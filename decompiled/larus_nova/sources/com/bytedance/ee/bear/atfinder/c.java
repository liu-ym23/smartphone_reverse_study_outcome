package com.bytedance.ee.bear.atfinder;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.ee.bear.at.AtObject;
import com.bytedance.ee.bear.widget.AtFinderView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.chad.library.adapter.base.BaseQuickAdapter;
import io.reactivex.Flowable;
import java.util.ArrayList;
import kn4.k;

/* JADX INFO: loaded from: classes15.dex */
public final class c implements View.OnKeyListener, BaseQuickAdapter.OnItemClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f206348a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f206349b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f206350c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public d f206351d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f206352e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f206353f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f206354g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f206355h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f206356i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final AtFinderViewModel f206357j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final k f206358k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f206359l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final kn4.b f206360m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public AtCheckBoxViewModel f206361n;

    public interface a {
    }

    public final void a() {
        tt5.a.b("AtFinderController", "AtFinderController.closeAtFinder ");
        tt5.a.b("AtFinderController", "accept: ");     // Catch: Exception -> L12
        if (this.f206349b == true) goto L7;
        tt5.a.h("AtFinderController", "closeAtFinder: is showing is false");     // Catch: Exception -> L12
        return;
    L7:
        ((AtFinderView) this.f206348a).a();     // Catch: Exception -> L12
        this.f206349b = false;     // Catch: Exception -> L12
        d r100 = this.f206351d;     // Catch: Exception -> L12
        if (r100 == null) goto L10;
        r100.b();     // Catch: Exception -> L12
        return;
    L10:
        tt5.a.h("AtFinderController", "closeAtFinder: mAtFinderDataCallback is null");     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        tt5.a.e("AtFinderController", "accept: exception", e, false);
    }

    public final synchronized void b(String r100) {
        monitor-enter(this);
    L10:
        e = move-exception;
        tt5.a.e("AtFinderController", "AtFinderController.search ", e, false);     // Catch: Throwable -> L8
    L12:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.f206357j == null) goto L6;
        tt5.a.b("AtFinderController", "search: search direct");     // Catch: Throwable -> L8 Exception -> L10
        ((AtFinderView) this.f206348a).e();     // Catch: Throwable -> L8 Exception -> L10
        this.f206357j.search(this.f206350c, r100, this.f206352e, this.f206354g, this.f206356i);     // Catch: Throwable -> L8 Exception -> L10
    L16:
    L6:
        tt5.a.k("AtFinderController", "search: mSearchViewModel is null");     // Catch: Throwable -> L8 Exception -> L10
        goto L16
    }

    public final void c(boolean r100) {
        tt5.a.h("AtFinderController", "AtFinderController.showAtFinder, needSearch:" + r100);
    L20:
        e = move-exception;
        tt5.a.e("AtFinderController", "accept: exception", e, false);
        return;
    L4:
        if (this.f206349b == false) goto L8;
        tt5.a.h("AtFinderController", "AtFinderController.showAtFinder is showing");     // Catch: Exception -> L20
        return;
    L8:
        if (this.f206348a == null) goto L18;
        this.f206349b = true;     // Catch: Exception -> L20
        if ("default".equals(this.f206355h) == false) goto L12;
        tt5.a.h("AtFinderController", "reportOpenMention(): mZone is default ,not report");     // Catch: Exception -> L20
    L13:
        if (r100 == false) goto L15;
        b("");     // Catch: Exception -> L20
    L15:
        AtFinderView r101 = (AtFinderView) this.f206348a;     // Catch: Exception -> L20
        tt5.a.h(r101.f239858a, "show() called");     // Catch: Exception -> L20
        r101.f239862e.getSearchResultList(r101.f239864g).observe(r101.f239867j, r101.f239865h);     // Catch: Exception -> L20
        r101.setVisibility(0);     // Catch: Exception -> L20
        AtFinderView.c r102 = r101.f239860c;     // Catch: Exception -> L20
        if (r102.f239892t == false) goto L24;
        r102.f239880h.setVisibility(8);     // Catch: Exception -> L20
        return;
    L24:
        return;
    L12:
        this.f206358k.d(this.f206359l);     // Catch: Exception -> L20
        this.f206358k.b();     // Catch: Exception -> L20
        goto L13
    L18:
        tt5.a.h("AtFinderController", "AtFinderController.showAtFinder:142 mContainer is null");     // Catch: Exception -> L20
    }

    public final void d(bo4.d r100) {
        this.f206350c = r100.f19839a;
        this.f206354g = r100.f19840b;
        this.f206355h = r100.f19841c;
        this.f206358k.f(r100);
        this.f206356i = r100.f19845g;
        if (TextUtils.isEmpty(r100.f19844f) == true) goto L6;
        this.f206359l = TextUtils.equals(r100.f19844f, NewBroadcastMonitor.STAGE.TOOLBAR);
        return;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
    public final void onItemClick(BaseQuickAdapter r100, View r101, int r102) {
        this.f206358k.clearParams();
        if (r100.getData().size() > r102) goto L6;
        tt5.a.d("AtFinderController", "onItemClick(): size" + r100.getData().size());
        return;
    L6:
        AtObject r103 = (AtObject) ListProtector.get(r100.getData(), r102);
        r103.setSequenceNum(r102);
        AtFinderResultList r104 = new AtFinderResultList();
        AtFinderResultList.DATA r105 = new AtFinderResultList.DATA();
        ArrayList r106 = new ArrayList();
        r106.add(r103);
        r105.setResult_list(r106);
        r104.setData(r105);
        if (this.f206351d == null) goto L9;
        Flowable.just(r104).observeOn(fo5.d.d()).subscribe(new com.bytedance.ee.bear.atfinder.a(this, r103, r102), new b());
        return;
    L9:
        this.f206358k.e(r103, this.f206359l);
        k r107 = this.f206358k;
        AtCheckBoxViewModel r108 = this.f206361n;
        if (r108 != null) goto L12;
    L14:
        boolean r109 = false;
    L15:
        r107.c(r103, r109, r102, true ^ TextUtils.equals(this.f206353f, ""));
        tt5.a.h("AtFinderController", "AtFinderController.sendResult:103 mAtFinderDataCallback is null");
        return;
    L12:
        if (r108.isCheckboxSelected() == false) goto L14;
        r109 = true;
        goto L15
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View r100, int r101, KeyEvent r102) {
        tt5.a.b("AtFinderController", "AtFinderController.onKey:104 ");
        if (r102.getAction() == 1) goto L5;
        return false;
    L5:
        if (r101 != 4) goto L10;
        tt5.a.h("AtFinderController", "AtFinderController.onKey:106 ");
        a();
        return true;
    L10:
        return false;
    }

    public c(AtFinderViewModel r100, bo4.d r101, bo4.c r102, String r103, a r104) {
        this.f206359l = true;
        tt5.a.b("AtFinderController", "AtFinderController.AtFinderController:52 token=" + du5.b.g(r101.f19839a) + " type=" + r103);
        this.f206349b = false;
        this.f206358k = r102.f19836a;
        if (r102.f19837b != null) goto L5;
        r102.f19837b = new bo4.b();
    L5:
        this.f206360m = r102.f19837b;
        d(r101);
        this.f206348a = r104;
        this.f206357j = r100;
        this.f206352e = r103;
    }
}
