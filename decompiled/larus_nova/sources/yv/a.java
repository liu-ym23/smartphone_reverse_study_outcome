package yv;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.gamecp.business.gamedetail.component.fansgroup.c;
import com.bytedance.android.gamecp.host_api.service.IBaseHostService;
import com.bytedance.bpea.basics.Cert;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public interface a extends IBaseHostService {

    /* JADX INFO: renamed from: yv.a$a, reason: collision with other inner class name */
    public interface InterfaceC8393a {
        void onFailure(JSONObject r100);
    }

    public interface b {
    }

    void A2(String r100, String r101, Long r102, String r103, c.a r104);

    void Z0(Context r100, String r101);

    boolean handleSchema(Context r100, String r101, Bundle r102);

    boolean isGranted(Context r100, String... r101);

    void requestPermissions(Activity r100, b r101, Cert r102, String... r103);
}
