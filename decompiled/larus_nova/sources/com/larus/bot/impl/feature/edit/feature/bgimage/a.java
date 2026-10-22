package com.larus.bot.impl.feature.edit.feature.bgimage;

import android.content.Intent;
import android.os.Bundle;
import com.larus.bot.impl.bean.BotAvatarIconData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public interface a {

    /* JADX INFO: renamed from: com.larus.bot.impl.feature.edit.feature.bgimage.a$a, reason: collision with other inner class name */
    public static final class C4126a implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Bundle f318616a;

        public C4126a(Bundle r100) {
            Intrinsics.checkNotNullParameter(r100, "bundle");
            this.f318616a = r100;
        }
    }

    public static final class b implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Bundle f318617a;

        public b(Bundle r100) {
            this.f318617a = r100;
        }
    }

    public static final class c implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final BotAvatarIconData f318618a;

        public c(BotAvatarIconData r100) {
            this.f318618a = r100;
        }
    }

    public static final class d implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f318619a = null;

        static {
            f318619a = new d();
        }

        public d() {
        }
    }

    public static final class e implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f318620a;

        public e(String r100) {
            Intrinsics.checkNotNullParameter(r100, "enterMethod");
            this.f318620a = r100;
        }
    }

    public static final class f implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f318621a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Intent f318622b;

        public f(boolean r100, Intent r101) {
            this.f318621a = r100;
            this.f318622b = r101;
        }
    }

    public static final class g implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f318623a;

        public g(boolean r100) {
            this.f318623a = r100;
        }
    }
}
