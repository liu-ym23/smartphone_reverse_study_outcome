package jm0;

import com.bytedance.android.live.room.api.messagewindow.container.MsgWindowPosition;
import com.bytedance.android.livesdk.message.model.e3;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import q71.d;
import r71.c;
import r71.e;
import r71.f;

/* JADX INFO: loaded from: classes46.dex */
public final class a implements q71.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d<e> f499621a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d<c> f499622b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d<r71.d> f499623c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d<r71.a> f499624d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d<r71.b> f499625e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<e3, Map<MsgWindowPosition, d<f>>> f499626f;

    @Override // q71.c
    public final void release() {
    }

    public a() {
        int r100 = d.f531908c;
        this.f499621a = d.a.a();
        this.f499622b = d.a.a();
        this.f499623c = d.a.a();
        this.f499624d = d.a.a();
        this.f499625e = d.a.a();
        this.f499626f = new LinkedHashMap();
    }

    @Override // q71.a, q71.b
    public final d a() {
        return this.f499621a;
    }

    @Override // q71.c
    public final d b() {
        return this.f499624d;
    }

    @Override // q71.b
    public final d d() {
        return this.f499623c;
    }

    @Override // q71.c
    public final d e() {
        return this.f499625e;
    }

    @Override // q71.a
    public final d<f> c(e3 r100, MsgWindowPosition r101) {
        Intrinsics.checkNotNullParameter(r101, "position");
        if (r100 != null) goto L6;
        return null;
    L6:
        Map r102 = (Map) ((LinkedHashMap) this.f499626f).get(r100);
        if (r102 == null) goto L10;
        d<f> r103 = (d) r102.get(r101);
        if (r103 == null) goto L10;
    L16:
        return r103;
    L10:
        int r104 = d.f531908c;
        r103 = d.a.a();
        if (((Map) ((LinkedHashMap) this.f499626f).get(r100)) != null) goto L13;
        Map<MsgWindowPosition, d<f>> r105 = this.f499626f.put(r100, new LinkedHashMap());
    L13:
        Map r106 = (Map) ((LinkedHashMap) this.f499626f).get(r100);
        if (r106 == null) goto L16;
        d r107 = (d) r106.put(r101, r103);
        goto L16
    }
}
