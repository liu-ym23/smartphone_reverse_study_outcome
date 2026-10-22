package com.ss.android.lark.todo.impl.features.detail.assignee.add.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.lark.pb.contact.v1.GetAnotherNameFormatResponse;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.ui.avatar.AvatarModel;
import com.larksuite.component.ui.avatar.v2.LarkAvatarView;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.larus.nova.R;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.todo.impl.features.detail.assignee.add.mvvm.d;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0011\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003$%&B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0013H\u0016J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u000bH\u0002J\u0018\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u000bH\u0002J\u0018\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u000bH\u0002J\u0018\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u000bH\u0002J\u001e\u0010\u001e\u001a\u00020\u00162\u0016\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fJ\u000e\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\u000eJ\u000e\u0010\"\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/detail/assignee/add/adapter/AssigneeRecommendAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/ss/android/lark/todo/impl/features/detail/assignee/add/adapter/AssigneeRecommendAdapter$ViewHolder;", "singlePick", "", "mOnItemClickListener", "Lcom/ss/android/lark/todo/impl/features/detail/assignee/add/adapter/AssigneeRecommendAdapter$IRecommendItemClickListener;", "<init>", "(ZLcom/ss/android/lark/todo/impl/features/detail/assignee/add/adapter/AssigneeRecommendAdapter$IRecommendItemClickListener;)V", "showData", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/todo/impl/features/detail/assignee/add/adapter/RecommendItem;", "Lkotlin/collections/ArrayList;", "nameRule", "Lcom/bytedance/lark/pb/contact/v1/GetAnotherNameFormatResponse$FormatRule;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "getItemCount", "onBindViewHolder", "", "holder", "position", "onViewClicked", MapController.ITEM_LAYER_TAG, "bindTitleItem", "bindAllItem", "bindChatterItem", "updateData", "data", "setNameRule", com.heytap.mcssdk.constant.b.f276366p, "setSinglePick", "single", "AvatarBuilder", "ViewHolder", "IRecommendItemClickListener", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AssigneeRecommendAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f442567a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f442568b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ArrayList<RecommendItem> f442569c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public GetAnotherNameFormatResponse.FormatRule f442570d;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/detail/assignee/add/adapter/AssigneeRecommendAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "getView", "()Landroid/view/View;", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f442571a;

        public ViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            super(r100);
            this.f442571a = r100;
        }
    }

    public static final class a extends AvatarModel.a<a> {
        public a() {
        }
    }

    public interface b {
        void a(RecommendItem r100, boolean r101);
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f442572a = null;

        static {
            int[] r100 = new int[RecommendItem.ShowType.values().length];
            r100[RecommendItem.ShowType.CHATTER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[RecommendItem.ShowType.TITLE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[RecommendItem.ShowType.SELECTALL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f442572a = r100;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f442569c.size();
    }

    public AssigneeRecommendAdapter(boolean r100, d r101) {
        Intrinsics.checkNotNullParameter(r101, "mOnItemClickListener");
        this.f442567a = r100;
        this.f442568b = r101;
        this.f442569c = new ArrayList();
        this.f442570d = GetAnotherNameFormatResponse.FormatRule.UNKNOWN;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r110, int r111) {
        ViewHolder r112 = (ViewHolder) r110;
        Intrinsics.checkNotNullParameter(r112, "holder");
        RecommendItem r113 = (RecommendItem) ListProtector.get(this.f442569c, r111);
        int r100 = c.f442572a[r113.getType().ordinal()];
        boolean r101 = true;
        if (r100 != 1) goto L5;
        RecommendItem.a r102 = r113.f442576d;
        if (r102 == null) goto L43;
        Chatter r103 = r102.f442581a;
        if (r103 == null) goto L43;
        ((RelativeLayout) r112.f442571a.findViewById(R.id.recommend_container)).setVisibility(0);
        ((RelativeLayout) r112.f442571a.findViewById(R.id.title_container)).setVisibility(8);
        LarkAvatarView r104 = (LarkAvatarView) r112.f442571a.findViewById(R.id.user_avatar);
        a r105 = new a();
        r105.b(r103.getAvatarKey());
        r105.f(r103.getId());
        r104.j(new AvatarModel(r105));
        TextView r106 = (TextView) r112.f442571a.findViewById(R.id.user_name);
        int r107 = p8c.b.f528279a;
        r106.setText(p8c.b.b(r103.getLocalizedName(), r103.getAnother_name(), r103.getAlias(), this.f442570d));
        int r108 = com.ss.android.lark.todo.impl.features.common.helper.c.f442449a;
        com.ss.android.lark.todo.impl.features.common.helper.c.a((TextView) r112.f442571a.findViewById(R.id.user_name), r103.getTagData());
        RecommendItem.a r109 = r113.f442576d;
        String r114 = null;
        if (r109 == null) goto L27;
        String r115 = r109.f442582b;
    L28:
        if (r115 != null) goto L30;
    L33:
        if (r101 == false) goto L35;
        ((TextView) r112.f442571a.findViewById(R.id.department_name)).setVisibility(8);
    L40:
        if (this.f442567a == false) goto L42;
        ((UDCheckBox) r112.f442571a.findViewById(R.id.select_icon)).setVisibility(8);
        goto L43
    L42:
        ((UDCheckBox) r112.f442571a.findViewById(R.id.select_icon)).setVisibility(0);
        ((UDCheckBox) r112.f442571a.findViewById(R.id.select_icon)).setChecked(r113.f442574b);
        goto L43
    L35:
        ((TextView) r112.f442571a.findViewById(R.id.department_name)).setVisibility(0);
        TextView r116 = (TextView) r112.f442571a.findViewById(R.id.department_name);
        RecommendItem.a r117 = r113.f442576d;
        if (r117 == null) goto L38;
        r114 = r117.f442582b;
    L38:
        r116.setText(r114);
        goto L40
    L30:
        if (r115.length() == 0) goto L33;
        r101 = false;
        goto L33
    L27:
        r115 = null;
    L43:
        r112.f442571a.setOnClickListener(new com.ss.android.lark.todo.impl.features.detail.assignee.add.adapter.a(this, r113));
        return;
    L5:
        if (r100 != 2) goto L7;
        ((RelativeLayout) r112.f442571a.findViewById(R.id.recommend_container)).setVisibility(8);
        ((RelativeLayout) r112.f442571a.findViewById(R.id.title_container)).setVisibility(0);
        ((TextView) r112.f442571a.findViewById(R.id.title_text)).setText(r113.f442575c);
        goto L43
    L7:
        if (r100 != 3) goto L17;
        if (this.f442567a == false) goto L11;
        ((RelativeLayout) r112.f442571a.findViewById(R.id.recommend_container)).setVisibility(8);
    L12:
        ((RelativeLayout) r112.f442571a.findViewById(R.id.title_container)).setVisibility(8);
        ((LarkAvatarView) r112.f442571a.findViewById(R.id.user_avatar)).setImageDrawable(r113.f442577e);
        ((TextView) r112.f442571a.findViewById(R.id.user_name)).setText(r113.f442575c);
        ((TextView) r112.f442571a.findViewById(R.id.department_name)).setVisibility(8);
        if (this.f442567a == false) goto L15;
        ((UDCheckBox) r112.f442571a.findViewById(R.id.select_icon)).setVisibility(8);
        goto L43
    L15:
        ((UDCheckBox) r112.f442571a.findViewById(R.id.select_icon)).setVisibility(0);
        ((UDCheckBox) r112.f442571a.findViewById(R.id.select_icon)).setChecked(r113.f442574b);
        ((UDCheckBox) r112.f442571a.findViewById(R.id.select_icon)).setEnabled(r113.f442578f);
        goto L43
    L11:
        ((RelativeLayout) r112.f442571a.findViewById(R.id.recommend_container)).setVisibility(0);
        goto L12
    L17:
        throw new NoWhenBranchMatchedException();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return new ViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.todo_assginee_recommend_fragment_item, r100, false));
    }
}
