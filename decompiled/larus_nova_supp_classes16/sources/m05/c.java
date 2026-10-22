package m05;

import android.text.TextUtils;
import db5.d;
import db5.f;
import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c {
    public static void a(final String r2, Consumer<String> r3, Consumer<Throwable> r4) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return;
    L5:
        Flowable.just(r2).map(new d()).map(new a()).map(new f()).doOnError(new b(r2)).subscribe(r3, r4);
    }
}
