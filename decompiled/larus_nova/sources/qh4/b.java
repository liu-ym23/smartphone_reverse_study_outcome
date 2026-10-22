package qh4;

import com.huawei.hms.framework.common.ContainerUtils;
import oh4.d;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes15.dex */
public final class b extends d {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f532966h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String[] f532967i;

    @Override // oh4.d
    public final String toString() {
        return this.f532966h;
    }

    public b(JSONArray r110) {
        int r100 = 0;
        super(21, 33, 0);
        this.f532966h = null;
        this.f532967i = new String[]{"enableXasan", "debug", "maxSimultaneousAlloc", "sampleRate", "monitorAllocSize", "monitorType", "monitorBugType", "soName"};
        if (r110 != null) goto L5;
        return;
    L5:
        if (r110.length() >= 10) goto L18;
        StringBuilder r101 = new StringBuilder();
    L9:
        if (r100 >= r110.length()) goto L13;
        String[] r102 = this.f532967i;
        if (r100 >= r102.length) goto L13;
        r101.append(r102[r100]);
        r101.append(ContainerUtils.KEY_VALUE_DELIMITER);
        r101.append(r110.optString(r100));
        r101.append("\n");
        r100 = r100 + 1;
    L13:
        this.f532966h = r101.toString();
        return;
    }
}
