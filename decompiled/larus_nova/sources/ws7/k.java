package ws7;

import android.content.Context;
import com.dtf.face.log.RecordService;
import com.dtf.face.network.APICallback;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes22.dex */
public final class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f561076a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f561077b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f561078c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Map f561079d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ APICallback f561080e;

    public final void a() {
        Context r100 = this.f561076a;
        String r101 = this.f561077b;
        boolean r102 = this.f561078c;
        Map r103 = this.f561079d;
        APICallback r104 = this.f561080e;
        monitor-enter(o.class);
        byte r105 = 0;
        if (r101 != null) goto L85;
    L76:
        RecordService r106 = RecordService.getInstance();     // Catch: Throwable -> L82
        String[] r107 = new String[2];     // Catch: Throwable -> L82
        r107[0] = "type";     // Catch: Throwable -> L82
        if (r101 != null) goto L79;
        r101 = "NULL";
    L79:
        r107[1] = r101;     // Catch: Throwable -> L82
        r106.recordEvent(2, "modelDownload", r107);     // Catch: Throwable -> L82
        monitor-exit(o.class);
        return;
    L85:
    L82:
        th = move-exception;
        throw th;
    L7:
        if ("FACE".equals(r101) == false) goto L9;
    L13:
        Map<String, CopyOnWriteArrayList<APICallback<String>>> r108 = o.f561081a;     // Catch: Throwable -> L82
        if (((ConcurrentHashMap) r108).get(r101) == null) goto L19;
        if (r104 == null) goto L17;
        ((CopyOnWriteArrayList) ((ConcurrentHashMap) r108).get(r101)).add(r104);     // Catch: Throwable -> L82
    L17:
        monitor-exit(o.class);
        return;
    L19:
        CopyOnWriteArrayList r110 = new CopyOnWriteArrayList();     // Catch: Throwable -> L82
        if (r104 == null) goto L22;
        r110.add(r104);     // Catch: Throwable -> L82
    L22:
        ((ConcurrentHashMap) r108).put(r101, r110);     // Catch: Throwable -> L82
        int r109 = r101.hashCode();     // Catch: Throwable -> L82
        if (r109 == 80904) goto L38;
        if (r109 == 2149981) goto L34;
        if (r109 == 1369197791) goto L30;
    L39:
        r105 = -1;
    L41:
        if (r105 == 0) goto L54;
        if (r105 == 1) goto L45;
        if (r105 != 2) goto L74;
    L64:
        ArrayList r111 = new ArrayList();     // Catch: Throwable -> L82
        if (r103 == null) goto L67;
        List r112 = (List) r103.get("e047462a83518c799c4082850d19c250");     // Catch: Throwable -> L82
    L69:
        if ("QUALITY".equals(r101) == false) goto L73;
        if (r112 == null) goto L72;
        r111.addAll(r112);     // Catch: Throwable -> L82
    L72:
        r111.add("https://gw.alipayobjects.com/render/p/yuyan_npm/@alipay_dtfconfig/1.0.2/lib/toyger.quality.android.wasm");     // Catch: Throwable -> L82
        r111.add("https://tianshu.alicdn.com/64ce83c2-97db-4024-9af3-ef6ffee08f52.png");     // Catch: Throwable -> L82
        r111.add("https://cn-shanghai-aliyun-cloudauth.oss-cn-shanghai.aliyuncs.com/model/toyger.quality.2.2.7.android.dat");     // Catch: Throwable -> L82
    L73:
        new baseverify.e("e047462a83518c799c4082850d19c250", null).a(r100, r111, r102, new n());     // Catch: Throwable -> L82
        goto L74
    L67:
        r112 = null;
    L74:
        monitor-exit(o.class);
        return;
    L45:
        if (r103 == null) goto L47;
        List r113 = (List) r103.get("fd4ddd72c85fd5fe2913be520df32ed0");     // Catch: Throwable -> L82
    L48:
        ArrayList r114 = new ArrayList();     // Catch: Throwable -> L82
        if ("FACE".equals(r101) == false) goto L53;
        if (r113 == null) goto L52;
        r114.addAll(r113);     // Catch: Throwable -> L82
    L52:
        r114.add("https://gw.alipayobjects.com/render/p/yuyan_npm/@alipay_dtfconfig/1.0.1/lib/toyger.face.android.wasm");     // Catch: Throwable -> L82
        r114.add("https://tianshu.alicdn.com/7504f3f0-aca8-4636-b486-e396559d3efb.png");     // Catch: Throwable -> L82
        r114.add("https://cn-shanghai-aliyun-cloudauth.oss-cn-shanghai.aliyuncs.com/model/toyger.face.dat");     // Catch: Throwable -> L82
    L53:
        new baseverify.e("fd4ddd72c85fd5fe2913be520df32ed0", null).a(r100, r114, r102, new l());     // Catch: Throwable -> L82
        goto L74
    L47:
        r113 = null;
        goto L48
    L54:
        if (r103 == null) goto L56;
        List<String> r115 = (List) r103.get("urls");     // Catch: Throwable -> L82
    L57:
        if (r103 == null) goto L59;
        String r116 = (String) r103.get("md5");     // Catch: Throwable -> L82
    L60:
        if (r103 == null) goto L62;
        String r117 = (String) r103.get("fileName");     // Catch: Throwable -> L82
    L63:
        new baseverify.e(r116, r117).a(r100, r115, r102, new m());     // Catch: Throwable -> L82
        goto L64
    L62:
        r117 = null;
        goto L63
    L59:
        r116 = null;
        goto L60
    L56:
        r115 = null;
        goto L57
    L30:
        if (r101.equals("QUALITY") == false) goto L39;
        r105 = 2;
        goto L41
    L34:
        if (r101.equals("FACE") == false) goto L39;
        r105 = 1;
        goto L41
    L38:
        if (r101.equals("RAW") == true) goto L41;
    L9:
        if ("RAW".equals(r101) == true) goto L13;
        if ("QUALITY".equals(r101) == true) goto L13;
        goto L13
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public k(Context r100, String r101, boolean r102, Map r103, o.a r104) {
        this.f561076a = r100;
        this.f561077b = r101;
        this.f561078c = r102;
        this.f561079d = r103;
        this.f561080e = r104;
    }
}
