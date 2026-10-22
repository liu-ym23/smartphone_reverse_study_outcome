package lib;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.framework.utils.UIUtils;

/* JADX INFO: loaded from: classes36.dex */
public final class o extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Activity f509484a;

    public o(Activity r100) {
        this.f509484a = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        super.getItemOffsets(r100, r101, r102, r103);
        r100.bottom = UIUtils.dp2px(this.f509484a, 10.0f);
    }
}
