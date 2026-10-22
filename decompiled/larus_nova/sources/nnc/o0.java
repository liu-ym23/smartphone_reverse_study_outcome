package nnc;

import android.app.Activity;
import android.os.Bundle;
import androidx.navigation.NavGraphBuilder;
import com.ss.android.lark.camera.startor.SystemCameraActivity;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes40.dex */
public final class o0 implements com.suite.lark.component.navroute.activity.a<Bundle> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o0 f519811a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final KClass<Bundle> f519812b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final KClass<? extends Activity> f519813c = null;

    public o0() {
    }

    @Override // com.suite.lark.component.navroute.api.b
    public final String getRoute() {
        return "record.system";
    }

    static {
        f519811a = new o0();
        f519812b = Reflection.getOrCreateKotlinClass(Bundle.class);
        f519813c = Reflection.getOrCreateKotlinClass(SystemCameraActivity.class);
    }

    @Override // com.suite.lark.component.navroute.activity.a
    public final KClass<? extends Activity> b() {
        return f519813c;
    }

    @Override // com.suite.lark.component.navroute.api.b
    public final <D extends com.suite.lark.component.navroute.api.b<?>> void c(NavGraphBuilder r100, D r101) {
        com.suite.lark.component.navroute.activity.a.C5521a.a(r100, r101);
    }
}
