package j4c;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.EllipsizedEmojiconTextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class g implements p, b08.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b08.a f497413a;

    @Override // b08.c
    public final <M, V extends View> void registerModelBinder(Class<M> r100, Class<V> r101, b08.b<? super V, ? super M> r102) {
        this.f497413a.registerModelBinder(r100, r101, r102);
    }

    public g() {
        b08.a r100 = new b08.a();
        Intrinsics.checkNotNullParameter(r100, "compositeComponentDelegate");
        this.f497413a = r100;
    }

    @Override // j4c.p
    public final void a(Context r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "parent");
        r101.removeAllViews();
        EllipsizedEmojiconTextView r102 = new EllipsizedEmojiconTextView(r100);
        r102.setId(R.id.avatar_item_summary);
        r102.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        ViewGroup.LayoutParams r103 = r102.getLayoutParams();
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        int r104 = a0.a(4.0f, r100);
        ((LinearLayout.LayoutParams) r103).topMargin = r104;
        r102.setIncludeFontPadding(false);
        r102.setGravity(16);
        r102.setEllipsize(TextUtils.TruncateAt.END);
        r102.setMaxLines(1);
        r102.setSingleLine(true);
        r102.setTextSize(2, 14.0f);
        r102.setTextColor(r100.getResources().getColor(R.color.text_placeholder));
        r102.setVisibility(8);
        r101.addView(r102);
        registerModelBinder(w3c.f.class, EllipsizedEmojiconTextView.class, f4c.f.f475602a);
    }
}
