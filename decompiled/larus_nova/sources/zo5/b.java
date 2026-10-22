package zo5;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.watermark.interfaces.CCMWatermarkInfo;
import com.ss.android.lark.vfs.VFSPath;
import com.ss.android.lark.watermark.core.IAttachToBitmapCallback;
import com.ss.android.lark.watermark.core.IGetWaterMarkResourceCallback;
import com.ss.android.lark.watermark.core.WatermarkPointContext;
import com.ss.android.lark.watermark.core.WatermarkType;
import com.ss.android.lark.watermark.dto.WatermarkData;
import com.ss.android.lark.watermark.dto.WatermarkInfo;
import io.reactivex.Single;
import okio.ByteString;

/* JADX INFO: loaded from: classes18.dex */
public interface b {
    CCMWatermarkInfo a();

    void b(WatermarkInfo r100);

    void c(Bitmap r100, IAttachToBitmapCallback r101);

    void d(Dialog r100);

    void detachWatermark(FrameLayout r100);

    Single<VFSPath> e(String r100);

    void f(Bitmap r100, IAttachToBitmapCallback r101, WatermarkType r102, WatermarkPointContext r103);

    void g(String r100, int r101);

    WatermarkData getWatermarkData(WatermarkType r100);

    void h(String r100, int r101);

    void i(String r100, IGetWaterMarkResourceCallback r101);

    void init(Context r100);

    void j(String r100, int r101, Dialog r102);

    Single<ByteString> k(ByteString r100);

    void l(String r100, int r101, FrameLayout r102);

    a m();

    void n(FragmentActivity r100);

    void o(String r100, int r101, FragmentActivity r102);

    void p(FrameLayout r100);

    void q(FragmentActivity r100);

    void r(FragmentActivity r100);

    void s(Dialog r100);
}
