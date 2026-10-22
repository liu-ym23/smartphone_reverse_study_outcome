package com.bytedance.lark.sdk;

import com.bytedance.crash.dumper.Scraps;
import com.bytedance.lark.pb.tool.v1.HttpHeader;
import com.bytedance.lark.pb.tool.v1.OnFetchResponse;
import com.bytedance.lark.sdk.refactor.j;
import com.bytedance.lark.sdk.stream.f;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.larksuite.framework.utils.z;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.sdk.i;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.texturerender.TextureRenderKeys;
import com.ss.ttvideoengine.model.SubInfo;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import se6.l;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u0000 \u00052\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/bytedance/lark/sdk/Sdk;", "", "<init>", "()V", "AndroidCallbackProxy", "Companion", "rust-interop_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Sdk {
    public static final Companion Companion = null;
    private static volatile a androidCallbackProxy;

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0087 J\u001b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\tH\u0087 J\u0019\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\tH\u0087 J!\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0087 J!\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0087 J\u0019\u0010\u0014\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0087 J\t\u0010\u0015\u001a\u00020\u0012H\u0087 J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0087 J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\tH\u0087 J3\u0010\u0019\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0017H\u0087 J;\u0010 \u001a\u0004\u0018\u00010\t2\u0006\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u0012H\u0087 J\u0019\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\tH\u0087 J\u0015\u0010%\u001a\u0004\u0018\u00010\t2\b\u0010&\u001a\u0004\u0018\u00010\u0017H\u0087 Jw\u0010'\u001a\u00020\u00102\b\u0010(\u001a\u0004\u0018\u00010\u00172\u0006\u0010)\u001a\u00020\u00172\b\u0010*\u001a\u0004\u0018\u00010\u00172\b\u0010+\u001a\u0004\u0018\u00010\u00172\u0006\u0010,\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u00122\b\u0010.\u001a\u0004\u0018\u00010\u00172\b\u0010/\u001a\u0004\u0018\u00010\u00172\u0006\u00100\u001a\u00020\u00072\b\u00101\u001a\u0004\u0018\u00010\u00172\b\u00102\u001a\u0004\u0018\u00010\u00172\u0006\u00103\u001a\u00020\u0007H\u0087 J+\u00104\u001a\u0004\u0018\u00010\t2\u0006\u0010&\u001a\u00020\u00172\u0006\u00105\u001a\u00020\u00172\u0006\u00106\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u0017H\u0087 J\u0010\u00108\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\tH\u0007J0\u00109\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020;2\u0006\u0010!\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\tH\u0007J\u0018\u0010=\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010>\u001a\u00020\u0012H\u0007J\u0018\u0010?\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010>\u001a\u00020\u0012H\u0007J \u0010@\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010:\u001a\u00020;2\u0006\u0010A\u001a\u00020\tH\u0007J\u0012\u0010B\u001a\u00020\u00102\b\u0010C\u001a\u0004\u0018\u00010\u0005H\u0007R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"Lcom/bytedance/lark/sdk/Sdk$Companion;", "", "<init>", "()V", "androidCallbackProxy", "Lcom/bytedance/lark/sdk/Sdk$AndroidCallbackProxy;", "_initSDK", "", HiAnalyticsConstant.Direction.REQUEST, "", "_invoke", "command", "data", "_invokeV2", "Lcom/bytedance/lark/sdk/InvokeResponse;", "_invokeAsync", "", DBDefinition.TASK_ID, "", "_invokeAsyncV2", "_fetchAsync", "_getNtpTime", "_getVersion", "", "_getTTNetRequestLogs", "_getAvatar", "entityId", "key", "sizeInDp", "dpi", "", SubInfo.KEY_FORMAT, "_getAvatarV2", "userId", "_preInitSDK", "storagePath", com.heytap.mcssdk.constant.b.f276376z, "_ResourceEncryptWithSdkKeyReadAll", "path", "_log", "logId", "message", "params", "tag", "level", "time", TextureRenderKeys.KEY_MODULE_NAME, "file", "line", PickerReporterConstants.KEY.TARGET, "thread", "pid", "_getInitSettings", Scraps.INNER_UNIT, "env", "channel", "pushCallback", "AsyncCallbackV2", "err", "", "verifyUserId", "OnFetchReadBuf", "maxChunkLength", "OnFetchPreReadBuf", "OnFetchResponse", "response", "setAndroidCallbackProxy", "proxy", "rust-interop_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        @JvmStatic
        public final byte[] _ResourceEncryptWithSdkKeyReadAll(String r100) {
            return Sdk._ResourceEncryptWithSdkKeyReadAll(r100);
        }

        @JvmStatic
        public final void _fetchAsync(byte[] r100, long r101) {
            Sdk._fetchAsync(r100, r101);
        }

        @JvmStatic
        public final byte[] _getAvatar(long r100, String r101, int r102, float r103, String r104) {
            return Sdk._getAvatar(r100, r101, r102, r103, r104);
        }

        @JvmStatic
        public final byte[] _getAvatarV2(long r100, String r101, int r102, float r103, String r104, long r105) {
            return Sdk._getAvatarV2(r100, r101, r102, r103, r104, r105);
        }

        @JvmStatic
        public final byte[] _getInitSettings(String r100, String r101, int r102, String r103) {
            return Sdk._getInitSettings(r100, r101, r102, r103);
        }

        @JvmStatic
        public final long _getNtpTime() {
            return Sdk._getNtpTime();
        }

        @JvmStatic
        public final byte[] _getTTNetRequestLogs() {
            return Sdk._getTTNetRequestLogs();
        }

        @JvmStatic
        public final String _getVersion() {
            return Sdk._getVersion();
        }

        @JvmStatic
        public final int _initSDK(byte[] r100) {
            return Sdk._initSDK(r100);
        }

        @JvmStatic
        public final byte[] _invoke(int r100, byte[] r101) {
            return Sdk._invoke(r100, r101);
        }

        @JvmStatic
        public final void _invokeAsync(int r100, byte[] r101, long r102) {
            Sdk._invokeAsync(r100, r101, r102);
        }

        @JvmStatic
        public final void _invokeAsyncV2(int r100, byte[] r101, long r102) {
            Sdk._invokeAsyncV2(r100, r101, r102);
        }

        @JvmStatic
        public final InvokeResponse _invokeV2(int r100, byte[] r101) {
            return Sdk._invokeV2(r100, r101);
        }

        @JvmStatic
        public final void _log(String r100, String r101, String r102, String r103, int r104, long r105, String r106, String r107, int r110, String r111, String r112, int r113) {
            Sdk._log(r100, r101, r102, r103, r104, r105, r106, r107, r110, r111, r112, r113);
        }

        @JvmStatic
        public final int _preInitSDK(String r100, byte[] r101) {
            return Sdk._preInitSDK(r100, r101);
        }

        @JvmStatic
        public final void pushCallback(byte[] r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
            if (Sdk.access$getAndroidCallbackProxy$cp() == null) goto L13;
            rpc.b r101 = rpc.d.f538911a;
            Intrinsics.checkNotNullParameter(r100, "data");
            rpc.b r102 = rpc.d.f538911a;
            if (r102 == null) goto L7;
            r102.g(r100);
        L7:
            Log.d("sdk", "pushCallback received");
            if (z.e(i.getContext()) == false) goto L12;
            j r103 = d.c();
            if (r103 == null) goto L12;
            r103.a(r100);
            return;
        L12:
            l r104 = new l(r100);
            d.f254141h.execute(r104);
            return;
        L13:
            rpc.b r105 = rpc.d.f538911a;
            Intrinsics.checkNotNullParameter(r100, "data");
            rpc.b r106 = rpc.d.f538911a;
            if (r106 == null) goto L19;
            r106.g(r100);
            return;
        }

        @JvmStatic
        public final void setAndroidCallbackProxy(a r100) {
            Sdk.access$setAndroidCallbackProxy$cp(r100);
        }

        @JvmStatic
        public final byte[] OnFetchPreReadBuf(long r100, long r101) {
            if (Sdk.access$getAndroidCallbackProxy$cp() == null) goto L16;
            Log.d("LarkNet", "OnFetchPreReadBuf " + String.valueOf(r100));
            com.bytedance.lark.sdk.stream.a.C3617a r102 = com.bytedance.lark.sdk.stream.i.f254388b.f254371a.get(Long.valueOf(r100));
            if (r102 == null) goto L9;
            com.bytedance.lark.sdk.stream.j r103 = r102.f254374c;
            if (r103 == null) goto L9;
            byte[] r104 = r103.b(r101);
        L10:
            if (r104 != null) goto L19;
            b.C3613b r105 = b.f254123a.get(Long.valueOf(r100));
            byte[] r106 = new byte[0];
            if (r105 != null) goto L18;
            return r106;
        L18:
            return b.a.b(r105.f254131e, r101);
        L19:
            return r104;
        L9:
            r104 = null;
            goto L10
        L16:
            return new byte[0];
        }

        @JvmStatic
        public final byte[] OnFetchReadBuf(long r100, long r101) {
            if (Sdk.access$getAndroidCallbackProxy$cp() == null) goto L16;
            Log.d("LarkNet", "OnFetchReadBuf " + String.valueOf(r100));
            com.bytedance.lark.sdk.stream.a.C3617a r102 = com.bytedance.lark.sdk.stream.i.f254388b.f254371a.get(Long.valueOf(r100));
            if (r102 == null) goto L9;
            com.bytedance.lark.sdk.stream.j r103 = r102.f254374c;
            if (r103 == null) goto L9;
            byte[] r104 = r103.a(r101);
        L10:
            if (r104 != null) goto L19;
            b.C3613b r105 = b.f254123a.get(Long.valueOf(r100));
            byte[] r106 = new byte[0];
            if (r105 != null) goto L18;
            return r106;
        L18:
            return b.a.b(r105.f254128b.f254059h, r101);
        L19:
            return r104;
        L9:
            r104 = null;
            goto L10
        L16:
            return new byte[0];
        }

        @JvmStatic
        public final void OnFetchResponse(long r110, boolean r111, byte[] r210) {
            Intrinsics.checkNotNullParameter(r210, "response");
            if (Sdk.access$getAndroidCallbackProxy$cp() == null) goto L156;
            com.bytedance.lark.sdk.stream.i r100 = com.bytedance.lark.sdk.stream.i.f254387a;
            Intrinsics.checkNotNullParameter(r210, "response");
            com.bytedance.lark.sdk.stream.a r101 = com.bytedance.lark.sdk.stream.i.f254388b;
            r101.getClass();
            Intrinsics.checkNotNullParameter(r210, "response");
            com.bytedance.lark.sdk.stream.a.C3617a r102 = r101.f254371a.get(Long.valueOf(r110));
            if (r102 != null) goto L8;
            boolean r103 = false;
        L135:
            if (r103 == true) goto L158;
            HashMap<Long, b.C3613b> r104 = b.f254123a;
            Intrinsics.checkNotNullParameter(r210, "response");
            b.C3613b r105 = b.f254123a.get(Long.valueOf(r110));
            if (r105 == null) goto L157;
            OnFetchResponse r106 = OnFetchResponse.ADAPTER.decode(r210);
            Intrinsics.checkNotNull(r106);     // Catch: OutOfMemoryError -> L142
            b.a.a(r106, r105);     // Catch: OutOfMemoryError -> L142
            Unit r107 = Unit.INSTANCE;     // Catch: OutOfMemoryError -> L142
            return;
        L143:
            if (r105.f254130d != null) goto L145;
            r105.f254130d = new LarkResponse.a();
        L145:
            LarkResponse.a r108 = r105.f254130d;
            Intrinsics.checkNotNull(r108);
            r108.a(LarkResponse.ResponseStatus.ERROR);
            LarkResponse.a r109 = r105.f254130d;
            Intrinsics.checkNotNull(r109);
            r109.f254097d = new LarkResponse.b(LarkResponse.InnerErrorCode.MEMORY_LIMIT, "OnResponse outOfMemory error");
            se6.j r112 = r105.f254129c;
            LarkResponse.a r113 = r105.f254130d;
            Intrinsics.checkNotNull(r113);
            r113.getClass();
            r112.d(new LarkResponse(r113));
            b.f254123a.remove(Long.valueOf(r105.f254127a));
            return;
        L157:
            return;
        L158:
            return;
        L8:
            if (r111 == false) goto L10;
            r102.f254375d.a(LarkResponse.ResponseStatus.ERROR);
            r102.f254375d.f254097d = new LarkResponse.b(LarkResponse.InnerErrorCode.UNKNOWN, "Rust fetch callback returned an error");
            f r114 = r102.f254373b;
            LarkResponse.a r115 = r102.f254375d;
            r115.getClass();
            r114.d(new LarkResponse(r115));
            r101.a(r110);
        L134:
            r103 = true;
            goto L135
        L10:
            OnFetchResponse r116 = OnFetchResponse.ADAPTER.decode(r210);
            Intrinsics.checkNotNull(r116);
            if (r116.cancel_response == null) goto L13;
            r102.f254375d.a(LarkResponse.ResponseStatus.CANCEL);
            r102.f254373b.g(r116.cancel_response);
        L65:
            boolean r117 = true;
        L132:
            if (r117 == false) goto L134;
            f r118 = r102.f254373b;
            LarkResponse.a r119 = r102.f254375d;
            r119.getClass();
            r118.d(new LarkResponse(r119));
            r101.a(r102.f254372a);
            goto L134
        L13:
            OnFetchResponse.OnErrorResponse r120 = r116.error_response;
            int r121 = -1;
            if (r120 == null) goto L47;
            OnFetchResponse.OnErrorResponse.Code r122 = r120.code;
            if (r122 == null) goto L19;
            r121 = com.bytedance.lark.sdk.stream.a.b.f254376a[r122.ordinal()];
        L19:
            if (r121 == 1) goto L28;
            if (r121 == 2) goto L27;
            if (r121 != 3) goto L23;
            LarkResponse.SdkErrorCode r123 = LarkResponse.SdkErrorCode.OFFLINE;
        L29:
            r102.f254375d.a(LarkResponse.ResponseStatus.ERROR);
            LarkResponse.a r124 = r102.f254375d;
            OnFetchResponse.OnErrorResponse r125 = r116.error_response;
            r124.f254098e = new LarkResponse.d(r123, r125.message, r125.lark_error_code.intValue(), r116.error_response.lark_error_status.intValue());
            OnFetchResponse.StageCost r126 = r116.error_response.stage_cost;
            LarkResponse.a r127 = r102.f254375d;
            if (r126 == null) goto L34;
            Integer r128 = r126.dns_cost;
            if (r128 == null) goto L34;
            int r129 = r128.intValue();
        L35:
            if (r126 == null) goto L39;
            Integer r130 = r126.tcp_connect_cost;
            if (r130 == null) goto L39;
            int r131 = r130.intValue();
        L40:
            if (r126 == null) goto L44;
            Integer r132 = r126.tls_cost;
            if (r132 == null) goto L44;
            int r133 = r132.intValue();
        L45:
            r127.f254094a = new LarkResponse.f(r129, r131, r133);
            r102.f254373b.a(r116.error_response);
        L44:
            r133 = 0;
        L39:
            r131 = 0;
        L34:
            r129 = 0;
            goto L35
        L23:
            if (r121 == 4) goto L25;
            r123 = LarkResponse.SdkErrorCode.OTHERS;
            goto L29
        L25:
            r123 = LarkResponse.SdkErrorCode.IO;
            goto L29
        L27:
            r123 = LarkResponse.SdkErrorCode.SDK;
            goto L29
        L28:
            r123 = LarkResponse.SdkErrorCode.TIMEOUT;
            goto L29
        L47:
            if (r116.success_response == null) goto L66;
            r102.f254375d.a(LarkResponse.ResponseStatus.SUCCESS);
            LarkResponse.a r134 = r102.f254375d;
            String r135 = r116.success_response.peer_addr;
            r134.getClass();
            Intrinsics.checkNotNullParameter(r135, "<set-?>");
            r134.f254100g = r135;
            OnFetchResponse.StageCost r136 = r116.success_response.stage_cost;
            LarkResponse.a r137 = r102.f254375d;
            if (r136 == null) goto L53;
            Integer r138 = r136.dns_cost;
            if (r138 == null) goto L53;
            int r139 = r138.intValue();
        L54:
            if (r136 == null) goto L58;
            Integer r140 = r136.tcp_connect_cost;
            if (r140 == null) goto L58;
            int r141 = r140.intValue();
        L59:
            if (r136 == null) goto L63;
            Integer r142 = r136.tls_cost;
            if (r142 == null) goto L63;
            int r143 = r142.intValue();
        L64:
            r137.f254094a = new LarkResponse.f(r139, r141, r143);
            r102.f254373b.c(r116.success_response);
        L63:
            r143 = 0;
        L58:
            r141 = 0;
        L53:
            r139 = 0;
            goto L54
        L66:
            OnFetchResponse.OnHeaderResponse r144 = r116.header_response;
            if (r144 == null) goto L84;
            List<HttpHeader> r145 = r144.headers;
            ArrayList r146 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r145, 10));
            Iterator<T> r147 = r145.iterator();
        L70:
            if (r147.hasNext() == false) goto L72;
            HttpHeader r148 = (HttpHeader) r147.next();
            r146.add(new com.bytedance.lark.sdk.a(r148.name, r148.value));
            goto L70
        L72:
            OnFetchResponse.OnHeaderResponse.Protocol r149 = r116.header_response.protocol;
            if (r149 == null) goto L76;
            r121 = com.bytedance.lark.sdk.stream.a.b.f254377b[r149.ordinal()];
        L76:
            if (r121 == 1) goto L82;
            if (r121 == 2) goto L81;
            if (r121 == 3) goto L80;
            LarkNetProtocol r150 = LarkNetProtocol.UNKNOWN;
        L83:
            r102.f254375d.f254096c = new LarkResponse.e(r116.header_response.status_code.intValue(), r150, r146);
            r102.f254373b.e(r116.header_response);
        L131:
            r117 = false;
            goto L132
        L80:
            r150 = LarkNetProtocol.QUIC;
            goto L83
        L81:
            r150 = LarkNetProtocol.HTTP_2;
            goto L83
        L82:
            r150 = LarkNetProtocol.HTTP_1_1;
            goto L83
        L84:
            OnFetchResponse.OnBodyResponse r151 = r116.body_response;
            if (r151 == null) goto L128;
            byte[] r152 = r151.body.toByteArray();
            LarkResponse.a r153 = r102.f254375d;
            if (r153.f254099f != null) goto L122;
            LarkResponse.e r154 = r153.f254096c;
            Object r155 = null;
            if (r154 == null) goto L106;
            List<com.bytedance.lark.sdk.a> r156 = r154.f254111c;
            if (r156 == null) goto L106;
            Iterator<T> r157 = r156.iterator();
        L94:
            if (r157.hasNext() == false) goto L98;
            Object r158 = r157.next();
            if (StringsKt.equals(((com.bytedance.lark.sdk.a) r158).f254119a, "content-length", true) == false) goto L94;
        L99:
            com.bytedance.lark.sdk.a r159 = (com.bytedance.lark.sdk.a) r158;
            if (r159 == null) goto L106;
            String r160 = r159.f254120b;
            if (r160 == null) goto L106;
            Long r161 = StringsKt.toLongOrNull(r160);
            if (r161 == null) goto L106;
            r161.longValue();
            goto L106
        L98:
            r158 = null;
        L106:
            if (r154 == null) goto L120;
            List<com.bytedance.lark.sdk.a> r162 = r154.f254111c;
            if (r162 == null) goto L120;
            Iterator<T> r163 = r162.iterator();
        L111:
            if (r163.hasNext() == false) goto L115;
            Object r164 = r163.next();
            if (StringsKt.equals(((com.bytedance.lark.sdk.a) r164).f254119a, com.alipay.sdk.m.p.e.f25658f, true) == false) goto L111;
            r155 = r164;
        L115:
            com.bytedance.lark.sdk.a r165 = (com.bytedance.lark.sdk.a) r155;
            if (r165 == null) goto L120;
            String r166 = r165.f254120b;
            if (r166 == null) goto L120;
        L121:
            r102.f254375d.f254099f = new LarkResponse.c(r166, new ByteArrayOutputStream(r152.length));
        L120:
            r166 = "";
        L122:
            LarkResponse.c r167 = r102.f254375d.f254099f;
            if (r167 == null) goto L127;
            ByteArrayOutputStream r168 = r167.f254104b;
            if (r168 == null) goto L127;
            r168.write(r152);
        L127:
            r102.f254373b.f(r116.body_response);
            goto L131
        L128:
            OnFetchResponse.OnProgressResponse r169 = r116.progress_response;
            if (r169 == null) goto L131;
            LarkResponse.a r170 = r102.f254375d;
            r169.recv_length.intValue();
            r116.progress_response.content_length.intValue();
            r170.getClass();
            r102.f254373b.b(r116.progress_response);
            goto L131
        }

        @JvmStatic
        public final void AsyncCallbackV2(long r110, boolean r111, boolean r112, long r113, byte[] r114) {
            Intrinsics.checkNotNullParameter(r114, "data");
            if (Sdk.access$getAndroidCallbackProxy$cp() == null) goto L8;
            rpc.b r100 = rpc.d.f538911a;
            String r101 = String.valueOf(r113);
            Intrinsics.checkNotNullParameter(r101, "userId");
            rpc.a r115 = new rpc.a(r110, r111, r114, r101, r112, null, 96);
            Intrinsics.checkNotNullParameter(r115, "data");
            rpc.b r102 = rpc.d.f538911a;
            if (r102 == null) goto L7;
            r102.h(r115);
        L7:
            d.d(r110, r111, r114, false, r112, String.valueOf(r113));
            return;
        L8:
            rpc.b r103 = rpc.d.f538911a;
            rpc.a r116 = new rpc.a(r110, r111, r114, String.valueOf(r113), r112, null, 96);
            Intrinsics.checkNotNullParameter(r116, "data");
            rpc.b r104 = rpc.d.f538911a;
            if (r104 == null) goto L13;
            r104.h(r116);
            return;
        }
    }

    public interface a {
    }

    static {
        Companion = new Companion(null);
    }

    private Sdk() {
    }

    @JvmStatic
    public static final void AsyncCallbackV2(long r100, boolean r110, boolean r111, long r112, byte[] r113) {
        Companion.AsyncCallbackV2(r100, r110, r111, r112, r113);
    }

    @JvmStatic
    public static final byte[] OnFetchPreReadBuf(long r100, long r101) {
        return Companion.OnFetchPreReadBuf(r100, r101);
    }

    @JvmStatic
    public static final byte[] OnFetchReadBuf(long r100, long r101) {
        return Companion.OnFetchReadBuf(r100, r101);
    }

    @JvmStatic
    public static final void OnFetchResponse(long r100, boolean r101, byte[] r102) {
        Companion.OnFetchResponse(r100, r101, r102);
    }

    @JvmStatic
    public static final native byte[] _ResourceEncryptWithSdkKeyReadAll(String r100);

    @JvmStatic
    public static final native void _fetchAsync(byte[] r100, long r101);

    @JvmStatic
    public static final native byte[] _getAvatar(long r100, String r101, int r102, float r103, String r104);

    @JvmStatic
    public static final native byte[] _getAvatarV2(long r100, String r101, int r102, float r103, String r104, long r105);

    @JvmStatic
    public static final native byte[] _getInitSettings(String r100, String r101, int r102, String r103);

    @JvmStatic
    public static final native long _getNtpTime();

    @JvmStatic
    public static final native byte[] _getTTNetRequestLogs();

    @JvmStatic
    public static final native String _getVersion();

    @JvmStatic
    public static final native int _initSDK(byte[] r100);

    @JvmStatic
    public static final native byte[] _invoke(int r100, byte[] r101);

    @JvmStatic
    public static final native void _invokeAsync(int r100, byte[] r101, long r102);

    @JvmStatic
    public static final native void _invokeAsyncV2(int r100, byte[] r101, long r102);

    @JvmStatic
    public static final native InvokeResponse _invokeV2(int r100, byte[] r101);

    @JvmStatic
    public static final native void _log(String r100, String r101, String r102, String r103, int r104, long r105, String r106, String r107, int r108, String r110, String r111, int r112);

    @JvmStatic
    public static final native int _preInitSDK(String r100, byte[] r101);

    @JvmStatic
    public static final void pushCallback(byte[] r100) {
        Companion.pushCallback(r100);
    }

    @JvmStatic
    public static final void setAndroidCallbackProxy(a r100) {
        Companion.setAndroidCallbackProxy(r100);
    }

    public static final /* synthetic */ a access$getAndroidCallbackProxy$cp() {
        return androidCallbackProxy;
    }

    public static final /* synthetic */ void access$setAndroidCallbackProxy$cp(a r100) {
        androidCallbackProxy = r100;
    }
}
