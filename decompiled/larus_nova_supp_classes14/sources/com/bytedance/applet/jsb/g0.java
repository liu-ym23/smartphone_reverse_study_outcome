package com.bytedance.applet.jsb;

import android.content.Context;
import com.ivy.ivykit.api.bridge.core.model.IvyBridgePlatformType;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.r2;
import com.larus.platform.model.video.business.EnterVideoMethod;
import com.larus.platform.uimodel.MediaEntity;
import com.larus.platform.uimodel.MediaEntityContainer;
import com.larus.platform.uimodel.VideoParam;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class g0 extends bx7.c {
    public final String getName() {
        return "applet.openAwemeVideos";
    }

    public g0() {
    }

    public final void a(dx7.b r69, ux7.d.d r70, IvyBridgePlatformType r71) {
        Intrinsics.checkNotNullParameter(r69, "params");
        Intrinsics.checkNotNullParameter(r70, "callback");
        Intrinsics.checkNotNullParameter(r71, "type");
        dx7.e r0 = r69.getArray("items");
        if (r0 == null) goto L7;
        JSONArray r1 = gx7.b.a(r0);
        ArrayList r4 = new ArrayList();
        int r5 = r1.length();
        int r6 = 0;
    L5:
        if (r6 >= r5) goto L8;
        Object r7 = r1.get(r6);
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type org.json.JSONObject");
        JSONObject r8 = (JSONObject) r7;
        r4.add(new MediaEntity(null, r8.optString("item_id", ""), null, null, r8.optString("artist_name", ""), r8.optString("song_name", ""), null, null, null, null, null, null, 3, null, null, null, 0, null, null, null, null, null, null, null, 16773069, null));
        r6 = r6 + 1;
    L8:
        ArrayList r17 = r4;
        ex7.d r9 = ((bx7.c) this).a;
        Context r10 = null;
        if (r9 == null) goto L16;
        Intrinsics.checkNotNullParameter(Context.class, "clazz");
        ex7.a r11 = (ex7.a) ((LinkedHashMap) r9.a).get(Context.class);
        if (r11 != null) goto L14;
        r11 = null;
    L14:
        if (r11 == null) goto L16;
        r10 = (Context) r11.provideInstance();
    L16:
        Context r12 = r10;
        VideoParam r15 = new VideoParam(r17, new MediaEntityContainer(null, r17, null, null, false, 0, 0, null, 253, null), null, null, null, null, null, 0, EnterVideoMethod.SEARCH_VIDEO_PAGE.getValue(), null, null, null, null, 0, 0, null, false, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, 0, null, null, -260, 131071);
        IFlowSdkDepend r13 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r13 == null) goto L21;
        r2 r14 = r13.A0();
        if (r14 == null) goto L21;
        Intrinsics.checkNotNull(r12);
        r14.p(r12, "", r15);
    L21:
        r70.invoke(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("code", 1)}));
        return;
    L7:
        r4 = new ArrayList();
        goto L8
    }
}
