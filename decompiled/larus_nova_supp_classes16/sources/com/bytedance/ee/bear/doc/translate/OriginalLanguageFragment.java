package com.bytedance.ee.bear.doc.translate;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.browser.plugin.q;
import sa5.v;
import sa5.w;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class OriginalLanguageFragment extends Fragment implements w, View.OnLayoutChangeListener {
    public static final /* synthetic */ int i = 0;
    public TranslateViewModel d;
    public TextView e;
    public v f;
    public final int[] g;
    public final d h;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.ee.bear.doc.translate.d] */
    public OriginalLanguageFragment() {
        this.g = new int[2];
        this.h = new d(this);
    }

    public final void onDestroyView() {
        super.onDestroyView();
        if (getView() == null) goto L5;
        getView().removeOnLayoutChangeListener(this);
    L5:
        v r0 = this.f;
        if (r0 == null) goto L8;
        r0.b(this);
        this.f = null;
    L8:
        com.bytedance.ee.util.ui.j.e(this.h);
    }

    static {
    }

    public final void onCreate(Bundle r1) {
        super.onCreate(r1);
        getActivity();
        this.d = (TranslateViewModel) q.a(this, TranslateViewModel.class);
    }

    @Override // sa5.w
    public final boolean u70(MotionEvent r4) {
        View r0 = getView();
        if (r0 != null) goto L5;
        return false;
    L5:
        r0.getLocationInWindow(this.g);
        if (r4.getY() >= this.g[1]) goto L9;
        this.d.setActiveOriginal(null);
        return true;
    L9:
        return false;
    }

    public final void onViewCreated(final View r2, Bundle r3) {
        super.onViewCreated(r2, r3);
        this.e = (TextView) r2.findViewById(2131381680);
        this.d.getActiveOriginal().observe(this, new c(this, r2));
        v r4 = (v) sa5.m.a.a(getActivity(), v.class);
        this.f = r4;
        if (r4 == null) goto L6;
        r4.c(this);
        return;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        return r2.inflate(2131564149, r3, false);
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        com.bytedance.ee.util.ui.j.e(this.h);
        com.bytedance.ee.util.ui.j.d(this.h, 30);
    }
}
