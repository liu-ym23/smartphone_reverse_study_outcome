package dq1;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.bytedance.android.livesdk.chatroom.vs_impl.message.BizAdMsgPanelViewManager;
import com.bytedance.android.livesdk.chatroom.vs_impl.message.BusinessMsgView;
import com.bytedance.android.livesdkapi.depend.model.live.vs.BusinessConfigure;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public interface c {
    boolean a(BusinessConfigure r100);

    boolean c(String r100, BusinessConfigure r101);

    BusinessMsgView d(Context r100, AttributeSet r101, int r102);

    ur1.a f();

    BizAdMsgPanelViewManager g(DataCenter r100, Context r101, ViewGroup r102);

    void h(String r100, String r101, BusinessConfigure r102, Map<String, String> r103);

    String i(Long r100);
}
