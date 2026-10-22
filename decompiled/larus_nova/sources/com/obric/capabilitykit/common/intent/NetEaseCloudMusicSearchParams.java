package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import com.obric.capabilitykit.EntityProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B5\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\nJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0011J>\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010 J\t\u0010!\u001a\u00020\u0006HÖ\u0001J\u0013\u0010\"\u001a\u00020\b2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020\u0006HÖ\u0001J\b\u0010&\u001a\u00020\bH\u0016J\u0012\u0010'\u001a\u00020\u00012\b\u0010(\u001a\u0004\u0018\u00010$H\u0016J\t\u0010)\u001a\u00020\u0004HÖ\u0001J\u0019\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u0006HÖ\u0001R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\t\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006/"}, d2 = {"Lcom/obric/capabilitykit/common/intent/NetEaseCloudMusicSearchParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "query", "", EntityProvider.KEY_ENTITY_TYPE, "", "auto_play", "", "count", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;)V", "getAuto_play", "()Ljava/lang/Boolean;", "setAuto_play", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getCount", "()Ljava/lang/Integer;", "setCount", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getEntity_type", "setEntity_type", "getQuery", "()Ljava/lang/String;", "setQuery", "(Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;)Lcom/obric/capabilitykit/common/intent/NetEaseCloudMusicSearchParams;", "describeContents", "equals", "other", "", "hashCode", "isParamsCompleted", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class NetEaseCloudMusicSearchParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<NetEaseCloudMusicSearchParams> CREATOR = null;
    private Boolean auto_play;
    private Integer count;
    private Integer entity_type;
    private String query;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<NetEaseCloudMusicSearchParams> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final NetEaseCloudMusicSearchParams createFromParcel(Parcel r110) {
            int r100 = r110.readInt();
            Intrinsics.checkNotNullParameter(r110, "parcel");
            String r101 = r110.readString();
            Integer r102 = null;
            if (r110.readInt() != 0) goto L5;
            Integer r103 = null;
        L6:
            int r104 = 1;
            if (r110.readInt() != 0) goto L10;
            Boolean r105 = null;
        L15:
            if (r110.readInt() == 0) goto L18;
            r102 = Integer.valueOf(r110.readInt());
        L18:
            NetEaseCloudMusicSearchParams r106 = new NetEaseCloudMusicSearchParams(r101, r103, r105, r102);
            int r107 = Math.min(r100, 0);
            ClassLoader r108 = a.class.getClassLoader();
        L19:
            if (r104 > r107) goto L21;
            r104 = r104 + 1;
        L21:
            if (r104 > r100) goto L23;
            joa.a.d(r110, r108);
            r104 = r104 + 1;
            goto L21
        L23:
            return r106;
        L10:
            if (r110.readInt() == 0) goto L12;
            boolean r109 = true;
        L13:
            r105 = Boolean.valueOf(r109);
            goto L15
        L12:
            r109 = false;
            goto L13
        L5:
            r103 = Integer.valueOf(r110.readInt());
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final NetEaseCloudMusicSearchParams[] newArray(int r100) {
            return new NetEaseCloudMusicSearchParams[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public NetEaseCloudMusicSearchParams() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ NetEaseCloudMusicSearchParams copy$default(NetEaseCloudMusicSearchParams r100, String r101, Integer r102, Boolean r103, Integer r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.query;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.entity_type;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.auto_play;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.count;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.query;
    }

    public final Integer component2() {
        return this.entity_type;
    }

    public final Boolean component3() {
        return this.auto_play;
    }

    public final Integer component4() {
        return this.count;
    }

    public final NetEaseCloudMusicSearchParams copy(String r100, Integer r101, Boolean r102, Integer r103) {
        return new NetEaseCloudMusicSearchParams(r100, r101, r102, r103);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof NetEaseCloudMusicSearchParams) == true) goto L8;
        return false;
    L8:
        NetEaseCloudMusicSearchParams r101 = (NetEaseCloudMusicSearchParams) r100;
        if (Intrinsics.areEqual(this.query, r101.query) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.entity_type, r101.entity_type) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.auto_play, r101.auto_play) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.count, r101.count) == true) goto L20;
        return false;
    L20:
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
        Integer r104 = this.entity_type;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.auto_play;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.count;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
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

    public String toString() {
        return "NetEaseCloudMusicSearchParams(query=" + this.query + ", entity_type=" + this.entity_type + ", auto_play=" + this.auto_play + ", count=" + this.count + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        int r102 = 0;
        r100.writeInt(0);
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        r100.writeString(this.query);
        Integer r103 = this.entity_type;
        if (r103 != null) goto L5;
        r100.writeInt(0);
    L6:
        Boolean r104 = this.auto_play;
        if (r104 != null) goto L9;
        r100.writeInt(0);
    L10:
        Integer r105 = this.count;
        if (r105 == null) goto L14;
        r100.writeInt(1);
        r102 = r105.intValue();
    L14:
        r100.writeInt(r102);
        return;
    L9:
        r100.writeInt(1);
        r100.writeInt(r104.booleanValue() ? 1 : 0);
        goto L10
    L5:
        r100.writeInt(1);
        r100.writeInt(r103.intValue());
        goto L6
    }

    public boolean isParamsCompleted() {
        if (this.query == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final Boolean getAuto_play() {
        return this.auto_play;
    }

    public final Integer getCount() {
        return this.count;
    }

    public final Integer getEntity_type() {
        return this.entity_type;
    }

    public final String getQuery() {
        return this.query;
    }

    public IntentParams mergeParams(Object r100) {
        if ((r100 instanceof NetEaseCloudMusicSearchParams) == true) goto L5;
        return this;
    L5:
        String r101 = this.query;
        if (r101 != null) goto L8;
        r101 = ((NetEaseCloudMusicSearchParams) r100).query;
    L8:
        Integer r102 = this.entity_type;
        if (r102 != null) goto L11;
        r102 = ((NetEaseCloudMusicSearchParams) r100).entity_type;
    L11:
        Boolean r103 = this.auto_play;
        if (r103 != null) goto L14;
        r103 = ((NetEaseCloudMusicSearchParams) r100).auto_play;
    L14:
        Integer r104 = this.count;
        if (r104 != null) goto L18;
        r104 = ((NetEaseCloudMusicSearchParams) r100).count;
    L18:
        return new NetEaseCloudMusicSearchParams(r101, r102, r103, r104);
    }

    public final void setAuto_play(Boolean r100) {
        this.auto_play = r100;
    }

    public final void setCount(Integer r100) {
        this.count = r100;
    }

    public final void setEntity_type(Integer r100) {
        this.entity_type = r100;
    }

    public final void setQuery(String r100) {
        this.query = r100;
    }

    public NetEaseCloudMusicSearchParams(String r100, Integer r101, Boolean r102, Integer r103) {
        this.query = r100;
        this.entity_type = r101;
        this.auto_play = r102;
        this.count = r103;
    }

    public /* synthetic */ NetEaseCloudMusicSearchParams(String r100, Integer r101, Boolean r102, Integer r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
