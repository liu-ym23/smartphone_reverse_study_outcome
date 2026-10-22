package com.bytedance.ies.bullet.preloadv2.cache;

import com.bytedance.ies.bullet.service.base.d1;
import java.util.Observable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import v26.l;

/* JADX INFO: loaded from: classes19.dex */
public class PreloadItem extends Observable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PreloadResourceType f247675a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f247676b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PreloadResourceType f247677c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f247678d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f247679e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f247680f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f247681g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f247682h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f247683i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public l f247684j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public l f247685k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public d1 f247686l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f247687m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f247688n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f247689o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f247690p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f247691q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f247692r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f247693s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public PreloadErrorCode f247694t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f247695u;

    public void b() {
    }

    public final String d() {
        String r100 = this.f247689o;
        if (r100 != null) goto L10;
        int r101 = m26.a.f511663a;
        r100 = m26.a.b(this.f247685k, this.f247676b);
        if (this.f247684j == null) goto L10;
        if (this.f247686l == null) goto L10;
        this.f247689o = r100;
    L10:
        return r100;
    }

    public int e() {
        return ((Number) this.f247690p.getValue()).intValue();
    }

    public final boolean a() {
        if (c() == PreloadResourceType.Any) goto L8;
        if (this.f247677c == c()) goto L8;
        return false;
    L8:
        if (this.f247681g <= 0) goto L13;
        if (System.currentTimeMillis() >= this.f247681g) goto L13;
        return false;
    L13:
        if (this.f247682h > 0) goto L15;
        return true;
    L15:
        if (System.currentTimeMillis() <= this.f247682h) goto L19;
        return false;
    L19:
        return true;
    }

    public PreloadResourceType c() {
        return this.f247675a;
    }

    public final PreloadResourceType getType() {
        return this.f247677c;
    }

    public PreloadItem(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "jsonObject");
        PreloadResourceType r101 = PreloadResourceType.Any;
        this.f247675a = r101;
        boolean r102 = true;
        this.f247678d = true;
        this.f247680f = 600001;
        this.f247690p = LazyKt.lazy(new PreloadItem$size$2(this));
        this.f247694t = PreloadErrorCode.None;
        this.f247676b = r100.optString("url");
        String r103 = r100.optString("type");
        PreloadResourceType r104 = PreloadResourceType.Template;
        if (Intrinsics.areEqual(r103, r104.getTag()) == false) goto L5;
    L4:
        r101 = r104;
    L23:
        this.f247677c = r101;
        if (r101 != PreloadResourceType.Image) goto L27;
        r102 = false;
    L27:
        this.f247678d = r100.optBoolean("enableMemory", r102);
        this.f247679e = r100.optBoolean("highPriority", false);
        this.f247680f = r100.optLong("expire", 600001);
        this.f247681g = r100.optLong("expire_start", 0);
        this.f247682h = r100.optLong("expire_end", 0);
        this.f247683i = r100.optLong("download_timeout", 0);
        return;
    L5:
        r104 = PreloadResourceType.Image;
        if (Intrinsics.areEqual(r103, r104.getTag()) == true) goto L4;
        r104 = PreloadResourceType.Font;
        if (Intrinsics.areEqual(r103, r104.getTag()) == true) goto L4;
        r104 = PreloadResourceType.ExternalJs;
        if (Intrinsics.areEqual(r103, r104.getTag()) == true) goto L4;
        r104 = PreloadResourceType.DynamicComponent;
        if (Intrinsics.areEqual(r103, r104.getTag()) == true) goto L4;
        r104 = PreloadResourceType.Lottie;
        if (Intrinsics.areEqual(r103, r104.getTag()) == true) goto L4;
        r104 = PreloadResourceType.Video;
        if (Intrinsics.areEqual(r103, r104.getTag()) == false) goto L23;
        goto L23
    }

    public PreloadItem(String r100, PreloadResourceType r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "type");
        this.f247675a = PreloadResourceType.Any;
        this.f247678d = true;
        this.f247680f = 600001;
        this.f247690p = LazyKt.lazy(new PreloadItem$size$2(this));
        this.f247694t = PreloadErrorCode.None;
        this.f247676b = r100;
        this.f247677c = r101;
        this.f247678d = true;
        this.f247680f = 600001;
    }

    public final void f(PreloadErrorCode r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "errorCode");
        this.f247694t = r100;
        this.f247695u = r101;
    }
}
