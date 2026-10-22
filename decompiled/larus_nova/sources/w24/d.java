package w24;

import android.content.Context;
import com.bytedance.awemeopen.infra.support.AoCodeResult;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import r14.c0;
import r14.z;

/* JADX INFO: loaded from: classes44.dex */
public interface d extends k24.a, n24.a {
    List E(String r100, boolean r101, long r102, List r103);

    void I0(Function0<Unit> r100);

    void J0(String r100, String r101);

    void Q(int r100, int r101, int r102, Function1<? super AoCodeResult<z>, Unit> r103);

    void S2(Function0<Unit> r100);

    void c2();

    void closeSideProfile();

    void insert(String r100);

    void j1(Function1<? super String, Unit> r100);

    void n(Function0<Unit> r100);

    void o3(Function2<? super String, ? super Map<String, String>, Unit> r100);

    void openSideProfile();

    void t2(String r100, Function1<? super AoCodeResult<c0>, Unit> r101);

    void t3(Context r100, b r101, r34.b<r14.c> r102);

    void updateCurrentHostVideoData(String r100);

    void y1(Context r100, b r101, r34.b<r14.c> r102);

    void z1(Context r100, b r101, r34.b<r14.c> r102);
}
