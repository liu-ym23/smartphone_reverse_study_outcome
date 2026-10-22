package glb;

import com.ss.android.lark.appreciablelib.AppreciableKit;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.Event;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.monitor.perf.BasePerfMonitor;
import com.ss.android.lark.utils.ImageUtils;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a extends BasePerfMonitor.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f481631a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Biz f481632b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Scene f481633c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f481634d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f481635e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f481636f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f481637g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f481638h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f481639i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f481640j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f481641k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f481642l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f481643m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f481644n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f481645o;

    /* JADX INFO: renamed from: glb.a$a, reason: collision with other inner class name */
    public static final class C6035a {
    }

    static {
    }

    @Override // com.ss.android.lark.monitor.perf.BasePerfMonitor.a
    public final String getEventName(int r100) {
        return "gallery_load";
    }

    public a() {
        this.f481631a = "";
        this.f481632b = Biz.Messenger;
        this.f481633c = Scene.Chat;
        this.f481634d = true;
        this.f481635e = 5;
        this.f481636f = true;
        this.f481637g = ImageUtils.ImageType.TYPE_UNKNOWN.getValue();
        this.f481638h = -1;
        this.f481641k = -1;
    }

    @Override // com.ss.android.lark.monitor.perf.BasePerfMonitor.b
    public final void end() {
        super.end();
        AppreciableKit.Companion r100 = AppreciableKit.Companion;
        r100.getInstance().spanEnd(this.f481631a, "data_load_cost");
        AppreciableKit.end$default(r100.getInstance(), this.f481631a, null, null, MapsKt.mapOf(new Pair[]{TuplesKt.to("resource_content_length", Long.valueOf(this.f481638h)), TuplesKt.to("resource_width", Integer.valueOf(this.f481639i)), TuplesKt.to("resource_height", Integer.valueOf(this.f481640j)), TuplesKt.to("upload_content_length", Long.valueOf(this.f481641k)), TuplesKt.to("upload_width", Integer.valueOf(this.f481642l)), TuplesKt.to("upload_height", Integer.valueOf(this.f481643m)), TuplesKt.to("compress_cost", Integer.valueOf(this.f481644n))}), MapsKt.mapOf(new Pair[]{TuplesKt.to("from_type", Integer.valueOf(this.f481635e)), TuplesKt.to("is_encrypt", Boolean.valueOf(this.f481634d)), TuplesKt.to("media_is_origin_type", Boolean.valueOf(this.f481636f)), TuplesKt.to("image_type", this.f481637g)}), 6, null);
        this.f481631a = "";
    }

    public final void a(Biz r100, Scene r110, int r111, String r112) {
        Intrinsics.checkNotNullParameter(r100, "biz");
        Intrinsics.checkNotNullParameter(r110, "scene");
        Intrinsics.checkNotNullParameter(r112, "page");
        super.start();
        this.f481632b = r100;
        this.f481633c = r110;
        this.f481635e = r111;
        AppreciableKit.Companion r101 = AppreciableKit.Companion;
        this.f481631a = AppreciableKit.start$default(r101.getInstance(), this.f481632b, this.f481633c, Event.image_upload, r112, false, 16, null);
        r101.getInstance().spanStart(this.f481631a, "data_load_cost");
    }
}
