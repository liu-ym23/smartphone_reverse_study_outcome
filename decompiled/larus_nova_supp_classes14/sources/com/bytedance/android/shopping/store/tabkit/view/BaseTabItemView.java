package com.bytedance.android.shopping.store.tabkit.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.bytedance.android.shopping.store.tabkit.model.k;
import com.bytedance.android.shopping.store.tabkit.model.o;
import com.bytedance.android.shopping.store.tabkit.model.p;
import com.bytedance.android.shopping.store.tabkit.model.w;
import com.bytedance.android.shopping.store.tabkit.model.x;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010+\u001a\u00020*\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010,\u0012\b\b\u0002\u0010/\u001a\u00020.¢\u0006\u0004\b0\u00101J\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R.\u0010\u000f\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR*\u0010\u0012\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00048\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R.\u0010\u001d\u001a\u0004\u0018\u00010\u00162\b\u0010\b\u001a\u0004\u0018\u00010\u00168\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u0004\u0018\u00010\u001e8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u0004\u0018\u00010\"8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0016\u0010)\u001a\u0004\u0018\u00010&8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(¨\u00062"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/view/BaseTabItemView;", "Landroid/widget/FrameLayout;", "", "update", "", "selected", "setSelected", "Lcom/bytedance/android/shopping/store/tabkit/model/k;", "value", "a", "Lcom/bytedance/android/shopping/store/tabkit/model/k;", "getTab", "()Lcom/bytedance/android/shopping/store/tabkit/model/k;", "setTab", "(Lcom/bytedance/android/shopping/store/tabkit/model/k;)V", "tab", "b", "Z", "isFullScreenState", "()Z", "setFullScreenState", "(Z)V", "Lcom/bytedance/android/shopping/store/tabkit/model/p;", "c", "Lcom/bytedance/android/shopping/store/tabkit/model/p;", "getTabBarStyleConfig", "()Lcom/bytedance/android/shopping/store/tabkit/model/p;", "setTabBarStyleConfig", "(Lcom/bytedance/android/shopping/store/tabkit/model/p;)V", "tabBarStyleConfig", "Lcom/bytedance/android/shopping/store/tabkit/model/w;", "getTabStyle", "()Lcom/bytedance/android/shopping/store/tabkit/model/w;", "tabStyle", "Lcom/bytedance/android/shopping/store/tabkit/model/o;", "getTabBarStyle", "()Lcom/bytedance/android/shopping/store/tabkit/model/o;", "tabBarStyle", "Lcom/bytedance/android/shopping/store/tabkit/model/x;", "getTabStyleConfig", "()Lcom/bytedance/android/shopping/store/tabkit/model/x;", "tabStyleConfig", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class BaseTabItemView extends FrameLayout {
    public k a;
    public boolean b;
    public p c;

    public BaseTabItemView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public BaseTabItemView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public void a(boolean r1, boolean r2) {
    }

    public final x getTabStyleConfig() {
        if (this.b == false) goto L7;
        k r0 = this.a;
        if (r0 != null) goto L17;
        return null;
    L17:
        return r0.o();
    L7:
        k r1 = this.a;
        if (r1 == null) goto L13;
        x r2 = r1.j();
        if (r2 == null) goto L13;
        return r2;
    L13:
        r0 = this.a;
        if (r0 != null) goto L17;
        return null;
    }

    public final o getTabBarStyle() {
        if (isSelected() == false) goto L7;
        p r0 = this.c;
        if (r0 != null) goto L17;
        return null;
    L17:
        return r0.i();
    L7:
        p r1 = this.c;
        if (r1 == null) goto L13;
        o r2 = r1.g();
        if (r2 == null) goto L13;
        return r2;
    L13:
        r0 = this.c;
        if (r0 != null) goto L17;
        return null;
    }

    public final w getTabStyle() {
        if (isSelected() == false) goto L7;
        x r0 = getTabStyleConfig();
        if (r0 != null) goto L17;
        return null;
    L17:
        return r0.c();
    L7:
        x r1 = getTabStyleConfig();
        if (r1 == null) goto L13;
        w r2 = r1.b();
        if (r2 == null) goto L13;
        return r2;
    L13:
        r0 = getTabStyleConfig();
        if (r0 != null) goto L17;
        return null;
    }

    public final void update() {
        a(isSelected(), false);
    }

    public final k getTab() {
        return this.a;
    }

    public final p getTabBarStyleConfig() {
        return this.c;
    }

    public final void setFullScreenState(boolean r2) {
        if (this.b == r2) goto L6;
        this.b = r2;
        update();
        return;
    }

    @Override // android.view.View
    public void setSelected(boolean r2) {
        b(r2, false);
    }

    public final void setTab(k r2) {
        if ((!Intrinsics.areEqual(this.a, r2)) == false) goto L6;
        this.a = r2;
        update();
        return;
    }

    public final void setTabBarStyleConfig(p r2) {
        if ((!Intrinsics.areEqual(this.c, r2)) == false) goto L6;
        this.c = r2;
        update();
        return;
    }

    public final void b(boolean r2, boolean r3) {
        if (isSelected() == r2) goto L5;
        boolean r0 = true;
    L6:
        super.setSelected(r2);
        if (r0 == true) goto L9;
        if (r3 == true) goto L9;
        return;
    L9:
        a(r2, r3);
        return;
    L5:
        r0 = false;
        goto L6
    }

    public BaseTabItemView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.b = true;
        setClipToPadding(false);
        setClipChildren(false);
    }

    public /* synthetic */ BaseTabItemView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
