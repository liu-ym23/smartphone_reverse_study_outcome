package mh6;

import com.alipay.sdk.m.u.i;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.link.model.bridge.k;
import com.bytedance.android.livesdkapi.depend.model.live.linker.CPositionModeUtilKt;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f513968a = 0;

    static {
    }

    public static long a(long r100) {
        i97.a r101 = i97.a.f488802a;
        return System.currentTimeMillis() - r100;
    }

    public static String b(List r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toLogString");
        StringBuilder r101 = new StringBuilder("ListUsers{size=");
        r101.append(r100.size());
        r101.append(",");
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        k r103 = (k) r102.next();
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
        r101.append(CPositionModeUtilKt.isCPositionUser(r103));
        r101.append("]");
        goto L4
    L9:
        r101.append(i.f25855d);
        return r101.toString();
    }
}
