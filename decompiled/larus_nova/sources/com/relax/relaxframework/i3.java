package com.relax.relaxframework;

import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class i3<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r0 f405132a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public T f405133b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f405134c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public q2 f405135d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function1<? super Function1<? super T, ? extends T>, Unit> f405136e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function1<? super Function1<? super Integer, Integer>, Unit> f405137f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final RxElementImpl f405138g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f405139h;

    /* JADX WARN: Multi-variable type inference failed */
    public i3(r0 r100, Object r101, int r102, q2 r103, Function1 r104, Function1 r105, RxElementImpl r106) {
        Intrinsics.checkNotNullParameter(r100, RootDescription.ROOT_ELEMENT);
        Intrinsics.checkNotNullParameter(r103, "currentItemProps");
        Intrinsics.checkNotNullParameter(r104, "itemSetter");
        Intrinsics.checkNotNullParameter(r105, "indexSetter");
        Intrinsics.checkNotNullParameter(r106, "element");
        this.f405132a = r100;
        this.f405133b = r101;
        this.f405134c = r102;
        this.f405135d = r103;
        this.f405136e = r104;
        this.f405137f = r105;
        this.f405138g = r106;
        this.f405139h = 0;
    }
}
