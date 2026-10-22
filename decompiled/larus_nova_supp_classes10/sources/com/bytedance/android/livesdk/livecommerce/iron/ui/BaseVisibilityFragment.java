package com.bytedance.android.livesdk.livecommerce.iron.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/iron/ui/BaseVisibilityFragment;", "Landroidx/fragment/app/Fragment;", "Landroid/view/View$OnAttachStateChangeListener;", "Lcom/bytedance/android/livesdk/livecommerce/iron/ui/l;", "<init>", "()V", "a", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public class BaseVisibilityFragment extends Fragment implements View.OnAttachStateChangeListener, l {
    public boolean d;
    public boolean e;
    public BaseVisibilityFragment f;
    public final ArrayList<l> g;

    public static final class a {
    }

    static {
    }

    public final void onDetach() {
        T90("onDetach");
        BaseVisibilityFragment r0 = this.f;
        if (r0 == null) goto L5;
        r0.g.remove(this);
    L5:
        super.onDetach();
        S90(false);
        this.f = null;
    }

    public final void onPause() {
        T90("onPause");
        super.onPause();
        this.d = false;
        S90(false);
    }

    public final void onResume() {
        T90("onResume");
        super.onResume();
        this.d = true;
        S90(true);
    }

    public BaseVisibilityFragment() {
        this.g = new ArrayList();
    }

    public final void S90(boolean r9) {
        if (r9 != this.e) goto L5;
        return;
    L5:
        BaseVisibilityFragment r10 = this.f;
        if (r10 != null) goto L8;
        boolean r11 = this.d;
    L11:
        boolean r1 = super.isVisible();
        boolean r2 = getUserVisibleHint();
        if (r11 == false) goto L16;
        if (r1 == false) goto L16;
        if (r2 == false) goto L16;
        boolean r4 = true;
    L17:
        StringCompanionObject r5 = StringCompanionObject.INSTANCE;
        T90(String.format("==> checkVisibility = %s  ( parent = %s, super = %s, hint = %s )", Arrays.copyOf(new Object[]{Boolean.valueOf(r4), Boolean.valueOf(r11), Boolean.valueOf(r1), Boolean.valueOf(r2)}, 4)));
        if (r4 == this.e) goto L23;
        this.e = r4;
        T90("==> onVisibilityChanged = " + r4);
        Iterator<l> r12 = this.g.iterator();
    L21:
        if (r12.hasNext() == false) goto L25;
        r12.next().qP(r4);
        goto L21
    L25:
        return;
    L23:
        return;
    L16:
        r4 = false;
        goto L17
    L8:
        if (r10 == null) goto L10;
        r11 = r10.e;
        goto L11
    L10:
        r11 = false;
        goto L11
    }

    public final void T90(String r1) {
        toString();
    }

    public final void onAttach(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        T90("onAttach");
        super.onAttach(r2);
        Fragment r3 = getParentFragment();
        if (r3 != null) goto L5;
    L7:
        S90(true);
        return;
    L5:
        if ((r3 instanceof BaseVisibilityFragment) == false) goto L7;
        BaseVisibilityFragment r4 = (BaseVisibilityFragment) r3;
        this.f = r4;
        r4.g.add(this);
        goto L7
    }

    public void onCreate(Bundle r2) {
        T90("onCreate");
        super.onCreate(r2);
    }

    public final void onHiddenChanged(boolean r1) {
        super.onHiddenChanged(r1);
        S90(r1);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
        T90("onViewAttachedToWindow");
        S90(true);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
        T90("onViewDetachedFromWindow");
        r2.removeOnAttachStateChangeListener(this);
        S90(false);
    }

    public void qP(boolean r1) {
        S90(r1);
    }

    public final void setUserVisibleHint(boolean r3) {
        T90("setUserVisibleHint = " + r3);
        super.setUserVisibleHint(r3);
        S90(r3);
    }

    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        r2.addOnAttachStateChangeListener(this);
    }
}
