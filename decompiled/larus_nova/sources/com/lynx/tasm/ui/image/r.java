package com.lynx.tasm.ui.image;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.interfaces.SettableDraweeHierarchy;

/* JADX INFO: loaded from: classes32.dex */
public final class r extends BaseDataSubscriber<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f384052a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f384053b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ q f384054c;

    @Override // com.facebook.datasource.BaseDataSubscriber
    public final void onFailureImpl(DataSource<Object> r100) {
        this.f384054c.j(this.f384052a, r100, r100.getFailureCause(), true);
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [T, java.lang.Object] */
    @Override // com.facebook.datasource.BaseDataSubscriber
    public final void onNewResultImpl(DataSource<Object> r110) {
        boolean r100 = r110.isFinished();
        float r101 = r110.getProgress();
        ?? r102 = r110.getResult();
        if (r102 == 0) goto L41;
        q r103 = this.f384054c;
        String r104 = this.f384052a;
        boolean r105 = this.f384053b;
        if (r103.i(r104, r110) == true) goto L8;
        r103.m(r102);
        r110.close();
        return;
    L8:
        if (r103.b(r110, r102) == false) goto L53;
        Drawable r111 = r103.c(r102);     // Catch: Exception -> L39
        T r106 = r103.f384040h;
        Drawable r107 = r103.f384041i;
        r103.f384040h = r102;
        r103.f384041i = r111;
        if (r100 == false) goto L21;
        Animatable r108 = null;
        r103.f384039g = null;     // Catch: Throwable -> L31
        SettableDraweeHierarchy r109 = r103.f384044l;     // Catch: Throwable -> L31
        if (r109 == null) goto L17;
        r109.setImage(r111, 1.0f, r105);     // Catch: Throwable -> L31
    L17:
        ControllerListener r112 = r103.d();     // Catch: Throwable -> L31
        Object r113 = r103.g(r102);     // Catch: Throwable -> L31
        Object r114 = r103.f384041i;     // Catch: Throwable -> L31
        if ((r114 instanceof Animatable) == false) goto L20;
        r108 = (Animatable) r114;     // Catch: Throwable -> L31
    L20:
        r112.onFinalImageSet(r104, r113, r108);     // Catch: Throwable -> L31
    L25:
        if (r107 == null) goto L28;
        if (r107 == r111) goto L28;
        r103.k(r107);
    L28:
        if (r106 == 0) goto L48;
        if (r106 == r102) goto L49;
        r103.m(r106);
        return;
    L49:
        return;
    L48:
        return;
    L21:
        SettableDraweeHierarchy r115 = r103.f384044l;     // Catch: Throwable -> L31
        if (r115 == null) goto L24;
        r115.setImage(r111, r101, r105);     // Catch: Throwable -> L31
    L24:
        r103.d().onIntermediateImageSet(r104, r103.g(r102));     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        if (r107 == null) goto L35;
        if (r107 == r111) goto L35;
        r103.k(r107);
    L35:
        if (r106 == 0) goto L38;
        if (r106 == r102) goto L38;
        r103.m(r106);
    L38:
        throw th;
    L39:
        e = move-exception;
        r103.m(r102);
        r103.j(r104, r110, e, r100);
        return;
    L53:
        return;
    L41:
        if (r100 == false) goto L52;
        this.f384054c.j(this.f384052a, r110, new NullPointerException(), true);
        return;
    }

    @Override // com.facebook.datasource.BaseDataSubscriber, com.facebook.datasource.DataSubscriber
    public final void onProgressUpdate(DataSource<Object> r100) {
        boolean r101 = r100.isFinished();
        float r102 = r100.getProgress();
        q r103 = this.f384054c;
        if (r103.i(this.f384052a, r100) == true) goto L5;
        r100.close();
        return;
    L5:
        if (r101 == true) goto L11;
        SettableDraweeHierarchy r104 = r103.f384044l;
        if (r104 == null) goto L12;
        r104.setProgress(r102, false);
        return;
    L12:
        return;
    }

    public r(q r100, String r101, boolean r102) {
        this.f384054c = r100;
        this.f384052a = r101;
        this.f384053b = r102;
    }
}
