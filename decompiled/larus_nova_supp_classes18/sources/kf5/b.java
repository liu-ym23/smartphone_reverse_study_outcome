package kf5;

import android.view.View;
import com.bytedance.ee.bear.drive.biz.comment.DriveCommentWrapper;
import com.bytedance.ee.bear.drive.biz.comment.e1;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentInputRequest;
import com.bytedance.ee.bear.middleground.comment.export.bean.SmartReplyDataForInsert;
import com.bytedance.ee.bear.middleground.comment.input.b2;
import com.bytedance.ee.bear.middleground.comment.widget.CommentEditText;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface b {
    void a(String r1);

    void b();

    void c(String r1);

    void d(boolean r1, boolean r2);

    void destroy();

    CommentEditText e();

    b2 f();

    void g(String r1, DriveCommentWrapper.7 r2);

    View getRootView();

    void h(boolean r1, boolean r2, boolean r3, boolean r4, boolean r5);

    CommentInputRequest i();

    boolean isShowing();

    void j(List<String> r1);

    void k(String r1, boolean r2, ArrayList<String> r3);

    void l();

    void m(List r1, e1 r2);

    void n(SmartReplyDataForInsert r1);

    void o(List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r1);

    void p(CommentInputRequest r1);

    void q(boolean r1);

    void r(String r1);

    void s();

    int t();

    void update(boolean r1);
}
