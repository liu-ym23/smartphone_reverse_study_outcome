package com.ss.android.ugc.aweme.search.common.chunk;

import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.reflect.KFunction;
import od6.a;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/chunk/ChunkHandler;", ExifInterface.GPS_DIRECTION_TRUE, "", "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ChunkHandler<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a<T> f451585a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<KFunction<Boolean>> f451586b;

    public ChunkHandler() {
        this.f451585a = new a();
        this.f451586b = CollectionsKt.listOf(new KFunction[]{new ChunkHandler$steps$1(this), new ChunkHandler$steps$2(this)});
    }
}
