package com.larus.bmhome.chat.standarduikit.richmedia.viewmodel;

import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.api.q0;
import com.larus.im.bean.message.Message;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes26.dex */
public interface f0 {
    String b();

    CoroutineScope c();

    boolean d();

    q0 e();

    kc8.q g();

    Integer getBotConversationType();

    String getBotId();

    String getChatType();

    String getConversationId();

    String getCurrentPage();

    Fragment getHostFragment();

    boolean h(Message r100);

    String j();

    boolean l();

    boolean m(int r100);

    boolean n();

    void o();

    boolean p();

    Object q(Continuation<? super Unit> r100);

    q0.a r();
}
