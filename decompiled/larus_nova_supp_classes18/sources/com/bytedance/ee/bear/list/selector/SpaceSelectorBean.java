package com.bytedance.ee.bear.list.selector;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 92\u00020\u0001:\u00019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0018\u00105\u001a\u0002062\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u00107\u001a\u00020\bH\u0016J\b\u00108\u001a\u00020\bH\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001a\u0010\u0016\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001a\u0010\u0019\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u0012R\u001a\u0010\u001c\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u0012R\u001a\u0010\u001f\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010!\"\u0004\b&\u0010#R\u001a\u0010'\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010!\"\u0004\b(\u0010#R\u001a\u0010)\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010!\"\u0004\b*\u0010#R\u001a\u0010+\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010!\"\u0004\b,\u0010#R\u001a\u0010-\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010!\"\u0004\b.\u0010#R\u001a\u0010/\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0010\"\u0004\b1\u0010\u0012R\u001a\u00102\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0010\"\u0004\b4\u0010\u0012¨\u0006:"}, d2 = {"Lcom/bytedance/ee/bear/list/selector/SpaceSelectorBean;", "Landroid/os/Parcelable;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "objType", "", "getObjType", "()I", "setObjType", "(I)V", "objToken", "", "getObjToken", "()Ljava/lang/String;", "setObjToken", "(Ljava/lang/String;)V", "parentToken", "getParentToken", "setParentToken", ResourceData.KEY_TOKEN, "getToken", "setToken", "subType", "getSubType", "setSubType", "title", "getTitle", "setTitle", "isSpaceV2", "", "()Z", "setSpaceV2", "(Z)V", "externalAccess", "getExternalAccess", "setExternalAccess", "isOwner", "setOwner", "isShortcut", "setShortcut", "isParentShareFolder", "setParentShareFolder", "isShareFolder", "setShareFolder", "source", "getSource", "setSource", "module", "getModule", "setModule", "writeToParcel", "", "flags", "describeContents", "CREATOR", "contentmanager-list-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SpaceSelectorBean implements Parcelable {
    public static final a CREATOR = null;
    public int a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;
    public boolean l;
    public String m;
    public String n;

    public static final class a implements Parcelable.Creator<SpaceSelectorBean> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final SpaceSelectorBean createFromParcel(Parcel r6) {
            Intrinsics.checkNotNullParameter(r6, "parcel");
            Intrinsics.checkNotNullParameter(r6, "parcel");
            SpaceSelectorBean r1 = new SpaceSelectorBean();
            r1.a = r6.readInt();
            String r0 = r6.readString();
            String r2 = "";
            if (r0 != null) goto L5;
            r0 = "";
        L5:
            r1.b = r0;
            String r3 = r6.readString();
            if (r3 != null) goto L8;
            r3 = "";
        L8:
            r1.c = r3;
            String r4 = r6.readString();
            if (r4 != null) goto L11;
            r4 = "";
        L11:
            r1.d = r4;
            String r5 = r6.readString();
            if (r5 != null) goto L14;
            r5 = "";
        L14:
            r1.e = r5;
            String r7 = r6.readString();
            if (r7 != null) goto L17;
            r7 = "";
        L17:
            r1.f = r7;
            boolean r8 = true;
            if (r6.readByte() == 0) goto L20;
            boolean r9 = true;
        L21:
            r1.g = r9;
            if (r6.readByte() == 0) goto L24;
            boolean r10 = true;
        L25:
            r1.h = r10;
            if (r6.readByte() == 0) goto L28;
            boolean r11 = true;
        L29:
            r1.i = r11;
            if (r6.readByte() == 0) goto L32;
            boolean r12 = true;
        L33:
            r1.j = r12;
            if (r6.readByte() != 0) goto L37;
            r8 = false;
        L37:
            r1.k = r8;
            String r13 = r6.readString();
            if (r13 != null) goto L40;
            r13 = "";
        L40:
            r1.m = r13;
            String r14 = r6.readString();
            if (r14 == null) goto L44;
            r2 = r14;
        L44:
            r1.n = r2;
            return r1;
        L32:
            r12 = false;
            goto L33
        L28:
            r11 = false;
            goto L29
        L24:
            r10 = false;
            goto L25
        L20:
            r9 = false;
            goto L21
        }

        @Override // android.os.Parcelable.Creator
        public final SpaceSelectorBean[] newArray(int r1) {
            return new SpaceSelectorBean[r1];
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
        this.b = "";
        this.d = "";
        this.e = "";
        this.f = "";
        this.g = true;
        this.m = "";
        this.n = "";
    }

    public final void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.b = r2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        r1.writeInt(this.a);
        r1.writeString(this.b);
        r1.writeString(this.c);
        r1.writeString(this.d);
        r1.writeString(this.e);
        r1.writeString(this.f);
        r1.writeByte(this.g ? 1 : 0);
        r1.writeByte(this.h ? 1 : 0);
        r1.writeByte(this.i ? 1 : 0);
        r1.writeByte(this.j ? 1 : 0);
        r1.writeByte(this.k ? 1 : 0);
        r1.writeString(this.m);
        r1.writeString(this.n);
    }
}
