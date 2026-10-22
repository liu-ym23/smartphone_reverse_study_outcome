package com.ss.android.lark.contact.customized.myqrcode.view;

import android.graphics.drawable.Drawable;
import com.ss.android.lark.image.api.DataSource;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a implements Drawable.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Drawable.Callback f419332a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ OfficeInviteExternalCardView f419333b;

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable r100) {
        Intrinsics.checkNotNullParameter(r100, "who");
        Drawable.Callback r101 = this.f419332a;
        if (r101 == null) goto L5;
        r101.invalidateDrawable(r100);
    L5:
        Function2<? super Boolean, ? super DataSource, Unit> r102 = this.f419333b.f419321b;
        if (r102 == null) goto L9;
        r102.invoke(Boolean.TRUE, null);
        return;
    }

    public a(Drawable.Callback r100, OfficeInviteExternalCardView r101) {
        this.f419332a = r100;
        this.f419333b = r101;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable r100, Runnable r101) {
        Intrinsics.checkNotNullParameter(r100, "who");
        Intrinsics.checkNotNullParameter(r101, "what");
        Drawable.Callback r102 = this.f419332a;
        if (r102 == null) goto L6;
        r102.unscheduleDrawable(r100, r101);
        return;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable r100, Runnable r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "who");
        Intrinsics.checkNotNullParameter(r101, "what");
        Drawable.Callback r103 = this.f419332a;
        if (r103 == null) goto L6;
        r103.scheduleDrawable(r100, r101, r102);
        return;
    }
}
