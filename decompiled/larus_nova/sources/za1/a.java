package za1;

import com.bytedance.android.live.browser.jsbridge.base.LynxReportResponseResultModel;
import com.bytedance.android.live.soloktv.SoloKtvContext;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.live.datacontext.m;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import w20.rb;
import w20.x3;

/* JADX INFO: loaded from: classes7.dex */
public final class a extends x3<rb, LynxReportResponseResultModel> {

    /* JADX INFO: renamed from: za1.a$a, reason: collision with other inner class name */
    public static final class C8435a {
    }

    static {
    }

    public a() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        rb r102 = (rb) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (Intrinsics.areEqual(r102.a(), "personal_karaoke_banner_list") == false) goto L14;
        Integer r103 = r102.b();
        boolean r104 = true;
        if (r103 != null) goto L8;
    L11:
        SoloKtvContext.Companion.getClass();
        m<Boolean> r105 = SoloKtvContext.a.a().getHideBannerIfNeed();
        if (r105 == null) goto L14;
        r105.setValue(Boolean.valueOf(r104));
        goto L14
    L8:
        if (r103.intValue() != 1) goto L11;
        r104 = false;
    L14:
        LynxReportResponseResultModel r106 = new LynxReportResponseResultModel();
        r106.a(LynxReportResponseResultModel.Code.Success);
        r106.b("请求成功");
        Unit r107 = Unit.INSTANCE;
        finishWithResult(r106);
    }
}
