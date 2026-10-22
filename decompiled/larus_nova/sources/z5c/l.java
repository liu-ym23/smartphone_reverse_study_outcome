package z5c;

import com.larus.bmhome.share.panel.ShareChannel;
import com.ss.android.lark.notification.export.AbstractNotification;

/* JADX INFO: loaded from: classes38.dex */
public final class l extends s5c.g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final s5c.a f570240c = null;

    static {
        l r100 = new l();
        r100.a("im_card");
        r100.a(AbstractNotification.CHANNEL_TYPE.DOC_FEED);
        r100.a("doc_web");
        r100.a("unknown");
        r100.a("app_schedule");
        r100.a(ShareChannel.WX_MOMENTS);
        r100.a("im_input_card");
        r100.a("doc");
        f570240c = r100.a("im_group_name");
    }

    public l() {
        super("card_source");
    }
}
