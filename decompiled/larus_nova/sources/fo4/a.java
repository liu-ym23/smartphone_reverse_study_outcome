package fo4;

import android.content.Context;
import com.bytedance.ee.bear.bitable.c;
import com.bytedance.ee.bear.bitable.core.usercomponent.b;
import com.lynx.tasm.LynxGroup;
import com.lynx.tasm.TemplateData;
import com.lynx.tasm.q1;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f478116a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f478117b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Object> f478118c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public zm4.a f478119d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public q1 f478120e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TemplateData f478121f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LynxGroup f478122g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public k7a.a f478123h;

    public final Context getContext() {
        return this.f478116a;
    }

    public final void a(TemplateData r100) {
        Intrinsics.checkNotNullParameter(r100, "templateData");
        this.f478121f = r100;
    }

    public a(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f478116a = r100;
        this.f478117b = r101;
        this.f478118c = new LinkedHashMap();
        b("base.ui.use_base_design_tag", Boolean.valueOf(c.B()));
    }

    public final void b(String r100, Boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        if (((LinkedHashMap) this.f478118c).get("fgConfig") != null) goto L5;
        this.f478118c.put("fgConfig", new LinkedHashMap());
    L5:
        Object r102 = ((LinkedHashMap) this.f478118c).get("fgConfig");
        if (TypeIntrinsics.isMutableMap(r102) == false) goto L8;
        Map r103 = (Map) r102;
    L9:
        if (r103 == null) goto L15;
        if (r101 == null) goto L12;
        boolean r104 = r101.booleanValue();
    L13:
        Boolean r105 = (Boolean) r103.put(r100, Boolean.valueOf(r104));
        return;
    L12:
        r104 = b.c(r100);
        goto L13
    L15:
        return;
    L8:
        r103 = null;
        goto L9
    }
}
