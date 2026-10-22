package com.obric.olog.salvage;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Handler;
import android.os.ParcelFileDescriptor;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.downloadlib.constants.MimeType;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import el9.a;
import java.io.FileNotFoundException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes5.dex */
public class LogCompressionProvider extends ContentProvider {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f398686c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PthreadHandlerThreadV2 f398687a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Handler f398688b;

    @Override // android.content.ContentProvider
    public String getType(Uri r100) {
        return MimeType.ZIP;
    }

    static {
        PatternProtector.compile("^[a-zA-Z0-9_./-]+$");
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        PthreadHandlerThreadV2 r100 = new PthreadHandlerThreadV2("LogCompressionThread", 10);
        this.f398687a = r100;
        ThreadMethodProxy.start(r100);
        this.f398688b = new Handler(this.f398687a.getLooper());
        return true;
    }

    public final boolean b() {
        Context r100 = getContext();
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.checkCallingOrSelfPermission(r100.getPackageName() + ".ACCESS_LOG_COMPRESSION_PROVIDER") != 0) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // android.content.ContentProvider
    public final void shutdown() {
        super.shutdown();
        this.f398687a.quitSafely();
    }

    public LogCompressionProvider() {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class<?> r103 = Class.forName(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class<?> r104 = Class.forName(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r100, ContentValues r101) {
        b();
        return null;
    }

    @Override // android.content.ContentProvider
    public final ParcelFileDescriptor openFile(Uri r100, String r101) throws FileNotFoundException {
        if (b() == false) goto L15;
        Context r102 = getContext();
        if (r102 == null) goto L13;
        PolarisFileWrapper r103 = new PolarisFileWrapper(r102.getFilesDir(), "ologs.zip");
        if (r103.exists() == false) goto L11;
        return ParcelFileDescriptor.open(r103, 268435456);
    L11:
        throw new FileNotFoundException("ZIP file not found: " + r103.getAbsolutePath());
    L13:
        throw new FileNotFoundException("Context is null");
    L15:
        throw new SecurityException("Caller does not have the required permission");
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r100, String r101, String[] r102) {
        if (b() == true) goto L6;
        return 0;
    L6:
        if ("delete_zip".equals(r101) == false) goto L16;
        Context r103 = getContext();
        if (r103 != null) goto L10;
        return 0;
    L10:
        PolarisFileWrapper r104 = new PolarisFileWrapper(r103.getFilesDir(), "ologs.zip");
        if (r104.exists() == false) goto L16;
        if (r104.delete() == false) goto L16;
        return 1;
    L16:
        return 0;
    }

    @Override // android.content.ContentProvider
    public int update(Uri r100, ContentValues r101, String r102, String[] r103) {
        b();
        return 0;
    }

    @Override // android.content.ContentProvider
    public Cursor query(final Uri r100, String[] r101, String r110, final String[] r111, String r112) {
        if (b() == true) goto L5;
        return null;
    L5:
        if (r111 != null) goto L7;
    L15:
        return null;
    L7:
        if (r111.length == 0) goto L15;
        final MatrixCursor r102 = new MatrixCursor(new String[]{"zip_file_uri"});
        final CountDownLatch r113 = new CountDownLatch(1);
        this.f398688b.post(new gla.a(this, r111, r100, r102, r113));
        r113.await();     // Catch: InterruptedException -> L12
    L14:
        return r102;
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L14
    }
}
