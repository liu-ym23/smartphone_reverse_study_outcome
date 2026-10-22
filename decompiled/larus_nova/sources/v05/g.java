package v05;

import android.content.Context;
import com.bytedance.ee.bear.document.titlebar.titleview.DocumentTitleView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes16.dex */
public final class g {
    public static DocumentTitleView a(Context r100) {
        DocumentTitleView r101 = new DocumentTitleView(r100.getApplicationContext());
        r101.setGravity(17);
        r101.setTitleTextSize(R.dimen.doc_title_bar_text_size);
        r101.setTitleTextColor(R.color.text_title);
        r101.setTitleTextBold(true);
        r101.setExternalVisible(false);
        return r101;
    }
}
