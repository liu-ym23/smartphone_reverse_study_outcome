package com.ss.android.lark.contact.impl.group;

import android.os.Bundle;
import android.os.Message;
import android.os.RemoteException;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.contact.entity.SelectedData;

/* JADX INFO: loaded from: classes35.dex */
public final class a implements LifecycleObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ContactsMyGroupFragment.b f419476a;

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        ContactsMyGroupFragment.b r100 = this.f419476a;
        Message r101 = r100.f419469a;
        Chat r102 = r100.f419470b;
        Message r103 = Message.obtain();
        if (r102 == null) goto L8;
        Bundle r104 = new Bundle();
        r103.setData(r104);
        SelectedData r105 = new SelectedData();
        r105.dataType = SelectedData.DataType.CHAT;
        r105.f419437id = r102.getId();
        r105.name = r102.getName();
        r105.avatarKey = r102.getAvatarKey();
        r105.addToBundle(r104);
    L8:
        r101.replyTo.send(r103);     // Catch: RemoteException -> L7
        return;
    }

    public a(ContactsMyGroupFragment.b r100) {
        this.f419476a = r100;
    }
}
