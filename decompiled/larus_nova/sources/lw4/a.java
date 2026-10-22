package lw4;

import android.os.Build;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.browser.plugin.MenuItem;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.TitleBar;
import com.bytedance.ee.bear.document.DocumentSplitWindowPlugin;
import com.bytedance.ee.util.ui.l;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.base.embedded.f;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f511011g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f511012a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ce5.a f511013b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f511014c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f511015d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f511016e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public MenuItem f511017f;

    /* JADX INFO: renamed from: lw4.a$a, reason: collision with other inner class name */
    public static final class C6743a {
    }

    static {
    }

    public a(c r100) {
        Intrinsics.checkNotNullParameter(r100, "expandClickListener");
        this.f511012a = r100;
        int r101 = ce5.a.f23445h;
        this.f511013b = new ce5.a();
        this.f511016e = new AtomicBoolean(false);
    }

    public final MenuItem b(FragmentActivity r100) {
        MenuItem r101 = this.f511017f;
        if (r101 != null) goto L9;
        r101 = new MenuItem();
        r101.setClickListener(new b(this));
        if (com.bytedance.ee.util.ui.a.a(r100) == false) goto L7;
        int r102 = R.drawable.ud_icon_minify_left_outlined;
    L8:
        r101.setId("activity_expand_action");
        r101.setIcon(l.a(r100, r102, R.color.facade_selector_icon_n1));
        this.f511017f = r101;
        goto L9
    L7:
        r102 = R.drawable.ud_icon_magnify_left_outlined;
    L9:
        return r101;
    }

    public final boolean c(String r100) {
        return this.f511013b.f23449d.isEnable(r100);
    L4:
        e = move-exception;
        tt5.a.d("ActivityExpandWrapper", r100 + " isEnable fail: " + e);
        return false;
    }

    public final void d(PluginHost r100) {
        if (r100 == null) goto L4;
        this.f511013b = new ce5.a(r100.getUserComponent());
        this.f511017f = b(r100.getActivity());
    L4:
        this.f511014c = c("ccm.mobile.android_doc_support_expand_page");
        this.f511015d = c("ccm.mobile.android_doc_disable_expand_page_in_easygo");
    }

    public final void e(TitleBar r100) {
        if (this.f511016e.get() == true) goto L6;
        tt5.a.h("ActivityExpandWrapper", "tryRemoveExpandItemMenu quit, tryAddExpandItemMenu == false");
        return;
    L6:
        if (r100 == null) goto L20;
        TitleBar.MenuType r101 = TitleBar.MenuType.Left;     // Catch: Exception -> L15
        List<MenuItem> r102 = r100.i(r101);     // Catch: Exception -> L15
        int r103 = a(r102, "activity_expand_action");     // Catch: Exception -> L15
        if (r103 >= 0) goto L11;
        return;
    L11:
        if (r102.size() <= r103) goto L13;
        ListProtector.remove(r102, r103);     // Catch: Exception -> L15
    L13:
        r100.j(r102, r101);     // Catch: Exception -> L15
        this.f511016e.set(false);     // Catch: Exception -> L15
        r100.invalidate();     // Catch: Exception -> L15
        return;
    L15:
        e = move-exception;
        tt5.a.d("ActivityExpandWrapper", "tryRemoveExpandItemMenu fail: " + e);
        return;
    }

    public static int a(List r100, String r101) {
        int r102 = r100.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L10;
        MenuItem r104 = (MenuItem) ListProtector.get(r100, r103);
        if (r104 == null) goto L9;
        if (Intrinsics.areEqual(r104.getId(), r101) == false) goto L9;
        return r103;
    L9:
        r103 = r103 + 1;
        goto L3
    L10:
        return -1;
    }

    public final void f(TitleBar r110, FragmentActivity r111) {
        Intrinsics.checkNotNullParameter(r111, "activity");
        if (this.f511014c == true) goto L6;
        tt5.a.k("ActivityExpandWrapper", "updateExpandItemMenu fail, #1 fg is disable");
        return;
    L6:
        tt5.a.h("ActivityExpandWrapper", "isDefaultFoldCheckHit 11: ");
        int r100 = 0;
        if (com.ss.android.lark.base.embedded.b.g() == false) goto L9;
    L12:
        boolean r101 = true;
    L13:
        if (r101 == false) goto L17;
        tt5.a.h("ActivityExpandWrapper", "isDefaultFoldCheckHit: " + r101);
        return;
    L17:
        if (com.ss.android.lark.base.embedded.b.d(r111) == false) goto L23;
        if (this.f511015d == false) goto L23;
        tt5.a.k("ActivityExpandWrapper", "updateExpandItemMenu fail, #2 fg is disable");
        e(r110);
        return;
    L23:
        if (this.f511012a.extraCloseExpandItemMenu(r110, r111) == false) goto L26;
        tt5.a.k("ActivityExpandWrapper", "updateExpandItemMenu fail, extra disable");
        e(r110);
        return;
    L26:
        boolean r102 = ku5.c.k(r111);
        boolean r103 = com.ss.android.lark.base.embedded.b.b(r111);
        if (r111.getResources().getConfiguration().orientation != 2) goto L29;
        boolean r104 = true;
    L31:
        if (Build.VERSION.SDK_INT >= 24) goto L33;
    L35:
        boolean r105 = false;
    L37:
        if (com.bytedance.ee.util.ui.a.a(r111) == false) goto L41;
        if (r104 == false) goto L41;
        if (r105 == true) goto L41;
        boolean r106 = true;
    L42:
        if (r102 == false) goto L46;
        if (r103 == true) goto L45;
        if (r106 == false) goto L46;
    L45:
        boolean r107 = true;
    L47:
        tt5.a.h("ActivityExpandWrapper", "updateExpandItemMenu, isPad=" + r102 + ", embedded=" + r103 + ", isLandscape=" + r104 + ", isInMultiWindowMode=" + r105 + ", isExpandActivity=" + r106 + ", needShowMenu=" + r107);
        if (r107 == true) goto L50;
        e(r110);
        return;
    L50:
        if (this.f511016e.get() == false) goto L52;
        tt5.a.h("ActivityExpandWrapper", "tryAddExpandItemMenu quit, tryAddExpandItemMenu == true");
        return;
    L52:
        if (r110 == null) goto L68;
        TitleBar.MenuType r108 = TitleBar.MenuType.Left;     // Catch: Exception -> L61
        List<MenuItem> r109 = r110.i(r108);     // Catch: Exception -> L61
        if (a(r109, "activity_expand_action") >= 0) goto L69;
        ArrayList r112 = new ArrayList();     // Catch: Exception -> L61
        r112.addAll(r109);     // Catch: Exception -> L61
        int r113 = a(r109, DocumentSplitWindowPlugin.BASE_LEFT_BACK);     // Catch: Exception -> L61
        if (r113 < 0) goto L59;
        r100 = r113;
    L59:
        ListProtector.add(r112, r100, b(r111));     // Catch: Exception -> L61
        r110.j(r112, r108);     // Catch: Exception -> L61
        this.f511016e.set(true);     // Catch: Exception -> L61
        r110.invalidate();     // Catch: Exception -> L61
        return;
    L69:
        return;
    L61:
        e = move-exception;
        tt5.a.d("ActivityExpandWrapper", "tryAddExpandItemMenu fail: " + e);
        return;
    L68:
        return;
    L46:
        r107 = false;
    L41:
        r106 = false;
        goto L42
    L33:
        if (r111.isInMultiWindowMode() == false) goto L35;
        r105 = true;
        goto L37
    L29:
        r104 = false;
        goto L31
    L9:
        if (f.a() == true) goto L12;
        r101 = false;
        goto L13
    }
}
