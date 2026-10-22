package com.ss.android.lark.widget.photopicker.utils;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.webkit.MimeTypeMap;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.FileUtils;
import com.larksuite.framework.utils.MediaStoreUtil;
import com.larksuite.framework.utils.file.direct.DirectFileAccess;
import com.larksuite.framework.utils.m0;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chat.entity.media.MediaExtra;
import com.ss.android.lark.log.Log;
import com.ss.ttvideoengine.model.VideoRef;
import java.io.File;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class g {

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ File f447656a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Uri f447657b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Context f447658c;

        public a(PolarisFileWrapper r100, Uri r101, Context r102) {
            this.f447656a = r100;
            this.f447657b = r101;
            this.f447658c = r102;
        }

        public final void a() {
            MediaStoreUtil.c(this.f447656a, this.f447657b, this.f447658c);
            PolarisFileWrapper r100 = m0.b(this.f447658c, this.f447657b, false);
            if (r100 == null) goto L5;
            String r101 = r100.getAbsolutePath();
        L6:
            if (r101 == null) goto L9;
            FileUtils.v(this.f447658c, r101, com.ss.android.lark.widget.photopicker.entity.d.f447523c);
            Log.i("MediaExtraUtils", "notifySystemScanFile, finalPath:".concat(r101));
            return;
        L9:
            return;
        L5:
            r101 = null;
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public static String c(MediaExtra r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r101 = Math.abs(r100.getKey().hashCode());
        String r102 = r100.getMime();
        String[] r103 = FileUtils.f285888a;
        String r104 = MimeTypeMap.getSingleton().getExtensionFromMimeType(r102);
        if (r104 != null) goto L6;
        r104 = "";
    L6:
        return r101 + '.' + r104;
    }

    @JvmStatic
    public static final String a(MediaExtra r100, Context r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r102 = Build.VERSION.SDK_INT;
        if (r102 <= 29) goto L5;
        String r103 = com.ss.android.lark.diskmanage.storage.d.s(r101) + c(r100);
    L6:
        Log.i("MediaExtraUtils", "getDownloadVideoWorkSpace, version:" + r102 + ",workSpace:" + r103);
        Intrinsics.checkNotNull(r103);
        return r103;
    L5:
        r103 = new PolarisFileWrapper(DirectFileAccess.a(new DirectFileAccess.a(DirectFileAccess.ScopedStorage.SHARED, DirectFileAccess.StorageLocation.EXTERNAL, Environment.DIRECTORY_MOVIES, r101, VideoRef.VALUE_VIDEO_REF_CODEC_HAS_BYTEVC2)), "/Lark/" + c(r100)).getAbsolutePath();
        goto L6
    }

    @JvmStatic
    public static final void b(MediaExtra r100, Context r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        StringBuilder r103 = new StringBuilder("saveFileToMediaStore start, version:");
        int r104 = Build.VERSION.SDK_INT;
        r103.append(r104);
        r103.append(",path:");
        r103.append(r102);
        Log.i("MediaExtraUtils", r103.toString());
        if (r102 == null) goto L19;
        if (r101 != null) goto L7;
        return;
    L7:
        if (r104 > 29) goto L10;
        FileUtils.v(r101, r102, com.ss.android.lark.widget.photopicker.entity.d.f447523c);
        Log.i("MediaExtraUtils", "notifySystemScanFile, path:".concat(r102));
        return;
    L10:
        PolarisFileWrapper r105 = new PolarisFileWrapper(r102);
        Uri r106 = MediaStoreUtil.f(r101, c(r100), r100.getMime(), null, com.ss.android.lark.widget.photopicker.entity.d.f447522b, 24);
        if (r106 != null) goto L14;
        return;
    L14:
        if (r105.exists() == true) goto L16;
        return;
    L16:
        if (r105.isFile() == false) goto L21;
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new a(r105, r106, r101));
        return;
    L21:
        return;
    }
}
