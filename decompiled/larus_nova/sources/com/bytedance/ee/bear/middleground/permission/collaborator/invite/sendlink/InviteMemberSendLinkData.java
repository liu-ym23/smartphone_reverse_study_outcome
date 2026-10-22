package com.bytedance.ee.bear.middleground.permission.collaborator.invite.sendlink;

import com.bytedance.ee.bear.middleground.permission.collaborator.NotNotifyUserEntity;
import com.bytedance.ee.util.io.NonProguard;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0099\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\u0011\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J\u0011\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J\u0011\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J\u0011\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J\u0011\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J\u0011\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J\u0011\u0010.\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J\u009b\u0001\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0001J\u0013\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u000103HÖ\u0003J\t\u00104\u001a\u00020\u0003HÖ\u0001J\t\u00105\u001a\u000206HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0017\"\u0004\b\u001b\u0010\u0019R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019R\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0017\"\u0004\b!\u0010\u0019R\"\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0017\"\u0004\b#\u0010\u0019R\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0017\"\u0004\b%\u0010\u0019¨\u00067"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/collaborator/invite/sendlink/InviteMemberSendLinkData;", "Lcom/bytedance/ee/util/io/NonProguard;", "sendLinkLimitNum", "", "askOwnerLimitNum", "notNotifyUsers", "", "Lcom/bytedance/ee/bear/middleground/permission/collaborator/NotNotifyUserEntity;", "blockUsers", "blockedUsers", "privacyUsers", "inviteFailedUsers", "limitUsers", "ownerNotInGroups", "<init>", "(IILjava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getSendLinkLimitNum", "()I", "setSendLinkLimitNum", "(I)V", "getAskOwnerLimitNum", "setAskOwnerLimitNum", "getNotNotifyUsers", "()Ljava/util/List;", "setNotNotifyUsers", "(Ljava/util/List;)V", "getBlockUsers", "setBlockUsers", "getBlockedUsers", "setBlockedUsers", "getPrivacyUsers", "setPrivacyUsers", "getInviteFailedUsers", "setInviteFailedUsers", "getLimitUsers", "setLimitUsers", "getOwnerNotInGroups", "setOwnerNotInGroups", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "toString", "", "middleground-permission-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InviteMemberSendLinkData implements NonProguard {
    private int askOwnerLimitNum;
    private List<? extends NotNotifyUserEntity> blockUsers;
    private List<? extends NotNotifyUserEntity> blockedUsers;
    private List<? extends NotNotifyUserEntity> inviteFailedUsers;
    private List<? extends NotNotifyUserEntity> limitUsers;
    private List<? extends NotNotifyUserEntity> notNotifyUsers;
    private List<? extends NotNotifyUserEntity> ownerNotInGroups;
    private List<? extends NotNotifyUserEntity> privacyUsers;
    private int sendLinkLimitNum;

    public InviteMemberSendLinkData() {
        this(0, 0, null, null, null, null, null, null, null, 511, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ InviteMemberSendLinkData copy$default(InviteMemberSendLinkData r110, int r111, int r112, List r113, List r114, List r115, List r116, List r117, List r118, List r119, int r210, Object r211) {
        if ((r210 & 1) == 0) goto L5;
        int r100 = r110.sendLinkLimitNum;
    L7:
        if ((r210 & 2) == 0) goto L9;
        int r101 = r110.askOwnerLimitNum;
    L11:
        if ((r210 & 4) == 0) goto L13;
        List r102 = r110.notNotifyUsers;
    L15:
        if ((r210 & 8) == 0) goto L17;
        List r103 = r110.blockUsers;
    L19:
        if ((r210 & 16) == 0) goto L21;
        List r104 = r110.blockedUsers;
    L23:
        if ((r210 & 32) == 0) goto L25;
        List r105 = r110.privacyUsers;
    L27:
        if ((r210 & 64) == 0) goto L29;
        List r106 = r110.inviteFailedUsers;
    L31:
        if ((r210 & 128) == 0) goto L33;
        List r107 = r110.limitUsers;
    L35:
        if ((r210 & 256) == 0) goto L37;
        List r108 = r110.ownerNotInGroups;
    L39:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r108);
    L37:
        r108 = r119;
        goto L39
    L33:
        r107 = r118;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final int component1() {
        return this.sendLinkLimitNum;
    }

    public final int component2() {
        return this.askOwnerLimitNum;
    }

    public final List<NotNotifyUserEntity> component3() {
        return this.notNotifyUsers;
    }

    public final List<NotNotifyUserEntity> component4() {
        return this.blockUsers;
    }

    public final List<NotNotifyUserEntity> component5() {
        return this.blockedUsers;
    }

    public final List<NotNotifyUserEntity> component6() {
        return this.privacyUsers;
    }

    public final List<NotNotifyUserEntity> component7() {
        return this.inviteFailedUsers;
    }

    public final List<NotNotifyUserEntity> component8() {
        return this.limitUsers;
    }

    public final List<NotNotifyUserEntity> component9() {
        return this.ownerNotInGroups;
    }

    public final InviteMemberSendLinkData copy(int r110, int r111, List<? extends NotNotifyUserEntity> r112, List<? extends NotNotifyUserEntity> r113, List<? extends NotNotifyUserEntity> r114, List<? extends NotNotifyUserEntity> r115, List<? extends NotNotifyUserEntity> r116, List<? extends NotNotifyUserEntity> r117, List<? extends NotNotifyUserEntity> r210) {
        return new InviteMemberSendLinkData(r110, r111, r112, r113, r114, r115, r116, r117, r210);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof InviteMemberSendLinkData) == true) goto L8;
        return false;
    L8:
        InviteMemberSendLinkData r101 = (InviteMemberSendLinkData) r100;
        if (this.sendLinkLimitNum == r101.sendLinkLimitNum) goto L12;
        return false;
    L12:
        if (this.askOwnerLimitNum == r101.askOwnerLimitNum) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.notNotifyUsers, r101.notNotifyUsers) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.blockUsers, r101.blockUsers) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.blockedUsers, r101.blockedUsers) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.privacyUsers, r101.privacyUsers) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.inviteFailedUsers, r101.inviteFailedUsers) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.limitUsers, r101.limitUsers) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.ownerNotInGroups, r101.ownerNotInGroups) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.sendLinkLimitNum * 31) + this.askOwnerLimitNum) * 31;
        List<? extends NotNotifyUserEntity> r101 = this.notNotifyUsers;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        List<? extends NotNotifyUserEntity> r105 = this.blockUsers;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        List<? extends NotNotifyUserEntity> r108 = this.blockedUsers;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        List<? extends NotNotifyUserEntity> r111 = this.privacyUsers;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        List<? extends NotNotifyUserEntity> r114 = this.inviteFailedUsers;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        List<? extends NotNotifyUserEntity> r117 = this.limitUsers;
        if (r117 != null) goto L25;
        int r118 = 0;
    L26:
        int r119 = (r116 + r118) * 31;
        List<? extends NotNotifyUserEntity> r120 = this.ownerNotInGroups;
        if (r120 == null) goto L31;
        r102 = r120.hashCode();
    L31:
        return r119 + r102;
    L25:
        r118 = r117.hashCode();
        goto L26
    L21:
        r115 = r114.hashCode();
        goto L22
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "InviteMemberSendLinkData(sendLinkLimitNum=" + this.sendLinkLimitNum + ", askOwnerLimitNum=" + this.askOwnerLimitNum + ", notNotifyUsers=" + this.notNotifyUsers + ", blockUsers=" + this.blockUsers + ", blockedUsers=" + this.blockedUsers + ", privacyUsers=" + this.privacyUsers + ", inviteFailedUsers=" + this.inviteFailedUsers + ", limitUsers=" + this.limitUsers + ", ownerNotInGroups=" + this.ownerNotInGroups + ')';
    }

    public final int getAskOwnerLimitNum() {
        return this.askOwnerLimitNum;
    }

    public final List<NotNotifyUserEntity> getBlockUsers() {
        return this.blockUsers;
    }

    public final List<NotNotifyUserEntity> getBlockedUsers() {
        return this.blockedUsers;
    }

    public final List<NotNotifyUserEntity> getInviteFailedUsers() {
        return this.inviteFailedUsers;
    }

    public final List<NotNotifyUserEntity> getLimitUsers() {
        return this.limitUsers;
    }

    public final List<NotNotifyUserEntity> getNotNotifyUsers() {
        return this.notNotifyUsers;
    }

    public final List<NotNotifyUserEntity> getOwnerNotInGroups() {
        return this.ownerNotInGroups;
    }

    public final List<NotNotifyUserEntity> getPrivacyUsers() {
        return this.privacyUsers;
    }

    public final int getSendLinkLimitNum() {
        return this.sendLinkLimitNum;
    }

    public final void setAskOwnerLimitNum(int r100) {
        this.askOwnerLimitNum = r100;
    }

    public final void setBlockUsers(List<? extends NotNotifyUserEntity> r100) {
        this.blockUsers = r100;
    }

    public final void setBlockedUsers(List<? extends NotNotifyUserEntity> r100) {
        this.blockedUsers = r100;
    }

    public final void setInviteFailedUsers(List<? extends NotNotifyUserEntity> r100) {
        this.inviteFailedUsers = r100;
    }

    public final void setLimitUsers(List<? extends NotNotifyUserEntity> r100) {
        this.limitUsers = r100;
    }

    public final void setNotNotifyUsers(List<? extends NotNotifyUserEntity> r100) {
        this.notNotifyUsers = r100;
    }

    public final void setOwnerNotInGroups(List<? extends NotNotifyUserEntity> r100) {
        this.ownerNotInGroups = r100;
    }

    public final void setPrivacyUsers(List<? extends NotNotifyUserEntity> r100) {
        this.privacyUsers = r100;
    }

    public final void setSendLinkLimitNum(int r100) {
        this.sendLinkLimitNum = r100;
    }

    public InviteMemberSendLinkData(int r100, int r101, List<? extends NotNotifyUserEntity> r102, List<? extends NotNotifyUserEntity> r103, List<? extends NotNotifyUserEntity> r104, List<? extends NotNotifyUserEntity> r105, List<? extends NotNotifyUserEntity> r106, List<? extends NotNotifyUserEntity> r107, List<? extends NotNotifyUserEntity> r108) {
        this.sendLinkLimitNum = r100;
        this.askOwnerLimitNum = r101;
        this.notNotifyUsers = r102;
        this.blockUsers = r103;
        this.blockedUsers = r104;
        this.privacyUsers = r105;
        this.inviteFailedUsers = r106;
        this.limitUsers = r107;
        this.ownerNotInGroups = r108;
    }

    public /* synthetic */ InviteMemberSendLinkData(int r110, int r111, List r112, List r113, List r114, List r115, List r116, List r117, List r118, int r210, DefaultConstructorMarker r211) {
        if ((r210 & 1) == 0) goto L5;
        int r100 = 5;
    L7:
        if ((r210 & 2) == 0) goto L9;
        int r101 = 20;
    L10:
        List r102 = null;
        if ((r210 & 4) == 0) goto L13;
        List r103 = null;
    L15:
        if ((r210 & 8) == 0) goto L17;
        List r104 = null;
    L19:
        if ((r210 & 16) == 0) goto L21;
        List r105 = null;
    L23:
        if ((r210 & 32) == 0) goto L25;
        List r106 = null;
    L27:
        if ((r210 & 64) == 0) goto L29;
        List r107 = null;
    L31:
        if ((r210 & 128) == 0) goto L33;
        List r108 = null;
    L35:
        if ((r210 & 256) != 0) goto L38;
        r102 = r118;
    L38:
        this(r100, r101, r103, r104, r105, r106, r107, r108, r102);
        return;
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L10
    L5:
        r100 = r110;
        goto L7
    }
}
