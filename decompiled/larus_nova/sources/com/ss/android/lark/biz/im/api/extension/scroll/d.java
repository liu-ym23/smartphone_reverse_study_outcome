package com.ss.android.lark.biz.im.api.extension.scroll;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ScrollScene f410234a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function1<? super RecyclerView, Integer> f410235b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function1<? super RecyclerView, Integer> f410236c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ScrollAlign f410237d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f410238e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f410239f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public b f410240g;

    public final ScrollEvent a() {
        return new ScrollEvent(this.f410234a, this.f410235b, this.f410236c, this.f410237d, this.f410238e, this.f410239f, this.f410240g);
    }

    public d(ScrollScene r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        this.f410234a = r100;
    }

    public final void b(final int r100) {
        this.f410236c = new ScrollEventBuilder$offset$2$1(r100);
    }

    public final void c(final int r100) {
        this.f410235b = new ScrollEventBuilder$position$2$1(r100);
    }
}
