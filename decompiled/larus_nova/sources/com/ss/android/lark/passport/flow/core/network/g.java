package com.ss.android.lark.passport.flow.core.network;

import com.bytedance.lark.rustclient.api.l;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes37.dex */
public final class g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Regex f437768b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f437769a;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f437770a = null;

        static {
            int[] r100 = new int[PassportHttpMethod.values().length];
            r100[PassportHttpMethod.GET.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L21:
            r100[PassportHttpMethod.POST.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L31:
            r100[PassportHttpMethod.DELETE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L23:
            r100[PassportHttpMethod.PUT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L25:
            r100[PassportHttpMethod.PATCH.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L19:
            r100[PassportHttpMethod.HEAD.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L27:
            r100[PassportHttpMethod.OPTIONS.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L10:
            f437770a = r100;
        }
    }

    static {
        f437768b = new Regex("^[!#$%&'*+.^_`|~0-9A-Za-z-]+$");
    }

    public g(l r100) {
        Intrinsics.checkNotNullParameter(r100, "rustClient");
        this.f437769a = r100;
    }
}
