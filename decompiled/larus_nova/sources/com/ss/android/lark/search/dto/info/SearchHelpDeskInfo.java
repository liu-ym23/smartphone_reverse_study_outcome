package com.ss.android.lark.search.dto.info;

import com.bytedance.lark.pb.basic.v1.Tag;
import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
public class SearchHelpDeskInfo extends SearchBaseInfo {
    private static final long serialVersionUID = -4021864670706611987L;
    private String crossTagInfo;
    private String faqId;
    private String faqTitle;
    private boolean isOfficialOnCall;
    private List<Tag> tags;

    @Override // com.ss.android.lark.search.dto.info.SearchBaseInfo
    public String getResultTypeForReport() {
        return "helpdesk";
    }

    public SearchHelpDeskInfo() {
        this.type = 10;
    }

    public String getCrossTagInfo() {
        return this.crossTagInfo;
    }

    public String getFaqId() {
        return this.faqId;
    }

    public String getFaqTitle() {
        return this.faqTitle;
    }

    public List<Tag> getTags() {
        return this.tags;
    }

    public boolean isOfficialOnCall() {
        return this.isOfficialOnCall;
    }

    public void setCrossTagInfo(String r100) {
        this.crossTagInfo = r100;
    }

    public void setFaqId(String r100) {
        this.faqId = r100;
    }

    public void setFaqTitle(String r100) {
        this.faqTitle = r100;
    }

    public void setOfficialOnCall(boolean r100) {
        this.isOfficialOnCall = r100;
    }

    public void setTags(List<Tag> r100) {
        this.tags = r100;
    }
}
