package com.larus.business.debug.base.audio.module;

import android.os.Handler;
import com.bytedance.keva.Keva;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.platform.service.z2;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class ASRModule implements m58.n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ASRModule$itemMap$1 f319978a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f319979b;

    @Override // m58.n
    public final int b() {
        int r100 = d.f320004a;
        if (f.f320006b == true) goto L6;
        return 0;
    L6:
        return f.a().getInt("keva_asr_mock_sami_core_force_count", -1);
    }

    public final boolean c() {
        int r100 = d.f320004a;
        if (f.f320006b == true) goto L6;
        return z2.f365865a.l0();
    L6:
        return f.a().getBoolean("keva_rtc_use_sami_processor", true);
    }

    public final long e() {
        int r100 = d.f320004a;
        if (f.f320006b == true) goto L6;
        return 0;
    L6:
        return f.a().getLong("keva_asr_end_force_delay", 0);
    }

    public final long f() {
        int r100 = d.f320004a;
        if (f.f320006b == true) goto L6;
        return 0;
    L6:
        return f.a().getLong("keva_asr_mock_sami_core_force_delay", 0);
    }

    public final int g() {
        int r100 = d.f320004a;
        if (f.f320006b == true) goto L6;
        return 0;
    L6:
        return f.a().getInt("keva_asr_mock_sami_core_error_type", 0);
    }

    public final long h() {
        int r100 = d.f320004a;
        if (f.f320006b == true) goto L6;
        return 0;
    L6:
        return f.a().getLong("keva_asr_stream_force_delay", 0);
    }

    public final long i() {
        int r100 = d.f320004a;
        if (f.f320006b == true) goto L6;
        return 0;
    L6:
        return f.a().getLong("keva_init_audio_task_force_delay", 0);
    }

    public final Boolean j() {
        boolean r100 = c78.a.f22657a;
        Keva r101 = c78.a.f22663g;
        if (r101.contains("key_enable_main_bot_mmt") == true) goto L7;
        return null;
    L7:
        return Boolean.valueOf(r101.getBoolean("key_enable_main_bot_mmt", true));
    }

    public final int k() {
        int r100 = d.f320004a;
        if (f.f320006b == true) goto L6;
        return 0;
    L6:
        return f.a().getInt("keva_realtime_call_hangup_time_interval", 0);
    }

    public final Boolean l() {
        boolean r100 = c78.a.f22657a;
        Keva r101 = c78.a.f22663g;
        if (r101.contains("key_enable_ugc_bot_mmt") == true) goto L7;
        return null;
    L7:
        return Boolean.valueOf(r101.getBoolean("key_enable_ugc_bot_mmt", true));
    }

    public final boolean m() {
        int r100 = d.f320004a;
        if (f.f320006b == true) goto L6;
        return false;
    L6:
        return f.a().getBoolean("keva_asr_mock_sami_core_open", false);
    }

    public final boolean n() {
        int r100 = d.f320004a;
        if (f.f320006b == true) goto L6;
        return false;
    L6:
        return f.a().getBoolean("keva_asr_stream_force_open", false);
    }

    public final boolean o() {
        int r100 = d.f320004a;
        if (f.f320006b == true) goto L6;
        return false;
    L6:
        return f.a().getBoolean("keva_asr_stream_tag_open", false);
    }

    public final int p() {
        int r100 = d.f320004a;
        if (f.f320006b == true) goto L6;
        return -1;
    L6:
        return f.a().getInt("keva_rtc_token_expire", -1);
    }

    public final boolean q() {
        int r100 = d.f320004a;
        boolean r101 = true;
        if (f.f320006b == false) goto L5;
        Keva r102 = f.a();
        if (d.a() == true) goto L13;
    L15:
        r101 = false;
    L17:
        return r102.getBoolean("keva_rtc_new_conn_impl_v2", r101);
    L13:
        if (z2.f365865a.c() == false) goto L15;
    L5:
        if (d.a() == true) goto L7;
    L9:
        return false;
    L7:
        if (z2.f365865a.c() == false) goto L9;
        return true;
    }

    public ASRModule() {
        this.f319978a = new ASRModule$itemMap$1();
        StringBuilder r100 = new StringBuilder();
        boolean r101 = AudioDebugUtil.f319980a;
        r100.append(AudioDebugUtil.f319981b);
        r100.append(File.separator);
        r100.append("asr_info.log");
        this.f319979b = r100.toString();
    }

    @Override // m58.n
    public final void a(int r100) {
        int r101 = d.f320004a;
        f.a().storeInt("keva_asr_mock_sami_core_force_count", r100);
    }

    public final a68.a d(String r100) {
        Intrinsics.checkNotNullParameter(r100, RemoteMessageConst.MSGID);
        return (a68.a) this.f319978a.get(r100);
    }

    public final void r(final String r100, final byte[] r101, final y58.a r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r102 != null) goto L6;
        return;
    L6:
        boolean r103 = AudioDebugUtil.f319980a;
        Handler r104 = AudioDebugUtil.f319991l;
        if (r104 == null) goto L10;
        r104.post(new b(this, r100, r102, r101));
        return;
    }
}
