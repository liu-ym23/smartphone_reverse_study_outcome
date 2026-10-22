package com.ss.android.ugc.aweme.editSticker.model;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.draft.DraftTransMark;
import com.ss.android.ugc.aweme.tools.BitmapExtKt;
import com.ss.android.ugc.tools.utils.a;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u00012\u00020\u0002B?\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\t\u0010#\u001a\u00020\fHÖ\u0001J\u0006\u0010$\u001a\u00020\u0004J\u0010\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&H\u0007J\u0006\u0010(\u001a\u00020)J\u0019\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\fHÖ\u0001R\"\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R \u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR \u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006."}, d2 = {"Lcom/ss/android/ugc/aweme/editSticker/model/EffectTextModel;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "hasCoverText", "", "textSticker", "Lcom/ss/android/ugc/aweme/editSticker/model/StickerItemModel;", "createAwemeCoverInfo", "Lcom/ss/android/ugc/aweme/editSticker/model/CreateAwemeCoverInfo;", "coverSelectedFrom", "", "coverFrameIndex", "", "(ZLcom/ss/android/ugc/aweme/editSticker/model/StickerItemModel;Lcom/ss/android/ugc/aweme/editSticker/model/CreateAwemeCoverInfo;Ljava/lang/String;Ljava/lang/Integer;)V", "getCoverFrameIndex", "()Ljava/lang/Integer;", "setCoverFrameIndex", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getCoverSelectedFrom", "()Ljava/lang/String;", "setCoverSelectedFrom", "(Ljava/lang/String;)V", "getCreateAwemeCoverInfo", "()Lcom/ss/android/ugc/aweme/editSticker/model/CreateAwemeCoverInfo;", "setCreateAwemeCoverInfo", "(Lcom/ss/android/ugc/aweme/editSticker/model/CreateAwemeCoverInfo;)V", "getHasCoverText", "()Z", "setHasCoverText", "(Z)V", "getTextSticker", "()Lcom/ss/android/ugc/aweme/editSticker/model/StickerItemModel;", "setTextSticker", "(Lcom/ss/android/ugc/aweme/editSticker/model/StickerItemModel;)V", "describeContents", "isCoverTextValid", "mergeCoverText", "Landroid/graphics/Bitmap;", "coverBitmap", BasicTestActionHandler.TEST_ACTION_RESET, "", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "lib-api_release"}, k = 1, mv = {1, 4, 1})
public class EffectTextModel implements Parcelable, Serializable {
    public static final Parcelable.Creator<EffectTextModel> CREATOR = null;

    @SerializedName("cover_frame_index")
    private Integer coverFrameIndex;

    @SerializedName("cover_select_from")
    private String coverSelectedFrom;

    @SerializedName("create_aweme_cover_info")
    private CreateAwemeCoverInfo createAwemeCoverInfo;

    @SerializedName("has_cover_text")
    private boolean hasCoverText;

