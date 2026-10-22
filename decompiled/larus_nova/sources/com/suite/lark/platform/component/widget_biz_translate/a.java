package com.suite.lark.platform.component.widget_biz_translate;

import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.log.Log;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TranslateOptionsAdapter f461143a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f461144b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ TranslateOptionsAdapter.b f461145c;

    public a(TranslateOptionsAdapter r100, int r101, TranslateOptionsAdapter.b r102) {
        this.f461143a = r100;
        this.f461144b = r101;
        this.f461145c = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        TranslateOptionsAdapter r101 = this.f461143a;
        TranslateOptionsAdapter.b r102 = (TranslateOptionsAdapter.b) CollectionsKt.getOrNull(r101.f461129a, r101.f461130b);
        if (r102 == null) goto L5;
        TranslateOptionsAdapter r103 = this.f461143a;
        Log.d("TranslateOptionsAdapter", "onBindViewHolder: lastSelectedIndex is : " + r103.f461130b);
        r102.f461136a = false;
        r103.notifyItemChanged(r103.f461130b);
    L5:
        ((TranslateOptionsAdapter.b) ListProtector.get(this.f461143a.f461129a, this.f461144b)).f461136a = true;
        this.f461143a.f461130b = this.f461144b;
        Log.d("TranslateOptionsAdapter", "onBindViewHolder: newSelectIndex is : " + this.f461143a.f461130b);
        TranslateOptionsAdapter r104 = this.f461143a;
        r104.notifyItemChanged(r104.f461130b);
        this.f461143a.f461131c.invoke(this.f461145c);
    }
}
