package uz0;

import com.bytedance.android.live.revenue.platform.network.api.dsl.ContentType;
import com.bytedance.android.live.revenue.platform.network.api.dsl.RequestDSL;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@RequestDSL
public final class e extends a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, String> f552166e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, List<String>> f552167f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public JsonObject f552168g;

    public e() {
        this.f552166e = new LinkedHashMap();
        this.f552167f = new LinkedHashMap();
        ContentType r100 = ContentType.APPLICATION_JSON;
    }

    public static void b(e r100, Object r101) {
        ContentType r102 = ContentType.APPLICATION_JSON;
        Intrinsics.checkNotNullParameter(r101, ContainerPosition.BODY);
        Intrinsics.checkNotNullParameter(r102, "contentType");
        int r103 = d.f552165a[r102.ordinal()];
        if (r103 != 1) goto L5;
        JsonElement r104 = GsonProtectorUtils.toJsonTree(l97.a.f508113a, r101);
        if ((r104 instanceof JsonObject) == true) goto L12;
        r104 = null;
    L12:
        JsonObject r105 = (JsonObject) r104;
        if (r105 == null) goto L17;
        r100.f552168g = r105;
        return;
    L17:
        throw new IllegalArgumentException("invalid body, please use object instead");
    L5:
        if (r103 == 2) goto L8;
        return;
    L8:
        throw new IllegalArgumentException("please use field instead");
    }
}
