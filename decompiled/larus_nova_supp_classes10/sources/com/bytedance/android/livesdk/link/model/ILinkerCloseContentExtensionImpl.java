package com.bytedance.android.livesdk.link.model;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\b\u0017\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00020\u00042\u00020\u00032\u00020\u0002B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013J.\u0010\b\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\b\u0010\tJ0\u0010\n\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\n\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\r¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/ILinkerCloseContentExtensionImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/ModelExtensionBase;", "Lcom/bytedance/android/livesdk/message/linker/e;", "Lcom/bytedance/android/livesdk/link/model/ILinkerCloseContent;", "Lvh7/e;", "R", "Ljava/lang/Class;", LocationMonitorConst.TYPE, "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "", "getSource", "()I", "source", "getReason", "reason", "base", "<init>", "(Lcom/bytedance/android/livesdk/message/linker/e;)V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public class ILinkerCloseContentExtensionImpl extends ModelExtensionBase<com.bytedance.android.livesdk.message.linker.e, ILinkerCloseContent> implements ILinkerCloseContent, com.bytedance.android.livesdk.message.linker.e {
    private final /* synthetic */ com.bytedance.android.livesdk.message.linker.e $$delegate_0;

    @Override // com.bytedance.android.livesdk.link.model.ILinkerCloseContent
    public <R extends vh7.e<com.bytedance.android.livesdk.message.linker.e>> R castTo(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TYPE);
        return (R) this.$$delegate_0.castTo(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.ILinkerCloseContent
    public <R extends vh7.e<com.bytedance.android.livesdk.message.linker.e>> R castToOrNull(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TYPE);
        return (R) this.$$delegate_0.castToOrNull(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.ILinkerCloseContent
    public int getReason() {
        return ((Number) get(3, ILinkerCloseContent.class, 0)).intValue();
    }

    @Override // com.bytedance.android.livesdk.link.model.ILinkerCloseContent
    public int getSource() {
        return ((Number) get(1, ILinkerCloseContent.class, 0)).intValue();
    }

    public ILinkerCloseContentExtensionImpl(com.bytedance.android.livesdk.message.linker.e r2) {
        Intrinsics.checkNotNullParameter(r2, "base");
        super(r2);
        this.$$delegate_0 = r2;
    }
}
