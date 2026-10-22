package v26;

import com.bytedance.ies.bullet.service.base.resourceloader.config.IXResourceLoader;
import com.bytedance.ies.bullet.service.base.resourceloader.config.LoaderType;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f552670f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f552671a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<LoaderType> f552672b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<? extends Class<? extends IXResourceLoader>> f552673c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<? extends Class<? extends IXResourceLoader>> f552674d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<? extends Class<? extends IXResourceLoader>> f552675e;

    /* JADX INFO: renamed from: v26.a$a, reason: collision with other inner class name */
    public static final class C7957a {
        public static a a(a r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            a r101 = new a(r100.f552671a);
            if (r100.f552675e == null) goto L9;
            ArrayList r102 = new ArrayList();
            List<? extends Class<? extends IXResourceLoader>> r103 = r100.f552675e;
            Intrinsics.checkNotNull(r103);
            r102.addAll(r103);
            r101.f552675e = r102;
        L9:
            if (r100.f552673c == null) goto L12;
            ArrayList r104 = new ArrayList();
            List<? extends Class<? extends IXResourceLoader>> r105 = r100.f552673c;
            Intrinsics.checkNotNull(r105);
            r104.addAll(r105);
            r101.f552673c = r104;
        L12:
            if (r100.f552674d == null) goto L15;
            ArrayList r106 = new ArrayList();
            List<? extends Class<? extends IXResourceLoader>> r107 = r100.f552674d;
            Intrinsics.checkNotNull(r107);
            r106.addAll(r107);
            r101.f552674d = r106;
        L15:
            if ((!r100.f552672b.isEmpty()) == false) goto L17;
            r101.f552672b.addAll(r100.f552672b);
        L17:
            return r101;
        }
    }

    static {
    }

    public a(boolean r100) {
        this.f552671a = r100;
        this.f552672b = new ArrayList();
    }

    public final void a(List<LoaderType> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f552672b = r100;
    }
}
