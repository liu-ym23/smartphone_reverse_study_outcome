package com.ss.android.lark.contact.base.contact_new.mvp;

import com.larksuite.framework.callback.UIGetDataCallback;
import com.larksuite.framework.mvp.IModel;
import com.ss.android.lark.contact.base.dto.ChatApplication;
import java.util.List;

/* JADX INFO: loaded from: classes35.dex */
public interface a extends IModel {

    /* JADX INFO: renamed from: com.ss.android.lark.contact.base.contact_new.mvp.a$a, reason: collision with other inner class name */
    public interface InterfaceC4928a {
        void a(List<ChatApplication> r100);
    }

    void L4();

    void X1(NewContactPresenter.a r100);

    void a4(String r100, UIGetDataCallback r101);

    void e4(UIGetDataCallback r100);

    boolean isHasMore();

    String x1();
}
