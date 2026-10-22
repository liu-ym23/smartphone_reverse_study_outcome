package com.bytedance.kmp.file.impl;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import okio.b0;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lokio/b0;", "it", "", AbsMethodDelegate.TAG_INVOKE, "(Lokio/b0;)Ljava/lang/String;", "<anonymous>"}, k = 3, mv = {1, 7, 0})
final class OkioKmpFile$listRecursively$1 extends Lambda implements Function1<b0, String> {
    public static final OkioKmpFile$listRecursively$1 INSTANCE = null;

    static {
        INSTANCE = new OkioKmpFile$listRecursively$1();
    }

    public OkioKmpFile$listRecursively$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2(b0 r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        return r100.toString();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ String invoke(b0 r100) {
        return invoke2(r100);
    }
}
