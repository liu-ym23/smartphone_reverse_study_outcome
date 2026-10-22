package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.widget.Toolbar;
import androidx.autofill.HintConstants;
import com.ss.android.lark.language.service.impl.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u000f\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0012\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0013\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\nH\u0016J\b\u0010\u0017\u001a\u00020\nH\u0016J\b\u0010\u0018\u001a\u00020\nH\u0016J\u0010\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J#\u0010\u001c\u001a\u0004\u0018\u0001H\u001d\"\n\b\u0000\u0010\u001d*\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020\u001bH\u0016¢\u0006\u0002\u0010 J\u0012\u0010!\u001a\u00020\n2\b\u0010\"\u001a\u0004\u0018\u00010\u001eH\u0016J\u0010\u0010!\u001a\u00020\n2\u0006\u0010#\u001a\u00020\u001bH\u0016J\u001c\u0010!\u001a\u00020\n2\b\u0010\"\u001a\u0004\u0018\u00010\u001e2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u001c\u0010&\u001a\u00020\n2\b\u0010\"\u001a\u0004\u0018\u00010\u001e2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(H\u0016J\u0012\u0010*\u001a\u00020\n2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\b\u0010-\u001a\u00020\nH\u0016J\b\u0010.\u001a\u00020\nH\u0016J\n\u0010/\u001a\u0004\u0018\u000100H\u0016J\u0010\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u001bH\u0016J\u0010\u00104\u001a\u0002022\u0006\u00103\u001a\u00020\u001bH\u0016J\u0012\u00105\u001a\u0004\u0018\u0001062\u0006\u00107\u001a\u000208H\u0016J\b\u00109\u001a\u00020\nH\u0016J.\u0010:\u001a\u0004\u0018\u00010\u001e2\b\u0010;\u001a\u0004\u0018\u00010\u001e2\b\u0010<\u001a\u0004\u0018\u00010=2\u0006\u0010)\u001a\u00020(2\u0006\u0010>\u001a\u00020?H\u0016J\u0010\u0010@\u001a\u00020\n2\u0006\u0010A\u001a\u000202H\u0016J\b\u0010B\u001a\u000202H\u0016J\u0012\u0010C\u001a\u00020\n2\b\u0010D\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010E\u001a\u000202H\u0016J\u0010\u0010F\u001a\u00020\n2\u0006\u0010G\u001a\u00020\u001bH\u0016J\b\u0010H\u001a\u00020\u001bH\u0016J\u0010\u0010I\u001a\u00020(2\u0006\u0010)\u001a\u00020(H\u0002J,\u0010J\u001a\u0004\u0018\u00010\u001e2\b\u0010;\u001a\u0004\u0018\u00010\u001e2\u0006\u0010<\u001a\u00020=2\u0006\u0010)\u001a\u00020(2\u0006\u0010>\u001a\u00020?H\u0016J\"\u0010J\u001a\u0004\u0018\u00010\u001e2\u0006\u0010<\u001a\u00020=2\u0006\u0010)\u001a\u00020(2\u0006\u0010>\u001a\u00020?H\u0016R\u000e\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006K"}, d2 = {"Landroidx/appcompat/app/BaseContextWrapperDelegate;", "Landroidx/appcompat/app/AppCompatDelegate;", "Landroid/view/LayoutInflater$Factory2;", "superDelegate", "<init>", "(Landroidx/appcompat/app/AppCompatDelegate;)V", "factory2", "getSupportActionBar", "Landroidx/appcompat/app/ActionBar;", "setSupportActionBar", "", "toolbar", "Landroidx/appcompat/widget/Toolbar;", "getMenuInflater", "Landroid/view/MenuInflater;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPostCreate", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onStart", "onStop", "onPostResume", "setTheme", "themeResId", "", "findViewById", "T", "Landroid/view/View;", "id", "(I)Landroid/view/View;", "setContentView", "v", "resId", "lp", "Landroid/view/ViewGroup$LayoutParams;", "addContentView", "attachBaseContext2", "Landroid/content/Context;", "context", "setTitle", "title", "", "invalidateOptionsMenu", "onDestroy", "getDrawerToggleDelegate", "Landroidx/appcompat/app/ActionBarDrawerToggle$Delegate;", "requestWindowFeature", "", "featureId", "hasWindowFeature", "startSupportActionMode", "Landroidx/appcompat/view/ActionMode;", "callback", "Landroidx/appcompat/view/ActionMode$Callback;", "installViewFactory", "createView", "parent", HintConstants.AUTOFILL_HINT_NAME, "", "attrs", "Landroid/util/AttributeSet;", "setHandleNativeActionModesEnabled", "enabled", "isHandleNativeActionModesEnabled", "onSaveInstanceState", "outState", "applyDayNight", "setLocalNightMode", "mode", "getLocalNightMode", "wrap", "onCreateView", "language_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BaseContextWrapperDelegate extends AppCompatDelegate implements LayoutInflater.Factory2 {
    private final LayoutInflater.Factory2 factory2;
    private final AppCompatDelegate superDelegate;

    public boolean applyDayNight() {
        return this.superDelegate.applyDayNight();
    }

    public ActionBarDrawerToggle.Delegate getDrawerToggleDelegate() {
        return this.superDelegate.getDrawerToggleDelegate();
    }

    public int getLocalNightMode() {
        return this.superDelegate.getLocalNightMode();
    }

    public MenuInflater getMenuInflater() {
        return this.superDelegate.getMenuInflater();
    }

    public ActionBar getSupportActionBar() {
        return this.superDelegate.getSupportActionBar();
    }

    public void installViewFactory() {
        this.superDelegate.installViewFactory();
    }

    public void invalidateOptionsMenu() {
        this.superDelegate.invalidateOptionsMenu();
    }

    public boolean isHandleNativeActionModesEnabled() {
        return this.superDelegate.isHandleNativeActionModesEnabled();
    }

    public void onDestroy() {
        this.superDelegate.onDestroy();
        AppCompatDelegate.removeActivityDelegate(this);
    }

    public void onPostResume() {
        this.superDelegate.onPostResume();
    }

    public void onStart() {
        this.superDelegate.onStart();
    }

    public void onStop() {
        this.superDelegate.onStop();
    }

    public BaseContextWrapperDelegate(AppCompatDelegate r2) {
        Intrinsics.checkNotNullParameter(r2, "superDelegate");
        this.superDelegate = r2;
        if ((r2 instanceof LayoutInflater.Factory2) == false) goto L5;
        LayoutInflater.Factory2 r3 = (LayoutInflater.Factory2) r2;
    L6:
        this.factory2 = r3;
        return;
    L5:
        r3 = null;
        goto L6
    }

    private final Context wrap(Context r2) {
        int r0 = a.f;
        return a.b.a.j(r2);
    }

    public Context attachBaseContext2(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return wrap(this.superDelegate.attachBaseContext2(super.attachBaseContext2(r2)));
    }

    public <T extends View> T findViewById(int r2) {
        return (T) this.superDelegate.findViewById(r2);
    }

    public boolean hasWindowFeature(int r2) {
        return this.superDelegate.hasWindowFeature(r2);
    }

    public void onConfigurationChanged(Configuration r2) {
        this.superDelegate.onConfigurationChanged(r2);
    }

    public void onCreate(Bundle r2) {
        this.superDelegate.onCreate(r2);
        AppCompatDelegate.removeActivityDelegate(this.superDelegate);
        AppCompatDelegate.addActiveDelegate(this);
    }

    public void onPostCreate(Bundle r2) {
        this.superDelegate.onPostCreate(r2);
    }

    public void onSaveInstanceState(Bundle r2) {
        this.superDelegate.onSaveInstanceState(r2);
    }

    public boolean requestWindowFeature(int r2) {
        return this.superDelegate.requestWindowFeature(r2);
    }

    public void setContentView(int r2) {
        this.superDelegate.setContentView(r2);
    }

    public void setHandleNativeActionModesEnabled(boolean r2) {
        this.superDelegate.setHandleNativeActionModesEnabled(r2);
    }

    public void setLocalNightMode(int r2) {
        this.superDelegate.setLocalNightMode(r2);
    }

    public void setSupportActionBar(Toolbar r2) {
        this.superDelegate.setSupportActionBar(r2);
    }

    public void setTheme(int r2) {
        this.superDelegate.setTheme(r2);
    }

    public void setTitle(CharSequence r2) {
        this.superDelegate.setTitle(r2);
    }

    public ActionMode startSupportActionMode(ActionMode.Callback r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        return this.superDelegate.startSupportActionMode(r2);
    }

    public void setContentView(View r2) {
        this.superDelegate.setContentView(r2);
    }

    public void addContentView(View r2, ViewGroup.LayoutParams r3) {
        this.superDelegate.addContentView(r2, r3);
    }

    public void setContentView(View r2, ViewGroup.LayoutParams r3) {
        this.superDelegate.setContentView(r2, r3);
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String r2, Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r2, HintConstants.AUTOFILL_HINT_NAME);
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "attrs");
        LayoutInflater.Factory2 r0 = this.factory2;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.onCreateView(r2, r3, r4);
    }

    public View createView(View r2, String r3, Context r4, AttributeSet r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "attrs");
        return this.superDelegate.createView(r2, r3, r4, r5);
    }

    @Override // android.view.LayoutInflater.Factory2
    public View onCreateView(View r2, String r3, Context r4, AttributeSet r5) {
        Intrinsics.checkNotNullParameter(r3, HintConstants.AUTOFILL_HINT_NAME);
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "attrs");
        LayoutInflater.Factory2 r0 = this.factory2;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.onCreateView(r2, r3, r4, r5);
    }
}
