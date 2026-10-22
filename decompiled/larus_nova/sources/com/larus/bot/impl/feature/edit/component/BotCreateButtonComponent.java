package com.larus.bot.impl.feature.edit.component;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import com.larus.bot.impl.databinding.LarusPageBotEditBinding;
import com.larus.bot.impl.feature.edit.BotCreateViewModel;
import com.larus.bot.impl.feature.edit.feature.accesspermission.BotPublicPermissionBSDialog;
import com.larus.settings.value.e10;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import tx9.o3;
import v19.c7;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 +2\u00060\u0001j\u0002`\u00022\u00020\u0003:\u0001+B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u000f\u0010\u0014\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0002\u0010\u0015J\u000f\u0010\u0016\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0002\u0010\u0015J\u000f\u0010\u0017\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0002\u0010\u0015J\u0017\u0010\u0018\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0019\u001a\u00020\u001aH\u0002¢\u0006\u0002\u0010\u001bJ\u000f\u0010\u001c\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0002\u0010\u0015J\u0012\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0002J8\u0010!\u001a\u00020\u00122\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010#2\b\u0010%\u001a\u0004\u0018\u00010#2\b\u0010&\u001a\u0004\u0018\u00010#2\u0006\u0010'\u001a\u00020\u001aH\u0002J\b\u0010(\u001a\u00020\u001aH\u0002J\b\u0010)\u001a\u00020\u0012H\u0016J\b\u0010*\u001a\u00020\u0012H\u0016R\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001d\u0010\f\u001a\u0004\u0018\u00010\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000f¨\u0006,"}, d2 = {"Lcom/larus/bot/impl/feature/edit/component/BotCreateButtonComponent;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lcom/larus/ui/arch/component/external/Component;", "Lcom/larus/bot/impl/feature/ability/IBotCreateButtonAbility;", "<init>", "()V", "botEditAbility", "Lcom/larus/bot/impl/feature/ability/IBotEditAbility;", "getBotEditAbility", "()Lcom/larus/bot/impl/feature/ability/IBotEditAbility;", "botEditAbility$delegate", "Lkotlin/Lazy;", "botCreateAbility", "Lcom/larus/bot/impl/feature/ability/IBotCreateAbility;", "getBotCreateAbility", "()Lcom/larus/bot/impl/feature/ability/IBotCreateAbility;", "botCreateAbility$delegate", "onAttach", "", "onParentViewCreated", "setupCreateBtn", "()Lkotlin/Unit;", "setupCreate", "setupCreateQuotaInfo", "refreshCreateBtn", "canCreate", "", "(Z)Lkotlin/Unit;", "updateScrollChildBottomPadding", "requireConversationDetail", "Lkotlinx/coroutines/Job;", "bot", "Lcom/larus/im/bean/bot/BotModel;", "handleCreateSuccess", "botId", "", "conversationId", "bgImgUrl", "bgImgColor", "showBg", "openInSideBar", "doFinish", "tryCrateBot", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BotCreateButtonComponent extends ComponentFeature implements ru8.b {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f318208j = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f318209h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f318210i;

    public static final class a {
    }

    public static final class b implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f318211a;

        public b(com.larus.bot.impl.feature.edit.component.a r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f318211a = r100;
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r100 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r100).getFunctionDelegate());
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> getFunctionDelegate() {
            return this.f318211a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object r100) {
            this.f318211a.invoke(r100);
        }
    }

    static {
    }

    public final ru8.a F2() {
        return (ru8.a) this.f318210i.getValue();
    }

    public final ru8.e L2() {
        return (ru8.e) this.f318209h.getValue();
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, ru8.b.class);
    }

    public BotCreateButtonComponent() {
        this.f318209h = LazyKt.lazy(new d(this));
        this.f318210i = LazyKt.lazy(new e(this));
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [com.larus.bot.impl.feature.edit.component.a] */
    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void B2() {
        ru8.e r100 = L2();
        if (r100 == null) goto L31;
        LarusPageBotEditBinding r101 = r100.e();
        if (r101 == null) goto L31;
        ru8.a r102 = F2();
        if (r102 == null) goto L30;
        final BotCreateViewModel r103 = r102.a1();
        if (r103 == null) goto L30;
        if (r103.getCanAddBgImage() == false) goto L29;
        com.larus.utils.e1.x(r101.f317937h);
        com.larus.utils.e1.x(r101.f317939j);
        ru8.e r104 = L2();
        if (r104 == null) goto L18;
        LarusPageBotEditBinding r105 = r104.e();
        if (r105 == null) goto L18;
        com.larus.utils.e1.o(r105.f317940k);
        Unit r106 = Unit.INSTANCE;
    L18:
        boolean r107 = false;
        N2(false);
        com.larus.utils.e1.d(r101.f317938i, new com.larus.bot.impl.feature.edit.component.b(this, r103));
        ru8.e r108 = L2();
        if (r108 == null) goto L30;
        LarusPageBotEditBinding r109 = r108.e();
        if (r109 == null) goto L30;
        if (r109.f317940k.getVisibility() != 0) goto L25;
        r107 = true;
    L25:
        if (r107 == false) goto L27;
        int r110 = c7.b(106);
    L28:
        ConstraintLayout r111 = r109.I;
        r111.setPaddingRelative(r111.getPaddingStart(), r111.getPaddingTop(), r111.getPaddingEnd(), r110);
        Unit r112 = Unit.INSTANCE;
        goto L30
    L27:
        r110 = c7.b(88);
        goto L28
    L29:
        com.larus.utils.e1.o(r101.f317937h);
    L30:
        Unit r113 = Unit.INSTANCE;
    L31:
        ru8.e r114 = L2();
        if (r114 != null) goto L34;
        return;
    L34:
        if (r114.e() == null) goto L49;
        ru8.a r115 = F2();
        if (r115 == null) goto L46;
        final BotCreateViewModel r116 = r115.a1();
        if (r116 == null) goto L46;
        ru8.e r117 = L2();
        if (r117 == null) goto L46;
        LifecycleOwner r118 = r117.s4();
        if (r118 == null) goto L46;
        com.larus.bot.impl.common.util.e.a(r116.getReady(), LifecycleOwnerKt.getLifecycleScope(r118), new BotCreateButtonComponent$setupCreate$1$1(this, null));
        r116.getCreateResult().observe(r118, new b(new com.larus.bot.impl.feature.edit.component.a(this, r116)));
    L46:
        Unit r119 = Unit.INSTANCE;
        return;
    }

    @Override // ru8.b
    public final void Eb() {
        ru8.a r100 = F2();
        if (r100 == null) goto L11;
        BotCreateViewModel r101 = r100.a1();
        if (r101 != null) goto L8;
        return;
    L8:
        if (r101.interceptDoFinish() == true) goto L12;
        o20();
        return;
    L12:
        return;
    }

    @Override // ru8.b
    public final void o20() {
        ru8.a r100 = F2();
        if (r100 == null) goto L54;
        final BotCreateViewModel r101 = r100.a1();
        if (r101 != null) goto L8;
        return;
    L8:
        if (r101.getPrivateStatus() != 1) goto L22;
        BotPublicPermissionBSDialog r102 = new BotPublicPermissionBSDialog();
        Pair[] r103 = new Pair[2];
        boolean r104 = false;
        r103[0] = TuplesKt.to("public_permission_scene_argument", 1);
        if (r101.getPrivateStatus() != 1) goto L12;
        r104 = true;
    L12:
        r103[1] = TuplesKt.to("public_status_key", Boolean.valueOf(r104));
        r102.setArguments(com.larus.utils.f.c(r103));
        r102.f318381j = new c(this, r101);
        Intrinsics.checkNotNullParameter(this, "<this>");
        FragmentManager r105 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getParentFragmentManager();
        LandscapeRestrictionOperation r106 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r102, "BotPublicPermissionBSDialog", r106);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r105, r102, r106) == false) goto L48;
    L17:
        ru8.a r107 = F2();
        if (r107 == null) goto L20;
        String r108 = r107.Wc();
    L21:
        String r109 = r108;
        String r110 = r101.getBotCreateTrace().d();
        String r111 = r101.getBotCreateTrace().o();
        String r112 = r101.getBotCreateTrace().c();
        String r113 = r101.getBotCreateTrace().i();
        String r114 = r101.getBotCreateTrace().h();
        Intrinsics.checkNotNullParameter(this, "<this>");
        Fragment r115 = com.larus.ui.arch.component.internal.attach.a.b(this, this);
        Intrinsics.checkNotNull(r115, "null cannot be cast to non-null type com.larus.trace.tracknode.TraceFragment");
        o3.a(r109, r110, r111, r112, "status_permission", r113, r114, (TraceFragment) r115, 257);
        return;
    L20:
        r108 = null;
        goto L21
    L48:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L45
    L16:
        r102.show(r105, "BotPublicPermissionBSDialog");
        goto L17
    L22:
        e10 r116 = e10.f368561a;
        if (e10.l() == true) goto L33;
        ru8.e r117 = L2();
        if (r117 == null) goto L33;
        com.larus.common_ui.dialog.l0 r118 = r117.uL();
        if (r118 == null) goto L33;
        if (DialogLancet.shouldBlockDialogShow(r118) == false) goto L50;
        DialogLancet.handleBlockedDialogShow(r118);
        goto L33
    L50:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L46
    L32:
        DialogLancet.beforeDialogShow(r118);
        r118.show();
        DialogLancet.afterDialogShow(r118);
    L33:
        r101.create();
        if (e10.l() == false) goto L56;
        ru8.e r119 = L2();
        if (r119 == null) goto L57;
        com.larus.common_ui.dialog.l0 r120 = r119.uL();
        if (r120 != null) goto L40;
        return;
    L40:
        if (DialogLancet.shouldBlockDialogShow(r120) == false) goto L52;
        DialogLancet.handleBlockedDialogShow(r120);
        return;
    L52:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L47
    L43:
        DialogLancet.beforeDialogShow(r120);
        r120.show();
        DialogLancet.afterDialogShow(r120);
        return;
    L57:
        return;
    L56:
        return;
    }

    public final Unit N2(boolean r100) {
        ru8.e r101 = L2();
        if (r101 == null) goto L20;
        LarusPageBotEditBinding r102 = r101.e();
        if (r102 == null) goto L20;
        ru8.a r103 = F2();
        boolean r104 = false;
        if (r103 == null) goto L13;
        BotCreateViewModel r105 = r103.a1();
        if (r105 == null) goto L13;
        if (r105.getCanAddBgImage() != true) goto L13;
        r104 = true;
    L13:
        if (r104 == false) goto L18;
        r102.f317938i.setEnabled(r100);
        if (r100 == false) goto L17;
        r102.f317938i.setAlpha(1.0f);
    L22:
        return Unit.INSTANCE;
    L17:
        r102.f317938i.setAlpha(0.3f);
        goto L22
    L18:
        r102.K.setRightTextEnable(r100);
    L20:
        return null;
    }
}
