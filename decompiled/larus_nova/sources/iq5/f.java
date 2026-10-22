package iq5;

import com.bytedance.ee.bear.contract.create.DocumentCreateInfo;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes18.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ee.bear.wikiv2.selector.d f495362a;

    public f(com.bytedance.ee.bear.wikiv2.selector.d r100) {
        this.f495362a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        DocumentCreateInfo r101 = (DocumentCreateInfo) r100;
        tt5.a.h("FolderSelectPresenter", "create folder success.");
        this.f495362a.I8();
        a0.a(this.f495362a.f241164o, "click_create_folder");
    }
}
