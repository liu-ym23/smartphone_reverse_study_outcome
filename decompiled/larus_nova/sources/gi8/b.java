package gi8;

import android.content.Context;
import android.graphics.Color;
import com.baidu.platform.comapi.map.MapController;
import com.larus.bmhome.chat.banner.ActiveSwitchBannerIconType;
import com.larus.bmhome.chat.banner.f;
import com.larus.bmhome.chat.banner.g;
import com.larus.bmhome.chat.banner.i;
import com.larus.bmhome.chat.banner.l;
import com.larus.bmhome.chat.banner.m;
import com.larus.bmhome.chat.nestedmenu.NestedMenuRightModel;
import com.larus.bmhome.chat.nestedmenu.NestedMenuScene;
import com.larus.bmhome.chat.nestedmenu.d;
import com.larus.bmhome.chat.nestedmenu.ui.q;
import di8.b0;
import di8.c0;
import di8.d0;
import di8.f0;
import di8.g0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import v19.h;
import v19.i5;

/* JADX INFO: loaded from: classes25.dex */
public final class b implements ei8.c, ei8.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f481474a;

    public static final class a {
    }

    static {
    }

    @Override // ei8.c
    public final String getKey() {
        return "banner";
    }

    public b() {
    }

    public final void h(LinkedHashMap<String, List<d0>> r100) {
        if (this.f481474a == false) goto L5;
        return;
    L5:
        this.f481474a = true;
        List<d0> r101 = r100.get("banner");
        if (r101 != null) goto L8;
        r101 = CollectionsKt.emptyList();
    L8:
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r101.iterator();
    L10:
        if (r103.hasNext() == false) goto L17;
        f0 r104 = ((d0) r103.next()).c();
        if ((r104 instanceof i) == false) goto L14;
        i r105 = (i) r104;
    L15:
        if (r105 == null) goto L10;
        r102.add(r105);
        goto L10
    L14:
        r105 = null;
        goto L15
    L17:
        int r106 = c.f481475a;
        Iterator r107 = r102.iterator();
    L19:
        if (r107.hasNext() == false) goto L21;
        i r108 = (i) r107.next();
        Intrinsics.checkNotNullParameter(r108, MapController.ITEM_LAYER_TAG);
        c.a(r108, false);
        goto L19
    }

    public static Integer f(m r100, boolean r101) {
        Object r102 = null;
        if (r101 == false) goto L14;
        if (r100 == null) goto L12;
        String r103 = r100.b();
        if (r103 == null) goto L12;
        if ((!StringsKt.isBlank(r103)) == true) goto L11;
        r103 = null;
    L11:
        if (r103 == null) goto L12;
    L17:
        if (r103 != null) goto L19;
        return null;
    L19:
        if ((!StringsKt.isBlank(r103)) == true) goto L22;
        r103 = null;
    L22:
        if (r103 == null) goto L36;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L25
        Object r105 = Result.m9449constructorimpl(Integer.valueOf(Color.parseColor(r103)));     // Catch: Throwable -> L25
    L28:
        if (Result.m9455isFailureimpl(r105) == true) goto L32;
        r102 = r105;
    L32:
        return (Integer) r102;
    L25:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L28
    L36:
        return null;
    L12:
        if (r100 == null) goto L16;
        r103 = r100.a();
    L16:
        r103 = null;
        goto L17
    L14:
        if (r100 == null) goto L16;
        r103 = r100.a();
        goto L17
    }

    public static String g(f r100, c0 r101) {
        boolean r102 = h.f552477a;
        if (h.b(r101.f468770c.getContext()) == false) goto L17;
        if (r100 == null) goto L11;
        g r103 = r100.a();
        if (r103 == null) goto L11;
        com.larus.bmhome.chat.banner.h r104 = r103.a();
        if (r104 == null) goto L11;
        String r105 = r104.a();
        if (r105 == null) goto L11;
        return r105;
    L11:
        if (r100 == null) goto L23;
        g r106 = r100.a();
        if (r106 == null) goto L23;
        com.larus.bmhome.chat.banner.h r107 = r106.b();
        if (r107 == null) goto L23;
        return r107.a();
    L23:
        return null;
    L17:
        if (r100 == null) goto L23;
        g r108 = r100.a();
        if (r108 == null) goto L23;
        com.larus.bmhome.chat.banner.h r109 = r108.b();
        if (r109 == null) goto L23;
        return r109.a();
    }

    /* JADX WARN: Type inference failed for: r9v1, types: [gi8.a] */
    @Override // ei8.a
    public final LinkedHashMap<String, List<d0>> a(LinkedHashMap<String, List<d0>> r310, c0 r311) {
        Intrinsics.checkNotNullParameter(r310, "models");
        Intrinsics.checkNotNullParameter(r311, "config");
        if (r311.f468768a != NestedMenuScene.SETTINGS) goto L5;
        return r310;
    L5:
        t1a.b r100 = r311.f468780m;
        if (r100 == null) goto L12;
        l r101 = (l) r100.getAbility(l.class);
        if (r101 == null) goto L12;
        com.larus.bmhome.chat.banner.c r102 = r101.EE();
        if (r102 == null) goto L12;
        List<i> r103 = r102.a();
    L13:
        if (r103 != null) goto L15;
        r103 = CollectionsKt.emptyList();
    L15:
        ArrayList r104 = new ArrayList();
        Iterator<T> r105 = r103.iterator();
    L17:
        if (r105.hasNext() == false) goto L69;
        i r110 = (i) r105.next();
        if (r110 == null) goto L65;
        m r106 = r110.h();
        if (r106 == null) goto L23;
        String r107 = r106.c();
    L24:
        boolean r108 = false;
        if (r107 != null) goto L27;
    L30:
        boolean r109 = true;
    L31:
        if (r109 == false) goto L44;
        m r111 = r110.g();
        if (r111 == null) goto L35;
        String r112 = r111.c();
    L36:
        if (r112 != null) goto L38;
    L41:
        boolean r113 = true;
    L42:
        if (r113 == false) goto L44;
        d r114 = null;
    L64:
        d r115 = r114;
    L66:
        if (r115 == null) goto L17;
        r104.add(r115);
        goto L17
    L38:
        if (StringsKt.isBlank(r112) == true) goto L41;
        r113 = false;
        goto L42
    L35:
        r112 = null;
    L44:
        boolean r116 = h.f552477a;
        boolean r117 = h.b(r311.f468770c.getContext());
        final f r118 = r110.c();
        if (r118 == null) goto L52;
        Integer r119 = r118.b();
        int r120 = ActiveSwitchBannerIconType.Percent.getValue();
        if (r119 == null) goto L52;
        if (r119.intValue() != r120) goto L52;
        r108 = true;
    L52:
        if (r108 == false) goto L54;
        final Context r121 = r311.f468770c.getContext();
        g0 r122 = new g0(null, null, null, false, new gi8.a(r121, r118), 31);
    L55:
        m r123 = r110.h();
        if (r123 == null) goto L58;
        String r210 = r123.c();
    L59:
        b0 r124 = new b0(r210, null, null, null, null, null, null, null, null, f(r110.h(), r117), 16382);
        m r125 = r110.g();
        if (r125 == null) goto L62;
        String r211 = r125.c();
    L63:
        r114 = new d(r122, r124, new NestedMenuRightModel(r211, null, g(r110.f(), r311), f(r110.g(), r117), 223), false, null, false, null, r110, false, false, false, 1912);
        goto L64
    L62:
        r211 = null;
        goto L63
    L58:
        r210 = null;
        goto L59
    L54:
        r122 = new g0(null, g(r118, r311), Integer.valueOf(i5.A()), true, null, 37);
        goto L55
    L27:
        if (StringsKt.isBlank(r107) == true) goto L30;
        r109 = false;
        goto L31
    L23:
        r107 = null;
        goto L24
    L65:
        r115 = null;
        goto L66
    L69:
        if (r104.isEmpty() == false) goto L71;
        return r310;
    L71:
        List<d0> r126 = r310.get("banner");
        if (r126 != null) goto L74;
        r126 = CollectionsKt.emptyList();
    L74:
        r310.put("banner", CollectionsKt.plus(r126, r104));
        return r310;
    L12:
        r103 = null;
        goto L13
    }

    @Override // ei8.b
    public final void b(LinkedHashMap<String, List<d0>> r100, c0 r101) {
        Intrinsics.checkNotNullParameter(r100, "models");
        Intrinsics.checkNotNullParameter(r101, "config");
        h(r100);
        t1a.b r102 = r101.f468780m;
        if (r102 == null) goto L8;
        l r103 = (l) r102.getAbility(l.class);
        if (r103 == null) goto L9;
        r103.iw("menu_open");
        return;
    L9:
        return;
    }

    @Override // ei8.b
    public final void c(List<? extends q> r100, c0 r101) {
        Intrinsics.checkNotNullParameter(r100, "nodes");
        Intrinsics.checkNotNullParameter(r101, "config");
    }

    @Override // ei8.b
    public final void d(LinkedHashMap<String, List<d0>> r100, c0 r101) {
        Intrinsics.checkNotNullParameter(r100, "models");
        Intrinsics.checkNotNullParameter(r101, "config");
        h(r100);
    }

    @Override // ei8.b
    public final void e(LinkedHashMap<String, List<d0>> r100, c0 r101) {
        Intrinsics.checkNotNullParameter(r100, "models");
        Intrinsics.checkNotNullParameter(r101, "config");
        this.f481474a = false;
    }
}
