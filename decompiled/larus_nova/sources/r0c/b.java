package r0c;

import android.content.Context;
import android.text.TextUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes37.dex */
public final class b implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f535515a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f535516b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f535517c;

    @Override // r0c.d
    public final String a() {
        return UIUtils.getString(this.f535515a, R.string.Lark_Legacy_Copy);
    }

    @Override // r0c.d
    public final Runnable getAction() {
        return new a(this);
    }

    @Override // r0c.d
    public final boolean isValid() {
        if (this.f535516b == true) goto L5;
    L7:
        return false;
    L5:
        if (TextUtils.isEmpty(this.f535517c) == true) goto L7;
        return true;
    }

    public b(Context r100, boolean r101, String r102) {
        this.f535515a = r100;
        this.f535516b = r101;
        this.f535517c = r102;
    }
}
