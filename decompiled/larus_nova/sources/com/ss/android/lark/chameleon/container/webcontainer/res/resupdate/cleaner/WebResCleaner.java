package com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.cleaner;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonResUtils;
import com.ss.android.lark.chameleon.idependency.Log;
import com.ss.android.lark.chameleon.util.FileUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0003R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/res/resupdate/cleaner/WebResCleaner;", "", "()V", "TAG", "", "cleanWebappRes", "", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class WebResCleaner {
    public static final WebResCleaner INSTANCE = null;
    public static final String TAG = "WebResCleaner";

    static {
        INSTANCE = new WebResCleaner();
    }

    private WebResCleaner() {
    }

    private final void cleanWebappRes() {
        PolarisFileWrapper r100 = new PolarisFileWrapper(ChameleonResUtils.INSTANCE.getWebcontainerRootDir());
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100.getAbsolutePath() + '_' + System.currentTimeMillis());
        if (r100.renameTo(r101) == false) goto L5;
        FileUtils.forceDelete(r101);
        Log.i(TAG, "cleanResource, clean webapp dir success");
        return;
    L5:
        Log.w(TAG, "cleanResource: rename failed ");
    }
}
