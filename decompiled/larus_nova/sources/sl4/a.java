package sl4;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.bytedance.dux.filterpanel.DuxFilterGroupView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DuxFilterGroupView f542459a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f542460b;

    public a(DuxFilterGroupView r100, Context r101) {
        this.f542459a = r100;
        this.f542460b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f542459a.getGridLayout().removeAllViews();
        DuxFilterGroupView r101 = this.f542459a;
        if (r101.f205071g == false) goto L9;
        TextView r102 = r101.f205067c;
        if (r102 == null) goto L8;
        r102.setText(this.f542460b.getResources().getString(R.string.dux_show_more));
    L8:
        DuxFilterGroupView r103 = this.f542459a;
        DuxFilterGroupView.S5(r103, r103.f205072h, r103.f205070f);
        this.f542459a.f205071g = false;
        return;
    L9:
        TextView r104 = r101.f205067c;
        if (r104 == null) goto L13;
        r104.setText(this.f542460b.getResources().getString(R.string.dux_show_less));
    L13:
        DuxFilterGroupView r105 = this.f542459a;
        DuxFilterGroupView.S5(r105, r105.f205073i, r105.f205070f);
        this.f542459a.f205071g = true;
    }
}
