package com.ss.android.vesdk.runtime;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.vesdk.VEException;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes40.dex */
public abstract class VERecorderResManager {
    private String mConcatSegmentAudioPath;
    private String mConcatSegmentVideoPath;
    private String mConcatSementAudioVideoMixedVideoPath;
    private List<String> mSegmentAudioPathList;
    protected String mSegmentDirPath;
    private List<String> mSegmentVideoPathList;
    protected String mWorkspace;

    public abstract String genSegmentAudioPath(int r100);

    public abstract String genSegmentVideoPath(int r100);

    public abstract String getSegmentDirPath();

    public String delSegmentAudioPath() {
        if (this.mSegmentAudioPathList.size() <= 0) goto L6;
        List<String> r100 = this.mSegmentAudioPathList;
        return (String) ListProtector.remove(r100, r100.size() - 1);
    L6:
        return "";
    }

    public String delSegmentVideoPath() throws VEException {
        if (this.mSegmentVideoPathList.size() <= 0) goto L7;
        List<String> r100 = this.mSegmentVideoPathList;
        return (String) ListProtector.remove(r100, r100.size() - 1);
    L7:
        throw new VEException(-105, "segment video list size is 0");
    }

    public void genConcatSegmentAudioPath() {
        this.mConcatSegmentAudioPath = d.b(this.mWorkspace, "concat") + File.separator + "concat.wav";
    }

    public void genConcatSegmentVideoPath() {
        this.mConcatSegmentVideoPath = d.b(this.mWorkspace, "concat") + File.separator + "concat.mp4";
    }

    public String getTempVideoFilePath() {
        return this.mWorkspace + File.separator + "temp.mp4";
    }

    public void release() {
        List<String> r100 = this.mSegmentVideoPathList;
        if (r100 == null) goto L5;
        r100.clear();
        this.mSegmentVideoPathList = null;
    L5:
        List<String> r101 = this.mSegmentAudioPathList;
        if (r101 == null) goto L9;
        r101.clear();
        this.mSegmentAudioPathList = null;
        return;
    }

    public String getConcatSegmentAudioPath() {
        return this.mConcatSegmentAudioPath;
    }

    public String getConcatSegmentVideoPath() {
        return this.mConcatSegmentVideoPath;
    }

    public List<String> getSegmentAudioPathList() {
        return this.mSegmentAudioPathList;
    }

    public List<String> getSegmentVideoPathList() {
        return this.mSegmentVideoPathList;
    }

    public String getWorkspace() {
        return this.mWorkspace;
    }

    public VERecorderResManager(String r100) {
        this.mWorkspace = r100;
        this.mSegmentVideoPathList = new ArrayList();
        this.mSegmentAudioPathList = new ArrayList();
    }

    public void addSegmentAudioPath(String r100) {
        this.mSegmentAudioPathList.add(r100);
    }

    public void addSegmentVideoPath(String r100) {
        this.mSegmentVideoPathList.add(r100);
    }
}
