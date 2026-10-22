package com.bytedance.ee.bear.document.member;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bytedance.ee.bear.facade.common.widget.CustomTitleView;
import com.bytedance.ee.util.glide.BearGlideUrl;
import com.bytedance.ee.util.ui.b;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.image.UDAvatar;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\"B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u001cH\u0016J\b\u0010!\u001a\u00020\u001cH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR0\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R#\u0010\u0011\u001a\n \u0013*\u0004\u0018\u00010\u00120\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015¨\u0006#"}, d2 = {"Lcom/bytedance/ee/bear/document/member/DocumentMemberListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/ee/bear/document/member/DocumentMemberListAdapter$MemberViewHolder;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "value", "", "Lcom/bytedance/ee/bear/document/member/MemberListData$MemberData;", "mMemberList", "getMMemberList", "()Ljava/util/List;", "setMMemberList", "(Ljava/util/List;)V", "mInflater", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", "getMInflater", "()Landroid/view/LayoutInflater;", "mInflater$delegate", "Lkotlin/Lazy;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "getItemCount", "MemberViewHolder", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocumentMemberListAdapter extends RecyclerView.Adapter<MemberViewHolder> {
    public final Context a;
    public List<MemberListData.MemberData> b;
    public final Lazy c;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ee/bear/document/member/DocumentMemberListAdapter$MemberViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "mAvatar", "Lcom/larksuite/component/universe_design/image/UDAvatar;", "getMAvatar", "()Lcom/larksuite/component/universe_design/image/UDAvatar;", "setMAvatar", "(Lcom/larksuite/component/universe_design/image/UDAvatar;)V", "mName", "Lcom/bytedance/ee/bear/facade/common/widget/CustomTitleView;", "getMName", "()Lcom/bytedance/ee/bear/facade/common/widget/CustomTitleView;", "setMName", "(Lcom/bytedance/ee/bear/facade/common/widget/CustomTitleView;)V", "mDepartment", "Landroid/widget/TextView;", "getMDepartment", "()Landroid/widget/TextView;", "setMDepartment", "(Landroid/widget/TextView;)V", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class MemberViewHolder extends RecyclerView.ViewHolder {
        public final UDAvatar a;
        public final CustomTitleView b;
        public final TextView c;

        public MemberViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.a = r2.findViewById(2131379844);
            this.b = (CustomTitleView) r2.findViewById(2131379848);
            this.c = (TextView) r2.findViewById(2131379845);
        }
    }

    public final int getItemCount() {
        return this.b.size();
    }

    public final Context getContext() {
        return this.a;
    }

    public DocumentMemberListAdapter(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
        this.b = new ArrayList();
        this.c = LazyKt.lazy(new DocumentMemberListAdapter$mInflater$2(this));
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r4, int r5) {
        MemberViewHolder r6 = (MemberViewHolder) r4;
        Intrinsics.checkNotNullParameter(r6, "holder");
        MemberListData.MemberData r7 = (MemberListData.MemberData) ListProtector.get(this.b, r5);
        if (b.b(this.a) == false) goto L5;
        Glide.with(this.a).load(new BearGlideUrl(r7.getAvatarUrl())).placeholder(2131235295).into(r6.a);
    L5:
        r6.a.setOnClickListener(new a(r7));
        r6.b.setTitle(r7.getName());
        if (TextUtils.isEmpty(r7.getDepartment()) == false) goto L8;
        r6.c.setVisibility(8);
        return;
    L8:
        r6.c.setVisibility(0);
        r6.c.setText(r7.getDepartment());
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        View r5 = ((LayoutInflater) this.c.getValue()).inflate(2131563629, r3, false);
        Intrinsics.checkNotNull(r5);
        return new MemberViewHolder(r5);
    }
}
