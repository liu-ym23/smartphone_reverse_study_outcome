package com.bytedance.ee.bear.block.jira;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.util.ui.l;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000  2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003 !\"B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0011J\u0019\u0010\u0015\u001a\u00020\u00132\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\u0017J\u0018\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000fH\u0016J\u0018\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u000fH\u0016J\b\u0010\u001f\u001a\u00020\u000fH\u0016R\u0018\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u000b\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/bytedance/ee/bear/block/jira/JiraActionAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/ee/bear/block/jira/JiraActionAdapter$ViewHolder;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "actions", "", "Lcom/bytedance/ee/bear/block/jira/JiraActionData$ActionSheetItem;", "[Lcom/bytedance/ee/bear/block/jira/JiraActionData$ActionSheetItem;", "mContext", "jiraItemActionDrawables", "", "", "", "mItemClickListener", "Lcom/bytedance/ee/bear/block/jira/JiraActionAdapter$OnItemClickListener;", "setItemClickListener", "", "itemClickListener", "updateActionDatas", "data", "([Lcom/bytedance/ee/bear/block/jira/JiraActionData$ActionSheetItem;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "getItemCount", "Companion", "ViewHolder", "OnItemClickListener", "features-block-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class JiraActionAdapter extends RecyclerView.Adapter<ViewHolder> {
    public JiraActionData.ActionSheetItem[] a;
    public final Context b;
    public final Map<String, Integer> c;
    public b d;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ee/bear/block/jira/JiraActionAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "actionIcon", "Landroid/widget/ImageView;", "getActionIcon", "()Landroid/widget/ImageView;", "actionText", "Landroid/widget/TextView;", "getActionText", "()Landroid/widget/TextView;", "actionDivider", "getActionDivider", "()Landroid/view/View;", "features-block-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        public final ImageView a;
        public final TextView b;
        public final View c;

        public ViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.a = (ImageView) r2.findViewById(2131375125);
            this.b = (TextView) r2.findViewById(2131375126);
            this.c = r2.findViewById(2131375124);
        }
    }

    public static final class a {
    }

    public interface b {
        void a(String r1);
    }

    static {
    }

    public final int getItemCount() {
        JiraActionData.ActionSheetItem[] r0 = this.a;
        if (r0 != null) goto L6;
        return 0;
    L6:
        Intrinsics.checkNotNull(r0);
        return r0.length;
    }

    public JiraActionAdapter(FragmentActivity r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this.b = r3;
        LinkedHashMap r4 = new LinkedHashMap();
        this.c = r4;
        r4.put("OpenJira", 2131238086);
        r4.put("SyncJira", 2131255528);
        r4.put("UnLockSync", 2131256066);
        r4.put("LockSync", 2131255047);
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r8, int r9) {
        ViewHolder r10 = (ViewHolder) r8;
        Intrinsics.checkNotNullParameter(r10, "holder");
        JiraActionData.ActionSheetItem[] r0 = this.a;
        if (r0 != null) goto L5;
        tt5.a.d("JiraActionAdapter", "onBindViewHolder: actions == null");
        return;
    L5:
        String r1 = r0[r9].getId();
        if (r1 == null) goto L10;
        Integer r2 = (Integer) ((LinkedHashMap) this.c).get(r1);
        if (r2 == null) goto L10;
        r10.a.setImageResource(r2.intValue());
        ((RecyclerView.ViewHolder) r10).itemView.setOnClickListener(new com.bytedance.ee.bear.block.jira.a(this, r1));
    L10:
        TextView r3 = r10.b;
        JiraActionData.ActionSheetItem[] r4 = this.a;
        Intrinsics.checkNotNull(r4);
        r3.setText(r4[r9].getText());
        if (r0[r9].getEnable() != null) goto L13;
    L16:
        boolean r5 = true;
    L17:
        if (r5 == false) goto L19;
        r10.b.setTextColor(ContextCompat.getColor(this.b, 2131102416));
        l.c(r10.a, 2131102416);
    L20:
        boolean r6 = !r5;
        ((RecyclerView.ViewHolder) r10).itemView.setClickable(r6);
        ((RecyclerView.ViewHolder) r10).itemView.setFocusable(r6);
        if (r9 != (r0.length - 1)) goto L23;
        r10.c.setVisibility(8);
        return;
    L23:
        r10.c.setVisibility(0);
        return;
    L19:
        r10.b.setTextColor(ContextCompat.getColor(this.b, 2131106622));
        l.c(r10.a, 2131102418);
        goto L20
    L13:
        if (Intrinsics.areEqual(r0[r9].getEnable(), Boolean.FALSE) == true) goto L16;
        r5 = false;
        goto L17
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        View r5 = LayoutInflater.from(this.b).inflate(2131561718, r3, false);
        Intrinsics.checkNotNull(r5);
        return new ViewHolder(r5);
    }
}
