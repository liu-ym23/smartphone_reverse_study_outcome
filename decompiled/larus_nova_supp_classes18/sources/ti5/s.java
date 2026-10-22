package ti5;

import android.content.Context;
import android.content.DialogInterface;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.permission.doc.DocPermissionAction;
import com.bytedance.ee.bear.middleground.permission.transfer.TransferApplyFragment;
import com.bytedance.ee.bear.middleground.permission.transfer.executor.OwnerTransferApplyExecutor;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.google.gson.JsonObject;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.lark.utils.UIHelper;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class s implements DialogInterface.OnClickListener {
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
        public final /* synthetic */ Context a;
        public final /* synthetic */ TransferApplyFragment b;

        public b(Context r1, TransferApplyFragment r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r7) {
            NetService.ServerErrorException r8 = (Throwable) r7;
            tt5.a.d("TransferApplyFragment", "showFolderDialog error " + r8);
            Intrinsics.checkNotNull(r8);
            Context r0 = this.a;
            String r2 = this.b.h.getOwnerName();
            String r3 = this.b.h.getOwnerId();
            int r4 = t.a;
            Intrinsics.checkNotNullParameter(r8, "throwable");
            Intrinsics.checkNotNullParameter(r0, "context");
            Intrinsics.checkNotNullParameter(r2, "ownerName");
            Intrinsics.checkNotNullParameter(r3, "ownerId");
            Toast.cancelLoading();     // Catch: Exception -> L21
            if ((r8 instanceof NetService.ServerErrorException) == false) goto L24;
            JSONObject r5 = new JSONObject(r8.getData()).optJSONObject("fail_map");     // Catch: Exception -> L21
            if (t.a(r5, 10015, r3) == false) goto L8;
        L19:
            Toast.showFailureText(r0, UIHelper.mustacheFormat(2131888959, "user", r2));     // Catch: Exception -> L21
            goto L24
        L8:
            if (t.a(r5, 10022, r3) == true) goto L19;
            if (t.a(r5, 2002, r3) == false) goto L14;
            t.b(r0);     // Catch: Exception -> L21
            goto L24
        L14:
            if (ax4.d.b(r8, DocPermissionAction.ERROR_DLP_INNER_SHARE_DETECTED_CODE) == false) goto L17;
            t.c(r0, r0.getResources().getString(2131888963));     // Catch: Exception -> L21
            goto L24
        L17:
            if (ax4.d.b(r8, 2006) == false) goto L24;
            t.c(r0, r0.getResources().getQuantityString(2131755032, 1, new Object[]{15}));     // Catch: Exception -> L21
        L24:
            return;
        L21:
            e = move-exception;
            tt5.a.d("TransferApplyFragment", "handleFolderPermission error " + e);
        }
    }

    public s(Context r1, TransferApplyFragment r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r7, int r8) {
        Context r9 = this.a;
        Toast.showLoading(r9, r9.getString(2131887769));
        TransferApplyFragment r10 = this.b;
        OwnerTransferApplyExecutor r11 = r10.n;
        if (r11 == null) goto L7;
        String r12 = r10.h.getOwnerId();
        String r0 = this.b.h.getToken();
        TransferApplyFragment r1 = this.b;
        boolean r2 = r1.l;
        boolean r3 = r1.m;
        int r4 = r1.j;
        Intrinsics.checkNotNullParameter(r12, "ownerId");
        Intrinsics.checkNotNullParameter(r0, ResourceData.KEY_TOKEN);
        JsonObject r5 = new JsonObject();
        r5.addProperty(ResourceData.KEY_TOKEN, r0);
        r5.addProperty("collaborator_id", r12);
        r5.addProperty("recursive_transfer", Boolean.valueOf(r2));
        r5.addProperty("remove_old_owner", Boolean.valueOf(r3));
        r5.addProperty("old_owner_perm_role", Integer.valueOf(r4));
        NetService.f r13 = new NetService.f("/space/api/suite/permission/space/collaborators/transfer");
        ((NetService.e) r13).c = 1;
        ((NetService.e) r13).j = r5.toString();
        Flowable r14 = r11.a.Vc(new ax4.f()).a(r13).map(com.bytedance.ee.bear.middleground.permission.transfer.executor.d.a);
        if (r14 == null) goto L7;
        Context r6 = this.a;
        TransferApplyFragment r15 = this.b;
        Disposable r16 = r14.subscribe(new a(r6, r15), new b(r6, r15));
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
