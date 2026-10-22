package xmc;

import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.ss.android.lark.imagewidget.subsampling.decoder.custom.MSkiaImageRegionDecoder;
import com.ss.mediakit.medialoader.AVMDLDataLoader;
import com.ss.mediakit.medialoader.AVMDLDataLoaderConfigure;
import com.ss.mediakit.medialoader.AVMDLDataLoaderListener;
import com.ss.mediakit.medialoader.AVMDLDataLoaderNotifyInfo;
import com.ss.ttm.player.MediaPlayer;
import com.ss.ttvideoengine.DataLoaderHelper;
import com.ss.videoarch.liveplayer.log.LiveLoggerService;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public final class c implements AVMDLDataLoaderListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AVMDLDataLoaderConfigure f564591a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f564592b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile xmc.a f564593c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public xmc.b f564594d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public MediaPlayer f564595e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f564596f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f564597g;

    public static /* synthetic */ class a {
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f564598a = null;

        private b() {
        }

        static {
            f564598a = new c(null);
        }

        public static /* synthetic */ c access$100() {
            return f564598a;
        }
    }

    public void enableLoadLibrary() {
        this.f564597g = true;
    }

    @Override // com.ss.mediakit.medialoader.AVMDLDataLoaderListener
    public String getCheckSumInfo(String r100) {
        return null;
    }

    @Override // com.ss.mediakit.medialoader.AVMDLDataLoaderListener
    public String getStringValue(int r100, long r101, String r102) {
        return null;
    }

    public void setLogService(LiveLoggerService r100) {
    }

    private boolean initInternal() {
        if (this.f564597g == true) goto L5;
    L21:
        AVMDLDataLoader.getInstance().setListener(107, this);     // Catch: Exception -> L18
        return true;
    L18:
        e = move-exception;
        e.printStackTrace();
        com.ss.videoarch.liveplayer.log.c.i("MediaLoaderWrapper", String.format("create loader failed: exception is" + e.toString(), new Object[0]));
        return false;
    L5:
        if (loadLibrary() == true) goto L9;
        com.ss.videoarch.liveplayer.log.c.i("MediaLoaderWrapper", String.format("library load fail", new Object[0]));
        return false;
    L9:
        if (this.f564593c == null) goto L11;
        boolean r100 = true;
    L13:
        if (AVMDLDataLoader.init(r100) == 0) goto L21;
        com.ss.videoarch.liveplayer.log.c.d("MediaLoaderWrapper", String.format("library has not been loaded", new Object[0]));
        return false;
    L11:
        r100 = false;
        goto L13
    }

    private boolean loadLibrary() {
        if (this.f564593c != null) goto L7;
        return true;
    L7:
        if (this.f564593c == null) goto L12;
        if (this.f564592b == true) goto L12;
        this.f564592b = this.f564593c.loadLibrary("avmdl");
    L12:
        return this.f564592b;
    }

    public void close() {
        if (this.f564596f == true) goto L6;
        com.ss.videoarch.liveplayer.log.c.e("MediaLoaderWrapper", "MediaLoader not started, not need close");
        return;
    L6:
        this.f564594d = null;
        AVMDLDataLoader.getInstance().close();
        AVMDLDataLoader.getInstance().cancelAll();
        this.f564596f = false;
    }

    public void start() throws Exception {
        if (this.f564596f == false) goto L6;
        return;
    L6:
        if (initInternal() == false) goto L38;
        JSONObject r100 = new JSONObject();
        String r101 = com.ss.videoarch.liveplayer.a.f458803c;     // Catch: JSONException -> L24
        if (r101 != null) goto L11;
    L26:
        if (r100 != null) goto L28;
        return;
    L28:
        AVMDLDataLoaderConfigure r102 = this.f564591a;
        r102.mAppInfo = r100.toString();
        if (com.ss.videoarch.liveplayer.a.f458801a == (-1)) goto L32;
        com.ss.videoarch.liveplayer.log.c.i("MediaLoaderWrapper", "set config");
        AVMDLDataLoader.getInstance().setConfigure(this.f564591a);
    L32:
        if (AVMDLDataLoader.getInstance().start() < 0) goto L36;
        this.f564596f = true;
        return;
    L36:
        throw new Exception("start mediaLoader fail");
    L11:
        if (TextUtils.isEmpty(r101) == true) goto L14;
        r100.put("app_channel", com.ss.videoarch.liveplayer.a.f458803c);     // Catch: JSONException -> L24
    L14:
        if (TextUtils.isEmpty(com.ss.videoarch.liveplayer.a.f458802b) == true) goto L17;
        r100.put("app_name", com.ss.videoarch.liveplayer.a.f458802b);     // Catch: JSONException -> L24
    L17:
        if (TextUtils.isEmpty(com.ss.videoarch.liveplayer.a.f458805e) == true) goto L20;
        r100.put("device_id", com.ss.videoarch.liveplayer.a.f458805e);     // Catch: JSONException -> L24
    L20:
        if (TextUtils.isEmpty(com.ss.videoarch.liveplayer.a.f458804d) == true) goto L22;
        r100.put("app_version", com.ss.videoarch.liveplayer.a.f458804d);     // Catch: JSONException -> L24
    L22:
        r100.put("app_id", com.ss.videoarch.liveplayer.a.f458801a);     // Catch: JSONException -> L24
    L24:
        e = move-exception;
        e.printStackTrace();
        r100 = null;
        goto L26
    L38:
        throw new Exception("init mediaLoader fail");
    }

    private c() {
        this.f564592b = false;
        this.f564593c = null;
        this.f564596f = false;
        this.f564597g = false;
        this.f564591a = AVMDLDataLoaderConfigure.getDefaultonfigure();
    }

    public static c getDataLoader() {
        return b.access$100();
    }

    public boolean isRunning() {
        if (AVMDLDataLoader.getInstance() != null) goto L6;
        return false;
    L6:
        return AVMDLDataLoader.getInstance().isRunning();
    }

    public c(xmc.b r100) {
        this.f564592b = false;
        this.f564593c = null;
        this.f564596f = false;
        this.f564597g = false;
        this.f564591a = AVMDLDataLoaderConfigure.getDefaultonfigure();
        this.f564594d = r100;
    }

    private boolean supportProxy(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return false;
    L5:
        String r101 = r100.toLowerCase();
        if (r101.startsWith("http://127.0.0.1") == false) goto L8;
    L26:
        return false;
    L8:
        if (r101.startsWith("http://localhost") == true) goto L26;
        if (r101.startsWith(MSkiaImageRegionDecoder.FILE_PREFIX) == true) goto L26;
        if (r101.startsWith(HTTP.URL_DEFAULT) == true) goto L26;
        if (r101.endsWith(".mpd") == true) goto L26;
        if (r101.contains(".mpd?") == true) goto L26;
        if (r101.contains(".m3u8?") == true) goto L26;
        if (r101.endsWith(".m3u8") == true) goto L26;
        return true;
    }

    public long getLongValueFromLoader(int r100) {
        com.ss.videoarch.liveplayer.log.c.i("MediaLoaderWrapper", "get long value from loader");
        AVMDLDataLoader r101 = AVMDLDataLoader.getInstance();
        long r102 = -1;
        if (r100 == 7218) goto L22;
        switch(r100) {
            case 8100: goto L18;
            case 8101: goto L14;
            case 8102: goto L6;
            default: goto L5;
        };
    L5:
        return -1;
    L6:
        if (r101 == null) goto L10;
        r102 = r101.getLongValue(AVMDLDataLoader.KeyIsLiveEnableMdlProto);
    L10:
        if (r102 == 1) goto L26;
        return 0;
    L26:
        return 1;
    L14:
        if (r101 != null) goto L17;
        return -1;
    L17:
        return r101.getLongValue(AVMDLDataLoader.KeyIsLiveLoaderP2pEnable);
    L18:
        if (r101 != null) goto L21;
        return -1;
    L21:
        return r101.getLongValue(8100);
    L22:
        if (r101 != null) goto L25;
        return -1;
    L25:
        return r101.getLongValue(AVMDLDataLoader.KeyIsGetMdlProtocolHandle);
    }

    public String getStringValueFromLoader(int r100) {
        com.ss.videoarch.liveplayer.log.c.i("MediaLoaderWrapper", "get string value from loader");
        AVMDLDataLoader r101 = AVMDLDataLoader.getInstance();
        if (r100 == 11) goto L5;
        return null;
    L5:
        if (r101 != null) goto L8;
        return null;
    L8:
        return r101.getStringValue(11);
    }

    @Override // com.ss.mediakit.medialoader.AVMDLDataLoaderListener
    public void onNotify(AVMDLDataLoaderNotifyInfo r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (this.f564594d == null) goto L22;
        com.ss.videoarch.liveplayer.log.c.i("MediaLoaderWrapper", "what:" + r100.what);
        int r101 = r100.what;
        if (r101 != 9) goto L9;
        xmc.b r102 = this.f564594d;
        if (r102 == null) goto L18;
        r102.onDataLoaderError((int) r100.parameter, r100.logInfo);
    L18:
        com.ss.videoarch.liveplayer.log.c.i("MediaLoaderWrapper", "live loader errorCode:" + r100.parameter + " errorInfo:" + r100.logInfo);
        return;
    L9:
        if (r101 != 12) goto L23;
        xmc.b r103 = this.f564594d;
        if (r103 == null) goto L14;
        r103.onSwitchLoaderType((int) r100.parameter, r100.logInfo);
    L14:
        com.ss.videoarch.liveplayer.log.c.i("MediaLoaderWrapper", "switch reason:" + r100.parameter + " switchInfo:" + r100.logInfo);
        return;
    L23:
        return;
    }

    public void setListener(xmc.b r100) {
        this.f564594d = r100;
        AVMDLDataLoader.getInstance().setListener(107, this);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        com.ss.videoarch.liveplayer.log.c.i("MediaLoaderWrapper", String.format("create loader failed: exception is" + e.toString(), new Object[0]));
    }

    public void setLoadProxy(xmc.a r100) {
        this.f564593c = r100;
    }

    public void setMediaPlayer(MediaPlayer r100) {
        this.f564595e = r100;
    }

    public /* synthetic */ c(a r100) {
        this();
    }

    @Override // com.ss.mediakit.medialoader.AVMDLDataLoaderListener
    public long getInt64Value(int r100, long r101) {
        com.ss.videoarch.liveplayer.log.c.i("MediaLoaderWrapper", "getInt64Value:" + r100);
        if (r100 != 8003) goto L5;
        MediaPlayer r102 = this.f564595e;
        if (r102 != null) goto L15;
        return r101;
    L15:
        return r102.getLongOption(73, 0);
    L5:
        if (r100 == 8004) goto L7;
        return r101;
    L7:
        xmc.b r103 = this.f564594d;
        if (r103 != null) goto L10;
        return r101;
    L10:
        return r103.getInt64Value(0, r101);
    }

    public String getProxyUrl(String r100, Boolean r101) {
        String r102 = null;
        if (r100 != null) goto L6;
        return null;
    L6:
        if (supportProxy(r100) == true) goto L8;
        return r100;
    L8:
        String r103 = AVMDLDataLoader.getInstance().getLocalAddr();
        if (TextUtils.isEmpty(r103) == false) goto L21;
        return null;
    L21:
        r102 = URLEncoder.encode(r100, "UTF-8");     // Catch: Throwable -> L13
    L15:
        String r104 = r103 + "?rk=v02004b50000bh9ajqhdli3lfv2rgsgg&k=426161df8c5ce110209a6fc6641e049ddfrfgaf&u0=" + r102;
        if (r101.booleanValue() == false) goto L20;
        return DataLoaderHelper.MDL_PREFIX + r104;
    L20:
        return "http://" + r104;
    L13:
        th = move-exception;
        th.printStackTrace();
        goto L15
    }

    public void setIntValue(int r100, int r101) {
        if (r100 != 51) goto L6;
        this.f564591a.mRWTimeOut = r101;
        return;
    L6:
        if (r100 != 52) goto L9;
        this.f564591a.mOpenTimeOut = r101;
        return;
    L9:
        if (r100 != 53) goto L12;
        this.f564591a.mTryCount = r101;
        return;
    L12:
        if (r100 != 49) goto L15;
        com.ss.videoarch.liveplayer.log.c.i("MediaLoaderWrapper", "allow p2p:" + r101);
        this.f564591a.mLiveP2pAllow = r101;
        return;
    L15:
        if (r100 != 50) goto L22;
        com.ss.videoarch.liveplayer.log.c.i("MediaLoaderWrapper", "loader type:" + r101);
        this.f564591a.mLiveLoaderType = r101;
        return;
    }

    public void setLongValue(int r100, long r101) {
        AVMDLDataLoader r102 = AVMDLDataLoader.getInstance();
        if (r102 != null) goto L6;
        return;
    L6:
        if (r100 == 59) goto L8;
        return;
    L8:
        r102.setLongValue(1100, r101);
    }

    public void setStringValue(int r100, String r101) {
        AVMDLDataLoader r102 = AVMDLDataLoader.getInstance();
        if (r102 != null) goto L5;
        return;
    L5:
        r102.setStringValue(r100, r101);
    }

    public void setInt64ValueByStrKey(int r100, String r101, int r102) {
        AVMDLDataLoader r103 = AVMDLDataLoader.getInstance();
        if (r103 != null) goto L6;
        return;
    L6:
        if (r100 != 7213) goto L8;
    L10:
        r103.setInt64ValueByStrKey(r100, r101, r102);
        return;
    L8:
        if (r100 == 7215) goto L10;
        r103.setInt64ValueByStrKey(r100, r101, System.currentTimeMillis());
    }
}
