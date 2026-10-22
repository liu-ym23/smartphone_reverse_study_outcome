package p30;

import android.content.Context;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes45.dex */
public interface j {
    void closeLiveRoomRTS(a r100, Function1<? super b, Unit> r101, Context r102);

    void getClientSettingRTS(f r100, Function1<Object, Unit> r101, Context r102);

    void getEnableLiveHistoryRTS(h r100, Function1<? super Boolean, Unit> r101);

    void userActionRTS(q r100, Function1<? super r, Unit> r101, Context r102);
}
