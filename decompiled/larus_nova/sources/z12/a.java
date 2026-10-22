package z12;

import android.content.Context;
import com.bytedance.android.livesdk.chatroom.event.LocateGiftInfo;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftViewModelManager;
import com.bytedance.android.livesdk.gift.platform.core.utils.u;
import com.bytedance.android.livesdk.gift.vs.panel.view.VSGiftDialogFragmentNew;
import com.bytedance.ies.sdk.widgets.DataCenter;
import h12.f;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a implements f {
    public a() {
    }

    @Override // h12.f
    public final VSGiftDialogFragmentNew a(Context r100, DataCenter r101, GiftViewModelManager r102, LocateGiftInfo r103) {
        Intrinsics.checkNotNullParameter(r100, "outerContext");
        if (u.p() == false) goto L12;
        VSGiftDialogFragmentNew r104 = new VSGiftDialogFragmentNew();
        r104.f132416i = r100;
        if (r101 == null) goto L9;
        Boolean r105 = (Boolean) r101.get("data_is_anchor", Boolean.FALSE);
        if (r105 == null) goto L9;
        boolean r106 = r105.booleanValue();
    L10:
        r104.f132415h = r106;
        r104.f132417j = r101;
        r104.f132418k = r102;
        r104.f132419l = r103;
        return r104;
    L9:
        r106 = false;
        goto L10
    L12:
        return null;
    }
}
