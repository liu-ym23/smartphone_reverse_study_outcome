package com.bytedance.ee.bear.middleground_permission_export.model.doc;

import com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptions;
import com.bytedance.ee.util.io.NonProguard;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001d\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001QJ\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&J\u000f\u0010\n\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\u0003H&J\b\u0010\r\u001a\u00020\u0003H&J\b\u0010\u000e\u001a\u00020\u0003H&J\b\u0010\u000f\u001a\u00020\u0003H&J\b\u0010\u0010\u001a\u00020\u0003H&J\b\u0010\u0011\u001a\u00020\u0003H&J\b\u0010\u0012\u001a\u00020\u0003H&J\b\u0010\u0013\u001a\u00020\u0003H&J\b\u0010\u0014\u001a\u00020\u0003H&J\b\u0010\u0015\u001a\u00020\u0003H&J\b\u0010\u0016\u001a\u00020\u0003H&J\b\u0010\u0017\u001a\u00020\u0003H&J\b\u0010\u0018\u001a\u00020\u0003H&J\b\u0010\u0019\u001a\u00020\u0003H&J\b\u0010\u001a\u001a\u00020\u0003H&J\b\u0010\u001b\u001a\u00020\u0003H&J\b\u0010\u001c\u001a\u00020\u0003H&J\b\u0010\u001d\u001a\u00020\u0003H&J\b\u0010\u001e\u001a\u00020\u0003H&J\b\u0010\u001f\u001a\u00020\u0003H&J\b\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020!H\u0016J\b\u0010#\u001a\u00020!H\u0016J\b\u0010$\u001a\u00020!H\u0016J\b\u0010%\u001a\u00020!H\u0016J\b\u0010&\u001a\u00020!H\u0016J\b\u0010'\u001a\u00020\u0003H\u0016J\b\u0010(\u001a\u00020!H\u0016J\b\u0010)\u001a\u00020\u0003H&J\b\u0010*\u001a\u00020\u0003H&J\b\u0010+\u001a\u00020\u0003H&J\b\u0010,\u001a\u00020\u0003H&J\b\u0010-\u001a\u00020\u0003H&J\b\u0010.\u001a\u00020\u0003H&J\b\u0010/\u001a\u00020\u0003H&J\b\u00100\u001a\u00020\u0003H&J\b\u00101\u001a\u00020\u0003H&J\b\u00102\u001a\u000203H&J\b\u00104\u001a\u00020\u0003H&J\b\u00105\u001a\u00020\u0003H&J\b\u00106\u001a\u00020\u0003H&J\b\u00107\u001a\u000203H&J\u0010\u00108\u001a\u0002092\u0006\u0010)\u001a\u00020\u0003H&J\u0010\u0010:\u001a\u0002092\u0006\u0010;\u001a\u00020\u0003H&J\u0010\u0010<\u001a\u0002092\u0006\u0010=\u001a\u000203H&J\b\u0010>\u001a\u00020\u0003H&J\b\u0010?\u001a\u00020\u0003H&J\b\u0010@\u001a\u00020\u0003H&J\b\u0010A\u001a\u00020\u0003H&J\b\u0010B\u001a\u00020\u0003H&J\b\u0010C\u001a\u00020\u0003H&J\b\u0010D\u001a\u00020\u0003H&J\b\u0010E\u001a\u00020\u0003H&J\b\u0010F\u001a\u00020\u0003H&J\b\u0010G\u001a\u00020\u0003H&J\u0012\u0010H\u001a\u00020\u00032\b\u0010I\u001a\u0004\u0018\u000103H&J\b\u0010J\u001a\u00020KH\u0016J\n\u0010L\u001a\u0004\u0018\u00010MH\u0016J\u000f\u0010N\u001a\u0004\u0018\u00010!H\u0016¢\u0006\u0002\u0010OJ\u000f\u0010P\u001a\u0004\u0018\u00010!H\u0016¢\u0006\u0002\u0010O¨\u0006R"}, d2 = {"Lcom/bytedance/ee/bear/middleground_permission_export/model/doc/IDocPublicPermission;", "Lcom/bytedance/ee/util/io/NonProguard;", "isLinkShareClose", "", "isLinkShareInternalRead", "isLinkShareInternalEdit", "isLinkSharePartnerTenantRead", "isLinkSharePartnerTenantEdit", "isLinkShareAnyoneRead", "isLinkShareAnyoneEdit", "hasModifiedLinkShare", "()Ljava/lang/Boolean;", "isSearchableTenant", "isSearchableKnownLink", "isCommentWithRead", "isCommentWithEdit", "isShareOnlyMe", "isShareInternal", "isShareAnyone", "isSecurityWithRead", "isSecurityWithEdit", "isSecurityWithFA", "isCopyWithRead", "isCopyWithEdit", "isCopyWithFA", "canLeaderCopy", "isShowCollaboratorInfoRead", "isShowCollaboratorInfoEdit", "isShowCollaboratorInfoFA", "isOpenLinkWithRead", "isOpenLinkWithEdit", "isOpenLinkWithFA", "getLinkShareAnyoneReadBlockValue", "", "getLinkShareAnyoneEditBlockValue", "getLinkSharePartnerTenantReadBlockValue", "getLinkSharePartnerTenantEditBlockValue", "getExternalAccessOpenBlockValue", "getExternalAccessCloseBlockValue", "canExternalAccessOpenEscape", "getPartnerTenantAccessBlockValue", "isOwner", "isSinglePageOwner", "isContainerOwner", "adminCanCross", "adminPartnerTenantCross", "externalAccess", "partnerTenantCross", "inviteExternal", "hasLinkPassword", "linkPassword", "", "anonymousVerify", "isLock", "canUnLock", "getReportJson", "setOwner", "", "setHasPassword", "hasPassword", "setPassword", "password", "isManagerCollaboratorTenant", "isManagerCollaboratorAnyone", "isManagerCollaboratorWithRead", "isManagerCollaboratorWithEdit", "isManagerCollaboratorWithFA", "isShareExternalWithRead", "isShareExternalWithEdit", "isShareExternalWithFA", "isExternalAccessPermTypeSinglePage", "isLinkSharePermTypeSinglePage", "isPartnerTenant", "tenantId", "getBlockOptions", "Lcom/bytedance/ee/bear/middleground_permission_export/model/folder/BlockOptions;", "getConfigInfo", "Lcom/bytedance/ee/bear/middleground_permission_export/model/doc/IDocPublicPermission$ConfigInfo;", "getLinkShareEntityV2", "()Ljava/lang/Integer;", "getVisibilityStatus", "ConfigInfo", "middleground-permission-export-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IDocPublicPermission extends NonProguard {

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/middleground_permission_export/model/doc/IDocPublicPermission$ConfigInfo;", "Ljava/io/Serializable;", "leaderSearchNumber", "", "<init>", "(I)V", "getLeaderSearchNumber", "Companion", "middleground-permission-export-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ConfigInfo implements Serializable {
        public static final String CONFIG_LEADER_SEARCH_NUMBER_KEY = "leader_search_number";
        public static final a Companion = null;
        private int leaderSearchNumber;

        public static final class a {
            public a() {
            }
        }

        static {
            Companion = new a();
        }

        public ConfigInfo() {
            int r100 = 0;
            this(r100, 1, null);
        }

        public final int getLeaderSearchNumber() {
            return this.leaderSearchNumber;
        }

        public ConfigInfo(int r100) {
            this.leaderSearchNumber = r100;
        }

        public /* synthetic */ ConfigInfo(int r100, int r101, DefaultConstructorMarker r102) {
            if ((r101 & 1) == 0) goto L5;
            r100 = 0;
        L5:
            this(r100);
        }
    }

    boolean adminCanCross();

    boolean adminPartnerTenantCross();

    boolean anonymousVerify();

    boolean canExternalAccessOpenEscape();

    boolean canLeaderCopy();

    boolean canUnLock();

    boolean externalAccess();

    BlockOptions getBlockOptions();

    ConfigInfo getConfigInfo();

    int getExternalAccessCloseBlockValue();

    int getExternalAccessOpenBlockValue();

    int getLinkShareAnyoneEditBlockValue();

    int getLinkShareAnyoneReadBlockValue();

    Integer getLinkShareEntityV2();

    int getLinkSharePartnerTenantEditBlockValue();

    int getLinkSharePartnerTenantReadBlockValue();

    int getPartnerTenantAccessBlockValue();

    String getReportJson();

    Integer getVisibilityStatus();

    boolean hasLinkPassword();

    Boolean hasModifiedLinkShare();

    boolean inviteExternal();

    boolean isCommentWithEdit();

    boolean isCommentWithRead();

    boolean isContainerOwner();

    boolean isCopyWithEdit();

    boolean isCopyWithFA();

    boolean isCopyWithRead();

    boolean isExternalAccessPermTypeSinglePage();

    boolean isLinkShareAnyoneEdit();

    boolean isLinkShareAnyoneRead();

    boolean isLinkShareClose();

    boolean isLinkShareInternalEdit();

    boolean isLinkShareInternalRead();

    boolean isLinkSharePartnerTenantEdit();

    boolean isLinkSharePartnerTenantRead();

    boolean isLinkSharePermTypeSinglePage();

    boolean isLock();

    boolean isManagerCollaboratorAnyone();

    boolean isManagerCollaboratorTenant();

    boolean isManagerCollaboratorWithEdit();

    boolean isManagerCollaboratorWithFA();

    boolean isManagerCollaboratorWithRead();

    boolean isOpenLinkWithEdit();

    boolean isOpenLinkWithFA();

    boolean isOpenLinkWithRead();

    boolean isOwner();

    boolean isPartnerTenant(String r100);

    boolean isSearchableKnownLink();

    boolean isSearchableTenant();

    boolean isSecurityWithEdit();

    boolean isSecurityWithFA();

    boolean isSecurityWithRead();

    boolean isShareAnyone();

    boolean isShareExternalWithEdit();

    boolean isShareExternalWithFA();

    boolean isShareExternalWithRead();

    boolean isShareInternal();

    boolean isShareOnlyMe();

    boolean isShowCollaboratorInfoEdit();

    boolean isShowCollaboratorInfoFA();

    boolean isShowCollaboratorInfoRead();

    boolean isSinglePageOwner();

    String linkPassword();

    boolean partnerTenantCross();

    void setHasPassword(boolean r100);

    void setOwner(boolean r100);

    void setPassword(String r100);
}
