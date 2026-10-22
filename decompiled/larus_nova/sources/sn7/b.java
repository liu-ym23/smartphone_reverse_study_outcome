package sn7;

import android.content.Context;
import com.larus.nova.R;
import oo7.p;

/* JADX INFO: loaded from: classes22.dex */
public class b implements no7.b {
    public static final String PACKAGE_NAME = "com.tencent.mobileqq";
    private Context mContext;

    public int getChannelIcon() {
        return R.drawable.share_sdk_share_icon_qq;
    }

    @Override // no7.b
    public String getPackageName() {
        return "com.tencent.mobileqq";
    }

    @Override // no7.b
    public no7.c getChannelHandler() {
        return new c();
    }

    @Override // no7.b
    public String getChannelName() {
        return this.mContext.getString(R.string.share_sdk_action_qq_share);
    }

    public boolean needFiltered() {
        return !p.b("com.tencent.mobileqq");
    }

    public b(Context r100) {
        this.mContext = r100;
    }

    @Override // no7.b
    public no7.a getChannel(Context r100) {
        return new a(r100);
    }
}
