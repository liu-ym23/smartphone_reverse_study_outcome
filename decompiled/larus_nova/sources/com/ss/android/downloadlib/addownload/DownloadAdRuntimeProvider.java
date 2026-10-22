package com.ss.android.downloadlib.addownload;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u00020\u0007H\u0007J/\u0010\b\u001a\u0004\u0018\u0001H\t\"\u0004\b\u0000\u0010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010\rJ)\u0010\u000e\u001a\u00020\u0007\"\u0004\b\u0000\u0010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u000b2\u0006\u0010\u000f\u001a\u0002H\tH\u0007¢\u0006\u0002\u0010\u0010J*\u0010\u0011\u001a\u00020\u0007\"\u0004\b\u0000\u0010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u000b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\t0\u0013H\u0007J\u001c\u0010\u0014\u001a\u00020\u0007\"\u0004\b\u0000\u0010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u000bH\u0007R\u0016\u0010\u0003\u001a\u00020\u00048\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0002¨\u0006\u0015"}, d2 = {"Lcom/ss/android/downloadlib/addownload/DownloadAdRuntimeProvider;", "", "()V", "INSTANCE", "Lcom/ss/android/downloadlib/addownload/BaseDownloadAdRuntimeProvider;", "INSTANCE$annotations", "clear", "", "getInnerService", ExifInterface.GPS_DIRECTION_TRUE, "clazz", "Ljava/lang/Class;", "params", "(Ljava/lang/Class;Ljava/lang/Object;)Ljava/lang/Object;", "registerInnerService", "instance", "(Ljava/lang/Class;Ljava/lang/Object;)V", "registerInnerServiceFactory", "factory", "Lcom/ss/android/downloadlib/addownload/DownloadInnerServiceFactory;", "unRegisterInnerServiceFactory", "download-api_release"}, k = 1, mv = {1, 1, 16})
public final class DownloadAdRuntimeProvider {
    private static final BaseDownloadAdRuntimeProvider INSTANCE = null;

    /* JADX INFO: renamed from: INSTANCE, reason: collision with other field name */
    public static final DownloadAdRuntimeProvider f110INSTANCE = null;

    private DownloadAdRuntimeProvider() {
    }

    @JvmStatic
    private static /* synthetic */ void INSTANCE$annotations() {
    }

    @JvmStatic
    public static final <T> T getInnerService(Class<T> r100) {
        return (T) getInnerService$default(r100, null, 2, null);
    }

    static {
        f110INSTANCE = new DownloadAdRuntimeProvider();
        INSTANCE = new BaseDownloadAdRuntimeProvider();
    }

    @JvmStatic
    public static final void clear() {
        INSTANCE.clear();
    }

    @JvmStatic
    public static final <T> void unRegisterInnerServiceFactory(Class<T> r100) {
        INSTANCE.unRegisterInnerServiceFactory(r100);
    }

    @JvmStatic
    public static final <T> T getInnerService(Class<T> r100, Object r101) {
        return (T) INSTANCE.getService(r100, r101);
    }

    @JvmStatic
    public static final <T> void registerInnerService(Class<T> r100, T r101) {
        INSTANCE.registerInnerService(r100, r101);
    }

    @JvmStatic
    public static final <T> void registerInnerServiceFactory(Class<T> r100, DownloadInnerServiceFactory<T> r101) {
        INSTANCE.registerInnerServiceFactory(r100, r101);
    }

    public static /* synthetic */ Object getInnerService$default(Class r100, Object r101, int r102, Object r103) {
        if ((r102 & 2) == 0) goto L6;
        r101 = null;
    L6:
        return getInnerService(r100, r101);
    }
}
