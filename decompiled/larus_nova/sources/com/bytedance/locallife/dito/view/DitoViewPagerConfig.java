package com.bytedance.locallife.dito.view;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/locallife/dito/view/DitoViewPagerConfig;", "Ljava/io/Serializable;", "defaultPageID", "", "defaultPageKey", "(Ljava/lang/String;Ljava/lang/String;)V", "getDefaultPageID", "()Ljava/lang/String;", "getDefaultPageKey", "dito-core-saas_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class DitoViewPagerConfig implements Serializable {

    @SerializedName("default_page_id")
    private final String defaultPageID;
    private final String defaultPageKey;

    /* JADX WARN: Multi-variable type inference failed */
    public DitoViewPagerConfig() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public final String getDefaultPageID() {
        return this.defaultPageID;
    }

    public final String getDefaultPageKey() {
        return this.defaultPageKey;
    }

    public DitoViewPagerConfig(String r100, String r101) {
        this.defaultPageID = r100;
        this.defaultPageKey = r101;
    }

    public /* synthetic */ DitoViewPagerConfig(String r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
