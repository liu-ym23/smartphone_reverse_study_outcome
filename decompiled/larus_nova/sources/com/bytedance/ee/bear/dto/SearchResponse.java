package com.bytedance.ee.bear.dto;

import com.larksuite.framework.utils.CollectionUtils;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes16.dex */
public class SearchResponse implements Serializable {
    private boolean hasMore;
    private String requestId;
    private List<Object> searchInfos;
    private String searchKey;
    private int total;

    public boolean isEmpty() {
        return CollectionUtils.isEmpty(this.searchInfos);
    }

    public List<Object> getMetaList() {
        return this.searchInfos;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public String getSearchKey() {
        return this.searchKey;
    }

    public int getTotal() {
        return this.total;
    }

    public boolean isHasMore() {
        return this.hasMore;
    }

    public void setHasMore(boolean r100) {
        this.hasMore = r100;
    }

    public void setMetaList(List<Object> r100) {
        this.searchInfos = r100;
    }

    public void setSearchKey(String r100) {
        this.searchKey = r100;
    }

    public void setTotal(int r100) {
        this.total = r100;
    }

    public SearchResponse(List<Object> r100, String r101, String r102, int r103, boolean r104) {
        this.searchInfos = r100;
        this.searchKey = r101;
        this.requestId = r102;
        this.total = r103;
        this.hasMore = r104;
    }
}
