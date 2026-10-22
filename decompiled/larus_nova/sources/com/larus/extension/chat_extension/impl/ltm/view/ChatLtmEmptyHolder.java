package com.larus.extension.chat_extension.impl.ltm.view;

import android.view.View;
import com.larus.extension.chat_extension.impl.ltm.r;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/larus/extension/chat_extension/impl/ltm/view/ChatLtmEmptyHolder;", "Lcom/larus/extension/chat_extension/impl/ltm/view/ChatLtmBaseHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "getItemView", "()Landroid/view/View;", "bindData", "", "data", "Lcom/larus/extension/chat_extension/impl/ltm/ChatLtmItemData;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatLtmEmptyHolder extends ChatLtmBaseHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f342881a;

    @Override // com.larus.extension.chat_extension.impl.ltm.view.ChatLtmBaseHolder
    public final void T3(r r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
    }

    public ChatLtmEmptyHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f342881a = r100;
    }
}
