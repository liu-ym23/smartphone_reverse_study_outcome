package com.larus.live.impl.ttlivesdk;

import android.content.Context;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.bytedance.router.SmartRouter;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class a extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f355815a;

    public a(Context r100) {
        this.f355815a = r100;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        com.bytedance.router.i r101 = SmartRouter.buildRoute(this.f355815a, "//flow/webview");
        Bundle r102 = new Bundle();
        r102.putString("link_url", "https://lf9-cdn-tos.draftstatic.com/obj/ies-hotsoon-draft/grace_legal/Shopping-Payment-FAQ.html");
        r101.f267554c.putExtras(r102);
        r101.d();
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        Intrinsics.checkNotNullParameter(r100, "ds");
        r100.setUnderlineText(false);
        Context r101 = this.f355815a;
        r100.setColor(ContextCompat.getColor(r101, v19.c.b(R.attr.larus_neutral_100, r101, R.color.larus_neutral_100)));
    }
}
