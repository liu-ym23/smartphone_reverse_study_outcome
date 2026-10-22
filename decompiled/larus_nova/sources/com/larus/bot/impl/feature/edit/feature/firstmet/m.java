package com.larus.bot.impl.feature.edit.feature.firstmet;

import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public interface m {

    public static final class a implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f319184a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final SpeakerVoice f319185b;

        public a(String r100, SpeakerVoice r101) {
            Intrinsics.checkNotNullParameter(r100, "text");
            Intrinsics.checkNotNullParameter(r101, "speakerVoice");
            this.f319184a = r100;
            this.f319185b = r101;
        }
    }

    public static final class b implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f319186a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f319187b;

        public /* synthetic */ b() {
            throw null;
        }

        public b(String r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "prologue");
            this.f319186a = r100;
            this.f319187b = r101;
        }
    }

    public static final class c implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f319188a;

        public c() {
            this.f319188a = R.string.larus_create_bot_settings_sound_popup_error_msg;
        }
    }

    public static final class d implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f319189a = null;

        static {
            f319189a = new d();
        }

        public d() {
        }
    }

    public static final class e implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f319190a = null;

        static {
            f319190a = new e();
        }

        public e() {
        }
    }
}
