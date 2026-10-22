package com.ss.android.lark.flow.notification.online.type.message;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.larus.network.http.ServiceType;
import com.larus.nova.R;
import com.ss.android.lark.appcontext.applifecycle.AppLifecycle;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.entity.AvatarImage;
import com.ss.android.lark.notification.export.AbstractNotification;
import com.ss.android.lark.notification.export.entity.Notice;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.concurrent.ExecutionException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class e extends AbstractNotification.AbstractNotificationDisplayer<qhb.a> {

    public static final class a {
    }

    public static final class b<R extends atb.a> implements AbstractNotification.AbstractNotificationDisplayer.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b<R> f423787a = null;

        static {
            f423787a = new b();
        }

        public b() {
        }

        @Override // com.ss.android.lark.notification.export.AbstractNotification.AbstractNotificationDisplayer.a
        public final void a(atb.a r110) {
            final qhb.a r111 = (qhb.a) r110;
            thb.a.b("FlowMessageNotification", "[Flow Push notify] Message - Notification display");
            ((qza.b) LarkContext.spiByDwarf(qza.b.class)).b1(LarkContext.getApplication(), new qza.c(ServiceType.IM, r111.f533069c, r111.f16292a, r111.f16293b, new FlowMessageNotificationDisplayer$getNotificationDisplayerImpl$1$1$1(r111), ""));
        }
    }

    static {
    }

    public e() {
    }

    @Override // com.ss.android.lark.notification.export.AbstractNotification.AbstractNotificationDisplayer
    public final AbstractNotification.AbstractNotificationDisplayer.a<qhb.a> a() {
        return b.f423787a;
    }

    @Override // com.ss.android.lark.notification.export.AbstractNotification.AbstractNotificationDisplayer
    public final atb.a b(Notice r110) {
        Intrinsics.checkNotNullParameter(r110, "data");
        c r100 = new c(r110);
        String r101 = null;
        if (r100.f423780c != null) goto L5;
    L58:
        thb.a.a("FlowMessageNotificationDataPacker", "messageId or getChatId is null");
        return null;
    L5:
        if (r100.f423781d == null) goto L58;
        if (r100.f423782e == null) goto L58;
        qhb.a r111 = new qhb.a();
        r100.a(r111);
        if (r100.r() == true) goto L12;
    L14:
        Math.max(r100.f423779b.extra.f433064h, 1);
    L15:
        r100.s();
        r100.r();
        Context r102 = r100.f423786i;
        Notice r103 = r100.f423779b;
        int r104 = shb.a.f542085a;
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r103, "notice");
        String r105 = r103.extra.f433063g;
    L29:
        e = move-exception;
        e.printStackTrace();
    L31:
        Bitmap r106 = null;
    L32:
        if (r106 == null) goto L35;
        r111.f533069c = r106;
    L35:
        if (r100.r() == false) goto L40;
        if (r100.s() == false) goto L40;
    L46:
        Notice r107 = r100.f423779b;
        long r108 = r107.createTime;
        r111.f533070d = r100.f423781d;
        r111.f533072f = r100.f423780c;
        if (com.ss.android.lark.notification.export.entity.a.a(r107) == true) goto L50;
        r101 = r100.f423783f;
    L50:
        r111.f533071e = r101;
        r111.f533073g = r100.f423785h;
        r111.f533074h = r100.f423784g;
        if (AppLifecycle.a.f408803a.h() == false) goto L61;
        if (r100.s() == true) goto L61;
        TextUtils.isEmpty(r100.f423779b.extra.f433076t);
    L61:
        return r111;
    L40:
        if (r100.r() == true) goto L42;
    L44:
        Math.max(r100.f423779b.extra.f433064h, 1);
    L45:
        UIHelper.getString(R.string.Lark_Legacy_AmountNotificationUnit);
        goto L46
    L42:
        if (r100.s() == false) goto L44;
    L27:
        e = move-exception;
        e.printStackTrace();
        goto L31
    L17:
        if (TextUtils.isEmpty(r105) == false) goto L19;
    L25:
        r106 = BitmapFactory.decodeResource(r102.getResources(), R.drawable.icon_flow_notification);     // Catch: ExecutionException -> L27 InterruptedException -> L29
        goto L32
    L19:
        if (r103.extra.f433062f == true) goto L25;
        int r109 = UIHelper.dp2px(48.0f);     // Catch: ExecutionException -> L27 InterruptedException -> L29
        Notice.Extra r112 = r103.extra;     // Catch: ExecutionException -> L27 InterruptedException -> L29
        if (r112.f433058b != Notice.Extra.ChatType.P2P) goto L23;
        String r113 = r112.f433059c;     // Catch: ExecutionException -> L27 InterruptedException -> L29
        Intrinsics.checkNotNull(r113);     // Catch: ExecutionException -> L27 InterruptedException -> L29
    L24:
        r106 = ImageLoader.with(r102).load(AvatarImage.Builder.obtain(r105, r113, r109, r109).build()).asBitmap().centerCrop().error(R.drawable.icon_flow_notification).getBitmap(r109, r109);     // Catch: ExecutionException -> L27 InterruptedException -> L29
        goto L32
    L23:
        r113 = r112.f433057a;     // Catch: ExecutionException -> L27 InterruptedException -> L29
        Intrinsics.checkNotNull(r113);     // Catch: ExecutionException -> L27 InterruptedException -> L29
        goto L24
    L12:
        if (r100.s() == false) goto L14;
        goto L14
    }

    @Override // com.ss.android.lark.notification.export.AbstractNotification.AbstractNotificationDisplayer
    public final boolean c(Notice r100) {
        boolean r101 = shb.b.b(r100);
        thb.a.b("FlowMessageNotification", "[Flow Push notify] Message - Notice key = " + r100.key + "，Notice message Id = " + r100.messageId + "，Push notify :" + r101 + "; sdk = " + Boolean.valueOf(r100.shouldNotify) + "; foreground = " + AppLifecycle.a.f408803a.h() + "; is current notifiable = " + Boolean.valueOf(r100.shouldNotify) + "; isFromBackgroundUser = " + Boolean.valueOf(r100.isFromBackgroundUser));
        return r101;
    }
}
