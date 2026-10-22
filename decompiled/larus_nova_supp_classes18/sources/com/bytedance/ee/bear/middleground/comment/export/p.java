package com.bytedance.ee.bear.middleground.comment.export;

import com.bytedance.ee.bear.drive.biz.comment.f1;
import com.bytedance.ee.bear.middleground.comment.export.bean.VisibilityBean;
import com.bytedance.ee.bear.middleground.comment.export.commentsdk.bean.CommentMetadata;
import io.reactivex.Flowable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface p {
    Flowable<String> E(String r1, int r2, String r3);

    Flowable<String> H(String r1, VisibilityBean r2, String r3);

    void P();

    Flowable<String> a(String r1, int r2, String r3);

    Flowable<String> e(String r1);

    void m(String r1, boolean r2);

    void q(f1 r1);

    Flowable<String> t(String r1, int r2, String r3);

    void v(CommentMetadata[] r1);

    void w(String r1, Action r2);

    void x(String r1);
}
