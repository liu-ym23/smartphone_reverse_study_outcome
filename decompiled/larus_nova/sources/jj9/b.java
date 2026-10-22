package jj9;

import com.larus.livetutor.api.idl.ControlReason;
import com.larus.livetutor.api.idl.PauseLocation;
import com.larus.livetutor.api.idl.UserSetting;
import com.larus.livetutor.impl.repository.viewmodel.b0;
import com.larus.livetutor.impl.repository.viewmodel.l;
import com.larus.livetutor.impl.repository.viewmodel.w;
import com.larus.livetutor.impl.tutor.controller.LiveTutorPauseController;
import com.larus.livetutor.impl.tutor.controller.u;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes30.dex */
public interface b {
    void a(String r100, ij9.a r101, l r102);

    void b(String r100, PauseLocation r101, w r102);

    void c(PauseLocation r100, ControlReason r101, u r102);

    void d(UserSetting r100, PauseLocation r101, long r102, Function1<? super Boolean, Unit> r103);

    void e(ControlReason r100, LiveTutorPauseController.b r101);

    void f(String r100, ij9.a r101, b0 r102);
}
