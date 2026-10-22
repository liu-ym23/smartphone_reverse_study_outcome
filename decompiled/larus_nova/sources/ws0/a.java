package ws0;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import jc1.k;
import n56.c;
import n56.f;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<Context> f560944a;

    /* JADX INFO: renamed from: ws0.a$a, reason: collision with other inner class name */
    public static final class C8154a {
    }

    static {
    }

    public a(WeakReference r100) {
        this.f560944a = r100;
    }

    @Override // n56.c
    public void call(f r110, JSONObject r111) {
        if (r110 == null) goto L53;
        if (r111 == null) goto L53;
        if (r110.f518032d == null) goto L53;
        r111.put("code", 0);
        JSONObject r100 = r110.f518032d;
        String r101 = r100.optString("type");
        if (TextUtils.isEmpty(r101) == false) goto L13;
        r111.put("code", 0);
        return;
    L13:
        if (r100.has("args") == false) goto L15;
        JSONObject r102 = JSONObjectProtectorUtils.getJSONObject(r100, "args");
    L16:
        if (r101 == null) goto L54;
        if (r101.hashCode() != (-309425751)) goto L54;
        if (r101.equals("profile") == false) goto L54;
        if (r102 != null) goto L25;
        r102 = new JSONObject();
    L25:
        String r103 = r102.optString("user_id");
        if (TextUtils.isEmpty(r103) == false) goto L28;
        r111.put("code", 0);
        goto L54
    L28:
        String r104 = r102.optString("sec_user_id");
        if (TextUtils.isEmpty(r104) == false) goto L31;
        r104 = r102.optString("sec_uid");
    L31:
        String r105 = r102.optString("source");
        String r112 = r102.optString("click_user_position");
        String r113 = r102.optString("vs_follow_position");
        String r114 = r102.optString("mystery_man");
        HashMap r106 = new HashMap();
        if (TextUtils.isEmpty(r104) == true) goto L35;
        r106.put("sec_user_id", r104);
    L35:
        if (TextUtils.isEmpty(r105) == true) goto L38;
        r106.put("source", r105);
    L38:
        if (TextUtils.isEmpty(r112) == true) goto L41;
        r106.put("click_user_position", r112);
    L41:
        if (TextUtils.isEmpty(r113) == true) goto L44;
        r106.put("vs_follow_position", r113);
    L44:
        if (TextUtils.isEmpty(r114) == true) goto L46;
        r106.put("mystery_man", r114);
    L46:
        IBaseLiveActionHandler r107 = (IBaseLiveActionHandler) k.n(IBaseLiveActionHandler.class);
        WeakReference<Context> r108 = this.f560944a;
        if (r108 == null) goto L49;
        Context r109 = r108.get();
    L50:
        r111.put("code", r107.showUserProfileExt(r109, r103, r102.optString("type"), r106) ? 1 : 0);
        return;
    L49:
        r109 = null;
    L54:
        return;
    L15:
        r102 = null;
    }
}
