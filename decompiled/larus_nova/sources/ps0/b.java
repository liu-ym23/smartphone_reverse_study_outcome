package ps0;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomOthersData;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;

/* JADX INFO: loaded from: classes47.dex */
public interface b {
    boolean a();

    IRoom b();

    Long getAutoCover();

    long getId();

    String getLabels();

    IBaseUser getOwner();

    String getOwnerUserIdStr();

    String getRequestId();

    LiveMode getStreamType();

    boolean isMediaRoom();

    boolean isVSRoom();

    IRoomOthersData k3();
}
