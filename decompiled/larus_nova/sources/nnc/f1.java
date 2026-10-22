package nnc;

import android.app.Activity;
import android.os.Bundle;
import androidx.navigation.NavGraphBuilder;
import com.ss.android.lark.cameraview.VECameraActivity;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes40.dex */
public final class f1 implements com.suite.lark.component.navroute.activity.a<Bundle> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f1 f519751a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final KClass<Bundle> f519752b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final KClass<? extends Activity> f519753c = null;

    public f1() {
    }

    @Override // com.suite.lark.component.navroute.api.b
    public final String getRoute() {
        return "record.ve";
    }

    static {
        f519751a = new f1();
        f519752b = Reflection.getOrCreateKotlinClass(Bundle.class);
        f519753c = Reflection.getOrCreateKotlinClass(VECameraActivity.class);
    }

    @Override // com.suite.lark.component.navroute.activity.a
    public final KClass<? extends Activity> b() {
        return f519753c;
    }

    @Override // com.suite.lark.component.navroute.api.b
    public final <D extends com.suite.lark.component.navroute.api.b<?>> void c(NavGraphBuilder r100, D r101) {
        com.suite.lark.component.navroute.activity.a.C5521a.a(r100, r101);
    }
}
