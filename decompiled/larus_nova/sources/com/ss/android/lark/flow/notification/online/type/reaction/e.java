package com.ss.android.lark.flow.notification.online.type.reaction;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.larus.nova.R;
import com.ss.android.lark.appcontext.applifecycle.AppLifecycle;
import com.ss.android.lark.chat.api.service.track.sample.BaseSampleRecorder$Scene;
import com.ss.android.lark.flow.notification.online.type.reaction.entity.FlowReactionNotice;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.entity.AvatarImage;
import com.ss.android.lark.notification.export.AbstractNotification;
import com.ss.android.lark.notification.export.entity.Notice;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.UIHelper;
import java.util.concurrent.ExecutionException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@UserScope
public final class e extends AbstractNotification.AbstractNotificationDisplayer<rhb.a> {

    public static final class a {
    }

    public static final class b<R extends atb.a> implements AbstractNotification.AbstractNotificationDisplayer.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b<R> f423795a = null;

        static {
            f423795a = new b();
        }

        public b() {
        }

        @Override // com.ss.android.lark.notification.export.AbstractNotification.AbstractNotificationDisplayer.a
        public final void a(atb.a r110) {
            final rhb.a r111 = (rhb.a) r110;
            thb.a.b("FlowReactionNotificationDisplayer", "[Flow Push notify] Reaction - Notification display");
            ((qza.b) LarkContext.spiByDwarf(qza.b.class)).b1(LarkContext.getApplication(), new qza.c(BaseSampleRecorder$Scene.REACTION, r111.f537861c, r111.f16292a, r111.f16293b, new FlowReactionNotificationDisplayer$getNotificationDisplayerImpl$1$1$1(r111), ""));
        }
    }

    static {
    }

    public e() {
    }

    @Override // com.ss.android.lark.notification.export.AbstractNotification.AbstractNotificationDisplayer
    public final AbstractNotification.AbstractNotificationDisplayer.a<rhb.a> a() {
        return b.f423795a;
    }

    @Override // com.ss.android.lark.notification.export.AbstractNotification.AbstractNotificationDisplayer
    public final atb.a b(Notice r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        c r101 = new c((FlowReactionNotice) r100);
        FlowReactionNotice r102 = r101.f423789b;
        Intrinsics.checkNotNullParameter(r102, "<this>");
        String r103 = null;
        if (TextUtils.isEmpty(r102.messageId) == true) goto L12;
        Notice.Extra r104 = r102.extra;
        if (r104 == null) goto L7;
        String r105 = r104.f433057a;
    L9:
        if (TextUtils.isEmpty(r105) == true) goto L12;
        boolean r106 = false;
    L13:
        if (r106 == true) goto L40;
        rhb.a r107 = new rhb.a();
        r101.a(r107);
        Notice.Extra r108 = r101.f423789b.extra;
        if (r108.f433062f == false) goto L18;
        Bitmap r109 = BitmapFactory.decodeResource(r101.f423794g.getResources(), R.drawable.icon_flow_notification);
    L33:
        r107.f537861c = r109;
        FlowReactionNotice r110 = r101.f423789b;
        r107.f537862d = r110.extra.f433057a;
        r107.f537864f = r101.f423790c;
        if (com.ss.android.lark.notification.export.entity.a.a(r110) == true) goto L37;
        r103 = r101.f423791d;
    L37:
        r107.f537863e = r103;
        r107.f537865g = r101.f423793f;
        r107.f537866h = r101.f423792e;
        return r107;
    L18:
        String r111 = r108.f433063g;
    L30:
        e = move-exception;
        e.printStackTrace();
    L32:
        r109 = null;
    L28:
        e = move-exception;
        e.printStackTrace();
        goto L32
    L20:
        if (TextUtils.isEmpty(r111) == true) goto L26;
        int r112 = UIHelper.dp2px(48.0f);     // Catch: ExecutionException -> L28 InterruptedException -> L30
        Notice.Extra r113 = r101.f423789b.extra;     // Catch: ExecutionException -> L28 InterruptedException -> L30
        if (r113.f433058b != Notice.Extra.ChatType.P2P) goto L24;
        String r114 = r113.f433059c;     // Catch: ExecutionException -> L28 InterruptedException -> L30
    L25:
        r109 = ImageLoader.with(r101.f423794g).load(AvatarImage.Builder.obtain(r111, r114, r112, r112).build()).asBitmap().centerCrop().error(R.drawable.icon_flow_notification).getBitmap(r112, r112);     // Catch: ExecutionException -> L28 InterruptedException -> L30
        goto L33
    L24:
        r114 = r113.f433057a;     // Catch: ExecutionException -> L28 InterruptedException -> L30
        goto L25
    L26:
        r109 = BitmapFactory.decodeResource(r101.f423794g.getResources(), R.drawable.icon_flow_notification);     // Catch: ExecutionException -> L28 InterruptedException -> L30
        goto L33
    L40:
        return null;
    L7:
        r105 = null;
    L12:
        r106 = true;
        goto L13
    }

    @Override // com.ss.android.lark.notification.export.AbstractNotification.AbstractNotificationDisplayer
    public final boolean c(Notice r100) {
        boolean r101 = shb.b.b(r100);
        thb.a.b("FlowReactionNotificationDisplayer", "[Flow Push notify] Reaction - Notice key = " + r100.key + "，Notice message Id = " + r100.messageId + "，Push notify :" + r101 + "; sdk = " + Boolean.valueOf(r100.shouldNotify) + "; foreground = " + AppLifecycle.a.f408803a.h() + "; is current notifiable = " + Boolean.valueOf(r100.shouldNotify) + "; isFromBackgroundUser = " + Boolean.valueOf(r100.isFromBackgroundUser));
        return r101;
    }
}
