package uo2;

import android.view.Surface;
import android.view.SurfaceHolder;
import com.bytedance.android.livesdk.player.LivePlayerContext;
import com.bytedance.android.livesdk.player.rtcplay.ILiveRTCPlayerService;
import com.bytedance.android.livesdkapi.model.WtnPlayEvent;
import com.bytedance.android.livesdkapi.model.WtnStopType;
import java.util.Objects;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f550905a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f550906b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SurfaceHolder f550907c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Surface f550908d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f550909e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f550910f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c f550911g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LivePlayerContext f550912h;

    /* JADX INFO: renamed from: uo2.a$a, reason: collision with other inner class name */
    public static final class C7906a {
    }

    public static final class b implements SurfaceHolder.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f550913a;

        public b(a r100) {
            this.f550913a = r100;
        }

        @Override // android.view.SurfaceHolder.Callback
        public final void surfaceCreated(SurfaceHolder r100) {
            Intrinsics.checkNotNullParameter(r100, "holder");
            a r101 = this.f550913a;
            r101.getClass();
            r101.f550912h.e("LiveRTCPlayer: surfaceCreated false", true);
            this.f550913a.getClass();
        }

        @Override // android.view.SurfaceHolder.Callback
        public final void surfaceDestroyed(SurfaceHolder r100) {
            Intrinsics.checkNotNullParameter(r100, "holder");
            a r101 = this.f550913a;
            r101.getClass();
            r101.f550912h.e("LiveRTCPlayer: surfaceDestroyed false", true);
            this.f550913a.getClass();
        }

        @Override // android.view.SurfaceHolder.Callback
        public final void surfaceChanged(SurfaceHolder r100, int r101, int r102, int r103) {
            Intrinsics.checkNotNullParameter(r100, "holder");
            a r104 = this.f550913a;
            r104.getClass();
            r104.f550912h.e("LiveRTCPlayer: surfaceChanged false", true);
            this.f550913a.getClass();
        }
    }

    public static final class c implements ILiveRTCPlayerService.a {
        public c() {
        }
    }

    static {
    }

    public final void a() {
        this.f550912h.e("LiveRTCPlayer:attachToSurface " + this.f550908d + ' ' + this.f550907c, true);
        Objects.toString(this.f550908d);
        Objects.toString(this.f550907c);
        ILiveRTCPlayerService r100 = (ILiveRTCPlayerService) k.f(ILiveRTCPlayerService.class);
        if (r100 == null) goto L14;
        Surface r101 = this.f550908d;
        if (r101 == null) goto L7;
        r100.setWtnStreamPlaySurface(this.f550905a, r101);
        goto L14
    L7:
        SurfaceHolder r102 = this.f550907c;
        if (r102 == null) goto L14;
        r102.addCallback(this.f550910f);
        String r103 = this.f550905a;
        SurfaceHolder r104 = this.f550907c;
        if (r104 == null) goto L12;
        Surface r105 = r104.getSurface();
    L13:
        r100.setWtnStreamPlaySurface(r103, r105);
        goto L14
    L12:
        r105 = null;
    L14:
        this.f550909e = true;
        b(this, WtnPlayEvent.Companion.getSTATE_PLAYING());
    }

    public a(LivePlayerContext r100) {
        Intrinsics.checkNotNullParameter(r100, "playerContext");
        this.f550912h = r100;
        WtnPlayEvent.Companion.getSTATE_IDLE();
        this.f550910f = new b(this);
        this.f550911g = new c();
    }

    public final void c(int r100) {
        if (this.f550906b == false) goto L15;
        this.f550912h.e("LiveRTCPlayer:stopWtnPlay: isInWtnPlay", true);
        this.f550906b = false;
        this.f550909e = false;
        ILiveRTCPlayerService r101 = (ILiveRTCPlayerService) k.f(ILiveRTCPlayerService.class);
        if (r101 == null) goto L7;
        r101.stopPlayWtnStream(this.f550905a, true, true);
        r101.releaseWtnStream(this.f550905a);
    L7:
        WtnStopType.Companion r102 = WtnStopType.Companion;
        if (r100 != r102.getSTOP_WTN_TYPE_NORMAL()) goto L11;
        b(this, WtnPlayEvent.Companion.getSTATE_CLOSED());
        return;
    L11:
        if (r100 != r102.getSTOP_WTN_TYPE_FALLBACK()) goto L13;
        b(this, WtnPlayEvent.Companion.getSTATE_FALLBACKED());
        return;
    L13:
        b(this, WtnPlayEvent.Companion.getSTATE_CLOSED());
        return;
    }

    public static void b(a r100, int r101) {
        r100.f550912h.M.f155061f0.postValue(new WtnPlayEvent(r101, null));
    }
}
