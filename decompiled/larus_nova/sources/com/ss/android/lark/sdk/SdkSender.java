package com.ss.android.lark.sdk;

import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.LarkError;
import com.bytedance.lark.pb.basic.v1.RequestPacket;
import com.bytedance.lark.pb.basic.v1.ResponseMeta;
import com.bytedance.lark.sdk.InvokeResponse;
import com.bytedance.lark.sdk.Sdk;
import com.bytedance.lark.sdk.SdkInterceptState;
import com.bytedance.lark.sdk.StreamDataSource;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.thread.CoreThreadPool;
import com.squareup.wire.Message;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.pb.improto.Packet;
import com.ss.android.lark.pb.improto.PayloadType;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;
import se6.p;
import se6.t;

/* JADX INFO: loaded from: classes38.dex */
public class SdkSender {
    private static final int SYNC_REQUEST_TIMEOUT = 30000;
    public static final String TAG = "SdkSender";
    private static c sErrorHandle;

    public interface IParser<T> {
        T parse(byte[] r100) throws IOException;
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class a<T> implements IParser<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IParser f439861a;

        public a(IParser r100) {
            this.f439861a = r100;
        }

        @Override // com.ss.android.lark.sdk.SdkSender.IParser
        public final T parse(byte[] r100) throws IOException {
            return (T) this.f439861a.parse(r100);
        }
    }

    public static class b<T> implements se6.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Command f439862a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final IParser<T> f439863b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final IGetDataCallback<T> f439864c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f439865d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f439866e;

        @Override // se6.b
        public final boolean a() {
            return this.f439865d;
        }

        @Override // se6.b
        public final void b(boolean r100, byte[] r101) {
            String r102 = this.f439866e;
            ThreadLocal<String> r103 = qqb.a.f534506a;
            Intrinsics.checkNotNullParameter(r102, "contextId");
            String r104 = qqb.a.b(r102);
            if (r104.length() != 0) goto L5;
            boolean r105 = true;
        L6:
            if (r105 == false) goto L8;
            r104 = qqb.a.d();
        L8:
            qqb.a.g(r104);
            Log.d(SdkSender.TAG, "asyncCallback, command = " + this.f439862a.name() + ", contextId=" + this.f439866e);
            if (r100 == false) goto L13;
            ErrorResult r106 = SdkSender.access$000(this.f439862a, r101, new RuntimeException(""));
            IGetDataCallback<T> r107 = this.f439864c;
            if (r107 == null) goto L19;
            r107.onError(r106);
        L19:
            qqb.a.a();
            return;
        L13:
            d r108 = SdkSender.parseObject(r101, this.f439863b, this.f439862a, this.f439866e, true);
            IGetDataCallback<T> r109 = this.f439864c;
            if (r109 == null) goto L19;
            ErrorResult r110 = r108.f439868b;
            if (r110 == null) goto L18;
            r109.onError(r110);
            goto L19
        L18:
            r109.onSuccess(r108.f439867a);
            goto L19
        L5:
            r105 = false;
            goto L6
        }

