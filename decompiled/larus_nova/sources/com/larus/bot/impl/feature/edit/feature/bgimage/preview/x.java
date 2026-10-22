package com.larus.bot.impl.feature.edit.feature.bgimage.preview;

import com.larus.bot.impl.bean.BotAvatarIconData;
import com.larus.bot.impl.common.propertyconfig.TextRes;
import com.larus.im.bean.bot.BgImage;
import com.larus.im.bean.bot.BgImageInfo;
import com.larus.im.bean.bot.BotModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public interface x {

    public static final class a implements x {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f319039a = null;

        static {
            f319039a = new a();
        }

        public a() {
        }
    }

    public static final class b implements x {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f319040a;

        public b(boolean r100) {
            this.f319040a = r100;
        }
    }

    public static final class c implements x {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final BotAvatarIconData f319041a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final BgImage f319042b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f319043c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f319044d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f319045e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f319046f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Boolean f319047g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final BotModel f319048h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final String f319049i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final String f319050j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final String f319051k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final Boolean f319052l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final String f319053m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final String f319054n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final String f319055o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final String f319056p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final String f319057q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final boolean f319058r;

        public c(BotAvatarIconData r100, BgImage r101, String r102, String r103, String r104, String r105, Boolean r110, BotModel r111, String r112, String r113, String r114, String r115, String r116, String r117, boolean r118) {
            Intrinsics.checkNotNullParameter(r100, "avatarInfo");
            this.f319041a = r100;
            this.f319042b = r101;
            this.f319043c = r102;
            this.f319044d = r103;
            this.f319045e = r104;
            this.f319046f = r105;
            this.f319047g = r110;
            this.f319048h = r111;
            this.f319049i = r112;
            this.f319050j = r113;
            this.f319051k = r114;
            this.f319052l = null;
            this.f319053m = null;
            this.f319054n = null;
            this.f319055o = r115;
            this.f319056p = r116;
            this.f319057q = r117;
            this.f319058r = r118;
        }
    }

    public static final class d implements x {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final BotAvatarIconData f319059a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final BgImageInfo f319060b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f319061c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f319062d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f319063e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f319064f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Boolean f319065g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final BotModel f319066h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final String f319067i;

        public d(BotAvatarIconData r100, BgImageInfo r101, String r102, String r103, String r104, String r105, Boolean r106, BotModel r107, String r108) {
            this.f319059a = r100;
            this.f319060b = r101;
            this.f319061c = r102;
            this.f319062d = r103;
            this.f319063e = r104;
            this.f319064f = r105;
            this.f319065g = r106;
            this.f319066h = r107;
            this.f319067i = r108;
        }
    }

    public static final class e implements x {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f319068a = null;

        static {
            f319068a = new e();
        }

        public e() {
        }
    }

    public static final class f implements x {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextRes f319069a;

        public f(TextRes r100) {
            Intrinsics.checkNotNullParameter(r100, "testRes");
            this.f319069a = r100;
        }
    }
}
