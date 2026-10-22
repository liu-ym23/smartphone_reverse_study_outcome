package com.larksuite.component.blockit.hashtag.list;

import android.content.DialogInterface;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes24.dex */
public final class d implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f283045a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ oy7.e f283046b;

    public d(b r100, oy7.e r101) {
        this.f283045a = r100;
        this.f283046b = r101;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        HashTagSwipeAdapter r102 = this.f283045a.f283043e;
        if (r102 == null) goto L5;
        r102.y2();
    L5:
        oy7.e r103 = this.f283046b;
        String r104 = r103.f527151b;
        if (r104 == null) goto L15;
        b r105 = this.f283045a;
        JSONObject r106 = new JSONObject(r105.f283041c);
        HashTagSwipeAdapter r107 = r105.f283043e;
        if (r107 == null) goto L10;
        Integer r108 = Integer.valueOf(r107.getItemCount());
    L11:
        r106.put("tag_count", r108);
        r106.put("tag_id", r103.f527150a);
        qy7.a.a("pano_action_panel_delete_tag", r106);
        k.a r109 = r105.f283042d;
        if (r109 == null) goto L16;
        r109.M3(r103.f527150a, r104);
        return;
    L16:
        return;
    L10:
        r108 = null;
        goto L11
    }
}
