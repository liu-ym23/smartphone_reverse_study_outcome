package wd0;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder;
import com.bytedance.android.live.liveinteract.plantform.multiroom.e;
import com.bytedance.android.live.liveinteract.utils.c1;
import com.bytedance.android.livesdk.config.gb0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBasisData;
import com.bytedance.ies.sdk.widgets.DataCenter;
import gd0.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class d implements c {

    public static final class a {
    }

    static {
    }

    public d() {
    }

    public static void b(xd0.a r100, DataCenter r101, boolean r102) {
        if (r102 == true) goto L7;
        if (r101 == null) goto L7;
        com.bytedance.android.live.liveinteract.bgComponent.platform.a r103 = e.c(r101);
        if (r103 == null) goto L7;
        r103.lb();
    L7:
        r100.f563273c.setVisible(r102);
    }

    @Override // wd0.c
    public final void a(b r100, List<xd0.a> r110, xd0.b r111) {
        Intrinsics.checkNotNullParameter(r100, "renderContext");
        Intrinsics.checkNotNullParameter(r110, GXTemplateKey.GAIAX_LAYERS);
        Intrinsics.checkNotNullParameter(r111, "shadowLayer");
        Iterator<T> r112 = r110.iterator();
    L3:
        boolean r101 = true;
        if (r112.hasNext() == false) goto L11;
        Object r102 = r112.next();
        if (((xd0.a) r102).f563272b != 2000) goto L8;
        boolean r103 = true;
    L9:
        if (r103 == false) goto L3;
    L12:
        xd0.a r104 = (xd0.a) r102;
        if (r104 != null) goto L15;
        return;
    L15:
        ALogger.i("ThemeBgLayerVisibleStrategy", "process, renderContext=" + r100);
        DataCenter r113 = r100.f559270a;
        if (r113 == null) goto L20;
        Integer r105 = (Integer) r113.get("data_link_state", 0);
        if (r105 == null) goto L20;
        int r106 = r105.intValue();
    L21:
        boolean r107 = v.a(r106, 4);
        boolean r108 = v.a(r106, 64);
        if (r107 == true) goto L111;
        if (r108 == true) goto L111;
        Boolean r109 = r100.f559276g;
        Boolean r114 = Boolean.TRUE;
        if (Intrinsics.areEqual(r109, r114) == false) goto L29;
        b(r104, r113, false);
        return;
    L29:
        IRoom r115 = r100.f559271b;
        if (r115 != null) goto L32;
    L47:
        Integer r116 = r100.f559273d;
        if (r116 != null) goto L51;
    L52:
        Integer r117 = r100.f559273d;
        if (r117 != null) goto L56;
    L58:
        int r118 = c1.f78742a;
        if (c1.a(0, r100.f559273d) == true) goto L61;
    L64:
        List<? extends tf0.e> r119 = r100.f559278i;
        if (r119 == null) goto L72;
        Iterator<T> r120 = r119.iterator();
        boolean r121 = true;
    L68:
        if (r120.hasNext() == false) goto L73;
        if ((((tf0.e) r120.next()) instanceof MultiLinkGuestViewBinder.a) == false) goto L68;
        r121 = false;
    L73:
        List<? extends tf0.e> r122 = r119;
        if (r122 != null) goto L76;
    L79:
        boolean r123 = true;
    L80:
        if (r123 == true) goto L84;
        if (r121 == true) goto L84;
        boolean r124 = false;
    L85:
        if (r124 == false) goto L89;
        b(r104, r113, false);
        return;
    L89:
        if (((Boolean) vm2.d.f555879k2.getValue(null, vm2.d.f555776a[164(0xa4, float:2.3E-43)])).booleanValue() == false) goto L101;
        Integer r125 = r100.f559273d;
        if (r125 == null) goto L93;
        int r126 = r125.intValue();
    L95:
        if (r126 != 7) goto L97;
        boolean r127 = true;
    L98:
        if (r127 == false) goto L101;
        b(r104, r113, false);
        return;
    L97:
        r127 = false;
        goto L98
    L93:
        r126 = 0;
    L101:
        Iterator r128 = ((ArrayList) r111.f563274a).iterator();
    L103:
        if (r128.hasNext() == false) goto L107;
        if (((yd0.a) r128.next()).a(r100) == true) goto L103;
        r101 = false;
        goto L103
    L107:
        b(r104, r113, r101);
        return;
    L84:
        r124 = true;
        goto L85
    L76:
        if (r122.isEmpty() == true) goto L79;
        r123 = false;
        goto L80
    L72:
        r121 = true;
        goto L73
    L61:
        if (r100.f559277h != 1) goto L64;
        b(r104, r113, false);
        return;
    L56:
        if (r117.intValue() != 0) goto L58;
    L109:
        b(r104, r113, false);
        return;
    L51:
        if (r116.intValue() == 15) goto L109;
    L32:
        if (r115.isLiveTypeAudio() != true) goto L47;
        IRoom r129 = r100.f559271b;
        if (r129 == null) goto L38;
        IRoomBasisData r130 = r129.getBasisRoomData();
        if (r130 == null) goto L38;
        Boolean r131 = r130.isCustomizeAudioRoom();
    L40:
        if (Intrinsics.areEqual(r131, r114) == false) goto L44;
        b(r104, r113, false);
        return;
    L44:
        if (CollectionsKt.contains(gb0.f120266a.getValue(), r100.f559273d) == false) goto L89;
        b(r104, r113, false);
        return;
    L38:
        r131 = null;
    L111:
        b(r104, r113, false);
        return;
    L20:
        r106 = 0;
        goto L21
    L8:
        r103 = false;
        goto L9
    L11:
        r102 = null;
        goto L12
    }
}
