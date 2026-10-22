package com.ss.android.lark.videosend.checker.raw;

import android.os.Handler;
import android.os.Looper;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.monitor.callback.CpuCallbackManager;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.storage.kv.repo.KVRepo;
import com.ss.android.lark.videosend.abtest.RawABTestExperimentController;
import com.ss.android.lark.videosend.pre.PreRawConfig;
import com.ss.android.lark.videosend.pre.VideoPreProcessSettingUtils;
import com.ss.android.lark.videosend.tools.k;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public final class VideoPreCheckRawService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PreRawConfig f444862a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Integer> f444863b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f444864c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final CopyOnWriteArrayList<String> f444865d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Executor f444866e = null;

    public interface a {
        void onFinish();
    }

    public static final class b implements com.ss.android.lark.videosend.checker.raw.a.InterfaceC5380a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f444867a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f444868b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ a f444869c;

        @Override // com.ss.android.lark.videosend.checker.raw.a.InterfaceC5380a
        public final void onResult(String r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "mediaPath");
            int r102 = this.f444867a;
            long r103 = System.currentTimeMillis() - this.f444868b;
            int r104 = k.f445017a;
            JSONObject r105 = new JSONObject();
            r105.put("cpuUsage", r102);
            r105.put("duration", r103);
            r105.put("result", r101);
            Log.i("VideoSendMonitor", "report media check raw: " + r105);
            Statistics.sendEvent("video_predicte_check_raw_dev", r105);
            VideoPreCheckRawService.f444863b.put(r100, Integer.valueOf(r101));
            ((KVRepo) VideoPreCheckRawService.f444864c.getValue()).putInt(r100, r101);
            VideoPreCheckRawService.f444865d.remove(r100);
            VideoPreCheckRawService.a(this.f444869c);
        }

        public b(int r100, long r101, a r102) {
            this.f444867a = r100;
            this.f444868b = r101;
            this.f444869c = r102;
        }
    }

    static {
        f444862a = (PreRawConfig) VideoPreProcessSettingUtils.f444966f.getValue();
        f444863b = new ConcurrentHashMap();
        f444864c = LazyKt.lazy(VideoPreCheckRawService$resultKvRepo$2.INSTANCE);
        f444865d = new CopyOnWriteArrayList();
        f444866e = CoreThreadPool.getDefault().getSingleScheduledThreadPool("lk-media-pre-check-raw");
    }

    public static void a(a r100) {
        String r101 = (String) CollectionsKt.firstOrNull(f444865d);
        StringBuilder r102 = new StringBuilder("check next, mediaPath:");
        if (r101 == null) goto L5;
        Integer r103 = Integer.valueOf(r101.hashCode());
    L6:
        r102.append(r103);
        Log.i("VideoPreCheckRawService", r102.toString());
        if (r101 != null) goto L9;
        Log.i("VideoPreCheckRawService", "onFinish");
        new Handler(Looper.getMainLooper()).post(new d(r100));
        return;
    L9:
        int r104 = (int) CpuCallbackManager.a().f432362c;
        long r105 = System.currentTimeMillis();
        Executor r106 = f444866e;
        if (r106 == null) goto L14;
        r106.execute(new com.ss.android.lark.videosend.checker.raw.a(r101, new b(r104, r105, r100)));
        return;
    L14:
        return;
    L5:
        r103 = null;
        goto L6
    }

    @JvmStatic
    public static final boolean b(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "mediaPath");
        boolean r102 = false;
        if (f444862a.getEnable() == 1) goto L5;
    L22:
        return r102;
    L5:
        if (((Boolean) RawABTestExperimentController.f444841a.getValue()).booleanValue() == false) goto L22;
        Integer r103 = f444863b.get(r100);
        if (r103 == null) goto L10;
        int r104 = r103.intValue();
    L12:
        if (r101 == false) goto L18;
        if (r104 == 3) goto L20;
        if (r104 == 4) goto L20;
    L21:
        Log.i("VideoPreCheckRawService", "mediaPath:" + r100.hashCode() + ", isOrigin:" + r101 + ", isRaw:" + r102);
    L20:
        r102 = true;
        goto L21
    L18:
        if (r104 == 2) goto L20;
        if (r104 != 4) goto L21;
    L10:
        r104 = ((KVRepo) f444864c.getValue()).getInt(r100, 1);
        goto L12
    }
}
