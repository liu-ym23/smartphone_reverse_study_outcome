package ze5;

import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.export.draft.DraftEntity;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public interface b {
    DraftEntity a(String r100);

    void b(String r100, List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r101);

    void c(String r100, List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r101);

    void d(String r100, String r101);

    void e(String r100, DraftEntity r101);
}
