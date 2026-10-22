package com.larus.bmhome.chat.layout.item;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public abstract class g extends i implements st8.a {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public p f304362p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Function0<Boolean> f304363q;

    @Override // st8.a
    public float getClickX() {
        return 0.0f;
    }

    @Override // st8.a
    public float getClickY() {
        return 0.0f;
    }

    @Override // st8.a
    public final View l5() {
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FrameLayout getContainer() {
        if ((this instanceof FrameLayout) == true) goto L7;
        return null;
    L7:
        return (FrameLayout) this;
    }

    @Override // com.larus.bmhome.chat.layout.item.i
    public Integer getImmerseBgColor() {
        return super.getImmerseBgColor();
    }

    @Override // com.larus.bmhome.chat.layout.item.i
    public boolean getUseSubscribedColor() {
        return super.getUseSubscribedColor();
    }

    public Function0<Boolean> getDownListener() {
        return this.f304363q;
    }

    public g(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }

    public final void setBoxChangedListener(p r100) {
        Intrinsics.checkNotNullParameter(r100, "boxChangedListener");
        this.f304362p = r100;
    }

    public void setDownListener(Function0<Boolean> r100) {
        this.f304363q = r100;
    }

    @Override // com.larus.bmhome.chat.layout.item.i
    public void setImmerseBgColor(Integer r100) {
        super.setImmerseBgColor(r100);
        p r101 = this.f304362p;
        if (r101 == null) goto L6;
        r101.c(r100);
        return;
    }

    @Override // com.larus.bmhome.chat.layout.item.i
    public void setUseSubscribedColor(boolean r100) {
        super.setUseSubscribedColor(r100);
        p r101 = this.f304362p;
        if (r101 == null) goto L6;
        r101.b(r100);
        return;
    }

    @Override // com.larus.bmhome.chat.layout.item.i
    public void l(boolean r100, boolean r101) {
        super.l(r100, r101);
        p r102 = this.f304362p;
        if (r102 == null) goto L6;
        r102.a(r100, r101);
        return;
    }
}
