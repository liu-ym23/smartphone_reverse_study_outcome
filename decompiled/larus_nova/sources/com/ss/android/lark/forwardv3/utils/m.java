package com.ss.android.lark.forwardv3.utils;

import android.view.KeyEvent;
import android.widget.TextView;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes36.dex */
public final class m implements TextView.OnEditorActionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0<Boolean> f425589a;

    public m(Function0<Boolean> r100) {
        this.f425589a = r100;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView r100, int r101, KeyEvent r102) {
        if (r101 == 4) goto L5;
        return false;
    L5:
        return this.f425589a.invoke().booleanValue();
    }
}
