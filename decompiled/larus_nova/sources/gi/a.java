package gi;

import com.bytedance.android.ec.diff.lib.di.ToCServiceModule_ProvideFactory;
import com.bytedance.android.ec.diff.lib.di.ToCServiceModule_ProvideTuringFactory;
import dagger.internal.DoubleCheck;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static fi.b f481329a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static hi.a f481330b;

    static {
        c r100 = new c();
        Provider r101 = DoubleCheck.provider(ToCServiceModule_ProvideFactory.create(r100));
        Provider r102 = DoubleCheck.provider(ToCServiceModule_ProvideTuringFactory.create(r100));
        fi.b r103 = (fi.b) r101.get();
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        f481329a = r103;
        hi.a r104 = (hi.a) r102.get();
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        f481330b = r104;
    }
}
