package vda;

import com.obric.assistant.data.ObricFloatChatPageState;

/* JADX INFO: loaded from: classes33.dex */
public final class a extends ObricFloatChatPageState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f554256a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f554257b;

    public a() {
        this(0.0f, 3);
    }

    @Override // com.obric.assistant.data.ObricFloatChatPageState
    public final String toString() {
        return super.toString() + "-velocity:" + this.f554256a;
    }

    @Override // com.obric.assistant.data.ObricFloatChatPageState
    public final int getHeight() {
        return this.f554257b;
    }

    @Override // com.obric.assistant.data.ObricFloatChatPageState
    public final void setHeight(int r100) {
        this.f554257b = r100;
    }

    public a(float r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        r100 = 0.0f;
    L5:
        super(false, 0, false, 7, null);
        this.f554256a = r100;
        this.f554257b = 0;
    }
}
