package kj5;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.quoto.FullQuotoConfig;
import com.bytedance.ee.bear.quoto.SingleFileQuotaConfig;
import com.bytedance.ee.bear.quoto.t;
import io.reactivex.Flowable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d implements t {
    public d() {
    }

    @Override // com.bytedance.ee.bear.quoto.t
    public final boolean a(Throwable r1, Context r2) {
        Intrinsics.checkNotNullParameter(r1, "throwable");
        return false;
    }

    @Override // com.bytedance.ee.bear.quoto.t
    public final void c(Context r1, String r2, String r3, boolean r4, boolean r5, String r6) {
        Intrinsics.checkNotNullParameter(r6, "reason");
    }

    @Override // com.bytedance.ee.bear.quoto.t
    public final void d(Context r1, int r2) {
    }

    @Override // com.bytedance.ee.bear.quoto.t
    public final boolean e() {
        return false;
    }

    @Override // com.bytedance.ee.bear.quoto.t
    public final boolean g(int r1) {
        return false;
    }

    @Override // com.bytedance.ee.bear.quoto.t
    public final boolean h(int r1, Context r2, boolean r3) {
        Intrinsics.checkNotNullParameter("", "reason");
        return false;
    }

    @Override // com.bytedance.ee.bear.quoto.t
    public final void i(FragmentActivity r1, String r2, String r3, boolean r4, String r5, View.OnClickListener r6) {
        Intrinsics.checkNotNullParameter(r6, "confirmListener");
    }

    @Override // com.bytedance.ee.bear.quoto.t
    public final void j(FragmentActivity r2, FullQuotoConfig r3) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "config");
    }

    @Override // com.bytedance.ee.bear.quoto.t
    public final boolean k(int r1) {
        return false;
    }

    @Override // com.bytedance.ee.bear.quoto.t
    public final boolean l(int r1, Context r2) {
        return false;
    }

    @Override // com.bytedance.ee.bear.quoto.t
    public final void m(FragmentActivity r2, DialogInterface.OnDismissListener r3) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "onDismissListener");
    }

    @Override // com.bytedance.ee.bear.quoto.t
    public final void n(Context r1, int r2, i55.a r3) {
        Intrinsics.checkNotNullParameter(r3, "clickListener");
    }

    @Override // com.bytedance.ee.bear.quoto.t
    public final boolean o(int r1) {
        return false;
    }

    @Override // com.bytedance.ee.bear.quoto.t
    public final boolean p(Throwable r1, Context r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "throwable");
        Intrinsics.checkNotNullParameter("", "reason");
        return false;
    }

    @Override // com.bytedance.ee.bear.quoto.t
    public final boolean q(int r1) {
        return false;
    }

    @Override // com.bytedance.ee.bear.quoto.t
    public final void r(FragmentActivity r2, DialogInterface.OnDismissListener r3) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "onDismissListener");
    }

    @Override // com.bytedance.ee.bear.quoto.t
    public final boolean s(int r1) {
        return false;
    }

    @Override // com.bytedance.ee.bear.quoto.t
    public final Flowable b() {
        Intrinsics.checkNotNullParameter("", "mountNodeToken");
        Intrinsics.checkNotNullParameter("mountPoint", "mountPoint");
        return Flowable.just(Boolean.FALSE);
    }

    @Override // com.bytedance.ee.bear.quoto.t
    public final void f(Context r1, SingleFileQuotaConfig r2, Long r3) {
        r3.longValue();
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "config");
    }
}
