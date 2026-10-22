package com.larus.contextwindow.api;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001c\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001c\u001a\u00020\bHÆ\u0003J\t\u0010\u001d\u001a\u00020\bHÆ\u0003J\t\u0010\u001e\u001a\u00020\bHÆ\u0003J\t\u0010\u001f\u001a\u00020\bHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\bHÆ\u0003Jq\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000e\u001a\u00020\bHÆ\u0001J\u0006\u0010$\u001a\u00020%J\u0013\u0010&\u001a\u00020\b2\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001a\u00020%HÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001J\u0016\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020%R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0016R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0016R\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0016R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0011\u0010\u000e\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0016¨\u00060"}, d2 = {"Lcom/larus/contextwindow/api/ContextWindowMessageSnapshot;", "Landroid/os/Parcelable;", "conversationId", "", "messageId", "logicalIndex", "", "isFromCurrentUser", "", "isAvailable", "isVisible", "isStreaming", "replyId", "contextWindowUsageRaw", "isCompressing", "<init>", "(Ljava/lang/String;Ljava/lang/String;JZZZZLjava/lang/String;Ljava/lang/String;Z)V", "getConversationId", "()Ljava/lang/String;", "getMessageId", "getLogicalIndex", "()J", "()Z", "getReplyId", "getContextWindowUsageRaw", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ContextWindowMessageSnapshot implements Parcelable {
    public static final Parcelable.Creator<ContextWindowMessageSnapshot> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f330242a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f330243b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f330244c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f330245d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f330246e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f330247f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f330248g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f330249h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f330250i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f330251j;

    public static final class a implements Parcelable.Creator<ContextWindowMessageSnapshot> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ContextWindowMessageSnapshot createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "parcel");
            String r100 = r110.readString();
            String r101 = r110.readString();
            long r102 = r110.readLong();
            if (r110.readInt() == 0) goto L5;
            boolean r103 = true;
        L7:
            if (r110.readInt() == 0) goto L9;
            boolean r104 = true;
        L11:
            if (r110.readInt() == 0) goto L13;
            boolean r111 = true;
        L15:
            if (r110.readInt() == 0) goto L17;
            boolean r112 = true;
        L18:
            String r113 = r110.readString();
            String r114 = r110.readString();
            if (r110.readInt() == 0) goto L21;
            boolean r115 = true;
        L23:
            return new ContextWindowMessageSnapshot(r100, r101, r102, r103, r104, r111, r112, r113, r114, r115);
        L21:
            r115 = false;
            goto L23
        L17:
            r112 = false;
            goto L18
        L13:
            r111 = false;
            goto L15
        L9:
            r104 = false;
            goto L11
        L5:
            r103 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final ContextWindowMessageSnapshot[] newArray(int r100) {
            return new ContextWindowMessageSnapshot[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ContextWindowMessageSnapshot) == true) goto L8;
        return false;
    L8:
        ContextWindowMessageSnapshot r101 = (ContextWindowMessageSnapshot) r100;
        if (Intrinsics.areEqual(this.f330242a, r101.f330242a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f330243b, r101.f330243b) == true) goto L15;
        return false;
    L15:
        if (this.f330244c == r101.f330244c) goto L18;
        return false;
    L18:
        if (this.f330245d == r101.f330245d) goto L21;
        return false;
    L21:
        if (this.f330246e == r101.f330246e) goto L24;
        return false;
    L24:
        if (this.f330247f == r101.f330247f) goto L27;
        return false;
    L27:
        if (this.f330248g == r101.f330248g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f330249h, r101.f330249h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f330250i, r101.f330250i) == true) goto L36;
        return false;
    L36:
        if (this.f330251j == r101.f330251j) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f330242a.hashCode() * 31) + this.f330243b.hashCode()) * 31;
        long r101 = this.f330244c;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        int r103 = 1231;
        if (this.f330245d == false) goto L5;
        int r104 = 1231;
    L6:
        int r105 = (r102 + r104) * 31;
        if (this.f330246e == false) goto L9;
        int r106 = 1231;
    L10:
        int r107 = (r105 + r106) * 31;
        if (this.f330247f == false) goto L13;
        int r108 = 1231;
    L14:
        int r109 = (r107 + r108) * 31;
        if (this.f330248g == false) goto L17;
        int r110 = 1231;
    L18:
        int r111 = (r109 + r110) * 31;
        String r112 = this.f330249h;
        int r113 = 0;
        if (r112 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r111 + r114) * 31;
        String r116 = this.f330250i;
        if (r116 == null) goto L26;
        r113 = r116.hashCode();
    L26:
        int r117 = (r115 + r113) * 31;
        if (this.f330251j == true) goto L31;
        r103 = 1237;
    L31:
        return r117 + r103;
    L21:
        r114 = r112.hashCode();
        goto L22
    L17:
        r110 = 1237;
        goto L18
    L13:
        r108 = 1237;
        goto L14
    L9:
        r106 = 1237;
        goto L10
    L5:
        r104 = 1237;
        goto L6
    }

    public final String toString() {
        return "ContextWindowMessageSnapshot(conversationId=" + this.f330242a + ", messageId=" + this.f330243b + ", logicalIndex=" + this.f330244c + ", isFromCurrentUser=" + this.f330245d + ", isAvailable=" + this.f330246e + ", isVisible=" + this.f330247f + ", isStreaming=" + this.f330248g + ", replyId=" + this.f330249h + ", contextWindowUsageRaw=" + this.f330250i + ", isCompressing=" + this.f330251j + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.f330242a);
        r100.writeString(this.f330243b);
        r100.writeLong(this.f330244c);
        r100.writeInt(this.f330245d ? 1 : 0);
        r100.writeInt(this.f330246e ? 1 : 0);
        r100.writeInt(this.f330247f ? 1 : 0);
        r100.writeInt(this.f330248g ? 1 : 0);
        r100.writeString(this.f330249h);
        r100.writeString(this.f330250i);
        r100.writeInt(this.f330251j ? 1 : 0);
    }

    public ContextWindowMessageSnapshot(String r100, String r101, long r102, boolean r103, boolean r104, boolean r105, boolean r106, String r110, String r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        Intrinsics.checkNotNullParameter(r101, "messageId");
        this.f330242a = r100;
        this.f330243b = r101;
        this.f330244c = r102;
        this.f330245d = r103;
        this.f330246e = r104;
        this.f330247f = r105;
        this.f330248g = r106;
        this.f330249h = r110;
        this.f330250i = r111;
        this.f330251j = r112;
    }
}
