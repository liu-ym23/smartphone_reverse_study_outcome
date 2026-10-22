package com.facebook.drawee.interfaces;

import android.graphics.drawable.Drawable;
import com.facebook.drawee.drawable.ScalingUtils;

/* JADX INFO: loaded from: classes23.dex */
public interface DraweePlaceHolderConfig {
    Drawable getFailureDrawable();

    int getFailureImageColorRes();

    int getFailureImageDrawableRes();

    ScalingUtils.ScaleType getFailureScaleType();

    Drawable getPlaceHolderDrawable();

    int getPlaceHolderImageColorRes();

    int getPlaceHolderImageDrawableRes();

    ScalingUtils.ScaleType getPlaceHolderScaleType();
}
