package com.bytedance.android.livesdk.livecommerce.eventcenter.ability;

import android.content.Context;
import android.widget.Toast;
import com.bytedance.android.ec.local.api.atomic.LiveAtomicAbilityDescriptor;
import com.bytedance.android.ui.ec.widget.toast.ECToast;
import com.bytedance.common.utility.UIUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@LiveAtomicAbilityDescriptor(action = "show_toast", description = "展示Toast", service = {"LiveBase"})
public final class h0 extends com.bytedance.android.livesdk.livecommerce.ability.d<JSONObject> {
    public h0() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.ability.d
    public final void a(Context r8, JSONObject r9, Object r10, il2.a r11, com.bytedance.android.livesdk.livecommerce.ability.e r12) {
        JSONObject r13 = r9;
        if (r8 == null) goto L17;
        if (r13 == null) goto L17;
        String r3 = r13.optString("toast");
        int r14 = r13.optInt("toast_type", 0);
        if (r14 != 1) goto L9;
        Toast.makeText(r8, r3, 0).show();
    L15:
        if (r12 == null) goto L20;
        r12.onSuccess();
        return;
    L20:
        return;
    L9:
        if (r14 == 2) goto L13;
        if (r14 == 3) goto L12;
        com.bytedance.android.livesdk.livecommerce.utils.k.n(r8, r3);
        goto L15
    L12:
        ECToast.showToast$default(ECToast.INSTANCE, r8, r3, null, 4, null);
        goto L15
    L13:
        UIUtils.displayToast(r8, r3);
    L17:
        if (r12 == null) goto L22;
        com.bytedance.android.livesdk.livecommerce.ability.e.a.a(r12, 0, null, 3);
        return;
    }
}
