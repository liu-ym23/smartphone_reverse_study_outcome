package com.bytedance.ee.bear.dto;

import android.text.TextUtils;
import com.larksuite.framework.utils.CollectionUtils;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes16.dex */
public class DocImagesForwardData implements Serializable {
    private boolean mCanAddExtraInfo;
    private String mContent;
    private List<String> mFiles;
    private List<String> mImages;
    private boolean mLocalShare;
    private String mSource;
    private String mTitle;

    public DocImagesForwardData() {
    }

    public boolean isEmpty() {
        if (TextUtils.isEmpty(this.mContent) == true) goto L5;
    L9:
        return false;
    L5:
        if (CollectionUtils.isEmpty(this.mImages) == false) goto L9;
        if (CollectionUtils.isEmpty(this.mFiles) == false) goto L9;
        return true;
    }

    public String getContent() {
        return this.mContent;
    }

    public List<String> getFiles() {
        return this.mFiles;
    }

    public List<String> getImages() {
        return this.mImages;
    }

    public String getSource() {
        return this.mSource;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public boolean isCanAddExtraInfo() {
        return this.mCanAddExtraInfo;
    }

    public boolean isLocalShare() {
        return this.mLocalShare;
    }

    public void setCanAddExtraInfo(boolean r100) {
        this.mCanAddExtraInfo = r100;
    }

    public void setContent(String r100) {
        this.mContent = r100;
    }

    public void setFiles(List<String> r100) {
        this.mFiles = r100;
    }

    public void setImages(List<String> r100) {
        this.mImages = r100;
    }

    public void setLocalShare(boolean r100) {
        this.mLocalShare = r100;
    }

    public void setSource(String r100) {
        this.mSource = r100;
    }

    public void setTitle(String r100) {
        this.mTitle = r100;
    }
}
