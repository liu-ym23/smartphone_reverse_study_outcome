package com.bytedance.upc.common.settings;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.upc.common.storage.SpStorage;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/bytedance/upc/common/storage/SpStorage;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 16})
final class UpcLocalSettings$mSp$2 extends Lambda implements Function0<SpStorage> {
    public static final UpcLocalSettings$mSp$2 INSTANCE = null;

    static {
        INSTANCE = new UpcLocalSettings$mSp$2();
    }

    public UpcLocalSettings$mSp$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ SpStorage invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final SpStorage invoke() {
        return SpStorage.f272473e;
    }
}
