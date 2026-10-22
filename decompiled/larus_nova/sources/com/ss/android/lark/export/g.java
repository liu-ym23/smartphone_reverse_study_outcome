package com.ss.android.lark.export;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larus.nova.R;
import com.ss.android.lark.image.api.SimpleTarget;
import kotlin.Result;
import kotlinx.coroutines.i;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: classes35.dex */
public final class g extends SimpleTarget<Drawable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f420682a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Drawable f420683b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ i<Drawable> f420684c;

    @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
    public final void onResourceReady(Object r100) {
        Drawable r101 = (Drawable) r100;
        super.onResourceReady(r101);
        if (r101 == null) goto L5;
        r101.mutate();
        r101.setTint(UDColorUtils.getColor(this.f420682a, R.color.primary_pri_500));
    L5:
        if (r101 != null) goto L8;
        r101 = this.f420683b;
    L8:
        if (this.f420684c.isActive() == false) goto L11;
        this.f420684c.resumeWith(Result.m9449constructorimpl(r101));
        return;
    }

    public g(Context r100, Drawable r101, j r102) {
        this.f420682a = r100;
        this.f420683b = r101;
        this.f420684c = r102;
    }
}
