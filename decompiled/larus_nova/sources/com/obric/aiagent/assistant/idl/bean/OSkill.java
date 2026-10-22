package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.support.feature.result.CommonConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u001b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B]\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010!\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010\"\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0017Jd\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010$J\u0006\u0010%\u001a\u00020&J\u0013\u0010'\u001a\u00020\u00072\b\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\t\u0010*\u001a\u00020&HÖ\u0001J\t\u0010+\u001a\u00020\u0003HÖ\u0001J\u0016\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020&R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0019\u0010\u0017R\u0015\u0010\f\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u001a\u0010\u0017¨\u00061"}, d2 = {"Lcom/obric/aiagent/assistant/idl/bean/OSkill;", "Landroid/os/Parcelable;", "slug", "", CommonConstant.KEY_DISPLAY_NAME, "coverUrl", "enabled", "", "available", "createdAt", "", "lastUsedAt", "lastUpdatedAt", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)V", "getSlug", "()Ljava/lang/String;", "getDisplayName", "getCoverUrl", "getEnabled", "()Z", "getAvailable", "getCreatedAt", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getLastUsedAt", "getLastUpdatedAt", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)Lcom/obric/aiagent/assistant/idl/bean/OSkill;", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OSkill implements Parcelable {
    public static final Parcelable.Creator<OSkill> CREATOR = null;
    private final boolean available;
    private final String coverUrl;
    private final Long createdAt;
    private final String displayName;
    private final boolean enabled;
    private final Long lastUpdatedAt;
    private final Long lastUsedAt;
    private final String slug;

    /* JADX INFO: loaded from: classes32.dex */
    public static final class a implements Parcelable.Creator<OSkill> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final OSkill createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "parcel");
            String r100 = r110.readString();
            String r101 = r110.readString();
            String r102 = r110.readString();
            boolean r103 = false;
            if (r110.readInt() == 0) goto L5;
            boolean r104 = true;
        L7:
            if (r110.readInt() == 0) goto L10;
            r103 = true;
        L10:
            if (r110.readInt() != 0) goto L12;
            Long r105 = null;
        L14:
            if (r110.readInt() != 0) goto L16;
            Long r106 = null;
        L18:
            if (r110.readInt() != 0) goto L20;
            Long r111 = null;
        L22:
            return new OSkill(r100, r101, r102, r104, r103, r105, r106, r111);
        L20:
            r111 = Long.valueOf(r110.readLong());
            goto L22
        L16:
            r106 = Long.valueOf(r110.readLong());
            goto L18
        L12:
            r105 = Long.valueOf(r110.readLong());
            goto L14
        L5:
            r104 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final OSkill[] newArray(int r100) {
            return new OSkill[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public OSkill() {
        this(null, null, null, false, false, null, null, null, 255, null);
    }

    public static /* synthetic */ OSkill copy$default(OSkill r100, String r110, String r111, String r112, boolean r113, boolean r114, Long r115, Long r116, Long r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        String r101 = r100.slug;
    L7:
        if ((r118 & 2) == 0) goto L9;
        String r102 = r100.displayName;
    L11:
        if ((r118 & 4) == 0) goto L13;
        String r103 = r100.coverUrl;
    L15:
        if ((r118 & 8) == 0) goto L17;
        boolean r104 = r100.enabled;
    L19:
        if ((r118 & 16) == 0) goto L21;
        boolean r105 = r100.available;
    L23:
        if ((r118 & 32) == 0) goto L25;
        Long r106 = r100.createdAt;
    L27:
        if ((r118 & 64) == 0) goto L29;
        Long r107 = r100.lastUsedAt;
    L31:
        if ((r118 & 128) == 0) goto L33;
        Long r108 = r100.lastUpdatedAt;
    L35:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107, r108);
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
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public final String component1() {
        return this.slug;
    }

    public final String component2() {
        return this.displayName;
    }

    public final String component3() {
        return this.coverUrl;
    }

    public final boolean component4() {
        return this.enabled;
    }

    public final boolean component5() {
        return this.available;
    }

    public final Long component6() {
        return this.createdAt;
    }

    public final Long component7() {
        return this.lastUsedAt;
    }

    public final Long component8() {
        return this.lastUpdatedAt;
    }

    public final OSkill copy(String r110, String r111, String r112, boolean r113, boolean r114, Long r115, Long r116, Long r117) {
        Intrinsics.checkNotNullParameter(r110, "slug");
        Intrinsics.checkNotNullParameter(r111, CommonConstant.KEY_DISPLAY_NAME);
        Intrinsics.checkNotNullParameter(r112, "coverUrl");
        return new OSkill(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OSkill) == true) goto L8;
        return false;
    L8:
        OSkill r101 = (OSkill) r100;
        if (Intrinsics.areEqual(this.slug, r101.slug) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.displayName, r101.displayName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.coverUrl, r101.coverUrl) == true) goto L18;
        return false;
    L18:
        if (this.enabled == r101.enabled) goto L21;
        return false;
    L21:
        if (this.available == r101.available) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.createdAt, r101.createdAt) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.lastUsedAt, r101.lastUsedAt) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.lastUpdatedAt, r101.lastUpdatedAt) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        int r100 = ((((this.slug.hashCode() * 31) + this.displayName.hashCode()) * 31) + this.coverUrl.hashCode()) * 31;
        int r101 = 1231;
        if (this.enabled == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.available == true) goto L10;
        r101 = 1237;
    L10:
        int r104 = (r103 + r101) * 31;
        Long r105 = this.createdAt;
        int r106 = 0;
        if (r105 != null) goto L13;
        int r107 = 0;
    L14:
        int r108 = (r104 + r107) * 31;
        Long r109 = this.lastUsedAt;
        if (r109 != null) goto L17;
        int r110 = 0;
    L18:
        int r111 = (r108 + r110) * 31;
        Long r112 = this.lastUpdatedAt;
        if (r112 == null) goto L23;
        r106 = r112.hashCode();
    L23:
        return r111 + r106;
    L17:
        r110 = r109.hashCode();
        goto L18
    L13:
        r107 = r105.hashCode();
        goto L14
    L5:
        r102 = 1237;
        goto L6
    }

    public String toString() {
        return "OSkill(slug=" + this.slug + ", displayName=" + this.displayName + ", coverUrl=" + this.coverUrl + ", enabled=" + this.enabled + ", available=" + this.available + ", createdAt=" + this.createdAt + ", lastUsedAt=" + this.lastUsedAt + ", lastUpdatedAt=" + this.lastUpdatedAt + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.slug);
        r100.writeString(this.displayName);
        r100.writeString(this.coverUrl);
        r100.writeInt(this.enabled ? 1 : 0);
        r100.writeInt(this.available ? 1 : 0);
        Long r102 = this.createdAt;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L6:
        Long r103 = this.lastUsedAt;
        if (r103 != null) goto L9;
        r100.writeInt(0);
    L10:
        Long r104 = this.lastUpdatedAt;
        if (r104 != null) goto L13;
        r100.writeInt(0);
        return;
    L13:
        r100.writeInt(1);
        r100.writeLong(r104.longValue());
        return;
    L9:
        r100.writeInt(1);
        r100.writeLong(r103.longValue());
        goto L10
    L5:
        r100.writeInt(1);
        r100.writeLong(r102.longValue());
        goto L6
    }

    public final boolean getAvailable() {
        return this.available;
    }

    public final String getCoverUrl() {
        return this.coverUrl;
    }

    public final Long getCreatedAt() {
        return this.createdAt;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final Long getLastUpdatedAt() {
        return this.lastUpdatedAt;
    }

    public final Long getLastUsedAt() {
        return this.lastUsedAt;
    }

    public final String getSlug() {
        return this.slug;
    }

    public OSkill(String r100, String r101, String r102, boolean r103, boolean r104, Long r105, Long r106, Long r107) {
        Intrinsics.checkNotNullParameter(r100, "slug");
        Intrinsics.checkNotNullParameter(r101, CommonConstant.KEY_DISPLAY_NAME);
        Intrinsics.checkNotNullParameter(r102, "coverUrl");
        this.slug = r100;
        this.displayName = r101;
        this.coverUrl = r102;
        this.enabled = r103;
        this.available = r104;
        this.createdAt = r105;
        this.lastUsedAt = r106;
        this.lastUpdatedAt = r107;
    }

    public /* synthetic */ OSkill(String r110, String r111, String r112, boolean r113, boolean r114, Long r115, Long r116, Long r117, int r118, DefaultConstructorMarker r119) {
        String r100 = "";
        if ((r118 & 1) == 0) goto L5;
        String r101 = "";
    L7:
        if ((r118 & 2) == 0) goto L9;
        String r102 = "";
    L11:
        if ((r118 & 4) != 0) goto L14;
        r100 = r112;
    L14:
        boolean r103 = false;
        if ((r118 & 8) == 0) goto L17;
        boolean r104 = false;
    L19:
        if ((r118 & 16) != 0) goto L22;
        r103 = r114;
    L22:
        Long r105 = null;
        if ((r118 & 32) == 0) goto L25;
        Long r106 = null;
    L27:
        if ((r118 & 64) == 0) goto L29;
        Long r107 = null;
    L31:
        if ((r118 & 128) != 0) goto L34;
        r105 = r117;
    L34:
        this(r101, r102, r100, r104, r103, r106, r107, r105);
        return;
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L17:
        r104 = r113;
        goto L19
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
