package zp2;

import com.bytedance.android.livesdkapi.feedback.event.FeedbackSendGiftEvent;
import com.bytedance.android.scope.o;
import xs2.b;

/* JADX INFO: loaded from: classes11.dex */
public final class a implements ar2.a, o {
    public a() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // ar2.a
    public final void z5() {
        b.a().post(new FeedbackSendGiftEvent());
    }
}
