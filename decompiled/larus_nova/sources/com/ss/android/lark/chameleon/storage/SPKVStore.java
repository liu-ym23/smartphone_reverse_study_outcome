package com.ss.android.lark.chameleon.storage;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.ss.android.lark.chameleon.idependency.Env;
import com.ss.android.lark.chameleon.idependency.IEnv;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\nH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0002J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0016J\u000e\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011J\u0018\u0010\u0012\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\nH\u0016J\u0018\u0010\u0014\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004H\u0016J\u000e\u0010\u0015\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/chameleon/storage/SPKVStore;", "Lcom/ss/android/lark/chameleon/storage/IKVStorage;", "()V", "DOMAIN", "", CloudControlInf.SP, "Landroid/content/SharedPreferences;", "clear", "", "getBoolean", "", "key", "defaultValue", "getSP", "getString", "init", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "putBoolean", "value", "putString", "remove", "chameleon-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SPKVStore implements IKVStorage {
    private static final String DOMAIN = "chameleon_debug";
    public static final SPKVStore INSTANCE = null;

    /* JADX INFO: renamed from: sp, reason: collision with root package name */
    private static volatile SharedPreferences f411114sp;

    static {
        INSTANCE = new SPKVStore();
    }

    private SPKVStore() {
    }

    private final SharedPreferences getSP() {
        SharedPreferences r100 = f411114sp;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Env r101 = Env.INSTANCE;
        if (r101.getIEnv() == null) goto L23;
        IEnv r102 = r101.getIEnv();
        if (r102 == null) goto L10;
        Application r103 = r102.getApplication();
    L11:
        if (r103 == null) goto L23;
        monitor-enter(this);
        SharedPreferences r104 = f411114sp;     // Catch: Throwable -> L20
        if (r104 != null) goto L17;
        r104 = Env.getApplication().getSharedPreferences(DOMAIN, 0);     // Catch: Throwable -> L20
        f411114sp = r104;     // Catch: Throwable -> L20
    L17:
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L20
        monitor-exit(this);
        return r104;
    L20:
        th = move-exception;
        throw th;
    L10:
        r103 = null;
    L23:
        return null;
    }

    public final void clear() {
        SharedPreferences r100 = getSP();
        if (r100 == null) goto L10;
        SharedPreferences.Editor r101 = r100.edit();
        if (r101 == null) goto L11;
        SharedPreferences.Editor r102 = r101.clear();
        if (r102 == null) goto L12;
        r102.apply();
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void init(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (f411114sp == null) goto L5;
        return;
    L5:
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (f411114sp != null) goto L9;
        f411114sp = r100.getApplicationContext().getSharedPreferences(DOMAIN, 0);     // Catch: Throwable -> L12
    L9:
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(this);
    }

    public final void remove(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        SharedPreferences r101 = getSP();
        if (r101 == null) goto L10;
        SharedPreferences.Editor r102 = r101.edit();
        if (r102 == null) goto L11;
        SharedPreferences.Editor r103 = r102.remove(r100);
        if (r103 == null) goto L12;
        r103.apply();
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // com.ss.android.lark.chameleon.storage.IKVStorage
    public boolean getBoolean(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        SharedPreferences r102 = getSP();
        if (r102 != null) goto L5;
        return r101;
    L5:
        return r102.getBoolean(r100, r101);
    }

    @Override // com.ss.android.lark.chameleon.storage.IKVStorage
    public String getString(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "defaultValue");
        SharedPreferences r102 = getSP();
        if (r102 == null) goto L5;
        String r103 = r102.getString(r100, r101);
    L6:
        if (r103 != null) goto L9;
        return r101;
    L9:
        return r103;
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.ss.android.lark.chameleon.storage.IKVStorage
    public void put(String r100, Object r101) {
        IKVStorage.DefaultImpls.put(this, r100, r101);
    }

    @Override // com.ss.android.lark.chameleon.storage.IKVStorage
    public void putBoolean(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        SharedPreferences r102 = getSP();
        if (r102 == null) goto L10;
        SharedPreferences.Editor r103 = r102.edit();
        if (r103 == null) goto L11;
        SharedPreferences.Editor r104 = r103.putBoolean(r100, r101);
        if (r104 == null) goto L12;
        r104.apply();
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // com.ss.android.lark.chameleon.storage.IKVStorage
    public void putString(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        SharedPreferences r102 = getSP();
        if (r102 == null) goto L10;
        SharedPreferences.Editor r103 = r102.edit();
        if (r103 == null) goto L11;
        SharedPreferences.Editor r104 = r103.putString(r100, r101);
        if (r104 == null) goto L12;
        r104.apply();
        return;
    L12:
        return;
    L11:
        return;
    }
}
