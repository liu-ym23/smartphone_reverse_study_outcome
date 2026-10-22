package com.larus.bmhome.chat.doclink;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.TextView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes25.dex */
public final /* synthetic */ class i implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TextView f302922a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f302923b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ MessageDocPreviewInlineRenderer.Style f302924c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f302925d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ MessageDocPreviewInlineRenderer.d f302926e;

    public /* synthetic */ i(TextView r100, Context r101, MessageDocPreviewInlineRenderer.Style r102, int r103, MessageDocPreviewInlineRenderer.d r104) {
        this.f302922a = r100;
        this.f302923b = r101;
        this.f302924c = r102;
        this.f302925d = r103;
        this.f302926e = r104;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        final TextView r101 = this.f302922a;
        final Context r102 = this.f302923b;
        final MessageDocPreviewInlineRenderer.Style r103 = this.f302924c;
        final int r104 = this.f302925d;
        final MessageDocPreviewInlineRenderer.d r105 = this.f302926e;
        final Drawable r106 = (Drawable) r100;
        if (r106 == null) goto L7;
        r101.post(new j(r106, r102, r103, r104, r105, r101));
        return Unit.INSTANCE;
    L7:
        return Unit.INSTANCE;
    }
}
