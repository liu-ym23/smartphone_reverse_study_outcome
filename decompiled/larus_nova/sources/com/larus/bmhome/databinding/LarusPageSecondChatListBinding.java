package com.larus.bmhome.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.ChatConversationList;
import com.larus.bmhome.view.NovaTitleBarEx;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusPageSecondChatListBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f311239a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ChatConversationList f311240b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinearLayout f311241c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final NovaTitleBarEx f311242d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f311239a;
    }

    public LarusPageSecondChatListBinding(LinearLayout r100, ChatConversationList r101, LinearLayout r102, NovaTitleBarEx r103) {
        this.f311239a = r100;
        this.f311240b = r101;
        this.f311241c = r102;
        this.f311242d = r103;
    }
}
