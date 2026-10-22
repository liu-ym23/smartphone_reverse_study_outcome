package com.bytedance.ee.bear.bitable;

import android.view.View;
import com.bytedance.ee.bear.bitable.uikit.Action;
import com.bytedance.ee.bear.bitable.uikit.ActionPayload;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes15.dex */
public final class h implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Action f212144a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f212145b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ gv4.a f212146c;

    public h(ActionPayload r100, Function0 r101, gv4.a r102) {
        this.f212144a = r100;
        this.f212145b = r101;
        this.f212146c = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Action r101 = this.f212144a;
        if (r101 == null) goto L7;
        gv4.a r102 = this.f212146c;
        if (r102 == null) goto L7;
        r102.a(r101);
    L7:
        Function0<Unit> r103 = this.f212145b;
        if (r103 == null) goto L11;
        r103.invoke();
        return;
    }
}
