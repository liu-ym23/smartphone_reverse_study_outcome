package com.bytedance.ee.bear.sheet_core.toolbar2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.document.model.toolbar.ItemIdV2;
import com.bytedance.ee.bear.document.model.toolbar.ItemV2;
import com.bytedance.ee.bear.edit.toolbar.toolbar2.BaseSubToolbarAdapter;
import com.bytedance.ee.bear.sheet.toolbar2.SheetBlockPrimaryItemId;
import com.bytedance.ee.bear.widgets.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SheetBlockAlignAttrAdapter extends BaseSubToolbarAdapter {
    public static final /* synthetic */ int e = 0;

    public class a extends t {
        public final /* synthetic */ ItemV2 c;
        public final /* synthetic */ SheetBlockAlignAttrAdapter d;

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r2) {
            SheetBlockAlignAttrAdapter r3 = this.d;
            int r0 = SheetBlockAlignAttrAdapter.e;
            BaseSubToolbarAdapter.b r4 = ((BaseSubToolbarAdapter) r3).b;
            if (r4 == null) goto L6;
            r4.a(this.c);
            return;
        }

        public a(SheetBlockAlignAttrAdapter r1, ItemV2 r2) {
            this.d = r1;
            this.c = r2;
        }
    }

    public static /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[SheetBlockPrimaryItemId.AlignAttrSecondaryItemId.values().length];
            a = r0;
            r0[SheetBlockPrimaryItemId.AlignAttrSecondaryItemId.horizontalLeft.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            a[SheetBlockPrimaryItemId.AlignAttrSecondaryItemId.horizontalCenter.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            a[SheetBlockPrimaryItemId.AlignAttrSecondaryItemId.horizontalRight.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            a[SheetBlockPrimaryItemId.AlignAttrSecondaryItemId.verticalTop.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            a[SheetBlockPrimaryItemId.AlignAttrSecondaryItemId.verticalCenter.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            a[SheetBlockPrimaryItemId.AlignAttrSecondaryItemId.verticalBottom.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    public SheetBlockAlignAttrAdapter(ItemV2[] r1) {
        super(r1);
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r3, int r4) {
        if ((r3 instanceof BaseSubToolbarAdapter.DividerViewHolder) == true) goto L21;
        ItemV2[] r0 = ((BaseSubToolbarAdapter) this).a;
        if (r0 == null) goto L22;
        ItemV2 r5 = r0[r4];
        BaseSubToolbarAdapter.SubToolbarViewHolder r6 = (BaseSubToolbarAdapter.SubToolbarViewHolder) r3;
        ItemIdV2 r1 = r5.id();
        if ((r1 instanceof SheetBlockPrimaryItemId.AlignAttrSecondaryItemId) == true) goto L10;
    L18:
        int r2 = 0;
    L19:
        A2(r6, r5, r2);
        ((RecyclerView.ViewHolder) r6).itemView.setOnClickListener(new a(this, r5));
        return;
    L10:
        switch(b.a[((SheetBlockPrimaryItemId.AlignAttrSecondaryItemId) r1).ordinal()]) {
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            default: goto L18;
        };
    L12:
        r2 = 2131253872;
        goto L19
    L13:
        r2 = 2131256123;
        goto L19
    L14:
        r2 = 2131256036;
        goto L19
    L15:
        r2 = 2131255561;
        goto L19
    L16:
        r2 = 2131254074;
        goto L19
    L17:
        r2 = 2131254994;
        goto L19
    L22:
        return;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        boolean r1 = true;
        if (r5 == 1) goto L6;
        r1 = false;
    L6:
        if (r1 == false) goto L8;
        int r6 = 2131559940;
    L9:
        View r7 = LayoutInflater.from(r4.getContext()).inflate(r6, r4, false);
        if (r1 == false) goto L13;
        return new BaseSubToolbarAdapter.DividerViewHolder(r7);
    L13:
        return new BaseSubToolbarAdapter.SubToolbarViewHolder(r7);
    L8:
        r6 = 2131559945;
        goto L9
    }
}
