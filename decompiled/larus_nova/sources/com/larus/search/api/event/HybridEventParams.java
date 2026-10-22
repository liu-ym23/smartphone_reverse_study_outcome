package com.larus.search.api.event;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.android.ec.slice.SliceInitService;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b\u0015\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bi\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0018\b\u0002\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#J\b\u0010$\u001a\u0004\u0018\u00010#J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010)\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0018J\u0019\u0010*\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000bHÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÂ\u0003Jp\u0010,\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u0018\b\u0002\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010-J\u0006\u0010.\u001a\u00020/J\u0013\u00100\u001a\u00020\t2\b\u00101\u001a\u0004\u0018\u000102HÖ\u0003J\t\u00103\u001a\u00020/HÖ\u0001J\t\u00104\u001a\u00020\u0003HÖ\u0001J\u0016\u00105\u001a\u00020!2\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020/R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\b\u0010\u0018\"\u0004\b\u0019\u0010\u001aR*\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/larus/search/api/event/HybridEventParams;", "Landroid/os/Parcelable;", "enterMethod", "", "localPage", "chatType", "duration", "", "isRichMediaPictureLink", "", "mobMap", "", "extra", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/util/Map;Ljava/lang/String;)V", "getEnterMethod", "()Ljava/lang/String;", "getLocalPage", "getChatType", "getDuration", "()Ljava/lang/Long;", "setDuration", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "()Ljava/lang/Boolean;", "setRichMediaPictureLink", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getMobMap", "()Ljava/util/Map;", "setMobMap", "(Ljava/util/Map;)V", "addExtraParams", "", "jsonObject", "Lorg/json/JSONObject;", "getExtraParams", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/util/Map;Ljava/lang/String;)Lcom/larus/search/api/event/HybridEventParams;", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "dest", "Landroid/os/Parcel;", "flags", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HybridEventParams implements Parcelable {
    public static final Parcelable.Creator<HybridEventParams> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f367379a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f367380b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f367381c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Long f367382d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Boolean f367383e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Map<String, String> f367384f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f367385g;

    public static final class a implements Parcelable.Creator<HybridEventParams> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final HybridEventParams createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "parcel");
            String r100 = r110.readString();
            String r101 = r110.readString();
            String r102 = r110.readString();
            if (r110.readInt() != 0) goto L5;
            Long r103 = null;
        L6:
            int r104 = 0;
            if (r110.readInt() != 0) goto L10;
            Boolean r105 = null;
        L15:
            if (r110.readInt() != 0) goto L17;
            LinkedHashMap r106 = null;
        L21:
            return new HybridEventParams(r100, r101, r102, r103, r105, r106, r110.readString());
        L17:
            int r107 = r110.readInt();
            r106 = new LinkedHashMap(r107);
        L18:
            if (r104 == r107) goto L21;
            r106.put(r110.readString(), r110.readString());
            r104 = r104 + 1;
            goto L18
        L10:
            if (r110.readInt() == 0) goto L12;
            boolean r108 = true;
        L13:
            r105 = Boolean.valueOf(r108);
            goto L15
        L12:
            r108 = false;
            goto L13
        L5:
            r103 = Long.valueOf(r110.readLong());
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final HybridEventParams[] newArray(int r100) {
            return new HybridEventParams[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public HybridEventParams() {
        this(null, null, null, null, 127);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof HybridEventParams) == true) goto L8;
        return false;
    L8:
        HybridEventParams r101 = (HybridEventParams) r100;
        if (Intrinsics.areEqual(this.f367379a, r101.f367379a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f367380b, r101.f367380b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f367381c, r101.f367381c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f367382d, r101.f367382d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f367383e, r101.f367383e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f367384f, r101.f367384f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f367385g, r101.f367385g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f367379a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f367380b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f367381c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Long r110 = this.f367382d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Boolean r113 = this.f367383e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Map<String, String> r116 = this.f367384f;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f367385g;
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

    public final String toString() {
        return "HybridEventParams(enterMethod=" + this.f367379a + ", localPage=" + this.f367380b + ", chatType=" + this.f367381c + ", duration=" + this.f367382d + ", isRichMediaPictureLink=" + this.f367383e + ", mobMap=" + this.f367384f + ", extra=" + this.f367385g + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.f367379a);
        r100.writeString(this.f367380b);
        r100.writeString(this.f367381c);
        Long r102 = this.f367382d;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L6:
        Boolean r103 = this.f367383e;
        if (r103 != null) goto L9;
        r100.writeInt(0);
    L10:
        Map<String, String> r104 = this.f367384f;
        if (r104 != null) goto L13;
        r100.writeInt(0);
    L17:
        r100.writeString(this.f367385g);
        return;
    L13:
        r100.writeInt(1);
        r100.writeInt(r104.size());
        Iterator<Map.Entry<String, String>> r105 = r104.entrySet().iterator();
    L15:
        if (r105.hasNext() == false) goto L17;
        Map.Entry<String, String> r106 = r105.next();
        r100.writeString(r106.getKey());
        r100.writeString(r106.getValue());
        goto L15
    L9:
        r100.writeInt(1);
        r100.writeInt(r103.booleanValue() ? 1 : 0);
        goto L10
    L5:
        r100.writeInt(1);
        r100.writeLong(r102.longValue());
        goto L6
    }

    public final void a(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "jsonObject");
        if (this.f367385g != null) goto L18;
        this.f367385g = r100.toString();
        return;
    L18:
        String r101 = this.f367385g;     // Catch: JSONException -> L11
        if (r101 != null) goto L9;
        r101 = SliceInitService.DEFAULT_SWITCH;
    L9:
        JSONObject r102 = new JSONObject(r101);     // Catch: JSONException -> L11
    L12:
        Iterator<String> r103 = r100.keys();
    L14:
        if (r103.hasNext() == false) goto L16;
        String r104 = r103.next();
        r102.put(r104, r100.get(r104));
        goto L14
    L16:
        this.f367385g = r102.toString();
        return;
    L11:
        r102 = new JSONObject();
        goto L12
    }

    public /* synthetic */ HybridEventParams(String r110, String r111, String r112, Map r113, int r114) {
        if ((r114 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r114 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r114 & 4) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r114 & 8) == 0) goto L17;
        Long r103 = 0L;
    L19:
        if ((r114 & 16) == 0) goto L21;
        Boolean r104 = Boolean.FALSE;
    L23:
        if ((r114 & 32) == 0) goto L25;
        Map r105 = null;
    L26:
        this(r100, r101, r102, r103, r104, r105, null);
        return;
    L25:
        r105 = r113;
        goto L26
    L21:
        r104 = null;
        goto L23
    L17:
        r103 = null;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }

    public HybridEventParams(String r100, String r101, String r102, Long r103, Boolean r104, Map<String, String> r105, String r106) {
        this.f367379a = r100;
        this.f367380b = r101;
        this.f367381c = r102;
        this.f367382d = r103;
        this.f367383e = r104;
        this.f367384f = r105;
        this.f367385g = r106;
    }
}
