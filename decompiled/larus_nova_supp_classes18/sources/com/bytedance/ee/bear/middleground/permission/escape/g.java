package com.bytedance.ee.bear.middleground.permission.escape;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.middleground.permission.escape.model.EscapeApprovalInfo;
import com.bytedance.ee.bear.middleground.permission.escape.model.EscapeRuleBean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface g {

    public interface a {
        void onCancel();

        void onFailed(Throwable r1);

        void onSuccess();
    }

    public interface b {
        void onCancel();

        void onConfirm();
    }

    void a(FragmentActivity r1, EscapeRuleBean r2, EscapeApprovalInfo r3, com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult.l r4);

    void b(FragmentActivity r1, EscapeRuleBean r2, EscapeApprovalInfo r3, a r4);

    void c(FragmentActivity r1, EscapeApprovalInfo r2, b r3);

    void d(FragmentActivity r1, EscapeApprovalInfo r2);
}
