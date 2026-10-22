package qo7;

import android.content.Context;
import com.larus.nova.R;
import no7.b;
import no7.c;

/* JADX INFO: loaded from: classes22.dex */
public class a implements b {
    private Context mContext;

    @Override // no7.b
    public c getChannelHandler() {
        return null;
    }

    public int getChannelIcon() {
        return R.drawable.share_sdk_share_icon_save_video;
    }

    @Override // no7.b
    public String getPackageName() {
        return null;
    }

    public boolean needFiltered() {
        return false;
    }

    @Override // no7.b
    public String getChannelName() {
        return this.mContext.getString(R.string.share_sdk_action_save_video);
    }

    public a(Context r100) {
        this.mContext = r100;
    }

    @Override // no7.b
    public no7.a getChannel(Context r100) {
        return new po7.a(r100);
    }
}
