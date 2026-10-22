package qh1;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;

/* JADX INFO: loaded from: classes7.dex */
public interface a extends IService {
    boolean canShowMsgBoard(DataCenter r100);

    Class<? extends Widget> getLiveElementClass();

    String getMsgBoardSchema(DataCenter r100);

    Class<? extends Widget> getReplayElementClass();

    void paidStatusChanged(DataCenter r100);

    boolean roomToolbarDataHasDress(IRoom r100);
}
