package com.larus.contextwindow.api;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\"\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bc\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0007HÆ\u0003J\t\u0010*\u001a\u00020\tHÆ\u0003J\t\u0010+\u001a\u00020\tHÆ\u0003J\t\u0010,\u001a\u00020\fHÆ\u0003J\t\u0010-\u001a\u00020\u000eHÆ\u0003J\t\u0010.\u001a\u00020\u0010HÆ\u0003J\t\u0010/\u001a\u00020\u0012HÆ\u0003J\t\u00100\u001a\u00020\u0012HÆ\u0003Jy\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0012HÆ\u0001J\u0006\u00102\u001a\u00020\fJ\u0013\u00103\u001a\u00020\u00122\b\u00104\u001a\u0004\u0018\u000105HÖ\u0003J\t\u00106\u001a\u00020\fHÖ\u0001J\t\u00107\u001a\u00020\u0003HÖ\u0001J\u0016\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010%R\u0011\u0010\u0013\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010%¨\u0006="}, d2 = {"Lcom/larus/contextwindow/api/ContextWindowSnapshot;", "Landroid/os/Parcelable;", "conversationId", "", "anchorMessageId", "usageMessageId", "parts", "Lcom/larus/contextwindow/api/ContextWindowUsageParts;", "used", "", "total", "totalPercentTenths", "", "usageSource", "Lcom/larus/contextwindow/api/ContextWindowUsageSource;", "totalSource", "Lcom/larus/contextwindow/api/ContextWindowTotalSource;", "isStreaming", "", "isCompressing", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/contextwindow/api/ContextWindowUsageParts;JJILcom/larus/contextwindow/api/ContextWindowUsageSource;Lcom/larus/contextwindow/api/ContextWindowTotalSource;ZZ)V", "getConversationId", "()Ljava/lang/String;", "getAnchorMessageId", "getUsageMessageId", "getParts", "()Lcom/larus/contextwindow/api/ContextWindowUsageParts;", "getUsed", "()J", "getTotal", "getTotalPercentTenths", "()I", "getUsageSource", "()Lcom/larus/contextwindow/api/ContextWindowUsageSource;", "getTotalSource", "()Lcom/larus/contextwindow/api/ContextWindowTotalSource;", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ContextWindowSnapshot implements Parcelable {
    public static final Parcelable.Creator<ContextWindowSnapshot> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f330254a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f330255b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f330256c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ContextWindowUsageParts f330257d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f330258e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f330259f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f330260g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ContextWindowUsageSource f330261h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ContextWindowTotalSource f330262i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f330263j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f330264k;

    public static final class a implements Parcelable.Creator<ContextWindowSnapshot> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ContextWindowSnapshot createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "parcel");
            String r100 = r110.readString();
            String r101 = r110.readString();
            String r102 = r110.readString();
            ContextWindowUsageParts r103 = ContextWindowUsageParts.CREATOR.createFromParcel(r110);
            long r104 = r110.readLong();
            long r105 = r110.readLong();
            int r111 = r110.readInt();
            ContextWindowUsageSource r112 = ContextWindowUsageSource.valueOf(r110.readString());
            ContextWindowTotalSource r113 = ContextWindowTotalSource.valueOf(r110.readString());
            boolean r114 = false;
            if (r110.readInt() == 0) goto L5;
            boolean r115 = true;
        L7:
            if (r110.readInt() == 0) goto L10;
            r114 = true;
        L10:
            return new ContextWindowSnapshot(r100, r101, r102, r103, r104, r105, r111, r112, r113, r115, r114);
        L5:
            r115 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final ContextWindowSnapshot[] newArray(int r100) {
            return new ContextWindowSnapshot[r100];
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
        if ((r100 instanceof ContextWindowSnapshot) == true) goto L8;
        return false;
    L8:
        ContextWindowSnapshot r101 = (ContextWindowSnapshot) r100;
        if (Intrinsics.areEqual(this.f330254a, r101.f330254a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f330255b, r101.f330255b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f330256c, r101.f330256c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f330257d, r101.f330257d) == true) goto L21;
        return false;
    L21:
        if (this.f330258e == r101.f330258e) goto L24;
        return false;
    L24:
        if (this.f330259f == r101.f330259f) goto L27;
        return false;
    L27:
        if (this.f330260g == r101.f330260g) goto L30;
        return false;
    L30:
        if (this.f330261h == r101.f330261h) goto L33;
        return false;
    L33:
        if (this.f330262i == r101.f330262i) goto L36;
        return false;
    L36:
        if (this.f330263j == r101.f330263j) goto L39;
        return false;
    L39:
        if (this.f330264k == r101.f330264k) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f330254a.hashCode() * 31;
        String r101 = this.f330255b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (((((r100 + r102) * 31) + this.f330256c.hashCode()) * 31) + this.f330257d.hashCode()) * 31;
        long r104 = this.f330258e;
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        long r106 = this.f330259f;
        int r107 = (((((((r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31) + this.f330260g) * 31) + this.f330261h.hashCode()) * 31) + this.f330262i.hashCode()) * 31;
        int r108 = 1231;
        if (this.f330263j == false) goto L9;
        int r109 = 1231;
    L10:
        int r110 = (r107 + r109) * 31;
        if (this.f330264k == true) goto L15;
        r108 = 1237;
    L15:
        return r110 + r108;
    L9:
        r109 = 1237;
        goto L10
    L5:
        r102 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "ContextWindowSnapshot(conversationId=" + this.f330254a + ", anchorMessageId=" + this.f330255b + ", usageMessageId=" + this.f330256c + ", parts=" + this.f330257d + ", used=" + this.f330258e + ", total=" + this.f330259f + ", totalPercentTenths=" + this.f330260g + ", usageSource=" + this.f330261h + ", totalSource=" + this.f330262i + ", isStreaming=" + this.f330263j + ", isCompressing=" + this.f330264k + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.f330254a);
        r100.writeString(this.f330255b);
        r100.writeString(this.f330256c);
        this.f330257d.writeToParcel(r100, r101);
        r100.writeLong(this.f330258e);
        r100.writeLong(this.f330259f);
        r100.writeInt(this.f330260g);
        r100.writeString(this.f330261h.name());
        r100.writeString(this.f330262i.name());
        r100.writeInt(this.f330263j ? 1 : 0);
        r100.writeInt(this.f330264k ? 1 : 0);
    }

    public static ContextWindowSnapshot a(ContextWindowSnapshot r110) {
        String r100 = r110.f330254a;
        String r101 = r110.f330255b;
        String r102 = r110.f330256c;
        ContextWindowUsageParts r103 = r110.f330257d;
        long r104 = r110.f330258e;
        long r105 = r110.f330259f;
        int r106 = r110.f330260g;
        ContextWindowUsageSource r111 = r110.f330261h;
        ContextWindowTotalSource r112 = r110.f330262i;
        boolean r113 = r110.f330263j;
        r110.getClass();
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        Intrinsics.checkNotNullParameter(r102, "usageMessageId");
        Intrinsics.checkNotNullParameter(r103, "parts");
        Intrinsics.checkNotNullParameter(r111, "usageSource");
        Intrinsics.checkNotNullParameter(r112, "totalSource");
        return new ContextWindowSnapshot(r100, r101, r102, r103, r104, r105, r106, r111, r112, r113, false);
    }

    public ContextWindowSnapshot(String r100, String r101, String r102, ContextWindowUsageParts r103, long r104, long r105, int r110, ContextWindowUsageSource r111, ContextWindowTotalSource r112, boolean r113, boolean r114) {
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        Intrinsics.checkNotNullParameter(r102, "usageMessageId");
        Intrinsics.checkNotNullParameter(r103, "parts");
        Intrinsics.checkNotNullParameter(r111, "usageSource");
        Intrinsics.checkNotNullParameter(r112, "totalSource");
        this.f330254a = r100;
        this.f330255b = r101;
        this.f330256c = r102;
        this.f330257d = r103;
        this.f330258e = r104;
        this.f330259f = r105;
        this.f330260g = r110;
        this.f330261h = r111;
        this.f330262i = r112;
        this.f330263j = r113;
        this.f330264k = r114;
    }
}
