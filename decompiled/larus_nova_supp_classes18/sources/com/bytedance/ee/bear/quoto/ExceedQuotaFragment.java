package com.bytedance.ee.bear.quoto;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.ee.bear.bizwidget.dialogfragment.CompatLandscapeBottomSheetDialogFragment;
import com.bytedance.ee.docsdk.impl.utils.keyboard.producer.BaseKeyboardHeightProducer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class ExceedQuotaFragment extends CompatLandscapeBottomSheetDialogFragment {
    public static long u;
    public static final /* synthetic */ int v = 0;
    public View k;
    public n l;
    public String m;
    public String n;
    public Boolean o;
    public String p;
    public boolean q;
    public boolean r;
    public String s;
    public View.OnClickListener t;

    public final boolean ba0() {
        return true;
    }

    public ExceedQuotaFragment() {
        this.s = "";
    }

    public final void onDestroy() {
        super/*com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment*/.onDestroy();
        n r0 = this.l;
        if (r0 == null) goto L6;
        r0.destroy();
        return;
    }

    public final void onCreate(Bundle r3) {
        super/*com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment*/.onCreate(r3);
        Bundle r4 = getArguments();
        if (r4 == null) goto L6;
        this.m = r4.getString("key_mount_node_token");
        this.n = r4.getString("key_mount_point");
        this.o = Boolean.valueOf(r4.getBoolean("key_is_folder"));
        this.p = r4.getString("key_reason");
        this.q = r4.getBoolean("key_cancel_outside", true);
        this.r = r4.getBoolean("key_is_department", false);
        this.s = r4.getString("key_custom_extra_hint", "");
        return;
    }

    public final Dialog onCreateDialog(Bundle r2) {
        Dialog r3 = super.onCreateDialog(r2);
        r3.setCanceledOnTouchOutside(this.q);
        r3.setCancelable(this.q);
        setCancelable(this.q);
        return r3;
    }

    public final void onViewCreated(View r11, Bundle r12) {
        super/*com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment*/.onViewCreated(r11, r12);
        View r1 = this.k;
        Context r3 = getContext();
        boolean r4 = this.o.booleanValue();
        String r5 = this.p;
        String r6 = this.s;
        boolean r13 = this.r;
        s r14 = new s(r1, this, r3, r4, r5, r6, r13, this.q, this.t);
        n r7 = new n(new k(), r14, this.m, this.n, r13, new f(this));
        this.l = r7;
        r7.create();
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        View r5 = r2.inflate(2131561237, r3, false);
        this.k = r5;
        return r5;
    }

    public static void da0(final FragmentActivity r12, final String r13, final String r14, final boolean r15, final String r16, final boolean r17, final String r18, final boolean r19, final View.OnClickListener r20) {
        Lifecycle.State r0 = r12.getLifecycle().getCurrentState();
        if (r0.isAtLeast(Lifecycle.State.RESUMED) == true) goto L7;
        tt5.a.h("QuotaFragment", "show()...illegal state = " + r0.name());
        return;
    L7:
        if ((System.currentTimeMillis() - u) > BaseKeyboardHeightProducer.CONFIGURATION_CHANGED_WAIT_MAX_INTERVAL) goto L11;
        tt5.a.h("QuotaFragment", "show()...has showed just now");
        return;
    L11:
        if (r12.getSupportFragmentManager().findFragmentByTag("QuotaFragment") == null) goto L14;
        tt5.a.h("QuotaFragment", "show()...fragment already added");
        return;
    L14:
        u = System.currentTimeMillis();
        com.bytedance.ee.util.ui.j.f(new d(r13, r14, r15, r16, r17, r19, r18, r12, r20));
    }
}
