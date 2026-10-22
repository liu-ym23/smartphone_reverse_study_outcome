package com.ss.android.lark.auditsdk.v2.utils;

import com.ss.android.lark.auditsdk.IAuditModuleDependency;
import com.ss.android.lark.log.Log;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: classes34.dex */
public final class AuditParamsUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AuditParamsUtil f409685a = null;

    public interface a {
        void a(swa.a r100);
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f409686a = null;

        static {
            int[] r100 = new int[IAuditModuleDependency.ChatType.values().length];
            r100[IAuditModuleDependency.ChatType.P2P.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            f409686a = r100;
        }
    }

    static {
        f409685a = new AuditParamsUtil();
    }

    public AuditParamsUtil() {
    }

    @JvmStatic
    public static final void b(swa.a r110, String r111, String r112, String r113, String r114, String r115, a r116) {
        Intrinsics.checkNotNullParameter(r110, "builder");
        Intrinsics.checkNotNullParameter(r116, "callback");
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new AuditParamsUtil$fillDlpParams$1(r110, r111, r112, r113, r114, r115, r116, null), 2, null);
    }

    public final Object a(swa.a r110, String r111, String r112, String r210, String r211, String r212, Continuation<? super swa.a> r213) {
        if ((r213 instanceof AuditParamsUtil$fillDlpParams$2) == false) goto L7;
        AuditParamsUtil$fillDlpParams$2 r100 = (AuditParamsUtil$fillDlpParams$2) r213;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        Long r113 = null;
        if (r104 == 0) goto L16;
        if (r104 == 1) goto L15;
        if (r104 != 2) goto L14;
        StringBuilder r105 = (StringBuilder) r100.L$4;
        String r106 = (String) r100.L$3;
        String r107 = (String) r100.L$2;
        String r108 = (String) r100.L$1;
        swa.a r109 = (swa.a) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L43:
        IAuditModuleDependency.b r114 = (IAuditModuleDependency.b) r102;
        StringBuilder r115 = new StringBuilder(",getMessageSenderInfo:[");
        if (r114 == null) goto L46;
        Long r116 = r114.f409557a;
    L47:
        r115.append(r116);
        r115.append(',');
        if (r114 == null) goto L50;
        r113 = r114.f409558b;
    L50:
        r115.append(r113);
        r115.append(']');
        r105.append(r115.toString());
        if (r114 == null) goto L53;
        r109.f543750k = r114.f409557a;
        r109.f543751l = r114.f409558b;
    L53:
        String r117 = r107;
        swa.a r118 = r109;
        String r119 = r108;
    L54:
        Log.i("AuditParamsUtil", "fileKey:" + r106 + ",chatId:" + r119 + ",messageId:" + r117 + ',' + r105);
        return r118;
    L46:
        r116 = null;
        goto L47
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r105 = (StringBuilder) r100.L$6;
        r106 = (String) r100.L$5;
        String r120 = (String) r100.L$4;
        String r121 = (String) r100.L$3;
        r117 = (String) r100.L$2;
        r119 = (String) r100.L$1;
        r118 = (swa.a) r100.L$0;
        ResultKt.throwOnFailure(r102);
        String r122 = r120;
    L23:
        if (b.f409686a[((IAuditModuleDependency.ChatType) r102).ordinal()] != 1) goto L25;
        long r123 = 1;
    L26:
        r118.f543754o = r119;
        r118.f543755p = Boxing.boxLong(r123);
        r105.append(",chatType:" + r123);
    L28:
        if (r117 == null) goto L54;
        r118.f543752m = r117;
        if (r121 == null) goto L32;
        Long r124 = StringsKt.toLongOrNull(r121);
    L33:
        if (r122 == null) goto L35;
        Long r125 = StringsKt.toLongOrNull(r122);
    L36:
        r118.f543750k = r124;
        r118.f543751l = r125;
        r105.append(",senderInfo:[" + r124 + ',' + r125 + ']');
        if (r124 == null) goto L39;
        if (r125 != null) goto L54;
    L39:
        CoroutineDispatcher r126 = Dispatchers.getIO();
        AuditParamsUtil$fillDlpParams$senderInfo$1 r127 = new AuditParamsUtil$fillDlpParams$senderInfo$1(r117, null);
        r100.L$0 = r118;
        r100.L$1 = r119;
        r100.L$2 = r117;
        r100.L$3 = r106;
        r100.L$4 = r105;
        r100.L$5 = null;
        r100.L$6 = null;
        r100.label = 2;
        r102 = BuildersKt.withContext(r126, r127, r100);
        if (r102 != r103) goto L42;
        return r103;
    L42:
        r109 = r118;
        r108 = r119;
        r107 = r117;
        goto L43
    L35:
        r125 = null;
        goto L36
    L32:
        r124 = null;
        goto L33
    L25:
        r123 = 2;
        goto L26
    L16:
        ResultKt.throwOnFailure(r102);
        r110.f543753n = r212;
        r110.f543755p = Boxing.boxLong(2);
        StringBuilder r128 = new StringBuilder();
        if (r111 == null) goto L27;
        CoroutineDispatcher r129 = Dispatchers.getIO();
        AuditParamsUtil$fillDlpParams$chatType$1 r130 = new AuditParamsUtil$fillDlpParams$chatType$1(r111, null);
        r100.L$0 = r110;
        r100.L$1 = r111;
        r100.L$2 = r112;
        r100.L$3 = r210;
        r122 = r211;
        r100.L$4 = r122;
        r100.L$5 = r212;
        r100.L$6 = r128;
        r100.label = 1;
        Object r131 = BuildersKt.withContext(r129, r130, r100);
        if (r131 != r103) goto L21;
        return r103;
    L21:
        r118 = r110;
        r105 = r128;
        r102 = r131;
        r121 = r210;
        r117 = r112;
        r119 = r111;
        r106 = r212;
        goto L23
    L27:
        r122 = r211;
        r118 = r110;
        r105 = r128;
        r121 = r210;
        r117 = r112;
        r119 = r111;
        r106 = r212;
    L7:
        r100 = new AuditParamsUtil$fillDlpParams$2(this, r213);
        goto L8
    }
}
