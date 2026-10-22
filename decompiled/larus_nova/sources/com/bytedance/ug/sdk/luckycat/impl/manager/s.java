package com.bytedance.ug.sdk.luckycat.impl.manager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes3.dex */
public final class s implements e {

    public class a implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.ug.sdk.luckycat.impl.popup.a f271368a;

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            CopyOnWriteArrayList<String> r100 = v.f271369a;
            com.bytedance.ug.sdk.luckycat.impl.popup.a r101 = this.f271368a;
            com.bytedance.ug.sdk.luckycat.impl.utils.a.c("LuckyForestPreloadManager", "onAppSettingsUpdatePreload, " + com.bytedance.ug.sdk.luckycat.impl.utils.n.a());
            final boolean r102 = com.bytedance.ug.sdk.luckycat.impl.utils.n.a();
            Function1<com.bytedance.ug.sdk.luckycat.impl.popup.f, Boolean> r103 = new LuckyForestPreloadManager$onAppSettingsUpdatePreload$1(r102);
            LuckyForestPreloadManager$onAppSettingsUpdatePreload$2 r104 = LuckyForestPreloadManager$onAppSettingsUpdatePreload$2.INSTANCE;
            if (r101 != null) goto L6;
            com.bytedance.ug.sdk.luckycat.impl.utils.a.c("LuckyForestPreloadManager", "commonPreloadConfig == null");     // Catch: Exception -> L31
        L34:
            return Unit.INSTANCE;
        L6:
            if (r101.c() == true) goto L8;
            com.bytedance.ug.sdk.luckycat.impl.utils.a.c("LuckyForestPreloadManager", "enable_forest_preload_settings_ready is false");     // Catch: Exception -> L31
            goto L34
        L8:
            Integer r105 = null;
            if (m.a.f271349a.f271344l == false) goto L15;
            StringBuilder r106 = new StringBuilder("commonPreloadConfig.luckyPreloadConfigList: ");     // Catch: Exception -> L31
            List<com.bytedance.ug.sdk.luckycat.impl.popup.f> r107 = r101.h();     // Catch: Exception -> L31
            if (r107 == null) goto L13;
            String r108 = r107.toString();     // Catch: Exception -> L31
        L14:
            r106.append(r108);     // Catch: Exception -> L31
            com.bytedance.ug.sdk.luckycat.impl.utils.a.c("LuckyForestPreloadManager", r106.toString());     // Catch: Exception -> L31
            goto L15
        L13:
            r108 = null;
        L15:
            StringBuilder r109 = new StringBuilder("commonPreloadConfig.luckyPreloadConfigList size: ");     // Catch: Exception -> L31
            List<com.bytedance.ug.sdk.luckycat.impl.popup.f> r110 = r101.h();     // Catch: Exception -> L31
            if (r110 == null) goto L18;
            r105 = Integer.valueOf(r110.size());     // Catch: Exception -> L31
        L18:
            r109.append(r105);     // Catch: Exception -> L31
            com.bytedance.ug.sdk.luckycat.impl.utils.a.c("LuckyForestPreloadManager", r109.toString());     // Catch: Exception -> L31
            List<com.bytedance.ug.sdk.luckycat.impl.popup.f> r111 = r101.h();     // Catch: Exception -> L31
            if (r111 == null) goto L34;
            ArrayList r112 = new ArrayList();     // Catch: Exception -> L31
            Iterator<T> r113 = r111.iterator();     // Catch: Exception -> L31
        L22:
            if (r113.hasNext() == false) goto L26;
            Object r114 = r113.next();     // Catch: Exception -> L31
            if (r103.invoke((com.bytedance.ug.sdk.luckycat.impl.popup.f) r114).booleanValue() == false) goto L22;
            r112.add(r114);     // Catch: Exception -> L31
            goto L22
        L26:
            Iterator r115 = r112.iterator();     // Catch: Exception -> L31
        L28:
            if (r115.hasNext() == false) goto L34;
            r104.invoke((com.bytedance.ug.sdk.luckycat.impl.popup.f) r115.next());     // Catch: Exception -> L31
        L31:
            e = move-exception;
            com.bytedance.ug.sdk.luckycat.impl.utils.a.b("LuckyCatBulletFragment", "Exception: " + e.getMessage());
            goto L34
        }

        public a(com.bytedance.ug.sdk.luckycat.impl.popup.a r100) {
            this.f271368a = r100;
        }
    }

    public s() {
    }

    @Override // com.bytedance.ug.sdk.luckycat.impl.manager.e
    public final void a(com.bytedance.ug.sdk.luckycat.impl.popup.a r100) {
        CopyOnWriteArrayList<String> r101 = v.f271369a;
        v.c(new a(r100));
    }
}
