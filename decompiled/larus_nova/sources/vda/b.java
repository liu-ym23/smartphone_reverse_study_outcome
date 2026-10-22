package vda;

import com.obric.assistant.data.ObricFloatChatPageState;

/* JADX INFO: loaded from: classes33.dex */
public final class b extends ObricFloatChatPageState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f554258a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f554259b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f554260c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f554261d;

    @Override // com.obric.assistant.data.ObricFloatChatPageState
    public final String toString() {
        return super.toString() + "-moveTaskToBack:" + this.f554259b + "-fromUser:" + this.f554260c + "-isUseOverlayAnim:" + this.f554261d;
    }

    @Override // com.obric.assistant.data.ObricFloatChatPageState
    public final int getHeight() {
        return this.f554258a;
    }

    @Override // com.obric.assistant.data.ObricFloatChatPageState
    public final void setHeight(int r100) {
        this.f554258a = r100;
    }

    public b(int r100, boolean r101, boolean r102, boolean r110) {
        super(false, r100, false, 5, null);
        this.f554258a = r100;
        this.f554259b = r101;
        this.f554260c = r102;
        this.f554261d = r110;
    }
}
