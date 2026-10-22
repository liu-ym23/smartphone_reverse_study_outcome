package com.bytedance.ee.bear.middleground.permission.lock;

import android.content.Context;
import android.util.AttributeSet;
import com.bytedance.ee.bear.widgets.t;
import com.larksuite.component.universe_design.notice.UDNotice;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import uh5.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ \u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u0006\u0010\u0014\u001a\u00020\rJ\u0006\u0010\f\u001a\u00020\r¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/lock/LockBannerView;", "Lcom/larksuite/component/universe_design/notice/UDNotice;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "show", "", "tip", "", "canRecover", "", "clickListener", "Landroid/view/View$OnClickListener;", "hide", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LockBannerView extends UDNotice {
    public LockBannerView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public LockBannerView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LockBannerView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        setIcon(2131255045);
        setTextButton(getContext().getString(2131887518));
        setTextButtonPosition(UDNotice.TextButtonPosition.AUTO);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void o6(String r2, boolean r3, t r4) {
        Intrinsics.checkNotNullParameter(r2, "tip");
        setVisibility(0);
        setText(r2);
        k6(r3);
        if (r3 == false) goto L5;
        setTextButtonListener(r4);
        return;
    L5:
        setTextButtonListener(a.a);
    }
}
