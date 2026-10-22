package com.bytedance.ee.bear.list.selector;

import android.os.Parcel;
import android.os.Parcelable;
import com.alipay.sdk.m.x.d;
import com.ss.android.cert.manager.constants.EventConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 92\u00020\u0001:\u00019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0018\u00105\u001a\u0002062\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u00107\u001a\u00020\bH\u0016J\b\u00108\u001a\u00020\bH\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001a\u0010\u0016\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001a\u0010\u0019\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u0012R\u001a\u0010\u001c\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u0012R\u001a\u0010\u001f\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010!\"\u0004\b&\u0010#R\u001a\u0010'\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010!\"\u0004\b(\u0010#R\u001a\u0010)\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010!\"\u0004\b*\u0010#R\u001a\u0010+\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010!\"\u0004\b,\u0010#R\u001a\u0010-\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010!\"\u0004\b.\u0010#R\u001a\u0010/\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0010\"\u0004\b1\u0010\u0012R\u001a\u00102\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0010\"\u0004\b4\u0010\u0012¨\u0006:"}, d2 = {"Lcom/bytedance/ee/bear/list/selector/SpaceSelectorBean;", "Landroid/os/Parcelable;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "objType", "", "getObjType", "()I", "setObjType", "(I)V", "objToken", "", "getObjToken", "()Ljava/lang/String;", "setObjToken", "(Ljava/lang/String;)V", "parentToken", "getParentToken", "setParentToken", "token", "getToken", "setToken", "subType", "getSubType", "setSubType", "title", "getTitle", d.f25925o, "isSpaceV2", "", "()Z", "setSpaceV2", "(Z)V", "externalAccess", "getExternalAccess", "setExternalAccess", "isOwner", "setOwner", "isShortcut", "setShortcut", "isParentShareFolder", "setParentShareFolder", "isShareFolder", "setShareFolder", "source", "getSource", "setSource", EventConstant.Key.MODULE, "getModule", "setModule", "writeToParcel", "", "flags", "describeContents", "CREATOR", "contentmanager-list-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SpaceSelectorBean implements Parcelable {
    public static final a CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f229385a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f229386b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f229387c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f229388d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f229389e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f229390f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f229391g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f229392h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f229393i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f229394j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f229395k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f229396l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f229397m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f229398n;

    public static final class a implements Parcelable.Creator<SpaceSelectorBean> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final SpaceSelectorBean createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            Intrinsics.checkNotNullParameter(r100, "parcel");
            SpaceSelectorBean r101 = new SpaceSelectorBean();
            r101.f229385a = r100.readInt();
            String r102 = r100.readString();
            String r103 = "";
            if (r102 != null) goto L5;
            r102 = "";
        L5:
            r101.f229386b = r102;
            String r104 = r100.readString();
            if (r104 != null) goto L8;
            r104 = "";
        L8:
            r101.f229387c = r104;
            String r105 = r100.readString();
            if (r105 != null) goto L11;
            r105 = "";
        L11:
            r101.f229388d = r105;
            String r106 = r100.readString();
            if (r106 != null) goto L14;
            r106 = "";
        L14:
            r101.f229389e = r106;
            String r107 = r100.readString();
            if (r107 != null) goto L17;
            r107 = "";
        L17:
            r101.f229390f = r107;
            boolean r108 = true;
            if (r100.readByte() == 0) goto L20;
            boolean r109 = true;
        L21:
            r101.f229391g = r109;
            if (r100.readByte() == 0) goto L24;
            boolean r110 = true;
        L25:
            r101.f229392h = r110;
            if (r100.readByte() == 0) goto L28;
            boolean r111 = true;
        L29:
            r101.f229393i = r111;
            if (r100.readByte() == 0) goto L32;
            boolean r112 = true;
        L33:
            r101.f229394j = r112;
            if (r100.readByte() != 0) goto L37;
            r108 = false;
        L37:
            r101.f229395k = r108;
            String r113 = r100.readString();
            if (r113 != null) goto L40;
            r113 = "";
        L40:
            r101.f229397m = r113;
            String r114 = r100.readString();
            if (r114 == null) goto L44;
            r103 = r114;
        L44:
            r101.f229398n = r103;
            return r101;
        L32:
            r112 = false;
            goto L33
        L28:
            r111 = false;
            goto L29
        L24:
            r110 = false;
            goto L25
        L20:
            r109 = false;
            goto L21
        }

        @Override // android.os.Parcelable.Creator
        public final SpaceSelectorBean[] newArray(int r100) {
            return new SpaceSelectorBean[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public SpaceSelectorBean() {
        this.f229386b = "";
        this.f229388d = "";
        this.f229389e = "";
        this.f229390f = "";
        this.f229391g = true;
        this.f229397m = "";
        this.f229398n = "";
    }

    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f229386b = r100;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeInt(this.f229385a);
        r100.writeString(this.f229386b);
        r100.writeString(this.f229387c);
        r100.writeString(this.f229388d);
        r100.writeString(this.f229389e);
        r100.writeString(this.f229390f);
        r100.writeByte(this.f229391g ? 1 : 0);
        r100.writeByte(this.f229392h ? 1 : 0);
        r100.writeByte(this.f229393i ? 1 : 0);
        r100.writeByte(this.f229394j ? 1 : 0);
        r100.writeByte(this.f229395k ? 1 : 0);
        r100.writeString(this.f229397m);
        r100.writeString(this.f229398n);
    }
}
