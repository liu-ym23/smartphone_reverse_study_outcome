package hm5;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.middleground.permission.export.ui.model.DocReportPubParam;
import com.bytedance.ies.xbridge.XBridgeMethod;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes18.dex */
public interface a {
    ArrayList<Class<? extends XBridgeMethod>> Id();

    void Sb(FragmentManager r100, Context r101, int r102, String r103, DocReportPubParam r104);

    void onDestroy();
}
