package hb7;

import android.view.View;
import com.bytedance.sdk.account.dialog.AccountButtonStyle;

/* JADX INFO: loaded from: classes22.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f484490a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View.OnClickListener f484491b;

    public a(String r100, View.OnClickListener r101) {
        this(r100, r101, 4, 0);
    }

    public a(String r100, View.OnClickListener r101, int r102) {
        this.f484490a = r100;
        this.f484491b = r101;
    }

    public /* synthetic */ a(String r100, View.OnClickListener r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r102 & 4) == 0) goto L8;
        AccountButtonStyle r104 = AccountButtonStyle.NORMAL;
    L8:
        this(r100, r101, 0);
    }
}
