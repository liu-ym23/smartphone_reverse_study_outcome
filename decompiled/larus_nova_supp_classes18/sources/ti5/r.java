package ti5;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.transfer.TransferApplyFragment;
import com.bytedance.ee.bear.middleground.permission.transfer.executor.OwnerTransferApplyExecutor;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.larksuite.framework.utils.l0;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class r implements gp5.a.InterfaceC0236a {
    public final /* synthetic */ Context a;
    public final /* synthetic */ TransferApplyFragment b;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ Context a;
        public final /* synthetic */ TransferApplyFragment b;

        public a(Context r1, TransferApplyFragment r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r2) {
            Boolean r3 = (Boolean) r2;
            Toast.cancelLoading();
            Toast.showText(this.a, 2131889322);
            this.b.dismissAllowingStateLoss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r4 = DialogFragmentLancet.sLastShowStack;
            if (r4 == null) goto L12;
            com.bytedance.crash.d.d(r4, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
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

        public final void accept(Object r3) {
            NetService.HttpErrorException r4 = (Throwable) r3;
            Toast.cancelLoading();
            tt5.a.d("TransferApplyFragment", "showDoubleCheckerDialog error " + r4);
            if ((r4 instanceof NetService.HttpErrorException) == true) goto L5;
        L7:
            TransferApplyFragment r0 = this.b;
            Intrinsics.checkNotNull(r4);
            TransferApplyFragment.Z90(r0, r4);
            return;
        L5:
            if (r4.getCode() != 429) goto L7;
            Toast.showText(this.a, 2131889321);
        }
    }

    @Override // gp5.a.InterfaceC0236a
    public final void a(String r11) {
        Intrinsics.checkNotNullParameter(r11, "text");
        Context r12 = this.a;
        Toast.showLoading(r12, r12.getString(2131887769));
        TransferApplyFragment r13 = this.b;
        OwnerTransferApplyExecutor r0 = r13.n;
        if (r0 == null) goto L17;
        String r14 = r13.h.getToken();
        int r1 = this.b.h.getType();
        String r2 = this.b.h.getOwnerId();
        Boolean r3 = Boolean.valueOf(this.b.m);
        Integer r4 = Integer.valueOf(this.b.j);
        Boolean r5 = Boolean.valueOf(this.b.l);
        String r6 = this.b.p.toString();
        Intrinsics.checkNotNullParameter(r14, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r2, "ownerId");
        JsonObject r8 = new JsonObject();
        r8.addProperty("new_owner_id", r2);
        if (r3 == null) goto L7;
        r8.addProperty("remove_old_owner", Boolean.valueOf(r3.booleanValue()));
    L7:
        if (r4 == null) goto L9;
        r8.addProperty("old_owner_perm_role", Integer.valueOf(r4.intValue()));
    L9:
        if (r5 == null) goto L12;
        r8.addProperty("recursive_transfer", Boolean.valueOf(r5.booleanValue()));
    L12:
        if (TextUtils.isEmpty(r6) == true) goto L14;
        r8.addProperty("remark", r6);
    L14:
        r8.addProperty("batch_trans_id", l0.a().toString());
        r8.addProperty("resource_operation_type", 19);
        JsonArray r7 = new JsonArray();
        JsonObject r9 = new JsonObject();
        r9.addProperty(ResourceData.KEY_TOKEN, r14);
        r9.addProperty("obj_type", Integer.valueOf(r1));
        r7.add(r9);
        r8.add("objs", r7);
        NetService.f r15 = new NetService.f("/space/api/suite/platform/apply_transfer/");
        ((NetService.e) r15).c = 1;
        ((NetService.e) r15).j = r8.toString();
        Flowable r16 = r0.a.Vc(new ax4.f()).a(r15).map(com.bytedance.ee.bear.middleground.permission.transfer.executor.a.a);
        if (r16 == null) goto L17;
        Context r10 = this.a;
        TransferApplyFragment r17 = this.b;
        Disposable r18 = r16.subscribe(new a(r10, r17), new b(r10, r17));
    L18:
        if (r18 == null) goto L23;
        CompositeDisposable r19 = this.b.o;
        if (r19 == null) goto L24;
        r19.add(r18);
        return;
    L24:
        return;
    L23:
        return;
    L17:
        r18 = null;
        goto L18
    }

    public r(Context r1, TransferApplyFragment r2) {
        this.a = r1;
        this.b = r2;
    }
}
