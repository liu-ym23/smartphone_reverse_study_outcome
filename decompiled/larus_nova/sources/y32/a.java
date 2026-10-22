package y32;

import com.bytedance.android.livesdk.interactivity.api.message.InteractivityMessageType;
import com.bytedance.android.livesdkapi.message.ExternalBaseMessage;
import com.bytedance.android.livesdkapi.message.ExternalMessageType;

/* JADX INFO: loaded from: classes9.dex */
public abstract class a extends ExternalBaseMessage {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f565845a;

    public abstract InteractivityMessageType E();

    @Override // com.bytedance.android.livesdkapi.message.ExternalBaseMessage, com.bytedance.android.livesdkapi.message.BaseMessage, com.bytedance.android.livesdk.message.model.o7
    public final void setLocalInsertMsg(boolean r100) {
    }

    @Override // com.bytedance.android.livesdkapi.message.ExternalBaseMessage, com.bytedance.android.livesdkapi.message.BaseMessage, com.bytedance.android.live.base.model.message.t
    public final boolean supportDisplayText() {
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.message.IExternalLiveMessage
    public final ExternalMessageType getExternalMessageType() {
        return E().getExternalMessageType();
    }

    @Override // com.bytedance.android.livesdkapi.message.ExternalBaseMessage, com.bytedance.android.livesdkapi.message.BaseMessage, tlc.d, com.bytedance.android.livesdkapi.message.IExternalLiveMessage
    public final int getIntType() {
        return E().getMessageIntType();
    }

    public a() {
    }

    @Override // com.bytedance.android.livesdkapi.message.ExternalBaseMessage, com.bytedance.android.livesdkapi.message.BaseMessage, com.bytedance.android.live.base.model.message.t
    public final boolean isTooMuchMsg() {
        return this.f565845a;
    }

    @Override // com.bytedance.android.livesdkapi.message.ExternalBaseMessage, com.bytedance.android.livesdkapi.message.BaseMessage, com.bytedance.android.live.base.model.message.t
    public final void setTooMuchMsg(boolean r100) {
        this.f565845a = r100;
    }
}
