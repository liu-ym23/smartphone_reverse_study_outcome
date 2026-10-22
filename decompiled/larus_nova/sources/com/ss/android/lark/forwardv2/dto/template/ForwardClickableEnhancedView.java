package com.ss.android.lark.forwardv2.dto.template;

import android.app.Activity;
import android.text.Editable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: classes36.dex */
public interface ForwardClickableEnhancedView extends ForwardEnhancedView {

    public interface a {
        void a(boolean r100);
    }

    public interface b {
        void a(String r100);
    }

    boolean e0();

    void f(Activity r100, ConstraintLayout r101, BasicDialogContent r102);

    void k1(Editable r100);

    void l(a r100, b r101);

    boolean n0();

    void onDestroy();

    void s0(Fragment r100);

    void t1(Activity r100, ConstraintLayout r101);
}
