package yp5;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import bd5.r;
import com.ss.android.lark.maincore.ITitleInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements com.bytedance.ee.bear.list.homepage.title.b {
    public final com.ss.android.lark.maintab.export.d a;
    public final a b;
    public final r c;

    public final class a implements ITitleInfo {
        public final List<Object> a;

        /* JADX INFO: renamed from: yp5.b$a$a, reason: collision with other inner class name */
        public static final class C0344a {
            public C0344a() {
            }
        }

        public a(b r2) {
            ArrayList r3 = new ArrayList();
            this.a = r3;
            r3.add(new C0344a());
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
    public final void setTitle(String r1) {
    }

    @Override // com.bytedance.ee.bear.list.homepage.title.b
    public final int getTitleBarHeight() {
        return this.a.getTitleBarHeight();
    }

    @Override // com.bytedance.ee.bear.list.homepage.title.b
    public final void a(int r5) {
        r r0 = this.c;
        int r6 = r0.b(r0.d, r5);
        r0.d = r6;
        float r7 = r0.a(r6);
        if (r7 <= 0.1f) goto L5;
        boolean r1 = true;
    L6:
        tt5.a.b("TitleBarTransformHelper", "onScrollBy, height:" + r0.d + ", alpha:" + r7 + ", visible:" + r1);
        StringBuilder r8 = new StringBuilder("onScrollBy, visible:");
        r8.append(r1);
        tt5.a.b("WikiTitleBarV2", r8.toString());
        this.b.getClass();
        if (r1 == false) goto L9;
        this.a.a();
        return;
    L9:
        this.a.x();
        return;
    L5:
        r1 = false;
        goto L6
    }

    public b(FragmentActivity r1, com.ss.android.lark.maintab.export.d r2, com.bytedance.ee.bear.contract.route.parcelable.c r3) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "larkTitleController");
        this.a = r2;
        int r4 = r2.getTitleBarHeight();
        this.c = new r(r4, r4, r4);
        a r5 = new a(this);
        this.b = r5;
        Intrinsics.checkNotNullParameter(r5, "oldWrapper");
        r2.b();
    }
}
