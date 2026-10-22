package com.bytedance.iesgurd.core;

import com.bytedance.geckox.AppSettingsManager;
import com.bytedance.geckox.IGeckoLowStorageConfig;
import com.bytedance.geckox.model.Resources;
import com.bytedance.geckox.settings.model.GlobalConfigSettings;
import com.bytedance.iesgurd.settings.GlobalSettingsManager;
import com.bytedance.iesgurd.settings.SettingsExtra;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;

/* JADX INFO: loaded from: classes19.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, Map<String, List<String>>> f250660a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, Resources> f250661b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, Resources> f250662c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f250663d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f250664e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static int f250665f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static int f250666g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static List<String> f250667h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final f f250668i = null;

    public f() {
    }

    public final synchronized List<String> a() {
        monitor-enter(this);
        List<String> r100 = f250667h;     // Catch: Throwable -> L13
        if (r100 == null) goto L7;
        monitor-exit(this);
        return r100;
    L7:
        GlobalConfigSettings r101 = GlobalSettingsManager.f250833a;     // Catch: Throwable -> L13
        SettingsExtra r102 = GlobalSettingsManager.f250843k;     // Catch: Throwable -> L13
        if (r102 == null) goto L10;
        f250667h = r102.getNoLocalAk();     // Catch: Throwable -> L13
    L10:
        List<String> r103 = f250667h;     // Catch: Throwable -> L13
        monitor-exit(this);
        return r103;
    L13:
        th = move-exception;
        throw th;
    }

    public final synchronized Pair<Integer, Integer> b() {
        monitor-enter(this);
    L90:
        th = move-exception;
        throw th;
    L4:
        if (f250663d == false) goto L9;
        Pair<Integer, Integer> r100 = new Pair(Integer.valueOf(f250665f), Integer.valueOf(f250666g));     // Catch: Throwable -> L90
        monitor-exit(this);
        return r100;
    L9:
        if (f250664e == false) goto L87;
        IGeckoLowStorageConfig r101 = (IGeckoLowStorageConfig) ServiceManager.get().getServiceForReal(IGeckoLowStorageConfig.class);     // Catch: Throwable -> L90
        if (r101 == null) goto L87;
        f250665f = r101.getLowStorageAvailable();     // Catch: Throwable -> L90
        f250666g = r101.getSensitiveStorageAvailable();     // Catch: Throwable -> L90
        if (f250665f == (-1)) goto L49;
        f250663d = true;     // Catch: Throwable -> L90
        Map<String, Resources> r102 = r101.getLowStorageWhiteList();     // Catch: Throwable -> L90
        if (r102 == null) goto L49;
        Set<Map.Entry<String, Resources>> r103 = r102.entrySet();     // Catch: Throwable -> L90
        if (r103 == null) goto L49;
        Iterator<T> r104 = r103.iterator();     // Catch: Throwable -> L90
    L20:
        if (r104.hasNext() == false) goto L49;
        Map.Entry r105 = (Map.Entry) r104.next();     // Catch: Throwable -> L90
        String r106 = (String) r105.getKey();     // Catch: Throwable -> L90
        Resources r107 = (Resources) r105.getValue();     // Catch: Throwable -> L90
        if (r107 == null) goto L30;
        List<String> r108 = r107.getGroups();     // Catch: Throwable -> L90
        if (r108 == null) goto L30;
        Object[] r109 = r108.toArray(new String[0]);     // Catch: Throwable -> L90
        if (r109 == null) goto L29;
        String[] r110 = (String[]) r109;     // Catch: Throwable -> L90
    L31:
        Resources r111 = (Resources) r105.getValue();     // Catch: Throwable -> L90
        if (r111 == null) goto L40;
        List<String> r112 = r111.getChannels();     // Catch: Throwable -> L90
        if (r112 == null) goto L40;
        Object[] r113 = r112.toArray(new String[0]);     // Catch: Throwable -> L90
        if (r113 == null) goto L39;
        String[] r114 = (String[]) r113;     // Catch: Throwable -> L90
    L41:
        Map<String, Resources> r115 = f250661b;     // Catch: Throwable -> L90
        Resources r116 = (Resources) ((ConcurrentHashMap) r115).get(r106);     // Catch: Throwable -> L90
        if (r116 != null) goto L44;
        r116 = new Resources();     // Catch: Throwable -> L90
        ((ConcurrentHashMap) r115).put(r106, r116);     // Catch: Throwable -> L90
    L44:
        if (r110 == null) goto L46;
        r116.setGroups(ArraysKt.asList(r110));     // Catch: Throwable -> L90
    L46:
        if (r114 == null) goto L20;
        r116.setChannels(ArraysKt.asList(r114));     // Catch: Throwable -> L90
        goto L20
    L39:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");     // Catch: Throwable -> L90
    L40:
        r114 = null;
        goto L41
    L29:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");     // Catch: Throwable -> L90
    L30:
        r110 = null;
    L49:
        if (f250666g == (-1)) goto L84;
        f250663d = true;     // Catch: Throwable -> L90
        Map<String, Resources> r117 = r101.getSensitiveStorageBlockList();     // Catch: Throwable -> L90
        if (r117 == null) goto L84;
        Set<Map.Entry<String, Resources>> r118 = r117.entrySet();     // Catch: Throwable -> L90
        if (r118 == null) goto L84;
        Iterator<T> r119 = r118.iterator();     // Catch: Throwable -> L90
    L56:
        if (r119.hasNext() == false) goto L84;
        Map.Entry r120 = (Map.Entry) r119.next();     // Catch: Throwable -> L90
        String r121 = (String) r120.getKey();     // Catch: Throwable -> L90
        Resources r122 = (Resources) r120.getValue();     // Catch: Throwable -> L90
        if (r122 == null) goto L66;
        List<String> r123 = r122.getGroups();     // Catch: Throwable -> L90
        if (r123 == null) goto L66;
        Object[] r124 = r123.toArray(new String[0]);     // Catch: Throwable -> L90
        if (r124 == null) goto L65;
        String[] r125 = (String[]) r124;     // Catch: Throwable -> L90
    L67:
        Resources r126 = (Resources) r120.getValue();     // Catch: Throwable -> L90
        if (r126 == null) goto L76;
        List<String> r127 = r126.getChannels();     // Catch: Throwable -> L90
        if (r127 == null) goto L76;
        Object[] r128 = r127.toArray(new String[0]);     // Catch: Throwable -> L90
        if (r128 == null) goto L75;
        String[] r129 = (String[]) r128;     // Catch: Throwable -> L90
    L77:
        Map<String, Resources> r130 = f250662c;     // Catch: Throwable -> L90
        Resources r131 = (Resources) ((ConcurrentHashMap) r130).get(r121);     // Catch: Throwable -> L90
        if (r131 != null) goto L80;
        r131 = new Resources();     // Catch: Throwable -> L90
        ((ConcurrentHashMap) r130).put(r121, r131);     // Catch: Throwable -> L90
    L80:
        if (r125 == null) goto L82;
        r131.setGroups(ArraysKt.asList(r125));     // Catch: Throwable -> L90
    L82:
        if (r129 == null) goto L56;
        r131.setChannels(ArraysKt.asList(r129));     // Catch: Throwable -> L90
        goto L56
    L75:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");     // Catch: Throwable -> L90
    L76:
        r129 = null;
        goto L77
    L65:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");     // Catch: Throwable -> L90
    L66:
        r125 = null;
    L84:
        Pair<Integer, Integer> r132 = new Pair(Integer.valueOf(f250665f), Integer.valueOf(f250666g));     // Catch: Throwable -> L90
        monitor-exit(this);
        return r132;
    L87:
        f250664e = false;     // Catch: Throwable -> L90
        AppSettingsManager r133 = AppSettingsManager.b.f245071a;     // Catch: Throwable -> L90
        Pair<Integer, Integer> r134 = new Pair(-1, -1);     // Catch: Throwable -> L90
        monitor-exit(this);
        return r134;
    }

    static {
        f250668i = new f();
        f250660a = new ConcurrentHashMap();
        f250661b = new ConcurrentHashMap();
        f250662c = new ConcurrentHashMap();
        f250664e = true;
        f250665f = -1;
        f250666g = -1;
    }
}
