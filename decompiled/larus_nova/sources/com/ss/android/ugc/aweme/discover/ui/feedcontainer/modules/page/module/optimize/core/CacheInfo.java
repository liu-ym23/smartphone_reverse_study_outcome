package com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.core;

import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.tasks.TaskResult;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zkc.b;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002R\u0017\u0010\b\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/ui/feedcontainer/modules/page/module/optimize/core/CacheInfo;", ExifInterface.GPS_DIRECTION_TRUE, "", "", "h", "I", "getType", "()I", "type", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CacheInfo<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile RecyclerView.ViewHolder f450707a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Future<TaskResult<RecyclerView.ViewHolder>> f450708b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f450709c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f450710d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f450711e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicBoolean f450712f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f450713g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f450714h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final T f450715i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Long f450716j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final b f450717k;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof CacheInfo) == false) goto L16;
        CacheInfo r101 = (CacheInfo) r100;
        if (this.f450713g == r101.f450713g) goto L8;
        return false;
    L8:
        if (this.f450714h == r101.f450714h) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f450715i, r101.f450715i) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f450716j, r101.f450716j) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f450717k, r101.f450717k) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        int r100 = ((this.f450713g * 31) + this.f450714h) * 31;
        T r101 = this.f450715i;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        Long r105 = this.f450716j;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        b r108 = this.f450717k;
        if (r108 == null) goto L14;
        r102 = r108.hashCode();
    L14:
        return r107 + r102;
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public final String toString() {
        return "CacheInfo(position=" + this.f450713g + ", type=" + this.f450714h + ", data=" + this.f450715i + ", timeout=" + this.f450716j + ", taskInfo=" + this.f450717k + ")";
    }

    public final int getType() {
        return this.f450714h;
    }

    public CacheInfo(int r100, int r101, T r102, Long r103, b r104) {
        this.f450713g = r100;
        this.f450714h = r101;
        this.f450715i = r102;
        this.f450716j = r103;
        this.f450717k = r104;
        this.f450709c = new AtomicBoolean(false);
        this.f450710d = new AtomicBoolean(false);
        this.f450711e = new AtomicBoolean(false);
        new AtomicBoolean(false);
        this.f450712f = new AtomicBoolean(false);
    }
}
