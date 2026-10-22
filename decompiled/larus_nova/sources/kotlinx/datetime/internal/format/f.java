package kotlinx.datetime.internal.format;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public final class f<T> extends h<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final huc.e<T> f505286b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final kotlinx.datetime.internal.format.parser.u<T> f505287c;

    @Override // kotlinx.datetime.internal.format.h, kotlinx.datetime.internal.format.n
    public final huc.e<T> a() {
        return this.f505286b;
    }

    @Override // kotlinx.datetime.internal.format.h, kotlinx.datetime.internal.format.n
    public final kotlinx.datetime.internal.format.parser.u<T> parser() {
        return this.f505287c;
    }

    public f(List<? extends q<? super T>> r100) {
        Intrinsics.checkNotNullParameter(r100, "formats");
        super(r100);
        this.f505286b = super.a();
        this.f505287c = super.parser();
    }
}
