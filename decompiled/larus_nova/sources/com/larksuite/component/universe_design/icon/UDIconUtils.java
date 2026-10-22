package com.larksuite.component.universe_design.icon;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.appcompat.content.res.AppCompatResources;
import com.larksuite.component.universe_design.dimension.UDDimension;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\tH\u0007J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0007J,\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\tH\u0007J$\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0001\u0010\n\u001a\u00020\tH\u0007J\"\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\fH\u0007J,\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0001\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u001a\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002¨\u0006\u0011"}, d2 = {"Lcom/larksuite/component/universe_design/icon/UDIconUtils;", "", "<init>", "()V", "getIconDrawable", "Landroid/graphics/drawable/Drawable;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "drawableRes", "", "color", "size", "Lcom/larksuite/component/universe_design/dimension/UDDimension;", "getIconDrawableByToken", "token", "", "translateTokenToIdentifier", "universe-ui-icon_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UDIconUtils {
    public static final int $stable = 0;
    public static final UDIconUtils INSTANCE = null;

    static {
        INSTANCE = new UDIconUtils();
    }

    private UDIconUtils() {
    }

    private final String translateTokenToIdentifier(String r100) {
        return "ud_icon" + StringsKt.replace$default(r100, '-', '_', false, 4, null);
    }

    @JvmStatic
    public static final Drawable getIconDrawable(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Drawable r102 = AppCompatResources.getDrawable(r100, r101);
        if (r102 == null) goto L6;
        return r102;
    L6:
        throw new Resources.NotFoundException("Resource ID #0x" + Integer.toHexString(r101));
    }

    @JvmStatic
    public static final Drawable getIconDrawableByToken(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "token");
        int r102 = r100.getResources().getIdentifier(INSTANCE.translateTokenToIdentifier(r101), "drawable", r100.getPackageName());
        if (r102 != 0) goto L7;
        return null;
    L7:
        return getIconDrawable(r100, r102);
    }

    @JvmStatic
    public static final Drawable getIconDrawable(Context r100, int r101, UDDimension r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "size");
        Drawable r103 = getIconDrawable(r100, r101);
        r103.mutate();
        int r104 = (int) r102.toPixels(r100);
        r103.setBounds(0, 0, r104, r104);
        return r103;
    }

    @JvmStatic
    public static final Drawable getIconDrawableByToken(Context r100, String r101, UDDimension r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "token");
        Intrinsics.checkNotNullParameter(r102, "size");
        Drawable r103 = getIconDrawableByToken(r100, r101);
        if (r103 == null) goto L5;
        r103.mutate();
        int r104 = (int) r102.toPixels(r100);
        r103.setBounds(0, 0, r104, r104);
        return r103;
    L5:
        return null;
    }

    @JvmStatic
    public static final Drawable getIconDrawable(Context r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Drawable r103 = getIconDrawable(r100, r101);
        r103.mutate();
        r103.setTint(r102);
        return r103;
    }

    @JvmStatic
    public static final Drawable getIconDrawableByToken(Context r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "token");
        Drawable r103 = getIconDrawableByToken(r100, r101);
        if (r103 == null) goto L5;
        r103.mutate();
        r103.setTint(r102);
        return r103;
    L5:
        return null;
    }

    @JvmStatic
    public static final Drawable getIconDrawable(Context r100, int r101, int r102, UDDimension r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r103, "size");
        Drawable r104 = getIconDrawable(r100, r101);
        r104.mutate();
        r104.setTint(r102);
        int r105 = (int) r103.toPixels(r100);
        r104.setBounds(0, 0, r105, r105);
        return r104;
    }

    @JvmStatic
    public static final Drawable getIconDrawableByToken(Context r100, String r101, int r102, UDDimension r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "token");
        Intrinsics.checkNotNullParameter(r103, "size");
        Drawable r104 = getIconDrawableByToken(r100, r101);
        if (r104 == null) goto L5;
        r104.mutate();
        r104.setTint(r102);
        int r105 = (int) r103.toPixels(r100);
        r104.setBounds(0, 0, r105, r105);
        return r104;
    L5:
        return null;
    }
}
