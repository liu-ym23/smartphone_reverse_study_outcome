package com.bytedance.locallife.live.util;

import android.graphics.Typeface;
import androidx.core.content.res.ResourcesCompat;
import com.larus.nova.R;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: classes21.dex */
public final class FontUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Typeface f260647a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Typeface f260648b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Typeface f260649c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f260650d = null;

    static {
        Typeface r100 = ResourcesCompat.getFont(LiveLifeSaaSUtil.p(), R.font.douyin_number_medium);     // Catch: Exception -> L5
    L6:
        f260647a = r100;
        Typeface r101 = ResourcesCompat.getFont(LiveLifeSaaSUtil.p(), R.font.douyin_number_bold);     // Catch: Exception -> L9
    L10:
        f260648b = r101;
        Typeface r102 = ResourcesCompat.getFont(LiveLifeSaaSUtil.p(), R.font.douyin_number_extra_bold);     // Catch: Exception -> L13
    L14:
        f260649c = r102;
        f260650d = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, FontUtil$DouyinSans$2.INSTANCE);
        return;
    L13:
        r102 = Typeface.DEFAULT;
    L9:
        r101 = Typeface.DEFAULT;
    L5:
        r100 = Typeface.DEFAULT;
        goto L6
    }
}
