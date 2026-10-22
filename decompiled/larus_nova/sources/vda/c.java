package vda;

import com.obric.assistant.data.ObricFloatChatPageState;

/* JADX INFO: loaded from: classes33.dex */
public final class c extends ObricFloatChatPageState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f554262a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ObricFloatChatPageState f554263b;

    @Override // com.obric.assistant.data.ObricFloatChatPageState
    public final int getHeight() {
        return this.f554262a;
    }

    @Override // com.obric.assistant.data.ObricFloatChatPageState
    public final void setHeight(int r100) {
        this.f554262a = r100;
    }

    public c(int r100, ObricFloatChatPageState r101) {
        super(false, 0, false, 7, null);
        this.f554262a = r100;
        this.f554263b = r101;
    }
}
