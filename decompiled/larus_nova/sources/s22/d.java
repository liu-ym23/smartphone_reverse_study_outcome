package s22;

import com.bytedance.android.livesdk.interactivity.service.wrds.RoomDataSyncModel;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.functions.Function0;
import vlc.l;

/* JADX INFO: loaded from: classes9.dex */
public interface d extends id0.a {
    Disposable a(int r100, l r101);

    void c(long r100, int r101, com.bytedance.android.livesdk.interactivity.chatchannel.manager.c r102);

    <T extends RoomDataSyncModel> T d(long r100, Function0<? extends T> r101);

    void e(long r100, com.bytedance.android.livesdk.interactivity.chatchannel.manager.c r101);

    void removeMessageListener(l r100);
}
