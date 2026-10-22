package tq5;

import android.content.Context;
import android.util.SparseIntArray;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.feed.export.bean.DocFeed$Value$Result;
import com.bytedance.ee.bear.wikiv2.wikitreev2.move.WikiMovToFragment;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiDialogs;
import com.larksuite.component.ui.dialog.LKUIDialog;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ WikiMovToFragment a;
    public final /* synthetic */ TreeNode b;

    public c(WikiMovToFragment r1, TreeNode r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r9) {
        Boolean r10 = (Boolean) r9;
        tt5.a.h("Wiki_WikiMovToFragment", "needShowSinglePageOwnerTips success, result = " + r10);
        Toast.cancelLoading();
        if (r10.booleanValue() == false) goto L7;
        WikiMovToFragment r11 = this.a;
        int r0 = WikiMovToFragment.x;
        WikiDialogs r1 = r11.k;
        Context r12 = r11.getContext();
        WikiMovToFragment r2 = this.a;
        a r3 = new a(r2, this.b);
        b r4 = new b(r2);
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "confirm");
        Intrinsics.checkNotNullParameter(r4, DocFeed$Value$Result.CANCEL);
        r1.c();
        if (r12 == null) goto L9;
        com.larksuite.component.ui.dialog.d r5 = new com.larksuite.component.ui.dialog.d(r12);
        r5.c.backgroundColor(2131100548);
        r5.c.messageTextColor(2131106622);
        r5.c.messageGravity(8388611);
        r5.c.message(2131887533);
        r5.c.titleColor(2131106622);
        r5.c.titleBold(true);
        r5.c.cancelOnTouchOutside(false);
        r5.c.maskAlpha(0.3f);
        r5.e(17);
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.p r13 = new com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.p(r4);
        UDBaseDialogBuilder.ActionBuilder r6 = new UDBaseDialogBuilder.ActionBuilder();
        SparseIntArray r7 = com.larksuite.component.ui.dialog.d.e;
        r6.actionResId(r7.get(2131378550, 2131378550));
        r6.text(2131888316);
        r6.text(null);
        r6.textSize(0);
        r6.textColorRes(2131106622);
        r6.textColor(0);
        r6.bgColorRes(0);
        r6.bgDrawableRes(0);
        r6.onClickListener(r13);
        r5.c.addActionButton(r6);
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.q r14 = new com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.q(r3);
        UDBaseDialogBuilder.ActionBuilder r8 = new UDBaseDialogBuilder.ActionBuilder();
        r8.actionResId(r7.get(2131378551, 2131378551));
        r8.text(2131888317);
        r8.text(null);
        r8.textSize(0);
        r8.textColorRes(2131102093);
        r8.textColor(0);
        r8.bgColorRes(0);
        r8.bgDrawableRes(0);
        r8.onClickListener(r14);
        r5.c.addActionButton(r8);
        LKUIDialog r15 = r5.c();
        r1.d = r15;
        WikiDialogs.b(r15);
        return;
    L9:
        return;
    L7:
        WikiMovToFragment.da0(this.a, this.b);
    }
}
