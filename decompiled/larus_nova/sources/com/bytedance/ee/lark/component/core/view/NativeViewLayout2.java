package com.bytedance.ee.lark.component.core.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import as5.b;
import com.bytedance.ee.lark.component.AbstractNativeComponent;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes19.dex */
public class NativeViewLayout2 extends FrameLayout implements cs5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f242769a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f242770b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f242771c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f242772d;

    public class a implements as5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NativeViewLayout2 f242773a;

        public a(NativeViewLayout2 r100) {
            this.f242773a = r100;
        }

        @Override // as5.a
        public final void a(tr5.a r100) {
            if (TextUtils.equals(this.f242773a.f242770b, r100.getViewId()) == false) goto L10;
            Log.i("NativeViewLayout2", "onDataRemoved, viewId=" + r100.getViewId());
            r100.onRemove();
            View r101 = this.f242773a.f242771c;
            if (r101 != null) goto L7;
            return;
        L7:
            if (r101.getParent() == null) goto L12;
            ((ViewGroup) this.f242773a.f242771c.getParent()).removeView(this.f242773a.f242771c);
            return;
        L12:
            return;
        }

        @Override // as5.a
        public final void b(tr5.a r100) {
            if (r100 != null) goto L7;
            Log.e("NativeViewLayout2", "onDataUpdated, nativeComponent is null");
            return;
        L7:
            if (TextUtils.equals(this.f242773a.f242770b, r100.getViewId()) == true) goto L9;
            return;
        L9:
            if (this.f242773a.f242771c == null) goto L13;
            Log.i("NativeViewLayout2", "onDataUpdated, viewId=" + r100.getViewId());
            r100.onUpdateView(this.f242773a.f242771c, r100.getData());
            return;
        }

        @Override // as5.a
        public final void c(AbstractNativeComponent r100) {
            String r101 = r100.getViewId();
            if (TextUtils.equals(this.f242773a.f242770b, r101) == false) goto L11;
            Log.i("NativeViewLayout2", "onDataAdded, viewId=" + r101);
            if (this.f242773a.f242771c == null) goto L9;
            Log.w("NativeViewLayout2", "onDataAdded nativeView not null");
            if (this.f242773a.f242771c.getParent() == null) goto L9;
            Log.w("NativeViewLayout2", "onDataAdded nativeView not null");
            ((ViewGroup) this.f242773a.f242771c.getParent()).removeView(this.f242773a.f242771c);
        L9:
            NativeViewLayout2 r102 = this.f242773a;
            r102.f242771c = r100.onCreateView(r102.getContext(), r100.getData());
            NativeViewLayout2 r103 = this.f242773a;
            r103.addView(r103.f242771c);
            return;
        }
    }

    @Override // cs5.a
    public final void b() {
        b r100 = this.f242769a;
        if (r100 == null) goto L8;
        a r101 = this.f242772d;
        if (r101 == null) goto L9;
        r100.f16129a.remove(r101);
        return;
    L9:
        return;
    }

    public NativeViewLayout2(Context r100) {
        super(r100);
        this.f242772d = new a(this);
    }

    @Override // cs5.a
    public final void a(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L6;
        this.f242770b = r100;
        return;
    }

    @Override // cs5.a
    public void setNativeComponentProvider(b r100) {
        b r101 = this.f242769a;
        if (r101 == null) goto L5;
        a r102 = this.f242772d;
        r101.f16129a.remove(r102);
    L5:
        this.f242769a = r100;
        a r103 = this.f242772d;
        r100.f16129a.add(r103);
    }

    public NativeViewLayout2(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f242772d = new a(this);
    }

    public NativeViewLayout2(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f242772d = new a(this);
    }
}
