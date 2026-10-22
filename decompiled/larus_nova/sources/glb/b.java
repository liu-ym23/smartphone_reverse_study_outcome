package glb;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.appreciablelib.AppreciableKit;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.ErrorLevel;
import com.ss.android.lark.appreciablelib.ErrorParams;
import com.ss.android.lark.appreciablelib.ErrorType;
import com.ss.android.lark.appreciablelib.Event;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.image.uploader.utils.ImageInfo;
import com.ss.android.lark.monitor.perf.BasePerfMonitor;
import com.ss.android.lark.utils.ImageUtils;
import com.ss.mediakit.medialoader.AVMDLDataLoader;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class b extends BasePerfMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f481646a = null;

    static {
        f481646a = new b();
    }

    public b() {
    }

    public static void d(com.ss.android.lark.image.uploader.entity.b r100) {
        Intrinsics.checkNotNullParameter(r100, "uploadImage");
        a r101 = new a();
        if (r100.f426390d == false) goto L5;
    L14:
        boolean r102 = true;
    L15:
        if (r102 == false) goto L17;
        return;
    L17:
        Biz r103 = r100.f426391e;
        Intrinsics.checkNotNull(r103);
        Scene r104 = r100.f426392f;
        Intrinsics.checkNotNull(r104);
        int r105 = r100.f426393g;
        String r106 = r100.f426394h;
        Intrinsics.checkNotNull(r106);
        r101.a(r103, r104, r105, r106);
        r100.f426400n = r101;
        return;
    L5:
        if (r100.f426391e == null) goto L14;
        if (r100.f426392f == null) goto L14;
        if (r100.f426393g == 0) goto L14;
        if (r100.f426394h == null) goto L14;
        r102 = false;
        goto L15
    }

    public static void e(com.ss.android.lark.image.uploader.entity.b r100) {
        Intrinsics.checkNotNullParameter(r100, "uploadImage");
        a r101 = r100.f426400n;
        if (r101 == null) goto L20;
        ImageInfo r102 = r100.f426397k;
        if (r102 == null) goto L8;
        ImageUtils.ImageType r103 = r102.f426428h;
        if (r103 == null) goto L8;
    L9:
        int r104 = 0;
        if (r102 == null) goto L12;
        int r105 = r102.f426421a;
    L13:
        if (r102 == null) goto L15;
        r104 = r102.f426422b;
    L15:
        if (r102 == null) goto L17;
        long r106 = r102.f426423c;
    L18:
        boolean r107 = r100.f426389c;
        boolean r108 = r100.f426388b;
        Intrinsics.checkNotNullParameter(r103, "imageType");
        r101.f481634d = r107;
        r101.f481636f = r108;
        r101.f481637g = r103.getValue();
        r101.f481638h = r106;
        r101.f481639i = r105;
        r101.f481640j = r104;
        return;
    L17:
        r106 = 0;
        goto L18
    L12:
        r105 = 0;
    L8:
        r103 = ImageUtils.ImageType.TYPE_UNKNOWN;
        goto L9
    }

    public static void f(com.ss.android.lark.image.uploader.entity.b r100) {
        Intrinsics.checkNotNullParameter(r100, "uploadImage");
        a r101 = r100.f426400n;
        if (r101 == null) goto L21;
        ImageInfo r102 = r100.f426397k;
        int r103 = 0;
        if (r102 == null) goto L7;
        int r104 = r102.f426421a;
    L8:
        if (r102 == null) goto L10;
        r103 = r102.f426422b;
    L10:
        if (r102 == null) goto L12;
        long r105 = r102.f426423c;
    L13:
        com.ss.android.lark.image.uploader.entity.a r106 = r100.f426399m;
        if (r106 == null) goto L16;
        Integer r107 = Integer.valueOf(r106.f426386c);
    L17:
        if (r107 == null) goto L19;
        r101.f481644n = r107.intValue();
    L19:
        r101.f481641k = r105;
        r101.f481642l = r104;
        r101.f481643m = r103;
        return;
    L16:
        r107 = null;
        goto L17
    L12:
        r105 = 0;
        goto L13
    L7:
        r104 = 0;
        goto L8
    }

    public static void c(com.ss.android.lark.image.uploader.entity.b r110, ErrorResult r210) {
        Intrinsics.checkNotNullParameter(r110, "uploadImage");
        Intrinsics.checkNotNullParameter(r210, "error");
        a r100 = r110.f426400n;
        if (r100 == null) goto L6;
        Intrinsics.checkNotNullParameter(r210, "error");
        String r111 = null;
        String r112 = null;
        ErrorParams r101 = new ErrorParams(r100.f481632b, r100.f481633c, Event.image_upload, ErrorType.Unknown, ErrorLevel.Exception, r210.getCode(), r111, r112, r210.getDebugMsg(), Boolean.FALSE, null, null, null, AVMDLDataLoader.KeyIsInitialSocketTimeout, null);
        r101.setErrorStatus(r210.getStatus());
        AppreciableKit.Companion.getInstance().error(r101);
        return;
    }
}
