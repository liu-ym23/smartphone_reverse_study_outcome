package ro2;

import com.bytedance.android.livesdkapi.player.ILivePlayerFeatureManager;

/* JADX INFO: loaded from: classes11.dex */
public final class a implements ILivePlayerFeatureManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f538762a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f538763b = null;

    public a() {
    }

    static {
        f538763b = new a();
        f538762a = true;
    }

    @Override // com.bytedance.android.livesdkapi.player.ILivePlayerFeatureManager
    public final boolean audioFocusListenerIsOpen() {
        return f538762a;
    }

    @Override // com.bytedance.android.livesdkapi.player.ILivePlayerFeatureManager
    public final void openAudioFocusListener(boolean r100) {
        f538762a = r100;
    }
}
