package kb5;

import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.suite.lark.emm.impl.SCClipboardProvider;
import com.suite.lark.emm.impl.clipboard.utils.TextViewMenuUtilsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a extends ActionMode {
    public final ActionMode a;
    public final Function0<Boolean> b;

    @Override // android.view.ActionMode
    public final void finish() {
        this.a.finish();
    }

    @Override // android.view.ActionMode
    public final View getCustomView() {
        return this.a.getCustomView();
    }

    @Override // android.view.ActionMode
    public final Menu getMenu() {
        return this.a.getMenu();
    }

    @Override // android.view.ActionMode
    public final MenuInflater getMenuInflater() {
        return this.a.getMenuInflater();
    }

    @Override // android.view.ActionMode
    public final CharSequence getSubtitle() {
        return this.a.getSubtitle();
    }

    @Override // android.view.ActionMode
    public final CharSequence getTitle() {
        return this.a.getTitle();
    }

    @Override // android.view.ActionMode
    public final void invalidate() {
        this.a.invalidate();
        if (FeatureGatingModule.getFeatureGatingService().isCurrentEnable("ccm.mobile.menu_display_strategy_opt") == false) goto L13;
        Menu r0 = getMenu();
        boolean r1 = ((Boolean) this.b.invoke()).booleanValue();
        int r2 = r0.size();
        int r4 = 0;
    L5:
        if (r4 >= r2) goto L18;
        MenuItem r5 = r0.getItem(r4);
        Intrinsics.checkNotNull(r5);
        if (TextViewMenuUtilsKt.g(r5) == false) goto L11;
        if (r1 == false) goto L11;
        boolean r6 = false;
    L12:
        r5.setVisible(r6);
        r4 = r4 + 1;
    L11:
        r6 = true;
        goto L12
    L18:
        return;
    L13:
        int r3 = com.suite.lark.emm.impl.a.a;
        com.suite.lark.emm.impl.a.a.a().getClass();
        SCClipboardProvider.a().N0(getMenu());
    }

    @Override // android.view.ActionMode
    public final void setCustomView(View r2) {
        this.a.setCustomView(r2);
    }

    @Override // android.view.ActionMode
    public final void setSubtitle(int r2) {
        this.a.setSubtitle(r2);
    }

    @Override // android.view.ActionMode
    public final void setTitle(int r2) {
        this.a.setTitle(r2);
    }

    @Override // android.view.ActionMode
    public final void setSubtitle(CharSequence r2) {
        this.a.setSubtitle(r2);
    }

    @Override // android.view.ActionMode
    public final void setTitle(CharSequence r2) {
        this.a.setTitle(r2);
    }

    public a(ActionMode r2, Function0<Boolean> r3) {
        Intrinsics.checkNotNullParameter(r2, "mActionMode");
        Intrinsics.checkNotNullParameter(r3, "onInterceptor");
        this.a = r2;
        this.b = r3;
    }
}
