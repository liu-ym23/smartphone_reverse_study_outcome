package ti5;

import android.content.Context;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.content.common.morepanel.CommonMorePanelItemData;
import com.bytedance.ee.bear.middleground.permission.transfer.TransferApplyFragment;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class n<T> implements Observer {
    public final /* synthetic */ TransferApplyFragment a;
    public final /* synthetic */ TextView b;

    public n(TransferApplyFragment r1, TextView r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onChanged(Object r4) {
        String r5 = ((CommonMorePanelItemData) r4).a;
        String r1 = "";
        switch(r5.hashCode()) {
            case 49: goto L24;
            case 50: goto L15;
            case 51: goto L6;
            default: goto L35;
        };
    L35:
        return;
    L6:
        if (r5.equals("3") == false) goto L36;
        TransferApplyFragment r6 = this.a;
        r6.j = 3;
        TextView r0 = this.b;
        Context r7 = r6.getContext();
        if (r7 == null) goto L13;
        String r8 = r7.getString(2131887512);
        if (r8 == null) goto L13;
        r1 = r8;
    L13:
        r0.setText(r1);
        return;
    L36:
        return;
    L15:
        if (r5.equals("2") == false) goto L37;
        TransferApplyFragment r9 = this.a;
        r9.j = 2;
        TextView r2 = this.b;
        Context r10 = r9.getContext();
        if (r10 == null) goto L22;
        String r11 = r10.getString(2131889689);
        if (r11 == null) goto L22;
        r1 = r11;
    L22:
        r2.setText(r1);
        return;
    L37:
        return;
    L24:
        if (r5.equals("1") == false) goto L38;
        TransferApplyFragment r12 = this.a;
        r12.j = 1;
        TextView r3 = this.b;
        Context r13 = r12.getContext();
        if (r13 == null) goto L31;
        String r14 = r13.getString(2131889693);
        if (r14 == null) goto L31;
        r1 = r14;
    L31:
        r3.setText(r1);
        return;
    }
}
