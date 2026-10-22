package com.larus.drive.sdk.api.file;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.android.livesdkapi.depend.model.live.RoomIntroLabel;
import com.larus.drive.biz.api.model.DriveFileType;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 G2\u00020\u0001:\u0001GBm\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010#\u001a\u00020\u00032\b\b\u0002\u0010$\u001a\u00020%J\u0006\u0010&\u001a\u00020\u0003J\u0006\u0010'\u001a\u00020%J\u0006\u0010(\u001a\u00020%J\u0006\u0010)\u001a\u00020%J\n\u0010,\u001a\u0004\u0018\u00010+H\u0002J\u0006\u0010-\u001a\u00020\nJ\u0006\u0010.\u001a\u00020%J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0007HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\nHÆ\u0003J\t\u00105\u001a\u00020\nHÆ\u0003J\t\u00106\u001a\u00020\u0007HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u000fHÆ\u0003J\t\u00109\u001a\u00020\u0007HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0083\u0001\u0010;\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00072\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0006\u0010<\u001a\u00020\u0007J\u0013\u0010=\u001a\u00020%2\b\u0010>\u001a\u0004\u0018\u00010?HÖ\u0003J\t\u0010@\u001a\u00020\u0007HÖ\u0001J\t\u0010A\u001a\u00020\u0003HÖ\u0001J\u0016\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0011\u0010\f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0019R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0015R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0010\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0019R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0015R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006H"}, d2 = {"Lcom/larus/drive/sdk/api/file/DriveFileItem;", "Landroid/os/Parcelable;", "fileName", "", "fileToken", "driveToken", "driveObjType", "", "fileURL", "openTime", "", "editTime", "iconResId", "iconInfo", "fileType", "Lcom/larus/drive/biz/api/model/DriveFileType;", "isOwner", "extra", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;JJILjava/lang/String;Lcom/larus/drive/biz/api/model/DriveFileType;ILjava/lang/String;)V", "getFileName", "()Ljava/lang/String;", "getFileToken", "getDriveToken", "getDriveObjType", "()I", "getFileURL", "getOpenTime", "()J", "getEditTime", "getIconResId", "getIconInfo", "getFileType", "()Lcom/larus/drive/biz/api/model/DriveFileType;", "getExtra", "getPostfix", "includeDot", "", "getNameWithoutPostfix", "isFileOwner", "isAIArtifact", "shouldImgLoadCover", "extraJson", "Lorg/json/JSONObject;", "getExtraJson", "getSize", "getImgAuditReject", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveFileItem implements Parcelable {
    public static final Parcelable.Creator<DriveFileItem> CREATOR = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Set<String> f341563n = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f341564a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f341565b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f341566c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f341567d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f341568e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f341569f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f341570g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f341571h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f341572i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final DriveFileType f341573j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f341574k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f341575l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public JSONObject f341576m;

    public static final class a {
    }

    public static final class b implements Parcelable.Creator<DriveFileItem> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final DriveFileItem createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "parcel");
            return new DriveFileItem(r110.readString(), r110.readString(), r110.readString(), r110.readInt(), r110.readString(), r110.readLong(), r110.readLong(), r110.readInt(), r110.readString(), DriveFileType.valueOf(r110.readString()), r110.readInt(), r110.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final DriveFileItem[] newArray(int r100) {
            return new DriveFileItem[r100];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DriveFileItem) == true) goto L8;
        return false;
    L8:
        DriveFileItem r101 = (DriveFileItem) r100;
        if (Intrinsics.areEqual(this.f341564a, r101.f341564a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f341565b, r101.f341565b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f341566c, r101.f341566c) == true) goto L18;
        return false;
    L18:
        if (this.f341567d == r101.f341567d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f341568e, r101.f341568e) == true) goto L24;
        return false;
    L24:
        if (this.f341569f == r101.f341569f) goto L27;
        return false;
    L27:
        if (this.f341570g == r101.f341570g) goto L30;
        return false;
    L30:
        if (this.f341571h == r101.f341571h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f341572i, r101.f341572i) == true) goto L36;
        return false;
    L36:
        if (this.f341573j == r101.f341573j) goto L39;
        return false;
    L39:
        if (this.f341574k == r101.f341574k) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f341575l, r101.f341575l) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((this.f341564a.hashCode() * 31) + this.f341565b.hashCode()) * 31) + this.f341566c.hashCode()) * 31) + this.f341567d) * 31) + this.f341568e.hashCode()) * 31;
        long r101 = this.f341569f;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.f341570g;
        int r104 = (((((((((r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31) + this.f341571h) * 31) + this.f341572i.hashCode()) * 31) + this.f341573j.hashCode()) * 31) + this.f341574k) * 31;
        String r105 = this.f341575l;
        if (r105 != null) goto L5;
        int r106 = 0;
    L7:
        return r104 + r106;
    L5:
        r106 = r105.hashCode();
        goto L7
    }

    public final String toString() {
        return "DriveFileItem(fileName=" + this.f341564a + ", fileToken=" + this.f341565b + ", driveToken=" + this.f341566c + ", driveObjType=" + this.f341567d + ", fileURL=" + this.f341568e + ", openTime=" + this.f341569f + ", editTime=" + this.f341570g + ", iconResId=" + this.f341571h + ", iconInfo=" + this.f341572i + ", fileType=" + this.f341573j + ", isOwner=" + this.f341574k + ", extra=" + this.f341575l + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.f341564a);
        r100.writeString(this.f341565b);
        r100.writeString(this.f341566c);
        r100.writeInt(this.f341567d);
        r100.writeString(this.f341568e);
        r100.writeLong(this.f341569f);
        r100.writeLong(this.f341570g);
        r100.writeInt(this.f341571h);
        r100.writeString(this.f341572i);
        r100.writeString(this.f341573j.name());
        r100.writeInt(this.f341574k);
        r100.writeString(this.f341575l);
    }

    static {
        CREATOR = new b();
        f341563n = SetsKt.setOf(new String[]{RoomIntroLabel.ICON_URL_SUFFIX_DEFAULT, ".jpeg", ".jpg", EffectConstants.GIF_FILE_SUFFIX, ".bmp", ".jfif", ".exif", ".tiff", ".bpg", ".webp", ".heic", ".heif"});
    }

    public final boolean b() {
        JSONObject r100 = this.f341576m;
        if (r100 != null) goto L12;
        String r101 = this.f341575l;     // Catch: JSONException -> L10
        if (r101 != null) goto L8;
        r101 = SliceInitService.DEFAULT_SWITCH;
    L8:
        r100 = new JSONObject(r101);     // Catch: JSONException -> L10
        this.f341576m = r100;     // Catch: JSONException -> L10
    L10:
        r100 = null;
    L12:
        if (r100 != null) goto L15;
        return false;
    L15:
        if (this.f341573j == DriveFileType.IMAGE) goto L17;
        return false;
    L17:
        if (r100.optInt("doubao_ai_skill_status", 1) != 20003) goto L23;
        return true;
    L23:
        return false;
    }

    public final String c() {
        int r100 = StringsKt.lastIndexOf$default(this.f341564a, '.', 0, false, 6, null);
        if (r100 <= 0) goto L8;
        if (r100 >= (this.f341564a.length() - 1)) goto L8;
        return this.f341564a.substring(0, r100);
    L8:
        return this.f341564a;
    }

    public final long e() {
        JSONObject r100 = this.f341576m;
        if (r100 == null) goto L15;
    L11:
        if (r100 != null) goto L17;
        return 0;
    L17:
        return r100.optLong("size");
    L15:
        String r101 = this.f341575l;     // Catch: JSONException -> L10
        if (r101 != null) goto L8;
        r101 = SliceInitService.DEFAULT_SWITCH;
    L8:
        r100 = new JSONObject(r101);     // Catch: JSONException -> L10
        this.f341576m = r100;     // Catch: JSONException -> L10
    L10:
        r100 = null;
        goto L11
    }

    public final boolean g() {
        if (this.f341574k == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean h() {
        return f341563n.contains(d(true).toLowerCase(Locale.ROOT));
    }

    public final String d(boolean r100) {
        int r101 = StringsKt.lastIndexOf$default(this.f341564a, '.', 0, false, 6, null);
        if (r101 > 0) goto L5;
    L9:
        return "";
    L5:
        if (r101 >= (this.f341564a.length() - 1)) goto L9;
        if (r100 == false) goto L12;
        return this.f341564a.substring(r101);
    L12:
        return this.f341564a.substring(r101 + 1);
    }

    public static DriveFileItem a(DriveFileItem r110, String r210, String r211, String r212, int r213) {
        if ((r213 & 1) == 0) goto L5;
        String r100 = r110.f341564a;
    L6:
        DriveFileType r101 = null;
        if ((r213 & 2) == 0) goto L9;
        String r102 = r110.f341565b;
    L11:
        if ((r213 & 4) == 0) goto L13;
        String r103 = r110.f341566c;
    L15:
        if ((r213 & 8) == 0) goto L17;
        int r104 = r110.f341567d;
    L19:
        if ((r213 & 16) == 0) goto L21;
        String r105 = r110.f341568e;
    L23:
        if ((r213 & 32) == 0) goto L25;
        long r111 = r110.f341569f;
    L27:
        if ((r213 & 64) == 0) goto L29;
        long r112 = r110.f341570g;
    L31:
        if ((r213 & 128) == 0) goto L33;
        int r113 = r110.f341571h;
    L35:
        if ((r213 & 256) == 0) goto L37;
        String r114 = r110.f341572i;
    L39:
        if ((r213 & 512) == 0) goto L41;
        r101 = r110.f341573j;
    L41:
        DriveFileType r106 = r101;
        if ((r213 & 1024) == 0) goto L44;
        int r115 = r110.f341574k;
    L46:
        if ((r213 & 2048) == 0) goto L48;
        String r107 = r110.f341575l;
    L49:
        r110.getClass();
        Intrinsics.checkNotNullParameter(r100, "fileName");
        Intrinsics.checkNotNullParameter(r102, "fileToken");
        Intrinsics.checkNotNullParameter(r103, "driveToken");
        Intrinsics.checkNotNullParameter(r105, "fileURL");
        Intrinsics.checkNotNullParameter(r114, "iconInfo");
        Intrinsics.checkNotNullParameter(r106, "fileType");
        return new DriveFileItem(r100, r102, r103, r104, r105, r111, r112, r113, r114, r106, r115, r107);
    L48:
        r107 = r212;
        goto L49
    L44:
        r115 = 0;
        goto L46
    L37:
        r114 = null;
        goto L39
    L33:
        r113 = 0;
        goto L35
    L29:
        r112 = 0;
        goto L31
    L25:
        r111 = 0;
        goto L27
    L21:
        r105 = r211;
        goto L23
    L17:
        r104 = 0;
        goto L19
    L13:
        r103 = null;
        goto L15
    L9:
        r102 = null;
        goto L11
    L5:
        r100 = r210;
        goto L6
    }

    public DriveFileItem(String r100, String r101, String r102, int r103, String r104, long r105, long r106, int r110, String r111, DriveFileType r112, int r113, String r114) {
        Intrinsics.checkNotNullParameter(r100, "fileName");
        Intrinsics.checkNotNullParameter(r101, "fileToken");
        Intrinsics.checkNotNullParameter(r102, "driveToken");
        Intrinsics.checkNotNullParameter(r104, "fileURL");
        Intrinsics.checkNotNullParameter(r111, "iconInfo");
        Intrinsics.checkNotNullParameter(r112, "fileType");
        this.f341564a = r100;
        this.f341565b = r101;
        this.f341566c = r102;
        this.f341567d = r103;
        this.f341568e = r104;
        this.f341569f = r105;
        this.f341570g = r106;
        this.f341571h = r110;
        this.f341572i = r111;
        this.f341573j = r112;
        this.f341574k = r113;
        this.f341575l = r114;
    }
}
