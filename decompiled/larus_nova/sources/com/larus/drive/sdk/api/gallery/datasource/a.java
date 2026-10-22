package com.larus.drive.sdk.api.gallery.datasource;

import com.larus.drive.sdk.api.file.DriveFileItem;
import com.larus.gallery.api.IGalleryDataSource;
import com.larus.gallery.api.k;
import java.util.List;
import kotlin.Pair;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public abstract class a<T> implements IGalleryDataSource<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DriveFileItem f341589a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f341590b;

    @Override // com.larus.gallery.api.IGalleryDataSource
    public final boolean b() {
        return false;
    }

    @Override // com.larus.gallery.api.IGalleryDataSource
    public final Object f(T r100, Continuation<? super T> r101) {
        return r100;
    }

    @Override // com.larus.gallery.api.IGalleryDataSource
    public final boolean h() {
        return true;
    }

    @Override // com.larus.gallery.api.IGalleryDataSource
    public final int k() {
        return this.f341590b;
    }

    public a(DriveFileItem r100) {
        this.f341589a = r100;
        this.f341590b = 10;
    }

    @Override // com.larus.gallery.api.IGalleryDataSource
    public final Object e(List<? extends T> r100, Continuation<? super List<? extends Pair<? extends T, k>>> r101) {
        return IGalleryDataSource.DefaultImpls.c(this, r100, r101);
    }

    @Override // com.larus.gallery.api.IGalleryDataSource
    public final boolean j(T r100, T r101) {
        return Intrinsics.areEqual(r100, r101);
    }
}
