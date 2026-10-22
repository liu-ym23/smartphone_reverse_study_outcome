package com.bytedance.jedi.ext.adapter.extension;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 16})
final class AdapterBuilderKt$MATCH_ALL$1 extends Lambda implements Function2<Integer, Object, Boolean> {
    public static final AdapterBuilderKt$MATCH_ALL$1 INSTANCE = null;

    static {
        INSTANCE = new AdapterBuilderKt$MATCH_ALL$1();
    }

    public AdapterBuilderKt$MATCH_ALL$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Boolean invoke(Integer r100, Object r101) {
        return Boolean.valueOf(invoke(r100.intValue(), r101));
    }

    public final boolean invoke(int r100, Object r101) {
        return true;
    }
}
