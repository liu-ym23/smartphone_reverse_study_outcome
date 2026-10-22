package com.ss.android.lark.filedetail.impl.folder.manage.service;

import com.larksuite.framework.utils.FileUtils;
import com.ss.android.lark.appsetting.api.SettingManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class ExtractConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static FileConfigValue f421788a;

    static {
        f421788a = new FileConfigValue(null, 1, null);
        SettingManager.getInstance().get(FileConfigValue.class, new AnonymousClass1());
    }

    public static boolean a(long r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "fileName");
        if (r100 <= f421788a.getExtractConfig().getMaxExtractSize()) goto L5;
        return false;
    L5:
        String r102 = FileUtils.m(r101);
        if (r102 != null) goto L8;
    L11:
        return false;
    L8:
        if (r102.length() <= 1) goto L11;
        String r103 = r102.substring(1);
        return f421788a.getExtractConfig().getSupportedFormat().contains(r103);
    }
}
