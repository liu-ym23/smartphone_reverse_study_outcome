package com.ss.android.lark.forwardv2;

import android.content.Context;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larksuite.component.ui.dialog.LKUIDialog;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.forwardv2.dto.StickImage;
import com.ss.android.lark.forwardv2.impl.ForwardPickFragment;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import pl.droidsonroids.gif.GifImageView;

/* JADX INFO: loaded from: classes36.dex */
public final class d implements hib.d {
    public d() {
    }

    @Override // hib.d
    public final void a(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "chatId");
    }

    @Override // hib.d
    public final void b(ForwardPickFragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
    }

    @Override // hib.d
    public final void c(Context r100, GifImageView r101, StickImage r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "imageView");
        Intrinsics.checkNotNullParameter(r102, "image");
    }

    @Override // hib.d
    public final void f() {
    }

    @Override // hib.d
    public final void getEventParams() {
    }

    @Override // hib.d
    public final void getTargetType() {
    }

    @Override // hib.d
    public final void h(LKUIDialog r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
    }

    @Override // hib.d
    public final void isEnterSendEnabled() {
    }

    @Override // hib.d
    public final b d() {
        return new b();
    }

    @Override // hib.d
    public final a g() {
        return new a();
    }

    @Override // hib.d
    public final c getPassportDependency() {
        return new c();
    }

    @Override // hib.d
    public final void e(IGetDataCallback r100) {
        r100.onSuccess(0);
    }
}
