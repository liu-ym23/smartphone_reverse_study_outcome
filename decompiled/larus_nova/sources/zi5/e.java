package zi5;

import android.view.View;
import com.larus.avatar.impl.scan.view.ScanCameraBeautyLevel;

/* JADX INFO: loaded from: classes18.dex */
public final class e implements View.OnClickListener {
    public e() {
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        com.bytedance.ee.bear.middleground.record.a.c(ScanCameraBeautyLevel.CATEGORY_KEY_BASIC, "ccm_space_docs_details_view");
    }
}
