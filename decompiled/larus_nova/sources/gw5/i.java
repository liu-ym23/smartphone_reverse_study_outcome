package gw5;

import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.videosend.tools.VideoTools;
import com.ss.ttvideoengine.model.SubInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f483060a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.flow_audio.api.foundation.record.a f483061b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f483062c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f483063d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final h f483064e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final g f483065f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c f483066g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f483067h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final e f483068i;

    public i() {
        this(null, null, null, null, null, null, null, 511);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f483060a, r101.f483060a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f483061b, r101.f483061b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f483062c, r101.f483062c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f483063d, r101.f483063d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f483064e, r101.f483064e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f483065f, r101.f483065f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f483066g, r101.f483066g) == true) goto L30;
        return false;
    L30:
        if (this.f483067h == r101.f483067h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f483068i, r101.f483068i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((((((this.f483060a.hashCode() * 31) + this.f483061b.hashCode()) * 31) + this.f483062c.hashCode()) * 31) + this.f483063d.hashCode()) * 31) + this.f483064e.hashCode()) * 31) + this.f483065f.hashCode()) * 31) + this.f483066g.hashCode()) * 31;
        if (this.f483067h == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = (r100 + r101) * 31;
        e r103 = this.f483068i;
        if (r103 != null) goto L9;
        int r104 = 0;
    L11:
        return r102 + r104;
    L9:
        r104 = r103.hashCode();
        goto L11
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "FlowAudioAsrSessionConfig(recognition=" + this.f483060a + ", format=" + this.f483061b + ", context=" + this.f483062c + ", compress=" + this.f483063d + ", start=" + this.f483064e + ", recording=" + this.f483065f + ", retry=" + this.f483066g + ", enableAudioDataCallback=" + this.f483067h + ", mock=" + this.f483068i + ')';
    }

    public final b getContext() {
        return this.f483062c;
    }

    public static i a(i r110, b r111, g r112, c r113, int r114) {
        e r100 = null;
        if ((r114 & 1) == 0) goto L5;
        f r101 = r110.f483060a;
    L7:
        if ((r114 & 2) == 0) goto L9;
        com.bytedance.flow_audio.api.foundation.record.a r102 = r110.f483061b;
    L11:
        if ((r114 & 4) == 0) goto L13;
        b r103 = r110.f483062c;
    L15:
        if ((r114 & 8) == 0) goto L17;
        a r104 = r110.f483063d;
    L19:
        if ((r114 & 16) == 0) goto L21;
        h r105 = r110.f483064e;
    L23:
        if ((r114 & 32) == 0) goto L25;
        g r115 = r110.f483065f;
    L27:
        if ((r114 & 64) == 0) goto L29;
        c r116 = r110.f483066g;
    L31:
        if ((r114 & 128) == 0) goto L33;
        boolean r117 = r110.f483067h;
    L35:
        if ((r114 & 256) == 0) goto L37;
        r100 = r110.f483068i;
    L37:
        Intrinsics.checkNotNullParameter(r101, "recognition");
        Intrinsics.checkNotNullParameter(r102, SubInfo.KEY_FORMAT);
        Intrinsics.checkNotNullParameter(r103, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r104, VideoTools.ERROR_TYPE_COMPRESS);
        Intrinsics.checkNotNullParameter(r105, "start");
        Intrinsics.checkNotNullParameter(r115, "recording");
        Intrinsics.checkNotNullParameter(r116, EventConstant.Value.RETRY);
        return new i(r101, r102, r103, r104, r105, r115, r116, r117, r100);
    L33:
        r117 = false;
        goto L35
    L29:
        r116 = r113;
        goto L31
    L25:
        r115 = r112;
        goto L27
    L21:
        r105 = null;
        goto L23
    L17:
        r104 = null;
        goto L19
    L13:
        r103 = r111;
        goto L15
    L9:
        r102 = null;
        goto L11
    L5:
        r101 = null;
        goto L7
    }

    public /* synthetic */ i(f r110, com.bytedance.flow_audio.api.foundation.record.a r111, b r112, a r113, g r114, c r115, e r210, int r211) {
        if ((r211 & 1) == 0) goto L5;
        f r100 = new f(null, null);
    L6:
        int r101 = 0;
        if ((r211 & 2) == 0) goto L9;
        com.bytedance.flow_audio.api.foundation.record.a r102 = new com.bytedance.flow_audio.api.foundation.record.a(r101);
    L11:
        if ((r211 & 4) == 0) goto L13;
        b r103 = new b(null, 127);
    L15:
        if ((r211 & 8) == 0) goto L17;
        a r104 = new a(r101);
    L19:
        if ((r211 & 16) == 0) goto L21;
        h r105 = new h(0);
    L23:
        if ((r211 & 32) == 0) goto L25;
        g r106 = new g(null, 0, 7);
    L27:
        if ((r211 & 64) == 0) goto L29;
        c r116 = new c(r101);
    L31:
        if ((r211 & 256) == 0) goto L33;
        e r117 = null;
    L34:
        this(r100, r102, r103, r104, r105, r106, r116, false, r117);
        return;
    L33:
        r117 = r210;
        goto L34
    L29:
        r116 = r115;
        goto L31
    L25:
        r106 = r114;
        goto L27
    L21:
        r105 = null;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L6
    }

    public i(f r100, com.bytedance.flow_audio.api.foundation.record.a r101, b r102, a r103, h r104, g r105, c r106, boolean r107, e r110) {
        Intrinsics.checkNotNullParameter(r100, "recognition");
        Intrinsics.checkNotNullParameter(r101, SubInfo.KEY_FORMAT);
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r103, VideoTools.ERROR_TYPE_COMPRESS);
        Intrinsics.checkNotNullParameter(r104, "start");
        Intrinsics.checkNotNullParameter(r105, "recording");
        Intrinsics.checkNotNullParameter(r106, EventConstant.Value.RETRY);
        this.f483060a = r100;
        this.f483061b = r101;
        this.f483062c = r102;
        this.f483063d = r103;
        this.f483064e = r104;
        this.f483065f = r105;
        this.f483066g = r106;
        this.f483067h = r107;
        this.f483068i = r110;
    }
}
