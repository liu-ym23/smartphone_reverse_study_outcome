package zn1;

import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.livesdk.chatroom.tetris.service.HybridBottomPanelManagerWidget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class f implements IHybridComponent.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HybridBottomPanelManagerWidget f572912a;

    public f(HybridBottomPanelManagerWidget r100) {
        this.f572912a = r100;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent.a
    public final void onJSBridgeCreated(y6.c r100) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        r100.registerMethod("getSeiInfo", this.f572912a.f111845e);
    }
}
