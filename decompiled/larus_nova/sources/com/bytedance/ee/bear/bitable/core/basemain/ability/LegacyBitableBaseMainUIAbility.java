package com.bytedance.ee.bear.bitable.core.basemain.ability;

import android.content.res.Configuration;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ee.bear.bitable.core.infoarch.BitableInfoArchManagerNew;
import com.bytedance.ee.bear.bitable.core.infoarch.arch.SceneModel;
import com.bytedance.ee.bear.bitable.core.infoarch.arch.ViewHolder;
import com.bytedance.ee.bear.bitable.core.infoarch.arch.k;
import com.bytedance.ee.bear.bitable.core.infoarch.i;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.BitableNativeViewContainer;
import com.bytedance.ee.bear.bitable.infoarch.top.BitableTopContainer;
import com.bytedance.ee.bear.bitable.infoarch.view.BitableLoadingContainer;
import com.bytedance.ee.bear.bitable.loading.ELoadingType;
import com.bytedance.ee.bear.bitable.plugin.BitableLoadingPlugin;
import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.browser.plugin.MenuItem;
import com.bytedance.ee.bear.browser.plugin.TitleBar;
import com.bytedance.ee.bear.document.DocumentSplitWindowPlugin;
import com.bytedance.ee.util.ui.l;
import com.bytedance.ee.util.ui.n;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tb5.m;

