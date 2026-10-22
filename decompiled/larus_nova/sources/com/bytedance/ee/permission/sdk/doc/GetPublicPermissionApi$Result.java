package com.bytedance.ee.permission.sdk.doc;

import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.ee.bear.document.setting.DocumentSettingViewModel;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.chameleon.bridge.NonProguard;
import com.ss.android.lark.chameleon.idependency.Log;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
import xt5.c;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0003678B\u0007¢\u0006\u0004\b4\u00105J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003R$\u0010\t\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00078\u0006@BX\u0087\u000e¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR$\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\f8\u0006@BX\u0087\u000e¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R$\u0010\u0011\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\f8\u0006@BX\u0087\u000e¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R$\u0010\u0013\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00078\u0006@BX\u0087\u000e¢\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0014\u0010\u000bR$\u0010\u0015\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00078\u0006@BX\u0087\u000e¢\u0006\f\n\u0004\b\u0015\u0010\n\u001a\u0004\b\u0016\u0010\u000bR$\u0010\u0017\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00078\u0006@BX\u0087\u000e¢\u0006\f\n\u0004\b\u0017\u0010\n\u001a\u0004\b\u0018\u0010\u000bR0\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198\u0006@BX\u0087\u000e¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR(\u0010 \u001a\u0004\u0018\u00010\u001f2\b\u0010\b\u001a\u0004\u0018\u00010\u001f8\u0006@BX\u0087\u000e¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R(\u0010%\u001a\u0004\u0018\u00010$2\b\u0010\b\u001a\u0004\u0018\u00010$8\u0006@BX\u0087\u000e¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R(\u0010*\u001a\u0004\u0018\u00010)2\b\u0010\b\u001a\u0004\u0018\u00010)8\u0006@BX\u0087\u000e¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\"\u0010.\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103¨\u00069"}, d2 = {"com/bytedance/ee/permission/sdk/doc/GetPublicPermissionApi$Result", "Lcom/ss/android/lark/chameleon/bridge/NonProguard;", "Lxt5/c;", "Lorg/json/JSONObject;", "json", "", "parse", "", "<set-?>", "isOwner", "Z", "()Z", "", "ownerPermType", "I", "getOwnerPermType", "()I", "adminExternalAccess", "getAdminExternalAccess", "anonymousVerify", "getAnonymousVerify", "canUnlock", "getCanUnlock", "adminCanCross", "getAdminCanCross", "", "", "partnerTenantIds", "Ljava/util/List;", "getPartnerTenantIds", "()Ljava/util/List;", "Lcom/bytedance/ee/permission/sdk/doc/GetPublicPermissionApi$Result$Label;", "label", "Lcom/bytedance/ee/permission/sdk/doc/GetPublicPermissionApi$Result$Label;", "getLabel", "()Lcom/bytedance/ee/permission/sdk/doc/GetPublicPermissionApi$Result$Label;", "Lcom/bytedance/ee/permission/sdk/doc/GetPublicPermissionApi$Result$PermPublic;", "publicPerm", "Lcom/bytedance/ee/permission/sdk/doc/GetPublicPermissionApi$Result$PermPublic;", "getPublicPerm", "()Lcom/bytedance/ee/permission/sdk/doc/GetPublicPermissionApi$Result$PermPublic;", "Lcom/bytedance/ee/permission/sdk/doc/GetPublicPermissionApi$Result$ConfigInfo;", "configInfo", "Lcom/bytedance/ee/permission/sdk/doc/GetPublicPermissionApi$Result$ConfigInfo;", "getConfigInfo", "()Lcom/bytedance/ee/permission/sdk/doc/GetPublicPermissionApi$Result$ConfigInfo;", "reportPublicPermJson", "Ljava/lang/String;", "getReportPublicPermJson", "()Ljava/lang/String;", "setReportPublicPermJson", "(Ljava/lang/String;)V", "<init>", "()V", "ConfigInfo", "Label", "PermPublic", "permission-model_release"}, k = 1, mv = {1, 7, 1})
public final class GetPublicPermissionApi$Result implements NonProguard, c {

    @SerializedName("admin_can_cross")
    @JSONField(name = "admin_can_cross")
    private boolean adminCanCross;

    @SerializedName("admin_external_access")
    @JSONField(name = "admin_external_access")
    private int adminExternalAccess;

    @SerializedName("anonymous_verify")
    @JSONField(name = "anonymous_verify")
    private boolean anonymousVerify;

    @SerializedName("can_unlock")
    @JSONField(name = "can_unlock")
    private boolean canUnlock;

    @SerializedName("config_info")
    @JSONField(name = "config_info")
    private ConfigInfo configInfo;

    @SerializedName("is_owner")
    @JSONField(name = "is_owner")
    private boolean isOwner;

    @SerializedName("label")
    @JSONField(name = "label")
    private Label label;

    @SerializedName("owner_perm_type")
    @JSONField(name = "owner_perm_type")
    private int ownerPermType;

    @SerializedName("partner_tenant_ids")
    @JSONField(name = "partner_tenant_ids")
    private List<String> partnerTenantIds;

