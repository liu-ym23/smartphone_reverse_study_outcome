package com.ss.android.lark.search.dto;

import com.ss.android.lark.chat.entity.image.ImageSet;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
public class SearchImageHistory implements Serializable {
    private boolean hasMoreBefore;
    private List<ImageSet> imageSetList;

    public List<ImageSet> getImageSetList() {
        return this.imageSetList;
    }

    public boolean isHasMoreBefore() {
        return this.hasMoreBefore;
    }

    public void setHasMoreBefore(boolean r100) {
        this.hasMoreBefore = r100;
    }

    public void setImageSetList(List<ImageSet> r100) {
        this.imageSetList = r100;
    }

    public SearchImageHistory(boolean r100, List<ImageSet> r101) {
        this.hasMoreBefore = r100;
        this.imageSetList = r101;
    }
}
