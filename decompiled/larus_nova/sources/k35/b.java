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

/* JADX INFO: loaded from: classes16.dex */
public final class b extends vv4.a {

    public class a implements i<RecordModel> {
        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public a() {
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r100, m r101) {
            RecordModel r102 = (RecordModel) r100;
            StringBuilder r103 = new StringBuilder("data is null? = ");
            if (r102 != null) goto L5;
            boolean r104 = true;
        L6:
            r103.append(r104);
            tt5.a.b("RecordWebService", r103.toString());
            if (r102 != null) goto L9;
        L14:
            r101.a(new RecordResultModel(false, new RecordModel()));
            return;
        L9:
            if (TextUtils.isEmpty(r102.getToken()) == true) goto L14;
            k35.a r105 = k35.a.C6505a.f501719a;
            String r106 = r102.getToken();
            RecordModel r107 = (RecordModel) ((ArrayMap) r105.f501718a).get(r106);
            if (r107 != null) goto L13;
            r101.a(new RecordResultModel(false, new RecordModel()));
            return;
        L13:
            r101.a(new RecordResultModel(true, r107));
            return;
        L5:
            r104 = false;
            goto L6
        }
    }

    /* JADX INFO: renamed from: k35.b$b, reason: collision with other inner class name */
    public class C6506b implements i<RecordModel> {
        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public C6506b() {
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r100, m r101) {
            RecordModel r102 = (RecordModel) r100;
            if (r102 != null) goto L6;
            tt5.a.b("RecordWebService", "handle()... data is null");
            return;
        L6:
            if (TextUtils.isEmpty(r102.getToken()) == true) goto L10;
            k35.a r103 = k35.a.C6505a.f501719a;
            String r104 = r102.getToken();
            ((ArrayMap) r103.f501718a).put(r104, r102);
            return;
        }
    }

    public b() {
    }

    @Override // vv4.a
    public final void onAttachToWeb(k r100) {
        super.onAttachToWeb(r100);
        bindBridgeHandlerAutoUnbind("biz.record.setRecordData", new C6506b());
        bindBridgeHandlerAutoUnbind("biz.record.getRecordData", new a());
    }
}
