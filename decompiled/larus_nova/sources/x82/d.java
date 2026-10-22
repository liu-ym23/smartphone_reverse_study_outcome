package x82;

import com.bytedance.android.livesdk.interactivity.medialink.contract.MediaMultiAnchorLinkContext;
import com.bytedance.android.livesdk.interactivity.medialink.widget.mixer.WindowsPosition;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.j;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes9.dex */
public interface d {

    /* JADX INFO: renamed from: z2, reason: collision with root package name */
    public static final a f562892z2 = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f562893a = null;

        public a() {
        }

        static {
            f562893a = new a();
        }

        public static d a() {
            DataContext r100 = com.bytedance.live.datacontext.d.d(MediaMultiAnchorLinkContext.class);
            if ((r100 instanceof MediaMultiAnchorLinkContext) == true) goto L5;
            r100 = null;
        L5:
            MediaMultiAnchorLinkContext r101 = (MediaMultiAnchorLinkContext) r100;
            if (r101 == null) goto L11;
            j<d> r102 = r101.getEnlargeService();
            if (r102 != null) goto L10;
            return null;
        L10:
            return r102.getValue();
        L11:
            return null;
        }
    }

    static {
        f562892z2 = a.f562893a;
    }

    void A5(String r100, boolean r101);

    void P4(String r100, boolean r101);

    Map<String, WindowsPosition> gc(List<String> r100);

    boolean t4(String r100);

    boolean x5(String r100);

    String zd();
}
