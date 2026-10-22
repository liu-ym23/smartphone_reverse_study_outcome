package com.bytedance.ee.bear.bitable.infoarch.nativeview.container;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewbinding.ViewBindings;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ee.bear.bitable.core.infoarch.arch.ThemeBackgroundView;
import com.bytedance.ee.bear.bitable.core.infoarch.arch.i;
import com.bytedance.ee.bear.bitable.databinding.BitableNativeFullTableFragmentLayoutBinding;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.BitableNativeViewContainer;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.BaseViewData;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.BitableNativeViewData;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.TitleBar;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.UIExtension;
import com.bytedance.ee.bear.bitable.infoarch.titlebar.BitableBaseTitleBar;
import com.bytedance.ee.bear.bitable.panel.EPanelItemIcon;
import com.bytedance.ee.bear.bitable.panel.Icon;
import com.bytedance.ee.bear.bitable.uikit.Action;
import com.bytedance.ee.bear.browser.plugin.MenuItem;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.l;
import com.larus.nova.R;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import tb5.m;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0081\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0012\u0018\u0000 72\u00020\u00012\u00020\u0002:\u000267B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u001a\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u001b2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010%\u001a\u00020#H\u0016J\f\u0010&\u001a\u00020'*\u00020\u001bH\u0002J\u0018\u0010(\u001a\u00020#2\u0006\u0010)\u001a\u00020\b2\b\u0010*\u001a\u0004\u0018\u00010\nJ\u0018\u0010(\u001a\u00020#2\u0006\u0010)\u001a\u00020\b2\u0006\u0010+\u001a\u00020,H\u0002J\u0018\u0010-\u001a\u00020#2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0002J\u0010\u00102\u001a\u00020#2\u0006\u00100\u001a\u000201H\u0002J\u000e\u00103\u001a\u00020#2\u0006\u00104\u001a\u00020\fJ\b\u00105\u001a\u00020\u0015H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u00068"}, d2 = {"Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/container/BitableFullTableFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "Lcom/bytedance/ee/bear/IFullScreenPage;", "<init>", "()V", RootDescription.ROOT_ELEMENT, "Lcom/bytedance/ee/bear/bitable/databinding/BitableNativeFullTableFragmentLayoutBinding;", "nativeViewData", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/BitableNativeViewData;", "bridgeCallback", "Lcom/bytedance/ee/bear/jsbridge/CallBackFunction;", "onDismissListener", "Landroid/content/DialogInterface$OnDismissListener;", "titleBarInsetState", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/container/BitableFullTableFragment$TitleBarInsetState;", "fragmentLayoutChangeListener", "Landroid/view/View$OnLayoutChangeListener;", "actionHandler", "com/bytedance/ee/bear/bitable/infoarch/nativeview/container/BitableFullTableFragment$actionHandler$1", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/container/BitableFullTableFragment$actionHandler$1;", "inApp", "", "getInApp", "()Z", "setInApp", "(Z)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onDestroyView", "topInWindow", "", "setData", "data", "callback", "handle", "Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;", "setThemeBackground", "themeBg", "Landroid/widget/ImageView;", "theme", "Lcom/bytedance/ee/bear/bitable/core/infoarch/arch/ThemeModel;", "setThemeType", "setDismissListener", "listener", "onBackPressed", "TitleBarInsetState", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableFullTableFragment extends BaseFragment implements l {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f213394m = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public BitableNativeFullTableFragmentLayoutBinding f213395e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public BitableNativeViewData f213396f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public m f213397g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public DialogInterface.OnDismissListener f213398h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public b f213399i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final d f213400j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final c f213401k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f213402l;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Function1<Integer, Unit> f213403a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Integer f213404b;

        /* JADX WARN: Multi-variable type inference failed */
        public b(Function1<? super Integer, Unit> r100) {
            Intrinsics.checkNotNullParameter(r100, "applyTopMargin");
            this.f213403a = r100;
        }
    }

    public static final class c implements gv4.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitableFullTableFragment f213405a;

        public c(BitableFullTableFragment r100) {
            this.f213405a = r100;
        }

        @Override // gv4.a
        public final void a(Action r100) {
            Intrinsics.checkNotNullParameter(r100, "action");
            tt5.a.h("BitableFullTableFragment", "SetFullTableView: onProduce " + r100.getAction());
            m r101 = this.f213405a.f213397g;
            if (r101 == null) goto L6;
            r101.a(r100);
            return;
        }
    }

    public static final class d implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitableFullTableFragment f213406a;

        public d(BitableFullTableFragment r100) {
            this.f213406a = r100;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
            b r109 = this.f213406a.f213399i;
            if (r109 == null) goto L9;
            Intrinsics.checkNotNull(r100);
            int[] r110 = new int[2];
            r100.getLocationInWindow(r110);
            int r111 = r110[1];
            Integer r112 = r109.f213404b;
            if (r112 == null) goto L10;
            if (r112 == null) goto L11;
            int r113 = r112.intValue();
            Function1<Integer, Unit> r114 = r109.f213403a;
            int r115 = BitableFullTableFragment.f213394m;
            r114.invoke(Integer.valueOf(RangesKt.coerceAtLeast(r113 - r111, 0)));
            return;
        L11:
            return;
        L10:
            return;
        }
    }

    public static final class e implements OnApplyWindowInsetsListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitableFullTableFragment f213407a;

        public e(BitableFullTableFragment r100) {
            this.f213407a = r100;
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public final WindowInsetsCompat onApplyWindowInsets(View r100, WindowInsetsCompat r101) {
            Intrinsics.checkNotNullParameter(r100, "fragmentView");
            Intrinsics.checkNotNullParameter(r101, "insets");
            int r102 = r101.getInsets(WindowInsetsCompat.Type.statusBars() | WindowInsetsCompat.Type.displayCutout()).top;
            b r103 = this.f213407a.f213399i;
            if (r103 == null) goto L7;
            int[] r104 = new int[2];
            r100.getLocationInWindow(r104);
            int r105 = r104[1];
            Integer r106 = Integer.valueOf(r102);
            r103.f213404b = r106;
            if (r106 == null) goto L7;
            int r107 = r106.intValue();
            Function1<Integer, Unit> r108 = r103.f213403a;
            int r109 = BitableFullTableFragment.f213394m;
            r108.invoke(Integer.valueOf(RangesKt.coerceAtLeast(r107 - r105, 0)));
        L7:
            return r101;
        }
    }

    public static final class f implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitableFullTableFragment f213408a;

        public f(BitableFullTableFragment r100) {
            this.f213408a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f213408a.onBackPressed();
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, sa5.d
    public final boolean onBackPressed() {
        tt5.a.h("BitableFullTableFragment", "SetFullTableView: onDismiss");
        BitableNativeViewData r100 = this.f213396f;
        if (r100 == null) goto L15;
        BaseViewData<?, ?> r101 = r100.getData();
        if (r101 == null) goto L15;
        UIExtension r102 = r101.getUiExtension();
        if (r102 == null) goto L15;
        TitleBar r103 = r102.getTitleBar();
        if (r103 == null) goto L15;
        Icon r104 = r103.getLeftIcon();
        if (r104 == null) goto L15;
        String r105 = r104.getClickAction();
        if (r105 == null) goto L15;
        this.f213401k.a(new Action(null, r105, 1, null));
    L15:
        DialogInterface.OnDismissListener r106 = this.f213398h;
        if (r106 == null) goto L18;
        r106.onDismiss(null);
    L18:
        return true;
    }

    public BitableFullTableFragment() {
        this.f213400j = new d(this);
        this.f213401k = new c(this);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        View r100 = getView();
        if (r100 == null) goto L5;
        r100.removeOnLayoutChangeListener(this.f213400j);
        ViewCompat.setOnApplyWindowInsetsListener(r100, null);
    L5:
        this.f213399i = null;
        this.f213395e = null;
        super.onDestroyView();
    }

    public final void U90(BitableNativeViewData r110, gv4.a r111) {
        BitableNativeFullTableFragmentLayoutBinding r100 = this.f213395e;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.f210963b.j(getActivity(), r110, r111, this.f213397g, true);
        BaseViewData<?, ?> r112 = r110.getData();
        if (r112 == null) goto L70;
        UIExtension r113 = r112.getUiExtension();
        if (r113 == null) goto L73;
        TitleBar r114 = r113.getTitleBar();
        if (r114 != null) goto L13;
        return;
    L13:
        if (this.f213402l == false) goto L15;
        r100.f210964c.setLeftTextSize(17.0f);
        r100.f210964c.setLeftText(r114.getTitle());
    L16:
        r100.f210964c.setLeftClickListener(new f(this));
        int r101 = i.f210264c;
        if (i.a.a() == false) goto L72;
        BitableBaseTitleBar r102 = r100.f210964c;
        List r115 = CollectionsKt.listOfNotNull(r114.getRightIcon());
        com.bytedance.ee.bear.browser.plugin.TitleBar.MenuType r103 = com.bytedance.ee.bear.browser.plugin.TitleBar.MenuType.Right;
        boolean r104 = this.f213402l;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "type");
        Intrinsics.checkNotNullParameter(r111, "actionHandler");
        if (r103 != com.bytedance.ee.bear.browser.plugin.TitleBar.MenuType.Left) goto L21;
        r102.f();
    L22:
        List r105 = r115;
        if (r105 != null) goto L25;
    L28:
        boolean r106 = true;
    L29:
        if (r106 == true) goto L53;
        Iterator r116 = r115.iterator();
    L32:
        if (r116.hasNext() == false) goto L53;
        Icon r107 = (Icon) r116.next();
        if (r107 == null) goto L32;
        String r108 = r107.getUdKey();
        if (r108 == null) goto L32;
        int r109 = EPanelItemIcon.getDrawableId(r102.getContext(), r108);
        String r117 = r107.getId();
        if (r117 != null) goto L40;
        r117 = r107.getUdKey();
    L40:
        Drawable r118 = AppCompatResources.getDrawable(r102.getContext(), r109);
        if (r118 == null) goto L32;
        Context r119 = r102.getContext();
        MenuItem r120 = new MenuItem(r117, r118, "");
        r120.setClickListener(new ot4.a(r107, (c) r111));
        ot4.e r121 = ot4.f.a(r119, r120, r104);
        if (r121 == null) goto L32;
        r121.f240048a = r117;
        int r122 = BitableBaseTitleBar.a.f213693a[r103.ordinal()];
        if (r122 != 1) goto L48;
        r102.a(r121, false);
        goto L32
    L48:
        if (r122 != 2) goto L51;
        r102.a(r121, true);
        goto L32
    L51:
        throw new NoWhenBranchMatchedException();
    L53:
        r102.b();
        return;
    L25:
        if (r105.isEmpty() == true) goto L28;
        r106 = false;
        goto L29
    L21:
        r102.g();
        goto L22
    L72:
        return;
    L15:
        r100.f210964c.setTitle(r114.getTitle());
        goto L16
    L73:
        return;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        this.f213399i = new b(new AnonymousClass1(this));
        ViewCompat.setOnApplyWindowInsetsListener(r100, new e(this));
        r100.addOnLayoutChangeListener(this.f213400j);
        ViewCompat.requestApplyInsets(r100);
        BitableNativeViewData r102 = this.f213396f;
        if (r102 == null) goto L6;
        U90(r102, this.f213401k);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = LayoutInflater.from(getContext()).inflate(R.layout.bitable_native_full_table_fragment_layout, r101, false);
        int r104 = R.id.nativeViewContainer;
        BitableNativeViewContainer r105 = (BitableNativeViewContainer) ViewBindings.findChildViewById(r103, R.id.nativeViewContainer);
        if (r105 == null) goto L11;
        r104 = R.id.themeBg;
        if (((ThemeBackgroundView) ViewBindings.findChildViewById(r103, R.id.themeBg)) == null) goto L11;
        r104 = R.id.titlbar;
        BitableBaseTitleBar r106 = (BitableBaseTitleBar) ViewBindings.findChildViewById(r103, R.id.titlbar);
        if (r106 == null) goto L11;
        ConstraintLayout r107 = (ConstraintLayout) r103;
        this.f213395e = new BitableNativeFullTableFragmentLayoutBinding(r107, r105, r106);
        return r107;
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r103.getResources().getResourceName(r104)));
    }
}
