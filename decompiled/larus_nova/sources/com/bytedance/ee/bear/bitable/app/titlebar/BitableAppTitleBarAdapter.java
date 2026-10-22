package com.bytedance.ee.bear.bitable.app.titlebar;

import android.widget.ImageView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.browser.plugin.MenuItem;
import com.bytedance.ee.bear.browser.plugin.TitleBar;
import com.bytedance.ee.bear.contract.icon.IconInfo;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.a7;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.util.ui.l;
import com.larus.nova.R;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.larkicon.IconScene;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class BitableAppTitleBarAdapter extends a7 {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final MenuItem f206958r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public MutableLiveData<Boolean> f206959s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Observer<CharSequence> f206960t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final boolean f206961u;

    public static final class a {
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitableAppTitleBarAdapter f206962a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LifecycleOwner f206963b;

        public b(BitableAppTitleBarAdapter r100, LifecycleOwner r101) {
            this.f206962a = r100;
            this.f206963b = r101;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Boolean r101 = (Boolean) r100;
            BitableAppTitleBarAdapter r102 = this.f206962a;
            Observer<CharSequence> r103 = r102.f206960t;
            if (r103 == null) goto L9;
            if (r101.booleanValue() == false) goto L7;
            r102.f218654b.getTitle().removeObserver(r103);
            goto L9
        L7:
            r102.f218654b.getDocName().removeObserver(r103);
        L9:
            if (r101.booleanValue() == false) goto L11;
            LiveData r104 = this.f206962a.f218654b.getDocName();
        L12:
            BitableAppTitleBarAdapter r105 = this.f206962a;
            c r106 = new c(r105);
            r105.f206960t = r106;
            r104.observe(this.f206963b, r106);
            int r107 = 0;
            if (r101.booleanValue() == true) goto L15;
        L26:
            boolean r108 = false;
        L27:
            ImageView r109 = this.f206962a.f218659g.getIconView();
            if (r109 == null) goto L42;
            BitableAppTitleBarAdapter r110 = this.f206962a;
            if (r108 == false) goto L40;
            r109.setVisibility(0);
            int r111 = obb.c.f522646p;
            IconInfo r112 = r110.f218654b.getShowingIconInfo().getValue();
            if (r112 == null) goto L34;
            r107 = r112.getType();
        L34:
            IconInfo r113 = r110.f218654b.getShowingIconInfo().getValue();
            if (r113 == null) goto L38;
            String r114 = r113.getKey();
            if (r114 == null) goto L38;
        L39:
            obb.c.a r115 = obb.c.b.a(r107, r114);
            IconScene r116 = IconScene.TODO;
            Intrinsics.checkNotNullParameter(r116, "scene");
            r115.f522674m = r116;
            mbb.c.h(r109, new obb.c(r115));
            return;
        L38:
            r114 = "";
            goto L39
        L40:
            r109.setVisibility(8);
            return;
        L42:
            return;
        L15:
            if (this.f206962a.f218659g.getTitleVisible() == false) goto L26;
            IconInfo r117 = this.f206962a.f218654b.getShowingIconInfo().getValue();
            String r118 = null;
            if (r117 == null) goto L19;
            Integer r119 = Integer.valueOf(r117.getType());
        L20:
            if (r119 == null) goto L26;
            IconInfo r120 = this.f206962a.f218654b.getShowingIconInfo().getValue();
            if (r120 == null) goto L24;
            r118 = r120.getKey();
        L24:
            if (r118 == null) goto L26;
            r108 = true;
            goto L27
        L19:
            r119 = null;
            goto L20
        L11:
            r104 = this.f206962a.f218654b.getTitle();
            goto L12
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.document.a7
    public final float n() {
        return 14.0f;
    }

    @Override // com.bytedance.ee.bear.document.a7
    public final boolean u() {
        return true;
    }

    @Override // com.bytedance.ee.bear.document.a7
    public final int o() {
        return this.f218653a.getActivity().getResources().getDimensionPixelSize(R.dimen.bitable_app_titlebar_height);
    }

    @Override // com.bytedance.ee.bear.document.a7
    public final int p() {
        return this.f218653a.getActivity().getResources().getDimensionPixelSize(R.dimen.bitable_app_titlebar_height);
    }

    @Override // com.bytedance.ee.bear.document.a7
    public final void t(LifecycleOwner r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (this.f206959s != null) goto L6;
        this.f206959s = new MutableLiveData(Boolean.FALSE);
    L6:
        MutableLiveData<Boolean> r101 = this.f206959s;
        if (r101 == null) goto L11;
        r101.observe(r100, new b(this, r100));
        return;
    }

    public BitableAppTitleBarAdapter(a7.c r100, DocViewModel r101) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        Intrinsics.checkNotNullParameter(r101, "documentMetadata");
        super(r100, r101);
        BitableAppTitleBar r102 = null;
        MenuItem r103 = new MenuItem("menu_app_close", l.a(r100.getActivity(), R.drawable.ud_icon_close_small_outlined, R.color.facade_selector_icon_n1), null);
        r103.setClickListener(new com.bytedance.ee.bear.bitable.app.titlebar.b(this));
        this.f206958r = r103;
        LarkAppContext.Companion.getClass();
        boolean r104 = !LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK();
        this.f206961u = r104;
        if (r104 == false) goto L11;
        j(CollectionsKt.mutableListOf(new MenuItem[]{r103}), TitleBar.MenuType.Right);
        BaseTitleBar r105 = this.f218657e;
        if ((r105 instanceof BitableAppTitleBar) == false) goto L7;
        BitableAppTitleBar r106 = (BitableAppTitleBar) r105;
    L8:
        if (r106 == null) goto L10;
        r106.setLeftIconVisibility(false);
    L10:
        this.f218657e.setLeftClickListener(null);
        return;
    L7:
        r106 = null;
        goto L8
    L11:
        BaseTitleBar r107 = this.f218657e;
        if ((r107 instanceof BitableAppTitleBar) == false) goto L14;
        r102 = (BitableAppTitleBar) r107;
    L14:
        if (r102 == null) goto L16;
        r102.setLeftIconVisibility(true);
    L16:
        this.f218657e.setLeftClickListener(new com.bytedance.ee.bear.bitable.app.titlebar.a(r100));
    }

    @Override // com.bytedance.ee.bear.document.a7, com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void j(List<? extends MenuItem> r100, TitleBar.MenuType r101) {
        Object r102 = null;
        if (r100 == null) goto L5;
        List<MenuItem> r103 = CollectionsKt.toMutableList(r100);
    L7:
        if (r101 != TitleBar.MenuType.Left) goto L11;
        if (r103 == null) goto L10;
        CollectionsKt.removeAll(r103, BitableAppTitleBarAdapter$setMenus$1.INSTANCE);
    L10:
        super.j(r103, r101);
        return;
    L11:
        if (r103 != null) goto L14;
        r103 = new ArrayList();
    L14:
        if (this.f206961u == false) goto L27;
        Iterator<T> r104 = r103.iterator();
    L17:
        if (r104.hasNext() == false) goto L25;
        Object r105 = r104.next();
        MenuItem r106 = (MenuItem) r105;
        if (r106 == null) goto L21;
        String r107 = r106.getId();
    L23:
        if (Intrinsics.areEqual(r107, "menu_app_close") == false) goto L17;
        r102 = r105;
        goto L25
    L21:
        r107 = null;
    L25:
        if (r102 != null) goto L27;
        r103.add(this.f206958r);
    L27:
        super.j(r103, r101);
        return;
    L5:
        r103 = null;
        goto L7
    }
}
