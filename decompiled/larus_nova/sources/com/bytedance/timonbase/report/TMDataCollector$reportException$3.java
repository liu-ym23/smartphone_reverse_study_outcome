package com.bytedance.timonbase.report;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import vg7.a;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "extraParams", "", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 16})
final class TMDataCollector$reportException$3 extends Lambda implements Function1<Map<String, ? extends String>, Unit> {
    final /* synthetic */ Map $customData;
    final /* synthetic */ String $ensureType;
    final /* synthetic */ Map $filterData;
    final /* synthetic */ boolean $isCore;
    final /* synthetic */ Function0 $javaStackBuilder;
    final /* synthetic */ String $logType;
    final /* synthetic */ String $message;
    final /* synthetic */ String $threadName;

    public TMDataCollector$reportException$3(Map r100, Function0 r101, String r102, String r103, String r104, String r105, boolean r106, Map r107) {
        this.$customData = r100;
        this.$javaStackBuilder = r101;
        this.$message = r102;
        this.$logType = r103;
        this.$ensureType = r104;
        this.$threadName = r105;
        this.$isCore = r106;
        this.$filterData = r107;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Map<String, String> r110) {
        Map<String, String> r100 = MapsKt.toMutableMap(this.$customData);
        r100.putAll(r110);
        a.a().monitorThrowable((String) this.$javaStackBuilder.invoke(), this.$message, this.$logType, this.$ensureType, this.$threadName, this.$isCore, r100, this.$filterData);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Map<String, ? extends String> r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
