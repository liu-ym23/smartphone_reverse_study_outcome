package com.bytedance.pitaya.api;

import android.content.Context;
import com.bytedance.pitaya.api.bean.PTYApplogEvent;
import com.bytedance.pitaya.api.bean.PTYApplogEventType;
import com.bytedance.pitaya.api.bean.PTYProxySetting;
import com.bytedance.pitaya.jniwrapper.ReflectionCall;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import f57.c;
import g57.a;
import g57.b;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b(\u0010)J\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u0003J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u000fJ\u000e\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010J\u0006\u0010\u0014\u001a\u00020\u0013J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0003H\u0016R\u001a\u0010\u0016\u001a\u00020\u00038\u0006X\u0086D¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u00038\u0006X\u0086D¢\u0006\f\n\u0004\b\u001a\u0010\u0017\u001a\u0004\b\u001b\u0010\u0019R\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0016\u0010!\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\u001cR\u001e\u0010$\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00030\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'¨\u0006*"}, d2 = {"Lcom/bytedance/pitaya/api/PitayaApplogProxy;", "Lcom/bytedance/pitaya/jniwrapper/ReflectionCall;", "Lf57/c;", "", "str", "", "stringToSet", "Lcom/bytedance/pitaya/api/bean/PTYProxySetting;", "setting", "", "init", "eventName", "extParams", "", "onEvent", "Lorg/json/JSONObject;", "Lcom/bytedance/pitaya/api/PTYApplogImplCallback;", "callback", "storeCache", "", "cacheSize", "isValidEvent", "TAG", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "APPLOG_CFGPATH", "getAPPLOG_CFGPATH", "Z", "getInit", "()Z", "setInit", "(Z)V", "stoped", "Lg57/b;", "Lcom/bytedance/pitaya/api/bean/PTYApplogEvent;", "cache", "Lg57/b;", "filterSet", "Ljava/util/Set;", "<init>", "()V", "pitayacore_release"}, k = 1, mv = {1, 7, 1})
public final class PitayaApplogProxy implements ReflectionCall, c {
    private final String APPLOG_CFGPATH;
    private final String TAG;
    private volatile b<PTYApplogEvent> cache;
    private volatile Set<String> filterSet;
    private volatile boolean init;
    private volatile boolean stoped;

