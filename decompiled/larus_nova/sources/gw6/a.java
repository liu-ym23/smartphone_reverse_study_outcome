package gw6;

import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import com.bytedance.locallife.common.utils.d;
import com.bytedance.locallife.dito.data.m;
import com.bytedance.locallife.dito.model.BaseDitoModel;
import com.bytedance.locallife.pdp.biz.common.frame.FrameData;
import com.bytedance.locallife.pdp.biz.common.frame.FrameInfo;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.reflect.TypeToken;
import com.ss.android.lark.passport.signinsdk_api.base.log.UniContext;
import com.ss.android.ugc.aweme.poi.bean.PoiBizCode;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import ww6.k;
import ww6.n;

/* JADX INFO: loaded from: classes21.dex */
public class a implements k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, FrameInfo> f483069b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f483070a;

    /* JADX INFO: renamed from: gw6.a$a, reason: collision with other inner class name */
    public static final class C6076a {
    }

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"gw6/a$b", "Lcom/google/gson/reflect/TypeToken;", "Lcom/bytedance/locallife/pdp/biz/common/frame/FrameData;", "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
    public static final class b extends TypeToken<FrameData> {
        public b() {
        }
    }

    public boolean d(String r100) {
        throw null;
    }

    static {
        f483069b = new ConcurrentHashMap();
    }

    @Override // ww6.k
    public final void init() {
        ConcurrentHashMap<String, FrameInfo> r100 = f483069b;
        boolean r101 = true;
        if ((!r100.isEmpty()) == false) goto L5;
        return;
    L5:
        String r102 = HostServiceUtilsKt.i0().a(this.f483070a, "DefaultFrameInfoProvider", "");
        if (r102 == null) goto L43;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L37
        if (r102.length() != 0) goto L10;
        boolean r104 = true;
    L11:
        if (r104 == false) goto L13;
        return;
    L13:
        qs6.b r105 = HostServiceUtilsKt.k();     // Catch: Throwable -> L37
        if (r105 == null) goto L16;
        r105.d("DefaultFrameInfoProvider", r102);     // Catch: Throwable -> L37
    L16:
        FrameData r106 = (FrameData) GsonProtectorUtils.fromJson(d.b(), r102, new b().getType());     // Catch: Throwable -> L37
        if (r106 == null) goto L34;
        Long r107 = r106.b();     // Catch: Throwable -> L37
        if (r107 == null) goto L34;
        if ((System.currentTimeMillis() - r107.longValue()) < 604800000) goto L23;
        boolean r108 = true;
    L24:
        if (r108 == true) goto L33;
        ConcurrentHashMap<String, FrameInfo> r109 = r106.a();     // Catch: Throwable -> L37
        if (r109 != null) goto L28;
    L30:
        r101 = false;
    L31:
        if (r101 == false) goto L33;
        r100.putAll(r106.a());     // Catch: Throwable -> L37
        goto L33
    L28:
        if ((!r109.isEmpty()) != true) goto L30;
    L33:
        Unit r110 = Unit.INSTANCE;     // Catch: Throwable -> L37
    L35:
        Object r111 = Result.m9449constructorimpl(r110);     // Catch: Throwable -> L37
    L39:
        Result.m9448boximpl(r111);
        return;
    L23:
        r108 = false;
    L34:
        r110 = null;
        goto L35
    L10:
        r104 = false;
    L37:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L39
    }

    @Override // ww6.k
    public final void c() {
        HostServiceUtilsKt.i0().e(this.f483070a, "DefaultFrameInfoProvider", d.c(new FrameData(f483069b, Long.valueOf(System.currentTimeMillis()))));
    }

    public a(PoiBizCode r100) {
        Intrinsics.checkNotNullParameter(r100, "bizCode");
        this.f483070a = "DefaultFrameInfoProvider_" + r100.bizCode + "_REPO";
    }

    public static String e(String r110, HashMap r111) {
        Intrinsics.checkNotNullParameter(r110, "nodeTag");
        Intrinsics.checkNotNullParameter(r111, "params");
        ArrayList r100 = new ArrayList();
        r100.add(r110);
        String r112 = (String) r111.get(UniContext.KEY_OF_BIZ_CODE);
        if (r112 == null) goto L11;
        if (r112.length() != 0) goto L7;
        boolean r113 = true;
    L8:
        if (r113 == true) goto L11;
        r100.add(r112);
        goto L11
    L7:
        r113 = false;
    L11:
        return CollectionsKt.joinToString$default(r100, "_", null, null, 0, null, null, 62, null);
    }

    @Override // ww6.k
    public final FrameInfo a(BaseDitoModel<?> r100, n r101) {
        Intrinsics.checkNotNullParameter(r101, ShortVideoSegments.KEY_PROP_PROVIDER);
        if (r100 == null) goto L7;
        m r102 = r100.f258493b;
        if (r102 == null) goto L7;
        String r103 = m.i(r102);
    L9:
        if (Intrinsics.areEqual(r103, ContainerPosition.BODY) == true) goto L11;
        return null;
    L11:
        String r104 = r100.f258493b.f258222b;
        if (d(r104) == true) goto L15;
        return null;
    L15:
        return f483069b.get(e(r104, r101.b()));
    L7:
        r103 = null;
        goto L9
    }

    @Override // ww6.k
    public final void b(BaseDitoModel<?> r100, n r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r101, ShortVideoSegments.KEY_PROP_PROVIDER);
        if (r100 == null) goto L7;
        m r104 = r100.f258493b;
        if (r104 == null) goto L7;
        String r105 = m.i(r104);
    L9:
        if (Intrinsics.areEqual(r105, ContainerPosition.BODY) == true) goto L11;
        return;
    L11:
        String r106 = r100.f258493b.f258222b;
        if (d(r106) == true) goto L14;
        return;
    L14:
        HashMap<String, String> r107 = r101.b();
        ConcurrentHashMap<String, FrameInfo> r108 = f483069b;
        monitor-enter(r108);
        r108.put(e(r106, r107), new FrameInfo(Integer.valueOf(r102), Integer.valueOf(r103)));     // Catch: Throwable -> L19
        Unit r109 = Unit.INSTANCE;     // Catch: Throwable -> L19
        monitor-exit(r108);
        return;
    L19:
        th = move-exception;
        throw th;
    L7:
        r105 = null;
        goto L9
    }
}
