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
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public class ExceedQuotaFragment extends CompatLandscapeBottomSheetDialogFragment {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static long f236298u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final /* synthetic */ int f236299v = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public View f236300k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public n f236301l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f236302m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f236303n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Boolean f236304o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f236305p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f236306q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f236307r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f236308s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public View.OnClickListener f236309t;

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment
    public final boolean ba0() {
        return true;
    }

    public ExceedQuotaFragment() {
        this.f236308s = "";
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        n r100 = this.f236301l;
        if (r100 == null) goto L6;
        r100.destroy();
        return;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsSheetDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Bundle r101 = getArguments();
        if (r101 == null) goto L6;
        this.f236302m = r101.getString("key_mount_node_token");
        this.f236303n = r101.getString("key_mount_point");
        this.f236304o = Boolean.valueOf(r101.getBoolean("key_is_folder"));
        this.f236305p = r101.getString("key_reason");
        this.f236306q = r101.getBoolean("key_cancel_outside", true);
        this.f236307r = r101.getBoolean("key_is_department", false);
        this.f236308s = r101.getString("key_custom_extra_hint", "");
        return;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.CompatLandscapeBottomSheetDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment, com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle r100) {
        Dialog r101 = super.onCreateDialog(r100);
        r101.setCanceledOnTouchOutside(this.f236306q);
        r101.setCancelable(this.f236306q);
        setCancelable(this.f236306q);
        return r101;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        super.onViewCreated(r110, r111);
        View r100 = this.f236300k;
        Context r101 = getContext();
        boolean r102 = this.f236304o.booleanValue();
        String r103 = this.f236305p;
        String r104 = this.f236308s;
        boolean r112 = this.f236307r;
        s r113 = new s(r100, this, r101, r102, r103, r104, r112, this.f236306q, this.f236309t);
        n r105 = new n(new k(), r113, this.f236302m, this.f236303n, r112, new f(this));
        this.f236301l = r105;
        r105.create();
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        View r103 = r100.inflate(R.layout.fragment_quota_layout, r101, false);
        this.f236300k = r103;
        return r103;
    }

    public static void da0(final FragmentActivity r110, final String r111, final String r112, final boolean r113, final String r114, final boolean r115, final String r116, final boolean r117, final View.OnClickListener r210) {
        Lifecycle.State r100 = r110.getLifecycle().getCurrentState();
        if (r100.isAtLeast(Lifecycle.State.RESUMED) == true) goto L7;
        tt5.a.h("QuotaFragment", "show()...illegal state = " + r100.name());
        return;
    L7:
        if ((System.currentTimeMillis() - f236298u) > 2000) goto L11;
        tt5.a.h("QuotaFragment", "show()...has showed just now");
        return;
    L11:
        if (r110.getSupportFragmentManager().findFragmentByTag("QuotaFragment") == null) goto L14;
        tt5.a.h("QuotaFragment", "show()...fragment already added");
        return;
    L14:
        f236298u = System.currentTimeMillis();
        com.bytedance.ee.util.ui.j.f(new d(r111, r112, r113, r114, r115, r117, r116, r110, r210));
    }
}
