package pw;

import com.bytedance.android.live.base.model.message.m0;
import com.bytedance.android.livesdkapi.message.CommonMessageData;
import com.bytedance.android.livesdkapi.message.ExternalBaseMessage;
import yh6.c;

/* JADX INFO: loaded from: classes44.dex */
public abstract class a extends ExternalBaseMessage implements c {
    public a() {
    }

    @Override // yh6.c
    public final m0 getCommonData() {
        return this.baseMessage;
    }

    public final void setCommonData(m0 r100) {
        if (r100 == null) goto L6;
        this.baseMessage = (CommonMessageData) r100;
        return;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdkapi.message.CommonMessageData");
    }
}
