package com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.v2;

import android.content.Context;
import android.view.View;
import androidx.core.util.Pools;
import com.ss.android.lark.widget.light.layout.TextLayoutViewHelperKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class k implements com.ss.android.lark.widget.light.viewstub.f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.ss.android.lark.widget.light.viewstub.f.a f412518b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ TextLayoutCacheStoreImpl2 f412519c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Context f412520d;

    @Override // com.ss.android.lark.widget.light.viewstub.f
    public final View a(com.ss.android.lark.widget.light.viewstub.h r100) {
        Intrinsics.checkNotNullParameter(r100, "stubSpan");
        TextLayoutCacheStoreImpl2 r101 = this.f412519c;
        Context r102 = this.f412520d;
        Pools.SynchronizedPool<View> r103 = r101.f412482d.get(Integer.valueOf(r100.getClass().hashCode()));
        if (r103 == null) goto L7;
        View r104 = r103.acquire();
        if (r104 == null) goto L7;
        return r104;
    L7:
        return r100.b(r102);
    }

    public k(TextLayoutCacheStoreImpl2 r100, Context r101) {
        this.f412519c = r100;
        this.f412520d = r101;
        this.f412518b = com.ss.android.lark.widget.light.viewstub.f.f446339a;
    }

    @Override // com.ss.android.lark.widget.light.viewstub.f
    public final void b(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        this.f412518b.getClass();
        Intrinsics.checkNotNullParameter(r100, "view");
        TextLayoutViewHelperKt.a(r100, r101);
    }
}
