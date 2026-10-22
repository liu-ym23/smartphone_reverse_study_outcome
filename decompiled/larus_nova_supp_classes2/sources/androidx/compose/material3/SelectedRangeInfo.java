package androidx.compose.material3;

import androidx.compose.material3.internal.CalendarDate;
import androidx.compose.material3.internal.CalendarMonth;
import androidx.compose.ui.unit.IntOffset;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0001\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u0012"}, d2 = {"Landroidx/compose/material3/SelectedRangeInfo;", "", "gridStartCoordinates", "Landroidx/compose/ui/unit/IntOffset;", "gridEndCoordinates", "firstIsSelectionStart", "", "lastIsSelectionEnd", "<init>", "(JJZZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getGridStartCoordinates-nOcc-ac", "()J", "J", "getGridEndCoordinates-nOcc-ac", "getFirstIsSelectionStart", "()Z", "getLastIsSelectionEnd", "Companion", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SelectedRangeInfo {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private final boolean firstIsSelectionStart;
    private final long gridEndCoordinates;
    private final long gridStartCoordinates;
    private final boolean lastIsSelectionEnd;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t¨\u0006\u000b"}, d2 = {"Landroidx/compose/material3/SelectedRangeInfo$Companion;", "", "<init>", "()V", "calculateRangeInfo", "Landroidx/compose/material3/SelectedRangeInfo;", "month", "Landroidx/compose/material3/internal/CalendarMonth;", "startDate", "Landroidx/compose/material3/internal/CalendarDate;", "endDate", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final SelectedRangeInfo calculateRangeInfo(CalendarMonth r16, CalendarDate r17, CalendarDate r18) {
            if (r17.getUtcTimeMillis() <= r16.getEndUtcTimeMillis()) goto L5;
            return null;
        L5:
            if (r18.getUtcTimeMillis() >= r16.getStartUtcTimeMillis()) goto L8;
            return null;
        L8:
            if (r17.getUtcTimeMillis() < r16.getStartUtcTimeMillis()) goto L10;
            boolean r12 = true;
        L12:
            if (r18.getUtcTimeMillis() > r16.getEndUtcTimeMillis()) goto L14;
            boolean r13 = true;
        L15:
            if (r12 == false) goto L17;
            int r0 = (r16.getDaysFromStartOfWeekToFirstOfMonth() + r17.getDayOfMonth()) - 1;
        L18:
            if (r13 == false) goto L20;
            int r1 = r16.getDaysFromStartOfWeekToFirstOfMonth();
            int r2 = r18.getDayOfMonth();
        L21:
            int r3 = (r1 + r2) - 1;
            int r4 = r0 % 7;
            long r5 = IntOffset.constructor-impl((((long) r4) << 32) | (((long) (r0 / 7)) & 4294967295L));
            int r6 = r3 % 7;
            long r7 = ((long) r6) << 32;
            return new SelectedRangeInfo(r5, IntOffset.constructor-impl((((long) (r3 / 7)) & 4294967295L) | r7), r12, r13, null);
        L20:
            r1 = r16.getDaysFromStartOfWeekToFirstOfMonth();
            r2 = r16.getNumberOfDays();
            goto L21
        L17:
            r0 = r16.getDaysFromStartOfWeekToFirstOfMonth();
            goto L18
        L14:
            r13 = false;
            goto L15
        L10:
            r12 = false;
            goto L12
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ SelectedRangeInfo(long r1, long r3, boolean r5, boolean r6, DefaultConstructorMarker r7) {
        this(r1, r3, r5, r6);
    }

    public final boolean getFirstIsSelectionStart() {
        return this.firstIsSelectionStart;
    }

    /* JADX INFO: renamed from: getGridEndCoordinates-nOcc-ac, reason: not valid java name */
    public final long m3112getGridEndCoordinatesnOccac() {
        return this.gridEndCoordinates;
    }

    /* JADX INFO: renamed from: getGridStartCoordinates-nOcc-ac, reason: not valid java name */
    public final long m3113getGridStartCoordinatesnOccac() {
        return this.gridStartCoordinates;
    }

    public final boolean getLastIsSelectionEnd() {
        return this.lastIsSelectionEnd;
    }

    private SelectedRangeInfo(long r1, long r3, boolean r5, boolean r6) {
        this.gridStartCoordinates = r1;
        this.gridEndCoordinates = r3;
        this.firstIsSelectionStart = r5;
        this.lastIsSelectionEnd = r6;
    }
}
