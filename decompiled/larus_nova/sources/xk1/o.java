package xk1;

import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.android.livesdk.live.extension.plugin.api.resourcemanager.downloader.LiveWrappedTask;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.collection.WeakHandler;
import com.ss.ttvideoengine.model.VideoInfo;
import com.ss.ttvideoengine.model.VideoRef;
import com.ss.ttvideoengine.utils.TTHelper;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public final class o implements WeakHandler.IHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f564171a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final tp1.a f564172b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f564173c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f564174d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f564175e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LiveWrappedTask f564176f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public a f564177g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final WeakHandler f564178h;

    public interface a {
    }

    public final String a() {
        tp1.a r100 = this.f564172b;
        if (r100 != null) goto L7;
        return "";
    L7:
        return r100.f547000a;
    }

    public final void b() {
        tp1.a r100 = this.f564172b;
        if (r100 == null) goto L14;
        VideoRef r101 = r100.f547009j;
        if (r101 == null) goto L14;
        VideoInfo r102 = q.a(r100.f547007h, r101);
        if (r102 == null) goto L10;
        String r103 = r102.getValueStr(0);
    L12:
        if (StringUtils.isEmpty(r103) == true) goto L14;
        String r104 = TTHelper.base64Decode(r103);
    L15:
        Message r105 = Message.obtain();
        if (TextUtils.isEmpty(r104) == true) goto L18;
        r105.what = 12;
        r105.obj = r104;
        this.f564178h.sendMessage(r105);
        return;
    L18:
        r105.what = 13;
        tp1.a r106 = this.f564172b;
        if (r106 == null) goto L21;
        String r107 = r106.f547000a;
    L22:
        r105.obj = r107;
        this.f564178h.sendMessage(r105);
        return;
    L21:
        r107 = "-1";
        goto L22
    L10:
        r103 = null;
    L14:
        r104 = "";
        goto L15
    }

    public final String toString() {
        tp1.a r100 = this.f564172b;
        if (r100 != null) goto L6;
        return "null";
    L6:
        return r100.toString();
    }

    public o(tp1.a r100) {
        this.f564173c = 0;
        this.f564174d = false;
        this.f564175e = 0;
        this.f564178h = new WeakHandler(Looper.getMainLooper(), this);
        this.f564172b = r100;
    }

    public final void c(int r100) {
        this.f564175e = r100;
        this.f564172b.f547013n.f547020c = r100;
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public final void handleMsg(Message r100) {
        this.f564174d = false;
        int r101 = r100.what;
        if (r101 != 13) goto L10;
        a r102 = this.f564177g;
        if (r102 == null) goto L10;
        ((b.C8246b) r102).a();
        new JSONObject().put("video_id", (String) r100.obj);     // Catch: Throwable -> L34
        return;
    L44:
        return;
    L10:
        if (r101 != 12) goto L37;
        a r103 = this.f564177g;
        if (r103 == null) goto L38;
        String r104 = (String) r100.obj;
        if (this.f564172b == null) goto L32;
        LiveWrappedTask.b r105 = new LiveWrappedTask.b();
        String r106 = i.f().f564150f + this.f564172b.f547000a;
        if ((!TextUtils.isEmpty(r106)) == false) goto L31;
        r105.f147295a = r106;
        if ((!TextUtils.isEmpty(r104)) == false) goto L29;
        r105.f147296b = r104;
        r105.f147297c = false;
        r105.f147298d = false;
        r105.f147300f = true;
        r105.f147301g = 1000;
        r105.f147299e = 5;
        this.f564176f = r105.a();
        b.C8246b r107 = (b.C8246b) this.f564177g;
        o r108 = r107.f564132a;
        if (r108.f564175e == 1) goto L23;
        r107.f564135d.f564130d[r107.f564133b] = null;
        return;
    L23:
        if (r108.f564173c == r107.f564134c) goto L25;
        r107.f564135d.f564130d[r107.f564133b] = null;
        return;
    L25:
        r107.f564135d.getClass();
        if (Logger.debug() == false) goto L41;
        Logger.d("DownloadDispatcher", "checkTask registerDownloadCallback & resume");
        return;
    L41:
        return;
    L29:
        throw new IllegalArgumentException("url is empty".toString());
    L31:
        throw new IllegalArgumentException("path is empty".toString());
    L32:
        ((b.C8246b) r103).a();
        return;
    L38:
        return;
    }
}
