package cy4;

import android.text.TextUtils;
import android.view.View;
import android.webkit.ValueCallback;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.more.protocol3.f;
import com.bytedance.ee.bear.more.protocol3.g;
import com.bytedance.ee.bear.more.protocol3.m;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import sbb.e;
import vv4.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a extends g {
    public final DocumentPluginHost c;
    public boolean d;
    public boolean e;

    /* JADX INFO: renamed from: cy4.a$a, reason: collision with other inner class name */
    public static final class C0209a {
    }

    public static final class b implements m {
        public final /* synthetic */ a a;

        public final boolean isVisible() {
            boolean r0 = this.a.c.getDocumentMetadata().isDocumentType(e.o);
            tt5.a.h("AISumSwitchMoreItem", "isVisible is " + r0);
            return r0;
        }

        public b(a r1) {
            this.a = r1;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ a a;

        /* JADX INFO: renamed from: cy4.a$c$a, reason: collision with other inner class name */
        public static final class C0210a<T> implements ValueCallback {
            public final /* synthetic */ a a;

            public C0210a(a r1) {
                this.a = r1;
            }

            @Override // android.webkit.ValueCallback
            public final void onReceiveValue(Object r5) {
                boolean r6 = JSONObjectProtectorUtils.getBoolean(new JSONObject((String) r5), "success");     // Catch: Exception -> L11
                tt5.a.h("AISumSwitchMoreItem", "execJS result = " + r6);     // Catch: Exception -> L11
                if (r6 == true) goto L16;
                a r7 = this.a;     // Catch: Exception -> L11
                if (r7.d == true) goto L8;
                boolean r1 = true;
            L9:
                r7.d = r1;     // Catch: Exception -> L11
                r7.j();     // Catch: Exception -> L11
                return;
            L8:
                r1 = false;
                goto L9
            L16:
                return;
            L11:
                e = move-exception;
                tt5.a.e("AISumSwitchMoreItem", "execJS error", e, false);
            }
        }

        public c(a r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            a r5 = this.a;
            r5.d = !r5.d;
            tt5.a.h("AISumSwitchMoreItem", "isCheck = " + this.a.d);
            k r6 = this.a.c.getWeb();
            com.alibaba.fastjson.JSONObject r0 = new com.alibaba.fastjson.JSONObject();
            r0.put("open", Boolean.valueOf(this.a.d));
            Unit r1 = Unit.INSTANCE;
            r6.a("javascript:window.lark.biz.AISummarySwitch", r0, new C0210a(this.a));
        }
    }

    static {
    }

    public final com.bytedance.ee.bear.more.protocol3.k a() {
        if (this.e == false) goto L5;
        this.e = false;
        this.d = g(((f) f.a.c).a);
        tt5.a.h("AISumSwitchMoreItem", "from js isCheck = " + this.d);
    L5:
        oj5.c r0 = c();
        if (r0 == null) goto L9;
        String r1 = r0.I();
        if (r1 == null) goto L9;
    L10:
        boolean r3 = !TextUtils.isEmpty(r1);
        tt5.a.h("AISumSwitchMoreItem", "buildUIItem, isFreeTrial: " + r3 + " aiSummaryTagInfoText: " + r1);
        f.a r7 = f.a.c;
        return g.i(this, r7, new com.bytedance.ee.bear.more.protocol3.e.h(this.d, r3, r1), CollectionsKt.arrayListOf(new m[]{new b(this), new com.bytedance.ee.bear.more.protocol3.checker.c(((f) r7).a)}), null, new c(this), 8);
    L9:
        r1 = "";
        goto L10
    }

    public a(DocumentPluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "pluginHost");
        this.c = r2;
        this.e = true;
    }
}
