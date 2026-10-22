package x31;

import com.bytedance.android.livesdk.link.model.IBattleRivalTag;
import com.bytedance.android.livesdk.link.model.IRivalExtraInfo;
import com.bytedance.android.livesdk.link.model.m2;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes47.dex */
public interface l {
    boolean isRequesting(IRoom r100);

    void onCancel(IRoom r100);

    void onInvite(IRoom r100, int r101, IRivalExtraInfo r102, int r103, m2 r104, List<IBattleRivalTag> r105, int r106, int r107, String r108, HashMap<String, String> r110, Boolean r111);
}