    public final int cacheSize() {
        monitor-enter(this);
        b<PTYApplogEvent> r100 = this.cache;     // Catch: Throwable -> L10
        if (r100 == null) goto L7;
        int r101 = r100.f480056b.size();     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);
        return r101;
    L7:
        r101 = 0;
    L10:
        th = move-exception;
        throw th;
    }

    public PitayaApplogProxy() {
        this.TAG = "PTY-ApplogProxy";
        this.APPLOG_CFGPATH = "/Pitaya/CFG/APPLOG_CACHE_KEY";
        this.filterSet = new LinkedHashSet();
    }

    public final String getAPPLOG_CFGPATH() {
        return this.APPLOG_CFGPATH;
    }

    public final boolean getInit() {
        return this.init;
    }

    public final String getTAG() {
        return this.TAG;
    }

    private final Set<String> stringToSet(String r100) {
        if (r100 == null) goto L4;
        List r101 = StringsKt.split$default(r100, new String[]{","}, false, 0, 6, null);
    L5:
        LinkedHashSet r102 = new LinkedHashSet();
        boolean r103 = false;
        if (r101 != null) goto L8;
    L10:
        if (r103 == false) goto L15;
        Iterator r104 = r101.iterator();
    L13:
        if (r104.hasNext() == false) goto L15;
        r102.add((String) r104.next());
    L15:
        return r102;
    L8:
        if ((!r101.isEmpty()) != true) goto L10;
        r103 = true;
        goto L10
    L4:
        r101 = null;
        goto L5
    }

    public final boolean init(PTYProxySetting r100) {
        Intrinsics.checkNotNullParameter(r100, "setting");
        if (r100.getUseCustomApplogEvents() == false) goto L8;
        this.filterSet = stringToSet(r100.getCustomApplogEvents());
        if (this.filterSet.size() != 0) goto L7;
        return false;
    L7:
        r100.getCustomApplogEvents();
    L19:
        this.cache = new b(r100.getMaxApplogEventCacheNum());
        this.init = true;
        return true;
    L8:
        StringBuilder r101 = new StringBuilder();
        Context r102 = a.f480053a.getContext();
        if (r102 == null) goto L13;
        File r103 = r102.getFilesDir();
        if (r103 == null) goto L13;
        String r104 = r103.getAbsolutePath();
    L14:
        r101.append(r104);
        r101.append(this.APPLOG_CFGPATH);
        PolarisFileWrapper r105 = new PolarisFileWrapper(r101.toString());
        if (r105.exists() == true) goto L22;
        this.init = true;
        this.stoped = true;
        return false;
    L22:
        this.filterSet = stringToSet(FilesKt.readText(r105, Charsets.UTF_8));     // Catch: Exception -> L21
    L21:
        return false;
    L13:
        r104 = null;
        goto L14
    }

    @Override // f57.c
    public boolean isValidEvent(String r100) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L9;
    L7:
        return false;
    L9:
        if (this.init == false) goto L7;
        if (this.filterSet.size() <= 0) goto L7;
        if (this.filterSet.contains(r100) == false) goto L7;
        return true;
    L5:
        r101 = false;
        goto L6
    }

    public final void setInit(boolean r100) {
        this.init = r100;
    }

    public final void storeCache(PTYApplogImplCallback r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        cacheSize();
        monitor-enter(this);
        this.stoped = true;     // Catch: Throwable -> L18
        if (cacheSize() != 0) goto L9;
        monitor-exit(this);
        return;
    L9:
        b<PTYApplogEvent> r101 = this.cache;     // Catch: Throwable -> L18
        Intrinsics.checkNotNull(r101);     // Catch: Throwable -> L18
        Iterator<PTYApplogEvent> r102 = r101.f480056b.iterator();     // Catch: Throwable -> L18
    L11:
        if (r102.hasNext() == false) goto L13;
        r100.onEvent(r102.next());     // Catch: Throwable -> L18
        goto L11
    L13:
        b<PTYApplogEvent> r103 = this.cache;     // Catch: Throwable -> L18
        if (r103 == null) goto L16;
        r103.f480056b.clear();     // Catch: Throwable -> L18
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L18
    L16:
        monitor-exit(this);
        return;
    L18:
        th = move-exception;
        throw th;
    }

    public final void onEvent(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        if (this.init == true) goto L6;
        return;
    L6:
        if (this.filterSet.size() > 0) goto L8;
        return;
    L8:
        if (this.filterSet.contains(r100) == false) goto L36;
        monitor-enter(this);
    L28:
        th = move-exception;
        throw th;
    L11:
        if (this.stoped == false) goto L14;
        monitor-exit(this);
        return;
    L14:
        if (r101 != null) goto L32;
        String r102 = null;
    L20:
        b<PTYApplogEvent> r103 = this.cache;     // Catch: Throwable -> L28
        if (r103 == null) goto L26;
        PTYApplogEvent r104 = new PTYApplogEvent(r100, r102, PTYApplogEventType.COLD_START);     // Catch: Throwable -> L28
        if (r103.f480056b.size() < r103.f480055a) goto L25;
        r103.f480056b.removeFirst();     // Catch: Throwable -> L28
    L25:
        r103.f480056b.addLast(r104);     // Catch: Throwable -> L28
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L28
    L26:
        monitor-exit(this);
        return;
    L32:
        r102 = r101.toString();     // Catch: Throwable -> L17
    L18:
        return;
    }

    public final void onEvent(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        if (this.init == true) goto L6;
        return;
    L6:
        if (this.filterSet.size() > 0) goto L8;
        return;
    L8:
        if (this.filterSet.contains(r100) == false) goto L28;
        monitor-enter(this);
    L22:
        th = move-exception;
        throw th;
    L11:
        if (this.stoped == false) goto L14;
        monitor-exit(this);
        return;
    L14:
        b<PTYApplogEvent> r102 = this.cache;     // Catch: Throwable -> L22
        if (r102 == null) goto L20;
        PTYApplogEvent r103 = new PTYApplogEvent(r100, r101, PTYApplogEventType.COLD_START);     // Catch: Throwable -> L22
        if (r102.f480056b.size() < r102.f480055a) goto L19;
        r102.f480056b.removeFirst();     // Catch: Throwable -> L22
    L19:
        r102.f480056b.addLast(r103);     // Catch: Throwable -> L22
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L22
    L20:
        monitor-exit(this);
        return;
    }
}
