package com.larus.contextwindow.impl.membership;

import com.larus.contextwindow.impl.membership.model.MembershipQuotaSummaryDto;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.ServiceType;
import com.larus.network.http.y;
import com.larus.utils.logger.FLogger;
import com.ss.ttm.player.MediaPlayer;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes27.dex */
public final class MembershipQuotaApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MembershipQuotaApi f330346a = null;

    static {
        f330346a = new MembershipQuotaApi();
    }

    public MembershipQuotaApi() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13, types: [com.larus.utils.logger.FLogger] */
    /* JADX WARN: Type inference failed for: r0v21, types: [com.larus.utils.logger.FLogger] */
    /* JADX WARN: Type inference failed for: r15v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v2 */
    /* JADX WARN: Type inference failed for: r15v3 */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.larus.utils.logger.FLogger] */
    /* JADX WARN: Type inference failed for: r1v8, types: [com.larus.utils.logger.FLogger] */
    /* JADX WARN: Type inference failed for: r2v8, types: [com.larus.utils.logger.FLogger] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final Object a(Continuation<? super e> r110) {
        if ((r110 instanceof MembershipQuotaApi$fetch$1) == false) goto L7;
        MembershipQuotaApi$fetch$1 r100 = (MembershipQuotaApi$fetch$1) r110;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        MembershipQuotaApi$fetch$1 r111 = r100;
        Object r102 = r111.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r111.label;
        ?? r112 = "MembershipQuotaApi";
        if (r104 == 0) goto L15;
        if (r104 != 1) goto L14;
        ResultKt.throwOnFailure(r102);     // Catch: CancellationException -> L34 Throwable -> L36
        ?? r105 = "MembershipQuotaApi";
        r112 = r112;
    L21:
        com.larus.network.http.a r106 = (com.larus.network.http.a) r102;     // Catch: Throwable -> L32 CancellationException -> L34
        if ((r106 instanceof y) == false) goto L28;
        MembershipQuotaSummaryDto r107 = (MembershipQuotaSummaryDto) ((y) r106).f360135b;     // Catch: Throwable -> L32 CancellationException -> L34
        if (r107 == null) goto L26;
        FLogger.f375446a.i(r105, "quota summary request success path=/alice/commerce/sale/subscription/quota/summary/");     // Catch: Throwable -> L32 CancellationException -> L34
        return new e.b(r107);
    L26:
        FLogger.f375446a.e(r105, "quota summary request empty path=/alice/commerce/sale/subscription/quota/summary/");     // Catch: Throwable -> L32 CancellationException -> L34
        return e.a.f330382a;
    L28:
        if ((r106 instanceof com.larus.network.http.f) == false) goto L30;
        FLogger.f375446a.e(r105, "quota summary request failed path=/alice/commerce/sale/subscription/quota/summary/ code=" + ((com.larus.network.http.f) r106).f360157d.getCode());     // Catch: Throwable -> L32 CancellationException -> L34
        return e.a.f330382a;
    L30:
        FLogger.f375446a.e(r105, "quota summary request incomplete path=/alice/commerce/sale/subscription/quota/summary/");     // Catch: Throwable -> L32 CancellationException -> L34
        return e.a.f330382a;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r102);
        JSONObject r108 = new JSONObject().put("product_line", com.bytedance.android.ec.core.event.a.VALUE_MEMBER);     // Catch: CancellationException -> L34 Throwable -> L36
        r111.label = 1;     // Catch: CancellationException -> L34 Throwable -> L36
        ?? r109 = "MembershipQuotaApi";
        r112 = 944(0x3b0, float:1.323E-42);
        r102 = HttpExtKt.k(ServiceType.BASIC_SERVICE, MembershipQuotaSummaryDto.class, "/alice/commerce/sale/subscription/quota/summary/", r108, null, null, true, null, null, null, r111, MediaPlayer.MEDIA_PLAYER_OPTION_HTTP2_PARAMS);     // Catch: Throwable -> L32 CancellationException -> L34
        r105 = r109;
        if (r102 != r103) goto L21;
        return r103;
    L32:
        th = th;
    L38:
        FLogger.f375446a.e(r109, "quota summary request exception path=/alice/commerce/sale/subscription/quota/summary/ type=".concat(th.getClass().getSimpleName()));
        return e.a.f330382a;
    L34:
        e = move-exception;
        throw e;
    L36:
        th = th;
        r109 = r112;
    L7:
        r100 = new MembershipQuotaApi$fetch$1(this, r110);
        goto L8
    }
}
