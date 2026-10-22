package com.lynx.tasm.ui.image;

import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Supplier;
import com.facebook.datasource.DataSource;

/* JADX INFO: loaded from: classes32.dex */
public final class s implements Supplier<DataSource<Object>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q f384055a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f384056b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f384057c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ LynxAbstractDraweeControllerBuilder.CacheLevel f384058d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ LynxAbstractDraweeControllerBuilder f384059e;

    @Override // com.facebook.common.internal.Supplier
    public final DataSource<Object> get() {
        return this.f384059e.a(this.f384055a, this.f384056b, this.f384057c, this.f384058d);
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("request", this.f384056b.toString()).toString();
    }

    public s(LynxAbstractDraweeControllerBuilder r100, u r101, String r102, Object r103, Object r104, LynxAbstractDraweeControllerBuilder.CacheLevel r105) {
        this.f384059e = r100;
        this.f384055a = r101;
        this.f384056b = r103;
        this.f384057c = r104;
        this.f384058d = r105;
    }
}
