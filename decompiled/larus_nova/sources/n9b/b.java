package n9b;

import android.content.Context;
import android.view.View;
import com.ss.android.lark.contact.customized.OfficeContactPageUtils;
import com.ss.android.lark.contact.customized.externalinvite.OfficeInviteExternalActivity;
import com.ss.android.lark.contact.customized.privatecontact.view.OfficePrivateContactFragment;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OfficePrivateContactFragment f518430a;

    public b(OfficePrivateContactFragment r100) {
        this.f518430a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Context r101 = this.f518430a.getContext();
        if (r101 == null) goto L6;
        com.ss.android.lark.contact.customized.common.b.a("contact", "contact");
        Lazy r102 = OfficeContactPageUtils.f418959a;
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r103 = OfficeInviteExternalActivity.f419261a;
        OfficeInviteExternalActivity.a.a(r101, "contact");
        return;
    }
}
