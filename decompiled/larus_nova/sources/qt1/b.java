package qt1;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.live.base.model.commerce.DouPlusEntry;
import com.bytedance.android.livesdk.app.dataholder.Observer;
import com.bytedance.android.livesdkapi.business.ILiveDouPlusService;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f534770a;

    public static final class a<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f534771a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f534772b;

        public a(String r100, Context r101) {
            this.f534771a = r100;
            this.f534772b = r101;
        }

        @Override // com.bytedance.android.livesdk.app.dataholder.Observer
        public final void onChanged(Object r100) {
            DouPlusEntry r101 = (DouPlusEntry) r100;
            if (r101 == null) goto L8;
            HashMap r102 = new HashMap();
            r102.put("is_live", "0");
            r102.put("sec_anchor_id", this.f534771a);
            r102.put("scene", IPerformanceManager.SCENE_CLICK_DOU_PLUS);
            Uri.Builder r103 = UriProtector.parse(r101.douPlusEntry).buildUpon();
            r103.appendQueryParameter("dou_plus_source", "douyin").appendQueryParameter("dou_plus_sub_source", "origin_entrance").appendQueryParameter("dou_plus_medium", "long_press_panel").appendQueryParameter("dou_plus_serving_type", "other_group").appendQueryParameter("dou_plus_entrance_type", "1").appendQueryParameter("dou_plus_entrance_level", "2").appendQueryParameter("dou_plus_referer", "long_press_panel").appendQueryParameter("dou_plus_order_type", "live").appendQueryParameter("target_step", "1");
            ILiveDouPlusService r104 = (ILiveDouPlusService) k.f(ILiveDouPlusService.class);
            if (r104 == null) goto L9;
            r104.showDouPlusDialog(this.f534772b, r102, r103.toString(), null);
            return;
        L9:
            return;
        }
    }

    static {
        f534770a = "6";
    }

    public static void a() {
        ILiveDouPlusService r100 = (ILiveDouPlusService) k.n(ILiveDouPlusService.class);
        HashMap r101 = new HashMap();
        r101.put(ILiveRoomPlayFragmentConstant.MALL_ENTRANCE_TYPE, "long_press_panel");
        r101.put("target_step", "1");
        r101.put("dou_plus_medium", "long_press_panel");
        r101.put("dou_plus_serving_type", "my_group");
        r101.put("dou_plus_entrance_type", "1");
        r101.put("dou_plus_entrance_level", "2");
        r101.put("dou_plus_referer", "long_press_panel");
        r101.put("dou_plus_order_type", "live");
        r101.put("dou_plus_entrance_seq", f534770a);
        r100.logEvent(false, "click_dou_plus", "", r101);
    }

    public static void b(int r100) {
        f534770a = String.valueOf(r100);
        ILiveDouPlusService r101 = (ILiveDouPlusService) k.n(ILiveDouPlusService.class);
        HashMap r102 = new HashMap();
        r102.put(ILiveRoomPlayFragmentConstant.MALL_ENTRANCE_TYPE, "long_press_panel");
        r102.put("target_step", "1");
        r102.put("dou_plus_medium", "long_press_panel");
        r102.put("dou_plus_serving_type", "my_group");
        r102.put("dou_plus_entrance_type", "1");
        r102.put("dou_plus_entrance_level", "2");
        r102.put("dou_plus_referer", "long_press_panel");
        r102.put("dou_plus_order_type", "live");
        r102.put("dou_plus_entrance_seq", String.valueOf(r100));
        r101.logEvent(false, "show_dou_plus", "", r102);
    }

    public static void c(long r100, String r101, Context r110) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r101 != null) goto L5;
        return;
    L5:
        ((ILiveDouPlusService) k.n(ILiveDouPlusService.class)).showDouPlusLiveEntry(r101, r100, "long_press_panel", new a(r101, r110));
    }
}
