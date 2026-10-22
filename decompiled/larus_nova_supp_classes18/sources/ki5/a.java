package ki5;

import android.view.View;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.setting.linkshare.sharelinkset.DocumentLinkShareView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ DocumentLinkShareView a;

    public a(DocumentLinkShareView r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        Toast.showText(this.a.getContext(), this.a.getContext().getString(2131889301));
    }
}
