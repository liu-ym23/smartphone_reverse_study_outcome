package iq5;

import com.bytedance.ee.bear.contract.create.DocumentCreateInfo;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ com.bytedance.ee.bear.wikiv2.selector.d a;

    public f(com.bytedance.ee.bear.wikiv2.selector.d r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        DocumentCreateInfo r3 = (DocumentCreateInfo) r2;
        tt5.a.h("FolderSelectPresenter", "create folder success.");
        this.a.I8();
        a0.a(this.a.o, "click_create_folder");
    }
}
