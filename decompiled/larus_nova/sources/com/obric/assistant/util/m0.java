package com.obric.assistant.util;

import android.view.View;
import android.view.ViewGroup;
import com.larus.nova.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final /* synthetic */ class m0 implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s0 f393768a;

    public /* synthetic */ m0(s0 r100) {
        this.f393768a = r100;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object r100, Object r101) {
        s0 r102 = this.f393768a;
        View r103 = (View) r100;
        float r104 = ((Float) r101).floatValue();
        Intrinsics.checkNotNullParameter(r103, "view");
        if (r103.getId() != R.id.obric_speaker_bg_view) goto L7;
        ViewGroup r105 = r102.f393832d;
        if (r105 == null) goto L7;
        float r106 = r105.getPaddingBottom();
    L8:
        r103.setTranslationY(r104 + r106);
        return Unit.INSTANCE;
    L7:
        r106 = 0.0f;
        goto L8
    }
}
