package com.bytedance.kmp.gamecp.base.settings;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.google.gson.JsonArray;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, d2 = {"<anonymous>", "", "R", "it", "", AbsMethodDelegate.TAG_INVOKE, "kotlin/sequences/SequencesKt___SequencesKt$filterIsInstance$1"}, k = 3, mv = {1, 5, 1})
public final class SettingFilterUtil$filterSettingKey$$inlined$filterIsInstance$1 extends Lambda implements Function1<Object, Boolean> {
    public static final SettingFilterUtil$filterSettingKey$$inlined$filterIsInstance$1 INSTANCE = null;

    static {
        INSTANCE = new SettingFilterUtil$filterSettingKey$$inlined$filterIsInstance$1();
    }

    public SettingFilterUtil$filterSettingKey$$inlined$filterIsInstance$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Object r100) {
        return Boolean.valueOf(invoke2(r100));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(Object r100) {
        return r100 instanceof JsonArray;
    }
}
