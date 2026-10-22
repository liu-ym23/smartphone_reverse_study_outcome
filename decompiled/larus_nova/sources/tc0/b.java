package tc0;

import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkMatchType;
import com.bytedance.android.live.liveinteract.plantform.model.e0;
import com.bytedance.android.livesdk.chatroom.model.v;
import com.bytedance.android.livesdk.link.model.bridge.g2;
import com.bytedance.android.livesdk.link.model.bridge.u1;
import com.bytedance.android.livesdk.link.model.bridge.v1;
import java.util.Map;

/* JADX INFO: loaded from: classes45.dex */
public interface b extends dn0.b {
    void Ah(String r100);

    void Ba();

    void Cl(Map<Long, ? extends g2> r100);

    void D0(com.bytedance.android.livesdk.message.linker.b r100);

    void D6(String r100);

    void De();

    void F7(LinkMatchType r100);

    void H9(boolean r100);

    void Jm(String r100);

    void Kj(boolean r100);

    com.bytedance.android.livesdk.message.linker.b Oa();

    void Pd(int r100);

    void R0(int r100);

    String Vd();

    void c1(String r100);

    void dh(String r100);

    String getApplyReason();

    long getChannelId();

    String getLiveCoreExtInfo();

    e0 getMcuContent();

    u1 getMultiLiveCoreInfo();

    v1 getMultiRtcInfo();

    String getRtcExtInfo();

    boolean isSupportCamera();

    void rg(int r100);

    void setApplyType(int r100);

    void setChorusCDNInfo(v r100);

    void setLiveCoreExtInfo(String r100);

    void setMcuContent(e0 r100);

    void setMultiLiveCoreInfo(u1 r100);

    void setMultiRtcInfo(v1 r100);

    void setRtcExtInfo(String r100);

    String u();

    void v6(boolean r100);

    String x9();

    boolean zi();
}
