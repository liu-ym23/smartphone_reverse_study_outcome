package com.bytedance.creativex.mediaimport.view.internal.main;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.larus.nova.R;
import io.reactivex.subjects.PublishSubject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ti4.u;

/* JADX INFO: loaded from: classes15.dex */
public final class c implements u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f203983a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f203984b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f203985c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f203986d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ViewGroup f203987e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final PublishSubject f203988f;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f203989a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f203990b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f203991c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Function1<? super FrameLayout, ? extends View> f203992d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Function1<? super View, Unit> f203993e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f203994f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Function1<? super FrameLayout, ? extends View> f203995g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Function1<? super View, Unit> f203996h;

        public a() {
            this(null);
        }

        public a(Object r100) {
            this.f203989a = 0;
            this.f203990b = 0;
            this.f203991c = false;
            this.f203992d = null;
            this.f203993e = null;
            this.f203994f = false;
            this.f203995g = null;
            this.f203996h = null;
        }
    }

    @Override // ti4.u
    public final View b() {
        ViewGroup r100 = this.f203987e;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("contentView");
        r100 = null;
    L6:
        return (FrameLayout) r100.findViewById(R.id.fl_right_action);
    }

    @Override // ti4.u
    public final a a() {
        return this.f203986d;
    }

    public c(ViewGroup r100, boolean r101, Function1<? super a, Unit> r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, RootDescription.ROOT_ELEMENT);
        this.f203983a = r100;
        this.f203984b = r101;
        this.f203985c = r103;
        a r104 = new a(null);
        this.f203986d = r104;
        if (r102 == null) goto L5;
        r102.invoke(r104);
    L5:
        this.f203988f = PublishSubject.create();
    }
}
