package com.ss.android.lark.contact.customized.newcontact.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.contact.base.contact_new.mvp.NewContactView;
import com.ss.android.lark.contact.base.dto.ChatApplication;
import com.ss.android.lark.image.ImageModule;
import com.ss.android.lark.image.entity.LoadParams;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0000\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002#$B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0011H\u0016J\b\u0010\u0016\u001a\u00020\u0011H\u0016J\u000e\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\fJ\u0014\u0010\u0019\u001a\u00020\u00132\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\u001bJ\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00070\u001dJ\u000e\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u0007J\u0018\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0014\u001a\u00020\u0002H\u0002R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/ss/android/lark/contact/customized/newcontact/view/OfficeNewContactAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/ss/android/lark/contact/customized/newcontact/view/OfficeNewContactAdapter$NewContactViewHolder;", "<init>", "()V", "items", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/contact/base/contact_new/mvp/NewContactView$FriendRequestViewData;", "Lkotlin/collections/ArrayList;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "itemClickListener", "Lcom/ss/android/lark/contact/customized/newcontact/view/OfficeNewContactAdapter$IItemClickListener;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "getItemCount", "setItemClickListener", "listener", "setItems", "newItems", "", "getItems", "", "remove", "viewData", "updateConfirmBtn", "status", "Lcom/ss/android/lark/contact/base/dto/ChatApplication$Status;", "IItemClickListener", "NewContactViewHolder", "contact-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeNewContactAdapter extends RecyclerView.Adapter<NewContactViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<NewContactView.a> f419355a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f419356b;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0013\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/contact/customized/newcontact/view/OfficeNewContactAdapter$NewContactViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", RootDescription.ROOT_ELEMENT, "getRoot", "()Landroid/view/View;", "newContactAvatar", "Lcom/larksuite/component/ui/imageview/LKUIRoundedImageView;", "getNewContactAvatar", "()Lcom/larksuite/component/ui/imageview/LKUIRoundedImageView;", "newContactNameTv", "Landroid/widget/TextView;", "getNewContactNameTv", "()Landroid/widget/TextView;", "newContactSubTv", "getNewContactSubTv", "confirmBtn", "getConfirmBtn", "contact-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class NewContactViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f419357a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final LKUIRoundedImageView f419358b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TextView f419359c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final TextView f419360d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final TextView f419361e;

        public NewContactViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.f419357a = r100;
            this.f419358b = (LKUIRoundedImageView) r100.findViewById(R.id.contact_avatar);
            this.f419359c = (TextView) r100.findViewById(R.id.contact_name);
            this.f419360d = (TextView) r100.findViewById(R.id.contact_subtitle);
            this.f419361e = (TextView) r100.findViewById(R.id.confirm_btn);
        }
    }

    public interface a {
        void a(View r100, NewContactView.a r101);

        void b(String r100, String r101);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f419355a.size();
    }

    public OfficeNewContactAdapter() {
        this.f419355a = new ArrayList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r110) {
        NewContactViewHolder r101 = (NewContactViewHolder) r100;
        Intrinsics.checkNotNullParameter(r101, "holder");
        NewContactView.a r111 = (NewContactView.a) ListProtector.get(this.f419355a, r110);
        r101.f419359c.setText(r111.f418724d);
        String r102 = r111.f418727g;
        boolean r103 = true;
        if (r102 != null) goto L5;
    L8:
        boolean r104 = true;
    L9:
        if (r104 == true) goto L11;
        String r105 = r111.f418727g;
    L12:
        if (r105 == null) goto L18;
        if (r105.length() == 0) goto L18;
        r103 = false;
    L18:
        if (r103 == false) goto L20;
        r101.f419360d.setVisibility(8);
    L21:
        int r106 = UIHelper.dp2px(60.0f);
        Context r107 = r101.f419358b.getContext();
        LKUIRoundedImageView r108 = r101.f419358b;
        String r109 = r111.f418723c;
        String r112 = r111.f418722b;
        LoadParams r113 = new LoadParams();
        r113.f426328a = r106;
        r113.f426329b = r106;
        ImageModule.a(r107, r108, r109, r112, r113);
        ChatApplication.Status r114 = r111.f418728h;
        Intrinsics.checkNotNull(r114);
        if (r114 != ChatApplication.Status.PEDING) goto L24;
        r101.f419361e.setVisibility(0);
        TextView r115 = r101.f419361e;
        r115.setTextColor(UIUtils.getColor(r115.getContext(), R.color.flow_ud_static_white));
        r101.f419361e.setBackgroundResource(R.drawable.contact_db_round_10_prim_50);
        r101.f419361e.setText(UIHelper.getString(R.string.LarkIM_Friend_View_Button));
    L35:
        if (r114 != ChatApplication.Status.DELETED) goto L37;
        r101.f419357a.setVisibility(8);
    L38:
        r101.f419361e.setOnClickListener(new c(this, r111));
        r101.f419357a.setOnClickListener(new d(this, r111));
        r101.f419357a.setOnLongClickListener(new e(this, r111));
        return;
    L37:
        r101.f419357a.setVisibility(0);
        goto L38
    L24:
        ChatApplication.Status r116 = ChatApplication.Status.AGREED;
        if (r114 != r116) goto L27;
    L30:
        r101.f419361e.setVisibility(0);
        r101.f419361e.setBackgroundResource(R.drawable.contact_db_round_10_neu_trans_1);
        TextView r117 = r101.f419361e;
        r117.setTextColor(UIUtils.getColor(r117.getContext(), R.color.flow_ud_neutral_50));
        if (r114 != r116) goto L33;
        r101.f419361e.setText(UIHelper.getString(R.string.LarkIM_Friend_Added_Button));
        goto L35
    L33:
        r101.f419361e.setText(UIHelper.getString(R.string.Lark_Legacy_FriendRequestExpired));
        goto L35
    L27:
        if (r114 == ChatApplication.Status.EXPIRED) goto L30;
        r101.f419361e.setVisibility(8);
        goto L35
    L20:
        r101.f419360d.setVisibility(0);
        r101.f419360d.setText(r105);
        goto L21
    L11:
        r105 = UIHelper.getString(R.string.LarkIM_Friend_ContactAddRequest_Text);
        goto L12
    L5:
        if (r102.length() == 0) goto L8;
        r104 = false;
        goto L9
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        r100.getContext();
        View r102 = LayoutInflater.from(r100.getContext()).inflate(R.layout.contact_db_item_new_contact, r100, false);
        Intrinsics.checkNotNull(r102);
        return new NewContactViewHolder(r102);
    }
}
