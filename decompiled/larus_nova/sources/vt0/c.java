package vt0;

import android.net.Uri;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Iterator;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f557186a = 0;

    static {
    }

    public static String a(String r110, IBaseUser r111, long r112) {
        Intrinsics.checkNotNullParameter(r110, PlayerResolution.SDKKEY.ORIGIN);
        Intrinsics.checkNotNullParameter(r111, "anchor");
        Uri r100 = UriProtector.parse(r110);
        if (r100 == null) goto L11;
        String r101 = r100.getScheme();
        if (r101 == null) goto L11;
        if (r101.length() != 0) goto L9;
        boolean r102 = true;
    L10:
        if (r102 != true) goto L11;
    L19:
        return r110;
    L9:
        r102 = false;
    L11:
        if (r100 == null) goto L20;
        String r103 = r100.getHost();
        if (r103 == null) goto L20;
        if (r103.length() != 0) goto L17;
        boolean r104 = true;
    L18:
        if (r104 != true) goto L20;
    L17:
        r104 = false;
    L20:
        Uri.Builder r105 = r100.buildUpon().clearQuery();
        Iterator<T> r106 = UriProtector.getQueryParameterNames(r100).iterator();
    L22:
        if (r106.hasNext() == false) goto L58;
        String r107 = (String) r106.next();
        String r108 = UriProtector.getQueryParameter(r100, r107);
        if (r108 == null) goto L22;
        if (r108.length() <= 0) goto L28;
        boolean r109 = true;
    L29:
        if (r109 != true) goto L22;
        if (Intrinsics.areEqual("url", r107) == false) goto L53;
        Uri r113 = UriProtector.parse(r108);
        String r114 = r111.getIdString();
        Intrinsics.checkNotNullParameter(r111, "$this$secUidExt");
        String r115 = r111.getCastSecUid();
        String r116 = "";
        if (r115 != null) goto L35;
        r115 = "";
    L35:
        String r117 = r111.getNickName();
        if (r117 != null) goto L38;
        r117 = "";
    L38:
        IMiddlewareUserService r118 = (IMiddlewareUserService) k.f(IMiddlewareUserService.class);
        if (r118 == null) goto L41;
        com.bytedance.android.livesdk.user.e r119 = r118.user();
    L42:
        if (r119 == null) goto L45;
        String r120 = r119.n();
        if (r120 == null) goto L45;
    L46:
        if (r119 == null) goto L51;
        String r121 = r119.a(r120);
        if (r121 == null) goto L51;
        r116 = r121;
    L51:
        r108 = r113.buildUpon().appendQueryParameter("room_id", String.valueOf(r112)).appendQueryParameter("anchor_id", r114.toString()).appendQueryParameter("user_id", r120).appendQueryParameter("sec_user_id", r116).appendQueryParameter("sec_anchor_id", r115).appendQueryParameter("anchor_name", r117).appendQueryParameter("dark_mode", "1").toString();
    L56:
        r105.appendQueryParameter(r107, r108);
    L45:
        r120 = "0";
        goto L46
    L41:
        r119 = null;
        goto L42
    L53:
        if (Intrinsics.areEqual("fallback_url", r107) == false) goto L56;
        r108 = a(r108, r111, r112);
        goto L56
    L28:
        r109 = false;
        goto L29
    L58:
        r105.appendQueryParameter("group_apply_enter_from", "live");
        r105.appendQueryParameter("group_apply_enter_method", "click_group_list");
        r105.appendQueryParameter("group_apply_room_id", String.valueOf(r112));
        return r105.toString();
    }
}
