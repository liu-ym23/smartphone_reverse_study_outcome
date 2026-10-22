package hb1;

import android.app.Activity;
import android.content.Context;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.soloktv.permission.BaseCheckException;
import com.bytedance.bpea.cert.token.TokenCert;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class e implements i<rh0.a>, k<rh0.a> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final TokenCert f484468d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public k<rh0.a> f484469a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f484470b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i<rh0.a> f484471c;

    public static final class a {
    }

    static {
        f484468d = TokenCert.Companion.with("bpea-androidpermissionchecker_request_permission");
    }

    public final void d() {
        TokenCert r100 = f484468d;
        Activity r101 = ContextUtil.contextToActivity(this.f484470b);
        if (r101 != null) goto L8;
        k<rh0.a> r102 = this.f484469a;
        if (r102 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("consumer");
    L7:
        r102.b(new BaseCheckException(BaseCheckException.CheckType.AndroidPermission, "context is not Activity"));
        return;
    L8:
        SettingKey<Boolean> r103 = m60.i.f512260a;
        m60.i.b r104 = new m60.i.b(r101);
        r104.f512265d = new f(r101, r100);
        g r105 = new g(this, r100);
        h r106 = new h(this, r100);
        ArrayList r107 = new ArrayList();
        r107.add("android.permission.RECORD_AUDIO");
        Object[] r108 = r107.toArray(new String[0]);
        if (r108 == null) goto L13;
        String[] r109 = (String[]) r108;
        r104.b(r105, r106, r100, (String[]) Arrays.copyOf(r109, r109.length));
        return;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    @Override // hb1.k
    public final /* bridge */ /* synthetic */ void c() {
        d();
    }

    public final Context getContext() {
        return this.f484470b;
    }

    @Override // hb1.i
    public final void a(k<rh0.a> r100) {
        Intrinsics.checkNotNullParameter(r100, "consumer");
        this.f484469a = r100;
        i<rh0.a> r101 = this.f484471c;
        if (r101 == null) goto L5;
        r101.a(this);
        return;
    L5:
        d();
    }

    @Override // hb1.k
    public final void b(BaseCheckException r100) {
        Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_EXCEPTION);
        k<rh0.a> r101 = this.f484469a;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("consumer");
    L5:
        r101.b(r100);
    }

    public e(Context r100, i<rh0.a> r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f484470b = r100;
        this.f484471c = r101;
    }
}
