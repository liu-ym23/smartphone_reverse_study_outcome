package g7c;

import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.bytedance.lark.pb.basic.v1.UrlPreviewEntity;
import com.bytedance.lark.pb.basic.v1.UrlPreviewHangPoint;
import com.ss.android.lark.export.entity.PreviewHangPoint;
import com.ss.android.lark.export.entity.UrlCardPreviewEntity;
import com.ss.android.lark.export.entity.preview.UrlInlinePreviewEntity;
import com.ss.android.lark.todo.impl.rustadapter.service.TodoRustCommon$getPreviewEntityByURLNew$2$1;
import com.ss.android.lark.widget.richtext.RichText;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes38.dex */
public interface u {
    Map a();

    UrlInlinePreviewEntity b(UrlPreviewEntity r100);

    Map<String, Map<String, UrlCardPreviewEntity>> c(Map<String, ? extends List<UrlPreviewHangPoint>> r100, SyncDataStrategy r101);

    void d(String r100, TodoRustCommon$getPreviewEntityByURLNew$2$1 r101);

    void transformRichTextByPreview(RichText r100, Map<String, PreviewHangPoint> r101);
}
