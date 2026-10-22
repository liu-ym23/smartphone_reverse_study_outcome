package com.volcengine.zeus.util.kv;

import com.bytedance.android.service.manager.pull.PullConfiguration;
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

/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\u0014\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0004H\u0002J\u0006\u0010\u0019\u001a\u00020\u0014J\u0006\u0010\u001a\u001a\u00020\u0016J\u0006\u0010\u001b\u001a\u00020\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R#\u0010\t\u001a\n \n*\u0004\u0018\u00010\u00040\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\b\u001a\u0004\b\u000b\u0010\u0006R\u001b\u0010\r\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\b\u001a\u0004\b\u000e\u0010\u0006R\u0016\u0010\u0010\u001a\n \n*\u0004\u0018\u00010\u00110\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n \n*\u0004\u0018\u00010\u00110\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/volcengine/zeus/util/kv/KVStorage;", "", "()V", "currentDynamicPrefix", "", "getCurrentDynamicPrefix", "()Ljava/lang/String;", "currentDynamicPrefix$delegate", "Lkotlin/Lazy;", "currentProcessName", "kotlin.jvm.PlatformType", "getCurrentProcessName", "currentProcessName$delegate", "currentProcessStartToken", "getCurrentProcessStartToken", "currentProcessStartToken$delegate", "dynamicRepo", "Lcom/bytedance/keva/Keva;", "staticRepo", "deletePreviousDynamicData", "", "dynamicKV", "Lcom/volcengine/zeus/util/kv/IKVStore;", "processName", "getDynamicPrefix", "init", "mainDynamicKV", "staticKV", "zeus-core_release"}, k = 1, mv = {1, 4, 2})
public final class KVStorage {
    public static final KVStorage INSTANCE = null;
    private static final Lazy currentDynamicPrefix$delegate = null;
    private static final Lazy currentProcessName$delegate = null;
    private static final Lazy currentProcessStartToken$delegate = null;
    private static final Keva dynamicRepo = null;
    private static final Keva staticRepo = null;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f462922a = null;

        static {
            f462922a = new a();
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
        LazyThreadSafetyMode r100 = LazyThreadSafetyMode.PUBLICATION;
        currentProcessName$delegate = LazyKt.lazy(r100, KVStorage$currentProcessName$2.INSTANCE);
        currentProcessStartToken$delegate = LazyKt.lazy(r100, KVStorage$currentProcessStartToken$2.INSTANCE);
        currentDynamicPrefix$delegate = LazyKt.lazy(r100, KVStorage$currentDynamicPrefix$2.INSTANCE);
    }

    private final void deletePreviousDynamicData() {
        String r100 = getCurrentProcessName() + '_';
        Set<String> r101 = dynamicRepo.getAll().keySet();
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L12;
        Object r104 = r103.next();
        String r105 = (String) r104;
        boolean r106 = false;
        if (StringsKt.startsWith$default(r105, r100, false, 2, null) == true) goto L8;
    L10:
        if (r106 == false) goto L4;
        r102.add(r104);
        goto L4
    L8:
        if (StringsKt.startsWith$default(r105, INSTANCE.getCurrentDynamicPrefix(), false, 2, null) == true) goto L10;
        r106 = true;
        goto L10
    L12:
        Iterator r107 = r102.iterator();
    L14:
        if (r107.hasNext() == false) goto L16;
        dynamicRepo.erase((String) r107.next());
        goto L14
    }

    public final void init() {
        Keva r100 = staticRepo;
        StringCompanionObject r101 = StringCompanionObject.INSTANCE;
        r100.storeString(String.format("storage_start_token_for_%s", Arrays.copyOf(new Object[]{getCurrentProcessName()}, 1)), getCurrentProcessStartToken());
        e.b(a.f462922a);
    }

    public final IKVStore mainDynamicKV() {
        return dynamicKV(PullConfiguration.PROCESS_NAME_MAIN);
    }

    public final IKVStore staticKV() {
        return new com.volcengine.zeus.util.kv.a(staticRepo, null);
    }

    public static final /* synthetic */ void access$deletePreviousDynamicData(KVStorage r100) {
        r100.deletePreviousDynamicData();
    }

    public static final /* synthetic */ String access$getCurrentProcessName$p(KVStorage r100) {
        return r100.getCurrentProcessName();
    }

    private final String getDynamicPrefix(String r100) {
        if (Intrinsics.areEqual(r100, getCurrentProcessName()) == false) goto L5;
        String r101 = getCurrentProcessStartToken();
    L7:
        return r100 + '_' + r101 + '_';
    L5:
        StringCompanionObject r102 = StringCompanionObject.INSTANCE;
        r101 = staticRepo.getString(String.format("storage_start_token_for_%s", Arrays.copyOf(new Object[]{r100}, 1)), "");
        goto L7
    }

    public final IKVStore dynamicKV(final String r100) {
        if (r100 != null) goto L6;
        r100 = getCurrentProcessName();
    L6:
        return new com.volcengine.zeus.util.kv.a(dynamicRepo, new AnonymousClass1(r100));
    }

    public static final /* synthetic */ String access$getDynamicPrefix(KVStorage r100, String r101) {
        return r100.getDynamicPrefix(r101);
    }

    public static /* synthetic */ IKVStore dynamicKV$default(KVStorage r100, String r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = null;
    L6:
        return r100.dynamicKV(r101);
    }
}
