package com.ss.android.lark.search.dto.info;

/* JADX INFO: loaded from: classes38.dex */
public class SearchWikiInfo extends SearchBaseInfo {
    private static final long serialVersionUID = -8785266645108862565L;
    private SearchSpaceInfo spaceInfo;
    private String token;
    private String url;

    @Override // com.ss.android.lark.search.dto.info.SearchBaseInfo
    public String getResultTypeForReport() {
        return "wiki";
    }

    public SearchWikiInfo() {
        this.type = 15;
    }

    public SearchSpaceInfo getSpaceInfo() {
        return this.spaceInfo;
    }

    public String getToken() {
        return this.token;
    }

    public String getUrl() {
        return this.url;
    }

    public void setSpaceInfo(SearchSpaceInfo r100) {
        this.spaceInfo = r100;
    }

    public void setToken(String r100) {
        this.token = r100;
    }

    public void setUrl(String r100) {
        this.url = r100;
    }
}
