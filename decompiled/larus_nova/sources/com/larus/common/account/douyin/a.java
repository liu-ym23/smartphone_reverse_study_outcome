package com.larus.common.account.douyin;

import androidx.lifecycle.MutableLiveData;
import com.larus.bmhome.auth.douyin.IAiChatOpenDouyinAuthService;
import com.larus.im.bean.message.Message;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes27.dex */
public final class a implements IAiChatOpenDouyinAuthService.b {
    public a() {
    }

    @Override // com.larus.bmhome.auth.douyin.IAiChatOpenDouyinAuthService.b
    public final void a(boolean r100, Integer r101) {
        com.larus.common.account.douyin.ai.chat.a r102 = com.larus.common.account.douyin.ai.chat.a.f326039a;
        if (r101 == null) goto L6;
        r101.intValue();
    L6:
        monitor-enter(r102);
        MutableLiveData<Message> r103 = com.larus.common.account.douyin.ai.chat.a.f326041c;     // Catch: Throwable -> L14
        Message r104 = r103.getValue();     // Catch: Throwable -> L14
        r103.postValue(null);     // Catch: Throwable -> L14
        Iterator r105 = new ArrayList(com.larus.common.account.douyin.ai.chat.a.f326042d).iterator();     // Catch: Throwable -> L14
    L9:
        if (r105.hasNext() == false) goto L12;
        ((ya8.a) r105.next()).a(r100, r104);     // Catch: Throwable -> L14
        goto L9
    L12:
        monitor-exit(r102);
        return;
    L14:
        th = move-exception;
        throw th;
    }
}
