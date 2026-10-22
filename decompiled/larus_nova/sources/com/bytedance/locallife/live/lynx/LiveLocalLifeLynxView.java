package com.bytedance.locallife.live.lynx;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.amap.api.col.s.ce;
import com.bytedance.android.anniex.ui.AnnieXLynxView;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.locallife.live.lynx.impl.b;
import com.bytedance.locallife.live.lynx.impl.f;
import com.bytedance.locallife.live.util.LiveLifeSaaSUtil;
import com.bytedance.locallife.live.util.s;
import com.bytedance.locallife.live.util.y;
import com.bytedance.mt.protector.impl.UriProtector;
import com.lynx.tasm.behavior.shadow.text.g;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jv6.h;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kv6.c;
import kv6.d;
import qv6.e;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\tJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002R\"\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR0\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010 \u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010'\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R*\u00100\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010(8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R*\u00105\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010(8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u0010+\u001a\u0004\b3\u0010-\"\u0004\b4\u0010/¨\u00066"}, d2 = {"Lcom/bytedance/locallife/live/lynx/LiveLocalLifeLynxView;", "Landroid/widget/FrameLayout;", "", "height", "", "setTrueHeight", "width", "setTrueWidth", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Ljava/lang/String;", "getUniqueKey", "()Ljava/lang/String;", "setUniqueKey", "(Ljava/lang/String;)V", "uniqueKey", "", "", ce.f26391f, "Ljava/util/Map;", "getData", "()Ljava/util/Map;", "setData", "(Ljava/util/Map;)V", "data", "Lkv6/d;", "h", "Lkv6/d;", "getListener", "()Lkv6/d;", "setListener", "(Lkv6/d;)V", "listener", ce.f26395j, "I", "getLoadStatus", "()I", "setLoadStatus", "(I)V", "loadStatus", "", "Lcom/bytedance/locallife/live/lynx/jsb/a;", ce.f26396k, "Ljava/util/List;", "getJsbMethodList", "()Ljava/util/List;", "setJsbMethodList", "(Ljava/util/List;)V", "jsbMethodList", "Lcom/bytedance/locallife/live/lynx/syncjsb/a;", "l", "getSyncJsbMethodList", "setSyncJsbMethodList", "syncJsbMethodList", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class LiveLocalLifeLynxView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f260520a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f260521b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Object> f260522c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f260523d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f260524e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f260525f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Map<String, Object> f260526g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public d f260527h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f260528i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f260529j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public List<com.bytedance.locallife.live.lynx.jsb.a> f260530k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public List<com.bytedance.locallife.live.lynx.syncjsb.a> f260531l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f260532m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final c f260533n;

    public static final class a {
    }

    static {
    }

    public LiveLocalLifeLynxView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, null, 14);
    }

    public LiveLocalLifeLynxView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, null, 12);
    }

    public LiveLocalLifeLynxView(Context r100, AttributeSet r101, int r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, r110, null, 8);
    }

    public final void e() {
        this.f260529j = 0;
        b r100 = this.f260521b;
        if (r100 == null) goto L12;
        b.a r101 = b.a.f260557a;
        Map<String, Typeface[]> r102 = g.f382310a;
        monitor-enter(g.class);
        ((ArrayList) g.f382315f).remove(r101);     // Catch: Throwable -> L9
        monitor-exit(g.class);
        r100.f260552f.destroy();
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public final boolean b() {
        if (getVisibility() == 0) goto L6;
        return false;
    L6:
        if (this.f260523d == false) goto L9;
        return false;
    L9:
        if (TextUtils.isEmpty(this.f260532m) == false) goto L11;
        return false;
    L11:
        Uri r100 = UriProtector.parse(this.f260532m);
        String r101 = "";
        if (r100 == null) goto L15;
        String r102 = UriProtector.getQueryParameter(r100, "bundle");
        if (r102 == null) goto L15;
    L16:
        String r103 = "shelf_cell";
        AnnieXLynxView r104 = null;
        boolean r105 = StringsKt.contains$default(r102, "shelf_cell", false, 2, null);
        boolean r106 = StringsKt.contains$default(r102, "topbar", false, 2, null);
        if (r105 == true) goto L20;
        if (r106 == true) goto L20;
        return false;
    L20:
        if (r105 == false) goto L22;
        int r107 = this.f260524e;
    L23:
        if (r105 == true) goto L26;
        r103 = "topbar";
    L26:
        b r108 = this.f260521b;
        if (r108 == null) goto L30;
        r104 = r108.f260552f;
    L30:
        if (r104 != null) goto L32;
    L34:
        boolean r109 = false;
    L35:
        if (r109 == true) goto L53;
        return false;
    L53:
        Result.Companion r110 = Result.Companion;     // Catch: Throwable -> L45
        int r111 = UIUtils.px2dip(getContext(), r104.getHeight());     // Catch: Throwable -> L45
        if (r111 >= r107) goto L43;
        int r112 = e.f534905a;     // Catch: Throwable -> L45
        LinkedHashMap r113 = new LinkedHashMap();     // Catch: Throwable -> L45
        r113.put("type", "1");     // Catch: Throwable -> L45
        String r114 = this.f260532m;     // Catch: Throwable -> L45
        if (r114 == null) goto L42;
        r101 = r114;
    L42:
        r113.put("url", r101);     // Catch: Throwable -> L45
        r113.put("message", "lynx " + r103 + " callback height is wrong");     // Catch: Throwable -> L45
        r113.put("card_height", String.valueOf(r111));     // Catch: Throwable -> L45
        Unit r115 = Unit.INSTANCE;     // Catch: Throwable -> L45
        e.a("live_life_lynx_view_load_exception", r113, true, this.f260520a);     // Catch: Throwable -> L45
    L43:
        Object r116 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L45
    L47:
        Throwable r117 = Result.m9452exceptionOrNullimpl(r116);
        if (r117 == null) goto L51;
        LiveLifeSaaSUtil.t().e("LiveLocalLifeLynxView", r117);
    L51:
        return true;
    L45:
        th = move-exception;
        Result.Companion r118 = Result.Companion;
        r116 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L47
    L32:
        if (r104.isAttachedToWindow() != true) goto L34;
        r109 = true;
        goto L35
    L22:
        r107 = this.f260525f;
    L15:
        r102 = "";
        goto L16
    }

    public final void f() {
        b r100 = this.f260521b;
        if (r100 == null) goto L6;
        r100.f260552f.updateGlobalProps(s.b(r100.f260549c));
        r100.f260552f.O("globalPropsUpdated", null, true);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        b();
        super.onDetachedFromWindow();
    }

    public final Map<String, Object> getData() {
        return this.f260526g;
    }

    public final List<com.bytedance.locallife.live.lynx.jsb.a> getJsbMethodList() {
        return this.f260530k;
    }

    public final d getListener() {
        return this.f260527h;
    }

    public final int getLoadStatus() {
        return this.f260529j;
    }

    public final List<com.bytedance.locallife.live.lynx.syncjsb.a> getSyncJsbMethodList() {
        return this.f260531l;
    }

    public final String getUniqueKey() {
        return this.f260520a;
    }

    public final void d(com.bytedance.locallife.live.lynx.syncjsb.a r100) {
        Intrinsics.checkNotNullParameter(r100, "syncJsbMethod");
        if (this.f260531l != null) goto L5;
        this.f260531l = new ArrayList();
    L5:
        List<com.bytedance.locallife.live.lynx.syncjsb.a> r101 = this.f260531l;
        if (r101 == null) goto L9;
        r101.add(r100);
        return;
    }

    public final void setData(Map<String, Object> r100) {
        this.f260526g = r100;
    }

    public final void setJsbMethodList(List<com.bytedance.locallife.live.lynx.jsb.a> r100) {
        this.f260530k = r100;
    }

    public final void setListener(d r100) {
        this.f260527h = r100;
    }

    public final void setLoadStatus(int r100) {
        this.f260529j = r100;
    }

    public final void setSyncJsbMethodList(List<com.bytedance.locallife.live.lynx.syncjsb.a> r100) {
        this.f260531l = r100;
    }

    public final void setTrueHeight(int r100) {
        getLayoutParams().height = r100;
        requestLayout();
    }

    public final void setTrueWidth(int r100) {
        getLayoutParams().width = r100;
        requestLayout();
    }

    public final void setUniqueKey(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f260520a = r100;
    }

    public final void c(String r100, List<? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        b r102 = this.f260521b;
        if (r102 == null) goto L6;
        Intrinsics.checkNotNullParameter(r100, "name");
        r102.f260552f.O(r100, r101, false);
        return;
    }

    public LiveLocalLifeLynxView(Context r100, AttributeSet r101, int r102, String r103, int r104) {
        Map<String, Object> r105 = null;
        if ((r104 & 2) == 0) goto L5;
        r101 = null;
    L5:
        boolean r106 = false;
        if ((r104 & 4) == 0) goto L9;
        r102 = 0;
    L9:
        if ((r104 & 8) == 0) goto L11;
        r103 = "";
    L11:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r103, "uniqueKey");
        super(r100, r101, r102);
        this.f260520a = r103;
        h r107 = com.bytedance.locallife.live.settings.c.f();
        if (r107 == null) goto L14;
        r105 = r107.S();
    L14:
        this.f260522c = r105;
        if (r105 != null) goto L17;
        Map<String, Object> r108 = MapsKt.emptyMap();
    L18:
        Integer r109 = y.b(r108, "enable_tracker");
        if (r109 != null) goto L22;
    L23:
        r106 = true;
    L24:
        this.f260523d = r106;
        if (r105 != null) goto L27;
        Map<String, Object> r110 = MapsKt.emptyMap();
    L28:
        Integer r111 = y.b(r110, "cell_min_height");
        if (r111 == null) goto L31;
        int r112 = r111.intValue();
    L32:
        this.f260524e = r112;
        if (r105 != null) goto L35;
        r105 = MapsKt.emptyMap();
    L35:
        Integer r113 = y.b(r105, "topbar_min_height");
        if (r113 == null) goto L38;
        int r114 = r113.intValue();
    L39:
        this.f260525f = r114;
        this.f260528i = System.currentTimeMillis();
        this.f260533n = new c(this);
        f.a();
        return;
    L38:
        r114 = 44;
        goto L39
    L31:
        r112 = 128;
        goto L32
    L27:
        r110 = r105;
        goto L28
    L22:
        if (r109.intValue() == 1) goto L24;
    L17:
        r108 = r105;
        goto L18
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(LiveLocalLifeLynxView r100, String r101, Map r102, int r103, int r104) {
        if ((r104 & 2) == 0) goto L5;
        r102 = null;
    L5:
        boolean r105 = false;
        if ((r104 & 4) == 0) goto L8;
        r103 = 0;
    L8:
        r100.f260532m = r101;
        if (r100.f260521b != null) goto L16;
        if (r101 != null) goto L12;
    L13:
        r105 = true;
    L14:
        if (r105 == true) goto L16;
        int r106 = f.f260558a;
        c r107 = r100.f260533n;
        Context r108 = r100.getContext();
        Intrinsics.checkNotNullParameter(r107, "liveLocalLifeLynxViewCallback");
        Intrinsics.checkNotNullParameter(r101, "url");
        Intrinsics.checkNotNullParameter(r108, PerfLog.PARAM_KEY_CONTEXT_ID);
        r100.f260521b = new b(r107, r101, r108, r103);
        goto L16
    L12:
        if (r101.length() != 0) goto L14;
    L16:
        b r109 = r100.f260521b;
        if (r109 == 0) goto L20;
        r109.a(r101, r102);
        return;
    }
}
