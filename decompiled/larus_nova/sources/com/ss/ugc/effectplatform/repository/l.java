package com.ss.ugc.effectplatform.repository;

import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.listener.IEffectPlatformBaseListener;
import com.ss.ugc.effectplatform.model.ExceptionResult;
import com.ss.ugc.effectplatform.task.WriteUpdateTagTask;
import com.ss.ugc.effectplatform.task.q1;
import com.ss.ugc.effectplatform.util.u;

/* JADX INFO: loaded from: classes36.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a0.b<z.b<String, String>> f457512a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final EffectConfig f457513b;

    public static abstract class a implements IEffectPlatformBaseListener<String> {
        public a() {
        }
    }

    public static final class b extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ hlc.f f457514a;

        public b(hlc.f r100) {
            this.f457514a = r100;
        }

        @Override // com.ss.ugc.effectplatform.listener.IEffectPlatformBaseListener
        public final void onSuccess(String r100) {
            hlc.f r101 = this.f457514a;
            if (r101 == null) goto L6;
            r101.onFinally();
            return;
        }

        @Override // com.ss.ugc.effectplatform.listener.IEffectPlatformBaseListener
        public final /* bridge */ /* synthetic */ void onFail(String r100, ExceptionResult r101) {
        }
    }

    public l(EffectConfig r100) {
        this.f457513b = r100;
        this.f457512a = new a0.b(null);
    }

    public final void a(String r100, String r101, IEffectPlatformBaseListener<Boolean> r110) {
        if (this.f457512a.f1239a != null) goto L6;
        if (r110 == null) goto L6;
        r110.onSuccess(Boolean.TRUE);
    L6:
        z.b<String, String> r102 = this.f457512a.f1239a;
        if (r102 != null) goto L9;
        return;
    L9:
        if (r102.containsKey(r100) == false) goto L36;
        int r103 = u.f458049a;
        boolean r104 = true;
        long r105 = -1;
        if (r101 != null) goto L13;
    L20:
        long r106 = -1;
    L21:
        String r107 = r102.get(r100);
        if (r107 == null) goto L31;
        if (r107.length() == 0) goto L27;
        r104 = false;
    L27:
        if (r104 == true) goto L31;
        r105 = CastLongProtector.parseLong(r107);     // Catch: Exception -> L39
    L31:
        if (r106 <= r105) goto L34;
        if (r110 == null) goto L46;
        r110.onSuccess(Boolean.TRUE);
        return;
    L46:
        return;
    L34:
        if (r110 == null) goto L48;
        r110.onSuccess(Boolean.FALSE);
        return;
    L48:
        return;
    L13:
        if (r101.length() != 0) goto L15;
        boolean r108 = true;
    L16:
        if (r108 == true) goto L20;
        r106 = CastLongProtector.parseLong(r101);     // Catch: Exception -> L40
    L15:
        r108 = false;
        goto L16
    L36:
        if (r110 == null) goto L50;
        r110.onSuccess(Boolean.TRUE);
        return;
    }

    public final void b(String r100, String r101, String r102, hlc.f r103) {
        if (this.f457512a.f1239a != null) goto L6;
        if (r103 == null) goto L6;
        r103.onFinally();
    L6:
        z.b<String, String> r104 = this.f457512a.f1239a;
        if (r104 == null) goto L12;
        r104.put(r101, r102);
        b r105 = new b(r103);
        this.f457513b.N.b(r100, r105);
        EffectConfig r106 = this.f457513b;
        WriteUpdateTagTask r107 = new WriteUpdateTagTask(r106, r100, r104);
        q1 r108 = r106.D;
        if (r108 == null) goto L13;
        r108.a(r107);
        return;
    L13:
        return;
    }
}
