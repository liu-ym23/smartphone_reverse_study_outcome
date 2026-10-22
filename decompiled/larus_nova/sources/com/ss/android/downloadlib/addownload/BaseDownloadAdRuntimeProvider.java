package com.ss.android.downloadlib.addownload;

import androidx.exifinterface.media.ExifInterface;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\b\u0016\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ/\u0010\t\u001a\u0004\u0018\u0001H\n\"\u0004\b\u0000\u0010\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0016¢\u0006\u0002\u0010\rJ'\u0010\u000e\u001a\u00020\b\"\u0004\b\u0000\u0010\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\u00052\u0006\u0010\u000f\u001a\u0002H\n¢\u0006\u0002\u0010\u0010J(\u0010\u0011\u001a\u00020\b\"\u0004\b\u0000\u0010\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\n0\u0006J\u001a\u0010\u0013\u001a\u00020\b\"\u0004\b\u0000\u0010\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\u0005R\"\u0010\u0003\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/ss/android/downloadlib/addownload/BaseDownloadAdRuntimeProvider;", "", "()V", "downloadInnerServices", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/lang/Class;", "Lcom/ss/android/downloadlib/addownload/DownloadInnerServiceFactory;", "clear", "", "getService", ExifInterface.GPS_DIRECTION_TRUE, "clazz", "params", "(Ljava/lang/Class;Ljava/lang/Object;)Ljava/lang/Object;", "registerInnerService", "instance", "(Ljava/lang/Class;Ljava/lang/Object;)V", "registerInnerServiceFactory", "factory", "unRegisterInnerServiceFactory", "Companion", "download-api_release"}, k = 1, mv = {1, 1, 16})
public class BaseDownloadAdRuntimeProvider {
    public static final Companion Companion = null;
    private static final String TAG = null;
    private final ConcurrentHashMap<Class<?>, DownloadInnerServiceFactory<?>> downloadInnerServices;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/ss/android/downloadlib/addownload/BaseDownloadAdRuntimeProvider$Companion;", "", "()V", "TAG", "", "download-api_release"}, k = 1, mv = {1, 1, 16})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
        TAG = Reflection.getOrCreateKotlinClass(BaseDownloadAdRuntimeProvider.class).getSimpleName();
    }

    public final void clear() {
        this.downloadInnerServices.clear();
    }

    public BaseDownloadAdRuntimeProvider() {
        this.downloadInnerServices = new ConcurrentHashMap();
    }

    public final <T> void unRegisterInnerServiceFactory(Class<T> r100) {
        if (this.downloadInnerServices.containsKey(r100) == false) goto L6;
        this.downloadInnerServices.remove(r100);
        return;
    }

    public <T> T getService(Class<T> r100, Object r101) {
        DownloadInnerServiceFactory<?> r102 = this.downloadInnerServices.get(r100);
        if (r102 == null) goto L5;
        Object r103 = r102.create(r101);
    L7:
        if (r100.isInstance(r103) == true) goto L9;
        return null;
    L9:
        return r100.cast(r103);
    L5:
        r103 = null;
        goto L7
    }

    public final <T> void registerInnerService(Class<T> r100, final T r101) {
        if (r101 != null) goto L5;
        unRegisterInnerServiceFactory(r100);
        return;
    L5:
        registerInnerServiceFactory(r100, new AnonymousClass1(r101));
    }

    public final <T> void registerInnerServiceFactory(Class<T> r100, DownloadInnerServiceFactory<T> r101) {
        if (this.downloadInnerServices.containsKey(r100) == true) goto L6;
        this.downloadInnerServices.put(r100, r101);
        return;
    }

    public static /* synthetic */ Object getService$default(BaseDownloadAdRuntimeProvider r100, Class r101, Object r102, int r103, Object r104) {
        if (r104 != null) goto L9;
        if ((r103 & 2) == 0) goto L7;
        r102 = null;
    L7:
        return r100.getService(r101, r102);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getService");
    }
}
