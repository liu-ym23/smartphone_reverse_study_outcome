package com.larus.bot.impl.feature.edit.feature.bgimage.aigen.text2img;

import com.larus.bot.impl.bean.BotAvatarIconData;
import com.larus.bot.impl.common.propertyconfig.TextRes;
import com.larus.im.bean.bot.BgImage;
import com.larus.im.bean.bot.BotModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public interface b {

    public static final class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f318899a = null;

        static {
            f318899a = new a();
        }

        public a() {
        }
    }

    /* JADX INFO: renamed from: com.larus.bot.impl.feature.edit.feature.bgimage.aigen.text2img.b$b, reason: collision with other inner class name */
    public static final class C4132b implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final BotAvatarIconData f318900a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final BgImage f318901b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f318902c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f318903d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f318904e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f318905f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Boolean f318906g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final BotModel f318907h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final String f318908i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final String f318909j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final boolean f318910k;

        public C4132b(BotAvatarIconData r100, BgImage r101, String r102, String r103, String r104, String r105, Boolean r106, BotModel r107, String r110, String r111, boolean r112) {
            Intrinsics.checkNotNullParameter(r100, "avatarInfo");
            Intrinsics.checkNotNullParameter(r101, "bgImage");
            this.f318900a = r100;
            this.f318901b = r101;
            this.f318902c = r102;
            this.f318903d = r103;
            this.f318904e = r104;
            this.f318905f = r105;
            this.f318906g = r106;
            this.f318907h = r107;
            this.f318908i = r110;
            this.f318909j = r111;
            this.f318910k = r112;
        }
    }

    public static final class c implements b {
    }

    public static final class d implements b {
        public d() {
        }
    }

    public static final class e implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextRes f318911a;

        public e(TextRes.StringResId r100) {
            Intrinsics.checkNotNullParameter(r100, "msg");
            this.f318911a = r100;
        }
    }
}
