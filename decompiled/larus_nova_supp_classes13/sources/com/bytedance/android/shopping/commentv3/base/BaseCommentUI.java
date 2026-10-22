package com.bytedance.android.shopping.commentv3.base;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.shopping.commentv3.base.a;
import com.bytedance.android.shopping.commentv3.base.b;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\u000e\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u00028\u00000\u00032\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005:\u0001\u0010B\u0007¢\u0006\u0004\b\u000e\u0010\u000fR$\u0010\r\u001a\u0004\u0018\u00010\u00068\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/shopping/commentv3/base/BaseCommentUI;", "Lcom/bytedance/android/shopping/commentv3/base/b;", "State", "Lcom/bytedance/android/shopping/commentv3/base/a;", "Logic", "Lcom/bytedance/android/shopping/commentv3/base/BaseUI;", "Landroid/content/Context;", "d", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "context", "<init>", "()V", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class BaseCommentUI<State extends b, Logic extends com.bytedance.android.shopping.commentv3.base.a<State>> extends BaseUI<State, Logic> {
    public View c;
    public Context d;
    public com.bytedance.android.shopping.commentv3.data.b e;
    public BaseCommentUI<?, ?> f;
    public c g;
    public final Lazy h;

    public static final class a {
    }

    static {
    }

    public void j() {
    }

    public Lifecycle rK() {
        BaseCommentUI<?, ?> r0 = this.f;
        if (r0 == null) goto L7;
        Lifecycle r1 = r0.rK();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return new InvalidLifecycle();
    }

    public BaseCommentUI() {
        this.h = LazyKt.lazy(BaseCommentUI$childUiMap$2.INSTANCE);
    }

    public final String k() {
        return getClass().getSimpleName();
    }

    @Override // com.bytedance.android.shopping.commentv3.base.BaseUI, com.bytedance.android.shopping.commentv3.base.LifecycleUI
    public void onCreate() {
        super.onCreate();
        j();
    }

    public final Context getContext() {
        return this.d;
    }

    public final int l(Number r2) {
        Intrinsics.checkNotNullParameter(r2, "number");
        c r0 = this.g;
        if (r0 == null) goto L6;
        return r0.a(r2);
    L6:
        return com.bytedance.android.shopping.extensions.b.b(r2);
    }

    public final float m(Number r3) {
        Intrinsics.checkNotNullParameter(r3, "number");
        c r1 = this.g;
        if (r1 == null) goto L6;
        Intrinsics.checkNotNullParameter(r3, "number");
        return ((Number) r1.d.b.f.invoke(r3)).floatValue();
    L6:
        return com.bytedance.android.shopping.extensions.b.c(r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void g(BaseCommentUI r4, BaseCommentUI r5) {
        r4.getClass();
        Intrinsics.checkNotNullParameter(r5, "child");
        ((Map) r4.h.getValue()).put(r5.k(), r5);
        r5.f = r4.f;
        c r0 = r4.g;
        r5.g = r0;
        com.bytedance.android.shopping.commentv3.data.b r1 = null;
        if (r0 == null) goto L7;
        Fragment r2 = r0.b;
        if (r2 == null) goto L7;
        Context r3 = r2.getContext();
    L8:
        r5.d = r3;
        if (r0 == null) goto L11;
        com.bytedance.android.shopping.commentv3.data.b r6 = r0.e;
    L12:
        r5.e = r6;
        Logic r7 = r5.a;
        if ((r7 instanceof BaseCommentLogic) == true) goto L15;
        r7 = null;
    L15:
        BaseCommentLogic r8 = (BaseCommentLogic) r7;
        if (r8 == null) goto L22;
        r8.c = r0;
        if (r0 == null) goto L20;
        r1 = r0.e;
    L20:
        r8.d = r1;
    L22:
        if ((r5 instanceof d) == false) goto L31;
        c r9 = r4.g;
        if (r9 == null) goto L31;
        CommentApiCenter r10 = r9.a;
        if (r10 == null) goto L31;
        d r11 = (d) r5;
        Intrinsics.checkNotNullParameter(r11, "api");
        if (r10.a().contains(r11) == true) goto L31;
        r10.a().add(r11);
    L31:
        BaseCommentUI<?, ?> r12 = r4.f;
        if (r12 == null) goto L37;
        Lifecycle r13 = r12.getLifecycle();
        if (r13 == null) goto L38;
        r13.addObserver(r5);
        return;
    L38:
        return;
    L37:
        return;
    L11:
        r6 = null;
    L7:
        r3 = null;
        goto L8
    }

    public static final boolean h(BaseCommentUI r3, BaseCommentUI r4) {
        r3.getClass();
        Intrinsics.checkNotNullParameter(r4, "child");
        dm.a.b r0 = dm.a.a;
        dm.a.a(r3.k()).i("canChildBeAttached, this.key: " + r3.k() + ", child: " + r4.k() + '}');
        Intrinsics.checkNotNullParameter(r4, "ui");
        if (((Map) r3.h.getValue()).containsKey(r4.k()) == false) goto L5;
        dm.a.a(r3.k()).i("canChildBeAttached, has attached, child.key: ".concat(r4.k()));
        return false;
    L5:
        return true;
    }

    public static final void i(BaseCommentUI r3, BaseCommentUI r4) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        dm.a.b r0 = dm.a.a;
        dm.a.a(r3.k()).i("onAttached, this: " + r3.k() + ", parent: " + r4.k() + '}');
    }
}
