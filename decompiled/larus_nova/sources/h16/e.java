package h16;

import android.net.Uri;
import android.view.View;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.core.kit.bridge.h;
import com.bytedance.ies.bullet.service.base.i0;
import com.bytedance.ies.bullet.service.base.o;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import t36.j;

/* JADX INFO: loaded from: classes19.dex */
public interface e extends i0 {

    public static class a implements e {
        public a() {
        }

        @Override // h16.e
        public final void Wn(View r100, int r101, int r102, int r103, int r104, int r105) {
            Intrinsics.checkNotNullParameter(r100, "loadingView");
        }

        @Override // h16.e
        public d getActivityWrapper() {
            return null;
        }

        @Override // h16.e
        public BulletContext getBulletContext() {
            return null;
        }

        @Override // h16.e
        public Uri getCurrentUri() {
            return null;
        }

        @Override // h16.e
        public o getKitView() {
            return null;
        }

        @Override // h16.e
        public Uri getProcessingUri() {
            return null;
        }

        @Override // h16.e
        public final j getSchemaModelUnion() {
            return null;
        }

        @Override // h16.e
        public String getSessionId() {
            return "";
        }

        @Override // h16.e
        public void onEvent(h r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
        }

        @Override // h16.e
        public final void qq(String r100, List<String> r101, List<? extends JSONObject> r102) {
            Intrinsics.checkNotNullParameter(r100, ReportConstant.COMMON_ACTION_TYPE);
            Intrinsics.checkNotNullParameter(r101, "name");
            Intrinsics.checkNotNullParameter(r102, "params");
        }

        @Override // h16.e
        public final void r0() {
        }

        @Override // com.bytedance.ies.bullet.service.base.i0
        public final void release() {
        }

        @Override // h16.e
        public final void v() {
        }

        @Override // h16.e
        public final void yc() {
        }
    }

    public static final class b {
        public static /* synthetic */ void a(e r100, View r101) {
            r100.Wn(r101, 17, 0, 0, 0, 0);
        }
    }

    void Wn(View r100, int r101, int r102, int r103, int r104, int r105);

    d getActivityWrapper();

    BulletContext getBulletContext();

    Uri getCurrentUri();

    o getKitView();

    Uri getProcessingUri();

    j getSchemaModelUnion();

    String getSessionId();

    void onEvent(h r100);

    void qq(String r100, List<String> r101, List<? extends JSONObject> r102);

    void r0();

    void v();

    void yc();
}
