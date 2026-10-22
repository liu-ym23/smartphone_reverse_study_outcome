package i00;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ies.sdk.widgets.DataCenter;
import f00.h;
import fg1.k;

/* JADX INFO: loaded from: classes45.dex */
public interface a extends b {
    void b(com.bytedance.android.livesdk.chatroom.broadcast.v2.scene.c r100);

    void c(k.q r100);

    com.bytedance.android.livesdk.chatroom.broadcast.v2.scene.d e();

    void g(k r100);

    FragmentActivity getActivity();

    DataCenter getDataCenter();

    com.bytedance.android.livesdk.chatroom.broadcast.v2.scene.c getInitData();

    h getScope();

    boolean h();

    void setDataCenter(DataCenter r100);

    void start(String r100);

    void stop(String r100);
}
