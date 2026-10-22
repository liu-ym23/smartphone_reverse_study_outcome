package fn5;

import com.bytedance.ee.bear.lynx.api.CCMLynxCardView;
import com.bytedance.ee.bear.reminder.model.EAlertTimeEvent;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c extends com.bytedance.ee.bear.reminder.model.a {
    @Override // com.bytedance.ee.bear.reminder.model.a
    public final List<EAlertTimeEvent> b() {
        return Arrays.asList(new EAlertTimeEvent[]{EAlertTimeEvent.noAlert, EAlertTimeEvent.onDayOfEvent, EAlertTimeEvent.oneDayBefore, EAlertTimeEvent.twoDaysBefore, EAlertTimeEvent.oneWeekBefore});
    }

    @Override // com.bytedance.ee.bear.reminder.model.a
    public final int c() {
        return 2131103404;
    }

    @Override // com.bytedance.ee.bear.reminder.model.a
    public final int d() {
        return 2131103404;
    }

    @Override // com.bytedance.ee.bear.reminder.model.a
    public final int e() {
        return 2131103404;
    }

    @Override // com.bytedance.ee.bear.reminder.model.a
    public final int g() {
        return 500;
    }

    @Override // com.bytedance.ee.bear.reminder.model.a
    public final int h() {
        return CCMLynxCardView.ViewType.BANNER;
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

    public c(com.bytedance.ee.bear.reminder.model.a r1) {
        super(r1);
    }
}
