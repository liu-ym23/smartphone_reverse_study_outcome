package com.lynx.textra;

import android.content.Context;
import android.os.Build;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.bdlocation.utils.DimLocationCheckUtil;
import com.ss.android.socialbase.appdownloader.util.RomUtils;

/* JADX INFO: loaded from: classes32.dex */
public interface PlatformFontCaps {
    public static final String DEFAULT_FAMILY_NAME = "sans-serif";
    public static final int MaxVariation = 1000;
    public static final int MinVariation = 100;

    /* JADX INFO: renamed from: com.lynx.textra.PlatformFontCaps$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static short $default$clamp(PlatformFontCaps r100, int r101) {
            if (r101 < 1000) goto L6;
            r101 = 1000;
        L6:
            if (r101 > 100) goto L9;
            r101 = 100;
        L9:
            return (short) r101;
        }
    }

    public static class Factory {
        public Factory() {
        }

        public static PlatformFontCaps getStrategy(Context r100) {
            String r101 = Build.BRAND;
            if (AppConstants.CHANNEL_OPPO.equalsIgnoreCase(r101) == false) goto L7;
            return new OppoFontCaps(r100);
        L7:
            if (DimLocationCheckUtil.VIVO.equalsIgnoreCase(r101) == false) goto L11;
            return new VivoFontCaps();
        L11:
            if (DimLocationCheckUtil.XIAOMI.equalsIgnoreCase(r101) == false) goto L15;
            return new XiaomiFontCaps(r100);
        L15:
            if (RomUtils.BRAND_HUAWEI.equalsIgnoreCase(r101) == false) goto L19;
            return new HuaweiFontCaps(r100);
        L19:
            if (RomUtils.BRAND_HONOR.equalsIgnoreCase(r101) == false) goto L23;
            return new HonorFontCaps(r100);
        L23:
            return new DefaultFontCaps();
        }
    }

    short adjust(short r100);

    short clamp(int r100);

    String defaultFamilyName();
}
