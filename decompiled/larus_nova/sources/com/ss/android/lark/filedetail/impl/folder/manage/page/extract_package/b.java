package com.ss.android.lark.filedetail.impl.folder.manage.page.extract_package;

import androidx.lifecycle.Observer;
import com.ss.android.lark.log.Log;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class b<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ExtractPackageFragment f421720a;

    public b(ExtractPackageFragment r100) {
        this.f421720a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Pair r101 = (Pair) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        if (((CharSequence) r101.getFirst()).length() != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
        return;
    L8:
        if (r101.getSecond() != null) goto L11;
        return;
    L11:
        if (Intrinsics.areEqual(this.f421720a.f421697e.b(), r101.getFirst()) == false) goto L23;
        StringBuilder r103 = new StringBuilder("file key = ");
        r103.append((String) r101.getFirst());
        r103.append(", size = ");
        nfb.c r104 = (nfb.c) r101.getSecond();
        if (r104 == null) goto L18;
        List<nfb.a> r105 = r104.f519011a;
        if (r105 == null) goto L18;
        Integer r106 = Integer.valueOf(r105.size());
    L19:
        r103.append(r106);
        Log.i("ExtractPackageFragment", r103.toString());
        this.f421720a.f421697e.e((String) r101.getFirst(), (nfb.c) r101.getSecond());
        return;
    L18:
        r106 = null;
        goto L19
    L23:
        return;
    L5:
        r102 = false;
        goto L6
    }
}
