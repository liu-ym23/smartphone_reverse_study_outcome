package lc5;

import com.bytedance.ee.bear.list.dto.Document;
import io.reactivex.functions.Consumer;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ Document a;
    public final /* synthetic */ String b;

    public d(Document r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r4) {
        Boolean r5 = (Boolean) r4;
        HashMap r6 = new HashMap();
        r6.put("doc_has_cache", String.valueOf(this.a.w ? 1 : 0));
        r6.put("file_type", sbb.e.c(this.a.getType()));
        r6.put("doc_from", this.b);
        if (qc5.a.h() == false) goto L5;
        String r0 = "new_format";
    L6:
        r6.put("space_version", r0);
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6)).v("dev_performance_show_list_item", r6);
        return;
    L5:
        r0 = "original";
        goto L6
    }
}
