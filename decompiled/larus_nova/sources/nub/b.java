package nub;

import android.content.Context;
import com.ss.android.lark.officesdk.api.base.IOfficeSDKProtocol;
import com.ss.android.lark.officesdk.minutes.api.recording.common.depend.rtc.VCMediaStreamType;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes37.dex */
public interface b extends IOfficeSDKProtocol {
    void A1(VCMediaStreamType r100);

    void B0(List<String> r100);

    void D1(String r100);

    void G0(int r100);

    void H();

    void J(int r100, int r101);

    void Q1(boolean r100);

    void U0(boolean r100);

    void V0(String r100);

    boolean W1(boolean r100);

    void b(String r100);

    void d(int r100);

    void e1(String r100);

    void g(String r100);

    void h(sub.a r100);

    void h1(String r100, String r101, String r102, String r103, String r104);

    void j0(boolean r100);

    void k1();

    void m1();

    void muteLocalAudioStream(boolean r100);

    eo9.d t(String r100);

    void t1(int r100, int r101);

    boolean v(Context r100, String r101, String r102, String r103, String r104);

    void x(JSONObject r100);

    void z(c r100);
}
