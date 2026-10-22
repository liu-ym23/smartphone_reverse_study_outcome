package com.bytedance.ee.bear.drive.biz.feed;

import android.content.res.Configuration;
import java.util.List;

/* JADX INFO: loaded from: classes16.dex */
public interface c {

    public interface a {
        void a(int r100);
    }

    void a(boolean r100, boolean r101);

    void attach();

    void c();

    void d(DriveFeedPlugin.b r100);

    void detach();

    void e(Configuration r100);

    void f();

    void g(List<String> r100);
}
