package com.ss.android.lark.sticker.core.utils;

import android.text.TextUtils;
import com.larksuite.framework.utils.FileUtils;
import com.suite.lark.platform.component.storage.file.dirs.h;

/* JADX INFO: loaded from: classes38.dex */
public final class c {
    public static String a() {
        String r100 = ((h.b) StickerFileUtils.f440834a.getValue()).a().getRealPath();
        FileUtils.t(r100);
        return r100;
    }

    public static String b(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L5;
        StringBuilder r101 = new StringBuilder();
        String r102 = ((h.b) StickerFileUtils.f440835b.getValue()).a().getRealPath();
        FileUtils.t(r102);
        r101.append(r102);
        r101.append(r100);
        String r103 = r101.toString();
        FileUtils.t(r103);
        return r103;
    L5:
        return a();
    }
}
