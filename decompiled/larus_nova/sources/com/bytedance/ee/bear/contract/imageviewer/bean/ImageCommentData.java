package com.bytedance.ee.bear.contract.imageviewer.bean;

import com.bytedance.ee.util.io.NonProguard;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes16.dex */
public class ImageCommentData implements NonProguard {
    private Map<String, ImageCommentInfo> mImageCommentDataMap;

    public static class ImageCommentInfo implements NonProguard {
        private int commentCount;
        private boolean commentable;

        public ImageCommentInfo() {
        }

        public int getCommentCount() {
            return this.commentCount;
        }

        public boolean isCommentable() {
            return this.commentable;
        }

        public void setCommentCount(int r100) {
            this.commentCount = r100;
        }

        public void setCommentable(boolean r100) {
            this.commentable = r100;
        }
    }

    public ImageCommentData() {
        this.mImageCommentDataMap = new HashMap();
    }

    public Map<String, ImageCommentInfo> getImageCommentDataMap() {
        return this.mImageCommentDataMap;
    }

    public void setCommentInfo(String r100, boolean r101, int r102) {
        ImageCommentInfo r103 = this.mImageCommentDataMap.get(r100);
        if (r103 != null) goto L5;
        r103 = new ImageCommentInfo();
        this.mImageCommentDataMap.put(r100, r103);
    L5:
        r103.setCommentable(r101);
        r103.setCommentCount(r102);
    }
}
