package com.ss.lark.android.encryption.legacy;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "path", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class CipherStreamProviderKt$provideCipherOutputStream$1 extends Lambda implements Function1<String, Unit> {
    public static final CipherStreamProviderKt$provideCipherOutputStream$1 INSTANCE = null;

    static {
        INSTANCE = new CipherStreamProviderKt$provideCipherOutputStream$1();
    }

    public CipherStreamProviderKt$provideCipherOutputStream$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        ConcurrentHashMap<String, kkc.a> r101 = a.f456803a;
        Intrinsics.checkNotNullParameter(r100, "path");
        a.f456803a.remove(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
