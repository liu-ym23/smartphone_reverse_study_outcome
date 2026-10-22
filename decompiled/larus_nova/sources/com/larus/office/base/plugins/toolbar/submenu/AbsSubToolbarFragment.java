package com.larus.office.base.plugins.toolbar.submenu;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.view.animation.DecelerateInterpolator;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.nova.R;
import com.larus.office.base.plugins.toolbar.colorpicker.ColorPickerTabFragment;
import com.larus.office.base.plugins.toolbar.fontpicker.BasePickerFragment;
import com.larus.office.base.plugins.toolbar.fontpicker.BasePickerFragment$attachToParentFragment$parentLifecycleObserver$1;
import com.larus.office.base.plugins.toolbar.fontpicker.FontPickerFragment;
import com.larus.office.base.plugins.toolbar.model.Item;
import com.larus.office.base.plugins.toolbar.model.ItemId;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import in9.e;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000 &2\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0001&B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0014J'\u0010\u0007\u001a\u00020\b\"\u0004\b\u0000\u0010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u0001H\tH\u0014¢\u0006\u0002\u0010\rJ\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\"\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002JB\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001d2\u0010\b\u0002\u0010!\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\"H\u0002J$\u0010#\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00122\b\u0010$\u001a\u0004\u0018\u00010\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\u0012\u0010%\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u0016H\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082D¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/larus/office/base/plugins/toolbar/submenu/AbsSubToolbarFragment;", "Lcom/larus/office/base/plugins/toolbar/submenu/BaseSubToolbarV2Fragment;", "Lcom/larus/office/base/plugins/toolbar/model/DocToolbar;", "<init>", "()V", "instantiateAdapter", "Lcom/larus/office/base/plugins/toolbar/submenu/BaseSubToolbarAdapter;", "processOnItemClick", "", "V", "itemV2", "Lcom/larus/office/base/plugins/toolbar/model/Item;", "value", "(Lcom/larus/office/base/plugins/toolbar/model/Item;Ljava/lang/Object;)V", "showPickerFragment", WidgetService.PARAM_FRAGMENT, "Lcom/larus/office/base/plugins/toolbar/fontpicker/BasePickerFragment;", "startEnterAnimation", "Landroidx/fragment/app/Fragment;", "oldContentView", "Landroid/view/View;", "fontSizeJson", "", "animationDuration", "", "createSlideFadeAnimator", "Landroid/animation/Animator;", "view", "fromX", "", "toX", "fromAlpha", "toAlpha", "onEndAction", "Lkotlin/Function0;", "startExitAnimation", "newContentView", "reportItemValue", "Companion", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsSubToolbarFragment extends BaseSubToolbarV2Fragment<e> {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f360935p = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final long f360936o;

    public static final class a {
    }

    public static final class b implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f360937a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        public b(Function0<Unit> r100) {
            this.f360937a = r100;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f360937a.invoke();
        }
    }

    public static final class c {
        public c() {
        }
    }

    static {
    }

    public AbsSubToolbarFragment() {
        this.f360936o = 200;
    }

    @Override // com.larus.office.base.plugins.toolbar.submenu.BaseSubToolbarV2Fragment
    public final DocSubToolbarAdapter W90() {
        Item[] r100 = U90((e) V90().getToolbar().getValue());
        if (r100 != null) goto L5;
        r100 = new Item[0];
    L5:
        DocSubToolbarAdapter r101 = new DocSubToolbarAdapter(r100);
        r101.f360954c = new com.larus.office.base.plugins.toolbar.submenu.a(this);
        r101.f360955d = new com.larus.office.base.plugins.toolbar.submenu.b(this);
        return r101;
    }

    public static View Z90(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public final void ba0(final BasePickerFragment r100) {
        Context r101 = getContext();
        if ((r101 instanceof FragmentActivity) == false) goto L5;
        FragmentActivity r102 = (FragmentActivity) r101;
    L6:
        if (r102 == null) goto L10;
        View r103 = r102.findViewById(R.id.toolbarLayout);
        if (r103 == null) goto L10;
        int r104 = r103.getHeight();
    L11:
        FLogger.f375446a.i("BasePickerFragment", "setHeightOffset() called with: toolBarHeight = " + r104);
        r100.f360863e = r104 + c7.b(10);
        FragmentManager r105 = getChildFragmentManager();
        String r106 = r100.getClass().getSimpleName();
        LandscapeRestrictionOperation r107 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r100, r106, r107);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r105, r100, r107) == false) goto L19;
    L16:
        Intrinsics.checkNotNullParameter(this, "parentFragment");
        getLifecycle().addObserver(new BasePickerFragment$attachToParentFragment$parentLifecycleObserver$1(r100, this));
        Intrinsics.checkNotNullParameter(new c(), "listener");
        return;
    L19:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L18
    L15:
        r100.show(r105, r106);
    L10:
        r104 = c7.b(110);
        goto L11
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.larus.office.base.plugins.toolbar.submenu.BaseSubToolbarV2Fragment
    public final <V> void Y90(Item r100, V r101) {
        super.Y90(r100, r101);
        if (r100 == null) goto L16;
        ItemId r102 = r100.id();
        if (r102 == null) goto L17;
        String r103 = r102.itemName();
        if (r103 != null) goto L10;
        return;
    L10:
        if (Intrinsics.areEqual(r103, "fontName") == false) goto L13;
        ba0(new FontPickerFragment());
        return;
    L13:
        if (Intrinsics.areEqual(r103, "fontColor") == false) goto L19;
        ba0(new ColorPickerTabFragment());
        return;
    L19:
        return;
    L17:
        return;
    }

    public final Animator aa0(View r100, float r101, float r102, float r103, float r104, Function0<Unit> r105) {
        ObjectAnimator r106 = ObjectAnimator.ofFloat(r100, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{r101, r102});
        ObjectAnimator r107 = ObjectAnimator.ofFloat(r100, "alpha", new float[]{r103, r104});
        AnimatorSet r108 = new AnimatorSet();
        r108.playTogether(new Animator[]{r106, r107});
        r108.setDuration(this.f360936o);
        r108.setInterpolator(new DecelerateInterpolator());
        if (r105 == null) goto L5;
        r108.addListener(new b(r105));
    L5:
        return r108;
    }
}
