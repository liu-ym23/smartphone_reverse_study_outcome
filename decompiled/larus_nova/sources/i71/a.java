package i71;

import com.bytedance.android.live.room.api.messagewindow.schedule.ScheduleParams;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import v61.c;

/* JADX INFO: loaded from: classes47.dex */
public interface a {
    <T extends ScheduleParams<? extends c>> void execute(Function1<? super T, Unit> r100);
}
