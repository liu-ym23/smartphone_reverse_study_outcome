package com.bytedance.timon.permission.storage.util;

import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import com.bytedance.timon.permission.storage.constant.TimonMediaType;

/* JADX INFO: loaded from: classes22.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f270671a = 0;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f270672a = null;

        static {
            int[] r100 = new int[TimonMediaType.values().length];
            r100[TimonMediaType.IMAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[TimonMediaType.VIDEO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[TimonMediaType.AUDIO.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f270672a = r100;
        }
    }

    static {
        Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getPath();
        Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES).getPath();
        Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_ALARMS).getPath();
        int r100 = Build.VERSION.SDK_INT;
        if (r100 < 29) goto L5;
        MediaStore.Images.Media.getContentUri("external_primary");
    L6:
        if (r100 < 29) goto L8;
        MediaStore.Video.Media.getContentUri("external_primary");
    L9:
        if (r100 < 29) goto L11;
        MediaStore.Audio.Media.getContentUri("external_primary");
        return;
    L11:
        Uri r101 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        return;
    L8:
        Uri r102 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        goto L9
    L5:
        Uri r103 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        goto L6
    }
}
