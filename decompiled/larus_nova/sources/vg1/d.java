package vg1;

import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.ies.web.jsbridge2.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class d implements IHybridComponent.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f554674a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g f554675b;

    public d(com.bytedance.android.livesdk.chatroom.end.vs.b r100) {
        this.f554674a = "vsOpenLiveRoom";
        this.f554675b = r100;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent.a
    public final void onJSBridgeCreated(y6.c r100) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        r100.registerMethod(this.f554674a, this.f554675b);
    }
}
