package com.larus.uaigc.chat.markdown.helper;

import com.larus.platform.api.IVideoController;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes31.dex */
public final /* synthetic */ class g1 implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ rd8.b f370935a;

    public /* synthetic */ g1(rd8.b r100) {
        this.f370935a = r100;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object r100, Object r101) {
        rd8.b r102 = this.f370935a;
        String r103 = (String) r100;
        IVideoController r104 = (IVideoController) r101;
        if (r102 == null) goto L11;
        kh8.a r105 = r102.q3();
        if (r105 == null) goto L11;
        if (r104 == null) goto L8;
        Integer r106 = Integer.valueOf(r104.getCurrentPlaybackTime());
    L9:
        r105.e(r103, r106);
        goto L11
    L8:
        r106 = null;
    L11:
        return Unit.INSTANCE;
    }
}
