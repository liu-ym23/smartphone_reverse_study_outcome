package com.ss.android.lark.widget.light.processor;

import android.content.Context;
import android.text.style.ClickableSpan;
import android.view.View;
import com.ss.android.lark.widget.cleanresource.ResourceType;
import com.ss.android.lark.widget.span.ImageInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class n extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f446184a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ImageInfo f446185b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.ss.android.lark.widget.light.e f446186c;

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        acc.a.f(this.f446184a, new acc.d(ResourceType.IMAGE, this.f446185b.resourceCleanScene, acc.a.d(this.f446186c.F)));
    }

    public n(Context r100, ImageInfo r101, com.ss.android.lark.widget.light.e r102) {
        this.f446184a = r100;
        this.f446185b = r101;
        this.f446186c = r102;
    }
}
