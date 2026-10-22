package mk4;

import com.bytedance.dora.device.DoraDevice;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes15.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final nk4.b f514302a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<DoraDevice> f514303b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<DoraDevice> f514304c;

    public final Map<String, Object> a() {
        LinkedHashMap r100 = new LinkedHashMap();
        r100.put("dora_device_track_mode", this.f514302a.a());
        List r101 = c.a(this.f514303b);
        String r102 = "";
        if (((ArrayList) r101).isEmpty() == false) goto L5;
        String r103 = "";
    L6:
        r100.put("dora_current_connect_devices", r103);
        List r104 = c.a(this.f514304c);
        if (((ArrayList) r104).isEmpty() == true) goto L10;
        r102 = new JSONArray(r104).toString();
    L10:
        r100.put("dora_track_mode_specific_devices", r102);
        return r100;
    L5:
        r103 = new JSONArray(r101).toString();
        goto L6
    }

    public a(nk4.b r100, List<?> r101, List<?> r102) {
        this.f514302a = r100;
        if (r101 != null) goto L5;
    L8:
        List<DoraDevice> r103 = Collections.emptyList();
    L9:
        this.f514303b = r103;
        if (r102 != null) goto L12;
    L15:
        List<DoraDevice> r104 = Collections.emptyList();
    L16:
        this.f514304c = r104;
        return;
    L12:
        if (r102.isEmpty() == true) goto L15;
        r104 = Collections.unmodifiableList(new ArrayList(d.b(r102)));
        goto L16
    L5:
        if (r101.isEmpty() == true) goto L8;
        r103 = Collections.unmodifiableList(new ArrayList(d.b(r101)));
        goto L9
    }
}
