package ui0;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f550123a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ui0.a f550124b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LifecycleOwner f550125c;

    public static final class a {
    }

    static {
    }

    public b(LifecycleOwner r100) {
        Intrinsics.checkNotNullParameter(r100, "liveCycleOwner");
        this.f550125c = r100;
    }

    public final void a(boolean r100, String r101) {
        ALogger.i("LiveRoomAudioManger", "muteLivePlayer, isMute: " + r100 + ", source: " + r101 + ", isLivePlayerMuteByGuestLink: " + this.f550123a);
        if (this.f550124b != null) goto L5;
        this.f550124b = new ui0.a(this.f550125c);
    L5:
        boolean r102 = false;
        if (r100 == false) goto L19;
        ui0.a r103 = this.f550124b;
        if (r103 == null) goto L24;
        ILivePlayerClient r104 = r103.a();
        if (r104 != null) goto L12;
    L14:
        if (r102 == true) goto L25;
        ALogger.i("LiveRoomAudioManger", "muteLivePlayer true");
        this.f550123a = true;
        ui0.a r105 = this.f550124b;
        if (r105 == null) goto L26;
        r105.b(true);
        return;
    L26:
        return;
    L25:
        return;
    L12:
        if (r104.isMute() != true) goto L14;
        r102 = true;
        goto L14
    L24:
        return;
    L19:
        if (this.f550123a == false) goto L28;
        ALogger.i("LiveRoomAudioManger", "muteLivePlayer false");
        this.f550123a = false;
        ui0.a r106 = this.f550124b;
        if (r106 == null) goto L29;
        r106.b(false);
        return;
    L29:
        return;
    }
}
