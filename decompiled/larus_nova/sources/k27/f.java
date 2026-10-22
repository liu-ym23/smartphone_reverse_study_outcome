package k27;

import com.bytedance.mira.core.MetaManager;
import com.bytedance.mira.log.MiraLogger;
import com.bytedance.mira.plugin.PluginManager;
import com.bytedance.mira.util.FileUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.io.File;
import java.io.FileFilter;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements FileFilter {
    public f() {
    }

    @Override // java.io.FileFilter
    public final boolean accept(File r110) {
        int r100 = PluginManager.getInstance().getHostUpdateVerCode();
        String r101 = r110.getName();
        String r102 = r101.replaceAll("pre_download_", "").replaceAll("\\.jar", "");
        String[] r103 = r102.split("_");
        if (r103.length >= 3) goto L5;
        MiraLogger.d(g.f501615c, "PrePlugin : info length < 3 >>> " + r101);
        String r104 = null;
        int r105 = 0;
    L8:
        int r106 = MetaManager.getInst().getHostCompatibleMaxVersion(r104, r105);
        int r107 = MetaManager.getInst().getHostCompatibleMinVersion(r104, r105);
        if (r100 < r107) goto L22;
        if (r100 > r106) goto L22;
        if (r110.getName().endsWith(".apk") == false) goto L15;
    L20:
        MiraLogger.w(MiraLogger.TAG_INIT, "PreDownloadScanRunnable installPluginDir installing : " + r110);
        MiraLogger.w(MiraLogger.TAG_INIT, "PreDownloadScanRunnable current version range = [ " + r107 + " , " + r106 + " ] : ");
        PluginManager.getInstance().asyncInstall(r110);
    L21:
        return false;
    L15:
        if (r110.getName().endsWith(".so") == true) goto L20;
        if (r110.getName().endsWith(".jar") == true) goto L20;
        FileUtils.deleteFile(r110);
        MiraLogger.w(MiraLogger.TAG_INIT, "PreDownloadScanRunnable installPluginDir deleted : " + r110);
    L22:
        MiraLogger.w(MiraLogger.TAG_INIT, "PreDownloadScanRunnable pre plugin install version valid fail >>>" + r110);
        return false;
    L5:
        r105 = -1;
        String r108 = r103[r103.length - 1];
        r105 = CastIntegerProtector.parseInt(r103[r103.length - 2]);     // Catch: Exception -> L24
    L7:
        r104 = r102.replaceAll("_" + r105 + "_" + r108, "");
        goto L8
    }
}
