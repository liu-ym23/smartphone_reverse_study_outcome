package com.ss.android.lark.search.dto.info;

import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.search.dto.constant.SearchCommonConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010+\u001a\u00020,H\u0016J\u0012\u0010-\u001a\u00020,2\b\u0010.\u001a\u0004\u0018\u00010&H\u0016J\u0012\u0010/\u001a\u00020,2\b\u00100\u001a\u0004\u0018\u00010&H\u0016R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R$\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001c\u0010%\u001a\u0004\u0018\u00010&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u00061"}, d2 = {"Lcom/ss/android/lark/search/dto/info/SearchCardInfo;", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "<init>", "()V", "infoList", "", "getInfoList", "()Ljava/util/List;", "topRowList", "getTopRowList", "nonTopRowList", "getNonTopRowList", "value", "", "rowLimit", "getRowLimit", "()I", "setRowLimit", "(I)V", "columnLimit", "getColumnLimit", "setColumnLimit", BitableAnalytic.LinkSceneClickType.EXPAND, "", "getExpand", "()Z", "setExpand", "(Z)V", "defaultExpand", "getDefaultExpand", "setDefaultExpand", "onMoreClickListener", "Lcom/ss/android/lark/search/dto/IOnMoreClickListener;", "getOnMoreClickListener", "()Lcom/ss/android/lark/search/dto/IOnMoreClickListener;", "setOnMoreClickListener", "(Lcom/ss/android/lark/search/dto/IOnMoreClickListener;)V", "location", "", "getLocation", "()Ljava/lang/String;", "setLocation", "(Ljava/lang/String;)V", "resetDefaultValue", "", "setImprId", "imprId", "setSession", AppbrandHostConstants.SCHEMA_INSPECT.SESSION, "search-dto_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SearchCardInfo extends SearchBaseInfo {
    private int columnLimit;
    private boolean defaultExpand;
    private boolean expand;
    private final List<SearchBaseInfo> infoList;
    private String location;
    private final List<SearchBaseInfo> nonTopRowList;
    private v3c.b onMoreClickListener;
    private int rowLimit;
    private final List<SearchBaseInfo> topRowList;

    public SearchCardInfo() {
        this.type = SearchCommonConstants.SearchResultType.CARD;
        this.infoList = new ArrayList();
        this.topRowList = new ArrayList();
        this.nonTopRowList = new ArrayList();
        this.rowLimit = 3;
        this.columnLimit = 4;
    }

    @Override // com.ss.android.lark.search.dto.info.SearchBaseInfo
    public void resetDefaultValue() {
        super.resetDefaultValue();
        this.expand = this.defaultExpand;
    }

    public final int getColumnLimit() {
        return this.columnLimit;
    }

    public final boolean getDefaultExpand() {
        return this.defaultExpand;
    }

    public final boolean getExpand() {
        return this.expand;
    }

    public final List<SearchBaseInfo> getInfoList() {
        return this.infoList;
    }

    public final String getLocation() {
        return this.location;
    }

    public final List<SearchBaseInfo> getNonTopRowList() {
        return this.nonTopRowList;
    }

    public final v3c.b getOnMoreClickListener() {
        return this.onMoreClickListener;
    }

    public final int getRowLimit() {
        return this.rowLimit;
    }

    public final List<SearchBaseInfo> getTopRowList() {
        return this.topRowList;
    }

    public final void setColumnLimit(int r100) {
        if (r100 > 0) goto L4;
        r100 = 4;
    L4:
        this.columnLimit = r100;
    }

    public final void setDefaultExpand(boolean r100) {
        this.defaultExpand = r100;
    }

    public final void setExpand(boolean r100) {
        this.expand = r100;
    }

    @Override // com.ss.android.lark.search.dto.info.SearchBaseInfo
    public void setImprId(String r100) {
        super.setImprId(r100);
        Iterator<SearchBaseInfo> r101 = this.infoList.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().setImprId(r100);
        goto L4
    }

    public final void setLocation(String r100) {
        this.location = r100;
    }

    public final void setOnMoreClickListener(v3c.b r100) {
        this.onMoreClickListener = r100;
    }

    public final void setRowLimit(int r100) {
        if (r100 > 0) goto L4;
        r100 = 3;
    L4:
        this.rowLimit = r100;
    }

    @Override // com.ss.android.lark.search.dto.info.SearchBaseInfo
    public void setSession(String r100) {
        super.setSession(r100);
        Iterator<SearchBaseInfo> r101 = this.infoList.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().setSession(r100);
        goto L4
    }
}
