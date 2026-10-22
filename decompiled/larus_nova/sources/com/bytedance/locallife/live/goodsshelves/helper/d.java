package com.bytedance.locallife.live.goodsshelves.helper;

import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.keva.Keva;
import com.bytedance.locallife.live.util.LiveLifeSaaSUtil;
import com.bytedance.locallife.live.util.w;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes21.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f259635a = 0;

    static {
    }

    @JvmStatic
    public static final String b() {
        String r100 = Keva.getRepo("live_local_life").getString("cur_tab_session", SliceInitService.DEFAULT_SWITCH);
        Object r101 = GsonProtectorUtils.fromJson(LiveLifeSaaSUtil.r(), r100, Map.class);
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");
        String r102 = w.f((Map) r101, "clent_tab_id");
        if (r102 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L12;
        return "1";
    L12:
        return r102;
    L5:
        if (r102.length() == 0) goto L8;
        r103 = false;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void a(Ref.IntRef r100, List<Integer> r101, Ref.ObjectRef<String> r102, String r103) {
        int r104 = r100.element;
        if (r104 <= 0) goto L5;
        ArrayList r105 = (ArrayList) r101;
        r105.add(Integer.valueOf(r104));
    L5:
        r100.element = 1;
        r102.element = r103;
    }
}
