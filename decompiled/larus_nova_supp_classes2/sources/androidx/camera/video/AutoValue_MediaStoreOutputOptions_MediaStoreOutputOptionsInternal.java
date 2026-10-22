package androidx.camera.video;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.location.Location;
import android.net.Uri;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class AutoValue_MediaStoreOutputOptions_MediaStoreOutputOptionsInternal extends MediaStoreOutputOptions.MediaStoreOutputOptionsInternal {
    private final Uri collectionUri;
    private final ContentResolver contentResolver;
    private final ContentValues contentValues;
    private final long durationLimitMillis;
    private final long fileSizeLimit;
    private final Location location;

    /* JADX INFO: renamed from: androidx.camera.video.AutoValue_MediaStoreOutputOptions_MediaStoreOutputOptionsInternal$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder extends MediaStoreOutputOptions.MediaStoreOutputOptionsInternal.Builder {
        private Uri collectionUri;
        private ContentResolver contentResolver;
        private ContentValues contentValues;
        private Long durationLimitMillis;
        private Long fileSizeLimit;
        private Location location;

        @Override // androidx.camera.video.MediaStoreOutputOptions.MediaStoreOutputOptionsInternal.Builder, androidx.camera.video.OutputOptions.OutputOptionsInternal.Builder
        public MediaStoreOutputOptions.MediaStoreOutputOptionsInternal build() {
            if (this.fileSizeLimit != null) goto L5;
            String r0 = " fileSizeLimit";
        L7:
            if (this.durationLimitMillis != null) goto L10;
            r0 = r0 + " durationLimitMillis";
        L10:
            if (this.contentResolver != null) goto L13;
            r0 = r0 + " contentResolver";
        L13:
            if (this.collectionUri != null) goto L16;
            r0 = r0 + " collectionUri";
        L16:
            if (this.contentValues != null) goto L19;
            r0 = r0 + " contentValues";
        L19:
            if (r0.isEmpty() == false) goto L23;
            return new AutoValue_MediaStoreOutputOptions_MediaStoreOutputOptionsInternal(this.fileSizeLimit.longValue(), this.durationLimitMillis.longValue(), this.location, this.contentResolver, this.collectionUri, this.contentValues, null);
        L23:
            throw new IllegalStateException("Missing required properties:".concat(r0));
        L5:
            r0 = "";
            goto L7
        }

        public Builder() {
        }

        @Override // androidx.camera.video.MediaStoreOutputOptions.MediaStoreOutputOptionsInternal.Builder, androidx.camera.video.OutputOptions.OutputOptionsInternal.Builder
        public /* bridge */ /* synthetic */ OutputOptions.OutputOptionsInternal build() {
            return build();
        }

        @Override // androidx.camera.video.MediaStoreOutputOptions.MediaStoreOutputOptionsInternal.Builder
        public MediaStoreOutputOptions.MediaStoreOutputOptionsInternal.Builder setCollectionUri(Uri r2) {
            if (r2 == null) goto L6;
            this.collectionUri = r2;
            return this;
        L6:
            throw new NullPointerException("Null collectionUri");
        }

        @Override // androidx.camera.video.MediaStoreOutputOptions.MediaStoreOutputOptionsInternal.Builder
        public MediaStoreOutputOptions.MediaStoreOutputOptionsInternal.Builder setContentResolver(ContentResolver r2) {
            if (r2 == null) goto L6;
            this.contentResolver = r2;
            return this;
        L6:
            throw new NullPointerException("Null contentResolver");
        }

        @Override // androidx.camera.video.MediaStoreOutputOptions.MediaStoreOutputOptionsInternal.Builder
        public MediaStoreOutputOptions.MediaStoreOutputOptionsInternal.Builder setContentValues(ContentValues r2) {
            if (r2 == null) goto L6;
            this.contentValues = r2;
            return this;
        L6:
            throw new NullPointerException("Null contentValues");
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.video.OutputOptions.OutputOptionsInternal.Builder
        public MediaStoreOutputOptions.MediaStoreOutputOptionsInternal.Builder setDurationLimitMillis(long r1) {
            this.durationLimitMillis = Long.valueOf(r1);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.video.OutputOptions.OutputOptionsInternal.Builder
        public MediaStoreOutputOptions.MediaStoreOutputOptionsInternal.Builder setFileSizeLimit(long r1) {
            this.fileSizeLimit = Long.valueOf(r1);
            return this;
        }

        @Override // androidx.camera.video.OutputOptions.OutputOptionsInternal.Builder
        public /* bridge */ /* synthetic */ MediaStoreOutputOptions.MediaStoreOutputOptionsInternal.Builder setLocation(Location r1) {
            return setLocation(r1);
        }

        @Override // androidx.camera.video.OutputOptions.OutputOptionsInternal.Builder
        public /* bridge */ /* synthetic */ MediaStoreOutputOptions.MediaStoreOutputOptionsInternal.Builder setDurationLimitMillis(long r1) {
            return setDurationLimitMillis(r1);
        }

        @Override // androidx.camera.video.OutputOptions.OutputOptionsInternal.Builder
        public /* bridge */ /* synthetic */ MediaStoreOutputOptions.MediaStoreOutputOptionsInternal.Builder setFileSizeLimit(long r1) {
            return setFileSizeLimit(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.video.OutputOptions.OutputOptionsInternal.Builder
        public MediaStoreOutputOptions.MediaStoreOutputOptionsInternal.Builder setLocation(Location r1) {
            this.location = r1;
            return this;
        }
    }

    public int hashCode() {
        long r0 = this.fileSizeLimit;
        int r1 = (((int) (r0 ^ (r0 >>> 32))) ^ 1000003) * 1000003;
        long r3 = this.durationLimitMillis;
        int r2 = (r1 ^ ((int) ((r3 >>> 32) ^ r3))) * 1000003;
        Location r4 = this.location;
        if (r4 != null) goto L5;
        int r5 = 0;
    L6:
        int r6 = (((((r2 ^ r5) * 1000003) ^ this.contentResolver.hashCode()) * 1000003) ^ this.collectionUri.hashCode()) * 1000003;
        return this.contentValues.hashCode() ^ r6;
    L5:
        r5 = r4.hashCode();
        goto L6
    }

    public String toString() {
        return "MediaStoreOutputOptionsInternal{fileSizeLimit=" + this.fileSizeLimit + ", durationLimitMillis=" + this.durationLimitMillis + ", location=" + this.location + ", contentResolver=" + this.contentResolver + ", collectionUri=" + this.collectionUri + ", contentValues=" + this.contentValues + "}";
    }

    @Override // androidx.camera.video.MediaStoreOutputOptions.MediaStoreOutputOptionsInternal
    public Uri getCollectionUri() {
        return this.collectionUri;
    }

    @Override // androidx.camera.video.MediaStoreOutputOptions.MediaStoreOutputOptionsInternal
    public ContentResolver getContentResolver() {
        return this.contentResolver;
    }

    @Override // androidx.camera.video.MediaStoreOutputOptions.MediaStoreOutputOptionsInternal
    public ContentValues getContentValues() {
        return this.contentValues;
    }

    @Override // androidx.camera.video.OutputOptions.OutputOptionsInternal
    public long getDurationLimitMillis() {
        return this.durationLimitMillis;
    }

    @Override // androidx.camera.video.OutputOptions.OutputOptionsInternal
    public long getFileSizeLimit() {
        return this.fileSizeLimit;
    }

    @Override // androidx.camera.video.OutputOptions.OutputOptionsInternal
    public Location getLocation() {
        return this.location;
    }

    public boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof MediaStoreOutputOptions.MediaStoreOutputOptionsInternal) == false) goto L27;
        MediaStoreOutputOptions.MediaStoreOutputOptionsInternal r9 = (MediaStoreOutputOptions.MediaStoreOutputOptionsInternal) r8;
        if (this.fileSizeLimit == r9.getFileSizeLimit()) goto L10;
    L25:
        return false;
    L10:
        if (this.durationLimitMillis != r9.getDurationLimitMillis()) goto L25;
        Location r1 = this.location;
        if (r1 != null) goto L17;
        if (r9.getLocation() != null) goto L25;
    L19:
        if (this.contentResolver.equals(r9.getContentResolver()) == false) goto L25;
        if (this.collectionUri.equals(r9.getCollectionUri()) == false) goto L25;
        if (this.contentValues.equals(r9.getContentValues()) == false) goto L25;
        return true;
    L17:
        if (r1.equals(r9.getLocation()) == false) goto L25;
    L27:
        return false;
    }

    private AutoValue_MediaStoreOutputOptions_MediaStoreOutputOptionsInternal(long r1, long r3, Location r5, ContentResolver r6, Uri r7, ContentValues r8) {
        this.fileSizeLimit = r1;
        this.durationLimitMillis = r3;
        this.location = r5;
        this.contentResolver = r6;
        this.collectionUri = r7;
        this.contentValues = r8;
    }

    public /* synthetic */ AutoValue_MediaStoreOutputOptions_MediaStoreOutputOptionsInternal(long r1, long r3, Location r5, ContentResolver r6, Uri r7, ContentValues r8, AnonymousClass1 r9) {
        this(r1, r3, r5, r6, r7, r8);
    }
}
