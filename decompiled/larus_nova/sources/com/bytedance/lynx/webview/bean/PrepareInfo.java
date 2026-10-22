package com.bytedance.lynx.webview.bean;

import android.text.TextUtils;
import com.bytedance.lynx.webview.internal.TTWebContext;
import com.bytedance.lynx.webview.internal.c0;
import com.bytedance.lynx.webview.util.CoreLifeCycle;
import f17.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import r27.a;

/* JADX INFO: loaded from: classes21.dex */
public final class PrepareInfo extends b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f265076c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f265077d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f265078e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f265079f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Source f265080g;

    public static final enum Source extends Enum<Source> {
        public static final Source ASSET_DEBUG = null;
        public static final Source BUILTIN = null;
        public static final Source DEBUG_PAGE = null;
        public static final Source SETTING = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Source[] f265081a = null;

        static {
            Source r100 = new Source("SETTING", 0);
            SETTING = r100;
            Source r101 = new Source("BUILTIN", 1);
            BUILTIN = r101;
            Source r102 = new Source("ASSET_DEBUG", 2);
            ASSET_DEBUG = r102;
            Source r103 = new Source("DEBUG_PAGE", 3);
            DEBUG_PAGE = r103;
            f265081a = new Source[]{r100, r101, r102, r103};
        }

        public static Source[] values() {
            return (Source[]) f265081a.clone();
        }

        public static Source valueOf(String r100) {
            return (Source) a.a(Source.class, r100);
        }

        public Source(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Override // f17.b
    public final String toString() {
        return "PrepareInfo{mSourceUrl='" + this.f265076c + "', mHostAbi='" + this.f265077d + "', mSignature='" + this.f265078e + "', mDelayMs=" + this.f265079f + ", mSource=" + this.f265080g + ", mCoreMd5=" + this.f475075b + ", mCoreVersino=" + this.f475074a + '}';
    }

    public PrepareInfo(String r100, String r101, Source r102, String r103, String r104, String r105, long r106) {
        super(r100, r101);
        this.f265080g = r102;
        this.f265076c = r103;
        this.f265078e = r104;
        this.f265077d = r105;
        this.f265079f = r106;
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        if (b() == true) goto L36;
        c0 r107 = TTWebContext.h().p();
        r107.getClass();
        String r108 = "effect_begin_time_" + r100;
        if (r107.f265273b.contains(r108) == true) goto L21;
        Map<String, ?> r109 = r107.f265273b.getAll();
        ArrayList r110 = new ArrayList(6);
        Iterator<Map.Entry<String, ?>> r111 = r109.entrySet().iterator();
    L10:
        if (r111.hasNext() == false) goto L16;
        String r112 = r111.next().getKey();
        if (r112 == null) goto L10;
        if (r112.startsWith("effect_begin_time_") == false) goto L10;
        r110.add(r112);
        goto L10
    L16:
        Iterator r113 = r110.iterator();
    L18:
        if (r113.hasNext() == false) goto L20;
        r107.f265273b.edit().remove((String) r113.next());
        goto L18
    L20:
        r107.f265273b.edit().apply();
        r107.f265273b.edit().putLong(r108, System.currentTimeMillis()).apply();
    L21:
        CoreLifeCycle.Phase r114 = CoreLifeCycle.Phase.PREPARE;
        Long r115 = Long.valueOf(System.currentTimeMillis());
        CoreLifeCycle.f265439b = r100;
        CoreLifeCycle.f265438a.put("setting_info", r115);     // Catch: JSONException -> L24
        return;
    L37:
        return;
    }
}
