package com.bytedance.ee.bear.list.preload;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.ee.bear.widgets.PublicTagView;
import com.bytedance.ee.bear.widgets.TemplateTagView;
import com.bytedance.ee.bear.widgets.UpgradeTagView;
import com.bytedance.ee.bear.widgets.crosstenant.ExternalView;
import com.bytedance.ee.bear.widgets.universedesign.SpaceTagTextView;
import com.bytedance.ee.util.ui.l;
import com.bytedance.ee.util.ui.n;
import com.larksuite.component.universe_design.tag.UDTagsDrawable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class ListTitleView extends LinearLayout {
    public TextView a;
    public ExternalView b;
    public UpgradeTagView c;
    public PublicTagView d;
    public TemplateTagView e;
    public ImageView f;
    public CharSequence g;
    public int h;
    public int i;
    public SpaceTagTextView j;

    public boolean getExternalVisible() {
        AppCompatTextView r0 = this.b;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.getVisibility() != 0) goto L7;
        return true;
    }

    public boolean getPublicVisible() {
        AppCompatTextView r0 = this.d;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.getVisibility() != 0) goto L7;
        return true;
    }

    public boolean getSharedVisible() {
        AppCompatTextView r0 = this.j;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.getVisibility() != 0) goto L7;
        return true;
    }

    public boolean getStarVisible() {
        ImageView r0 = this.f;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.getVisibility() != 0) goto L7;
        return true;
    }

    public boolean getUpgradeVisible() {
        AppCompatTextView r0 = this.c;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.getVisibility() != 0) goto L7;
        return true;
    }

    public CharSequence getTitle() {
        return this.g;
    }

    public ListTitleView(Context r2) {
        super(r2);
        n.d(16);
        this.i = 1;
        a(r2, null);
    }

    /* JADX WARN: Type inference failed for: r3v4, types: [android.widget.TextView, com.bytedance.ee.bear.widgets.crosstenant.ExternalView] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void setExternalVisible(boolean r6) {
        AppCompatTextView r0 = this.b;
        int r1 = 0;
        if (r0 == null) goto L8;
        if (r6 == true) goto L7;
        r1 = 8;
    L7:
        r0.setVisibility(r1);
        return;
    L8:
        if (r6 == false) goto L15;
        Context r7 = getContext();
        if (this.b != null) goto L12;
        LinearLayout.LayoutParams r2 = new LinearLayout.LayoutParams(-2, -2);
        r2.gravity = 17;
        r2.leftMargin = getResources().getDimensionPixelSize(2131166501);
        ?? r3 = new ExternalView(r7);
        this.b = r3;
        r3.setVisibility(8);
        addView(this.b, r2);
    L12:
        this.b.setVisibility(0);
        return;
    }

    /* JADX WARN: Type inference failed for: r3v4, types: [android.widget.TextView, com.bytedance.ee.bear.widgets.PublicTagView] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void setPublicVisible(boolean r6) {
        Context r0 = getContext();
        int r2 = 8;
        if (this.d != null) goto L5;
        LinearLayout.LayoutParams r1 = new LinearLayout.LayoutParams(-2, -2);
        r1.gravity = 17;
        r1.leftMargin = getResources().getDimensionPixelSize(2131166501);
        ?? r3 = new PublicTagView(r0);
        this.d = r3;
        r3.setVisibility(8);
        addView(this.d, r1);
    L5:
        AppCompatTextView r4 = this.d;
        if (r6 == false) goto L8;
        r2 = 0;
    L8:
        r4.setVisibility(r2);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void setSharedVisible(boolean r7) {
        Context r0 = getContext();
        int r2 = 8;
        if (this.j != null) goto L5;
        LinearLayout.LayoutParams r1 = new LinearLayout.LayoutParams(-2, -2);
        r1.gravity = 17;
        r1.leftMargin = getResources().getDimensionPixelSize(2131166501);
        SpaceTagTextView r3 = new SpaceTagTextView(getContext());
        this.j = r3;
        UDTagsDrawable.d.a r4 = new UDTagsDrawable.d.a(r0);
        r4.c = getContext().getString(2131889828);
        r4.c(UDTagsDrawable.TagColorSet.BLUE);
        r3.y(r4.b());
        this.j.setVisibility(8);
        addView(this.j, r1);
    L5:
        AppCompatTextView r5 = this.j;
        if (r7 == false) goto L8;
        r2 = 0;
    L8:
        r5.setVisibility(r2);
    }

    public void setStarVisible(boolean r6) {
        ImageView r0 = this.f;
        int r1 = 0;
        if (r0 == null) goto L8;
        if (r6 == true) goto L7;
        r1 = 8;
    L7:
        r0.setVisibility(r1);
        return;
    L8:
        if (r6 == false) goto L15;
        Context r7 = getContext();
        if (this.f != null) goto L12;
        LinearLayout.LayoutParams r2 = new LinearLayout.LayoutParams(-2, -2);
        r2.gravity = 17;
        r2.width = getResources().getDimensionPixelSize(2131166500);
        r2.height = getResources().getDimensionPixelSize(2131166500);
        r2.leftMargin = getResources().getDimensionPixelSize(2131166501);
        ImageView r3 = new ImageView(r7);
        this.f = r3;
        r3.setBackground(getResources().getDrawable(2131254138));
        l.b(this.f, 2131101124);
        this.f.setVisibility(8);
        addView(this.f, r2);
    L12:
        this.f.setVisibility(0);
        return;
    }

    /* JADX WARN: Type inference failed for: r3v4, types: [android.widget.TextView, com.bytedance.ee.bear.widgets.TemplateTagView] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void setTemplateVisible(boolean r6) {
        AppCompatTextView r0 = this.e;
        int r1 = 0;
        if (r0 == null) goto L8;
        if (r6 == true) goto L7;
        r1 = 8;
    L7:
        r0.setVisibility(r1);
        return;
    L8:
        if (r6 == false) goto L15;
        Context r7 = getContext();
        if (this.e != null) goto L12;
        LinearLayout.LayoutParams r2 = new LinearLayout.LayoutParams(-2, -2);
        r2.gravity = 17;
        r2.leftMargin = getResources().getDimensionPixelSize(2131166501);
        ?? r3 = new TemplateTagView(r7);
        this.e = r3;
        r3.setVisibility(8);
        addView(this.e, r2);
    L12:
        this.e.setVisibility(0);
        return;
    }

    public void setTitle(int r2) {
        String r3 = getResources().getString(r2);
        this.g = r3;
        this.a.setText(r3);
    }

    public void setTitleColor(int r2) {
        this.a.setTextColor(r2);
    }

    public void setTitleMaxLines(int r3) {
        if (r3 != 1) goto L5;
        this.a.setSingleLine(true);
        this.a.setMaxLines(1);
        return;
    L5:
        this.a.setSingleLine(false);
        this.a.setMaxLines(r3);
    }

    public void setTitleSize(float r2) {
        this.a.setTextSize(r2);
    }

    /* JADX WARN: Type inference failed for: r3v4, types: [android.widget.TextView, com.bytedance.ee.bear.widgets.UpgradeTagView] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void setUpgradeVisible(boolean r6) {
        AppCompatTextView r0 = this.c;
        int r1 = 0;
        if (r0 == null) goto L8;
        if (r6 == true) goto L7;
        r1 = 8;
    L7:
        r0.setVisibility(r1);
        return;
    L8:
        if (r6 == false) goto L15;
        Context r7 = getContext();
        if (this.c != null) goto L12;
        LinearLayout.LayoutParams r2 = new LinearLayout.LayoutParams(-2, -2);
        r2.gravity = 17;
        r2.leftMargin = getResources().getDimensionPixelSize(2131166501);
        ?? r3 = new UpgradeTagView(r7);
        this.c = r3;
        r3.setVisibility(8);
        addView(this.c, r2);
    L12:
        this.c.setVisibility(0);
        return;
    }

    public void setTitle(CharSequence r2) {
        this.g = r2;
        this.a.setText(r2);
    }

    public ListTitleView(Context r2, AttributeSet r3) {
        super(r2, r3);
        n.d(16);
        this.i = 1;
        a(r2, r3);
    }

    public final void a(Context r7, AttributeSet r8) {
        this.h = r7.getResources().getColor(2131106622);
        if (r8 == null) goto L5;
        TypedArray r9 = r7.obtainStyledAttributes(r8, new int[]{2130974575, 2130974583, 2130974585, 2130974586, 2130974587, 2130974588});
        this.g = r9.getString(5);
        r9.getDimension(2, getResources().getDimension(2131166502));
        this.h = r9.getColor(0, getResources().getColor(2131106622));
        this.i = r9.getInt(1, 1);
        r9.recycle();
    L5:
        setOrientation(0);
        setGravity(16);
        LinearLayout.LayoutParams r1 = new LinearLayout.LayoutParams(-2, -2);
        r1.gravity = 17;
        TextView r4 = new TextView(r7);
        this.a = r4;
        r4.setEllipsize(TextUtils.TruncateAt.END);
        this.a.setGravity(16);
        this.a.setTextSize(2, 16.0f);
        this.a.setTextColor(this.h);
        if (TextUtils.isEmpty(this.g) == true) goto L9;
        this.a.setText(this.g);
    L9:
        if (this.i != 1) goto L11;
        this.a.setSingleLine(true);
    L12:
        addView(this.a, r1);
        return;
    L11:
        this.a.setSingleLine(false);
        this.a.setMaxLines(this.i);
        goto L12
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
        int r0 = 0;
        int r1 = 0;
    L4:
        if (r1 >= getChildCount()) goto L6;
        measureChildWithMargins(getChildAt(r1), r10, 0, r11, 0);
        r1 = r1 + 1;
        goto L4
    L6:
        ImageView r12 = this.f;
        if (r12 != null) goto L9;
    L11:
        int r13 = 0;
    L12:
        AppCompatTextView r14 = this.b;
        if (r14 != null) goto L15;
    L17:
        int r2 = 0;
    L18:
        AppCompatTextView r15 = this.c;
        if (r15 != null) goto L21;
    L23:
        int r3 = 0;
    L24:
        AppCompatTextView r16 = this.d;
        if (r16 != null) goto L27;
    L29:
        int r4 = 0;
    L30:
        AppCompatTextView r17 = this.j;
        if (r17 != null) goto L33;
    L35:
        int r5 = 0;
    L36:
        AppCompatTextView r18 = this.e;
        if (r18 != null) goto L39;
    L41:
        ViewGroup.MarginLayoutParams r19 = (ViewGroup.MarginLayoutParams) this.a.getLayoutParams();
        int r6 = (this.a.getMeasuredWidth() + r19.leftMargin) + r19.rightMargin;
        int r110 = getMeasuredWidth();
        int r7 = getMeasuredHeight();
        int r8 = (((((r110 - r2) - r3) - r4) - r13) - r0) - r5;
        if (r6 <= r8) goto L44;
        r6 = r8;
    L44:
        int r9 = View.MeasureSpec.makeMeasureSpec(r6, 1073741824);
        int r20 = View.MeasureSpec.makeMeasureSpec(this.a.getMeasuredHeight(), 1073741824);
        this.a.measure(r9, r20);
        setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(r110, 1073741824), View.MeasureSpec.makeMeasureSpec(r7, 1073741824));
        return;
    L39:
        if (r18.getVisibility() != 0) goto L41;
        ViewGroup.MarginLayoutParams r111 = (ViewGroup.MarginLayoutParams) this.e.getLayoutParams();
        r0 = (this.e.getMeasuredWidth() + r111.leftMargin) + r111.rightMargin;
        goto L41
    L33:
        if (r17.getVisibility() != 0) goto L35;
        ViewGroup.MarginLayoutParams r112 = (ViewGroup.MarginLayoutParams) this.j.getLayoutParams();
        r5 = (this.j.getMeasuredWidth() + r112.leftMargin) + r112.rightMargin;
        goto L36
    L27:
        if (r16.getVisibility() != 0) goto L29;
        ViewGroup.MarginLayoutParams r113 = (ViewGroup.MarginLayoutParams) this.d.getLayoutParams();
        r4 = (this.d.getMeasuredWidth() + r113.leftMargin) + r113.rightMargin;
        goto L30
    L21:
        if (r15.getVisibility() != 0) goto L23;
        ViewGroup.MarginLayoutParams r114 = (ViewGroup.MarginLayoutParams) this.c.getLayoutParams();
        r3 = (this.c.getMeasuredWidth() + r114.leftMargin) + r114.rightMargin;
        goto L24
    L15:
        if (r14.getVisibility() != 0) goto L17;
        ViewGroup.MarginLayoutParams r115 = (ViewGroup.MarginLayoutParams) this.b.getLayoutParams();
        r2 = (this.b.getMeasuredWidth() + r115.leftMargin) + r115.rightMargin;
        goto L18
    L9:
        if (r12.getVisibility() != 0) goto L11;
        ViewGroup.MarginLayoutParams r116 = (ViewGroup.MarginLayoutParams) this.f.getLayoutParams();
        r13 = (this.f.getMeasuredWidth() + r116.leftMargin) + r116.rightMargin;
        goto L12
    }

    public ListTitleView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        n.d(16);
        this.i = 1;
        a(r1, r2);
    }
}
