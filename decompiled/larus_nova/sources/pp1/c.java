package pp1;

import android.text.Spannable;
import com.bytedance.android.live.base.model.message.a5;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class c extends com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f530166o = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Spannable f530167a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f530168b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a5 f530169c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f530170d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f530171e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final py.k f530172f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final py.k f530173g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f530174h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f530175i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Map<String, String> f530176j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f530177k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f530178l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final py.k f530179m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final py.k f530180n;

    public static final class a {

        /* JADX INFO: renamed from: pp1.c$a$a, reason: collision with other inner class name */
        public static final class C7221a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f530181a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f530182b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final Map<String, String> f530183c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final int f530184d;

            public final c a() {
                return new c(this.f530181a, null, null, this.f530182b, null, null, 0, 0, this.f530183c, this.f530184d, 7168);
            }

            public C7221a() {
                this.f530182b = 5;
                this.f530183c = new LinkedHashMap();
                this.f530184d = 1;
            }

            public C7221a(String r100) {
                Intrinsics.checkNotNullParameter(r100, "plainText");
                this();
                this.f530181a = r100;
            }
        }

        public static c a(String r110) {
            Intrinsics.checkNotNullParameter(r110, "text");
            return new c(r110, null, null, 0, null, null, 0, 0, null, 0, 8190);
        }
    }

    static {
    }

    public final String toString() {
        return "IconBubbleCommand(scheme=" + this.f530170d + ", duration=" + this.f530171e + ", actionType=" + this.f530174h + ", messageType=" + this.f530175i + ')';
    }

    public /* synthetic */ c(String r110, a5 r111, String r210, int r211, py.k r212, py.k r213, int r214, int r215, Map r216, int r217, int r218) {
        if ((r218 & 2) == 0) goto L5;
        a5 r100 = null;
    L7:
        if ((r218 & 4) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r218 & 8) == 0) goto L13;
        int r102 = 5;
    L15:
        if ((r218 & 16) == 0) goto L17;
        py.k r103 = null;
    L19:
        if ((r218 & 32) == 0) goto L21;
        py.k r104 = null;
    L23:
        if ((r218 & 64) == 0) goto L25;
        int r112 = 0;
    L27:
        if ((r218 & 128) == 0) goto L29;
        int r113 = 0;
    L31:
        if ((r218 & 256) == 0) goto L33;
        Map r114 = MapsKt.emptyMap();
    L35:
        if ((r218 & 512) == 0) goto L37;
        int r115 = 1;
    L38:
        this(r110, r100, r101, r102, r103, r104, r112, r113, r114, r115, null, null, null);
        return;
    L37:
        r115 = r217;
        goto L38
    L33:
        r114 = r216;
        goto L35
    L29:
        r113 = r215;
        goto L31
    L25:
        r112 = r214;
        goto L27
    L21:
        r104 = r213;
        goto L23
    L17:
        r103 = r212;
        goto L19
    L13:
        r102 = r211;
        goto L15
    L9:
        r101 = r210;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public c(String r100, a5 r101, String r102, int r103, py.k r104, py.k r105, int r106, int r107, Map<String, String> r108, int r110, String r111, py.k r112, py.k r113) {
        this.f530168b = r100;
        this.f530169c = r101;
        this.f530170d = r102;
        this.f530171e = r103;
        this.f530172f = r104;
        this.f530173g = r105;
        this.f530174h = r106;
        this.f530175i = r107;
        this.f530176j = r108;
        this.f530177k = r110;
        this.f530178l = r111;
        this.f530179m = r112;
        this.f530180n = r113;
    }
}
