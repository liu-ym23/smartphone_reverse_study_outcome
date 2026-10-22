package com.ss.android.lark.search.dto.info;

import com.bytedance.lark.pb.search.slash.v1.SlashCommandMeta;
import com.bytedance.lark.pb.search.v2.SearchQABizType;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public class SearchOpenSearchInfo extends SearchBaseInfo {
    private static final long serialVersionUID = -3610534218153492754L;
    private String app_link;
    SearchQABizType bizType;
    private long createTime;
    private String enterpriseMailAddress;
    private String extra;
    private String slashId;
    private SlashCommandMeta.SlashCommandType slash_command_type;
    private List<SlashCommandMeta.SlashCommandTag> tag;

    @Override // com.ss.android.lark.search.dto.info.SearchBaseInfo
    public Map<String, Object> getExtraParams() {
        SearchQABizType r100 = this.bizType;
        if (r100 != SearchQABizType.ConsumedQA) goto L5;
    L9:
        HashMap r101 = new HashMap();
        if (this.bizType != SearchQABizType.UnConsumedQA) goto L12;
        r101.put("ai_round_id", getId());
    L27:
        HashMap r102 = new HashMap();
        if (this.bizType != SearchQABizType.ConsumedQA) goto L30;
        Boolean r103 = Boolean.TRUE;
        r102.put("is_consumed", r103);
        r101.put("is_consumed", r103);
    L31:
        r101.put("sub_click_detail", r102);
        return r101;
    L30:
        Boolean r104 = Boolean.FALSE;
        r102.put("is_consumed", r104);
        r101.put("is_consumed", r104);
        goto L31
    L12:
        int r105 = c.f440167a;
        String r106 = this.app_link;
        Intrinsics.checkNotNullParameter("ai_round_id", "key");
        if (r106 != null) goto L15;
    L18:
        boolean r107 = true;
    L19:
        String r108 = "";
        if (r107 == false) goto L34;
    L26:
        r101.put("ai_round_id", r108);
        goto L27
    L34:
        String r109 = UriProtector.getQueryParameter(UriProtector.parse(r106), "ai_round_id");     // Catch: Exception -> L33
        if (r109 == null) goto L26;
        r108 = r109;
        goto L26
    L15:
        if (r106.length() == 0) goto L18;
        r107 = false;
        goto L19
    L5:
        if (r100 == SearchQABizType.UnConsumedQA) goto L9;
        return super.getExtraParams();
    }

    @Override // com.ss.android.lark.search.dto.info.SearchBaseInfo
    public String getResultTypeForReport() {
        SearchQABizType r100 = this.bizType;
        if (r100 != SearchQABizType.ConsumedQA) goto L5;
        return "enterprise_qa_history";
    L5:
        if (r100 == SearchQABizType.UnConsumedQA) goto L11;
        return "slash_command";
    L11:
        return "enterprise_qa_history";
    }

    @Override // com.ss.android.lark.search.dto.info.SearchBaseInfo
    public String getTagForReport() {
        SearchQABizType r100 = this.bizType;
        if (r100 != SearchQABizType.ConsumedQA) goto L5;
        return "enterprise_qa_section";
    L5:
        if (r100 == SearchQABizType.UnConsumedQA) goto L11;
        return "slash_command_section";
    L11:
        return "enterprise_qa_section";
    }

    public SearchOpenSearchInfo() {
        this.type = 21;
    }

    public String getApp_link() {
        return this.app_link;
    }

    public SearchQABizType getBizType() {
        return this.bizType;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public String getEnterpriseMailAddress() {
        return this.enterpriseMailAddress;
    }

    public String getExtra() {
        return this.extra;
    }

    public String getSlashId() {
        return this.slashId;
    }

    public SlashCommandMeta.SlashCommandType getSlash_command_type() {
        return this.slash_command_type;
    }

    public List<SlashCommandMeta.SlashCommandTag> getTag() {
        return this.tag;
    }

    public void setApp_link(String r100) {
        this.app_link = r100;
    }

    public void setBizType(SearchQABizType r100) {
        this.bizType = r100;
    }

    public void setCreateTime(long r100) {
        this.createTime = r100;
    }

    public void setEnterpriseMailAddress(String r100) {
        this.enterpriseMailAddress = r100;
    }

    public void setExtra(String r100) {
        this.extra = r100;
    }

    public void setSlashId(String r100) {
        this.slashId = r100;
    }

    public void setSlash_command_type(SlashCommandMeta.SlashCommandType r100) {
        this.slash_command_type = r100;
    }

    public void setTag(List<SlashCommandMeta.SlashCommandTag> r100) {
        this.tag = r100;
    }
}
