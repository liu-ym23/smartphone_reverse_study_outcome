package com.bytedance.ee.bear.sheet.inputbar.toolbar;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.sheet.inputbar.editor.SheetInputData;
import com.bytedance.ee.util.ui.n;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.List;
import wm5.k1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class ToolbarItemAdapter extends RecyclerView.Adapter<b> {
    public static final String[] e = null;
    public a a;
    public final List<SheetInputData.SheetToolbarItem> b;
    public boolean c;
    public int d;

    public interface a {
    }

    public static class b extends RecyclerView.ViewHolder {
        public b(ToolbarItemView r1) {
            super(r1);
        }
    }

    static {
        e = new String[]{"ABC", "123", "=", "+", "-", "/", "*", ".", ",", ";", "(", ")", "$", "!", ":", "^", "%", "&", "<", ">", "{", "}"};
    }

    public final int getItemCount() {
        if (this.c == false) goto L6;
        return e.length;
    L6:
        return ((ArrayList) this.b).size();
    }

    public ToolbarItemAdapter() {
        this.b = new ArrayList();
        this.d = -1;
    }

    public final void y2(int r4) {
        if (r4 >= 0) goto L4;
        return;
    L4:
        if (r4 >= getItemCount()) goto L35;
        int r0 = this.d;
        if (r4 != r0) goto L9;
        return;
    L9:
        if (this.c == true) goto L11;
        SheetInputData.SheetToolbarItem r1 = (SheetInputData.SheetToolbarItem) ListProtector.get(this.b, r4);
        if (r1.isHasSelectedState() == true) goto L26;
        return;
    L26:
        int r2 = this.d;
        this.d = r4;
        notifyItemChanged(r4);
        if (r2 == (-1)) goto L29;
        notifyItemChanged(r2);
    L29:
        a r5 = this.a;
        if (r5 == null) goto L36;
        k1 r6 = (k1) r5;
        r6.a(ToolbarItemEnum.getToolbarItemEnumByName(r1.getId()));
        return;
    L36:
        return;
    L11:
        if (r4 <= 1) goto L13;
        return;
    L13:
        this.d = r4;
        notifyItemChanged(r4);
        if (r0 == (-1)) goto L16;
        notifyItemChanged(r0);
    L16:
        a r3 = this.a;
        if (r3 == null) goto L33;
        if (r4 != 0) goto L20;
        ToolbarItemEnum r7 = ToolbarItemEnum.text;
    L21:
        ((k1) r3).a(r7);
        return;
    L20:
        r7 = ToolbarItemEnum.number;
        goto L21
    L33:
        return;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r10, int r11) {
        View r12 = ((RecyclerView.ViewHolder) ((b) r10)).itemView;
        if ((r12 instanceof ToolbarItemView) == false) goto L56;
        ToolbarItemView r13 = (ToolbarItemView) r12;
        ViewGroup.LayoutParams r0 = r13.getLayoutParams();
        if (r0 == null) goto L21;
        Context r1 = r13.getContext();
        if ((r1 instanceof Activity) == false) goto L16;
        View r2 = ((Activity) r1).getWindow().getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L13;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r3 = ThreadMethodProxy.currentThread();
        if (r3 == com.larus.home.impl.utils.c.a) goto L13;
        com.larus.home.impl.utils.c.a(r3, "getDecorView");
    L13:
        int r4 = n.a;
        Rect r5 = new Rect();
        if (r2 == null) goto L17;
        r2.getWindowVisibleDisplayFrame(r5);
    L17:
        if (r5 == null) goto L19;
        int r6 = r5.width();
    L20:
        r0.width = ((r6 - r13.getResources().getDimensionPixelSize(2131168163)) - r13.getResources().getDimensionPixelSize(2131168165)) / 6;
        r13.setLayoutParams(r0);
        goto L21
    L19:
        r6 = n.v();
        goto L20
    L16:
        r5 = null;
    L21:
        boolean r7 = true;
        int r8 = 8;
        float r9 = 1.0f;
        if (this.c == false) goto L39;
        String r14 = e[r11];
        if (r0 == null) goto L30;
        Context r15 = r13.getContext();
        if (r11 >= 2) goto L28;
        float r16 = 62.0f;
    L29:
        Resources r17 = r15.getResources();
        r0.width = (int) TypedValue.applyDimension(1, r16, WindowDisplayMetricsOverride.apply(r17, r17.getDisplayMetrics()));
        r13.setLayoutParams(r0);
        goto L30
    L28:
        r16 = 48.0f;
    L30:
        r13.setText(r14);
        if (r11 <= 0) goto L33;
        boolean r18 = true;
    L34:
        r13.setLeadingDividerVisible(r18);
        r13.setAlpha(1.0f);
        r13.setBadgeVisibility(8);
        if (r11 == this.d) goto L38;
        r7 = false;
    L38:
        r13.setSelected(r7);
        r13.setTag(r14);
        r13.setOnClickListener(new c(this, r13, r14));
        return;
    L33:
        r18 = false;
        goto L34
    L39:
        SheetInputData.SheetToolbarItem r19 = (SheetInputData.SheetToolbarItem) ListProtector.get(this.b, r11);
        ToolbarItemEnum r20 = ToolbarItemEnum.valueOf(r19.getId());
        r13.setLeadingDividerVisible(false);
        r13.setIconDrawable(r13.getContext().getDrawable(r20.iconRes));
        if (r20.alpha == false) goto L42;
        r9 = 0.5f;
    L42:
        r13.setAlpha(r9);
        r13.setOnClickListener(new d(this, r20, r13, r11));
        if (r20.adminLimit == false) goto L46;
        return;
    L46:
        if (r19.isBadged() == false) goto L48;
        r8 = 0;
    L48:
        r13.setBadgeVisibility(r8);
        if (r11 == this.d) goto L51;
    L53:
        r7 = false;
    L54:
        r13.setSelected(r7);
        r13.setTag(r19.getId());
        return;
    L51:
        if (r20.selectable == false) goto L53;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r2, int r3) {
        ToolbarItemView r4 = new ToolbarItemView(r2.getContext());
        r4.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        return new b(r4);
    }
}
