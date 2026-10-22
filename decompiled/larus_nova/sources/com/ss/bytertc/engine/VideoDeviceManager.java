package com.ss.bytertc.engine;

import com.ss.bytertc.engine.utils.LogUtil;
import com.ss.bytertc.engine.video.IVideoDeviceManager;
import com.ss.bytertc.engine.video.VideoDeviceInfo;
import java.util.List;

/* JADX INFO: loaded from: classes40.dex */
public class VideoDeviceManager implements IVideoDeviceManager {
    private static final String TAG = "VideoDeviceManager";
    private long mVideoDevicemanager;

    @Override // com.ss.bytertc.engine.video.IVideoDeviceManager
    public List<VideoDeviceInfo> enumerateVideoCaptureDevices() {
        long r100 = this.mVideoDevicemanager;
        if (r100 != 0) goto L7;
        LogUtil.e(TAG, "native VideoDeviceManager is invalid, enumerateVideoCaptureDevices failed.");
        return null;
    L7:
        return NativeVideoDeviceManagerFunctions.nativeEnumerateVideoCaptureDevices(r100);
    }

    public VideoDeviceManager(long r100) {
        this.mVideoDevicemanager = r100;
    }

    @Override // com.ss.bytertc.engine.video.IVideoDeviceManager
    public int setVideoCaptureDevice(String r100) {
        long r101 = this.mVideoDevicemanager;
        if (r101 != 0) goto L7;
        LogUtil.e(TAG, "native VideoDeviceManager is invalid, setVideoCaptureDevice failed.");
        return -1;
    L7:
        return NativeVideoDeviceManagerFunctions.nativeSetVideoCaptureDevice(r101, r100);
    }
}
