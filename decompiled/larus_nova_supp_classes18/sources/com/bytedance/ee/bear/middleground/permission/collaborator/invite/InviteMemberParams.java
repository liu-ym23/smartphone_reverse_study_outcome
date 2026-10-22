package com.bytedance.ee.bear.middleground.permission.collaborator.invite;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ee.bear.middleground.permission.permission.doc.DocUserPermission;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b?\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bû\u0001\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\n\u0012\b\b\u0002\u0010\r\u001a\u00020\n\u0012\b\b\u0002\u0010\u000e\u001a\u00020\n\u0012\b\b\u0002\u0010\u000f\u001a\u00020\n\u0012\b\b\u0002\u0010\u0010\u001a\u00020\n\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\n\u0012\b\b\u0002\u0010\u0014\u001a\u00020\n\u0012\b\b\u0002\u0010\u0015\u001a\u00020\n\u0012\b\b\u0002\u0010\u0016\u001a\u00020\n\u0012\b\b\u0002\u0010\u0017\u001a\u00020\n\u0012\b\b\u0002\u0010\u0018\u001a\u00020\n\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u001a\u001a\u00020\n\u0012\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\t\u0010A\u001a\u00020\u0003HÆ\u0003J\t\u0010B\u001a\u00020\u0005HÆ\u0003J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\t\u0010D\u001a\u00020\u0003HÆ\u0003J\t\u0010E\u001a\u00020\u0003HÆ\u0003J\t\u0010F\u001a\u00020\nHÆ\u0003J\t\u0010G\u001a\u00020\nHÆ\u0003J\t\u0010H\u001a\u00020\nHÆ\u0003J\t\u0010I\u001a\u00020\nHÆ\u0003J\t\u0010J\u001a\u00020\nHÆ\u0003J\t\u0010K\u001a\u00020\nHÆ\u0003J\t\u0010L\u001a\u00020\nHÆ\u0003J\t\u0010M\u001a\u00020\u0003HÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010O\u001a\u00020\nHÆ\u0003J\t\u0010P\u001a\u00020\nHÆ\u0003J\t\u0010Q\u001a\u00020\nHÆ\u0003J\t\u0010R\u001a\u00020\nHÆ\u0003J\t\u0010S\u001a\u00020\nHÆ\u0003J\t\u0010T\u001a\u00020\nHÆ\u0003J\u0010\u0010U\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010:J\t\u0010V\u001a\u00020\nHÆ\u0003J\u0011\u0010W\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cHÆ\u0003J\u0080\u0002\u0010X\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\u000f\u001a\u00020\n2\b\b\u0002\u0010\u0010\u001a\u00020\n2\b\b\u0002\u0010\u0011\u001a\u00020\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0013\u001a\u00020\n2\b\b\u0002\u0010\u0014\u001a\u00020\n2\b\b\u0002\u0010\u0015\u001a\u00020\n2\b\b\u0002\u0010\u0016\u001a\u00020\n2\b\b\u0002\u0010\u0017\u001a\u00020\n2\b\b\u0002\u0010\u0018\u001a\u00020\n2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u001a\u001a\u00020\n2\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cHÆ\u0001¢\u0006\u0002\u0010YJ\u0006\u0010Z\u001a\u00020\u0005J\u0013\u0010[\u001a\u00020\n2\b\u0010\\\u001a\u0004\u0018\u00010]HÖ\u0003J\t\u0010^\u001a\u00020\u0005HÖ\u0001J\t\u0010_\u001a\u00020\u0003HÖ\u0001J\u0016\u0010`\u001a\u00020a2\u0006\u0010b\u001a\u00020c2\u0006\u0010d\u001a\u00020\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010!R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010!R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010!R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u001a\u0010\u000b\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010(\"\u0004\b*\u0010+R\u0011\u0010\f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b,\u0010(R\u0011\u0010\r\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010(R\u0011\u0010\u000e\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b-\u0010(R\u0011\u0010\u000f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b.\u0010(R\u0011\u0010\u0010\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010(R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010!R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010!R\u0011\u0010\u0013\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b1\u0010(R\u001a\u0010\u0014\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010(\"\u0004\b3\u0010+R\u0011\u0010\u0015\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b4\u0010(R\u001a\u0010\u0016\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010(\"\u0004\b6\u0010+R\u0011\u0010\u0017\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b7\u0010(R\u0011\u0010\u0018\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b8\u0010(R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010=\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u0011\u0010\u001a\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b>\u0010(R\u0019\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@¨\u0006e"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/collaborator/invite/InviteMemberParams;", "Landroid/os/Parcelable;", ResourceData.KEY_TOKEN, "", ResourceData.KEY_TYPE, "", "ownerId", "subType", "module", "inviteDepEnable", "", "inviteUserGroupEnable", "inviteEmailEnable", "isWiki", "canReAdd", "canReAddNormalExistUser", "isSingleContainer", "nextPageTarget", "title", "canFullAccess", "externalAccess", "adminExternalAccess", "partnerTenantAccess", "adminPartnerTenantAccess", "containerClosePartnerTenantAccess", "disableShowUserGroupEntrance", "canExternalAccessOpenEscape", "existUsers", "", "Lcom/bytedance/ee/bear/share/export/UserInfo;", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZZZZZLjava/lang/String;Ljava/lang/String;ZZZZZZLjava/lang/Boolean;ZLjava/util/List;)V", "getToken", "()Ljava/lang/String;", "getType", "()I", "getOwnerId", "getSubType", "getModule", "getInviteDepEnable", "()Z", "getInviteUserGroupEnable", "setInviteUserGroupEnable", "(Z)V", "getInviteEmailEnable", "getCanReAdd", "getCanReAddNormalExistUser", "getNextPageTarget", "getTitle", "getCanFullAccess", "getExternalAccess", "setExternalAccess", "getAdminExternalAccess", "getPartnerTenantAccess", "setPartnerTenantAccess", "getAdminPartnerTenantAccess", "getContainerClosePartnerTenantAccess", "getDisableShowUserGroupEntrance", "()Ljava/lang/Boolean;", "setDisableShowUserGroupEntrance", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getCanExternalAccessOpenEscape", "getExistUsers", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "copy", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZZZZZLjava/lang/String;Ljava/lang/String;ZZZZZZLjava/lang/Boolean;ZLjava/util/List;)Lcom/bytedance/ee/bear/middleground/permission/collaborator/invite/InviteMemberParams;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "middleground-permission-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InviteMemberParams implements Parcelable {
    public static final Parcelable.Creator<InviteMemberParams> CREATOR = null;
    public final String a;
    public final int b;
    public final String c;
    public final String d;
    public final String e;
    public final boolean f;
    public boolean g;
    public final boolean h;
    public final boolean i;
    public final boolean j;
    public final boolean k;
    public final boolean l;
    public final String m;
    public final String n;
    public final boolean o;
    public boolean p;
    public final boolean q;
    public boolean r;
    public final boolean s;
    public final boolean t;
    public Boolean u;
    public final boolean v;
    public final List<UserInfo> w;

    public static final class a implements Parcelable.Creator<InviteMemberParams> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final InviteMemberParams createFromParcel(Parcel r29) {
            Intrinsics.checkNotNullParameter(r29, "parcel");
            String r3 = r29.readString();
            int r4 = r29.readInt();
            String r5 = r29.readString();
            String r6 = r29.readString();
            String r7 = r29.readString();
            if (r29.readInt() == 0) goto L5;
            boolean r1 = true;
        L7:
            if (r29.readInt() == 0) goto L9;
            boolean r9 = true;
        L11:
            if (r29.readInt() == 0) goto L13;
            boolean r10 = true;
        L15:
            if (r29.readInt() == 0) goto L17;
            boolean r11 = true;
        L19:
            if (r29.readInt() == 0) goto L21;
            boolean r12 = true;
        L23:
            if (r29.readInt() == 0) goto L25;
            boolean r13 = true;
        L27:
            if (r29.readInt() == 0) goto L29;
            boolean r14 = true;
        L30:
            String r15 = r29.readString();
            String r16 = r29.readString();
            if (r29.readInt() == 0) goto L33;
            boolean r17 = true;
        L35:
            if (r29.readInt() == 0) goto L37;
            boolean r18 = true;
        L39:
            if (r29.readInt() == 0) goto L41;
            boolean r19 = true;
        L43:
            if (r29.readInt() == 0) goto L45;
            boolean r20 = true;
        L47:
            if (r29.readInt() == 0) goto L49;
            boolean r21 = true;
        L51:
            if (r29.readInt() == 0) goto L53;
            boolean r22 = true;
        L55:
            if (r29.readInt() != 0) goto L58;
            Boolean r23 = null;
        L63:
            if (r29.readInt() == 0) goto L65;
            boolean r25 = true;
        L67:
            if (r29.readInt() != 0) goto L69;
            ArrayList r0 = null;
        L74:
            return new InviteMemberParams(r3, r4, r5, r6, r7, r1, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r25, r0);
        L69:
            int r2 = r29.readInt();
            ArrayList r8 = new ArrayList(r2);
            int r110 = 0;
        L70:
            if (r110 == r2) goto L72;
            r8.add(r29.readParcelable(InviteMemberParams.class.getClassLoader()));
            r110 = r110 + 1;
            r2 = r2;
            goto L70
        L72:
            r0 = r8;
            goto L74
        L65:
            r25 = false;
            goto L67
        L58:
            if (r29.readInt() == 0) goto L60;
            boolean r24 = true;
        L61:
            r23 = Boolean.valueOf(r24);
            goto L63
        L60:
            r24 = false;
            goto L61
        L53:
            r22 = false;
            goto L55
        L49:
            r21 = false;
            goto L51
        L45:
            r20 = false;
            goto L47
        L41:
            r19 = false;
            goto L43
        L37:
            r18 = false;
            goto L39
        L33:
            r17 = false;
            goto L35
        L29:
            r14 = false;
            goto L30
        L25:
            r13 = false;
            goto L27
        L21:
            r12 = false;
            goto L23
        L17:
            r11 = false;
            goto L19
        L13:
            r10 = false;
            goto L15
        L9:
            r9 = false;
            goto L11
        L5:
            r1 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final InviteMemberParams[] newArray(int r1) {
            return new InviteMemberParams[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public InviteMemberParams() {
        this(null, 0, null, null, null, false, false, false, false, false, false, false, null, null, false, false, false, false, false, false, false, null, 8388607);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof InviteMemberParams) == true) goto L8;
        return false;
    L8:
        InviteMemberParams r6 = (InviteMemberParams) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L30;
        return false;
    L30:
        if (this.h == r6.h) goto L33;
        return false;
    L33:
        if (this.i == r6.i) goto L36;
        return false;
    L36:
        if (this.j == r6.j) goto L39;
        return false;
    L39:
        if (this.k == r6.k) goto L42;
        return false;
    L42:
        if (this.l == r6.l) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.m, r6.m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.n, r6.n) == true) goto L51;
        return false;
    L51:
        if (this.o == r6.o) goto L54;
        return false;
    L54:
        if (this.p == r6.p) goto L57;
        return false;
    L57:
        if (this.q == r6.q) goto L60;
        return false;
    L60:
        if (this.r == r6.r) goto L63;
        return false;
    L63:
        if (this.s == r6.s) goto L66;
        return false;
    L66:
        if (this.t == r6.t) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.u, r6.u) == true) goto L72;
        return false;
    L72:
        if (this.v == r6.v) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.w, r6.w) == true) goto L77;
        return false;
    L77:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((((this.a.hashCode() * 31) + this.b) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31;
        int r2 = 1231;
        if (this.f == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        if (this.g == false) goto L9;
        int r4 = 1231;
    L10:
        int r5 = (r3 + r4) * 31;
        if (this.h == false) goto L13;
        int r6 = 1231;
    L14:
        int r7 = (r5 + r6) * 31;
        if (this.i == false) goto L17;
        int r8 = 1231;
    L18:
        int r9 = (r7 + r8) * 31;
        if (this.j == false) goto L21;
        int r10 = 1231;
    L22:
        int r11 = (r9 + r10) * 31;
        if (this.k == false) goto L25;
        int r12 = 1231;
    L26:
        int r13 = (r11 + r12) * 31;
        if (this.l == false) goto L29;
        int r14 = 1231;
    L30:
        int r15 = (((r13 + r14) * 31) + this.m.hashCode()) * 31;
        String r16 = this.n;
        int r17 = 0;
        if (r16 != null) goto L33;
        int r18 = 0;
    L34:
        int r19 = (r15 + r18) * 31;
        if (this.o == false) goto L37;
        int r20 = 1231;
    L38:
        int r21 = (r19 + r20) * 31;
        if (this.p == false) goto L41;
        int r22 = 1231;
    L42:
        int r23 = (r21 + r22) * 31;
        if (this.q == false) goto L45;
        int r24 = 1231;
    L46:
        int r25 = (r23 + r24) * 31;
        if (this.r == false) goto L49;
        int r26 = 1231;
    L50:
        int r27 = (r25 + r26) * 31;
        if (this.s == false) goto L53;
        int r28 = 1231;
    L54:
        int r29 = (r27 + r28) * 31;
        if (this.t == false) goto L57;
        int r30 = 1231;
    L58:
        int r31 = (r29 + r30) * 31;
        Boolean r32 = this.u;
        if (r32 != null) goto L61;
        int r33 = 0;
    L62:
        int r34 = (r31 + r33) * 31;
        if (this.v == true) goto L66;
        r2 = 1237;
    L66:
        int r35 = (r34 + r2) * 31;
        List<UserInfo> r36 = this.w;
        if (r36 == null) goto L71;
        r17 = r36.hashCode();
    L71:
        return r35 + r17;
    L61:
        r33 = r32.hashCode();
        goto L62
    L57:
        r30 = 1237;
        goto L58
    L53:
        r28 = 1237;
        goto L54
    L49:
        r26 = 1237;
        goto L50
    L45:
        r24 = 1237;
        goto L46
    L41:
        r22 = 1237;
        goto L42
    L37:
        r20 = 1237;
        goto L38
    L33:
        r18 = r16.hashCode();
        goto L34
    L29:
        r14 = 1237;
        goto L30
    L25:
        r12 = 1237;
        goto L26
    L21:
        r10 = 1237;
        goto L22
    L17:
        r8 = 1237;
        goto L18
    L13:
        r6 = 1237;
        goto L14
    L9:
        r4 = 1237;
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "InviteMemberParams(token=" + this.a + ", type=" + this.b + ", ownerId=" + this.c + ", subType=" + this.d + ", module=" + this.e + ", inviteDepEnable=" + this.f + ", inviteUserGroupEnable=" + this.g + ", inviteEmailEnable=" + this.h + ", isWiki=" + this.i + ", canReAdd=" + this.j + ", canReAddNormalExistUser=" + this.k + ", isSingleContainer=" + this.l + ", nextPageTarget=" + this.m + ", title=" + this.n + ", canFullAccess=" + this.o + ", externalAccess=" + this.p + ", adminExternalAccess=" + this.q + ", partnerTenantAccess=" + this.r + ", adminPartnerTenantAccess=" + this.s + ", containerClosePartnerTenantAccess=" + this.t + ", disableShowUserGroupEntrance=" + this.u + ", canExternalAccessOpenEscape=" + this.v + ", existUsers=" + this.w + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "dest");
        r4.writeString(this.a);
        r4.writeInt(this.b);
        r4.writeString(this.c);
        r4.writeString(this.d);
        r4.writeString(this.e);
        r4.writeInt(this.f ? 1 : 0);
        r4.writeInt(this.g ? 1 : 0);
        r4.writeInt(this.h ? 1 : 0);
        r4.writeInt(this.i ? 1 : 0);
        r4.writeInt(this.j ? 1 : 0);
        r4.writeInt(this.k ? 1 : 0);
        r4.writeInt(this.l ? 1 : 0);
        r4.writeString(this.m);
        r4.writeString(this.n);
        r4.writeInt(this.o ? 1 : 0);
        r4.writeInt(this.p ? 1 : 0);
        r4.writeInt(this.q ? 1 : 0);
        r4.writeInt(this.r ? 1 : 0);
        r4.writeInt(this.s ? 1 : 0);
        r4.writeInt(this.t ? 1 : 0);
        Boolean r0 = this.u;
        if (r0 != null) goto L5;
        r4.writeInt(0);
    L6:
        r4.writeInt(this.v ? 1 : 0);
        List<UserInfo> r1 = this.w;
        if (r1 != null) goto L9;
        r4.writeInt(0);
        return;
    L9:
        r4.writeInt(1);
        r4.writeInt(r1.size());
        Iterator<UserInfo> r2 = r1.iterator();
    L11:
        if (r2.hasNext() == false) goto L15;
        r4.writeParcelable(r2.next(), r5);
        goto L11
    L15:
        return;
    L5:
        r4.writeInt(1);
        r4.writeInt(r0.booleanValue() ? 1 : 0);
        goto L6
    }

    public final int getType() {
        return this.b;
    }

    public /* synthetic */ InviteMemberParams(String r28, int r29, String r30, String r31, String r32, boolean r33, boolean r34, boolean r35, boolean r36, boolean r37, boolean r38, boolean r39, String r40, String r41, boolean r42, boolean r43, boolean r44, boolean r45, boolean r46, boolean r47, boolean r48, List r49, int r50) {
        if ((r50 & 1) == 0) goto L5;
        String r4 = "";
    L7:
        if ((r50 & 2) == 0) goto L9;
        int r5 = 0;
    L11:
        if ((r50 & 4) == 0) goto L13;
        String r6 = "";
    L15:
        if ((r50 & 8) == 0) goto L17;
        String r7 = "";
    L19:
        if ((r50 & 16) == 0) goto L21;
        String r8 = "";
    L23:
        if ((r50 & 32) == 0) goto L25;
        boolean r9 = false;
    L27:
        if ((r50 & 64) == 0) goto L29;
        boolean r10 = false;
    L31:
        if ((r50 & 128) == 0) goto L33;
        boolean r11 = false;
    L35:
        if ((r50 & 256) == 0) goto L37;
        boolean r12 = false;
    L39:
        if ((r50 & 512) == 0) goto L41;
        boolean r13 = false;
    L43:
        if ((r50 & DocUserPermission.USER_PERM_FULL_ACCESS) == 0) goto L45;
        boolean r14 = false;
    L47:
        if ((r50 & DocUserPermission.USER_PREVIEW) == 0) goto L49;
        boolean r15 = false;
    L51:
        if ((r50 & DocUserPermission.USER_PERCEIVE) == 0) goto L53;
        String r16 = "ccm_permission_select_contact_view";
    L55:
        if ((r50 & 8192) == 0) goto L57;
        String r17 = null;
    L59:
        if ((r50 & 16384) == 0) goto L61;
        boolean r18 = false;
    L63:
        if ((32768 & r50) == 0) goto L65;
        boolean r19 = false;
    L67:
        if ((65536 & r50) == 0) goto L69;
        boolean r20 = false;
    L71:
        if ((131072 & r50) == 0) goto L73;
        boolean r21 = false;
    L75:
        if ((262144 & r50) == 0) goto L77;
        boolean r22 = false;
    L79:
        if ((524288 & r50) == 0) goto L81;
        boolean r23 = false;
    L83:
        if ((2097152 & r50) == 0) goto L85;
        boolean r25 = false;
    L87:
        if ((r50 & 4194304) == 0) goto L89;
        List r26 = null;
    L90:
        this(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, null, r25, r26);
        return;
    L89:
        r26 = r49;
        goto L90
    L85:
        r25 = r48;
        goto L87
    L81:
        r23 = r47;
        goto L83
    L77:
        r22 = r46;
        goto L79
    L73:
        r21 = r45;
        goto L75
    L69:
        r20 = r44;
        goto L71
    L65:
        r19 = r43;
        goto L67
    L61:
        r18 = r42;
        goto L63
    L57:
        r17 = r41;
        goto L59
    L53:
        r16 = r40;
        goto L55
    L49:
        r15 = r39;
        goto L51
    L45:
        r14 = r38;
        goto L47
    L41:
        r13 = r37;
        goto L43
    L37:
        r12 = r36;
        goto L39
    L33:
        r11 = r35;
        goto L35
    L29:
        r10 = r34;
        goto L31
    L25:
        r9 = r33;
        goto L27
    L21:
        r8 = r32;
        goto L23
    L17:
        r7 = r31;
        goto L19
    L13:
        r6 = r30;
        goto L15
    L9:
        r5 = r29;
        goto L11
    L5:
        r4 = r28;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public InviteMemberParams(String r8, int r9, String r10, String r11, String r12, boolean r13, boolean r14, boolean r15, boolean r16, boolean r17, boolean r18, boolean r19, String r20, String r21, boolean r22, boolean r23, boolean r24, boolean r25, boolean r26, boolean r27, Boolean r28, boolean r29, List<? extends UserInfo> r30) {
        Intrinsics.checkNotNullParameter(r8, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r10, "ownerId");
        Intrinsics.checkNotNullParameter(r11, "subType");
        Intrinsics.checkNotNullParameter(r12, "module");
        Intrinsics.checkNotNullParameter(r20, "nextPageTarget");
        this.a = r8;
        this.b = r9;
        this.c = r10;
        this.d = r11;
        this.e = r12;
        this.f = r13;
        this.g = r14;
        this.h = r15;
        this.i = r16;
        this.j = r17;
        this.k = r18;
        this.l = r19;
        this.m = r20;
        this.n = r21;
        this.o = r22;
        this.p = r23;
        this.q = r24;
        this.r = r25;
        this.s = r26;
        this.t = r27;
        this.u = r28;
        this.v = r29;
        this.w = r30;
    }
}
