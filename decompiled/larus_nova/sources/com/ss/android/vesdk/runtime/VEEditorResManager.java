package com.ss.android.vesdk.runtime;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes40.dex */
public class VEEditorResManager {
    public String[] mAudioPaths;
    private String mComposedVideoPath;
    private String mCropedAudioPath;
    private String mCropedVideoPath;
    public int mOriginalSoundTrackIndex;
    public int mOriginalSoundTrackType;
    public boolean mReverseAudioDone;
    public String[] mReverseAudioPaths;
    private ArrayList<String> mReverseCacheFiles;
    public boolean mReverseDone;
    public String[] mReverseVideoPath;
    public int mTimeMode;
    public String[] mTransitions;
    public String[] mVideoPaths;
    private String mWorkSpace;

    public void clearReverseCacheFiles() {
        ArrayList<String> r100 = this.mReverseCacheFiles;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.size() <= 0) goto L18;
        Iterator<String> r101 = this.mReverseCacheFiles.iterator();
    L8:
        if (r101.hasNext() == false) goto L19;
        PolarisFileWrapper r102 = new PolarisFileWrapper(r101.next());
        if (r102.exists() == false) goto L8;
        r102.delete();
        goto L8
    L19:
        return;
    }

    public String genComposedVideoPath() {
        return d.b(this.mWorkSpace, "compose") + File.separator + System.currentTimeMillis() + "_composed.mp4";
    }

    public String getWorkspace() {
        return this.mWorkSpace;
    }

    public VEEditorResManager(String r100) {
        this.mReverseDone = false;
        this.mReverseAudioDone = false;
        this.mTimeMode = 0;
        this.mWorkSpace = r100;
        this.mReverseCacheFiles = new ArrayList();
    }

    public String genReverseVideoPath(String r100) {
        String r101 = d.b(this.mWorkSpace, "concat") + File.separator + r100 + "_reverse.mp4";
        this.mReverseCacheFiles.add(r101);
        return r101;
    }

    public String genSeqAudioPath(String r100) {
        String r101 = d.b(this.mWorkSpace, "concat") + File.separator + r100 + "_reverse.wav";
        this.mReverseCacheFiles.add(r101);
        return r101;
    }
}
