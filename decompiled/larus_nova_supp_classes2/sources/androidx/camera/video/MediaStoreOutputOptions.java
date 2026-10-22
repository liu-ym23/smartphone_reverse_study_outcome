package androidx.camera.video;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.location.Location;
import android.net.Uri;
import androidx.core.util.Preconditions;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class MediaStoreOutputOptions extends OutputOptions {
    public static final ContentValues EMPTY_CONTENT_VALUES = null;
    private final MediaStoreOutputOptionsInternal mMediaStoreOutputOptionsInternal;

    public static final class Builder extends OutputOptions.Builder<MediaStoreOutputOptions, Builder> {
        private final MediaStoreOutputOptionsInternal.Builder mInternalBuilder;

        @Override // androidx.camera.video.OutputOptions.Builder
        public MediaStoreOutputOptions build() {
            return new MediaStoreOutputOptions(this.mInternalBuilder.build());
        }

        @Override // androidx.camera.video.OutputOptions.Builder
        public /* bridge */ /* synthetic */ OutputOptions build() {
            return build();
        }

        public Builder setContentValues(ContentValues r2) {
            Preconditions.checkNotNull(r2, "Content values can't be null.");
            this.mInternalBuilder.setContentValues(r2);
            return this;
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [androidx.camera.video.MediaStoreOutputOptions$Builder, java.lang.Object] */
        @Override // androidx.camera.video.OutputOptions.Builder
        public /* bridge */ /* synthetic */ Builder setDurationLimitMillis(long r1) {
            return super.setDurationLimitMillis(r1);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [androidx.camera.video.MediaStoreOutputOptions$Builder, java.lang.Object] */
        @Override // androidx.camera.video.OutputOptions.Builder
        public /* bridge */ /* synthetic */ Builder setFileSizeLimit(long r1) {
            return super.setFileSizeLimit(r1);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [androidx.camera.video.MediaStoreOutputOptions$Builder, java.lang.Object] */
        @Override // androidx.camera.video.OutputOptions.Builder
        public /* bridge */ /* synthetic */ Builder setLocation(Location r1) {
            return super.setLocation(r1);
        }

        public Builder(ContentResolver r2, Uri r3) {
            super(new AutoValue_MediaStoreOutputOptions_MediaStoreOutputOptionsInternal.Builder());
            Preconditions.checkNotNull(r2, "Content resolver can't be null.");
            Preconditions.checkNotNull(r3, "Collection Uri can't be null.");
            MediaStoreOutputOptionsInternal.Builder r0 = (MediaStoreOutputOptionsInternal.Builder) this.mRootInternalBuilder;
            this.mInternalBuilder = r0;
            r0.setContentResolver(r2).setCollectionUri(r3).setContentValues(MediaStoreOutputOptions.EMPTY_CONTENT_VALUES);
        }
    }

    public static abstract class MediaStoreOutputOptionsInternal extends OutputOptions.OutputOptionsInternal {

        public static abstract class Builder extends OutputOptions.OutputOptionsInternal.Builder<Builder> {
            @Override // androidx.camera.video.OutputOptions.OutputOptionsInternal.Builder
            public abstract MediaStoreOutputOptionsInternal build();

            public abstract Builder setCollectionUri(Uri r1);

            public abstract Builder setContentResolver(ContentResolver r1);

            public abstract Builder setContentValues(ContentValues r1);

            @Override // androidx.camera.video.OutputOptions.OutputOptionsInternal.Builder
            public /* bridge */ /* synthetic */ OutputOptions.OutputOptionsInternal build() {
                return build();
            }

            public Builder() {
            }
        }

        public abstract Uri getCollectionUri();

        public abstract ContentResolver getContentResolver();

        public abstract ContentValues getContentValues();

        public MediaStoreOutputOptionsInternal() {
        }
    }

    static {
        EMPTY_CONTENT_VALUES = new ContentValues();
    }

    public Uri getCollectionUri() {
        return this.mMediaStoreOutputOptionsInternal.getCollectionUri();
    }

    public ContentResolver getContentResolver() {
        return this.mMediaStoreOutputOptionsInternal.getContentResolver();
    }

    public ContentValues getContentValues() {
        return this.mMediaStoreOutputOptionsInternal.getContentValues();
    }

    public int hashCode() {
        return this.mMediaStoreOutputOptionsInternal.hashCode();
    }

    public String toString() {
        return this.mMediaStoreOutputOptionsInternal.toString().replaceFirst("MediaStoreOutputOptionsInternal", "MediaStoreOutputOptions");
    }

    public MediaStoreOutputOptions(MediaStoreOutputOptionsInternal r1) {
        super(r1);
        this.mMediaStoreOutputOptionsInternal = r1;
    }

    public boolean equals(Object r2) {
        if (this != r2) goto L6;
        return true;
    L6:
        if ((r2 instanceof MediaStoreOutputOptions) == true) goto L10;
        return false;
    L10:
        return this.mMediaStoreOutputOptionsInternal.equals(((MediaStoreOutputOptions) r2).mMediaStoreOutputOptionsInternal);
    }
}
