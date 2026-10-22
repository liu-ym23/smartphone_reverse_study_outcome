package vda;

import com.obric.assistant.data.ObricFloatChatPageState;

/* JADX INFO: loaded from: classes33.dex */
public final class f extends ObricFloatChatPageState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f554270a;

    public f() {
        this(true);
    }

    @Override // com.obric.assistant.data.ObricFloatChatPageState
    public final boolean getUseAnim() {
        return this.f554270a;
    }

    public f(boolean r100) {
        super(false, 0, false, 7, null);
        this.f554270a = r100;
    }
}
