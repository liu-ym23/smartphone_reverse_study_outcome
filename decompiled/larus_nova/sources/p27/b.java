package p27;

import com.byted.cast.common.TeaEventTrack;
import com.bytedance.mira.Mira;
import com.bytedance.mira.helper.PluginDirHelper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.ttvideoengine.superresolution.SRStrategy;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public static String b() {
        return PluginDirHelper.ensureDirExists(new PolarisFileWrapper(Mira.getAppContext().getFilesDir(), ".pre_download"));
    }

    public static String a(int r100, String r101, String r102, boolean r103) {
        if (r100 != 1) goto L5;
        boolean r104 = true;
    L7:
        if (r104 == false) goto L9;
        String r105 = SRStrategy.KEY_SR_STRATEGY_CONFIG;
    L21:
        if (r103 == false) goto L25;
        return String.format("%s_%s_%s_p.jar", new Object[]{r105, r101, r102});
    L25:
        return String.format("%s_%s_%s.jar", new Object[]{r105, r101, r102});
    L9:
        if (r100 != 0) goto L11;
        boolean r106 = true;
    L12:
        if (r106 == false) goto L14;
        r105 = "auto";
        goto L21
    L14:
        if (r100 != 3) goto L16;
        boolean r107 = true;
    L17:
        if (r107 == false) goto L19;
        r105 = TeaEventTrack.ACTION_DRAMA_PRE;
        goto L21
    L19:
        r105 = "";
        goto L21
    L16:
        r107 = false;
        goto L17
    L11:
        r106 = false;
        goto L12
    L5:
        r104 = false;
        goto L7
    }
}
