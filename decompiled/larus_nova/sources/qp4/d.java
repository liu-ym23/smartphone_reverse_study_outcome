package qp4;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class d extends ViewOutlineProvider {
    public d() {
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View r100, Outline r110) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r110, "outline");
        float r101 = r100.getResources().getDimension(R.dimen.space_kit_len_4);
        r110.setRoundRect(0, 0, r100.getWidth(), r100.getHeight(), r101);
    }
}
