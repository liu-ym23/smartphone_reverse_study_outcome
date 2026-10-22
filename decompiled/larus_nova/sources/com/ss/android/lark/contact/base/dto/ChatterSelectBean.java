package com.ss.android.lark.contact.base.dto;

import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.chatter.ChatterDescription;
import com.ss.android.lark.chat.entity.chatter.WorkStatus;
import java.util.List;

/* JADX INFO: loaded from: classes35.dex */
public class ChatterSelectBean extends BaseSelectBean {
    private static final long serialVersionUID = -8980352757996945035L;
    private ChatterDescription chatterDescription;
    private Chatter.ChatterType chatterType;
    private boolean hasOUPermission;
    private boolean isRegistered;
    private String mailAddress;
    private List<String> mailAddressHitTerms;
    private String tenantId;
    private String timeZoneId;
    private WorkStatus workStatus;

    @Override // com.ss.android.lark.contact.base.dto.BaseSelectBean
    public int getType() {
        return 2;
    }

    public boolean isCustomer() {
        return "0".equals(this.tenantId);
    }

    public ChatterSelectBean() {
        this.hasOUPermission = true;
    }

    public ChatterDescription getChatterDescription() {
        return this.chatterDescription;
    }

    public Chatter.ChatterType getChatterType() {
        return this.chatterType;
    }

    public String getMailAddress() {
        return this.mailAddress;
    }

    public List<String> getMailAddressHitTerms() {
        return this.mailAddressHitTerms;
    }

    public String getTenantId() {
        return this.tenantId;
    }

    public String getTimeZoneId() {
        return this.timeZoneId;
    }

    public WorkStatus getWorkStatus() {
        return this.workStatus;
    }

    public boolean isHasOUPermission() {
        return this.hasOUPermission;
    }

    public boolean isRegistered() {
        return this.isRegistered;
    }

    public void setChatterDescription(ChatterDescription r100) {
        this.chatterDescription = r100;
    }

    public void setChatterType(Chatter.ChatterType r100) {
        this.chatterType = r100;
    }

    public void setHasOUPermission(boolean r100) {
        this.hasOUPermission = r100;
    }

    public void setMailAddress(String r100) {
        this.mailAddress = r100;
    }

    public void setMailAddressHitTerms(List<String> r100) {
        this.mailAddressHitTerms = r100;
    }

    public void setRegistered(boolean r100) {
        this.isRegistered = r100;
    }

    public void setTenantId(String r100) {
        this.tenantId = r100;
    }

    public void setTimeZoneId(String r100) {
        this.timeZoneId = r100;
    }

    public void setWorkStatus(WorkStatus r100) {
        this.workStatus = r100;
    }
}
