package yp5;

import android.view.View;
import com.bytedance.ee.bear.route.h;
import com.bytedance.ee.bear.widgets.t;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a extends t {
    public a() {
    }

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r3) {
        ((h) org.koin.java.a.c(h.class, null, null, 6)).w2("/search/sub_activity").j("KEY_SEARCH_OBJ_TYPE", -1).j("KEY_SEARCH_SUB_PAGE_TYPE", 3).i(ResourceData.KEY_TYPE, DocumentType.WIKI_NAME).e();
    }
}
