package com.bytedance.locallife.dito.interact;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001\nB\u0019\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/locallife/dito/interact/AbstractInteractBehavior;", "Landroid/view/View;", "V", "Landroidx/coordinatorlayout/widget/CoordinatorLayout$Behavior;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "dito-core-saas_release"}, k = 1, mv = {1, 4, 3})
public abstract class AbstractInteractBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f258316a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f258317b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f258318c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f258319d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f258320e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public c f258321f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f258322g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<d> f258323h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ArrayList<b> f258324i;

    public static final class a {
    }

    static {
    }

    public abstract boolean b();

    public boolean c() {
        return false;
    }

    public int d() {
        return 0;
    }

    public abstract void e();

    public abstract void f();

    public void setState(int r100) {
    }

    public final void a(b r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        if (this.f258324i.contains(r100) == true) goto L6;
        this.f258324i.add(r100);
        return;
    }

    public final void g(int r100) {
        int r101 = this.f258324i.size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        ((b) ListProtector.get(this.f258324i, r102)).b(r100);
        r102 = r102 + 1;
        goto L3
    }

    public AbstractInteractBehavior(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f258318c = 5;
        this.f258319d = 1;
        this.f258320e = -1;
        this.f258323h = new ArrayList();
        this.f258324i = new ArrayList();
    }

    public final void h(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "bottomSheet");
        if (r101 != this.f258320e) goto L5;
        return;
    L5:
        this.f258320e = r101;
        int r102 = this.f258324i.size();
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L8;
        ((b) ListProtector.get(this.f258324i, r103)).e(r100, r101);
        r103 = r103 + 1;
        goto L6
    }

    public final void i(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "bottomSheet");
        int r102 = this.f258324i.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        ((b) ListProtector.get(this.f258324i, r103)).h(r100, r101);
        r103 = r103 + 1;
        goto L3
    }
}
