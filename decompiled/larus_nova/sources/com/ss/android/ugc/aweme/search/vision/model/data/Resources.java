package com.ss.android.ugc.aweme.search.vision.model.data;

import androidx.exifinterface.media.ExifInterface;
import com.ss.android.ugc.aweme.search.model.commodity.CommodityResultParam;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/ss/android/ugc/aweme/search/vision/model/data/Resources;", ExifInterface.GPS_DIRECTION_TRUE, "", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class Resources<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f453627a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Exception f453628b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Status f453629c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CommodityResultParam f453630d;

    public final void a(Status r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f453629c = r100;
    }

    public Resources(T r100, Exception r101, Status r102, CommodityResultParam r103) {
        Intrinsics.checkNotNullParameter(r102, "status");
        this.f453627a = r100;
        this.f453628b = r101;
        this.f453629c = r102;
        this.f453630d = r103;
    }

    public /* synthetic */ Resources(Object r100, Status r101, CommodityResultParam r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 8) == 0) goto L8;
        r102 = null;
    L8:
        this(r100, null, r101, r102);
    }
}
