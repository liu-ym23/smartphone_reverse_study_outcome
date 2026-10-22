package iq5;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ com.bytedance.ee.bear.wikiv2.selector.d a;
    public final /* synthetic */ FragmentActivity b;

    public g(com.bytedance.ee.bear.wikiv2.selector.d r1, FragmentActivity r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r6) {
        Throwable r7 = (Throwable) r6;
        Intrinsics.checkNotNullParameter(r7, "throwable");
        tt5.a.d("FolderSelectPresenter", "create folder failed, throwable = " + r7);
        Context r0 = this.a.getContext();
        Context r1 = this.a.getContext();
        if (r1 == null) goto L5;
        String r2 = r1.getString(2131887731);
    L6:
        Toast.showFailureText(r0, r2, 0);
        a0.a(this.a.o, "click_create_folder");
        ((com.bytedance.ee.bear.quoto.t) org.koin.java.a.c(com.bytedance.ee.bear.quoto.t.class, null, null, 6)).a(r7, this.b);
        ((com.bytedance.ee.bear.quoto.t) org.koin.java.a.c(com.bytedance.ee.bear.quoto.t.class, null, null, 6)).p(r7, this.b, false);
        return;
    L5:
        r2 = null;
        goto L6
    }
}
