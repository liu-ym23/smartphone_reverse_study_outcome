package com.ss.android.lark.download.service.impl;

import android.text.TextUtils;
import com.ss.android.lark.download.service.DownloadProgress;
import com.ss.android.lark.download.service.FileDownloadState;
import com.ss.android.lark.download.service.NetworkType;
import com.ss.android.lark.http.netstate.NetworkUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, wbb.a> f420526a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.ss.android.lark.http.netstate.c f420527b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<wbb.b> f420528c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.ss.android.lark.download.service.impl.b f420529d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set<wbb.c> f420530e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f420531f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public NetworkType f420532g;

    /* JADX INFO: renamed from: com.ss.android.lark.download.service.impl.a$a, reason: collision with other inner class name */
    public class C4956a implements wbb.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f420533a;

        public C4956a(a r100) {
            this.f420533a = r100;
        }

        @Override // wbb.e
        public final void a(DownloadProgress r100) {
            a r101 = this.f420533a;
            if (r100 != null) goto L5;
            r101.getClass();
            return;
        L5:
            Map<String, wbb.a> r102 = r101.f420526a;
            HashMap r103 = (HashMap) r102;
            wbb.a r104 = (wbb.a) r103.get(r100.getKey());
            if (r104 != null) goto L9;
            return;
        L9:
            if (r100.getMessageId().equals(null) == true) goto L12;
            return;
        L12:
            if (r100.getState() != FileDownloadState.DOWNLOAD_SUCCESS) goto L20;
            String r105 = r100.getKey();
            r100.getMessageId();
            if (TextUtils.isEmpty(r105) == false) goto L17;
            return;
        L17:
            if (((wbb.a) ((HashMap) r101.f420526a).get(r105)) == null) goto L26;
            throw null;
        L26:
            return;
        L20:
            r104.f559031b = r100.getState();
            r104.f559030a = r100.getProgress();
        }
    }

    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f420534a = null;

        static {
            int[] r100 = new int[NetworkUtils.NetworkType.values().length];
            f420534a = r100;
            r100[NetworkUtils.NetworkType.UNKNOWN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L18:
            f420534a[NetworkUtils.NetworkType.NONE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L22:
            f420534a[NetworkUtils.NetworkType.WIFI.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L30:
            f420534a[NetworkUtils.NetworkType.MOBILE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L20:
            f420534a[NetworkUtils.NetworkType.MOBILE_2G.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L24:
            f420534a[NetworkUtils.NetworkType.MOBILE_3G.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L26:
            f420534a[NetworkUtils.NetworkType.MOBILE_4G.ordinal()] = 7;     // Catch: NoSuchFieldError -> L17
            return;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f420535a = null;

        static {
            f420535a = new a();
        }
    }

    public a() {
        this.f420526a = new HashMap();
        this.f420527b = com.ss.android.lark.http.netstate.c.a.f425872a;
        C4956a r100 = new C4956a(this);
        e r101 = e.b.f420544a;
        com.ss.android.lark.sdk.f.a(r101.f420542b, r100, new com.ss.android.lark.download.service.impl.c(r101));
        this.f420528c = Collections.newSetFromMap(new ConcurrentHashMap());
        this.f420530e = Collections.newSetFromMap(new ConcurrentHashMap());
        new j();
    }

    public static boolean a(a r100) {
        Map<String, wbb.a> r101 = r100.f420526a;
        if (r101 != null) goto L5;
    L13:
        return false;
    L5:
        if (((HashMap) r101).size() == 0) goto L13;
        Iterator r102 = ((HashMap) r100.f420526a).values().iterator();
    L9:
        if (r102.hasNext() == false) goto L13;
        if (((wbb.a) r102.next()).f559031b != FileDownloadState.DOWNLOADING) goto L9;
        return true;
    }
}
