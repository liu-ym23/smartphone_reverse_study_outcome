package un7;

import android.content.Context;
import com.larus.nova.R;
import oo7.p;

/* JADX INFO: loaded from: classes22.dex */
public class e implements no7.b {
    public static final String PACKAGE_NAME = "com.tencent.mm";
    private Context mContext;

    @Override // no7.b
    public no7.c getChannelHandler() {
        return null;
    }

    public int getChannelIcon() {
        return R.drawable.share_sdk_share_icon_circle_friends;
    }

    @Override // no7.b
    public String getPackageName() {
        return "com.tencent.mm";
    }

    @Override // no7.b
    public String getChannelName() {
        return this.mContext.getString(R.string.share_sdk_action_weixin_timeline);
    }

    public boolean needFiltered() {
        return !p.b("com.tencent.mm");
    }

    public e(Context r100) {
        this.mContext = r100;
    }

    @Override // no7.b
    public no7.a getChannel(Context r100) {
        return new a(r100);
    }
}
