package com.bytedance.ee.bear.bitable.msgcenter.view;

import android.view.View;
import com.bytedance.ee.bear.bitable.uikit.ActionPayload;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes15.dex */
public final class h implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ActionPayload f214736a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<com.larksuite.component.universe_design.menu.c> f214737b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f214738c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ gv4.a f214739d;

    public h(ActionPayload r100, Ref.ObjectRef<com.larksuite.component.universe_design.menu.c> r101, boolean r102, gv4.a r103) {
        this.f214736a = r100;
        this.f214737b = r101;
        this.f214738c = r102;
        this.f214739d = r103;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        ActionPayload r101 = this.f214736a;
        if (r101 == null) goto L7;
        gv4.a r102 = this.f214739d;
        if (r102 == null) goto L7;
        r102.a(r101);
    L7:
        com.larksuite.component.universe_design.menu.c r103 = this.f214737b.element;
        if (r103 == null) goto L11;
        r103.a();
    L11:
        if (this.f214738c == false) goto L13;
        a.b("message_un_mute");
        return;
    L13:
        a.b("message_mute");
    }
}
