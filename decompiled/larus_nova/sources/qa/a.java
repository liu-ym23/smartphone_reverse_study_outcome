package qa;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.ies.bullet.core.common.Scenes;
import com.bytedance.ies.bullet.service.base.i0;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.ss.android.lark.inv.export.router.InvRouter;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import t36.j;

/* JADX INFO: loaded from: classes43.dex */
public final class a implements i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Scenes f532197a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f532198b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f532199c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final KitType f532200d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f532201e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final j f532202f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Context f532203g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final m16.b f532204h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Map<String, Object> f532205i;

    @Override // com.bytedance.ies.bullet.service.base.i0
    public final void release() {
        this.f532203g = null;
        m16.b r100 = this.f532204h;
        if (r100 == null) goto L6;
        r100.h();
        return;
    }

    public final Context getContext() {
        return this.f532203g;
    }

    public a(Scenes r100, String r101, String r102, Bundle r103, String r104, KitType r105, j r106) {
        Intrinsics.checkNotNullParameter(r100, InvRouter.SCENES);
        Intrinsics.checkNotNullParameter(r101, "sessionId");
        Intrinsics.checkNotNullParameter(r102, "bid");
        Intrinsics.checkNotNullParameter(r103, "bundle");
        Intrinsics.checkNotNullParameter(r104, "originSchema");
        Intrinsics.checkNotNullParameter(r105, "kitType");
        Intrinsics.checkNotNullParameter(r106, "schemaModelUnion");
        this.f532204h = new m16.b();
        this.f532205i = new LinkedHashMap();
        this.f532197a = r100;
        this.f532198b = r101;
        this.f532199c = r102;
        this.f532201e = r104;
        this.f532200d = r105;
        this.f532202f = r106;
    }
}
