package com.bytedance.android.shopping.commentv3.uitree.bottomcard;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.model.response.LynxCellDataConfig;
import com.bytedance.android.shopping.anchorv3.comment.model.BottomProductCardInfo;
import com.bytedance.android.shopping.anchorv3.comment.model.CommentParams;
import com.bytedance.android.shopping.commentv3.base.BaseCommentUI;
import com.bytedance.android.shopping.commentv3.base.CommentApiCenter;
import com.bytedance.android.shopping.commentv3.base.c;
import com.bytedance.android.shopping.commentv3.base.d;
import com.bytedance.android.shopping.commentv3.uitree.p000float.g;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import oc3.a;
import oc3.b;
import ti.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/shopping/commentv3/uitree/bottomcard/BottomProductCardUI;", "Lcom/bytedance/android/shopping/commentv3/base/BaseCommentUI;", "Loc3/b;", "Loc3/a;", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BottomProductCardUI extends BaseCommentUI<b, a> {
    public l i;

    @Override // com.bytedance.android.shopping.commentv3.base.BaseCommentUI, com.bytedance.android.shopping.commentv3.base.BaseUI, com.bytedance.android.shopping.commentv3.base.LifecycleUI
    public final void onCreate() {
        super.onCreate();
        com.bytedance.android.shopping.commentv3.data.b r1 = this.e;
        FragmentActivity r2 = null;
        if (r1 == null) goto L7;
        CommentParams r3 = r1.a;
        if (r3 == null) goto L7;
        BottomProductCardInfo r4 = r3.getBottomProductCardInfo();
    L8:
        if (r4 == null) goto L10;
        LynxCellDataConfig r5 = r4.getLynxConfig();
    L11:
        if (r4 == null) goto L13;
        String r6 = r4.getProductCardInfo();
    L14:
        if (r5 != null) goto L16;
        return;
    L16:
        if (r6 != null) goto L18;
    L21:
        boolean r7 = true;
    L22:
        if (r7 == false) goto L25;
        return;
    L25:
        if (this.i != null) goto L72;
        View r8 = this.c;
        if ((r8 instanceof FrameLayout) == true) goto L30;
        r8 = null;
    L30:
        FrameLayout r9 = (FrameLayout) r8;
        if (r9 == null) goto L70;
        c r10 = this.g;
        if (r10 == null) goto L42;
        CommentApiCenter r11 = r10.a;
        if (r11 == null) goto L42;
        Iterator<T> r12 = r11.a().iterator();
    L38:
        if (r12.hasNext() == false) goto L42;
        d r13 = (d) r12.next();
        if ((r13 instanceof g) == false) goto L38;
    L44:
        if ((r13 instanceof g) == true) goto L46;
        r13 = null;
    L46:
        g r14 = (g) r13;
        if (r14 == null) goto L49;
        r14.e(com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r5.getHeight())));
    L49:
        c r15 = this.g;
        if (r15 == null) goto L54;
        Fragment r16 = r15.b;
        if (r16 == null) goto L54;
        r2 = r16.getActivity();
    L54:
        if (r2 == null) goto L58;
        Window r17 = r2.getWindow();
        if (r17 == null) goto L58;
        r17.setNavigationBarColor(-1);
    L58:
        ViewGroup.LayoutParams r18 = r9.getLayoutParams();
        if (r18 == null) goto L61;
        r18.height = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r5.getHeight()));
        r9.setLayoutParams(r18);
    L61:
        r9.setVisibility(0);
        Context r19 = r9.getContext();
        String r20 = r5.getUrl();
        if (r20 != null) goto L64;
        r20 = "";
    L64:
        LinkedHashMap r21 = new LinkedHashMap();
        r21.put("product_info", r6);
        Unit r22 = Unit.INSTANCE;
        this.i = ECLiveHybridUtil.b(r19, r20, r21, r9, null, null, null, false, null, null, false, 4080);
        return;
    L42:
        r13 = null;
        goto L44
    L70:
        return;
    L72:
        return;
    L18:
        if (r6.length() == 0) goto L21;
        r7 = false;
        goto L22
    L13:
        r6 = null;
        goto L14
    L10:
        r5 = null;
    L7:
        r4 = null;
        goto L8
    }

    public BottomProductCardUI() {
    }
}
