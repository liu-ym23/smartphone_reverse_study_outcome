package qr2;

import android.content.Context;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.Disposable;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes11.dex */
public interface c extends dy0.a {
    int H();

    a I8(String r100);

    oq2.c Qd();

    String getGuestAnchorLinkMicId();

    e getPkAudienceLogData();

    String getSelfAnchorLinkMicId();

    void hideInteractDialog();

    boolean isInSelfAnchorLink();

    void leaveChannel();

    void markSwitchToMulti(boolean r100);

    void openMockLinkDialog(Context r100);

    boolean pm(String r100);

    Disposable registerOnlineListChange(Function1<? super List<? extends ILinkPlayerInfoBridge>, Unit> r100);

    void registerPkGuestLynxDataObserver(Observer<String> r100);

    void resetLinkData();

    a s7(String r100);

    void tryLoadPkAudienceWidget();

    void tryUnLoadPkAudienceWidget();

    void unRegisterPkGuestLynxDataObserver(Observer<String> r100);

    List<ILinkPlayerInfoBridge> yi(boolean r100);
}
