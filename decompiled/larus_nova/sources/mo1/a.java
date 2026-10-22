package mo1;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.bytedance.android.livehostapi.foundation.IHostFrescoHelper;
import com.bytedance.android.livesdk.chatroom.ui.livesticker.adapter.RoomStickerDecorationImageViewHolder;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes8.dex */
public final class a implements IHostFrescoHelper.GetBitmapCallBack {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RoomStickerDecorationImageViewHolder f514581a;

    @Override // com.bytedance.android.livehostapi.foundation.IHostFrescoHelper.GetBitmapCallBack
    public final void fail(IHostFrescoHelper.BitmapDataSource r100) {
    }

    public a(RoomStickerDecorationImageViewHolder r100) {
        this.f514581a = r100;
    }

    @Override // com.bytedance.android.livehostapi.foundation.IHostFrescoHelper.GetBitmapCallBack
    public final void onNewResultImpl(Bitmap r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        ImageView r101 = this.f514581a.f113691a;
        if (r101 == null) goto L7;
        r101.setImageBitmap(r100.copy(Bitmap.Config.ARGB_8888, false));
    L7:
        this.f514581a.itemView.setTag(R.id.ttlive_decoration_view_height, Integer.valueOf(r100.getHeight()));
    }
}
