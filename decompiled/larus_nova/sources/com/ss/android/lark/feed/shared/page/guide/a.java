package com.ss.android.lark.feed.shared.page.guide;

import android.app.Activity;
import android.util.Size;
import android.view.View;
import com.bytedance.sdk.account.platform.api.ITwitterService;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.guide.ui.config.AnchorConfig;
import com.ss.android.lark.guide.ui.config.MaskConfig;
import com.ss.android.lark.utils.UIHelper;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
import ujb.d;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f421416a = 0;

    /* JADX INFO: renamed from: com.ss.android.lark.feed.shared.page.guide.a$a, reason: collision with other inner class name */
    public interface InterfaceC4967a {
        void onClose();

        void onConfirm();
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f421417a = null;

        static {
            int[] r100 = new int[FeedTipGuideHelper$GuideType.values().length];
            r100[FeedTipGuideHelper$GuideType.BADGE_STYLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[FeedTipGuideHelper$GuideType.AT_ALL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[FeedTipGuideHelper$GuideType.AT_USER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f421417a = r100;
        }
    }

    static {
    }

    public static void a(View r100, Activity r101, UIFeedCard.AtInfo r102, boolean r110, InterfaceC4967a r111) {
        if (r100 == null) goto L15;
        if (r102 == null) goto L15;
        if (r101 == null) goto L15;
        if (r110 == false) goto L8;
        String r103 = "all_feed_mention_all";
    L9:
        AnchorConfig r104 = new AnchorConfig(r100, AnchorConfig.AnchorGravity.START);
        MaskConfig r105 = new MaskConfig(MaskConfig.ShapeType.CIRCLE, null, new Size(12, 12), 42);
        d r106 = new d(UIUtils.getString(r100.getContext(), R.string.Lark_Legacy_HintIHadKnow), new com.ss.android.lark.feed.shared.page.guide.b(r111, r103));
        if (r110 == false) goto L12;
        String r107 = UIHelper.mustacheFormat(R.string.Lark_Legacy_FeedAtAllGuideTip, ITwitterService.ResponseConstants.USER_NAME, r102.getLocalizedUserName());
    L13:
        Intrinsics.checkNotNull(r107);
        ujb.c r108 = new ujb.c(r104, r105, r107, r106);
        int r109 = qjb.a.f533446a;
        Intrinsics.checkNotNullParameter(r101, "activity");
        Intrinsics.checkNotNullParameter(r108, "config");
        new tjb.c(new WeakReference(r101), r108).o();
        heb.a.f484903a.getGuideDependency().c();
        return;
    L12:
        r107 = UIHelper.mustacheFormat(R.string.Lark_Legacy_FeedAtYouGuideTip, ITwitterService.ResponseConstants.USER_NAME, r102.getLocalizedUserName());
        goto L13
    L8:
        r103 = "all_feed_mention_you";
    L15:
        if (r111 == null) goto L18;
        r111.onClose();
        return;
    }
}
