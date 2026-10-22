package com.bytedance.android.livesdk.ktvimpl.crossplatform.player;

import com.bytedance.android.live.core.utils.FileUtils;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.tuningpanel.tuningeffect.ability.TuningEffectAbility;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import java.io.File;
import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class h<T> implements SingleOnSubscribe {
    public final /* synthetic */ g a;
    public final /* synthetic */ com.bytedance.android.live.ktv.common.model.bean.h b;

    public h(g r1, com.bytedance.android.live.ktv.common.model.bean.h r2) {
        this.a = r1;
        this.b = r2;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r2 = Class.forName("com.ss.android.socialbase.downloader.model.DownloadTask");     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.ss.android.socialbase.downloader.model.DownloadTask");     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.ss.android.socialbase.downloader.model.DownloadTask");
    L12:
        throw th;
    L34:
        Class<?> r3 = Class.forName("com.ss.android.socialbase.downloader.model.DownloadTask");     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.ss.android.socialbase.downloader.model.DownloadTask");     // Catch: Throwable -> L17
    L16:
        return r3;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.ss.android.socialbase.downloader.model.DownloadTask");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.ss.android.socialbase.downloader.model.DownloadTask");
    }

    public final void subscribe(SingleEmitter<String> r18) {
        Intrinsics.checkNotNullParameter(r18, "observer");
        g r0 = this.a;
        com.bytedance.android.live.ktv.common.model.bean.h r3 = this.b;
        r0.getClass();
        StringBuilder r4 = new StringBuilder(r0.e);
        r4.append(r3.d());
        String r1 = File.separator;
        r4.append(r1);
        r4.append(r3.d());
        r4.append("_version_");
        r4.append(r3.f());
        r4.append(".json");
        String r5 = r4.toString();
        if (new PolarisFileWrapper(r5).exists() == false) goto L5;
        r18.onSuccess(r5);
        return;
    L5:
        this.a.getClass();
        FileUtils.removeDir(new PolarisFileWrapper(r5));
        g r6 = this.a;
        r6.b = null;
        Integer r7 = r6.c;
        if (r7 == null) goto L8;
        Downloader.getInstance(s1.getContext()).cancel(r7.intValue());
    L8:
        g r8 = this.a;
        com.bytedance.android.live.ktv.common.model.bean.h r9 = this.b;
        r8.getClass();
        List r10 = r9.b().getUrls();
        if (CollectionsKt.getLastIndex(r10) < 0) goto L11;
        Object r11 = ListProtector.get(r10, 0);
    L12:
        g r13 = this.a;
        DownloadTask r12 = Downloader.with(s1.getContext()).url((String) r11);
        this.a.getClass();
        int r14 = StringsKt.lastIndexOf$default(r5, "/", 0, false, 6, null);
        if (r14 == (-1)) goto L18;
        if (r5 == null) goto L17;
        String r15 = r5.substring(r14);
    L19:
        DownloadTask r16 = r12.name(r15);
        g r17 = this.a;
        r17.getClass();
        int r19 = StringsKt.lastIndexOf$default(r5, "/", 0, false, 6, null);
        if (r19 == (-1)) goto L25;
        if (r5 == null) goto L24;
        String r2 = r5.substring(0, r19);
    L26:
        r13.b = r16.savePath(r2).monitorScene("musicpack_tuningeffect");
        DownloadTask r20 = this.a.b;
        if (r20 == null) goto L42;
        r20.autoRemoveCallback(true);
    L42:
        Class r21 = a();     // Catch: Exception -> L31
        Object r22 = r21.newInstance();     // Catch: Exception -> L31
        Method r23 = r21.getDeclaredMethod("setCacheLifeTimeMax", new Class[0]);     // Catch: Exception -> L31
        r23.setAccessible(true);     // Catch: Exception -> L31
        r23.invoke(r22, new Object[]{1209600});     // Catch: Exception -> L31
    L33:
        this.a.d = new TuningEffectAbility.b(r18, r5);
        g r24 = this.a;
        DownloadTask r25 = r24.b;
        if (r25 == null) goto L36;
        r25.mainThreadListener(r24.d);
    L36:
        g r26 = this.a;
        DownloadTask r27 = r26.b;
        if (r27 == null) goto L39;
        Integer r110 = Integer.valueOf(r27.download());
    L40:
        r26.c = r110;
        return;
    L39:
        r110 = null;
    L31:
        e = move-exception;
        com.bytedance.android.livesdk.ktvimpl.crossplatform.a.a("TuningEffectManager", "set cache life time max fail : " + e.getMessage());
        goto L33
    L24:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L25:
        r2 = r17.e + "none" + r1;
        goto L26
    L17:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L18:
        r15 = "none.json";
        goto L19
    L11:
        r11 = "";
        goto L12
    }
}
