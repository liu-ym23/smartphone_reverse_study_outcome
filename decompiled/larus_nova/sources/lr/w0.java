package lr;

import com.bytedance.android.ecom.service_annotation.ServiceDefaultImpl;
import com.facebook.drawee.view.GenericDraweeView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.common.Priority;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@ServiceDefaultImpl
public final class w0 implements yj.l {
    public w0() {
    }

    @Override // yj.l
    public final void e() {
    }

    @Override // yj.l
    public final void initFirstScreenImageRecord() {
    }

    @Override // yj.l
    public final Map<String, BufferedDiskCache> c() {
        yj.l.f568006a.getClass();
        return yj.l.a.f568007a;
    }

    @Override // yj.l
    public final void d(GenericDraweeView r100, String r101, HashMap r102) {
        Intrinsics.checkNotNullParameter(r100, "draweeView");
        Intrinsics.checkNotNullParameter(r101, "url");
        Intrinsics.checkNotNullParameter(r102, "monitor");
    }

    @Override // yj.l
    public final void f(SimpleDraweeView r100, String r101, HashMap r102) {
        Intrinsics.checkNotNullParameter(r100, "draweeView");
        Intrinsics.checkNotNullParameter(r101, "url");
        Intrinsics.checkNotNullParameter(r102, "monitor");
    }

    @Override // yj.l
    public final void g(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "bizTag");
        Intrinsics.checkNotNullParameter(r102, "sceneTag");
    }

    @Override // yj.l
    public final void a(List r100, Priority r101, String r102, String r103, HashMap r104) {
        Intrinsics.checkNotNullParameter(r100, "images");
        Intrinsics.checkNotNullParameter(r101, "priority");
        Intrinsics.checkNotNullParameter(r102, "bizTag");
        Intrinsics.checkNotNullParameter(r103, "sceneTag");
        Intrinsics.checkNotNullParameter(r104, "monitor");
    }

    @Override // yj.l
    public final void b(String r100, Priority r101, String r102, String r103, HashMap r104) {
        Intrinsics.checkNotNullParameter(r100, "imageUrl");
        Intrinsics.checkNotNullParameter(r101, "priority");
        Intrinsics.checkNotNullParameter(r102, "bizTag");
        Intrinsics.checkNotNullParameter(r103, "sceneTag");
        Intrinsics.checkNotNullParameter(r104, "monitor");
    }
}
