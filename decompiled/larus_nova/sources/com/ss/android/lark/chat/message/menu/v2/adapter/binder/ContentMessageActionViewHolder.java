package com.ss.android.lark.chat.message.menu.v2.adapter.binder;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0019\u0010\u0006\u001a\n \u0007*\u0004\u0018\u00010\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0019\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u000b0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0019\u0010\u000e\u001a\n \u0007*\u0004\u0018\u00010\u000f0\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0012\u001a\n \u0007*\u0004\u0018\u00010\u00130\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0016\u001a\n \u0007*\u0004\u0018\u00010\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/ss/android/lark/chat/message/menu/v2/adapter/binder/ContentMessageActionViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "defaultContainer", "kotlin.jvm.PlatformType", "getDefaultContainer", "()Landroid/view/View;", "customContainer", "Landroid/widget/FrameLayout;", "getCustomContainer", "()Landroid/widget/FrameLayout;", "iconView", "Landroidx/appcompat/widget/AppCompatImageView;", "getIconView", "()Landroidx/appcompat/widget/AppCompatImageView;", "labelTv", "Landroid/widget/TextView;", "getLabelTv", "()Landroid/widget/TextView;", "redDot", "getRedDot", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ContentMessageActionViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f415684a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f415685b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AppCompatImageView f415686c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f415687d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f415688e;

    public ContentMessageActionViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f415684a = r100.findViewById(R.id.default_view_container);
        this.f415685b = (FrameLayout) r100.findViewById(R.id.custom_view_container);
        this.f415686c = (AppCompatImageView) r100.findViewById(R.id.message_action_icon);
        this.f415687d = (TextView) r100.findViewById(R.id.message_action_label);
        this.f415688e = r100.findViewById(R.id.red_dot_view);
    }
}
