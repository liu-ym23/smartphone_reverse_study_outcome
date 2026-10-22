package cta;

import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes34.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b.a f465368a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String[] f465369b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String[] f465370c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<String, Integer> f465371d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f465372e;

    public final void a() {
        CJLogger.d("CJPermissionRequestData", "daCallback: mListener=" + this.f465368a);
        if (this.f465368a != null) goto L5;
        return;
    L5:
        int r100 = this.f465372e;
        int[] r101 = new int[r100];
        Map<String, Integer> r102 = this.f465371d;
        boolean r103 = true;
        if (r102 == null) goto L19;
        if (r100 <= 0) goto L19;
        Integer[] r104 = (Integer[]) ((HashMap) r102).values().toArray(new Integer[this.f465372e]);
        int r105 = 0;
        boolean r106 = true;
    L10:
        if (r105 >= this.f465372e) goto L18;
        r101[r105] = r104[r105].intValue();
        if (r106 == true) goto L14;
    L16:
        r106 = false;
    L17:
        r105 = r105 + 1;
        goto L10
    L14:
        if (r104[r105].intValue() != 0) goto L16;
        r106 = true;
        goto L17
    L18:
        r103 = r106;
    L19:
        b.a r107 = this.f465368a;
        int r108 = this.f465372e;
        String[] r109 = new String[r108];
        Map<String, Integer> r110 = this.f465371d;
        if (r110 == null) goto L23;
        if (r108 <= 0) goto L23;
        r109 = (String[]) ((HashMap) r110).keySet().toArray(new String[this.f465372e]);
    L23:
        r107.onPermissionCheckCallback(r109, r101, r103);
    }

    public final void b() {
        CJLogger.d("CJPermissionRequestData", "grantedCallback: mListener=" + this.f465368a);
        if (this.f465368a != null) goto L5;
        return;
    L5:
        int[] r100 = new int[this.f465372e];
        Arrays.fill(r100, 0);
        b.a r101 = this.f465368a;
        int r102 = this.f465372e;
        String[] r103 = new String[r102];
        Map<String, Integer> r104 = this.f465371d;
        if (r104 == null) goto L9;
        if (r102 <= 0) goto L9;
        r103 = (String[]) ((HashMap) r104).keySet().toArray(new String[this.f465372e]);
    L9:
        r101.onPermissionCheckCallback(r103, r100, true);
    }

    public a(b.a r100, String[] r101, String[] r102) {
        int r103 = 0;
        this.f465372e = 0;
        this.f465368a = r100;
        this.f465369b = r101;
        this.f465370c = r102;
        this.f465371d = new HashMap();
        String[] r104 = this.f465369b;
        if (r104 != null) goto L5;
        return;
    L5:
        if (r104.length == 0) goto L12;
        int r105 = r104.length;
    L8:
        if (r103 >= r105) goto L13;
        ((HashMap) this.f465371d).put(r104[r103], -1);
        this.f465372e++;
        r103 = r103 + 1;
        goto L8
    L13:
        return;
    }
}
