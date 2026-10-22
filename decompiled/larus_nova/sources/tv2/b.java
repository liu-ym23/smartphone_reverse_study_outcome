package tv2;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.interactivity.api.expression.j;
import com.bytedance.android.livesdk.widget.board.ExpressionContext;
import com.bytedance.android.livesdk.widget.board.k;
import com.bytedance.android.livesdk.widget.ui.NewEmojiSelectPanelV3;
import com.bytedance.common.utility.UIUtils;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class b implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f547667a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f547668b;

    @Override // com.bytedance.android.livesdk.widget.board.k
    public final void a() {
    }

    @Override // com.bytedance.android.livesdk.widget.board.k
    public final void unbind() {
    }

    @Override // com.bytedance.android.livesdk.widget.board.k
    public final View getRootView() {
        return this.f547667a;
    }

    @Override // com.bytedance.android.livesdk.widget.board.k
    public final void b(ExpressionContext r100) {
        Intrinsics.checkNotNullParameter(r100, "expressionContext");
        View r101 = this.f547667a;
        if ((r101 instanceof NewEmojiSelectPanelV3) == true) goto L5;
        r101 = null;
    L5:
        NewEmojiSelectPanelV3 r102 = (NewEmojiSelectPanelV3) r101;
        if (r102 == null) goto L15;
        j r103 = r100.getOnCommentSendDelegate().getValue();
        if (r103 == null) goto L10;
        r102.setOnEmojiSelectListener(r103);
    L10:
        r102.S5(this.f547668b);
        boolean r104 = r100.getSectionShow().getValue().booleanValue();
        RecyclerView r105 = (RecyclerView) r102.findViewById(R.id.list);
        if (r104 == false) goto L13;
        r105.setPadding(0, 0, 0, (int) UIUtils.dip2Px(r102.getContext(), 120.0f));
        return;
    L13:
        r105.setPadding(0, 0, 0, (int) UIUtils.dip2Px(r102.getContext(), 52.0f));
        return;
    }

    public b(View r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "rootView");
        this.f547667a = r100;
        this.f547668b = r101;
        r100.getContext();
    }
}
