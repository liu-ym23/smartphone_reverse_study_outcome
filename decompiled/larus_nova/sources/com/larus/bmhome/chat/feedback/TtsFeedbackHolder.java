package com.larus.bmhome.chat.feedback;

import android.content.Context;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.larus.bmhome.databinding.LarusItemTtsFeedbackBinding;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/larus/bmhome/chat/feedback/TtsFeedbackHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/larus/bmhome/databinding/LarusItemTtsFeedbackBinding;", "<init>", "(Lcom/larus/bmhome/databinding/LarusItemTtsFeedbackBinding;)V", "getBinding", "()Lcom/larus/bmhome/databinding/LarusItemTtsFeedbackBinding;", "bindData", "", MapController.ITEM_LAYER_TAG, "Lcom/larus/audio/bean/FeedbackItem;", "isAdd", "", "updateSelectStatus", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TtsFeedbackHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusItemTtsFeedbackBinding f303007a;

    public TtsFeedbackHolder(LarusItemTtsFeedbackBinding r100) {
        Intrinsics.checkNotNullParameter(r100, "binding");
        super(r100.f310997a);
        this.f303007a = r100;
    }

    public final void T3(boolean r100) {
        Context r101 = null;
        if (r100 == false) goto L9;
        AppCompatImageView r102 = this.f303007a.f311000d;
        if (r102 == null) goto L15;
        if (r102 == null) goto L8;
        r101 = r102.getContext();
    L8:
        r102.setImageResource(v19.c.b(R.attr.larus_ic_tts_feedback_select, r101, R.drawable.larus_ic_tts_feedback_select));
        return;
    L15:
        return;
    L9:
        AppCompatImageView r103 = this.f303007a.f311000d;
        if (r103 == null) goto L17;
        if (r103 == null) goto L13;
        r101 = r103.getContext();
    L13:
        r103.setImageResource(v19.c.b(R.attr.larus_ic_tts_feedback_normal, r101, R.drawable.larus_ic_tts_feedback_normal));
        return;
    }
}
