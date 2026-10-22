package com.bytedance.ee.bear.dto;

import android.text.TextUtils;
import com.larksuite.framework.utils.CollectionUtils;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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

    public void setCanAddExtraInfo(boolean r1) {
        this.mCanAddExtraInfo = r1;
    }

    public void setContent(String r1) {
        this.mContent = r1;
    }

    public void setFiles(List<String> r1) {
        this.mFiles = r1;
    }

    public void setImages(List<String> r1) {
        this.mImages = r1;
    }

    public void setLocalShare(boolean r1) {
        this.mLocalShare = r1;
    }

    public void setSource(String r1) {
        this.mSource = r1;
    }

    public void setTitle(String r1) {
        this.mTitle = r1;
    }
}
