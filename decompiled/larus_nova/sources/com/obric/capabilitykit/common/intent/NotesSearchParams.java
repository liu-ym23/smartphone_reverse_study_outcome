package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.alipay.sdk.m.x.d;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b%\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002BY\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\u000b\u0010'\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010)\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010*\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010+\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u001dJb\u0010.\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0002\u0010/J\t\u00100\u001a\u00020\rHÖ\u0001J\u0013\u00101\u001a\u00020\t2\b\u00102\u001a\u0004\u0018\u000103HÖ\u0003J\t\u00104\u001a\u00020\rHÖ\u0001J\u0012\u00105\u001a\u00020\u00012\b\u00106\u001a\u0004\u0018\u000103H\u0016J\t\u00107\u001a\u00020\u0004HÖ\u0001J\u0019\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\rHÖ\u0001R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\b\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0010\"\u0004\b\"\u0010\u0012R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b#\u0010\u0014\"\u0004\b$\u0010\u0016R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0010\"\u0004\b&\u0010\u0012¨\u0006="}, d2 = {"Lcom/obric/capabilitykit/common/intent/NotesSearchParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "query", "", "startTimestamp", "", "endTimestamp", Keys.API_EVENT_KEY_IS_FAVORITE, "", "title", "content", "maxCount", "", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "getEndTimestamp", "()Ljava/lang/Long;", "setEndTimestamp", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "()Ljava/lang/Boolean;", "setFavorite", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getMaxCount", "()Ljava/lang/Integer;", "setMaxCount", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getQuery", "setQuery", "getStartTimestamp", "setStartTimestamp", "getTitle", d.f25925o, "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/obric/capabilitykit/common/intent/NotesSearchParams;", "describeContents", "equals", "other", "", "hashCode", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class NotesSearchParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<NotesSearchParams> CREATOR = null;
    private String content;
    private Long endTimestamp;
    private Boolean isFavorite;
    private Integer maxCount;
    private String query;
    private Long startTimestamp;
    private String title;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<NotesSearchParams> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final NotesSearchParams createFromParcel(Parcel r110) {
            int r100 = r110.readInt();
            Intrinsics.checkNotNullParameter(r110, "parcel");
            String r101 = r110.readString();
            if (r110.readInt() != 0) goto L5;
            Long r102 = null;
        L7:
            if (r110.readInt() != 0) goto L9;
            Long r103 = null;
        L10:
            int r111 = 1;
            if (r110.readInt() != 0) goto L14;
            Boolean r104 = null;
        L18:
            String r105 = r110.readString();
            String r106 = r110.readString();
            if (r110.readInt() != 0) goto L21;
            Integer r112 = null;
        L22:
            NotesSearchParams r107 = new NotesSearchParams(r101, r102, r103, r104, r105, r106, r112);
            int r108 = Math.min(r100, 0);
            ClassLoader r109 = a.class.getClassLoader();
        L23:
            if (r111 > r108) goto L25;
            r111 = r111 + 1;
        L25:
            if (r111 > r100) goto L27;
            joa.a.d(r110, r109);
            r111 = r111 + 1;
            goto L25
        L27:
            return r107;
        L21:
            r112 = Integer.valueOf(r110.readInt());
            goto L22
        L14:
            if (r110.readInt() == 0) goto L16;
            boolean r113 = true;
        L17:
            r104 = Boolean.valueOf(r113);
            goto L18
        L16:
            r113 = false;
            goto L17
        L9:
            r103 = Long.valueOf(r110.readLong());
            goto L10
        L5:
            r102 = Long.valueOf(r110.readLong());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final NotesSearchParams[] newArray(int r100) {
            return new NotesSearchParams[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public NotesSearchParams() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ NotesSearchParams copy$default(NotesSearchParams r100, String r101, Long r102, Long r103, Boolean r104, String r110, String r111, Integer r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.query;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.startTimestamp;
    L8:
        Long r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.endTimestamp;
    L11:
        Long r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.isFavorite;
    L14:
        Boolean r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.title;
    L17:
        String r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.content;
    L20:
        String r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.maxCount;
    L23:
        String r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final String component1() {
        return this.query;
    }

    public final Long component2() {
        return this.startTimestamp;
    }

    public final Long component3() {
        return this.endTimestamp;
    }

    public final Boolean component4() {
        return this.isFavorite;
    }

    public final String component5() {
        return this.title;
    }

    public final String component6() {
        return this.content;
    }

    public final Integer component7() {
        return this.maxCount;
    }

    public final NotesSearchParams copy(String r110, Long r111, Long r112, Boolean r113, String r114, String r115, Integer r116) {
        return new NotesSearchParams(r110, r111, r112, r113, r114, r115, r116);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof NotesSearchParams) == true) goto L8;
        return false;
    L8:
        NotesSearchParams r101 = (NotesSearchParams) r100;
        if (Intrinsics.areEqual(this.query, r101.query) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.startTimestamp, r101.startTimestamp) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.endTimestamp, r101.endTimestamp) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.isFavorite, r101.isFavorite) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.maxCount, r101.maxCount) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public String getSubActionValue() {
        return null;
    }

    public int hashCode() {
        String r100 = this.query;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Long r104 = this.startTimestamp;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.endTimestamp;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.isFavorite;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.title;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.content;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Integer r119 = this.maxCount;
        if (r119 == null) goto L31;
        r101 = r119.hashCode();
    L31:
        return r118 + r101;
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public boolean isParamsCompleted() {
        return true;
    }

    public String toString() {
        return "NotesSearchParams(query=" + this.query + ", startTimestamp=" + this.startTimestamp + ", endTimestamp=" + this.endTimestamp + ", isFavorite=" + this.isFavorite + ", title=" + this.title + ", content=" + this.content + ", maxCount=" + this.maxCount + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        int r102 = 0;
        r100.writeInt(0);
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        r100.writeString(this.query);
        Long r103 = this.startTimestamp;
        if (r103 != null) goto L5;
        r100.writeInt(0);
    L6:
        Long r104 = this.endTimestamp;
        if (r104 != null) goto L9;
        r100.writeInt(0);
    L10:
        Boolean r105 = this.isFavorite;
        if (r105 != null) goto L13;
        r100.writeInt(0);
    L14:
        r100.writeString(this.title);
        r100.writeString(this.content);
        Integer r106 = this.maxCount;
        if (r106 == null) goto L18;
        r100.writeInt(1);
        r102 = r106.intValue();
    L18:
        r100.writeInt(r102);
        return;
    L13:
        r100.writeInt(1);
        r100.writeInt(r105.booleanValue() ? 1 : 0);
        goto L14
    L9:
        r100.writeInt(1);
        r100.writeLong(r104.longValue());
        goto L10
    L5:
        r100.writeInt(1);
        r100.writeLong(r103.longValue());
        goto L6
    }

    public final String getContent() {
        return this.content;
    }

    public final Long getEndTimestamp() {
        return this.endTimestamp;
    }

    public final Integer getMaxCount() {
        return this.maxCount;
    }

    public final String getQuery() {
        return this.query;
    }

    public final Long getStartTimestamp() {
        return this.startTimestamp;
    }

    public final String getTitle() {
        return this.title;
    }

    public final Boolean isFavorite() {
        return this.isFavorite;
    }

    public IntentParams mergeParams(Object r110) {
        if ((r110 instanceof NotesSearchParams) == true) goto L5;
        return this;
    L5:
        String r100 = this.query;
        if (r100 != null) goto L8;
        r100 = ((NotesSearchParams) r110).query;
    L8:
        String r101 = r100;
        Long r102 = this.startTimestamp;
        if (r102 != null) goto L11;
        r102 = ((NotesSearchParams) r110).startTimestamp;
    L11:
        Long r103 = r102;
        Long r104 = this.endTimestamp;
        if (r104 != null) goto L14;
        r104 = ((NotesSearchParams) r110).endTimestamp;
    L14:
        Long r105 = r104;
        Boolean r106 = this.isFavorite;
        if (r106 != null) goto L17;
        r106 = ((NotesSearchParams) r110).isFavorite;
    L17:
        Boolean r107 = r106;
        String r108 = this.title;
        if (r108 != null) goto L20;
        r108 = ((NotesSearchParams) r110).title;
    L20:
        String r109 = r108;
        String r111 = this.content;
        if (r111 != null) goto L23;
        r111 = ((NotesSearchParams) r110).content;
    L23:
        String r112 = r111;
        Integer r113 = this.maxCount;
        if (r113 != null) goto L26;
        Integer r114 = ((NotesSearchParams) r110).maxCount;
    L28:
        return new NotesSearchParams(r101, r103, r105, r107, r109, r112, r114);
    L26:
        r114 = r113;
        goto L28
    }

    public final void setContent(String r100) {
        this.content = r100;
    }

    public final void setEndTimestamp(Long r100) {
        this.endTimestamp = r100;
    }

    public final void setFavorite(Boolean r100) {
        this.isFavorite = r100;
    }

    public final void setMaxCount(Integer r100) {
        this.maxCount = r100;
    }

    public final void setQuery(String r100) {
        this.query = r100;
    }

    public final void setStartTimestamp(Long r100) {
        this.startTimestamp = r100;
    }

    public final void setTitle(String r100) {
        this.title = r100;
    }

    public NotesSearchParams(String r100, Long r101, Long r102, Boolean r103, String r104, String r105, Integer r106) {
        this.query = r100;
        this.startTimestamp = r101;
        this.endTimestamp = r102;
        this.isFavorite = r103;
        this.title = r104;
        this.content = r105;
        this.maxCount = r106;
    }

    public /* synthetic */ NotesSearchParams(String r100, Long r101, Long r102, Boolean r110, String r111, String r112, Integer r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 1) == 0) goto L5;
        String r116 = null;
    L7:
        if ((r114 & 2) == 0) goto L9;
        Long r103 = null;
    L11:
        if ((r114 & 4) == 0) goto L13;
        Long r104 = null;
    L15:
        if ((r114 & 8) == 0) goto L17;
        Boolean r105 = null;
    L19:
        if ((r114 & 16) == 0) goto L21;
        String r106 = null;
    L23:
        if ((r114 & 32) == 0) goto L25;
        String r107 = null;
    L27:
        if ((r114 & 64) == 0) goto L29;
        Integer r117 = null;
    L30:
        this(r116, r103, r104, r105, r106, r107, r117);
        return;
    L29:
        r117 = r113;
        goto L30
    L25:
        r107 = r112;
        goto L27
    L21:
        r106 = r111;
        goto L23
    L17:
        r105 = r110;
        goto L19
    L13:
        r104 = r102;
        goto L15
    L9:
        r103 = r101;
        goto L11
    L5:
        r116 = r100;
        goto L7
    }
}
