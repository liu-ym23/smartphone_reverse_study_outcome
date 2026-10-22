package jm0;

import com.bytedance.android.live.room.api.messagewindow.container.MsgWindowPosition;
import com.bytedance.android.livesdk.message.model.e3;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import q71.d;
import r71.e;
import r71.f;

/* JADX INFO: loaded from: classes46.dex */
public final class b implements q71.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d<e> f499627a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d<r71.d> f499628b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d<r71.a> f499629c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final d<r71.b> f499630d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Map<e3, Map<MsgWindowPosition, d<f>>> f499631e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b f499632f = null;

    public b() {
    }

    @Override // q71.c
    public final void release() {
    }

    static {
        f499632f = new b();
        int r100 = d.f531908c;
        f499627a = d.a.a();
        d.a.a();
        f499628b = d.a.a();
        f499629c = d.a.a();
        f499630d = d.a.a();
        f499631e = new LinkedHashMap();
    }

    @Override // q71.a, q71.b
    public final d a() {
        return f499627a;
    }

    @Override // q71.c
    public final d b() {
        return f499629c;
    }

    @Override // q71.b
    public final d d() {
        return f499628b;
    }

    @Override // q71.c
    public final d e() {
        return f499630d;
    }

    @Override // q71.a
    public final d<f> c(e3 r100, MsgWindowPosition r101) {
        Intrinsics.checkNotNullParameter(r101, "position");
        if (r100 != null) goto L6;
        return null;
    L6:
        Map<e3, Map<MsgWindowPosition, d<f>>> r102 = f499631e;
        LinkedHashMap r103 = (LinkedHashMap) r102;
        Map r104 = (Map) r103.get(r100);
        if (r104 == null) goto L10;
        d<f> r105 = (d) r104.get(r101);
        if (r105 == null) goto L10;
    L16:
        return r105;
    L10:
        int r106 = d.f531908c;
        r105 = d.a.a();
        if (((Map) r103.get(r100)) != null) goto L13;
        Map<MsgWindowPosition, d<f>> r107 = r102.put(r100, new LinkedHashMap());
    L13:
        Map r108 = (Map) r103.get(r100);
        if (r108 == null) goto L16;
        d r109 = (d) r108.put(r101, r105);
        goto L16
    }
}
