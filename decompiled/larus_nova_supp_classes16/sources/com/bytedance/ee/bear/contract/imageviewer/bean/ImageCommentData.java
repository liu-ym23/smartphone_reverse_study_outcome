package com.bytedance.ee.bear.contract.imageviewer.bean;

import com.bytedance.ee.util.io.NonProguard;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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

        public void setCommentCount(int r1) {
            this.commentCount = r1;
        }

        public void setCommentable(boolean r1) {
            this.commentable = r1;
        }
    }

    public ImageCommentData() {
        this.mImageCommentDataMap = new HashMap();
    }

    public Map<String, ImageCommentInfo> getImageCommentDataMap() {
        return this.mImageCommentDataMap;
    }

    public void setCommentInfo(String r3, boolean r4, int r5) {
        ImageCommentInfo r0 = this.mImageCommentDataMap.get(r3);
        if (r0 != null) goto L5;
        r0 = new ImageCommentInfo();
        this.mImageCommentDataMap.put(r3, r0);
    L5:
        r0.setCommentable(r4);
        r0.setCommentCount(r5);
    }
}
