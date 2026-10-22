package com.larus.bmhome.databinding;

import android.view.View;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.ChatConversationList;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusPageConversationListBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ChatConversationList f311234a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ChatConversationList f311235b;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f311234a;
    }

    public LarusPageConversationListBinding(ChatConversationList r100, ChatConversationList r101) {
        this.f311234a = r100;
        this.f311235b = r101;
    }
}
