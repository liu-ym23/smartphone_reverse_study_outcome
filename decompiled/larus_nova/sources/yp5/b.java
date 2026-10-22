package yp5;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import bd5.r;
import com.ss.android.lark.maincore.ITitleInfo;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class b implements com.bytedance.ee.bear.list.homepage.title.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.maintab.export.d f568715a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f568716b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final r f568717c;

    public final class a implements ITitleInfo {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<Object> f568718a;

        /* JADX INFO: renamed from: yp5.b$a$a, reason: collision with other inner class name */
        public static final class C8370a {
            public C8370a() {
            }
        }

        public a(b r100) {
            ArrayList r101 = new ArrayList();
            this.f568718a = r101;
            r101.add(new C8370a());
            qc5.a.k();
        }
    }

    @Override // com.bytedance.ee.bear.list.homepage.title.b
    public final void b() {
    }

    @Override // com.bytedance.ee.bear.list.homepage.title.b
    public final View getCreateView() {
        return null;
    }

    @Override // com.bytedance.ee.bear.list.homepage.title.b
    public final int getTitleType() {
        return 0;
    }

    @Override // com.bytedance.ee.bear.list.homepage.title.b
    public final void setTitle(String r100) {
    }

    @Override // com.bytedance.ee.bear.list.homepage.title.b
    public final int getTitleBarHeight() {
        return this.f568715a.getTitleBarHeight();
    }

    @Override // com.bytedance.ee.bear.list.homepage.title.b
    public final void a(int r100) {
        r r101 = this.f568717c;
        int r102 = r101.b(r101.f18678d, r100);
        r101.f18678d = r102;
        float r103 = r101.a(r102);
        if (r103 <= 0.1f) goto L5;
        boolean r104 = true;
    L6:
        tt5.a.b("TitleBarTransformHelper", "onScrollBy, height:" + r101.f18678d + ", alpha:" + r103 + ", visible:" + r104);
        StringBuilder r105 = new StringBuilder("onScrollBy, visible:");
        r105.append(r104);
        tt5.a.b("WikiTitleBarV2", r105.toString());
        this.f568716b.getClass();
        if (r104 == false) goto L9;
        this.f568715a.a();
        return;
    L9:
        this.f568715a.x();
        return;
    L5:
        r104 = false;
        goto L6
    }

    public b(FragmentActivity r100, com.ss.android.lark.maintab.export.d r101, com.bytedance.ee.bear.contract.route.parcelable.c r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "larkTitleController");
        this.f568715a = r101;
        int r103 = r101.getTitleBarHeight();
        this.f568717c = new r(r103, r103, r103);
        a r104 = new a(this);
        this.f568716b = r104;
        Intrinsics.checkNotNullParameter(r104, "oldWrapper");
        r101.b();
    }
}
