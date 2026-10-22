package com.bytedance.ee.bear.document.permission;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.middleground.permission.permission.doc.AuthReason;
import com.bytedance.ee.bear.middleground.permission.permission.doc.DocPermissionAction;
import com.bytedance.ee.bear.share.export.OwnerInfo;
import com.bytedance.ee.util.io.NonProguard;
import org.koin.java.a;

/* JADX INFO: loaded from: classes16.dex */
public class PermissionData implements NonProguard {
    private int code;
    private OwnerInfo owner;
    private int permission_status_code;
    private PublicPermissions publicPermissions;
    private String reportJsonString;
    private String token;
    private int type;
    private int userPermissions;
    private UserPermissionV2 userPermissionsV2;

    public static class PublicPermissions implements NonProguard {
        private boolean admin_can_cross;
        private boolean anonymous_verify;
        private boolean can_unlock;
        private int comment_entity;
        private boolean external_access;
        private boolean has_link_password;
        private boolean invite_external;
        private boolean is_owner;
        private String link_password;
        private int link_share_entity;
        private boolean lock_state;
        private int security_entity;
        private int share_entity;
        private int visibility_status;

        public PublicPermissions() {
        }

        public String toString() {
            return "PublicPermissions{link_share_entity=" + this.link_share_entity + ", comment_entity=" + this.comment_entity + ", share_entity=" + this.share_entity + ", security_entity=" + this.security_entity + ", visibility_status=" + this.visibility_status + ", is_owner=" + this.is_owner + ", admin_can_cross=" + this.admin_can_cross + ", link_password='" + this.link_password + "', has_link_password=" + this.has_link_password + ", anonymous_verify=" + this.anonymous_verify + ", external_access=" + this.external_access + ", invite_external=" + this.invite_external + ", lock_state=" + this.lock_state + ", can_unlock=" + this.can_unlock + '}';
        }

        @JSONField(serialize = false)
        public String getReportJsonString() {
            return JSON.toJSONString(this);
        }

        public int getComment_entity() {
            return this.comment_entity;
        }

        public String getLink_password() {
            return this.link_password;
        }

        public int getLink_share_entity() {
            return this.link_share_entity;
        }

        public int getSecurity_entity() {
            return this.security_entity;
        }

        public int getShare_entity() {
            return this.share_entity;
        }

        public int getVisibilityStatus() {
            return this.visibility_status;
        }

        public boolean isAdmin_can_cross() {
            return this.admin_can_cross;
        }

        public boolean isAnonymous_verify() {
            return this.anonymous_verify;
        }

        public boolean isCan_unlock() {
            return this.can_unlock;
        }

        public boolean isExternal_access() {
            return this.external_access;
        }

        public boolean isHas_link_password() {
            return this.has_link_password;
        }

        public boolean isInvite_external() {
            return this.invite_external;
        }

        public boolean isIs_owner() {
            return this.is_owner;
        }

        public boolean isLock_state() {
            return this.lock_state;
        }

        public void setAdmin_can_cross(boolean r100) {
            this.admin_can_cross = r100;
        }

        public void setAnonymous_verify(boolean r100) {
            this.anonymous_verify = r100;
        }

        public void setCan_unlock(boolean r100) {
            this.can_unlock = r100;
        }

        public void setComment_entity(int r100) {
            this.comment_entity = r100;
        }

        public void setExternal_access(boolean r100) {
            this.external_access = r100;
        }

        public void setHas_link_password(boolean r100) {
            this.has_link_password = r100;
        }

        public void setInvite_external(boolean r100) {
            this.invite_external = r100;
        }

        public void setIs_owner(boolean r100) {
            this.is_owner = r100;
        }

        public void setLink_password(String r100) {
            this.link_password = r100;
        }

        public void setLink_share_entity(int r100) {
            this.link_share_entity = r100;
        }

        public void setLock_state(boolean r100) {
            this.lock_state = r100;
        }

        public void setSecurity_entity(int r100) {
            this.security_entity = r100;
        }

        public void setShare_entity(int r100) {
            this.share_entity = r100;
        }

        public void setVisibilityStatus(int r100) {
            this.visibility_status = r100;
        }
    }

    public static class UserActions extends DocPermissionAction implements NonProguard {
        public UserActions() {
        }
    }

    public static class UserData implements NonProguard {
        private UserActions actions;
        private AuthReason auth_reasons;
        private boolean is_owner;
        private int permission_status_code;

        public UserData() {
        }

        public String toString() {
            return "UserData{actions=" + this.actions + ", is_owner=" + this.is_owner + ", permission_status_code=" + this.permission_status_code + '}';
        }

        public UserActions getActions() {
            return this.actions;
        }

        public AuthReason getAuthReasons() {
            return this.auth_reasons;
        }

        public int getPermission_status_code() {
            return this.permission_status_code;
        }

        public boolean isIs_owner() {
            return this.is_owner;
        }

        public void setActions(UserActions r100) {
            this.actions = r100;
        }

        public void setAuthReasons(AuthReason r100) {
            this.auth_reasons = r100;
        }

        public void setIs_owner(boolean r100) {
            this.is_owner = r100;
        }

        public void setPermission_status_code(int r100) {
            this.permission_status_code = r100;
        }
    }

    public static class UserPermissionV2 implements NonProguard {
        private int code;
        private UserData data;
        private String msg;

        public UserPermissionV2() {
        }

        public String toString() {
            return "UserPermissionV2{data=" + this.data + ", code=" + this.code + '}';
        }

        public int getCode() {
            return this.code;
        }

        public UserData getData() {
            return this.data;
        }

        public String getMsg() {
            return this.msg;
        }

        public void setCode(int r100) {
            this.code = r100;
        }

