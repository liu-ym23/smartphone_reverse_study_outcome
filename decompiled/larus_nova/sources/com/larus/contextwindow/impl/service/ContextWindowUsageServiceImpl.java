package com.larus.contextwindow.impl.service;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import androidx.camera.video.AudioStats;
import androidx.fragment.app.FragmentActivity;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.larus.contextwindow.api.ContextWindowContainer;
import com.larus.contextwindow.api.ContextWindowEnterFrom;
import com.larus.contextwindow.api.ContextWindowEntryRequest;
import com.larus.contextwindow.api.ContextWindowHiddenReason;
import com.larus.contextwindow.api.ContextWindowSnapshot;
import com.larus.contextwindow.api.IContextWindowUsageService;
import com.larus.contextwindow.impl.membership.MembershipQuotaRepository;
import com.larus.contextwindow.impl.membership.h;
import com.larus.contextwindow.impl.membership.k;
import com.larus.contextwindow.impl.membership.model.MembershipQuotaRowKind;
import com.larus.contextwindow.impl.membership.model.MembershipQuotaSummaryDto;
import com.larus.contextwindow.impl.routing.ContextWindowUsageHostActivity;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import w29.g;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B-\b\u0000\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006¢\u0006\u0004\b\t\u0010\nB\t\b\u0016¢\u0006\u0004\b\t\u0010\u000bJ\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u001a\u0010\u0016\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0013H\u0017J\u001a\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0013H\u0017J\"\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010 \u001a\u00020\rH\u0016J\u0018\u0010!\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001dH\u0002R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f¨\u0006\""}, d2 = {"Lcom/larus/contextwindow/impl/service/ContextWindowUsageServiceImpl;", "Lcom/larus/contextwindow/api/IContextWindowUsageService;", "featureEnabled", "Lkotlin/Function0;", "", "drawableFactory", "Lkotlin/Function1;", "Landroid/content/Context;", "Landroid/graphics/drawable/Drawable;", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "()V", "interceptor", "Lcom/bytedance/router/interceptor/IInterceptor;", "getInterceptor", "()Lcom/bytedance/router/interceptor/IInterceptor;", "interceptor$delegate", "Lkotlin/Lazy;", "evaluate", "Lcom/larus/contextwindow/api/ContextWindowEntryDecision;", "input", "Lcom/larus/contextwindow/api/ContextWindowEvaluationInput;", "createUsageIndicatorDrawable", PerfLog.PARAM_KEY_CONTEXT_ID, "decision", "createSlashUsageDescription", "", "open", "request", "Lcom/larus/contextwindow/api/ContextWindowEntryRequest;", "prefetchedSnapshot", "Lcom/larus/contextwindow/api/ContextWindowSnapshot;", "getRouterInterceptor", "openFromRoute", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ContextWindowUsageServiceImpl implements IContextWindowUsageService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Boolean> f330415b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<Context, Drawable> f330416c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f330417d;

    /* JADX INFO: renamed from: com.larus.contextwindow.impl.service.ContextWindowUsageServiceImpl$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<Boolean> {
        public AnonymousClass1(Object r100) {
            super(0, r100, y29.b.class, "isEnabled", "isEnabled()Z", 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            ((y29.b) this.receiver).getClass();
            return Boolean.valueOf(y29.b.a());
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return invoke();
        }
    }

    /* JADX INFO: renamed from: com.larus.contextwindow.impl.service.ContextWindowUsageServiceImpl$2, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<Context, Drawable> {
        public AnonymousClass2(Object r100) {
            super(1, r100, g.class, "create", "create(Landroid/content/Context;)Landroid/graphics/drawable/Drawable;", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Drawable invoke2(Context r100) {
            Intrinsics.checkNotNullParameter(r100, "p0");
            ((g) this.receiver).getClass();
            return g.a(r100);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Drawable invoke(Context r100) {
            return invoke2(r100);
        }
    }

    public ContextWindowUsageServiceImpl() {
        AnonymousClass1 r100 = new AnonymousClass1(y29.b.f565722a);
        AnonymousClass2 r101 = new AnonymousClass2(g.f558053a);
        Intrinsics.checkNotNullParameter(r100, "featureEnabled");
        Intrinsics.checkNotNullParameter(r101, "drawableFactory");
        this.f330415b = r100;
        this.f330416c = r101;
        this.f330417d = LazyKt.lazy(LazyThreadSafetyMode.NONE, new b(this));
    }

    @Override // com.larus.contextwindow.api.IContextWindowUsageService
    public final q97.a c() {
        return (q97.a) this.f330417d.getValue();
    }

    @Override // com.larus.contextwindow.api.IContextWindowUsageService
    public final com.larus.contextwindow.api.a e(v29.a r100) {
        Intrinsics.checkNotNullParameter(r100, "input");
        x29.g.f562264a.getClass();
        return x29.g.a(r100);
    }

    @Override // com.larus.contextwindow.api.IContextWindowUsageService
    public final Drawable a(Context r100, com.larus.contextwindow.api.a.b r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "decision");
        if (this.f330415b.invoke().booleanValue() == true) goto L5;
        return null;
    L5:
        return this.f330416c.invoke(r100);
    }

    /* JADX WARN: Type inference failed for: r11v0, types: [com.larus.contextwindow.impl.service.c] */
    /* JADX WARN: Type inference failed for: r12v0, types: [com.larus.contextwindow.impl.service.d] */
    @Override // com.larus.contextwindow.api.IContextWindowUsageService
    public final String d(final Context r110, com.larus.contextwindow.api.a.b r111) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "decision");
        if (this.f330415b.invoke().booleanValue() == false) goto L92;
        k.a();
        Lazy<MembershipQuotaRepository> r100 = MembershipQuotaRepository.f330347k;
        MembershipQuotaSummaryDto r101 = ((h) MembershipQuotaRepository.b.a().getState().getValue()).f330385a;
        if (r101 == null) goto L7;
        List<z29.b> r102 = com.larus.contextwindow.impl.membership.c.a(r101).f569815a;
    L8:
        if (r102 != null) goto L10;
        r102 = CollectionsKt.emptyList();
    L10:
        Regex r103 = com.larus.contextwindow.impl.membership.a.f330361a;
        double r104 = ((double) r111.f330277a.f330260g) / 10.0d;
        com.larus.contextwindow.impl.membership.b r112 = new com.larus.contextwindow.impl.membership.b(r110.getString(R.string.larus_input_contextWindow), r110.getString(R.string.larus_input_contextWindow_limit_current), r110.getString(R.string.larus_input_contextWindow_AIGC_quota), r110.getString(R.string.larus_input_contextWindow_usage_finish), r110.getString(R.string.larus_doubao_member_5h_without_limit_info), r110.getString(R.string.larus_input_contextWindow_usage_notyet), new c(r110), new d(r110));
        Intrinsics.checkNotNullParameter(r102, "quotaRows");
        Intrinsics.checkNotNullParameter(r112, "text");
        if (Double.isInfinite(r104) == false) goto L13;
    L15:
        boolean r113 = false;
    L16:
        if (r113 == false) goto L18;
        int r114 = MathKt.roundToInt(r104);
    L19:
        List r105 = CollectionsKt.mutableListOf(new String[]{r112.f330363a + ' ' + r114 + '%'});
        Iterator<T> r106 = r102.iterator();
    L21:
        if (r106.hasNext() == false) goto L91;
        z29.b r107 = (z29.b) r106.next();
        MembershipQuotaRowKind r108 = r107.f569803a;
        if (r108 != MembershipQuotaRowKind.SUBSCRIPTION_TOTAL) goto L25;
    L27:
        StringBuilder r109 = new StringBuilder();
        int r115 = com.larus.contextwindow.impl.membership.a.C4198a.f330362a[r107.f569803a.ordinal()];
        if (r115 != 1) goto L30;
        String r116 = r107.f569804b;
        if (r116 == null) goto L52;
        String r117 = StringsKt.trim(r116).toString();
        if (r117 == null) goto L52;
        if (r117.length() <= 0) goto L47;
        boolean r118 = true;
    L48:
        if (r118 == true) goto L51;
        r117 = null;
    L51:
        if (r117 == null) goto L52;
    L53:
        r109.append(r117);
        if (r107.f569811i == false) goto L56;
        String r119 = r112.f330367e;
    L87:
        r109.append(r119);
        String r120 = r109.toString();
    L88:
        if (r120 == null) goto L21;
        r105.add(r120);
        goto L21
    L56:
        String r121 = r107.f569812j;
        if (r121 != null) goto L59;
    L61:
        r121 = null;
    L62:
        String r122 = r107.f569813k;
        if (r122 != null) goto L65;
    L67:
        r122 = null;
    L68:
        if (r121 == null) goto L71;
        if (r122 == null) goto L71;
        boolean r123 = true;
    L73:
        if (r107.f569810h == false) goto L77;
        if (r123 == false) goto L76;
        r119 = r112.f330366d + ' ' + r122;
        goto L87
    L76:
        r119 = r112.f330366d;
        goto L87
    L77:
        if (r121 == null) goto L81;
        if (r122 == null) goto L81;
        r119 = com.larus.contextwindow.impl.membership.a.f330361a.replace(r112.f330369g.invoke(r121, r122), HTTP.URL_DEFAULT);
    L81:
        if (r107.f569809g == false) goto L84;
        r119 = r112.f330370h.invoke(" <1%");
        goto L87
    L84:
        if (r107.f569806d > AudioStats.AUDIO_AMPLITUDE_NONE) goto L86;
        r119 = r112.f330368f;
        goto L87
    L86:
        r119 = r112.f330370h.invoke(" " + BigDecimal.valueOf(r107.f569806d).stripTrailingZeros().toPlainString() + '%');
    L71:
        r123 = false;
        goto L73
    L65:
        if ((!StringsKt.isBlank(r122)) == false) goto L67;
    L59:
        if ((!StringsKt.isBlank(r121)) == false) goto L61;
    L47:
        r118 = false;
    L52:
        r117 = r112.f330365c;
        goto L53
    L30:
        if (r115 != 2) goto L32;
        r117 = r112.f330364b;
        goto L53
    L32:
        if (r115 != 3) goto L34;
    L38:
        r117 = "";
        goto L53
    L34:
        if (r115 == 4) goto L38;
        throw new NoWhenBranchMatchedException();
    L25:
        if (r108 == MembershipQuotaRowKind.H5) goto L27;
        r120 = null;
        goto L88
    L91:
        return CollectionsKt.joinToString$default(r105, "，", null, null, 0, null, null, 62, null);
    L18:
        r114 = 0;
        goto L19
    L13:
        if (Double.isNaN(r104) == true) goto L15;
        r113 = true;
        goto L16
    L7:
        r102 = null;
        goto L8
    L92:
        return null;
    }

    @Override // com.larus.contextwindow.api.IContextWindowUsageService
    public final boolean b(Context r100, ContextWindowEntryRequest r101, ContextWindowSnapshot r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "request");
        boolean r103 = false;
        if (this.f330415b.invoke().booleanValue() == true) goto L6;
        a39.a r104 = a39.a.f1682a;
        ContextWindowHiddenReason r105 = ContextWindowHiddenReason.FEATURE_OFF;
        ContextWindowEnterFrom r106 = r101.f330238d;
        r104.getClass();
        a39.a.a(r105, r106);
        return false;
    L6:
        a.f330418a.getClass();
        if (a.b(r101) == false) goto L9;
        if (r102 != null) goto L16;
    L19:
        if (r102 == null) goto L29;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Activity r107 = a.a(r100);
        if ((r107 instanceof FragmentActivity) == false) goto L23;
        FragmentActivity r108 = (FragmentActivity) r107;
    L24:
        if (r108 == null) goto L29;
        if (a.d(r108, r101, r102) == false) goto L29;
        return true;
    L23:
        r108 = null;
    L29:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "request");
        if (a.b(r101) == false) goto L51;
        if (r102 != null) goto L34;
    L36:
        int r109 = ContextWindowUsageHostActivity.f330409k;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "request");
        Intent r110 = new Intent(r100, ContextWindowUsageHostActivity.class);
        r110.putExtra("context_window_request", r101);
        if (r102 == null) goto L40;
        r110.putExtra("context_window_snapshot", r102);
    L40:
        if (a.a(r100) != null) goto L54;
        r110.addFlags(268435456);
    L54:
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L44
        r100.startActivity(r110);     // Catch: Throwable -> L44
        Object r112 = Result.m9449constructorimpl(Boolean.TRUE);     // Catch: Throwable -> L44
    L46:
        Throwable r113 = Result.m9452exceptionOrNullimpl(r112);
        if (r113 == null) goto L50;
        FLogger.f375446a.e("ContextWindowLauncher", "launch host failed", r113);
        r112 = Boolean.FALSE;
    L50:
        r103 = ((Boolean) r112).booleanValue();
    L44:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L46
    L34:
        if (a.c(r101, r102) == true) goto L36;
    L51:
        if (r103 == true) goto L53;
        a39.a r115 = a39.a.f1682a;
        ContextWindowHiddenReason r116 = ContextWindowHiddenReason.SERVICE_UNAVAILABLE;
        ContextWindowEnterFrom r117 = r101.f330238d;
        r115.getClass();
        a39.a.a(r116, r117);
    L53:
        return r103;
    L16:
        if (a.c(r101, r102) == true) goto L19;
        a39.a r118 = a39.a.f1682a;
        ContextWindowHiddenReason r119 = ContextWindowHiddenReason.USAGE_INVALID;
        ContextWindowEnterFrom r120 = r101.f330238d;
        r118.getClass();
        a39.a.a(r119, r120);
        return false;
    L9:
        if (r101.f330239e != ContextWindowContainer.UNSUPPORTED) goto L11;
        ContextWindowHiddenReason r121 = ContextWindowHiddenReason.UNSUPPORTED_CONTAINER;
    L12:
        a39.a r122 = a39.a.f1682a;
        ContextWindowEnterFrom r123 = r101.f330238d;
        r122.getClass();
        a39.a.a(r121, r123);
        return false;
    L11:
        r121 = ContextWindowHiddenReason.INVALID_CONVERSATION;
        goto L12
    }
}
