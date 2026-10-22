package x82;

import com.bytedance.android.livesdk.interactivity.medialink.contract.MediaMultiAnchorLinkContext;
import com.bytedance.android.livesdk.interactivity.medialink.ui.window.UILayout;
import com.bytedance.android.livesdkapi.model.SeiAppData;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.j;
import f92.f;

/* JADX INFO: loaded from: classes9.dex */
public interface e {
    public static final a A2 = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f562894a = null;

        public a() {
        }

        static {
            f562894a = new a();
        }

        public static e a() {
            DataContext r100 = com.bytedance.live.datacontext.d.d(MediaMultiAnchorLinkContext.class);
            if ((r100 instanceof MediaMultiAnchorLinkContext) == true) goto L5;
            r100 = null;
        L5:
            MediaMultiAnchorLinkContext r101 = (MediaMultiAnchorLinkContext) r100;
            if (r101 == null) goto L11;
            j<e> r102 = r101.getLayoutService();
            if (r102 != null) goto L10;
            return null;
        L10:
            return r102.getValue();
        L11:
            return null;
        }
    }

    static {
        A2 = a.f562894a;
    }

    void Oe(SeiAppData r100);

    f Q8();

    void ah();

    UILayout getDefaultUILayout();

    UILayout getUILayout();

    void kg(UILayout r100, String r101, boolean r102);

    void of(int r100);
}
