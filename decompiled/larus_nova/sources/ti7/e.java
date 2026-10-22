package ti7;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.ug.sdk.luckycat.impl.manager.r;
import java.net.URLEncoder;

/* JADX INFO: loaded from: classes22.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f546234a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f546235b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f546236c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f546237d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f546238e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f546239f;

    public final String a() {
        int r100 = this.f546234a;
        if (r100 <= 0) goto L5;
        String r101 = r.f271366b.a(r100);
    L7:
        if (this.f546236c == false) goto L12;
        Uri.Builder r102 = UriProtector.parse("sslocal://polaris").buildUpon();
        Uri.Builder r103 = UriProtector.parse(r101).buildUpon();
        if (TextUtils.isEmpty(null) == true) goto L11;
        r103.appendQueryParameter("enter_from", null);
    L11:
        r102.appendQueryParameter("url", URLEncoder.encode(r103.toString()));
    L15:
        if (r102 != null) goto L19;
        return "";
    L19:
        if (this.f546235b == false) goto L22;
        r102.appendQueryParameter("hide_bar", String.valueOf(1));
    L22:
        if (this.f546237d == false) goto L25;
        r102.appendQueryParameter("hide_status_bar", String.valueOf(1));
    L25:
        if (this.f546238e == false) goto L28;
        r102.appendQueryParameter("hide_back_button", String.valueOf(1));
    L28:
        if (TextUtils.isEmpty(this.f546239f) == true) goto L31;
        r102.appendQueryParameter("back_button_color", this.f546239f);
    L31:
        return r102.toString();
    L12:
        r102 = UriProtector.parse(r101).buildUpon();
        if (TextUtils.isEmpty(null) == true) goto L15;
        r102.appendQueryParameter("enter_from", null);
        goto L15
    L5:
        r101 = null;
        goto L7
    }

    public e() {
    }
}
