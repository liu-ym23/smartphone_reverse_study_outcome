package w25;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.n;
import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import com.bytedance.ee.bear.contract.setting.PreloadStrategy;
import com.bytedance.ee.bear.contract.setting.WikiPreloadConfig;
import com.bytedance.ee.bear.document.offline.sync.preloadexecutor.nextpage.BlockData;
import com.bytedance.ee.bear.document.offline.sync.preloadexecutor.nextpage.BlockDataList;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.Gson;
import com.ss.android.lark.monitor.callback.DevicePerfManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import s45.p;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c {
    public static Boolean a;
    public static final WikiPreloadConfig b = null;
    public static final List<String> c = null;
    public static final Gson d = null;
    public static BearUrl e;
    public static String f;

    static {
        b = (WikiPreloadConfig) com.bytedance.ee.bear.appsetting.c.a.a.c(WikiPreloadConfig.WIKI_PRELOAD_CONFIG, WikiPreloadConfig.class, new WikiPreloadConfig());
        c = CollectionsKt.listOf(new String[]{"unkonw", "page", "table", "callout", "grid", "okr", "code", "todo", "task", "bookmark", "ordered", "bullet", "quote_container", "heading"});
        d = new Gson();
    }

    public static boolean c() {
        if (a != null) goto L16;
        Boolean r0 = ((xm4.a.a) org.koin.java.a.c(xm4.a.a.class, null, null, 6)).a(t25.a.class.getName());
        if (r0 == null) goto L7;
        boolean r1 = r0.booleanValue();
    L9:
        if (com.bytedance.ee.bear.appsetting.c.a.a.h("ccm.mobile.wiki_docx_content_preload_dev") == false) goto L14;
        if (r1 == false) goto L14;
        boolean r2 = true;
        if ((!DevicePerfManager.b.a.e.h) == false) goto L14;
    L15:
        a = Boolean.valueOf(r2);
    L14:
        r2 = false;
        goto L15
    L7:
        r1 = false;
    L16:
        tt5.a.h("PreloadNextPageExecutor", "PreloadNextPageExecutor isEnable " + a);
        Boolean r3 = a;
        if (r3 != null) goto L19;
        return false;
    L19:
        return r3.booleanValue();
    }

    public static void d(List r7, String r8) {
        if ((!r7.isEmpty()) == false) goto L33;
        List r9 = r7;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
        Iterator r10 = r9.iterator();
    L6:
        if (r10.hasNext() == false) goto L8;
        String r2 = p.a().v8((String) r10.next());
        BearUrl r3 = p.a().Z(r2);
        OfflineDoc r4 = new OfflineDoc(r3.b, r2, e.g(r3.a), r3.h);
        r4.setSubFrom(r8);
        r4.setCanPreloadIfFileOpen(true);
        r0.add(r4);
        goto L6
    L8:
        ArrayList r11 = new ArrayList();
        Iterator r1 = r0.iterator();
    L10:
        if (r1.hasNext() == false) goto L18;
        Object r5 = r1.next();
        if (((OfflineDoc) r5).getType() != 16) goto L14;
        boolean r6 = true;
    L15:
        if (r6 == false) goto L10;
        r11.add(r5);
        goto L10
    L14:
        r6 = false;
        goto L15
    L18:
        if ((!r11.isEmpty()) == false) goto L34;
        tt5.a.h("PreloadNextPageExecutor", "triggerPreload " + r8 + ' ' + r11.size());
        PreloadStrategy r12 = b.getPreloadContent().get(r8);
        if (r12 == null) goto L35;
        List<OfflineDoc> r13 = r11;
        if (r12.getSort() == 1) goto L25;
        r13 = com.larksuite.framework.utils.p.a(r11);
    L25:
        ((n) org.koin.java.a.c(n.class, null, null, 6)).q(r13, r12.getLimit());
        return;
    L35:
        return;
    L34:
        return;
    }

    public static String a(String r3, HashMap r4, String r5) {
        if (r3 != null) goto L4;
    L6:
        BlockDataList r0 = (BlockDataList) r4.get(r5);
        String r1 = null;
        if (r0 == null) goto L11;
        BlockData r2 = r0.getData();
        if (r2 == null) goto L11;
        String r6 = r2.getType();
    L12:
        if (r6 != null) goto L14;
    L18:
        BlockDataList r7 = (BlockDataList) r4.get(r5);
        if (r7 == null) goto L23;
        BlockData r8 = r7.getData();
        if (r8 == null) goto L23;
        r1 = r8.getParentId();
    L23:
        if (r1 == null) goto L29;
        if (TextUtils.isEmpty(r1) == true) goto L29;
        return a(r3, r4, r1);
    L29:
        return (String) ListProtector.get(c, 0);
    L14:
        if (TextUtils.isEmpty(r6) == true) goto L18;
        if (c.contains(r6) == false) goto L18;
        return r6;
    L11:
        r6 = null;
        goto L12
    L4:
        if (TextUtils.isEmpty(r3) == true) goto L6;
        return r3;
    }

    public static void b(String r1, String r2, HashMap r3) {
        if (r1 != null) goto L5;
        return;
    L5:
        if (r3.get(r1) != null) goto L7;
        r3.put(r1, new ArrayList());
    L7:
        ArrayList r4 = (ArrayList) r3.get(r1);
        if (r4 != null) goto L10;
        return;
    L10:
        if (r4.contains(r2) == true) goto L14;
        r4.add(r2);
        return;
    }
}
