package com.larus.voicecall.impl.component.vlm;

import android.widget.ImageView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public final /* synthetic */ class j2 implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ImageView f377960a;

    public /* synthetic */ j2(ImageView r100) {
        this.f377960a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        JSONObject r101 = (JSONObject) r100;
        if (this.f377960a.isSelected() == false) goto L5;
        String r102 = "on";
    L6:
        r101.put("flashlight_status", r102);
        return Unit.INSTANCE;
    L5:
        r102 = "off";
        goto L6
    }
}
