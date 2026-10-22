package y81;

import android.view.View;
import android.widget.TextSwitcher;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.room.incentiveinfo.model.BizStatus;
import com.larus.nova.R;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class f0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d0 f566758a;

    public f0(d0 r100) {
        this.f566758a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        d0 r101 = (d0) r100;
        TextSwitcher r102 = this.f566758a.Q;
        View r103 = null;
        if (r102 == null) goto L5;
        View r104 = r102.getCurrentView();
    L7:
        if ((r104 instanceof TextView) == false) goto L10;
        r103 = r104;
    L10:
        TextView r105 = (TextView) r103;
        if (r105 == null) goto L14;
        r105.setTextColor(s1.h(R.color.commonui_white));
    L14:
        if (this.f566758a.Z != BizStatus.END.getValue()) goto L17;
        this.f566758a.m();
        return;
    L17:
        return;
    L5:
        r104 = null;
        goto L7
    }
}
