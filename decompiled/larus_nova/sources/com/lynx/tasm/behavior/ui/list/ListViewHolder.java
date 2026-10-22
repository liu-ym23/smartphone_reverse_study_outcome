package com.lynx.tasm.behavior.ui.list;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.ui.view.UIComponent;
import java.util.HashMap;

/* JADX INFO: loaded from: classes32.dex */
public class ListViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f382620a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f382621b;

    public interface a {
    }

    public static class b extends FrameLayout {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f382622a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public UIComponent f382623b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f382624c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f382625d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f382626e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f382627f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f382628g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public a f382629h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f382630i;

        public b(Context r100) {
            super(r100);
            this.f382622a = 0;
            this.f382625d = 400;
            this.f382626e = -1;
            this.f382627f = false;
            this.f382628g = 0;
            this.f382630i = 0;
        }

        @Override // android.view.View
        public final void setLayoutDirection(int r100) {
            this.f382630i = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.widget.FrameLayout, android.view.View
        public final void onMeasure(int r100, int r101) {
            if (this.f382622a != 0) goto L17;
            int r102 = this.f382626e;
            if (r102 > 0) goto L8;
            r102 = View.MeasureSpec.getSize(r100);
        L8:
            int r103 = this.f382625d;
            if (this.f382627f == false) goto L41;
            UIComponent r104 = this.f382623b;
            if (r104 == null) goto L41;
            if (r104.getView() == 0) goto L41;
            if (((com.lynx.tasm.behavior.ui.view.a) this.f382623b.getView()).isLayoutRequested() == false) goto L41;
            this.f382623b.measureChildren();
        L41:
            setMeasuredDimension(r102, r103);
            int r105 = UIList.L0;
            return;
        L17:
            UIComponent r106 = this.f382623b;
            if (r106 == null) goto L40;
            r106.measure();
            if (2 != this.f382622a) goto L22;
            this.f382622a = 3;
        L22:
            int r107 = this.f382623b.getWidth() + this.f382623b.getMarginLeft();
            r102 = this.f382623b.getMarginRight() + r107;
            r103 = ((this.f382623b.getHeight() + this.f382623b.getMarginTop()) + this.f382623b.getMarginBottom()) + this.f382628g;
            a r108 = this.f382629h;
            if (r108 == null) goto L41;
            String r109 = this.f382623b.f383173b;
            c r110 = (c) r108;
            r110.getClass();
            if (TextUtils.isEmpty(r109) == true) goto L41;
            HashMap<String, Integer> r111 = r110.f382729a.f382692u;
            if (r111 == null) goto L41;
            if (r111.containsKey(r109) == false) goto L41;
            int r112 = 0;
        L33:
            if (r112 >= r110.f382729a.B.size()) goto L41;
            int r113 = r110.f382729a.f382692u.get(r109).intValue();
            if (ListProtector.get(r110.f382729a.B, r112) == null) goto L39;
            if (((HashMap) ListProtector.get(r110.f382729a.B, r112)).containsKey(Integer.valueOf(r113)) == false) goto L39;
            ((HashMap) ListProtector.get(r110.f382729a.B, r112)).put(Integer.valueOf(r113), Integer.valueOf(r103));
        L39:
            r112 = r112 + 1;
            goto L33
        L40:
            r102 = getMeasuredWidth();
            r103 = getMeasuredHeight();
            goto L41
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r8v12, types: [android.view.View] */
        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        public final void onLayout(boolean r100, int r101, int r110, int r111, int r112) {
            int r102 = UIList.L0;
            UIComponent r103 = this.f382623b;
            if (r103 == null) goto L17;
            r103.setTop(0);
            this.f382623b.setLeft(0);
            this.f382623b.layout();
            int r104 = this.f382623b.getMarginLeft();
            int r105 = this.f382623b.getMarginTop();
            int r106 = this.f382623b.getWidth();
            int r107 = this.f382623b.getHeight();
            if (this.f382630i != 1) goto L7;
            int r108 = (r111 - r101) - r106;
        L8:
            ((com.lynx.tasm.behavior.ui.view.a) this.f382623b.getView()).layout(r104 + r108, r105, (r104 + r106) + r108, r107 + r105);
            if (this.f382623b.getOverflow() != 0) goto L11;
        L13:
            Rect r109 = ViewCompat.getClipBounds(this.f382623b.getView());
            if (r109 == null) goto L18;
            r109.set(Math.min(r109.left, r101), Math.min(r109.top, r110), Math.max(r109.right, r111), Math.max(r109.bottom, r112));
            ViewCompat.setClipBounds(this, r109);
            return;
        L18:
            return;
        L11:
            if (getParent() == null) goto L13;
            ((ViewGroup) getParent()).setClipChildren(false);
            goto L13
        L7:
            r108 = 0;
            goto L8
        }
    }

    public final void T3() {
        b r100 = this.f382620a;
        UIComponent r101 = r100.f382623b;
        if (r101 == null) goto L13;
        String r102 = r101.f383173b;
        r100.removeAllViews();     // Catch: NullPointerException -> L7
    L9:
        this.f382620a.f382623b = null;
        return;
    L7:
        e = move-exception;
        LLog.e("UIList", "ListViewHolder removeUIComponent.the itemKey is " + r102 + " errorMessage:" + e.getMessage());
        goto L9
    }

    public ListViewHolder(b r100) {
        super(r100);
        this.f382621b = 0;
        this.f382620a = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1, types: [android.view.View] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void U3(UIComponent r100) {
        this.f382620a.f382623b = r100;
        FrameLayout.LayoutParams r101 = new FrameLayout.LayoutParams(-1, -2);
        this.f382620a.addView(r100.getView(), r101);
        b r102 = this.f382620a;
        r102.f382624c = getAdapterPosition();
    }
}
