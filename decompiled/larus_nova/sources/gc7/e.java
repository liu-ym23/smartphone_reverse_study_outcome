package gc7;

import android.content.ContentValues;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.account.impl.j;
import com.tencent.connect.common.Constants;
import java.util.HashSet;

/* JADX INFO: loaded from: classes22.dex */
public final class e extends hc7.a<d.c> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f480877c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f480878d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Context f480879e;

    @Override // hc7.a
    public final d.c a() {
        jc7.b r100 = jc7.b.a.f498144a;
        String r101 = this.f480877c;
        String r102 = this.f480878d;
        r100.getClass();
        if (TextUtils.isEmpty(r101) == false) goto L5;
    L12:
        boolean r103 = false;
    L13:
        tb7.a.a("SaveService", "updateSecUid res = " + r103);
        if (r103 == false) goto L20;
        j r104 = j.m(this.f480879e);
        String r105 = this.f480877c;
        if (r104.V.a() != null) goto L18;
        r104.V.c(new HashSet());
    L18:
        r104.V.a().add(r105);
        r104.P0.edit().putStringSet("has_update_sec_uids", r104.V.a()).apply();
        return new d.c(0, null);
    L20:
        return new d.c(-1, "数据更新失败或者没有此数据");
    L5:
        if (TextUtils.isEmpty(r102) == true) goto L12;
        if (r100.b() == false) goto L12;
        ContentValues r106 = new ContentValues();
        r106.put("sec_uid", r102);
        r103 = true;
        if (r100.f498143b.update(Constants.LOGIN_INFO, r106, "uid = ?", new String[]{r101}) == 0) goto L12;
        goto L12
    }

    @Override // hc7.a
    public final /* bridge */ /* synthetic */ void c(d.c r100) {
    }

    public e(String r100, String r101, Context r102) {
        this.f480877c = r100;
        this.f480878d = r101;
        this.f480879e = r102;
    }
}
