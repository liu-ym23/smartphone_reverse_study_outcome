package ykb;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.image.uploader.entity.ImageUploadTask;
import com.ss.android.lark.image.uploader.utils.c;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f568290b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageUploadTask f568291a;

    /* JADX INFO: renamed from: ykb.a$a, reason: collision with other inner class name */
    public static final class C8350a {
        @JvmStatic
        public static a a(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return new a(new ImageUploadTask(r100));
        }
    }

    static {
    }

    public final void c() {
        ArrayList<com.ss.android.lark.image.uploader.entity.b> r100 = this.f568291a.f426376b;
        boolean r101 = false;
        if (r100.isEmpty() == false) goto L5;
        c.b("ImageUploader", "uploadImage is empty", null, false);
    L15:
        if (r101 == true) goto L20;
        dlb.a r102 = this.f568291a.f426380f;
        if (r102 == null) goto L29;
        r102.d();
        return;
    L29:
        return;
    L20:
        ExecutorService r103 = elb.b.f473036a;
        ImageUploadTask r104 = this.f568291a;
        Intrinsics.checkNotNullParameter(r104, "uploadTask");
        if (r104.f426382h == false) goto L23;
        elb.b.f473036a.execute(new elb.a(r104));
        return;
    L23:
        elb.b.a(r104);
        return;
    L5:
        Iterator<com.ss.android.lark.image.uploader.entity.b> r105 = r100.iterator();
    L7:
        if (r105.hasNext() == false) goto L14;
        String r106 = r105.next().f426387a;
        if (TextUtils.isEmpty(r106) == true) goto L10;
        if (new PolarisFileWrapper(r106).exists() == true) goto L7;
        c.b("ImageUploader", "filePath is not exist", null, false);
        goto L15
    L10:
        c.b("ImageUploader", "filePath is empty", null, false);
        goto L15
    L14:
        r101 = true;
        goto L15
    }

    public a(ImageUploadTask r100) {
        Intrinsics.checkNotNullParameter(r100, "task");
        this.f568291a = r100;
    }

    public final void a(dlb.b r100) {
        ImageUploadTask r101 = this.f568291a;
        r101.getClass();
        r101.f426380f = new dlb.a(r100);
    }

    public final void b(com.ss.android.lark.image.uploader.entity.b r100) {
        Intrinsics.checkNotNullParameter(r100, "image");
        ImageUploadTask r101 = this.f568291a;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "image");
        r101.f426376b.add(r100);
    }
}
