package erc;

import com.bytedance.android.bytehook.ByteHook;
import com.bytedance.shadowhook.ShadowHook;

/* JADX INFO: loaded from: classes5.dex */
public final class a {
    public static void a() {
        ByteHook.access$000();
        int r100 = ByteHook.access$100();
        ByteHook.access$200();
        ShadowHook.Mode r101 = ByteHook.access$300();
        ByteHook.b r102 = new ByteHook.b();
        r102.f42509a = r100;
        r102.f42510b = false;
        r102.f42511c = false;
        r102.f42512d = r101;
        r102.f42513e = false;
        r102.f42514f = false;
        ByteHook.init(r102);
    }

    public static void b() {
        ShadowHook.access$000();
        int r100 = ShadowHook.access$100();
        ShadowHook.b r101 = new ShadowHook.b();
        r101.f270294a = r100;
        r101.f270295b = false;
        r101.f270296c = false;
        r101.f270297d = false;
        ShadowHook.init(r101);
    }
}
