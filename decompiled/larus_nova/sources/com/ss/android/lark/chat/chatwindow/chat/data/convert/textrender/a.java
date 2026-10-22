package com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender;

import android.content.Context;
import android.view.View;
import androidx.core.util.Pools;
import com.ss.android.lark.widget.light.layout.TextLayoutViewHelperKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a implements com.ss.android.lark.widget.light.viewstub.f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.ss.android.lark.widget.light.viewstub.f.a f412457b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AbsTextLayoutCacheStore f412458c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Context f412459d;

    @Override // com.ss.android.lark.widget.light.viewstub.f
    public final View a(com.ss.android.lark.widget.light.viewstub.h r100) {
        Intrinsics.checkNotNullParameter(r100, "stubSpan");
        AbsTextLayoutCacheStore r101 = this.f412458c;
        Context r102 = this.f412459d;
        Pools.SynchronizedPool<View> r103 = r101.f412439c.get(Integer.valueOf(r100.getClass().hashCode()));
        if (r103 == null) goto L7;
        View r104 = r103.acquire();
        if (r104 == null) goto L7;
        return r104;
    L7:
        return r100.b(r102);
    }

    public a(AbsTextLayoutCacheStore r100, Context r101) {
        this.f412458c = r100;
        this.f412459d = r101;
        this.f412457b = com.ss.android.lark.widget.light.viewstub.f.f446339a;
    }

    @Override // com.ss.android.lark.widget.light.viewstub.f
    public final void b(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        this.f412457b.getClass();
        Intrinsics.checkNotNullParameter(r100, "view");
        TextLayoutViewHelperKt.a(r100, r101);
    }
}
