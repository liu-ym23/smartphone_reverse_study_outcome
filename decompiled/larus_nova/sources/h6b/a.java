package h6b;

import android.content.Context;
import com.larksuite.component.ui.display.manager.zoom.LarkFont;
import com.larksuite.component.ui.display.manager.zoom.ZoomLevel6;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.export.entity.preview.FontLevel;
import com.ss.android.lark.export.entity.preview.FontType;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f483930a = 0;

    /* JADX INFO: renamed from: h6b.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C6107a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f483931a = null;

        static {
            int[] r100 = new int[FontType.values().length];
            r100[FontType.TITLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[FontType.HEADLINE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[FontType.BODY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f483931a = r100;
        }
    }

    static {
    }

    public static boolean a(FontLevel r100) {
        if (r100 == null) goto L5;
        FontType r101 = r100.getType();
        if (r101 == null) goto L5;
    L7:
        if (r100 == null) goto L9;
        int r102 = r100.getLevel();
    L10:
        int r103 = C6107a.f483931a[r101.ordinal()];
        if (r103 != 1) goto L13;
    L27:
        return true;
    L13:
        if (r103 == 2) goto L27;
        if (r103 == 3) goto L22;
        if (r102 == 0) goto L20;
        if (r102 == 1) goto L28;
        if (r102 == 2) goto L20;
        return false;
    L28:
        return false;
    L20:
        return true;
    L22:
        if (r102 == 0) goto L30;
        if (r102 != 1) goto L31;
        return true;
    L31:
        return false;
    L30:
        return false;
    L9:
        r102 = 0;
    L5:
        r101 = FontType.CAPTION;
        goto L7
    }

    public static LarkFont b(FontType r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        int r102 = C6107a.f483931a[r100.ordinal()];
        if (r102 == 1) goto L22;
        if (r102 == 2) goto L30;
        if (r102 == 3) goto L15;
        if (r101 == 0) goto L26;
        if (r101 == 1) goto L25;
        if (r101 == 2) goto L24;
        return LarkFont.CAPTION3;
    L24:
        return LarkFont.CAPTION2;
    L25:
        return LarkFont.CAPTION1;
    L26:
        return LarkFont.CAPTION0;
    L15:
        if (r101 == 0) goto L29;
        if (r101 == 1) goto L28;
        return LarkFont.BODY2;
    L28:
        return LarkFont.BODY1;
    L29:
        return LarkFont.BODY0;
    L30:
        return LarkFont.HEADLINE;
    L22:
        return LarkFont.TITLE4;
    }

    public static float c(Context r100, FontLevel r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r101 == null) goto L6;
        FontType r102 = r101.getType();
        if (r102 == null) goto L6;
    L7:
        if (r101 == null) goto L9;
        int r103 = r101.getLevel();
    L10:
        LarkFont r104 = b(r102, r103);
        ZoomLevel6 r105 = zz7.b.f574096a;
        Intrinsics.checkNotNullParameter(r104, "larkFont");
        return UIUtils.dp2px(r100, zz7.b.b(r104, zz7.b.d()));
    L9:
        r103 = 0;
    L6:
        r102 = FontType.CAPTION;
        goto L7
    }
}
