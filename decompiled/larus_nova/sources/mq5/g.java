package mq5;

import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.WikiDatabase;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes18.dex */
public final class g<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f514890a;

    public g(String r100) {
        this.f514890a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        if (tp5.b.c(tp5.b.a((Throwable) r100)) == false) goto L6;
        tt5.a.k("PersonalTreeDataManager", "requestPersonal, this relation was deleted. ");
        WikiDatabase.c().d().e(this.f514890a);
        return;
    }
}
