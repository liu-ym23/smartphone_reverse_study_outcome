package hm5;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.middleground.permission.export.ui.model.DocReportPubParam;
import com.bytedance.ies.xbridge.XBridgeMethod;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface a {
    ArrayList<Class<? extends XBridgeMethod>> Id();

    void Sb(FragmentManager r1, Context r2, int r3, String r4, DocReportPubParam r5);

    void onDestroy();
}
