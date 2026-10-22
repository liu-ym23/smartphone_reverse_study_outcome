package com.ss.android.lark.chat.entity.sticker;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.image.entity.Image;
import java.io.Serializable;
import java.util.List;
import r27.a;

/* JADX INFO: loaded from: classes35.dex */
public class StickerSet implements Serializable {
    private Archive mArchive;
    private String mAuthorId;
    private Image mCover;
    private String mDescription;
    private boolean mHasPaid;
    private Image mIcon;
    private Perm mPerm;
    private Image mPreview;
    private String mStickerSetId;
    private StickerSetType mStickerSetType;
    private List<Sticker> mStickers;
    private String mTitle;
    private long mUpdateTime;
    private int mVersion;

    public static final enum Perm extends Enum<Perm> {
        public static final Perm ALONE = null;
        public static final Perm OWN = null;
        public static final Perm UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Perm[] f415360a = null;
        private int mValue;

        static {
            Perm r100 = new Perm("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            Perm r101 = new Perm("ALONE", 1, 1);
            ALONE = r101;
            Perm r102 = new Perm("OWN", 2, 2);
            OWN = r102;
            f415360a = new Perm[]{r100, r101, r102};
        }

        public static Perm[] values() {
            return (Perm[]) f415360a.clone();
        }

        public int getNumber() {
            return this.mValue;
        }

        public static Perm forNumber(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return OWN;
        L12:
            return ALONE;
        L14:
            return UNKNOWN;
        }

        public static Perm valueOf(String r100) {
            return (Perm) a.a(Perm.class, r100);
        }

        public static Perm valueOf(int r100) {
            return forNumber(r100);
        }

        public Perm(String r100, int r101, int r102) {
            super(r100, r101);
            this.mValue = r102;
        }
    }

    public StickerSet() {
    }

    public String getArchiveKey() {
        Archive r100 = this.mArchive;
        if (r100 != null) goto L7;
        return "";
    L7:
        return r100.getKey();
    }

    public String getArchiveUrl() {
        Archive r100 = this.mArchive;
        if (r100 != null) goto L5;
        return "";
    L5:
        List<String> r101 = r100.getUrls();
        if (CollectionUtils.isEmpty(r101) == false) goto L9;
        return "";
    L9:
        return (String) ListProtector.get(r101, 0);
    }

    public String getPreviewKey() {
        Image r100 = this.mPreview;
        if (r100 != null) goto L7;
        return "";
    L7:
        return r100.getKey();
    }

    public boolean isAdded() {
        if (this.mPerm != Perm.OWN) goto L5;
        return true;
    L5:
        return false;
    }

    public Archive getArchive() {
        return this.mArchive;
    }

    public String getAuthorId() {
        return this.mAuthorId;
    }

    public Image getCover() {
        return this.mCover;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public Image getIcon() {
        return this.mIcon;
    }

    public Perm getPerm() {
        return this.mPerm;
    }

    public Image getPreview() {
        return this.mPreview;
    }

    public String getStickerSetId() {
        return this.mStickerSetId;
    }

    public StickerSetType getStickerSetType() {
        return this.mStickerSetType;
    }

    public List<Sticker> getStickers() {
        return this.mStickers;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public long getUpdateTime() {
        return this.mUpdateTime;
    }

    public int getVersion() {
        return this.mVersion;
    }

    public boolean isHasPaid() {
        return this.mHasPaid;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L31:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L31;
        StickerSet r101 = (StickerSet) r100;
        if (TextUtils.equals(this.mStickerSetId, r101.getStickerSetId()) == true) goto L14;
        return false;
    L14:
        if (this.mPerm == r101.mPerm) goto L16;
        return false;
    L16:
        List<Sticker> r102 = this.mStickers;
        if (r102 == null) goto L31;
        if (r101.mStickers == null) goto L31;
        if (r102.size() == r101.getStickers().size()) goto L24;
        return false;
    L24:
        int r103 = this.mStickers.size();
        int r104 = 0;
    L25:
        if (r104 >= r103) goto L30;
        if (((Sticker) ListProtector.get(this.mStickers, r104)).equals(ListProtector.get(r101.getStickers(), r104)) == false) goto L28;
        r104 = r104 + 1;
        goto L25
    L28:
        return false;
    L30:
        return true;
    }

    public void setArchive(Archive r100) {
        this.mArchive = r100;
    }

    public void setAuthorId(String r100) {
        this.mAuthorId = r100;
    }

    public void setCover(Image r100) {
        this.mCover = r100;
    }

    public void setDescription(String r100) {
        this.mDescription = r100;
    }

    public void setHasPaid(boolean r100) {
        this.mHasPaid = r100;
    }

    public void setIcon(Image r100) {
        this.mIcon = r100;
    }

    public void setPerm(Perm r100) {
        this.mPerm = r100;
    }

    public void setPreview(Image r100) {
        this.mPreview = r100;
    }

    public void setStickerSetId(String r100) {
        this.mStickerSetId = r100;
    }

    public void setStickerSetType(StickerSetType r100) {
        this.mStickerSetType = r100;
    }

    public void setStickers(List<Sticker> r100) {
        this.mStickers = r100;
    }

    public void setTitle(String r100) {
        this.mTitle = r100;
    }

    public void setUpdateTime(long r100) {
        this.mUpdateTime = r100;
    }

    public void setVersion(int r100) {
        this.mVersion = r100;
    }
}
