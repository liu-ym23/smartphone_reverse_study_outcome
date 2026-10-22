package com.bytedance.tools.kcp.modelx.runtime.internal;

import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vh7.c;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\u0012\b\u0000\u0010\u0003*\u00020\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u00042\u00020\u0005B#\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/bytedance/tools/kcp/modelx/runtime/internal/FlexModelDelegate;", "", "Lvh7/c;", "PARENT", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Ljava/io/Serializable;", "actualModel", "Lvh7/c;", "Ljava/lang/Class;", "interfaceType", "<init>", "(Ljava/lang/Class;Lvh7/c;)V", "lib-modelx"}, k = 1, mv = {1, 4, 3})
public final class FlexModelDelegate<PARENT extends vh7.c<PARENT>> extends FlexModelBase<PARENT> {
    public final transient vh7.c<PARENT> actualModel;

    public FlexModelDelegate(Class<PARENT> r100, vh7.c<PARENT> r101) {
        Intrinsics.checkNotNullParameter(r100, "interfaceType");
        Intrinsics.checkNotNullParameter(r101, "actualModel");
        super(r100);
        this.actualModel = r101;
    }
}
