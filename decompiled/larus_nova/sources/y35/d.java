package y35;

import android.text.TextUtils;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.thread.BearExecutors;
import io.reactivex.functions.Function;

/* JADX INFO: loaded from: classes16.dex */
public final class d<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BearUrl f565859a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f565860b;

    public d(BearUrl r100, String r101) {
        this.f565859a = r100;
        this.f565860b = r101;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        String r101 = (String) r100;
        if (TextUtils.isEmpty(r101) == true) goto L5;
        BearExecutors.b().execute(new c(this.f565859a, this.f565860b, r101));
    L5:
        return r101;
    }
}
