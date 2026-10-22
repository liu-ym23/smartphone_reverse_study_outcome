package com.bytedance.ee.android.file.picker.lib;

import android.os.Parcel;
import android.os.Parcelable;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0002\b)\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B¥\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u000f\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u0012\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0014\u0010\u0015J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0006HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010-\u001a\u00020\bHÆ\u0003J\t\u0010.\u001a\u00020\bHÆ\u0003J\t\u0010/\u001a\u00020\rHÆ\u0003J\u000f\u00100\u001a\b\u0012\u0004\u0012\u00020\b0\u000fHÆ\u0003J\u0011\u00101\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000fHÆ\u0003J\t\u00102\u001a\u00020\rHÆ\u0003J\u0011\u00103\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000fHÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\bHÆ\u0003J§\u0001\u00105\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\r2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u000f2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\r2\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000f2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0006\u00106\u001a\u00020\u0006J\u0013\u00107\u001a\u00020\r2\b\u00108\u001a\u0004\u0018\u000109HÖ\u0003J\t\u0010:\u001a\u00020\u0006HÖ\u0001J\t\u0010;\u001a\u00020\bHÖ\u0001J\u0016\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001cR\u0011\u0010\u000b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001cR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u000f¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0019\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b$\u0010#R\u0011\u0010\u0011\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b%\u0010!R\u0019\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b&\u0010#R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001c¨\u0006A"}, d2 = {"Lcom/bytedance/ee/android/file/picker/lib/FilePickerParams;", "Landroid/os/Parcelable;", "maxSelectFileSize", "", "maxSingleSelectFileSize", "maxSelectFileCount", "", "overSelectFileSizeTips", "", "overSelectSingleFileSizeTips", "customTitle", "customSendBtnText", "showSystemPicker", "", "dataSourceSet", "", "supportedFileExtensions", "directlyOpenSystemFileChooser", "systemPickerMimeTypes", "customSendBtnTextWhenEmpty", "<init>", "(JJILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/Set;Ljava/util/Set;ZLjava/util/Set;Ljava/lang/String;)V", "getMaxSelectFileSize", "()J", "getMaxSingleSelectFileSize", "getMaxSelectFileCount", "()I", "getOverSelectFileSizeTips", "()Ljava/lang/String;", "getOverSelectSingleFileSizeTips", "getCustomTitle", "getCustomSendBtnText", "getShowSystemPicker", "()Z", "getDataSourceSet", "()Ljava/util/Set;", "getSupportedFileExtensions", "getDirectlyOpenSystemFileChooser", "getSystemPickerMimeTypes", "getCustomSendBtnTextWhenEmpty", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "file-picker-lib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FilePickerParams implements Parcelable {
    public static final Parcelable.Creator<FilePickerParams> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f205956a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f205957b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f205958c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f205959d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f205960e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f205961f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f205962g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f205963h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Set<String> f205964i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Set<String> f205965j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f205966k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Set<String> f205967l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f205968m;

    public static final class a implements Parcelable.Creator<FilePickerParams> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final FilePickerParams createFromParcel(Parcel r210) {
            Intrinsics.checkNotNullParameter(r210, "parcel");
            long r100 = r210.readLong();
            long r101 = r210.readLong();
            int r102 = r210.readInt();
            String r103 = r210.readString();
            String r104 = r210.readString();
            String r105 = r210.readString();
            String r110 = r210.readString();
            if (r210.readInt() == 0) goto L5;
            boolean r106 = true;
        L6:
            int r111 = r210.readInt();
            LinkedHashSet r112 = new LinkedHashSet(r111);
            int r113 = 0;
        L7:
            if (r113 == r111) goto L10;
            r112.add(r210.readString());
            r113 = r113 + 1;
            goto L7
        L10:
            if (r210.readInt() != 0) goto L12;
            LinkedHashSet r114 = null;
        L17:
            if (r210.readInt() == 0) goto L19;
            boolean r115 = true;
        L21:
            if (r210.readInt() != 0) goto L23;
            LinkedHashSet r116 = null;
        L27:
            boolean r117 = r106;
            boolean r118 = r115;
            return new FilePickerParams(r100, r101, r102, r103, r104, r105, r110, r117, r112, r114, r118, r116, r210.readString());
        L23:
            int r119 = r210.readInt();
            LinkedHashSet r120 = new LinkedHashSet(r119);
            int r121 = 0;
        L24:
            if (r121 == r119) goto L26;
            r120.add(r210.readString());
            r121 = r121 + 1;
            goto L24
        L26:
            r116 = r120;
            goto L27
        L19:
            r115 = false;
            goto L21
        L12:
            int r122 = r210.readInt();
            LinkedHashSet r123 = new LinkedHashSet(r122);
            int r124 = 0;
        L13:
            if (r124 == r122) goto L15;
            r123.add(r210.readString());
            r124 = r124 + 1;
            goto L13
        L15:
            r114 = r123;
            goto L17
        L5:
            r106 = false;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final FilePickerParams[] newArray(int r100) {
            return new FilePickerParams[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public FilePickerParams() {
        this(0, 0, 0, null, null, null, null, false, null, 8191);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FilePickerParams) == true) goto L8;
        return false;
    L8:
        FilePickerParams r101 = (FilePickerParams) r100;
        if (this.f205956a == r101.f205956a) goto L12;
        return false;
    L12:
        if (this.f205957b == r101.f205957b) goto L15;
        return false;
    L15:
        if (this.f205958c == r101.f205958c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f205959d, r101.f205959d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f205960e, r101.f205960e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f205961f, r101.f205961f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f205962g, r101.f205962g) == true) goto L30;
        return false;
    L30:
        if (this.f205963h == r101.f205963h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f205964i, r101.f205964i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f205965j, r101.f205965j) == true) goto L39;
        return false;
    L39:
        if (this.f205966k == r101.f205966k) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f205967l, r101.f205967l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f205968m, r101.f205968m) == true) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f205956a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f205957b;
        int r103 = (((r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31) + this.f205958c) * 31;
        String r104 = this.f205959d;
        int r105 = 0;
        if (r104 != null) goto L5;
        int r106 = 0;
    L6:
        int r107 = (r103 + r106) * 31;
        String r108 = this.f205960e;
        if (r108 != null) goto L9;
        int r109 = 0;
    L10:
        int r110 = (((((r107 + r109) * 31) + this.f205961f.hashCode()) * 31) + this.f205962g.hashCode()) * 31;
        int r111 = 1231;
        if (this.f205963h == false) goto L13;
        int r112 = 1231;
    L14:
        int r113 = (((r110 + r112) * 31) + this.f205964i.hashCode()) * 31;
        Set<String> r114 = this.f205965j;
        if (r114 != null) goto L17;
        int r115 = 0;
    L18:
        int r116 = (r113 + r115) * 31;
        if (this.f205966k == true) goto L22;
        r111 = 1237;
    L22:
        int r117 = (r116 + r111) * 31;
        Set<String> r118 = this.f205967l;
        if (r118 != null) goto L25;
        int r119 = 0;
    L26:
        int r120 = (r117 + r119) * 31;
        String r121 = this.f205968m;
        if (r121 == null) goto L31;
        r105 = r121.hashCode();
    L31:
        return r120 + r105;
    L25:
        r119 = r118.hashCode();
        goto L26
    L17:
        r115 = r114.hashCode();
        goto L18
    L13:
        r112 = 1237;
        goto L14
    L9:
        r109 = r108.hashCode();
        goto L10
    L5:
        r106 = r104.hashCode();
        goto L6
    }

    public final String toString() {
        return "FilePickerParams(maxSelectFileSize=" + this.f205956a + ", maxSingleSelectFileSize=" + this.f205957b + ", maxSelectFileCount=" + this.f205958c + ", overSelectFileSizeTips=" + this.f205959d + ", overSelectSingleFileSizeTips=" + this.f205960e + ", customTitle=" + this.f205961f + ", customSendBtnText=" + this.f205962g + ", showSystemPicker=" + this.f205963h + ", dataSourceSet=" + this.f205964i + ", supportedFileExtensions=" + this.f205965j + ", directlyOpenSystemFileChooser=" + this.f205966k + ", systemPickerMimeTypes=" + this.f205967l + ", customSendBtnTextWhenEmpty=" + this.f205968m + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeLong(this.f205956a);
        r100.writeLong(this.f205957b);
        r100.writeInt(this.f205958c);
        r100.writeString(this.f205959d);
        r100.writeString(this.f205960e);
        r100.writeString(this.f205961f);
        r100.writeString(this.f205962g);
        r100.writeInt(this.f205963h ? 1 : 0);
        Set<String> r102 = this.f205964i;
        r100.writeInt(r102.size());
        Iterator<String> r103 = r102.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r100.writeString(r103.next());
        goto L4
    L6:
        Set<String> r104 = this.f205965j;
        if (r104 != null) goto L9;
        r100.writeInt(0);
    L13:
        r100.writeInt(this.f205966k ? 1 : 0);
        Set<String> r105 = this.f205967l;
        if (r105 != null) goto L16;
        r100.writeInt(0);
    L20:
        r100.writeString(this.f205968m);
        return;
    L16:
        r100.writeInt(1);
        r100.writeInt(r105.size());
        Iterator<String> r106 = r105.iterator();
    L18:
        if (r106.hasNext() == false) goto L20;
        r100.writeString(r106.next());
        goto L18
    L9:
        r100.writeInt(1);
        r100.writeInt(r104.size());
        Iterator<String> r107 = r104.iterator();
    L11:
        if (r107.hasNext() == false) goto L13;
        r100.writeString(r107.next());
        goto L11
    }

    public FilePickerParams(long r210, long r211, int r212, String r213, String r214, String r215, String r216, boolean r310, Set r311, int r312) {
        if ((r312 & 1) == 0) goto L5;
        long r100 = Long.MAX_VALUE;
    L7:
        if ((r312 & 2) == 0) goto L9;
        long r101 = Long.MAX_VALUE;
    L11:
        if ((r312 & 4) == 0) goto L13;
        int r102 = Integer.MAX_VALUE;
    L15:
        if ((r312 & 8) == 0) goto L17;
        String r110 = null;
    L19:
        if ((r312 & 16) == 0) goto L21;
        String r111 = null;
    L23:
        if ((r312 & 32) == 0) goto L25;
        String r112 = UIHelper.mustacheFormat(R.string.Lark_Message_File_defTitle);
    L27:
        if ((r312 & 64) == 0) goto L29;
        String r113 = UIHelper.getString(R.string.Lark_Legacy_Send);
    L31:
        if ((r312 & 128) == 0) goto L33;
        boolean r114 = false;
    L35:
        if ((r312 & 256) == 0) goto L37;
        Set r115 = SetsKt.setOf(new String[]{"picker_video", "picker_doc", "picker_received"});
    L38:
        this(r100, r101, r102, r110, r111, r112, r113, r114, r115, null, false, null, null);
        return;
    L37:
        r115 = r311;
        goto L38
    L33:
        r114 = r310;
        goto L35
    L29:
        r113 = r216;
        goto L31
    L25:
        r112 = r215;
        goto L27
    L21:
        r111 = r214;
        goto L23
    L17:
        r110 = r213;
        goto L19
    L13:
        r102 = r212;
        goto L15
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }

    public FilePickerParams(long r100, long r101, int r110, String r111, String r112, String r113, String r114, boolean r115, Set<String> r116, Set<String> r117, boolean r118, Set<String> r210, String r211) {
        Intrinsics.checkNotNullParameter(r113, "customTitle");
        Intrinsics.checkNotNullParameter(r114, "customSendBtnText");
        Intrinsics.checkNotNullParameter(r116, "dataSourceSet");
        this.f205956a = r100;
        this.f205957b = r101;
        this.f205958c = r110;
        this.f205959d = r111;
        this.f205960e = r112;
        this.f205961f = r113;
        this.f205962g = r114;
        this.f205963h = r115;
        this.f205964i = r116;
        this.f205965j = r117;
        this.f205966k = r118;
        this.f205967l = r210;
        this.f205968m = r211;
    }
}
