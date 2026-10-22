package com.ss.android.lark.passport.flow.auth_type;

import com.alibaba.fastjson.annotation.JSONField;
import com.ss.android.lark.passport.flow.core.model.ButtonInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes37.dex */
public class AuthTypeStepInfo implements Serializable {

    @JSONField(name = "auth_type_list")
    public ArrayList<ButtonInfo> authTypeList;

    @JSONField(name = "bottom_button")
    public ButtonInfo bottomButton;

    @JSONField(name = "subtitle")
    public String subTitle;

    @JSONField(name = "target_tenant_icon")
    public String targetTenantIcon;
    public String title;

    public AuthTypeStepInfo() {
    }

    public ButtonInfo getBottomButton() {
        return this.bottomButton;
    }

    public String getSubTitle() {
        return this.subTitle;
    }

    public String getTitle() {
        return this.title;
    }

    public List<ButtonInfo> getTypeList() {
        return this.authTypeList;
    }

    public void setBottomButton(ButtonInfo r100) {
        this.bottomButton = r100;
    }

    public void setSubTitle(String r100) {
        this.subTitle = r100;
    }

    public void setTitle(String r100) {
        this.title = r100;
    }

    public void setTypeList(ArrayList<ButtonInfo> r100) {
        this.authTypeList = r100;
    }
}
