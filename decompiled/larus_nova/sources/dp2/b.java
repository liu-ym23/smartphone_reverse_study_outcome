package dp2;

import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdk.config.n11;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import jc1.k;

/* JADX INFO: loaded from: classes11.dex */
public final class b implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f469580a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f469581b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f469582c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f469583d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f469584e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f469585f;

    @Override // dp2.c
    public final cp2.b execute() {
        cp2.b r100 = fp2.b.a();
        boolean r101 = true;
        if (this.f469580a == true) goto L5;
    L8:
        boolean r102 = true;
    L9:
        r100.f464628a = r102;
        if (this.f469583d == true) goto L12;
    L19:
        r100.f464629b = r101;
        return r100;
    L12:
        if (this.f469584e == false) goto L14;
    L18:
        r101 = false;
        goto L19
    L14:
        if (this.f469582c == false) goto L19;
        if (this.f469585f == true) goto L18;
    L5:
        if (this.f469581b == false) goto L8;
        r102 = false;
        goto L9
    }

    public b(n11.b.a r100) {
        Boolean r101 = r100.g();
        boolean r102 = false;
        if (r101 == null) goto L5;
        boolean r103 = r101.booleanValue();
    L6:
        this.f469580a = r103;
        Boolean r104 = r100.a();
        if (r104 == null) goto L9;
        boolean r105 = r104.booleanValue();
    L10:
        this.f469581b = r105;
        Boolean r106 = r100.f();
        if (r106 == null) goto L13;
        boolean r107 = r106.booleanValue();
    L14:
        this.f469582c = r107;
        Boolean r108 = r100.h();
        if (r108 == null) goto L17;
        boolean r109 = r108.booleanValue();
    L18:
        this.f469583d = r109;
        Boolean r110 = r100.e();
        if (r110 == null) goto L21;
        r110.booleanValue();
    L21:
        Boolean r111 = r100.b();
        if (r111 == null) goto L24;
        r102 = r111.booleanValue();
    L24:
        this.f469584e = r102;
        if (fp2.b.b() == LiveMode.AUDIO) goto L27;
    L31:
        this.f469585f = ((IInteractService) k.n(IInteractService.class)).enableCaptureAudioOnBackground(true);
        return;
    L27:
        if (fp2.b.e() == false) goto L31;
        IBroadcastService r112 = (IBroadcastService) va1.b.a.f553922a.a(IBroadcastService.class);
        if (r112 == null) goto L31;
        r112.broadcastFloatWindowManager();
        goto L31
    L17:
        r109 = false;
        goto L18
    L13:
        r107 = false;
        goto L14
    L9:
        r105 = false;
        goto L10
    L5:
        r103 = false;
        goto L6
    }
}
