package po8;

import com.larus.bmhome.chat.view.DislikeFeedbackDialogFragment;
import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class l implements IIMCallback<Message> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DislikeFeedbackDialogFragment f530115a;

    @Override // com.larus.im.callback.IIMCallback
    public final boolean mustInMain() {
        return true;
    }

    public l(DislikeFeedbackDialogFragment r100) {
        this.f530115a = r100;
    }

    @Override // com.larus.im.callback.IIMCallback
    public final void onFailure(IIMError r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        Intrinsics.checkNotNullParameter(r100, "error");
    }

    @Override // com.larus.im.callback.IIMCallback
    public final void onSuccess(Message r100) {
        Message r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "result");
        DislikeFeedbackDialogFragment r102 = this.f530115a;
        Map<String, String> r103 = r101.getExt();
        if (r103 == null) goto L5;
        String r104 = r103.get("inner_log_id");
    L6:
        int r105 = DislikeFeedbackDialogFragment.f310328g;
        r102.T90(r104);
        return;
    L5:
        r104 = null;
        goto L6
    }
}
