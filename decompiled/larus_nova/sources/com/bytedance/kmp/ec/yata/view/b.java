package com.bytedance.kmp.ec.yata.view;

import ba6.h;
import com.bytedance.kmp.ec.yata.common.biz.YataStoreWrapper$submitStoreData$1;
import com.bytedance.kmp.ec.yata.view.render.delegate.RenderDelegateManager;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class b implements ba6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ba6.a f251816a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f251817b;

    @Override // ba6.a
    public final void a(h r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        this.f251816a.a(r100);
    }

    @Override // ba6.a
    public final void b(h r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        Iterator r101 = ((LinkedHashMap) ((RenderDelegateManager) this.f251817b.f251827j.getValue()).f252012c).entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((com.bytedance.kmp.ec.yata.view.render.delegate.a) ((Map.Entry) r101.next()).getValue()).c();
        goto L4
    L6:
        this.f251817b.f251824g = true;
        this.f251816a.b(r100);
    }

    @Override // ba6.a
    public final void c(h r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        this.f251816a.c(r100);
    }

    public b(YataStoreWrapper$submitStoreData$1 r100, c r101) {
        this.f251816a = r100;
        this.f251817b = r101;
    }
}
