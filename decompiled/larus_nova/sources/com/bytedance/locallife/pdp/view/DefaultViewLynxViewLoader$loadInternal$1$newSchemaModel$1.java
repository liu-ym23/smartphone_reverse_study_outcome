package com.bytedance.locallife.pdp.view;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "schema", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3}, xi = 48)
final class DefaultViewLynxViewLoader$loadInternal$1$newSchemaModel$1 extends Lambda implements Function1<String, String> {
    public static final DefaultViewLynxViewLoader$loadInternal$1$newSchemaModel$1 INSTANCE = null;

    static {
        INSTANCE = new DefaultViewLynxViewLoader$loadInternal$1$newSchemaModel$1();
    }

    public DefaultViewLynxViewLoader$loadInternal$1$newSchemaModel$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2(String r100) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        List<String> r101 = com.bytedance.locallife.common.utils.i.f257150a;
        String r102 = com.bytedance.locallife.common.utils.i.a(r100, MapsKt.mapOf(TuplesKt.to("preload", "0")));
        if (r102 != null) goto L6;
        return r100;
    L6:
        return r102;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ String invoke(String r100) {
        return invoke2(r100);
    }
}
