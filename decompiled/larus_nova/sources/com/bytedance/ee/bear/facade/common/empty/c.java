package com.bytedance.ee.bear.facade.common.empty;

import android.content.Context;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;

/* JADX INFO: loaded from: classes16.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f226422a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f226423b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final EmptyStateSource f226424c;

    public final void a(EmptyStateSource.b r100) {
        tt5.a.h("EmptyViewMediator", "updateEmptyState");
        if (r100 != null) goto L5;
        return;
    L5:
        int r101 = r100.f226415a;
        tt5.a.h("EmptyViewMediator", "emptyState.getState:" + r101);
        if (r101 != 0) goto L8;
    L55:
        this.f226422a.show();
        View r102 = this.f226423b;
        if (r102 == null) goto L58;
        r102.setVisibility(4);
    L58:
        this.f226422a.showLoading();
        return;
    L8:
        if (r101 != 1) goto L10;
        this.f226422a.show();
        View r103 = this.f226423b;
        if (r103 == null) goto L54;
        r103.setVisibility(4);
    L54:
        this.f226422a.showNoContent();
        return;
    L10:
        if (r101 != 2) goto L12;
        this.f226422a.hide();
        View r104 = this.f226423b;
        if (r104 == null) goto L68;
        r104.setVisibility(0);
        return;
    L68:
        return;
    L12:
        if (r101 == 3) goto L44;
        if (r101 != 4) goto L15;
        this.f226422a.show();
        View r105 = this.f226423b;
        if (r105 == null) goto L43;
        r105.setVisibility(4);
    L43:
        this.f226422a.showNoNetworkError();
        return;
    L15:
        if (r101 != 5) goto L17;
        this.f226422a.show();
        View r106 = this.f226423b;
        if (r106 == null) goto L39;
        r106.setVisibility(4);
    L39:
        this.f226422a.showNoFound();
        return;
    L17:
        if (r101 == 99) goto L32;
        switch(r101) {
            case 7: goto L28;
            case 8: goto L55;
            case 9: goto L24;
            case 10: goto L20;
            default: goto L19;
        };
    L19:
        tt5.a.d("EmptyViewMediator", "onChanged: unknown state = " + r101);
        return;
    L20:
        this.f226422a.show();
        View r107 = this.f226423b;
        if (r107 == null) goto L23;
        r107.setVisibility(4);
    L23:
        this.f226422a.showNoSupport();
        return;
    L24:
        this.f226422a.show();
        View r108 = this.f226423b;
        if (r108 == null) goto L27;
        r108.setVisibility(4);
    L27:
        this.f226422a.showWikiDeleted();
        return;
    L28:
        this.f226422a.show();
        View r109 = this.f226423b;
        if (r109 == null) goto L31;
        r109.setVisibility(4);
    L31:
        this.f226422a.showTimeout();
        return;
    L32:
        this.f226422a.show();
        View r110 = this.f226423b;
        if (r110 == null) goto L35;
        r110.setVisibility(4);
    L35:
        this.f226422a.showNoPermission();
        return;
    L44:
        this.f226422a.show();
        View r111 = this.f226423b;
        if (r111 == null) goto L47;
        r111.setVisibility(4);
    L47:
        this.f226422a.a();
    }

    public c(d r100, View r101) {
        this.f226422a = r100;
        this.f226423b = r101;
    }

    public c(Context r100, LifecycleOwner r101, EmptyView r102, View r103) {
        this.f226422a = r102;
        this.f226423b = r103;
        EmptyStateSource r104 = new EmptyStateSource(r100);
        this.f226424c = r104;
        r104.observe(r101, new b(this));
    }
}
