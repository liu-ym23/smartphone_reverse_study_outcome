package com.bytedance.ee.bear.more.protocol3.checker;

import com.bytedance.ee.bear.more.protocol3.j;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes18.dex */
public final class BizChecker extends j {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lambda f234783e;

    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.functions.Function0, kotlin.jvm.internal.Lambda] */
    @Override // com.bytedance.ee.bear.more.protocol3.j
    public final boolean e() {
        return ((Boolean) this.f234783e.invoke()).booleanValue();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.bytedance.ee.bear.more.protocol3.checker.BizChecker$1, kotlin.jvm.internal.Lambda] */
    public BizChecker(final boolean r100) {
        this.f234783e = new AnonymousClass1(r100);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.bytedance.ee.bear.more.protocol3.checker.BizChecker$2, kotlin.jvm.internal.Lambda] */
    public BizChecker(String r100, final boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "disableReason");
        this.f234898b = r100;
        this.f234783e = new AnonymousClass2(r101);
    }
}
