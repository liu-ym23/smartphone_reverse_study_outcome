package com.bytedance.security.android.aopcheck;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import com.bytedance.android.service.manager.alliance.IAllianceService;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import f06.b;
import f06.d;
import g06.a;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\"\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J,\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J,\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\fH\u0007J\"\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J,\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\"\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007¨\u0006\u0016"}, d2 = {"Lcom/bytedance/security/android/aopcheck/ContentResolverWrapper;", "", "()V", "openAssetFile", "Landroid/content/res/AssetFileDescriptor;", "resolver", "Landroid/content/ContentResolver;", "uri", "Landroid/net/Uri;", "mode", "", "cancellationSignal", "Landroid/os/CancellationSignal;", "openAssetFileDescriptor", "openFile", "Landroid/os/ParcelFileDescriptor;", IAllianceService.LAUNCH_FROM_SIGNAL, "openFileDescriptor", "openInputStream", "Ljava/io/InputStream;", "openOutputStream", "Ljava/io/OutputStream;", "aopcheck_release"}, k = 1, mv = {1, 1, 15})
public final class ContentResolverWrapper {
    public static final ContentResolverWrapper INSTANCE = null;

    private ContentResolverWrapper() {
    }

    static {
        INSTANCE = new ContentResolverWrapper();
    }

    @JvmStatic
    public static final InputStream openInputStream(ContentResolver r100, Uri r101) {
        if (PathTraversalChecker.check(r101) == false) goto L11;
        PathTraversalChecker r102 = PathTraversalChecker.INSTANCE;
        if (r102.getEnableIntercept() == false) goto L11;
        if (r102.getEnableContentResolverIntercept() == false) goto L11;
        return null;
    L11:
        return r100.openInputStream(r101);
    }

    @JvmStatic
    public static final OutputStream openOutputStream(ContentResolver r100, Uri r101) {
        if (PathTraversalChecker.check(r101) == false) goto L11;
        PathTraversalChecker r102 = PathTraversalChecker.INSTANCE;
        if (r102.getEnableIntercept() == false) goto L11;
        if (r102.getEnableContentResolverIntercept() == false) goto L11;
        return null;
    L11:
        return r100.openOutputStream(r101);
    }

    private static ParcelFileDescriptor com_bytedance_security_android_aopcheck_ContentResolverWrapper_android_content_ContentResolver_openFileDescriptor(ContentResolver r110, Uri r111, String r210) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111, r210};
        b r112 = new b();
        a r102 = ApiHookConfig.f245611b.get(240020);
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
        d r107 = r106.preInvoke(240020, "android/content/ContentResolver", "openFileDescriptor", r110, r101, "android.os.ParcelFileDescriptor", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return (ParcelFileDescriptor) r107.f474983b;
    L21:
        return r110.openFileDescriptor(r111, r210);
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

    @JvmStatic
    public static final AssetFileDescriptor openAssetFileDescriptor(ContentResolver r100, Uri r101, String r102) {
        if (PathTraversalChecker.check(r101) == false) goto L11;
        PathTraversalChecker r103 = PathTraversalChecker.INSTANCE;
        if (r103.getEnableIntercept() == false) goto L11;
        if (r103.getEnableContentResolverIntercept() == false) goto L11;
        return null;
    L11:
        return r100.openAssetFileDescriptor(r101, r102);
    }

    @JvmStatic
    public static final ParcelFileDescriptor openFileDescriptor(ContentResolver r100, Uri r101, String r102) {
        if (PathTraversalChecker.check(r101) == false) goto L11;
        PathTraversalChecker r103 = PathTraversalChecker.INSTANCE;
        if (r103.getEnableIntercept() == false) goto L11;
        if (r103.getEnableContentResolverIntercept() == false) goto L11;
        return null;
    L11:
        return com_bytedance_security_android_aopcheck_ContentResolverWrapper_android_content_ContentResolver_openFileDescriptor(r100, r101, r102);
    }

    @JvmStatic
    public static final OutputStream openOutputStream(ContentResolver r100, Uri r101, String r102) {
        if (PathTraversalChecker.check(r101) == false) goto L11;
        PathTraversalChecker r103 = PathTraversalChecker.INSTANCE;
        if (r103.getEnableIntercept() == false) goto L11;
        if (r103.getEnableContentResolverIntercept() == false) goto L11;
        return null;
    L11:
        return r100.openOutputStream(r101, r102);
    }

    private static ParcelFileDescriptor com_bytedance_security_android_aopcheck_ContentResolverWrapper_android_content_ContentResolver_openFileDescriptor(ContentResolver r110, Uri r111, String r210, CancellationSignal r211) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111, r210, r211};
        b r112 = new b();
        a r102 = ApiHookConfig.f245611b.get(240020);
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
        d r107 = r106.preInvoke(240020, "android/content/ContentResolver", "openFileDescriptor", r110, r101, "android.os.ParcelFileDescriptor", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return (ParcelFileDescriptor) r107.f474983b;
    L21:
        return r110.openFileDescriptor(r111, r210, r211);
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

    @JvmStatic
    public static final AssetFileDescriptor openAssetFile(ContentResolver r100, Uri r101, String r102, CancellationSignal r103) {
        if (PathTraversalChecker.check(r101) == false) goto L11;
        PathTraversalChecker r104 = PathTraversalChecker.INSTANCE;
        if (r104.getEnableIntercept() == false) goto L11;
        if (r104.getEnableContentResolverIntercept() == false) goto L11;
        return null;
    L11:
        return r100.openAssetFile(r101, r102, r103);
    }

    @JvmStatic
    public static final AssetFileDescriptor openAssetFileDescriptor(ContentResolver r100, Uri r101, String r102, CancellationSignal r103) {
        if (PathTraversalChecker.check(r101) == false) goto L11;
        PathTraversalChecker r104 = PathTraversalChecker.INSTANCE;
        if (r104.getEnableIntercept() == false) goto L11;
        if (r104.getEnableContentResolverIntercept() == false) goto L11;
        return null;
    L11:
        return r100.openAssetFileDescriptor(r101, r102, r103);
    }

    @JvmStatic
    public static final ParcelFileDescriptor openFile(ContentResolver r100, Uri r101, String r102, CancellationSignal r103) {
        if (PathTraversalChecker.check(r101) == false) goto L11;
        PathTraversalChecker r104 = PathTraversalChecker.INSTANCE;
        if (r104.getEnableIntercept() == false) goto L11;
        if (r104.getEnableContentResolverIntercept() == false) goto L11;
        return null;
    L11:
        return r100.openFile(r101, r102, r103);
    }

    @JvmStatic
    public static final ParcelFileDescriptor openFileDescriptor(ContentResolver r100, Uri r101, String r102, CancellationSignal r103) {
        if (PathTraversalChecker.check(r101) == false) goto L11;
        PathTraversalChecker r104 = PathTraversalChecker.INSTANCE;
        if (r104.getEnableIntercept() == false) goto L11;
        if (r104.getEnableContentResolverIntercept() == false) goto L11;
        return null;
    L11:
        return com_bytedance_security_android_aopcheck_ContentResolverWrapper_android_content_ContentResolver_openFileDescriptor(r100, r101, r102, r103);
    }
}
