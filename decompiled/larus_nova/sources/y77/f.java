package y77;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class f {

    @SerializedName("signal_report_settings")
    private List<b> signalReportSettings;

    public final List<b> a() {
        List<b> r100 = this.signalReportSettings;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return new ArrayList();
    }

    public f() {
        this.signalReportSettings = new ArrayList();
    }
}
