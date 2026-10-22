package fy3;

import android.os.Handler;
import com.bytedance.awemeopen.apps.framework.utils.n0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d implements com.bytedance.awemeopen.infra.base.image.a {
    public final /* synthetic */ b a;

    public final void onSuccess() {
    }

    public final void onFail() {
        if (n0.c(this.a.d.e.getContext()) == false) goto L5;
        final String r0 = "https://p6-webcast.douyinpic.com/img/webcast/video_test/company_header_image_dark.png~tplv-obj.image";
    L6:
        final b r1 = this.a;
        new Handler().post(new c(r1, r0));
        return;
    L5:
        r0 = "https://p6-webcast.douyinpic.com/img/webcast/video_test/company_header_image_light.png~tplv-obj.image";
        goto L6
    }

    public d(b r1) {
        this.a = r1;
    }
}
