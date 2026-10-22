package sr9;

import com.larus.im.bean.bot.SpeakerVoice;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class i implements com.larus.bmhome.setting.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f543245a = null;

    static {
        f543245a = new i();
    }

    public i() {
    }

    @Override // com.larus.bmhome.setting.b
    public final void a(String r100, SpeakerVoice r101, String r102) {
    }

    @Override // com.larus.bmhome.setting.b
    public final void b(int r100, long r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r102, "botId");
        Intrinsics.checkNotNullParameter(r103, "errTips");
    }

    @Override // com.larus.bmhome.setting.b
    public final void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "toLanguage");
    }

    @Override // com.larus.bmhome.setting.b
    public final void d() {
    }

    @Override // com.larus.bmhome.setting.b
    public final void e() {
    }

    @Override // com.larus.bmhome.setting.b
    public final void f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "editMethod");
    }
}
