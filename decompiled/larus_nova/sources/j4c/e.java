package j4c;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.larus.nova.R;
import com.ss.android.lark.search.ui.result.component.ExtraInfoView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class e implements n, b08.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b08.a f497412a;

    @Override // b08.c
    public final <M, V extends View> void registerModelBinder(Class<M> r100, Class<V> r101, b08.b<? super V, ? super M> r102) {
        this.f497412a.registerModelBinder(r100, r101, r102);
    }

    public e() {
        b08.a r100 = new b08.a();
        Intrinsics.checkNotNullParameter(r100, "compositeComponentDelegate");
        this.f497412a = r100;
    }

    @Override // j4c.n
    public final void a(Context r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "parent");
        r101.removeAllViews();
        ExtraInfoView r102 = new ExtraInfoView(r100);
        r102.setId(R.id.avatar_item_extra_info);
        r102.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        ViewGroup.LayoutParams r103 = r102.getLayoutParams();
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        int r104 = a0.a(4.0f, r100);
        ((LinearLayout.LayoutParams) r103).topMargin = r104;
        r102.setVisibility(8);
        r101.addView(r102);
        registerModelBinder(w3c.c.class, ExtraInfoView.class, f4c.b.f475598a);
    }
}
