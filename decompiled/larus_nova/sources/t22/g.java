package t22;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.interactivity.api.comment.keyboard.HintType;
import com.bytedance.android.livesdkapi.depend.model.live.TopicCommentTip;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class g implements com.bytedance.android.livesdk.interactivity.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f544222a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.bytedance.android.livesdk.interactivity.e f544223b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Disposable f544224c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f544225d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public HintType f544226e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f544227f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TopicCommentTip f544228g;

    @Override // com.bytedance.android.livesdk.interactivity.c
    public final x22.a a() {
        if (this.f544225d == true) goto L7;
        return null;
    L7:
        return new x22.a(this.f544228g.getContent(), this.f544226e);
    }

    public g(TopicCommentTip r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        this.f544228g = r100;
        this.f544226e = HintType.NORMAL;
        this.f544227f = "TopicTipManager";
    }

    @Override // com.bytedance.android.livesdk.interactivity.c
    public final void b(com.bytedance.android.livesdk.interactivity.e r100) {
        this.f544223b = r100;
    }

    public final void c(boolean r100) {
        ALogger.i(this.f544227f, "底纹词可见性：" + r100);
        this.f544225d = r100;
        com.bytedance.android.livesdk.interactivity.e r101 = this.f544223b;
        if (r101 == null) goto L6;
        r101.update();
        return;
    }
}
