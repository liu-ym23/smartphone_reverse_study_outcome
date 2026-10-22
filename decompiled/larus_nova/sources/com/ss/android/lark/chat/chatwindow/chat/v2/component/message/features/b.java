package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.CoreMessageListComponent;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import s2b.d;

/* JADX INFO: loaded from: classes35.dex */
public interface b {
    d a();

    <F extends a> F b(Class<F> r100);

    LifecycleCoroutineScope c();

    IMessageListViewModel f();

    FragmentActivity getActivity();

    v getContainer();

    View getContentView();

    Context getContext();

    IMessageListComponent.e getDependency();

    Fragment getFragment();

    CoreMessageListComponent getLifecycleOwner();
}
