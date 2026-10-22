package com.bytedance.ee.bear.list.homepage.title;

import android.content.Context;
import android.view.View;
import bd5.r;
import bd5.s;
import com.bytedance.ee.bear.lark.i;
import com.ss.android.lark.maincore.ITitleInfo;
import com.ss.android.lark.maintab.export.ITabTitleConfig;
import com.ss.android.lark.maintab.export.d;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c implements b {
    public final d a;
    public final s b;
    public final bd5.b c;
    public final View.OnClickListener d;
    public final r e;
    public int f;

    @Override // com.bytedance.ee.bear.list.homepage.title.b
    public final int getTitleType() {
        return 0;
    }

    @Override // com.bytedance.ee.bear.list.homepage.title.b
    public final void b() {
        this.e.c = 0;
        this.f = this.a.getTitleBarHeight();
        this.a.a();
        this.b.getClass();
    }

    @Override // com.bytedance.ee.bear.list.homepage.title.b
    public final View getCreateView() {
        return this.c.b().a;
    }

    @Override // com.bytedance.ee.bear.list.homepage.title.b
    public final int getTitleBarHeight() {
        return this.a.getTitleBarHeight();
    }

    @Override // com.bytedance.ee.bear.list.homepage.title.b
    public final void a(int r4) {
        int r5 = this.e.b(this.f, r4);
        this.f = r5;
        float r6 = this.e.a(r5);
        this.e.getClass();
        if (r6 <= 0.1f) goto L5;
        boolean r0 = true;
    L6:
        tt5.a.b("TitleControllerWrapper", "onScrollBy, height:" + this.f + ", alpha:" + r6 + ", visible:" + r0);
        if (r0 == false) goto L9;
        this.a.a();
        this.b.getClass();
        return;
    L9:
        this.a.x();
        this.b.getClass();
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void c(View.OnClickListener r2) {
        bd5.a r0 = this.c.c();
        r0.b = r2;
        r0.a.setOnClickListener(r2);
    }

    public final void d(View.OnClickListener r2) {
        bd5.a r3 = this.c.d();
        View.OnClickListener r0 = this.d;
        r3.b = r0;
        r3.a.setOnClickListener(r0);
    }

    @Override // com.bytedance.ee.bear.list.homepage.title.b
    public final void setTitle(String r1) {
        this.b.getClass();
        this.a.b();
    }

    public final void e(boolean r5, boolean r6) {
        bd5.a r0 = this.c.d();
        bd5.a r1 = this.c.b();
        bd5.a r2 = this.c.c();
        ArrayList r3 = new ArrayList();
        r3.add(r0);
        if (r5 == false) goto L5;
        r3.add(r1);
    L5:
        if (r6 == false) goto L7;
        r3.add(r2);
    L7:
        s r7 = this.b;
        ((ArrayList) r7.a).clear();
        ((ArrayList) r7.a).addAll(r3);
        s r8 = this.b;
        ITitleInfo.IconStyle r9 = ITitleInfo.IconStyle.Hide;
        r8.getClass();
        this.a.b();
    }

    public c(Context r1, d r2, s r3, ITabTitleConfig r4, i r5) {
        this.a = r2;
        this.b = r3;
        this.d = r5;
        int r6 = r2.getTitleBarHeight();
        this.f = r6;
        this.e = new r(r6, r6);
        this.c = new bd5.b(r1);
    }
}
