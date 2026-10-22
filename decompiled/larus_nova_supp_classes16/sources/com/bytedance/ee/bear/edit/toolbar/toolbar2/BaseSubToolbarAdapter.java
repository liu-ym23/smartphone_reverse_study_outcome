package com.bytedance.ee.bear.edit.toolbar.toolbar2;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import com.bytedance.ee.bear.document.model.toolbar.ItemIdV2;
import com.bytedance.ee.bear.document.model.toolbar.ItemV2;
import com.bytedance.ee.bear.document.offline.file.upload.UploadResult;
import com.bytedance.ee.util.ui.ColorUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u0000 52\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0006012345B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\u0002\u0010\u0014J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0019\u0010\u0017\u001a\u00020\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0007J\u0010\u0010\u001a\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\nJ\u001a\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u0016H\u0005J\u0018\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u0016H\u0016J\u0010\u0010#\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020\u0016H\u0016J\u0012\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010\"\u001a\u00020\u0016H\u0004J\u001a\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0016H\u0004J \u0010+\u001a\u00020\u00182\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u0016H\u0004R\u001c\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0004@\u0004X\u0085\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0014\u0010\t\u001a\u0004\u0018\u00010\n8\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u00066"}, d2 = {"Lcom/bytedance/ee/bear/edit/toolbar/toolbar2/BaseSubToolbarAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "items", "", "Lcom/bytedance/ee/bear/document/model/toolbar/ItemV2;", "<init>", "([Lcom/bytedance/ee/bear/document/model/toolbar/ItemV2;)V", "[Lcom/bytedance/ee/bear/document/model/toolbar/ItemV2;", "itemClickListener", "Lcom/bytedance/ee/bear/edit/toolbar/toolbar2/BaseSubToolbarAdapter$OnItemClickListener;", "toolbarConfig", "Lcom/bytedance/ee/bear/api/registry/IToolbarConfig;", "toolbarContext", "Lcom/bytedance/ee/bear/api/registry/ToolbarContext;", "getToolbarContext", "()Lcom/bytedance/ee/bear/api/registry/ToolbarContext;", "setToolbarContext", "(Lcom/bytedance/ee/bear/api/registry/ToolbarContext;)V", "getItems", "()[Lcom/bytedance/ee/bear/document/model/toolbar/ItemV2;", "getItemCount", "", "updateItems", "", "newItems", "setItemClickListener", "listener", "parseColor", "color", "", "defColor", "onBindViewHolder", "holder", "position", "getItemViewType", "getItemViewFactory", "Lcom/bytedance/ee/bear/api/registry/ToolbarItemViewFactory;", "getCustomViewHolder", "Lcom/bytedance/ee/bear/edit/toolbar/toolbar2/BaseSubToolbarAdapter$CustomViewHolder;", "parent", "Landroid/view/ViewGroup;", "viewType", "setIconAttrs", "subToolbarViewHolder", "Lcom/bytedance/ee/bear/edit/toolbar/toolbar2/BaseSubToolbarAdapter$SubToolbarViewHolder;", "item", "resId", "OnItemClickListener", "DividerViewHolder", "SubToolbarViewHolder", "TextColorViewHolder", "CustomViewHolder", "Companion", "docs-edit-toolbar-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseSubToolbarAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public ItemV2[] a;
    public b b;
    public an4.a c;
    public an4.b d;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/edit/toolbar/toolbar2/BaseSubToolbarAdapter$CustomViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "docs-edit-toolbar-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class CustomViewHolder extends RecyclerView.ViewHolder {
        public CustomViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/edit/toolbar/toolbar2/BaseSubToolbarAdapter$DividerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "docs-edit-toolbar-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class DividerViewHolder extends RecyclerView.ViewHolder {
        public DividerViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/edit/toolbar/toolbar2/BaseSubToolbarAdapter$SubToolbarViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "mIcon", "Landroid/widget/ImageView;", "docs-edit-toolbar-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class SubToolbarViewHolder extends RecyclerView.ViewHolder {
        public final ImageView a;

        public SubToolbarViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            super(r2);
            ImageView r3 = (ImageView) r2.findViewById(2131387565);
            this.a = r3;
            com.bytedance.ee.util.ui.l.c(r3, 2131102418);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/ee/bear/edit/toolbar/toolbar2/BaseSubToolbarAdapter$TextColorViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "colorRect", CustomHeaderConfig.Menu.Style.ICON_STYLE, "Landroid/widget/ImageView;", "docs-edit-toolbar-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class TextColorViewHolder extends RecyclerView.ViewHolder {
        public final View a;
        public final ImageView b;

        public TextColorViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.a = r2.findViewById(2131388373);
            ImageView r3 = (ImageView) r2.findViewById(2131374718);
            this.b = r3;
            com.bytedance.ee.util.ui.l.c(r3, 2131102418);
        }
    }

    public static final class a {
    }

    public interface b {
        void a(ItemV2 r1);
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ BaseSubToolbarAdapter a;
        public final /* synthetic */ ItemV2[] b;
        public final /* synthetic */ int c;

        public c(BaseSubToolbarAdapter r1, ItemV2[] r2, int r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            b r4 = this.a.b;
            if (r4 == null) goto L6;
            r4.a(this.b[this.c]);
            return;
        }
    }

    static {
    }

    public final int getItemCount() {
        ItemV2[] r0 = this.a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.length;
    }

    public BaseSubToolbarAdapter(ItemV2[] r2) {
        Intrinsics.checkNotNullParameter(r2, "items");
        this.a = r2;
    }

    public int getItemViewType(int r2) {
        if (y2(r2) == null) goto L7;
        return r2 + UploadResult.UPLOAD_CACELL;
    L7:
        return super.getItemViewType(r2);
    }

    public final an4.g y2(int r6) {
        ItemV2[] r0 = this.a;
        Object r1 = null;
        if (r0 != null) goto L5;
        return null;
    L5:
        ItemV2 r7 = r0[r6];
        an4.a r2 = this.c;
        if (r2 == null) goto L29;
        ItemIdV2 r8 = r7.id();
        Set r3 = r2.getItemFactorySet();
        ArrayList r4 = new ArrayList();
        Iterator r5 = r3.iterator();
    L9:
        if (r5.hasNext() == false) goto L13;
        Object r9 = r5.next();
        if ((r9 instanceof an4.g) == false) goto L9;
        r4.add(r9);
        goto L9
    L13:
        Iterator r10 = r4.iterator();
    L15:
        if (r10.hasNext() == false) goto L20;
        Object r11 = r10.next();
        if (Intrinsics.areEqual(((an4.e) r11).getItemId().name(), r8.name()) == false) goto L15;
        r1 = r11;
    L20:
        return (an4.e) r1;
    L29:
        return null;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "holder");
        ItemV2[] r0 = this.a;
        if (r0 != null) goto L6;
        return;
    L6:
        if ((r4 instanceof CustomViewHolder) == false) goto L16;
        an4.g r1 = y2(r5);
        if (r1 == null) goto L22;
        an4.b r2 = this.d;
        if (r2 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("toolbarContext");
        r2 = null;
    L13:
        r1.a(r2, r4.itemView, r0[r5]);
        return;
    L22:
        return;
    L16:
        if ((r4 instanceof DividerViewHolder) == false) goto L18;
        return;
    L18:
        if (r5 >= r0.length) goto L24;
        r4.itemView.setOnClickListener(new c(this, r0, r5));
        return;
    }

    public final int z2(String r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "color");
    L9:
        th = move-exception;
        tt5.a.e("BaseSubToolbarAdapter", "color:" + r5, th, false);
    L11:
        return r6;
    L4:
        if (TextUtils.isEmpty(r5) == true) goto L11;
        if (StringsKt.startsWith$default(r5, "#", false, 2, null) == false) goto L11;
        return ColorUtils.h(r5);
    }

    public final void A2(SubToolbarViewHolder r4, ItemV2 r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "subToolbarViewHolder");
        Intrinsics.checkNotNullParameter(r5, "item");
        an4.a r0 = this.c;
        Integer r1 = null;
        if (r0 == null) goto L5;
        an4.e r2 = an4.h.a(r0, r5.id());
    L6:
        if (r2 == null) goto L10;
        Integer r3 = r2.getIconRes();
        if (r3 == null) goto L10;
        r6 = r3.intValue();
    L10:
        if (r2 == null) goto L16;
        an4.d r7 = r2.getToolbarIconDecoration();
        if (r7 == null) goto L16;
        Integer r8 = r7.a;
        if (r8 == null) goto L16;
    L23:
        int r9 = r8.intValue();
    L25:
        if (r2 == null) goto L31;
        an4.d r10 = r2.getToolbarIconDecoration();
        if (r10 == null) goto L31;
        Integer r11 = r10.b;
        if (r11 == null) goto L31;
        int r12 = r11.intValue();
    L39:
        ImageView r13 = r4.a;
        r13.setImageResource(r6);
        r13.setImageTintList(r13.getResources().getColorStateList(r9));
        r13.setBackground(r13.getResources().getDrawable(r12));
        if (r5.isEnable() == true) goto L42;
    L44:
        boolean r14 = false;
    L45:
        r13.setSelected(r14);
        r13.setEnabled(r5.isEnable());
        return;
    L42:
        if (r5.isSelected() == false) goto L44;
        r14 = true;
    L31:
        an4.a r16 = this.c;
        if (r16 == null) goto L36;
        an4.d r17 = r16.getGlobalDecoration();
        if (r17 == null) goto L36;
        r1 = r17.b;
    L36:
        if (r1 == null) goto L38;
        r12 = r1.intValue();
        goto L39
    L38:
        r12 = 2131233700;
    L16:
        an4.a r18 = this.c;
        if (r18 == null) goto L21;
        an4.d r19 = r18.getGlobalDecoration();
        if (r19 == null) goto L21;
        r8 = r19.a;
    L22:
        if (r8 != null) goto L23;
        r9 = 2131101286;
    L21:
        r8 = null;
        goto L22
    L5:
        r2 = null;
        goto L6
    }
}
