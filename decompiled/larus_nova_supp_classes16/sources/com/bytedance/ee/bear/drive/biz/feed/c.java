package com.bytedance.ee.bear.drive.biz.feed;

import android.content.res.Configuration;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface c {

    public interface a {
        void a(int r1);
    }

    void a(boolean r1, boolean r2);

    void attach();

    void c();

    void d(DriveFeedPlugin.b r1);

    void detach();

    void e(Configuration r1);

    void f();

    void g(List<String> r1);
}
