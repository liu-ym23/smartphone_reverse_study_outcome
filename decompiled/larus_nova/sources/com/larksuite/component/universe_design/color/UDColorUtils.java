package com.larksuite.component.universe_design.color;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.util.TypedValue;
import androidx.collection.LruCache;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\u000b2\b\b\u0001\u0010\r\u001a\u00020\u000eH\u0007J$\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0001\u0010\u0011\u001a\u00020\u000b2\b\b\u0001\u0010\r\u001a\u00020\u000eH\u0007J\u001a\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0001\u0010\u0011\u001a\u00020\u000bH\u0007J\u001a\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0001\u0010\u0015\u001a\u00020\u000bH\u0007J$\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0001\u0010\u0017\u001a\u00020\u000b2\b\b\u0001\u0010\r\u001a\u00020\u000eH\u0007J\u001a\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0001\u0010\u0017\u001a\u00020\u000bH\u0007J\u001e\u0010\u0018\u001a\u00020\u000b2\n\u0010\u0019\u001a\u00060\u001aR\u00020\u001b2\b\b\u0001\u0010\u001c\u001a\u00020\u000bH\u0007J\u0018\u0010#\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u001fH\u0007J\u0010\u0010%\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\u001fH\u0003R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R'\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u000b0\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\t\u001a\u0004\b \u0010!¨\u0006&"}, d2 = {"Lcom/larksuite/component/universe_design/color/UDColorUtils;", "", "<init>", "()V", "sTmpValue", "Landroid/util/TypedValue;", "getSTmpValue", "()Landroid/util/TypedValue;", "sTmpValue$delegate", "Lkotlin/Lazy;", "getAlphaColor", "", "baseColor", "alpha", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "baseColorId", "getColor", "getColorStateList", "Landroid/content/res/ColorStateList;", "colorId", "getAttrAlphaColor", "attrRes", "getAttrColor", "theme", "Landroid/content/res/Resources$Theme;", "Landroid/content/res/Resources;", SlcElement.KEY_ATTR, "tokenIdCache", "Landroidx/collection/LruCache;", "", "getTokenIdCache", "()Landroidx/collection/LruCache;", "tokenIdCache$delegate", "getColorIdByToken", "token", "convertToken", "universe-ui-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UDColorUtils {
    public static final int $stable = 0;
    public static final UDColorUtils INSTANCE = null;
    private static final Lazy sTmpValue$delegate = null;
    private static final Lazy tokenIdCache$delegate = null;

    private UDColorUtils() {
    }

    static {
        INSTANCE = new UDColorUtils();
        sTmpValue$delegate = LazyKt.lazy(UDColorUtils$sTmpValue$2.INSTANCE);
        tokenIdCache$delegate = LazyKt.lazy(UDColorUtils$tokenIdCache$2.INSTANCE);
        $stable = 8;
    }

    private final TypedValue getSTmpValue() {
        return (TypedValue) sTmpValue$delegate.getValue();
    }

    private final LruCache<String, Integer> getTokenIdCache() {
        return (LruCache) tokenIdCache$delegate.getValue();
    }

    @JvmStatic
    private static final String convertToken(String r100) {
        return StringsKt.replace$default(r100, "-", "_", false, 4, null);
    }

    @JvmStatic
    public static final int getAlphaColor(int r100, float r101) {
        return Color.argb((int) (255 * r101), Color.red(r100), Color.green(r100), Color.blue(r100));
    }

    @JvmStatic
    public static final int getAttrColor(Resources.Theme r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "theme");
        UDColorUtils r102 = INSTANCE;
        if (r100.resolveAttribute(r101, r102.getSTmpValue(), true) == true) goto L7;
        return 0;
    L7:
        if (r102.getSTmpValue().type != 2) goto L10;
        return getAttrColor(r100, r102.getSTmpValue().data);
    L10:
        return r102.getSTmpValue().data;
    }

    @JvmStatic
    public static final int getColor(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return r100.getResources().getColor(r101);
    }

    @JvmStatic
    public static final int getColorIdByToken(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "token");
        UDColorUtils r102 = INSTANCE;
        Integer r103 = r102.getTokenIdCache().get(r101);
        if (r103 != null) goto L5;
        String r104 = convertToken(r101);
        String r105 = r100.getPackageName();
        int r106 = r100.getResources().getIdentifier(r104, "color", r105);
        r102.getTokenIdCache().put(r101, Integer.valueOf(r106));
        return r106;
    L5:
        return r103.intValue();
    }

    @JvmStatic
    public static final ColorStateList getColorStateList(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (Build.VERSION.SDK_INT < 23) goto L5;
        ColorStateList r102 = r100.getResources().getColorStateList(r101, r100.getTheme());
        Intrinsics.checkNotNull(r102);
        return r102;
    L5:
        ColorStateList r103 = r100.getResources().getColorStateList(r101);
        Intrinsics.checkNotNull(r103);
        return r103;
    }

    @JvmStatic
    public static final int getAttrColor(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return getAttrColor(r100.getTheme(), r101);
    }

    @JvmStatic
    public static final int getAlphaColor(Context r100, int r101, float r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return getAlphaColor(r100.getResources().getColor(r101), r102);
    }

    @JvmStatic
    public static final int getAttrAlphaColor(Context r100, int r101, float r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return getAlphaColor(getAttrColor(r100, r101), r102);
    }
}
