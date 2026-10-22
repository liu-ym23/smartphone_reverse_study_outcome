package com.bytedance.ee.bear.bitable.card.view.cell.text;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ee.bear.at.MentionData;
import com.bytedance.ee.bear.at.MentionTitleResult;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.utils.AtUtils;
import io.reactivex.functions.Function;

/* JADX INFO: loaded from: classes15.dex */
public final class f implements Function<MentionTitleResult, db5.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f208250a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BearUrl f208251b;

    @Override // io.reactivex.functions.Function
    public final /* bridge */ /* synthetic */ db5.a apply(MentionTitleResult r100) throws Exception {
        return c(r100);
    }

    public final db5.a c(MentionTitleResult r310) {
        if (this.f208251b == null) goto L13;
        if (r310 == null) goto L13;
        DATA r100 = r310.data;
        if (r100 == 0) goto L13;
        MentionData r101 = (MentionData) r100;
        int r102 = AtUtils.e(r101.type);
        String r103 = this.f208251b.f222561b;
        String r104 = r101.title;
        if (TextUtils.isEmpty(r104) == false) goto L10;
        r104 = ng5.a.b(this.f208250a, r101.type);
    L10:
        int r105 = r104.length();
        String r106 = this.f208251b.f222564e;
        int r107 = r101.icon_type;
        String r110 = r104;
        return new db5.a(r104, new bo4.a[]{new bo4.a(0, r105, r102, -1, r103, r106, r110, null, null, null, null, "", r101.icon_fsunit, r101.icon_key, r107, false, null, false, false, "", "", null, null, null, 0)}, new db5.j[0]);
    L13:
        return new db5.a();
    }

    public f(Context r100, BearUrl r101) {
        this.f208250a = r100;
        this.f208251b = r101;
    }
}
