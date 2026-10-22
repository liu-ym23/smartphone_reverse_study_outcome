package oa2;

import android.graphics.Bitmap;
import android.view.ViewGroup;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livehostapi.foundation.IHostFrescoHelper;
import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.carnival.ui.ChatCarnivalView;

/* JADX INFO: loaded from: classes9.dex */
public final class e implements IHostFrescoHelper.GetBitmapCallBack {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ChatCarnivalView f522539a;

    public e(ChatCarnivalView r100) {
        this.f522539a = r100;
    }

    @Override // com.bytedance.android.livehostapi.foundation.IHostFrescoHelper.GetBitmapCallBack
    public final void fail(IHostFrescoHelper.BitmapDataSource r100) {
        ALogger.e("ChatCarnivalView", "load title image failed when warmup");
    }

    @Override // com.bytedance.android.livehostapi.foundation.IHostFrescoHelper.GetBitmapCallBack
    public final void onNewResultImpl(Bitmap r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isRecycled() == true) goto L24;
        Bitmap r101 = r100.copy(Bitmap.Config.ARGB_8888, false);
        if (r101 != null) goto L10;
        return;
    L10:
        if (r101.isRecycled() == true) goto L25;
        this.f522539a.f139754i.setImageBitmap(r101);
        int r102 = r101.getHeight() / 26;     // Catch: Exception -> L17
        if (r102 == 0) goto L18;
        int r103 = s1.f(r101.getWidth() / r102);     // Catch: Exception -> L17
        ViewGroup.LayoutParams r104 = this.f522539a.f139754i.getLayoutParams();     // Catch: Exception -> L17
        r104.width = r103;     // Catch: Exception -> L17
        this.f522539a.f139754i.setLayoutParams(r104);     // Catch: Exception -> L17
    L18:
        ALogger.i("ChatCarnivalView", "load title image success when warmup");
        return;
    L17:
        ALogger.e("ChatCarnivalView", "calculate image size error");
        goto L18
    L25:
        return;
    }
}
