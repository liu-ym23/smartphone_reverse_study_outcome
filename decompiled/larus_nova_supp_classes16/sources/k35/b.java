package k35;

import android.text.TextUtils;
import android.util.ArrayMap;
import com.bytedance.ee.bear.document.record.RecordModel;
import com.bytedance.ee.bear.document.record.RecordResultModel;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import tb5.i;
import tb5.m;
import vv4.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b extends vv4.a {

    public class a implements i<RecordModel> {
        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public a() {
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r5, m r6) {
            RecordModel r7 = (RecordModel) r5;
            StringBuilder r0 = new StringBuilder("data is null? = ");
            if (r7 != null) goto L5;
            boolean r3 = true;
        L6:
            r0.append(r3);
            tt5.a.b("RecordWebService", r0.toString());
            if (r7 != null) goto L9;
        L14:
            r6.a(new RecordResultModel(false, new RecordModel()));
            return;
        L9:
            if (TextUtils.isEmpty(r7.getToken()) == true) goto L14;
            k35.a r1 = k35.a.C0243a.a;
            String r8 = r7.getToken();
            RecordModel r9 = (RecordModel) ((ArrayMap) r1.a).get(r8);
            if (r9 != null) goto L13;
            r6.a(new RecordResultModel(false, new RecordModel()));
            return;
        L13:
            r6.a(new RecordResultModel(true, r9));
            return;
        L5:
            r3 = false;
            goto L6
        }
    }

    /* JADX INFO: renamed from: k35.b$b, reason: collision with other inner class name */
    public class C0244b implements i<RecordModel> {
        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public C0244b() {
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r2, m r3) {
            RecordModel r4 = (RecordModel) r2;
            if (r4 != null) goto L6;
            tt5.a.b("RecordWebService", "handle()... data is null");
            return;
        L6:
            if (TextUtils.isEmpty(r4.getToken()) == true) goto L10;
            k35.a r5 = k35.a.C0243a.a;
            String r0 = r4.getToken();
            ((ArrayMap) r5.a).put(r0, r4);
            return;
        }
    }

    public b() {
    }

    @Override // vv4.a
    public final void onAttachToWeb(k r2) {
        super.onAttachToWeb(r2);
        bindBridgeHandlerAutoUnbind("biz.record.setRecordData", new C0244b());
        bindBridgeHandlerAutoUnbind("biz.record.getRecordData", new a());
    }
}
