package com.bytedance.ee.bear.middleground.permission.collaborator.invite.sendlink;

import com.bytedance.ee.bear.middleground.permission.collaborator.NotNotifyUserEntity;
import com.bytedance.ee.util.io.NonProguard;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
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
    public static /* synthetic */ InviteMemberSendLinkData copy$default(InviteMemberSendLinkData r10, int r11, int r12, List r13, List r14, List r15, List r16, List r17, List r18, List r19, int r20, Object r21) {
        if ((r20 & 1) == 0) goto L5;
        int r2 = r10.sendLinkLimitNum;
    L7:
        if ((r20 & 2) == 0) goto L9;
        int r3 = r10.askOwnerLimitNum;
    L11:
        if ((r20 & 4) == 0) goto L13;
        List r4 = r10.notNotifyUsers;
    L15:
        if ((r20 & 8) == 0) goto L17;
        List r5 = r10.blockUsers;
    L19:
        if ((r20 & 16) == 0) goto L21;
        List r6 = r10.blockedUsers;
    L23:
        if ((r20 & 32) == 0) goto L25;
        List r7 = r10.privacyUsers;
    L27:
        if ((r20 & 64) == 0) goto L29;
        List r8 = r10.inviteFailedUsers;
    L31:
        if ((r20 & 128) == 0) goto L33;
        List r9 = r10.limitUsers;
    L35:
        if ((r20 & 256) == 0) goto L37;
        List r1 = r10.ownerNotInGroups;
    L39:
        return r10.copy(r2, r3, r4, r5, r6, r7, r8, r9, r1);
    L37:
        r1 = r19;
        goto L39
    L33:
        r9 = r18;
        goto L35
    L29:
        r8 = r17;
        goto L31
    L25:
        r7 = r16;
        goto L27
    L21:
        r6 = r15;
        goto L23
    L17:
        r5 = r14;
        goto L19
    L13:
        r4 = r13;
        goto L15
    L9:
        r3 = r12;
        goto L11
    L5:
        r2 = r11;
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

    public final InviteMemberSendLinkData copy(int r12, int r13, List<? extends NotNotifyUserEntity> r14, List<? extends NotNotifyUserEntity> r15, List<? extends NotNotifyUserEntity> r16, List<? extends NotNotifyUserEntity> r17, List<? extends NotNotifyUserEntity> r18, List<? extends NotNotifyUserEntity> r19, List<? extends NotNotifyUserEntity> r20) {
        return new InviteMemberSendLinkData(r12, r13, r14, r15, r16, r17, r18, r19, r20);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof InviteMemberSendLinkData) == true) goto L8;
        return false;
    L8:
        InviteMemberSendLinkData r6 = (InviteMemberSendLinkData) r5;
        if (this.sendLinkLimitNum == r6.sendLinkLimitNum) goto L12;
        return false;
    L12:
        if (this.askOwnerLimitNum == r6.askOwnerLimitNum) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.notNotifyUsers, r6.notNotifyUsers) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.blockUsers, r6.blockUsers) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.blockedUsers, r6.blockedUsers) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.privacyUsers, r6.privacyUsers) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.inviteFailedUsers, r6.inviteFailedUsers) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.limitUsers, r6.limitUsers) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.ownerNotInGroups, r6.ownerNotInGroups) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.sendLinkLimitNum * 31) + this.askOwnerLimitNum) * 31;
        List<? extends NotNotifyUserEntity> r1 = this.notNotifyUsers;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        List<? extends NotNotifyUserEntity> r5 = this.blockUsers;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        List<? extends NotNotifyUserEntity> r8 = this.blockedUsers;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        List<? extends NotNotifyUserEntity> r11 = this.privacyUsers;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        List<? extends NotNotifyUserEntity> r14 = this.inviteFailedUsers;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        List<? extends NotNotifyUserEntity> r17 = this.limitUsers;
        if (r17 != null) goto L25;
        int r18 = 0;
    L26:
        int r19 = (r16 + r18) * 31;
        List<? extends NotNotifyUserEntity> r20 = this.ownerNotInGroups;
        if (r20 == null) goto L31;
        r2 = r20.hashCode();
    L31:
        return r19 + r2;
    L25:
        r18 = r17.hashCode();
        goto L26
    L21:
        r15 = r14.hashCode();
        goto L22
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
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

    public final void setAskOwnerLimitNum(int r1) {
        this.askOwnerLimitNum = r1;
    }

    public final void setBlockUsers(List<? extends NotNotifyUserEntity> r1) {
        this.blockUsers = r1;
    }

    public final void setBlockedUsers(List<? extends NotNotifyUserEntity> r1) {
        this.blockedUsers = r1;
    }

    public final void setInviteFailedUsers(List<? extends NotNotifyUserEntity> r1) {
        this.inviteFailedUsers = r1;
    }

    public final void setLimitUsers(List<? extends NotNotifyUserEntity> r1) {
        this.limitUsers = r1;
    }

    public final void setNotNotifyUsers(List<? extends NotNotifyUserEntity> r1) {
        this.notNotifyUsers = r1;
    }

    public final void setOwnerNotInGroups(List<? extends NotNotifyUserEntity> r1) {
        this.ownerNotInGroups = r1;
    }

    public final void setPrivacyUsers(List<? extends NotNotifyUserEntity> r1) {
        this.privacyUsers = r1;
    }

    public final void setSendLinkLimitNum(int r1) {
        this.sendLinkLimitNum = r1;
    }

    public InviteMemberSendLinkData(int r1, int r2, List<? extends NotNotifyUserEntity> r3, List<? extends NotNotifyUserEntity> r4, List<? extends NotNotifyUserEntity> r5, List<? extends NotNotifyUserEntity> r6, List<? extends NotNotifyUserEntity> r7, List<? extends NotNotifyUserEntity> r8, List<? extends NotNotifyUserEntity> r9) {
        this.sendLinkLimitNum = r1;
        this.askOwnerLimitNum = r2;
        this.notNotifyUsers = r3;
        this.blockUsers = r4;
        this.blockedUsers = r5;
        this.privacyUsers = r6;
        this.inviteFailedUsers = r7;
        this.limitUsers = r8;
        this.ownerNotInGroups = r9;
    }

    public /* synthetic */ InviteMemberSendLinkData(int r11, int r12, List r13, List r14, List r15, List r16, List r17, List r18, List r19, int r20, DefaultConstructorMarker r21) {
        if ((r20 & 1) == 0) goto L5;
        int r1 = 5;
    L7:
        if ((r20 & 2) == 0) goto L9;
        int r2 = 20;
    L10:
        List r4 = null;
        if ((r20 & 4) == 0) goto L13;
        List r3 = null;
    L15:
        if ((r20 & 8) == 0) goto L17;
        List r5 = null;
    L19:
        if ((r20 & 16) == 0) goto L21;
        List r6 = null;
    L23:
        if ((r20 & 32) == 0) goto L25;
        List r7 = null;
    L27:
        if ((r20 & 64) == 0) goto L29;
        List r8 = null;
    L31:
        if ((r20 & 128) == 0) goto L33;
        List r9 = null;
    L35:
        if ((r20 & 256) != 0) goto L38;
        r4 = r19;
    L38:
        this(r1, r2, r3, r5, r6, r7, r8, r9, r4);
        return;
    L33:
        r9 = r18;
        goto L35
    L29:
        r8 = r17;
        goto L31
    L25:
        r7 = r16;
        goto L27
    L21:
        r6 = r15;
        goto L23
    L17:
        r5 = r14;
        goto L19
    L13:
        r3 = r13;
        goto L15
    L9:
        r2 = r12;
        goto L10
    L5:
        r1 = r11;
        goto L7
    }
}
