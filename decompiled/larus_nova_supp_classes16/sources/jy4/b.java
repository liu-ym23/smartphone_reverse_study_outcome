package jy4;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.doc.blockeditpanel.model.BlockEditPanelMenusModel;
import com.bytedance.ee.bear.doc.blockeditpanel.model.CustomColorStates;
import com.bytedance.ee.bear.doc.blockeditpanel.model.CustomEMenuConfig;
import com.bytedance.ee.bear.doc.blockeditpanel.model.EMenuItemConfig;
import com.bytedance.ee.bear.doc.blockeditpanel.view.GradientColorConfig;
import com.bytedance.ee.bear.doc.blockeditpanel.view.GradientTextView;
import com.bytedance.ee.bear.doc.blockeditpanel.view.f;
import com.bytedance.ee.bear.doc.blockeditpanel.view.viewholder.BaseBlockEditMenuViewHolder;
import com.bytedance.ee.util.ui.n;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.CollectionUtils;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b extends BaseBlockEditMenuViewHolder {
    public final ImageView c;
    public final GradientTextView d;

    /* JADX WARN: Type inference failed for: r0v5, types: [android.widget.TextView, com.bytedance.ee.bear.doc.blockeditpanel.view.GradientTextView] */
    public b(View r3) {
        super(r3);
        this.c = (ImageView) r3.findViewById(2131374718);
        ?? r0 = (GradientTextView) r3.findViewById(2131388367);
        this.d = r0;
        r0.setTextColor(r3.getResources().getColor(2131106607));
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
    @Override // com.bytedance.ee.bear.doc.blockeditpanel.view.viewholder.BaseBlockEditMenuViewHolder
    public final void U3(BlockEditPanelMenusModel.BlockEditPanelMenuItem r11) {
        ((RecyclerView.ViewHolder) this).itemView.setTag(r11);
        EMenuItemConfig r0 = EMenuItemConfig.getMenuItemConfigById(r11.getId());
        if (r0 == EMenuItemConfig.UNKNOWN) goto L5;
    L7:
        Context r1 = this.c.getContext();
        CustomEMenuConfig r2 = r11.getCustomConfig();
        if (r2 != null) goto L10;
    L12:
        int r3 = r0.imageRes;
    L14:
        if (r3 == (-1)) goto L16;
        this.c.setImageResource(r3);
    L24:
        this.d.setText(r11.getText());
        ImageView r4 = this.c;
        CustomEMenuConfig r5 = r11.getCustomConfig();
        if (r5 == null) goto L30;
        CustomColorStates r6 = r5.getIconStateColorList();
        if (r6 == null) goto L29;
        r4.setImageTintList(f.e(r6));
    L32:
        this.c.setEnabled(r11.isEnable());
        this.c.setSelected(r11.isSelected());
        AppCompatTextView r7 = this.d;
        CustomEMenuConfig r8 = r11.getCustomConfig();
        if (r8 == null) goto L38;
        if (r8.getTextStateColorList() == null) goto L38;
        r7.setTextColor(f.e(r8.getTextStateColorList()));
    L40:
        EMenuItemConfig.c r9 = r0.textGradientColorList;
        if (r9 == null) goto L43;
        this.d.z(r9.a, r9.b);
    L44:
        this.d.setEnabled(r11.isEnable());
        this.d.setSelected(r11.isSelected());
        EMenuItemConfig.c r10 = r0.backgroundGradientColorList;
        int r12 = 0;
        if (r10 == null) goto L57;
        View r13 = ((RecyclerView.ViewHolder) this).itemView;
        StateListDrawable r14 = new StateListDrawable();
        GradientDrawable r16 = new GradientDrawable();
        r16.setCornerRadius(n.d(8));
        GradientColorConfig r17 = r10.b;
        if (r17 != null) goto L49;
    L51:
        GradientDrawable r18 = new GradientDrawable();
        r18.setCornerRadius(n.d(8));
        GradientColorConfig r19 = r10.a;
        if (r19 != null) goto L54;
    L56:
        r14.addState(new int[]{R.attr.state_pressed}, r16);
        r14.addState(new int[0], r18);
        r13.setBackground(r14);
        ((RecyclerView.ViewHolder) this).itemView.setBackgroundTintList(null);
    L64:
        int r20 = r0.bgRes;
        if (r20 == (-1)) goto L67;
        ((RecyclerView.ViewHolder) this).itemView.setBackgroundResource(r20);
    L67:
        ((RecyclerView.ViewHolder) this).itemView.setEnabled(r11.isEnable());
        ((RecyclerView.ViewHolder) this).itemView.setSelected(r11.isSelected());
        View r21 = ((RecyclerView.ViewHolder) this).itemView;
        if (r11.isVisible() == true) goto L71;
        r12 = 4;
    L71:
        r21.setVisibility(r12);
        return;
    L54:
        if (CollectionUtils.isEmpty(r19.a) == true) goto L56;
        V3(r18, r10.a.a);
        goto L56
    L49:
        if (CollectionUtils.isEmpty(r17.a) == true) goto L51;
        V3(r16, r10.b.a);
        goto L51
    L57:
        View r22 = ((RecyclerView.ViewHolder) this).itemView;
        CustomEMenuConfig r23 = r11.getCustomConfig();
        if (r23 == null) goto L63;
        CustomColorStates r24 = r23.getBackgroundStateColorList();
        if (r24 == null) goto L62;
        r22.setBackgroundTintList(f.e(r24));
        goto L64
    L62:
        r22.setBackgroundTintList(null);
        goto L64
    L63:
        f.f(r22, r0.backgroundStateColorList);
        goto L64
    L43:
        this.d.z(null, null);
    L38:
        if (r0.textStateColorList == null) goto L40;
        r7.setTextColor(f.d(((RecyclerView.ViewHolder) this).itemView.getContext(), r0.textStateColorList));
        goto L40
    L29:
        r4.setImageTintList(null);
        goto L32
    L30:
        if (r0 == null) goto L32;
        f.g(r4, r0.iconStateColorList);
        goto L32
    L16:
        Context r26 = this.c.getContext();
        CustomEMenuConfig r27 = r11.getCustomConfig();
        int r28 = n.d(27);
        if (r27 != null) goto L19;
    L21:
        Drawable r29 = r0.getImageDrawable(r26, r28);
    L22:
        if (r29 == null) goto L24;
        this.c.setImageDrawable(r29);
        goto L24
    L19:
        if (r27.getUdIcon() == null) goto L21;
        r29 = ContextCompat.getDrawable(r26, n.n(r26, r27.getUdIcon()));
        goto L22
    L10:
        if (r2.getUdIcon() == null) goto L12;
        r3 = n.n(r1, r2.getUdIcon());
        goto L14
    L5:
        if (r11.getCustomConfig() != null) goto L7;
    }

    public final void V3(GradientDrawable r5, List<Integer> r6) {
        int[] r0 = new int[r6.size()];
        int r2 = 0;
        if (r6.size() <= 1) goto L9;
    L5:
        if (r2 >= r6.size()) goto L7;
        r0[r2] = ContextCompat.getColor(((RecyclerView.ViewHolder) this).itemView.getContext(), ((Integer) ListProtector.get(r6, r2)).intValue());
        r2 = r2 + 1;
        goto L5
    L7:
        r5.setColors(r0);
        r5.setOrientation(GradientDrawable.Orientation.TL_BR);
        return;
    L9:
        if (r6.size() != 1) goto L14;
        r5.setColor(ContextCompat.getColor(((RecyclerView.ViewHolder) this).itemView.getContext(), ((Integer) ListProtector.get(r6, 0)).intValue()));
        return;
    }
}
