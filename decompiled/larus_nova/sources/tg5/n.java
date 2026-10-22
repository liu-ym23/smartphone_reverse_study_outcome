package tg5;

import android.content.Context;
import android.view.View;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.widgets.t;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public final class n extends t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ b f545882c;

    public n(b r100) {
        this.f545882c = r100;
    }

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r100) {
        Context r101 = this.f545882c.f545851a;
        Toast.showText(r101, r101.getString(R.string.LarkCCM_Docs_InviteEmail_SendNote_Required_Tooltip));
    }
}
