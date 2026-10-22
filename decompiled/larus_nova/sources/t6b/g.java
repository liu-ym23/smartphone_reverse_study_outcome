package t6b;

import com.ss.android.lark.biz.im.extension.PageType;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public class g implements s6b.b<g, h> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<yya.l> f544791a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f544792b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Integer> f544793c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f544794d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final yya.f f544795e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final PageType f544796f;

    public g() {
        List r100 = null;
        this(r100, false, r100, 63);
    }

    @Override // s6b.b
    public final s6b.b a() {
        return new h(this);
    }

    public List<yya.l> c() {
        return this.f544791a;
    }

    public yya.f d() {
        return this.f544795e;
    }

    public List<Integer> e() {
        return this.f544793c;
    }

    public PageType f() {
        return this.f544796f;
    }

    public boolean g() {
        return this.f544792b;
    }

    public boolean h() {
        return this.f544794d;
    }

    @Override // s6b.b
    public final s6b.b b(s6b.b r100) {
        g r101 = (g) r100;
        Intrinsics.checkNotNullParameter(r101, "patch");
        return new g(r101.c(), r101.g(), r101.e(), r101.h(), r101.d(), r101.f());
    }

    public /* synthetic */ g(List r100, boolean r101, List r110, int r111) {
        if ((r111 & 1) == 0) goto L5;
        r100 = CollectionsKt.emptyList();
    L5:
        List r102 = r100;
        if ((r111 & 2) == 0) goto L8;
        boolean r103 = true;
    L10:
        if ((r111 & 4) == 0) goto L12;
        r110 = CollectionsKt.emptyList();
    L12:
        List r104 = r110;
        if ((r111 & 32) == 0) goto L15;
        PageType r105 = PageType.CHAT_WINDOW;
    L16:
        this(r102, r103, r104, false, null, r105);
        return;
    L15:
        r105 = null;
        goto L16
    L8:
        r103 = r101;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g(List<? extends yya.l> r100, boolean r101, List<Integer> r102, boolean r103, yya.f r104, PageType r105) {
        Intrinsics.checkNotNullParameter(r100, "actionInterceptorList");
        Intrinsics.checkNotNullParameter(r102, "messageActionHandlerKeys");
        Intrinsics.checkNotNullParameter(r105, "pageType");
        this.f544791a = r100;
        this.f544792b = r101;
        this.f544793c = r102;
        this.f544794d = r103;
        this.f544795e = r104;
        this.f544796f = r105;
    }
}
