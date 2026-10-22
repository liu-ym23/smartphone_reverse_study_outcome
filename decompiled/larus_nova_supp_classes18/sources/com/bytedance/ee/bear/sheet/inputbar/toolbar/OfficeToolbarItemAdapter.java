package com.bytedance.ee.bear.sheet.inputbar.toolbar;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.sheet.inputbar.editor.SheetInputData;
import com.bytedance.ee.util.ui.n;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.Contexts;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.List;
import wm5.d0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class OfficeToolbarItemAdapter extends RecyclerView.Adapter<b> {
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

    public OfficeToolbarItemAdapter() {
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
        d0 r6 = (d0) r5;
        r6.a(com.bytedance.ee.bear.sheet_core.inputbar.toolbar.ToolbarItemEnum.getToolbarItemEnumByName(r1.getId()));
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
        com.bytedance.ee.bear.sheet_core.inputbar.toolbar.ToolbarItemEnum r7 = com.bytedance.ee.bear.sheet_core.inputbar.toolbar.ToolbarItemEnum.text;
    L21:
        ((d0) r3).a(r7);
        return;
    L20:
        r7 = com.bytedance.ee.bear.sheet_core.inputbar.toolbar.ToolbarItemEnum.number;
        goto L21
    L33:
        return;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r10, int r11) {
        View r12 = ((RecyclerView.ViewHolder) ((b) r10)).itemView;
        if ((r12 instanceof ToolbarItemView) == false) goto L59;
        ToolbarItemView r13 = (ToolbarItemView) r12;
        ViewGroup.LayoutParams r0 = r13.getLayoutParams();
        boolean r1 = false;
        if (r0 == null) goto L24;
        Context r2 = r13.getContext();
        if ((r2 instanceof Activity) == true) goto L57;
    L19:
        Rect r3 = null;
    L20:
        if (r3 == null) goto L22;
        int r4 = r3.width();
    L23:
        r0.width = ((r4 - r13.getResources().getDimensionPixelSize(2131168163)) - r13.getResources().getDimensionPixelSize(2131168165)) / 6;
        r13.setLayoutParams(r0);
        goto L24
    L22:
        r4 = n.v();
        goto L23
    L57:
        View r5 = Contexts.requireActivity(r2).getWindow().getDecorView();     // Catch: Exception -> L17
        if (com.larus.home.impl.utils.c.e == false) goto L13;
        FLogger.a.i("DecorViewLancet", "getDecorView");     // Catch: Exception -> L17
        Thread r6 = ThreadMethodProxy.currentThread();     // Catch: Exception -> L17
        if (r6 == com.larus.home.impl.utils.c.a) goto L13;
        com.larus.home.impl.utils.c.a(r6, "getDecorView");     // Catch: Exception -> L17
    L13:
        int r7 = n.a;     // Catch: Exception -> L17
        r3 = new Rect();     // Catch: Exception -> L17
        if (r5 == null) goto L20;
        r5.getWindowVisibleDisplayFrame(r3);     // Catch: Exception -> L17
    L17:
        e = move-exception;
        tt5.a.e("OfficeToolbarItemAdapter", "getScreenVisibleRect error", e, false);
    L24:
        int r8 = 8;
        float r9 = 1.0f;
        if (this.c == false) goto L41;
        String r14 = e[r11];
        if (r0 == null) goto L33;
        Context r15 = r13.getContext();
        if (r11 >= 2) goto L31;
        float r16 = 62.0f;
    L32:
        Resources r17 = r15.getResources();
        r0.width = (int) TypedValue.applyDimension(1, r16, WindowDisplayMetricsOverride.apply(r17, r17.getDisplayMetrics()));
        r13.setLayoutParams(r0);
        goto L33
    L31:
        r16 = 48.0f;
    L33:
        r13.setText(r14);
        if (r11 <= 0) goto L36;
        boolean r18 = true;
    L37:
        r13.setLeadingDividerVisible(r18);
        r13.setAlpha(1.0f);
        r13.setBadgeVisibility(8);
        if (r11 != this.d) goto L40;
        r1 = true;
    L40:
        r13.setSelected(r1);
        r13.setTag(r14);
        r13.setOnClickListener(new com.bytedance.ee.bear.sheet.inputbar.toolbar.a(this, r13, r14));
        return;
    L36:
        r18 = false;
        goto L37
    L41:
        SheetInputData.SheetToolbarItem r19 = (SheetInputData.SheetToolbarItem) ListProtector.get(this.b, r11);
        com.bytedance.ee.bear.sheet_core.inputbar.toolbar.ToolbarItemEnum r20 = com.bytedance.ee.bear.sheet_core.inputbar.toolbar.ToolbarItemEnum.valueOf(r19.getId());
        r13.setLeadingDividerVisible(false);
        r13.setIconDrawable(AppCompatResources.getDrawable(r13.getContext(), r20.iconRes));
        if (r20.alpha == false) goto L44;
        r9 = 0.5f;
    L44:
        r13.setAlpha(r9);
        r13.setOnClickListener(new com.bytedance.ee.bear.sheet.inputbar.toolbar.b(this, r20, r13, r11));
        if (r20.adminLimit == false) goto L48;
        return;
    L48:
        if (r19.isBadged() == false) goto L50;
        r8 = 0;
    L50:
        r13.setBadgeVisibility(r8);
        if (r11 == this.d) goto L53;
    L55:
        r13.setSelected(r1);
        r13.setTag(r19.getId());
        return;
    L53:
        if (r20.selectable == false) goto L55;
        r1 = true;
        goto L55
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r2, int r3) {
        ToolbarItemView r4 = new ToolbarItemView(r2.getContext());
        r4.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        return new b(r4);
    }
}
