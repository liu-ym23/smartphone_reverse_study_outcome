package com.bytedance.ee.bear.profile;

import android.content.Context;
import android.view.View;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class j extends com.bytedance.ee.bear.facade.common.widget.d {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final ArrayList<View> f236289s;

    @Override // com.bytedance.ee.bear.facade.common.widget.d
    public final int b() {
        return this.f226590e.getHeight() - ((int) this.f226590e.getTranslationY());
    }

    public final void o() {
        View r100 = this.f226590e;
        r100.setTranslationY(r100.getHeight() - 1);
        p();
    }

    public final void p() {
        ArrayList<View> r100 = this.f236289s;
        if (r100 == null) goto L8;
        Iterator<T> r101 = r100.iterator();
    L6:
        if (r101.hasNext() == false) goto L10;
        ((View) r101.next()).setTranslationY(this.f226590e.getTranslationY());
        goto L6
    L10:
        return;
    }

    @Override // com.bytedance.ee.bear.facade.common.widget.d
    public final int c() {
        return b();
    }

    @Override // com.bytedance.ee.bear.facade.common.widget.d
    public final void l(float r100) {
        if (r100 >= 0.0f) goto L5;
        return;
    L5:
        float r101 = this.f226590e.getHeight() - r100;
        if (r101 != this.f226590e.getTranslationY()) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
        return;
    L11:
        this.f226590e.setTranslationY(r101);
        p();
        d((int) r100);
        return;
    L8:
        r102 = false;
        goto L9
    }

    @Override // com.bytedance.ee.bear.facade.common.widget.d
    public final void m(float r100, float r101, float r102) {
        super.m(r100, r101, r102);
    }

    public j(Context r100, VerticalScrollInterceptLayout r101, float r102, float r110, ArrayList r111) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "contentView");
        Intrinsics.checkNotNullParameter(r111, "followViews");
        super(r100, r101, 0.0f, r102, r110);
        this.f236289s = r111;
    }
}
