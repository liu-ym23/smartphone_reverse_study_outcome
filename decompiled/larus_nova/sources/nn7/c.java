package nn7;

import android.content.Context;
import com.larus.nova.R;
import oo7.p;

/* JADX INFO: loaded from: classes22.dex */
public class c implements no7.b {
    public static final String LITE_PACKAGE_NAME = "com.ss.android.ugc.aweme.lite";
    public static final String PACKAGE_NAME = "com.ss.android.ugc.aweme";
    private Context mContext;

    @Override // no7.b
    public no7.c getChannelHandler() {
        return null;
    }

    public int getChannelIcon() {
        return R.drawable.share_sdk_share_icon_douyin;
    }

    @Override // no7.b
    public String getPackageName() {
        return "com.ss.android.ugc.aweme";
    }

    @Override // no7.b
    public String getChannelName() {
        return this.mContext.getString(R.string.share_sdk_action_dy_share);
    }

    public boolean needFiltered() {
        if (p.b("com.ss.android.ugc.aweme") == false) goto L5;
    L7:
        return false;
    L5:
        if (p.b("com.ss.android.ugc.aweme.lite") == true) goto L7;
        return true;
    }

    public c(Context r100) {
        this.mContext = r100;
    }

    @Override // no7.b
    public no7.a getChannel(Context r100) {
        return new b(r100);
    }
}
