package h5;

import android.view.ViewGroup;
import com.bytedance.ai.model.objects.WidgetInfo;
import java.util.Map;
import k2.u;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f483836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f483837b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f483838c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f483839d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f483840e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public WidgetInfo f483841f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ViewGroup f483842g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final u f483843h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f483844i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Map<String, String> f483845j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Map<String, Object> f483846k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f483847l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Map<String, Object> f483848m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Map<String, Object> f483849n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Function1<Boolean, Unit> f483850o;

    public k() {
        throw null;
    }

    public String b() {
        return null;
    }

    public final String a() {
        WidgetInfo r100 = this.f483841f;
        if (r100 == null) goto L5;
        String r101 = r100.getMixtureCardId();
    L6:
        if (r101 != null) goto L8;
    L11:
        boolean r102 = true;
    L12:
        if (r102 == true) goto L14;
        return r101;
    L14:
        return this.f483836a;
    L8:
        if (r101.length() == 0) goto L11;
        r102 = false;
        goto L12
    L5:
        r101 = null;
        goto L6
    }

    public k(String r100, String r101, String r110, String r111, String r112, WidgetInfo r113, ViewGroup r114, u r115, int r116, Map r117, Map r118, boolean r119, Map r210, Map r211, int r212) {
        if ((r212 & 4096) == 0) goto L5;
        boolean r102 = true;
    L7:
        if ((r212 & 8192) == 0) goto L9;
        Map r103 = null;
    L11:
        if ((r212 & 16384) == 0) goto L13;
        Map r104 = null;
    L14:
        Intrinsics.checkNotNullParameter(r100, "messageId");
        this.f483836a = r100;
        this.f483837b = r101;
        this.f483838c = r110;
        this.f483839d = r111;
        this.f483840e = r112;
        this.f483841f = r113;
        this.f483842g = r114;
        this.f483843h = r115;
        this.f483844i = r116;
        this.f483845j = r117;
        this.f483846k = r118;
        this.f483847l = r102;
        this.f483848m = r103;
        this.f483849n = r104;
        this.f483850o = null;
        return;
    L13:
        r104 = r211;
        goto L14
    L9:
        r103 = r210;
        goto L11
    L5:
        r102 = r119;
        goto L7
    }
}
