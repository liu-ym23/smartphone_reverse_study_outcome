package sza;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.larus.feishu.office.im.impl.docpreview.MessageDocPreviewServiceImpl$getPreviewEntities$1;
import com.larus.home.impl.sdk.office.FlowOfficeUrlPreviewHostService;
import com.ss.android.lark.integrator.im.impl.preview.OfficeUrlPreviewPageServiceImpl;
import java.util.List;

/* JADX INFO: loaded from: classes34.dex */
public interface c {
    void a(List r100, SyncDataStrategy r101, MessageDocPreviewServiceImpl$getPreviewEntities$1 r102);

    OfficeUrlPreviewPageServiceImpl b(Context r100, LifecycleOwner r101, kc9.a r102, FlowOfficeUrlPreviewHostService.b r103);
}
