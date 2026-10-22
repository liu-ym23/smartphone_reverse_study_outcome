package hs0;

import android.view.View;
import com.bytedance.android.live.player.ILivePlatformPlayerManagerAdapter;
import com.bytedance.android.livesdkapi.depend.player.ILivePlatformPlayerProxy;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import jc1.k;

/* JADX INFO: loaded from: classes46.dex */
public final class a implements ILivePlatformPlayerManagerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ILivePlatformPlayerManagerAdapter f486937a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f486938b = null;

    public a() {
    }

    static {
        f486938b = new a();
        f486937a = (ILivePlatformPlayerManagerAdapter) k.n(ILivePlatformPlayerManagerAdapter.class);
    }

    @Override // com.bytedance.android.live.player.ILivePlatformPlayerManagerAdapter
    public final ILivePlatformPlayerProxy curRoomPlayer() {
        return f486937a.curRoomPlayer();
    }

    @Override // com.bytedance.android.live.player.ILivePlatformPlayerManagerAdapter
    public final ILivePlayerClient getCurrentClient() {
        return f486937a.getCurrentClient();
    }

    @Override // com.bytedance.android.live.player.ILivePlatformPlayerManagerAdapter
    public final View getCurrentLivePlayerParent() {
        return f486937a.getCurrentLivePlayerParent();
    }
}
