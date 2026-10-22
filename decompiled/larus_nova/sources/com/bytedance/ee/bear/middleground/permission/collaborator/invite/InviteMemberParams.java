package com.bytedance.ee.bear.middleground.permission.collaborator.invite;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.ss.android.cert.manager.constants.EventConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b?\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bû\u0001\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\n\u0012\b\b\u0002\u0010\r\u001a\u00020\n\u0012\b\b\u0002\u0010\u000e\u001a\u00020\n\u0012\b\b\u0002\u0010\u000f\u001a\u00020\n\u0012\b\b\u0002\u0010\u0010\u001a\u00020\n\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\n\u0012\b\b\u0002\u0010\u0014\u001a\u00020\n\u0012\b\b\u0002\u0010\u0015\u001a\u00020\n\u0012\b\b\u0002\u0010\u0016\u001a\u00020\n\u0012\b\b\u0002\u0010\u0017\u001a\u00020\n\u0012\b\b\u0002\u0010\u0018\u001a\u00020\n\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u001a\u001a\u00020\n\u0012\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\t\u0010A\u001a\u00020\u0003HÆ\u0003J\t\u0010B\u001a\u00020\u0005HÆ\u0003J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\t\u0010D\u001a\u00020\u0003HÆ\u0003J\t\u0010E\u001a\u00020\u0003HÆ\u0003J\t\u0010F\u001a\u00020\nHÆ\u0003J\t\u0010G\u001a\u00020\nHÆ\u0003J\t\u0010H\u001a\u00020\nHÆ\u0003J\t\u0010I\u001a\u00020\nHÆ\u0003J\t\u0010J\u001a\u00020\nHÆ\u0003J\t\u0010K\u001a\u00020\nHÆ\u0003J\t\u0010L\u001a\u00020\nHÆ\u0003J\t\u0010M\u001a\u00020\u0003HÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010O\u001a\u00020\nHÆ\u0003J\t\u0010P\u001a\u00020\nHÆ\u0003J\t\u0010Q\u001a\u00020\nHÆ\u0003J\t\u0010R\u001a\u00020\nHÆ\u0003J\t\u0010S\u001a\u00020\nHÆ\u0003J\t\u0010T\u001a\u00020\nHÆ\u0003J\u0010\u0010U\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010:J\t\u0010V\u001a\u00020\nHÆ\u0003J\u0011\u0010W\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cHÆ\u0003J\u0080\u0002\u0010X\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\u000f\u001a\u00020\n2\b\b\u0002\u0010\u0010\u001a\u00020\n2\b\b\u0002\u0010\u0011\u001a\u00020\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0013\u001a\u00020\n2\b\b\u0002\u0010\u0014\u001a\u00020\n2\b\b\u0002\u0010\u0015\u001a\u00020\n2\b\b\u0002\u0010\u0016\u001a\u00020\n2\b\b\u0002\u0010\u0017\u001a\u00020\n2\b\b\u0002\u0010\u0018\u001a\u00020\n2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u001a\u001a\u00020\n2\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cHÆ\u0001¢\u0006\u0002\u0010YJ\u0006\u0010Z\u001a\u00020\u0005J\u0013\u0010[\u001a\u00020\n2\b\u0010\\\u001a\u0004\u0018\u00010]HÖ\u0003J\t\u0010^\u001a\u00020\u0005HÖ\u0001J\t\u0010_\u001a\u00020\u0003HÖ\u0001J\u0016\u0010`\u001a\u00020a2\u0006\u0010b\u001a\u00020c2\u0006\u0010d\u001a\u00020\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010!R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010!R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010!R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u001a\u0010\u000b\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010(\"\u0004\b*\u0010+R\u0011\u0010\f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b,\u0010(R\u0011\u0010\r\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010(R\u0011\u0010\u000e\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b-\u0010(R\u0011\u0010\u000f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b.\u0010(R\u0011\u0010\u0010\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010(R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010!R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010!R\u0011\u0010\u0013\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b1\u0010(R\u001a\u0010\u0014\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010(\"\u0004\b3\u0010+R\u0011\u0010\u0015\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b4\u0010(R\u001a\u0010\u0016\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010(\"\u0004\b6\u0010+R\u0011\u0010\u0017\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b7\u0010(R\u0011\u0010\u0018\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b8\u0010(R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010=\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u0011\u0010\u001a\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b>\u0010(R\u0019\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@¨\u0006e"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/collaborator/invite/InviteMemberParams;", "Landroid/os/Parcelable;", "token", "", "type", "", "ownerId", "subType", EventConstant.Key.MODULE, "inviteDepEnable", "", "inviteUserGroupEnable", "inviteEmailEnable", "isWiki", "canReAdd", "canReAddNormalExistUser", "isSingleContainer", "nextPageTarget", "title", "canFullAccess", "externalAccess", "adminExternalAccess", "partnerTenantAccess", "adminPartnerTenantAccess", "containerClosePartnerTenantAccess", "disableShowUserGroupEntrance", "canExternalAccessOpenEscape", "existUsers", "", "Lcom/bytedance/ee/bear/share/export/UserInfo;", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZZZZZLjava/lang/String;Ljava/lang/String;ZZZZZZLjava/lang/Boolean;ZLjava/util/List;)V", "getToken", "()Ljava/lang/String;", "getType", "()I", "getOwnerId", "getSubType", "getModule", "getInviteDepEnable", "()Z", "getInviteUserGroupEnable", "setInviteUserGroupEnable", "(Z)V", "getInviteEmailEnable", "getCanReAdd", "getCanReAddNormalExistUser", "getNextPageTarget", "getTitle", "getCanFullAccess", "getExternalAccess", "setExternalAccess", "getAdminExternalAccess", "getPartnerTenantAccess", "setPartnerTenantAccess", "getAdminPartnerTenantAccess", "getContainerClosePartnerTenantAccess", "getDisableShowUserGroupEntrance", "()Ljava/lang/Boolean;", "setDisableShowUserGroupEntrance", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getCanExternalAccessOpenEscape", "getExistUsers", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "copy", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZZZZZLjava/lang/String;Ljava/lang/String;ZZZZZZLjava/lang/Boolean;ZLjava/util/List;)Lcom/bytedance/ee/bear/middleground/permission/collaborator/invite/InviteMemberParams;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "middleground-permission-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InviteMemberParams implements Parcelable {
    public static final Parcelable.Creator<InviteMemberParams> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f233166a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f233167b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f233168c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f233169d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f233170e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f233171f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f233172g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f233173h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f233174i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f233175j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f233176k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f233177l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f233178m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f233179n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f233180o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f233181p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f233182q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f233183r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f233184s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final boolean f233185t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Boolean f233186u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final boolean f233187v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final List<UserInfo> f233188w;

    public static final class a implements Parcelable.Creator<InviteMemberParams> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final InviteMemberParams createFromParcel(Parcel r210) {
            Intrinsics.checkNotNullParameter(r210, "parcel");
            String r100 = r210.readString();
            int r101 = r210.readInt();
            String r102 = r210.readString();
            String r103 = r210.readString();
            String r104 = r210.readString();
            if (r210.readInt() == 0) goto L5;
            boolean r105 = true;
        L7:
            if (r210.readInt() == 0) goto L9;
            boolean r106 = true;
        L11:
            if (r210.readInt() == 0) goto L13;
            boolean r110 = true;
        L15:
            if (r210.readInt() == 0) goto L17;
            boolean r111 = true;
        L19:
            if (r210.readInt() == 0) goto L21;
            boolean r112 = true;
        L23:
            if (r210.readInt() == 0) goto L25;
            boolean r113 = true;
        L27:
            if (r210.readInt() == 0) goto L29;
            boolean r114 = true;
        L30:
            String r115 = r210.readString();
            String r116 = r210.readString();
            if (r210.readInt() == 0) goto L33;
            boolean r117 = true;
        L35:
            if (r210.readInt() == 0) goto L37;
            boolean r118 = true;
        L39:
            if (r210.readInt() == 0) goto L41;
            boolean r119 = true;
        L43:
            if (r210.readInt() == 0) goto L45;
            boolean r211 = true;
        L47:
            if (r210.readInt() == 0) goto L49;
            boolean r212 = true;
        L51:
            if (r210.readInt() == 0) goto L53;
            boolean r213 = true;
        L55:
            if (r210.readInt() != 0) goto L58;
            Boolean r214 = null;
        L63:
            if (r210.readInt() == 0) goto L65;
            boolean r215 = true;
        L67:
            if (r210.readInt() != 0) goto L69;
            ArrayList r107 = null;
        L74:
            return new InviteMemberParams(r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r211, r212, r213, r214, r215, r107);
        L69:
            int r108 = r210.readInt();
            ArrayList r109 = new ArrayList(r108);
            int r120 = 0;
        L70:
            if (r120 == r108) goto L72;
            r109.add(r210.readParcelable(InviteMemberParams.class.getClassLoader()));
            r120 = r120 + 1;
            r108 = r108;
            goto L70
        L72:
            r107 = r109;
            goto L74
        L65:
            r215 = false;
            goto L67
        L58:
            if (r210.readInt() == 0) goto L60;
            boolean r216 = true;
        L61:
            r214 = Boolean.valueOf(r216);
            goto L63
        L60:
            r216 = false;
            goto L61
        L53:
            r213 = false;
            goto L55
        L49:
            r212 = false;
            goto L51
        L45:
            r211 = false;
            goto L47
        L41:
            r119 = false;
            goto L43
        L37:
            r118 = false;
            goto L39
        L33:
            r117 = false;
            goto L35
        L29:
            r114 = false;
            goto L30
        L25:
            r113 = false;
            goto L27
        L21:
            r112 = false;
            goto L23
        L17:
            r111 = false;
            goto L19
        L13:
            r110 = false;
            goto L15
        L9:
            r106 = false;
            goto L11
        L5:
            r105 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final InviteMemberParams[] newArray(int r100) {
            return new InviteMemberParams[r100];
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

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof InviteMemberParams) == true) goto L8;
        return false;
    L8:
        InviteMemberParams r101 = (InviteMemberParams) r100;
        if (Intrinsics.areEqual(this.f233166a, r101.f233166a) == true) goto L12;
        return false;
    L12:
        if (this.f233167b == r101.f233167b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f233168c, r101.f233168c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f233169d, r101.f233169d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f233170e, r101.f233170e) == true) goto L24;
        return false;
    L24:
        if (this.f233171f == r101.f233171f) goto L27;
        return false;
    L27:
        if (this.f233172g == r101.f233172g) goto L30;
        return false;
    L30:
        if (this.f233173h == r101.f233173h) goto L33;
        return false;
    L33:
        if (this.f233174i == r101.f233174i) goto L36;
        return false;
    L36:
        if (this.f233175j == r101.f233175j) goto L39;
        return false;
    L39:
        if (this.f233176k == r101.f233176k) goto L42;
        return false;
    L42:
        if (this.f233177l == r101.f233177l) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f233178m, r101.f233178m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f233179n, r101.f233179n) == true) goto L51;
        return false;
    L51:
        if (this.f233180o == r101.f233180o) goto L54;
        return false;
    L54:
        if (this.f233181p == r101.f233181p) goto L57;
        return false;
    L57:
        if (this.f233182q == r101.f233182q) goto L60;
        return false;
    L60:
        if (this.f233183r == r101.f233183r) goto L63;
        return false;
    L63:
        if (this.f233184s == r101.f233184s) goto L66;
        return false;
    L66:
        if (this.f233185t == r101.f233185t) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.f233186u, r101.f233186u) == true) goto L72;
        return false;
    L72:
        if (this.f233187v == r101.f233187v) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.f233188w, r101.f233188w) == true) goto L77;
        return false;
    L77:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((this.f233166a.hashCode() * 31) + this.f233167b) * 31) + this.f233168c.hashCode()) * 31) + this.f233169d.hashCode()) * 31) + this.f233170e.hashCode()) * 31;
        int r101 = 1231;
        if (this.f233171f == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f233172g == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        if (this.f233173h == false) goto L13;
        int r106 = 1231;
    L14:
        int r107 = (r105 + r106) * 31;
        if (this.f233174i == false) goto L17;
        int r108 = 1231;
    L18:
        int r109 = (r107 + r108) * 31;
        if (this.f233175j == false) goto L21;
        int r110 = 1231;
    L22:
        int r111 = (r109 + r110) * 31;
        if (this.f233176k == false) goto L25;
        int r112 = 1231;
    L26:
        int r113 = (r111 + r112) * 31;
        if (this.f233177l == false) goto L29;
        int r114 = 1231;
    L30:
        int r115 = (((r113 + r114) * 31) + this.f233178m.hashCode()) * 31;
        String r116 = this.f233179n;
        int r117 = 0;
        if (r116 != null) goto L33;
        int r118 = 0;
    L34:
        int r119 = (r115 + r118) * 31;
        if (this.f233180o == false) goto L37;
        int r120 = 1231;
    L38:
        int r121 = (r119 + r120) * 31;
        if (this.f233181p == false) goto L41;
        int r122 = 1231;
    L42:
        int r123 = (r121 + r122) * 31;
        if (this.f233182q == false) goto L45;
        int r124 = 1231;
    L46:
        int r125 = (r123 + r124) * 31;
        if (this.f233183r == false) goto L49;
        int r126 = 1231;
    L50:
        int r127 = (r125 + r126) * 31;
        if (this.f233184s == false) goto L53;
        int r128 = 1231;
    L54:
        int r129 = (r127 + r128) * 31;
        if (this.f233185t == false) goto L57;
        int r130 = 1231;
    L58:
        int r131 = (r129 + r130) * 31;
        Boolean r132 = this.f233186u;
        if (r132 != null) goto L61;
        int r133 = 0;
    L62:
        int r134 = (r131 + r133) * 31;
        if (this.f233187v == true) goto L66;
        r101 = 1237;
    L66:
        int r135 = (r134 + r101) * 31;
        List<UserInfo> r136 = this.f233188w;
        if (r136 == null) goto L71;
        r117 = r136.hashCode();
    L71:
        return r135 + r117;
    L61:
        r133 = r132.hashCode();
        goto L62
    L57:
        r130 = 1237;
        goto L58
    L53:
        r128 = 1237;
        goto L54
    L49:
        r126 = 1237;
        goto L50
    L45:
        r124 = 1237;
        goto L46
    L41:
        r122 = 1237;
        goto L42
    L37:
        r120 = 1237;
        goto L38
    L33:
        r118 = r116.hashCode();
        goto L34
    L29:
        r114 = 1237;
        goto L30
    L25:
        r112 = 1237;
        goto L26
    L21:
        r110 = 1237;
        goto L22
    L17:
        r108 = 1237;
        goto L18
    L13:
        r106 = 1237;
        goto L14
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "InviteMemberParams(token=" + this.f233166a + ", type=" + this.f233167b + ", ownerId=" + this.f233168c + ", subType=" + this.f233169d + ", module=" + this.f233170e + ", inviteDepEnable=" + this.f233171f + ", inviteUserGroupEnable=" + this.f233172g + ", inviteEmailEnable=" + this.f233173h + ", isWiki=" + this.f233174i + ", canReAdd=" + this.f233175j + ", canReAddNormalExistUser=" + this.f233176k + ", isSingleContainer=" + this.f233177l + ", nextPageTarget=" + this.f233178m + ", title=" + this.f233179n + ", canFullAccess=" + this.f233180o + ", externalAccess=" + this.f233181p + ", adminExternalAccess=" + this.f233182q + ", partnerTenantAccess=" + this.f233183r + ", adminPartnerTenantAccess=" + this.f233184s + ", containerClosePartnerTenantAccess=" + this.f233185t + ", disableShowUserGroupEntrance=" + this.f233186u + ", canExternalAccessOpenEscape=" + this.f233187v + ", existUsers=" + this.f233188w + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.f233166a);
        r100.writeInt(this.f233167b);
        r100.writeString(this.f233168c);
        r100.writeString(this.f233169d);
        r100.writeString(this.f233170e);
        r100.writeInt(this.f233171f ? 1 : 0);
        r100.writeInt(this.f233172g ? 1 : 0);
        r100.writeInt(this.f233173h ? 1 : 0);
        r100.writeInt(this.f233174i ? 1 : 0);
        r100.writeInt(this.f233175j ? 1 : 0);
        r100.writeInt(this.f233176k ? 1 : 0);
        r100.writeInt(this.f233177l ? 1 : 0);
        r100.writeString(this.f233178m);
        r100.writeString(this.f233179n);
        r100.writeInt(this.f233180o ? 1 : 0);
        r100.writeInt(this.f233181p ? 1 : 0);
        r100.writeInt(this.f233182q ? 1 : 0);
        r100.writeInt(this.f233183r ? 1 : 0);
        r100.writeInt(this.f233184s ? 1 : 0);
        r100.writeInt(this.f233185t ? 1 : 0);
        Boolean r102 = this.f233186u;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L6:
        r100.writeInt(this.f233187v ? 1 : 0);
        List<UserInfo> r103 = this.f233188w;
        if (r103 != null) goto L9;
        r100.writeInt(0);
        return;
    L9:
        r100.writeInt(1);
        r100.writeInt(r103.size());
        Iterator<UserInfo> r104 = r103.iterator();
    L11:
        if (r104.hasNext() == false) goto L15;
        r100.writeParcelable(r104.next(), r101);
        goto L11
    L15:
        return;
    L5:
        r100.writeInt(1);
        r100.writeInt(r102.booleanValue() ? 1 : 0);
        goto L6
    }

    public final int getType() {
        return this.f233167b;
    }

    public /* synthetic */ InviteMemberParams(String r210, int r211, String r310, String r311, String r312, boolean r313, boolean r314, boolean r315, boolean r316, boolean r317, boolean r318, boolean r319, String r410, String r411, boolean r412, boolean r413, boolean r414, boolean r415, boolean r416, boolean r417, boolean r418, List r419, int r510) {
        if ((r510 & 1) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r510 & 2) == 0) goto L9;
        int r101 = 0;
    L11:
        if ((r510 & 4) == 0) goto L13;
        String r102 = "";
    L15:
        if ((r510 & 8) == 0) goto L17;
        String r103 = "";
    L19:
        if ((r510 & 16) == 0) goto L21;
        String r104 = "";
    L23:
        if ((r510 & 32) == 0) goto L25;
        boolean r105 = false;
    L27:
        if ((r510 & 64) == 0) goto L29;
        boolean r110 = false;
    L31:
        if ((r510 & 128) == 0) goto L33;
        boolean r111 = false;
    L35:
        if ((r510 & 256) == 0) goto L37;
        boolean r112 = false;
    L39:
        if ((r510 & 512) == 0) goto L41;
        boolean r113 = false;
    L43:
        if ((r510 & 1024) == 0) goto L45;
        boolean r114 = false;
    L47:
        if ((r510 & 2048) == 0) goto L49;
        boolean r115 = false;
    L51:
        if ((r510 & 4096) == 0) goto L53;
        String r116 = "ccm_permission_select_contact_view";
    L55:
        if ((r510 & 8192) == 0) goto L57;
        String r117 = null;
    L59:
        if ((r510 & 16384) == 0) goto L61;
        boolean r118 = false;
    L63:
        if ((32768 & r510) == 0) goto L65;
        boolean r119 = false;
    L67:
        if ((65536 & r510) == 0) goto L69;
        boolean r212 = false;
    L71:
        if ((131072 & r510) == 0) goto L73;
        boolean r213 = false;
    L75:
        if ((262144 & r510) == 0) goto L77;
        boolean r214 = false;
    L79:
        if ((524288 & r510) == 0) goto L81;
        boolean r215 = false;
    L83:
        if ((2097152 & r510) == 0) goto L85;
        boolean r216 = false;
    L87:
        if ((r510 & 4194304) == 0) goto L89;
        List r217 = null;
    L90:
        this(r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r212, r213, r214, r215, null, r216, r217);
        return;
    L89:
        r217 = r419;
        goto L90
    L85:
        r216 = r418;
        goto L87
    L81:
        r215 = r417;
        goto L83
    L77:
        r214 = r416;
        goto L79
    L73:
        r213 = r415;
        goto L75
    L69:
        r212 = r414;
        goto L71
    L65:
        r119 = r413;
        goto L67
    L61:
        r118 = r412;
        goto L63
    L57:
        r117 = r411;
        goto L59
    L53:
        r116 = r410;
        goto L55
    L49:
        r115 = r319;
        goto L51
    L45:
        r114 = r318;
        goto L47
    L41:
        r113 = r317;
        goto L43
    L37:
        r112 = r316;
        goto L39
    L33:
        r111 = r315;
        goto L35
    L29:
        r110 = r314;
        goto L31
    L25:
        r105 = r313;
        goto L27
    L21:
        r104 = r312;
        goto L23
    L17:
        r103 = r311;
        goto L19
    L13:
        r102 = r310;
        goto L15
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public InviteMemberParams(String r100, int r101, String r110, String r111, String r112, boolean r113, boolean r114, boolean r115, boolean r116, boolean r117, boolean r118, boolean r119, String r210, String r211, boolean r212, boolean r213, boolean r214, boolean r215, boolean r216, boolean r217, Boolean r218, boolean r219, List<? extends UserInfo> r310) {
        Intrinsics.checkNotNullParameter(r100, "token");
        Intrinsics.checkNotNullParameter(r110, "ownerId");
        Intrinsics.checkNotNullParameter(r111, "subType");
        Intrinsics.checkNotNullParameter(r112, EventConstant.Key.MODULE);
        Intrinsics.checkNotNullParameter(r210, "nextPageTarget");
        this.f233166a = r100;
        this.f233167b = r101;
        this.f233168c = r110;
        this.f233169d = r111;
        this.f233170e = r112;
        this.f233171f = r113;
        this.f233172g = r114;
        this.f233173h = r115;
        this.f233174i = r116;
        this.f233175j = r117;
        this.f233176k = r118;
        this.f233177l = r119;
        this.f233178m = r210;
        this.f233179n = r211;
        this.f233180o = r212;
        this.f233181p = r213;
        this.f233182q = r214;
        this.f233183r = r215;
        this.f233184s = r216;
        this.f233185t = r217;
        this.f233186u = r218;
        this.f233187v = r219;
        this.f233188w = r310;
    }
}
