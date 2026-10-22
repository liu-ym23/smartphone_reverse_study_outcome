package com.bytedance.timonbase.report;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import vg7.a;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "extraParams", "", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 16})
final class TMDataCollector$reportNativeException$1 extends Lambda implements Function1<Map<String, ? extends String>, Unit> {
    final /* synthetic */ Map $data;
    final /* synthetic */ String $javaStack;
    final /* synthetic */ String $message;
    final /* synthetic */ String $nativeStack;
    final /* synthetic */ String $threadName;

    public TMDataCollector$reportNativeException$1(Map r100, String r101, String r102, String r103, String r104) {
        this.$data = r100;
        this.$nativeStack = r101;
        this.$javaStack = r102;
        this.$threadName = r103;
        this.$message = r104;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Map<String, String> r100) {
        Map<String, String> r101 = MapsKt.toMutableMap(this.$data);
        r101.putAll(r100);
        a.a().monitorNativeException(this.$nativeStack, this.$javaStack, this.$threadName, this.$message, r101);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Map<String, ? extends String> r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
