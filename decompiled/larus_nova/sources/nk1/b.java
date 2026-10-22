package nk1;

import com.bytedance.android.livesdk.castscreen.leboController.bytecast.ui.CastStreamTimeShiftContext;
import com.bytedance.android.livesdk.castscreen.leboController.bytecast.ui.LiveByteCastUIManager;
import com.bytedance.live.datacontext.m;

/* JADX INFO: loaded from: classes7.dex */
public final class b implements com.bytedance.android.livesdk.chatroom.progressbar.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CastStreamTimeShiftContext f519477a;

    @Override // com.bytedance.android.livesdk.chatroom.progressbar.b
    public final m<Long> a() {
        return this.f519477a.getCurrentDisplayTime();
    }

    @Override // com.bytedance.android.livesdk.chatroom.progressbar.b
    public final m<Boolean> b() {
        return this.f519477a.isCastPlaying();
    }

    @Override // com.bytedance.android.livesdk.chatroom.progressbar.b
    public final m<mf1.b> c() {
        return this.f519477a.getAtLatest();
    }

    @Override // com.bytedance.android.livesdk.chatroom.progressbar.b
    public final m<Boolean> d() {
        return this.f519477a.isSupportStreamTimeShift();
    }

    @Override // com.bytedance.android.livesdk.chatroom.progressbar.b
    public final m<Long> getCurrentTime() {
        return this.f519477a.getCurrentTime();
    }

    @Override // com.bytedance.android.livesdk.chatroom.progressbar.b
    public final m<Long> getTotalTime() {
        return this.f519477a.getTotalTime();
    }

    public b() {
        String r100 = LiveByteCastUIManager.f104549a;
        this.f519477a = LiveByteCastUIManager.f104555g;
    }
}
