package com.larus.bot.impl.feature.edit.feature.avatar;

import com.larus.bot.impl.common.propertyconfig.TextRes;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public interface b {

    public static final class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f318512a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f318513b;

        public a(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "avatarUrl");
            this.f318512a = r100;
            this.f318513b = r101;
        }
    }

    /* JADX INFO: renamed from: com.larus.bot.impl.feature.edit.feature.avatar.b$b, reason: collision with other inner class name */
    public static final class C4125b implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f318514a;

        public C4125b(String r100) {
            this.f318514a = r100;
        }
    }

    public static final class c implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f318515a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f318516b;

        public c(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "clickFrom");
            this.f318515a = r100;
            this.f318516b = r101;
        }
    }

    public static final class d implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextRes f318517a;

        public d(TextRes r100) {
            Intrinsics.checkNotNullParameter(r100, "testRes");
            this.f318517a = r100;
        }
    }
}
