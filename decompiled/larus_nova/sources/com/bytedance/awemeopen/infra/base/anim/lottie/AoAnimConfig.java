package com.bytedance.awemeopen.infra.base.anim.lottie;

import android.animation.Animator;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.awemeopen.servicesapi.ui.AoAnimationServiceConfig;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class AoAnimConfig {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final AoAnimConfig f198557g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ResMode f198558a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f198559b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f198560c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f198561d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f198562e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function1<Throwable, Unit> f198563f;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\u0006\u0010\u0003\u001a\u00020\u0002j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/awemeopen/infra/base/anim/lottie/AoAnimConfig$ResMode;", "", "Lcom/bytedance/awemeopen/servicesapi/ui/AoAnimationServiceConfig$ResMode;", "toServiceMode", "URL", "ASSET", "RAW_RES", "JSON_STREAM", "JSON_STRING", "ZIP_STREAM", "EMPTY", "ao_base_core_release"}, k = 1, mv = {1, 7, 1})
    public static final enum ResMode extends Enum<ResMode> {
        public static final ResMode ASSET = null;
        public static final ResMode EMPTY = null;
        public static final ResMode JSON_STREAM = null;
        public static final ResMode JSON_STRING = null;
        public static final ResMode RAW_RES = null;
        public static final ResMode URL = null;
        public static final ResMode ZIP_STREAM = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ResMode[] f198564a = null;

        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f198565a = null;

            static {
                int[] r100 = new int[ResMode.values().length];
                r100[ResMode.URL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
            L21:
                r100[ResMode.ASSET.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
            L31:
                r100[ResMode.RAW_RES.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
            L23:
                r100[ResMode.JSON_STREAM.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
            L25:
                r100[ResMode.JSON_STRING.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
            L19:
                r100[ResMode.ZIP_STREAM.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
            L27:
                r100[ResMode.EMPTY.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
            L10:
                f198565a = r100;
            }
        }

        public static ResMode valueOf(String r100) {
            return (ResMode) r27.a.a(ResMode.class, r100);
        }

        public static ResMode[] values() {
            return (ResMode[]) f198564a.clone();
        }

        static {
            ResMode r100 = new ResMode("URL", 0);
            URL = r100;
            ResMode r101 = new ResMode("ASSET", 1);
            ASSET = r101;
            ResMode r102 = new ResMode("RAW_RES", 2);
            RAW_RES = r102;
            ResMode r103 = new ResMode("JSON_STREAM", 3);
            JSON_STREAM = r103;
            ResMode r104 = new ResMode("JSON_STRING", 4);
            JSON_STRING = r104;
            ResMode r105 = new ResMode("ZIP_STREAM", 5);
            ZIP_STREAM = r105;
            ResMode r110 = new ResMode("EMPTY", 6);
            EMPTY = r110;
            f198564a = new ResMode[]{r100, r101, r102, r103, r104, r105, r110};
        }

        public final AoAnimationServiceConfig.ResMode toServiceMode() {
            switch(a.f198565a[ordinal()]) {
                case 1: goto L13;
                case 2: goto L19;
                case 3: goto L18;
                case 4: goto L17;
                case 5: goto L16;
                case 6: goto L15;
                case 7: goto L14;
                default: goto L5;
            };
        L5:
            throw new NoWhenBranchMatchedException();
        L14:
            return AoAnimationServiceConfig.ResMode.EMPTY;
        L15:
            return AoAnimationServiceConfig.ResMode.ZIP_STREAM;
        L16:
            return AoAnimationServiceConfig.ResMode.JSON_STRING;
        L17:
            return AoAnimationServiceConfig.ResMode.JSON_STREAM;
        L18:
            return AoAnimationServiceConfig.ResMode.RAW_RES;
        L19:
            return AoAnimationServiceConfig.ResMode.ASSET;
        L13:
            return AoAnimationServiceConfig.ResMode.URL;
        }

        public ResMode(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    public interface b extends Animator.AnimatorListener, Animator.AnimatorPauseListener {

        /* JADX INFO: renamed from: n1, reason: collision with root package name */
        public static final a f198566n1 = null;

        public static final class a implements b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f198567a = null;

            static {
                f198567a = new a();
            }

            public a() {
            }

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationCancel(Animator r100) {
                Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            }

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator r100) {
                Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            }

            @Override // android.animation.Animator.AnimatorPauseListener
            public final void onAnimationPause(Animator r100) {
                Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            }

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationRepeat(Animator r100) {
                Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            }

            @Override // android.animation.Animator.AnimatorPauseListener
            public final void onAnimationResume(Animator r100) {
                Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            }

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator r100) {
                Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            }
        }

        static {
            f198566n1 = a.f198567a;
        }
    }

    public AoAnimConfig() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AoAnimConfig) == true) goto L8;
        return false;
    L8:
        AoAnimConfig r101 = (AoAnimConfig) r100;
        if (this.f198558a == r101.f198558a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f198559b, r101.f198559b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f198560c, r101.f198560c) == true) goto L18;
        return false;
    L18:
        if (this.f198561d == r101.f198561d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f198562e, r101.f198562e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f198563f, r101.f198563f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v6, types: [int] */
    public final int hashCode() {
        int r100 = ((this.f198558a.hashCode() * 31) + this.f198559b.hashCode()) * 31;
        Object r101 = this.f198560c;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (r100 + r102) * 31;
        boolean r104 = this.f198561d;
        ?? r105 = r104;
        if (r104 == false) goto L10;
        r105 = 1;
    L10:
        return ((((r103 + r105) * 31) + this.f198562e.hashCode()) * 31) + this.f198563f.hashCode();
    L5:
        r102 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "AoAnimConfig(resMode=" + this.f198558a + ", res=" + this.f198559b + ", fallbackRes=" + this.f198560c + ", isSync=" + this.f198561d + ", lifecycleListener=" + this.f198562e + ", onError=" + this.f198563f + ')';
    }

    static {
        f198557g = new AoAnimConfig(ResMode.EMPTY, new Object(), null, null, 60);
    }

    public AoAnimConfig(ResMode r100, Object r101, e r102, Function1 r103, int r104) {
        b r105 = r102;
        if ((r104 & 16) == 0) goto L6;
        r105 = b.f198566n1;
    L6:
        if ((r104 & 32) == 0) goto L8;
        r103 = AnonymousClass1.INSTANCE;
    L8:
        Intrinsics.checkNotNullParameter(r100, "resMode");
        Intrinsics.checkNotNullParameter(r101, "res");
        Intrinsics.checkNotNullParameter(r105, "lifecycleListener");
        Intrinsics.checkNotNullParameter(r103, LynxVideoManagerLite.EVENT_ON_ERROR);
        this.f198558a = r100;
        this.f198559b = r101;
        this.f198560c = null;
        this.f198561d = false;
        this.f198562e = r105;
        this.f198563f = r103;
    }
}
