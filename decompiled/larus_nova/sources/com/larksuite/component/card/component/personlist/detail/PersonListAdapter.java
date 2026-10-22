package com.larksuite.component.card.component.personlist.detail;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.card.component.personlist.PersonInfo;
import com.larksuite.component.card.component.personlist.g;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView2;
import com.larus.nova.R;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.entity.AvatarImage;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 #2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003#$%B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J \u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u000eH\u0002J\b\u0010\u0019\u001a\u00020\u000eH\u0016J\u0016\u0010\u001a\u001a\u00020\u00102\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001cJ\u001a\u0010\u001d\u001a\u00020\u00102\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\u001fJ\u000e\u0010\"\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\tR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/larksuite/component/card/component/personlist/detail/PersonListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "<init>", "()V", "personList", "", "Lcom/larksuite/component/card/component/personlist/PersonInfo;", "itemClickListener", "Lcom/larksuite/component/card/component/personlist/detail/PersonListAdapter$OnItemClickListener;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "getPlaceHolderDrawable", "Landroid/graphics/drawable/Drawable;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "width", "height", "getItemCount", "setDataList", "newData", "", "updateData", "personMap", "", "", "Lcom/larksuite/component/card/component/personlist/detail/SimpleChatterInfo;", "setOnItemClickListener", "Companion", "OnItemClickListener", "MemberViewHolder", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PersonListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<PersonInfo> f283496a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f283497b;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/larksuite/component/card/component/personlist/detail/PersonListAdapter$MemberViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "getItemView", "()Landroid/view/View;", "avatar", "Lcom/larksuite/component/ui/imageview/LKUIRoundedImageView2;", "getAvatar", "()Lcom/larksuite/component/ui/imageview/LKUIRoundedImageView2;", "setAvatar", "(Lcom/larksuite/component/ui/imageview/LKUIRoundedImageView2;)V", "userName", "Landroid/widget/TextView;", "getUserName", "()Landroid/widget/TextView;", "setUserName", "(Landroid/widget/TextView;)V", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class MemberViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f283498a;

        public MemberViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.f283498a = r100;
            LKUIRoundedImageView2 r101 = (LKUIRoundedImageView2) r100.findViewById(R.id.avatar);
            TextView r102 = (TextView) r100.findViewById(R.id.user_name);
        }
    }

    public static final class a {
    }

    public interface b {
        void a(String r100);
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PersonListAdapter f283499a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ PersonInfo f283500b;

        public c(PersonListAdapter r100, PersonInfo r101) {
            this.f283499a = r100;
            this.f283500b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            b r101 = this.f283499a.f283497b;
            if (r101 == null) goto L6;
            r101.a(this.f283500b.getId());
            return;
        }
    }

    static {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return ((ArrayList) this.f283496a).size();
    }

    public PersonListAdapter() {
        this.f283496a = new ArrayList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        PersonInfo r102 = (PersonInfo) ListProtector.get(this.f283496a, r101);
        LKUIRoundedImageView2 r103 = (LKUIRoundedImageView2) r100.itemView.findViewById(R.id.avatar);
        if (r103.getLayoutParams().width <= 0) goto L5;
        int r104 = r103.getLayoutParams().width;
    L7:
        if (r103.getLayoutParams().height <= 0) goto L9;
        int r105 = r103.getLayoutParams().height;
    L10:
        AvatarImage r106 = AvatarImage.Builder.obtain(r102.getAvatarKey(), r102.getId(), r104, r105).build();
        Context r107 = r103.getContext();
        g.f283510a.getClass();
        Intrinsics.checkNotNullParameter(r107, PerfLog.PARAM_KEY_CONTEXT_ID);
        Resources r108 = r107.getResources();
        BitmapDrawable r109 = new BitmapDrawable(r108, Bitmap.createScaledBitmap(BitmapFactory.decodeResource(r108, R.drawable.card_avatar_placeholder), r104, r105, true));
        ImageLoader.with(r103.getContext()).load(r106).placeholder(r109).override(r104, r105).into(r103);
        ((TextView) r100.itemView.findViewById(R.id.user_name)).setText(g.f(r102));
        ((LinearLayout) r100.itemView.findViewById(R.id.lv_avatar_name)).setOnClickListener(new c(this, r102));
        return;
    L9:
        r105 = UIHelper.dp2px(40.0f);
        goto L10
    L5:
        r104 = UIHelper.dp2px(40.0f);
        goto L7
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r102 = LayoutInflater.from(r100.getContext()).inflate(R.layout.card_person_list_item, r100, false);
        Intrinsics.checkNotNull(r102);
        return new MemberViewHolder(r102);
    }
}
