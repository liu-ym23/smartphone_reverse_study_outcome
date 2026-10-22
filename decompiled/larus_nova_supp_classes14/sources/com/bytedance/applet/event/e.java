package com.bytedance.applet.event;

import androidx.collection.LruCache;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.ai.model.clienttool.ClientToolRunner;
import com.bytedance.ai.model.d0;
import com.bytedance.ai.model.e0;
import com.bytedance.ai.model.objects.LLMData;
import com.bytedance.ai.model.objects.RealData;
import com.bytedance.ai.model.x;
import com.bytedance.applet.utils.MessageUtils;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.stop.PendingAppletActionCancellation;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e implements w4.a {
    public static final e a = null;
    public static final com.bytedance.ai.uiu.l b = null;
    public static final Gson c = null;
    public static final List<o> d = null;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\rJ2\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/bytedance/applet/event/BaseAppActionListener$SnapshotAppActionContent;", "", "action", "", "key", "timeoutMs", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getAction", "()Ljava/lang/String;", "getKey", "getTimeoutMs", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/bytedance/applet/event/BaseAppActionListener$SnapshotAppActionContent;", "equals", "", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a {

        @SerializedName("action")
        private final String action;

        @SerializedName("key")
        private final String key;

        @SerializedName("timeout_ms")
        private final Integer timeoutMs;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.action, r6.action) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.key, r6.key) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.timeoutMs, r6.timeoutMs) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            String r0 = this.action;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.key;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            Integer r7 = this.timeoutMs;
            if (r7 == null) goto L15;
            r1 = r7.hashCode();
        L15:
            return r6 + r1;
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "SnapshotAppActionContent(action=" + this.action + ", key=" + this.key + ", timeoutMs=" + this.timeoutMs + ')';
        }

        public a() {
            this.action = null;
            this.key = null;
            this.timeoutMs = null;
        }

        public final String a() {
            return this.action;
        }

        public final String b() {
            return this.key;
        }

        public final Integer c() {
            return this.timeoutMs;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001c\b\u0082\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003J\t\u0010\u001c\u001a\u00020\bHÆ\u0003J\t\u0010\u001d\u001a\u00020\bHÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003JO\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010 \u001a\u00020\u00052\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\bHÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0016\u0010\n\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000f¨\u0006$"}, d2 = {"Lcom/bytedance/applet/event/BaseAppActionListener$SnapshotAppActionResponse;", "", "key", "", "uploaded", "", "mimeType", "width", "", "height", "errorCode", "errorMsg", "<init>", "(Ljava/lang/String;ZLjava/lang/String;IIILjava/lang/String;)V", "getKey", "()Ljava/lang/String;", "getUploaded", "()Z", "getMimeType", "getWidth", "()I", "getHeight", "getErrorCode", "getErrorMsg", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b {

        @SerializedName("error_code")
        private final int errorCode;

        @SerializedName("error_msg")
        private final String errorMsg;

        @SerializedName("height")
        private final int height;

        @SerializedName("key")
        private final String key;

        @SerializedName("mime_type")
        private final String mimeType;

        @SerializedName("uploaded")
        private final boolean uploaded;

        @SerializedName("width")
        private final int width;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.key, r6.key) == true) goto L12;
            return false;
        L12:
            if (this.uploaded == r6.uploaded) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.mimeType, r6.mimeType) == true) goto L18;
            return false;
        L18:
            if (this.width == r6.width) goto L21;
            return false;
        L21:
            if (this.height == r6.height) goto L24;
            return false;
        L24:
            if (this.errorCode == r6.errorCode) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.errorMsg, r6.errorMsg) == true) goto L29;
            return false;
        L29:
            return true;
        }

        public final int hashCode() {
            int r0 = this.key.hashCode() * 31;
            if (this.uploaded == false) goto L5;
            int r1 = 1231;
        L7:
            return ((((((((((r0 + r1) * 31) + this.mimeType.hashCode()) * 31) + this.width) * 31) + this.height) * 31) + this.errorCode) * 31) + this.errorMsg.hashCode();
        L5:
            r1 = 1237;
            goto L7
        }

        public final String toString() {
            return "SnapshotAppActionResponse(key=" + this.key + ", uploaded=" + this.uploaded + ", mimeType=" + this.mimeType + ", width=" + this.width + ", height=" + this.height + ", errorCode=" + this.errorCode + ", errorMsg=" + this.errorMsg + ')';
        }

        public b(String r4, boolean r5, String r6, int r7, int r8, int r9, String r10, int r11) {
            if ((r11 & 4) == 0) goto L6;
            r6 = "";
        L6:
            if ((r11 & 8) == 0) goto L9;
            r7 = 0;
        L9:
            if ((r11 & 16) == 0) goto L12;
            r8 = 0;
        L12:
            if ((r11 & 32) == 0) goto L15;
            r9 = 0;
        L15:
            if ((r11 & 64) == 0) goto L17;
            r10 = "";
        L17:
            Intrinsics.checkNotNullParameter(r4, "key");
            Intrinsics.checkNotNullParameter(r6, "mimeType");
            Intrinsics.checkNotNullParameter(r10, "errorMsg");
            this.key = r4;
            this.uploaded = r5;
            this.mimeType = r6;
            this.width = r7;
            this.height = r8;
            this.errorCode = r9;
            this.errorMsg = r10;
        }
    }

    public e() {
    }

    static {
        e r0 = new e();
        a = r0;
        b = new com.bytedance.ai.uiu.l();
        c = new Gson();
        ArrayList r1 = new ArrayList();
        d = r1;
        Intrinsics.checkNotNullParameter(r0, "appActionListener");
        r1.add(new com.bytedance.applet.utils.e());
        PendingAppletActionCancellation r2 = PendingAppletActionCancellation.a;
        PendingAppletActionCancellation.a r3 = new d();
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "revoker");
        PendingAppletActionCancellation.c.add(r3);
    }

    public static String e(int r2, String r3, String r4) {
        JSONObject r0 = new JSONObject();
        r0.put("code", r2);
        r0.put("msg", r3);
        r0.put("data", r4);
        return r0.toString();
    }

    public final void c(String r11, String r12, String r13, j r14) {
        Intrinsics.checkNotNullParameter(r12, "msgId");
        Intrinsics.checkNotNullParameter(r13, "questionId");
        Intrinsics.checkNotNullParameter(r14, "responseCallback");
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L5
        Object r16 = Result.constructor-impl((a) c.fromJson(r11, a.class));     // Catch: Throwable -> L5
    L7:
        Throwable r17 = Result.exceptionOrNull-impl(r16);
        if (r17 != null) goto L41;
        a r18 = (a) r16;
        if (r18 != null) goto L13;
        return;
    L13:
        if (Intrinsics.areEqual(r18.a(), "get_current_page_screenshot") == false) goto L45;
        String r19 = r18.b();
        boolean r110 = true;
        if (r19 != null) goto L17;
    L20:
        boolean r111 = true;
    L21:
        if (r111 == false) goto L27;
        Gson r112 = c;
        String r113 = r18.b();
        if (r113 != null) goto L25;
        r113 = "";
    L25:
        r14.invoke(e(-1, "messageId is empty", GsonProtectorUtils.toJson(r112, new b(r113, false, null, 0, 0, -1, "messageId is empty", 28))));
        return;
    L27:
        String r3 = r18.b();
        Integer r114 = r18.c();
        if (r114 != null) goto L30;
    L38:
        long r115 = 5000;
    L39:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new BaseAppActionListener$onUndefinedAction$1(r115, r3, r14, null), 3, null);
        return;
    L30:
        if (r114.intValue() > 0) goto L33;
        r110 = false;
    L33:
        if (r110 == true) goto L36;
        r114 = null;
    L36:
        if (r114 == null) goto L38;
        r115 = r114.intValue();
        goto L39
    L17:
        if (r19.length() == 0) goto L20;
        r111 = false;
        goto L21
    L45:
        return;
    L41:
        FLogger.a.e("BaseAppActionListener", "parse undefined app action error " + r17);
        return;
    L5:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public final void a(String r23, String r24, String r25, String r26, String r27, Map r28, String r29, String r30, Long r31, Integer r32, j r33) {
        Intrinsics.checkNotNullParameter(r23, "botId");
        Intrinsics.checkNotNullParameter(r24, "conversationId");
        Intrinsics.checkNotNullParameter(r25, "appId");
        Intrinsics.checkNotNullParameter(r26, "apiName");
        Intrinsics.checkNotNullParameter(r27, "param");
        Intrinsics.checkNotNullParameter(r29, "msgId");
        Intrinsics.checkNotNullParameter(r30, "questionId");
        Intrinsics.checkNotNullParameter(r33, "responseCallback");
        FLogger.a.i("BaseAppActionListener", "begin to handle ui action questionId " + r30 + " apiName " + r26);
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new BaseAppActionListener$onUIAction$1(r23, r24, r25, r26, r27, r28, r29, r30, r31, BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new BaseAppActionListener$onUIAction$job$1(r32, r30, r26, r33, r29, r23, r24, r25, null), 3, null), r33, null), 3, null);
    }

    public final void b(String r1, String r2, String r3, String r4, String r5, Map r6, String r7, String r8, Long r9, Integer r10, j r11) {
        Intrinsics.checkNotNullParameter(r1, "botId");
        Intrinsics.checkNotNullParameter(r2, "conversationId");
        Intrinsics.checkNotNullParameter(r3, "appId");
        Intrinsics.checkNotNullParameter(r4, "eventName");
        Intrinsics.checkNotNullParameter(r5, "data");
        Intrinsics.checkNotNullParameter(r7, "msgId");
        Intrinsics.checkNotNullParameter(r8, "questionId");
        Intrinsics.checkNotNullParameter(r11, "responseCallback");
        com.bytedance.ai.monitor.b.d("app_action", new f(r7, r8));
        r11.invoke(e(0, "success", null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v30, types: [com.bytedance.applet.event.b] */
    /* JADX WARN: Type inference failed for: r1v3, types: [com.bytedance.applet.event.c, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v14, types: [com.bytedance.applet.event.a] */
    public static final Object d(e r19, String r20, String r21, String r22, String r23, String r24, Map r25, String r26, String r27, Long r28, g r29, Continuation r30) {
        String r0 = r26;
        String r1 = r27;
        r19.getClass();
        if ((r30 instanceof BaseAppActionListener$processUIAction$1) == false) goto L7;
        BaseAppActionListener$processUIAction$1 r3 = (BaseAppActionListener$processUIAction$1) r30;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        boolean r7 = false;
        if (r6 == 0) goto L16;
        if (r6 == 1) goto L15;
        if (r6 != 2) goto L14;
        Function1 r8 = (Function1) r3.L$8;
        Long r9 = (Long) r3.L$7;
        String r10 = (String) r3.L$6;
        String r11 = (String) r3.L$5;
        Map r12 = (Map) r3.L$4;
        String r13 = (String) r3.L$3;
        String r14 = (String) r3.L$2;
        String r15 = (String) r3.L$1;
        String r16 = (String) r3.L$0;
        ResultKt.throwOnFailure(r2);
        final Function1 r17 = r8;
        Long r18 = r9;
        r0 = r11;
        String r31 = r16;
        Map r110 = r12;
        String r32 = r15;
        String r111 = r13;
        String r112 = r14;
    L37:
        String r33 = (String) r2;
        r1 = r10;
    L40:
        PendingAppletActionCancellation.a.getClass();
        if (PendingAppletActionCancellation.d == false) goto L51;
        List r34 = CollectionsKt.listOf(new String[]{r1, r0});
        ArrayList r35 = new ArrayList();
        Iterator r36 = r34.iterator();
    L45:
        if (r36.hasNext() == false) goto L49;
        String r37 = PendingAppletActionCancellation.e((String) r36.next());
        if (r37 == null) goto L45;
        r35.add(r37);
        goto L45
    L49:
        Set r38 = CollectionsKt.toSet(r35);
        if (r38.isEmpty() == true) goto L51;
        boolean r39 = PendingAppletActionCancellation.d(r38, PendingAppletActionCancellation.e(r33));
    L53:
        LLMData r40 = null;
        if (r39 == false) goto L56;
        FLogger.a.i("BaseAppActionListener", "ignore applet ui action after user stop, appId=" + r32 + " apiName=" + r112 + " questionId=" + r1 + " msgId=" + r0 + " conversationId=" + r33);
        r17.invoke(e(0, "interrupted", null));
        return Unit.INSTANCE;
    L56:
        Iterator r41 = ((ArrayList) d).iterator();
    L58:
        if (r41.hasNext() == false) goto L62;
        o r113 = (o) r41.next();
        if (r113.a(r112) == false) goto L58;
        FLogger.a.i("BaseAppActionListener", "intercept ui action apiName " + r112 + " by " + r113.getClass().getSimpleName());
        r113.b(r31, r33, r32, r112, r111, r0, r1, new com.bytedance.applet.event.a(r17));
        return Unit.INSTANCE;
    L62:
        com.bytedance.ai.uiu.l r42 = b;
        r42.getClass();
        Intrinsics.checkNotNullParameter(r112, "apiName");
        if (Intrinsics.areEqual(r112, "system_ui_understanding_plugin.system_do_view_operations_tool") == false) goto L65;
    L68:
        boolean r43 = true;
    L69:
        if (r43 == false) goto L71;
        r42.a(r31, r32, r33, r112, r111, new com.bytedance.applet.event.b(r17));
        return Unit.INSTANCE;
    L71:
        AppletRuntimeManager r44 = AppletRuntimeManager.INSTANCE;
        if (r18 == null) goto L74;
        long r114 = r18.longValue();
    L75:
        h5.g r45 = new h5.g(r111, r0, r33, r31, r114, r1, r112, r110, r32);
        ?? r46 = new c(r17);
        r44.getClass();
        Intrinsics.checkNotNullParameter(r45, "data");
        Intrinsics.checkNotNullParameter(r46, "appActionCallback");
        long r47 = System.currentTimeMillis();
        LruCache r48 = com.bytedance.ai.utils.j.a;
        com.bytedance.ai.utils.j.a r49 = com.bytedance.ai.utils.j.b(Long.valueOf(CastLongProtector.parseLong(r45.b)));
        if (r49 == null) goto L81;
        com.bytedance.ai.utils.j.c r50 = r49.k;
        if (r50 == null) goto L81;
        r50.a();
    L81:
        if (r45.d.length() != 0) goto L83;
        r7 = true;
    L83:
        if (r7 == false) goto L86;
        String r51 = AppletRuntimeManager.h(r45.c);
        Intrinsics.checkNotNullParameter(r51, "<set-?>");
        r45.d = r51;
    L86:
        if (r45.j == null) goto L128;
    L106:
        LLMData r52 = r45.j;
        String r53 = r45.d;
        ConcurrentHashMap r54 = x4.a.a;
        String r55 = r45.c;
        Intrinsics.checkNotNullParameter(r55, "sessionId");
        if (r53 == null) goto L110;
        x4.a.a.putIfAbsent(r53, r55);
    L110:
        com.bytedance.ai.monitor.b.d("applet_llm_msg_received", new d0(r52, r53, r45));
        com.bytedance.ai.utils.g r56 = com.bytedance.ai.utils.g.a;
        r56.i("applet_lifecycle", "<parseMessage><msgId-" + r45.b + "> message is function call: " + r45);
        com.bytedance.ai.monitor.b.d("applet_switch_bot", new e0(r45));
        if (r52 == null) goto L123;
        RealData r57 = r52.getData();
        if (r57 == null) goto L123;
        String r58 = r57.getAppletId();
        if (r58 == null) goto L123;
        com.bytedance.ai.utils.f.j("llmMsgReceived --> " + r45.b + " to applet: " + r58);
        r56.i("applet_lifecycle", "<parseMessage><msgId-" + r45.b + "><conversationId-" + r45.c + "> runapplet  : " + r58);
        if (r49 == null) goto L122;
        com.bytedance.ai.utils.j.c r59 = r49.l;
        if (r59 == null) goto L122;
        r59.a();
    L122:
        ClientToolRunner r60 = ClientToolRunner.a;
        x r61 = new x(r58, r45, r46, r49, r52, r47);
        r60.getClass();
        ClientToolRunner.f(r58, r52, r47, r46, r61);
    L127:
        return Unit.INSTANCE;
    L123:
        String r62 = "llmData is broken " + r45;
        r56.e("AppletRuntimeManager", r62);
        r46.invoke(-1, r62, "");
        if (r49 == null) goto L127;
        r49.a(r62);
        goto L127
    L128:
        Result.Companion r63 = Result.Companion;     // Catch: Throwable -> L89
        Lazy r64 = com.bytedance.ai.applet.base.gson.e.a;     // Catch: Throwable -> L89
        Object r65 = Result.constructor-impl((LLMData) com.bytedance.ai.applet.base.gson.e.a(r45.a, LLMData.class));     // Catch: Throwable -> L89
    L92:
        if (Result.isFailure-impl(r65) == false) goto L94;
        r65 = null;
    L94:
        LLMData r66 = (LLMData) r65;
        if (r66 == null) goto L105;
        r66.setMsgId(r45.b);
        r66.setConversationID(r45.c);
        r66.setRealJSONData(r45.a);
        r66.setFromBotId(r45.d);
        r66.setCreateTime(Long.valueOf(r45.e));
        RealData r67 = r66.getData();
        if (r67 == null) goto L104;
        RealData r68 = r66.getData();
        if (r68 == null) goto L102;
        String r69 = r68.getPluginId();
        if (r69 == null) goto L102;
    L103:
        r67.setPluginId(r69);
    L102:
        r69 = r45.g;
    L104:
        r66.setQuestionId(r45.f);
        r66.setFeatureMap(r45.h);
        r40 = r66;
    L105:
        r45.j = r40;
    L89:
        th = move-exception;
        Result.Companion r70 = Result.Companion;
        r65 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L92
    L74:
        r114 = 0;
        goto L75
    L65:
        if (Intrinsics.areEqual(r112, "system_ui_understanding_plugin.system_get_uiu_context_tool") == true) goto L68;
        r43 = false;
    L51:
        r39 = false;
        goto L53
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        Function1 r71 = (Function1) r3.L$8;
        Long r72 = (Long) r3.L$7;
        String r73 = (String) r3.L$6;
        String r74 = (String) r3.L$5;
        Map r115 = (Map) r3.L$4;
        r111 = (String) r3.L$3;
        String r116 = (String) r3.L$2;
        String r117 = (String) r3.L$1;
        String r118 = (String) r3.L$0;
        ResultKt.throwOnFailure(r2);
        r17 = r71;
        r0 = r74;
        r32 = r117;
        r18 = r72;
        r1 = r73;
        r31 = r118;
        r110 = r115;
        r112 = r116;
    L31:
        r33 = (String) r2;
        if (r33 != null) goto L40;
        MessageUtils r75 = MessageUtils.a;
        r3.L$0 = r31;
        r3.L$1 = r32;
        r3.L$2 = r112;
        r3.L$3 = r111;
        r3.L$4 = r110;
        r3.L$5 = r0;
        r3.L$6 = r1;
        r3.L$7 = r18;
        r3.L$8 = r17;
        r3.label = 2;
        r2 = r75.d(r31, r3);
        if (r2 == r5) goto L142;
        r10 = r1;
        goto L37
    L142:
        return r5;
    L16:
        ResultKt.throwOnFailure(r2);
        LruCache r76 = com.bytedance.ai.utils.j.a;
        com.bytedance.ai.utils.j.a r77 = com.bytedance.ai.utils.j.b(Boxing.boxLong(CastLongProtector.parseLong(r26)));
        if (r77 == null) goto L21;
        com.bytedance.ai.utils.j.c r78 = r77.j;
        if (r78 == null) goto L21;
        r78.a();
    L21:
        com.bytedance.ai.monitor.b.d("app_action", new h(r0, r1));
        if (r21.length() != 0) goto L24;
        boolean r79 = true;
    L25:
        if (r79 == false) goto L39;
        LruCache<String, String> r80 = com.bytedance.applet.utils.j.a;
        Intrinsics.checkNotNullParameter(r1, "msgId");
        r33 = (String) com.bytedance.applet.utils.j.a.get(r1);
        if (r33 != null) goto L38;
        MessageUtils r81 = MessageUtils.a;
        r31 = r20;
        r3.L$0 = r31;
        r32 = r22;
        r3.L$1 = r32;
        r112 = r23;
        r3.L$2 = r112;
        r111 = r24;
        r3.L$3 = r111;
        r110 = r25;
        r3.L$4 = r110;
        r3.L$5 = r0;
        r3.L$6 = r1;
        r18 = r28;
        r3.L$7 = r18;
        r17 = r29;
        r3.L$8 = r17;
        r3.label = 1;
        r2 = r81.e(r1, r3);
        if (r2 != r5) goto L31;
        return r5;
    L38:
        r31 = r20;
        r32 = r22;
        r112 = r23;
        r111 = r24;
        r110 = r25;
        r18 = r28;
        r17 = r29;
        goto L40
    L39:
        r31 = r20;
        r32 = r22;
        r112 = r23;
        r111 = r24;
        r110 = r25;
        r18 = r28;
        r17 = r29;
        r33 = r21;
        goto L40
    L24:
        r79 = false;
    L7:
        r3 = new BaseAppActionListener$processUIAction$1(r19, r30);
        goto L8
    }
}
