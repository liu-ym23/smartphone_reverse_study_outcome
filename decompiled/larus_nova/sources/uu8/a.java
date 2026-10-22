package uu8;

import android.os.Bundle;

/* JADX INFO: loaded from: classes26.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bundle f551780a;

    public final String a() {
        String r100 = this.f551780a.getString("click_from");
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r100.length() != 0) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == false) goto L11;
        r100 = null;
    L11:
        return r100;
    L7:
        r101 = false;
        goto L8
    }

    public final String b() {
        String r100 = this.f551780a.getString("create_way");
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r100.length() != 0) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == false) goto L11;
        r100 = null;
    L11:
        return r100;
    L7:
        r101 = false;
        goto L8
    }

    public final String c() {
        String r100 = this.f551780a.getString("creation_id");
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r100.length() != 0) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == false) goto L11;
        r100 = null;
    L11:
        return r100;
    L7:
        r101 = false;
        goto L8
    }

    public a() {
        this.f551780a = new Bundle();
    }
}
