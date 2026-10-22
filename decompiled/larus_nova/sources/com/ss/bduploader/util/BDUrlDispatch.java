package com.ss.bduploader.util;

import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.bduploader.BDUploadUtil;
import el9.a;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes40.dex */
public class BDUrlDispatch {
    private static final String TAG = "ttmn";
    private static final String URL_DISPATCHRESULT_CLASS_NAME = "com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.DispatchResult";
    private static final String URL_DISPATCH_CLASS_NAME = "com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.URLDispatcher";
    private static final String URL_REQUEST_CLASS_NAME = "com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.URLRequest";
    private static volatile BDUrlDispatch mInstance;
    public long mDispatchDuration;
    private final ReentrantReadWriteLock mDispatchlock;
    public String mTncTag;

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static BDUrlDispatch inst() {
        if (mInstance != null) goto L15;
        monitor-enter(BDUrlDispatch.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mInstance != null) goto L9;
        mInstance = new BDUrlDispatch();     // Catch: Throwable -> L11
    L9:
        monitor-exit(BDUrlDispatch.class);     // Catch: Throwable -> L11
    L15:
        return mInstance;
    }

    public BDUrlDispatch() {
        this.mDispatchlock = new ReentrantReadWriteLock();
        this.mDispatchDuration = -1;
        this.mTncTag = null;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_ss_bduploader_util_BDUrlDispatch_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
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
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
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

    private String doOkHttpDispatchPrivate(String r110, String r111) throws Exception {
        Class r100 = INVOKESTATIC_com_ss_bduploader_util_BDUrlDispatch_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(URL_DISPATCH_CLASS_NAME);
        Object r101 = r100.getMethod("inst", new Class[0]).invoke(null, new Object[0]);
        Boolean r102 = (Boolean) r100.getMethod("isDispatchActionsEmpty", new Class[0]).invoke(r101, new Object[0]);
        this.mTncTag = (String) r100.getMethod("getTncEtag", new Class[0]).invoke(r101, new Object[0]);
        if (r102.booleanValue() == true) goto L18;
        long r103 = System.currentTimeMillis();
        Class<?> r104 = INVOKESTATIC_com_ss_bduploader_util_BDUrlDispatch_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(URL_REQUEST_CLASS_NAME);
        Object r112 = r104.getConstructor(new Class[]{String.class, String.class}).newInstance(new Object[]{r110, r111});
        Object r113 = r100.getMethod("getDispatchResultForUrl", new Class[]{r104}).invoke(r101, new Object[]{r112});
        this.mDispatchDuration = System.currentTimeMillis() - r103;
        if (r113 == null) goto L24;
        Class r105 = INVOKESTATIC_com_ss_bduploader_util_BDUrlDispatch_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(URL_DISPATCHRESULT_CLASS_NAME);
        String r106 = (String) r105.getField("mDispatchedURL").get(r113);
        if (r110.equals(r106) == true) goto L24;
        List r114 = (List) r105.getField("mActionRuleIdList").get(r113);
        if (r106.isEmpty() == false) goto L16;
        if (r114.isEmpty() == true) goto L16;
        throw new Exception("ERR_TTNET_TRAFFIC_CONTROL_DROP, -555");
    L16:
        if (UrlUtils.isValidUrl(r106) == false) goto L24;
        r110 = r106;
    L24:
        return r110;
    L18:
        long r107 = System.currentTimeMillis();
        String r115 = (String) r100.getMethod("handleHostMapping", new Class[]{String.class}).invoke(r101, new Object[]{r110});
        this.mDispatchDuration = System.currentTimeMillis() - r107;
        if (r110.equals(r115) == true) goto L24;
        if (UrlUtils.isValidUrl(r115) == false) goto L24;
        r110 = r115;
        goto L24
    }

    public String getDispatchUrl(String r100, String r101) {
        this.mDispatchlock.writeLock().lock();
        this.mDispatchDuration = -1;
        String r102 = doOkHttpDispatchPrivate(r100, r101);     // Catch: Exception -> L5
    L10:
        this.mDispatchlock.writeLock().unlock();
        return r102;
    L5:
        e = move-exception;
        e.printStackTrace();
        e.toString();
        if (BDUploadUtil.urlDispatch == null) goto L9;
        r102 = BDUploadUtil.urlDispatch.doDispatchUrl(r100, r101);
        goto L10
    L9:
        r102 = null;
        goto L10
    }
}
