package com.bytedance.ee.bear.templates.topic;

import android.os.Bundle;
import android.view.View;
import com.bytedance.ee.bear.content.common.morepanel.ActionSheetDialogFragment;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.list.sort.SortAndFilterFragment;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ BaseTopicView a;

    public a(BaseTopicView r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        BaseTopicView r6 = this.a;
        boolean r2 = true;
        if (r6.i.getNetworkState().a() == true) goto L6;
        r2 = false;
    L6:
        if (r2 == false) goto L8;
        Bundle r0 = new Bundle();
        r0.putString("key_module", "home");
        r0.putString("key_token", "template_topic");
        r0.putBoolean("key_sort_asc_enable", false);
        r0.putInt("key_default_type_pos", r6.k().getCurrentTabFilterIndex());
        r0.putBoolean("key_reset_enable", false);
        r0.putBoolean("key_sort_filter_enable", false);
        ActionSheetDialogFragment.ba0(r6.a, SortAndFilterFragment.class, r0);
        return;
    L8:
        Toast.showFailureText(r6.a, 2131887789);
    }
}
