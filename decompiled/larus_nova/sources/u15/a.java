package u15;

import com.bytedance.ee.bear.contract.d;
import com.ss.android.lark.image.entity.LoadParams;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import du5.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes16.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f548293a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Object> f548294b;

    /* JADX INFO: renamed from: u15.a$a, reason: collision with other inner class name */
    public static final class C7819a {
    }

    static {
    }

    public a(d r100) {
        this.f548293a = r100;
        this.f548294b = new HashMap();
        StringBuilder r101 = new StringBuilder("analyticService null: ");
        if (r100 != null) goto L5;
        boolean r102 = true;
    L6:
        r101.append(r102);
        tt5.a.h("EditImageAnalytic", r101.toString());
        if (r100 == null) goto L9;
        HashMap<String, Object> r103 = r100.m("docCommonParams");
    L10:
        if (r103 == null) goto L15;
        Iterator<Map.Entry<String, Object>> r104 = r103.entrySet().iterator();
    L13:
        if (r104.hasNext() == false) goto L17;
        Map.Entry<String, Object> r105 = r104.next();
        this.f548294b.put(r105.getKey(), r105.getValue());
        goto L13
    L17:
        return;
    L15:
        return;
    L9:
        r103 = null;
        goto L10
    L5:
        r102 = false;
        goto L6
    }

    public final void a(String r100, String r101) {
        ((HashMap) this.f548294b).put("click", r100);
        ((HashMap) this.f548294b).put(PickerReporterConstants.KEY.TARGET, "none");
        Map<String, Object> r102 = this.f548294b;
        HashMap r103 = (HashMap) r102;
        r103.put("object_id", b.g(r101));
        ((HashMap) this.f548294b).put("object_file_type", LoadParams.ImageFormat.PNG);
        ((HashMap) this.f548294b).put("preview_viable", 1);
        d r104 = this.f548293a;
        if (r104 == null) goto L6;
        r104.n("ccm_drive_page_click", this.f548294b);
        return;
    }
}
