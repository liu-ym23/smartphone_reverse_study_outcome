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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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

        public void setAdmin_can_cross(boolean r1) {
            this.admin_can_cross = r1;
        }

        public void setAnonymous_verify(boolean r1) {
            this.anonymous_verify = r1;
        }

        public void setCan_unlock(boolean r1) {
            this.can_unlock = r1;
        }

        public void setComment_entity(int r1) {
            this.comment_entity = r1;
        }

        public void setExternal_access(boolean r1) {
            this.external_access = r1;
        }

        public void setHas_link_password(boolean r1) {
            this.has_link_password = r1;
        }

        public void setInvite_external(boolean r1) {
            this.invite_external = r1;
        }

        public void setIs_owner(boolean r1) {
            this.is_owner = r1;
        }

        public void setLink_password(String r1) {
            this.link_password = r1;
        }

        public void setLink_share_entity(int r1) {
            this.link_share_entity = r1;
        }

        public void setLock_state(boolean r1) {
            this.lock_state = r1;
        }

        public void setSecurity_entity(int r1) {
            this.security_entity = r1;
        }

        public void setShare_entity(int r1) {
            this.share_entity = r1;
        }

        public void setVisibilityStatus(int r1) {
            this.visibility_status = r1;
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

        public void setActions(UserActions r1) {
            this.actions = r1;
        }

        public void setAuthReasons(AuthReason r1) {
            this.auth_reasons = r1;
        }

        public void setIs_owner(boolean r1) {
            this.is_owner = r1;
        }

        public void setPermission_status_code(int r1) {
            this.permission_status_code = r1;
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

        public void setCode(int r1) {
            this.code = r1;
        }

        public void setData(UserData r1) {
            this.data = r1;
        }

        public void setMsg(String r1) {
            this.msg = r1;
        }
    }

    public PermissionData() {
    }

    private UserActions getUserActions() {
        UserPermissionV2 r0 = this.userPermissionsV2;
        if (r0 != null) goto L5;
        return null;
    L5:
        UserData r1 = r0.getData();
        if (r1 != null) goto L9;
        return null;
    L9:
        return r1.getActions();
    }

    public boolean disableApplyPerm() {
        OwnerInfo r0 = this.owner;
        if (r0 == null) goto L20;
        String r1 = r0.getTenant_id();
        AccountService$Account r2 = ((h0) a.a(h0.class)).G2();
        if (r2 == null) goto L7;
        String r3 = r2.tenantId;
    L9:
        if (TextUtils.isEmpty(r1) == false) goto L11;
    L13:
        boolean r4 = false;
    L15:
        if (this.owner.isAdmin_can_cross() == true) goto L18;
        if (r4 == true) goto L18;
        return true;
    L18:
        return false;
    L11:
        if (TextUtils.equals(r1, r3) == false) goto L13;
        r4 = true;
        goto L15
    L7:
        r3 = "";
        goto L9
    L20:
        return true;
    }

    public boolean isAuthViewByAuthLeaderFa() {
        UserPermissionV2 r0 = this.userPermissionsV2;
        if (r0 != null) goto L5;
    L11:
        return false;
    L5:
        if (r0.getData() == null) goto L11;
        if (this.userPermissionsV2.getData().getAuthReasons() == null) goto L11;
        if (this.userPermissionsV2.getData().getAuthReasons().getView() != 100003) goto L11;
        return true;
    }

    public boolean isConditionAccessControl() {
        UserPermissionV2 r0 = this.userPermissionsV2;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.getData() != null) goto L7;
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
        UserPermissionV2 r0 = this.userPermissionsV2;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.getData() != null) goto L7;
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
        UserPermissionV2 r0 = this.userPermissionsV2;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.getData() != null) goto L7;
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
        UserPermissionV2 r0 = this.userPermissionsV2;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.getData() != null) goto L7;
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
        UserActions r0 = getUserActions();
        if (r0 != null) goto L6;
        return false;
    L6:
        if (r0.getPerceive() == 1) goto L8;
        return false;
    L8:
        if (r0.getView() != 2002) goto L12;
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

    public void setCode(int r1) {
        this.code = r1;
    }

    public void setOwner(OwnerInfo r1) {
        this.owner = r1;
    }

    public void setPermissionStatusCode(int r1) {
        this.permission_status_code = r1;
    }

    public void setPublicPermissions(PublicPermissions r1) {
        this.publicPermissions = r1;
    }

    public void setReportJsonString(String r1) {
        this.reportJsonString = r1;
    }

    public void setToken(String r1) {
        this.token = r1;
    }

    public void setType(int r1) {
        this.type = r1;
    }

    public void setUserPermissions(int r1) {
        this.userPermissions = r1;
    }

    public void setUserPermissionsV2(UserPermissionV2 r1) {
        this.userPermissionsV2 = r1;
    }
}
