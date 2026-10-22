package pqa;

import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.common.push.BaseJson;
import com.ss.alive.monitor.model.StartType;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public final class a extends BaseJson {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public StartType f530306a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f530307b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f530308c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f530309d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public StackTraceElement[] f530310e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f530311f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f530312g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f530313h;

    public final JSONObject b() {
        JSONObject r100 = new JSONObject();
        add(r100, "start_type", this.f530306a.startType);
        if (this.f530307b == false) goto L5;
        long r101 = 1;
    L6:
        add(r100, "is_fore_ground", r101);
        add(r100, "is_active", 0);
        add(r100, "target_pkg", this.f530308c);
        add(r100, "target_component", this.f530309d);
        add(r100, Constants.Keys.KEY_CLIENT_TIME, this.f530312g);
        add(r100, "process", this.f530313h);
        JSONArray r102 = new JSONArray();
        StackTraceElement[] r103 = this.f530310e;
        if (r103 == null) goto L11;
        int r104 = r103.length;
        int r105 = 0;
    L9:
        if (r105 >= r104) goto L11;
        StackTraceElement r106 = r103[r105];
        JSONObject r107 = new JSONObject();
        add(r107, "class_name", r106.getClassName());
        add(r107, "file_name", r106.getFileName());
        add(r107, "method_name", r106.getMethodName());
        add(r107, "line_number", r106.getLineNumber());
        r102.put(r107);
        r105 = r105 + 1;
    L11:
        add(r100, "stack_trace", r102.toString());
        return r100;
    L5:
        r101 = 0;
        goto L6
    }

    public a() {
    }
}
