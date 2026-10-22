package com.larus.uaigc.chat.markdown.helper;

import com.larus.common_ui.video.VideoPlayView;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes31.dex */
public final class a0 implements VideoPlayView.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ iy9.b f370907a;

    public a0(iy9.b r100) {
        this.f370907a = r100;
    }

    @Override // com.larus.common_ui.video.VideoPlayView.a
    public final void a(String r100) {
        iy9.b r101 = this.f370907a;
        if (r101 == null) goto L8;
        Function2<String, Boolean, Unit> r102 = r101.f496617c;
        if (r102 == null) goto L9;
        r102.invoke(r100, Boolean.TRUE);
        return;
    L9:
        return;
    }

    @Override // com.larus.common_ui.video.VideoPlayView.a
    public final void onPause(String r100) {
        iy9.b r101 = this.f370907a;
        if (r101 == null) goto L8;
        Function2<String, Boolean, Unit> r102 = r101.f496617c;
        if (r102 == null) goto L9;
        r102.invoke(r100, Boolean.FALSE);
        return;
    L9:
        return;
    }
}
