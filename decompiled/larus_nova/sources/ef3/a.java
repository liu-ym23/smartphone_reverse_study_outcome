package ef3;

import android.content.Context;
import android.view.View;
import com.bytedance.android.shopping.mall.feed.ECMallFeed;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public class a implements b, jf3.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f472417a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f472418b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f472419c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<b> f472420d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f472421e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f472422f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Context f472423g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ECMallFeed f472424h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f472425i;

    /* JADX INFO: renamed from: ef3.a$a, reason: collision with other inner class name */
    public static final class C5775a {
    }

    static {
    }

    @Override // ef3.b
    public void onRelease() {
        jf3.e r100 = this.f472424h.A1.jF();
        if (r100 == null) goto L5;
        Intrinsics.checkNotNullParameter(this, "listener");
        r100.f498879a.remove(this);
    L5:
        Iterator<T> r101 = this.f472420d.iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        ((b) r101.next()).onRelease();
        goto L7
    L9:
        ((ArrayList) this.f472420d).clear();
    }

    @Override // ef3.b
    public final void p() {
        Iterator<T> r100 = this.f472420d.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((b) r100.next()).p();
        goto L4
    }

    public final Context getContext() {
        return this.f472423g;
    }

    @Override // ef3.b
    public void N2(View r100) {
        Intrinsics.checkNotNullParameter(r100, "cardView");
        jf3.e r101 = this.f472424h.A1.jF();
        if (r101 == null) goto L5;
        Intrinsics.checkNotNullParameter(this, "listener");
        r101.f498879a.add(this);
    L5:
        Iterator<T> r102 = this.f472420d.iterator();
    L7:
        if (r102.hasNext() == false) goto L9;
        ((b) r102.next()).N2(r100);
        goto L7
    }

    public final void a(b r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        if (this.f472420d.contains(r100) == true) goto L6;
        this.f472420d.add(r100);
        return;
    }

    public a(Context r100, ECMallFeed r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "mallFeed");
        Intrinsics.checkNotNullParameter(r102, "sceneID");
        this.f472423g = r100;
        this.f472424h = r101;
        this.f472425i = r102;
        Object r103 = r101.A1.getGlobalProps().get("page_name");
        if (r103 == null) goto L6;
        String r104 = r103.toString();
        if (r104 == null) goto L6;
    L7:
        this.f472417a = r104;
        if (Intrinsics.areEqual(r104, "order_homepage") == false) goto L10;
        String r105 = "1098,1031";
    L11:
        this.f472418b = r105;
        this.f472419c = Intrinsics.areEqual(r101.A1.getGlobalProps().get("theme"), "dark");
        this.f472420d = new ArrayList();
        return;
    L10:
        r105 = "1099,1031";
    L6:
        r104 = "";
        goto L7
    }

    @Override // ef3.b
    public final void Q0(boolean r100, Boolean r101, boolean r102) {
        this.f472422f = r100;
        Iterator<T> r103 = this.f472420d.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((b) r103.next()).Q0(r100, r101, r102);
        goto L4
    }
}
