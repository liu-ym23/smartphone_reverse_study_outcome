package com.relax.relaxframework;

import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class n2<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r0 f405193a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f405194b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public T f405195c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<? super Function1<? super T, ? extends T>, Unit> f405196d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f405197e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function1<? super Function1<? super Integer, Integer>, Unit> f405198f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final RxElementImpl f405199g;

    public n2(r0 r100, String r101, T r102, Function1<? super Function1<? super T, ? extends T>, Unit> r103, int r104, Function1<? super Function1<? super Integer, Integer>, Unit> r105, RxElementImpl r106) {
        Intrinsics.checkNotNullParameter(r100, RootDescription.ROOT_ELEMENT);
        Intrinsics.checkNotNullParameter(r103, "itemSetter");
        Intrinsics.checkNotNullParameter(r105, "indexSetter");
        Intrinsics.checkNotNullParameter(r106, "element");
        this.f405193a = r100;
        this.f405194b = r101;
        this.f405195c = r102;
        this.f405196d = r103;
        this.f405197e = r104;
        this.f405198f = r105;
        this.f405199g = r106;
    }
}
