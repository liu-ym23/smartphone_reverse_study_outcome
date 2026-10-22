package mh;

import cj.b;
import com.bytedance.android.ec.sdk.ECSdk;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f513819a = 0;

    @JvmStatic
    public static final void a() {
        int r100 = ECSdk.f48106a;
        b r101 = (b) ECSdk.a(b.class);
        if (r101 == null) goto L6;
        r101.closeAnimDelay();
        return;
    }

    @JvmStatic
    public static final void b() {
        int r100 = ECSdk.f48106a;
        b r101 = (b) ECSdk.a(b.class);
        if (r101 == null) goto L6;
        r101.openAnimDelay();
        return;
    }

    static {
    }
}
