package oo1;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.nio.ByteBuffer;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes8.dex */
public final class g extends PthreadThreadV2 implements d.a {
    public int A;
    public int B;
    public int C;
    public int D;
    public int E;
    public int F;
    public String G;
    public final j H;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final AtomicBoolean f524546v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Context f524547w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final CopyOnWriteArrayList<b> f524548x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f524549y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f524550z;

    public static final class a {
    }

    static {
    }

    @Override // oo1.d.a
    public final void b(int r100) {
    }

    @Override // oo1.d.a
    public final void d(int r100) {
    }

    public final void l() {
        StringBuilder r100 = new StringBuilder("init 是否可以init音频数据:");
        boolean r101 = true;
        r100.append(!this.f524546v.get());
        ALogger.d("VSAudioDataPushThread", r100.toString());
    L4:
        if (this.f524546v.get() == true) goto L9;
        d r102 = f.f524542a;     // Catch: Exception -> L7
        f.f524543b = this.f524547w;     // Catch: Exception -> L7
        f.f524545d = this;     // Catch: Exception -> L7
        f.b(this.A, this.B, this.C, this.D, this.E);     // Catch: Exception -> L7
        this.f524546v.set(true);     // Catch: Exception -> L7
        ALogger.d("VSAudioDataPushThread", "初始化成功");     // Catch: Exception -> L7
    L7:
        e = move-exception;
        ALogger.d("VSAudioDataPushThread", "startRecord Fail:" + e.getMessage());
        this.f524546v.set(false);
        goto L4
    L9:
        ALogger.d("VSAudioDataPushThread", "push 是否可以push音频数据:" + e.f524540f.get());
    L10:
        AtomicBoolean r103 = e.f524540f;
        String r104 = "QuickInsideRecordManager";
        if (r103.get() == false) goto L52;
        ALogger.d("VSAudioDataPushThread", "push 是否有可push的音频数据:" + (CollectionUtils.isEmpty(this.f524548x) ^ r101));
    L14:
        if (CollectionUtils.isEmpty(this.f524548x) == true) goto L10;
        b r105 = (b) CollectionsKt.first(this.f524548x);     // Catch: Exception -> L17
    L18:
        if (r105 == null) goto L47;
        d r106 = f.f524542a;
        byte[] r107 = r105.f524519a;
        int r108 = r105.f524520b;
        int r109 = this.D;
        int r110 = this.E;
        ALogger.d(r104, "pushAudioFrame samples:" + r108 + " channel:" + r109 + " audioFormat:" + r110);
        if (r107 == null) goto L45;
        int r111 = r108 * (r109 * (r110 / 8));
        d r112 = f.f524542a;
        if (r112 == null) goto L45;
        if (r112.f524524c == null) goto L45;
        if (e.f524538d.get() == true) goto L45;
        if (e.f524539e.get() == true) goto L45;
        int r113 = r112.f524524c.dequeueInputBuffer(0);     // Catch: Exception -> L42
        if (r113 >= 0) goto L33;
        ALogger.d("MediaEncodeManager", "return  buffIndex 为:" + r113);     // Catch: Exception -> L42
        goto L45
    L33:
        ByteBuffer r114 = r112.f524524c.getInputBuffer(r113);     // Catch: Exception -> L42
        if (r114 == null) goto L45;
        r114.clear();     // Catch: Exception -> L42
        r114.put(r107);     // Catch: Exception -> L42
        String r115 = r104;
        r112.f524532k = r112.f524532k + ((long) (((((double) r111) * 1.0d) / ((r112.f524529h * ((long) r112.f524530i)) * ((long) (r112.f524531j / 8)))) * 1000000.0d));     // Catch: Exception -> L40
        ALogger.d("MediaEncodeManager", "pcm一帧时间戳 = " + (r112.f524532k / 1000000.0f));     // Catch: Exception -> L40
        r112.f524524c.queueInputBuffer(r113, 0, r111, r112.f524532k, 0);     // Catch: Exception -> L40
    L46:
        ALogger.d("VSAudioDataPushThread", "pushFrame");
    L57:
        this.f524548x.remove(0);     // Catch: Exception -> L50
    L51:
        r104 = r115;
        r101 = true;
    L40:
        e = e;
    L44:
        ALogger.d("MediaEncodeManager", "setPcmSource: MediaCodec对象已释放 msg:" + e.getMessage());
    L42:
        e = e;
        r115 = r104;
    L45:
        r115 = r104;
        goto L46
    L47:
        r115 = r104;
    L17:
        r105 = null;
        goto L18
    L52:
        ALogger.d("VSAudioDataPushThread", "stop pushFrame");
        r103.set(false);
        d r116 = f.f524542a;
        ALogger.i("QuickInsideRecordManager", "stopRecord");
        d r117 = f.f524542a;
        if (r117 == null) goto L55;
        r117.a();
    L55:
        this.f524549y = f.f524544c;
        ALogger.i("QuickInsideRecordManager", "releaseRecorder");
        f.f524544c = "";
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2, java.lang.Thread, java.lang.Runnable
    public final void run() {
        l();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public final Context getContext() {
        return this.f524547w;
    }

    public g(j r100) {
        super("VSAudioDataPushThread");
        this.H = r100;
        this.f524546v = new AtomicBoolean(false);
        this.f524548x = new CopyOnWriteArrayList();
        this.f524549y = "";
        this.G = "";
    }

    @Override // oo1.d.a
    public final void c(String r100, String r101, int r102) {
        this.f524550z++;
        ALogger.i("VSAudioDataPushThread", "processFinish threadFinishNum:" + this.f524550z);
        if (TextUtils.isEmpty(r101) == false) goto L5;
        if (r102 > 0) goto L5;
    L7:
        if (this.f524550z != 2) goto L13;
        j r103 = this.H;
        if (r103 == null) goto L11;
        r103.b(this.f524549y, this.G, this.F);
    L11:
        this.G = "";
        this.F = 0;
        return;
    L13:
        return;
    L5:
        this.G = r101;
        this.F = r102;
        goto L7
    }
}
