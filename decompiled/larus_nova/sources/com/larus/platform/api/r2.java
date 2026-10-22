package com.larus.platform.api;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.larus.platform.uimodel.ArticleParam;
import com.larus.platform.uimodel.VideoParam;
import java.util.List;

/* JADX INFO: loaded from: classes31.dex */
public interface r2 {

    public interface a {
        View a(String r100);
    }

    void a(Context r100, Uri r101);

    void b(String r100, String r101);

    void c(List r100);

    v4 d(v r100, boolean r101);

    void e(Context r100, ArticleParam r101, Integer r102);

    String f(String r100);

    void g(PrefetchRecommendVideoParam r100);

    List<pr9.a> h(String r100, Integer r101);

    boolean i(String r100);

    boolean j(Uri r100);

    void k(String r100);

    void l(Context r100);

    void m(Context r100, ArticleParam r101, View r102);

    Object n(List r100);

    void o(k r100, boolean r101);

    void p(Context r100, String r101, VideoParam r102);

    int q();

    void r(Context r100, VideoParam r101, View r102, a r103);
}
