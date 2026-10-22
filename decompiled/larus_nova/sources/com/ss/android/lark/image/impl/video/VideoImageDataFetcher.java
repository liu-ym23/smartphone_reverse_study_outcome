package com.ss.android.lark.image.impl.video;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.ss.android.lark.image.entity.VideoImage;
import com.ss.android.lark.image.impl.resource.ResourceImageDataFetcher;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.videosend.tools.VideoCoverManager;
import java.io.FileNotFoundException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes36.dex */
public class VideoImageDataFetcher extends ResourceImageDataFetcher<VideoImage> {
    @Override // com.ss.android.lark.image.impl.resource.ResourceImageDataFetcher
    public String getLogTag() {
        return "VideoImageDataFetcher";
    }

    public VideoImageDataFetcher(VideoImage r100) {
        super(r100);
    }

    /* JADX INFO: renamed from: getResourceStream, reason: avoid collision after fix types in other method */
    public InputStream getResourceStream2(VideoImage r100) throws FileNotFoundException {
        long r101 = SystemClock.elapsedRealtime();
        String r102 = r100.getPath();
        String r103 = VideoCoverManager.getVideoCover(UIHelper.getContext(), r102).f444975a;
        long r104 = SystemClock.elapsedRealtime() - r101;
        Log.d(getLogTag(), "getResourceStream: cost=" + r104 + ", coverPath=" + r103 + ", videoPath=" + r102);
        if (TextUtils.isEmpty(r103) == false) goto L7;
        return null;
    L7:
        return new PolarisFileInputStreamWrapper(r103);
    }

    @Override // com.ss.android.lark.image.impl.resource.ResourceImageDataFetcher
    public /* bridge */ /* synthetic */ InputStream getResourceStream(VideoImage r100) throws FileNotFoundException {
        return getResourceStream2(r100);
    }
}
