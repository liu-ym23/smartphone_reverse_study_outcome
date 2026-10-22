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

/* JADX INFO: loaded from: classes18.dex */
public final class c implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f228409a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s f228410b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final bd5.b f228411c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View.OnClickListener f228412d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final r f228413e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f228414f;

    @Override // com.bytedance.ee.bear.list.homepage.title.b
    public final int getTitleType() {
        return 0;
    }

    @Override // com.bytedance.ee.bear.list.homepage.title.b
    public final void b() {
        this.f228413e.f18677c = 0;
        this.f228414f = this.f228409a.getTitleBarHeight();
        this.f228409a.a();
        this.f228410b.getClass();
    }

    @Override // com.bytedance.ee.bear.list.homepage.title.b
    public final View getCreateView() {
        return this.f228411c.b().f18656a;
    }

    @Override // com.bytedance.ee.bear.list.homepage.title.b
    public final int getTitleBarHeight() {
        return this.f228409a.getTitleBarHeight();
    }

    @Override // com.bytedance.ee.bear.list.homepage.title.b
    public final void a(int r100) {
        int r101 = this.f228413e.b(this.f228414f, r100);
        this.f228414f = r101;
        float r102 = this.f228413e.a(r101);
        this.f228413e.getClass();
        if (r102 <= 0.1f) goto L5;
        boolean r103 = true;
    L6:
        tt5.a.b("TitleControllerWrapper", "onScrollBy, height:" + this.f228414f + ", alpha:" + r102 + ", visible:" + r103);
        if (r103 == false) goto L9;
        this.f228409a.a();
        this.f228410b.getClass();
        return;
    L9:
        this.f228409a.x();
        this.f228410b.getClass();
        return;
    L5:
        r103 = false;
        goto L6
    }

    public final void c(View.OnClickListener r100) {
        bd5.a r101 = this.f228411c.c();
        r101.f18657b = r100;
        r101.f18656a.setOnClickListener(r100);
    }

    public final void d(View.OnClickListener r100) {
        bd5.a r101 = this.f228411c.d();
        View.OnClickListener r102 = this.f228412d;
        r101.f18657b = r102;
        r101.f18656a.setOnClickListener(r102);
    }

    @Override // com.bytedance.ee.bear.list.homepage.title.b
    public final void setTitle(String r100) {
        this.f228410b.getClass();
        this.f228409a.b();
    }

    public final void e(boolean r100, boolean r101) {
        bd5.a r102 = this.f228411c.d();
        bd5.a r103 = this.f228411c.b();
        bd5.a r104 = this.f228411c.c();
        ArrayList r105 = new ArrayList();
        r105.add(r102);
        if (r100 == false) goto L5;
        r105.add(r103);
    L5:
        if (r101 == false) goto L7;
        r105.add(r104);
    L7:
        s r106 = this.f228410b;
        ((ArrayList) r106.f18679a).clear();
        ((ArrayList) r106.f18679a).addAll(r105);
        s r107 = this.f228410b;
        ITitleInfo.IconStyle r108 = ITitleInfo.IconStyle.Hide;
        r107.getClass();
        this.f228409a.b();
    }

    public c(Context r100, d r101, s r102, ITabTitleConfig r103, i r104) {
        this.f228409a = r101;
        this.f228410b = r102;
        this.f228412d = r104;
        int r105 = r101.getTitleBarHeight();
        this.f228414f = r105;
        this.f228413e = new r(r105, r105);
        this.f228411c = new bd5.b(r100);
    }
}
