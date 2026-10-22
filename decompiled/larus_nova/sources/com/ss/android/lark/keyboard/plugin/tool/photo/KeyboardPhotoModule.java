package com.ss.android.lark.keyboard.plugin.tool.photo;

import android.app.Activity;
import android.content.Context;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes36.dex */
public final class KeyboardPhotoModule {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f429741a = null;

    public interface a {
        int getFileUploadAuthorizatedDenyCode();

        int getFileUploadAuthorizatedDenyCodeByFilePolicy();

        int getUnifiedStorageLimitErrorCode();

        boolean isHitStorageQuotaLimit(int r100);

        void onAuthorizatedDeny(Context r100, String r101);

        boolean showQuotaLimitDialog(Activity r100, int r101);

        void showUnifiedStorageLimitCTADialog(Activity r100);
    }

    static {
        f429741a = LazyKt.lazy(KeyboardPhotoModule$dependency$2.INSTANCE);
    }

    public static final a a() {
        return (a) f429741a.getValue();
    }
}
