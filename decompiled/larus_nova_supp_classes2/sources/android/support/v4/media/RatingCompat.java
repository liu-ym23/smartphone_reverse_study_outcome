package android.support.v4.media;

import android.media.Rating;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.compose.material3.MenuKt;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class RatingCompat implements Parcelable {
    public static final Parcelable.Creator<RatingCompat> CREATOR = null;
    public static final int RATING_3_STARS = 3;
    public static final int RATING_4_STARS = 4;
    public static final int RATING_5_STARS = 5;
    public static final int RATING_HEART = 1;
    public static final int RATING_NONE = 0;
    private static final float RATING_NOT_RATED = -1.0f;
    public static final int RATING_PERCENTAGE = 6;
    public static final int RATING_THUMB_UP_DOWN = 2;
    private static final String TAG = "Rating";
    private Object mRatingObj;
    private final int mRatingStyle;
    private final float mRatingValue;

    @Retention(RetentionPolicy.SOURCE)
    public @interface StarStyle {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Style {
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public float getPercentRating() {
        if (this.mRatingStyle == 6) goto L5;
        return RATING_NOT_RATED;
    L5:
        if (isRated() == true) goto L8;
        return RATING_NOT_RATED;
    L8:
        return this.mRatingValue;
    }

    public Object getRating() {
        if (this.mRatingObj != null) goto L16;
        if (isRated() == false) goto L14;
        int r0 = this.mRatingStyle;
        switch(r0) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L11;
            case 5: goto L11;
            case 6: goto L10;
            default: goto L8;
        };
    L8:
        return null;
    L10:
        this.mRatingObj = Rating.newPercentageRating(getPercentRating());
        goto L16
    L11:
        this.mRatingObj = Rating.newStarRating(r0, getStarRating());
        goto L16
    L12:
        this.mRatingObj = Rating.newThumbRating(isThumbUp());
        goto L16
    L13:
        this.mRatingObj = Rating.newHeartRating(hasHeart());
        goto L16
    L14:
        this.mRatingObj = Rating.newUnratedRating(this.mRatingStyle);
    L16:
        return this.mRatingObj;
    }

    public float getStarRating() {
        int r0 = this.mRatingStyle;
        if (r0 == 3) goto L10;
        if (r0 == 4) goto L10;
        if (r0 == 5) goto L10;
        return RATING_NOT_RATED;
    L10:
        if (isRated() == true) goto L12;
        return RATING_NOT_RATED;
    L12:
        return this.mRatingValue;
    }

    public boolean hasHeart() {
        if (this.mRatingStyle == 1) goto L6;
        return false;
    L6:
        if (this.mRatingValue != 1.0f) goto L9;
        return true;
    L9:
        return false;
    }

    public boolean isRated() {
        if (this.mRatingValue < MenuKt.ClosedAlphaTarget) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isThumbUp() {
        if (this.mRatingStyle == 2) goto L6;
        return false;
    L6:
        if (this.mRatingValue != 1.0f) goto L9;
        return true;
    L9:
        return false;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("Rating:style=");
        r0.append(this.mRatingStyle);
        r0.append(" rating=");
        float r1 = this.mRatingValue;
        if (r1 >= MenuKt.ClosedAlphaTarget) goto L5;
        String r2 = "unrated";
    L6:
        r0.append(r2);
        return r0.toString();
    L5:
        r2 = String.valueOf(r1);
        goto L6
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return this.mRatingStyle;
    }

    public int getRatingStyle() {
        return this.mRatingStyle;
    }

    public static RatingCompat fromRating(Object r4) {
        RatingCompat r0 = null;
        if (r4 == null) goto L14;
        Rating r1 = (Rating) r4;
        int r2 = r1.getRatingStyle();
        if (r1.isRated() == false) goto L12;
        switch(r2) {
            case 1: goto L11;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L9;
            case 5: goto L9;
            case 6: goto L8;
            default: goto L7;
        };
    L7:
        return null;
    L8:
        r0 = newPercentageRating(r1.getPercentRating());
    L13:
        r0.mRatingObj = r4;
        goto L14
    L9:
        r0 = newStarRating(r2, r1.getStarRating());
        goto L13
    L10:
        r0 = newThumbRating(r1.isThumbUp());
        goto L13
    L11:
        r0 = newHeartRating(r1.hasHeart());
        goto L13
    L12:
        r0 = newUnratedRating(r2);
    L14:
        return r0;
    }

    public static RatingCompat newHeartRating(boolean r2) {
        if (r2 == false) goto L5;
        float r3 = 1.0f;
    L7:
        return new RatingCompat(1, r3);
    L5:
        r3 = MenuKt.ClosedAlphaTarget;
        goto L7
    }

    public static RatingCompat newPercentageRating(float r2) {
        if (r2 >= MenuKt.ClosedAlphaTarget) goto L5;
        return null;
    L5:
        if (r2 <= 100.0f) goto L8;
        return null;
    L8:
        return new RatingCompat(6, r2);
    }

    public static RatingCompat newThumbRating(boolean r2) {
        if (r2 == false) goto L5;
        float r3 = 1.0f;
    L7:
        return new RatingCompat(2, r3);
    L5:
        r3 = MenuKt.ClosedAlphaTarget;
        goto L7
    }

    public static RatingCompat newUnratedRating(int r2) {
        switch(r2) {
            case 1: goto L6;
            case 2: goto L6;
            case 3: goto L6;
            case 4: goto L6;
            case 5: goto L6;
            case 6: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L6:
        return new RatingCompat(r2, RATING_NOT_RATED);
    }

    public RatingCompat(int r1, float r2) {
        this.mRatingStyle = r1;
        this.mRatingValue = r2;
    }

    public static RatingCompat newStarRating(int r3, float r4) {
        if (r3 != 3) goto L5;
        float r0 = 3.0f;
    L14:
        if (r4 >= MenuKt.ClosedAlphaTarget) goto L16;
    L20:
        return null;
    L16:
        if (r4 > r0) goto L20;
        return new RatingCompat(r3, r4);
    L5:
        if (r3 != 4) goto L7;
        r0 = 4.0f;
        goto L14
    L7:
        if (r3 != 5) goto L9;
        r0 = 5.0f;
        goto L14
    L9:
        return null;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(this.mRatingStyle);
        r1.writeFloat(this.mRatingValue);
    }
}
