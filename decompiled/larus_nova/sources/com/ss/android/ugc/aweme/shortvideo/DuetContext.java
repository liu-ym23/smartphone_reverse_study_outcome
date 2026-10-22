package com.ss.android.ugc.aweme.shortvideo;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.ugc.aweme.shortvideo.ui.EmbaddedWindowInfo;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/ss/android/ugc/aweme/shortvideo/DuetContext;", "Landroid/os/Parcelable;", "Companion", "lib-runtime_release"}, k = 1, mv = {1, 4, 1})
public final class DuetContext implements Parcelable {
    public static final Parcelable.Creator<DuetContext> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f454142a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f454143b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f454144c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f454145d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f454146e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f454147f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f454148g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f454149h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f454150i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f454151j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f454152k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final List<EmbaddedWindowInfo> f454153l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f454154m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f454155n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f454156o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f454157p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Effect f454158q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final String f454159r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f454160s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final boolean f454161t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f454162u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String f454163v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Integer f454164w;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0087D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/ss/android/ugc/aweme/shortvideo/DuetContext$Companion;", "", "()V", "DUET_UPLOAD_TYPE_PICTURE", "", "DUET_UPLOAD_TYPE_VIDEO", "GREEN_SCREEN_DUET_LAYOUT", "", "HORIZONTAL_DUET_LAYOUT", "P_IN_P_DUET_LAYOUT", "VERTICAL_DUET_LAYOUT", "lib-runtime_release"}, k = 1, mv = {1, 4, 1})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    public static class Creator implements Parcelable.Creator<DuetContext> {
        public Creator() {
        }

        @Override // android.os.Parcelable.Creator
        public final DuetContext createFromParcel(Parcel r210) {
            Intrinsics.checkNotNullParameter(r210, "in");
            String r100 = r210.readString();
            String r101 = r210.readString();
            String r102 = r210.readString();
            String r103 = r210.readString();
            float r104 = r210.readFloat();
            float r105 = r210.readFloat();
            if (r210.readInt() == 0) goto L5;
            boolean r110 = true;
        L6:
            int r111 = r210.readInt();
            int r112 = r210.readInt();
            String r113 = r210.readString();
            String r114 = r210.readString();
            int r106 = r210.readInt();
            ArrayList r115 = new ArrayList(r106);
        L7:
            if (r106 == 0) goto L10;
            r115.add((EmbaddedWindowInfo) r210.readParcelable(DuetContext.class.getClassLoader()));
            r106 = r106 - 1;
            goto L7
        L10:
            if (r210.readInt() == 0) goto L12;
            boolean r116 = true;
        L13:
            int r117 = r210.readInt();
            String r211 = r210.readString();
            int r212 = r210.readInt();
            Effect r213 = (Effect) r210.readParcelable(DuetContext.class.getClassLoader());
            String r214 = r210.readString();
            if (r210.readInt() == 0) goto L16;
            boolean r215 = true;
        L18:
            if (r210.readInt() == 0) goto L20;
            boolean r216 = true;
        L21:
            int r217 = r210.readInt();
            String r218 = r210.readString();
            if (r210.readInt() == 0) goto L24;
            Integer r107 = Integer.valueOf(r210.readInt());
        L26:
            return new DuetContext(r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r116, r117, r211, r212, r213, r214, r215, r216, r217, r218, r107);
        L24:
            r107 = null;
            goto L26
        L20:
            r216 = false;
            goto L21
        L16:
            r215 = false;
            goto L18
        L12:
            r116 = false;
            goto L13
        L5:
            r110 = false;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final DuetContext[] newArray(int r100) {
            return new DuetContext[r100];
        }
    }

