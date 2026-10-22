package mq5;

import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.WikiDatabase;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ String a;

    public g(String r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        if (tp5.b.c(tp5.b.a((Throwable) r2)) == false) goto L6;
        tt5.a.k("PersonalTreeDataManager", "requestPersonal, this relation was deleted. ");
        WikiDatabase.c().d().e(this.a);
        return;
    }
}
