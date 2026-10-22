package com.obric.livecard.api;

import com.bytedance.sdk.open.aweme.core.net.OpenNetMethod;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0016\b\u0086\u0001\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0016B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0017"}, d2 = {"Lcom/obric/livecard/api/LiveCardType;", "", "(Ljava/lang/String;I)V", "CALL", "ASSISTANT", "OAUTO", "MEMORY_DATA", "SCREEN_CAP", "BATTERY", "VIBRATE", "RING_DOWN", "MUTE", "CARD_PACKAGE", "AUTO_DISMISS", "SOUND_RECORD", "TRANSFER_DATA", "ALARM", "COUNT_DOWN", "STOP_WATCH", "MUSIC", OpenNetMethod.LOCK, "LIVE_NOTIFICATION", "Companion", "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum LiveCardType extends Enum<LiveCardType> {
    private static final /* synthetic */ LiveCardType[] $VALUES = null;
    public static final LiveCardType ALARM = null;
    public static final LiveCardType ASSISTANT = null;
    public static final LiveCardType AUTO_DISMISS = null;
    public static final LiveCardType BATTERY = null;
    public static final LiveCardType CALL = null;
    public static final LiveCardType CARD_PACKAGE = null;
    public static final LiveCardType COUNT_DOWN = null;
    public static final Companion Companion = null;
    public static final LiveCardType LIVE_NOTIFICATION = null;
    public static final LiveCardType LOCK = null;
    public static final LiveCardType MEMORY_DATA = null;
    public static final LiveCardType MUSIC = null;
    public static final LiveCardType MUTE = null;
    public static final LiveCardType OAUTO = null;
    public static final LiveCardType RING_DOWN = null;
    public static final LiveCardType SCREEN_CAP = null;
    public static final LiveCardType SOUND_RECORD = null;
    public static final LiveCardType STOP_WATCH = null;
    public static final LiveCardType TRANSFER_DATA = null;
    public static final LiveCardType VIBRATE = null;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/livecard/api/LiveCardType$Companion;", "", "()V", "fromString", "Lcom/obric/livecard/api/LiveCardType;", "value", "", "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final LiveCardType fromString(String r100) {
            Intrinsics.checkNotNullParameter(r100, "value");
            Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
            Object r102 = Result.m9449constructorimpl(LiveCardType.valueOf(r100));     // Catch: Throwable -> L5
        L8:
            if (Result.m9455isFailureimpl(r102) == false) goto L11;
            r102 = null;
        L11:
            return (LiveCardType) r102;
        L5:
            th = move-exception;
            Result.Companion r103 = Result.Companion;
            r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L8
        }
    }

    private static final /* synthetic */ LiveCardType[] $values() {
        return new LiveCardType[]{CALL, ASSISTANT, OAUTO, MEMORY_DATA, SCREEN_CAP, BATTERY, VIBRATE, RING_DOWN, MUTE, CARD_PACKAGE, AUTO_DISMISS, SOUND_RECORD, TRANSFER_DATA, ALARM, COUNT_DOWN, STOP_WATCH, MUSIC, LOCK, LIVE_NOTIFICATION};
    }

    public static LiveCardType valueOf(String r100) {
        return (LiveCardType) r27.a.a(LiveCardType.class, r100);
    }

    public static LiveCardType[] values() {
        return (LiveCardType[]) $VALUES.clone();
    }

    static {
        CALL = new LiveCardType("CALL", 0);
        ASSISTANT = new LiveCardType("ASSISTANT", 1);
        OAUTO = new LiveCardType("OAUTO", 2);
        MEMORY_DATA = new LiveCardType("MEMORY_DATA", 3);
        SCREEN_CAP = new LiveCardType("SCREEN_CAP", 4);
        BATTERY = new LiveCardType("BATTERY", 5);
        VIBRATE = new LiveCardType("VIBRATE", 6);
        RING_DOWN = new LiveCardType("RING_DOWN", 7);
        MUTE = new LiveCardType("MUTE", 8);
        CARD_PACKAGE = new LiveCardType("CARD_PACKAGE", 9);
        AUTO_DISMISS = new LiveCardType("AUTO_DISMISS", 10);
        SOUND_RECORD = new LiveCardType("SOUND_RECORD", 11);
        TRANSFER_DATA = new LiveCardType("TRANSFER_DATA", 12);
        ALARM = new LiveCardType("ALARM", 13);
        COUNT_DOWN = new LiveCardType("COUNT_DOWN", 14);
        STOP_WATCH = new LiveCardType("STOP_WATCH", 15);
        MUSIC = new LiveCardType("MUSIC", 16);
        LOCK = new LiveCardType(OpenNetMethod.LOCK, 17);
        LIVE_NOTIFICATION = new LiveCardType("LIVE_NOTIFICATION", 18);
        $VALUES = $values();
        Companion = new Companion(null);
    }

    private LiveCardType(String r100, int r101) {
        super(r100, r101);
    }
}
