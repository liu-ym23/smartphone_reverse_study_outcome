package com.bytedance.locallife.poi.perf;

import android.graphics.Bitmap;
import com.bytedance.locallife.cube.Cube;
import com.bytedance.locallife.cube.api.i.ICubeGlobalListener;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.lynx.fresco.FrescoImagePrefetchHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class e implements com.bytedance.locallife.poi.perf.a {

    public static final class a extends BaseDataSubscriber<Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f263701a;

        @Override // com.facebook.datasource.BaseDataSubscriber
        public final void onFailureImpl(DataSource<Void> r100) {
            this.f263701a.getClass();
        }

        @Override // com.facebook.datasource.BaseDataSubscriber
        public final void onNewResultImpl(DataSource<Void> r100) {
            this.f263701a.getClass();
        }

        public a(e r100, String r101) {
            this.f263701a = r100;
        }
    }

    public e() {
    }

    @Override // com.bytedance.locallife.poi.perf.a
    public final void handle(Map<String, ? extends Object> r100) {
        Object r101 = r100.get("images");
        if ((r101 instanceof List) == false) goto L5;
        List r102 = (List) r101;
    L6:
        if (r102 != null) goto L8;
        return;
    L8:
        ArrayList r103 = new ArrayList();
        Iterator r104 = r102.iterator();
    L10:
        if (r104.hasNext() == false) goto L14;
        Object r105 = r104.next();
        if ((r105 instanceof String) == false) goto L10;
        r103.add(r105);
        goto L10
    L14:
        Iterator r106 = r103.iterator();
    L16:
        if (r106.hasNext() == false) goto L29;
        String r107 = (String) r106.next();
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L20
        kp6.a<ICubeGlobalListener> r109 = Cube.f257155a;     // Catch: Throwable -> L20
        Intrinsics.checkNotNullParameter(r107, "imageUrl");     // Catch: Throwable -> L20
        Object r110 = Result.m9449constructorimpl(FrescoImagePrefetchHelper.prefetchImageToBitmapCache(r107, Bitmap.Config.ARGB_8888, null));     // Catch: Throwable -> L20
    L23:
        if (Result.m9455isFailureimpl(r110) == false) goto L25;
        r110 = null;
    L25:
        DataSource r111 = (DataSource) r110;
        if (r111 == null) goto L16;
        r111.subscribe(new a(this, r107), UiThreadImmediateExecutorService.getInstance());
    L20:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r110 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L23
    L29:
        return;
    L5:
        r102 = null;
        goto L6
    }
}