        public void setData(UserData r100) {
            this.data = r100;
        }

        public void setMsg(String r100) {
            this.msg = r100;
        }
    }

    public PermissionData() {
    }

    private UserActions getUserActions() {
        UserPermissionV2 r100 = this.userPermissionsV2;
        if (r100 != null) goto L5;
        return null;
    L5:
        UserData r101 = r100.getData();
        if (r101 != null) goto L9;
        return null;
    L9:
        return r101.getActions();
    }

    public boolean disableApplyPerm() {
        OwnerInfo r100 = this.owner;
        if (r100 == null) goto L20;
        String r101 = r100.getTenant_id();
        AccountService$Account r102 = ((h0) a.a(h0.class)).G2();
        if (r102 == null) goto L7;
        String r103 = r102.tenantId;
    L9:
        if (TextUtils.isEmpty(r101) == false) goto L11;
    L13:
        boolean r104 = false;
    L15:
        if (this.owner.isAdmin_can_cross() == true) goto L18;
        if (r104 == true) goto L18;
        return true;
    L18:
        return false;
    L11:
        if (TextUtils.equals(r101, r103) == false) goto L13;
        r104 = true;
        goto L15
    L7:
        r103 = "";
        goto L9
    L20:
        return true;
    }

    public boolean isAuthViewByAuthLeaderFa() {
        UserPermissionV2 r100 = this.userPermissionsV2;
        if (r100 != null) goto L5;
    L11:
        return false;
    L5:
        if (r100.getData() == null) goto L11;
        if (this.userPermissionsV2.getData().getAuthReasons() == null) goto L11;
        if (this.userPermissionsV2.getData().getAuthReasons().getView() != 100003) goto L11;
        return true;
    }

    public boolean isConditionAccessControl() {
        UserPermissionV2 r100 = this.userPermissionsV2;
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.getData() != null) goto L7;
        return false;
    L7:
        if (this.userPermissionsV2.getData().getActions() != null) goto L9;
        return false;
    L9:
        if (this.userPermissionsV2.getData().getActions().getPerceive() == 2002) goto L11;
        return false;
    L11:
        if (this.userPermissionsV2.getData().getActions().getView() != 2002) goto L19;
        return true;
    L19:
        return false;
    }

    public boolean isControlByDLPInnerControl() {
        UserPermissionV2 r100 = this.userPermissionsV2;
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.getData() != null) goto L7;
        return false;
    L7:
        if (this.userPermissionsV2.getData().getActions() != null) goto L9;
        return false;
    L9:
        if (this.userPermissionsV2.getData().getActions().getPerceive() == 2005) goto L11;
        return false;
    L11:
        if (this.userPermissionsV2.getData().getActions().getView() != 2005) goto L19;
        return true;
    L19:
        return false;
    }

    public boolean isPerceiveControl() {
        UserPermissionV2 r100 = this.userPermissionsV2;
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.getData() != null) goto L7;
        return false;
    L7:
        if (this.userPermissionsV2.getData().getActions() != null) goto L9;
        return false;
    L9:
        if (this.userPermissionsV2.getData().getActions().getPerceive() == 1) goto L11;
        return false;
    L11:
        if (this.userPermissionsV2.getData().getActions().getView() == 1) goto L18;
        return true;
    L18:
        return false;
    }

    public boolean isViewBlockByAuditControl() {
        UserPermissionV2 r100 = this.userPermissionsV2;
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.getData() != null) goto L7;
        return false;
    L7:
        if (this.userPermissionsV2.getData().getActions() != null) goto L9;
        return false;
    L9:
        if (this.userPermissionsV2.getData().getActions().getView() != 202) goto L16;
        return true;
    L16:
        return false;
    }

    public String toString() {
        return "PermissionData{type=" + this.type + ", userPermissions=" + this.userPermissions + ", publicPermissions=" + this.publicPermissions + ", code=" + this.code + ", permission_status_code=" + this.permission_status_code + ", owner=" + this.owner + ", userPermissionsV2=" + this.userPermissionsV2 + '}';
    }

    public boolean isViewControlledByCAC() {
        UserActions r100 = getUserActions();
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.getPerceive() == 1) goto L8;
        return false;
    L8:
        if (r100.getView() != 2002) goto L12;
        return true;
    L12:
        return false;
    }

    public int getCode() {
        return this.code;
    }

    public OwnerInfo getOwner() {
        return this.owner;
    }

    public int getPermissionStatusCode() {
        return this.permission_status_code;
    }

    public PublicPermissions getPublicPermissions() {
        return this.publicPermissions;
    }

    public String getReportJsonString() {
        return this.reportJsonString;
    }

    public String getToken() {
        return this.token;
    }

    public int getType() {
        return this.type;
    }

    public int getUserPermissions() {
        return this.userPermissions;
    }

    public UserPermissionV2 getUserPermissionsV2() {
        return this.userPermissionsV2;
    }

    public void setCode(int r100) {
        this.code = r100;
    }

    public void setOwner(OwnerInfo r100) {
        this.owner = r100;
    }

    public void setPermissionStatusCode(int r100) {
        this.permission_status_code = r100;
    }

    public void setPublicPermissions(PublicPermissions r100) {
        this.publicPermissions = r100;
    }

    public void setReportJsonString(String r100) {
        this.reportJsonString = r100;
    }

    public void setToken(String r100) {
        this.token = r100;
    }

    public void setType(int r100) {
        this.type = r100;
    }

    public void setUserPermissions(int r100) {
        this.userPermissions = r100;
    }

    public void setUserPermissionsV2(UserPermissionV2 r100) {
        this.userPermissionsV2 = r100;
    }
}
