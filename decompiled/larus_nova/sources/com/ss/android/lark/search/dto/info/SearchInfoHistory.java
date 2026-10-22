package com.ss.android.lark.search.dto.info;

import com.ss.android.lark.pb.searches.SearchTabName;
import com.ss.android.lark.pb.usearch.AdvGrammarSelectorResult;
import com.ss.android.lark.pb.usearch.SearchActionFilter;
import com.ss.android.lark.pb.usearch.SearchEntity;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes38.dex */
public class SearchInfoHistory implements Serializable {
    private LinkedList<AdvGrammarSelectorResult> advHistory;
    private String applink;
    private String digest;
    private Map<SearchActionFilter, SearchEntity> filterEntityMap;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f440162id;
    private String query;
    private SearchTabName searchTabName;

    public SearchInfoHistory() {
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.f440162id, this.query});
    }

    public LinkedList<AdvGrammarSelectorResult> getAdvHistory() {
        return this.advHistory;
    }

    public String getApplink() {
        return this.applink;
    }

    public String getDigest() {
        return this.digest;
    }

    public Map<SearchActionFilter, SearchEntity> getFilterEntityMap() {
        return this.filterEntityMap;
    }

    public String getId() {
        return this.f440162id;
    }

    public String getQuery() {
        return this.query;
    }

    public SearchTabName getSearchTabName() {
        return this.searchTabName;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L17:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L17;
        SearchInfoHistory r101 = (SearchInfoHistory) r100;
        if (Objects.equals(this.f440162id, r101.f440162id) == true) goto L13;
    L15:
        return false;
    L13:
        if (Objects.equals(this.query, r101.query) == false) goto L15;
        return true;
    }

    public void setAdvHistory(LinkedList<AdvGrammarSelectorResult> r100) {
        this.advHistory = r100;
    }

    public void setApplink(String r100) {
        this.applink = r100;
    }

    public void setDigest(String r100) {
        this.digest = r100;
    }

    public void setFilterEntityMap(Map<SearchActionFilter, SearchEntity> r100) {
        this.filterEntityMap = r100;
    }

    public void setId(String r100) {
        this.f440162id = r100;
    }

    public void setQuery(String r100) {
        this.query = r100;
    }

    public void setSearchTabName(SearchTabName r100) {
        this.searchTabName = r100;
    }
}
