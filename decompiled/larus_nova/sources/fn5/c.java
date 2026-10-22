package fn5;

import com.bytedance.ee.bear.reminder.model.EAlertTimeEvent;
import com.larus.nova.R;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public final class c extends com.bytedance.ee.bear.reminder.model.a {
    @Override // com.bytedance.ee.bear.reminder.model.a
    public final List<EAlertTimeEvent> b() {
        return Arrays.asList(new EAlertTimeEvent[]{EAlertTimeEvent.noAlert, EAlertTimeEvent.onDayOfEvent, EAlertTimeEvent.oneDayBefore, EAlertTimeEvent.twoDaysBefore, EAlertTimeEvent.oneWeekBefore});
    }

    @Override // com.bytedance.ee.bear.reminder.model.a
    public final int c() {
        return R.color.lkui_B500;
    }

    @Override // com.bytedance.ee.bear.reminder.model.a
    public final int d() {
        return R.color.lkui_B500;
    }

    @Override // com.bytedance.ee.bear.reminder.model.a
    public final int e() {
        return R.color.lkui_B500;
    }

    @Override // com.bytedance.ee.bear.reminder.model.a
    public final int g() {
        return 500;
    }

    @Override // com.bytedance.ee.bear.reminder.model.a
    public final int h() {
        return 1000;
    }

    @Override // com.bytedance.ee.bear.reminder.model.a
    public final boolean i() {
        return true;
    }

    @Override // com.bytedance.ee.bear.reminder.model.a
    public final boolean j() {
        return true;
    }

    @Override // com.bytedance.ee.bear.reminder.model.a
    public final List<EAlertTimeEvent> a() {
        return Arrays.asList(new EAlertTimeEvent[]{EAlertTimeEvent.noAlert, EAlertTimeEvent.atTimeOfEvent, EAlertTimeEvent.before5Mins, EAlertTimeEvent.before15Mins, EAlertTimeEvent.before30Mins, EAlertTimeEvent.before1Hour, EAlertTimeEvent.before2Hours, EAlertTimeEvent.before1Day, EAlertTimeEvent.before2Days, EAlertTimeEvent.before1Week});
    }

    public c() {
    }

    public c(com.bytedance.ee.bear.reminder.model.a r100) {
        super(r100);
    }
}
