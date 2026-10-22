package nec;

import com.ss.android.lark.widget.richtext.preprocess.ElementExtra;
import com.ss.android.lark.widget.span.PrefixInfo;
import com.ss.android.lark.widget.span.PrefixSpan;
import java.util.Stack;

/* JADX INFO: loaded from: classes38.dex */
public final class b extends lec.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f518926a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Stack<Integer> f518927b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Stack<ElementExtra.FloorInfo> f518928c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Stack<PrefixInfo> f518929d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ElementExtra.FloorInfo f518930e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public PrefixInfo f518931f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.ss.android.lark.widget.richtext.preprocess.b.InterfaceC5430b f518932g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final lec.b f518933h;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f518934a = null;

        static {
            int[] r100 = new int[PrefixSpan.Type.values().length];
            f518934a = r100;
            r100[PrefixSpan.Type.LIST_NUM.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            f518934a[PrefixSpan.Type.FILL_RECT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            f518934a[PrefixSpan.Type.FILL_CIRCLE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            f518934a[PrefixSpan.Type.HOLLOW_RECT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            f518934a[PrefixSpan.Type.HOLLOW_CIRCLE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public b(com.ss.android.lark.widget.richtext.preprocess.b.InterfaceC5430b r100, lec.b r101) {
        this.f518926a = -1;
        this.f518927b = new Stack();
        this.f518928c = new Stack();
        this.f518929d = new Stack();
        this.f518931f = null;
        this.f518932g = r100;
        this.f518933h = r101;
    }
}
