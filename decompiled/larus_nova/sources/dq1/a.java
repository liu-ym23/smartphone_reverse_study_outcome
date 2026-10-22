package dq1;

import android.os.Bundle;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.liveinteract.hamlet.HamletAvatarWidget$addDataChangeObserver$$inlined$let$lambda$10;
import com.bytedance.android.livesdk.chatroom.utils.u4;
import com.bytedance.android.livesdk.chatroom.utils.v4;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VSCameraInfo;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public interface a {

    /* JADX INFO: renamed from: dq1.a$a, reason: collision with other inner class name */
    public static final class C5698a {
        public static /* synthetic */ void a(a r100, Long r101, Bundle r102, boolean r103, String r104, Boolean r105, int r106) {
            if ((r106 & 1) == 0) goto L6;
            r101 = null;
        L6:
            if ((r106 & 2) == 0) goto L9;
            r102 = null;
        L9:
            if ((r106 & 4) == 0) goto L12;
            r103 = false;
        L12:
            if ((r106 & 8) == 0) goto L15;
            r104 = null;
        L15:
            if ((r106 & 16) == 0) goto L17;
            r105 = null;
        L17:
            r100.l4(r101, r102, r103, r104, r105);
        }
    }

    VSCameraInfo C4();

    void D4(e r100);

    void F4(v4 r100);

    int W3();

    void c4(LifecycleOwner r100, HamletAvatarWidget$addDataChangeObserver$$inlined$let$lambda$10 r101);

    void e4(DataCenter r100, u4 r101, long r102);

    void l4(Long r100, Bundle r101, boolean r102, String r103, Boolean r104);

    void o4();

    List<VSCameraInfo> p4();

    void x4(DataCenter r100);

    void z4(IRoom r100);
}
