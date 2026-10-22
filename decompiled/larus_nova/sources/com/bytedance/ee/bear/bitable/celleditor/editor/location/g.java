package com.bytedance.ee.bear.bitable.celleditor.editor.location;

import android.content.Context;
import android.webkit.ValueCallback;
import com.bytedance.ee.bear.lark.dependency.r;
import com.bytedance.supervisor.token.Token;

/* JADX INFO: loaded from: classes15.dex */
public final class g<T> implements ValueCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f209429a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f209430b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ValueCallback<Boolean> f209431c;

    public g(boolean r100, e r101, b r102) {
        this.f209429a = r100;
        this.f209430b = r101;
        this.f209431c = r102;
    }

    @Override // android.webkit.ValueCallback
    public final void onReceiveValue(Object r100) {
        if (((Boolean) r100).booleanValue() == true) goto L5;
        this.f209431c.onReceiveValue(Boolean.FALSE);
        return;
    L5:
        if (this.f209429a == false) goto L7;
        Token r101 = e.f209420d;
    L8:
        r r102 = (r) org.koin.java.a.c(r.class, null, null, 6);
        Context r103 = this.f209430b.f209426a.getContext();
        final e r104 = this.f209430b;
        final ValueCallback<Boolean> r105 = this.f209431c;
        r102.b(r103, r101, new LocationEditorViewModel$enterEditModeAuto$1$1(r104, r105));
        return;
    L7:
        r101 = e.f209422f;
        goto L8
    }
}
