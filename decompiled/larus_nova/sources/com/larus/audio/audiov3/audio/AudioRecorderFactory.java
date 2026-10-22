package com.larus.audio.audiov3.audio;

import android.content.Context;
import com.larus.audio.record.AudioRecordType;
import com.larus.audio.record.factory.IAudioRecorderFactory;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import p58.d;
import p58.e;
import r58.c;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tH\u0016¨\u0006\f"}, d2 = {"Lcom/larus/audio/audiov3/audio/AudioRecorderFactory;", "Lcom/larus/audio/record/factory/IAudioRecorderFactory;", "<init>", "()V", "create", "Lcom/larus/audio/audiov3/audio/record/IAudioRecorder;", "type", "Lcom/larus/audio/record/AudioRecordType;", "params", "", "", "", "audiosdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AudioRecorderFactory implements IAudioRecorderFactory {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f288497a = null;

        static {
            int[] r100 = new int[AudioRecordType.values().length];
            r100[AudioRecordType.AudioRecord.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[AudioRecordType.BackTraceRecord.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f288497a = r100;
        }
    }

    public AudioRecorderFactory() {
    }

    @Override // com.larus.audio.record.factory.IAudioRecorderFactory
    public final c a(AudioRecordType r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "params");
        int r102 = a.f288497a[r100.ordinal()];
        int r103 = -1;
        Integer r104 = null;
        if (r102 != 1) goto L5;
        Object r105 = r101.get("bufferSize");
        if ((r105 instanceof Integer) == false) goto L28;
        r104 = (Integer) r105;
    L28:
        if (r104 == null) goto L30;
        r103 = r104.intValue();
    L30:
        c r106 = new d(r103);
    L31:
        return r106;
    L5:
        if (r102 != 2) goto L24;
        Object r107 = r101.get(PerfLog.PARAM_KEY_CONTEXT_ID);
        if ((r107 instanceof Context) == false) goto L9;
        Context r108 = (Context) r107;
    L10:
        Object r109 = r101.get("bufferSize");
        if ((r109 instanceof Integer) == false) goto L13;
        Integer r110 = (Integer) r109;
    L14:
        if (r110 == null) goto L16;
        int r111 = r110.intValue();
    L17:
        Object r112 = r101.get("sessionId");
        if ((r112 instanceof Integer) == false) goto L20;
        r104 = (Integer) r112;
    L20:
        if (r104 == null) goto L22;
        r103 = r104.intValue();
    L22:
        r106 = new e(r108, r111, r103);
        goto L31
    L16:
        r111 = -1;
        goto L17
    L13:
        r110 = null;
        goto L14
    L9:
        r108 = null;
        goto L10
    L24:
        throw new NoWhenBranchMatchedException();
    }
}
