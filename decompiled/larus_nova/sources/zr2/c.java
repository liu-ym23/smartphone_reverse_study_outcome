package zr2;

import com.bytedance.android.livesdk.revenue.toolbar.RevToolbarButton;
import kotlin.Deprecated;

/* JADX INFO: loaded from: classes11.dex */
public interface c {
    void a(RevToolbarButton r100, n r101);

    @Deprecated(message = "toolbar实验结束后将由服务端控制其显隐性")
    void b(RevToolbarButton r100);

    void c(RevToolbarButton r100, k r101);

    @Deprecated(message = "toolbar实验结束后将由服务端控制其显隐性")
    void d(RevToolbarButton r100);

    void e(RevToolbarButton r100, k r101);

    boolean f(RevToolbarButton r100);
}
