package kf5;

import android.view.View;
import com.bytedance.ee.bear.drive.biz.comment.DriveCommentWrapper$7;
import com.bytedance.ee.bear.drive.biz.comment.e1;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentInputRequest;
import com.bytedance.ee.bear.middleground.comment.export.bean.SmartReplyDataForInsert;
import com.bytedance.ee.bear.middleground.comment.input.b2;
import com.bytedance.ee.bear.middleground.comment.widget.CommentEditText;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public interface b {
    void a(String r100);

    void b();

    void c(String r100);

    void d(boolean r100, boolean r101);

    void destroy();

    CommentEditText e();

    b2 f();

    void g(String r100, DriveCommentWrapper$7 r101);

    View getRootView();

    void h(boolean r100, boolean r101, boolean r102, boolean r103, boolean r104);

    CommentInputRequest i();

    boolean isShowing();

    void j(List<String> r100);

    void k(String r100, boolean r101, ArrayList<String> r102);

    void l();

    void m(List r100, e1 r101);

    void n(SmartReplyDataForInsert r100);

    void o(List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r100);

    void p(CommentInputRequest r100);

    void q(boolean r100);

    void r(String r100);

    void s();

    int t();

    void update(boolean r100);
}
