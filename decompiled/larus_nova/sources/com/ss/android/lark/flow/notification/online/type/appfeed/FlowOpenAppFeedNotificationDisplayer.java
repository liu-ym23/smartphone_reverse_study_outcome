package com.ss.android.lark.flow.notification.online.type.appfeed;

import com.larus.nova.R;
import com.ss.android.lark.appcontext.applifecycle.AppLifecycle;
import com.ss.android.lark.notification.export.AbstractNotification;
import com.ss.android.lark.notification.export.entity.Notice;
import com.ss.android.lark.profile.utils.IProfileLauncherV2;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.UIHelper;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import qza.c;

/* JADX INFO: loaded from: classes36.dex */
public final class FlowOpenAppFeedNotificationDisplayer extends AbstractNotification.AbstractNotificationDisplayer<phb.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy<IProfileLauncherV2> f423776a = null;

    public static final class a {
    }

    public final class b implements AbstractNotification.AbstractNotificationDisplayer.a<phb.a> {
        public b() {
        }

        @Override // com.ss.android.lark.notification.export.AbstractNotification.AbstractNotificationDisplayer.a
        public final void a(atb.a r110) {
            final phb.a r111 = (phb.a) r110;
            Intrinsics.checkNotNullParameter(r111, "data");
            thb.a.b("FlowOpenAppFeedNotificationDisplayer", "[Flow Push notify] Open App Feed - show notification");
            ((qza.b) LarkContext.spiByDwarf(qza.b.class)).b1(LarkContext.getApplication(), new c("OpenAppFeed", r111.f529311c, r111.f16292a, r111.f16293b, new FlowOpenAppFeedNotificationDisplayer$OpenAppFeedDisplayerImpl$showNotification$1$1(r111), UIHelper.getString(R.string.LarkIM_Friend_ViewRequest_Button)));
        }
    }

    static {
        f423776a = LazyKt.lazy(FlowOpenAppFeedNotificationDisplayer$Companion$profileLauncherInstance$2.INSTANCE);
    }

    @Override // com.ss.android.lark.notification.export.AbstractNotification.AbstractNotificationDisplayer
    public final AbstractNotification.AbstractNotificationDisplayer.a<phb.a> a() {
        return new b();
    }

    public FlowOpenAppFeedNotificationDisplayer() {
    }

    @Override // com.ss.android.lark.notification.export.AbstractNotification.AbstractNotificationDisplayer
    public final atb.a b(Notice r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        return new com.ss.android.lark.flow.notification.online.type.appfeed.b(r100).r();
    }

    @Override // com.ss.android.lark.notification.export.AbstractNotification.AbstractNotificationDisplayer
    public final boolean c(Notice r100) {
        boolean r101 = shb.b.b(r100);
        thb.a.b("FlowOpenAppFeedNotificationDisplayer", "[Flow Push notify] AppFeed - Notice key = " + r100.key + "，Notice message Id = " + r100.messageId + "，Push notify :" + r101 + "; sdk = " + Boolean.valueOf(r100.shouldNotify) + "; foreground = " + AppLifecycle.a.f408803a.h() + "; is current notifiable = " + Boolean.valueOf(r100.shouldNotify) + "; isFromBackgroundUser = " + Boolean.valueOf(r100.isFromBackgroundUser));
        return r101;
    }
}
