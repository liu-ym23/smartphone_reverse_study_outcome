package dl0;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdkapi.depend.model.live.linker.CPositionModeUtil;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class q {
    public static final String a(List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r100) {
        StringBuilder r101 = new StringBuilder("ListUsers{size=");
        r101.append(r100.size());
        r101.append(",");
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        com.bytedance.android.livesdk.link.model.bridge.k r103 = (com.bytedance.android.livesdk.link.model.bridge.k) r102.next();
        r101.append("[");
        if (r103.getUser() == null) goto L8;
        r101.append("id=");
        IBaseUser r104 = r103.getUser();
        Intrinsics.checkNotNull(r104);
        r101.append(r104.getIdString());
        r101.append(",");
    L8:
        r101.append("pos=");
        r101.append(r103.getUserPosition());
        r101.append(",silence=");
        r101.append(r103.getSilenceStatus());
        r101.append(",linkId=");
        r101.append(r103.getLinkMicIdStr());
        r101.append(",linkType=");
        r101.append(r103.getLinkType());
        r101.append(",isBg=");
        r101.append(r103.isBackground());
        r101.append(",mc=");
        r101.append(r103.getMcStatus());
        r101.append(",isCPos=");
        r101.append(CPositionModeUtil.isCPositionUser(r103));
        r101.append("]");
        goto L4
    L9:
        r101.append(com.alipay.sdk.m.u.i.f25855d);
        return r101.toString();
    }
}
