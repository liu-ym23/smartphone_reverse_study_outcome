package com.ss.android.lark.inline.ai.creationai.editor;

import android.view.GestureDetector;
import android.view.MotionEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class f extends GestureDetector.SimpleOnGestureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CreationAIEditorWebview f427094a;

    public f(CreationAIEditorWebview r100) {
        this.f427094a = r100;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final void onLongPress(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        l r101 = this.f427094a.R;
        if (r101 == null) goto L5;
        r101.b();
    L5:
        super.onLongPress(r100);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onSingleTapUp(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        l r101 = this.f427094a.R;
        if (r101 == null) goto L7;
        r101.b();
        return false;
    L7:
        return false;
    }
}