/* JADX INFO: loaded from: classes15.dex */
@Deprecated(level = DeprecationLevel.WARNING, message = "Legacy Bitable BaseMain is pending removal")
public final class LegacyBitableBaseMainUIAbility extends com.bytedance.ee.bear.bitable.core.basemain.ability.d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WebPluginHost f210116c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.ee.bear.bitable.core.f f210117d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ur4.a f210118e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.bytedance.ee.bear.bitable.card.viewmodel.a f210119f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f210120g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f210121h;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f210122a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f210123b = null;

        static {
            int[] r100 = new int[BaseMainOverlayType.values().length];
            r100[BaseMainOverlayType.ITEM_VIEW.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L17:
            r100[BaseMainOverlayType.FORM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L23:
            r100[BaseMainOverlayType.LINKED_DOCUMENT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L7:
            f210122a = r100;
            int[] r101 = new int[BaseMainTitleTagType.values().length];
            r101[BaseMainTitleTagType.EXTERNAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L19:
            r101[BaseMainTitleTagType.TEMPLATE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L10:
            f210123b = r101;
        }
    }

    public static final class c implements TitleBar.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LegacyBitableBaseMainUIAbility f210124a;

        public c(LegacyBitableBaseMainUIAbility r100) {
            this.f210124a = r100;
        }

        @Override // com.bytedance.ee.bear.browser.plugin.TitleBar.b
        public final void onExternalTagChanged(boolean r100) {
            tt5.a.h("LegacyBitableBaseMainUIAbility", "onExternalTagChanged:" + r100);
            this.f210124a.b(BaseMainTitleTagType.EXTERNAL, r100);
        }

        @Override // com.bytedance.ee.bear.browser.plugin.TitleBar.b
        public final void onTemplateTagChanged(boolean r100) {
            tt5.a.h("LegacyBitableBaseMainUIAbility", "onTemplateTagChanged:" + r100);
            this.f210124a.b(BaseMainTitleTagType.TEMPLATE, r100);
        }
    }

    public static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LegacyBitableBaseMainUIAbility f210125a;

        public d(LegacyBitableBaseMainUIAbility r100) {
            this.f210125a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            FragmentActivity r101 = this.f210125a.f210116c.getActivity();
            if (com.bytedance.ee.util.ui.b.a(r101) == false) goto L6;
            r101.onBackPressed();
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.bitable.core.basemain.ability.d, com.bytedance.ee.bear.bitable.core.basemain.ability.b
    public final void W3() {
        com.bytedance.ee.bear.bitable.infoarch.swipe.a r100 = this.f210117d.f210167o.f210191q;
        if (r100 == null) goto L6;
        r100.w0();
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.core.basemain.ability.d, com.bytedance.ee.bear.bitable.core.basemain.ability.b
    public final boolean We() {
        SceneModel r100 = this.f210117d.f210167o.f210184j.f210256b.f210263f;
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.isBitable() != true) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.bytedance.ee.bear.bitable.core.basemain.ability.b
    public final void destroy() {
        ur4.a r100 = this.f210118e;
        if (r100 == null) goto L7;
        com.bytedance.ee.bear.bitable.card.viewmodel.a r101 = this.f210119f;
        if (r101 == null) goto L7;
        Intrinsics.checkNotNullParameter(r100, "listener");
        ((ArrayList) ((com.bytedance.ee.bear.bitable.card.viewmodel.b) r101).f208990a).remove(r100);
    L7:
        this.f210118e = null;
        this.f210119f = null;
    }

    @Override // com.bytedance.ee.bear.bitable.core.basemain.ability.b
    public final void hideLoading() {
        BitableLoadingPlugin r100 = (BitableLoadingPlugin) this.f210116c.findPlugin(BitableLoadingPlugin.class);
        if (r100 == null) goto L6;
        r100.hideLoading();
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.core.basemain.ability.d, com.bytedance.ee.bear.bitable.core.basemain.ability.b
    public final void m1() {
        this.f210117d.f210167o.q();
    }

    @Override // com.bytedance.ee.bear.bitable.core.basemain.ability.b
    public final int z1() {
        return this.f210117d.f210167o.f210178d.getWidth();
    }

    @Override // com.bytedance.ee.bear.bitable.core.basemain.ability.d, com.bytedance.ee.bear.bitable.core.basemain.ability.b
    public final void G7(final com.bytedance.ee.bear.bitable.core.basemain.ability.a r110) {
        Intrinsics.checkNotNullParameter(r110, "config");
        BitableLoadingPlugin r100 = (BitableLoadingPlugin) this.f210116c.findPlugin(BitableLoadingPlugin.class);
        if (r100 != null) goto L5;
        return;
    L5:
        BitableLoadingContainer r101 = this.f210117d.f210167o.f210181g.f210224k;
        ur4.a r102 = null;
        if (r110.f210126a == true) goto L8;
    L19:
        r101.setVisibility(8);
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.d("base.old.form.view.accelerate.v1") == false) goto L22;
        r102 = new ur4.a(this.f210117d.f210167o.f210181g.f210226m, true);
        r100.registerLoadingConainer(a(true));
        BitableInfoArchManagerNew r103 = this.f210117d.f210167o;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r102, "listener");
        ((ArrayList) r103.f210552b).add(r102);
    L23:
        ur4.a r104 = this.f210118e;
        if (r104 == null) goto L28;
        com.bytedance.ee.bear.bitable.card.viewmodel.a r105 = this.f210119f;
        if (r105 == null) goto L28;
        Intrinsics.checkNotNullParameter(r104, "listener");
        ((ArrayList) ((com.bytedance.ee.bear.bitable.card.viewmodel.b) r105).f208990a).remove(r104);
    L28:
        this.f210118e = r102;
        if (r102 == null) goto L33;
        com.bytedance.ee.bear.bitable.card.viewmodel.a r106 = this.f210119f;
        if (r106 == null) goto L33;
        Intrinsics.checkNotNullParameter(r102, "listener");
        ((ArrayList) ((com.bytedance.ee.bear.bitable.card.viewmodel.b) r106).f208990a).add(r102);
    L33:
        r100.registerLoadingSuccessCallbck(new LegacyBitableBaseMainUIAbility$configureLoading$2(this, r110));
        r100.registerLoadingFailsCallback(new LegacyBitableBaseMainUIAbility$configureLoading$3(this));
        return;
    L22:
        r100.registerLoadingConainer(a(false));
        goto L23
    L8:
        if (r110.f210127b == false) goto L10;
    L11:
        r101.setVisibility(0);
        ur4.a r107 = new ur4.a(this.f210117d.f210167o.f210181g.f210226m, false);
        r100.registerLoadingConainer(CollectionsKt.listOf(new com.bytedance.ee.bear.bitable.loading.a[]{r107, r101}));
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.d("base.old.form.view.accelerate.v1") == false) goto L14;
        r102 = r107;
    L14:
        r101.setBackClickListener(new d(this));
        if (r110.f210127b == false) goto L17;
        ELoadingType r108 = ELoadingType.GLOBAL_SHARE_RECORD;
    L18:
        r101.setLoadingType(r108);
        goto L23
    L17:
        r108 = ELoadingType.GLOBAL_BASE_ADD;
        goto L18
    L10:
        if (r110.f210128c == false) goto L19;
        goto L11
    }

    @Override // com.bytedance.ee.bear.bitable.core.basemain.ability.d, com.bytedance.ee.bear.bitable.core.basemain.ability.b
    public final void Od(com.bytedance.ee.bear.bitable.card.viewmodel.a r100) {
        ur4.a r101 = this.f210118e;
        if (r101 == null) goto L7;
        com.bytedance.ee.bear.bitable.card.viewmodel.a r102 = this.f210119f;
        if (r102 == null) goto L7;
        Intrinsics.checkNotNullParameter(r101, "listener");
        ((ArrayList) ((com.bytedance.ee.bear.bitable.card.viewmodel.b) r102).f208990a).remove(r101);
    L7:
        this.f210119f = r100;
        ur4.a r103 = this.f210118e;
        if (r103 == null) goto L12;
        if (r100 == null) goto L13;
        Intrinsics.checkNotNullParameter(r103, "listener");
        ((ArrayList) ((com.bytedance.ee.bear.bitable.card.viewmodel.b) r100).f208990a).add(r103);
        return;
    L13:
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.core.basemain.ability.b
    public final void Sa(Function0<Unit> r100) {
        this.f210117d.f210167o.f210181g.f210219f.setInterceptListener(r100);
    }

    @Override // com.bytedance.ee.bear.bitable.core.basemain.ability.d, com.bytedance.ee.bear.bitable.core.basemain.ability.b
    public final void Vg(TitleBar r100) {
        if (this.f210120g == true) goto L11;
        if (r100 == null) goto L12;
        this.f210120g = true;
        r100.getTitleBarLayout().setLeftIconVisibility(false);
        r100.getTitleBarLayout().setLeftClickListener(null);
        ((LinearLayout) r100.getTitleBarLayout().f240030e).setGravity(16);
        r100.f();
        r100.k(new c(this));
        MenuItem r101 = new MenuItem(DocumentSplitWindowPlugin.BASE_LEFT_BACK, l.a(this.f210116c.getContext(), R.drawable.ud_icon_left_outlined, R.color.facade_selector_icon_n1), DocumentSplitWindowPlugin.BASE_LEFT_BACK);
        r101.setClickListener(new e(this));
        MenuItem r102 = new MenuItem("base_drawer", l.a(this.f210116c.getContext(), R.drawable.ud_icon_slide_outlined, R.color.facade_selector_icon_n1), "base_drawer");
        r102.setClickListener(new f(this));
        r100.j(CollectionsKt.listOf(new MenuItem[]{r101, r102}), TitleBar.MenuType.Left);
        BitableInfoArchManagerNew r103 = this.f210117d.f210167o;
        ot4.c r104 = r103.f210181g.f210229p;
        r104.f526674b = r100;
        View r105 = r104.b();
        if (r105 == null) goto L9;
        r105.setVisibility(8);
    L9:
        r104.f526676d = r103;
        return;
    L12:
        return;
    }

    public final List<com.bytedance.ee.bear.bitable.loading.a> a(boolean r100) {
        ViewHolder r101 = this.f210117d.f210167o.f210181g;
        return CollectionsKt.listOf(new com.bytedance.ee.bear.bitable.loading.a[]{r101.f210220g, r101.f210222i, r101.f210223j, new ur4.a(this.f210117d.f210167o.f210181g.f210226m, r100)});
    }

    @Override // com.bytedance.ee.bear.bitable.core.basemain.ability.d, com.bytedance.ee.bear.bitable.core.basemain.ability.b
    public final void bd(boolean r100) {
        com.bytedance.ee.bear.bitable.infoarch.swipe.a r101 = this.f210117d.f210167o.f210191q;
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.core.basemain.ability.d, com.bytedance.ee.bear.bitable.core.basemain.ability.b
    public final boolean h3(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter("ChameleonBitableFormView", "tag");
        this.f210117d.q("ChameleonBitableFormView", r100);
        return true;
    }

    @Override // com.bytedance.ee.bear.bitable.core.basemain.ability.d, com.bytedance.ee.bear.bitable.core.basemain.ability.b
    public final void ol(boolean r100) {
        this.f210117d.f210167o.f210188n.d(r100);
    }

    @Override // com.bytedance.ee.bear.bitable.core.basemain.ability.d, com.bytedance.ee.bear.bitable.core.basemain.ability.b
    public final void onConfigurationChanged(Configuration r100) {
        BitableInfoArchManagerNew r101 = this.f210117d.f210167o;
        com.bytedance.ee.bear.bitable.core.infoarch.g r102 = r101.f210185k;
        boolean r103 = false;
        if (r100 != null) goto L5;
    L7:
        boolean r104 = false;
    L8:
        r102.f210558f = r104;
        r101.f210181g.f210222i.b();
        nt4.a r105 = r101.f210181g.f210228o;
        boolean r106 = r101.f210185k.f210558f;
        View r107 = r105.f520488a;
        if (r107 != null) goto L11;
    L13:
        if (r103 == false) goto L17;
        View r108 = r105.f520488a;
        if (r108 == null) goto L17;
        r108.setVisibility(8);
    L17:
        BitableNativeViewContainer r109 = r101.f210181g.f210230q;
        boolean r110 = r101.f210185k.f210558f;
        r109.e();
        if (r101.f210185k.f210554b == false) goto L21;
        r101.p();
        return;
    L21:
        return;
    L11:
        if (r107.getVisibility() != 0) goto L13;
        r103 = true;
        goto L13
    L5:
        if (r100.orientation != 2) goto L7;
        r104 = true;
        goto L8
    }

    @Override // com.bytedance.ee.bear.bitable.core.basemain.ability.d, com.bytedance.ee.bear.bitable.core.basemain.ability.b
    public final void ph(m r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        com.bytedance.ee.bear.bitable.infoarch.swipe.a r101 = this.f210117d.f210167o.f210191q;
        if (r101 == null) goto L6;
        r101.b(new com.bytedance.ee.bear.bitable.infoarch.swipe.c(this.f210116c.getActivity(), r100));
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.core.basemain.ability.d, com.bytedance.ee.bear.bitable.core.basemain.ability.b
    public final Integer t5(boolean r100) {
        this.f210117d.f210167o.f210181g.f210219f.setExpanded(false, false);
        ViewHolder r101 = this.f210117d.f210167o.f210181g;
        return Integer.valueOf(r101.b(r100, true) + r101.f210222i.getMeasuredHeight());
    }

    public LegacyBitableBaseMainUIAbility(WebPluginHost r100, com.bytedance.ee.bear.bitable.core.f r101) {
        Intrinsics.checkNotNullParameter(r100, "pluginHost");
        Intrinsics.checkNotNullParameter(r101, KtvSubElement.CONTAINER);
        super(r101.f210167o);
        this.f210116c = r100;
        this.f210117d = r101;
        this.f210121h = LazyKt.lazy(LegacyBitableBaseMainUIAbility$splitWindowManager$2.INSTANCE);
    }

    @Override // com.bytedance.ee.bear.bitable.core.basemain.ability.d, com.bytedance.ee.bear.bitable.core.basemain.ability.b
    public final void Qn(BaseMainOverlayType r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r110, "type");
        int r112 = b.f210122a[r110.ordinal()];
        if (r112 != 1) goto L5;
        com.bytedance.ee.bear.bitable.core.infoarch.arch.f r113 = this.f210117d.f210167o.f210184j;
        r113.f210256b.f210262e = Boolean.valueOf(r111);
        r113.f210255a.f210187m.b();
        return;
    L5:
        if (r112 != 2) goto L7;
        BitableInfoArchManagerNew r114 = this.f210117d.f210167o;
        r114.getClass();
        tt5.a.h("BitableInfoArchManager", "onToggleNewForm " + r111);
        com.bytedance.ee.bear.bitable.core.infoarch.arch.f r115 = r114.f210184j;
        r115.f210256b.f210259b = Boolean.valueOf(r111);
        if (r111 == false) goto L14;
        i.c(r115.f210255a.f210188n, null, false, false, false, false, false, false, false, 240);
    L14:
        k r100 = r115.f210255a.f210182h;
        r100.f210271b = !r111;
        if (r111 == false) goto L17;
        k.b(r100, Boolean.TRUE, null, 2);
    L18:
        ViewHolder r116 = r115.f210255a.f210181g;
        Intrinsics.checkNotNullParameter(r116, "viewHolder");
        ViewGroup r101 = r116.f210216c;
        int r102 = 0;
        if (r111 == false) goto L21;
        int r103 = 8;
    L22:
        r101.setVisibility(r103);
        BitableTopContainer r117 = r116.f210219f;
        if (r111 == false) goto L25;
        r102 = 8;
    L25:
        r117.setVisibility(r102);
        return;
    L21:
        r103 = 0;
        goto L22
    L17:
        k.b(r100, Boolean.FALSE, null, 2);
        goto L18
    L7:
        if (r112 != 3) goto L10;
        this.f210117d.r(r111);
        return;
    L10:
        throw new NoWhenBranchMatchedException();
    }

    public final void b(BaseMainTitleTagType r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        int r102 = b.f210123b[r100.ordinal()];
        boolean r103 = true;
        if (r102 != 1) goto L5;
        this.f210117d.f210167o.f210181g.f210220g.setTitleExternalTagEnabled(r101);
        this.f210117d.f210167o.f210181g.f210227n.getHeader().setTitleExternalTagEnabled(r101);
        return;
    L5:
        if (r102 != 2) goto L22;
        this.f210117d.f210167o.f210181g.f210220g.setTitleTemplateTagEnabled(r101);
        this.f210117d.f210167o.f210181g.f210227n.getHeader().setTitleExternalTagEnabled(r101);
        nt4.a r104 = this.f210117d.f210167o.f210181g.f210228o;
        r104.f520494g = r101;
        View r105 = r104.f520488a;
        if (r105 != null) goto L9;
    L11:
        r103 = false;
    L12:
        if (r103 == true) goto L14;
        return;
    L14:
        if (r104.f520494g == false) goto L26;
        tt5.a.h("BitableViewOnBoardingNewContainer", "update tips position");
        PopupWindow r106 = r104.f520495h;
        if (r106 == null) goto L18;
        PopupWindowLancet.handleDismissBeforeOrigin(r106);
        r106.dismiss();
    L18:
        PopupWindow r107 = r104.f520495h;
        if (r107 == null) goto L27;
        nt4.a.b(r107, r104.f520490c, n.c(60.0f), n.c(175.0f));
        return;
    L27:
        return;
    L26:
        return;
    L9:
        if (r105.getVisibility() != 0) goto L11;
    L22:
        throw new NoWhenBranchMatchedException();
    }
}
