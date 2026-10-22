package vda;

import com.obric.assistant.data.ObricFloatChatPageState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class d extends ObricFloatChatPageState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f554264a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Float f554265b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f554266c;

    public d() {
        this(true, null, "");
    }

    @Override // com.obric.assistant.data.ObricFloatChatPageState
    public final String toString() {
        return super.toString() + "-velocity:" + this.f554265b + "-reason: " + this.f554266c;
    }

    @Override // com.obric.assistant.data.ObricFloatChatPageState
    public final boolean getUseAnim() {
        return this.f554264a;
    }

    public d(boolean r100, Float r101, String r110) {
        Intrinsics.checkNotNullParameter(r110, "reason");
        super(false, 0, false, 7, null);
        this.f554264a = r100;
        this.f554265b = r101;
        this.f554266c = r110;
    }
}
