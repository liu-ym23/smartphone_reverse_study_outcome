package com.bytedance.lynx.media;

import com.bytedance.lynx.media.playable.IVideoEnginePlayable;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyMap;

/* JADX INFO: loaded from: classes21.dex */
public final class b implements IVideoEnginePlayable.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Callback f264823a;

    public b(Callback r100) {
        this.f264823a = r100;
    }

    @Override // com.bytedance.lynx.media.playable.IVideoEnginePlayable.a
    public final void a(int r100, j07.c r101, int r102, String r103) {
        JavaOnlyMap r104 = new JavaOnlyMap();
        if (r100 == 0) goto L5;
        r104.put("errorCode", Integer.valueOf(r102));
        r104.put("errorMsg", r103);
    L5:
        this.f264823a.invoke(new Object[]{Integer.valueOf(r100), r104});
    }
}
