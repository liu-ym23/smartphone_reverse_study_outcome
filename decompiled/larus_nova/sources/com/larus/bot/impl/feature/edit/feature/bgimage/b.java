package com.larus.bot.impl.feature.edit.feature.bgimage;

import com.larus.bot.impl.bean.BotAvatarIconData;
import com.larus.bot.impl.common.propertyconfig.TextRes;
import com.larus.im.bean.bot.BgImage;
import com.larus.im.bean.bot.BgImageInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public interface b {

    public static final class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f318931a = null;

        static {
            f318931a = new a();
        }

        public a() {
        }
    }

    /* JADX INFO: renamed from: com.larus.bot.impl.feature.edit.feature.bgimage.b$b, reason: collision with other inner class name */
    public static final class C4133b implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final BotAvatarIconData f318932a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final BgImageInfo f318933b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f318934c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f318935d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f318936e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f318937f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final String f318938g;

        public C4133b(BotAvatarIconData r100, BgImageInfo r101, String r102, String r103, String r104, String r105) {
            this.f318932a = r100;
            this.f318933b = r101;
            this.f318934c = r102;
            this.f318935d = r103;
            this.f318936e = r104;
            this.f318937f = r105;
            this.f318938g = "click_ai_button";
        }
    }

    public static final class c implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f318939a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f318940b;

        public c(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "userBotGender");
            this.f318939a = r100;
            this.f318940b = r101;
        }
    }

    public static final class d implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final BotAvatarIconData f318941a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final BgImage f318942b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f318943c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f318944d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f318945e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f318946f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final String f318947g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final String f318948h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final Boolean f318949i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final String f318950j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final boolean f318951k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final String f318952l;

        public d(BotAvatarIconData r100, BgImage r101, String r102, String r103, String r104, String r105, String r106, String r107, Boolean r110, String r111, boolean r112, String r113) {
            Intrinsics.checkNotNullParameter(r100, "avatarInfo");
            this.f318941a = r100;
            this.f318942b = r101;
            this.f318943c = r102;
            this.f318944d = r103;
            this.f318945e = r104;
            this.f318946f = r105;
            this.f318947g = r106;
            this.f318948h = r107;
            this.f318949i = r110;
            this.f318950j = r111;
            this.f318951k = r112;
            this.f318952l = r113;
        }
    }

    public static final class e implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f318953a;

        public e() {
            this.f318953a = null;
        }
    }

    public static final class f implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f318954a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final BotAvatarIconData f318955b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final BgImageInfo f318956c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f318957d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f318958e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f318959f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final String f318960g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final String f318961h;

        public f(boolean r100, BotAvatarIconData r101, BgImageInfo r102, String r103, String r104, String r105, String r106, String r107) {
            this.f318954a = r100;
            this.f318955b = r101;
            this.f318956c = r102;
            this.f318957d = r103;
            this.f318958e = r104;
            this.f318959f = r105;
            this.f318960g = r106;
            this.f318961h = r107;
        }
    }

    public static final class g implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f318962a = null;

        static {
            f318962a = new g();
        }

        public g() {
        }
    }

    public static final class h implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextRes f318963a;

        public h(TextRes r100) {
            Intrinsics.checkNotNullParameter(r100, "text");
            this.f318963a = r100;
        }
    }
}
