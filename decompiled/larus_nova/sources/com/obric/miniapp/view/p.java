package com.obric.miniapp.view;

import android.content.Context;
import com.google.gson.JsonObject;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes33.dex */
public final /* synthetic */ class p implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MiniAppFragment f398675a;

    public /* synthetic */ p(MiniAppFragment r100) {
        this.f398675a = r100;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object r100, Object r101) {
        MiniAppFragment r102 = this.f398675a;
        boolean r103 = ((Boolean) r100).booleanValue();
        int r104 = ((Integer) r101).intValue();
        int r105 = MiniAppFragment.R;
        Context r106 = r102.getContext();
        if (r106 == null) goto L10;
        com.bytedance.ai.model.widgets.c r107 = r102.f398598k;
        if (r107 == null) goto L10;
        d3.b0 r108 = r107.getAIBridge();
        if (r108 == null) goto L10;
        JsonObject r109 = new JsonObject();
        r109.addProperty("visible", Boolean.valueOf(r103));
        r109.addProperty("height", Integer.valueOf(com.bytedance.ai.utils.o.d(r104, r106)));
        Unit r110 = Unit.INSTANCE;
        r108.a("applet.keyboardStatusChange", r109);
    L10:
        return Unit.INSTANCE;
    }
}
