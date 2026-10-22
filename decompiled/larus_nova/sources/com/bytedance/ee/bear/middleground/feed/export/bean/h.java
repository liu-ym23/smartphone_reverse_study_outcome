package com.bytedance.ee.bear.middleground.feed.export.bean;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.Notice;
import java.util.Map;
import l15.l;
import uf5.q0;

/* JADX INFO: loaded from: classes18.dex */
public interface h {

    public interface a {
    }

    q0 a(String r100, sbb.e r101);

    gg5.a b(FragmentActivity r100, Fragment r101, ViewGroup r102, l r103, MessageConfig r104, vf5.b r105);

    com.bytedance.ee.bear.middleground.feed.b.a c(String r100, sbb.e r101, com.bytedance.ee.bear.document.feed.f r102);

    void d(Map<String, Object> r100);

    boolean e(String r100);

    void f();

    void g(Notice r100, Boolean r101);

    void h();

    boolean i(String r100, Map<String, String> r101);

    void j(Notice r100);

    com.bytedance.ee.bear.middleground.feed.a k(b r100);
}
