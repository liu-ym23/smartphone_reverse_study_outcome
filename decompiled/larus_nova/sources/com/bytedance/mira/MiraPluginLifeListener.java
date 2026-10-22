package com.bytedance.mira;

import android.content.pm.PackageInfo;
import com.bytedance.mira.plugin.Plugin;
import java.io.File;

/* JADX INFO: loaded from: classes21.dex */
public interface MiraPluginLifeListener {
    void onPluginInitStart(Plugin r100);

    void onPluginInstallStart(Plugin r100, File r101, PackageInfo r102);
}
