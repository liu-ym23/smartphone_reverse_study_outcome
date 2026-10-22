package h88;

import com.larus.audio.call.RealtimeCallParam;
import com.larus.audio.call.mgr.MajorState;
import com.larus.av_call.constant.ThemeType;
import com.larus.av_call.model.RealtimePageMode;
import com.larus.im.service.audio.AudioSessionType;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public class b implements t1a.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f484260a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f484261b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f484262c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f484263d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AudioSessionType f484264e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f484265f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f484266g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f484267h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ThemeType f484268i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public RealtimeCallParam f484269j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f484270k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public MajorState f484271l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f484272m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f484273n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f484274o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f484275p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f484276q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f484277r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f484278s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f484279t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public RealtimePageMode f484280u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f484281v;

    public static final class a {
    }

    static {
    }

    public final RealtimeCallParam a() {
        RealtimeCallParam r100 = this.f484269j;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("callParam");
        return null;
    }

    public String toString() {
        return "localCallId:" + this.f484260a + ",taskId:" + this.f484261b + ",isMainBot:" + this.f484263d + ",avSessionType:" + this.f484264e + ",useNewConn: " + this.f484265f + ",isShowChooseSceneButton:" + this.f484267h + ",themeType:" + this.f484268i + ",currentState:" + this.f484270k + ",muted:" + this.f484272m + ",paused:" + this.f484273n + ",endMethod:" + this.f484274o;
    }

    public b() {
        this.f484260a = UUID.randomUUID().toString();
        this.f484261b = UUID.randomUUID().toString();
        this.f484262c = "";
        this.f484264e = AudioSessionType.RTC;
        this.f484268i = ThemeType.DEFAULT;
        this.f484270k = -1;
        this.f484271l = MajorState.c.f289181c;
        this.f484280u = RealtimePageMode.FULL_SCREEN;
    }
}
