package android.support.v4.media;

import android.graphics.Bitmap;
import android.media.MediaMetadata;
import android.media.Rating;
import android.os.Parcel;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
class MediaMetadataCompatApi21 {

    public static class Builder {
        public static Object newInstance() {
            return new MediaMetadata.Builder();
        }

        private Builder() {
        }

        public static Object build(Object r0) {
            return ((MediaMetadata.Builder) r0).build();
        }

        public static void putBitmap(Object r0, String r1, Bitmap r2) {
            ((MediaMetadata.Builder) r0).putBitmap(r1, r2);
        }

        public static void putLong(Object r0, String r1, long r2) {
            ((MediaMetadata.Builder) r0).putLong(r1, r2);
        }

        public static void putRating(Object r0, String r1, Object r2) {
            ((MediaMetadata.Builder) r0).putRating(r1, (Rating) r2);
        }

        public static void putString(Object r0, String r1, String r2) {
            ((MediaMetadata.Builder) r0).putString(r1, r2);
        }

        public static void putText(Object r0, String r1, CharSequence r2) {
            ((MediaMetadata.Builder) r0).putText(r1, r2);
        }
    }

    private MediaMetadataCompatApi21() {
    }

    public static Object createFromParcel(Parcel r1) {
        return MediaMetadata.CREATOR.createFromParcel(r1);
    }

    public static Set<String> keySet(Object r0) {
        return ((MediaMetadata) r0).keySet();
    }

    public static Bitmap getBitmap(Object r0, String r1) {
        return ((MediaMetadata) r0).getBitmap(r1);
    }

    public static long getLong(Object r0, String r1) {
        return ((MediaMetadata) r0).getLong(r1);
    }

    public static Object getRating(Object r0, String r1) {
        return ((MediaMetadata) r0).getRating(r1);
    }

    public static CharSequence getText(Object r0, String r1) {
        return ((MediaMetadata) r0).getText(r1);
    }

    public static void writeToParcel(Object r0, Parcel r1, int r2) {
        ((MediaMetadata) r0).writeToParcel(r1, r2);
    }
}
