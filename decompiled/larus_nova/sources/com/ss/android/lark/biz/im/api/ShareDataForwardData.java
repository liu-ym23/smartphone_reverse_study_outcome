package com.ss.android.lark.biz.im.api;

import android.text.TextUtils;
import com.larksuite.framework.utils.CollectionUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes34.dex */
public class ShareDataForwardData implements Serializable {
    private boolean canAddExtraInfo;
    private String content;
    private String extraInfo;
    private boolean forceStandAlone;
    private List<String> images;
    private boolean isSdkShare;
    private boolean isSystemShare;
    private boolean mIncludeExternal;
    private String source;
    private Object sourceData;
    private String title;
    private ArrayList<String> videoCoverPath;
    private Map<String, Long> videos;

    public boolean isEmpty() {
        if (this.sourceData == null) goto L5;
    L11:
        return false;
    L5:
        if (CollectionUtils.isEmpty(this.images) == false) goto L11;
        if (TextUtils.isEmpty(this.content) == false) goto L11;
        if (CollectionUtils.isEmpty(this.videos) == false) goto L11;
        return true;
    }

    public ShareDataForwardData() {
        this.extraInfo = "";
    }

    public boolean canAddExtraInfo() {
        return this.canAddExtraInfo;
    }

    public String getContent() {
        return this.content;
    }

    public String getExtraInfo() {
        return this.extraInfo;
    }

    public List<String> getImages() {
        return this.images;
    }

    public String getSource() {
        return this.source;
    }

    public Object getSourceData() {
        return this.sourceData;
    }

    public String getTitle() {
        return this.title;
    }

    public List<String> getVideoCoverPath() {
        return this.videoCoverPath;
    }

    public Map<String, Long> getVideos() {
        return this.videos;
    }

    public boolean isForceStandAlone() {
        return this.forceStandAlone;
    }

    public boolean isIncludeExternal() {
        return this.mIncludeExternal;
    }

    public boolean isSdkShare() {
        return this.isSdkShare;
    }

    public boolean isSystemShare() {
        return this.isSystemShare;
    }

    public void setCanAddExtraInfo(boolean r100) {
        this.canAddExtraInfo = r100;
    }

    public void setContent(String r100) {
        this.content = r100;
    }

    public void setExtraInfo(String r100) {
        this.extraInfo = r100;
    }

    public void setForceStandAlone(boolean r100) {
        this.forceStandAlone = r100;
    }

    public void setImages(List<String> r100) {
        this.images = r100;
    }

    public void setIncludeExternal(boolean r100) {
        this.mIncludeExternal = r100;
    }

    public void setSdkShare(boolean r100) {
        this.isSdkShare = r100;
    }

    public void setSource(String r100) {
        this.source = r100;
    }

    public void setSourceData(Object r100) {
        this.sourceData = r100;
    }

    public void setSystemShare(boolean r100) {
        this.isSystemShare = r100;
    }

    public void setTitle(String r100) {
        this.title = r100;
    }

    public void setVideoCoverPath(ArrayList<String> r100) {
        this.videoCoverPath = r100;
    }

    public void setVideos(Map<String, Long> r100) {
        this.videos = r100;
    }
}
