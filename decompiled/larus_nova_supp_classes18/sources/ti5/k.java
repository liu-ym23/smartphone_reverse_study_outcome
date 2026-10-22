package ti5;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.ee.bear.content.common.morepanel.ActionSheetDialogFragment;
import com.bytedance.ee.bear.content.common.morepanel.CommonMorePanelData;
import com.bytedance.ee.bear.content.common.morepanel.CommonMorePanelFragment;
import com.bytedance.ee.bear.content.common.morepanel.CommonMorePanelItemData;
import com.bytedance.ee.bear.content.common.morepanel.CommonMorePanelViewModel;
import com.bytedance.ee.bear.middleground.permission.transfer.TransferApplyFragment;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class k implements a {
    public final /* synthetic */ TransferApplyFragment a;

    public k(TransferApplyFragment r1) {
        this.a = r1;
    }

    @Override // ti5.a
    public final void a(TextView r14) {
        Intrinsics.checkNotNullParameter(r14, "view");
        TransferApplyFragment r1 = this.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r14, "view");
        Context r0 = r1.getContext();
        if (r0 == null) goto L50;
        CommonMorePanelItemData r2 = new CommonMorePanelItemData();
        Intrinsics.checkNotNullParameter("1", "<set-?>");
        r2.a = "1";
        r2.a(r0.getString(2131889693));
        CommonMorePanelItemData r3 = new CommonMorePanelItemData();
        Intrinsics.checkNotNullParameter("2", "<set-?>");
        r3.a = "2";
        r3.a(r0.getString(2131889689));
        CommonMorePanelItemData r5 = new CommonMorePanelItemData();
        Intrinsics.checkNotNullParameter("3", "<set-?>");
        r5.a = "3";
        r5.a(r0.getString(2131887512));
        int r6 = 2;
        ArrayList r7 = CollectionsKt.arrayListOf(new CommonMorePanelItemData[]{r3, r5});
        int r8 = r1.h.getType();
        int r10 = t.a;
        if (idb.f.a().isEnable("apaas.miaoda.migrate_to_ccm") == true) goto L8;
    L11:
        boolean r9 = true;
    L12:
        if (r9 == false) goto L14;
        ListProtector.add(r7, 0, r2);
    L14:
        Iterator r11 = r7.iterator();
    L15:
        CommonMorePanelItemData r12 = null;
        if (r11.hasNext() == false) goto L20;
        Object r13 = r11.next();
        if (Intrinsics.areEqual(((CommonMorePanelItemData) r13).a, String.valueOf(r1.j)) == false) goto L15;
    L21:
        CommonMorePanelItemData r15 = (CommonMorePanelItemData) r13;
        if (r15 != null) goto L33;
        CommonMorePanelItemData r16 = (CommonMorePanelItemData) CollectionsKt.firstOrNull(r7);
        if (r16 != null) goto L26;
    L34:
        if (r12 == null) goto L36;
        r12.d = 2131255020;
        r12.g = com.bytedance.ee.util.ui.n.d(20);
        r12.h = 2131105543;
    L36:
        Parcelable r4 = new CommonMorePanelData();
        String r17 = r0.getString(2131889317);
        Intrinsics.checkNotNullParameter(r17, "<set-?>");
        ((CommonMorePanelData) r4).a = r17;
        Intrinsics.checkNotNullParameter(r7, "<set-?>");
        ((CommonMorePanelData) r4).c = r7;
        Bundle r18 = new Bundle();
        r18.putParcelable("panel_data", r4);
        ActionSheetDialogFragment.ba0(r1.getActivity(), CommonMorePanelFragment.class, r18);
        FragmentActivity r19 = r1.getActivity();
        if (r19 == null) goto L47;
        CommonMorePanelViewModel r20 = new ViewModelProvider(r19).get(CommonMorePanelViewModel.class);
        if (r20 == null) goto L48;
        MutableLiveData r21 = r20.getSelectData();
        if (r21 == null) goto L49;
        r21.observe(r19, new n(r1, r14));
        return;
    L49:
        return;
    L48:
        return;
    L47:
        return;
    L26:
        if (Intrinsics.areEqual(r16, r2) == false) goto L29;
        r6 = 1;
    L32:
        r1.j = r6;
        r14.setText(r16.c);
        r12 = r16;
        goto L34
    L29:
        if (Intrinsics.areEqual(r16, r3) == true) goto L32;
        r6 = 3;
        goto L32
    L33:
        r12 = r15;
        goto L34
    L20:
        r13 = null;
        goto L21
    L8:
        if (sbb.g.a(r8) == false) goto L11;
        r9 = false;
        goto L12
    }

    @Override // ti5.a
    public final void b(d r2) {
        Intrinsics.checkNotNullParameter(r2, WikiFolderPushPlugin.DATA);
        TransferApplyFragment r0 = this.a;
        r0.m = r2.g;
    }
}
