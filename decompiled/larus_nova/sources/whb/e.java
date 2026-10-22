package whb;

import android.content.Context;
import androidx.activity.contextaware.OnContextAvailableListener;
import com.ss.android.lark.flow.replyinthread.FlowReplyInThreadActivity;
import com.ss.android.lark.flow.replyinthread.Hilt_FlowReplyInThreadActivity;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.internal.UnsafeCasts;

/* JADX INFO: loaded from: classes36.dex */
public final class e implements OnContextAvailableListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Hilt_FlowReplyInThreadActivity f559724a;

    public e(Hilt_FlowReplyInThreadActivity r100) {
        this.f559724a = r100;
    }

    @Override // androidx.activity.contextaware.OnContextAvailableListener
    public final void onContextAvailable(Context r100) {
        Hilt_FlowReplyInThreadActivity r101 = this.f559724a;
        if (r101.f423936a == true) goto L6;
        r101.f423936a = true;
        ((a) ((DwarfComponentProvider) UnsafeCasts.unsafeCast(r101)).provideComponent()).f1((FlowReplyInThreadActivity) UnsafeCasts.unsafeCast(r101));
        return;
    }
}
