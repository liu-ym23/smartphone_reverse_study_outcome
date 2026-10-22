package jm1;

import com.bytedance.android.livesdk.chatroom.model.z3;
import com.bytedance.android.livesdk.vscore_api.multicamera.IMultiCameraView;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes7.dex */
public interface a {

    /* JADX INFO: renamed from: jm1.a$a, reason: collision with other inner class name */
    public interface InterfaceC6459a {
        TreeMap<Double, com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.a> a();

        TreeMap<Double, com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.a> b();

        TreeMap<Double, com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.a> c();

        TreeMap<Double, com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.a> d();

        z3 e();
    }

    void a(boolean r100, boolean r101, boolean r102, IMultiCameraView.Source r103);

    void b(boolean r100, boolean r101, boolean r102, IMultiCameraView.Source r103, mg2.d r104);

    void c(Runnable r100);

    void onDestroy();
}
