package vda;

import com.obric.assistant.data.ObricFloatChatPageState;

/* JADX INFO: loaded from: classes33.dex */
public final class e extends ObricFloatChatPageState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f554267a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f554268b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Float f554269c;

    @Override // com.obric.assistant.data.ObricFloatChatPageState
    public final String toString() {
        return super.toString() + "-velocity:" + this.f554269c;
    }

    @Override // com.obric.assistant.data.ObricFloatChatPageState
    public final int getHeight() {
        return this.f554268b;
    }

    @Override // com.obric.assistant.data.ObricFloatChatPageState
    public final boolean getUseAnim() {
        return this.f554267a;
    }

    @Override // com.obric.assistant.data.ObricFloatChatPageState
    public final void setHeight(int r100) {
        this.f554268b = r100;
    }

    public e(boolean r100, int r101, Float r102) {
        super(false, 0, false, 7, null);
        this.f554267a = r100;
        this.f554268b = r101;
        this.f554269c = r102;
    }
}
