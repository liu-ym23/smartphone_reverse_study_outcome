package ux5;

import com.bytedance.frameworks.baselib.network.queryfilter.QueryFilterEngine;
import com.bytedance.retrofit2.client.Request;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class e extends c {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<String> f551998i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<String> f551999j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f552000k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f552001l;

    static {
    }

    public e(int r100) {
        super(r100);
        this.f551998i = new ArrayList();
        this.f551999j = new ArrayList();
        this.f552000k = false;
        this.f552001l = false;
    }

    @Override // ux5.c
    public final void d(JSONObject r100) {
        e(r100);
        QueryFilterEngine.parseArrayListConfig(r100.optJSONArray("keep_list"), this.f551998i);
        QueryFilterEngine.parseArrayListConfig(r100.optJSONArray("remove_list"), this.f551999j);
        boolean r101 = false;
        if (r100.optInt("protect_background_request", 0) <= 0) goto L5;
        boolean r102 = true;
    L6:
        this.f551991c = r102;
        if (r100.optInt("add_background_rm_mark", 0) <= 0) goto L9;
        r101 = true;
    L9:
        this.f552001l = r101;
        if (((ArrayList) this.f551998i).isEmpty() == false) goto L12;
        return;
    L12:
        if (((ArrayList) this.f551999j).isEmpty() == true) goto L16;
        this.f552000k = true;
        return;
    L16:
        return;
    L5:
        r102 = false;
        goto L6
    }

    @Override // ux5.c
    public final boolean a(Request r100, Map<String, List<String>> r101) {
        if (this.f552000k == false) goto L5;
    L44:
        return false;
    L5:
        if (c(r100) == false) goto L44;
        if (r101.isEmpty() == false) goto L11;
        return false;
    L11:
        if (((ArrayList) this.f551998i).isEmpty() == true) goto L23;
        Map<? extends String, ? extends List<String>> r102 = new LinkedHashMap();
        if (r101.containsKey("x-tt-encrypt-queries") == false) goto L15;
        r102.put("x-tt-encrypt-queries", r101.get("x-tt-encrypt-queries"));
    L15:
        Iterator r103 = ((ArrayList) this.f551998i).iterator();
    L17:
        if (r103.hasNext() == false) goto L21;
        String r104 = (String) r103.next();
        if (r101.containsKey(r104) == false) goto L17;
        r102.put(r104, r101.get(r104));
        goto L17
    L21:
        r101.clear();
        r101.putAll(r102);
        return true;
    L23:
        if (((ArrayList) this.f551999j).isEmpty() == true) goto L55;
        Iterator r105 = ((ArrayList) this.f551999j).iterator();
    L26:
        if (r105.hasNext() == false) goto L29;
        r101.remove((String) r105.next());
        goto L26
    L29:
        if (r100.getUrl() == null) goto L31;
        String r106 = r100.getUrl();
    L33:
        if (this.f552001l == true) goto L35;
        return true;
    L35:
        if (r106.contains("bgrm") == true) goto L57;
        Iterator r107 = ((ArrayList) this.f551999j).iterator();
    L38:
        if (r107.hasNext() == false) goto L58;
        if (r106.contains((String) r107.next()) == false) goto L38;
        ArrayList r108 = new ArrayList();
        r108.add("1");
        r101.put("bgrm", r108);
        return true;
    L58:
        return true;
    L57:
        return true;
    L31:
        r106 = "";
        goto L33
    L55:
        return true;
    }
}
