package com.bytedance.ies.argus.aspect;

import com.bytedance.ies.argus.api.ArgusLynxDelegate;
import com.bytedance.ies.argus.api.params.LoadTemplateParams;
import com.bytedance.ies.argus.util.CommonUtils;
import com.lynx.tasm.LynxView;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f245800a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, LoadTemplateParams> f245801b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap<String, WeakReference<ArgusLynxDelegate>> f245802c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ConcurrentHashMap<String, WeakReference<ArgusLynxDelegate>> f245803d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Map<String, Integer> f245804e = null;

    public c() {
    }

    static {
        f245800a = new c();
        f245801b = new ConcurrentHashMap();
        f245802c = new ConcurrentHashMap();
        f245803d = new ConcurrentHashMap();
        f245804e = new LinkedHashMap();
    }

    public final ArgusLynxDelegate getContext(com.bytedance.lynx.service.security.f r100) {
        Intrinsics.checkNotNullParameter(r100, "lynxVerification");
        LynxView r101 = r100.f264949b.get();
        ArgusLynxDelegate r102 = null;
        if (r101 == null) goto L10;
        String r103 = CommonUtils.e(r101);
        if (r103 == null) goto L10;
        WeakReference<ArgusLynxDelegate> r104 = f245803d.get(r103);
        if (r104 != null) goto L9;
        return null;
    L9:
        return r104.get();
    L10:
        Intrinsics.checkNotNullParameter(r100, "verification");
        String r105 = a(r100.f264951d, r100.f264952e);
        if (r105 == null) goto L17;
        ConcurrentHashMap<String, WeakReference<ArgusLynxDelegate>> r106 = f245802c;
        WeakReference<ArgusLynxDelegate> r107 = r106.get(r105);
        if (r107 == null) goto L16;
        r102 = r107.get();
    L16:
        r106.remove(r105);
    L17:
        return r102;
    }

    public static String a(byte[] r100, ByteBuffer r101) {
        if (r100 == null) goto L9;
        String r102 = CommonUtils.e(r100);
        if (r102 != null) goto L8;
        return null;
    L8:
        return r102 + '_' + r100.length;
    L9:
        if (r101 == null) goto L15;
        String r103 = CommonUtils.e(r101);
        if (r103 != null) goto L14;
        return null;
    L14:
        return r103 + '_' + r101.limit();
    L15:
        return null;
    }
}
