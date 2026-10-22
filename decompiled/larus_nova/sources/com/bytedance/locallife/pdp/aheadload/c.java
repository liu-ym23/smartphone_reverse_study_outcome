package com.bytedance.locallife.pdp.aheadload;

import android.content.Context;
import android.widget.Toast;
import com.bytedance.locallife.dito.data.DitoNode;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;

/* JADX INFO: loaded from: classes21.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Map<String, DitoNode> f260909a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f260910b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Map<String, DitoNode> f260911c;

    public c(Map<String, DitoNode> r100, Context r101, Map<String, DitoNode> r102) {
        this.f260909a = r100;
        this.f260910b = r101;
        this.f260911c = r102;
    }

    public final void a() {
        if ((!this.f260909a.isEmpty()) == false) goto L5;
        String r100 = "底Bar提前加载";
    L6:
        Toast.makeText(this.f260910b, "提前加载页面前" + this.f260911c.size() + "个模块," + r100, 0).show();
        return;
    L5:
        r100 = "底Bar没有提前加载";
        goto L6
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
