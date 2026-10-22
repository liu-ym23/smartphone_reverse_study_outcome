package h88;

import android.view.View;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes24.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f484289a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f484290b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f484291c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function0<? extends b> f484292d;

    public void c() {
    }

    public abstract void d(boolean r100);

    public abstract String getType();

    public d() {
        this.f484290b = true;
    }

    public void a(boolean r100) {
        this.f484290b = r100;
        View r101 = this.f484289a;
        if (r101 == null) goto L9;
        if (r100 == false) goto L6;
        float r102 = 1.0f;
    L7:
        r101.setAlpha(r102);
        return;
    L6:
        r102 = 0.4f;
        goto L7
    }

    public void b(boolean r100) {
        this.f484291c = r100;
        View r101 = this.f484289a;
        if (r101 == null) goto L6;
        r101.setSelected(r100);
        return;
    }
}
