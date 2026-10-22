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

/* JADX INFO: loaded from: classes16.dex */
public final class a extends ActionMode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ActionMode f502210a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Boolean> f502211b;

    @Override // android.view.ActionMode
    public final void finish() {
        this.f502210a.finish();
    }

    @Override // android.view.ActionMode
    public final View getCustomView() {
        return this.f502210a.getCustomView();
    }

    @Override // android.view.ActionMode
    public final Menu getMenu() {
        return this.f502210a.getMenu();
    }

    @Override // android.view.ActionMode
    public final MenuInflater getMenuInflater() {
        return this.f502210a.getMenuInflater();
    }

    @Override // android.view.ActionMode
    public final CharSequence getSubtitle() {
        return this.f502210a.getSubtitle();
    }

    @Override // android.view.ActionMode
    public final CharSequence getTitle() {
        return this.f502210a.getTitle();
    }

    @Override // android.view.ActionMode
    public final void invalidate() {
        this.f502210a.invalidate();
        if (FeatureGatingModule.getFeatureGatingService().isCurrentEnable("ccm.mobile.menu_display_strategy_opt") == false) goto L13;
        Menu r100 = getMenu();
        boolean r101 = this.f502211b.invoke().booleanValue();
        int r102 = r100.size();
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L18;
        MenuItem r104 = r100.getItem(r103);
        Intrinsics.checkNotNull(r104);
        if (TextViewMenuUtilsKt.g(r104) == false) goto L11;
        if (r101 == false) goto L11;
        boolean r105 = false;
    L12:
        r104.setVisible(r105);
        r103 = r103 + 1;
    L11:
        r105 = true;
        goto L12
    L18:
        return;
    L13:
        int r106 = com.suite.lark.emm.impl.a.f460436a;
        com.suite.lark.emm.impl.a.C5524a.a().getClass();
        SCClipboardProvider.a().N0(getMenu());
    }

    @Override // android.view.ActionMode
    public final void setCustomView(View r100) {
        this.f502210a.setCustomView(r100);
    }

    @Override // android.view.ActionMode
    public final void setSubtitle(int r100) {
        this.f502210a.setSubtitle(r100);
    }

    @Override // android.view.ActionMode
    public final void setTitle(int r100) {
        this.f502210a.setTitle(r100);
    }

    @Override // android.view.ActionMode
    public final void setSubtitle(CharSequence r100) {
        this.f502210a.setSubtitle(r100);
    }

    @Override // android.view.ActionMode
    public final void setTitle(CharSequence r100) {
        this.f502210a.setTitle(r100);
    }

    public a(ActionMode r100, Function0<Boolean> r101) {
        Intrinsics.checkNotNullParameter(r100, "mActionMode");
        Intrinsics.checkNotNullParameter(r101, "onInterceptor");
        this.f502210a = r100;
        this.f502211b = r101;
    }
}
