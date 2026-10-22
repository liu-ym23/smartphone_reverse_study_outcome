package lw4;

import android.os.Build;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.browser.plugin.MenuItem;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.TitleBar;
import com.bytedance.ee.bear.document.DocumentSplitWindowPlugin;
import com.bytedance.ee.util.ui.l;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.base.embedded.f;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public static final /* synthetic */ int g = 0;
    public final c a;
    public ce5.a b;
    public boolean c;
    public boolean d;
    public final AtomicBoolean e;
    public MenuItem f;

    /* JADX INFO: renamed from: lw4.a$a, reason: collision with other inner class name */
    public static final class C0250a {
    }

    static {
    }

    public a(c r2) {
        Intrinsics.checkNotNullParameter(r2, "expandClickListener");
        this.a = r2;
        int r3 = ce5.a.h;
        this.b = new ce5.a();
        this.e = new AtomicBoolean(false);
    }

    public final MenuItem b(FragmentActivity r4) {
        MenuItem r0 = this.f;
        if (r0 != null) goto L9;
        r0 = new MenuItem();
        r0.setClickListener(new b(this));
        if (com.bytedance.ee.util.ui.a.a(r4) == false) goto L7;
        int r1 = 2131255132;
    L8:
        r0.setId("activity_expand_action");
        r0.setIcon(l.a(r4, r1, 2131101926));
        this.f = r0;
        goto L9
    L7:
        r1 = 2131255063;
    L9:
        return r0;
    }

    public final boolean c(String r3) {
        return this.b.d.isEnable(r3);
    L4:
        e = move-exception;
        tt5.a.d("ActivityExpandWrapper", r3 + " isEnable fail: " + e);
        return false;
    }

    public final void d(PluginHost r3) {
        if (r3 == null) goto L4;
        this.b = new ce5.a(r3.getUserComponent());
        this.f = b(r3.getActivity());
    L4:
        this.c = c("ccm.mobile.android_doc_support_expand_page");
        this.d = c("ccm.mobile.android_doc_disable_expand_page_in_easygo");
    }

    public final void e(TitleBar r6) {
        if (this.e.get() == true) goto L6;
        tt5.a.h("ActivityExpandWrapper", "tryRemoveExpandItemMenu quit, tryAddExpandItemMenu == false");
        return;
    L6:
        if (r6 == null) goto L20;
        TitleBar.MenuType r0 = TitleBar.MenuType.Left;     // Catch: Exception -> L15
        List<MenuItem> r2 = r6.i(r0);     // Catch: Exception -> L15
        int r3 = a(r2, "activity_expand_action");     // Catch: Exception -> L15
        if (r3 >= 0) goto L11;
        return;
    L11:
        if (r2.size() <= r3) goto L13;
        ListProtector.remove(r2, r3);     // Catch: Exception -> L15
    L13:
        r6.j(r2, r0);     // Catch: Exception -> L15
        this.e.set(false);     // Catch: Exception -> L15
        r6.invalidate();     // Catch: Exception -> L15
        return;
    L15:
        e = move-exception;
        tt5.a.d("ActivityExpandWrapper", "tryRemoveExpandItemMenu fail: " + e);
        return;
    }

    public static int a(List r3, String r4) {
        int r0 = r3.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L10;
        MenuItem r2 = (MenuItem) ListProtector.get(r3, r1);
        if (r2 == null) goto L9;
        if (Intrinsics.areEqual(r2.getId(), r4) == false) goto L9;
        return r1;
    L9:
        r1 = r1 + 1;
        goto L3
    L10:
        return -1;
    }

    public final void f(TitleBar r12, FragmentActivity r13) {
        Intrinsics.checkNotNullParameter(r13, "activity");
        if (this.c == true) goto L6;
        tt5.a.k("ActivityExpandWrapper", "updateExpandItemMenu fail, #1 fg is disable");
        return;
    L6:
        tt5.a.h("ActivityExpandWrapper", "isDefaultFoldCheckHit 11: ");
        int r3 = 0;
        if (com.ss.android.lark.base.embedded.b.g() == false) goto L9;
    L12:
        boolean r0 = true;
    L13:
        if (r0 == false) goto L17;
        tt5.a.h("ActivityExpandWrapper", "isDefaultFoldCheckHit: " + r0);
        return;
    L17:
        if (com.ss.android.lark.base.embedded.b.d(r13) == false) goto L23;
        if (this.d == false) goto L23;
        tt5.a.k("ActivityExpandWrapper", "updateExpandItemMenu fail, #2 fg is disable");
        e(r12);
        return;
    L23:
        if (this.a.extraCloseExpandItemMenu(r12, r13) == false) goto L26;
        tt5.a.k("ActivityExpandWrapper", "updateExpandItemMenu fail, extra disable");
        e(r12);
        return;
    L26:
        boolean r1 = ku5.c.k(r13);
        boolean r4 = com.ss.android.lark.base.embedded.b.b(r13);
        if (r13.getResources().getConfiguration().orientation != 2) goto L29;
        boolean r5 = true;
    L31:
        if (Build.VERSION.SDK_INT >= 24) goto L33;
    L35:
        boolean r6 = false;
    L37:
        if (com.bytedance.ee.util.ui.a.a(r13) == false) goto L41;
        if (r5 == false) goto L41;
        if (r6 == true) goto L41;
        boolean r7 = true;
    L42:
        if (r1 == false) goto L46;
        if (r4 == true) goto L45;
        if (r7 == false) goto L46;
    L45:
        boolean r8 = true;
    L47:
        tt5.a.h("ActivityExpandWrapper", "updateExpandItemMenu, isPad=" + r1 + ", embedded=" + r4 + ", isLandscape=" + r5 + ", isInMultiWindowMode=" + r6 + ", isExpandActivity=" + r7 + ", needShowMenu=" + r8);
        if (r8 == true) goto L50;
        e(r12);
        return;
    L50:
        if (this.e.get() == false) goto L52;
        tt5.a.h("ActivityExpandWrapper", "tryAddExpandItemMenu quit, tryAddExpandItemMenu == true");
        return;
    L52:
        if (r12 == null) goto L68;
        TitleBar.MenuType r2 = TitleBar.MenuType.Left;     // Catch: Exception -> L61
        List<MenuItem> r9 = r12.i(r2);     // Catch: Exception -> L61
        if (a(r9, "activity_expand_action") >= 0) goto L69;
        ArrayList r10 = new ArrayList();     // Catch: Exception -> L61
        r10.addAll(r9);     // Catch: Exception -> L61
        int r11 = a(r9, DocumentSplitWindowPlugin.BASE_LEFT_BACK);     // Catch: Exception -> L61
        if (r11 < 0) goto L59;
        r3 = r11;
    L59:
        ListProtector.add(r10, r3, b(r13));     // Catch: Exception -> L61
        r12.j(r10, r2);     // Catch: Exception -> L61
        this.e.set(true);     // Catch: Exception -> L61
        r12.invalidate();     // Catch: Exception -> L61
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
        r8 = false;
    L41:
        r7 = false;
        goto L42
    L33:
        if (r13.isInMultiWindowMode() == false) goto L35;
        r6 = true;
        goto L37
    L29:
        r5 = false;
        goto L31
    L9:
        if (f.a() == true) goto L12;
        r0 = false;
        goto L13
    }
}
