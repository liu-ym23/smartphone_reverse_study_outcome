package com.ss.android.lark.biz.im.api.extension.scroll;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.chat.configurator.AutoScrollBottomHandler;

/* JADX INFO: loaded from: classes34.dex */
public interface c {
    void a();

    void b(RecyclerView r100, LinearLayoutManager r101);

    boolean c(e.a.C4769a r100);

    boolean d(e.a.C4769a r100);

    void detach();

    void e(AutoScrollBottomHandler.b r100);

    String f(ScrollEvent r100);
}
