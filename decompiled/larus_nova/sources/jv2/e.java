package jv2;

import android.graphics.drawable.Drawable;
import com.bytedance.android.livesdk.widget.crop.CustomThemeCropFragment;
import com.bytedance.android.livesdkapi.depend.model.live.audio.ThemeShowArea;
import com.bytedance.android.livesdkapi.depend.model.live.audio.ThemeUpLoadListener;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;

/* JADX INFO: loaded from: classes11.dex */
public interface e {
    void a(boolean r100);

    void b(String r100, ThemeShowArea r101, CustomThemeCropFragment.g r102);

    void c(PolarisFileWrapper r100, ThemeUpLoadListener r101, int r102);

    void d(Drawable r100, String r101);

    void e(Throwable r100);

    void f(String r100, String r101, String r102);
}
