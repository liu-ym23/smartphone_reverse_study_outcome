package com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img;

import android.net.Uri;
import android.os.Bundle;
import com.larus.bot.impl.common.propertyconfig.TextRes;
import com.larus.im.bean.bot.BgImageInfo;
import com.larus.im.bean.bot.BotModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public interface c {

    public static final class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f318652a = null;

        static {
            f318652a = new a();
        }

        public a() {
        }
    }

    public static final class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Bundle f318653a;

        public b(Bundle r100) {
            this.f318653a = r100;
        }
    }

    /* JADX INFO: renamed from: com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.c$c, reason: collision with other inner class name */
    public static final class C4128c implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final BgImageInfo f318654a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f318655b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f318656c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f318657d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f318658e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Boolean f318659f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final BotModel f318660g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final String f318661h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final String f318662i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final Boolean f318663j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final String f318664k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final String f318665l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final String f318666m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final boolean f318667n;

        public C4128c(BgImageInfo r100, String r101, String r102, String r103, String r104, Boolean r105, BotModel r106, String r107, String r108, Boolean r110, String r111, String r112, String r113, boolean r114) {
            this.f318654a = r100;
            this.f318655b = r101;
            this.f318656c = r102;
            this.f318657d = r103;
            this.f318658e = r104;
            this.f318659f = r105;
            this.f318660g = r106;
            this.f318661h = r107;
            this.f318662i = r108;
            this.f318663j = r110;
            this.f318664k = r111;
            this.f318665l = r112;
            this.f318666m = r113;
            this.f318667n = r114;
        }
    }

    public static final class d implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f318668a;

        public d(boolean r100) {
            this.f318668a = r100;
        }
    }

    public static final class e implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Uri f318669a;

        public e(Uri r100) {
            this.f318669a = r100;
        }
    }

    public static final class f implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f318670a = null;

        static {
            f318670a = new f();
        }

        public f() {
        }
    }

    public static final class g implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextRes f318671a;

        public g(TextRes r100) {
            Intrinsics.checkNotNullParameter(r100, "testRes");
            this.f318671a = r100;
        }
    }

    public static final class h implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextRes f318672a;

        public h(TextRes.StringResId r100) {
            Intrinsics.checkNotNullParameter(r100, "testRes");
            this.f318672a = r100;
        }
    }
}
