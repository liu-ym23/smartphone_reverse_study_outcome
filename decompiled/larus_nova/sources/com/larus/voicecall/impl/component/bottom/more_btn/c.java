package com.larus.voicecall.impl.component.bottom.more_btn;

import android.view.View;
import com.larus.voicecall.impl.video.VideoPreviewState;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import w3a.o;

/* JADX INFO: loaded from: classes32.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f377240a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f377241b;

    public static final class a implements w3a.i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f377242a;

        public a(c r100) {
            this.f377242a = r100;
        }

        @Override // w3a.i
        public final void a(w3a.h r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            if ((r100 instanceof o) == false) goto L6;
            this.f377242a.h(((o) r100).f558209a);
            return;
        L6:
            if ((r100 instanceof w3a.l) == false) goto L10;
            this.f377242a.g(((w3a.l) r100).f558206a);
            return;
        }
    }

    public abstract String b();

    public void c(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
    }

    public void d() {
    }

    public void g(boolean r100) {
    }

    public void h(VideoPreviewState r100) {
        Intrinsics.checkNotNullParameter(r100, "newState");
    }

    public final e3a.a a() {
        w3a.k r100 = this.f377240a.c();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f558201b;
    }

    public void e() {
        w3a.k r100 = this.f377240a.c();
        if (r100 == null) goto L6;
        r100.c(this.f377241b);
        return;
    }

    public void f() {
        w3a.k r100 = this.f377240a.c();
        if (r100 == null) goto L6;
        a r101 = this.f377241b;
        Intrinsics.checkNotNullParameter(r101, "listener");
        r100.f558204e.remove(r101);
        return;
    }

    public c(d r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        this.f377240a = r100;
        this.f377241b = new a(this);
    }

    public final void i(c r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Function1<c, Unit> r101 = this.f377240a.a();
        if (r101 == null) goto L6;
        r101.invoke(r100);
        return;
    }
}
