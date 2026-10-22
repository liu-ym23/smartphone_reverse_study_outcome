package com.ss.android.lark.chat.entity.sticker;

import android.text.TextUtils;
import com.ss.android.lark.image.entity.BaseImageSet;
import com.ss.android.lark.image.entity.Image;
import java.io.Serializable;
import r27.a;
import y28.b;

/* JADX INFO: loaded from: classes35.dex */
public class Sticker implements Serializable, Comparable, b<Sticker> {
    private String mDesc;
    private boolean mHasPaid;
    private BaseImageSet mImageSet;
    private Mode mMode;
    private int mPosition;
    private String mSmallUrl;
    private String mStickerId;
    private String mStickerSetId;

    public static final enum Mode extends Enum<Mode> {
        public static final Mode MEME = null;
        public static final Mode STICKER = null;
        public static final Mode UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Mode[] f415359a = null;
        private int mValue;

        static {
            Mode r100 = new Mode("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            Mode r101 = new Mode("STICKER", 1, 1);
            STICKER = r101;
            Mode r102 = new Mode("MEME", 2, 2);
            MEME = r102;
            f415359a = new Mode[]{r100, r101, r102};
        }

        public static Mode[] values() {
            return (Mode[]) f415359a.clone();
        }

        public int getNumber() {
            return this.mValue;
        }

        public static Mode forNumber(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return MEME;
        L12:
            return STICKER;
        L14:
            return UNKNOWN;
        }

        public static Mode valueOf(String r100) {
            return (Mode) a.a(Mode.class, r100);
        }

        public static Mode valueOf(int r100) {
            return forNumber(r100);
        }

        public Mode(String r100, int r101, int r102) {
            super(r100, r101);
            this.mValue = r102;
        }
    }

    public Sticker() {
    }

    public int hashCode() {
        String r100 = this.mStickerId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        String r103 = getOriginImageKey();
        int r104 = r102 * 31;
        if (r103 == null) goto L9;
        int r105 = r103.hashCode();
    L10:
        int r106 = r104 + r105;
        String r107 = getThumbnailImageKey();
        int r108 = r106 * 31;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r108 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String getImageKey() {
        String r100 = getThumbnailImageKey();
        if (TextUtils.isEmpty(r100) == false) goto L6;
        r100 = getSmallUrl();
    L6:
        if (TextUtils.isEmpty(r100) == true) goto L8;
        return r100;
    L8:
        return getOriginImageKey();
    }

    public int getOriginImageHeight() {
        BaseImageSet r100 = getImageSet();
        if (r100 != null) goto L5;
        Image r101 = null;
    L6:
        if (r101 != null) goto L10;
        return 0;
    L10:
        return r101.getHeight();
    L5:
        r101 = r100.getOrigin();
        goto L6
    }

    public String getOriginImageKey() {
        BaseImageSet r100 = getImageSet();
        if (r100 != null) goto L5;
        Image r101 = null;
    L6:
        if (r101 != null) goto L10;
        return "";
    L10:
        return r101.getKey();
    L5:
        r101 = r100.getOrigin();
        goto L6
    }

    public int getOriginImageWidth() {
        BaseImageSet r100 = getImageSet();
        if (r100 != null) goto L5;
        Image r101 = null;
    L6:
        if (r101 != null) goto L10;
        return 0;
    L10:
        return r101.getWidth();
    L5:
        r101 = r100.getOrigin();
        goto L6
    }

    public String getThumbnailImageKey() {
        BaseImageSet r100 = getImageSet();
        if (r100 != null) goto L5;
        return "";
    L5:
        Image r101 = r100.getThumbnail();
        if (r101 != null) goto L9;
        return "";
    L9:
        return r101.getKey();
    }

    public String getDesc() {
        return this.mDesc;
    }

    public BaseImageSet getImageSet() {
        return this.mImageSet;
    }

    public Mode getMode() {
        return this.mMode;
    }

    public int getPosition() {
        return this.mPosition;
    }

    public String getSmallUrl() {
        return this.mSmallUrl;
    }

    public String getStickerId() {
        return this.mStickerId;
    }

    public String getStickerSetId() {
        return this.mStickerSetId;
    }

    public boolean isHasPaid() {
        return this.mHasPaid;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object r100) {
        if ((r100 instanceof Sticker) == false) goto L12;
        Sticker r101 = (Sticker) r100;
        if (getPosition() >= r101.getPosition()) goto L9;
        return -1;
    L9:
        if (getPosition() <= r101.getPosition()) goto L12;
        return 1;
    L12:
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L19:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L19;
        Sticker r101 = (Sticker) r100;
        if (TextUtils.equals(this.mStickerId, r101.getStickerId()) == true) goto L13;
    L17:
        return false;
    L13:
        if (TextUtils.equals(getOriginImageKey(), r101.getOriginImageKey()) == false) goto L17;
        if (TextUtils.equals(getThumbnailImageKey(), r101.getThumbnailImageKey()) == false) goto L17;
        return true;
    }

    public boolean isContentSame(Sticker r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (isItemSame(r100) == true) goto L8;
        return false;
    L8:
        if (TextUtils.equals(getOriginImageKey(), r100.getOriginImageKey()) == true) goto L10;
        return false;
    L10:
        if (TextUtils.equals(getThumbnailImageKey(), r100.getThumbnailImageKey()) == false) goto L15;
        return true;
    L15:
        return false;
    }

    public boolean isItemSame(Sticker r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (TextUtils.equals(this.mStickerId, r100.getStickerId()) == true) goto L8;
        return false;
    L8:
        if (TextUtils.equals(this.mStickerSetId, r100.getStickerSetId()) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public void setDesc(String r100) {
        this.mDesc = r100;
    }

    public void setHasPaid(boolean r100) {
        this.mHasPaid = r100;
    }

    public void setImageSet(BaseImageSet r100) {
        this.mImageSet = r100;
    }

    public void setMode(Mode r100) {
        this.mMode = r100;
    }

    public void setPosition(int r100) {
        this.mPosition = r100;
    }

    public void setSmallUrl(String r100) {
        this.mSmallUrl = r100;
    }

    public void setStickerId(String r100) {
        this.mStickerId = r100;
    }

    public void setStickerSetId(String r100) {
        this.mStickerSetId = r100;
    }

    @Override // y28.b
    public /* bridge */ /* synthetic */ boolean isContentSame(b r100) {
        return isContentSame((Sticker) r100);
    }

    @Override // y28.b
    public /* bridge */ /* synthetic */ boolean isItemSame(b r100) {
        return isItemSame((Sticker) r100);
    }
}
