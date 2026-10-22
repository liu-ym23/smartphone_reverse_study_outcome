package com.larus.bot.impl.feature.edit;

import com.larus.bot.impl.bean.ContentType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public interface e0 {

    public static final class a implements e0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f318356a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ContentType f318357b;

        public a(boolean r100, ContentType r101) {
            Intrinsics.checkNotNullParameter(r101, "type");
            this.f318356a = r100;
            this.f318357b = r101;
        }
    }

    public static final class b implements e0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final wu8.c f318358a;

        public b(wu8.c r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
            this.f318358a = r100;
        }
    }

    public static final class c implements e0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f318359a = null;

        static {
            f318359a = new c();
        }

        public c() {
        }
    }
}
