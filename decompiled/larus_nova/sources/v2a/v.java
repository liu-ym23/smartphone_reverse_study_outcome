package v2a;

import com.google.android.material.appbar.AppBarLayout;
import com.larus.utils.logger.FLogger;
import com.larus.voice_setting.voice.base.AppBarLayoutStateListener;
import com.larus.voice_setting.voice.mix.VoiceMixBar;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class v extends AppBarLayoutStateListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ VoiceMixBar f552764b;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f552765a = null;

        static {
            int[] r100 = new int[AppBarLayoutStateListener.State.values().length];
            r100[AppBarLayoutStateListener.State.COLLAPSED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            f552765a = r100;
        }
    }

    public v(VoiceMixBar r100) {
        this.f552764b = r100;
    }

    @Override // com.larus.voice_setting.voice.base.AppBarLayoutStateListener
    public final void a(AppBarLayout r100, AppBarLayoutStateListener.State r101, AppBarLayoutStateListener.State r102) {
        Intrinsics.checkNotNullParameter(r100, "appBarLayout");
        Intrinsics.checkNotNullParameter(r101, "lastState");
        Intrinsics.checkNotNullParameter(r102, "state");
        FLogger.f375446a.i("VoiceMixBar", "[onStateChange] last:" + r101 + ", state=" + r102);
        if (a.f552765a[r102.ordinal()] != 1) goto L5;
        VoiceMixBar r103 = this.f552764b;
        r103.f376912c = r102;
        r103.applyState();
        return;
    L5:
        VoiceMixBar r104 = this.f552764b;
        r104.f376912c = r102;
        r104.applyState();
    }
}
