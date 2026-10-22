package uv2;

import android.view.View;
import com.bytedance.android.livesdk.interactivity.api.expression.j;
import com.bytedance.android.livesdk.widget.board.ExpressionContext;
import com.bytedance.android.livesdk.widget.board.k;
import com.bytedance.android.livesdk.widget.ui.subscribe.SubscribeSelectPanel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class a implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f551797a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f551798b;

    @Override // com.bytedance.android.livesdk.widget.board.k
    public final void a() {
    }

    @Override // com.bytedance.android.livesdk.widget.board.k
    public final void unbind() {
        View r100 = this.f551797a;
        if (r100 == null) goto L7;
        SubscribeSelectPanel r101 = (SubscribeSelectPanel) r100;
        r101.f162199g.dispose();
        r101.f162198f = null;
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.widget.ui.subscribe.SubscribeSelectPanel");
    }

    @Override // com.bytedance.android.livesdk.widget.board.k
    public final View getRootView() {
        return this.f551797a;
    }

    @Override // com.bytedance.android.livesdk.widget.board.k
    public final void b(ExpressionContext r100) {
        Intrinsics.checkNotNullParameter(r100, "expressionContext");
        View r101 = this.f551797a;
        if (r101 == null) goto L10;
        SubscribeSelectPanel r102 = (SubscribeSelectPanel) r101;
        j r103 = r100.getOnCommentSendDelegate().getValue();
        if (r103 == null) goto L7;
        r102.setOnSubscribeEmojiSendListener(r103);
    L7:
        r102.d(this.f551798b);
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.widget.ui.subscribe.SubscribeSelectPanel");
    }

    public a(View r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "rootView");
        this.f551797a = r100;
        this.f551798b = r101;
    }
}
