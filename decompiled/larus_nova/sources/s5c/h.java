package s5c;

import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public final class h implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f540777a = null;

    public h() {
    }

    @Override // s5c.d
    public final String getKey() {
        return PickerReporterConstants.KEY.TARGET;
    }

    @Override // s5c.d
    public final String getValue() {
        return "none";
    }

    static {
        f540777a = new h();
    }

    @Override // s5c.d
    public final JSONObject toJson() {
        return d.b.c(this);
    }

    @Override // s5c.d
    public final d plus(Map<String, ? extends Object> r100) {
        return d.b.a(this, r100);
    }

    @Override // s5c.d
    public final d plus(d r100) {
        return d.b.b(this, r100);
    }
}
