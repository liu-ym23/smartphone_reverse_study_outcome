package com.ss.android.lark.widget.light.processor;

import android.content.Context;
import android.text.style.ClickableSpan;
import android.view.View;
import com.ss.android.lark.widget.cleanresource.ResourceType;
import com.ss.android.lark.widget.span.MediaInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class r extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f446187a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MediaInfo f446188b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.ss.android.lark.widget.light.e f446189c;

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        acc.a.f(this.f446187a, new acc.d(ResourceType.VIDEO, this.f446188b.resourceCleanScene, acc.a.d(this.f446189c.F)));
    }

    public r(Context r100, MediaInfo r101, com.ss.android.lark.widget.light.e r102) {
        this.f446187a = r100;
        this.f446188b = r101;
        this.f446189c = r102;
    }
}
