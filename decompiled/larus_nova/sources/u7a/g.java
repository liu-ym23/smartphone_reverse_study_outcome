package u7a;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.text.TextUtils;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableType;
import com.lynx.tasm.base.LLog;

/* JADX INFO: loaded from: classes32.dex */
public final class g {

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f549107a = null;

        static {
            int[] r100 = new int[Bitmap.Config.values().length];
            f549107a = r100;
            r100[Bitmap.Config.ARGB_8888.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            f549107a[Bitmap.Config.ALPHA_8.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            f549107a[Bitmap.Config.ARGB_4444.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            f549107a[Bitmap.Config.RGB_565.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f549108a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f549109b;

        public b() {
            this.f549108a = false;
            this.f549109b = false;
        }
    }

    public static b b(f6a.a r100) {
        b r101 = new b();
        if (r100 != null) goto L5;
        r101.f549108a = false;
    L27:
        return r101;
    L5:
        ReadableType r102 = r100.getType();
        if (r102 != ReadableType.Boolean) goto L9;
        r101.f549108a = r100.asBoolean();
        r101.f549109b = false;
        goto L27
    L9:
        if (r102 != ReadableType.String) goto L27;
        String r103 = r100.asString();
        if (TextUtils.isEmpty(r103) == false) goto L13;
    L26:
        r101.f549108a = false;
        r101.f549109b = false;
        goto L27
    L13:
        if ("none".equals(r103) == true) goto L26;
        if ("false".equals(r103) == true) goto L26;
        if ("default".equals(r103) == false) goto L20;
    L25:
        r101.f549108a = true;
        r101.f549109b = false;
        goto L27
    L20:
        if ("true".equals(r103) == true) goto L25;
        if ("await".equals(r103) == false) goto L27;
        r101.f549108a = true;
        r101.f549109b = true;
        goto L27
    }

    public static Rect c(ReadableMap r100) {
        if (r100 != null) goto L33;
        return null;
    L33:
    L15:
        th = move-exception;
        LLog.e("ImageUtils", "parseRegionToDecode error: " + th.getMessage());
    L17:
        Rect r101 = null;
    L18:
        if (r101 != null) goto L21;
        LLog.w("ImageUtils", "parseRegionToDecode: rect is null");
        return null;
    L21:
        int r102 = r101.left;
        if (r102 < 0) goto L31;
        int r103 = r101.top;
        if (r103 < 0) goto L31;
        if (r101.right <= r102) goto L31;
        if (r101.bottom <= r103) goto L31;
        return r101;
    L31:
        LLog.w("ImageUtils", "parseRegionToDecode: invalid rect " + r101);
        return null;
    L6:
        if (r100.hasKey("x") == false) goto L17;
        if (r100.hasKey("y") == false) goto L17;
        if (r100.hasKey("width") == false) goto L17;
        if (r100.hasKey("height") == false) goto L17;
        int r104 = (int) r100.getDouble("x");     // Catch: Throwable -> L15
        int r105 = (int) r100.getDouble("y");     // Catch: Throwable -> L15
        r101 = new Rect(r104, r105, ((int) r100.getDouble("width")) + r104, ((int) r100.getDouble("height")) + r105);     // Catch: Throwable -> L15
        goto L18
    }

    public static int a(int r100, int r101, Bitmap.Config r102) {
        int r103 = r100 * r101;
        int r104 = a.f549107a[r102.ordinal()];
        int r105 = 4;
        if (r104 == 1) goto L15;
        if (r104 != 2) goto L7;
        r105 = 1;
        goto L15
    L7:
        if (r104 == 3) goto L12;
        if (r104 == 4) goto L12;
        throw new UnsupportedOperationException("Current Bitmap.Config is not supported");
    L12:
        r105 = 2;
    L15:
        return r103 * r105;
    }
}
