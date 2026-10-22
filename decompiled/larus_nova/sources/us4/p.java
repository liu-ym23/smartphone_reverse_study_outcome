package us4;

import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class p implements com.bytedance.lark.lark_bitable_android.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f551507a;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f551508a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f551509b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.lark.lark_bitable_android.i f551510c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f551511d;

        public a(l r100, long r101, com.bytedance.lark.lark_bitable_android.i r102, String r103) {
            this.f551508a = r100;
            this.f551509b = r101;
            this.f551510c = r102;
            this.f551511d = r103;
        }

        public final void a() {
            l r100 = this.f551508a;
            long r101 = this.f551509b;
            com.bytedance.lark.lark_bitable_android.i r102 = this.f551510c;
            if (r102 == null) goto L5;
            String r103 = r102.f253066a;
        L6:
            String r104 = this.f551511d;
            boolean r105 = false;
            r100.f551499o = false;
            Toast.cancelLoading();
            if (r101 != 0) goto L16;
            if (r103 != null) goto L10;
        L13:
            boolean r106 = true;
        L14:
            if (r106 == true) goto L16;
            r100.e(r103);
            return;
        L10:
            if (r103.length() == 0) goto L13;
            r106 = false;
        L16:
            tt5.a.d("BitableBoostViewContainer", "handleMarketplaceCreateResult failed errorCode=" + r101 + " msg=" + r104);
            if (r104.length() <= 0) goto L19;
            r105 = true;
        L19:
            if (r105 == false) goto L21;
            Toast.showFailureText(r100.getContext(), r104);
            return;
        L21:
            Toast.showFailureText(r100.getContext(), R.string.Doc_Facade_CreateFailed);
            return;
        L5:
            r103 = null;
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public p(l r100) {
        this.f551507a = r100;
    }

    @Override // com.bytedance.lark.lark_bitable_android.g
    public final void a(com.bytedance.lark.lark_bitable_android.i r100, long r110, String r111) {
        Intrinsics.checkNotNullParameter(r111, "msg");
        l r101 = this.f551507a;
        r101.post(new a(r101, r110, r100, r111));
    }
}
