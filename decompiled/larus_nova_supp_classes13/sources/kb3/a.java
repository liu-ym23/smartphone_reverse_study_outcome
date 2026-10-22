package kb3;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.collect.container.CollectYataQueryFrom;
import com.bytedance.android.shopping.collect.custom_view.CollectGoodsLinkedScrollView;
import com.bytedance.android.shopping.collect.repo.model.CollectParams;
import com.bytedance.android.shopping.collect.util.e;
import com.bytedance.android.ui.ec.widget.toast.ECToast;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements b {
    public Function0<AndroidYaTaInstance> a;
    public CollectParams b;
    public e c;
    public LifecycleOwner d;
    public mb3.a e;
    public final lb3.a f;

    /* JADX INFO: renamed from: kb3.a$a, reason: collision with other inner class name */
    public static final class C0211a {
    }

    static {
    }

    @Override // kb3.b
    public final AndroidYaTaInstance c() {
        Function0<AndroidYaTaInstance> r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return (AndroidYaTaInstance) r0.invoke();
    }

    public a() {
        this.f = new lb3.a();
    }

    @Override // kb3.b
    public final CollectParams b() {
        return this.b;
    }

    @Override // kb3.b
    public final LifecycleOwner getLifecycleOwner() {
        return this.d;
    }

    @Override // kb3.b
    public final void a(CollectGoodsLinkedScrollView r6) {
        Intrinsics.checkNotNullParameter(r6, "nestedScrollView");
        e r0 = this.c;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.a == true) goto L40;
        int r1 = e.e;
        Function0<AndroidYaTaInstance> r2 = r0.d;
        RecyclerView.LayoutManager r3 = null;
        if (r2 == null) goto L10;
        AndroidYaTaInstance r4 = (AndroidYaTaInstance) r2.invoke();
    L12:
        if (e.a.a(r4) == false) goto L41;
        int r5 = 0;
        if (r6 == null) goto L21;
        RecyclerView r7 = r6.getRv();
        if (r7 == null) goto L21;
        RecyclerView.Adapter r8 = r7.getAdapter();
        if (r8 == null) goto L21;
        int r9 = r8.getItemCount();
    L22:
        if (r6 == null) goto L26;
        RecyclerView r10 = r6.getRv();
        if (r10 == null) goto L26;
        RecyclerView.LayoutManager r11 = r10.getLayoutManager();
    L28:
        if ((r11 instanceof LinearLayoutManager) == false) goto L31;
        r3 = r11;
    L31:
        LinearLayoutManager r12 = (LinearLayoutManager) r3;
        if (r12 == null) goto L35;
        r5 = r12.findLastCompletelyVisibleItemPosition();
    L35:
        if ((r9 - r5) >= 4) goto L39;
        r0.c.requestQuery(CollectYataQueryFrom.LOAD_MORE);
        return;
    L39:
        return;
    L26:
        r11 = null;
    L21:
        r9 = 0;
        goto L22
    L41:
        return;
    L10:
        r4 = null;
        goto L12
    }

    public final void d(Context r11, CollectYataQueryFrom r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r12, "queryScene");
        e r2 = this.c;
        if (r2 == null) goto L11;
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r12, "queryScene");
        if (r12 != CollectYataQueryFrom.LOAD_MORE) goto L12;
        if (r13 == true) goto L9;
        ECToast.showToast$default(ECToast.INSTANCE, r11, "部分商品加载失败，请重试", 0, null, 8, null);
    L9:
        r2.a = false;
        return;
    L12:
        return;
    }
}
