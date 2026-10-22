package com.bytedance.locallife.poi.perf.timing;

import androidx.exifinterface.media.ExifInterface;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
public final class PoiTimingLogger {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f263711a = 0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/locallife/poi/perf/timing/PoiTimingLogger$EventState;", "", "B", ExifInterface.LONGITUDE_EAST, "M", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
    public static final enum EventState extends Enum<EventState> {
        public static final EventState B = null;
        public static final EventState E = null;
        public static final EventState M = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ EventState[] f263712a = null;

        public static EventState valueOf(String r100) {
            return (EventState) r27.a.a(EventState.class, r100);
        }

        public static EventState[] values() {
            return (EventState[]) f263712a.clone();
        }

        static {
            EventState r100 = new EventState("B", 0);
            B = r100;
            EventState r101 = new EventState(ExifInterface.LONGITUDE_EAST, 1);
            E = r101;
            EventState r102 = new EventState("M", 2);
            M = r102;
            f263712a = new EventState[]{r100, r101, r102};
        }

        public EventState(String r100, int r101) {
            super(r100, r101);
        }
    }

    static {
        new ConcurrentLinkedQueue();
    }
}
