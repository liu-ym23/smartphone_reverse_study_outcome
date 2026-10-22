package com.bytedance.ee.bear.drive.test.item;

import android.app.Application;
import android.content.Context;
import android.view.View;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.bytedance.ee.bear.drive.preload.DriveCacheInfo;
import com.bytedance.ee.bear.drive.preload.VideoCacheInfo;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.util.io.FileUtils;
import com.ss.android.lark.vfs.VFSPath;
import com.ss.ttvideoengine.DataLoaderHelper;
import com.ss.ttvideoengine.TTVideoEngine;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements z85.a {

    public static final class a implements View.OnClickListener {
        public static final a a = null;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.test.item.b$a$a, reason: collision with other inner class name */
        public static final class C0171a implements FilenameFilter {
            public static final C0171a a = null;

            static {
                a = new C0171a();
            }

            public C0171a() {
            }

            @Override // java.io.FilenameFilter
            public final boolean accept(File r4, String r5) {
                Intrinsics.checkNotNull(r5);
                return StringsKt.endsWith$default(r5, ".json", false, 2, null);
            }
        }

        static {
            a = new a();
        }

        public a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r11) {
            ArrayList r0 = new ArrayList();
            int r1 = a95.a.d;
            Context r2 = null;
            a95.a r3 = a95.a.b.a(null);
            Application r4 = eu5.b.a;
            com.bytedance.ee.bear.drive.preload.r.b(r3);
            File[] r5 = z75.b.f(com.bytedance.ee.bear.drive.cache.t.g(), a95.a.b.a(null).b).listFiles(C0171a.a);
            if (r5 == null) goto L29;
            int r6 = r5.length;
            int r7 = 0;
        L5:
            if (r7 >= r6) goto L29;
            File r8 = r5[r7];
            if (r8 == null) goto L27;
            VFSPath r9 = ay4.d.a().t(r8);
            if (r9 != null) goto L11;
        L23:
            tt5.a.d("VideoCacheInfoManager", "getVideoCacheInfo PreviewUrlResult is null");
        L24:
            VideoCacheInfo r10 = null;
        L25:
            if (r10 == null) goto L27;
            r0.add(r10);
            goto L27
        L11:
            if (r9.toFile().exists() == false) goto L23;
            byte[] r12 = FileUtils.o(r9);
            if (r12 != null) goto L16;
            tt5.a.d("VideoCacheInfoManager", "getVideoCacheInfo resultBytes is null");
            goto L24
        L16:
            DriveCacheInfo r13 = (DriveCacheInfo) JSON.parseObject(r12, DriveCacheInfo.class, new Feature[0]);
            if (r13 != null) goto L19;
            tt5.a.d("VideoCacheInfoManager", "getVideoCacheInfo parse result is null");
            goto L24
        L19:
            DataLoaderHelper.DataLoaderCacheInfo r14 = TTVideoEngine.getCacheInfo(com.bytedance.ee.bear.drive.preload.n.c(r13.getObjToken(), r13.getDataVersion()));
            if (r14 != null) goto L22;
            tt5.a.b("VideoCacheInfoManager", "getVideoCacheInfo no cacheInfo");
            goto L24
        L22:
            r10 = new VideoCacheInfo(r14, r13);
        L27:
            r7 = r7 + 1;
        L29:
            if (r0.isEmpty() == false) goto L33;
            if (r11 == null) goto L32;
            r2 = r11.getContext();
        L32:
            Toast.showText(r2, "本地无视频缓存", 0);
            return;
        L33:
            ArrayList r16 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
            Iterator r17 = r0.iterator();
        L35:
            if (r17.hasNext() == false) goto L41;
            f85.a.C0229a r18 = (f85.a.C0229a) ((VideoCacheInfo) r17.next()).getFileModel().a;
            if (r18 == null) goto L39;
            String r19 = r18.b;
        L40:
            r16.add(r19);
            goto L35
        L39:
            r19 = null;
            goto L40
        L41:
            List r20 = CollectionsKt.toList(r16);
            if (r11 == null) goto L44;
            r2 = r11.getContext();
        L44:
            com.larksuite.component.ui.dialog.i r21 = new com.larksuite.component.ui.dialog.i(r2);
            String[] r110 = (String[]) r20.toArray(new String[0]);
            r21.n((CharSequence[]) Arrays.copyOf(r110, r110.length));
            r21.i();
        }
    }

    public b() {
    }

    @Override // z85.a
    public final String getButtonName() {
        return "查看预加载视频";
    }

    @Override // z85.a
    public final View.OnClickListener a() {
        return a.a;
    }
}
