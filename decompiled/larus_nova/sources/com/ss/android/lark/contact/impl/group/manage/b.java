package com.ss.android.lark.contact.impl.group.manage;

import android.os.Bundle;
import com.larksuite.framework.mvp.IView;
import com.ss.android.lark.chat.entity.chat.Chat;
import java.util.List;

/* JADX INFO: loaded from: classes35.dex */
public interface b extends IView<a> {

    public interface a extends IView.IViewDelegate {
        void Z7();

        boolean canLoadMore();
    }

    void B5(List<Chat> r100);

    void i8(List<Chat> r100);

    void n();

    void refresh();

    void setEnableChatPreview(boolean r100);

    void setExtras(Bundle r100);
}
