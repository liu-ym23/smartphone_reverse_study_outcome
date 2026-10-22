package com.obric.assistant.cocreationreview.modules.searchqa;

import com.obric.assistant.cocreationreview.s3;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes32.dex */
public final /* synthetic */ class n implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q f387564a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f387565b;

    public /* synthetic */ n(q r100, l r101) {
        this.f387564a = r100;
        this.f387565b = r101;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        q r100 = this.f387564a;
        Function1 r101 = this.f387565b;
        LinkedHashSet<Function1<List<c0>, Unit>> r102 = r100.f387570c;
        monitor-enter(r102);
        r100.f387570c.remove(r101);     // Catch: Throwable -> L11
        int r103 = r100.f387570c.size();     // Catch: Throwable -> L11
        monitor-exit(r102);
        int r104 = s3.f387719a;
        s3.b("search_qa.repository.observe", "remove listeners=" + r103);
        if (r103 != 0) goto L10;
        r100.d();
    L10:
        return Unit.INSTANCE;
    L11:
        th = move-exception;
        throw th;
    }
}
