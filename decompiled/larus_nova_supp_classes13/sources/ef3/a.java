package ef3;

import android.content.Context;
import android.view.View;
import com.bytedance.android.shopping.mall.feed.ECMallFeed;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public class a implements b, jf3.a {
    public final String a;
    public String b;
    public boolean c;
    public final List<b> d;
    public boolean e;
    public boolean f;
    public final Context g;
    public final ECMallFeed h;
    public final String i;

    /* JADX INFO: renamed from: ef3.a$a, reason: collision with other inner class name */
    public static final class C0193a {
    }

    static {
    }

    @Override // ef3.b
    public void onRelease() {
        jf3.e r0 = this.h.A1.jF();
        if (r0 == null) goto L5;
        Intrinsics.checkNotNullParameter(this, "listener");
        r0.a.remove(this);
    L5:
        Iterator<T> r1 = this.d.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        ((b) r1.next()).onRelease();
        goto L7
    L9:
        ((ArrayList) this.d).clear();
    }

    @Override // ef3.b
    public final void p() {
        Iterator<T> r0 = this.d.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((b) r0.next()).p();
        goto L4
    }

    public final Context getContext() {
        return this.g;
    }

    @Override // ef3.b
    public void N2(View r3) {
        Intrinsics.checkNotNullParameter(r3, "cardView");
        jf3.e r0 = this.h.A1.jF();
        if (r0 == null) goto L5;
        Intrinsics.checkNotNullParameter(this, "listener");
        r0.a.add(this);
    L5:
        Iterator<T> r1 = this.d.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        ((b) r1.next()).N2(r3);
        goto L7
    }

    public final void a(b r2) {
        Intrinsics.checkNotNullParameter(r2, "observer");
        if (this.d.contains(r2) == true) goto L6;
        this.d.add(r2);
        return;
    }

    public a(Context r2, ECMallFeed r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "mallFeed");
        Intrinsics.checkNotNullParameter(r4, "sceneID");
        this.g = r2;
        this.h = r3;
        this.i = r4;
        Object r5 = r3.A1.getGlobalProps().get(PdpOpenThirdParam.KEY_PAGE_NAME);
        if (r5 == null) goto L6;
        String r6 = r5.toString();
        if (r6 == null) goto L6;
    L7:
        this.a = r6;
        if (Intrinsics.areEqual(r6, "order_homepage") == false) goto L10;
        String r7 = "1098,1031";
    L11:
        this.b = r7;
        this.c = Intrinsics.areEqual(r3.A1.getGlobalProps().get("theme"), "dark");
        this.d = new ArrayList();
        return;
    L10:
        r7 = "1099,1031";
    L6:
        r6 = "";
        goto L7
    }

    @Override // ef3.b
    public final void Q0(boolean r3, Boolean r4, boolean r5) {
        this.f = r3;
        Iterator<T> r0 = this.d.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((b) r0.next()).Q0(r3, r4, r5);
        goto L4
    }
}
