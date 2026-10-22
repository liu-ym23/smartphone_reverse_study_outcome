package d32;

import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.interactivity.api.commentcontrol.utils.CommentControlSwitchHelper;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f466702a = null;

    static {
        f466702a = new a();
    }

    public a() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Response r101 = (Response) r100;
        if (r101 == null) goto L17;
        com.bytedance.android.livesdk.interactivity.api.commentcontrol.model.a r102 = (com.bytedance.android.livesdk.interactivity.api.commentcontrol.model.a) r101.data;
        if (r102 != null) goto L7;
        return;
    L7:
        if (CommentControlSwitchHelper.b() != 0) goto L12;
        CommentControlSwitchHelper.BaseDisplayText r103 = CommentControlSwitchHelper.f133091c;
        if (r103 == null) goto L19;
        r103.updateBaseDisplayText(r102);
        return;
    L19:
        return;
    L12:
        if (CommentControlSwitchHelper.b() != 1) goto L21;
        CommentControlSwitchHelper.AdvancedDisplayText r104 = CommentControlSwitchHelper.f133092d;
        if (r104 == null) goto L22;
        r104.updateAdvancedDisplayText(r102);
        return;
    L22:
        return;
    L21:
        return;
    }
}
