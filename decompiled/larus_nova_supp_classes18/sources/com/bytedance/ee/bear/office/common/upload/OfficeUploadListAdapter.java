package com.bytedance.ee.bear.office.common.upload;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0012\u0013B/\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u000eH\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ee/bear/office/common/upload/OfficeUploadListAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/bytedance/ee/bear/office/common/upload/OfficeUploadItem;", "Lcom/bytedance/ee/bear/office/common/upload/OfficeUploadListAdapter$ViewHolder;", "onRemoveClick", "Lkotlin/Function1;", "", "onRetryClick", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "ViewHolder", "DiffCallback", "office-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeUploadListAdapter extends ListAdapter<u, ViewHolder> {
    public final Function1<u, Unit> a;
    public final Function1<u, Unit> b;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J6\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00070\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00070\u000b¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/bear/office/common/upload/OfficeUploadListAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Lcom/bytedance/ee/bear/office/common/upload/OfficeUploadItemView;", "<init>", "(Lcom/bytedance/ee/bear/office/common/upload/OfficeUploadItemView;)V", "bind", "", "item", "Lcom/bytedance/ee/bear/office/common/upload/OfficeUploadItem;", "onRemoveClick", "Lkotlin/Function1;", "onRetryClick", "office-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(v r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
        }
    }

    public static final class a extends DiffUtil.ItemCallback<u> {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final boolean areContentsTheSame(Object r2, Object r3) {
            u r4 = (u) r2;
            u r5 = (u) r3;
            Intrinsics.checkNotNullParameter(r4, "oldItem");
            Intrinsics.checkNotNullParameter(r5, "newItem");
            return Intrinsics.areEqual(r4, r5);
        }

        public final boolean areItemsTheSame(Object r2, Object r3) {
            u r4 = (u) r2;
            u r5 = (u) r3;
            Intrinsics.checkNotNullParameter(r4, "oldItem");
            Intrinsics.checkNotNullParameter(r5, "newItem");
            return Intrinsics.areEqual(r4.a, r5.a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OfficeUploadListAdapter(Function1<? super u, Unit> r2, Function1<? super u, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "onRemoveClick");
        Intrinsics.checkNotNullParameter(r3, "onRetryClick");
        super(a.a);
        this.a = r2;
        this.b = r3;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r12, int r13) {
        ViewHolder r14 = (ViewHolder) r12;
        Intrinsics.checkNotNullParameter(r14, "holder");
        u r15 = (u) getItem(r13);
        Function1<u, Unit> r0 = this.a;
        Function1<u, Unit> r1 = this.b;
        r14.getClass();
        Intrinsics.checkNotNullParameter(r15, "item");
        Intrinsics.checkNotNullParameter(r0, "onRemoveClick");
        Intrinsics.checkNotNullParameter(r1, "onRetryClick");
        View r16 = ((RecyclerView.ViewHolder) r14).itemView;
        Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type com.bytedance.ee.bear.office.common.upload.OfficeUploadItemView");
        v r17 = (v) r16;
        r17.getClass();
        Intrinsics.checkNotNullParameter(r15, "item");
        Intrinsics.checkNotNullParameter(r0, "onRemoveClick");
        Intrinsics.checkNotNullParameter(r1, "onRetryClick");
        ImageView r3 = r17.a;
        String r10 = r15.b;
        int r4 = StringsKt.lastIndexOf$default(r10, '.', 0, false, 6, null);
        if (r4 > 0) goto L5;
    L7:
        String r5 = "";
    L8:
        r3.setImageResource(rbb.b.e(r5));
        r17.b.setText(r15.b);
        int r6 = 0;
        if (r15.d != OfficeUploadStatus.FAILED) goto L11;
        boolean r7 = true;
    L12:
        ImageView r8 = r17.e;
        if (r7 == true) goto L16;
        r6 = 8;
    L16:
        r8.setVisibility(r6);
        ViewGroup.LayoutParams r9 = r17.b.getLayoutParams();
        if ((r9 instanceof ViewGroup.MarginLayoutParams) == false) goto L19;
        ViewGroup.MarginLayoutParams r11 = (ViewGroup.MarginLayoutParams) r9;
    L20:
        if (r11 == null) goto L26;
        Context r18 = r17.getContext();
        if (r7 == false) goto L24;
        int r19 = 56;
    L25:
        r11.rightMargin = e.a(r18, r19);
        r17.b.setLayoutParams(r11);
        goto L26
    L24:
        r19 = 12;
    L26:
        int r20 = v.a.a[r15.d.ordinal()];
        if (r20 == 1) goto L31;
        if (r20 == 2) goto L30;
        int r21 = 2131103960;
    L32:
        r17.c.setTextColor(ContextCompat.getColor(r17.getContext(), r21));
        TextView r22 = r17.c;
        k0 r23 = k0.a;
        Context r24 = r17.getContext();
        r23.getClass();
        Intrinsics.checkNotNullParameter(r24, "context");
        Intrinsics.checkNotNullParameter(r15, "item");
        Long r2 = r15.f;
        String r25 = "0.0B";
        if (r2 == null) goto L36;
        String r26 = k0.e(r2.longValue(), null);
        if (r26 == null) goto L36;
    L37:
        int r27 = k0.a.b[r15.d.ordinal()];
        if (r27 == 1) goto L58;
        if (r27 != 2) goto L41;
        Long r28 = r15.g;
        if (r28 == null) goto L57;
        String r29 = k0.e(r28.longValue(), r15.f);
        if (r29 == null) goto L57;
        r25 = r29;
    L57:
        String r30 = r24.getString(2131888457) + ' ' + r25 + '/' + r26;
    L59:
        r22.setText(r30);
        r17.d.setOnClickListener(new w(r0, r15));
        r17.e.setOnClickListener(new x(r1, r15));
        return;
    L41:
        if (r27 != 3) goto L43;
        r30 = r24.getString(2131888453) + ' ' + r26;
        goto L59
    L43:
        if (r27 != 4) goto L49;
        StringBuilder r31 = new StringBuilder();
        String r32 = r15.e;
        if (r32 != null) goto L47;
        r32 = r24.getString(2131892996);
    L47:
        r31.append(r32);
        r31.append(' ');
        r31.append(r26);
        r30 = r31.toString();
        goto L59
    L49:
        throw new NoWhenBranchMatchedException();
    L58:
        r30 = r24.getString(2131886504) + ' ' + r26;
    L36:
        r26 = "0.0B";
        goto L37
    L30:
        r21 = 2131103953;
        goto L32
    L31:
        r21 = 2131103957;
        goto L32
    L19:
        r11 = null;
        goto L20
    L11:
        r7 = false;
        goto L12
    L5:
        if (r4 >= (r10.length() - 1)) goto L7;
        r5 = r10.substring(r4 + 1);
        goto L8
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        return new ViewHolder(new v(r2.getContext()));
    }
}
