package vfc;

import com.larksuite.component.ui.dialog.LKUIDialog;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes38.dex */
public final class l extends com.larksuite.component.ui.dialog.d.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f554652a;

    public l(o r100) {
        this.f554652a = r100;
    }

    @Override // com.larksuite.component.ui.dialog.d.a
    public final void b(LKUIDialog r100) {
        o r101 = this.f554652a;
        r101.getClass();
        r100.findViewById(R.id.stopView).setOnClickListener(new h(r100));
        r100.setOnDismissListener(new i(r101));
    }
}
