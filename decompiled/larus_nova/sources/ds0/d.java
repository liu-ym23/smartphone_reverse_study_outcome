package ds0;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.live.core.setting.p3;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.livesdk.chatroom.room.LiveRoomMetrics;
import com.bytedance.android.livesdk.chatroom.room.p0;
import com.bytedance.android.livesdk.config.tl0;
import com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VSCameraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.room.RoomBaseSession;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public abstract class d extends RoomBaseSession {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f469814a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<String> f469815b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f469816c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f469817d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<String> f469818e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f469819f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f469820g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f469821h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f469822i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f469823j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f469824k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f469825l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public VSCameraInfo f469826m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f469827n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public List<String> f469828o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f469829p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f469830q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f469831r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f469832s;

    public abstract void a(String r100);

    public abstract void b(IBaseStreamUrl r100);

    public abstract void c(VSCameraInfo r100);

    public abstract Context d();

    public abstract p0 e();

    public abstract Bundle f();

    public int i() {
        return 0;
    }

    public int j() {
        return 0;
    }

    public boolean k() {
        return false;
    }

    public abstract LiveRoomMetrics o();

    public boolean s() {
        return false;
    }

    public boolean t() {
        return false;
    }

    public boolean u() {
        return false;
    }

    public abstract boolean v();

    public abstract Room w();

    public abstract long x();

    public abstract void z();

    @Override // com.bytedance.android.livesdkapi.depend.model.live.room.RoomBaseSession
    public Pair<Integer, Integer> getVideoSize() {
        ILivePlayerClient r100 = m();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getVideoSize();
    }

    public final boolean l() {
        return LivePlatformPlayerManager.c(x(), false).k();
    }

    public final ILivePlayerClient m() {
        return LivePlatformPlayerManager.c(x(), v()).player();
    }

    public final IRoomEventHub n() {
        ILivePlayerClient r100 = m();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getEventHub();
    }

    public List<String> g() {
        return this.f469818e;
    }

    public List<String> h() {
        return this.f469814a;
    }

    public int p() {
        return this.f469816c;
    }

    public List<String> q() {
        return this.f469815b;
    }

    public Observer<Boolean> r() {
        return this.f469817d;
    }

    public void y(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f469815b = r100;
    }

    public d(Context r100, Bundle r101, hn1.e r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "inExtra");
        Intrinsics.checkNotNullParameter(r102, "roomLog");
        super(r100, r101, r102);
        this.f469814a = CollectionsKt.emptyList();
        this.f469815b = CollectionsKt.emptyList();
        this.f469816c = -1;
        this.f469817d = c.f469813a;
        this.f469818e = CollectionsKt.emptyList();
        this.f469831r = tl0.f121309a.getValue().booleanValue();
        this.f469832s = p3.f65382a.getValue().booleanValue();
    }
}
