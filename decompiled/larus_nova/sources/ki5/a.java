package ki5;

import android.view.View;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.setting.linkshare.sharelinkset.DocumentLinkShareView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DocumentLinkShareView f503639a;

    public a(DocumentLinkShareView r100) {
        this.f503639a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Toast.showText(this.f503639a.getContext(), this.f503639a.getContext().getString(R.string.LarkCCM_Docs_SyncBlock_ShareInheritSource_Tooltip));
    }
}
