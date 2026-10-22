package com.bytedance.ee.bear.dto;

import com.larksuite.framework.utils.CollectionUtils;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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

    public void setHasMore(boolean r1) {
        this.hasMore = r1;
    }

    public void setMetaList(List<Object> r1) {
        this.searchInfos = r1;
    }

    public void setSearchKey(String r1) {
        this.searchKey = r1;
    }

    public void setTotal(int r1) {
        this.total = r1;
    }

    public SearchResponse(List<Object> r1, String r2, String r3, int r4, boolean r5) {
        this.searchInfos = r1;
        this.searchKey = r2;
        this.requestId = r3;
        this.total = r4;
        this.hasMore = r5;
    }
}
