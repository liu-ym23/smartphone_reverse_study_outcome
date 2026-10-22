package ze5;

import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.export.draft.DraftEntity;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface b {
    DraftEntity a(String r1);

    void b(String r1, List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r2);

    void c(String r1, List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r2);

    void d(String r1, String r2);

    void e(String r1, DraftEntity r2);
}
