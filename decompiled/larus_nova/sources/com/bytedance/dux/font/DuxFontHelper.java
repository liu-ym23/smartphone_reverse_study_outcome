package com.bytedance.dux.font;

import android.content.Context;
import android.graphics.Typeface;
import com.bytedance.geckox.GeckoClient;
import com.bytedance.geckox.OptionCheckUpdateParams;
import com.bytedance.geckox.model.CheckRequestBodyModel;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.sysoptimizer.TypeFaceLancet;
import com.bytedance.sysoptimizer.TypeFaceOptimizer;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.File;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import uy5.c;

/* JADX INFO: loaded from: classes15.dex */
public final class DuxFontHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f205084a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f205085b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap<String, SoftReference<Typeface>> f205086c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Set<String> f205087d = null;

    public interface a {
    }

    public DuxFontHelper() {
    }

    static {
        f205084a = LazyKt.lazy(DuxFontHelper$ioScope$2.INSTANCE);
        f205085b = LazyKt.lazy(DuxFontHelper$accessKey$2.INSTANCE);
        f205086c = new ConcurrentHashMap();
        f205087d = Collections.synchronizedSet(new HashSet());
    }

    public static Typeface a(String r100) {
        if (TypeFaceOptimizer.getSwitch() == false) goto L14;
        if (r100 == null) goto L14;
        if (TypeFaceLancet.cache.contains(r100) == true) goto L8;
        Typeface r101 = Typeface.createFromFile(r100);
        if (r101 == null) goto L14;
        TypeFaceLancet.cache.put(r100, r101);
        return r101;
    L8:
        return (Typeface) TypeFaceLancet.cache.get(r100);
    L14:
        return Typeface.createFromFile(r100);
    }

    public static final boolean b(String r110, long r111) {
        CountDownLatch r100 = new CountDownLatch(1);
        Ref.BooleanRef r101 = new Ref.BooleanRef();
        long r102 = System.currentTimeMillis();
        Map<String, GeckoClient> r103 = com.bytedance.geckox.a.f245075a;
        Lazy r104 = f205085b;
        GeckoClient r105 = com.bytedance.geckox.a.a((String) r104.getValue());
        if (r105 != null) goto L5;
        return false;
    L5:
        HashMap r106 = new HashMap();
        ArrayList r107 = new ArrayList();
        r107.add(new CheckRequestBodyModel.TargetChannel(r110));
        r106.put((String) r104.getValue(), r107);
        r105.checkUpdateMulti(null, r106, new OptionCheckUpdateParams().setChannelUpdatePriority(3).setListener(new com.bytedance.dux.font.a(r102, r101, r100, r110)));
        r100.await(r111, TimeUnit.MILLISECONDS);
        return r101.element;
    }

    public static Typeface c(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "fontName");
        Intrinsics.checkNotNullParameter("dux_typeface", "channel");
        ConcurrentHashMap<String, SoftReference<Typeface>> r102 = f205086c;
        SoftReference<Typeface> r103 = r102.get(r101);
        if (r103 == null) goto L7;
        Typeface r104 = r103.get();
        if (r104 == null) goto L7;
        return r104;
    L7:
        c r105 = null;
        c r106 = new c(r100, (String) f205085b.getValue(), new PolarisFileWrapper(r100.getFilesDir().getCanonicalPath() + "/offlineX/"));     // Catch: Throwable -> L18 Exception -> L22
        Typeface r107 = a(r106.a("dux_typeface" + File.separator + r101));     // Catch: Throwable -> L15 Exception -> L17
        if ((!Intrinsics.areEqual(r107, Typeface.DEFAULT)) == true) goto L13;
        r107 = null;
    L13:
        r102.put(r101, new SoftReference(r107));     // Catch: Throwable -> L15 Exception -> L17
        r106.b();
        return r107;
    L15:
        th = th;
        r105 = r106;
    L19:
        if (r105 == null) goto L21;
        r105.b();
    L21:
        throw th;
    L23:
        if (r106 == null) goto L31;
        r106.b();
        return null;
    L31:
        return null;
    L22:
        r106 = null;
    L18:
        th = th;
        goto L19
    }
}
