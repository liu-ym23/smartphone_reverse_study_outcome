package ju4;

import android.text.Editable;
import android.view.View;
import com.bytedance.ee.bear.bitable.pro.applypro.BitableApplyProFetcher;
import com.bytedance.ee.bear.bitable.pro.applypro.BitableApplyProFragment;
import com.bytedance.ee.bear.contract.net.SimpleRequestResult;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e implements View.OnClickListener {
    public final /* synthetic */ BitableApplyProFragment a;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ BitableApplyProFragment a;

        public a(BitableApplyProFragment r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            int r4 = ((SimpleRequestResult) r3).getCode();
            BitableApplyProFragment.U90(this.a, r4);
            if (r4 != 0) goto L5;
            this.a.X90().setText("");
            return;
        L5:
            tt5.a.d("BitableApplyProFragment", "apply pro fail " + r4);
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ BitableApplyProFragment a;

        public b(BitableApplyProFragment r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            BitableApplyProFragment.U90(this.a, -1);
            tt5.a.e("BitableApplyProFragment", "apply pro err  ", (Throwable) r4, false);
        }
    }

    public e(BitableApplyProFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        BitableApplyProFragment r5 = this.a;
        int r0 = BitableApplyProFragment.u;
        r5.X90().clearFocus();
        rcb.c.c(r5.getContext());
        Editable r6 = this.a.X90().getText();
        if (r6 == null) goto L6;
        String r7 = r6.toString();
        if (r7 == null) goto L6;
    L7:
        int r1 = com.bytedance.ee.bear.bitable.pro.d.a;
        if (r7.length() <= 0) goto L10;
        boolean r2 = true;
    L11:
        com.bytedance.ee.bear.bitable.pro.d.a(r2);
        BitableApplyProFetcher r3 = this.a.p;
        if (r3 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("fetcher");
        r3 = null;
    L14:
        Flowable<SimpleRequestResult> r8 = r3.a(r7);
        BitableApplyProFragment r9 = this.a;
        Disposable r10 = r8.subscribe(new a(r9), new b(r9));
        this.a.q.add(r10);
        return;
    L10:
        r2 = false;
    L6:
        r7 = "";
        goto L7
    }
}
