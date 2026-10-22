package ti5;

import android.content.Context;
import android.content.DialogInterface;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.transfer.TransferApplyFragment;
import com.bytedance.ee.bear.middleground.permission.transfer.executor.OwnerTransferApplyExecutor;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class p implements DialogInterface.OnClickListener {
    public final /* synthetic */ Context a;
    public final /* synthetic */ TransferApplyFragment b;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ Context a;
        public final /* synthetic */ TransferApplyFragment b;

        public a(Context r1, TransferApplyFragment r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            Boolean r4 = (Boolean) r3;
            Toast.cancelLoading();
            Toast.showSuccessText(this.a, 2131889685);
            jg5.j r5 = ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa();
            String r0 = this.b.h.getToken();
            r5.getClass();
            com.bytedance.ee.bear.middleground.permission.collaborator.invite.i r6 = (com.bytedance.ee.bear.middleground.permission.collaborator.invite.i) ((HashMap) jg5.j.f).get(r0);
            if (r6 == null) goto L13;
            r6.b();
        L13:
            this.b.dismissAllowingStateLoss();     // Catch: Exception -> L8
            return;
        L8:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r7 = DialogFragmentLancet.sLastShowStack;
            if (r7 == null) goto L15;
            com.bytedance.crash.d.d(r7, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ TransferApplyFragment a;

        public b(TransferApplyFragment r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            tt5.a.d("TransferApplyFragment", "showCheckDialog error " + r4);
            TransferApplyFragment r0 = this.a;
            Intrinsics.checkNotNull(r4);
            TransferApplyFragment.Z90(r0, r4);
        }
    }

    public p(Context r1, TransferApplyFragment r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r8, int r9) {
        Context r10 = this.a;
        Toast.showLoading(r10, r10.getString(2131887769));
        TransferApplyFragment r11 = this.b;
        OwnerTransferApplyExecutor r12 = r11.n;
        if (r12 == null) goto L7;
        String r13 = r11.h.getToken();
        int r0 = this.b.h.getType();
        String r1 = this.b.h.getOwnerId();
        TransferApplyFragment r2 = this.b;
        int r3 = r2.j;
        boolean r4 = r2.m;
        Intrinsics.checkNotNullParameter(r13, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r1, "ownerId");
        HashMap r5 = new HashMap();
        r5.put(ResourceData.KEY_TYPE, String.valueOf(r0));
        r5.put(ResourceData.KEY_TOKEN, r13);
        r5.put("owner_id", r1);
        r5.put("owner_type", "0");
        r5.put("old_owner_perm_role", String.valueOf(r3));
        r5.put("remove_old_owner", String.valueOf(r4));
        NetService.f r14 = new NetService.f("/space/api/suite/permission/members/transfer");
        r14.d(r5);
        ((NetService.e) r14).c = 1;
        Flowable r15 = r12.a.Vc(new ax4.f()).a(r14).map(com.bytedance.ee.bear.middleground.permission.transfer.executor.c.a);
        if (r15 == null) goto L7;
        Context r6 = this.a;
        TransferApplyFragment r7 = this.b;
        Disposable r16 = r15.subscribe(new a(r6, r7), new b(r7));
    L8:
        if (r16 == null) goto L13;
        CompositeDisposable r17 = this.b.o;
        if (r17 == null) goto L14;
        r17.add(r16);
        return;
    L14:
        return;
    L13:
        return;
    L7:
        r16 = null;
        goto L8
    }
}