    @SerializedName("text_sticker")
    @DraftTransMark
    private StickerItemModel textSticker;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    public static class Creator implements Parcelable.Creator<EffectTextModel> {
        public Creator() {
        }

        @Override // android.os.Parcelable.Creator
        public final EffectTextModel createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "in");
            if (r100.readInt() == 0) goto L5;
            boolean r101 = true;
        L6:
            StickerItemModel r102 = (StickerItemModel) r100.readParcelable(EffectTextModel.class.getClassLoader());
            if (r100.readInt() == 0) goto L9;
            CreateAwemeCoverInfo r103 = CreateAwemeCoverInfo.CREATOR.createFromParcel(r100);
        L10:
            String r104 = r100.readString();
            if (r100.readInt() == 0) goto L13;
            Integer r105 = Integer.valueOf(r100.readInt());
        L15:
            return new EffectTextModel(r101, r102, r103, r104, r105);
        L13:
            r105 = null;
            goto L15
        L9:
            r103 = null;
            goto L10
        L5:
            r101 = false;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final EffectTextModel[] newArray(int r100) {
            return new EffectTextModel[r100];
        }
    }

    static {
        CREATOR = new Creator();
    }

    public EffectTextModel() {
        this(false, null, null, null, null, 31, null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final void reset() {
        this.hasCoverText = false;
        this.textSticker = null;
        this.createAwemeCoverInfo = null;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeInt(this.hasCoverText ? 1 : 0);
        r100.writeParcelable(this.textSticker, r101);
        CreateAwemeCoverInfo r102 = this.createAwemeCoverInfo;
        if (r102 == null) goto L5;
        r100.writeInt(1);
        r102.writeToParcel(r100, 0);
    L6:
        r100.writeString(this.coverSelectedFrom);
        Integer r103 = this.coverFrameIndex;
        if (r103 == null) goto L9;
        r100.writeInt(1);
        r100.writeInt(r103.intValue());
        return;
    L9:
        r100.writeInt(0);
        return;
    L5:
        r100.writeInt(0);
        goto L6
    }

    public final boolean isCoverTextValid() {
        if (this.hasCoverText == false) goto L18;
        StickerItemModel r100 = this.textSticker;
        if (r100 == null) goto L7;
        String r101 = r100.path;
    L9:
        if (r101 != null) goto L11;
    L14:
        boolean r102 = true;
    L15:
        if (r102 == true) goto L19;
        return true;
    L19:
        return false;
    L11:
        if (r101.length() == 0) goto L14;
        r102 = false;
        goto L15
    L7:
        r101 = null;
        goto L9
    L18:
        return false;
    }

    public final Integer getCoverFrameIndex() {
        return this.coverFrameIndex;
    }

    public final String getCoverSelectedFrom() {
        return this.coverSelectedFrom;
    }

    public final CreateAwemeCoverInfo getCreateAwemeCoverInfo() {
        return this.createAwemeCoverInfo;
    }

    public final boolean getHasCoverText() {
        return this.hasCoverText;
    }

    public final StickerItemModel getTextSticker() {
        return this.textSticker;
    }

    public final Bitmap mergeCoverText(Bitmap r100) {
        Intrinsics.checkNotNullParameter(r100, "coverBitmap");
        if (this.hasCoverText == false) goto L36;
        StickerItemModel r101 = this.textSticker;
        if (r101 == null) goto L37;
        int r102 = r100.getWidth();     // Catch: Exception -> L34
        Pair<Integer, Integer> r103 = BitmapExtKt.c(r101.path);     // Catch: Exception -> L34
        if (r100.getWidth() > r100.getHeight()) goto L9;
    L11:
        boolean r104 = false;
    L13:
        if (r103.getFirst().intValue() != 0) goto L15;
    L27:
        Bitmap r105 = BitmapExtKt.b(r101.path, r102, r100.getHeight());     // Catch: Exception -> L34
        Bitmap r106 = a.a(r100, r105);     // Catch: Exception -> L34
        if (r105 != null) goto L30;
    L33:
        return r106;
    L30:
        if (r105.isRecycled() == true) goto L33;
        r105.recycle();     // Catch: Exception -> L34
        goto L33
    L15:
        if (r103.getSecond().intValue() == 0) goto L27;
        if (r104 == false) goto L27;
        Bitmap r107 = BitmapExtKt.b(r101.path, r102, (int) ((r102 * r103.getSecond().intValue()) / r103.getFirst().floatValue()));     // Catch: Exception -> L34
        if (r107 == null) goto L22;
        r106 = CoverPublishModelKt.a(r100, r107);     // Catch: Exception -> L34
        if (r106 == null) goto L22;
    L23:
        if (r107 == null) goto L33;
        if (r107.isRecycled() == true) goto L33;
        r107.recycle();     // Catch: Exception -> L34
    L22:
        r106 = r100;
        goto L23
    L9:
        if (r103.getSecond().intValue() <= r103.getFirst().intValue()) goto L11;
        r104 = true;
        goto L13
    L38:
        return r100;
    L37:
        return r100;
    L36:
        return r100;
    }

    public final void setCoverFrameIndex(Integer r100) {
        this.coverFrameIndex = r100;
    }

    public final void setCoverSelectedFrom(String r100) {
        this.coverSelectedFrom = r100;
    }

    public final void setCreateAwemeCoverInfo(CreateAwemeCoverInfo r100) {
        this.createAwemeCoverInfo = r100;
    }

    public final void setHasCoverText(boolean r100) {
        this.hasCoverText = r100;
    }

    public final void setTextSticker(StickerItemModel r100) {
        this.textSticker = r100;
    }

    public EffectTextModel(boolean r100, StickerItemModel r101, CreateAwemeCoverInfo r102, String r103, Integer r104) {
        this.hasCoverText = r100;
        this.textSticker = r101;
        this.createAwemeCoverInfo = r102;
        this.coverSelectedFrom = r103;
        this.coverFrameIndex = r104;
    }

    public /* synthetic */ EffectTextModel(boolean r100, StickerItemModel r101, CreateAwemeCoverInfo r102, String r103, Integer r104, int r105, DefaultConstructorMarker r110) {
        if ((r105 & 1) == 0) goto L5;
        r100 = false;
    L5:
        Integer r106 = null;
        if ((r105 & 2) == 0) goto L8;
        StickerItemModel r111 = null;
    L10:
        if ((r105 & 4) == 0) goto L12;
        CreateAwemeCoverInfo r107 = null;
    L14:
        if ((r105 & 8) == 0) goto L16;
        String r108 = null;
    L18:
        if ((r105 & 16) != 0) goto L21;
        r106 = r104;
    L21:
        this(r100, r111, r107, r108, r106);
        return;
    L16:
        r108 = r103;
        goto L18
    L12:
        r107 = r102;
        goto L14
    L8:
        r111 = r101;
        goto L10
    }
}
