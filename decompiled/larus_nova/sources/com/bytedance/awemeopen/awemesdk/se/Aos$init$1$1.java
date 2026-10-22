package com.bytedance.awemeopen.awemesdk.se;

import android.app.Activity;
import com.bytedance.awemeopen.bizmodels.user.LoginMethod;
import com.bytedance.awemeopen.bizmodels.user.e;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class Aos$init$1$1 implements e {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f198159a = null;

        static {
            int[] r100 = new int[LoginMethod.values().length];
            r100[LoginMethod.NORMAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[LoginMethod.ONE_KEY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[LoginMethod.SILENT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[LoginMethod.UNKNOWN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f198159a = r100;
        }
    }

    public Aos$init$1$1() {
    }

    @Override // com.bytedance.awemeopen.bizmodels.user.e
    public final /* bridge */ /* synthetic */ void b() {
    }

    @Override // com.bytedance.awemeopen.bizmodels.user.e
    public final Function4<Activity, LoginMethod, String, Map<String, String>, Unit> a() {
        return new Aos$init$1$1$newOnSuccess$1(this);
    }

    @Override // com.bytedance.awemeopen.bizmodels.user.e
    public final Function6<Activity, LoginMethod, String, Map<String, String>, Integer, String, Unit> c() {
        return new Aos$init$1$1$newOnFailed$1(this);
    }

    @Override // com.bytedance.awemeopen.bizmodels.user.e
    public final i04.b d() {
        return new i04.b();
    }

    @Override // com.bytedance.awemeopen.bizmodels.user.e
    public final com.bytedance.awemeopen.awemesdk.se.a e() {
        return new com.bytedance.awemeopen.awemesdk.se.a();
    }

    public static String f(LoginMethod r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r101 = a.f198159a[r100.ordinal()];
        if (r101 != 1) goto L5;
    L14:
        return BdpAppEventConstant.NO;
    L5:
        if (r101 != 2) goto L7;
        return BdpAppEventConstant.YES;
    L7:
        if (r101 == 3) goto L14;
        if (r101 != 4) goto L12;
        return "";
    L12:
        throw new NoWhenBranchMatchedException();
    }
}
