package com.bytedance.ee.bear.middleground.feed.export.bean;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.Notice;
import java.util.Map;
import l15.l;
import uf5.q0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface h {

    public interface a {
    }

    q0 a(String r1, sbb.e r2);

    gg5.a b(FragmentActivity r1, Fragment r2, ViewGroup r3, l r4, MessageConfig r5, vf5.b r6);

    com.bytedance.ee.bear.middleground.feed.b.a c(String r1, sbb.e r2, com.bytedance.ee.bear.document.feed.f r3);

    void d(Map<String, Object> r1);

    boolean e(String r1);

    void f();

    void g(Notice r1, Boolean r2);

    void h();

    boolean i(String r1, Map<String, String> r2);

    void j(Notice r1);

    com.bytedance.ee.bear.middleground.feed.a k(b r1);
}
