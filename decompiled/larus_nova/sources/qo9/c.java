package qo9;

import android.os.Handler;
import com.bytedance.ee.bear.doc.editmodeswitchplugin.IEditModeSwitchViewPlugin;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.larus.office.OfficeInputParam;
import com.larus.office.plugins.inputv2.d1;
import com.larus.office.plugins.inputv2.h0;
import com.larus.office.plugins.inputv2.o1;
import com.larus.office.plugins.inputv2.s0;
import com.larus.utils.t0;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes30.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<OfficeInputParam> f534258a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<ChameleonPluginHost> f534259b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<com.larus.office.h> f534260c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<g45.d> f534261d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.larus.office.plugins.inputv2.adapter.g f534262e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f534263f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f534264g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Integer f534265h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f534266i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final d f534267j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final qo9.a f534268k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final b f534269l;

    public static final class a {
    }

    static {
    }

    public final void b() {
        Handler r100 = t0.f375468a;
        r100.removeCallbacks(this.f534268k);
        r100.removeCallbacks(this.f534269l);
        this.f534266i = false;
        com.larus.office.plugins.inputv2.adapter.g r101 = this.f534262e;
        if (r101 == null) goto L5;
        r101.u(this.f534267j);
    L5:
        this.f534262e = null;
        this.f534263f = false;
        this.f534264g = 0;
        a(0, true);
        this.f534265h = null;
    }

    public final void c() {
        if (this.f534266i == false) goto L5;
        return;
    L5:
        this.f534266i = true;
        t0.f375468a.post(this.f534269l);
    }

    public final void a(Integer r100, boolean r101) {
        OfficeInputParam r102 = this.f534258a.invoke();
        if (r102 == null) goto L5;
        String r103 = r102.getType();
    L6:
        if (r103 != null) goto L8;
        r103 = "";
    L8:
        boolean r104 = true;
        if (r103.length() != 0) goto L11;
        boolean r105 = true;
    L12:
        if (r105 == false) goto L14;
        return;
    L14:
        if (r100 == null) goto L17;
        int r106 = r100.intValue();
    L20:
        if (r101 == true) goto L27;
        Integer r107 = this.f534265h;
        if (r107 == null) goto L27;
        if (r107.intValue() != r106) goto L27;
        return;
    L27:
        this.f534265h = Integer.valueOf(r106);
        com.larus.office.h r108 = this.f534260c.invoke();
        if (r108 != null) goto L30;
    L32:
        r104 = false;
    L33:
        if (r104 == false) goto L35;
        return;
    L35:
        if (Intrinsics.areEqual(r103, DocumentType.DOCX_NAME) == false) goto L43;
        ChameleonPluginHost r109 = this.f534259b.invoke();
        if (r109 == null) goto L44;
        IEditModeSwitchViewPlugin r110 = (IEditModeSwitchViewPlugin) r109.findPlugin(IEditModeSwitchViewPlugin.class);
        if (r110 == null) goto L45;
        r110.setEditModeSwitchMargin(0, 0, 0, RangesKt.coerceAtLeast(r106, 0));
        return;
    L45:
        return;
    L44:
        return;
    L43:
        return;
    L30:
        if (r108.f9(r103, r106) != true) goto L32;
    L17:
        if (this.f534263f == false) goto L19;
        r106 = this.f534264g;
        goto L20
    L19:
        r106 = 0;
        goto L20
    L11:
        r105 = false;
        goto L12
    L5:
        r103 = null;
        goto L6
    }

    public final void d(boolean r100, boolean r101) {
        this.f534263f = r100;
        if (r100 == false) goto L5;
        c();
    L6:
        if (r101 == false) goto L11;
        g45.d r102 = this.f534261d.invoke();
        if (r102 == null) goto L12;
        r102.requestUpdateWebContentHeight();
        return;
    L12:
        return;
    L11:
        return;
    L5:
        Handler r103 = t0.f375468a;
        r103.removeCallbacks(this.f534268k);
        r103.removeCallbacks(this.f534269l);
        this.f534266i = false;
        a(0, r101);
        goto L6
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [qo9.a] */
    /* JADX WARN: Type inference failed for: r2v3, types: [qo9.b] */
    public c(h0 r100, s0 r101, d1 r102, o1 r103) {
        Intrinsics.checkNotNullParameter(r100, "paramsProvider");
        Intrinsics.checkNotNullParameter(r101, "hostProvider");
        Intrinsics.checkNotNullParameter(r102, "hostAbilityProvider");
        Intrinsics.checkNotNullParameter(r103, "editPanelManagerProvider");
        this.f534258a = r100;
        this.f534259b = r101;
        this.f534260c = r102;
        this.f534261d = r103;
        this.f534267j = new d(this);
        this.f534268k = new qo9.a(this);
        this.f534269l = new b(this);
    }
}
