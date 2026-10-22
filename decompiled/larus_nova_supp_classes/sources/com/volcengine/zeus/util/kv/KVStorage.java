package com.volcengine.zeus.util.kv;

import com.bytedance.keva.Keva;
import com.larus.apm.impl.protector.RunnableProtector;
import dqc.e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\u0014\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0004H\u0002J\u0006\u0010\u0019\u001a\u00020\u0014J\u0006\u0010\u001a\u001a\u00020\u0016J\u0006\u0010\u001b\u001a\u00020\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R#\u0010\t\u001a\n \n*\u0004\u0018\u00010\u00040\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\b\u001a\u0004\b\u000b\u0010\u0006R\u001b\u0010\r\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\b\u001a\u0004\b\u000e\u0010\u0006R\u0016\u0010\u0010\u001a\n \n*\u0004\u0018\u00010\u00110\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n \n*\u0004\u0018\u00010\u00110\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/volcengine/zeus/util/kv/KVStorage;", XmlPullParser.NO_NAMESPACE, "()V", "currentDynamicPrefix", XmlPullParser.NO_NAMESPACE, "getCurrentDynamicPrefix", "()Ljava/lang/String;", "currentDynamicPrefix$delegate", "Lkotlin/Lazy;", "currentProcessName", "kotlin.jvm.PlatformType", "getCurrentProcessName", "currentProcessName$delegate", "currentProcessStartToken", "getCurrentProcessStartToken", "currentProcessStartToken$delegate", "dynamicRepo", "Lcom/bytedance/keva/Keva;", "staticRepo", "deletePreviousDynamicData", XmlPullParser.NO_NAMESPACE, "dynamicKV", "Lcom/volcengine/zeus/util/kv/IKVStore;", "processName", "getDynamicPrefix", "init", "mainDynamicKV", "staticKV", "zeus-core_release"}, k = 1, mv = {1, 4, 2})
public final class KVStorage {
    public static final KVStorage INSTANCE = null;
    private static final Lazy currentDynamicPrefix$delegate = null;
    private static final Lazy currentProcessName$delegate = null;
    private static final Lazy currentProcessStartToken$delegate = null;
    private static final Keva dynamicRepo = null;
    private static final Keva staticRepo = null;

    public static final class a implements Runnable {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            KVStorage.access$deletePreviousDynamicData(KVStorage.INSTANCE);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    private KVStorage() {
    }

    private final String getCurrentDynamicPrefix() {
        return (String) currentDynamicPrefix$delegate.getValue();
    }

    private final String getCurrentProcessName() {
        return (String) currentProcessName$delegate.getValue();
    }

    private final String getCurrentProcessStartToken() {
        return (String) currentProcessStartToken$delegate.getValue();
    }

    public final IKVStore dynamicKV() {
        return dynamicKV$default(this, null, 1, null);
    }

    static {
        INSTANCE = new KVStorage();
        staticRepo = Keva.getRepo("zeus_static_storage", 1);
        dynamicRepo = Keva.getRepo("zeus_dynamic_storage", 1);
        LazyThreadSafetyMode r0 = LazyThreadSafetyMode.PUBLICATION;
        currentProcessName$delegate = LazyKt.lazy(r0, KVStorage$currentProcessName$2.INSTANCE);
        currentProcessStartToken$delegate = LazyKt.lazy(r0, KVStorage$currentProcessStartToken$2.INSTANCE);
        currentDynamicPrefix$delegate = LazyKt.lazy(r0, KVStorage$currentDynamicPrefix$2.INSTANCE);
    }

    private final void deletePreviousDynamicData() {
        String r0 = getCurrentProcessName() + '_';
        Set<String> r1 = dynamicRepo.getAll().keySet();
        ArrayList r2 = new ArrayList();
        Iterator<T> r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L12;
        Object r4 = r3.next();
        String r5 = (String) r4;
        boolean r6 = false;
        if (StringsKt.startsWith$default(r5, r0, false, 2, null) == true) goto L8;
    L10:
        if (r6 == false) goto L4;
        r2.add(r4);
        goto L4
    L8:
        if (StringsKt.startsWith$default(r5, INSTANCE.getCurrentDynamicPrefix(), false, 2, null) == true) goto L10;
        r6 = true;
        goto L10
    L12:
        Iterator r7 = r2.iterator();
    L14:
        if (r7.hasNext() == false) goto L16;
        dynamicRepo.erase((String) r7.next());
        goto L14
    }

    public final void init() {
        Keva r0 = staticRepo;
        StringCompanionObject r1 = StringCompanionObject.INSTANCE;
        r0.storeString(String.format("storage_start_token_for_%s", Arrays.copyOf(new Object[]{getCurrentProcessName()}, 1)), getCurrentProcessStartToken());
        e.b(a.a);
    }

    public final IKVStore mainDynamicKV() {
        return dynamicKV("main");
    }

    public final IKVStore staticKV() {
        return new com.volcengine.zeus.util.kv.a(staticRepo, null);
    }

    public static final /* synthetic */ void access$deletePreviousDynamicData(KVStorage r0) {
        r0.deletePreviousDynamicData();
    }

    public static final /* synthetic */ String access$getCurrentProcessName$p(KVStorage r0) {
        return r0.getCurrentProcessName();
    }

    private final String getDynamicPrefix(String r4) {
        if (Intrinsics.areEqual(r4, getCurrentProcessName()) == false) goto L5;
        String r0 = getCurrentProcessStartToken();
    L7:
        return r4 + '_' + r0 + '_';
    L5:
        StringCompanionObject r1 = StringCompanionObject.INSTANCE;
        r0 = staticRepo.getString(String.format("storage_start_token_for_%s", Arrays.copyOf(new Object[]{r4}, 1)), XmlPullParser.NO_NAMESPACE);
        goto L7
    }

    public final IKVStore dynamicKV(final String r4) {
        if (r4 != null) goto L6;
        r4 = getCurrentProcessName();
    L6:
        return new com.volcengine.zeus.util.kv.a(dynamicRepo, new AnonymousClass1(r4));
    }

    public static final /* synthetic */ String access$getDynamicPrefix(KVStorage r0, String r1) {
        return r0.getDynamicPrefix(r1);
    }

    public static /* synthetic */ IKVStore dynamicKV$default(KVStorage r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = null;
    L6:
        return r0.dynamicKV(r1);
    }
}
