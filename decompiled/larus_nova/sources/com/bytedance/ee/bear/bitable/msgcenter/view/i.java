package com.bytedance.ee.bear.bitable.msgcenter.view;

import android.view.View;
import com.bytedance.ee.bear.bitable.uikit.ActionPayload;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes15.dex */
public final class i implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ActionPayload f214740a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<com.larksuite.component.universe_design.menu.c> f214741b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ gv4.a f214742c;

    public i(ActionPayload r100, Ref.ObjectRef<com.larksuite.component.universe_design.menu.c> r101, gv4.a r102) {
        this.f214740a = r100;
        this.f214741b = r101;
        this.f214742c = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        ActionPayload r101 = this.f214740a;
        if (r101 == null) goto L7;
        gv4.a r102 = this.f214742c;
        if (r102 == null) goto L7;
        r102.a(r101);
    L7:
        com.larksuite.component.universe_design.menu.c r103 = this.f214741b.element;
        if (r103 == null) goto L10;
        r103.a();
    L10:
        a.b("history");
    }
}
