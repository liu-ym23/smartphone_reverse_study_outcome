package s62;

import android.view.View;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.AICloneConvItem;

/* JADX INFO: loaded from: classes9.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f540791a;

    public c(a r100) {
        this.f540791a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        AICloneConvItem r101 = this.f540791a.a();
        if (r101 == null) goto L8;
        String r102 = r101.getSchema();
        if (r102 == null) goto L9;
        this.f540791a.b(r102, "live_comment");
        return;
    L9:
        return;
    }
}
