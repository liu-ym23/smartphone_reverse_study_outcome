package com.bytedance.locallife.photo.preview.uilayer;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.locallife.cube.api.config.CubeContext;
import com.bytedance.locallife.cube.api.i.IPoiLynxKitDelegate;
import com.bytedance.locallife.cube.api.model.CubeInternalSchemaModel;
import com.bytedance.locallife.cube.api.model.DelegateStatus;
import com.google.gson.JsonObject;
import com.ss.android.cert.manager.constants.EventConstant;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kp6.c;
import wx6.b;

/* JADX INFO: loaded from: classes21.dex */
public final class LynxUILayer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Activity f262343a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public JsonObject f262344b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public JsonObject f262345c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f262346d;

    public final IPoiLynxKitDelegate d() {
        return (IPoiLynxKitDelegate) this.f262346d.getValue();
    }

    public LynxUILayer() {
        this.f262346d = LazyKt.lazy(new LynxUILayer$cubeInstance$2(this));
    }

    public final View c(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Context r101 = r100.getContext();
        if ((r101 instanceof Activity) == false) goto L5;
        Activity r102 = (Activity) r101;
    L6:
        if (r102 != null) goto L8;
        return null;
    L8:
        this.f262343a = r102;
        IPoiLynxKitDelegate r103 = d();
        if (r103 != null) goto L11;
        return null;
    L11:
        return r103.realView();
    L5:
        r102 = null;
        goto L6
    }

    public final Map<String, Object> b(String r100, String r110) {
        Pair[] r101 = new Pair[6];
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        int r102 = 0;
        r101[0] = TuplesKt.to(EventConstant.Key.RAW_DATA, r100);
        r101[1] = TuplesKt.to("font_scale", "1.0");
        r101[2] = TuplesKt.to("use_native_module", 1);
        r101[3] = TuplesKt.to("preload", Boolean.FALSE);
        r101[4] = TuplesKt.to("use_lepus_bridge", 1);
        int r103 = b.f561837a;
        JsonObject[] r104 = {this.f262344b, this.f262345c};
        Intrinsics.checkNotNullParameter(r104, "jsons");
        JsonObject r105 = new JsonObject();
    L6:
        if (r102 >= 2) goto L16;
        JsonObject r106 = r104[r102];
        if (r106 == null) goto L15;
        Set<String> r107 = r106.keySet();
        if (r107 == null) goto L15;
        Iterator<T> r108 = r107.iterator();
    L13:
        if (r108.hasNext() == false) goto L15;
        String r109 = (String) r108.next();
        r105.add(r109, r106.get(r109));
    L15:
        r102 = r102 + 1;
        goto L6
    L16:
        r101[5] = TuplesKt.to("track_data", r105.toString());
        Map<String, Object> r111 = MapsKt.mutableMapOf(r101);
        if (r110 == null) goto L19;
        r111.put("lynx_common_data", r110);
    L19:
        return r111;
    }

    public final void a(String r100, final String r101, final String r110) {
        if (d() != null) goto L5;
        return;
    L5:
        if (r100 != null) goto L7;
        return;
    L7:
        CubeInternalSchemaModel r102 = c.e(c.f505514a, r100);
        if (StringsKt.isBlank(r102.getSchema()) == false) goto L10;
        return;
    L10:
        IPoiLynxKitDelegate r103 = d();
        if (r103 == null) goto L15;
        CubeContext r104 = r103.getCubeContext();
        if (r104 == null) goto L15;
        DelegateStatus r105 = r104.a();
    L17:
        if (r105 != DelegateStatus.SUCCESS) goto L21;
        IPoiLynxKitDelegate r106 = d();
        if (r106 == null) goto L25;
        IPoiLynxKitDelegate.DefaultImpls.updateData$default(r106, r102, b(r101, r110), null, 4, null);
        return;
    L25:
        return;
    L21:
        IPoiLynxKitDelegate r107 = d();
        if (r107 == null) goto L27;
        r107.load(r102, new LynxUILayer$bindItemData$1(this, r101, r110));
        return;
    L27:
        return;
    L15:
        r105 = null;
        goto L17
    }
}
