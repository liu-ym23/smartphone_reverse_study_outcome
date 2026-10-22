package com.bytedance.awemeopen.apps.framework;

import android.content.Context;
import android.view.View;
import c54.e;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.AosRecomendFeedViewModel;
import com.bytedance.awemeopen.apps.framework.launchconfig.LaunchConfigManager$checkLaunchConfig$1;
import com.bytedance.awemeopen.export.api.AosConfigService;
import com.bytedance.awemeopen.export.api.pagetransition.AosPageTransition;
import com.bytedance.awemeopen.infra.base.settings.AoSettings;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/AosConfigServiceDefaultImpl;", "Lcom/bytedance/awemeopen/export/api/AosConfigService;", "<init>", "()V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public class AosConfigServiceDefaultImpl implements AosConfigService {

    public static final class a implements f54.a {
        public a() {
        }

        public final void a() {
            Intrinsics.checkNotNullParameter("ao_short_video_detail", "tag");
        }

        public final void start() {
        }

        public final void stop() {
        }
    }

    public static final class b implements c54.c {
        public b() {
        }

        public final void a() {
        }

        public final int b() {
            return 5;
        }

        public final void d() {
        }

        public final void showAutoPlaySwitch() {
        }

        public final long timeOnLiveRoom() {
            return 60000;
        }

        public final boolean getAutoPlayState() {
            return z54.a.b("recommend_feed_autoplay_config").getBoolean("state", true);
        }

        public final void c(boolean r3) {
            z54.a.b("recommend_feed_autoplay_config").edit().putBoolean("state", r3).apply();
        }
    }

    public static final class c implements e {
        public c() {
        }

        public final void a() {
        }

        public final void b() {
        }

        public final c54.b c() {
            return new c54.b();
        }
    }

    public final void D0() {
    }

    public final boolean H(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter("com.ss.android.ugc.aweme", "packageName");
        return false;
    }

    public final void H1() {
    }

    public final boolean K0() {
        return true;
    }

    public final View L1(Context r1, String r2, String r3, com.bytedance.awemeopen.apps.framework.feed.layout.layout.c r4, AosConfigService.b r5) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r4, "handleBySdkCallback");
        return null;
    }

    public final boolean P1(Context r1, String r2, JSONObject r3) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "scheme");
        return false;
    }

    public final boolean Q1(Context r1, String r2, boolean r3, Function2<? super Float, ? super Float, Unit> r4) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return false;
    }

    public final boolean Y0() {
        return true;
    }

    public final boolean m0() {
        return true;
    }

    public final void v2() {
    }

    public final void x() {
    }

    public final void z() {
    }

    public final e54.a A() {
        return new e54.a(0);
    }

    public final m54.a J() {
        return new m54.a(0);
    }

    public final f54.a J0() {
        return new a();
    }

    public final AosPageTransition U0() {
        return new AosPageTransition(0, 0, 3, null);
    }

    public final c54.a W1() {
        return new c54.a(0);
    }

    public final e Y() {
        return new c();
    }

    public final z44.a b0() {
        return new z44.a(0);
    }

    public final a54.a getCommentConfig() {
        a54.a r8 = new a54.a(false, false, false, null, false, false, 255);
        JSONObject r0 = AoSettings.a("ao_comment_config");
        if (r0 != null) goto L5;
        return r8;
    L5:
        return new a54.a(r0.optBoolean("allow_comment", r8.a), r0.optBoolean("allow_comment", r8.b), r0.optBoolean("allow_write_comment", r8.c), r0.optString("comment_input_default_text", r8.d), r0.optBoolean("expand_comment_click_area", r8.e), r0.optBoolean("allow_reply_comment", r8.f), r0.optBoolean("enable_digg_bury", r8.g), r0.optBoolean("enable_avatar_click", r8.h));
    }

    public final b54.b l1() {
        return new b54.b(3);
    }

    public final c54.c n1() {
        return new b();
    }

    public final g54.b p2() {
        return new g54.a();
    }

    public final r54.a z0() {
        return new r54.a(0);
    }

    public AosConfigServiceDefaultImpl() {
    }

    public final void P0(LaunchConfigManager$checkLaunchConfig$1 r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        r2.a(new h54.a());
    }

    public final long v(String r3) {
        Intrinsics.checkNotNullParameter(r3, "openId");
        return -1;
    }

    public final void E0(int r2, AosRecomendFeedViewModel.f r3) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        r3.a(null, true);
    }
}
