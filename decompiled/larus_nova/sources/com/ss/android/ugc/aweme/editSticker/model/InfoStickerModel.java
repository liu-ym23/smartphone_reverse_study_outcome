package com.ss.android.ugc.aweme.editSticker.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.tools.utils.b;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public class InfoStickerModel implements Parcelable, Serializable, Cloneable {
    public static final Parcelable.Creator<InfoStickerModel> CREATOR = null;

    @SerializedName("sticker_dir")
    public String infoStickerDraftDir;

    @SerializedName("text_align")
    public int mAlign;

    @SerializedName("bg_mode")
    public int mBgMode;

    @SerializedName("bg_color")
    public int mColor;

    @SerializedName("text_font_id")
    public String mFontId;

    @SerializedName("text_font_path")
    public String mFontPath;

    @SerializedName("text_font")
    public String mFontType;

    @SerializedName("text_audio_length")
    public int mTextAudioLength;

    @SerializedName("stickers")
    public List<StickerItemModel> stickers;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public void clearInfoSticker() {
        Iterator<StickerItemModel> r100 = this.stickers.iterator();
    L4:
        if (r100.hasNext() == false) goto L12;
        StickerItemModel r101 = r100.next();
        if (r101.isImageSticker() == true) goto L11;
        if (r101.isLyric() == true) goto L11;
        if (r101.isNormalInfoSticker() == false) goto L4;
    L11:
        r100.remove();
        goto L4
    }

    public void clearSticker() {
        this.stickers.clear();
    }

    public String getInfoStickerIds() {
        if (b.a(this.stickers) == false) goto L7;
        return "";
    L7:
        return getNotEmptyInfoStickerIds();
    }

    public StickerItemModel getLyricStickerModel() {
        if (b.a(this.stickers) == false) goto L5;
        return null;
    L5:
        Iterator<StickerItemModel> r100 = this.stickers.iterator();
    L7:
        if (r100.hasNext() == false) goto L13;
        StickerItemModel r101 = r100.next();
        if (r101 == null) goto L7;
        if (r101.isLyric() == false) goto L7;
        return r101;
    L13:
        return null;
    }

    public String getNotEmptyInfoStickerIds() {
        Iterator<StickerItemModel> r100 = this.stickers.iterator();
        StringBuilder r101 = new StringBuilder();
        boolean r102 = true;
    L4:
        if (r100.hasNext() == false) goto L17;
        StickerItemModel r103 = r100.next();
        if (r103 == null) goto L4;
        if (TextUtils.isEmpty(r103.stickerId) == true) goto L4;
        if (r103.type == 2) goto L4;
        if (r102 == false) goto L14;
        r102 = false;
    L15:
        r101.append(r103.stickerId);
        goto L4
    L14:
        r101.append(',');
        goto L15
    L17:
        return r101.toString();
    }

    public String getOtherEffect() {
        if (b.a(this.stickers) == false) goto L6;
        return "[]";
    L6:
        Iterator<StickerItemModel> r100 = this.stickers.iterator();
        JSONArray r101 = new JSONArray();
    L20:
    L16:
        e = move-exception;
        e.printStackTrace();
    L19:
        return r101.toString();
    L8:
        if (r100.hasNext() == false) goto L19;
        StickerItemModel r102 = r100.next();     // Catch: Exception -> L16
        if (r102 == null) goto L20;
        if (r102.type != 10) goto L20;
        JSONObject r103 = new JSONObject();     // Catch: Exception -> L16
        r103.put("id", r102.stickerId);     // Catch: Exception -> L16
        r103.put("type", "giphy");     // Catch: Exception -> L16
        r101.put(r103);     // Catch: Exception -> L16
        goto L20
    }

    public int getSubtitleRule() {
        if (b.a(this.stickers) == false) goto L5;
        return -1;
    L5:
        int r100 = 0;
    L7:
        if (r100 >= this.stickers.size()) goto L19;
        StickerItemModel r101 = (StickerItemModel) ListProtector.get(this.stickers, r100);
        if (r101 == null) goto L13;
        if (r101.isSubtitleRule() == false) goto L13;
        return r100;
    L13:
        r100 = r100 + 1;
        goto L7
    L19:
        return -1;
    }

    public boolean hasAnimTimestampSticker() {
        if (b.a(this.stickers) == false) goto L5;
        return false;
    L5:
        Iterator<StickerItemModel> r100 = this.stickers.iterator();
    L7:
        if (r100.hasNext() == false) goto L14;
        StickerItemModel r101 = r100.next();
        if (r101 == null) goto L7;
        if (r101.isAnimTimestampSticker() == false) goto L7;
        return true;
    L14:
        return false;
    }

    public boolean hasImageSticker() {
        if (b.a(this.stickers) == false) goto L5;
        return false;
    L5:
        Iterator<StickerItemModel> r100 = this.stickers.iterator();
    L7:
        if (r100.hasNext() == false) goto L14;
        StickerItemModel r101 = r100.next();
        if (r101 == null) goto L7;
        if (r101.isImageSticker() == false) goto L7;
        return true;
    L14:
        return false;
    }

    public boolean hasLocalHashTagSticker() {
        if (b.a(this.stickers) == false) goto L5;
        return false;
    L5:
        Iterator<StickerItemModel> r100 = this.stickers.iterator();
    L7:
        if (r100.hasNext() == false) goto L14;
        StickerItemModel r101 = r100.next();
        if (r101 == null) goto L7;
        if (r101.isLocalHashTagSticker() == false) goto L7;
        return true;
    L14:
        return false;
    }

    public boolean hasLyricSticker() {
        if (b.a(this.stickers) == false) goto L5;
        return false;
    L5:
        Iterator<StickerItemModel> r100 = this.stickers.iterator();
    L7:
        if (r100.hasNext() == false) goto L14;
        StickerItemModel r101 = r100.next();
        if (r101 == null) goto L7;
        if (r101.isLyric() == false) goto L7;
        return true;
    L14:
        return false;
    }

    public boolean hasSubtitle() {
        if (b.a(this.stickers) == false) goto L5;
        return false;
    L5:
        Iterator<StickerItemModel> r100 = this.stickers.iterator();
    L7:
        if (r100.hasNext() == false) goto L14;
        StickerItemModel r101 = r100.next();
        if (r101 == null) goto L7;
        if (r101.isSubtitle() == false) goto L7;
        return true;
    L14:
        return false;
    }

    public String toString() {
        return "InfoStickerModel@" + Integer.toHexString(hashCode()) + "{infoStickerDraftDir='" + this.infoStickerDraftDir + "', stickers=" + this.stickers + '}';
    }

    public InfoStickerModel() {
        this.mColor = -1;
        this.mBgMode = 1;
        this.mAlign = 2;
    }

    public InfoStickerModel clone() {
        InfoStickerModel r100 = (InfoStickerModel) super.clone();     // Catch: CloneNotSupportedException -> L10
        ArrayList r101 = new ArrayList();     // Catch: CloneNotSupportedException -> L10
        Iterator<StickerItemModel> r102 = r100.stickers.iterator();     // Catch: CloneNotSupportedException -> L10
    L4:
        if (r102.hasNext() == false) goto L8;
        StickerItemModel r103 = r102.next();     // Catch: CloneNotSupportedException -> L10
        if (r103 == null) goto L4;
        r101.add(r103.clone());     // Catch: CloneNotSupportedException -> L10
        goto L4
    L8:
        r100.stickers = r101;     // Catch: CloneNotSupportedException -> L10
        return r100;
    L11:
        throw new AssertionError();
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m8701clone() throws CloneNotSupportedException {
        return clone();
    }

    public InfoStickerModel(Parcel r100) {
        this.mColor = -1;
        this.mBgMode = 1;
        this.mAlign = 2;
        this.infoStickerDraftDir = r100.readString();
        this.stickers = r100.createTypedArrayList(StickerItemModel.CREATOR);
        this.mFontType = r100.readString();
        this.mFontId = r100.readString();
        this.mFontPath = r100.readString();
        this.mColor = r100.readInt();
        this.mBgMode = r100.readInt();
        this.mAlign = r100.readInt();
        this.mTextAudioLength = r100.readInt();
    }

    public void addSticker(StickerItemModel r100) {
        this.stickers.add(r100);
    }

    public void removeSticker(StickerItemModel r100) {
        this.stickers.remove(r100);
    }

    public InfoStickerModel(InfoStickerModel r100) {
        this.mColor = -1;
        this.mBgMode = 1;
        this.mAlign = 2;
        this.infoStickerDraftDir = r100.infoStickerDraftDir;
        this.stickers = new ArrayList(r100.stickers);
        this.mFontType = r100.mFontType;
        this.mFontId = r100.mFontId;
        this.mFontPath = r100.mFontPath;
        this.mColor = r100.mColor;
        this.mBgMode = r100.mBgMode;
        this.mAlign = r100.mAlign;
        this.mTextAudioLength = r100.mTextAudioLength;
    }

    public InfoStickerModel(String r100) {
        this.mColor = -1;
        this.mBgMode = 1;
        this.mAlign = 2;
        String r101 = File.separator;
        if (r100.endsWith(r101) == false) goto L5;
        this.infoStickerDraftDir = r100;
    L6:
        this.stickers = new ArrayList();
        return;
    L5:
        this.infoStickerDraftDir = r100 + r101;
        goto L6
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.infoStickerDraftDir);
        r100.writeTypedList(this.stickers);
        r100.writeString(this.mFontType);
        r100.writeString(this.mFontId);
        r100.writeString(this.mFontPath);
        r100.writeInt(this.mColor);
        r100.writeInt(this.mBgMode);
        r100.writeInt(this.mAlign);
        r100.writeInt(this.mTextAudioLength);
    }
}
