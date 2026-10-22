package qq6;

import com.bytedance.locallife.dito.host.ui.SkinMode;

/* JADX INFO: loaded from: classes21.dex */
public final class b {
    public static final SkinMode a(int r100) {
        SkinMode r101 = SkinMode.FORCE_WHITE;
        if (r100 == r101.getMode()) goto L10;
        SkinMode r102 = SkinMode.FORCE_NIGHT;
        if (r100 != r102.getMode()) goto L9;
        return r102;
    L9:
        return SkinMode.AUTO_SKIN;
    L10:
        return r101;
    }
}
