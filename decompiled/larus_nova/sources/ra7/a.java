package ra7;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.view.LayoutInflater;
import qa7.g;

/* JADX INFO: loaded from: classes19.dex */
public class a extends ContextWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f536847a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Resources.Theme f536848b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LayoutInflater f536849c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Resources f536850d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f536851e;

    public final void a() {
        if (this.f536848b != null) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L10;
        this.f536848b = getResources().newTheme();
        Resources.Theme r101 = getBaseContext().getTheme();
        if (r101 == null) goto L10;
        this.f536848b.setTo(r101);
    L10:
        this.f536848b.applyStyle(this.f536847a, true);
        return;
    L5:
        r100 = false;
        goto L6
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (this.f536850d != null) goto L6;
        this.f536850d = super.getResources();
    L6:
        return this.f536850d;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Resources.Theme getTheme() {
        Resources.Theme r100 = this.f536848b;
        if (r100 == null) goto L5;
        return r100;
    L5:
        a();
        return this.f536848b;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final AssetManager getAssets() {
        return getResources().getAssets();
    }

    @Override // android.content.ContextWrapper
    public final void attachBaseContext(Context r100) {
        super.attachBaseContext(r100);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String r100) {
        if ("layout_inflater".equals(r100) == false) goto L10;
        if (this.f536849c != null) goto L8;
        this.f536849c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
    L8:
        return this.f536849c;
    L10:
        return getBaseContext().getSystemService(r100);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void setTheme(int r100) {
        if (this.f536847a == r100) goto L9;
        this.f536847a = r100;
        if (this.f536851e == false) goto L7;
        this.f536848b = null;
        this.f536850d = null;
    L7:
        a();
        return;
    }

    public a(Context r100, Resources.Theme r101) {
        super(r100);
        g.d(r101, "theme can't be null");
        this.f536848b = r101;
        this.f536851e = true;
    }
}
