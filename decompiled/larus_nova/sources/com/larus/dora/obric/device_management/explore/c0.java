package com.larus.dora.obric.device_management.explore;

import com.larus.nova.R;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes27.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f339509a = 0;

    static {
    }

    public c0() {
    }

    public static x0 b(String r100) {
        return new x0(r100, DoraObricGlassesImagePageType.BASIC_DETAIL);
    }

    public static x0 d(String r100) {
        return new x0(r100, DoraObricGlassesImagePageType.DETAIL);
    }

    public static x0 e(String r100) {
        return new x0(r100, DoraObricGlassesImagePageType.EXPLORE);
    }

    public static b0 a(String r100, int r101, Integer r102, Map r103, DoraObricGlassesExploreActionStateType r110, int r111) {
        if ((r111 & 2) == 0) goto L6;
        r101 = R.string.larus_dora_obric_glasses_explore_action_go_enable_cn;
    L6:
        if ((r111 & 4) == 0) goto L9;
        r102 = Integer.valueOf(R.string.larus_dora_obric_glasses_explore_action_enabled_cn);
    L9:
        if ((r111 & 8) == 0) goto L11;
        r103 = MapsKt.emptyMap();
    L11:
        Map r104 = r103;
        if ((r111 & 16) == 0) goto L14;
        DoraObricGlassesExploreActionStateType r105 = null;
    L15:
        d1 r106 = new d1(r101);
        if (r102 == null) goto L18;
        d1 r107 = new d1(r102.intValue());
    L20:
        return new b0(r100, r106, r107, r104, r105);
    L18:
        r107 = null;
        goto L20
    L14:
        r105 = r110;
        goto L15
    }

    public static z c(String r110, int r111, int r112, String r113, List r114, List r115, b0 r116, int r117) {
        if ((r117 & 32) == 0) goto L5;
        List r100 = CollectionsKt.emptyList();
    L7:
        if ((r117 & 64) == 0) goto L9;
        List r101 = CollectionsKt.emptyList();
    L11:
        if ((r117 & 256) == 0) goto L13;
        b0 r102 = null;
    L15:
        return new z(r110, new d1(r111), new d1(r112), null, r100, r101, r102, r113);
    L13:
        r102 = r116;
        goto L15
    L9:
        r101 = r115;
        goto L11
    L5:
        r100 = r114;
        goto L7
    }
}
