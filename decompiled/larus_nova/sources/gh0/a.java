package gh0;

import android.text.TextUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class a {
    public static final String c() {
        return ((IMiddlewareUserService) k.n(IMiddlewareUserService.class)).user().n();
    }

    public static final boolean d() {
        Boolean r100 = m.i().isAnchor();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.booleanValue();
    }

    public static final boolean e(List<? extends LinkmicPositionItem> r110, List<? extends LinkmicPositionItem> r111) {
        if (r110 == null) goto L5;
        int r100 = r110.size();
    L6:
        if (r111 == null) goto L8;
        int r101 = r111.size();
    L9:
        if (r100 == r101) goto L11;
        return false;
    L11:
        if (r110 == null) goto L13;
        int r102 = r110.size();
    L15:
        if (r102 != 0) goto L17;
        return true;
    L17:
        if (r110 == null) goto L40;
        if (r111 == null) goto L40;
        int r103 = r110.size();
        int r104 = 0;
    L20:
        if (r104 >= r103) goto L40;
        LinkmicPositionItem r105 = (LinkmicPositionItem) ListProtector.get(r110, r104);
        LinkmicPositionItem r106 = (LinkmicPositionItem) ListProtector.get(r111, r104);
        Intrinsics.checkNotNullParameter(r105, "$this$isChange");
        if (r106 != null) goto L25;
    L35:
        boolean r107 = false;
    L37:
        if (r107 == true) goto L38;
        r104 = r104 + 1;
        goto L20
    L38:
        return false;
    L25:
        if (r105.getPosition() == r106.getPosition()) goto L27;
    L36:
        r107 = true;
        goto L37
    L27:
        if (r105.getPositionType() != r106.getPositionType()) goto L36;
        if (r105.getStatus() != r106.getStatus()) goto L36;
        if (r105.getVerifyStatus() != r106.getVerifyStatus()) goto L36;
        if (TextUtils.equals(r105.getActiveName(), r106.getActiveName()) == true) goto L35;
    L40:
        return true;
    L13:
        r102 = 0;
        goto L15
    L8:
        r101 = 0;
        goto L9
    L5:
        r100 = 0;
        goto L6
    }

    public static final boolean f(List<ILinkPlayerInfoBridge> r100, List<ILinkPlayerInfoBridge> r101) {
        if (r100 == null) goto L5;
        int r102 = r100.size();
    L6:
        if (r101 == null) goto L8;
        int r103 = r101.size();
    L9:
        if (r102 == r103) goto L11;
        return false;
    L11:
        if (r100 == null) goto L13;
        int r104 = r100.size();
    L15:
        if (r104 != 0) goto L17;
        return true;
    L17:
        if (r100 != null) goto L20;
        if (r101 != null) goto L20;
        return true;
    L20:
        if (r100 == null) goto L28;
        if (r101 == null) goto L28;
        int r105 = r100.size();
        int r106 = 0;
    L23:
        if (r106 >= r105) goto L28;
        if (((ILinkPlayerInfoBridge) ListProtector.get(r100, r106)).isEqual((ILinkPlayerInfoBridge) ListProtector.get(r101, r106)) == false) goto L26;
        r106 = r106 + 1;
        goto L23
    L26:
        return false;
    L28:
        return true;
    L13:
        r104 = 0;
        goto L15
    L8:
        r103 = 0;
        goto L9
    L5:
        r102 = 0;
        goto L6
    }

    public static final void a(String r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r101, "content");
        if (r100 != null) goto L5;
        String r103 = "LinkDataMerge";
    L6:
        if (r102 == false) goto L8;
        ALogger.d(r103, r101);
        return;
    L8:
        ALogger.i(r103, r101);
        return;
    L5:
        r103 = "LinkDataMerge#".concat(r100);
        goto L6
    }

    public static /* synthetic */ void b(String r100, String r101, int r102) {
        if ((r102 & 1) == 0) goto L5;
        r100 = null;
    L5:
        a(r100, r101, false);
    }
}
