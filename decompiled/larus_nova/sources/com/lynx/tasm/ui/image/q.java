package com.lynx.tasm.ui.image;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.facebook.common.executors.HandlerExecutorServiceImpl;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.components.DeferredReleaser;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.controller.ForwardingControllerListener;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.drawee.interfaces.SettableDraweeHierarchy;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.utils.UIThreadUtils;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes32.dex */
public abstract class q<T, INFO> implements DeferredReleaser.Releasable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.lynx.tasm.ui.image.a f384033a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f384034b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f384035c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f384036d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile boolean f384037e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f384038f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile DataSource<T> f384039g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public T f384040h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Drawable f384041i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f384042j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ControllerListener<INFO> f384043k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public SettableDraweeHierarchy f384044l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public WeakReference<FlattenUIImage> f384045m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f384046n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f384047o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Object f384048p;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DataSource f384049a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f384050b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ q f384051c;

        @Override // java.lang.Runnable
        public final void run() {
            DataSource r100 = this.f384049a;     // Catch: Throwable -> L14
            if (r100 == null) goto L5;
            r100.close();     // Catch: Throwable -> L14
        L5:
            Object r101 = this.f384050b;     // Catch: Throwable -> L14
            q r102 = this.f384051c;     // Catch: Throwable -> L14
            if (r101 != r102.f384040h) goto L17;
            Drawable r103 = r102.f384041i;     // Catch: Throwable -> L14
            if (r103 == null) goto L10;
            r102.k(r103);     // Catch: Throwable -> L14
        L10:
            r102.f384041i = null;     // Catch: Throwable -> L14
            T r104 = r102.f384040h;     // Catch: Throwable -> L14
            if (r104 == null) goto L21;
            r102.m(r104);     // Catch: Throwable -> L14
            r102.f384040h = null;     // Catch: Throwable -> L14
            return;
        L21:
            return;
        L17:
            return;
        L14:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L22;
            throw th;
        }

        public a(q r100, DataSource r101, Object r102) {
            this.f384051c = r100;
            this.f384049a = r101;
            this.f384050b = r102;
        }
    }

    public static class b<INFO> extends ForwardingControllerListener<INFO> {
        public b() {
        }
    }

    public abstract Drawable c(T r100);

    public abstract DataSource<T> e();

    public abstract INFO g(T r100);

    public abstract void k(Drawable r100);

    public abstract void m(T r100);

    public final ControllerListener<INFO> d() {
        ControllerListener<INFO> r100 = this.f384043k;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return BaseControllerListener.getNoOpListener();
    }

    public final void l() {
        boolean r100 = this.f384036d;
        this.f384036d = false;
        this.f384037e = false;
        DataSource<T> r101 = this.f384039g;
        this.f384039g = null;
        UIThreadUtils.runOnUiThreadImmediately(new a(this, r101, this.f384040h));
        if (r100 == false) goto L6;
        d().onRelease(this.f384047o);
        return;
    }

    public String toString() {
        return Objects.toStringHelper(this).add("isAttached", this.f384035c).add("isRequestSubmitted", this.f384036d).add("hasFetchFailed", this.f384037e).add("fetchedImage", f(this.f384040h)).toString();
    }

    @Override // com.facebook.drawee.components.DeferredReleaser.Releasable
    public final void release() {
        l();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(ControllerListener<? super INFO> r100) {
        ControllerListener<INFO> r101 = this.f384043k;
        if ((r101 instanceof b) == false) goto L6;
        ((b) r101).addListener(r100);
        return;
    L6:
        if (r101 == null) goto L9;
        b r102 = new b();
        r102.addListener(r101);
        r102.addListener(r100);
        this.f384043k = r102;
        return;
    L9:
        this.f384043k = r100;
    }

    public int f(T r100) {
        return System.identityHashCode(r100);
    }

    public final void n(DraweeHierarchy r100) {
        if (this.f384036d == false) goto L6;
        this.f384033a.f383859a.remove(this);
        l();
    L6:
        if (this.f384044l == null) goto L8;
        this.f384044l = null;
    L8:
        if (r100 == null) goto L11;
        Preconditions.checkArgument(r100 instanceof SettableDraweeHierarchy);
        this.f384044l = (SettableDraweeHierarchy) r100;
        return;
    }

    public q(com.lynx.tasm.ui.image.a r100, HandlerExecutorServiceImpl r101) {
        this.f384042j = true;
        this.f384033a = r100;
        this.f384034b = r101;
        h(null, null);
    }

    public final boolean b(DataSource<T> r100, T r101) {
        WeakReference<FlattenUIImage> r102 = this.f384045m;
        if (r102 == null) goto L14;
        FlattenUIImage r103 = r102.get();
        if (r103 != null) goto L7;
        return true;
    L7:
        if (TextUtils.equals(r103.getSource(), this.f384046n) == true) goto L17;
        if (r101 == null) goto L10;
        m(r101);
    L10:
        if (r100 == null) goto L12;
        r100.close();
    L12:
        LLog.i("LynxImage", "image check failed curUrl = " + r103.getSource() + " preUrl = " + this.f384046n);
        return false;
    L17:
        return true;
    L14:
        return true;
    }

    public final void h(String r100, Object r101) {
        if (this.f384042j == true) goto L7;
        com.lynx.tasm.ui.image.a r102 = this.f384033a;
        if (r102 == null) goto L7;
        r102.f383859a.remove(this);
    L7:
        this.f384035c = false;
        l();
        this.f384038f = false;
        this.f384043k = null;
        if (this.f384044l == null) goto L10;
        this.f384044l = null;
    L10:
        this.f384047o = r100;
        this.f384048p = r101;
    }

    public final boolean i(String r100, DataSource<T> r101) {
        if (r101 != null) goto L8;
        if (this.f384039g != null) goto L8;
        return true;
    L8:
        if (r100.equals(this.f384047o) == true) goto L10;
    L14:
        return false;
    L10:
        if (r101 != this.f384039g) goto L14;
        if (this.f384036d == false) goto L14;
        return true;
    }

    public final void j(String r100, DataSource<T> r101, Throwable r102, boolean r103) {
        if (i(r100, r101) == true) goto L7;
        r101.close();
        return;
    L7:
        if (b(r101, null) == true) goto L9;
        return;
    L9:
        if (r103 == false) goto L19;
        this.f384039g = null;
        this.f384037e = true;
        SettableDraweeHierarchy r104 = this.f384044l;
        if (r104 != null) goto L13;
    L18:
        d().onFailure(this.f384047o, r102);
        return;
    L13:
        if (this.f384038f == false) goto L17;
        Drawable r105 = this.f384041i;
        if (r105 == null) goto L17;
        r104.setImage(r105, 1.0f, true);
    L17:
        r104.setFailure(r102);
        goto L18
    L19:
        d().onIntermediateImageFailed(this.f384047o, r102);
    }
}
