package com.bytedance.ee.bear.lark.selector;

import android.content.Context;
import com.larksuite.framework.mvp.BasePresenter;
import com.larksuite.framework.mvp.IView;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.utils.UIHelper;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e extends BasePresenter<d, DocsConfirmView, com.bytedance.ee.bear.lark.selector.base.a> {

    public class a implements com.bytedance.ee.bear.lark.selector.base.a {
        public a() {
        }
    }

    public final IView.IViewDelegate createViewDelegate() {
        return new a();
    }

    public final void create() {
        super.create();
        DocsConfirmView r0 = (DocsConfirmView) getView();
        List<DocSelectorViewData> r1 = getModel().a;
        r0.getClass();
        int r2 = r1.size();
        r0.mTitleBar.setTitle(UIHelper.mustacheFormat(2131892192, "select_count", Integer.toString(r2)));
        r0.mTitleBar.setLeftImageResource(2131248407);
        String r3 = UIUtils.getString(r0.b, 2131892137);
        r0.mTitleBar.addAction(new f(r0, r3));
        r0.mTitleBar.getRightText().setPadding(0, 0, UIUtils.dp2px(r0.b, 15.0f), 0);
        r0.c.resetAll(r1);
    }

    public e(Context r2, List r3, DocConfirmActivity.a r4) {
        DocsConfirmView r0 = new DocsConfirmView(r2, r4);
        setModel(new d(r3));
        setView(r0);
    }
}
