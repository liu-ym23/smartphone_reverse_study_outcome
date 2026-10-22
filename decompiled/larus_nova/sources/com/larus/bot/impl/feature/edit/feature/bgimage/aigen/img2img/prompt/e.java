package com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.prompt;

import com.larus.bot.impl.common.propertyconfig.TextRes;
import com.ss.android.cert.manager.constants.EventConstant;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public interface e {

    public static final class a implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f318737a;

        public a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "text");
            this.f318737a = r100;
        }
    }

    public static final class b implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f318738a;

        public b(String r100) {
            Intrinsics.checkNotNullParameter(r100, EventConstant.Key.RETAIN_PROMPT);
            this.f318738a = r100;
        }
    }

    public static final class c implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextRes f318739a;

        public c(TextRes r100) {
            Intrinsics.checkNotNullParameter(r100, "testRes");
            this.f318739a = r100;
        }
    }
}
