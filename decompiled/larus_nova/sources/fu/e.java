package fu;

import android.view.View;
import com.bytedance.android.gamecp.common.track.GamecpTracker;
import com.facebook.imagepipeline.image.ImageInfo;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import java.util.HashMap;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes44.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f478835a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f478836b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ImageInfo f478837c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f478838d;

    public e(View r100, View r101, ImageInfo r102, String r103) {
        this.f478835a = r100;
        this.f478836b = r101;
        this.f478837c = r102;
        this.f478838d = r103;
    }

    public final void a() {
        LocalTestManager.a(new Class[]{uv.a.class});
        LocalTestManager.a(new Class[]{uv.a.class});
        if ((this.f478835a.getWidth() * 4) >= this.f478837c.getWidth()) goto L5;
    L6:
        LinkedHashMap r100 = new LinkedHashMap();
        r100.put("image_url", this.f478838d);
        r100.put("target_width", String.valueOf(this.f478835a.getWidth()));
        r100.put("target_height", String.valueOf(this.f478835a.getHeight()));
        r100.put("image_real_width", String.valueOf(this.f478837c.getWidth()));
        r100.put("image_real_height", String.valueOf(this.f478837c.getHeight()));
        HashMap<String, String> r101 = GamecpTracker.f56755a;
        GamecpTracker.z(null, "dygame_tech_cloud_image_size_error", r100);
        return;
    L5:
        if ((this.f478835a.getHeight() * 4) < this.f478837c.getHeight()) goto L6;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
