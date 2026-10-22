package com.bytedance.ee.bear.bitable.share.sharepanel;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.supervisor.token.Token;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.utils.FileUtils;
import com.ss.android.lark.permission.StoragePermissionUtils;
import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class q implements View.OnClickListener {
    public final /* synthetic */ FormsQRCodePanelFragmentV2 a;

    public static final class a implements com.ss.android.lark.utils.h.c {
        public final /* synthetic */ FormsQRCodePanelFragmentV2 a;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.bitable.share.sharepanel.q$a$a, reason: collision with other inner class name */
        public static final class C0020a<T, R> implements Function {
            public final /* synthetic */ FormsQRCodePanelFragmentV2 a;
            public final /* synthetic */ Bitmap b;

            public C0020a(FormsQRCodePanelFragmentV2 r1, Bitmap r2) {
                this.a = r1;
                this.b = r2;
            }

            public final Object apply(Object r5) {
                Intrinsics.checkNotNullParameter((String) r5, "it");
                if (FormsQRCodePanelFragmentV2.S90(this.a) == false) goto L5;
                int r6 = com.suite.lark.platform.component.storage.file.dirs.h.c;
                com.suite.lark.platform.component.storage.file.dirs.h r7 = com.suite.lark.platform.component.storage.file.dirs.h.a.a(this.a.requireContext());
                r7.c(ay4.d.a());
                com.suite.lark.platform.component.storage.file.dirs.j r1 = new com.suite.lark.platform.component.storage.file.dirs.j();
                Intrinsics.checkNotNullParameter(r1, "pathProvider");
                com.suite.lark.platform.component.storage.file.dirs.h.b r8 = r7.a(r1);
                r8.b(System.currentTimeMillis() + ".jpg");
                String r9 = FileUtils.w(this.b, r8.a().getRealPath());
                tt5.a.h("FormsQRCodePanelFragment", "save success " + r9);
                FileUtils.u(this.a.getActivity(), r9);
            L7:
                return Unit.INSTANCE;
            L5:
                tt5.a.h("FormsQRCodePanelFragment", "fragment detached save qrcode");
                goto L7
            }
        }

        public static final class b<T> implements Consumer {
            public final /* synthetic */ FormsQRCodePanelFragmentV2 a;

            public b(FormsQRCodePanelFragmentV2 r1) {
                this.a = r1;
            }

            public final void accept(Object r2) {
                Unit r3 = (Unit) r2;
                if (FormsQRCodePanelFragmentV2.S90(this.a) == false) goto L5;
                UDToast.show(this.a.requireContext(), 2131892560);
                return;
            L5:
                tt5.a.h("FormsQRCodePanelFragment", "fragment detached show succeed toast");
            }
        }

        public static final class c<T> implements Consumer {
            public final /* synthetic */ FormsQRCodePanelFragmentV2 a;

            public c(FormsQRCodePanelFragmentV2 r1) {
                this.a = r1;
            }

            public final void accept(Object r4) {
                tt5.a.e("FormsQRCodePanelFragment", "save failed", (Throwable) r4, false);
                if (FormsQRCodePanelFragmentV2.S90(this.a) == false) goto L5;
                UDToast.show(this.a.requireContext(), 2131892140);
                return;
            L5:
                tt5.a.h("FormsQRCodePanelFragment", "fragment detached show failed toast");
            }
        }

        public a(FormsQRCodePanelFragmentV2 r1) {
            this.a = r1;
        }

        public final void b(StoragePermissionUtils.c r5) {
            Intrinsics.checkNotNullParameter(r5, "state");
            if (r5.d == false) goto L11;
            Context r6 = this.a.getContext();
            if (r6 == null) goto L7;
            this.a.U90().setBackgroundColor(r6.getResources().getColor(2131106521));
        L7:
            Bitmap r7 = com.ss.android.lark.utils.p.f(this.a.U90());
            if (this.a.getContext() == null) goto L10;
            this.a.U90().setBackground(null);
        L10:
            FormsQRCodePanelFragmentV2 r0 = this.a;
            Flowable r8 = Flowable.just("").map(new C0020a(this.a, r7)).subscribeOn(fo5.d.c()).observeOn(fo5.d.d());
            FormsQRCodePanelFragmentV2 r2 = this.a;
            r0.r = r8.subscribe(new b(r2), new c(r2));
            return;
        L11:
            tt5.a.h("FormsQRCodePanelFragment", "hasn't save permission");
        }
    }

    public q(FormsQRCodePanelFragmentV2 r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        Function0<Unit> r6 = this.a.q;
        if (r6 == null) goto L5;
        r6.invoke();
    L5:
        FragmentActivity r7 = this.a.getActivity();
        if (r7 == null) goto L9;
        com.ss.android.lark.utils.h.g(r7, new a(this.a), com.ss.android.lark.utils.n.c(), new Token("LARK-PSDA-base_forms_share_qrcode_save"), new String[0]);
        return;
    }
}
