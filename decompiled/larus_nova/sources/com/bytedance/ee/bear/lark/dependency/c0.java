package com.bytedance.ee.bear.lark.dependency;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.ss.android.lark.passportc.entity.UserSession;
import kotlin.Pair;

/* JADX INFO: loaded from: classes16.dex */
public interface c0 {

    public interface a {
        void onCancel();

        void onConfirm();
    }

    void D1(Fragment r100, UserSession r101, String r102, String r103, String r104, String r105, a r106);

    void Wb(FragmentActivity r100, FragmentManager r101, UserSession r102, String r103, String r104, String r105, String r106, a r107);

    void eb(Context r100, String r101, String r102, boolean r103);

    Pair<Fragment, r1c.a> j4(UserSession r100, String r101, String r102);

    void onDestroy();
}
