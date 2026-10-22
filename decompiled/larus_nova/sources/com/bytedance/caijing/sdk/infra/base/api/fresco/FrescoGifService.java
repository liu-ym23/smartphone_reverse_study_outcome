package com.bytedance.caijing.sdk.infra.base.api.fresco;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.bytedance.caijing.sdk.infra.base.core.di.ICJService;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import vd4.b;
import vd4.c;
import vd4.d;
import we4.a;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J\u001c\u0010\n\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\f\u001a\u00020\u000bH&JB\u0010\u0017\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H&J\u0012\u0010\u0018\u001a\u00020\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u001c\u0010\u0018\u001a\u00020\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H&J\u0018\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001bH&J(\u0010 \u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u000e\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u001dH&J\u001a\u0010\"\u001a\u0004\u0018\u00010!2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&J \u0010&\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020%H&J*\u0010'\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0016\u001a\u00020%H&¨\u0006("}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/fresco/FrescoGifService;", "Lcom/bytedance/caijing/sdk/infra/base/core/di/ICJService;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "", "frescoInitialize", "", "url", "", "cacheExist", "preLoad", "", "resId", "Landroid/net/Uri;", "buildUriFromFresco", "Landroid/widget/ImageView;", "gifView", "uri", "Landroid/graphics/drawable/Drawable;", "placeholderDrawable", "loopCount", "Lvd4/a;", "listener", "startGif", "getSimpleDraweeView", "Landroid/widget/ImageView$ScaleType;", "scaleType", "Lvd4/d;", "options", "Lwe4/a;", "Lvd4/c;", "callback", "downloadImage", "Landroid/graphics/Bitmap;", "getCacheImageWithUrl", "view", "imageUrl", "Lvd4/b;", "loadImage", "loadCircleImage", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0})
public interface FrescoGifService extends ICJService {
    Uri buildUriFromFresco(int r100);

    boolean cacheExist(String r100);

    void downloadImage(Context r100, String r101, a<c> r102);

    void frescoInitialize(Context r100);

    Bitmap getCacheImageWithUrl(Context r100, String r101);

    ImageView getSimpleDraweeView(Context r100);

    ImageView getSimpleDraweeView(Context r100, ImageView.ScaleType r101);

    ImageView getSimpleDraweeView(Context r100, d r101);

    void loadCircleImage(ImageView r100, String r101, Drawable r102, b r103);

    void loadImage(ImageView r100, String r101, b r102);

    void preLoad(Context r100, String r101);

    void startGif(Context r100, ImageView r101, Uri r102, Drawable r103, int r104, vd4.a r105);
}
