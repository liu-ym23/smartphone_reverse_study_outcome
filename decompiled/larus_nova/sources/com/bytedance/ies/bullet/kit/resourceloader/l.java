package com.bytedance.ies.bullet.kit.resourceloader;

import android.net.Uri;
import com.bytedance.android.ecom.arch.slice.render.SlcPosition;
import com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonAssertResManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class l {
    public static Uri a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        Uri.Builder r101 = new Uri.Builder().scheme(ChameleonAssertResManager.ASSET_FOLDER).authority(SlcPosition.RELATIVE).path(r100);
        Intrinsics.checkNotNullParameter(r101, "<this>");
        return r101.build();
    }

    public static Uri b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        Uri.Builder r101 = new Uri.Builder().scheme("local_file").authority(SlcPosition.RELATIVE).path(r100);
        Intrinsics.checkNotNullParameter(r101, "<this>");
        return r101.build();
    }
}
