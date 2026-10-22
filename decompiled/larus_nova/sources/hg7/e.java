package hg7;

import android.content.Context;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.bytedance.sync.v2.protocal.BsyncProtocol;

/* JADX INFO: loaded from: classes3.dex */
public interface e extends rgc.a {
    BsyncProtocol B(byte[] r100);

    byte[] L(BsyncProtocol r100);

    WsChannelMsg P(Context r100, BsyncProtocol r101);
}
