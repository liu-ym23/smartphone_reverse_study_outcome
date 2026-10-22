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
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.ee.util.ui.l;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000  2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003 !\"B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0011J\u0019\u0010\u0015\u001a\u00020\u00132\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\u0017J\u0018\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000fH\u0016J\u0018\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u000fH\u0016J\b\u0010\u001f\u001a\u00020\u000fH\u0016R\u0018\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u000b\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/bytedance/ee/bear/block/jira/JiraActionAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/ee/bear/block/jira/JiraActionAdapter$ViewHolder;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", SlcCommonAction.KEY_ACTIONS, "", "Lcom/bytedance/ee/bear/block/jira/JiraActionData$ActionSheetItem;", "[Lcom/bytedance/ee/bear/block/jira/JiraActionData$ActionSheetItem;", "mContext", "jiraItemActionDrawables", "", "", "", "mItemClickListener", "Lcom/bytedance/ee/bear/block/jira/JiraActionAdapter$OnItemClickListener;", "setItemClickListener", "", "itemClickListener", "updateActionDatas", "data", "([Lcom/bytedance/ee/bear/block/jira/JiraActionData$ActionSheetItem;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "getItemCount", "Companion", "ViewHolder", "OnItemClickListener", "features-block-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class JiraActionAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JiraActionData.ActionSheetItem[] f216563a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f216564b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Integer> f216565c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f216566d;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ee/bear/block/jira/JiraActionAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "actionIcon", "Landroid/widget/ImageView;", "getActionIcon", "()Landroid/widget/ImageView;", "actionText", "Landroid/widget/TextView;", "getActionText", "()Landroid/widget/TextView;", "actionDivider", "getActionDivider", "()Landroid/view/View;", "features-block-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ImageView f216567a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f216568b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final View f216569c;

        public ViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.f216567a = (ImageView) r100.findViewById(R.id.img_action_icon);
            this.f216568b = (TextView) r100.findViewById(R.id.img_action_text);
            this.f216569c = r100.findViewById(R.id.img_action_divider);
        }
    }

    public static final class a {
    }

    public interface b {
        void a(String r100);
    }

    static {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        JiraActionData.ActionSheetItem[] r100 = this.f216563a;
        if (r100 != null) goto L6;
        return 0;
    L6:
        Intrinsics.checkNotNull(r100);
        return r100.length;
    }

    public JiraActionAdapter(FragmentActivity r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f216564b = r100;
        LinkedHashMap r101 = new LinkedHashMap();
        this.f216565c = r101;
        r101.put("OpenJira", Integer.valueOf(R.drawable.icon_tool_switchitem_nor));
        r101.put("SyncJira", Integer.valueOf(R.drawable.ud_icon_refresh_outlined));
        r101.put("UnLockSync", Integer.valueOf(R.drawable.ud_icon_unlock_outlined));
        r101.put("LockSync", Integer.valueOf(R.drawable.ud_icon_lock_outlined));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        ViewHolder r102 = (ViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        JiraActionData.ActionSheetItem[] r103 = this.f216563a;
        if (r103 != null) goto L5;
        tt5.a.d("JiraActionAdapter", "onBindViewHolder: actions == null");
        return;
    L5:
        String r104 = r103[r101].getId();
        if (r104 == null) goto L10;
        Integer r105 = (Integer) ((LinkedHashMap) this.f216565c).get(r104);
        if (r105 == null) goto L10;
        r102.f216567a.setImageResource(r105.intValue());
        r102.itemView.setOnClickListener(new com.bytedance.ee.bear.block.jira.a(this, r104));
    L10:
        TextView r106 = r102.f216568b;
        JiraActionData.ActionSheetItem[] r107 = this.f216563a;
        Intrinsics.checkNotNull(r107);
        r106.setText(r107[r101].getText());
        if (r103[r101].getEnable() != null) goto L13;
    L16:
        boolean r108 = true;
    L17:
        if (r108 == false) goto L19;
        r102.f216568b.setTextColor(ContextCompat.getColor(this.f216564b, R.color.icon_disable));
        l.c(r102.f216567a, R.color.icon_disable);
    L20:
        boolean r109 = !r108;
        r102.itemView.setClickable(r109);
        r102.itemView.setFocusable(r109);
        if (r101 != (r103.length - 1)) goto L23;
        r102.f216569c.setVisibility(8);
        return;
    L23:
        r102.f216569c.setVisibility(0);
        return;
    L19:
        r102.f216568b.setTextColor(ContextCompat.getColor(this.f216564b, R.color.text_title));
        l.c(r102.f216567a, R.color.icon_n1);
        goto L20
    L13:
        if (Intrinsics.areEqual(r103[r101].getEnable(), Boolean.FALSE) == true) goto L16;
        r108 = false;
        goto L17
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r102 = LayoutInflater.from(this.f216564b).inflate(R.layout.jira_action_item, r100, false);
        Intrinsics.checkNotNull(r102);
        return new ViewHolder(r102);
    }
}
