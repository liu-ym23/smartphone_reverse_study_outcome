package com.larus.dora.api;

import com.bytedance.keva.Keva;
import com.larus.bmhome.auth.c1;
import com.larus.bmhome.auth.h0;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.platform.service.e1;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import hq9.z1;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import r27.a;

/* JADX INFO: loaded from: classes4.dex */
public final class DoraConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Keva f331707a = null;

    /* JADX INFO: loaded from: classes27.dex */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/larus/dora/api/DoraConfig$AppeaseType;", "", "type", "", "scene", "", "<init>", "(Ljava/lang/String;IILjava/lang/String;)V", "getType", "()I", "getScene", "()Ljava/lang/String;", "UNKNOW", "VOICE", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum AppeaseType extends Enum<AppeaseType> {
        public static final AppeaseType UNKNOW = null;
        public static final AppeaseType VOICE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ AppeaseType[] f331708a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f331709b = null;
        private final String scene;
        private final int type;

        public static EnumEntries<AppeaseType> getEntries() {
            return f331709b;
        }

        static {
            AppeaseType r100 = new AppeaseType("UNKNOW", 0, 0, "none");
            UNKNOW = r100;
            AppeaseType r101 = new AppeaseType("VOICE", 1, 1, "audio_comfort");
            VOICE = r101;
            AppeaseType[] r102 = {r100, r101};
            f331708a = r102;
            f331709b = EnumEntriesKt.enumEntries(r102);
        }

        public static AppeaseType[] values() {
            return (AppeaseType[]) f331708a.clone();
        }

        public final String getScene() {
            return this.scene;
        }

        public final int getType() {
            return this.type;
        }

        public static AppeaseType valueOf(String r100) {
            return (AppeaseType) a.a(AppeaseType.class, r100);
        }

        public AppeaseType(String r100, int r101, int r102, String r103) {
            super(r100, r101);
            this.type = r102;
            this.scene = r103;
        }
    }

    static {
        f331707a = Keva.getRepo("dora_flow_env", 0);
    }

    public static String a() {
        return f331707a.getString("key_g_bottom_language", "zh");
    }

    public static String b() {
        return f331707a.getString("key_g_top_language", "en");
    }

    public static String c() {
        return f331707a.getString("key_lite_bottom_language", "zh");
    }

    public static String d() {
        return f331707a.getString("key_lite_top_language", "en");
    }

    public static boolean e() {
        IDoraService r100 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r100 == null) goto L9;
        DeviceService r101 = r100.device();
        if (r101 == null) goto L9;
        if (r101.M() != true) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L13;
        return false;
    L13:
        return f331707a.getBoolean("key_dora_sv_enable", true);
    L9:
        r102 = false;
        goto L10
    }

    public static boolean f() {
        return f331707a.getBoolean("key_si_dora_g_conference_enable", false);
    }

    public static String g() {
        if (((z1) e1.f365733a.getValue()).a() == false) goto L18;
        c1<h0> r100 = AuthModelDelegate.f297134b.a().getValue();
        if (r100 == null) goto L19;
        h0 r101 = r100.f295753d;
        if (r101 == null) goto L20;
        String r102 = r101.b();
        if (r102 != null) goto L11;
        return "7234781073513644036";
    L11:
        if ((!StringsKt.isBlank(r102)) == true) goto L14;
        r102 = null;
    L14:
        if (r102 != null) goto L16;
        return "7234781073513644036";
    L16:
        return r102;
    L20:
        return "7234781073513644036";
    L19:
        return "7234781073513644036";
    L18:
        return f331707a.getString("key_dora_main_bot_id", "7234781073513644036");
    }

    public static void h(String r100) {
        Intrinsics.checkNotNullParameter(r100, "src");
        f331707a.storeString("key_g_bottom_language", r100);
    }

    public static void i(String r100) {
        Intrinsics.checkNotNullParameter(r100, "src");
        f331707a.storeString("key_g_top_language", r100);
    }

    public static void j(String r100) {
        Intrinsics.checkNotNullParameter(r100, "src");
        f331707a.storeString("key_lite_bottom_language", r100);
    }

    public static void k(String r100) {
        Intrinsics.checkNotNullParameter(r100, "src");
        f331707a.storeString("key_lite_top_language", r100);
    }
}
