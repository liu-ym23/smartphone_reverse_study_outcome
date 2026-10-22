package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.sys;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.larksuite.component.universe_design.button.UDButton;
import com.larksuite.component.universe_design.button.e;
import com.ss.android.lark.image.api.SimpleTarget;
import kotlin.Unit;

/* JADX INFO: loaded from: classes35.dex */
public final class a extends SimpleTarget<Drawable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SysChatGuideContentBlock f413248a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ UDButton f413249b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f413250c;

    @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
    public final void onLoadFailed(Drawable r100) {
        UDButton r101 = this.f413249b;
        String r102 = this.f413250c;
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        e.b(r101, r102);
    }

    @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
    public final void onResourceReady(Object r100) {
        Drawable r101 = (Drawable) r100;
        if (r101 == null) goto L10;
        int r102 = this.f413248a.f413234h;
        r101.setBounds(new Rect(0, 0, r102, r102));
        UDButton r103 = this.f413249b;
        com.larksuite.component.universe_design.button.a r104 = new com.larksuite.component.universe_design.button.a();
        String r105 = this.f413250c;
        if (r105 != null) goto L8;
        r105 = "";
    L8:
        r104.f284588b = r105;
        Unit r106 = Unit.INSTANCE;
        e.d(r103, r101, r104);
        return;
    }

    public a(SysChatGuideContentBlock r100, UDButton r101, String r102) {
        this.f413248a = r100;
        this.f413249b = r101;
        this.f413250c = r102;
    }
}