        public b(Command r100, IParser r101, IGetDataCallback<T> r102, String r103, boolean r104) {
            this.f439862a = r100;
            this.f439863b = r101;
            this.f439864c = r102;
            this.f439865d = r104;
            this.f439866e = r103;
        }
    }

    public interface c {
    }

    public static class d<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public T f439867a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ErrorResult f439868b;

        public d() {
        }
    }

    public SdkSender() {
    }

    public static c getErrorHandle() {
        return null;
    }

    public static void setErrorHandle(c r100) {
    }

    static {
        ErrorResult.setCodeCompat(com.ss.android.lark.sdk.b.f439869a);
    }

    public static long getNtpTime() {
        Map<Long, se6.b> r100 = com.bytedance.lark.sdk.d.f254138e;
        return Sdk._getNtpTime();
    }

    private static String appendCallStackTrace(StackTraceElement[] r100) {
        StringBuilder r101 = new StringBuilder();
        if (r100 == null) goto L6;
        StackTraceElement r102 = r100[0];
        r101.append("\n className=" + r102.getClassName());
        r101.append("\n fileName=" + r102.getFileName());
        r101.append("\n methodName=" + r102.getMethodName());
        r101.append("\n lineNumber=" + r102.getLineNumber());
    L6:
        return r101.toString();
    }

    private static String extractBytesFragment(byte[] r100, int r101) {
        if (r100 != null) goto L4;
        return "";
    L4:
        if (r100.length == 0) goto L17;
        StringBuilder r102 = new StringBuilder();
        int r103 = 0;
    L7:
        if (r103 >= r101) goto L12;
        if (r103 >= r100.length) goto L12;
        r102.append(String.format("%02X ", new Object[]{Byte.valueOf(r100[r103])}));
        r103 = r103 + 1;
    L12:
        return r102.toString();
    L17:
        return "";
    }

    public static /* synthetic */ ErrorResult access$000(Command r100, byte[] r101, Exception r102) {
        return translateAndHandlerLarkError(r100, r101, r102);
    }

    public static <T> T sendRequest(Command r100, Message.Builder r101, IParser<T> r102) {
        return (T) sendRequest(r100, r101, r102, 30000, qqb.a.c());
    }

    public static <T> T syncSend(Command r100, Message.Builder r101, IParser<T> r102) {
        return (T) syncSend(r100, r101, qqb.a.c(), r102);
    }

    public static <T> d<T> syncSendMayError(Command r100, Message.Builder r101, IParser<T> r102) {
        return syncSendMayError(r100, r101, qqb.a.c(), r102, null);
    }

    private static ErrorResult translateAndHandlerLarkError(Command r100, byte[] r101, Exception r110) {
        ErrorResult.a r102 = new ErrorResult.a();
        if (r101 != null) goto L33;
        r102.f285545h = r110;
        return r102.a();
    L33:
        LarkError r103 = LarkError.ADAPTER.decode(r101);     // Catch: IOException -> L25
        if (r103 == null) goto L29;
        LarkError.ErrorDetails r104 = r103.details;     // Catch: IOException -> L25
        String r105 = "";
        if (r104 == null) goto L12;
        String r106 = r104.debug_message;     // Catch: IOException -> L25
    L13:
        if (r104 == null) goto L15;
        String r107 = r104.server_request_id;     // Catch: IOException -> L25
    L16:
        if (r104 == null) goto L18;
        r105 = r104.x_tt_logid;     // Catch: IOException -> L25
    L18:
        r102.f285538a = r103.status.intValue();     // Catch: IOException -> L25
        r102.f285539b = r103.code.intValue();     // Catch: IOException -> L25
        r102.f285540c = r106;     // Catch: IOException -> L25
        r102.f285543f = r107;     // Catch: IOException -> L25
        r102.f285541d = r103.display_message;     // Catch: IOException -> L25
        r102.f285544g = r105;     // Catch: IOException -> L25
        r102.f285542e = r103.display_title;     // Catch: IOException -> L25
        ByteString r108 = r103.extra;     // Catch: IOException -> L25
        if (r108 != null) goto L31;
    L23:
        r110 = new RuntimeException("\n debugMessage = " + r106);     // Catch: IOException -> L25
        goto L29
    L31:
        r102.f285546i = new String(r108.toByteArray());     // Catch: UnsupportedOperationException -> L22 IOException -> L25
        r102.f285547j = r103.extra.toByteArray();     // Catch: UnsupportedOperationException -> L22 IOException -> L25
    L22:
        Log.e(TAG, "error extra decode failed, errorCode: " + r103.code);     // Catch: IOException -> L25
        goto L23
    L15:
        r107 = "";
        goto L16
    L12:
        r106 = "";
    L29:
        r102.f285545h = r110;
        return r102.a();
    L25:
        e = move-exception;
        Log.e(TAG, "translateAndHandlerLarkError: " + e.getMessage() + " error:" + extractBytesFragment(r101, 200));
        if (r110 != null) goto L29;
        r110 = e;
        goto L29
    }

    public static <T> void asynSendRequestNonWrap(Command r100, Message.Builder r101, IGetDataCallback<T> r110, IParser<T> r111) {
        asynSendRequestNonWrap(r100, r101.build().encode(), r110, false, qqb.a.c(), r111, null, null);
    }

    public static <T> void sendLocalRequest(Command r100, Message.Builder r101, IGetDataCallback<T> r110, IParser<T> r111) {
        asynSendRequestNonWrap(r100, r101.build().encode(), r110, false, qqb.a.c(), r111, StreamDataSource.ONCE_LOCAL, null);
    }

    public static <T> void sendNetRequest(Command r100, Message.Builder r101, IGetDataCallback<T> r110, IParser<T> r111) {
        asynSendRequestNonWrap(r100, r101.build().encode(), r110, false, qqb.a.c(), r111, StreamDataSource.ONCE_NET, null);
    }

    public static <T> void sendPassThroughRequest(com.ss.android.lark.pb.improto.Command r100, Message.Builder r101, IGetDataCallback<T> r102, IParser<T> r103) {
        sendPassThroughRequest(r100, r101, r102, r103, null);
    }

    public static <T> T sendRequest(Command r100, Message.Builder r101, int r102, IParser<T> r103) {
        return (T) sendRequest(r100, r101, r103, r102, qqb.a.c());
    }

    public static <T> void sendSmartRequest(Command r100, Message.Builder r101, IGetDataCallback<T> r110, IParser<T> r111) {
        asynSendRequestNonWrap(r100, r101.build().encode(), r110, false, qqb.a.c(), r111, StreamDataSource.DEFAULT_SMART, null);
    }

    public static <T> T syncSend(Command r100, Message.Builder r101, String r102, IParser<T> r103) {
        return syncSendMayError(r100, r101, r102, r103, null).f439867a;
    }

    public static <T> d<T> syncSendMayError(Command r100, Message.Builder r101, IParser<T> r102, h r103) {
        return syncSendMayError(r100, r101, qqb.a.c(), r102, r103);
    }

    public static <T> T sendRequest(Command r100, Message.Builder r101, String r102, IParser<T> r103) {
        return (T) sendRequest(r100, r101, r103, 30000, r102);
    }

    public static <T> d<T> syncSendMayError(Command r100, Message.Builder r101, String r102, IParser<T> r103) {
        return syncSendMayError(r100, r101, r102, r103, null);
    }

    public static <T> void asynSendRequestNonWrap(Command r100, Message.Builder r101, IGetDataCallback<T> r110, IParser<T> r111, h r112) {
        asynSendRequestNonWrap(r100, r101.build().encode(), r110, false, qqb.a.c(), r111, null, r112);
    }

    public static <T> d<T> parseObject(byte[] r100, IParser<T> r101, Command r102, String r103, boolean r104) {
        d<T> r105 = new d();
        r105.f439867a = r101.parse(r100);     // Catch: Exception -> L5
    L13:
        return r105;
    L5:
        e = move-exception;
        if (r104 == false) goto L8;
        String r106 = "asyncCall";
    L9:
        if (r104 == false) goto L11;
        byte[] r107 = null;
    L12:
        r105.f439868b = translateAndHandlerLarkError(r102, r107, e);
        Log.e(TAG, r106 + " command = " + r102.name() + "\n parseObject failed, contextId: " + r103 + ", error:" + e.getMessage() + " \n bytes:" + extractBytesFragment(r100, 200));
        goto L13
    L11:
        r107 = r100;
        goto L12
    L8:
        r106 = "syncCall";
        goto L9
    }

    public static <T> void sendPassThroughRequest(com.ss.android.lark.pb.improto.Command r100, byte[] r101, IGetDataCallback<T> r110, IParser<T> r111, h r112) {
        String r102 = qqb.a.c();
        ByteString r103 = ByteString.of(r101);
        Packet.Builder r104 = new Packet.Builder();
        r104.cid(r102);
        r104.payload_type(PayloadType.PB2);
        r104.payload(r103);
        r104.cmd(r100);
        Log.i(TAG, "sendPassThroughRequest : contextId is " + r102 + " , command is " + r100.name());
        asynPassTroughSendRequestNonWrap(r100.getValue(), r104.build().encode(), r110, false, r102, r111, null, r112);
    }

    public static <T> T sendRequest(Command r110, Message.Builder r111, IParser<T> r112, int r113, String r114) {
        final CountDownLatch r100 = new CountDownLatch(1);
        final ArrayList r101 = new ArrayList();
        asynSendRequestNonWrap(r110, r111.build().encode(), new AnonymousClass1(r101, r100), true, r114, new a(r112), null);
    L7:
        e = move-exception;
        Log.e(TAG, "moniter syn sendRequest command = " + r110.name() + "\n interrupt, contextId: " + r114 + "\n error: InterruptedException " + e);
        r101.add(null);
    L10:
        return (T) ListProtector.get(r101, 0);
    L4:
        if (r100.await(r113, TimeUnit.MILLISECONDS) == true) goto L10;
        Log.e(TAG, "moniter syn sendRequest command = " + r110.name() + "\n timeout, contextId: " + r114 + "\n error: time out ");     // Catch: InterruptedException -> L7
        r101.add(null);     // Catch: InterruptedException -> L7
        goto L10
    }

    public static <T> T syncSend(Command r100, Message.Builder r101, String r102, IParser<T> r103, h r104) {
        return syncSendMayError(r100, r101, r102, r103, r104).f439867a;
    }

    public static <T> d<T> syncSendMayError(Command r310, Message.Builder r311, String r312, IParser<T> r313, h r410) {
        Log.d(TAG, "syncSendMayError sendRequest command = " + r310.name() + ", contextId=" + r312);
        byte[] r100 = r311.build().encode();
        if (com.bytedance.lark.sdk.d.f254149p >= 0) goto L5;
        se6.g r101 = new se6.g(new InvokeResponse(0, new byte[]{0, 0, 0, 0}, new byte[]{0, 0, 0, 0}), null, false);
        boolean r102 = false;
    L30:
        InvokeResponse r103 = r101.f541572a;
        RequestPacket r110 = r101.f541573b;
        boolean r104 = r101.f541574c;
        String r111 = "";
        String r210 = null;
        String r211 = null;
    L146:
        th = th;
    L147:
        boolean r105 = false;
    L149:
        if (r103 != null) goto L151;
    L153:
        boolean r106 = false;
    L154:
        Boolean r212 = Boolean.valueOf(r106);
        if (r110 == null) goto L157;
        Command r107 = r110.cmd;
    L158:
        Command r213 = r107;
        if (r110 == null) goto L161;
        String r214 = r110.context_id;
    L162:
        com.bytedance.lark.sdk.d.p(AbsMethodDelegate.TAG_INVOKE, r212, r213, r214, r210, r211, Boolean.valueOf(r105));
        throw th;
    L161:
        r214 = "";
        goto L162
    L157:
        r107 = Command.UNKNOWN_COMMAND;
        goto L158
    L151:
        if (r103.f254047a == r8) goto L153;
        r106 = true;
        goto L154
    L32:
        if (com.bytedance.lark.sdk.d.l() == false) goto L46;
        if (r103 != null) goto L35;
    L37:
        boolean r108 = false;
    L38:
        Boolean r109 = Boolean.valueOf(r108);
        if (r110 == null) goto L41;
        Command r112 = r110.cmd;
    L42:
        if (r110 == null) goto L44;
        r111 = r110.context_id;
    L44:
        Boolean r113 = Boolean.FALSE;
        String r114 = null;
        String r115 = null;
        String r116 = r111;
    L91:
        com.bytedance.lark.sdk.d.p(AbsMethodDelegate.TAG_INVOKE, r109, r112, r116, r114, r115, r113);
    L137:
        boolean r117 = true;
    L138:
        if (r117 == true) goto L141;
        d<T> r118 = new d();
        r118.f439868b = translateAndHandlerLarkError(r310, r10, new RuntimeException("User Verify Failed."));
        return r118;
    L141:
        d<T> r119 = parseObject(r101.f541572a.f254049c, r313, r310, r312, r102);
        if (r119.f439868b == null) goto L144;
        Log.e(TAG, "sync call error：command = " + r310.name() + " contextId: " + r312);
    L144:
        Log.d(TAG, "syncSendMayError sendRequest end, command = " + r310.name() + ", contextId=" + r312);
        return r119;
    L41:
        r112 = Command.UNKNOWN_COMMAND;
        goto L42
    L35:
        if (r103.f254047a == 0) goto L37;
        r108 = true;
        goto L38
    L46:
        if (r110 == null) goto L123;
        if (TextUtils.isEmpty(r110.user_id) == true) goto L123;
        if (r110.cmd == Command.MAKE_USER_ONLINE) goto L123;
        if (r103 == null) goto L116;
        byte[] r120 = r103.f254048b;     // Catch: Throwable -> L146
        if (r120 == null) goto L116;
        ResponseMeta r121 = ResponseMeta.ADAPTER.decode(r120);     // Catch: IOException -> L165 Throwable -> L146
        String r122 = r110.user_id.trim();     // Catch: IOException -> L165 Throwable -> L146
        goto L104
    L181:
        String r123 = String.valueOf(r121.user_id);     // Catch: Throwable -> L100 IOException -> L103
    L183:
        boolean r124 = r121.verify_user_id.booleanValue();     // Catch: Throwable -> L97 IOException -> L99
    L92:
        th = th;
        String r215 = r123;
        String r216 = r122;
    L94:
        r105 = r124;
        r123 = r215;
        r122 = r216;
    L114:
        r211 = r123;
        r210 = r122;
    L95:
        r215 = r123;
        r216 = r122;
    L96:
        r105 = r124;
        r123 = r215;
        r122 = r216;
    L166:
        com.bytedance.lark.sdk.d.n(r110, r103);     // Catch: Throwable -> L113
        if (r103.f254047a == r8) goto L110;
        boolean r125 = true;
    L111:
        Boolean r126 = Boolean.valueOf(r125);
        Command r127 = r110.cmd;
        String r128 = r110.context_id;
        Boolean r129 = Boolean.valueOf(r105);
        String r130 = r123;
        Command r131 = r127;
        Boolean r132 = r126;
        String r133 = r122;
        String r134 = r128;
    L112:
        com.bytedance.lark.sdk.d.p(AbsMethodDelegate.TAG_INVOKE, r132, r131, r134, r133, r130, r129);
        r117 = false;
        goto L138
    L110:
        r125 = false;
    L113:
        th = th;
        goto L114
    L60:
        if (TextUtils.equals(r122, r123) == false) goto L62;
    L85:
        r215 = r123;
        r216 = r122;
    L87:
        if (r103.f254047a == r8) goto L89;
        boolean r135 = true;
    L90:
        r109 = Boolean.valueOf(r135);
        r112 = r110.cmd;
        String r136 = r110.context_id;
        r113 = Boolean.valueOf(r124);
        r115 = r215;
        r114 = r216;
        r116 = r136;
        goto L91
    L89:
        r135 = false;
        goto L90
    L62:
        if (r103.f254047a != r8) goto L85;
        if (com.bytedance.lark.sdk.d.k(r123) == true) goto L176;
    L71:
        r215 = r123;
        r216 = r122;
        com.bytedance.lark.sdk.d.o(r122, r123, r110, r103, r104, r121.verify_user_id.booleanValue());     // Catch: Throwable -> L83 IOException -> L164
    L75:
        if (com.bytedance.lark.sdk.d.k(r215) == true) goto L87;
        if (r121.verify_user_id.booleanValue() == false) goto L87;
        if (r103.f254047a == r8) goto L81;
        boolean r137 = true;
    L82:
        Boolean r138 = Boolean.valueOf(r137);
        Command r139 = r110.cmd;
        String r140 = r110.context_id;
        r129 = Boolean.valueOf(r124);
        r130 = r215;
        r133 = r216;
        r134 = r140;
        r131 = r139;
        r132 = r138;
        goto L112
    L81:
        r137 = false;
        goto L82
    L83:
        th = th;
        goto L94
    L176:
        if (r121.verify_user_id.booleanValue() == true) goto L71;
        r215 = r123;
        r216 = r122;
    L69:
        th = th;
        r105 = r124;
        goto L114
    L99:
        r211 = r123;
        r122 = r122;
    L105:
        r123 = r211;
        r105 = false;
    L97:
        th = th;
        r211 = r123;
    L102:
        r210 = r122;
    L103:
        r210 = r122;
    L100:
        th = th;
    L104:
        r122 = r210;
    L116:
        if (r103 != null) goto L118;
    L120:
        boolean r141 = false;
    L121:
        com.bytedance.lark.sdk.d.p(AbsMethodDelegate.TAG_INVOKE, Boolean.valueOf(r141), r110.cmd, r110.context_id, null, null, Boolean.FALSE);
        goto L137
    L118:
        if (r103.f254047a == r8) goto L120;
        r141 = true;
    L123:
        if (r103 != null) goto L125;
    L127:
        boolean r142 = false;
    L128:
        Boolean r217 = Boolean.valueOf(r142);
        if (r110 == null) goto L131;
        Command r143 = r110.cmd;
    L132:
        Command r314 = r143;
        if (r110 == null) goto L135;
        String r315 = r110.context_id;
    L136:
        com.bytedance.lark.sdk.d.p(AbsMethodDelegate.TAG_INVOKE, r217, r314, r315, null, null, Boolean.FALSE);
        goto L137
    L135:
        r315 = "";
        goto L136
    L131:
        r143 = Command.UNKNOWN_COMMAND;
        goto L132
    L125:
        if (r103.f254047a == r8) goto L127;
        r142 = true;
        goto L128
    L5:
        e r144 = i.f439881a;
        p r145 = com.bytedance.lark.sdk.d.f254146m;
        if (r145.a(r310) == true) goto L170;
    L11:
        com.bytedance.lark.sdk.e r146 = r145.f541589a;
        r146.getClass();
        if (r310 != Command.MAKE_USER_ONLINE) goto L14;
        boolean r147 = true;
    L15:
        if (r147 == false) goto L18;
        r146.f254172e.set(false);
    L24:
        boolean r148 = false;
    L25:
        RequestPacket r149 = com.bytedance.lark.sdk.e.e(r310, r100, r312, -1, false, null, ThreadMethodProxy.currentThread().getId(), r410);
        Command r150 = com.bytedance.lark.sdk.e.f254167h;
        byte[] r151 = r149.encode();
        r102 = false;
        com.bytedance.lark.sdk.e.g(r310, r312, false, r149.user_id, r149.user_container_id);
        com.bytedance.lark.sdk.e.a r152 = r146.f254174g;
        int r153 = r150.getValue();
        int r154 = r310.getValue();
        ((com.bytedance.lark.sdk.d.b) r152).getClass();
        InvokeResponse r155 = com.bytedance.lark.sdk.d.i(r153, r151, r154);
        if (r147 == false) goto L29;
        r146.f254172e.set(true);
        r146.f254173f.countDown();
        CoreThreadPool.getSerialTaskHandler().post(new t(r146));
    L29:
        r101 = new se6.g(r155, r149, r148);
        goto L30
    L18:
        if (r146.f254172e.get() == true) goto L24;
        r146.f254173f.await();     // Catch: InterruptedException -> L21
    L23:
        r146.f254173f = new CountDownLatch(1);
        r148 = true;
    L21:
        e = move-exception;
        Log.e("SdkRequestInterceptor", "block sync req:" + r310 + " occurs interruptedException:" + e.toString());
        goto L23
    L14:
        r147 = false;
        goto L15
    L170:
        r145.f541590b.await();     // Catch: InterruptedException -> L9
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    public static <T> void asynSendRequestNonWrap(Command r100, Message.Builder r101, String r102, IGetDataCallback<T> r110, IParser<T> r111) {
        asynSendRequestNonWrap(r100, r101.build().encode(), r110, false, r102, r111, null);
    }

    public static <T> void sendPassThroughRequest(com.ss.android.lark.pb.improto.Command r100, Message.Builder r101, IGetDataCallback<T> r102, IParser<T> r103, h r104) {
        sendPassThroughRequest(r100, r101.build(), r102, r103, r104);
    }

    public static <T> void sendPassThroughRequest(com.ss.android.lark.pb.improto.Command r100, Message r101, IGetDataCallback<T> r102, IParser<T> r103, h r104) {
        sendPassThroughRequest(r100, r101.encode(), r102, r103, r104);
    }

    public static <T> void asynSendRequestNonWrap(Command r100, Message.Builder r101, String r102, IGetDataCallback<T> r110, IParser<T> r111, h r112) {
        asynSendRequestNonWrap(r100, r101.build().encode(), r110, false, r102, r111, r112);
    }

    private static <T> void asynSendRequestNonWrap(Command r100, byte[] r101, IGetDataCallback<T> r110, boolean r111, String r112, IParser r113, h r114) {
        asynSendRequestNonWrap(r100, r101, r110, r111, r112, r113, null, r114);
    }

    private static <T> void asynPassTroughSendRequestNonWrap(int r110, byte[] r111, IGetDataCallback<T> r112, boolean r113, String r114, IParser r115, StreamDataSource r210, h r211) {
        Log.d(TAG, "async nonWrap sendPassTroughRequest command id is: " + r110 + " , contextId is: " + r114);
        Command r116 = Command.POST_GATEWAY;
        b r100 = new b(r116, r115, r112, r114, r113);
        Map<Long, se6.b> r101 = com.bytedance.lark.sdk.d.f254138e;
        AtomicLong r102 = ue6.a.f549807a;
        long r117 = ue6.a.C7870a.a();
        ((ConcurrentHashMap) com.bytedance.lark.sdk.d.f254138e).put(Long.valueOf(r117), com.bytedance.lark.sdk.d.f254145l.i(r116, r100, r114, r110));
        Log.d("sdk", "invokeAsync taskId:" + r117 + ",command:" + r110);
        p r103 = com.bytedance.lark.sdk.d.f254146m;
        r103.getClass();
        if (r103.a(r116) == true) goto L14;
        com.bytedance.lark.sdk.e r118 = r103.f541589a;
        r118.getClass();
        if (i.f439882b == null) goto L7;
        r118.b(r110, r111, r117, r114, r210, r211);
        goto L14
    L7:
        if (r210 == null) goto L9;
        boolean r104 = true;
    L10:
        RequestPacket r105 = com.bytedance.lark.sdk.e.d(r110, r111, r114, r117, r104, r210, r211);
        Command r106 = com.bytedance.lark.sdk.e.f254167h;
        byte[] r107 = r105.encode();
        com.bytedance.lark.sdk.e.f(r110, r114);
        if (r118.f254172e.get() == false) goto L13;
        com.bytedance.lark.sdk.d.f.f254166a.g(r106.getValue(), r107, r117, r116.getValue());
        r118.h();
        goto L14
    L13:
        r118.f254169b.add(new com.bytedance.lark.sdk.e.c(r106, r107, r117, r116));
        Log.i("SdkRequestInterceptor", "asyncInvokePassThroughCommand add cache command = " + r110);
        goto L14
    L9:
        r104 = false;
    L14:
        e r108 = i.f439881a;
    }

    public static <T> void asynSendRequestNonWrap(Command r110, byte[] r111, IGetDataCallback<T> r112, boolean r113, String r114, IParser r115, StreamDataSource r116, h r210) {
        Log.d(TAG, "async nonWrap sendRequest command = " + r110.name() + ", contextId=" + r114);
        b r100 = new b(r110, r115, r112, r114, r113);
        Map<Long, se6.b> r101 = com.bytedance.lark.sdk.d.f254138e;
        AtomicLong r102 = ue6.a.f549807a;
        long r103 = ue6.a.C7870a.a();
        int r104 = r110.getValue();
        com.bytedance.lark.sdk.e.C3615e r105 = com.bytedance.lark.sdk.d.f254145l.i(r110, r100, r114, 0);
        if (r104 != Command.MAKE_USER_ONLINE.getValue()) goto L5;
    L8:
        Object r106 = new com.bytedance.lark.sdk.d.e(r105, r104);
    L9:
        ((ConcurrentHashMap) com.bytedance.lark.sdk.d.f254138e).put(Long.valueOf(r103), r106);
        Log.d("sdk", "invokeAsync taskId:" + r103 + ",command:" + r110.name());
        p r117 = com.bytedance.lark.sdk.d.f254146m;
        if (r117.a(r110) == true) goto L27;
        SdkInterceptState r107 = r117.f541589a.a(r110, r111, r103, r114, r116, r210);
    L18:
        if (r107 == SdkInterceptState.MakeOnline) goto L20;
    L22:
        e r108 = i.f439881a;
        return;
    L20:
        if ((r106 instanceof com.bytedance.lark.sdk.e.C3615e) == false) goto L22;
        ((com.bytedance.lark.sdk.e.C3615e) r106).f254196e = true;
        goto L22
    L27:
        r117.f541592d.lock();     // Catch: Throwable -> L24
        if (r117.a(r110) == false) goto L16;
        r117.f541593e.add(new p.a(r110, r111, r103, r114, r116, r210));     // Catch: Throwable -> L24
        r107 = SdkInterceptState.Init;     // Catch: Throwable -> L24
        r117.f541592d.unlock();
        goto L18
    L16:
        r117.f541592d.unlock();
        r107 = r117.f541589a.a(r110, r111, r103, r114, r116, r210);
    L24:
        th = move-exception;
        r117.f541592d.unlock();
        throw th;
    L5:
        if (r104 == Command.MAKE_USER_OFFLINE.getValue()) goto L8;
        r106 = r105;
        goto L9
    }

    public static <T> void asynSendRequestNonWrap(Command r100, Message.Builder r101, IGetDataCallback<T> r110, boolean r111, String r112, IParser r113, StreamDataSource r114, h r115) {
        asynSendRequestNonWrap(r100, r101.build().encode(), r110, r111, r112, r113, r114, r115);
    }
}
