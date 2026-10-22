package com.bytedance.locallife.cube.view;

import com.bytedance.locallife.cube.api.config.LynxLoadConfig;
import com.bytedance.locallife.cube.api.model.CubeInternalSchemaModel;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "resultSchemaModel", "Lcom/bytedance/locallife/cube/api/model/CubeInternalSchemaModel;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3}, xi = 48)
final class CubeContainerView$loadWithGlobalProps$1 extends Lambda implements Function1<CubeInternalSchemaModel, Unit> {
    final /* synthetic */ Function1<LynxLoadConfig, Unit> $loadConfig;
    final /* synthetic */ CubeInternalSchemaModel $schemaModel;
    final /* synthetic */ Function1<Map<String, Object>, Unit> $updateGlobalPropsInject;
    final /* synthetic */ CubeContainerView this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public CubeContainerView$loadWithGlobalProps$1(Function1<? super Map<String, Object>, Unit> r100, CubeContainerView r101, Function1<? super LynxLoadConfig, Unit> r102, CubeInternalSchemaModel r103) {
        this.$updateGlobalPropsInject = r100;
        this.this$0 = r101;
        this.$loadConfig = r102;
        this.$schemaModel = r103;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(final CubeInternalSchemaModel r110) {
        Intrinsics.checkNotNullParameter(r110, "resultSchemaModel");
        final LinkedHashMap r100 = new LinkedHashMap();
        Function1<Map<String, Object>, Unit> r101 = this.$updateGlobalPropsInject;
        if (r101 == null) goto L5;
        r101.invoke(r100);
    L5:
        final CubeContainerView r102 = this.this$0;
        Function1<LynxLoadConfig, Unit> r103 = this.$loadConfig;
        Function1<Map<String, Object>, Unit> r104 = new AnonymousClass1(r102, r110, r100);
        final CubeContainerView r105 = this.this$0;
        final CubeInternalSchemaModel r106 = this.$schemaModel;
        final Function1<LynxLoadConfig, Unit> r107 = this.$loadConfig;
        CubeContainerView.a(r102, r110, r103, r104, new AnonymousClass2(r105, r100, r106, r110, r107));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(CubeInternalSchemaModel r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
