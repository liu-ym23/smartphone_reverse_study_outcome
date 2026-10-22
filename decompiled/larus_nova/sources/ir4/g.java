package ir4;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.bitable.card.model.stmodel.cell.AttachmentEntity;
import com.bytedance.ee.bear.bitable.celleditor.model.upload.DocumentInfo;
import com.bytedance.ee.bear.bitable.celleditor.model.upload.TargetCellInfo;
import java.util.List;

/* JADX INFO: loaded from: classes15.dex */
public interface g {
    void a(TargetCellInfo r100, String r101, List<? extends AttachmentEntity> r102);

    boolean b();

    DocumentInfo d();

    FragmentActivity p0();
}
