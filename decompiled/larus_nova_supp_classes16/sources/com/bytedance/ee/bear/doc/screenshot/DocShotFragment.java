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
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import fz4.b0;
import fz4.c0;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DocShotFragment extends BaseDialogFragment {
    public static final /* synthetic */ int r = 0;
    public DocShotView h;
    public boolean i;
    public DocShotPresenter j;
    public WebView k;
    public BearUrl l;
    public String m;
    public String n;
    public m.b o;
    public String p;
    public a q;

    public interface a {
    }

    public DocShotFragment() {
    }

    public final void onConfigurationChanged(Configuration r2) {
        super/*androidx.fragment.app.Fragment*/.onConfigurationChanged(r2);
        this.h.onConfigurationChanged(r2);
    }

    public final void onDismiss(DialogInterface r2) {
        DocShotPresenter r0 = this.j;     // Catch: Throwable -> L11
        if (r0 == null) goto L5;
        r0.k();     // Catch: Throwable -> L11
    L5:
        a r1 = this.q;     // Catch: Throwable -> L11
        if (r1 == null) goto L8;
        SnapshotPlugin.c(((c0) r1).a);     // Catch: Throwable -> L11
    L8:
        super.onDismiss(r2);     // Catch: Throwable -> L11
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

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment
    public final View onCreateView(LayoutInflater r6, ViewGroup r7, Bundle r8) {
        DocShotView r9 = (DocShotView) r6.inflate(2131560094, r7, false);
        this.h = r9;
        r9.setSourceInfo(this.m);
        tt5.a.h("DocShotFragment", "onRequestSnapshot()... ");
        if (getActivity().getLifecycle().getCurrentState() == Lifecycle.State.RESUMED) goto L5;
        tt5.a.k("DocShotFragment", "onRequestSnapshot, activity is not RESUMED");
    L27:
        return this.h;
    L5:
        DocShotPresenter r10 = new DocShotPresenter(getActivity(), this.i);
        this.j = r10;
        r10.c = this.o;
        String r11 = this.n;
        if (TextUtils.isEmpty(r11) == false) goto L9;
        r10.m = null;
    L15:
        DocShotPresenter r12 = this.j;
        r12.r = new fz4.b(this);
        r12.n = this.p;
        WebView r13 = this.k;
        DocShotView r14 = this.h;
        BearUrl r2 = this.l;
        r12.p = System.currentTimeMillis();
        r12.b.setValue(Boolean.TRUE);
        r12.o = false;
        if (r13 == null) goto L27;
        if (r2 == null) goto L27;
        if (r14 == null) goto L27;
        String r3 = r2.e;
        r12.j = r3;
        r12.k = r2.b;
        r12.l = r2.a;
        r12.f = r14;
        r14.setShareUrl(r3);
        ((View) r12.f).setVisibility(0);
        r12.f.setDocShotPresenter(r12);
        r12.f.setActivity(r12.e);
        b0 r16 = r12.f;
        ((DocShotView) r16).d.setTitle(r12.n);
        r12.j(0, r13);
        b0 r17 = r12.f;
        if (r17 == null) goto L23;
        ((DocShotView) r17).d();
    L23:
        if (r12.s == false) goto L25;
        r12.w = r13.getScrollY();
        r13.scrollTo(0, 0);
    L25:
        com.bytedance.ee.bear.contract.d r18 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class);
        HashMap<String, Object> r19 = r18.m("docCommonParams");
        r18.n("ccm_space_docs_topbar_view", r19);
        tt5.a.b("DocShotPresenter", "reportTopBarViewEvent, params = " + r19);
        goto L27
    L9:
        if ("summary".equals(r11) == false) goto L11;
    L14:
        r10.m = r11;
        goto L15
    L11:
        if ("transcript".equals(r11) == true) goto L14;
        tt5.a.k("DocShotPresenter", "ignore invalid exportType: " + r11);
        r10.m = null;
        goto L15
    }
}
