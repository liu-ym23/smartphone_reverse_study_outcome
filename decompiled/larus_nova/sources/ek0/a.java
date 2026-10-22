package ek0;

import android.content.DialogInterface;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class a implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f472926a = null;

    static {
        f472926a = new a();
    }

    public a() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        r100.dismiss();
    }
}
