package qg6;

import com.bytedance.android.livesdk.chatroom.model.g1;
import com.bytedance.android.livesdk.link.model.bridge.h1;
import com.bytedance.live.bizlink.api.business.anchor2guest.base.BizLinkServiceType;

/* JADX INFO: loaded from: classes19.dex */
public interface b {

    public static final class a {
        public static /* synthetic */ void a(b r100, g1 r101, h1 r102, BizLinkServiceType r103, int r104) {
            if ((r104 & 1) == 0) goto L6;
            r101 = null;
        L6:
            if ((r104 & 2) == 0) goto L8;
            r102 = null;
        L8:
            r100.a(r101, r102, r103);
        }
    }

    void a(g1 r100, h1 r101, BizLinkServiceType r102);
}
