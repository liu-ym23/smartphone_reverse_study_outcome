package q71;

import com.bytedance.android.live.room.api.messagewindow.container.MsgWindowPosition;
import com.bytedance.android.livesdk.message.model.e3;
import r71.f;

/* JADX INFO: loaded from: classes47.dex */
public interface a extends b {

    /* JADX INFO: renamed from: q71.a$a, reason: collision with other inner class name */
    public static final class C7292a {
        public static /* synthetic */ d a(a r100, e3 r101) {
            return r100.c(r101, MsgWindowPosition.BOTTOM_RIGHT);
        }
    }

    @Override // q71.b
    d a();

    d<f> c(e3 r100, MsgWindowPosition r101);
}
