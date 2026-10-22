package com.ss.android.lark.export;

import android.graphics.drawable.Drawable;
import com.ss.android.lark.export.entity.preview.ColorIcon;
import com.ss.android.lark.export.entity.preview.ThemeColor;
import com.ss.android.lark.image.api.SimpleTarget;
import com.ss.android.lark.utils.UIHelper;
import kotlin.Result;
import kotlinx.coroutines.i;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: classes35.dex */
public final class f extends SimpleTarget<Drawable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ColorIcon f420677a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Drawable f420678b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ i<Drawable> f420679c;

    @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
    public final void onLoadFailed(Drawable r100) {
        super.onLoadFailed(r100);
        if (this.f420679c.isActive() == false) goto L6;
        i<Drawable> r101 = this.f420679c;
        Result.Companion r102 = Result.Companion;
        r101.resumeWith(Result.m9449constructorimpl(this.f420678b));
        return;
    }

    @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
    public final void onResourceReady(Object r100) {
        Drawable r101 = (Drawable) r100;
        ColorIcon r102 = this.f420677a;
        if (r102 == null) goto L12;
        ThemeColor r103 = r102.getThemeColor();
        if (r103 == null) goto L12;
        int r104 = com.ss.android.lark.export.entity.preview.a.a(r103, UIHelper.getContext(), null);
        if (r104 == 0) goto L12;
        if (r101 == null) goto L10;
        r101.mutate();
    L10:
        if (r101 == null) goto L12;
        r101.setTint(r104);
    L12:
        if (r101 != null) goto L15;
        r101 = this.f420678b;
    L15:
        if (this.f420679c.isActive() == false) goto L18;
        this.f420679c.resumeWith(Result.m9449constructorimpl(r101));
        return;
    }

    public f(ColorIcon r100, Drawable r101, j r102) {
        this.f420677a = r100;
        this.f420678b = r101;
        this.f420679c = r102;
    }
}
