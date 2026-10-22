package i57;

import android.content.Context;
import com.bytedance.android.scope.j;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes21.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f488319a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f f488320b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final f f488321c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final f f488322d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final f f488323e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final e f488324f = null;

    static {
        f488319a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(e.class, "HYBRID_COMPONENT", "getHYBRID_COMPONENT()Lcom/bytedance/platform/aio/context/AioCallContext$Key;", 0)), Reflection.property1(new PropertyReference1Impl(e.class, "ANDROID_CONTEXT", "getANDROID_CONTEXT()Lcom/bytedance/platform/aio/context/AioCallContext$Key;", 0)), Reflection.property1(new PropertyReference1Impl(e.class, "PREFERRED_CONTENT_TYPE", "getPREFERRED_CONTENT_TYPE()Lcom/bytedance/platform/aio/context/AioCallContext$Key;", 0)), Reflection.property1(new PropertyReference1Impl(e.class, "CURRENT_SCOPE", "getCURRENT_SCOPE()Lcom/bytedance/platform/aio/context/AioCallContext$Key;", 0))};
        f488324f = new e();
        f r100 = f.f488325a;
        f488320b = r100;
        f488321c = r100;
        f488322d = r100;
        f488323e = r100;
    }

    public e() {
    }

    public final a.C6231a<Context> a() {
        return (a.C6231a) f488321c.getValue(this, f488319a[1]);
    }

    public final a.C6231a<j> b() {
        return (a.C6231a) f488323e.getValue(this, f488319a[3]);
    }
}
