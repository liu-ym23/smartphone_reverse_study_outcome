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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface b {
    CCMWatermarkInfo a();

    void b(WatermarkInfo r1);

    void c(Bitmap r1, IAttachToBitmapCallback r2);

    void d(Dialog r1);

    void detachWatermark(FrameLayout r1);

    Single<VFSPath> e(String r1);

    void f(Bitmap r1, IAttachToBitmapCallback r2, WatermarkType r3, WatermarkPointContext r4);

    void g(String r1, int r2);

    WatermarkData getWatermarkData(WatermarkType r1);

    void h(String r1, int r2);

    void i(String r1, IGetWaterMarkResourceCallback r2);

    void init(Context r1);

    void j(String r1, int r2, Dialog r3);

    Single<ByteString> k(ByteString r1);

    void l(String r1, int r2, FrameLayout r3);

    a m();

    void n(FragmentActivity r1);

    void o(String r1, int r2, FragmentActivity r3);

    void p(FrameLayout r1);

    void q(FragmentActivity r1);

    void r(FragmentActivity r1);

    void s(Dialog r1);
}
