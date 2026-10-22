package yg0;

import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import jc1.k;

/* JADX INFO: loaded from: classes46.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f567474a = null;

    static {
        StringBuilder r100 = new StringBuilder("https://");
        IMiddleWareHostContext r101 = (IMiddleWareHostContext) k.f(IMiddleWareHostContext.class);
        boolean r102 = false;
        if (r101 == null) goto L8;
        if (r101.isBoe() == false) goto L8;
        String r103 = "tosv-boe.byted.org";
    L14:
        r100.append(r103);
        r100.append("/obj/");
        IMiddleWareHostContext r104 = (IMiddleWareHostContext) k.f(IMiddleWareHostContext.class);
        if (r104 == null) goto L20;
        if (r104.isBoe() == false) goto L20;
        String r105 = "gecko-internal/10893";
    L26:
        r100.append(r105);
        r100.append("/gecko/resource/webcast_multilink_layout_config_resource");
        f567474a = r100.toString();
        return;
    L20:
        if (((Boolean) vm2.b.f555743b.getValue(null, vm2.b.f555742a[0])).booleanValue() == true) goto L23;
        r102 = v.a();
    L23:
        if (r102 == false) goto L25;
        r105 = "gecko-internal/10180";
        goto L26
    L25:
        r105 = "byte-gurd-source/10181";
    L8:
        if (((Boolean) vm2.b.f555743b.getValue(null, vm2.b.f555742a[0])).booleanValue() == false) goto L10;
        boolean r106 = false;
    L11:
        if (r106 == false) goto L13;
        r103 = "tosv.byted.org";
        goto L14
    L13:
        r103 = "lf-webcast-sourcecdn-tos.bytegecko.com";
        goto L14
    L10:
        r106 = v.a();
        goto L11
    }
}
