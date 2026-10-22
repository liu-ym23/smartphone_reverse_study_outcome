package faceverify;

import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaMuxer;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.dtf.face.log.RecordConst;
import com.dtf.face.log.RecordService;
import com.dtf.face.photinus.VideoFormatConfig;
import com.dtf.face.photinus.VideoWriter;
import com.dtf.face.utils.ClientConfigUtil;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes41.dex */
public class k implements ps7.a, j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j f476140a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CopyOnWriteArrayList<is7.b> f476141b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f476142c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f476143d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f476144e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f476145f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f476146g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f476147h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f476148i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public VideoFormatConfig f476149j;

    public void b() {
        monitor-enter(this);
    L58:
        th = move-exception;
        throw th;
    L4:
        if (this.f476146g <= 0) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L58
        return;
    L7:
        this.f476146g = System.currentTimeMillis();     // Catch: Throwable -> L58
        monitor-exit(this);     // Catch: Throwable -> L58
        CopyOnWriteArrayList<is7.b> r100 = this.f476141b;
        boolean r101 = true;
        if (r100 != null) goto L12;
    L56:
        RecordService.getInstance().recordEvent(4, "VideoMakerError", new String[]{RecordConst.LOG_ERR_TYPE, "start", "errMsg", "NOData", "fileName", this.f476142c});
        a();
        return;
    L12:
        if (r100.size() == 0) goto L56;
        RecordService.getInstance().recordEvent(4, "VideoMaker", new String[]{"status", "start", "fileName", this.f476142c, "size", String.valueOf(this.f476141b.size())});
        if (this.f476143d == (-1)) goto L21;
        if (this.f476144e == (-1)) goto L21;
        if (this.f476145f == (-1)) goto L21;
    L24:
        if (ClientConfigUtil.f() == false) goto L26;
        c();
        return;
    L26:
        Context r102 = hs7.a.h().getContext();
        ArrayList<ByteBuffer> r103 = ws7.a.b(this.f476141b);
        int r104 = this.f476143d;
        int r110 = this.f476144e;
        int r111 = this.f476145f;
        String r105 = this.f476142c;
        VideoFormatConfig r106 = this.f476149j;
        ps7.e.f530457a = true;
        ps7.e.a r107 = ps7.e.d(r102, r110, r111, r105, r106, r104);     // Catch: Exception -> L29
    L31:
        if (r107 != null) goto L33;
        return;
    L33:
        if (r107.f530458a != null) goto L35;
    L39:
        r101 = false;
    L40:
        if (r101 == false) goto L69;
        Iterator<ByteBuffer> r108 = r103.iterator();     // Catch: Exception -> L53
        int r109 = 0;
    L43:
        if (r108.hasNext() == false) goto L45;
        ps7.e.b(r109, VideoWriter.a(r108.next().array(), r110, r111, r104), r107);     // Catch: Exception -> L53
        r109 = r109 + 1;     // Catch: Exception -> L53
        goto L43
    L45:
        ps7.e.b(r109, null, r107);     // Catch: Exception -> L53
        MediaCodec r112 = r107.f530458a;     // Catch: Exception -> L53
        if (r112 == null) goto L48;
        r112.stop();     // Catch: Exception -> L53
        r107.f530458a.release();     // Catch: Exception -> L53
        r107.f530458a = null;     // Catch: Exception -> L53
    L48:
        MediaMuxer r113 = r107.f530459b;     // Catch: Exception -> L53
        if (r113 == null) goto L51;
        r113.stop();     // Catch: Exception -> L53
        r107.f530459b.release();     // Catch: Exception -> L53
        r107.f530459b = null;     // Catch: Exception -> L53
        r107.f530461d = false;     // Catch: Exception -> L53
    L51:
        onVideoWriteSuccess(Uri.fromFile(r107.f530460c));     // Catch: Exception -> L53
        return;
    L53:
        e = move-exception;
        onVideoWriteError(RecordService.getStackTraceString(e));
        return;
    L69:
        return;
    L35:
        if (r107.f530459b == null) goto L39;
        if (r107.f530460c == null) goto L39;
    L29:
        e = move-exception;
        onVideoWriteError(RecordService.getStackTraceString(e));
        r107 = null;
    L21:
        if (this.f476141b.size() <= 0) goto L24;
        this.f476143d = this.f476141b.get(0).f495634j;
        this.f476144e = this.f476141b.get(0).f495632h;
        this.f476145f = this.f476141b.get(0).f495633i;
        goto L24
    }

    public final void c() {
        this.f476148i = true;     // Catch: Exception -> L5
        ws7.f.e(Uri.withAppendedPath(ps7.e.c(hs7.a.h().getContext()), this.f476142c + ".mp4").getPath());     // Catch: Exception -> L5
        String r100 = Uri.withAppendedPath(ps7.e.c(hs7.a.h().getContext()), this.f476142c + ".zip").getPath();     // Catch: Exception -> L5
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100);     // Catch: Exception -> L5
        ws7.f.f(r101);     // Catch: Exception -> L5
        ws7.u.a(ws7.a.b(this.f476141b), r101, this.f476144e, this.f476145f, this.f476143d);     // Catch: Exception -> L5
        a(r100, ws7.i.e(r100));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        RecordService.getInstance().recordEvent(4, "VideoMakerError", new String[]{RecordConst.LOG_ERR_TYPE, "zipVideoFrames", "errMsg", RecordService.getStackTraceString(e), "fileName", this.f476142c});
        a();
    }

    @Override // faceverify.j
    public void a() {
        this.f476147h = System.currentTimeMillis();
        RecordService.getInstance().recordEvent(4, "VideoMakerFailed", new String[]{"fileName", this.f476142c, ChameleonOpenTracker.ParamKey.COST, String.valueOf(this.f476147h - this.f476146g), "hasZip", String.valueOf(this.f476148i)});
        j r100 = this.f476140a;
        if (r100 == null) goto L6;
        r100.a();
        return;
    }

    @Override // ps7.a
    public void onVideoWriteError(String r100) {
        RecordService r101 = RecordService.getInstance();
        String[] r102 = new String[6];
        r102[0] = RecordConst.LOG_ERR_TYPE;
        r102[1] = "onVideoWriteError";
        r102[2] = "errMsg";
        if (r100 != null) goto L6;
        r100 = "";
    L6:
        r102[3] = r100;
        r102[4] = "fileName";
        r102[5] = this.f476142c;
        r101.recordEvent(4, "VideoMakerError", r102);
        c();
    }

    @Override // ps7.a
    public void onVideoWriteSuccess(Uri r100) {
        if (r100 != null) goto L4;
    L10:
        String r101 = "NoUri";
    L11:
        RecordService.getInstance().recordEvent(4, "VideoMakerError", new String[]{RecordConst.LOG_ERR_TYPE, "onVideoWriteSuccess", "errMsg", r101, "fileName", this.f476142c});
        c();
        return;
    L4:
        if (r100.getPath() == null) goto L10;
        String r102 = r100.getPath();
        if (TextUtils.isEmpty(r102) == true) goto L9;
        a(r102, ws7.i.e(r102));
        return;
    L9:
        r101 = "NoPath";
        goto L11
    }

    @Override // faceverify.j
    public void a(String r100, String r101) {
        this.f476147h = System.currentTimeMillis();
        RecordService r102 = RecordService.getInstance();
        String[] r103 = new String[14];
        r103[0] = "fileName";
        r103[1] = this.f476142c;
        r103[2] = ChameleonOpenTracker.ParamKey.COST;
        r103[3] = String.valueOf(this.f476147h - this.f476146g);
        r103[4] = "fameCount";
        CopyOnWriteArrayList<is7.b> r104 = this.f476141b;
        if (r104 == null) goto L5;
        String r105 = String.valueOf(r104.size());
    L6:
        r103[5] = r105;
        r103[6] = "rotation";
        r103[7] = String.valueOf(this.f476143d);
        r103[8] = "width";
        r103[9] = String.valueOf(this.f476144e);
        r103[10] = "height";
        r103[11] = String.valueOf(this.f476145f);
        r103[12] = "hasZip";
        r103[13] = String.valueOf(this.f476148i);
        r102.recordEvent(4, "VideoMakerSuccess", r103);
        j r106 = this.f476140a;
        if (r106 == null) goto L10;
        r106.a(r100, r101);
        return;
    L10:
        return;
    L5:
        r105 = "0";
        goto L6
    }

    public k(CopyOnWriteArrayList<is7.b> r100, String r101, j r102) {
        this.f476143d = -1;
        this.f476144e = -1;
        this.f476145f = -1;
        this.f476146g = -1;
        this.f476147h = -1;
        this.f476148i = false;
        this.f476149j = VideoFormatConfig.L;
        this.f476140a = r102;
        this.f476141b = r100;
        this.f476142c = r101;
    }
}
