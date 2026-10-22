package com.ss.android.lark.contact.base.contact_search;

import android.app.Activity;
import com.larksuite.framework.mvp.IView;
import com.ss.android.lark.profile.dto.ProfileFinishResult;
import java.util.List;

/* JADX INFO: loaded from: classes35.dex */
public interface b extends IView<a> {

    public interface a extends IView.IViewDelegate {
        void H4();

        String getUniqueId();

        void v3(String r100, boolean r101);

        void x0(String r100);
    }

    void A3();

    void F2();

    void M0(String r100);

    void N5();

    void O5(ProfileFinishResult r100);

    void V1();

    Activity getActivity();

    void i0();

    void l2();

    void showToast(String r100);

    void v8(String r100);

    void y4(List<? extends bec.a> r100);
}
