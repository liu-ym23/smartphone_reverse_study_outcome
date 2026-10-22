package qm2;

import com.bytedance.android.livesdk.message.model.vg;
import com.bytedance.android.livesdk.microom.MicRoomAnchorTimeControlWidget;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes11.dex */
public final class p<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MicRoomAnchorTimeControlWidget f533859a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ vg f533860b;

    public p(MicRoomAnchorTimeControlWidget r100, vg r101) {
        this.f533859a = r100;
        this.f533860b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        MicRoomAnchorTimeControlWidget r102 = this.f533859a;
        vg r103 = this.f533860b;
        int r104 = MicRoomAnchorTimeControlWidget.f153735g;
        r102.xq(r103);
    }
}
