package com.larksuite.framework.ui;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import com.larksuite.component.decoration.avatar.DecoratedAvatar;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class a extends TouchDelegate {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Rect f285842b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap<Integer, TouchDelegate> f285843a;

    /* JADX INFO: renamed from: com.larksuite.framework.ui.a$a, reason: collision with other inner class name */
    public static final class C3929a {

        /* JADX INFO: renamed from: com.larksuite.framework.ui.a$a$a, reason: collision with other inner class name */
        public static final class ViewOnLayoutChangeListenerC3930a implements View.OnLayoutChangeListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ View f285844a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ View f285845b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ int f285846c;

            public ViewOnLayoutChangeListenerC3930a(View r100, View r101, int r102) {
                this.f285844a = r100;
                this.f285845b = r101;
                this.f285846c = r102;
            }

            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
                r100.removeOnLayoutChangeListener(this);
                if (this.f285844a.getTouchDelegate() != null) goto L5;
                this.f285844a.setTouchDelegate(new a(this.f285844a));
            L5:
                TouchDelegate r109 = this.f285844a.getTouchDelegate();
                if ((r109 instanceof a) == false) goto L8;
                a r110 = (a) r109;
            L9:
                if (r110 == null) goto L13;
                Rect r111 = new Rect();
                this.f285845b.getHitRect(r111);
                int r112 = r111.left;
                int r113 = this.f285846c;
                r111.left = r112 - r113;
                r111.top -= r113;
                r111.right += r113;
                r111.bottom += r113;
                View r114 = this.f285845b;
                TouchDelegate r115 = new TouchDelegate(r111, this.f285845b);
                Intrinsics.checkNotNullParameter(r114, "view");
                Intrinsics.checkNotNullParameter(r115, "delegate");
                r110.f285843a.put(Integer.valueOf(r114.hashCode()), r115);
                return;
            L13:
                return;
            L8:
                r110 = null;
                goto L9
            }
        }

        public static void b(DecoratedAvatar r100) {
            Intrinsics.checkNotNullParameter(r100, "<this>");
            Object r101 = r100.getParent();
            a r102 = null;
            if ((r101 instanceof View) == false) goto L5;
            View r103 = (View) r101;
        L6:
            if (r103 != null) goto L8;
            return;
        L8:
            TouchDelegate r104 = r103.getTouchDelegate();
            if ((r104 instanceof a) == false) goto L11;
            r102 = (a) r104;
        L11:
            if (r102 == null) goto L14;
            Intrinsics.checkNotNullParameter(r100, "view");
            r102.f285843a.remove(Integer.valueOf(r100.hashCode()));
            return;
        L14:
            return;
        L5:
            r103 = null;
            goto L6
        }

        public static void a(View r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "<this>");
            Object r102 = r100.getParent();
            a r103 = null;
            if ((r102 instanceof View) == false) goto L5;
            View r104 = (View) r102;
        L6:
            if (r104 != null) goto L9;
            return;
        L9:
            if (r100.isLaidOut() == true) goto L11;
        L21:
            r100.addOnLayoutChangeListener(new ViewOnLayoutChangeListenerC3930a(r104, r100, r101));
            return;
        L11:
            if (r100.isLayoutRequested() == true) goto L21;
            if (r104.getTouchDelegate() != null) goto L15;
            r104.setTouchDelegate(new a(r104));
        L15:
            TouchDelegate r105 = r104.getTouchDelegate();
            if ((r105 instanceof a) == false) goto L18;
            r103 = (a) r105;
        L18:
            if (r103 == null) goto L24;
            Rect r106 = new Rect();
            r100.getHitRect(r106);
            r106.left -= r101;
            r106.top -= r101;
            r106.right += r101;
            r106.bottom += r101;
            TouchDelegate r107 = new TouchDelegate(r106, r100);
            Intrinsics.checkNotNullParameter(r100, "view");
            Intrinsics.checkNotNullParameter(r107, "delegate");
            r103.f285843a.put(Integer.valueOf(r100.hashCode()), r107);
            return;
        L24:
            return;
        L5:
            r104 = null;
            goto L6
        }
    }

    static {
        f285842b = new Rect();
    }

    public a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super(f285842b, r100);
        this.f285843a = new LinkedHashMap();
    }

    @Override // android.view.TouchDelegate
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        float r101 = r100.getX();
        float r102 = r100.getY();
        Iterator<TouchDelegate> r103 = this.f285843a.values().iterator();
    L4:
        if (r103.hasNext() == false) goto L9;
        TouchDelegate r104 = r103.next();
        r100.setLocation(r101, r102);
        if (r104.onTouchEvent(r100) == false) goto L4;
        return true;
    L9:
        return false;
    }

    @Override // android.view.TouchDelegate
    public final boolean onTouchExplorationHoverEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        float r101 = r100.getX();
        float r102 = r100.getY();
        Iterator<TouchDelegate> r103 = this.f285843a.values().iterator();
    L4:
        if (r103.hasNext() == false) goto L9;
        TouchDelegate r104 = r103.next();
        r100.setLocation(r101, r102);
        if (r104.onTouchExplorationHoverEvent(r100) == false) goto L4;
        return true;
    L9:
        return false;
    }
}
