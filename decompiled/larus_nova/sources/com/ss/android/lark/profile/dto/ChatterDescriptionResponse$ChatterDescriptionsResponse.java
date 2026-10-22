package com.ss.android.lark.profile.dto;

import com.ss.android.lark.profile.entity.ChatterDescription;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes37.dex */
public class ChatterDescriptionResponse$ChatterDescriptionsResponse implements Serializable {
    public List<ChatterDescription> descriptions;
    public boolean hasMore;

    public ChatterDescriptionResponse$ChatterDescriptionsResponse(List<ChatterDescription> r100, boolean r101) {
        this.descriptions = r100;
        this.hasMore = r101;
    }
}
