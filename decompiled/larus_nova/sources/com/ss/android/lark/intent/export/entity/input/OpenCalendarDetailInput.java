package com.ss.android.lark.intent.export.entity.input;

import com.ss.android.lark.search.dto.info.CalendarResult;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/intent/export/entity/input/OpenCalendarDetailInput;", "Lcom/ss/android/lark/intent/export/entity/input/IntentInput;", "Ljava/io/Serializable;", "calendarResult", "Lcom/ss/android/lark/search/dto/info/CalendarResult;", "<init>", "(Lcom/ss/android/lark/search/dto/info/CalendarResult;)V", "getCalendarResult", "()Lcom/ss/android/lark/search/dto/info/CalendarResult;", "toString", "", "intent-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OpenCalendarDetailInput extends IntentInput implements Serializable {
    private final CalendarResult calendarResult;

    public String toString() {
        StringBuilder r100 = new StringBuilder("OpenCalendarDetailInput(calendarResult=(");
        Object r101 = this.calendarResult;
        if (r101 != null) goto L6;
        r101 = "null";
    L6:
        r100.append(r101);
        r100.append("))");
        return r100.toString();
    }

    public final CalendarResult getCalendarResult() {
        return this.calendarResult;
    }

    public OpenCalendarDetailInput(CalendarResult r100) {
        super(IntentInput.IntentType.OPEN_CALENDAR_DETAIL);
        this.calendarResult = r100;
    }
}
