package l2a;

import com.larus.flow.video.bean.CommonVideoModel;
import com.larus.network.http.AsyncThrowable;
import com.larus.platform.uimodel.MediaEntityContainer;
import com.larus.video.impl.widget.VideoViewHolder;

/* JADX INFO: loaded from: classes32.dex */
public final class n implements CommonVideoModel.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommonVideoModel.b f507180a;

    @Override // com.larus.flow.video.bean.CommonVideoModel.b
    public final void b(AsyncThrowable r100) {
    }

    public n(VideoViewHolder.b r100) {
        this.f507180a = r100;
    }

    @Override // com.larus.flow.video.bean.CommonVideoModel.b
    public final void a(MediaEntityContainer r100) {
        CommonVideoModel.b r101 = this.f507180a;
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }
}
