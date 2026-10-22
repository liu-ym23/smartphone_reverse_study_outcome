package l2a;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.larus.video.impl.VideoActivity;
import com.larus.video.impl.widget.PagerLayoutManager;

/* JADX INFO: loaded from: classes32.dex */
public final class m implements PagerLayoutManager.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VideoActivity f507179a;

    public m(VideoActivity r100) {
        this.f507179a = r100;
    }

    @Override // com.larus.video.impl.widget.PagerLayoutManager.a
    public final void a(int r100, int r101) {
        this.f507179a.Q1(r100, r101, "up");
    }

    @Override // com.larus.video.impl.widget.PagerLayoutManager.a
    public final void b(int r100, int r101) {
        this.f507179a.Q1(r100, r101, ILiveRoomPlayFragmentConstant.LOG_DIRECTION_DOWN);
    }
}
