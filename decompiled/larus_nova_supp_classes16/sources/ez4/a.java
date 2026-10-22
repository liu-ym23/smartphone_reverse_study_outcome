package ez4;

import android.view.View;
import android.webkit.ValueCallback;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BizDomain;
import com.bytedance.ee.bear.more.protocol3.f;
import com.bytedance.ee.bear.more.protocol3.g;
import com.bytedance.ee.bear.more.protocol3.m;
import com.bytedance.ee.bear.more.protocol3.panel.y;
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

    /* JADX INFO: renamed from: ez4.a$a, reason: collision with other inner class name */
    public static final class C0223a {
    }

    public static final class b implements m {
        public final /* synthetic */ a a;

        public final boolean isVisible() {
            boolean r0 = this.a.c.getDocumentMetadata().isDocumentType(e.o);
            boolean r1 = a.k(this.a);
            if (y.a() == true) goto L10;
            y.c("RevisionSwitchMoreItemV3", ((f) f.f0.c).a);
            if (r0 == false) goto L9;
            if (r1 == false) goto L9;
            r0 = true;
        L9:
            r0 = false;
        L10:
            String r7 = ((f) f.f0.c).a;
            if (r0 == false) goto L14;
            if (r1 == false) goto L14;
            boolean r9 = true;
        L15:
            if (r0 == false) goto L18;
            if (r1 == true) goto L18;
            String r2 = "edit_permission";
        L19:
            boolean r8 = r0;
            y.b("RevisionSwitchMoreItemV3", r7, r8, r9, r2, "docx_type_edit_permission");
            return r0;
        L18:
            r2 = "";
        L14:
            r9 = false;
            goto L15
        }

        public b(a r1) {
            this.a = r1;
        }
    }

    public static final class c implements com.bytedance.ee.bear.more.protocol3.a {
        public final /* synthetic */ a a;

        public final View.OnClickListener a() {
            return null;
        }

        public final String b() {
            return this.a.c.getContext().getString(2131889132);
        }

        public final boolean isEnable() {
            if (y.a() == false) goto L5;
            boolean r0 = a.k(this.a);
        L6:
            String r2 = ((f) f.f0.c).a;
            if (r0 == false) goto L9;
            String r4 = "";
        L10:
            String r5 = r4;
            y.b("RevisionSwitchMoreItemV3", r2, true, r0, r5, "edit_permission");
            return r0;
        L9:
            r4 = "edit_permission";
            goto L10
        L5:
            r0 = true;
            goto L6
        }

        public c(a r1) {
            this.a = r1;
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ a a;

        /* JADX INFO: renamed from: ez4.a$d$a, reason: collision with other inner class name */
        public static final class C0224a<T> implements ValueCallback {
            public final /* synthetic */ a a;

            public C0224a(a r1) {
                this.a = r1;
            }

            @Override // android.webkit.ValueCallback
            public final void onReceiveValue(Object r5) {
                boolean r6 = JSONObjectProtectorUtils.getBoolean(new JSONObject((String) r5), "success");     // Catch: Exception -> L11
                tt5.a.h("RevisionSwitchMoreItemV3", "execJS result = " + r6);     // Catch: Exception -> L11
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
                tt5.a.e("RevisionSwitchMoreItemV3", "execJS error", e, false);
            }
        }

        public d(a r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            a r5 = this.a;
            r5.d = !r5.d;
            tt5.a.h("RevisionSwitchMoreItemV3", "isCheck = " + this.a.d);
            k r6 = this.a.c.getWeb();
            com.alibaba.fastjson.JSONObject r0 = new com.alibaba.fastjson.JSONObject();
            r0.put("open", Boolean.valueOf(this.a.d));
            Unit r1 = Unit.INSTANCE;
            r6.a("javascript:window.lark.biz.revision.revisionStatusSwitch", r0, new C0224a(this.a));
        }
    }

    static {
    }

    public final com.bytedance.ee.bear.more.protocol3.k a() {
        if (this.e == false) goto L6;
        this.e = false;
        this.d = g(((f) f.f0.c).a);
        tt5.a.h("RevisionSwitchMoreItemV3", "from js isCheck = " + this.d);
    L6:
        return h(f.f0.c, new com.bytedance.ee.bear.more.protocol3.e.h(this.d, 4), CollectionsKt.arrayListOf(new b[]{new b(this)}), CollectionsKt.arrayListOf(new c[]{new c(this)}), new d(this));
    }

    public a(DocumentPluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "pluginHost");
        this.c = r2;
        this.e = true;
    }

    public static final boolean k(a r6) {
        oj5.c r2 = r6.c();
        if (r2 != null) goto L5;
        return false;
    L5:
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (jg5.e.a.a.g() == false) goto L9;
        return ((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).t(r2.getToken(), r2, BizDomain.FileBizDomainCCM, "EDIT", r2.c().a).getAllow();
    L9:
        return r2.n();
    }
}
