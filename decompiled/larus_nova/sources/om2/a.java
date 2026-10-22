package om2;

import com.bytedance.android.live.core.log.g;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.business.IHostDouyinIm;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.g3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.x3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.config.LiveConfigSettingKeys;
import com.bytedance.android.livesdk.log.b0;
import com.bytedance.android.livesdk.messagebox.api.MessageBoxApi;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import pp1.j;

/* JADX INFO: loaded from: classes11.dex */
public final class a implements IHostDouyinIm.IDouyinImEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f524237a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Disposable f524238b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Disposable f524239c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f524240d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f524241e = null;

    /* JADX INFO: renamed from: om2.a$a, reason: collision with other inner class name */
    public static final class C7070a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C7070a f524242a = null;

        static {
            f524242a = new C7070a();
        }

        public C7070a() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Disposable r101 = a.f524238b;
            List<pm2.a> r102 = ((pm2.b) r100).a();
            ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
            Iterator<T> r104 = r102.iterator();
        L4:
            if (r104.hasNext() == false) goto L6;
            r103.add(Long.valueOf(((pm2.a) r104.next()).a()));
            goto L4
        L6:
            a.b(CollectionsKt.sumOfLong(r103));
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f524243a = null;

        static {
            f524243a = new b();
        }

        public b() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            b0.o().getClass();
            g.d("messageBox", "messagebox fetch err", (Throwable) r100);
        }
    }

    public a() {
    }

    static {
        f524241e = new a();
        f524240d = true;
    }

    public final void a() {
        IHostDouyinIm r100 = TTLiveSDK.hostService().hostDouyinIm();
        if (r100 != null) goto L5;
    L12:
        Disposable r101 = f524238b;
        if (r101 == null) goto L15;
        r101.dispose();
    L15:
        f524238b = ((MessageBoxApi) com.bytedance.android.live.network.c.b().e(MessageBoxApi.class)).getMessageCount(1).compose(RxUtil.rxSchedulerHelper()).subscribe(C7070a.f524242a, b.f524243a);
        return;
    L5:
        if (r100.isAuthSuccess() != true) goto L12;
        if (LiveConfigSettingKeys.SHOW_DOUYIN_IM_ENTRANCE.getValue().booleanValue() == false) goto L12;
        b(r100.getUnreadCount());
        if (f524240d == false) goto L17;
        f524240d = false;
        r100.bindDouyinImEventListener(this);
        return;
    }

    public static void b(long r100) {
        if (f524237a == r100) goto L14;
        f524237a = r100;
        x3 r101 = y3.l();
        ToolbarButton r102 = ToolbarButton.MORE;
        boolean r103 = true;
        if (r100 <= 0) goto L7;
        boolean r104 = true;
    L8:
        r101.b(r102, new j(r104));
        g3 r105 = y3.e();
        ToolbarButton r106 = ToolbarButton.MESSAGE_BOX;
        if (r100 > 0) goto L12;
        r103 = false;
    L12:
        r105.b(r106, new j(r103));
        return;
    L7:
        r104 = false;
        goto L8
    }

    @Override // com.bytedance.android.livehostapi.business.IHostDouyinIm.IDouyinImEventListener
    public final void onGetUnreadCount(int r100) {
        b(r100);
    }
}
