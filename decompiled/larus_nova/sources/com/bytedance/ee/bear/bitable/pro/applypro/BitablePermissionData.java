package com.bytedance.ee.bear.bitable.pro.applypro;

import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.bear.document.permission.PermissionData;
import com.bytedance.ee.util.io.NonProguard;
import com.bytedance.sdk.account.platform.api.IGoogleService;
import com.huawei.hms.support.feature.result.CommonConstant;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0004\f\r\u000e\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/bear/bitable/pro/applypro/BitablePermissionData;", "Lcom/bytedance/ee/bear/document/permission/PermissionData;", "<init>", "()V", "bitableProInfo", "Lcom/bytedance/ee/bear/bitable/pro/applypro/BitablePermissionData$BitableProInfoData;", "getBitableProInfo", "()Lcom/bytedance/ee/bear/bitable/pro/applypro/BitablePermissionData$BitableProInfoData;", "setBitableProInfo", "(Lcom/bytedance/ee/bear/bitable/pro/applypro/BitablePermissionData$BitableProInfoData;)V", "toString", "", "BitableProInfoData", "Owner", "Extra", "OwnerInfo", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitablePermissionData extends PermissionData {
    private BitableProInfoData bitableProInfo;

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u001f\u001a\u00020\u0005J\b\u0010 \u001a\u00020\rH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0006\"\u0004\b\n\u0010\bR*\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006!"}, d2 = {"Lcom/bytedance/ee/bear/bitable/pro/applypro/BitablePermissionData$BitableProInfoData;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "isAdvancedBase", "", "()Z", "setAdvancedBase", "(Z)V", "isBaseAdmin", "setBaseAdmin", "applyRoleIDs", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getApplyRoleIDs", "()Ljava/util/ArrayList;", "setApplyRoleIDs", "(Ljava/util/ArrayList;)V", "owner", "Lcom/bytedance/ee/bear/bitable/pro/applypro/BitablePermissionData$Owner;", "getOwner", "()Lcom/bytedance/ee/bear/bitable/pro/applypro/BitablePermissionData$Owner;", "setOwner", "(Lcom/bytedance/ee/bear/bitable/pro/applypro/BitablePermissionData$Owner;)V", "extra", "Lcom/bytedance/ee/bear/bitable/pro/applypro/BitablePermissionData$Extra;", "getExtra", "()Lcom/bytedance/ee/bear/bitable/pro/applypro/BitablePermissionData$Extra;", "setExtra", "(Lcom/bytedance/ee/bear/bitable/pro/applypro/BitablePermissionData$Extra;)V", "needApplyPro", "toString", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class BitableProInfoData implements NonProguard {
        private ArrayList<String> applyRoleIDs;
        private Extra extra;
        private boolean isAdvancedBase;
        private boolean isBaseAdmin;
        private Owner owner;

        public final boolean needApplyPro() {
            if (this.isAdvancedBase == true) goto L5;
        L9:
            return false;
        L5:
            if (this.isBaseAdmin == true) goto L9;
            if (this.applyRoleIDs.isEmpty() == false) goto L9;
            return true;
        }

        public String toString() {
            return "BitableProInfoData(isAdvancedBase=" + this.isAdvancedBase + ", isBaseAdmin=" + this.isBaseAdmin + ", applyRoleIDs=" + this.applyRoleIDs.size() + ", owner=" + this.owner + ", extra=" + this.extra + ')';
        }

        public BitableProInfoData() {
            this.applyRoleIDs = new ArrayList();
        }

        public final ArrayList<String> getApplyRoleIDs() {
            return this.applyRoleIDs;
        }

        public final Extra getExtra() {
            return this.extra;
        }

        public final Owner getOwner() {
            return this.owner;
        }

        public final boolean isAdvancedBase() {
            return this.isAdvancedBase;
        }

        public final boolean isBaseAdmin() {
            return this.isBaseAdmin;
        }

        public final void setAdvancedBase(boolean r100) {
            this.isAdvancedBase = r100;
        }

        public final void setApplyRoleIDs(ArrayList<String> r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.applyRoleIDs = r100;
        }

        public final void setBaseAdmin(boolean r100) {
            this.isBaseAdmin = r100;
        }

        public final void setExtra(Extra r100) {
            this.extra = r100;
        }

        public final void setOwner(Owner r100) {
            this.owner = r100;
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/pro/applypro/BitablePermissionData$Extra;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "ownerInfo", "Lcom/bytedance/ee/bear/bitable/pro/applypro/BitablePermissionData$OwnerInfo;", "getOwnerInfo", "()Lcom/bytedance/ee/bear/bitable/pro/applypro/BitablePermissionData$OwnerInfo;", "setOwnerInfo", "(Lcom/bytedance/ee/bear/bitable/pro/applypro/BitablePermissionData$OwnerInfo;)V", "toString", "", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Extra implements NonProguard {
        private OwnerInfo ownerInfo;

        public Extra() {
        }

        public String toString() {
            return "Extra(ownerInfo=" + this.ownerInfo + ')';
        }

        public final OwnerInfo getOwnerInfo() {
            return this.ownerInfo;
        }

        public final void setOwnerInfo(OwnerInfo r100) {
            this.ownerInfo = r100;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0013\u001a\u00020\u0005H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR \u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ee/bear/bitable/pro/applypro/BitablePermissionData$Owner;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "name", "getName", "setName", "enName", "getEnName", "setEnName", CommonConstant.KEY_DISPLAY_NAME, "getDisplayName", "setDisplayName", "toString", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Owner implements NonProguard {

        @JSONField(name = IGoogleService.ResponseKey.DISPLAY_NAME)
        private String displayName;

        @JSONField(name = "en_name")
        private String enName;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private String f215148id;
        private String name;

        public Owner() {
        }

        public String toString() {
            StringBuilder r100 = new StringBuilder("Owner(name=");
            boolean r101 = true;
            if (this.name == null) goto L5;
            boolean r102 = true;
        L6:
            r100.append(r102);
            r100.append(", en_name=");
            if (this.enName == null) goto L9;
            boolean r103 = true;
        L10:
            r100.append(r103);
            r100.append(", display_name=");
            if (this.displayName != null) goto L14;
            r101 = false;
        L14:
            r100.append(r101);
            r100.append(')');
            return r100.toString();
        L9:
            r103 = false;
            goto L10
        L5:
            r102 = false;
            goto L6
        }

        public final String getDisplayName() {
            return this.displayName;
        }

        public final String getEnName() {
            return this.enName;
        }

        public final String getId() {
            return this.f215148id;
        }

        public final String getName() {
            return this.name;
        }

        public final void setDisplayName(String r100) {
            this.displayName = r100;
        }

        public final void setEnName(String r100) {
            this.enName = r100;
        }

        public final void setId(String r100) {
            this.f215148id = r100;
        }

        public final void setName(String r100) {
            this.name = r100;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0013\u001a\u00020\u0005H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ee/bear/bitable/pro/applypro/BitablePermissionData$OwnerInfo;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "userID", "", "getUserID", "()Ljava/lang/String;", "setUserID", "(Ljava/lang/String;)V", "name", "getName", "setName", "enName", "getEnName", "setEnName", "i18nName", "getI18nName", "setI18nName", "toString", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class OwnerInfo implements NonProguard {
        private String enName;
        private String i18nName;
        private String name;
        private String userID;

        public OwnerInfo() {
        }

        public String toString() {
            StringBuilder r100 = new StringBuilder("OwnerInfo(name!=null ");
            boolean r101 = true;
            if (this.name == null) goto L5;
            boolean r102 = true;
        L6:
            r100.append(r102);
            r100.append(", enName!=null ");
            if (this.enName == null) goto L9;
            boolean r103 = true;
        L10:
            r100.append(r103);
            r100.append(", i18nName!=null ");
            if (this.i18nName != null) goto L14;
            r101 = false;
        L14:
            r100.append(r101);
            r100.append(')');
            return r100.toString();
        L9:
            r103 = false;
            goto L10
        L5:
            r102 = false;
            goto L6
        }

        public final String getEnName() {
            return this.enName;
        }

        public final String getI18nName() {
            return this.i18nName;
        }

        public final String getName() {
            return this.name;
        }

        public final String getUserID() {
            return this.userID;
        }

        public final void setEnName(String r100) {
            this.enName = r100;
        }

        public final void setI18nName(String r100) {
            this.i18nName = r100;
        }

        public final void setName(String r100) {
            this.name = r100;
        }

        public final void setUserID(String r100) {
            this.userID = r100;
        }
    }

    @Override // com.bytedance.ee.bear.document.permission.PermissionData
    public String toString() {
        return "BitablePermissionData(bitableProInfo=" + this.bitableProInfo + ')' + super.toString();
    }

    public BitablePermissionData() {
    }

    public final BitableProInfoData getBitableProInfo() {
        return this.bitableProInfo;
    }

    public final void setBitableProInfo(BitableProInfoData r100) {
        this.bitableProInfo = r100;
    }
}
