package com.bytedance.android.shopping.store.tabkit.mixframe;

import android.view.View;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public interface c {
    public static final a a = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }
    }

    static {
        a = a.a;
    }

    View a();

    List<QIPresenter> b(View r1);

    void destroy();

    void init();

    void onHide(boolean r1);

    void onShow(boolean r1);
}
