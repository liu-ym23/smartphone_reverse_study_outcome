package com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.select;

import android.os.Bundle;
import com.larus.bot.impl.bean.BotAvatarIconData;
import com.larus.bot.impl.common.propertyconfig.TextRes;
import com.larus.im.bean.bot.BgImage;
import com.larus.im.bean.bot.BotModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public interface k {

    public static final class a implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Bundle f318816a;

        public a(Bundle r100) {
            Intrinsics.checkNotNullParameter(r100, "bundle");
            this.f318816a = r100;
        }
    }

    public static final class b implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Bundle f318817a;

        public b(Bundle r100) {
            this.f318817a = r100;
        }
    }

    public static final class c implements k {
    }

    public static final class d implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final BotAvatarIconData f318818a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final BgImage f318819b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f318820c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f318821d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f318822e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f318823f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Boolean f318824g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final BotModel f318825h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final String f318826i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final String f318827j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final String f318828k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final String f318829l;

        public d(BotAvatarIconData r100, BgImage r101, String r102, String r103, String r104, String r105, Boolean r106, BotModel r107, String r110, String r111, String r112, String r113) {
            Intrinsics.checkNotNullParameter(r100, "avatarInfo");
            Intrinsics.checkNotNullParameter(r101, "bgImage");
            this.f318818a = r100;
            this.f318819b = r101;
            this.f318820c = r102;
            this.f318821d = r103;
            this.f318822e = r104;
            this.f318823f = r105;
            this.f318824g = r106;
            this.f318825h = r107;
            this.f318826i = r110;
            this.f318827j = r111;
            this.f318828k = r112;
            this.f318829l = r113;
        }
    }

    public static final class e implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final BgSelectViewHolder.a f318830a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f318831b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f318832c;

        public e(BgSelectViewHolder.a r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "bgSelectItemData");
            this.f318830a = r100;
            this.f318831b = r101;
            this.f318832c = r102;
        }
    }

    public static final class f implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f318833a;

        public f() {
            this.f318833a = false;
        }
    }

    public static final class g implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextRes f318834a;

        public g(TextRes r100) {
            Intrinsics.checkNotNullParameter(r100, "msg");
            this.f318834a = r100;
        }
    }
}
