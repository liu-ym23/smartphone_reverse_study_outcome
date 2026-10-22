package lf5;

import android.view.ViewGroup;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.ee.bear.middleground.comment.export.s;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements s {
    public final ViewGroup a;

    /* JADX INFO: renamed from: lf5.a$a, reason: collision with other inner class name */
    public static final class C0258a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.s
    public final boolean isShowing() {
        return false;
    }

    public a(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "rootView");
        this.a = r2;
        new LottieAnimationView(r2.getContext());
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.s
    public final void a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "reactionKey");
        tt5.a.h("Comment#ReactionAnimation", "getAnimationFile start, reactionKey: " + r3);
        if (qsb.b.a().Yd(r3) != null) goto L5;
        tt5.a.k("Comment#ReactionAnimation", "getAnimationFile, getReactionEntity null");
        return;
    L5:
        tt5.a.k("Comment#ReactionAnimation", "getAnimationFile, animationKey is empty");
    }
}
