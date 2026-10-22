package com.ss.android.lark.sticker.core.impl;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.CollectionUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.sticker.core.model.StickerFileInfo;
import com.ss.android.lark.utils.LarkContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes38.dex */
public final class g {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f440820d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<b> f440821a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f440822b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ExecutorService f440823c;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List<String> f440824a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f440825b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final a6c.a f440826c;

        public a(a6c.a r100) {
            this.f440824a = new ArrayList();
            this.f440825b = false;
            this.f440826c = r100;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<String> f440827a;

        public b() {
            this.f440827a = new ArrayList();
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b f440828a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final f f440829b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ g f440830c;

        public final void a() {
            int r100 = 0;
            if (this.f440830c.f440822b == true) goto L15;
            List<String> r101 = this.f440828a.f440827a;
            f r102 = this.f440829b;
            r102.getClass();
            List<String>[] r103 = CollectionUtils.split(r101, 8);
            int r104 = r103.length;
        L5:
            if (r100 >= r104) goto L29;
            List<String> r105 = r103[r100];
            LarkContext.getApplication();
            String r106 = com.ss.android.lark.sticker.core.utils.c.a();
            if (TextUtils.isEmpty(r102.f440818a) == true) goto L9;
            LarkContext.getApplication();
            r106 = com.ss.android.lark.sticker.core.utils.c.b(r102.f440818a);
        L9:
            r102.f440819b.getResources(r106, r105, null);
            Thread.sleep(500);     // Catch: Exception -> L12
        L14:
            r100 = r100 + 1;
        L12:
            e = move-exception;
            Log.e(e.getMessage());
            goto L14
        L29:
            return;
        L15:
            String r107 = (String) ListProtector.get(this.f440828a.f440827a, 0);
            f r108 = this.f440829b;
            this.f440830c.getClass();
            r108.getClass();
            ArrayList r109 = new ArrayList();
            Log.d("StickerDownloader", "start download sticker " + r107);
            r109.add(r107);
            LarkContext.getApplication();
            String r110 = com.ss.android.lark.sticker.core.utils.c.a();
            if (TextUtils.isEmpty(r108.f440818a) == true) goto L18;
            LarkContext.getApplication();
            r110 = com.ss.android.lark.sticker.core.utils.c.b(r108.f440818a);
        L18:
            c6c.a r111 = r108.f440819b.a(r110, r109).get(r107);
            if (r111 == null) goto L21;
            StickerFileInfo r112 = new StickerFileInfo();
            String r113 = r111.f22630a;
            r112.setKey(r113);
            r112.setFilePath(r111.f22631b);
            r112.setUrl(r111.f22631b);
            Log.d("StickerDownloader", "download sticker complete " + r113);
            return;
        L21:
            Log.d("StickerDownloader", "download sticker fail " + r107);
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

        public c(g r100, b r101) {
            this.f440830c = r100;
            this.f440828a = r101;
            this.f440829b = new f();
        }
    }

    static {
        LarkContext.getApplication();
        f440820d = com.ss.android.lark.sticker.core.utils.c.a();
    }

    public g(a r100) {
        this.f440823c = CoreThreadPool.getDefault().getFixedThreadPool();
        boolean r101 = true;
        int r102 = 0;
        if (((ArrayList) r100.f440824a).size() == 1) goto L6;
        r101 = false;
    L6:
        this.f440822b = r101;
        List<String> r103 = r100.f440824a;
        ArrayList r104 = new ArrayList();
        ArrayList r105 = (ArrayList) r103;
        if (r105.size() > 8) goto L13;
        Iterator r106 = r105.iterator();
    L10:
        if (r106.hasNext() == false) goto L19;
        String r107 = (String) r106.next();
        b r108 = new b();
        List<String> r109 = r108.f440827a;
        ArrayList r110 = (ArrayList) r109;
        r110.addAll(Collections.singletonList(r107));
        r104.add(r108);
    L19:
        this.f440821a = r104;
        boolean r111 = r100.f440825b;
        return;
    L13:
        if (r102 >= r105.size()) goto L19;
        String r112 = (String) ListProtector.get(r105, r102);
        int r113 = r102 % 8;
        if (r104.size() > r113) goto L17;
        b r114 = new b();
        ((ArrayList) r114.f440827a).add(r112);
        r104.add(r114);
    L18:
        r102 = r102 + 1;
        goto L13
    L17:
        ((ArrayList) ((b) ListProtector.get(r104, r113)).f440827a).add(r112);
        goto L18
    }
}
