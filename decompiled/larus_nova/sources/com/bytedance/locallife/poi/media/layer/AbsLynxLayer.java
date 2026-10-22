package com.bytedance.locallife.poi.media.layer;

import android.app.Activity;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.shopping.slice.action.entity.SendClosePdpEventParam;
import com.bytedance.ies.bullet.core.q;
import com.bytedance.ies.bullet.service.base.o;
import com.bytedance.ies.bullet.ui.common.BulletContainerView;
import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import com.bytedance.locallife.cube.Cube;
import com.bytedance.locallife.cube.api.i.ICubeGlobalListener;
import com.bytedance.locallife.poi.media.api.PlayState;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.lynx.tasm.LynxError;
import com.ss.android.cert.manager.constants.EventConstant;
import iy6.g;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import u26.e;

/* JADX INFO: loaded from: classes21.dex */
public abstract class AbsLynxLayer implements hy6.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f262670a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f262671b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public JsonObject f262672c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f262673d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public JsonObject f262674e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public iy6.c f262675f;

    public static final class a extends q.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final C3699a f262676a;

        /* JADX INFO: renamed from: com.bytedance.locallife.poi.media.layer.AbsLynxLayer$a$a, reason: collision with other inner class name */
        public static final class C3699a extends u26.b.a {
            @Override // u26.b.a, u26.b
            public final void d(o r100) {
            }

            public C3699a() {
            }

            @Override // u26.b.a, u26.b
            public final void g(o r100, String r101) {
            }

            @Override // u26.b.a, u26.b
            public final void l(o r100, e r101) {
                Objects.toString(r101);
            }
        }

        public a() {
            this.f262676a = new C3699a();
        }

        @Override // com.bytedance.ies.bullet.core.q.a, com.bytedance.ies.bullet.core.s
        public final u26.b getLynxClient() {
            return this.f262676a;
        }
    }

    @Override // hy6.d
    public final void a() {
    }

    @Override // hy6.b
    public final void g() {
    }

    @Override // hy6.b
    public final void h(int r100, int r101) {
    }

    public abstract ViewGroup.LayoutParams l();

    @Override // hy6.b
    public final void onRenderStart() {
    }

    @Override // hy6.b
    public final void onVideoSizeChanged(int r100, int r101) {
    }

    public abstract void p();

    public abstract void q();

    public abstract void r();

    public abstract void s();

    public abstract void t();

    public final BulletContainerView d() {
        return (BulletContainerView) this.f262671b.getValue();
    }

    @Override // hy6.d
    public final void release() {
        d().release();
    }

    public final Activity getActivity() {
        return this.f262670a;
    }

    @Override // hy6.d
    public final void n() {
        p();
    }

    public AbsLynxLayer(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        this.f262670a = r100;
        this.f262671b = LazyKt.lazy(new AbsLynxLayer$mBulletContainer$2(this));
    }

    public final Map<String, Object> b(String r100) {
        j();
        Objects.toString(this.f262672c);
        Objects.toString(this.f262674e);
        iy6.c r101 = this.f262675f;
        if (r101 == null) goto L5;
        r101.d();
    L5:
        LinkedHashMap r102 = new LinkedHashMap();
        String r103 = "";
        if (r100 != null) goto L8;
        r100 = "";
    L8:
        r102.put(EventConstant.Key.RAW_DATA, r100);
        String r104 = this.f262673d;
        if (r104 != null) goto L11;
    L14:
        boolean r105 = true;
    L15:
        if (r105 == false) goto L31;
        JsonObject r106 = this.f262674e;
        if (r106 == null) goto L35;
        Set<String> r107 = r106.keySet();
        if (r107 == null) goto L35;
        Iterator<T> r108 = r107.iterator();
    L22:
        if (r108.hasNext() == false) goto L35;
        String r109 = (String) r108.next();
        JsonObject r110 = this.f262674e;
        if (r110 == null) goto L29;
        JsonElement r111 = r110.get(r109);
        if (r111 == null) goto L29;
        String r112 = r111.toString();
        if (r112 == null) goto L29;
    L30:
        r102.put(r109, r112);
    L29:
        r112 = "";
    L35:
        JsonObject r113 = this.f262672c;
        if (r113 == null) goto L39;
        String r114 = r113.toString();
        if (r114 == null) goto L39;
    L40:
        r102.put("track_data", r114);
        JsonObject r115 = this.f262674e;
        if (r115 == null) goto L44;
        String r116 = r115.toString();
        if (r116 == null) goto L44;
    L45:
        r102.put("extra_params", r116);
        iy6.c r117 = this.f262675f;
        if (r117 == null) goto L53;
        g r118 = r117.d();
        if (r118 == null) goto L53;
        String r119 = r118.b();
        if (r119 == null) goto L53;
        r103 = r119;
    L53:
        r102.put("author_id", r103);
        return r102;
    L44:
        r116 = "";
    L39:
        r114 = "";
        goto L40
    L31:
        String r120 = this.f262673d;
        if (r120 != null) goto L34;
        r120 = "";
    L34:
        r102.put("sync_data", r120);
        goto L35
    L11:
        if (StringsKt.isBlank(r104) == true) goto L14;
        r105 = false;
        goto L15
    }

    @Override // hy6.d
    public final View c(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        BulletContainerView r101 = d();
        r101.setLayoutParams(l());
        return r101;
    }

    @Override // hy6.d
    public final void e(iy6.c r100) {
        this.f262675f = r100;
        r();
    }

    @Override // hy6.d
    public final void f(iy6.d r110) {
        if (r110 != null) goto L4;
        return;
    L4:
        JsonObject r111 = r110.a();
        if (r111 != null) goto L8;
        return;
    L8:
        if (r111.has(SendClosePdpEventParam.KEY_LYNX_URL) == false) goto L10;
        String r100 = r111.get(SendClosePdpEventParam.KEY_LYNX_URL).getAsString();
    L12:
        if (r100 != null) goto L14;
    L17:
        boolean r101 = true;
    L18:
        if (r101 == false) goto L21;
        return;
    L21:
        if (r111.has(EventConstant.Key.RAW_DATA) == false) goto L23;
        String r112 = r111.get(EventConstant.Key.RAW_DATA).getAsString();
    L24:
        d().f();
        if (d().f() == false) goto L33;
        d().f();
        if (d().f() == false) goto L66;
        BulletContainerView r102 = d();
        JSONObject r103 = new JSONObject();
        Iterator r113 = ((LinkedHashMap) b(r112)).entrySet().iterator();
    L30:
        if (r113.hasNext() == false) goto L32;
        Map.Entry r104 = (Map.Entry) r113.next();
        r103.put((String) r104.getKey(), r104.getValue());
        goto L30
    L32:
        r102.onEvent(new com.bytedance.ies.bullet.core.event.a(r103));
        return;
    L66:
        return;
    L33:
        Map r105 = MapsKt.mapOf(TuplesKt.to("font_scale", String.valueOf(HostServiceUtilsKt.z().getCurrentFontScale())));
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r105, "params");
        boolean r106 = StringsKt.isBlank(r100);
        String r107 = r100;
        if (r106 == true) goto L58;
        r107 = r100;
        if (r105.isEmpty() == true) goto L58;
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L52
        Uri r109 = UriProtector.parse(r100);     // Catch: Throwable -> L52
        Uri.Builder r114 = r109.buildUpon().clearQuery();     // Catch: Throwable -> L52
        LinkedHashMap r115 = new LinkedHashMap();     // Catch: Throwable -> L52
        Iterator<T> r116 = UriProtector.getQueryParameterNames(r109).iterator();     // Catch: Throwable -> L52
    L40:
        if (r116.hasNext() == false) goto L42;
        String r117 = (String) r116.next();     // Catch: Throwable -> L52
        r115.put(r117, UriProtector.getQueryParameter(r109, r117));     // Catch: Throwable -> L52
        goto L40
    L42:
        Iterator r118 = r105.entrySet().iterator();     // Catch: Throwable -> L52
    L44:
        if (r118.hasNext() == false) goto L46;
        Map.Entry r119 = (Map.Entry) r118.next();     // Catch: Throwable -> L52
        r115.put((String) r119.getKey(), (String) r119.getValue());     // Catch: Throwable -> L52
        goto L44
    L46:
        Iterator r120 = r115.entrySet().iterator();     // Catch: Throwable -> L52
    L48:
        if (r120.hasNext() == false) goto L50;
        Map.Entry r121 = (Map.Entry) r120.next();     // Catch: Throwable -> L52
        r114.appendQueryParameter((String) r121.getKey(), (String) r121.getValue());     // Catch: Throwable -> L52
        goto L48
    L50:
        Object r122 = Result.m9449constructorimpl(r114.build().toString());     // Catch: Throwable -> L52
    L54:
        Object r123 = r100;
        if (Result.m9452exceptionOrNullimpl(r122) != null) goto L57;
        r123 = r122;
    L57:
        r107 = (String) r123;
    L52:
        th = move-exception;
        Result.Companion r124 = Result.Companion;
        r122 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L58:
        ly6.b.a(d());
        String r125 = kp6.c.e(kp6.c.f505514a, r107).getSchema();
        BulletContainerView r126 = d();
        Uri r127 = HostServiceUtilsKt.P().e(r125);
        kp6.a<ICubeGlobalListener> r128 = Cube.f257155a;
        r126.h(r127, null, Cube.b(b(r112)), new a());
        return;
    L23:
        r112 = null;
        goto L24
    L14:
        if (StringsKt.isBlank(r100) == true) goto L17;
        r101 = false;
        goto L18
    L10:
        r100 = null;
        goto L12
    }

    @Override // hy6.d
    public final void i(JsonObject r100) {
        this.f262672c = r100;
        t();
    }

    @Override // hy6.d
    public final void k(JsonObject r100) {
        Objects.toString(r100);
        this.f262674e = r100;
        q();
    }

    @Override // hy6.d
    public final void m(String r100) {
        this.f262673d = r100;
        s();
    }

    @Override // hy6.b
    public final void o(PlayState r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // hy6.b
    public final void onError(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
        Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
    }
}
