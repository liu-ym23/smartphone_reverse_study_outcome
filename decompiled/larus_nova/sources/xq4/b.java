package xq4;

import android.view.View;
import com.bytedance.ee.bear.bitable.uikit.ActionPayload;

/* JADX INFO: loaded from: classes15.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f564800a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f564801b;

    public b(a r100, c r101) {
        this.f564800a = r100;
        this.f564801b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        a r101 = this.f564800a;
        r101.getClass();
        ActionPayload r102 = new ActionPayload();
        r102.setAction("CreateGroup");
        r101.a(r102);
        com.bytedance.ee.bear.bitable.celleditor.editor.g<Model> r103 = this.f564801b.f209380b;
        if (r103 == 0) goto L6;
        r103.dismiss();
        return;
    }
}
