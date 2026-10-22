package io.noties.markwon.ext.onetex;

import android.app.Application;
import android.content.Context;
import com.edu.onetex.OneTeXInitializer;
import com.edu.onetex.latex.LaTeXEngine;
import com.edu.onetex.latex.OneTexConfiguration;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes5.dex */
public final class LaTexHelper implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f492376a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile e f492377b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f492378c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final LaTexHelper f492379d = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f492380a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L5;
        L13:
            return true;
        L5:
            if ((r100 instanceof a) == true) goto L7;
        L12:
            return false;
        L7:
            if (this.f492380a != ((a) r100).f492380a) goto L9;
            boolean r101 = true;
        L10:
            if (r101 == false) goto L12;
        L9:
            r101 = false;
            goto L10
        }

        public final int hashCode() {
            boolean r100 = this.f492380a;
            if (r100 == false) goto L6;
            return 1;
        L6:
            return r100 ? 1 : 0;
        }

        public final String toString() {
            return "LatexInitConfig(supportNewCommand=" + this.f492380a + ")";
        }

        public a(boolean r100) {
            this.f492380a = r100;
        }
    }

    static {
        f492376a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LaTexHelper.class), "executor", "getExecutor$markwon_ext_onetex_release()Ljava/util/concurrent/ThreadPoolExecutor;"))};
        f492379d = new LaTexHelper();
        f492378c = LazyKt.lazy(LaTexHelper$executor$2.INSTANCE);
    }

    public LaTexHelper() {
    }

    @Override // io.noties.markwon.ext.onetex.e
    public final void a(String r100) {
        e r101 = f492377b;
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }

    @Override // io.noties.markwon.ext.onetex.e
    public final void b(long r100) {
        e r101 = f492377b;
        if (r101 == null) goto L6;
        r101.b(r100);
        return;
    }

    @Override // io.noties.markwon.ext.onetex.e
    public final void c(String r100) {
        e r101 = f492377b;
        if (r101 == null) goto L6;
        r101.c(r100);
        return;
    }

    public final void d(Context r110, a r111) {
        Context r100 = null;
        if (r110 == null) goto L5;
        Context r112 = r110.getApplicationContext();
    L7:
        if ((r112 instanceof Application) == false) goto L10;
        r100 = r112;
    L10:
        Application r101 = (Application) r100;
        if (r101 == null) goto L30;
        LaTeXEngine r113 = LaTeXEngine.INSTANCE;
        if (r113.isInitialized() == false) goto L15;
        return;
    L15:
        monitor-enter(this);
    L27:
        th = move-exception;
        throw th;
    L17:
        if (r113.isInitialized() == false) goto L33;
        monitor-exit(this);
        return;
    L33:
        OneTeXInitializer.init(r101);     // Catch: Throwable -> L22
        boolean r102 = r111.f492380a;     // Catch: Throwable -> L22
        r113.setConfig(new OneTexConfiguration(null, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("cosx", "cos"), TuplesKt.to("sinx", "sin"), TuplesKt.to("arcsinx", "arcsin"), TuplesKt.to("arccosx", "arccos")}), r102, r102, false, false, false, 113, null));     // Catch: Throwable -> L22
    L24:
        Unit r114 = Unit.INSTANCE;     // Catch: Throwable -> L27
        monitor-exit(this);
        return;
    L22:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L27
        goto L24
    L30:
        return;
    L5:
        r112 = null;
        goto L7
    }
}
