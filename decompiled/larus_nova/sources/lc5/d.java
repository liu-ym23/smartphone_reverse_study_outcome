package lc5;

import com.bytedance.ee.bear.list.dto.Document;
import io.reactivex.functions.Consumer;
import java.util.HashMap;

/* JADX INFO: loaded from: classes18.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Document f508437a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f508438b;

    public d(Document r100, String r101) {
        this.f508437a = r100;
        this.f508438b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Boolean r101 = (Boolean) r100;
        HashMap r102 = new HashMap();
        r102.put("doc_has_cache", String.valueOf(this.f508437a.f227903w ? 1 : 0));
        r102.put("file_type", sbb.e.c(this.f508437a.getType()));
        r102.put("doc_from", this.f508438b);
        if (qc5.a.h() == false) goto L5;
        String r103 = "new_format";
    L6:
        r102.put("space_version", r103);
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6)).v("dev_performance_show_list_item", r102);
        return;
    L5:
        r103 = "original";
        goto L6
    }
}
