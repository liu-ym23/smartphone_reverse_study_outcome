package ia7;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.android.anniex.api.c;
import com.bytedance.android.anniex.api.d;
import com.bytedance.android.anniex.ui.AnnieXLynxView;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.salamander.ability.RtsBridge;
import com.lynx.tasm.TemplateData;
import com.lynx.tasm.q1;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ra.b;

/* JADX INFO: loaded from: classes20.dex */
public final class a extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AnnieXLynxView f488926a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RtsBridge f488927b;

    /* JADX INFO: renamed from: ia7.a$a, reason: collision with other inner class name */
    public static final class C6247a extends q1 {
        public C6247a() {
        }

        @Override // com.lynx.tasm.q1
        public final void onDataUpdated() {
            super.onDataUpdated();
        }
    }

    public final RtsBridge getBridgeHandler() {
        return this.f488927b;
    }

    public final AnnieXLynxView getLynxView() {
        return this.f488926a;
    }

    public final void setBridgeHandler(RtsBridge r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f488927b = r100;
    }

    public final void setLynxView(AnnieXLynxView r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f488926a = r100;
    }

    public a(Context r310, String r311, Map<String, ? extends Object> r312) {
        Intrinsics.checkNotNullParameter(r310, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r311, "url");
        Intrinsics.checkNotNullParameter(r312, "state");
        super(r310);
        LinkedHashMap r100 = new LinkedHashMap();
        r100.put("key1", "value1");
        ra.a r101 = d.g(new d(null, r100, new b(false, null, null, null, 0, 0, 0.0f, false, false, null, false, 0, 0, null, false, false, false, false, null, false, 0.0f, 16777215), 9), UriProtector.parse(r311), TemplateData.fromMap(r312), null, 24);
        com.bytedance.android.anniex.assemble.a r102 = com.bytedance.android.anniex.assemble.a.f40251a;
        this.f488926a = c.a(r310, r101);
        this.f488926a.A(r101, null, null);
        this.f488926a.addLynxViewClient(new C6247a());
        int r103 = ha7.a.f484394a;
        this.f488927b = new RtsBridge(r310, StringsKt.replace$default(UUID.randomUUID().toString(), "-", "", false, 4, null));
        RtsBridge r104 = this.f488927b;
        AnnieXLynxView r105 = this.f488926a;
        r104.getClass();
        Intrinsics.checkNotNullParameter(r105, "lynxView");
        com.bytedance.salamander.ability.a r106 = new com.bytedance.salamander.ability.a(r104.f267768k, r105, r104, r104.f267769l);
        Intrinsics.checkNotNullParameter(r106, "<set-?>");
        r104.f267770m = r106;
        r104.r(r106);
        addView(this.f488926a, new FrameLayout.LayoutParams(-1, -1));
    }
}
