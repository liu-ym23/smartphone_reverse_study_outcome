package com.larus.bmhome.music.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.bytedance.mira.core.opt.res.NewMiraResourcesManager;
import com.larus.common.apphost.AppHost;

/* JADX INFO: loaded from: classes26.dex */
public final class m2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Context f313352a = null;

    static {
        AppHost.Companion r100 = AppHost.f326268a;
        Resources r101 = r100.getApplication().getResources();
        Configuration r102 = new Configuration(r101.getConfiguration());
        Configuration r103 = new Configuration(r101.getConfiguration());
        r102.uiMode = 16;
        r103.uiMode = 32;
        Context r104 = r100.getApplication().createConfigurationContext(r102);
        NewMiraResourcesManager.getInstance().install(r104);
        Context r105 = r100.getApplication().createConfigurationContext(r103);
        NewMiraResourcesManager.getInstance().install(r105);
        f313352a = r105;
    }
}
