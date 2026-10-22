package com.ss.android.ugc.aweme.search.service;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostService;
import el9.a;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/ss/android/ugc/aweme/search/service/TradeSearch;", "", "<init>", "()V", ExifInterface.TAG_SCENE_TYPE, "trade-search-api_release"}, k = 1, mv = {1, 4, 3})
public final class TradeSearch {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TradeSearch f453393a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile ConcurrentHashMap<Integer, ITradeSearchHostService> f453394b;

    @Retention(RetentionPolicy.RUNTIME)
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0086\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/search/service/TradeSearch$SceneType;", "", "trade-search-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    public @interface SceneType {
    }

    private TradeSearch() {
    }

    static {
        f453393a = new TradeSearch();
        f453394b = new ConcurrentHashMap();
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

    public static ITradeSearchHostService b(@SceneType int r100) {
        ITradeSearchHostService r101 = f453394b.get(Integer.valueOf(r100));
        if (r101 == null) goto L5;
        return r101;
    L5:
        ITradeSearchHostService r102 = null;
        if (r100 == 0) goto L20;
    L10:
        ITradeSearchHostService r103 = null;
    L11:
        if (r103 != null) goto L17;
        if (r100 == 0) goto L22;
    L16:
        r103 = r102;
        goto L17
    L22:
        Object r104 = a("com.bytedance.android.ec.search.host.impl.ECSearchHostService").newInstance();     // Catch: Throwable -> L15
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostService");     // Catch: Throwable -> L15
        r102 = (ITradeSearchHostService) r104;     // Catch: Throwable -> L15
    L17:
        if (r103 == null) goto L19;
        f453394b.put(Integer.valueOf(r100), r103);
    L19:
        return r103;
    L20:
        Object r105 = a("com.ss.android.ugc.aweme.commerce.sdk.hostimpl.search.ECSearchHostService").newInstance();     // Catch: Throwable -> L9
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostService");     // Catch: Throwable -> L9
        r103 = (ITradeSearchHostService) r105;     // Catch: Throwable -> L9
        goto L11
    }

    public static /* synthetic */ ITradeSearchHostService c(TradeSearch r100) {
        r100.getClass();
        return b(0);
    }
}
