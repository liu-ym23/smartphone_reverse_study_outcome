package com.bytedance.sdk.xbridge.cn.utils;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3}, xi = 48)
final class UGLogger$e$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ UGLogger.a $ctx;
    final /* synthetic */ String $module;
    final /* synthetic */ String $msg;
    final /* synthetic */ Map<String, Object> $params;
    final /* synthetic */ String $tag;

    public UGLogger$e$1(String r100, String r101, String r102, Map<String, ? extends Object> r103, UGLogger.a r104) {
        this.$tag = r100;
        this.$module = r101;
        this.$msg = r102;
        this.$params = r103;
        this.$ctx = r104;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        UGLogger.c r100 = UGLogger.f270252a;
        String r101 = UGLogger.b(this.$tag, this.$module);
        String r102 = UGLogger.a(this.$msg, this.$params, this.$ctx);
        UGLogger.f270252a.b(r101, r102);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
