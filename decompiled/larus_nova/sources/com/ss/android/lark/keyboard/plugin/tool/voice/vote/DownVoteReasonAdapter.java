package com.ss.android.lark.keyboard.plugin.tool.voice.vote;

import android.content.Context;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u001f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u001d\u001e\u001fB#\u0012\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004j\u0004\u0018\u0001`\u0007¢\u0006\u0004\b\b\u0010\tJ\u0014\u0010\r\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000eJ\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000eJ\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0005H\u0016J\u0018\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0005H\u0016J\u0018\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u0005H\u0016R\"\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004j\u0004\u0018\u0001`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/vote/DownVoteReasonAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/vote/DownVoteReasonAdapter$DownVoteReasonViewHolder;", "reasonSelectListener", "Lkotlin/Function1;", "", "", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/vote/ReasonSelectListener;", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "reasonList", "", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/vote/DownVoteReasonAdapter$DownVoteReason;", "updateReasonList", "", "getSelectedReasonList", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "setupReasonView", "textView", "Landroid/widget/TextView;", "isSelected", "", "getItemCount", "DownVoteReasonViewHolder", "DownVoteReason", "Companion", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DownVoteReasonAdapter extends RecyclerView.Adapter<DownVoteReasonViewHolder> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f430831c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<Integer, Unit> f430832a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<b> f430833b;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/vote/DownVoteReasonAdapter$DownVoteReasonViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "textView", "Landroidx/appcompat/widget/AppCompatTextView;", "getTextView", "()Landroidx/appcompat/widget/AppCompatTextView;", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class DownVoteReasonViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AppCompatTextView f430834a;

        public DownVoteReasonViewHolder(AppCompatTextView r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.f430834a = r100;
        }
    }

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f430835a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f430836b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f430837c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f430835a, r101.f430835a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f430836b, r101.f430836b) == true) goto L15;
            return false;
        L15:
            if (this.f430837c == r101.f430837c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f430835a.hashCode() * 31) + this.f430836b.hashCode()) * 31;
            if (this.f430837c == false) goto L5;
            int r101 = 1231;
        L7:
            return r100 + r101;
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "DownVoteReason(id=" + this.f430835a + ", text=" + this.f430836b + ", isSelected=" + this.f430837c + ')';
        }

        public b(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "id");
            Intrinsics.checkNotNullParameter(r101, "text");
            this.f430835a = r100;
            this.f430836b = r101;
            this.f430837c = false;
        }
    }

    static {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return ((ArrayList) this.f430833b).size();
    }

    public DownVoteReasonAdapter() {
        this.f430832a = null;
        this.f430833b = new ArrayList();
    }

    public static void y2(AppCompatTextView r100, boolean r101) {
        Context r102 = r100.getContext();
        if (r101 == false) goto L5;
        Intrinsics.checkNotNull(r102);
        r100.setTextColor(UDColorUtils.getColor(r102, R.color.primary_pri_500));
        r100.setBackgroundResource(R.drawable.bg_down_vote_reason_selected);
        return;
    L5:
        Intrinsics.checkNotNull(r102);
        r100.setTextColor(UDColorUtils.getColor(r102, R.color.text_title));
        r100.setBackgroundResource(R.drawable.bg_down_vote_reason_normal);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        DownVoteReasonViewHolder r102 = (DownVoteReasonViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        b r103 = (b) ListProtector.get(this.f430833b, r101);
        r102.f430834a.setText(r103.f430836b);
        y2(r102.f430834a, r103.f430837c);
        r102.f430834a.setOnClickListener(new c(r103, this, r102, r101));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Context r102 = r100.getContext();
        AppCompatTextView r103 = new AppCompatTextView(r102);
        Intrinsics.checkNotNull(r102);
        r103.setTextSize(0, zz7.b.g(r102, 16));
        r103.setGravity(1);
        int r104 = UIUtils.dp2px(r102, 7.0f);
        r103.setPadding(0, r104, 0, r104);
        r103.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        r103.setMinHeight(UIUtils.dp2px(r102, 36.0f));
        return new DownVoteReasonViewHolder(r103);
    }
}
