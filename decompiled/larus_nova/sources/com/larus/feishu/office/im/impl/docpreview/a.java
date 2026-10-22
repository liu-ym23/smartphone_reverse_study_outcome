package com.larus.feishu.office.im.impl.docpreview;

import android.graphics.drawable.Drawable;
import com.larus.bmhome.chat.doclink.i;
import com.ss.android.lark.export.e;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class a implements e.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<Drawable, Unit> f343209a;

    public a(i r100) {
        this.f343209a = r100;
    }

    @Override // com.ss.android.lark.export.e.a
    public final void a(Drawable r100) {
        Intrinsics.checkNotNullParameter(r100, "drawable");
        this.f343209a.invoke(r100);
    }
}
