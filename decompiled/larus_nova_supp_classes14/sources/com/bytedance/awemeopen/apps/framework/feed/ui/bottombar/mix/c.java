package com.bytedance.awemeopen.apps.framework.feed.ui.bottombar.mix;

import android.app.Activity;
import android.text.TextUtils;
import androidx.lifecycle.Observer;
import com.bytedance.awemeopen.apps.framework.feed.AosEventReporter;
import com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.o;
import com.bytedance.awemeopen.bizmodels.feed.mix.MixStatisStruct;
import com.bytedance.awemeopen.bizmodels.feed.mix.MixStruct;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import r14.w;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c extends BaseElement<i, j, a, jz3.a> {
    public final Activity g;
    public final o h;
    public jz3.a i;
    public String j;
    public String k;
    public String l;
    public String m;
    public Integer n;
    public Integer o;
    public String p;
    public boolean q;
    public boolean r;

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void m() {
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void n() {
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void o() {
        this.q = false;
        this.k = null;
        this.l = null;
        this.j = null;
        this.n = null;
        this.o = null;
        this.r = false;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.a b() {
        return new i();
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.b c() {
        return new j();
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c d() {
        return new h(getContext(), g(), h());
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void k() {
        if (this.r == true) goto L5;
        return;
    L5:
        AosEventReporter r0 = AosEventReporter.a;
        o r1 = this.h;
        jz3.a r2 = this.i;
        String r3 = this.k;
        if (r3 != null) goto L8;
        r3 = "";
    L8:
        String r5 = this.j;
        if (r5 != null) goto L11;
        r5 = "";
    L11:
        String r6 = this.l;
        if (r6 != null) goto L15;
        r6 = "";
    L15:
        if (r1.getPageConfig().getHostExtraParams() == null) goto L20;
        JSONObject r4 = this.h.getPageConfig().getHostExtraParams();
        if (r4 == null) goto L19;
        JSONObject r7 = r4.put("host_expand_raw_data", this.m);
    L21:
        JSONObject r8 = r7;
        r0.getClass();
        AosEventReporter.i(r1, r2, r3, r5, r6, r8);
        return;
    L19:
        r7 = null;
        goto L21
    L20:
        r7 = new JSONObject().put("host_expand_raw_data", this.m);
        goto L21
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void onCreate() {
        i r0 = g();
        Observer<Unit> r1 = new b(this);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "observer");
        r0.a.a(r1);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.d e() {
        return wz3.a.a;
    }

    public final Activity getActivity() {
        return this.g;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void l(jz3.a r8) {
        jz3.a r9 = r8;
        Intrinsics.checkNotNullParameter(r9, "data");
        if (f().d() == false) goto L5;
    L64:
        j();
        return;
    L5:
        if (Intrinsics.areEqual(this.h.getPageConfig().getEnterFrom(), "volc_agent_card") == true) goto L64;
        this.i = r9;
        MixStruct r0 = r9.a.y();
        boolean r1 = false;
        String r4 = "";
        if (r0 == null) goto L34;
        this.j = r0.getMixId();
        this.l = r0.getMixName();
        this.m = r0.getExtra();
        this.k = getContext().getResources().getText(2131894234).toString();
        this.q = false;
        MixStatisStruct r10 = r0.getStatis();
        if (r10 == null) goto L12;
        Integer r11 = Integer.valueOf(r10.getCurrentEpisode());
    L13:
        this.n = r11;
        MixStatisStruct r12 = r0.getStatis();
        if (r12 == null) goto L16;
        Integer r13 = Integer.valueOf(r12.getUpdatedToEpisode());
    L17:
        this.o = r13;
        String r14 = this.l;
        if (r14 != null) goto L20;
    L21:
        r1 = true;
    L22:
        if (r1 == true) goto L33;
        Integer r15 = this.n;
        if (r15 == null) goto L33;
        Intrinsics.checkNotNull(r15);
        if (r15.intValue() < 0) goto L33;
        p();
        j r16 = h();
        String r2 = this.l;
        Intrinsics.checkNotNull(r2);
        r16.getClass();
        Intrinsics.checkNotNullParameter(r2, "name");
        r16.b.b(r2);
        j r17 = h();
        String r3 = this.k;
        if (r3 == null) goto L32;
        r4 = r3;
    L32:
        r17.getClass();
        Intrinsics.checkNotNullParameter(r4, "name");
        r17.a.b(r4);
        h().c.b(null);
        return;
    L33:
        j();
        return;
    L20:
        if (r14.length() != 0) goto L22;
    L16:
        r13 = null;
        goto L17
    L12:
        r11 = null;
        goto L13
    L34:
        Map r18 = r9.a.w();
        if (r18 == null) goto L63;
        List r19 = (List) r18.get(3);
        if (r19 == null) goto L63;
        if (r19.isEmpty() == true) goto L63;
        w r20 = (w) ListProtector.get(r19, 0);
        this.k = r20.i();
        this.j = String.valueOf(r20.b());
        this.l = r20.a();
        this.m = r20.f();
        this.p = r20.d();
        this.q = true;
        String r5 = this.l;
        if (r5 != null) goto L44;
    L47:
        boolean r6 = true;
    L48:
        if (r6 == false) goto L56;
        String r7 = this.k;
        if (r7 != null) goto L52;
    L53:
        r1 = true;
    L54:
        if (r1 == false) goto L56;
        j();
        return;
    L52:
        if (r7.length() != 0) goto L54;
    L56:
        p();
        this.r = true;
        j r21 = h();
        String r22 = this.l;
        Intrinsics.checkNotNull(r22);
        r21.getClass();
        Intrinsics.checkNotNullParameter(r22, "name");
        r21.b.b(r22);
        if (TextUtils.isEmpty(this.k) == false) goto L59;
        j r23 = h();
        r23.getClass();
        Intrinsics.checkNotNullParameter("", "name");
        r23.a.b("");
    L60:
        List<String> r24 = r20.c();
        if (r24 == null) goto L69;
        h().c.b(r24);
        return;
    L69:
        return;
    L59:
        j r25 = h();
        String r26 = String.valueOf(this.k);
        r25.getClass();
        Intrinsics.checkNotNullParameter(r26, "name");
        r25.a.b(r26);
        goto L60
    L44:
        if (r5.length() == 0) goto L47;
        r6 = false;
    L63:
        j();
    }

    public c(Activity r2, o r3) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "vm");
        super(r2);
        this.g = r2;
        this.h = r3;
    }
}
