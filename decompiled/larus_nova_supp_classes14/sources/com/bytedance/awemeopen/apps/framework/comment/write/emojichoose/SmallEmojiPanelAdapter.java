package com.bytedance.awemeopen.apps.framework.comment.write.emojichoose;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.awemeopen.apps.framework.card.view.widget.EmptyFootViewHolder;
import com.bytedance.awemeopen.apps.framework.comment.emoji.OnlineSmallEmojiCache;
import com.bytedance.awemeopen.apps.framework.comment.emoji.OnlineSmallEmojiResManager;
import com.bytedance.awemeopen.infra.base.image.AoImageView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0003\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/comment/write/emojichoose/SmallEmojiPanelAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "b", "SmallEmojiPanelHolder", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class SmallEmojiPanelAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public final m44.d a;
    public final List<Object> b;
    public final List<Object> c;
    public e d;

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/comment/write/emojichoose/SmallEmojiPanelAdapter$SmallEmojiPanelHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
    public static final class SmallEmojiPanelHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final m44.d a;
        public final AoImageView b;
        public m44.b c;

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            String r0 = null;
            if (r3 == null) goto L5;
            Integer r4 = Integer.valueOf(r3.getId());
        L6:
            if (r4 != null) goto L9;
            return;
        L9:
            if (r4.intValue() != 2131371533) goto L15;
            m44.d r5 = this.a;
            m44.b r1 = this.c;
            if (r1 == null) goto L13;
            r0 = r1.c;
        L13:
            r5.a(r0, 1);
            return;
        L15:
            return;
        L5:
            r4 = null;
            goto L6
        }

        public SmallEmojiPanelHolder(View r1, m44.d r2, e r3) {
            Intrinsics.checkNotNullParameter(r1, "itemView");
            Intrinsics.checkNotNullParameter(r2, "inputApi");
            super(r1);
            this.a = r2;
            AoImageView r4 = r1.findViewById(2131371533);
            this.b = r4;
            if (r4 == null) goto L6;
            r4.setOnClickListener(this);
            return;
        }
    }

    public static final class a {
        public a() {
        }
    }

    public static final class b {
    }

    static {
    }

    public final int getItemCount() {
        return ((ArrayList) this.c).size();
    }

    public final int getItemViewType(int r2) {
        if ((ListProtector.get(this.c, r2) instanceof m44.b) == false) goto L6;
        return 1;
    L6:
        return 2;
    }

    public SmallEmojiPanelAdapter(m44.d r2, List<Object> r3) {
        Intrinsics.checkNotNullParameter(r2, "inputApi");
        Intrinsics.checkNotNullParameter(r3, "originalList");
        this.a = r2;
        this.b = r3;
        ArrayList r4 = new ArrayList();
        this.c = r4;
        r4.addAll(r3);
        r4.add(new a());
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "holder");
        if ((r6 instanceof SmallEmojiPanelHolder) == false) goto L30;
        Object r8 = ListProtector.get(this.c, r7);
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type com.bytedance.awemeopen.emoji.api.base.BaseEmoji");
        m44.b r9 = (m44.b) r8;
        int r0 = r9.a;
        if (r0 <= 0) goto L9;
        AoImageView r1 = ((SmallEmojiPanelHolder) r6).b;
        if (r1 == null) goto L28;
        r1.setImageResource(r0);
    L28:
        ((SmallEmojiPanelHolder) r6).c = r9;
        return;
    L9:
        String r2 = r9.b;
        if (r2 != null) goto L12;
    L15:
        boolean r3 = true;
    L16:
        if (r3 == true) goto L28;
        OnlineSmallEmojiResManager r4 = OnlineSmallEmojiResManager.i;
        OnlineSmallEmojiResManager r5 = OnlineSmallEmojiResManager.i;
        AoImageView r10 = ((SmallEmojiPanelHolder) r6).b;
        Intrinsics.checkNotNull(r10);
        r5.getClass();
        Intrinsics.checkNotNullParameter(r10, "view");
        Intrinsics.checkNotNullParameter(r9, "emoji");
        if (r5.c() == false) goto L28;
        OnlineSmallEmojiCache r11 = r5.e;
        if (r11 == null) goto L25;
        Bitmap r12 = r11.b(r5.e(r9.c), false);
        if (r12 == null) goto L25;
        r10.setImageDrawable(new BitmapDrawable(r10.getContext().getResources(), r12));
        Unit r13 = Unit.INSTANCE;
    L26:
        if (r13 != null) goto L28;
        String r14 = r9.b;
        r10.getClass();
        Intrinsics.checkNotNullParameter(r14, "url");
        r10.j(new com.bytedance.awemeopen.infra.base.image.b(r14));
    L25:
        r13 = null;
        goto L26
    L12:
        if (r2.length() == 0) goto L15;
        r3 = false;
        goto L16
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        if (r5 == 1) goto L10;
        if (r5 != 2) goto L8;
        return new EmptyFootViewHolder(LayoutInflater.from(r4.getContext()).inflate(2131558626, r4, false));
    L8:
        throw new RuntimeException("unSupport view type!");
    L10:
        return new SmallEmojiPanelHolder(LayoutInflater.from(r4.getContext()).inflate(2131558625, r4, false), this.a, this.d);
    }
}
