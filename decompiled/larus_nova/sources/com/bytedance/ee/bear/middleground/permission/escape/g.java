package com.bytedance.ee.bear.middleground.permission.escape;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.middleground.permission.escape.model.EscapeApprovalInfo;
import com.bytedance.ee.bear.middleground.permission.escape.model.EscapeRuleBean;

/* JADX INFO: loaded from: classes18.dex */
public interface g {

    public interface a {
        void onCancel();

        void onFailed(Throwable r100);

        void onSuccess();
    }

    public interface b {
        void onCancel();

        void onConfirm();
    }

    void a(FragmentActivity r100, EscapeRuleBean r101, EscapeApprovalInfo r102, com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult.l r103);

    void b(FragmentActivity r100, EscapeRuleBean r101, EscapeApprovalInfo r102, a r103);

    void c(FragmentActivity r100, EscapeApprovalInfo r101, b r102);

    void d(FragmentActivity r100, EscapeApprovalInfo r101);
}
