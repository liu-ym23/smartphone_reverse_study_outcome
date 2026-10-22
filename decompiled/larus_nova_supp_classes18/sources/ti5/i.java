package ti5;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.transfer.TransferApplyFragment;
import com.bytedance.ee.bear.middleground.permission.transfer.executor.OwnerTransferApplyExecutor;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i implements View.OnClickListener {
    public final /* synthetic */ Context a;
    public final /* synthetic */ TransferApplyFragment b;

    public i(Context r1, TransferApplyFragment r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r9) {
        if (com.bytedance.ee.bear.contract.j.a.a.getNetworkState().a() == true) goto L7;
        Toast.showFailureText(this.a, 2131887782);
        return;
    L7:
        if (TextUtils.isEmpty(this.b.h.getOwnerId()) == false) goto L9;
        return;
    L9:
        TransferApplyFragment r10 = this.b;
        Context r0 = r10.getContext();
        Context r1 = r10.getContext();
        Disposable r2 = null;
        if (r1 == null) goto L12;
        String r3 = r1.getString(2131887769);
    L13:
        Toast.showLoading(r0, r3);
        OwnerTransferApplyExecutor r4 = r10.n;
        if (r4 == null) goto L18;
        String r5 = r10.h.getToken();
        int r6 = r10.h.getType();
        String r7 = r10.h.getOwnerId();
        Intrinsics.checkNotNullParameter(r5, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r7, "ownerId");
        JsonObject r8 = new JsonObject();
        r8.addProperty("new_owner_id", r7);
        JsonArray r11 = new JsonArray();
        JsonObject r12 = new JsonObject();
        r12.addProperty(ResourceData.KEY_TOKEN, r5);
        r12.addProperty("obj_type", Integer.valueOf(r6));
        r11.add(r12);
        r8.add("objs", r11);
        NetService.f r13 = new NetService.f("/space/api/suite/platform/check_transfer/");
        ((NetService.e) r13).c = 1;
        ((NetService.e) r13).j = r8.toString();
        Flowable r14 = r4.a.Vc(new ax4.f()).a(r13).map(com.bytedance.ee.bear.middleground.permission.transfer.executor.b.a);
        if (r14 == null) goto L18;
        r2 = r14.subscribe(new e(r10), new f(r10));
    L18:
        if (r2 == null) goto L23;
        CompositeDisposable r15 = r10.o;
        if (r15 == null) goto L24;
        r15.add(r2);
        return;
    L24:
        return;
    L23:
        return;
    L12:
        r3 = null;
        goto L13
    }
}
