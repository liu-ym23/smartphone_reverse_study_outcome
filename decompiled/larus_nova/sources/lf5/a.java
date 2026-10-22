package lf5;

import android.view.ViewGroup;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.ee.bear.middleground.comment.export.s;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class a implements s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f509056a;

    /* JADX INFO: renamed from: lf5.a$a, reason: collision with other inner class name */
    public static final class C6688a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.s
    public final boolean isShowing() {
        return false;
    }

    public a(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "rootView");
        this.f509056a = r100;
        new LottieAnimationView(r100.getContext());
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.s
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reactionKey");
        tt5.a.h("Comment#ReactionAnimation", "getAnimationFile start, reactionKey: " + r100);
        if (qsb.b.a().Yd(r100) != null) goto L5;
        tt5.a.k("Comment#ReactionAnimation", "getAnimationFile, getReactionEntity null");
        return;
    L5:
        tt5.a.k("Comment#ReactionAnimation", "getAnimationFile, animationKey is empty");
    }
}
