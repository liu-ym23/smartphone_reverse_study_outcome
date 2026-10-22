package n35;

import com.bytedance.ee.bear.document.offline.base.OfflineTransferModel;
import com.bytedance.ee.bear.document.render.core.offline.CollectResultModel;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerRunOnNotUIThread$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.ss.android.lark.vfs.VFSFile;
import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import k25.e0;
import k25.e1;
import k25.m0;

/* JADX INFO: loaded from: classes16.dex */
public final class e implements tb5.h<OfflineTransferModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f516934a;

    public static final class a {
    }

    static {
    }

    @Override // tb5.h, tb5.i, tb5.o
    public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return BridgeHandlerRunOnNotUIThread$CC.$default$authType(this);
    }

    public e() {
        this.f516934a = e0.r();
    }

    @Override // tb5.h, tb5.i, tb5.o
    public final void handle(Object r100, tb5.m r101) {
        OfflineTransferModel r102 = (OfflineTransferModel) r100;
        StringBuilder r103 = new StringBuilder("CollectDataHandlerV2 objToken: ");
        String r104 = null;
        if (r102 == null) goto L5;
        String r105 = r102.getObjToken();
    L6:
        r103.append(du5.b.g(r105));
        r103.append(" , category : ");
        if (r102 == null) goto L9;
        r104 = r102.getCategory();
    L9:
        r103.append(r104);
        tt5.a.d("CollectDataHandlerV2", r103.toString());
        ArrayList r106 = new ArrayList();
        if (r102 == null) goto L28;
        String r107 = r102.getCategory();
        boolean r108 = true;
        if (r107 != null) goto L14;
    L17:
        boolean r109 = true;
    L18:
        if (r109 == true) goto L29;
        String r110 = r102.getObjToken();
        if (r110 != null) goto L22;
    L25:
        if (r108 == true) goto L30;
        Flowable.just("").observeOn(Schedulers.from(this.f516934a)).subscribe(new f(this, r102, r106, r101), new g(this, r102, r106, r101));
        return;
    L30:
        return;
    L22:
        if (r110.length() == 0) goto L25;
        r108 = false;
        goto L25
    L29:
        return;
    L14:
        if (r107.length() == 0) goto L17;
        r109 = false;
        goto L18
    L28:
        return;
    L5:
        r105 = null;
        goto L6
    }

    public static final void a(e r100, OfflineTransferModel r101, ArrayList r102, tb5.m r103) {
        r100.getClass();
        StringBuilder r104 = new StringBuilder("onResult ");
        String r105 = null;
        if (r101 == null) goto L5;
        String r106 = r101.getCategory();
    L6:
        r104.append(du5.b.g(r106));
        r104.append(tb2.c.DEFAULT_TEXT);
        if (r101 == null) goto L9;
        r105 = r101.getObjToken();
    L9:
        r104.append(du5.b.g(r105));
        r104.append(' ');
        r104.append(r102.size());
        tt5.a.d("CollectDataHandlerV2", r104.toString());
        CollectResultModel r107 = new CollectResultModel(0, "success", r102);
        if (r103 == null) goto L13;
        r103.onCallBack(r107.toString());
        return;
    L13:
        return;
    L5:
        r106 = null;
        goto L6
    }

    public static final void c(e r100, String r101, String r102, ArrayList r103) {
        r100.getClass();
        e0 r104 = e0.m();
        r104.getClass();
        m0 r105 = r104.q().e().j(r102, r101);     // Catch: Exception -> L5
    L8:
        if (r105 == null) goto L16;
        StringBuilder r106 = new StringBuilder("selectDbAndFile it.resvalue1: ");
        String r107 = r105.f501542c;
        if (r107 == null) goto L12;
        Integer r108 = Integer.valueOf(r107.length());
    L13:
        r106.append(r108);
        tt5.a.d("CollectDataHandlerV2", r106.toString());
        String r109 = r105.f501542c;
        if (r109 == null) goto L16;
        r103.add(r109);
        goto L16
    L12:
        r108 = null;
    L16:
        e1 r110 = e0.m().f501512b;
        r110.getClass();
        ArrayList r111 = new ArrayList();
        VFSFile r112 = ay4.d.a().i(r110.f501519b);
        if (r112.isDirectory() == false) goto L28;
        VFSFile[] r113 = r112.listFiles();
        if (r113 == null) goto L28;
        StringBuilder r114 = new StringBuilder();
        StringBuilder r115 = new StringBuilder();
        r115.append(r102);
        r115.append(r101);
        int r116 = 0;
        r115.append(0);
        r114.append(du5.d.a(r115.toString()));
        r114.append("_");
        String r117 = r114.toString();
        int r118 = r113.length;
    L23:
        if (r116 >= r118) goto L28;
        VFSFile r119 = r113[r116];
        if (r119.getName().startsWith(r117) == false) goto L27;
        r111.add(r110.e(r119.getVfsPath().getRealPath()));
    L27:
        r116 = r116 + 1;
    L28:
        tt5.a.d("CollectDataHandlerV2", "selectDbAndFile it.resvalue2: " + r111.size());
        if (r111.size() <= 0) goto L37;
        r103.addAll(r111);
        return;
    L37:
        return;
    L5:
        e = move-exception;
        iu5.d.c(e);
        r105 = new m0();
        goto L8
    }
}
