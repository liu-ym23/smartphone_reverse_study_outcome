package com.larus.home.impl.sdk;

import android.text.TextUtils;
import com.larus.platform.api.IVideoController;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class r0 implements com.larus.platform.api.v0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ConcurrentHashMap<String, com.larus.platform.api.w0> f346227a;

    public r0() {
    }

    @Override // com.larus.platform.api.v0
    public final boolean a(String r100) {
        com.larus.platform.api.v0 r101 = (com.larus.platform.api.v0) com.larus.platform.service.v1.f365816a.getValue();
        if (r101 == null) goto L5;
        Map<String, com.larus.platform.api.w0> r102 = r101.d(r100);
    L7:
        if (r102 != null) goto L9;
    L12:
        boolean r103 = true;
    L13:
        if (r103 == false) goto L15;
        return true;
    L15:
        return false;
    L9:
        if (r102.isEmpty() == true) goto L12;
        r103 = false;
        goto L13
    L5:
        r102 = null;
        goto L7
    }

    @Override // com.larus.platform.api.v0
    public final boolean b(String r100) {
        Map<String, com.larus.platform.api.w0> r101 = d(r100);
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
        return true;
    L11:
        Iterator<com.larus.platform.api.w0> r103 = r101.values().iterator();
    L13:
        if (r103.hasNext() == false) goto L23;
        com.larus.platform.api.w0 r104 = r103.next();
        if (r104.getStatus() == IVideoController.PlayType.PLAY) goto L22;
        if (r104.getStatus() == IVideoController.PlayType.PREPARE) goto L22;
        if (r104.a() == false) goto L13;
        FLogger.f375446a.i("MusicPlay", "checkMediaAllPlayEnd false because just triggered play");
    L22:
        return false;
    L23:
        return true;
    L5:
        if (r101.isEmpty() == true) goto L8;
        r102 = false;
        goto L9
    }

    @Override // com.larus.platform.api.v0
    public final void c(ConcurrentHashMap<String, com.larus.platform.api.w0> r100) {
        Intrinsics.checkNotNullParameter(r100, "engineMaps");
        this.f346227a = r100;
    }

    @Override // com.larus.platform.api.v0
    public final Map<String, com.larus.platform.api.w0> d(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L5;
        ConcurrentHashMap<String, com.larus.platform.api.w0> r101 = this.f346227a;
        if (r101 == null) goto L14;
        LinkedHashMap r102 = new LinkedHashMap();
        Iterator<Map.Entry<String, com.larus.platform.api.w0>> r103 = r101.entrySet().iterator();
    L10:
        if (r103.hasNext() == false) goto L21;
        Map.Entry<String, com.larus.platform.api.w0> r104 = r103.next();
        if (Intrinsics.areEqual(r104.getValue().getId(), r100) == false) goto L10;
        r102.put(r104.getKey(), r104.getValue());
        goto L10
    L21:
        return r102;
    L14:
        return null;
    L5:
        return this.f346227a;
    }
}
