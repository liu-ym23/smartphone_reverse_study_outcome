package rvb;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.ss.android.lark.officesdk.minutes.service.foundation.utils.settings.configs.MmSubtitleAsrOptConfig;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.helper.MmSubtitleSmoothType;
import com.ss.android.lark.pb.minutes.v1.RecordingSubtitleData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class b extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f539528a;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r11v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r11v7, types: [java.util.ArrayList] */
    @Override // android.os.Handler
    public final void handleMessage(Message r110) {
        Intrinsics.checkNotNullParameter(r110, "msg");
        if (r110.what != 1) goto L145;
        a r100 = this.f539528a;
        if (r100.f539514d.isEmpty() == false) goto L7;
        r100.f539518h.set(false);
    L120:
        if (this.f539528a.f539518h.get() == false) goto L146;
        a r101 = this.f539528a;
        Handler r102 = r101.f539517g;
        if (r102 == null) goto L147;
        r102.sendEmptyMessageDelayed(1, r101.f539520j);
        return;
    L147:
        return;
    L146:
        return;
    L7:
        Iterator<Map.Entry<Long, a.d>> r103 = r100.f539514d.entrySet().iterator();
    L9:
        if (r103.hasNext() == false) goto L120;
        Map.Entry<Long, a.d> r104 = r103.next();
        a.d r105 = r104.getValue();
        RecordingSubtitleData r106 = r105.f539525a;
        MmSubtitleSmoothType r107 = r100.f539511a;
        MmSubtitleSmoothType r108 = MmSubtitleSmoothType.TARGET;
        if (r107 != r108) goto L13;
        RecordingSubtitleData.Subtitle r111 = r106.target;
    L14:
        if (r111 == null) goto L17;
        String r112 = r111.content;
        if (r112 == null) goto L17;
    L18:
        if (r107 != r108) goto L20;
        RecordingSubtitleData.Subtitle r109 = r106.target;
    L21:
        if (r109 == null) goto L35;
        RecordingSubtitleData.Subtitle.Punctuation r113 = r109.punctuation;
        if (r113 == null) goto L35;
        List<Long> r114 = r113.word_ends;
        if (r114 == null) goto L35;
        ?? r115 = new ArrayList();
        Iterator r116 = r114.iterator();
    L28:
        if (r116.hasNext() == false) goto L36;
        Long r117 = (Long) r116.next();
        if (r117 == null) goto L32;
        Integer r118 = Integer.valueOf((int) r117.longValue());
    L33:
        if (r118 == null) goto L28;
        r115.add(r118);
        goto L28
    L32:
        r118 = null;
    L36:
        RecordingSubtitleData.SSDSpeaker r119 = r106.ssd_speaker;
        if (r119 == null) goto L40;
        String r120 = r119.speaker_user_id;
        if (r120 == null) goto L40;
    L45:
        int r121 = r105.f539526b;
        RecordingSubtitleData r122 = r105.f539525a;
        Boolean r123 = r122.is_seg_final;
        if (r123 == null) goto L48;
        boolean r124 = r123.booleanValue();
    L50:
        if (r121 != (-1)) goto L52;
    L105:
        Object r125 = new a.b.c(r112.length());
    L107:
        if (Intrinsics.areEqual(r125, a.b.C7542a.f539522a) == true) goto L108;
        if ((r125 instanceof a.b.c) == true) goto L111;
        if (Intrinsics.areEqual(r125, a.b.C7543b.f539523a) == true) goto L9;
        throw new NoWhenBranchMatchedException();
    L111:
        a.b.c r126 = (a.b.c) r125;
        int r127 = r126.f539524a;
        if (r127 == r105.f539526b) goto L9;
        r100.c(r106, r112.substring(0, r127));
        int r128 = r126.f539524a;
        RecordingSubtitleData r129 = r105.f539525a;
        Intrinsics.checkNotNullParameter(r129, "data");
        r104.setValue(new a.d(r129, r128));
        goto L9
    L108:
        r103.remove();
        r100.c(r106, r112);
        goto L9
    L52:
        if (r121 > r112.length()) goto L105;
        if (r121 != r112.length()) goto L74;
        if (r124 == true) goto L73;
        MmSubtitleAsrOptConfig r130 = r100.f539521k;
        if (r130 != null) goto L60;
    L62:
        boolean r131 = false;
    L63:
        if (r131 == true) goto L65;
    L69:
        boolean r132 = false;
    L70:
        if (r132 == true) goto L73;
        r125 = a.b.C7543b.f539523a;
        goto L107
    L65:
        if (r122.sound_type != RecordingSubtitleData.SoundType.NOISE) goto L67;
    L68:
        r132 = true;
        goto L70
    L67:
        if (TextUtils.isEmpty(r112) == false) goto L69;
    L60:
        if (r130.getEnabled() != true) goto L62;
        r131 = true;
    L73:
        r125 = a.b.C7542a.f539522a;
        goto L107
    L74:
        Long r133 = r100.f539516f.get(r120);
        if (r133 == null) goto L79;
        a.d r134 = r100.f539514d.get(Long.valueOf(r133.longValue()));
        if (r134 == null) goto L79;
        RecordingSubtitleData r135 = r134.f539525a;
    L80:
        MmSubtitleAsrOptConfig r136 = r100.f539521k;
        if (r136 != null) goto L83;
    L85:
        boolean r137 = false;
    L86:
        if (r137 == false) goto L98;
        if (r133 == null) goto L98;
        long r138 = r133.longValue();
        Long r139 = r122.seg_id;
        if (r139 == null) goto L91;
        long r140 = r139.longValue();
    L93:
        if (r138 >= r140) goto L98;
        if (r135 == null) goto L98;
        if (Intrinsics.areEqual(r135.is_seg_final, Boolean.TRUE) == true) goto L98;
        r125 = new a.b.c(r112.length());
        goto L107
    L91:
        r140 = 0;
    L98:
        Iterator r141 = r115.iterator();
    L100:
        if (r141.hasNext() == false) goto L104;
        int r142 = ((Number) r141.next()).intValue();
        if (r142 <= r121) goto L100;
        r125 = new a.b.c(r142);
        goto L107
    L104:
        r125 = new a.b.c(r112.length());
        goto L107
    L83:
        if (r136.getEnabled() != true) goto L85;
        r137 = true;
    L79:
        r135 = null;
        goto L80
    L48:
        r124 = false;
    L40:
        if (r119 == null) goto L42;
        r120 = r119.user_id;
    L43:
        if (r120 != null) goto L45;
        r120 = "1";
        goto L45
    L42:
        r120 = null;
    L35:
        r115 = CollectionsKt.emptyList();
        goto L36
    L20:
        r109 = r106.source;
    L17:
        r112 = "";
        goto L18
    L13:
        r111 = r106.source;
        goto L14
    }

    public b(a r100, Looper r101) {
        this.f539528a = r100;
        super(r101);
    }
}
