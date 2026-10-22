package androidx.appcompat.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import com.bytedance.mira.core.opt.res.NewMiraResourcesManager;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class ContextThemeWrapper extends ContextWrapper {
    private LayoutInflater mInflater;
    private Configuration mOverrideConfiguration;
    private Resources mResources;
    private Resources.Theme mTheme;
    private int mThemeResource;

    public ContextThemeWrapper() {
        super(null);
    }

    private Resources getResourcesInternal() {
        if (this.mResources != null) goto L9;
        Configuration r0 = this.mOverrideConfiguration;
        if (r0 != null) goto L7;
        this.mResources = super.getResources();
        goto L9
    L7:
        Context r1 = createConfigurationContext(r0);
        NewMiraResourcesManager.getInstance().install(r1);
        this.mResources = r1.getResources();
    L9:
        return this.mResources;
    }

    private void initializeTheme() {
        if (this.mTheme != null) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        this.mTheme = getResources().newTheme();
        Resources.Theme r1 = getBaseContext().getTheme();
        if (r1 == null) goto L10;
        this.mTheme.setTo(r1);
    L10:
        onApplyThemeResource(this.mTheme, this.mThemeResource, r0);
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme r0 = this.mTheme;
        if (r0 == null) goto L6;
        return r0;
    L6:
        if (this.mThemeResource != 0) goto L8;
        this.mThemeResource = 2131953636;
    L8:
        initializeTheme();
        return this.mTheme;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return getResourcesInternal();
    }

    public int getThemeResId() {
        return this.mThemeResource;
    }

    public static DisplayMetrics INVOKEVIRTUAL_androidx_appcompat_view_ContextThemeWrapper_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r1) {
        return WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
    }

    public void applyOverrideConfiguration(Configuration r2) {
        if (this.mResources != null) goto L11;
        if (this.mOverrideConfiguration != null) goto L9;
        this.mOverrideConfiguration = new Configuration(r2);
        return;
    L9:
        throw new IllegalStateException("Override configuration has already been set");
    L11:
        throw new IllegalStateException("getResources() or getAssets() has already been called");
    }

    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context r1) {
        super.attachBaseContext(r1);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String r2) {
        if ("layout_inflater".equals(r2) == false) goto L10;
        if (this.mInflater != null) goto L8;
        this.mInflater = LayoutInflater.from(getBaseContext()).cloneInContext(this);
    L8:
        return this.mInflater;
    L10:
        return getBaseContext().getSystemService(r2);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int r2) {
        if (this.mThemeResource == r2) goto L6;
        this.mThemeResource = r2;
        initializeTheme();
        return;
    }

    public ContextThemeWrapper(Context r1, int r2) {
        super(r1);
        this.mThemeResource = r2;
    }

    public ContextThemeWrapper(Context r1, Resources.Theme r2) {
        super(r1);
        this.mTheme = r2;
    }

    public void onApplyThemeResource(Resources.Theme r1, int r2, boolean r3) {
        r1.applyStyle(r2, true);
    }
}
