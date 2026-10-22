package yn0;

import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.room.IMicRoomService;

/* JADX INFO: loaded from: classes46.dex */
public final class o implements l81.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f568511a = null;

    public o() {
    }

    static {
        f568511a = new o();
    }

    @Override // l81.o
    public final Class<? extends LiveRecyclableWidget> getMicRoomOfficialInfoWidget() {
        return ((IMicRoomService) jc1.k.n(IMicRoomService.class)).getMicRoomOfficialInfoWidget();
    }
}
