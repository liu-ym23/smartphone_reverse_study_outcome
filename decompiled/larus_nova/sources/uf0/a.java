package uf0;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.chatroom.interact.model.v;
import com.bytedance.android.livesdk.link.model.bridge.ILinkMicGuideMessageBridge;
import com.bytedance.android.livesdk.link.model.bridge.z0;

/* JADX INFO: loaded from: classes46.dex */
public interface a extends b {
    void Ba(z0 r100);

    void Ff(z0 r100);

    void If();

    void L2(String r100, Throwable r101);

    void e6(String r100, IBaseUser r101, v r102);

    void eo(z0 r100);

    void k5(String r100, Throwable r101);

    void l(String r100, Throwable r101);

    void onPermitSuccess(String r100);

    void vf(ILinkMicGuideMessageBridge r100);
}
