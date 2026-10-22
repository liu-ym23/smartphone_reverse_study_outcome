package nd2;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.ktv.common.model.bean.DownloadResourceType;
import com.bytedance.android.live.ktv.common.music.download.KtvMusicManager;
import com.bytedance.android.live.ktv.common.music.download.p;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.android.live.ktv.common.util.i;
import com.bytedance.android.livesdk.config.b9;
import com.bytedance.android.livesdk.ktvimpl.base.logger.KtvLoggerHelper;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b implements p.a {
    public final /* synthetic */ c a;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ b a;
        public final /* synthetic */ MusicPanel b;

        public a(b r1, MusicPanel r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r8) {
            c r9 = this.a.a;
            MusicPanel r1 = this.b;
            r9.getClass();
            KtvMusicManager.e(KtvMusicManager.m, r1, new nd2.a(r9), false, null, r9.e, 12);
        }
    }

    public b(c r1) {
        this.a = r1;
    }

    public final void c(MusicPanel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "panel");
        this.a.d.c(r3, r4);
        r3.b = 2;
        r3.s = r4;
        i.a(r3.a.getMId(), r4);
    }

    public final void a(MusicPanel r11, String r12, String r13) {
        if (r11 != null) goto L4;
        return;
    L4:
        Long r0 = (Long) ((LinkedHashMap) this.a.a).get(String.valueOf(r11.a.getId()));
        long r1 = 0;
        if (r0 == null) goto L7;
        long r3 = r0.longValue();
    L9:
        if (r3 != 0) goto L14;
        ALogger.i("ktv_music_resource_download_opt_tag", "KtvMusicDownloadOptManager ;; repeat main_resource success callback ;; songName == " + r11.a.getMTitle() + ' ');
        if (KtvUtilsKt.m(r11) == false) goto L30;
        r11.b = 1;
        this.a.d.a(r11, r12, r13);
        pd2.d.n.getClass();
        pd2.d.B("choose_download_success", r11, null);
        int r14 = mb0.f.a;
        mb0.f.i(r11);
        i.a(r11.a.getMId(), 100);
        return;
    L30:
        return;
    L14:
        r11.b = 1;
        this.a.d.a(r11, r12, r13);
        pd2.d.n.getClass();
        pd2.d.B("choose_download_success", r11, null);
        int r15 = mb0.f.a;
        mb0.f.i(r11);
        i.a(r11.a.getMId(), 100);
        Long r16 = KtvLoggerHelper.a;
        KtvLoggerHelper.O(r11, "1", c.a(this.a, r11));
        StringBuilder r17 = new StringBuilder("main_resource download success duration == ");
        long r4 = System.currentTimeMillis();
        Long r18 = (Long) ((LinkedHashMap) this.a.a).get(String.valueOf(r11.a.getId()));
        if (r18 == null) goto L17;
        long r5 = r18.longValue();
    L18:
        r17.append(r4 - r5);
        r17.append(" ;; songName == ");
        r17.append(r11.a.getMTitle());
        ALogger.i("ktv_music_resource_download_opt_tag", r17.toString());
        this.a.a.remove(String.valueOf(r11.a.getId()));
        this.a.b.put(String.valueOf(r11.a.getId()), Long.valueOf(System.currentTimeMillis()));
        if (KtvUtilsKt.E(r11) == true) goto L25;
        StringBuilder r19 = new StringBuilder("other_resource not need download duration == ");
        long r6 = System.currentTimeMillis();
        Long r2 = (Long) ((LinkedHashMap) this.a.b).get(String.valueOf(r11.a.getId()));
        if (r2 == null) goto L23;
        r1 = r2.longValue();
    L23:
        r19.append(r6 - r1);
        r19.append(" ;; songName == ");
        r19.append(r11.a.getMTitle());
        ALogger.i("ktv_music_resource_download_opt_tag", r19.toString());
        c r110 = this.a;
        com.bytedance.android.live.ktv.common.model.bean.f r111 = new com.bytedance.android.live.ktv.common.model.bean.f(DownloadResourceType.OTHER_RESOURCE, false);
        r110.getClass();
        c.b(r11, r111);
        this.a.b.remove(String.valueOf(r11.a.getId()));
        return;
    L25:
        c r112 = this.a;
        com.bytedance.android.live.ktv.common.model.bean.f r113 = new com.bytedance.android.live.ktv.common.model.bean.f(DownloadResourceType.OTHER_RESOURCE, true);
        r112.getClass();
        c.b(r11, r113);
        Lazy r114 = KtvSettingHelper.W0;
        if (((b9) r114.getValue()).b() == false) goto L28;
        Observable.just(new Object()).delay(((b9) r114.getValue()).a(), TimeUnit.MILLISECONDS).subscribeOn(Schedulers.io()).subscribe(new a(this, r11));
        return;
    L28:
        c r115 = this.a;
        r115.getClass();
        KtvMusicManager.e(KtvMusicManager.m, r11, new nd2.a(r115), false, null, r115.e, 12);
        return;
    L17:
        r5 = 0;
        goto L18
    L7:
        r3 = 0;
        goto L9
    }

    public final void b(MusicPanel r6, int r7, String r8) {
        Intrinsics.checkNotNullParameter(r8, "errorMsg");
        if (r6 != null) goto L5;
        return;
    L5:
        r6.s = 0;
        r6.b = 1;
        pd2.d r2 = pd2.d.n;
        HashMap r1 = MapsKt.hashMapOf(new Pair[]{TuplesKt.to(LocationMonitorConst.ERR_CODE, String.valueOf(r7))});
        r2.getClass();
        pd2.d.B("choose_download_fail", r6, r1);
        int r3 = mb0.f.a;
        mb0.f.h(r6, r7, r8);
        if (((Boolean) KtvMusicManager.j.invoke(r8)).booleanValue() == false) goto L8;
        f2.b(2131918481, 0);
    L9:
        this.a.d.b(r6, r7, r8);
        i.a(r6.a.getMId(), -1);
        Long r9 = KtvLoggerHelper.a;
        KtvLoggerHelper.O(r6, BDLocationException.ERROR_TIMEOUT, c.a(this.a, r6));
        StringBuilder r10 = new StringBuilder("main_resource download fail duration == ");
        long r4 = System.currentTimeMillis();
        Long r11 = (Long) ((LinkedHashMap) this.a.a).get(String.valueOf(r6.a.getId()));
        if (r11 == null) goto L12;
        long r5 = r11.longValue();
    L13:
        r10.append(r4 - r5);
        r10.append(" ;; songName == ");
        r10.append(r6.a.getMTitle());
        ALogger.i("ktv_music_resource_download_opt_tag", r10.toString());
        c r12 = this.a;
        com.bytedance.android.live.ktv.common.model.bean.f r13 = new com.bytedance.android.live.ktv.common.model.bean.f(DownloadResourceType.OTHER_RESOURCE, false);
        r12.getClass();
        c.b(r6, r13);
        this.a.a.remove(String.valueOf(r6.a.getId()));
        this.a.b.remove(String.valueOf(r6.a.getId()));
        return;
    L12:
        r5 = 0;
        goto L13
    L8:
        f2.b(2131918370, 0);
        goto L9
    }
}
