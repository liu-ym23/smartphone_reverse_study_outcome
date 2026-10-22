package com.ss.android.ugc.aweme.editSticker.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b(\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 :2\u00020\u00012\u00020\u0002:\u0001:B\u0093\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\b\b\u0002\u0010\n\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0004¢\u0006\u0002\u0010\u0014J\t\u00104\u001a\u00020\u0007HÖ\u0001J\u0019\u00105\u001a\u0002062\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u0007HÖ\u0001R\u001e\u0010\u0013\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018R\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R\u001e\u0010\u0010\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0016\"\u0004\b\"\u0010\u0018R\u001e\u0010\u000e\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010#\"\u0004\b$\u0010%R\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010#\"\u0004\b&\u0010%R\u001e\u0010\u0011\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u001e\"\u0004\b'\u0010 R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001e\"\u0004\b)\u0010 R\u001e\u0010\n\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0016\"\u0004\b+\u0010\u0018R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0016\"\u0004\b-\u0010\u0018R\u001e\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0016\"\u0004\b/\u0010\u0018R\u001e\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0016\"\u0004\b1\u0010\u0018R\u001e\u0010\b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0016\"\u0004\b3\u0010\u0018¨\u0006;"}, d2 = {"Lcom/ss/android/ugc/aweme/editSticker/model/StickerMobParams;", "Ljava/io/Serializable;", "Landroid/os/Parcelable;", "selectFrom", "", "stickerType", "panelPosition", "", "tabName", "creationId", "propId", "shootWay", "isCutout", "", "isCrop", "customStickerEntrance", "customCutoutModelType", "isMultiContent", "contentType", "contentSource", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;IILjava/lang/String;Ljava/lang/String;)V", "getContentSource", "()Ljava/lang/String;", "setContentSource", "(Ljava/lang/String;)V", "getContentType", "setContentType", "getCreationId", "setCreationId", "getCustomCutoutModelType", "()I", "setCustomCutoutModelType", "(I)V", "getCustomStickerEntrance", "setCustomStickerEntrance", "()Z", "setCrop", "(Z)V", "setCutout", "setMultiContent", "getPanelPosition", "setPanelPosition", "getPropId", "setPropId", "getSelectFrom", "setSelectFrom", "getShootWay", "setShootWay", "getStickerType", "setStickerType", "getTabName", "setTabName", "describeContents", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "lib-api_release"}, k = 1, mv = {1, 4, 1})
public final class StickerMobParams implements Serializable, Parcelable {
    public static final Parcelable.Creator<StickerMobParams> CREATOR = null;
    public static final String CUSTOM_ADD = "custom_add";
    public static final Companion Companion = null;
    public static final String FROM_SEARCH = "search_tab";
    public static final String RECENT_USE = "recent_use";

    @SerializedName("contentSource")
    private String contentSource;

    @SerializedName("contentType")
    private String contentType;

    @SerializedName("creationId")
    private String creationId;

    @SerializedName("customCutoutModelType")
    private int customCutoutModelType;

    @SerializedName("customStickerEntrance")
    private String customStickerEntrance;

    @SerializedName("isCrop")
    private boolean isCrop;

    @SerializedName("isCutout")
    private boolean isCutout;

    @SerializedName("isMultiContent")
    private int isMultiContent;

    @SerializedName("panelPosition")
    private int panelPosition;

    @SerializedName("propId")
    private String propId;

    @SerializedName("selectFrom")
    private String selectFrom;

    @SerializedName("shootWay")
    private String shootWay;

    @SerializedName("stickerType")
    private String stickerType;

    @SerializedName("tabName")
    private String tabName;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004¨\u0006\t"}, d2 = {"Lcom/ss/android/ugc/aweme/editSticker/model/StickerMobParams$Companion;", "", "", "CUSTOM_ADD", "Ljava/lang/String;", "FROM_SEARCH", "RECENT_USE", "<init>", "()V", "lib-api_release"}, k = 1, mv = {1, 4, 1})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    public static class Creator implements Parcelable.Creator<StickerMobParams> {
        public Creator() {
        }

