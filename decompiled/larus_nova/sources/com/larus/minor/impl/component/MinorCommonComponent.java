package com.larus.minor.impl.component;

import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.news.common.settings.SettingsManager;
import com.bytedance.news.common.settings.SettingsUpdateListener;
import com.larus.basic.experience.downgrade.api.DowngradeSource;
import com.larus.bmhome.auth.c1;
import com.larus.bmhome.auth.h0;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.chat.tips.IGuideTipsService;
import com.larus.commercecredit.api.ICommerceCreditService;
import com.larus.minor.api.IMinorService;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000[\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001!\u0018\u00002\u00060\u0001j\u0002`\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020$H\u0016J\b\u0010&\u001a\u00020$H\u0016J\b\u0010'\u001a\u00020$H\u0002J\b\u0010(\u001a\u00020$H\u0016J\u000e\u0010)\u001a\u00020$H\u0082@¢\u0006\u0002\u0010*J\u0018\u0010+\u001a\u00020$2\u0006\u0010,\u001a\u00020\u00072\u0006\u0010-\u001a\u00020.H\u0002J\b\u0010/\u001a\u00020$H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u001a\u001a\u0004\b\u001d\u0010\u001eR\u0010\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\"¨\u00060"}, d2 = {"Lcom/larus/minor/impl/component/MinorCommonComponent;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lcom/larus/ui/arch/component/external/Component;", "Lcom/larus/bmhome/chat/component/minor/IMinorCommonComponentAbility;", "<init>", "()V", "TAG", "", "isMinorChecked", "", "isMinorShowed", "isCommerceShown", "isAccountReusedShown", "isAccountReusedChecked", "_dialogShowState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/larus/bmhome/chat/component/minor/MinorDialogShowState;", "dialogShowState", "Lkotlinx/coroutines/flow/StateFlow;", "getDialogShowState", "()Lkotlinx/coroutines/flow/StateFlow;", "chatConversationAbility", "Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "getChatConversationAbility", "()Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "chatConversationAbility$delegate", "Lkotlin/Lazy;", "settingsUpdateListener", "Lcom/bytedance/news/common/settings/SettingsUpdateListener;", "getSettingsUpdateListener", "()Lcom/bytedance/news/common/settings/SettingsUpdateListener;", "settingsUpdateListener$delegate", "launchInfoObserver", "com/larus/minor/impl/component/MinorCommonComponent$launchInfoObserver$1", "Lcom/larus/minor/impl/component/MinorCommonComponent$launchInfoObserver$1;", "onAttach", "", WidgetCostModule.TYPE_ON_CREATE, "onParentViewCreated", "tryShowAccountReused", "onResume", "tryShowMinorTips", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryShowCommerceCreditGuide", "scene", "source", "Lcom/larus/basic/experience/downgrade/api/DowngradeSource;", LiveCommonConstants.REASON_ON_DEDTROY, "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MinorCommonComponent extends ComponentFeature implements ae8.a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f359165h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f359166i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f359167j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f359168k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f359169l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final StateFlowImpl f359170m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final b1 f359171n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f359172o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f359173p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final MinorCommonComponent$launchInfoObserver$1 f359174q;

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onCreate() {
        SettingsManager.registerListener((SettingsUpdateListener) this.f359173p.getValue(), true);
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onDestroy() {
        SettingsManager.unregisterListener((SettingsUpdateListener) this.f359173p.getValue());
        AuthModelDelegate.f297134b.a().removeObserver(this.f359174q);
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onResume() {
        FLogger.f375446a.i(this.f359165h, "onResume");
        if (this.f359167j == false) goto L5;
        return;
    L5:
        if (this.f359166i == false) goto L9;
        N2(this.f359165h + "_onResume", DowngradeSource.COLD_LAUNCH);
        return;
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, ae8.a.class);
    }

    /* JADX WARN: Type inference failed for: r0v8, types: [com.larus.minor.impl.component.MinorCommonComponent$launchInfoObserver$1] */
    public MinorCommonComponent() {
        this.f359165h = "MinorCommonComponent";
        StateFlowImpl r100 = j1.a(null);
        this.f359170m = r100;
        this.f359171n = kotlinx.coroutines.flow.e.b(r100);
        this.f359172o = LazyKt.lazy(new a(this));
        this.f359173p = LazyKt.lazy(new b(this));
        this.f359174q = new MinorCommonComponent$launchInfoObserver$1(this);
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void B2() {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new MinorCommonComponent$onParentViewCreated$1(this, null), 3, null);
        LiveData<c1<h0>> r100 = AuthModelDelegate.f297134b.a();
        Intrinsics.checkNotNullParameter(this, "<this>");
        r100.observe(com.larus.ui.arch.component.internal.attach.a.b(this, this).getViewLifecycleOwner(), this.f359174q);
    }

    @Override // ae8.a
    public final b1 Ce() {
        return this.f359171n;
    }

    public static final void F2(MinorCommonComponent r100) {
        r100.getClass();
        c1<h0> r101 = AuthModelDelegate.f297134b.a().getValue();
        if (r101 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == false) goto L11;
        r100.f359169l = true;
        r100.f359170m.setValue(new ae8.c(r100.f359166i, r100.f359167j, r100.f359168k, false, true));
        return;
    L11:
        return;
    L5:
        if (r101.f295751b != 2) goto L7;
        r102 = true;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [com.larus.minor.impl.component.c] */
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
    public static final Object L2(final MinorCommonComponent r110, Continuation r111) {
        r110.getClass();
        if ((r111 instanceof MinorCommonComponent$tryShowMinorTips$1) == false) goto L7;
        MinorCommonComponent$tryShowMinorTips$1 r100 = (MinorCommonComponent$tryShowMinorTips$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        MinorCommonComponent r104 = (MinorCommonComponent) r100.L$0;
        ResultKt.throwOnFailure(r112);
    L20:
        r104.f359167j = ((Boolean) r112).booleanValue();
        r110.f359166i = true;
        r110.f359170m.setValue(new ae8.c(true, r110.f359167j, r110.f359168k, false, r110.f359169l));
        if (r110.f359167j == false) goto L23;
        jo8.b.f499915a = true;
    L23:
        FLogger.f375446a.i(r110.f359165h, "tryShowMinorTips isMinorShowed=" + r110.f359167j + " isMinorChecked=true");
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r112);
        if (r110.f359169l == false) goto L25;
        IMinorService.Companion r113 = IMinorService.f359156a;
        ?? r105 = new c(r110);
        r100.L$0 = r110;
        r100.label = 1;
        r112 = r113.f(r105, r100);
        if (r112 == r102) goto L27;
        r104 = r110;
        goto L20
    L27:
        return r102;
    L25:
        return Unit.INSTANCE;
    L7:
        r100 = new MinorCommonComponent$tryShowMinorTips$1(r110, r111);
        goto L8
    }

    public final void N2(String r100, final DowngradeSource r110) {
        ICommerceCreditService.f325667a.getClass();
        ICommerceCreditService r101 = ICommerceCreditService.a.a();
        if (r101 == null) goto L5;
        Boolean r102 = Boolean.valueOf(r101.n(r100));
    L6:
        y r103 = (y) this.f359172o.getValue();
        if (r103 == null) goto L10;
        String r104 = r103.Y1();
        if (r104 == null) goto L10;
    L11:
        boolean r105 = com.larus.bmhome.utils.i.g(r104);
        FLogger.f375446a.i(this.f359165h, "tryShowCommerceCreditGuide show commerce credit guide scene=" + r100 + " isShowed=" + r102 + " conversationId=" + r104 + " isMainBot=" + r105);
        if (r105 == true) goto L14;
        return;
    L14:
        if (Intrinsics.areEqual(r102, Boolean.TRUE) == true) goto L22;
        IGuideTipsService r106 = (IGuideTipsService) ServiceManager.get().getService(IGuideTipsService.class);
        if (r106 == null) goto L23;
        boolean r107 = Boolean.valueOf(r106.g(new com.larus.bmhome.chat.tips.a(5, "", ""), new d(this, r110))).booleanValue();
        this.f359168k = r107;
        this.f359170m.setValue(new ae8.c(this.f359166i, this.f359167j, r107, false, this.f359169l));
        if (this.f359168k == false) goto L24;
        jo8.b.f499915a = true;
        return;
    L24:
        return;
    L23:
        return;
    L22:
        return;
    L10:
        r104 = "";
        goto L11
    L5:
        r102 = null;
        goto L6
    }
}
