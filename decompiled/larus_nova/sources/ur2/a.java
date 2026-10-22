package ur2;

import android.text.Spannable;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.livesdk.revenue.text.RevRenderConfig;
import kotlin.Deprecated;

/* JADX INFO: loaded from: classes11.dex */
public interface a extends dy0.a {
    @Deprecated(message = "该方法在加载图片资源时存在异步加载的问题，建议使用loadText方法")
    Spannable Lf(a5 r100, String r101);

    CharSequence Q9(a5 r100);

    void a4(a5 r100, RevRenderConfig r101, yr2.a r102);
}
