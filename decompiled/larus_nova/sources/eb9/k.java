package eb9;

import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<o<?>, e> f471884a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<o<?>, Integer> f471885b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<o<?>, Integer> f471886c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<o<?>, Integer> f471887d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function1<o<?>, Boolean> f471888e;

    public final boolean a(o<?> r100) {
        Intrinsics.checkNotNullParameter(r100, BrowserDependency.UrlClickType.CARD);
        return this.f471888e.invoke(r100).booleanValue();
    }

    public k(final e.b r100, final Integer r101, final Integer r102, final boolean r103, int r104) {
        final Integer r105 = null;
        if ((r104 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r104 & 8) == 0) goto L9;
        r102 = null;
    L9:
        if ((r104 & 16) == 0) goto L11;
        r103 = true;
    L11:
        Intrinsics.checkNotNullParameter(r100, "title");
        Function1<o<?>, e> r106 = new f(r100);
        Function1<o<?>, Integer> r107 = new g(r101);
        Function1<o<?>, Integer> r108 = new h(r105);
        Function1<o<?>, Integer> r109 = new i(r102);
        Function1<o<?>, Boolean> r110 = new j(r103);
        Intrinsics.checkNotNullParameter(r106, "titleProvider");
        Intrinsics.checkNotNullParameter(r107, "iconResProvider");
        Intrinsics.checkNotNullParameter(r108, "backgroundResProvider");
        Intrinsics.checkNotNullParameter(r109, "textColorResProvider");
        Intrinsics.checkNotNullParameter(r110, "enabledProvider");
        this.f471884a = r106;
        this.f471885b = r107;
        this.f471886c = r108;
        this.f471887d = r109;
        this.f471888e = r110;
    }
}
