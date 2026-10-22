package com.larus.bot.impl.feature.edit.feature.firstmet;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import com.larus.audio.audiov3.tts.PlayStateEnum;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public interface l {

    public static final class a implements l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f319176a = null;

        static {
            f319176a = new a();
        }

        public a() {
        }
    }

    public static final class b implements l {
        public b(Bundle r100) {
        }
    }

    public static final class c implements l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Lifecycle.Event f319177a;

        public c(Lifecycle.Event r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            this.f319177a = r100;
        }
    }

    public static final class d implements l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final PlayStateEnum f319178a;

        public d(PlayStateEnum r100) {
            this.f319178a = r100;
        }
    }

    public static final class e implements l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f319179a;

        public e(String r100) {
            Intrinsics.checkNotNullParameter(r100, "text");
            this.f319179a = r100;
        }
    }

    public static final class f implements l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Boolean f319180a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Triple<String, String, String> f319181b;

        public f(Boolean r100, Triple<String, String, String> r101) {
            this.f319180a = r100;
            this.f319181b = r101;
        }
    }

    public static final class g implements l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f319182a;

        public g() {
            this.f319182a = true;
        }
    }

    public static final class h implements l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h f319183a = null;

        static {
            f319183a = new h();
        }

        public h() {
        }
    }
}
