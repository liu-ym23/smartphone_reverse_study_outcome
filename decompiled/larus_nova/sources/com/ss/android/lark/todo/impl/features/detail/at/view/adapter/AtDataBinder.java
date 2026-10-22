package com.ss.android.lark.todo.impl.features.detail.at.view.adapter;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.component.ui.avatar.v2.LarkAvatarView;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;
import f8c.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class AtDataBinder implements c<f8c.a, AtDataViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtSelectAdapter.b f442804a;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/detail/at/view/adapter/AtDataBinder$AtDataViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "mTitle", "Landroid/widget/TextView;", "getMTitle", "()Landroid/widget/TextView;", "mDesc", "getMDesc", "mAvatar", "Lcom/larksuite/component/ui/avatar/v2/LarkAvatarView;", "getMAvatar", "()Lcom/larksuite/component/ui/avatar/v2/LarkAvatarView;", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AtDataViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f442805a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f442806b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final LarkAvatarView f442807c;

        public AtDataViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            super(r100);
            this.f442805a = (TextView) r100.findViewById(R.id.title);
            this.f442806b = (TextView) r100.findViewById(R.id.desc);
            this.f442807c = (LarkAvatarView) r100.findViewById(R.id.avatar);
        }
    }

    public AtDataBinder(AtSelectAdapter.b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f442804a = r100;
    }

    @Override // f8c.c
    public final long a(AtBean r100) {
        f8c.a r101 = (f8c.a) r100;
        Intrinsics.checkNotNullParameter(r101, "data");
        return r101.f442801a;
    }

    @Override // f8c.c
    public final RecyclerView.ViewHolder n(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r101 = LayoutInflater.from(r100.getContext()).inflate(R.layout.todo_detail_at_data_item, r100, false);
        r101.setLayoutParams(new RecyclerView.LayoutParams(-1, UIHelper.dp2px(64.0f)));
        Intrinsics.checkNotNull(r101);
        return new AtDataViewHolder(r101);
    }

    @Override // f8c.c
    public final void b(RecyclerView.ViewHolder r100, AtBean r101) {
        AtDataViewHolder r102 = (AtDataViewHolder) r100;
        f8c.a r103 = (f8c.a) r101;
        Intrinsics.checkNotNullParameter(r102, "holder");
        Intrinsics.checkNotNullParameter(r103, "data");
        r102.itemView.setVisibility(0);
        r102.f442805a.setText(this.f442804a.b(r103));
        int r104 = com.ss.android.lark.todo.impl.features.common.helper.c.f442449a;
        com.ss.android.lark.todo.impl.features.common.helper.c.a(r102.f442805a, r103.f475943h);
        if (TextUtils.isEmpty(r103.f475941f) == false) goto L5;
        r102.f442806b.setVisibility(8);
    L6:
        uz7.a.C7948a r105 = new uz7.a.C7948a();
        String r106 = r103.f475937b;
        r105.f552199k = r106;
        r105.f(r106);
        r105.b(r103.f475942g);
        uz7.a r107 = new uz7.a(r105);
        r102.f442807c.j(r107);
        r102.itemView.setOnClickListener(new a(this, r103));
        return;
    L5:
        r102.f442806b.setText(r103.f475941f);
        r102.f442806b.setVisibility(0);
        goto L6
    }
}
