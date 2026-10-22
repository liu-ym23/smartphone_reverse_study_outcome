package com.ss.android.ugc.aweme.utils;

import android.app.Application;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import androidx.exifinterface.media.ExifInterface;
import bytedance.io.BdFileSystem;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.UriProtector;
import com.mammon.speechaudiosdk.session.type.SpeechCode;
import com.ss.android.ugc.tools.utils.FileAdapterUtils;
import f06.b;
import f06.d;
import g06.a;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/utils/FileMetaInfoQueryManager;", "", "<init>", "()V", "lib-api_release"}, k = 1, mv = {1, 4, 1})
public final class FileMetaInfoQueryManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FileMetaInfoQueryManager f454347a = null;

    private FileMetaInfoQueryManager() {
    }

    static {
        f454347a = new FileMetaInfoQueryManager();
    }

    @JvmStatic
    public static final int b(String r100) {
        f454347a.getClass();
        Application r101 = FileAdapterUtils.f454856e.a();
        FileAdapterUtils.c();
        if (FileAdapterUtils.b(r100) == true) goto L6;
    L8:
        if (r100 == null) goto L11;
        ExifInterface r102 = new ExifInterface(r100);     // Catch: Throwable -> L25
    L12:
        if (r102 == null) goto L23;
        int r103 = r102.getAttributeInt(ExifInterface.TAG_ORIENTATION, 1);
        if (r103 != 3) goto L16;
        return 180;
    L16:
        if (r103 != 6) goto L18;
        return 90;
    L18:
        if (r103 != 8) goto L23;
        return 270;
    L23:
        return 0;
    L28:
        r102 = null;
        goto L12
    L6:
        if (Build.VERSION.SDK_INT < 24) goto L8;
        r102 = new ExifInterface(BdFileSystem.getFileDescriptor(r101, UriProtector.parse(r100), "r").getFileDescriptor());     // Catch: Throwable -> L25
    L11:
        r102 = null;
        goto L12
    }

    public static String a(MediaMetadataRetriever r110, int r111) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {Integer.valueOf(r111)};
        b r112 = new b();
        a r102 = ApiHookConfig.f245611b.get(Integer.valueOf(SpeechCode.SPEECH_TOKEN_NOT_SUPPORT_ONLINE));
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        d r107 = r106.preInvoke(SpeechCode.SPEECH_TOKEN_NOT_SUPPORT_ONLINE, "android/media/MediaMetadataRetriever", "extractMetadata", r110, r101, "java.lang.String", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return (String) r107.f474983b;
    L21:
        return r110.extractMetadata(r111);
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }
}