    @SerializedName("perm_public")
    @JSONField(name = "perm_public")
    private PermPublic publicPerm;
    private String reportPublicPermJson;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b&\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u00100\u001a\u0002012\u0006\u00102\u001a\u000203R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001e\u0010\u0012\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001e\u0010\u0015\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u001e\u0010\u0018\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR\u001e\u0010\u001b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\f\"\u0004\b\u001d\u0010\u000eR\u001e\u0010\u001e\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\f\"\u0004\b \u0010\u000eR\u001e\u0010!\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\f\"\u0004\b#\u0010\u000eR\u001e\u0010$\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\f\"\u0004\b&\u0010\u000eR\u001e\u0010'\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\f\"\u0004\b)\u0010\u000eR\u001e\u0010*\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\bR\u001e\u0010-\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\b¨\u00064"}, d2 = {"Lcom/bytedance/ee/permission/sdk/doc/GetPublicPermissionApi$Result$ConfigInfo;", "Lcom/ss/android/lark/chameleon/bridge/NonProguard;", "()V", "departmentSearchTriggerNum", "", "getDepartmentSearchTriggerNum", "()I", "setDepartmentSearchTriggerNum", "(I)V", "enableAutoShareDepartment", "", "getEnableAutoShareDepartment", "()Z", "setEnableAutoShareDepartment", "(Z)V", "enableAutoShareDepartmentExternal", "getEnableAutoShareDepartmentExternal", "setEnableAutoShareDepartmentExternal", "enableAutoShareLeader", "getEnableAutoShareLeader", "setEnableAutoShareLeader", "enableAutoShareTenant", "getEnableAutoShareTenant", "setEnableAutoShareTenant", "enableDisableAiSearch", "getEnableDisableAiSearch", "setEnableDisableAiSearch", "enableDocsAccessExpand", "getEnableDocsAccessExpand", "setEnableDocsAccessExpand", "enableLeaderAutoApprove", "getEnableLeaderAutoApprove", "setEnableLeaderAutoApprove", "enableLeaderLinkShare", "getEnableLeaderLinkShare", "setEnableLeaderLinkShare", "enableLeaderSearch", "getEnableLeaderSearch", "setEnableLeaderSearch", "enableLeaderSetting", "getEnableLeaderSetting", "setEnableLeaderSetting", "leaderSearchNumber", "getLeaderSearchNumber", "setLeaderSearchNumber", "leaderSearchTriggerNum", "getLeaderSearchTriggerNum", "setLeaderSearchTriggerNum", "parse", "", "json", "Lorg/json/JSONObject;", "permission-model_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class ConfigInfo implements NonProguard {

        @SerializedName("department_search_trigger_num")
        @JSONField(name = "department_search_trigger_num")
        private int departmentSearchTriggerNum;

        @SerializedName("enable_auto_share_department")
        @JSONField(name = "enable_auto_share_department")
        private boolean enableAutoShareDepartment;

        @SerializedName("enable_auto_share_department_external")
        @JSONField(name = "enable_auto_share_department_external")
        private boolean enableAutoShareDepartmentExternal;

        @SerializedName("enable_auto_share_leader")
        @JSONField(name = "enable_auto_share_leader")
        private boolean enableAutoShareLeader;

        @SerializedName("enable_auto_share_tenant")
        @JSONField(name = "enable_auto_share_tenant")
        private boolean enableAutoShareTenant;

        @SerializedName("enable_disable_ai_search")
        @JSONField(name = "enable_disable_ai_search")
        private boolean enableDisableAiSearch;

        @SerializedName("enable_docs_access_expand")
        @JSONField(name = "enable_docs_access_expand")
        private boolean enableDocsAccessExpand;

        @SerializedName("enable_leader_auto_approve")
        @JSONField(name = "enable_leader_auto_approve")
        private boolean enableLeaderAutoApprove;

        @SerializedName("enable_leader_link_share")
        @JSONField(name = "enable_leader_link_share")
        private boolean enableLeaderLinkShare;

        @SerializedName("enable_leader_search")
        @JSONField(name = "enable_leader_search")
        private boolean enableLeaderSearch;

        @SerializedName("enable_leader_setting")
        @JSONField(name = "enable_leader_setting")
        private boolean enableLeaderSetting;

        @SerializedName(IDocPublicPermission.ConfigInfo.CONFIG_LEADER_SEARCH_NUMBER_KEY)
        @JSONField(name = IDocPublicPermission.ConfigInfo.CONFIG_LEADER_SEARCH_NUMBER_KEY)
        private int leaderSearchNumber;

        @SerializedName("leader_search_trigger_num")
        @JSONField(name = "leader_search_trigger_num")
        private int leaderSearchTriggerNum;

        public ConfigInfo() {
        }

        public final int getDepartmentSearchTriggerNum() {
            return this.departmentSearchTriggerNum;
        }

        public final boolean getEnableAutoShareDepartment() {
            return this.enableAutoShareDepartment;
        }

        public final boolean getEnableAutoShareDepartmentExternal() {
            return this.enableAutoShareDepartmentExternal;
        }

        public final boolean getEnableAutoShareLeader() {
            return this.enableAutoShareLeader;
        }

        public final boolean getEnableAutoShareTenant() {
            return this.enableAutoShareTenant;
        }

        public final boolean getEnableDisableAiSearch() {
            return this.enableDisableAiSearch;
        }

        public final boolean getEnableDocsAccessExpand() {
            return this.enableDocsAccessExpand;
        }

        public final boolean getEnableLeaderAutoApprove() {
            return this.enableLeaderAutoApprove;
        }

        public final boolean getEnableLeaderLinkShare() {
            return this.enableLeaderLinkShare;
        }

        public final boolean getEnableLeaderSearch() {
            return this.enableLeaderSearch;
        }

        public final boolean getEnableLeaderSetting() {
            return this.enableLeaderSetting;
        }

        public final int getLeaderSearchNumber() {
            return this.leaderSearchNumber;
        }

        public final int getLeaderSearchTriggerNum() {
            return this.leaderSearchTriggerNum;
        }

        public final void parse(JSONObject r100) {
            Intrinsics.checkNotNullParameter(r100, "json");
            this.enableLeaderLinkShare = r100.optBoolean("enable_leader_link_share");     // Catch: Exception -> L5
            this.departmentSearchTriggerNum = r100.optInt("department_search_trigger_num");     // Catch: Exception -> L5
            this.enableDocsAccessExpand = r100.optBoolean("enable_docs_access_expand");     // Catch: Exception -> L5
            this.enableDisableAiSearch = r100.optBoolean("enable_disable_ai_search");     // Catch: Exception -> L5
            this.enableAutoShareDepartment = r100.optBoolean("enable_auto_share_department");     // Catch: Exception -> L5
            this.enableAutoShareDepartmentExternal = r100.optBoolean("enable_auto_share_department_external");     // Catch: Exception -> L5
            this.enableAutoShareTenant = r100.optBoolean("enable_auto_share_tenant");     // Catch: Exception -> L5
            this.enableLeaderAutoApprove = r100.optBoolean("enable_leader_auto_approve");     // Catch: Exception -> L5
            this.enableLeaderSearch = r100.optBoolean("enable_leader_search");     // Catch: Exception -> L5
            this.leaderSearchNumber = r100.optInt(IDocPublicPermission.ConfigInfo.CONFIG_LEADER_SEARCH_NUMBER_KEY);     // Catch: Exception -> L5
            this.leaderSearchTriggerNum = r100.optInt("leader_search_trigger_num");     // Catch: Exception -> L5
            this.enableLeaderSetting = r100.optBoolean("enable_leader_setting");     // Catch: Exception -> L5
            this.enableAutoShareLeader = r100.optBoolean("enable_auto_share_leader");     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            Log.e("GetPublicPermissionApi", "ConfigInfo - parse, error: ", e);
        }

        public final void setDepartmentSearchTriggerNum(int r100) {
            this.departmentSearchTriggerNum = r100;
        }

        public final void setEnableAutoShareDepartment(boolean r100) {
            this.enableAutoShareDepartment = r100;
        }

        public final void setEnableAutoShareDepartmentExternal(boolean r100) {
            this.enableAutoShareDepartmentExternal = r100;
        }

        public final void setEnableAutoShareLeader(boolean r100) {
            this.enableAutoShareLeader = r100;
        }

        public final void setEnableAutoShareTenant(boolean r100) {
            this.enableAutoShareTenant = r100;
        }

        public final void setEnableDisableAiSearch(boolean r100) {
            this.enableDisableAiSearch = r100;
        }

        public final void setEnableDocsAccessExpand(boolean r100) {
            this.enableDocsAccessExpand = r100;
        }

        public final void setEnableLeaderAutoApprove(boolean r100) {
            this.enableLeaderAutoApprove = r100;
        }

        public final void setEnableLeaderLinkShare(boolean r100) {
            this.enableLeaderLinkShare = r100;
        }

        public final void setEnableLeaderSearch(boolean r100) {
            this.enableLeaderSearch = r100;
        }

        public final void setEnableLeaderSetting(boolean r100) {
            this.enableLeaderSetting = r100;
        }

        public final void setLeaderSearchNumber(int r100) {
            this.leaderSearchNumber = r100;
        }

        public final void setLeaderSearchTriggerNum(int r100) {
            this.leaderSearchTriggerNum = r100;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0019B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR \u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR \u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ee/permission/sdk/doc/GetPublicPermissionApi$Result$Label;", "Lcom/ss/android/lark/chameleon/bridge/NonProguard;", "()V", "autoShareDepartmentEntity", "Lcom/bytedance/ee/permission/sdk/doc/GetPublicPermissionApi$Result$Label$LabelDetail;", "getAutoShareDepartmentEntity", "()Lcom/bytedance/ee/permission/sdk/doc/GetPublicPermissionApi$Result$Label$LabelDetail;", "setAutoShareDepartmentEntity", "(Lcom/bytedance/ee/permission/sdk/doc/GetPublicPermissionApi$Result$Label$LabelDetail;)V", "autoShareLeaderEntity", "getAutoShareLeaderEntity", "setAutoShareLeaderEntity", "autoShareTenantEntity", "getAutoShareTenantEntity", "setAutoShareTenantEntity", "disableAiSearchEntity", "getDisableAiSearchEntity", "setDisableAiSearchEntity", "leaderSearchEntity", "getLeaderSearchEntity", "setLeaderSearchEntity", "parse", "", "json", "Lorg/json/JSONObject;", "LabelDetail", "permission-model_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Label implements NonProguard {

        @SerializedName("auto_share_department_entity")
        @JSONField(name = "auto_share_department_entity")
        private LabelDetail autoShareDepartmentEntity;

        @SerializedName("auto_share_leader_entity")
        @JSONField(name = "auto_share_leader_entity")
        private LabelDetail autoShareLeaderEntity;

        @SerializedName("auto_share_tenant_entity")
        @JSONField(name = "auto_share_tenant_entity")
        private LabelDetail autoShareTenantEntity;

        @SerializedName("disable_ai_search_entity")
        @JSONField(name = "disable_ai_search_entity")
        private LabelDetail disableAiSearchEntity;

        @SerializedName("leader_search_entity")
        @JSONField(name = "leader_search_entity")
        private LabelDetail leaderSearchEntity;

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/permission/sdk/doc/GetPublicPermissionApi$Result$Label$LabelDetail;", "Lcom/ss/android/lark/chameleon/bridge/NonProguard;", "()V", "label", "", "getLabel", "()Ljava/lang/String;", "setLabel", "(Ljava/lang/String;)V", "tips", "getTips", "setTips", "parse", "", "json", "Lorg/json/JSONObject;", "permission-model_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class LabelDetail implements NonProguard {

            @SerializedName("label")
            @JSONField(name = "label")
            private String label;

            @SerializedName("tips")
            @JSONField(name = "tips")
            private String tips;

            public LabelDetail() {
                this.label = "";
                this.tips = "";
            }

            public final String getLabel() {
                return this.label;
            }

            public final String getTips() {
                return this.tips;
            }

            public final void parse(JSONObject r100) {
                Intrinsics.checkNotNullParameter(r100, "json");
                this.label = r100.optString("label");
                this.tips = r100.optString("tips");
            }

            public final void setLabel(String r100) {
                Intrinsics.checkNotNullParameter(r100, "<set-?>");
                this.label = r100;
            }

            public final void setTips(String r100) {
                Intrinsics.checkNotNullParameter(r100, "<set-?>");
                this.tips = r100;
            }
        }

        public Label() {
        }

        public final LabelDetail getAutoShareDepartmentEntity() {
            return this.autoShareDepartmentEntity;
        }

        public final LabelDetail getAutoShareLeaderEntity() {
            return this.autoShareLeaderEntity;
        }

        public final LabelDetail getAutoShareTenantEntity() {
            return this.autoShareTenantEntity;
        }

        public final LabelDetail getDisableAiSearchEntity() {
            return this.disableAiSearchEntity;
        }

        public final LabelDetail getLeaderSearchEntity() {
            return this.leaderSearchEntity;
        }

        public final void parse(JSONObject r100) {
            Intrinsics.checkNotNullParameter(r100, "json");
            JSONObject r101 = r100.optJSONObject("leader_search_entity");     // Catch: Exception -> L24
            LabelDetail r102 = null;
            if (r101 == null) goto L6;
            LabelDetail r103 = new LabelDetail();     // Catch: Exception -> L24
            r103.parse(r101);     // Catch: Exception -> L24
        L7:
            this.leaderSearchEntity = r103;     // Catch: Exception -> L24
            JSONObject r104 = r100.optJSONObject("auto_share_leader_entity");     // Catch: Exception -> L24
            if (r104 == null) goto L10;
            LabelDetail r105 = new LabelDetail();     // Catch: Exception -> L24
            r105.parse(r104);     // Catch: Exception -> L24
        L11:
            this.autoShareLeaderEntity = r105;     // Catch: Exception -> L24
            JSONObject r106 = r100.optJSONObject("auto_share_department_entity");     // Catch: Exception -> L24
            if (r106 == null) goto L14;
            LabelDetail r107 = new LabelDetail();     // Catch: Exception -> L24
            r107.parse(r106);     // Catch: Exception -> L24
        L15:
            this.autoShareDepartmentEntity = r107;     // Catch: Exception -> L24
            JSONObject r108 = r100.optJSONObject("auto_share_tenant_entity");     // Catch: Exception -> L24
            if (r108 == null) goto L18;
            LabelDetail r109 = new LabelDetail();     // Catch: Exception -> L24
            r109.parse(r108);     // Catch: Exception -> L24
        L19:
            this.autoShareTenantEntity = r109;     // Catch: Exception -> L24
            JSONObject r110 = r100.optJSONObject("disable_ai_search_entity");     // Catch: Exception -> L24
            if (r110 == null) goto L22;
            r102 = new LabelDetail();     // Catch: Exception -> L24
            r102.parse(r110);     // Catch: Exception -> L24
        L22:
            this.disableAiSearchEntity = r102;     // Catch: Exception -> L24
            return;
        L18:
            r109 = null;
            goto L19
        L14:
            r107 = null;
            goto L15
        L10:
            r105 = null;
            goto L11
        L6:
            r103 = null;
        L24:
            e = move-exception;
            Log.e("GetPublicPermissionApi", "Label - parse, error: ", e);
        }

        public final void setAutoShareDepartmentEntity(LabelDetail r100) {
            this.autoShareDepartmentEntity = r100;
        }

        public final void setAutoShareLeaderEntity(LabelDetail r100) {
            this.autoShareLeaderEntity = r100;
        }

        public final void setAutoShareTenantEntity(LabelDetail r100) {
            this.autoShareTenantEntity = r100;
        }

        public final void setDisableAiSearchEntity(LabelDetail r100) {
            this.disableAiSearchEntity = r100;
        }

        public final void setLeaderSearchEntity(LabelDetail r100) {
            this.leaderSearchEntity = r100;
        }
    }

    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0006|}~\u007f\u0080\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010x\u001a\u00020y2\u0006\u0010z\u001a\u00020{R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001e\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR \u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR \u0010\u001b\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R \u0010!\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001e\u0010'\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR\u001e\u0010*\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\bR\u001e\u0010-\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\bR\u001e\u00100\u001a\u0002018\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001e\u00106\u001a\u0002018\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00103\"\u0004\b8\u00105R\u001e\u00109\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0006\"\u0004\b;\u0010\bR\u001e\u0010<\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u0006\"\u0004\b>\u0010\bR\u001e\u0010?\u001a\u0002018\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u00103\"\u0004\bA\u00105R\u001e\u0010B\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u0006\"\u0004\bD\u0010\bR\u001e\u0010E\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u0006\"\u0004\bG\u0010\bR\u001e\u0010H\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\u0006\"\u0004\bJ\u0010\bR\u001e\u0010K\u001a\u00020L8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u001e\u0010Q\u001a\u0002018\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u00103\"\u0004\bS\u00105R\u001e\u0010T\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010\u0006\"\u0004\bV\u0010\bR\u001e\u0010W\u001a\u0002018\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u00103\"\u0004\bY\u00105R\u001e\u0010Z\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\u0006\"\u0004\b\\\u0010\bR \u0010]\u001a\u0004\u0018\u00010^8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR \u0010c\u001a\u0004\u0018\u00010d8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR\u001e\u0010i\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010\u0006\"\u0004\bk\u0010\bR\u001e\u0010l\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u0010\u0006\"\u0004\bn\u0010\bR\u001e\u0010o\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bp\u0010\u0006\"\u0004\bq\u0010\bR\u001e\u0010r\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bs\u0010\u0006\"\u0004\bt\u0010\bR\u001e\u0010u\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bv\u0010\u0006\"\u0004\bw\u0010\b¨\u0006\u0081\u0001"}, d2 = {"Lcom/bytedance/ee/permission/sdk/doc/GetPublicPermissionApi$Result$PermPublic;", "Lcom/ss/android/lark/chameleon/bridge/NonProguard;", "()V", "applyEmbedEntity", "", "getApplyEmbedEntity", "()I", "setApplyEmbedEntity", "(I)V", "autoShareDepartmentEntity", "getAutoShareDepartmentEntity", "setAutoShareDepartmentEntity", "autoShareLeaderEntity", "getAutoShareLeaderEntity", "setAutoShareLeaderEntity", "autoShareTenantEntity", "getAutoShareTenantEntity", "setAutoShareTenantEntity", "blockOptions", "Lcom/bytedance/ee/permission/sdk/doc/GetPublicPermissionApi$Result$PermPublic$BlockOptions;", "getBlockOptions", "()Lcom/bytedance/ee/permission/sdk/doc/GetPublicPermissionApi$Result$PermPublic$BlockOptions;", "setBlockOptions", "(Lcom/bytedance/ee/permission/sdk/doc/GetPublicPermissionApi$Result$PermPublic$BlockOptions;)V", "commentEntity", "getCommentEntity", "setCommentEntity", "constraint", "Lcom/bytedance/ee/permission/sdk/doc/GetPublicPermissionApi$Result$PermPublic$Constraint;", "getConstraint", "()Lcom/bytedance/ee/permission/sdk/doc/GetPublicPermissionApi$Result$PermPublic$Constraint;", "setConstraint", "(Lcom/bytedance/ee/permission/sdk/doc/GetPublicPermissionApi$Result$PermPublic$Constraint;)V", "constraintValue", "Lcom/bytedance/ee/permission/sdk/doc/GetPublicPermissionApi$Result$PermPublic$ConstraintValue;", "getConstraintValue", "()Lcom/bytedance/ee/permission/sdk/doc/GetPublicPermissionApi$Result$PermPublic$ConstraintValue;", "setConstraintValue", "(Lcom/bytedance/ee/permission/sdk/doc/GetPublicPermissionApi$Result$PermPublic$ConstraintValue;)V", "copyEntity", "getCopyEntity", "setCopyEntity", "disableAiSearchEntity", "getDisableAiSearchEntity", "setDisableAiSearchEntity", "externalAccessEntity", "getExternalAccessEntity", "setExternalAccessEntity", "externalAccessSwitch", "", "getExternalAccessSwitch", "()Z", "setExternalAccessSwitch", "(Z)V", "hasModifiedLinkShare", "getHasModifiedLinkShare", "setHasModifiedLinkShare", "leaderAutoApproveEntity", "getLeaderAutoApproveEntity", "setLeaderAutoApproveEntity", "leaderCollaboratorRoleEntity", "getLeaderCollaboratorRoleEntity", "setLeaderCollaboratorRoleEntity", "leaderCopySwitch", "getLeaderCopySwitch", "setLeaderCopySwitch", "leaderLinkShareEntity", "getLeaderLinkShareEntity", "setLeaderLinkShareEntity", "leaderRoleEntity", "getLeaderRoleEntity", "setLeaderRoleEntity", "leaderSearchEntity", "getLeaderSearchEntity", "setLeaderSearchEntity", "linkPassword", "", "getLinkPassword", "()Ljava/lang/String;", "setLinkPassword", "(Ljava/lang/String;)V", "linkPasswordSwitch", "getLinkPasswordSwitch", "setLinkPasswordSwitch", "linkShareEntityV2", "getLinkShareEntityV2", "setLinkShareEntityV2", "lockSwitch", "getLockSwitch", "setLockSwitch", "manageCollaboratorEntity", "getManageCollaboratorEntity", "setManageCollaboratorEntity", "permSourceOptions", "Lcom/bytedance/ee/permission/sdk/doc/GetPublicPermissionApi$Result$PermPublic$PermSourceOptions;", "getPermSourceOptions", "()Lcom/bytedance/ee/permission/sdk/doc/GetPublicPermissionApi$Result$PermPublic$PermSourceOptions;", "setPermSourceOptions", "(Lcom/bytedance/ee/permission/sdk/doc/GetPublicPermissionApi$Result$PermPublic$PermSourceOptions;)V", "permType", "Lcom/bytedance/ee/permission/sdk/doc/GetPublicPermissionApi$Result$PermPublic$PermType;", "getPermType", "()Lcom/bytedance/ee/permission/sdk/doc/GetPublicPermissionApi$Result$PermPublic$PermType;", "setPermType", "(Lcom/bytedance/ee/permission/sdk/doc/GetPublicPermissionApi$Result$PermPublic$PermType;)V", "searchEntity", "getSearchEntity", "setSearchEntity", "securityEntity", "getSecurityEntity", "setSecurityEntity", "shareEntity", "getShareEntity", "setShareEntity", "shareExternalEntity", "getShareExternalEntity", "setShareExternalEntity", "showCollaboratorInfoEntity", "getShowCollaboratorInfoEntity", "setShowCollaboratorInfoEntity", "parse", "", "json", "Lorg/json/JSONObject;", "BlockOptions", "Constraint", "ConstraintValue", "PermSourceOptions", "PermType", "permission-model_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class PermPublic implements NonProguard {

        @SerializedName("apply_embed_entity")
        @JSONField(name = "apply_embed_entity")
        private int applyEmbedEntity;

        @SerializedName("auto_share_department_entity")
        @JSONField(name = "auto_share_department_entity")
        private int autoShareDepartmentEntity;

        @SerializedName("auto_share_leader_entity")
        @JSONField(name = "auto_share_leader_entity")
        private int autoShareLeaderEntity;

        @SerializedName("auto_share_tenant_entity")
        @JSONField(name = "auto_share_tenant_entity")
        private int autoShareTenantEntity;

        @SerializedName("block_options")
        @JSONField(name = "block_options")
        private BlockOptions blockOptions;

        @SerializedName("comment_entity")
        @JSONField(name = "comment_entity")
        private int commentEntity;

        @SerializedName("constraint")
        @JSONField(name = "constraint")
        private Constraint constraint;

        @SerializedName("constraint_value")
        @JSONField(name = "constraint_value")
        private ConstraintValue constraintValue;

        @SerializedName("copy_entity")
        @JSONField(name = "copy_entity")
        private int copyEntity;

        @SerializedName("disable_ai_search_entity")
        @JSONField(name = "disable_ai_search_entity")
        private int disableAiSearchEntity;

        @SerializedName("external_access_entity")
        @JSONField(name = "external_access_entity")
        private int externalAccessEntity;

        @SerializedName("external_access_switch")
        @JSONField(name = "external_access_switch")
        private boolean externalAccessSwitch;

        @SerializedName("has_modified_link_share")
        @JSONField(name = "has_modified_link_share")
        private boolean hasModifiedLinkShare;

        @SerializedName("leader_auto_approve_entity")
        @JSONField(name = "leader_auto_approve_entity")
        private int leaderAutoApproveEntity;

        @SerializedName("leader_collaborator_role_entity")
        @JSONField(name = "leader_collaborator_role_entity")
        private int leaderCollaboratorRoleEntity;

        @SerializedName("leader_copy_switch")
        @JSONField(name = "leader_copy_switch")
        private boolean leaderCopySwitch;

        @SerializedName("leader_link_share_entity")
        @JSONField(name = "leader_link_share_entity")
        private int leaderLinkShareEntity;

        @SerializedName("leader_role_entity")
        @JSONField(name = "leader_role_entity")
        private int leaderRoleEntity;

        @SerializedName("leader_search_entity")
        @JSONField(name = "leader_search_entity")
        private int leaderSearchEntity;

        @SerializedName("link_password")
        @JSONField(name = "link_password")
        private String linkPassword;

        @SerializedName("link_password_switch")
        @JSONField(name = "link_password_switch")
        private boolean linkPasswordSwitch;

        @SerializedName("link_share_entity_v2")
        @JSONField(name = "link_share_entity_v2")
        private int linkShareEntityV2;

        @SerializedName("lock_switch")
        @JSONField(name = "lock_switch")
        private boolean lockSwitch;

        @SerializedName("manage_collaborator_entity")
        @JSONField(name = "manage_collaborator_entity")
        private int manageCollaboratorEntity;

        @SerializedName("perm_source_options")
        @JSONField(name = "perm_source_options")
        private PermSourceOptions permSourceOptions;

        @SerializedName(DocumentSettingViewModel.KEY_ACCESS_PERM_TYPE)
        @JSONField(name = DocumentSettingViewModel.KEY_ACCESS_PERM_TYPE)
        private PermType permType;

        @SerializedName("search_entity")
        @JSONField(name = "search_entity")
        private int searchEntity;

        @SerializedName("security_entity")
        @JSONField(name = "security_entity")
        private int securityEntity;

        @SerializedName("share_entity")
        @JSONField(name = "share_entity")
        private int shareEntity;

        @SerializedName("share_external_entity")
        @JSONField(name = "share_external_entity")
        private int shareExternalEntity;

        @SerializedName("show_collaborator_info_entity")
        @JSONField(name = "show_collaborator_info_entity")
        private int showCollaboratorInfoEntity;

        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b;\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001GB\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020CJ \u0010D\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010B\u001a\u00020C2\u0006\u0010E\u001a\u00020FH\u0002R&\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR&\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR&\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR&\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR&\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR&\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR&\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\tR&\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\tR&\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0007\"\u0004\b!\u0010\tR&\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0007\"\u0004\b$\u0010\tR&\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0007\"\u0004\b'\u0010\tR&\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0007\"\u0004\b*\u0010\tR&\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0007\"\u0004\b-\u0010\tR&\u0010.\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0007\"\u0004\b0\u0010\tR&\u00101\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0007\"\u0004\b3\u0010\tR&\u00104\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0007\"\u0004\b6\u0010\tR&\u00107\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0007\"\u0004\b9\u0010\tR&\u0010:\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u0007\"\u0004\b<\u0010\tR&\u0010=\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u0007\"\u0004\b?\u0010\t¨\u0006H"}, d2 = {"Lcom/bytedance/ee/permission/sdk/doc/GetPublicPermissionApi$Result$PermPublic$BlockOptions;", "Lcom/ss/android/lark/chameleon/bridge/NonProguard;", "()V", "applyEmbedEntity", "", "Lcom/bytedance/ee/permission/sdk/doc/GetPublicPermissionApi$Result$PermPublic$BlockOptions$BlockOptionItem;", "getApplyEmbedEntity", "()Ljava/util/List;", "setApplyEmbedEntity", "(Ljava/util/List;)V", "autoShareDepartmentEntity", "getAutoShareDepartmentEntity", "setAutoShareDepartmentEntity", "autoShareLeaderEntity", "getAutoShareLeaderEntity", "setAutoShareLeaderEntity", "comment", "getComment", "setComment", "copyEntity", "getCopyEntity", "setCopyEntity", "disableAiSearchEntity", "getDisableAiSearchEntity", "setDisableAiSearchEntity", "externalAccessSwitch", "getExternalAccessSwitch", "setExternalAccessSwitch", "leaderAutoApproveEntity", "getLeaderAutoApproveEntity", "setLeaderAutoApproveEntity", "leaderCollaboratorRoleEntity", "getLeaderCollaboratorRoleEntity", "setLeaderCollaboratorRoleEntity", "leaderLinkShareEntity", "getLeaderLinkShareEntity", "setLeaderLinkShareEntity", "leaderRoleEntity", "getLeaderRoleEntity", "setLeaderRoleEntity", "leaderSearchEntity", "getLeaderSearchEntity", "setLeaderSearchEntity", "linkShareEntity", "getLinkShareEntity", "setLinkShareEntity", "manageCollaboratorEntity", "getManageCollaboratorEntity", "setManageCollaboratorEntity", "searchEntity", "getSearchEntity", "setSearchEntity", AppConstants.API_HOST_SI_PREFIX, "getSecurity", "setSecurity", "shareEntity", "getShareEntity", "setShareEntity", "shareExternalEntity", "getShareExternalEntity", "setShareExternalEntity", "showCollaboratorInfoEntity", "getShowCollaboratorInfoEntity", "setShowCollaboratorInfoEntity", "parse", "", "json", "Lorg/json/JSONObject;", "parseBlockOptionEntity", "entityName", "", "BlockOptionItem", "permission-model_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class BlockOptions implements NonProguard {

            @SerializedName("apply_embed_entity")
            @JSONField(name = "apply_embed_entity")
            private List<BlockOptionItem> applyEmbedEntity;

            @SerializedName("auto_share_department_entity")
            @JSONField(name = "auto_share_department_entity")
            private List<BlockOptionItem> autoShareDepartmentEntity;

            @SerializedName("auto_share_leader_entity")
            @JSONField(name = "auto_share_leader_entity")
            private List<BlockOptionItem> autoShareLeaderEntity;

            @SerializedName("comment")
            @JSONField(name = "comment")
            private List<BlockOptionItem> comment;

            @SerializedName("copy_entity")
            @JSONField(name = "copy_entity")
            private List<BlockOptionItem> copyEntity;

            @SerializedName("disable_ai_search_entity")
            @JSONField(name = "disable_ai_search_entity")
            private List<BlockOptionItem> disableAiSearchEntity;

            @SerializedName("external_access_switch")
            @JSONField(name = "external_access_switch")
            private List<BlockOptionItem> externalAccessSwitch;

            @SerializedName("leader_auto_approve_entity")
            @JSONField(name = "leader_auto_approve_entity")
            private List<BlockOptionItem> leaderAutoApproveEntity;

            @SerializedName("leader_collaborator_role_entity")
            @JSONField(name = "leader_collaborator_role_entity")
            private List<BlockOptionItem> leaderCollaboratorRoleEntity;

            @SerializedName("leader_link_share_entity")
            @JSONField(name = "leader_link_share_entity")
            private List<BlockOptionItem> leaderLinkShareEntity;

            @SerializedName("leader_role_entity")
            @JSONField(name = "leader_role_entity")
            private List<BlockOptionItem> leaderRoleEntity;

            @SerializedName("leader_search_entity")
            @JSONField(name = "leader_search_entity")
            private List<BlockOptionItem> leaderSearchEntity;

            @SerializedName("link_share_entity")
            @JSONField(name = "link_share_entity")
            private List<BlockOptionItem> linkShareEntity;

            @SerializedName("manage_collaborator_entity")
            @JSONField(name = "manage_collaborator_entity")
            private List<BlockOptionItem> manageCollaboratorEntity;

            @SerializedName("search_entity")
            @JSONField(name = "search_entity")
            private List<BlockOptionItem> searchEntity;

            /* JADX INFO: renamed from: security, reason: collision with root package name */
            @SerializedName(AppConstants.API_HOST_SI_PREFIX)
            @JSONField(name = AppConstants.API_HOST_SI_PREFIX)
            private List<BlockOptionItem> f243052security;

            @SerializedName("share_entity")
            @JSONField(name = "share_entity")
            private List<BlockOptionItem> shareEntity;

            @SerializedName("share_external_entity")
            @JSONField(name = "share_external_entity")
            private List<BlockOptionItem> shareExternalEntity;

            @SerializedName("show_collaborator_info_entity")
            @JSONField(name = "show_collaborator_info_entity")
            private List<BlockOptionItem> showCollaboratorInfoEntity;

            @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001e\u0010\u0011\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0006\"\u0004\b\u0013\u0010\b¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ee/permission/sdk/doc/GetPublicPermissionApi$Result$PermPublic$BlockOptions$BlockOptionItem;", "Lcom/ss/android/lark/chameleon/bridge/NonProguard;", "()V", "blockType", "", "getBlockType", "()I", "setBlockType", "(I)V", "canEscape", "", "getCanEscape", "()Z", "setCanEscape", "(Z)V", "isEscaped", "setEscaped", "value", "getValue", "setValue", "parse", "", "json", "Lorg/json/JSONObject;", "permission-model_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
            public static final class BlockOptionItem implements NonProguard {

                @SerializedName("block_type")
                @JSONField(name = "block_type")
                private int blockType;

                @SerializedName("can_escape")
                @JSONField(name = "can_escape")
                private boolean canEscape;

                @SerializedName("is_escaped")
                @JSONField(name = "is_escaped")
                private boolean isEscaped;

                @SerializedName("value")
                @JSONField(name = "value")
                private int value;

                public BlockOptionItem() {
                }

                public final int getBlockType() {
                    return this.blockType;
                }

                public final boolean getCanEscape() {
                    return this.canEscape;
                }

                public final int getValue() {
                    return this.value;
                }

                public final boolean isEscaped() {
                    return this.isEscaped;
                }

                public final void parse(JSONObject r100) {
                    Intrinsics.checkNotNullParameter(r100, "json");
                    this.blockType = r100.optInt("block_type");     // Catch: Exception -> L5
                    this.value = r100.optInt("value");     // Catch: Exception -> L5
                    this.canEscape = r100.optBoolean("can_escape");     // Catch: Exception -> L5
                    this.isEscaped = r100.optBoolean("is_escaped");     // Catch: Exception -> L5
                    return;
                L5:
                    e = move-exception;
                    Log.e("GetPublicPermissionApi", "BlockOptionItem - parse, error: ", e);
                }

                public final void setBlockType(int r100) {
                    this.blockType = r100;
                }

                public final void setCanEscape(boolean r100) {
                    this.canEscape = r100;
                }

                public final void setEscaped(boolean r100) {
                    this.isEscaped = r100;
                }

                public final void setValue(int r100) {
                    this.value = r100;
                }
            }

            public BlockOptions() {
            }

            public final List<BlockOptionItem> getApplyEmbedEntity() {
                return this.applyEmbedEntity;
            }

            public final List<BlockOptionItem> getAutoShareDepartmentEntity() {
                return this.autoShareDepartmentEntity;
            }

            public final List<BlockOptionItem> getAutoShareLeaderEntity() {
                return this.autoShareLeaderEntity;
            }

            public final List<BlockOptionItem> getComment() {
                return this.comment;
            }

            public final List<BlockOptionItem> getCopyEntity() {
                return this.copyEntity;
            }

            public final List<BlockOptionItem> getDisableAiSearchEntity() {
                return this.disableAiSearchEntity;
            }

            public final List<BlockOptionItem> getExternalAccessSwitch() {
                return this.externalAccessSwitch;
            }

            public final List<BlockOptionItem> getLeaderAutoApproveEntity() {
                return this.leaderAutoApproveEntity;
            }

            public final List<BlockOptionItem> getLeaderCollaboratorRoleEntity() {
                return this.leaderCollaboratorRoleEntity;
            }

            public final List<BlockOptionItem> getLeaderLinkShareEntity() {
                return this.leaderLinkShareEntity;
            }

            public final List<BlockOptionItem> getLeaderRoleEntity() {
                return this.leaderRoleEntity;
            }

            public final List<BlockOptionItem> getLeaderSearchEntity() {
                return this.leaderSearchEntity;
            }

            public final List<BlockOptionItem> getLinkShareEntity() {
                return this.linkShareEntity;
            }

            public final List<BlockOptionItem> getManageCollaboratorEntity() {
                return this.manageCollaboratorEntity;
            }

            public final List<BlockOptionItem> getSearchEntity() {
                return this.searchEntity;
            }

            public final List<BlockOptionItem> getSecurity() {
                return this.f243052security;
            }

            public final List<BlockOptionItem> getShareEntity() {
                return this.shareEntity;
            }

            public final List<BlockOptionItem> getShareExternalEntity() {
                return this.shareExternalEntity;
            }

            public final List<BlockOptionItem> getShowCollaboratorInfoEntity() {
                return this.showCollaboratorInfoEntity;
            }

            public final void parse(JSONObject r100) {
                Intrinsics.checkNotNullParameter(r100, "json");
                this.f243052security = parseBlockOptionEntity(r100, AppConstants.API_HOST_SI_PREFIX);     // Catch: Exception -> L5
                this.linkShareEntity = parseBlockOptionEntity(r100, "link_share_entity");     // Catch: Exception -> L5
                this.shareEntity = parseBlockOptionEntity(r100, "share_entity");     // Catch: Exception -> L5
                this.shareExternalEntity = parseBlockOptionEntity(r100, "share_external_entity");     // Catch: Exception -> L5
                this.applyEmbedEntity = parseBlockOptionEntity(r100, "apply_embed_entity");     // Catch: Exception -> L5
                this.copyEntity = parseBlockOptionEntity(r100, "copy_entity");     // Catch: Exception -> L5
                this.comment = parseBlockOptionEntity(r100, "comment");     // Catch: Exception -> L5
                this.searchEntity = parseBlockOptionEntity(r100, "search_entity");     // Catch: Exception -> L5
                this.autoShareDepartmentEntity = parseBlockOptionEntity(r100, "auto_share_department_entity");     // Catch: Exception -> L5
                this.externalAccessSwitch = parseBlockOptionEntity(r100, "external_access_switch");     // Catch: Exception -> L5
                this.disableAiSearchEntity = parseBlockOptionEntity(r100, "disable_ai_search_entity");     // Catch: Exception -> L5
                this.showCollaboratorInfoEntity = parseBlockOptionEntity(r100, "show_collaborator_info_entity");     // Catch: Exception -> L5
                this.manageCollaboratorEntity = parseBlockOptionEntity(r100, "manage_collaborator_entity");     // Catch: Exception -> L5
                this.autoShareLeaderEntity = parseBlockOptionEntity(r100, "auto_share_leader_entity");     // Catch: Exception -> L5
                this.leaderSearchEntity = parseBlockOptionEntity(r100, "leader_search_entity");     // Catch: Exception -> L5
                this.leaderLinkShareEntity = parseBlockOptionEntity(r100, "leader_link_share_entity");     // Catch: Exception -> L5
                this.leaderRoleEntity = parseBlockOptionEntity(r100, "leader_role_entity");     // Catch: Exception -> L5
                this.leaderCollaboratorRoleEntity = parseBlockOptionEntity(r100, "leader_collaborator_role_entity");     // Catch: Exception -> L5
                this.leaderAutoApproveEntity = parseBlockOptionEntity(r100, "leader_auto_approve_entity");     // Catch: Exception -> L5
                return;
            L5:
                e = move-exception;
                Log.e("GetPublicPermissionApi", "BlockOptions - parse, error: ", e);
            }

            public final void setApplyEmbedEntity(List<BlockOptionItem> r100) {
                this.applyEmbedEntity = r100;
            }

            public final void setAutoShareDepartmentEntity(List<BlockOptionItem> r100) {
                this.autoShareDepartmentEntity = r100;
            }

            public final void setAutoShareLeaderEntity(List<BlockOptionItem> r100) {
                this.autoShareLeaderEntity = r100;
            }

            public final void setComment(List<BlockOptionItem> r100) {
                this.comment = r100;
            }

            public final void setCopyEntity(List<BlockOptionItem> r100) {
                this.copyEntity = r100;
            }

            public final void setDisableAiSearchEntity(List<BlockOptionItem> r100) {
                this.disableAiSearchEntity = r100;
            }

            public final void setExternalAccessSwitch(List<BlockOptionItem> r100) {
                this.externalAccessSwitch = r100;
            }

            public final void setLeaderAutoApproveEntity(List<BlockOptionItem> r100) {
                this.leaderAutoApproveEntity = r100;
            }

            public final void setLeaderCollaboratorRoleEntity(List<BlockOptionItem> r100) {
                this.leaderCollaboratorRoleEntity = r100;
            }

            public final void setLeaderLinkShareEntity(List<BlockOptionItem> r100) {
                this.leaderLinkShareEntity = r100;
            }

            public final void setLeaderRoleEntity(List<BlockOptionItem> r100) {
                this.leaderRoleEntity = r100;
            }

            public final void setLeaderSearchEntity(List<BlockOptionItem> r100) {
                this.leaderSearchEntity = r100;
            }

            public final void setLinkShareEntity(List<BlockOptionItem> r100) {
                this.linkShareEntity = r100;
            }

            public final void setManageCollaboratorEntity(List<BlockOptionItem> r100) {
                this.manageCollaboratorEntity = r100;
            }

            public final void setSearchEntity(List<BlockOptionItem> r100) {
                this.searchEntity = r100;
            }

            public final void setSecurity(List<BlockOptionItem> r100) {
                this.f243052security = r100;
            }

            public final void setShareEntity(List<BlockOptionItem> r100) {
                this.shareEntity = r100;
            }

            public final void setShareExternalEntity(List<BlockOptionItem> r100) {
                this.shareExternalEntity = r100;
            }

            public final void setShowCollaboratorInfoEntity(List<BlockOptionItem> r100) {
                this.showCollaboratorInfoEntity = r100;
            }

            private final List<BlockOptionItem> parseBlockOptionEntity(JSONObject r100, String r101) {
                JSONArray r102 = r100.optJSONArray(r101);
                if (r102 != null) goto L6;
                return null;
            L6:
                ArrayList r103 = new ArrayList();
                int r104 = r102.length();
                int r105 = 0;
            L7:
                if (r105 >= r104) goto L13;
                JSONObject r106 = r102.optJSONObject(r105);
                if (r106 == null) goto L12;
                BlockOptionItem r107 = new BlockOptionItem();
                r107.parse(r106);
                r103.add(r107);
            L12:
                r105 = r105 + 1;
                goto L7
            L13:
                return r103;
            }
        }

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ee/permission/sdk/doc/GetPublicPermissionApi$Result$PermPublic$Constraint;", "Lcom/ss/android/lark/chameleon/bridge/NonProguard;", "()V", "comment", "", "getComment", "()I", "setComment", "(I)V", "linkShareEntity", "getLinkShareEntity", "setLinkShareEntity", AppConstants.API_HOST_SI_PREFIX, "getSecurity", "setSecurity", "parse", "", "json", "Lorg/json/JSONObject;", "permission-model_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Constraint implements NonProguard {

            @SerializedName("comment")
            @JSONField(name = "comment")
            private int comment;

            @SerializedName("link_share_entity")
            @JSONField(name = "link_share_entity")
            private int linkShareEntity;

            /* JADX INFO: renamed from: security, reason: collision with root package name */
            @SerializedName(AppConstants.API_HOST_SI_PREFIX)
            @JSONField(name = AppConstants.API_HOST_SI_PREFIX)
            private int f243053security;

            public Constraint() {
            }

            public final int getComment() {
                return this.comment;
            }

            public final int getLinkShareEntity() {
                return this.linkShareEntity;
            }

            public final int getSecurity() {
                return this.f243053security;
            }

            public final void parse(JSONObject r100) {
                Intrinsics.checkNotNullParameter(r100, "json");
                this.f243053security = r100.optInt(AppConstants.API_HOST_SI_PREFIX);     // Catch: Exception -> L5
                this.comment = r100.optInt("comment");     // Catch: Exception -> L5
                this.linkShareEntity = r100.optInt("link_share_entity");     // Catch: Exception -> L5
                return;
            L5:
                e = move-exception;
                Log.e("GetPublicPermissionApi", "Constraint - parse, error: ", e);
            }

            public final void setComment(int r100) {
                this.comment = r100;
            }

            public final void setLinkShareEntity(int r100) {
                this.linkShareEntity = r100;
            }

            public final void setSecurity(int r100) {
                this.f243053security = r100;
            }
        }

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ee/permission/sdk/doc/GetPublicPermissionApi$Result$PermPublic$ConstraintValue;", "Lcom/ss/android/lark/chameleon/bridge/NonProguard;", "()V", "comment", "", "getComment", "()I", "setComment", "(I)V", "linkShareEntity", "getLinkShareEntity", "setLinkShareEntity", AppConstants.API_HOST_SI_PREFIX, "getSecurity", "setSecurity", "parse", "", "json", "Lorg/json/JSONObject;", "permission-model_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class ConstraintValue implements NonProguard {

            @SerializedName("comment")
            @JSONField(name = "comment")
            private int comment;

            @SerializedName("link_share_entity")
            @JSONField(name = "link_share_entity")
            private int linkShareEntity;

            /* JADX INFO: renamed from: security, reason: collision with root package name */
            @SerializedName(AppConstants.API_HOST_SI_PREFIX)
            @JSONField(name = AppConstants.API_HOST_SI_PREFIX)
            private int f243054security;

            public ConstraintValue() {
            }

            public final int getComment() {
                return this.comment;
            }

            public final int getLinkShareEntity() {
                return this.linkShareEntity;
            }

            public final int getSecurity() {
                return this.f243054security;
            }

            public final void parse(JSONObject r100) {
                Intrinsics.checkNotNullParameter(r100, "json");
                this.f243054security = r100.optInt(AppConstants.API_HOST_SI_PREFIX);     // Catch: Exception -> L5
                this.comment = r100.optInt("comment");     // Catch: Exception -> L5
                this.linkShareEntity = r100.optInt("link_share_entity");     // Catch: Exception -> L5
                return;
            L5:
                e = move-exception;
                Log.e("GetPublicPermissionApi", "ConstraintValue - parse, error: ", e);
            }

            public final void setComment(int r100) {
                this.comment = r100;
            }

            public final void setLinkShareEntity(int r100) {
                this.linkShareEntity = r100;
            }

            public final void setSecurity(int r100) {
                this.f243054security = r100;
            }
        }

        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001 B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ \u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002R&\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR&\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR&\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR&\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR&\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR&\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\t¨\u0006!"}, d2 = {"Lcom/bytedance/ee/permission/sdk/doc/GetPublicPermissionApi$Result$PermPublic$PermSourceOptions;", "Lcom/ss/android/lark/chameleon/bridge/NonProguard;", "()V", "applyEmbedEntity", "", "Lcom/bytedance/ee/permission/sdk/doc/GetPublicPermissionApi$Result$PermPublic$PermSourceOptions$PermSourceOptionItem;", "getApplyEmbedEntity", "()Ljava/util/List;", "setApplyEmbedEntity", "(Ljava/util/List;)V", "comment", "getComment", "setComment", "copyEntity", "getCopyEntity", "setCopyEntity", "manageCollaboratorEntity", "getManageCollaboratorEntity", "setManageCollaboratorEntity", "shareExternalEntity", "getShareExternalEntity", "setShareExternalEntity", "showCollaboratorInfoEntity", "getShowCollaboratorInfoEntity", "setShowCollaboratorInfoEntity", "parse", "", "json", "Lorg/json/JSONObject;", "parsePermSourceOptionEntity", "entityName", "", "PermSourceOptionItem", "permission-model_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class PermSourceOptions implements NonProguard {

            @SerializedName("apply_embed_entity")
            @JSONField(name = "apply_embed_entity")
            private List<PermSourceOptionItem> applyEmbedEntity;

            @SerializedName("comment")
            @JSONField(name = "comment")
            private List<PermSourceOptionItem> comment;

            @SerializedName("copy_entity")
            @JSONField(name = "copy_entity")
            private List<PermSourceOptionItem> copyEntity;

            @SerializedName("manage_collaborator_entity")
            @JSONField(name = "manage_collaborator_entity")
            private List<PermSourceOptionItem> manageCollaboratorEntity;

            @SerializedName("share_external_entity")
            @JSONField(name = "share_external_entity")
            private List<PermSourceOptionItem> shareExternalEntity;

            @SerializedName("show_collaborator_info_entity")
            @JSONField(name = "show_collaborator_info_entity")
            private List<PermSourceOptionItem> showCollaboratorInfoEntity;

            @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/permission/sdk/doc/GetPublicPermissionApi$Result$PermPublic$PermSourceOptions$PermSourceOptionItem;", "Lcom/ss/android/lark/chameleon/bridge/NonProguard;", "()V", "source", "", "getSource", "()I", "setSource", "(I)V", "parse", "", "json", "Lorg/json/JSONObject;", "permission-model_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
            public static final class PermSourceOptionItem implements NonProguard {

                @SerializedName("source")
                @JSONField(name = "source")
                private int source;

                public PermSourceOptionItem() {
                }

                public final int getSource() {
                    return this.source;
                }

                public final void parse(JSONObject r100) {
                    Intrinsics.checkNotNullParameter(r100, "json");
                    this.source = r100.optInt("source");     // Catch: Exception -> L5
                    return;
                L5:
                    e = move-exception;
                    Log.e("GetPublicPermissionApi", "PermSourceOptionItem - parse, error: ", e);
                }

                public final void setSource(int r100) {
                    this.source = r100;
                }
            }

            public PermSourceOptions() {
            }

            public final List<PermSourceOptionItem> getApplyEmbedEntity() {
                return this.applyEmbedEntity;
            }

            public final List<PermSourceOptionItem> getComment() {
                return this.comment;
            }

            public final List<PermSourceOptionItem> getCopyEntity() {
                return this.copyEntity;
            }

            public final List<PermSourceOptionItem> getManageCollaboratorEntity() {
                return this.manageCollaboratorEntity;
            }

            public final List<PermSourceOptionItem> getShareExternalEntity() {
                return this.shareExternalEntity;
            }

            public final List<PermSourceOptionItem> getShowCollaboratorInfoEntity() {
                return this.showCollaboratorInfoEntity;
            }

            public final void parse(JSONObject r100) {
                Intrinsics.checkNotNullParameter(r100, "json");
                this.showCollaboratorInfoEntity = parsePermSourceOptionEntity(r100, "show_collaborator_info_entity");     // Catch: Exception -> L5
                this.comment = parsePermSourceOptionEntity(r100, "comment");     // Catch: Exception -> L5
                this.manageCollaboratorEntity = parsePermSourceOptionEntity(r100, "manage_collaborator_entity");     // Catch: Exception -> L5
                this.shareExternalEntity = parsePermSourceOptionEntity(r100, "share_external_entity");     // Catch: Exception -> L5
                this.copyEntity = parsePermSourceOptionEntity(r100, "copy_entity");     // Catch: Exception -> L5
                this.applyEmbedEntity = parsePermSourceOptionEntity(r100, "apply_embed_entity");     // Catch: Exception -> L5
                return;
            L5:
                e = move-exception;
                Log.e("GetPublicPermissionApi", "PermSourceOptions - parse, error: ", e);
            }

            public final void setApplyEmbedEntity(List<PermSourceOptionItem> r100) {
                this.applyEmbedEntity = r100;
            }

            public final void setComment(List<PermSourceOptionItem> r100) {
                this.comment = r100;
            }

            public final void setCopyEntity(List<PermSourceOptionItem> r100) {
                this.copyEntity = r100;
            }

            public final void setManageCollaboratorEntity(List<PermSourceOptionItem> r100) {
                this.manageCollaboratorEntity = r100;
            }

            public final void setShareExternalEntity(List<PermSourceOptionItem> r100) {
                this.shareExternalEntity = r100;
            }

            public final void setShowCollaboratorInfoEntity(List<PermSourceOptionItem> r100) {
                this.showCollaboratorInfoEntity = r100;
            }

            private final List<PermSourceOptionItem> parsePermSourceOptionEntity(JSONObject r100, String r101) {
                JSONArray r102 = r100.optJSONArray(r101);
                if (r102 != null) goto L6;
                return null;
            L6:
                ArrayList r103 = new ArrayList();
                int r104 = r102.length();
                int r105 = 0;
            L7:
                if (r105 >= r104) goto L13;
                JSONObject r106 = r102.optJSONObject(r105);
                if (r106 == null) goto L12;
                PermSourceOptionItem r107 = new PermSourceOptionItem();
                r107.parse(r106);
                r103.add(r107);
            L12:
                r105 = r105 + 1;
                goto L7
            L13:
                return r103;
            }
        }

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ee/permission/sdk/doc/GetPublicPermissionApi$Result$PermPublic$PermType;", "Lcom/ss/android/lark/chameleon/bridge/NonProguard;", "()V", "externalAccessSwitch", "", "getExternalAccessSwitch", "()I", "setExternalAccessSwitch", "(I)V", "linkShareEntity", "getLinkShareEntity", "setLinkShareEntity", "searchEntity", "getSearchEntity", "setSearchEntity", "parse", "", "json", "Lorg/json/JSONObject;", "permission-model_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class PermType implements NonProguard {

            @SerializedName("external_access_switch")
            @JSONField(name = "external_access_switch")
            private int externalAccessSwitch;

            @SerializedName("link_share_entity")
            @JSONField(name = "link_share_entity")
            private int linkShareEntity;

            @SerializedName("search_entity")
            @JSONField(name = "search_entity")
            private int searchEntity;

            public PermType() {
            }

            public final int getExternalAccessSwitch() {
                return this.externalAccessSwitch;
            }

            public final int getLinkShareEntity() {
                return this.linkShareEntity;
            }

            public final int getSearchEntity() {
                return this.searchEntity;
            }

            public final void parse(JSONObject r100) {
                Intrinsics.checkNotNullParameter(r100, "json");
                this.linkShareEntity = r100.optInt("link_share_entity");     // Catch: Exception -> L5
                this.externalAccessSwitch = r100.optInt("external_access_switch");     // Catch: Exception -> L5
                this.searchEntity = r100.optInt("search_entity");     // Catch: Exception -> L5
                return;
            L5:
                e = move-exception;
                Log.e("GetPublicPermissionApi", "PermType - parse, error: ", e);
            }

            public final void setExternalAccessSwitch(int r100) {
                this.externalAccessSwitch = r100;
            }

            public final void setLinkShareEntity(int r100) {
                this.linkShareEntity = r100;
            }

            public final void setSearchEntity(int r100) {
                this.searchEntity = r100;
            }
        }

        public PermPublic() {
            this.linkPassword = "";
        }

        public final int getApplyEmbedEntity() {
            return this.applyEmbedEntity;
        }

        public final int getAutoShareDepartmentEntity() {
            return this.autoShareDepartmentEntity;
        }

        public final int getAutoShareLeaderEntity() {
            return this.autoShareLeaderEntity;
        }

        public final int getAutoShareTenantEntity() {
            return this.autoShareTenantEntity;
        }

        public final BlockOptions getBlockOptions() {
            return this.blockOptions;
        }

        public final int getCommentEntity() {
            return this.commentEntity;
        }

        public final Constraint getConstraint() {
            return this.constraint;
        }

        public final ConstraintValue getConstraintValue() {
            return this.constraintValue;
        }

        public final int getCopyEntity() {
            return this.copyEntity;
        }

        public final int getDisableAiSearchEntity() {
            return this.disableAiSearchEntity;
        }

        public final int getExternalAccessEntity() {
            return this.externalAccessEntity;
        }

        public final boolean getExternalAccessSwitch() {
            return this.externalAccessSwitch;
        }

        public final boolean getHasModifiedLinkShare() {
            return this.hasModifiedLinkShare;
        }

        public final int getLeaderAutoApproveEntity() {
            return this.leaderAutoApproveEntity;
        }

        public final int getLeaderCollaboratorRoleEntity() {
            return this.leaderCollaboratorRoleEntity;
        }

        public final boolean getLeaderCopySwitch() {
            return this.leaderCopySwitch;
        }

        public final int getLeaderLinkShareEntity() {
            return this.leaderLinkShareEntity;
        }

        public final int getLeaderRoleEntity() {
            return this.leaderRoleEntity;
        }

        public final int getLeaderSearchEntity() {
            return this.leaderSearchEntity;
        }

        public final String getLinkPassword() {
            return this.linkPassword;
        }

        public final boolean getLinkPasswordSwitch() {
            return this.linkPasswordSwitch;
        }

        public final int getLinkShareEntityV2() {
            return this.linkShareEntityV2;
        }

        public final boolean getLockSwitch() {
            return this.lockSwitch;
        }

        public final int getManageCollaboratorEntity() {
            return this.manageCollaboratorEntity;
        }

        public final PermSourceOptions getPermSourceOptions() {
            return this.permSourceOptions;
        }

        public final PermType getPermType() {
            return this.permType;
        }

        public final int getSearchEntity() {
            return this.searchEntity;
        }

        public final int getSecurityEntity() {
            return this.securityEntity;
        }

        public final int getShareEntity() {
            return this.shareEntity;
        }

        public final int getShareExternalEntity() {
            return this.shareExternalEntity;
        }

        public final int getShowCollaboratorInfoEntity() {
            return this.showCollaboratorInfoEntity;
        }

        public final void parse(JSONObject r100) {
            Intrinsics.checkNotNullParameter(r100, "json");
            this.securityEntity = r100.optInt("security_entity");     // Catch: Exception -> L24
            this.linkShareEntityV2 = r100.optInt("link_share_entity_v2");     // Catch: Exception -> L24
            this.hasModifiedLinkShare = r100.optBoolean("has_modified_link_share");     // Catch: Exception -> L24
            this.shareEntity = r100.optInt("share_entity");     // Catch: Exception -> L24
            this.shareExternalEntity = r100.optInt("share_external_entity");     // Catch: Exception -> L24
            this.showCollaboratorInfoEntity = r100.optInt("show_collaborator_info_entity");     // Catch: Exception -> L24
            this.manageCollaboratorEntity = r100.optInt("manage_collaborator_entity");     // Catch: Exception -> L24
            this.copyEntity = r100.optInt("copy_entity");     // Catch: Exception -> L24
            this.commentEntity = r100.optInt("comment_entity");     // Catch: Exception -> L24
            this.applyEmbedEntity = r100.optInt("apply_embed_entity");     // Catch: Exception -> L24
            this.searchEntity = r100.optInt("search_entity");     // Catch: Exception -> L24
            this.disableAiSearchEntity = r100.optInt("disable_ai_search_entity");     // Catch: Exception -> L24
            this.externalAccessSwitch = r100.optBoolean("external_access_switch");     // Catch: Exception -> L24
            this.externalAccessEntity = r100.optInt("external_access_entity");     // Catch: Exception -> L24
            this.linkPasswordSwitch = r100.optBoolean("link_password_switch");     // Catch: Exception -> L24
            this.linkPassword = r100.optString("link_password");     // Catch: Exception -> L24
            this.autoShareDepartmentEntity = r100.optInt("auto_share_department_entity");     // Catch: Exception -> L24
            this.autoShareTenantEntity = r100.optInt("auto_share_tenant_entity");     // Catch: Exception -> L24
            this.lockSwitch = r100.optBoolean("lock_switch");     // Catch: Exception -> L24
            this.leaderLinkShareEntity = r100.optInt("leader_link_share_entity");     // Catch: Exception -> L24
            this.leaderSearchEntity = r100.optInt("leader_search_entity");     // Catch: Exception -> L24
            this.leaderCopySwitch = r100.optBoolean("leader_copy_switch");     // Catch: Exception -> L24
            this.autoShareLeaderEntity = r100.optInt("auto_share_leader_entity");     // Catch: Exception -> L24
            this.leaderRoleEntity = r100.optInt("leader_role_entity");     // Catch: Exception -> L24
            this.leaderCollaboratorRoleEntity = r100.optInt("leader_collaborator_role_entity");     // Catch: Exception -> L24
            this.leaderAutoApproveEntity = r100.optInt("leader_auto_approve_entity");     // Catch: Exception -> L24
            JSONObject r101 = r100.optJSONObject(DocumentSettingViewModel.KEY_ACCESS_PERM_TYPE);     // Catch: Exception -> L24
            PermSourceOptions r102 = null;
            if (r101 == null) goto L6;
            PermType r103 = new PermType();     // Catch: Exception -> L24
            r103.parse(r101);     // Catch: Exception -> L24
        L7:
            this.permType = r103;     // Catch: Exception -> L24
            JSONObject r104 = r100.optJSONObject("block_options");     // Catch: Exception -> L24
            if (r104 == null) goto L10;
            BlockOptions r105 = new BlockOptions();     // Catch: Exception -> L24
            r105.parse(r104);     // Catch: Exception -> L24
        L11:
            this.blockOptions = r105;     // Catch: Exception -> L24
            JSONObject r106 = r100.optJSONObject("constraint");     // Catch: Exception -> L24
            if (r106 == null) goto L14;
            Constraint r107 = new Constraint();     // Catch: Exception -> L24
            r107.parse(r106);     // Catch: Exception -> L24
        L15:
            this.constraint = r107;     // Catch: Exception -> L24
            JSONObject r108 = r100.optJSONObject("constraint_value");     // Catch: Exception -> L24
            if (r108 == null) goto L18;
            ConstraintValue r109 = new ConstraintValue();     // Catch: Exception -> L24
            r109.parse(r108);     // Catch: Exception -> L24
        L19:
            this.constraintValue = r109;     // Catch: Exception -> L24
            JSONObject r110 = r100.optJSONObject("perm_source_options");     // Catch: Exception -> L24
            if (r110 == null) goto L22;
            r102 = new PermSourceOptions();     // Catch: Exception -> L24
            r102.parse(r110);     // Catch: Exception -> L24
        L22:
            this.permSourceOptions = r102;     // Catch: Exception -> L24
            return;
        L18:
            r109 = null;
            goto L19
        L14:
            r107 = null;
            goto L15
        L10:
            r105 = null;
            goto L11
        L6:
            r103 = null;
        L24:
            e = move-exception;
            Log.e("GetPublicPermissionApi", "PermPublic - parse, error: ", e);
        }

        public final void setApplyEmbedEntity(int r100) {
            this.applyEmbedEntity = r100;
        }

        public final void setAutoShareDepartmentEntity(int r100) {
            this.autoShareDepartmentEntity = r100;
        }

        public final void setAutoShareLeaderEntity(int r100) {
            this.autoShareLeaderEntity = r100;
        }

        public final void setAutoShareTenantEntity(int r100) {
            this.autoShareTenantEntity = r100;
        }

        public final void setBlockOptions(BlockOptions r100) {
            this.blockOptions = r100;
        }

        public final void setCommentEntity(int r100) {
            this.commentEntity = r100;
        }

        public final void setConstraint(Constraint r100) {
            this.constraint = r100;
        }

        public final void setConstraintValue(ConstraintValue r100) {
            this.constraintValue = r100;
        }

        public final void setCopyEntity(int r100) {
            this.copyEntity = r100;
        }

        public final void setDisableAiSearchEntity(int r100) {
            this.disableAiSearchEntity = r100;
        }

        public final void setExternalAccessEntity(int r100) {
            this.externalAccessEntity = r100;
        }

        public final void setExternalAccessSwitch(boolean r100) {
            this.externalAccessSwitch = r100;
        }

        public final void setHasModifiedLinkShare(boolean r100) {
            this.hasModifiedLinkShare = r100;
        }

        public final void setLeaderAutoApproveEntity(int r100) {
            this.leaderAutoApproveEntity = r100;
        }

        public final void setLeaderCollaboratorRoleEntity(int r100) {
            this.leaderCollaboratorRoleEntity = r100;
        }

        public final void setLeaderCopySwitch(boolean r100) {
            this.leaderCopySwitch = r100;
        }

        public final void setLeaderLinkShareEntity(int r100) {
            this.leaderLinkShareEntity = r100;
        }

        public final void setLeaderRoleEntity(int r100) {
            this.leaderRoleEntity = r100;
        }

        public final void setLeaderSearchEntity(int r100) {
            this.leaderSearchEntity = r100;
        }

        public final void setLinkPassword(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.linkPassword = r100;
        }

        public final void setLinkPasswordSwitch(boolean r100) {
            this.linkPasswordSwitch = r100;
        }

        public final void setLinkShareEntityV2(int r100) {
            this.linkShareEntityV2 = r100;
        }

        public final void setLockSwitch(boolean r100) {
            this.lockSwitch = r100;
        }

        public final void setManageCollaboratorEntity(int r100) {
            this.manageCollaboratorEntity = r100;
        }

        public final void setPermSourceOptions(PermSourceOptions r100) {
            this.permSourceOptions = r100;
        }

        public final void setPermType(PermType r100) {
            this.permType = r100;
        }

        public final void setSearchEntity(int r100) {
            this.searchEntity = r100;
        }

        public final void setSecurityEntity(int r100) {
            this.securityEntity = r100;
        }

        public final void setShareEntity(int r100) {
            this.shareEntity = r100;
        }

        public final void setShareExternalEntity(int r100) {
            this.shareExternalEntity = r100;
        }

        public final void setShowCollaboratorInfoEntity(int r100) {
            this.showCollaboratorInfoEntity = r100;
        }
    }

    public GetPublicPermissionApi$Result() {
        this.partnerTenantIds = new ArrayList();
        this.reportPublicPermJson = "";
    }

    public final boolean getAdminCanCross() {
        return this.adminCanCross;
    }

    public final int getAdminExternalAccess() {
        return this.adminExternalAccess;
    }

    public final boolean getAnonymousVerify() {
        return this.anonymousVerify;
    }

    public final boolean getCanUnlock() {
        return this.canUnlock;
    }

    public final ConfigInfo getConfigInfo() {
        return this.configInfo;
    }

    public final Label getLabel() {
        return this.label;
    }

    public final int getOwnerPermType() {
        return this.ownerPermType;
    }

    public final List<String> getPartnerTenantIds() {
        return this.partnerTenantIds;
    }

    public final PermPublic getPublicPerm() {
        return this.publicPerm;
    }

    public final String getReportPublicPermJson() {
        return this.reportPublicPermJson;
    }

    public final boolean isOwner() {
        return this.isOwner;
    }

    public final void parse(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "json");
        this.isOwner = r100.optBoolean("is_owner");     // Catch: Exception -> L21
        this.ownerPermType = r100.optInt("owner_perm_type");     // Catch: Exception -> L21
        this.adminExternalAccess = r100.optInt("admin_external_access");     // Catch: Exception -> L21
        this.anonymousVerify = r100.optBoolean("anonymous_verify");     // Catch: Exception -> L21
        this.canUnlock = r100.optBoolean("can_unlock");     // Catch: Exception -> L21
        this.adminCanCross = r100.optBoolean("admin_can_cross");     // Catch: Exception -> L21
        ArrayList r101 = new ArrayList();     // Catch: Exception -> L21
        JSONArray r102 = r100.optJSONArray("partner_tenant_ids");     // Catch: Exception -> L21
        if (r102 == null) goto L8;
        int r103 = r102.length();     // Catch: Exception -> L21
        int r104 = 0;
    L6:
        if (r104 >= r103) goto L8;
        r101.add(r102.optString(r104));     // Catch: Exception -> L21
        r104 = r104 + 1;     // Catch: Exception -> L21
    L8:
        this.partnerTenantIds = r101;     // Catch: Exception -> L21
        JSONObject r105 = r100.optJSONObject("label");     // Catch: Exception -> L21
        ConfigInfo r106 = null;
        if (r105 == null) goto L11;
        Label r107 = new Label();     // Catch: Exception -> L21
        r107.parse(r105);     // Catch: Exception -> L21
    L12:
        this.label = r107;     // Catch: Exception -> L21
        JSONObject r108 = r100.optJSONObject("perm_public");     // Catch: Exception -> L21
        if (r108 == null) goto L15;
        PermPublic r109 = new PermPublic();     // Catch: Exception -> L21
        r109.parse(r108);     // Catch: Exception -> L21
    L16:
        this.publicPerm = r109;     // Catch: Exception -> L21
        JSONObject r110 = r100.optJSONObject("config_info");     // Catch: Exception -> L21
        if (r110 == null) goto L19;
        r106 = new ConfigInfo();     // Catch: Exception -> L21
        r106.parse(r110);     // Catch: Exception -> L21
    L19:
        this.configInfo = r106;     // Catch: Exception -> L21
        return;
    L15:
        r109 = null;
        goto L16
    L11:
        r107 = null;
    L21:
        e = move-exception;
        Log.e("GetPublicPermissionApi", "Result - parse, error: ", e);
    }

    public final void setReportPublicPermJson(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.reportPublicPermJson = r100;
    }
}
