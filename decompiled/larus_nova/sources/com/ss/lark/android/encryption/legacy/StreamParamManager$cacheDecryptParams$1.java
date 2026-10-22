package com.ss.lark.android.encryption.legacy;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/ss/lark/android/encryption/model/StreamParam;", "it", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class StreamParamManager$cacheDecryptParams$1 extends Lambda implements Function1<String, kkc.a> {
    final /* synthetic */ String $path;

    public StreamParamManager$cacheDecryptParams$1(String r100) {
        this.$path = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final kkc.a invoke2(String r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        ConcurrentHashMap<String, kkc.a> r101 = a.f456803a;
        return a.a(this.$path, false, false);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ kkc.a invoke(String r100) {
        return invoke2(r100);
    }
}
