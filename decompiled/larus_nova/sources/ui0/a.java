package ui0;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.depend.player.ILivePlatformPlayerProxy;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f550118a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ILivePlayerClient f550119b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f550120c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LifecycleOwner f550121d;

    /* JADX INFO: renamed from: ui0.a$a, reason: collision with other inner class name */
    public static final class C7886a {
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f550122a;

        public b(a r100) {
            this.f550122a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Boolean r101 = (Boolean) r100;
            ALogger.i("LivePlayerMediaManager", "livePlayerClient, update isMute: " + r101 + ", LivePlayerMediaManager: " + this.f550122a);
            if (this.f550122a.f550118a == true) goto L5;
            return;
        L5:
            if (Intrinsics.areEqual(r101, Boolean.FALSE) == false) goto L9;
            ALogger.i("LivePlayerMediaManager", "keep mute");
            this.f550122a.b(true);
            vi0.b.b();
            return;
        }
    }

    static {
    }

    public final ILivePlayerClient a() {
        if (this.f550119b != null) goto L23;
        ILivePlatformPlayerProxy r100 = hs0.a.f486938b.curRoomPlayer();
        Boolean r101 = null;
        if (r100 == null) goto L7;
        ILivePlayerClient r102 = r100.player();
    L8:
        this.f550119b = r102;
        StringBuilder r103 = new StringBuilder("getLivePlayerClient, isMute: ");
        ILivePlayerClient r104 = this.f550119b;
        if (r104 == null) goto L15;
        IRoomEventHub r105 = r104.getEventHub();
        if (r105 == null) goto L15;
        MutableLiveData<Boolean> r106 = r105.getPlayerMute();
        if (r106 == null) goto L15;
        r101 = r106.getValue();
    L15:
        r103.append(r101);
        ALogger.i("LivePlayerMediaManager", r103.toString());
        ILivePlayerClient r107 = this.f550119b;
        if (r107 == null) goto L23;
        IRoomEventHub r108 = r107.getEventHub();
        if (r108 == null) goto L23;
        MutableLiveData<Boolean> r109 = r108.getPlayerMute();
        if (r109 == null) goto L23;
        ALogger.i("LivePlayerMediaManager", "add playerMuteObserver");
        r109.observe(this.f550121d, this.f550120c);
        goto L23
    L7:
        r102 = null;
    L23:
        return this.f550119b;
    }

    public a(LifecycleOwner r100) {
        Intrinsics.checkNotNullParameter(r100, "liveCycleOwner");
        this.f550121d = r100;
        this.f550120c = new b(this);
    }

    public final void b(boolean r100) {
        this.f550118a = r100;
        ALogger.i("LivePlayerMediaManager", "muteLiveRoom, isMute: " + r100);
        if (r100 == false) goto L7;
        ILivePlayerClient r101 = a();
        if (r101 == null) goto L11;
        r101.mute("LivePlayerMediaManager.mute");
        return;
    L11:
        return;
    L7:
        ILivePlayerClient r102 = a();
        if (r102 == null) goto L13;
        r102.unmute("LivePlayerMediaManager.mute");
        return;
    }
}