    public DuetContext() {
        this(null, null, null, null, 1.0f, 1.0f, false, 0, 0, null, null, new ArrayList(), false, 0, "", 0, null, null, false, false, 0, null, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof DuetContext) == false) goto L52;
        DuetContext r101 = (DuetContext) r100;
        if (Intrinsics.areEqual(this.f454142a, r101.f454142a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f454143b, r101.f454143b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f454144c, r101.f454144c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f454145d, r101.f454145d) == true) goto L14;
        return false;
    L14:
        if (Float.compare(this.f454146e, r101.f454146e) == 0) goto L16;
        return false;
    L16:
        if (Float.compare(this.f454147f, r101.f454147f) == 0) goto L18;
        return false;
    L18:
        if (this.f454148g == r101.f454148g) goto L20;
        return false;
    L20:
        if (this.f454149h == r101.f454149h) goto L22;
        return false;
    L22:
        if (this.f454150i == r101.f454150i) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f454151j, r101.f454151j) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.f454152k, r101.f454152k) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.f454153l, r101.f454153l) == true) goto L30;
        return false;
    L30:
        if (this.f454154m == r101.f454154m) goto L32;
        return false;
    L32:
        if (this.f454155n == r101.f454155n) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.f454156o, r101.f454156o) == true) goto L36;
        return false;
    L36:
        if (this.f454157p == r101.f454157p) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.f454158q, r101.f454158q) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.f454159r, r101.f454159r) == true) goto L42;
        return false;
    L42:
        if (this.f454160s == r101.f454160s) goto L44;
        return false;
    L44:
        if (this.f454161t == r101.f454161t) goto L46;
        return false;
    L46:
        if (this.f454162u == r101.f454162u) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f454163v, r101.f454163v) == true) goto L50;
        return false;
    L50:
        if (Intrinsics.areEqual(this.f454164w, r101.f454164w) == true) goto L79;
        return false;
    L79:
        return true;
    L52:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r2v14, types: [int] */
    /* JADX WARN: Type inference failed for: r2v27, types: [int] */
    /* JADX WARN: Type inference failed for: r2v40, types: [int] */
    /* JADX WARN: Type inference failed for: r2v48 */
    /* JADX WARN: Type inference failed for: r2v52 */
    /* JADX WARN: Type inference failed for: r2v56 */
    /* JADX WARN: Type inference failed for: r2v60 */
    /* JADX WARN: Type inference failed for: r2v61 */
    /* JADX WARN: Type inference failed for: r2v62 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        String r100 = this.f454142a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f454143b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f454144c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f454145d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (((((r109 + r111) * 31) + Float.floatToIntBits(this.f454146e)) * 31) + Float.floatToIntBits(this.f454147f)) * 31;
        boolean r113 = this.f454148g;
        ?? r114 = 1;
        ?? r115 = r113;
        if (r113 == false) goto L21;
        r115 = 1;
    L21:
        int r116 = (((((r112 + r115) * 31) + this.f454149h) * 31) + this.f454150i) * 31;
        String r117 = this.f454151j;
        if (r117 == null) goto L24;
        int r118 = r117.hashCode();
    L25:
        int r119 = (r116 + r118) * 31;
        String r120 = this.f454152k;
        if (r120 == null) goto L28;
        int r121 = r120.hashCode();
    L29:
        int r122 = (r119 + r121) * 31;
        List<EmbaddedWindowInfo> r123 = this.f454153l;
        if (r123 == null) goto L32;
        int r124 = r123.hashCode();
    L33:
        int r125 = (r122 + r124) * 31;
        boolean r126 = this.f454154m;
        ?? r127 = r126;
        if (r126 == false) goto L36;
        r127 = 1;
    L36:
        int r128 = (((r125 + r127) * 31) + this.f454155n) * 31;
        String r129 = this.f454156o;
        if (r129 == null) goto L39;
        int r130 = r129.hashCode();
    L40:
        int r131 = (((r128 + r130) * 31) + this.f454157p) * 31;
        Effect r132 = this.f454158q;
        if (r132 == null) goto L43;
        int r133 = r132.hashCode();
    L44:
        int r134 = (r131 + r133) * 31;
        String r135 = this.f454159r;
        if (r135 == null) goto L47;
        int r136 = r135.hashCode();
    L48:
        int r137 = (r134 + r136) * 31;
        boolean r138 = this.f454160s;
        ?? r139 = r138;
        if (r138 == false) goto L51;
        r139 = 1;
    L51:
        int r140 = (r137 + r139) * 31;
        boolean r141 = this.f454161t;
        if (r141 == true) goto L55;
        r114 = r141;
    L55:
        int r142 = (((r140 + r114) * 31) + this.f454162u) * 31;
        String r143 = this.f454163v;
        if (r143 == null) goto L58;
        int r144 = r143.hashCode();
    L59:
        int r145 = (r142 + r144) * 31;
        Integer r146 = this.f454164w;
        if (r146 == null) goto L63;
        r101 = r146.hashCode();
    L63:
        return r145 + r101;
    L58:
        r144 = 0;
        goto L59
    L47:
        r136 = 0;
        goto L48
    L43:
        r133 = 0;
        goto L44
    L39:
        r130 = 0;
        goto L40
    L32:
        r124 = 0;
        goto L33
    L28:
        r121 = 0;
        goto L29
    L24:
        r118 = 0;
        goto L25
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "DuetContext(duetFromChallengeName=" + this.f454142a + ", duetFromAwemeId=" + this.f454143b + ", duetVideoPath=" + this.f454144c + ", duetAudioPath=" + this.f454145d + ", veSuggestHumanVolume=" + this.f454146e + ", veSuggestVideoVolume=" + this.f454147f + ", successEnableAEC=" + this.f454148g + ", duetVideoWidth=" + this.f454149h + ", duetVideoHeight=" + this.f454150i + ", duetLayout=" + this.f454151j + ", duetLayoutInfoJson=" + this.f454152k + ", windowInfoList=" + this.f454153l + ", micDefaultState=" + this.f454154m + ", isFromDuetSticker=" + this.f454155n + ", duetLayoutMode=" + this.f454156o + ", layoutDirection=" + this.f454157p + ", defaultDuetLayout=" + this.f454158q + ", duetOriginId=" + this.f454159r + ", isDuetSing=" + this.f454160s + ", isDuetUpload=" + this.f454161t + ", duetUploadType=" + this.f454162u + ", chorusMethod=" + this.f454163v + ", duetGroupDuration=" + this.f454164w + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeString(this.f454142a);
        r100.writeString(this.f454143b);
        r100.writeString(this.f454144c);
        r100.writeString(this.f454145d);
        r100.writeFloat(this.f454146e);
        r100.writeFloat(this.f454147f);
        r100.writeInt(this.f454148g ? 1 : 0);
        r100.writeInt(this.f454149h);
        r100.writeInt(this.f454150i);
        r100.writeString(this.f454151j);
        r100.writeString(this.f454152k);
        List<EmbaddedWindowInfo> r102 = this.f454153l;
        r100.writeInt(r102.size());
        Iterator<EmbaddedWindowInfo> r103 = r102.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r100.writeParcelable(r103.next(), r101);
        goto L4
    L6:
        r100.writeInt(this.f454154m ? 1 : 0);
        r100.writeInt(this.f454155n);
        r100.writeString(this.f454156o);
        r100.writeInt(this.f454157p);
        r100.writeParcelable(this.f454158q, r101);
        r100.writeString(this.f454159r);
        r100.writeInt(this.f454160s ? 1 : 0);
        r100.writeInt(this.f454161t ? 1 : 0);
        r100.writeInt(this.f454162u);
        r100.writeString(this.f454163v);
        Integer r104 = this.f454164w;
        if (r104 == null) goto L9;
        r100.writeInt(1);
        int r105 = r104.intValue();
    L10:
        r100.writeInt(r105);
        return;
    L9:
        r105 = 0;
        goto L10
    }

    static {
        new Companion(0);
        CREATOR = new Creator();
    }

    public DuetContext(String r100, String r101, String r102, String r103, float r104, float r110, boolean r111, int r112, int r113, String r114, String r115, List<EmbaddedWindowInfo> r116, boolean r117, int r118, String r119, int r210, Effect r211, String r212, boolean r213, boolean r214, int r215, String r216, Integer r217) {
        Intrinsics.checkNotNullParameter(r116, "windowInfoList");
        Intrinsics.checkNotNullParameter(r119, "duetLayoutMode");
        this.f454142a = r100;
        this.f454143b = r101;
        this.f454144c = r102;
        this.f454145d = r103;
        this.f454146e = r104;
        this.f454147f = r110;
        this.f454148g = r111;
        this.f454149h = r112;
        this.f454150i = r113;
        this.f454151j = r114;
        this.f454152k = r115;
        this.f454153l = r116;
        this.f454154m = r117;
        this.f454155n = r118;
        this.f454156o = r119;
        this.f454157p = r210;
        this.f454158q = r211;
        this.f454159r = r212;
        this.f454160s = r213;
        this.f454161t = r214;
        this.f454162u = r215;
        this.f454163v = r216;
        this.f454164w = r217;
    }
}
