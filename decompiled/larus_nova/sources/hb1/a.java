package hb1;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.soloktv.permission.BaseCheckException;
import com.bytedance.bpea.cert.token.TokenCert;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class a implements i<rh0.a>, k<rh0.a> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final TokenCert f484458d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public k<rh0.a> f484459a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f484460b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i<rh0.a> f484461c;

    /* JADX INFO: renamed from: hb1.a$a, reason: collision with other inner class name */
    public static final class C6121a {
    }

    static {
        f484458d = TokenCert.Companion.with("bpea-androidpermissionchecker_request_permission");
    }

    public final void d() {
        if (vm2.e.o() == true) goto L5;
    L20:
        k<rh0.a> r100 = this.f484459a;
        if (r100 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("consumer");
    L23:
        r100.c();
        return;
    L5:
        if (Build.VERSION.SDK_INT < 31) goto L20;
        com.bytedance.android.livesdk.sharedpref.e<Boolean> r101 = com.bytedance.android.livesdk.sharedpref.c.f158290o;
        if (r101.getValue().booleanValue() == true) goto L20;
        TokenCert r102 = f484458d;
        Activity r103 = ContextUtil.contextToActivity(this.f484460b);
        if (r103 == null) goto L15;
        SettingKey<Boolean> r104 = m60.i.f512260a;
        m60.i.b r105 = new m60.i.b(r103);
        r105.f512265d = new b(r103, r102);
        c r106 = new c(this, r102);
        d r107 = new d(this, r102);
        ArrayList r108 = new ArrayList();
        r108.add("android.permission.BLUETOOTH_CONNECT");
        Object[] r109 = r108.toArray(new String[0]);
        if (r109 == null) goto L14;
        String[] r110 = (String[]) r109;
        r105.b(r106, r107, r102, (String[]) Arrays.copyOf(r110, r110.length));
    L19:
        com.bytedance.android.livesdk.sharedpref.f.d(r101, Boolean.TRUE);
        return;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L15:
        k<rh0.a> r111 = this.f484459a;
        if (r111 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("consumer");
    L18:
        r111.c();
        goto L19
    }

    @Override // hb1.k
    public final /* bridge */ /* synthetic */ void c() {
        d();
    }

    public final Context getContext() {
        return this.f484460b;
    }

    @Override // hb1.i
    public final void a(k<rh0.a> r100) {
        Intrinsics.checkNotNullParameter(r100, "consumer");
        this.f484459a = r100;
        i<rh0.a> r101 = this.f484461c;
        if (r101 == null) goto L5;
        r101.a(this);
        return;
    L5:
        d();
    }

    @Override // hb1.k
    public final void b(BaseCheckException r100) {
        Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_EXCEPTION);
        k<rh0.a> r101 = this.f484459a;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("consumer");
    L5:
        r101.b(r100);
    }

    public a(Context r100, i<rh0.a> r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f484460b = r100;
        this.f484461c = r101;
    }
}
