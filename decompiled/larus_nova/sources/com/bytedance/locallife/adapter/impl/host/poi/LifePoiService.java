package com.bytedance.locallife.adapter.impl.host.poi;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.KeyEvent;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.locallife.biz.common.ui.LocalLifeLoadingLayout;
import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import com.bytedance.locallife.biz.experiment.e;
import com.bytedance.locallife.cube.api.model.CubeInternalSchemaModel;
import com.bytedance.locallife.dito.core.DitoInteractDialogFragment;
import com.bytedance.locallife.dito.core.f;
import com.bytedance.locallife.dito.data.o;
import com.bytedance.locallife.live.lynx.LiveLocalLifeLynxView;
import com.bytedance.locallife.poi.perf.i;
import com.bytedance.locallife.poi.settings.IPoiSetting;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.poi.ui.PoiLoadingMode;
import com.ss.android.ugc.aweme.poi.ui.PoiLoadingShowStyle;
import com.ss.android.ugc.aweme.poi.ui.PoiSkinMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes20.dex */
public class LifePoiService implements vt6.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f256482a;

    @Override // vt6.d
    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "fontName");
    }

    @Override // vt6.d
    public final void d(HashMap r100, Activity r101, LiveLocalLifeLynxView r102) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "activity");
        Intrinsics.checkNotNullParameter(r102, "targetView");
    }

    @Override // vt6.d
    public final void h(HashMap<String, Object> r100, Activity r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "activity");
    }

    @Override // vt6.d
    public final void j() {
    }

    @Override // vt6.d
    public final void l(String r100) {
        Intrinsics.checkNotNullParameter(r100, "requestId");
    }

    @Override // vt6.d
    public final void p() {
    }

    @Override // vt6.d
    public final void q(String r100, Function2 r101) {
        Intrinsics.checkNotNullParameter(r100, "enterFrom");
        Intrinsics.checkNotNullParameter(r101, "builder");
    }

    @Override // vt6.d
    public final void r() {
    }

    @Override // vt6.d
    public final void s(String r100) {
        Intrinsics.checkNotNullParameter(r100, "scheme");
    }

    @Override // vt6.d
    public final void u() {
    }

    @Override // vt6.d
    public final Map<String, o> i() {
        return new LinkedHashMap();
    }

    @Override // vt6.d
    public final List o() {
        return new ArrayList();
    }

    public LifePoiService() {
        this.f256482a = LazyKt.lazy(LifePoiService$lifeSaasGeckoCdn$2.INSTANCE);
    }

    @Override // vt6.d
    public final void c() {
        Activity r100 = HostServiceUtilsKt.E().getCurrentActivity();
        DitoInteractDialogFragment r101 = null;
        if ((r100 instanceof FragmentActivity) == false) goto L5;
        FragmentActivity r102 = (FragmentActivity) r100;
    L6:
        if (r102 != null) goto L8;
        return;
    L8:
        if (r102.getSupportFragmentManager().getFragments().size() > 1) goto L10;
    L18:
        r102.onBackPressed();
        return;
    L10:
        if ((CollectionsKt.lastOrNull(r102.getSupportFragmentManager().getFragments()) instanceof DitoInteractDialogFragment) == false) goto L18;
        Object r103 = CollectionsKt.lastOrNull(r102.getSupportFragmentManager().getFragments());
        if ((r103 instanceof DitoInteractDialogFragment) == false) goto L14;
        r101 = (DitoInteractDialogFragment) r103;
    L14:
        if (r101 == null) goto L21;
        f r104 = r101.getDialog();
        if (r104 == null) goto L22;
        r104.dispatchKeyEvent(new KeyEvent(0, 4));
        return;
    L22:
        return;
    L21:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // vt6.d
    public final String m() {
        return IPoiSetting.a().h();
    }

    @Override // vt6.d
    public final PoiLoadingShowStyle a() {
        return PoiLoadingShowStyle.DOUBLE_BALL;
    }

    @Override // vt6.d
    public final void e(mq6.c r100) {
        Intrinsics.checkNotNullParameter(r100, "builder");
    }

    @Override // vt6.d
    public final void g(View r100) {
        if ((r100 instanceof LocalLifeLoadingLayout) == false) goto L6;
        ((LocalLifeLoadingLayout) r100).b();
        return;
    }

    @Override // vt6.d
    public Uri interceptSchema(Uri r110) {
        Intrinsics.checkNotNullParameter(r110, "originSchemaUri");
        LifeSaasGeckoCdn r100 = (LifeSaasGeckoCdn) this.f256482a.getValue();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r110, "originSchemaUri");
        Uri r101 = null;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L19
        ((HashMap) r100.f256483a.getValue()).size();     // Catch: Throwable -> L19
        if ((!((HashMap) r100.f256483a.getValue()).isEmpty()) == false) goto L17;
        Pair r103 = LifeSaasGeckoCdn.a(r110);     // Catch: Throwable -> L19
        if (r103 == null) goto L17;
        String r104 = (String) r103.getFirst();     // Catch: Throwable -> L19
        String r105 = (String) r103.getSecond();     // Catch: Throwable -> L19
        if (r105.length() <= 0) goto L10;
        boolean r106 = true;
    L11:
        if (r106 == false) goto L17;
        if (((HashMap) r100.f256483a.getValue()).keySet().contains(r105) == false) goto L17;
        String r107 = (String) ((HashMap) r100.f256483a.getValue()).get(r105);     // Catch: Throwable -> L19
        if (ap6.a.b(r107) == false) goto L17;
        Uri r108 = jz6.b.a(r110, MapsKt.mapOf(TuplesKt.to(r104, r107)), true);     // Catch: Throwable -> L19
        Objects.toString(r108);     // Catch: Throwable -> L19
    L22:
        if (r108 == null) goto L58;
    L52:
        if (r108 != null) goto L55;
        return r110;
    L55:
        return r108;
    L58:
        ((List) r100.f256484b.getValue()).size();     // Catch: Throwable -> L49
        if ((!((List) r100.f256484b.getValue()).isEmpty()) == false) goto L47;
        String r109 = UriProtector.getQueryParameter(r110, "channel");     // Catch: Throwable -> L49
        if (r109 != null) goto L30;
        r109 = "";
    L30:
        if (ap6.a.b(r109) == false) goto L47;
        if (((List) r100.f256484b.getValue()).contains(r109) == false) goto L47;
        Pair r111 = LifeSaasGeckoCdn.a(r110);     // Catch: Throwable -> L49
        if (r111 == null) goto L47;
        String r112 = (String) r111.getFirst();     // Catch: Throwable -> L49
        String r113 = (String) r111.getSecond();     // Catch: Throwable -> L49
        if (r113.length() <= 0) goto L38;
        boolean r114 = true;
    L39:
        if (r114 == false) goto L47;
        if (StringsKt.contains$default(r113, r109, false, 2, null) == false) goto L47;
        String r115 = "https://lf-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/lifesaas/isomorphic/resource/".concat(r109);     // Catch: Throwable -> L49
        List r116 = StringsKt.split$default(r113, new String[]{r109}, false, 0, 6, null);     // Catch: Throwable -> L49
        if (r116.size() != 2) goto L47;
        if (ap6.a.b((String) ListProtector.get(r116, 1)) == false) goto L47;
        Uri r117 = jz6.b.a(r110, MapsKt.mapOf(TuplesKt.to(r112, r115 + ((String) ListProtector.get(r116, 1)))), true);     // Catch: Throwable -> L49
        Objects.toString(r117);     // Catch: Throwable -> L49
        r101 = r117;
    L57:
    L51:
        r108 = r101;
        goto L52
    L38:
        r114 = false;
    L47:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L49
    L49:
        th = move-exception;
        Result.Companion r118 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L51
    L10:
        r106 = false;
    L17:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L19
    L21:
        r108 = null;
    L19:
        th = move-exception;
        Result.Companion r119 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L21
    }

    @Override // vt6.d
    public final void t(View r100) {
        if ((r100 instanceof LocalLifeLoadingLayout) == false) goto L6;
        ((LocalLifeLoadingLayout) r100).a();
        return;
    }

    @Override // vt6.d
    public final String appendCacheUniqueKey(CubeInternalSchemaModel r100, Uri r101) {
        Intrinsics.checkNotNullParameter(r100, "schemaModel");
        Intrinsics.checkNotNullParameter(r101, "schemaUri");
        String r102 = UriProtector.getQueryParameter(r101, "request_version");
        if (r102 != null) goto L6;
        r102 = "";
    L6:
        if (r102.length() <= 0) goto L8;
        boolean r103 = true;
    L9:
        if (r103 == true) goto L11;
        return "";
    L11:
        if (Intrinsics.areEqual(UriProtector.getQueryParameter(r101, "disable_gecko"), "1") == true) goto L13;
        return "";
    L13:
        return "-requestVersion".concat(r102);
    L8:
        r103 = false;
        goto L9
    }

    @Override // vt6.d
    public final void f(Number r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "level");
        Intrinsics.checkNotNullParameter("poi_detail_ng", "page");
        e r103 = com.bytedance.locallife.biz.experiment.f.a();
        if (r103.f256650a == true) goto L5;
    L7:
        boolean r104 = false;
    L8:
        if (r104 == true) goto L10;
        return;
    L10:
        i.b(r100, r101, r102);
        return;
    L5:
        if (r103.f256657h == false) goto L7;
        r104 = true;
        goto L8
    }

    @Override // vt6.d
    public final boolean k(String r100, String r101, Number r102) {
        Intrinsics.checkNotNullParameter(r100, "page");
        Intrinsics.checkNotNullParameter(r101, "bizCode");
        Intrinsics.checkNotNullParameter(r102, "level");
        e r103 = com.bytedance.locallife.biz.experiment.f.a();
        if (r103.f256650a == true) goto L5;
    L7:
        boolean r104 = false;
    L8:
        if (r104 == true) goto L10;
        return true;
    L10:
        if (i.a(r100, r101, r102) == true) goto L15;
        return false;
    L15:
        return true;
    L5:
        if (r103.f256657h == false) goto L7;
        r104 = true;
        goto L8
    }

    @Override // vt6.d
    public final LocalLifeLoadingLayout n(Context r100, PoiLoadingMode r101, PoiSkinMode r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "poiLoadingMode");
        Intrinsics.checkNotNullParameter(r102, "poiSkinMode");
        return new LocalLifeLoadingLayout(r100, null, 6, 0);
    }
}
