package yp4;

import android.view.View;
import android.widget.TextView;
import com.bytedance.ee.bear.bitable.card.view.cell.text.BitableTextFieldEditor;

/* JADX INFO: loaded from: classes15.dex */
public final class h implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ee.bear.bitable.card.view.cell.progress.b f568712a;

    public h(com.bytedance.ee.bear.bitable.card.view.cell.progress.b r100) {
        this.f568712a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        TextView r101 = this.f568712a.f207969h;
        if (r101 == null) goto L5;
        r101.setVisibility(8);
    L5:
        BitableTextFieldEditor r102 = this.f568712a.f207968g;
        if (r102 == null) goto L9;
        r102.requestFocus();
        return;
    }
}
