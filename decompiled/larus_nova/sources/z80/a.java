package z80;

import com.bytedance.android.live.core.verify.monitor.RealNameFullMonitor;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.business.IHostOCRApiProxy;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.ee.bear.unbundle.BenefitStore;
import com.ss.android.lark.videosend.tools.VideoTools;
import java.util.HashMap;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import v80.h;

/* JADX INFO: loaded from: classes45.dex */
public final class a implements x80.a {

    /* JADX INFO: renamed from: z80.a$a, reason: collision with other inner class name */
    public static final class C8427a implements IHostOCRApiProxy.OCRProxyCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f570884a;

        public C8427a(h r100) {
            this.f570884a = r100;
        }

        @Override // com.bytedance.android.livehostapi.business.IHostOCRApiProxy.OCRProxyCallback
        public final void onDetectOCRFinish(int r100, int r101, String r102, JSONObject r110) {
            v80.e r103 = (v80.e) this.f570884a;
            String r104 = r103.f553593b;
            JSONObject r105 = new JSONObject();
            r105.put("errCode", r100);
            r105.put(BenefitStore.FROM_SERVER, r101);
            r105.put(BenefitStore.FROM_SERVER, r101);
            int r106 = RealNameFullMonitor.f66487a;
            JSONObject r107 = new JSONObject();
            if (r103 == null) goto L5;
            r107.put("imageType", r103.f553634g);
            r107.put(VideoTools.ERROR_TYPE_COMPRESS, r103.f553635h);
            r107.put("scene", r103.f553593b);
            r107.put("mode", r103.f553595d);
        L5:
            RealNameFullMonitor.e("ttlive_cert_ziyan_ocr", r100, r104, RealNameFullMonitor.a(r107, r105));
            ((v80.e) this.f570884a).f553636i.onDetectOCRFinish(r100, r101, r102, r110);
        }
    }

    public a() {
    }

    @Override // x80.a
    public final void a(h r110) {
        if ((r110 instanceof v80.e) == true) goto L5;
        return;
    L5:
        v80.e r100 = (v80.e) r110;
        IHostOCRApiProxy.OCRProxyCallback r101 = r100.f553636i;
        if (r101 != null) goto L8;
        return;
    L8:
        IHostOCRApiProxy r102 = (IHostOCRApiProxy) k.f(IHostOCRApiProxy.class);
        IUserService r103 = (IUserService) k.f(IUserService.class);
        IHostContext r104 = (IHostContext) k.f(IHostContext.class);
        if (r102 == null) goto L15;
        if (r103 == null) goto L15;
        if (r104 == null) goto L15;
        HashMap<String, String> r105 = new HashMap();
        r105.put("scene", r100.f553593b);
        r105.put("mode", r100.f553595d);
        r105.put("ticket", r100.f553594c);
        r102.doOCRDetect(r100.getContext(), r100.f553634g, r100.f553635h, r105, new C8427a(r110));
        return;
    L15:
        Intrinsics.checkNotNull(r101);
        r101.onDetectOCRFinish(-10000, -10000, "error_ocr_system", null);
    }
}
