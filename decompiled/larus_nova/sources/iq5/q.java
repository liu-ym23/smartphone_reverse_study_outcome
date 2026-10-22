package iq5;

import android.app.Application;
import com.bytedance.ee.bear.list.selector.SelectorScope;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class q implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SelectorScope f495376a;

    @Override // iq5.p
    public final /* synthetic */ float b() {
        return 16.0f;
    }

    @Override // iq5.p
    public final /* synthetic */ int d() {
        return 0;
    }

    @Override // iq5.p
    public final int height() {
        return com.bytedance.ee.util.ui.n.d(48);
    }

    @Override // iq5.p
    public final String title() {
        Application r100 = eu5.b.f474075a;
        int r101 = jq5.a.f500067a;
        if (qc5.a.h() == false) goto L5;
        int r102 = R.string.Doc_List_My_Folder;
    L7:
        return r100.getString(r102);
    L5:
        r102 = R.string.Doc_List_My_Space;
        goto L7
    }

    @Override // iq5.p
    public final int c() {
        return kac.a.b(R.drawable.ud_icon_file_folder_colorful);
    }

    public q(SelectorScope r100) {
        Intrinsics.checkNotNullParameter(r100, "selectorScope");
        this.f495376a = r100;
    }

    @Override // iq5.p
    public final boolean a(ce5.a r100) {
        Intrinsics.checkNotNullParameter(r100, "userComponentAbility");
        SelectorScope r101 = this.f495376a;
        if (r101 != SelectorScope.ALL) goto L5;
    L8:
        return true;
    L5:
        if (r101 == SelectorScope.SPACE_ONLY) goto L8;
        return false;
    }
}
