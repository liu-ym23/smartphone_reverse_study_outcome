package android.support.v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class MediaDescriptionCompat implements Parcelable {
    public static final long BT_FOLDER_TYPE_ALBUMS = 2;
    public static final long BT_FOLDER_TYPE_ARTISTS = 3;
    public static final long BT_FOLDER_TYPE_GENRES = 4;
    public static final long BT_FOLDER_TYPE_MIXED = 0;
    public static final long BT_FOLDER_TYPE_PLAYLISTS = 5;
    public static final long BT_FOLDER_TYPE_TITLES = 1;
    public static final long BT_FOLDER_TYPE_YEARS = 6;
    public static final Parcelable.Creator<MediaDescriptionCompat> CREATOR = null;
    public static final String DESCRIPTION_KEY_MEDIA_URI = "android.support.v4.media.description.MEDIA_URI";
    public static final String DESCRIPTION_KEY_NULL_BUNDLE_FLAG = "android.support.v4.media.description.NULL_BUNDLE_FLAG";
    public static final String EXTRA_BT_FOLDER_TYPE = "android.media.extra.BT_FOLDER_TYPE";
    public static final String EXTRA_DOWNLOAD_STATUS = "android.media.extra.DOWNLOAD_STATUS";
    public static final long STATUS_DOWNLOADED = 2;
    public static final long STATUS_DOWNLOADING = 1;
    public static final long STATUS_NOT_DOWNLOADED = 0;
    private final CharSequence mDescription;
    private Object mDescriptionObj;
    private final Bundle mExtras;
    private final Bitmap mIcon;
    private final Uri mIconUri;
    private final String mMediaId;
    private final Uri mMediaUri;
    private final CharSequence mSubtitle;
    private final CharSequence mTitle;

    public static final class Builder {
        private CharSequence mDescription;
        private Bundle mExtras;
        private Bitmap mIcon;
        private Uri mIconUri;
        private String mMediaId;
        private Uri mMediaUri;
        private CharSequence mSubtitle;
        private CharSequence mTitle;

        public MediaDescriptionCompat build() {
            return new MediaDescriptionCompat(this.mMediaId, this.mTitle, this.mSubtitle, this.mDescription, this.mIcon, this.mIconUri, this.mExtras, this.mMediaUri);
        }

        public Builder() {
        }

        public Builder setDescription(CharSequence r1) {
            this.mDescription = r1;
            return this;
        }

        public Builder setExtras(Bundle r1) {
            this.mExtras = r1;
            return this;
        }

        public Builder setIconBitmap(Bitmap r1) {
            this.mIcon = r1;
            return this;
        }

        public Builder setIconUri(Uri r1) {
            this.mIconUri = r1;
            return this;
        }

        public Builder setMediaId(String r1) {
            this.mMediaId = r1;
            return this;
        }

        public Builder setMediaUri(Uri r1) {
            this.mMediaUri = r1;
            return this;
        }

        public Builder setSubtitle(CharSequence r1) {
            this.mSubtitle = r1;
            return this;
        }

        public Builder setTitle(CharSequence r1) {
            this.mTitle = r1;
            return this;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public Object getMediaDescription() {
        Object r0 = this.mDescriptionObj;
        if (r0 != null) goto L16;
        int r1 = Build.VERSION.SDK_INT;
        Object r2 = MediaDescriptionCompatApi21.Builder.newInstance();
        MediaDescriptionCompatApi21.Builder.setMediaId(r2, this.mMediaId);
        MediaDescriptionCompatApi21.Builder.setTitle(r2, this.mTitle);
        MediaDescriptionCompatApi21.Builder.setSubtitle(r2, this.mSubtitle);
        MediaDescriptionCompatApi21.Builder.setDescription(r2, this.mDescription);
        MediaDescriptionCompatApi21.Builder.setIconBitmap(r2, this.mIcon);
        MediaDescriptionCompatApi21.Builder.setIconUri(r2, this.mIconUri);
        Bundle r3 = this.mExtras;
        if (r1 < 23) goto L7;
    L11:
        MediaDescriptionCompatApi21.Builder.setExtras(r2, r3);
        if (r1 < 23) goto L14;
        MediaDescriptionCompatApi23.Builder.setMediaUri(r2, this.mMediaUri);
    L14:
        Object r4 = MediaDescriptionCompatApi21.Builder.build(r2);
        this.mDescriptionObj = r4;
        return r4;
    L7:
        if (this.mMediaUri == null) goto L11;
        if (r3 != null) goto L10;
        r3 = new Bundle();
        r3.putBoolean(DESCRIPTION_KEY_NULL_BUNDLE_FLAG, true);
    L10:
        r3.putParcelable(DESCRIPTION_KEY_MEDIA_URI, this.mMediaUri);
        goto L11
    L16:
        return r0;
    }

    public String toString() {
        return this.mTitle + ", " + this.mSubtitle + ", " + this.mDescription;
    }

    public CharSequence getDescription() {
        return this.mDescription;
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    public Bitmap getIconBitmap() {
        return this.mIcon;
    }

    public Uri getIconUri() {
        return this.mIconUri;
    }

    public String getMediaId() {
        return this.mMediaId;
    }

    public Uri getMediaUri() {
        return this.mMediaUri;
    }

    public CharSequence getSubtitle() {
        return this.mSubtitle;
    }

    public CharSequence getTitle() {
        return this.mTitle;
    }

    public MediaDescriptionCompat(Parcel r3) {
        this.mMediaId = r3.readString();
        this.mTitle = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(r3);
        this.mSubtitle = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(r3);
        this.mDescription = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(r3);
        ClassLoader r0 = MediaDescriptionCompat.class.getClassLoader();
        this.mIcon = (Bitmap) r3.readParcelable(r0);
        this.mIconUri = (Uri) r3.readParcelable(r0);
        this.mExtras = r3.readBundle(r0);
        this.mMediaUri = (Uri) r3.readParcelable(r0);
    }

    public static MediaDescriptionCompat fromMediaDescription(Object r9) {
        Bundle r0 = null;
        if (r9 == null) goto L24;
        int r1 = Build.VERSION.SDK_INT;
        Builder r2 = new Builder();
        r2.setMediaId(MediaDescriptionCompatApi21.getMediaId(r9));
        r2.setTitle(MediaDescriptionCompatApi21.getTitle(r9));
        r2.setSubtitle(MediaDescriptionCompatApi21.getSubtitle(r9));
        r2.setDescription(MediaDescriptionCompatApi21.getDescription(r9));
        r2.setIconBitmap(MediaDescriptionCompatApi21.getIconBitmap(r9));
        r2.setIconUri(MediaDescriptionCompatApi21.getIconUri(r9));
        Bundle r3 = MediaDescriptionCompatApi21.getExtras(r9);
        if (r3 == null) goto L7;
        MediaSessionCompat.ensureClassLoader(r3);
        Uri r5 = (Uri) r3.getParcelable(DESCRIPTION_KEY_MEDIA_URI);
    L8:
        if (r5 != null) goto L10;
    L15:
        r0 = r3;
    L16:
        r2.setExtras(r0);
        if (r5 == null) goto L20;
        r2.setMediaUri(r5);
    L22:
        MediaDescriptionCompat r4 = r2.build();
        r4.mDescriptionObj = r9;
        return r4;
    L20:
        if (r1 < 23) goto L22;
        r2.setMediaUri(MediaDescriptionCompatApi23.getMediaUri(r9));
        goto L22
    L10:
        if (r3.containsKey(DESCRIPTION_KEY_NULL_BUNDLE_FLAG) == true) goto L12;
    L14:
        r3.remove(DESCRIPTION_KEY_MEDIA_URI);
        r3.remove(DESCRIPTION_KEY_NULL_BUNDLE_FLAG);
        goto L15
    L12:
        if (r3.size() != 2) goto L14;
    L7:
        r5 = null;
        goto L8
    L24:
        return null;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        MediaDescriptionCompatApi21.writeToParcel(getMediaDescription(), r2, r3);
    }

    public MediaDescriptionCompat(String r1, CharSequence r2, CharSequence r3, CharSequence r4, Bitmap r5, Uri r6, Bundle r7, Uri r8) {
        this.mMediaId = r1;
        this.mTitle = r2;
        this.mSubtitle = r3;
        this.mDescription = r4;
        this.mIcon = r5;
        this.mIconUri = r6;
        this.mExtras = r7;
        this.mMediaUri = r8;
    }
}
