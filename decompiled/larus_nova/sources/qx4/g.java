package qx4;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.ee.bear.widgets.t;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes16.dex */
public final class g extends t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f535113c;

    public g(View r100) {
        this.f535113c = r100;
    }

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r100) {
        if (((TextView) this.f535113c.findViewById(R.id.responseBodyText)).getVisibility() != 0) goto L5;
        ((TextView) this.f535113c.findViewById(R.id.responseBodyText)).setVisibility(8);
        ((ImageView) this.f535113c.findViewById(R.id.responseBodyArrow)).setImageResource(R.drawable.ud_icon_expand_up_filled);
        return;
    L5:
        ((TextView) this.f535113c.findViewById(R.id.responseBodyText)).setVisibility(0);
        ((ImageView) this.f535113c.findViewById(R.id.responseBodyArrow)).setImageResource(R.drawable.ud_icon_expand_down_filled);
    }
}
