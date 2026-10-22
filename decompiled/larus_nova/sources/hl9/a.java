package hl9;

import cl9.g;
import com.bytedance.mira.Mira;
import com.bytedance.mira.plugin.Plugin;
import com.bytedance.mira.plugin.PluginManager;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PThreadPoolExecutor f485700a = null;

    /* JADX INFO: renamed from: hl9.a$a, reason: collision with other inner class name */
    public static final class ThreadFactoryC6161a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f485701a;

        public ThreadFactoryC6161a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable r100) {
            Intrinsics.checkNotNullParameter(r100, "r");
            StringBuilder r101 = new StringBuilder("Mira-IO-Thread-");
            int r102 = this.f485701a;
            this.f485701a = r102 + 1;
            r101.append(r102);
            return new PthreadThreadV2(r100, r101.toString());
        }
    }

    static {
        f485700a = new PThreadPoolExecutor(4, 20, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(1000), new ThreadFactoryC6161a(), new ThreadPoolExecutor.CallerRunsPolicy());
    }

    public static boolean a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "pluginPackageName");
        if ((!PluginManager.getInstance().isPluginPackage(r100)) == true) goto L25;
        g.f24138a.getClass();
        if (g.e() == false) goto L20;
        List r101 = b(r100);
        if ((r101 instanceof Collection) == true) goto L9;
    L11:
        Iterator r102 = r101.iterator();
    L13:
        if (r102.hasNext() == false) goto L17;
        if (Mira.isPluginInstalled((String) r102.next()) == true) goto L13;
        boolean r103 = false;
    L18:
        if (r103 == false) goto L20;
        return true;
    L17:
        r103 = true;
        goto L18
    L9:
        if (r101.isEmpty() == false) goto L11;
    L20:
        return false;
    L25:
        return true;
    }

    public static List b(String r100) {
        if ((!PluginManager.getInstance().isPluginPackage(r100)) == true) goto L23;
        int r101 = 0;
        if (r100 != null) goto L7;
    L10:
        boolean r102 = true;
    L11:
        if (r102 == true) goto L23;
        Set r103 = SetsKt.mutableSetOf(new String[]{r100});
        Plugin r104 = Mira.getPlugin(r100);
        if (r104 == null) goto L21;
        JSONArray r105 = (JSONArray) r104.optExtraData("dependencies");
        if (r105 == null) goto L21;
        int r106 = r105.length();
    L18:
        if (r101 >= r106) goto L21;
        r103.addAll(b(JSONArrayProtectorUtils.getString(r105, r101)));
        r101 = r101 + 1;
    L21:
        return CollectionsKt.toList(r103);
    L7:
        if (r100.length() == 0) goto L10;
        r102 = false;
    L23:
        return CollectionsKt.emptyList();
    }
}
