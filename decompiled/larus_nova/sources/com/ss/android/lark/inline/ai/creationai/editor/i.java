package com.ss.android.lark.inline.ai.creationai.editor;

import com.ss.android.lark.inline.ai.creationai.d0;
import com.ss.android.lark.log.Log;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes36.dex */
public final class i<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CreationAIEditorWebview f427100a;

    public i(CreationAIEditorWebview r100) {
        this.f427100a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        int r102 = d0.f427056b;
        if (r101 == null) goto L5;
        String r103 = r101.toString();
    L6:
        d0.a.a(404, r103, 0);
        Log.e(this.f427100a.getMTag(), r101, true);
        return;
    L5:
        r103 = null;
        goto L6
    }
}
