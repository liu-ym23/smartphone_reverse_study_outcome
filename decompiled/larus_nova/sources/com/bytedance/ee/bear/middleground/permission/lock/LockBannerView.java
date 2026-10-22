package com.bytedance.ee.bear.middleground.permission.lock;

import android.content.Context;
import android.util.AttributeSet;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.ee.bear.widgets.t;
import com.larksuite.component.universe_design.notice.UDNotice;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import uh5.a;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ \u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u0006\u0010\u0014\u001a\u00020\rJ\u0006\u0010\f\u001a\u00020\r¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/lock/LockBannerView;", "Lcom/larksuite/component/universe_design/notice/UDNotice;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "show", "", AppConstants.BUNDLE_TIP, "", "canRecover", "", "clickListener", "Landroid/view/View$OnClickListener;", "hide", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LockBannerView extends UDNotice {
    public LockBannerView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public LockBannerView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0);
    }

    public LockBannerView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        setIcon(R.drawable.ud_icon_lock_filled);
        setTextButton(getContext().getString(R.string.CreationMobile_Wiki_Permission_Recover_Button));
        setTextButtonPosition(UDNotice.TextButtonPosition.AUTO);
    }

    public final void o6(String r100, boolean r101, t r102) {
        Intrinsics.checkNotNullParameter(r100, AppConstants.BUNDLE_TIP);
        setVisibility(0);
        setText(r100);
        k6(r101);
        if (r101 == false) goto L5;
        setTextButtonListener(r102);
        return;
    L5:
        setTextButtonListener(a.f550101a);
    }
}
