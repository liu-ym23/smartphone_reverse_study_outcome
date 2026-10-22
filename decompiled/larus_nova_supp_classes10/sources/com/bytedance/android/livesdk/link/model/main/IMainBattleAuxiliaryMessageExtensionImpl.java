package com.bytedance.android.livesdk.link.model.main;

import com.bytedance.android.livesdk.link.model.IBattleAuxiliaryMessageExtensionImpl;
import com.bytedance.android.livesdk.link.model.bridge.o;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0017\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\b\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/main/IMainBattleAuxiliaryMessageExtensionImpl;", "Lcom/bytedance/android/livesdk/link/model/IBattleAuxiliaryMessageExtensionImpl;", "Lvh7/e;", "Lcom/bytedance/android/livesdk/link/model/bridge/o;", "Lcom/bytedance/android/livesdk/link/model/main/b;", "Lcom/bytedance/android/livesdk/link/model/main/b$c;", "getUpdateContent", "()Lcom/bytedance/android/livesdk/link/model/main/b$c;", "updateContent", "base", "<init>", "(Lcom/bytedance/android/livesdk/link/model/bridge/o;)V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public class IMainBattleAuxiliaryMessageExtensionImpl extends IBattleAuxiliaryMessageExtensionImpl implements b {
    @Override // com.bytedance.android.livesdk.link.model.main.b
    public b.c getUpdateContent() {
        return (b.c) get(8, b.class, b.c.class);
    }

    public IMainBattleAuxiliaryMessageExtensionImpl(o r2) {
        Intrinsics.checkNotNullParameter(r2, "base");
        super(r2);
    }
}