        @Override // android.os.Parcelable.Creator
        public final StickerMobParams createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "in");
            String r100 = r110.readString();
            String r101 = r110.readString();
            int r102 = r110.readInt();
            String r103 = r110.readString();
            String r104 = r110.readString();
            String r105 = r110.readString();
            String r106 = r110.readString();
            boolean r111 = false;
            if (r110.readInt() == 0) goto L5;
            boolean r107 = true;
        L7:
            if (r110.readInt() == 0) goto L10;
            r111 = true;
        L10:
            return new StickerMobParams(r100, r101, r102, r103, r104, r105, r106, r107, r111, r110.readString(), r110.readInt(), r110.readInt(), r110.readString(), r110.readString());
        L5:
            r107 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final StickerMobParams[] newArray(int r100) {
            return new StickerMobParams[r100];
        }
    }

    static {
        Companion = new Companion(0);
        CREATOR = new Creator();
    }

    public StickerMobParams() {
        this(null, null, 0, null, null, null, null, false, false, null, 0, 0, null, null, 16383, null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeString(this.selectFrom);
        r100.writeString(this.stickerType);
        r100.writeInt(this.panelPosition);
        r100.writeString(this.tabName);
        r100.writeString(this.creationId);
        r100.writeString(this.propId);
        r100.writeString(this.shootWay);
        r100.writeInt(this.isCutout ? 1 : 0);
        r100.writeInt(this.isCrop ? 1 : 0);
        r100.writeString(this.customStickerEntrance);
        r100.writeInt(this.customCutoutModelType);
        r100.writeInt(this.isMultiContent);
        r100.writeString(this.contentType);
        r100.writeString(this.contentSource);
    }

    public final String getContentSource() {
        return this.contentSource;
    }

    public final String getContentType() {
        return this.contentType;
    }

    public final String getCreationId() {
        return this.creationId;
    }

    public final int getCustomCutoutModelType() {
        return this.customCutoutModelType;
    }

    public final String getCustomStickerEntrance() {
        return this.customStickerEntrance;
    }

    public final int getPanelPosition() {
        return this.panelPosition;
    }

    public final String getPropId() {
        return this.propId;
    }

    public final String getSelectFrom() {
        return this.selectFrom;
    }

    public final String getShootWay() {
        return this.shootWay;
    }

    public final String getStickerType() {
        return this.stickerType;
    }

    public final String getTabName() {
        return this.tabName;
    }

    public final boolean isCrop() {
        return this.isCrop;
    }

    public final boolean isCutout() {
        return this.isCutout;
    }

    public final int isMultiContent() {
        return this.isMultiContent;
    }

    public final void setContentSource(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.contentSource = r100;
    }

    public final void setContentType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.contentType = r100;
    }

    public final void setCreationId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.creationId = r100;
    }

    public final void setCrop(boolean r100) {
        this.isCrop = r100;
    }

    public final void setCustomCutoutModelType(int r100) {
        this.customCutoutModelType = r100;
    }

    public final void setCustomStickerEntrance(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.customStickerEntrance = r100;
    }

    public final void setCutout(boolean r100) {
        this.isCutout = r100;
    }

    public final void setMultiContent(int r100) {
        this.isMultiContent = r100;
    }

    public final void setPanelPosition(int r100) {
        this.panelPosition = r100;
    }

    public final void setPropId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.propId = r100;
    }

    public final void setSelectFrom(String r100) {
        this.selectFrom = r100;
    }

    public final void setShootWay(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.shootWay = r100;
    }

    public final void setStickerType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.stickerType = r100;
    }

    public final void setTabName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.tabName = r100;
    }

    public StickerMobParams(String r100, String r101, int r102, String r103, String r104, String r105, String r106, boolean r107, boolean r110, String r111, int r112, int r113, String r114, String r115) {
        Intrinsics.checkNotNullParameter(r101, "stickerType");
        Intrinsics.checkNotNullParameter(r103, "tabName");
        Intrinsics.checkNotNullParameter(r104, "creationId");
        Intrinsics.checkNotNullParameter(r105, "propId");
        Intrinsics.checkNotNullParameter(r106, "shootWay");
        Intrinsics.checkNotNullParameter(r111, "customStickerEntrance");
        Intrinsics.checkNotNullParameter(r114, "contentType");
        Intrinsics.checkNotNullParameter(r115, "contentSource");
        this.selectFrom = r100;
        this.stickerType = r101;
        this.panelPosition = r102;
        this.tabName = r103;
        this.creationId = r104;
        this.propId = r105;
        this.shootWay = r106;
        this.isCutout = r107;
        this.isCrop = r110;
        this.customStickerEntrance = r111;
        this.customCutoutModelType = r112;
        this.isMultiContent = r113;
        this.contentType = r114;
        this.contentSource = r115;
    }

    public /* synthetic */ StickerMobParams(String r110, String r111, int r112, String r113, String r210, String r211, String r212, boolean r213, boolean r214, String r215, int r216, int r217, String r218, String r219, int r310, DefaultConstructorMarker r311) {
        String r100 = "";
        if ((r310 & 1) == 0) goto L5;
        String r101 = "";
    L7:
        if ((r310 & 2) == 0) goto L9;
        String r102 = "";
    L10:
        int r103 = -1;
        if ((r310 & 4) == 0) goto L13;
        int r104 = -1;
    L15:
        if ((r310 & 8) == 0) goto L17;
        String r105 = "";
    L19:
        if ((r310 & 16) == 0) goto L21;
        String r106 = "";
    L23:
        if ((r310 & 32) == 0) goto L25;
        String r107 = "";
    L27:
        if ((r310 & 64) == 0) goto L29;
        String r108 = "";
    L30:
        int r114 = 0;
        if ((r310 & 128) == 0) goto L33;
        boolean r115 = false;
    L35:
        if ((r310 & 256) == 0) goto L37;
        boolean r116 = false;
    L39:
        if ((r310 & 512) == 0) goto L41;
        String r117 = "";
    L43:
        if ((r310 & 1024) != 0) goto L47;
        r103 = r216;
    L47:
        if ((r310 & 2048) != 0) goto L51;
        r114 = r217;
    L51:
        if ((r310 & 4096) == 0) goto L53;
        String r118 = "";
    L55:
        if ((r310 & 8192) != 0) goto L58;
        r100 = r219;
    L58:
        this(r101, r102, r104, r105, r106, r107, r108, r115, r116, r117, r103, r114, r118, r100);
        return;
    L53:
        r118 = r218;
        goto L55
    L41:
        r117 = r215;
        goto L43
    L37:
        r116 = r214;
        goto L39
    L33:
        r115 = r213;
        goto L35
    L29:
        r108 = r212;
        goto L30
    L25:
        r107 = r211;
        goto L27
    L21:
        r106 = r210;
        goto L23
    L17:
        r105 = r113;
        goto L19
    L13:
        r104 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L10
    L5:
        r101 = r110;
        goto L7
    }
}
