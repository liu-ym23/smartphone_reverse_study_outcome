package ye8;

import android.content.Context;
import android.net.Uri;
import com.larus.im.bean.message.Message;
import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import ic8.n0;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes4.dex */
public interface b {

    /* JADX INFO: loaded from: classes25.dex */
    public static final class a {
        public static /* synthetic */ void a(b r100, Context r101, String r102, String r110, AbsDownloadListener r111) {
            r100.c(r101, r102, r110, false, null, r111);
        }

        public static /* synthetic */ n0 c(b r100, String r101, boolean r110, ns8.a r111, ns8.b r112, int r113) {
            if ((r113 & 4) == 0) goto L5;
            ns8.a r102 = null;
        L7:
            if ((r113 & 8) == 0) goto L9;
            ns8.b r103 = null;
        L11:
            return r100.f(r101, r110, r102, r103, false);
        L9:
            r103 = r112;
            goto L11
        L5:
            r102 = r111;
            goto L7
        }

        public static /* synthetic */ n0 b(b r100, Uri r110, boolean r111, ns8.a r112, String r113, ns8.b r114, int r115) {
            if ((r115 & 4) == 0) goto L5;
            ns8.a r101 = null;
        L7:
            if ((r115 & 8) == 0) goto L9;
            String r102 = null;
        L11:
            if ((r115 & 16) == 0) goto L13;
            ns8.b r103 = null;
        L15:
            return r100.e(r110, r111, r101, r102, r103, false);
        L13:
            r103 = r114;
            goto L15
        L9:
            r102 = r113;
            goto L11
        L5:
            r101 = r112;
            goto L7
        }
    }

    Object a(Message r100, Continuation<? super Unit> r101);

    String b(boolean r100, String r101, boolean r102);

    void c(Context r100, String r101, String r102, boolean r103, String r104, AbsDownloadListener r105);

    String d();

    n0 e(Uri r100, boolean r101, ns8.a r102, String r103, ns8.b r104, boolean r105);

    n0 f(String r100, boolean r101, ns8.a r102, ns8.b r103, boolean r104);
}
