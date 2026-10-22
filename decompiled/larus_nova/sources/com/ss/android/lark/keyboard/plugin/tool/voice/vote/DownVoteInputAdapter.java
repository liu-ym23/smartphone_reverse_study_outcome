package com.ss.android.lark.keyboard.plugin.tool.voice.vote;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import androidx.core.view.GravityCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.suite.lark.emm.design.edittext.SCAppCompatEditText;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u001a\u001b\u001cB\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\f\u001a\u00020\rJ\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0017J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\u000e\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\rJ\b\u0010\u0019\u001a\u00020\u0012H\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/vote/DownVoteInputAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/vote/DownVoteInputAdapter$DownVoteInputViewHolder;", "listener", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/vote/DownVoteInputAdapter$InputContentListener;", "<init>", "(Lcom/ss/android/lark/keyboard/plugin/tool/voice/vote/DownVoteInputAdapter$InputContentListener;)V", "getListener", "()Lcom/ss/android/lark/keyboard/plugin/tool/voice/vote/DownVoteInputAdapter$InputContentListener;", "setListener", "editText", "Landroidx/appcompat/widget/AppCompatEditText;", "getText", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "setHint", "hint", "getItemCount", "DownVoteInputViewHolder", "InputContentListener", "Companion", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DownVoteInputAdapter extends RecyclerView.Adapter<DownVoteInputViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SCAppCompatEditText f430829a;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/vote/DownVoteInputAdapter$DownVoteInputViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", KtvSubElement.CONTAINER, "Landroid/widget/FrameLayout;", "getContainer", "()Landroid/widget/FrameLayout;", "editText", "Landroid/widget/EditText;", "getEditText", "()Landroid/widget/EditText;", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class DownVoteInputViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final FrameLayout f430830a;

        public DownVoteInputViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            FrameLayout r101 = (FrameLayout) r100;
            this.f430830a = r101;
            View r102 = r101.getChildAt(0);
            Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type android.widget.EditText");
            EditText r103 = (EditText) r102;
        }
    }

    public static final class a {
    }

    static {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return 1;
    }

    public DownVoteInputAdapter() {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        DownVoteInputViewHolder r102 = (DownVoteInputViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        r102.getClass();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Context r102 = r100.getContext();
        FrameLayout r103 = new FrameLayout(r102);
        r103.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        r103.setPadding(0, UIUtils.dp2px(r102, 18.0f), 0, 0);
        Intrinsics.checkNotNull(r102);
        SCAppCompatEditText r104 = new SCAppCompatEditText(r102, null);
        r104.setTextSize(0, zz7.b.g(r102, 16));
        int r105 = UIUtils.dp2px(r102, 10.0f);
        int r106 = UIUtils.dp2px(r102, 16.0f);
        r104.setPadding(r106, r105, r106, r105);
        r104.setBackgroundResource(R.drawable.bg_down_vote_input);
        r104.setTextColor(UDColorUtils.getColor(r102, R.color.text_title));
        r104.setLayoutParams(new ViewGroup.LayoutParams(-1, UIUtils.dp2px(r102, 122.0f)));
        r104.setHint(R.string.MyAI_IM_SubmitFeedback_Placeholder);
        r104.setHintTextColor(UIUtils.getColor(r102, R.color.text_placeholder));
        r104.setMinLines(5);
        r104.setGravity(GravityCompat.START);
        r104.addTextChangedListener(new uob.a(this));
        if (r104.isAttachedToWindow() == false) goto L5;
        r104.setCursorVisible(false);
        r104.setCursorVisible(true);
        r104.setOnTouchListener(b.f430841a);
    L6:
        this.f430829a = r104;
        r103.addView(r104);
        return new DownVoteInputViewHolder(r103);
    L5:
        r104.addOnAttachStateChangeListener(new uob.b(r104, r104));
        goto L6
    }
}
