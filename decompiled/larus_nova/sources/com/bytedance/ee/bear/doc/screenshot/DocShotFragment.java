package com.bytedance.ee.bear.doc.screenshot;

import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.lifecycle.Lifecycle;
import com.bytedance.ee.bear.bizwidget.dialogfragment.BaseDialogFragment;
import com.bytedance.ee.bear.contract.m;
import com.bytedance.ee.bear.domain.BearUrl;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import fz4.b0;
import fz4.c0;
import java.util.HashMap;

/* JADX INFO: loaded from: classes16.dex */
public class DocShotFragment extends BaseDialogFragment {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ int f218061r = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public DocShotView f218062h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f218063i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public DocShotPresenter f218064j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public WebView f218065k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public BearUrl f218066l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f218067m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f218068n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public m.b f218069o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f218070p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public a f218071q;

    public interface a {
    }

    public DocShotFragment() {
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        this.f218062h.onConfigurationChanged(r100);
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        DocShotPresenter r101 = this.f218064j;     // Catch: Throwable -> L11
        if (r101 == null) goto L5;
        r101.k();     // Catch: Throwable -> L11
    L5:
        a r102 = this.f218071q;     // Catch: Throwable -> L11
        if (r102 == null) goto L8;
        SnapshotPlugin.c(((c0) r102).f479360a);     // Catch: Throwable -> L11
    L8:
        super.onDismiss(r100);     // Catch: Throwable -> L11
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L11:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        DocShotView r103 = (DocShotView) r100.inflate(R.layout.doc_screen_shot_layout, r101, false);
        this.f218062h = r103;
        r103.setSourceInfo(this.f218067m);
        tt5.a.h("DocShotFragment", "onRequestSnapshot()... ");
        if (getActivity().getLifecycle().getCurrentState() == Lifecycle.State.RESUMED) goto L5;
        tt5.a.k("DocShotFragment", "onRequestSnapshot, activity is not RESUMED");
    L27:
        return this.f218062h;
    L5:
        DocShotPresenter r104 = new DocShotPresenter(getActivity(), this.f218063i);
        this.f218064j = r104;
        r104.f218074c = this.f218069o;
        String r105 = this.f218068n;
        if (TextUtils.isEmpty(r105) == false) goto L9;
        r104.f218084m = null;
    L15:
        DocShotPresenter r106 = this.f218064j;
        r106.f218089r = new fz4.b(this);
        r106.f218085n = this.f218070p;
        WebView r107 = this.f218065k;
        DocShotView r108 = this.f218062h;
        BearUrl r109 = this.f218066l;
        r106.f218087p = System.currentTimeMillis();
        r106.f218073b.setValue(Boolean.TRUE);
        r106.f218086o = false;
        if (r107 == null) goto L27;
        if (r109 == null) goto L27;
        if (r108 == null) goto L27;
        String r110 = r109.f222564e;
        r106.f218081j = r110;
        r106.f218082k = r109.f222561b;
        r106.f218083l = r109.f222560a;
        r106.f218077f = r108;
        r108.setShareUrl(r110);
        ((View) r106.f218077f).setVisibility(0);
        r106.f218077f.setDocShotPresenter(r106);
        r106.f218077f.setActivity(r106.f218076e);
        b0 r111 = r106.f218077f;
        ((DocShotView) r111).f218099d.setTitle(r106.f218085n);
        r106.j(0, r107);
        b0 r112 = r106.f218077f;
        if (r112 == null) goto L23;
        ((DocShotView) r112).d();
    L23:
        if (r106.f218090s == false) goto L25;
        r106.f218094w = r107.getScrollY();
        r107.scrollTo(0, 0);
    L25:
        com.bytedance.ee.bear.contract.d r113 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class);
        HashMap<String, Object> r114 = r113.m("docCommonParams");
        r113.n("ccm_space_docs_topbar_view", r114);
        tt5.a.b("DocShotPresenter", "reportTopBarViewEvent, params = " + r114);
        goto L27
    L9:
        if ("summary".equals(r105) == false) goto L11;
    L14:
        r104.f218084m = r105;
        goto L15
    L11:
        if ("transcript".equals(r105) == true) goto L14;
        tt5.a.k("DocShotPresenter", "ignore invalid exportType: " + r105);
        r104.f218084m = null;
        goto L15
    }
}
