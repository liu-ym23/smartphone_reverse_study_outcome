package w4b;

import com.bytedance.lark.pb.basic.v1.PreviewHangPoint;
import com.ss.android.lark.core.keyboard.KeyboardBaseModuleDependencyImpl;
import com.ss.android.lark.export.entity.UrlCardPreviewEntity;
import java.util.List;
import java.util.Map;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes35.dex */
public interface f {
    Object a(List<PreviewHangPoint> r100, Continuation<? super Map<String, UrlCardPreviewEntity>> r101);

    void b();

    xcb.a c(Map<String, wxa.e> r100);

    void d(String r100, long r101, long r102, KeyboardBaseModuleDependencyImpl.C118301 r103);
}
