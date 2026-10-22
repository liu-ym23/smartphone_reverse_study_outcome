package com.larus.video.impl.sdk;

import com.larus.platform.api.p0;
import com.ss.ttvideoengine.model.VideoInfo;
import com.ss.ttvideoengine.model.VideoModel;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class a implements p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final VideoModel f375782a;

    public final float a() {
        List<VideoInfo> r100 = this.f375782a.getVideoInfoList();
        if (r100 == null) goto L7;
        VideoInfo r101 = (VideoInfo) CollectionsKt.firstOrNull(r100);
        if (r101 == null) goto L7;
        return r101.mVHeight;
    L7:
        return 0.0f;
    }

    public final float b() {
        List<VideoInfo> r100 = this.f375782a.getVideoInfoList();
        if (r100 == null) goto L7;
        VideoInfo r101 = (VideoInfo) CollectionsKt.firstOrNull(r100);
        if (r101 == null) goto L7;
        return r101.mVWidth;
    L7:
        return 0.0f;
    }

    @Override // com.larus.platform.api.p0
    public final VideoModel getImpl() {
        VideoModel r100 = this.f375782a;
        if (r100 != null) goto L6;
        return null;
    L6:
        return r100;
    }

    public a(VideoModel r100) {
        Intrinsics.checkNotNullParameter(r100, "videoModelImpl");
        this.f375782a = r100;
    }
}
