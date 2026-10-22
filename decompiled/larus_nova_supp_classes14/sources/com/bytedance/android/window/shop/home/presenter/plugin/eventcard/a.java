package com.bytedance.android.window.shop.home.presenter.plugin.eventcard;

import android.content.Context;
import android.widget.LinearLayout;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.opt.ab.p;
import com.bytedance.android.ec.window.base.setting.WindowSettingKeys;
import com.bytedance.android.window.shop.eventcard.LynxEventCard;
import com.bytedance.android.window.shop.home.tab.tabplugin.e;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a implements e {
    public LynxEventCard a;
    public final Context b;
    public final LifecycleOwner c;
    public final ECWindowViewModel d;

    @Override // com.bytedance.android.window.shop.home.tab.tabplugin.e
    public final void a() {
        Lazy r1 = ECSettingKeys.a;
        int r2 = p.a;
        Object r3 = Boolean.FALSE;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r5 = jj4.b.b;     // Catch: Throwable -> L7
        Object r6 = jj4.a.a("window_use_lynx_event_card", Boolean.class, r3, false);     // Catch: Throwable -> L7
        if (r6 != null) goto L13;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L13:
        b r0 = new b(((Boolean) r6).booleanValue(), WindowSettingKeys.getEC_COMMERCE_WINDOW_LYNX_EVENT_CARD_URL());
        if (r0.a == true) goto L16;
        return;
    L16:
        final String r7 = r0.b;
        Context r8 = this.b;
        LynxEventCard r9 = this.a;
        if (r9 == null) goto L23;
        Iterator<com.bytedance.android.window.shop.eventcard.handler.a> r10 = r9.a.c.values().iterator();
    L20:
        if (r10.hasNext() == false) goto L22;
        r10.next().release();
        goto L20
    L22:
        r9.b.release();
    L23:
        final LynxEventCard r11 = new LynxEventCard(r8, new LinearLayout(r8), this.d);
        this.a = r11;
        this.d.runLowPriorityTask(new ECWindowEventHandlePlugin$prepareLynxEventCard$1(this, r11, r7));
        return;
    L7:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        Object r13 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r13) == true) goto L12;
        r3 = r13;
    L12:
        r6 = r3;
        goto L13
    }

    @Override // com.bytedance.android.window.shop.home.tab.tabplugin.e
    public final void b() {
        LynxEventCard r0 = this.a;
        if (r0 == null) goto L9;
        Iterator<com.bytedance.android.window.shop.eventcard.handler.a> r1 = r0.a.c.values().iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        r1.next().release();
        goto L6
    L8:
        r0.b.release();
    L9:
        this.a = null;
    }

    public a(Context r2, LifecycleOwner r3, ECWindowViewModel r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r4, "viewModel");
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
