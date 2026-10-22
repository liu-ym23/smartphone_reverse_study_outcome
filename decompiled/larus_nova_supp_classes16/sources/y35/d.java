package y35;

import android.text.TextUtils;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.thread.BearExecutors;
import io.reactivex.functions.Function;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d<T, R> implements Function {
    public final /* synthetic */ BearUrl a;
    public final /* synthetic */ String b;

    public d(BearUrl r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object apply(Object r5) {
        String r6 = (String) r5;
        if (TextUtils.isEmpty(r6) == true) goto L5;
        BearExecutors.b().execute(new c(this.a, this.b, r6));
    L5:
        return r6;
    }
}
