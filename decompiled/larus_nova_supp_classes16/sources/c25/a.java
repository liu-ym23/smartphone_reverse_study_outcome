package c25;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.doccomponent.config.DocComponentConfig;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.lark.dependency.s;
import com.bytedance.ee.bear.more.protocol3.g;
import sa5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class a<T extends PluginHost> {
    public a() {
    }

    public abstract c b(T r1);

    public final g a(FragmentActivity r14, PluginHost r16) {
        if (((s) org.koin.java.a.c(s.class, null, null, 6)).enableFgMainTabContainer() == true) goto L5;
    L62:
        return null;
    L5:
        if ((r14 instanceof m) == false) goto L40;
        m r17 = (m) r14;
        c r0 = b(r16);
        String r7 = r0.f;
        String r4 = r0.b;
        if (r4 != null) goto L9;
        String r6 = "";
    L10:
        xj5.a r18 = r17.vb(xj5.a.class);
        if (r18 != null) goto L38;
        if (r16 != null) goto L14;
    L18:
        String r11 = "";
        String r12 = r11;
    L19:
        if (r18 == null) goto L21;
        Boolean r5 = Boolean.valueOf(r18.b);
    L22:
        if (r5 != null) goto L31;
        if (r16 == null) goto L29;
        vo5.a r19 = r16.getUserComponent();
        if (r19 == null) goto L29;
        t45.c r110 = (t45.c) r19.a(t45.c.class);
        if (r110 == null) goto L29;
        BearUrl r111 = r110.Z(r0.a);
    L30:
        boolean r112 = DocComponentConfig.isDocComponent(r111);
    L32:
        boolean r8 = r112;
        String r113 = r0.a;
        if (r113 != null) goto L35;
        String r9 = "";
    L37:
        return ((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).d(new wb5.d(r8, r6, r7, r9, r0.getType(), r0.d, r11, r12));
    L35:
        r9 = r113;
    L29:
        r111 = null;
        goto L30
    L31:
        r112 = r18.b;
        goto L32
    L21:
        r5 = null;
        goto L22
    L14:
        if ((r16 instanceof DocumentPluginHost) == false) goto L18;
        DocViewModel r10 = ((DocumentPluginHost) r16).a();
        if (r10 == null) goto L18;
        String r13 = r10.getToken();
        r12 = r10.getOriginBearUrl().b;
        r11 = r13;
        goto L19
    L38:
        r18.a.b();
        throw null;
    L9:
        r6 = r4;
        goto L10
    L40:
        if (r16 == null) goto L42;
        Fragment r114 = r16.getHostFragment();
    L44:
        if (ForsetiHelper.s(r114) == false) goto L62;
        c r115 = b(r16);
        String r20 = r115.f;
        String r1 = r115.b;
        if (r1 != null) goto L48;
        String r21 = "";
    L49:
        if (r16 != null) goto L51;
    L55:
        String r116 = "";
        String r117 = r116;
    L56:
        String r2 = r115.a;
        if (r2 != null) goto L59;
        String r22 = "";
    L61:
        return ((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).d(new wb5.d(true, r21, r20, r22, r115.getType(), r115.d, r116, r117));
    L59:
        r22 = r2;
        goto L61
    L51:
        if ((r16 instanceof DocumentPluginHost) == false) goto L55;
        DocViewModel r118 = ((DocumentPluginHost) r16).a();
        if (r118 == null) goto L55;
        String r3 = r118.getToken();
        r117 = r118.getOriginBearUrl().b;
        r116 = r3;
        goto L56
    L48:
        r21 = r1;
        goto L49
    L42:
        r114 = null;
        goto L44
    }
}
