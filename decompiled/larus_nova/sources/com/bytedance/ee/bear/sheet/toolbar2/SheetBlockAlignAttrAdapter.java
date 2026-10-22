package com.bytedance.ee.bear.sheet.toolbar2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.document.model.toolbar.ItemIdV2;
import com.bytedance.ee.bear.document.model.toolbar.ItemV2;
import com.bytedance.ee.bear.edit.component.toolbar2.BaseSubToolbarAdapter;
import com.bytedance.ee.bear.widgets.t;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public class SheetBlockAlignAttrAdapter extends BaseSubToolbarAdapter {

    public class a extends t {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ItemV2 f238406c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ SheetBlockAlignAttrAdapter f238407d;

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r100) {
            BaseSubToolbarAdapter.a r101 = this.f238407d.f226051b;
            if (r101 == null) goto L6;
            r101.a(this.f238406c);
            return;
        }

        public a(SheetBlockAlignAttrAdapter r100, ItemV2 r101) {
            this.f238407d = r100;
            this.f238406c = r101;
        }
    }

    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f238408a = null;

        static {
            int[] r100 = new int[SheetBlockPrimaryItemId.AlignAttrSecondaryItemId.values().length];
            f238408a = r100;
            r100[SheetBlockPrimaryItemId.AlignAttrSecondaryItemId.horizontalLeft.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            f238408a[SheetBlockPrimaryItemId.AlignAttrSecondaryItemId.horizontalCenter.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            f238408a[SheetBlockPrimaryItemId.AlignAttrSecondaryItemId.horizontalRight.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            f238408a[SheetBlockPrimaryItemId.AlignAttrSecondaryItemId.verticalTop.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            f238408a[SheetBlockPrimaryItemId.AlignAttrSecondaryItemId.verticalCenter.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            f238408a[SheetBlockPrimaryItemId.AlignAttrSecondaryItemId.verticalBottom.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    public SheetBlockAlignAttrAdapter(ItemV2[] r100) {
        super(r100);
    }

    @Override // com.bytedance.ee.bear.edit.component.toolbar2.BaseSubToolbarAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        if ((r100 instanceof BaseSubToolbarAdapter.DividerViewHolder) == true) goto L21;
        ItemV2[] r102 = this.f226050a;
        if (r102 == null) goto L22;
        ItemV2 r103 = r102[r101];
        BaseSubToolbarAdapter.SubToolbarViewHolder r104 = (BaseSubToolbarAdapter.SubToolbarViewHolder) r100;
        ItemIdV2 r105 = r103.id();
        if ((r105 instanceof SheetBlockPrimaryItemId.AlignAttrSecondaryItemId) == true) goto L10;
    L18:
        int r106 = 0;
    L19:
        BaseSubToolbarAdapter.z2(r104, r103, r106);
        r104.itemView.setOnClickListener(new a(this, r103));
        return;
    L10:
        switch(b.f238408a[((SheetBlockPrimaryItemId.AlignAttrSecondaryItemId) r105).ordinal()]) {
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            default: goto L18;
        };
    L12:
        r106 = R.drawable.ud_icon_bottom_align_outlined;
        goto L19
    L13:
        r106 = R.drawable.ud_icon_vertical_align_outlined;
        goto L19
    L14:
        r106 = R.drawable.ud_icon_top_align_outlined;
        goto L19
    L15:
        r106 = R.drawable.ud_icon_right_alignment_outlined;
        goto L19
    L16:
        r106 = R.drawable.ud_icon_center_alignment_outlined;
        goto L19
    L17:
        r106 = R.drawable.ud_icon_left_alignment_outlined;
        goto L19
    L22:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        boolean r102 = true;
        if (r101 == 1) goto L6;
        r102 = false;
    L6:
        if (r102 == false) goto L8;
        int r103 = R.layout.doc_sub_toolbar_item_divider;
    L9:
        View r104 = LayoutInflater.from(r100.getContext()).inflate(r103, r100, false);
        if (r102 == false) goto L13;
        return new BaseSubToolbarAdapter.DividerViewHolder(r104);
    L13:
        return new BaseSubToolbarAdapter.SubToolbarViewHolder(r104);
    L8:
        r103 = R.layout.doc_sub_toolbar_item_horizontal;
        goto L9
    }
}
