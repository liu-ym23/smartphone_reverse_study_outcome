package com.bytedance.ee.bear.lark.dependency;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.ss.android.lark.passportc.entity.UserSession;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface c0 {

    public interface a {
        void onCancel();

        void onConfirm();
    }

    void D1(Fragment r1, UserSession r2, String r3, String r4, String r5, String r6, a r7);

    void Wb(FragmentActivity r1, FragmentManager r2, UserSession r3, String r4, String r5, String r6, String r7, a r8);

    void eb(Context r1, String r2, String r3, boolean r4);

    Pair<Fragment, r1c.a> j4(UserSession r1, String r2, String r3);

    void onDestroy();
}
