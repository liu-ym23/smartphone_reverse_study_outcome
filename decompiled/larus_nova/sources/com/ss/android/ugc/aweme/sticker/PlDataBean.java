package com.ss.android.ugc.aweme.sticker;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b/\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002Bð\u0001\u0012\"\b\u0002\u0010\u0003\u001a\u001c\u0012\u0004\u0012\u00020\u00050\u0004j\r\u0012\u0004\u0012\u00020\u0005`\u0006¢\u0006\u0002\b\u0007¢\u0006\u0002\b\u0007\u0012\u000f\b\u0002\u0010\b\u001a\t\u0018\u00010\u0005¢\u0006\u0002\b\u0007\u0012\u000f\b\u0002\u0010\t\u001a\t\u0018\u00010\u0005¢\u0006\u0002\b\u0007\u0012\r\b\u0002\u0010\n\u001a\u00070\u000b¢\u0006\u0002\b\u0007\u0012\r\b\u0002\u0010\f\u001a\u00070\u000b¢\u0006\u0002\b\u0007\u0012\r\b\u0002\u0010\r\u001a\u00070\u000e¢\u0006\u0002\b\u0007\u0012\r\b\u0002\u0010\u000f\u001a\u00070\u000e¢\u0006\u0002\b\u0007\u0012\r\b\u0002\u0010\u0010\u001a\u00070\u000e¢\u0006\u0002\b\u0007\u0012\r\b\u0002\u0010\u0011\u001a\u00070\u000e¢\u0006\u0002\b\u0007\u0012\r\b\u0002\u0010\u0012\u001a\u00070\u000e¢\u0006\u0002\b\u0007\u0012\r\b\u0002\u0010\u0013\u001a\u00070\u000e¢\u0006\u0002\b\u0007\u0012\r\b\u0002\u0010\u0014\u001a\u00070\u000e¢\u0006\u0002\b\u0007\u0012\r\b\u0002\u0010\u0015\u001a\u00070\u000e¢\u0006\u0002\b\u0007\u0012\r\b\u0002\u0010\u0016\u001a\u00070\u000e¢\u0006\u0002\b\u0007¢\u0006\u0002\u0010\u0017J\t\u0010<\u001a\u00020\u000eHÖ\u0001J\u0019\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020\u000eHÖ\u0001R#\u0010\r\u001a\u00070\u000e¢\u0006\u0002\b\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR8\u0010\u0003\u001a\u001c\u0012\u0004\u0012\u00020\u00050\u0004j\r\u0012\u0004\u0012\u00020\u0005`\u0006¢\u0006\u0002\b\u0007¢\u0006\u0002\b\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR#\u0010\u0013\u001a\u00070\u000e¢\u0006\u0002\b\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0019\"\u0004\b!\u0010\u001bR#\u0010\u0014\u001a\u00070\u000e¢\u0006\u0002\b\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0019\"\u0004\b#\u0010\u001bR#\u0010\u0010\u001a\u00070\u000e¢\u0006\u0002\b\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0019\"\u0004\b%\u0010\u001bR#\u0010\u000f\u001a\u00070\u000e¢\u0006\u0002\b\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0019\"\u0004\b'\u0010\u001bR#\u0010\f\u001a\u00070\u000b¢\u0006\u0002\b\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R%\u0010\t\u001a\t\u0018\u00010\u0005¢\u0006\u0002\b\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R#\u0010\n\u001a\u00070\u000b¢\u0006\u0002\b\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010)\"\u0004\b1\u0010+R#\u0010\u0012\u001a\u00070\u000e¢\u0006\u0002\b\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0019\"\u0004\b3\u0010\u001bR#\u0010\u0011\u001a\u00070\u000e¢\u0006\u0002\b\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0019\"\u0004\b5\u0010\u001bR#\u0010\u0015\u001a\u00070\u000e¢\u0006\u0002\b\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u0019\"\u0004\b7\u0010\u001bR#\u0010\u0016\u001a\u00070\u000e¢\u0006\u0002\b\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0019\"\u0004\b9\u0010\u001bR%\u0010\b\u001a\t\u0018\u00010\u0005¢\u0006\u0002\b\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010-\"\u0004\b;\u0010/¨\u0006B"}, d2 = {"Lcom/ss/android/ugc/aweme/sticker/PlDataBean;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "alg", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "Lkotlinx/android/parcel/RawValue;", "relation", "imgK", "loading", "", "guide", "albumFilter", "", "faceCountMin", "faceCountMax", "minCount", "maxCount", "defaultHeight", "defaultWidth", "minFilterHeight", "minFilterWidth", "(Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;ZZIIIIIIIII)V", "getAlbumFilter", "()I", "setAlbumFilter", "(I)V", "getAlg", "()Ljava/util/ArrayList;", "setAlg", "(Ljava/util/ArrayList;)V", "getDefaultHeight", "setDefaultHeight", "getDefaultWidth", "setDefaultWidth", "getFaceCountMax", "setFaceCountMax", "getFaceCountMin", "setFaceCountMin", "getGuide", "()Z", "setGuide", "(Z)V", "getImgK", "()Ljava/lang/String;", "setImgK", "(Ljava/lang/String;)V", "getLoading", "setLoading", "getMaxCount", "setMaxCount", "getMinCount", "setMinCount", "getMinFilterHeight", "setMinFilterHeight", "getMinFilterWidth", "setMinFilterWidth", "getRelation", "setRelation", "describeContents", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "lib-api_release"}, k = 1, mv = {1, 4, 1})
public final class PlDataBean implements Parcelable, Serializable {
    public static final Parcelable.Creator<PlDataBean> CREATOR = null;

    @SerializedName("albumFilter")
    private int albumFilter;

    @SerializedName("alg")
    private ArrayList<String> alg;

    @SerializedName("defaultHeight")
    private int defaultHeight;

    @SerializedName("defaultWidth")
    private int defaultWidth;

    @SerializedName("face_count_max")
    private int faceCountMax;

    @SerializedName("face_count_min")
    private int faceCountMin;

    @SerializedName("guide")
    private boolean guide;

    @SerializedName("imgK")
    private String imgK;

    @SerializedName("loading")
    private boolean loading;

    @SerializedName(DownloadSettingKeys.RetryScheduleConfig.MAX_COUNT)
    private int maxCount;

    @SerializedName("min_count")
    private int minCount;

    @SerializedName("minFilterHeight")
    private int minFilterHeight;

    @SerializedName("minFilterWidth")
    private int minFilterWidth;

    @SerializedName("relation")
    private String relation;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    public static class Creator implements Parcelable.Creator<PlDataBean> {
        public Creator() {
        }

        @Override // android.os.Parcelable.Creator
        public final PlDataBean createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "in");
            int r100 = r110.readInt();
            ArrayList r101 = new ArrayList(r100);
        L3:
            String r102 = r110.readString();
            if (r100 == 0) goto L6;
            r101.add(r102);
            r100 = r100 - 1;
            goto L3
        L6:
            String r103 = r110.readString();
            boolean r104 = false;
            if (r110.readInt() == 0) goto L9;
            boolean r105 = true;
        L11:
            if (r110.readInt() == 0) goto L14;
            r104 = true;
        L14:
            return new PlDataBean(r101, r102, r103, r105, r104, r110.readInt(), r110.readInt(), r110.readInt(), r110.readInt(), r110.readInt(), r110.readInt(), r110.readInt(), r110.readInt(), r110.readInt());
        L9:
            r105 = false;
            goto L11
        }

        @Override // android.os.Parcelable.Creator
        public final PlDataBean[] newArray(int r100) {
            return new PlDataBean[r100];
        }
    }

    static {
        CREATOR = new Creator();
    }

    public PlDataBean() {
        this(null, null, null, false, false, 0, 0, 0, 0, 0, 0, 0, 0, 0, 16383, null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        ArrayList<String> r102 = this.alg;
        r100.writeInt(r102.size());
        Iterator<String> r103 = r102.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r100.writeString(r103.next());
        goto L4
    L6:
        r100.writeString(this.relation);
        r100.writeString(this.imgK);
        r100.writeInt(this.loading ? 1 : 0);
        r100.writeInt(this.guide ? 1 : 0);
        r100.writeInt(this.albumFilter);
        r100.writeInt(this.faceCountMin);
        r100.writeInt(this.faceCountMax);
        r100.writeInt(this.minCount);
        r100.writeInt(this.maxCount);
        r100.writeInt(this.defaultHeight);
        r100.writeInt(this.defaultWidth);
        r100.writeInt(this.minFilterHeight);
        r100.writeInt(this.minFilterWidth);
    }

    public final int getAlbumFilter() {
        return this.albumFilter;
    }

    public final ArrayList<String> getAlg() {
        return this.alg;
    }

    public final int getDefaultHeight() {
        return this.defaultHeight;
    }

    public final int getDefaultWidth() {
        return this.defaultWidth;
    }

    public final int getFaceCountMax() {
        return this.faceCountMax;
    }

    public final int getFaceCountMin() {
        return this.faceCountMin;
    }

    public final boolean getGuide() {
        return this.guide;
    }

    public final String getImgK() {
        return this.imgK;
    }

    public final boolean getLoading() {
        return this.loading;
    }

    public final int getMaxCount() {
        return this.maxCount;
    }

    public final int getMinCount() {
        return this.minCount;
    }

    public final int getMinFilterHeight() {
        return this.minFilterHeight;
    }

    public final int getMinFilterWidth() {
        return this.minFilterWidth;
    }

    public final String getRelation() {
        return this.relation;
    }

    public final void setAlbumFilter(int r100) {
        this.albumFilter = r100;
    }

    public final void setAlg(ArrayList<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.alg = r100;
    }

    public final void setDefaultHeight(int r100) {
        this.defaultHeight = r100;
    }

    public final void setDefaultWidth(int r100) {
        this.defaultWidth = r100;
    }

    public final void setFaceCountMax(int r100) {
        this.faceCountMax = r100;
    }

    public final void setFaceCountMin(int r100) {
        this.faceCountMin = r100;
    }

    public final void setGuide(boolean r100) {
        this.guide = r100;
    }

    public final void setImgK(String r100) {
        this.imgK = r100;
    }

    public final void setLoading(boolean r100) {
        this.loading = r100;
    }

    public final void setMaxCount(int r100) {
        this.maxCount = r100;
    }

    public final void setMinCount(int r100) {
        this.minCount = r100;
    }

    public final void setMinFilterHeight(int r100) {
        this.minFilterHeight = r100;
    }

    public final void setMinFilterWidth(int r100) {
        this.minFilterWidth = r100;
    }

    public final void setRelation(String r100) {
        this.relation = r100;
    }

    public PlDataBean(ArrayList<String> r100, String r101, String r102, boolean r103, boolean r104, int r105, int r106, int r107, int r110, int r111, int r112, int r113, int r114, int r115) {
        Intrinsics.checkNotNullParameter(r100, "alg");
        this.alg = r100;
        this.relation = r101;
        this.imgK = r102;
        this.loading = r103;
        this.guide = r104;
        this.albumFilter = r105;
        this.faceCountMin = r106;
        this.faceCountMax = r107;
        this.minCount = r110;
        this.maxCount = r111;
        this.defaultHeight = r112;
        this.defaultWidth = r113;
        this.minFilterHeight = r114;
        this.minFilterWidth = r115;
    }

    public /* synthetic */ PlDataBean(ArrayList r110, String r111, String r112, boolean r113, boolean r210, int r211, int r212, int r213, int r214, int r215, int r216, int r217, int r218, int r219, int r310, DefaultConstructorMarker r311) {
        if ((r310 & 1) == 0) goto L5;
        ArrayList r100 = new ArrayList();
    L6:
        String r101 = null;
        if ((r310 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r310 & 4) != 0) goto L14;
        r101 = r112;
    L14:
        boolean r103 = true;
        if ((r310 & 8) == 0) goto L17;
        boolean r104 = true;
    L19:
        if ((r310 & 16) != 0) goto L22;
        r103 = r210;
    L22:
        int r105 = 0;
        if ((r310 & 32) == 0) goto L25;
        int r106 = 0;
    L27:
        if ((r310 & 64) == 0) goto L29;
        int r107 = 2;
    L31:
        if ((r310 & 128) == 0) goto L33;
        int r108 = 5;
    L34:
        int r114 = -1;
        if ((r310 & 256) == 0) goto L37;
        int r115 = -1;
    L39:
        if ((r310 & 512) == 0) goto L41;
        int r116 = -1;
    L43:
        if ((r310 & 1024) == 0) goto L45;
        int r117 = -1;
    L47:
        if ((r310 & 2048) != 0) goto L51;
        r114 = r217;
    L51:
        if ((r310 & 4096) == 0) goto L53;
        int r118 = 0;
    L55:
        if ((r310 & 8192) != 0) goto L58;
        r105 = r219;
    L58:
        this(r100, r102, r101, r104, r103, r106, r107, r108, r115, r116, r117, r114, r118, r105);
        return;
    L53:
        r118 = r218;
        goto L55
    L45:
        r117 = r216;
        goto L47
    L41:
        r116 = r215;
        goto L43
    L37:
        r115 = r214;
        goto L39
    L33:
        r108 = r213;
        goto L34
    L29:
        r107 = r212;
        goto L31
    L25:
        r106 = r211;
        goto L27
    L17:
        r104 = r113;
        goto L19
    L9:
        r102 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L6
    }
}
