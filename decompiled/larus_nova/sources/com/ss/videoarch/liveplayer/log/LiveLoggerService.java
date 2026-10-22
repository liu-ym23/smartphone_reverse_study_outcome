package com.ss.videoarch.liveplayer.log;

import android.content.Context;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.alipay.sdk.m.u.i;
import com.bytedance.android.live.wallet.model.OrderParamsKey;
import com.bytedance.android.livehostapi.business.depend.livead.MiniAppConstants;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.android.livesdkapi.broadcastgame.GameSeiConstants;
import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.android.livesdkapi.roomplayer.VrBgLogData;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.sdk.account.platform.api.ITiktokService;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.larus.dora.api.model.FlowDoraWifiScene;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import com.ss.texturerender.TextureRenderKeys;
import com.ss.texturerender.effect.PureColorDetector;
import com.ss.ttm.player.MediaPlayer;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import com.ss.ttvideoengine.log.IVideoEventLogger;
import com.ss.ttvideoengine.portrait.PortraitEngine;
import com.ss.videoarch.live.ttquic.TTUtils;
import com.ss.videoarch.liveplayer.VideoLiveManager;
import com.ss.videoarch.liveplayer.g;
import com.ss.videoarch.liveplayer.g0;
import com.ss.videoarch.liveplayer.v;
import com.ss.videoarch.strategy.LiveStrategyManager;
import com.ss.videoarch.strategy.dataCenter.strategyData.HistoryTableOperate;
import java.io.IOException;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.commons.net.ntp.NTPUDPClient;
import org.apache.commons.net.ntp.TimeInfo;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public final class LiveLoggerService extends cnc.d implements Handler.Callback {

    /* JADX INFO: renamed from: ce, reason: collision with root package name */
    public static final AtomicLong f458906ce = null;

    /* JADX INFO: renamed from: de, reason: collision with root package name */
    public static final AtomicLong f458907de = null;

    /* JADX INFO: renamed from: ee, reason: collision with root package name */
    public static final AtomicLong f458908ee = null;

    /* JADX INFO: renamed from: fe, reason: collision with root package name */
    public static final AtomicLong f458909fe = null;

    /* JADX INFO: renamed from: ge, reason: collision with root package name */
    public static final AtomicLong f458910ge = null;

    /* JADX INFO: renamed from: he, reason: collision with root package name */
    public static final AtomicLong f458911he = null;

    /* JADX INFO: renamed from: ie, reason: collision with root package name */
    public static final AtomicLong f458912ie = null;

    /* JADX INFO: renamed from: je, reason: collision with root package name */
    public static final AtomicLong f458913je = null;

    /* JADX INFO: renamed from: ke, reason: collision with root package name */
    public static final HashMap<String, Integer> f458914ke = null;
    public String A;
    public long A3;
    public int A4;
    public boolean A5;
    public long A6;
    public int A7;
    public String A8;
    public long A9;
    public int Aa;
    public long Ab;
    public float Ac;
    public int Ad;
    public int B;
    public int B3;
    public int B4;
    public boolean B5;
    public String B6;
    public int B7;
    public long B8;
    public long B9;
    public String Ba;
    public int Bb;
    public int Bc;
    public int Bd;
    public int C;
    public int C3;
    public int C4;
    public float C5;
    public int C6;
    public int C7;
    public long C8;
    public long C9;
    public int Ca;
    public int Cb;
    public String Cc;
    public long Cd;
    public String D;
    public int D3;
    public int D4;
    public long D5;
    public boolean D6;
    public int D7;
    public long D8;
    public long D9;
    public String Da;
    public int Db;
    public String Dc;
    public long Dd;
    public String E;
    public int E2;
    public int E3;
    public int E4;
    public String E5;
    public long E6;
    public String E7;
    public long E8;
    public long E9;
    public int Ea;
    public int Eb;
    public int Ec;
    public final String Ed;
    public String F;
    public int F2;
    public int F3;
    public long F4;
    public String F5;
    public long F6;
    public boolean F7;
    public long F8;
    public long F9;
    public int Fa;
    public long Fb;
    public int Fc;
    public final String Fd;
    public String G;
    public int G1;
    public int G2;
    public int G3;
    public String G4;
    public String G5;
    public long G6;
    public int G7;
    public long G8;
    public wmc.a G9;
    public int Ga;
    public long Gb;
    public String Gc;
    public final String Gd;
    public String H;
    public int H0;
    public int H1;
    public int H2;
    public long H3;
    public int H4;
    public int H5;
    public long H6;
    public long H7;
    public long H8;
    public int H9;
    public int Ha;
    public long Hb;
    public String Hc;
    public final String Hd;
    public int I;
    public int I2;
    public long I3;
    public int I4;
    public int I5;
    public long I6;
    public long I7;
    public long I8;
    public int I9;
    public int Ia;
    public long Ib;
    public int Ic;
    public final String Id;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public int f458915J;
    public int J2;
    public long J3;
    public int J4;
    public String J5;
    public long J6;
    public long J7;
    public long J8;
    public int J9;
    public int Ja;
    public long Jb;
    public String Jc;
    public final String Jd;
    public int K;
    public int K2;
    public long K3;
    public int K4;
    public String K5;
    public long K6;
    public long K7;
    public long K8;
    public int K9;
    public String Ka;
    public long Kb;
    public String Kc;
    public final String Kd;
    public int L;
    public int L0;
    public int L1;
    public int L2;
    public boolean L3;
    public int L4;
    public String L5;
    public long L6;
    public int L7;
    public long L8;
    public String L9;
    public int La;
    public long Lb;
    public String Lc;
    public long Ld;
    public int M;
    public float M1;
    public int M2;
    public int M3;
    public String M4;
    public boolean M5;
    public long M6;
    public long M7;
    public long M8;
    public long M9;
    public String Ma;
    public long Mb;
    public int Mc;
    public long Md;
    public String N;
    public int N2;
    public int N3;
    public int N4;
    public boolean N5;
    public int N6;
    public long N7;
    public long N8;
    public long N9;
    public List<String> Na;
    public long Nb;
    public final ArrayList<JSONObject> Nc;
    public DisplayModel Nd;
    public String O;
    public float O2;
    public int O3;
    public String O4;
    public JSONObject O5;
    public long O6;
    public String O7;
    public long O8;
    public String O9;
    public String Oa;
    public int Ob;
    public String Oc;
    public String Od;
    public String P;
    public boolean P0;
    public int P1;
    public int P2;
    public int P3;
    public String P4;
    public JSONObject P5;
    public long P6;
    public String P7;
    public long P8;
    public int P9;
    public String Pa;
    public int Pb;
    public long Pc;
    public long Pd;
    public int Q;
    public float Q1;
    public String Q2;
    public int Q3;
    public ArrayList<Long> Q4;
    public JSONObject Q5;
    public long Q6;
    public String Q7;
    public long Q8;
    public long Q9;
    public boolean Qa;
    public String Qb;
    public long Qc;
    public final HashMap<String, Long> Qd;
    public boolean R;
    public String R2;
    public int R3;
    public ArrayList<Long> R4;
    public int R5;
    public int R6;
    public int R7;
    public long R8;
    public int R9;
    public String Ra;
    public String Rb;
    public long Rc;
    public JSONArray Rd;
    public String S;
    public float S1;
    public String S2;
    public long S3;
    public ArrayList<Long> S4;
    public JSONObject S5;
    public int S6;
    public int S7;
    public long S8;
    public int S9;
    public String Sa;
    public boolean Sb;
    public long Sc;
    public int Sd;
    public int T;
    public int T1;
    public String T2;
    public long T3;
    public ArrayList<Long> T4;
    public int T5;
    public int T6;
    public final int T7;
    public long T8;
    public int T9;
    public int Ta;
    public final List<Long> Tb;
    public long Tc;
    public long Td;
    public int U;
    public String U2;
    public long U3;
    public ArrayList<Integer> U4;
    public final String U5;
    public int U6;
    public boolean U7;
    public long U8;
    public int U9;
    public int Ua;
    public int Ub;
    public long Uc;
    public int Ud;
    public int V;
    public int V0;
    public int V1;
    public String V2;
    public long V3;
    public long V4;
    public final String V5;
    public int V6;
    public int V7;
    public long V8;
    public String V9;
    public long Va;
    public int Vb;
    public long Vc;
    public long Vd;
    public boolean W;
    public String W2;
    public long W3;
    public String W4;
    public String W5;
    public int W6;
    public int W7;
    public long W8;
    public String W9;
    public long Wa;
    public int Wb;
    public long Wc;
    public long Wd;
    public boolean X;
    public String X2;
    public long X3;
    public String X4;
    public String X5;
    public int X6;
    public String X7;
    public long X8;
    public long X9;
    public int Xa;
    public int Xb;
    public long Xc;
    public JSONObject Xd;
    public boolean Y;
    public int Y2;
    public long Y3;
    public JSONObject Y4;
    public String Y5;
    public int Y6;
    public Map<String, String> Y7;
    public long Y8;
    public int Y9;
    public long Ya;
    public float Yb;
    public long Yc;
    public int Yd;
    public String Z;
    public int Z2;
    public int Z3;
    public ArrayList<Integer> Z4;
    public boolean Z5;
    public int Z6;
    public String Z7;
    public long Z8;
    public long Z9;
    public int Za;
    public int Zb;
    public long Zc;
    public long Zd;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f458916a;

    /* JADX INFO: renamed from: a3, reason: collision with root package name */
    public long f458917a3;

    /* JADX INFO: renamed from: a4, reason: collision with root package name */
    public int f458918a4;

    /* JADX INFO: renamed from: a5, reason: collision with root package name */
    public ArrayList<Integer> f458919a5;

    /* JADX INFO: renamed from: a6, reason: collision with root package name */
    public String f458920a6;

    /* JADX INFO: renamed from: a7, reason: collision with root package name */
    public int f458921a7;

    /* JADX INFO: renamed from: a8, reason: collision with root package name */
    public int f458922a8;

    /* JADX INFO: renamed from: a9, reason: collision with root package name */
    public long f458923a9;

    /* JADX INFO: renamed from: aa, reason: collision with root package name */
    public long f458924aa;

    /* JADX INFO: renamed from: ab, reason: collision with root package name */
    public int f458925ab;

    /* JADX INFO: renamed from: ac, reason: collision with root package name */
    public long f458926ac;

    /* JADX INFO: renamed from: ad, reason: collision with root package name */
    public long f458927ad;

    /* JADX INFO: renamed from: ae, reason: collision with root package name */
    public final int f458928ae;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f458929b;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public int f458930b1;

    /* JADX INFO: renamed from: b2, reason: collision with root package name */
    public int f458931b2;

    /* JADX INFO: renamed from: b3, reason: collision with root package name */
    public long f458932b3;

    /* JADX INFO: renamed from: b4, reason: collision with root package name */
    public int f458933b4;

    /* JADX INFO: renamed from: b5, reason: collision with root package name */
    public ArrayList<Long> f458934b5;

    /* JADX INFO: renamed from: b6, reason: collision with root package name */
    public boolean f458935b6;

    /* JADX INFO: renamed from: b7, reason: collision with root package name */
    public int f458936b7;

    /* JADX INFO: renamed from: b8, reason: collision with root package name */
    public int f458937b8;

    /* JADX INFO: renamed from: b9, reason: collision with root package name */
    public long f458938b9;

    /* JADX INFO: renamed from: ba, reason: collision with root package name */
    public int f458939ba;

    /* JADX INFO: renamed from: bb, reason: collision with root package name */
    public int f458940bb;

    /* JADX INFO: renamed from: bc, reason: collision with root package name */
    public long f458941bc;

    /* JADX INFO: renamed from: bd, reason: collision with root package name */
    public int f458942bd;

    /* JADX INFO: renamed from: be, reason: collision with root package name */
    public long f458943be;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Handler f458944c;

    /* JADX INFO: renamed from: c3, reason: collision with root package name */
    public long f458945c3;

    /* JADX INFO: renamed from: c4, reason: collision with root package name */
    public boolean f458946c4;

    /* JADX INFO: renamed from: c5, reason: collision with root package name */
    public String f458947c5;

    /* JADX INFO: renamed from: c6, reason: collision with root package name */
    public String f458948c6;

    /* JADX INFO: renamed from: c7, reason: collision with root package name */
    public List<String> f458949c7;

    /* JADX INFO: renamed from: c8, reason: collision with root package name */
    public float f458950c8;

    /* JADX INFO: renamed from: c9, reason: collision with root package name */
    public long f458951c9;

    /* JADX INFO: renamed from: ca, reason: collision with root package name */
    public int f458952ca;

    /* JADX INFO: renamed from: cb, reason: collision with root package name */
    public String f458953cb;

    /* JADX INFO: renamed from: cc, reason: collision with root package name */
    public boolean f458954cc;

    /* JADX INFO: renamed from: cd, reason: collision with root package name */
    public long f458955cd;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.videoarch.liveplayer.e f458956d;

    /* JADX INFO: renamed from: d3, reason: collision with root package name */
    public long f458957d3;

    /* JADX INFO: renamed from: d4, reason: collision with root package name */
    public int f458958d4;

    /* JADX INFO: renamed from: d5, reason: collision with root package name */
    public String f458959d5;

    /* JADX INFO: renamed from: d6, reason: collision with root package name */
    public String f458960d6;

    /* JADX INFO: renamed from: d7, reason: collision with root package name */
    public LinkedBlockingQueue<Long> f458961d7;

    /* JADX INFO: renamed from: d8, reason: collision with root package name */
    public int f458962d8;

    /* JADX INFO: renamed from: d9, reason: collision with root package name */
    public long f458963d9;

    /* JADX INFO: renamed from: da, reason: collision with root package name */
    public long f458964da;

    /* JADX INFO: renamed from: db, reason: collision with root package name */
    public int f458965db;

    /* JADX INFO: renamed from: dc, reason: collision with root package name */
    public long f458966dc;

    /* JADX INFO: renamed from: dd, reason: collision with root package name */
    public long f458967dd;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LogBundle f458968e;

    /* JADX INFO: renamed from: e3, reason: collision with root package name */
    public int f458969e3;

    /* JADX INFO: renamed from: e4, reason: collision with root package name */
    public boolean f458970e4;

    /* JADX INFO: renamed from: e5, reason: collision with root package name */
    public String f458971e5;

    /* JADX INFO: renamed from: e6, reason: collision with root package name */
    public String f458972e6;

    /* JADX INFO: renamed from: e7, reason: collision with root package name */
    public int f458973e7;

    /* JADX INFO: renamed from: e8, reason: collision with root package name */
    public int f458974e8;

    /* JADX INFO: renamed from: e9, reason: collision with root package name */
    public long f458975e9;

    /* JADX INFO: renamed from: ea, reason: collision with root package name */
    public long f458976ea;

    /* JADX INFO: renamed from: eb, reason: collision with root package name */
    public int f458977eb;

    /* JADX INFO: renamed from: ec, reason: collision with root package name */
    public long f458978ec;

    /* JADX INFO: renamed from: ed, reason: collision with root package name */
    public long f458979ed;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final VideoLiveManager f458980f;

    /* JADX INFO: renamed from: f3, reason: collision with root package name */
    public int f458981f3;

    /* JADX INFO: renamed from: f4, reason: collision with root package name */
    public boolean f458982f4;

    /* JADX INFO: renamed from: f5, reason: collision with root package name */
    public String f458983f5;

    /* JADX INFO: renamed from: f6, reason: collision with root package name */
    public ArrayList<String> f458984f6;

    /* JADX INFO: renamed from: f7, reason: collision with root package name */
    public long f458985f7;

    /* JADX INFO: renamed from: f8, reason: collision with root package name */
    public int f458986f8;

    /* JADX INFO: renamed from: f9, reason: collision with root package name */
    public long f458987f9;

    /* JADX INFO: renamed from: fa, reason: collision with root package name */
    public final int f458988fa;

    /* JADX INFO: renamed from: fb, reason: collision with root package name */
    public long f458989fb;

    /* JADX INFO: renamed from: fc, reason: collision with root package name */
    public int f458990fc;

    /* JADX INFO: renamed from: fd, reason: collision with root package name */
    public final Queue<PureColorDetector.DetectResult> f458991fd;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f458992g;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    public int f458993g1;

    /* JADX INFO: renamed from: g2, reason: collision with root package name */
    public int f458994g2;

    /* JADX INFO: renamed from: g3, reason: collision with root package name */
    public int f458995g3;

    /* JADX INFO: renamed from: g4, reason: collision with root package name */
    public boolean f458996g4;

    /* JADX INFO: renamed from: g5, reason: collision with root package name */
    public boolean f458997g5;

    /* JADX INFO: renamed from: g6, reason: collision with root package name */
    public boolean f458998g6;

    /* JADX INFO: renamed from: g7, reason: collision with root package name */
    public int f458999g7;

    /* JADX INFO: renamed from: g8, reason: collision with root package name */
    public long f459000g8;

    /* JADX INFO: renamed from: g9, reason: collision with root package name */
    public long f459001g9;

    /* JADX INFO: renamed from: ga, reason: collision with root package name */
    public final int f459002ga;

    /* JADX INFO: renamed from: gb, reason: collision with root package name */
    public JSONObject f459003gb;

    /* JADX INFO: renamed from: gc, reason: collision with root package name */
    public long f459004gc;

    /* JADX INFO: renamed from: gd, reason: collision with root package name */
    public boolean f459005gd;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f459006h;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public int f459007h1;

    /* JADX INFO: renamed from: h2, reason: collision with root package name */
    public int f459008h2;

    /* JADX INFO: renamed from: h3, reason: collision with root package name */
    public boolean f459009h3;

    /* JADX INFO: renamed from: h4, reason: collision with root package name */
    public long f459010h4;

    /* JADX INFO: renamed from: h5, reason: collision with root package name */
    public g f459011h5;

    /* JADX INFO: renamed from: h6, reason: collision with root package name */
    public boolean f459012h6;

    /* JADX INFO: renamed from: h7, reason: collision with root package name */
    public int f459013h7;

    /* JADX INFO: renamed from: h8, reason: collision with root package name */
    public int f459014h8;

    /* JADX INFO: renamed from: h9, reason: collision with root package name */
    public long f459015h9;

    /* JADX INFO: renamed from: ha, reason: collision with root package name */
    public String f459016ha;

    /* JADX INFO: renamed from: hb, reason: collision with root package name */
    public List<Long> f459017hb;

    /* JADX INFO: renamed from: hc, reason: collision with root package name */
    public long f459018hc;

    /* JADX INFO: renamed from: hd, reason: collision with root package name */
    public String f459019hd;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f459020i;

    /* JADX INFO: renamed from: i3, reason: collision with root package name */
    public boolean f459021i3;

    /* JADX INFO: renamed from: i4, reason: collision with root package name */
    public boolean f459022i4;

    /* JADX INFO: renamed from: i5, reason: collision with root package name */
    public boolean f459023i5;

    /* JADX INFO: renamed from: i6, reason: collision with root package name */
    public String f459024i6;

    /* JADX INFO: renamed from: i7, reason: collision with root package name */
    public int f459025i7;

    /* JADX INFO: renamed from: i8, reason: collision with root package name */
    public LogBundle f459026i8;

    /* JADX INFO: renamed from: i9, reason: collision with root package name */
    public long f459027i9;

    /* JADX INFO: renamed from: ia, reason: collision with root package name */
    public String f459028ia;

    /* JADX INFO: renamed from: ib, reason: collision with root package name */
    public List<Long> f459029ib;

    /* JADX INFO: renamed from: ic, reason: collision with root package name */
    public boolean f459030ic;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public int f459031id;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f459032j;

    /* JADX INFO: renamed from: j3, reason: collision with root package name */
    public long f459033j3;

    /* JADX INFO: renamed from: j4, reason: collision with root package name */
    public long f459034j4;

    /* JADX INFO: renamed from: j5, reason: collision with root package name */
    public int f459035j5;

    /* JADX INFO: renamed from: j6, reason: collision with root package name */
    public String f459036j6;

    /* JADX INFO: renamed from: j7, reason: collision with root package name */
    public int f459037j7;

    /* JADX INFO: renamed from: j8, reason: collision with root package name */
    public boolean f459038j8;

    /* JADX INFO: renamed from: j9, reason: collision with root package name */
    public long f459039j9;

    /* JADX INFO: renamed from: ja, reason: collision with root package name */
    public long f459040ja;

    /* JADX INFO: renamed from: jb, reason: collision with root package name */
    public List<Long> f459041jb;

    /* JADX INFO: renamed from: jc, reason: collision with root package name */
    public int f459042jc;

    /* JADX INFO: renamed from: jd, reason: collision with root package name */
    public int f459043jd;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f459044k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public boolean f459045k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public int f459046k1;

    /* JADX INFO: renamed from: k3, reason: collision with root package name */
    public long f459047k3;

    /* JADX INFO: renamed from: k4, reason: collision with root package name */
    public long f459048k4;

    /* JADX INFO: renamed from: k5, reason: collision with root package name */
    public int f459049k5;

    /* JADX INFO: renamed from: k6, reason: collision with root package name */
    public String f459050k6;

    /* JADX INFO: renamed from: k7, reason: collision with root package name */
    public int f459051k7;

    /* JADX INFO: renamed from: k8, reason: collision with root package name */
    public long f459052k8;

    /* JADX INFO: renamed from: k9, reason: collision with root package name */
    public long f459053k9;

    /* JADX INFO: renamed from: ka, reason: collision with root package name */
    public int f459054ka;

    /* JADX INFO: renamed from: kb, reason: collision with root package name */
    public List<Long> f459055kb;

    /* JADX INFO: renamed from: kc, reason: collision with root package name */
    public long f459056kc;

    /* JADX INFO: renamed from: kd, reason: collision with root package name */
    public int f459057kd;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f459058l;

    /* JADX INFO: renamed from: l3, reason: collision with root package name */
    public String f459059l3;

    /* JADX INFO: renamed from: l4, reason: collision with root package name */
    public long f459060l4;

    /* JADX INFO: renamed from: l5, reason: collision with root package name */
    public int f459061l5;

    /* JADX INFO: renamed from: l6, reason: collision with root package name */
    public long f459062l6;

    /* JADX INFO: renamed from: l7, reason: collision with root package name */
    public int f459063l7;

    /* JADX INFO: renamed from: l8, reason: collision with root package name */
    public long f459064l8;

    /* JADX INFO: renamed from: l9, reason: collision with root package name */
    public long f459065l9;

    /* JADX INFO: renamed from: la, reason: collision with root package name */
    public int f459066la;

    /* JADX INFO: renamed from: lb, reason: collision with root package name */
    public List<Long> f459067lb;

    /* JADX INFO: renamed from: lc, reason: collision with root package name */
    public long f459068lc;

    /* JADX INFO: renamed from: ld, reason: collision with root package name */
    public int f459069ld;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f459070m;

    /* JADX INFO: renamed from: m3, reason: collision with root package name */
    public long f459071m3;

    /* JADX INFO: renamed from: m4, reason: collision with root package name */
    public b f459072m4;

    /* JADX INFO: renamed from: m5, reason: collision with root package name */
    public int f459073m5;

    /* JADX INFO: renamed from: m6, reason: collision with root package name */
    public int f459074m6;

    /* JADX INFO: renamed from: m7, reason: collision with root package name */
    public int f459075m7;

    /* JADX INFO: renamed from: m8, reason: collision with root package name */
    public long f459076m8;

    /* JADX INFO: renamed from: m9, reason: collision with root package name */
    public long f459077m9;

    /* JADX INFO: renamed from: ma, reason: collision with root package name */
    public int f459078ma;

    /* JADX INFO: renamed from: mb, reason: collision with root package name */
    public List<Double> f459079mb;

    /* JADX INFO: renamed from: mc, reason: collision with root package name */
    public long f459080mc;

    /* JADX INFO: renamed from: md, reason: collision with root package name */
    public int f459081md;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f459082n;

    /* JADX INFO: renamed from: n3, reason: collision with root package name */
    public long f459083n3;

    /* JADX INFO: renamed from: n4, reason: collision with root package name */
    public int f459084n4;

    /* JADX INFO: renamed from: n5, reason: collision with root package name */
    public int f459085n5;

    /* JADX INFO: renamed from: n6, reason: collision with root package name */
    public int f459086n6;

    /* JADX INFO: renamed from: n7, reason: collision with root package name */
    public LinkedBlockingQueue<Integer> f459087n7;

    /* JADX INFO: renamed from: n8, reason: collision with root package name */
    public long f459088n8;

    /* JADX INFO: renamed from: n9, reason: collision with root package name */
    public long f459089n9;

    /* JADX INFO: renamed from: na, reason: collision with root package name */
    public long f459090na;

    /* JADX INFO: renamed from: nb, reason: collision with root package name */
    public List<Integer> f459091nb;

    /* JADX INFO: renamed from: nc, reason: collision with root package name */
    public long f459092nc;

    /* JADX INFO: renamed from: nd, reason: collision with root package name */
    public int f459093nd;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public JSONObject f459094o;

    /* JADX INFO: renamed from: o3, reason: collision with root package name */
    public int f459095o3;

    /* JADX INFO: renamed from: o4, reason: collision with root package name */
    public final NTPUDPClient f459096o4;

    /* JADX INFO: renamed from: o5, reason: collision with root package name */
    public String f459097o5;

    /* JADX INFO: renamed from: o6, reason: collision with root package name */
    public String f459098o6;

    /* JADX INFO: renamed from: o7, reason: collision with root package name */
    public String f459099o7;

    /* JADX INFO: renamed from: o8, reason: collision with root package name */
    public long f459100o8;

    /* JADX INFO: renamed from: o9, reason: collision with root package name */
    public long f459101o9;

    /* JADX INFO: renamed from: oa, reason: collision with root package name */
    public ArrayList<Integer> f459102oa;

    /* JADX INFO: renamed from: ob, reason: collision with root package name */
    public int f459103ob;

    /* JADX INFO: renamed from: oc, reason: collision with root package name */
    public long f459104oc;

    /* JADX INFO: renamed from: od, reason: collision with root package name */
    public int f459105od;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f459106p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public String f459107p0;

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    public int f459108p1;

    /* JADX INFO: renamed from: p2, reason: collision with root package name */
    public String f459109p2;

    /* JADX INFO: renamed from: p3, reason: collision with root package name */
    public int f459110p3;

    /* JADX INFO: renamed from: p4, reason: collision with root package name */
    public InetAddress f459111p4;

    /* JADX INFO: renamed from: p5, reason: collision with root package name */
    public boolean f459112p5;

    /* JADX INFO: renamed from: p6, reason: collision with root package name */
    public boolean f459113p6;

    /* JADX INFO: renamed from: p7, reason: collision with root package name */
    public List<String> f459114p7;

    /* JADX INFO: renamed from: p8, reason: collision with root package name */
    public int f459115p8;

    /* JADX INFO: renamed from: p9, reason: collision with root package name */
    public long f459116p9;

    /* JADX INFO: renamed from: pa, reason: collision with root package name */
    public volatile long f459117pa;

    /* JADX INFO: renamed from: pb, reason: collision with root package name */
    public int f459118pb;

    /* JADX INFO: renamed from: pc, reason: collision with root package name */
    public long f459119pc;

    /* JADX INFO: renamed from: pd, reason: collision with root package name */
    public int f459120pd;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f459121q;

    /* JADX INFO: renamed from: q3, reason: collision with root package name */
    public long f459122q3;

    /* JADX INFO: renamed from: q4, reason: collision with root package name */
    public a f459123q4;

    /* JADX INFO: renamed from: q5, reason: collision with root package name */
    public int f459124q5;

    /* JADX INFO: renamed from: q6, reason: collision with root package name */
    public int f459125q6;

    /* JADX INFO: renamed from: q7, reason: collision with root package name */
    public List<String> f459126q7;

    /* JADX INFO: renamed from: q8, reason: collision with root package name */
    public long f459127q8;

    /* JADX INFO: renamed from: q9, reason: collision with root package name */
    public long f459128q9;

    /* JADX INFO: renamed from: qa, reason: collision with root package name */
    public volatile long f459129qa;

    /* JADX INFO: renamed from: qb, reason: collision with root package name */
    public HashMap<String, Integer> f459130qb;

    /* JADX INFO: renamed from: qc, reason: collision with root package name */
    public final AtomicBoolean f459131qc;

    /* JADX INFO: renamed from: qd, reason: collision with root package name */
    public int f459132qd;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f459133r;

    /* JADX INFO: renamed from: r3, reason: collision with root package name */
    public long f459134r3;

    /* JADX INFO: renamed from: r4, reason: collision with root package name */
    public boolean f459135r4;

    /* JADX INFO: renamed from: r5, reason: collision with root package name */
    public int f459136r5;

    /* JADX INFO: renamed from: r6, reason: collision with root package name */
    public int f459137r6;

    /* JADX INFO: renamed from: r7, reason: collision with root package name */
    public int f459138r7;

    /* JADX INFO: renamed from: r8, reason: collision with root package name */
    public long f459139r8;

    /* JADX INFO: renamed from: r9, reason: collision with root package name */
    public long f459140r9;

    /* JADX INFO: renamed from: ra, reason: collision with root package name */
    public String f459141ra;

    /* JADX INFO: renamed from: rb, reason: collision with root package name */
    public boolean f459142rb;

    /* JADX INFO: renamed from: rc, reason: collision with root package name */
    public final ArrayList<JSONObject> f459143rc;

    /* JADX INFO: renamed from: rd, reason: collision with root package name */
    public List<String> f459144rd;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f459145s;

    /* JADX INFO: renamed from: s3, reason: collision with root package name */
    public long f459146s3;

    /* JADX INFO: renamed from: s4, reason: collision with root package name */
    public int f459147s4;

    /* JADX INFO: renamed from: s5, reason: collision with root package name */
    public boolean f459148s5;

    /* JADX INFO: renamed from: s6, reason: collision with root package name */
    public String f459149s6;

    /* JADX INFO: renamed from: s7, reason: collision with root package name */
    public List<String> f459150s7;

    /* JADX INFO: renamed from: s8, reason: collision with root package name */
    public long f459151s8;

    /* JADX INFO: renamed from: s9, reason: collision with root package name */
    public int f459152s9;

    /* JADX INFO: renamed from: sa, reason: collision with root package name */
    public float f459153sa;

    /* JADX INFO: renamed from: sb, reason: collision with root package name */
    public long f459154sb;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public int f459155sc;

    /* JADX INFO: renamed from: sd, reason: collision with root package name */
    public String f459156sd;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f459157t;

    /* JADX INFO: renamed from: t3, reason: collision with root package name */
    public long f459158t3;

    /* JADX INFO: renamed from: t4, reason: collision with root package name */
    public int f459159t4;

    /* JADX INFO: renamed from: t5, reason: collision with root package name */
    public int f459160t5;

    /* JADX INFO: renamed from: t6, reason: collision with root package name */
    public long f459161t6;

    /* JADX INFO: renamed from: t7, reason: collision with root package name */
    public List<String> f459162t7;

    /* JADX INFO: renamed from: t8, reason: collision with root package name */
    public long f459163t8;

    /* JADX INFO: renamed from: t9, reason: collision with root package name */
    public int f459164t9;

    /* JADX INFO: renamed from: ta, reason: collision with root package name */
    public int f459165ta;

    /* JADX INFO: renamed from: tb, reason: collision with root package name */
    public int f459166tb;

    /* JADX INFO: renamed from: tc, reason: collision with root package name */
    public int f459167tc;

    /* JADX INFO: renamed from: td, reason: collision with root package name */
    public long f459168td;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f459169u;

    /* JADX INFO: renamed from: u3, reason: collision with root package name */
    public long f459170u3;

    /* JADX INFO: renamed from: u4, reason: collision with root package name */
    public boolean f459171u4;

    /* JADX INFO: renamed from: u5, reason: collision with root package name */
    public int f459172u5;

    /* JADX INFO: renamed from: u6, reason: collision with root package name */
    public long f459173u6;

    /* JADX INFO: renamed from: u7, reason: collision with root package name */
    public List<String> f459174u7;

    /* JADX INFO: renamed from: u8, reason: collision with root package name */
    public long f459175u8;

    /* JADX INFO: renamed from: u9, reason: collision with root package name */
    public int f459176u9;

    /* JADX INFO: renamed from: ua, reason: collision with root package name */
    public int f459177ua;

    /* JADX INFO: renamed from: ub, reason: collision with root package name */
    public String f459178ub;

    /* JADX INFO: renamed from: uc, reason: collision with root package name */
    public boolean f459179uc;

    /* JADX INFO: renamed from: ud, reason: collision with root package name */
    public JSONObject f459180ud;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f459181v;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public int f459182v1;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    public String f459183v2;

    /* JADX INFO: renamed from: v3, reason: collision with root package name */
    public long f459184v3;

    /* JADX INFO: renamed from: v4, reason: collision with root package name */
    public String f459185v4;

    /* JADX INFO: renamed from: v5, reason: collision with root package name */
    public long f459186v5;

    /* JADX INFO: renamed from: v6, reason: collision with root package name */
    public long f459187v6;

    /* JADX INFO: renamed from: v7, reason: collision with root package name */
    public List<String> f459188v7;

    /* JADX INFO: renamed from: v8, reason: collision with root package name */
    public long f459189v8;

    /* JADX INFO: renamed from: v9, reason: collision with root package name */
    public long f459190v9;

    /* JADX INFO: renamed from: va, reason: collision with root package name */
    public int f459191va;

    /* JADX INFO: renamed from: vb, reason: collision with root package name */
    public String f459192vb;

    /* JADX INFO: renamed from: vc, reason: collision with root package name */
    public int f459193vc;

    /* JADX INFO: renamed from: vd, reason: collision with root package name */
    public long f459194vd;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f459195w;

    /* JADX INFO: renamed from: w3, reason: collision with root package name */
    public long f459196w3;

    /* JADX INFO: renamed from: w4, reason: collision with root package name */
    public int f459197w4;

    /* JADX INFO: renamed from: w5, reason: collision with root package name */
    public long f459198w5;

    /* JADX INFO: renamed from: w6, reason: collision with root package name */
    public long f459199w6;

    /* JADX INFO: renamed from: w7, reason: collision with root package name */
    public final LogBundle f459200w7;

    /* JADX INFO: renamed from: w8, reason: collision with root package name */
    public long f459201w8;

    /* JADX INFO: renamed from: w9, reason: collision with root package name */
    public long f459202w9;

    /* JADX INFO: renamed from: wa, reason: collision with root package name */
    public int f459203wa;

    /* JADX INFO: renamed from: wb, reason: collision with root package name */
    public long f459204wb;

    /* JADX INFO: renamed from: wc, reason: collision with root package name */
    public int f459205wc;

    /* JADX INFO: renamed from: wd, reason: collision with root package name */
    public long f459206wd;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f459207x;

    /* JADX INFO: renamed from: x1, reason: collision with root package name */
    public int f459208x1;

    /* JADX INFO: renamed from: x2, reason: collision with root package name */
    public long f459209x2;

    /* JADX INFO: renamed from: x3, reason: collision with root package name */
    public long f459210x3;

    /* JADX INFO: renamed from: x4, reason: collision with root package name */
    public int f459211x4;

    /* JADX INFO: renamed from: x5, reason: collision with root package name */
    public String f459212x5;

    /* JADX INFO: renamed from: x6, reason: collision with root package name */
    public long f459213x6;

    /* JADX INFO: renamed from: x7, reason: collision with root package name */
    public int f459214x7;

    /* JADX INFO: renamed from: x8, reason: collision with root package name */
    public long f459215x8;

    /* JADX INFO: renamed from: x9, reason: collision with root package name */
    public long f459216x9;

    /* JADX INFO: renamed from: xa, reason: collision with root package name */
    public int f459217xa;

    /* JADX INFO: renamed from: xb, reason: collision with root package name */
    public int f459218xb;

    /* JADX INFO: renamed from: xc, reason: collision with root package name */
    public int f459219xc;

    /* JADX INFO: renamed from: xd, reason: collision with root package name */
    public long f459220xd;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f459221y;

    /* JADX INFO: renamed from: y1, reason: collision with root package name */
    public int f459222y1;

    /* JADX INFO: renamed from: y2, reason: collision with root package name */
    public long f459223y2;

    /* JADX INFO: renamed from: y3, reason: collision with root package name */
    public long f459224y3;

    /* JADX INFO: renamed from: y4, reason: collision with root package name */
    public long f459225y4;

    /* JADX INFO: renamed from: y5, reason: collision with root package name */
    public int f459226y5;

    /* JADX INFO: renamed from: y6, reason: collision with root package name */
    public long f459227y6;

    /* JADX INFO: renamed from: y7, reason: collision with root package name */
    public int f459228y7;

    /* JADX INFO: renamed from: y8, reason: collision with root package name */
    public int f459229y8;

    /* JADX INFO: renamed from: y9, reason: collision with root package name */
    public long f459230y9;

    /* JADX INFO: renamed from: ya, reason: collision with root package name */
    public int f459231ya;

    /* JADX INFO: renamed from: yb, reason: collision with root package name */
    public long f459232yb;

    /* JADX INFO: renamed from: yc, reason: collision with root package name */
    public String f459233yc;

    /* JADX INFO: renamed from: yd, reason: collision with root package name */
    public final List<d> f459234yd;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f459235z;

    /* JADX INFO: renamed from: z3, reason: collision with root package name */
    public long f459236z3;

    /* JADX INFO: renamed from: z4, reason: collision with root package name */
    public int f459237z4;

    /* JADX INFO: renamed from: z5, reason: collision with root package name */
    public boolean f459238z5;

    /* JADX INFO: renamed from: z6, reason: collision with root package name */
    public long f459239z6;

    /* JADX INFO: renamed from: z7, reason: collision with root package name */
    public int f459240z7;

    /* JADX INFO: renamed from: z8, reason: collision with root package name */
    public int f459241z8;

    /* JADX INFO: renamed from: z9, reason: collision with root package name */
    public long f459242z9;

    /* JADX INFO: renamed from: za, reason: collision with root package name */
    public long f459243za;

    /* JADX INFO: renamed from: zb, reason: collision with root package name */
    public long f459244zb;

    /* JADX INFO: renamed from: zc, reason: collision with root package name */
    public float f459245zc;

    /* JADX INFO: renamed from: zd, reason: collision with root package name */
    public List<String> f459246zd;

    public static final enum DisplayModel extends Enum<DisplayModel> {
        public static final DisplayModel BACKGROUND = null;
        public static final DisplayModel INITAL = null;
        public static final DisplayModel INNER = null;
        public static final DisplayModel INNER_PREPLAY = null;
        public static final DisplayModel OTHER = null;
        public static final DisplayModel PREVIEW = null;
        public static final DisplayModel PREVIEW_PREPLAY = null;
        public static final DisplayModel SMALL_WINDOW = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ DisplayModel[] f459247a = null;

        static {
            DisplayModel r100 = new DisplayModel("INITAL", 0);
            INITAL = r100;
            DisplayModel r101 = new DisplayModel("PREVIEW", 1);
            PREVIEW = r101;
            DisplayModel r102 = new DisplayModel("INNER", 2);
            INNER = r102;
            DisplayModel r103 = new DisplayModel("PREVIEW_PREPLAY", 3);
            PREVIEW_PREPLAY = r103;
            DisplayModel r104 = new DisplayModel("INNER_PREPLAY", 4);
            INNER_PREPLAY = r104;
            DisplayModel r105 = new DisplayModel("BACKGROUND", 5);
            BACKGROUND = r105;
            DisplayModel r110 = new DisplayModel("SMALL_WINDOW", 6);
            SMALL_WINDOW = r110;
            DisplayModel r111 = new DisplayModel(FlowDoraWifiScene.OTHER, 7);
            OTHER = r111;
            f459247a = new DisplayModel[]{r100, r101, r102, r103, r104, r105, r110, r111};
        }

        public static DisplayModel[] values() {
            return (DisplayModel[]) f459247a.clone();
        }

        public static DisplayModel valueOf(String r100) {
            return (DisplayModel) r27.a.a(DisplayModel.class, r100);
        }

        private DisplayModel(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final PthreadHandlerThreadV2 f459248a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final HandlerC5511a f459249b;

        /* JADX INFO: renamed from: com.ss.videoarch.liveplayer.log.LiveLoggerService$a$a, reason: collision with other inner class name */
        public class HandlerC5511a extends Handler {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ LiveLoggerService f459250a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a f459251b;

            @Override // android.os.Handler
            public void handleMessage(Message r100) {
                if (r100 == null) goto L28;
                String r101 = this.f459250a.f459185v4;
                if (r101 != null) goto L6;
                return;
            L6:
                if (r101.equals("null") == false) goto L9;
                return;
            L9:
                if (r100.what != 104) goto L13;
                if (LiveLoggerService.access$100(this.f459250a) != (-1)) goto L13;
            L26:
                LiveLoggerService r102 = this.f459250a;     // Catch: UnknownHostException -> L18
                LiveLoggerService.access$302(r102, InetAddress.getByName(r102.f459185v4));     // Catch: UnknownHostException -> L18
            L21:
                if (r100.what != 103) goto L30;
                LiveLoggerService.access$400(this.f459250a);
                if (LiveLoggerService.access$500(this.f459250a) == false) goto L31;
                a.access$000(this.f459251b).sendEmptyMessageDelayed(103, 300000);
                return;
            L31:
                return;
            L30:
                return;
            L18:
                e = move-exception;
                LiveLoggerService.access$302(this.f459250a, null);
                e.printStackTrace();
            L13:
                if (LiveLoggerService.access$200(this.f459250a) == true) goto L26;
                if (LiveLoggerService.access$300(this.f459250a) != null) goto L21;
            }

            public HandlerC5511a(a r100, Looper r101, LiveLoggerService r102) {
                this.f459251b = r100;
                this.f459250a = r102;
                super(r101);
            }
        }

        public a(LiveLoggerService r100) {
            PthreadHandlerThreadV2 r101 = new PthreadHandlerThreadV2("DnsHandlerThread");
            this.f459248a = r101;
            ThreadMethodProxy.start(r101);
            this.f459249b = new HandlerC5511a(this, r101.getLooper(), r100);
        }

        public static /* synthetic */ Handler access$000(a r100) {
            return r100.f459249b;
        }

        public void sendEmptyMessageDelayed(int r100, long r101) {
            if (this.f459248a == null) goto L12;
            HandlerC5511a r102 = this.f459249b;
            if (r102 != null) goto L8;
            return;
        L8:
            if (r101 != 0) goto L10;
            r102.sendEmptyMessage(r100);
            return;
        L10:
            r102.sendEmptyMessageDelayed(r100, r101);
            return;
        }
    }

    private int HexCharToData(char r100) {
        if (r100 >= '0') goto L5;
    L7:
        char r101 = 'A';
        if (r100 >= 'A') goto L10;
    L12:
        r101 = 'a';
        if (r100 >= 'a') goto L15;
    L17:
        return 0;
    L15:
        if (r100 > 'f') goto L17;
    L20:
        return (r100 - r101) + 10;
    L10:
        if (r100 > 'F') goto L12;
    L5:
        if (r100 > '9') goto L7;
        return r100 - '0';
    }

    private void resetPlayingInfo() {
        int r100 = 0;
        this.f458952ca = 0;
        this.f458976ea = 0;
        this.f459028ia = "";
        this.f458918a4 = 0;
        this.M3 = 0;
        this.N3 = 0;
        this.Q3 = 0;
        this.R3 = 0;
        this.O3 = 0;
        this.P3 = 0;
        this.C3 = 0;
        this.B3 = 0;
        this.E3 = 0;
        this.D3 = 0;
        this.F3 = 0;
        this.G3 = 0;
        this.S8 = 0;
        this.U8 = 0;
        this.R8 = 0;
        this.T8 = 0;
        this.f459116p9 = 0;
        this.f459140r9 = 0;
        this.f459101o9 = 0;
        this.f459128q9 = 0;
        this.f459008h2 = 0;
        this.f459109p2 = "none";
        if (this.f458946c4 == true) goto L6;
        r100 = -1;
    L6:
        this.f458958d4 = r100;
        LogBundle r101 = this.f458968e;
        r101.f459295i1 = r101.f459280f1;
        this.f459150s7.clear();
        this.f459162t7.clear();
        this.G8 = 0;
        this.H8 = 0;
        this.I8 = 0;
        this.J8 = 0;
        this.f459174u7.clear();
        this.f459188v7.clear();
        this.K8 = 0;
        this.L8 = 0;
        this.M8 = 0;
        this.N8 = 0;
    }

    public void enableCheckSei() {
        this.f458982f4 = true;
    }

    public void enableCheckSeiV2() {
        this.f458996g4 = true;
    }

    public void enableSharp() {
        this.f458970e4 = true;
    }

    public void onErrorRecovered() {
        this.f459022i4 = false;
        c.i("LiveLoggerService", "recover from error time " + (System.currentTimeMillis() - this.f459034j4));
        if (this.f459034j4 == 0) goto L6;
        this.f459048k4++;
        this.f459060l4 += System.currentTimeMillis() - this.f459034j4;
        return;
    }

    public void openNTP() {
        this.f459211x4 = 1;
        this.f459197w4 = 1;
        if (this.f459123q4 != null) goto L6;
        a r100 = new a(this);
        this.f459123q4 = r100;
        r100.sendEmptyMessageDelayed(104, 0);
        return;
    }

    public void resetApplogParams() {
        this.Fc = -1;
    }

    public void resetLog() {
    }

    public void setInErrorRecovering() {
        this.f459022i4 = true;
        this.f459034j4 = System.currentTimeMillis();
    }

    static {
        f458906ce = new AtomicLong(0);
        f458907de = new AtomicLong(0);
        f458908ee = new AtomicLong(0);
        f458909fe = new AtomicLong(0);
        f458910ge = new AtomicLong(0);
        f458911he = new AtomicLong(0);
        f458912ie = new AtomicLong(0);
        f458913je = new AtomicLong(0);
        f458914ke = new HashMap();
    }

    private long calculatePreplayTime() {
        VideoLiveManager r100 = this.f458980f;
        if (r100 != null) goto L5;
    L40:
        return 0;
    L5:
        if (r100.getPreplayType() == 0) goto L40;
        long r101 = this.f459020i;
        if (r101 != 0) goto L11;
        r101 = System.currentTimeMillis();
    L11:
        if (r100.getPreplayType() != 3) goto L22;
        LogBundle r102 = this.f458968e;
        if (r102 == null) goto L20;
        long r103 = r102.f459318n;
        if (r103 <= 0) goto L20;
        if (r101 <= r103) goto L20;
        return r101 - r103;
    L20:
        return 0;
    L22:
        if (this.f459009h3 == false) goto L28;
        long r104 = this.f459033j3;
        if (r101 > r104) goto L26;
        return 0;
    L26:
        return r101 - r104;
    L28:
        LogBundle r105 = this.f458968e;
        if (r105 == null) goto L31;
        long r106 = r105.f459318n;
    L33:
        if (r106 != 0) goto L36;
        return 0;
    L36:
        if (r106 <= r101) goto L39;
        return 0;
    L39:
        return r101 - r106;
    L31:
        r106 = 0;
        goto L33
    }

    private void calibratePlayTime() {
        if (this.f458942bd != 1) goto L5;
        return;
    L5:
        long r100 = System.currentTimeMillis() - this.f459052k8;
        long r101 = this.Pc + this.Qc;
        long r102 = r100 - r101;
        c.d("LiveLoggerService", "sessionPlayTime:" + r100 + "totaliotime:" + r101 + "diff:" + r102);
        if (r100 > 0) goto L8;
    L12:
        this.f458942bd = 2;
        return;
    L8:
        if (r101 <= 0) goto L12;
        if (Math.abs(r102) > 1000) goto L12;
        long r103 = this.Pc;
        long r104 = (r102 * r103) / r101;
        this.Pc = r103 + r104;
        this.Qc += r102 - r104;
    }

    private void computeDisplayTime() {
        if (this.f459038j8 == false) goto L39;
        LogBundle r100 = this.f459026i8;
        if (r100 != null) goto L8;
        return;
    L8:
        if (r100.E3 != 0) goto L10;
        r100.E3 = 1;
        long r101 = this.f459064l8;
    L11:
        long r102 = System.currentTimeMillis() - r101;
        DisplayModel r103 = this.Nd;
        if (r103 != DisplayModel.PREVIEW_PREPLAY) goto L15;
        this.f459026i8.f459382z3 += r102;
        return;
    L15:
        if (r103 != DisplayModel.PREVIEW) goto L18;
        this.f459026i8.f459372x3 += r102;
        return;
    L18:
        if (r103 != DisplayModel.INNER_PREPLAY) goto L21;
        this.f459026i8.A3 += r102;
        return;
    L21:
        if (r103 != DisplayModel.INNER) goto L24;
        this.f459026i8.f459377y3 += r102;
        return;
    L24:
        if (r103 != DisplayModel.SMALL_WINDOW) goto L27;
        this.f459026i8.C3 += r102;
        return;
    L27:
        if (r103 != DisplayModel.INITAL) goto L30;
        this.f459026i8.D3 += r102;
        return;
    L30:
        if (r103 != DisplayModel.BACKGROUND) goto L33;
        this.f459026i8.B3 += r102;
        return;
    L33:
        if (r103 == DisplayModel.OTHER) goto L35;
        return;
    L35:
        if (this.Qd.containsKey(this.Od) == false) goto L37;
        r102 = r102 + this.Qd.get(this.Od).longValue();
    L37:
        this.Qd.put(this.Od, Long.valueOf(r102));
        return;
    L10:
        r101 = this.Ld;
        goto L11
    }

    private String getAlgoSeParams() {
        VideoLiveManager r100 = this.f458980f;
        if (r100 != null) goto L5;
        return "none";
    L5:
        umc.b r101 = r100.mAlgoSeiFunction;
        if (r101 != null) goto L8;
        return "none";
    L8:
        if ((r101 instanceof umc.c) == false) goto L17;
        return ((umc.c) r101).getSeiReportStr();
    L12:
        c.e("getSeiReportStr", "parseSEI err");
        return "none";
    L17:
        return "none";
    }

    private int getCallPreloadFuncState() {
        VideoLiveManager r100 = this.f458980f;
        if (r100 != null) goto L5;
        return -1;
    L5:
        return r100.getCallPreloadFuncState();
    }

    private int getEnableRtsPlay() {
        VideoLiveManager r100 = this.f458980f;
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.getEnableRtsPlay();
    }

    private int getRTCPreloadingState() {
        VideoLiveManager r100 = this.f458980f;
        if (r100 != null) goto L5;
        return -1;
    L5:
        return r100.getPreloadState();
    }

    private void initReportKey() {
        HashMap<String, Integer> r100 = f458914ke;
        r100.put("playing", 1);
        r100.put("play_stop", 4);
        r100.put("start_play", 8);
        r100.put(PortraitEngine.LABEL_FIRST_FRAME, 4096);
        r100.put("session_stop", 64);
        r100.put("pull_restart_recmd", 128);
        r100.put("pull_restart", 8192);
        r100.put("pull_restart_success", 256);
        r100.put("demux_stall", 512);
        r100.put(EventConstant.Value.RETRY, 1024);
        r100.put("play_error", 2048);
        r100.put("vqscore_report", 16384);
        r100.put("session_start", 2);
        r100.put("session_first_frame", 16);
        r100.put("stream_abnormal", 32);
    }

    private boolean isNetWorkChanged() {
        NetworkInfo r100 = ymc.d.getNetworkInfo(this.f458929b);
        if (r100 != null) goto L5;
    L7:
        int r101 = -1;
    L9:
        if (r101 != (-1)) goto L11;
        this.f459159t4 = r101;
        return true;
    L11:
        if (r101 == this.f459159t4) goto L14;
        this.f459159t4 = r101;
        return true;
    L14:
        return false;
    L5:
        if (r100.isAvailable() == false) goto L7;
        r101 = r100.getType();
        goto L9
    }

    private void ntp() {
        NTPUDPClient r100 = this.f459096o4;
        if (r100 != null) goto L5;
        return;
    L5:
        TimeInfo r101 = null;
        r100.open();     // Catch: IOException -> L10 SocketException -> L16
        InetAddress r102 = this.f459111p4;     // Catch: IOException -> L10 SocketException -> L16
        if (r102 == null) goto L12;
        r101 = this.f459096o4.getTime(r102);     // Catch: IOException -> L10 SocketException -> L16
    L12:
        if (r101 != null) goto L14;
        return;
    L14:
        long r103 = r101.getMessage().getOriginateTimeStamp().getTime();
        long r104 = r101.getMessage().getReceiveTimeStamp().getTime();
        long r105 = r101.getMessage().getTransmitTimeStamp().getTime();
        long r106 = System.currentTimeMillis();
        this.f459225y4 = ((r104 - r103) + (r105 - r106)) / 2;
        c.d("zdh", "ori:" + r103 + " rec:" + r104 + " trans:" + r105 + " destTs:" + r106 + " diff:" + this.f459225y4);
        return;
    L16:
        e = move-exception;
        e.printStackTrace();
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L12
    }

    private void resetAbrSessionInfo() {
        this.f459173u6 = 0;
        this.f459187v6 = 0;
    }

    private void resetSessionInfo() {
        if (this.f459014h8 != 0) goto L5;
        return;
    L5:
        if (this.f459026i8 == null) goto L10;
        this.f459038j8 = false;
        this.f458941bc = 0;
        this.f458978ec = 0;
        this.f459201w8 = 0;
        this.f459215x8 = 0;
        this.f459127q8 = 0;
        this.f459139r8 = 0;
        this.f459052k8 = 0;
        this.f459064l8 = 0;
        this.f459076m8 = 0;
        this.Ad = 0;
        ((ArrayList) this.f459234yd).clear();
        this.f459246zd = new ArrayList();
        this.f459088n8 = 0;
        this.f459151s8 = 0;
        this.f459163t8 = 0;
        this.f459175u8 = 0;
        this.f459189v8 = 0;
        this.f459229y8 = -1;
        this.f459241z8 = 0;
        this.A8 = "none";
        this.f459179uc = false;
        this.Zb = 0;
        this.N9 = 0;
        this.Pc = 0;
        this.Qc = 0;
        this.Rc = -1;
        this.Sc = -1;
        this.Tc = -1;
        this.Uc = -1;
        this.Vc = 0;
        this.Wc = 0;
        this.Xc = 0;
        this.Yc = 0;
        this.Zc = 0;
        this.f458927ad = 0;
        this.f458942bd = -1;
        this.Oc = "none";
        LogBundle r100 = this.f459026i8;
        long r101 = r100.f459349t0;
        r100.reset();
        return;
    }

    private void updateSessionSeries() {
        VideoLiveManager r100 = this.f458980f;
        if (r100 == null) goto L17;
        LogBundle r101 = this.f458968e;
        if (r101 == null) goto L19;
        r100.getLogInfo(r101, 3);
        if (this.Q4 != null) goto L10;
        this.Q4 = new ArrayList();
        this.S4 = new ArrayList();
        this.R4 = new ArrayList();
    L10:
        this.Q4.add(Long.valueOf((long) this.f458968e.P0));
        this.S4.add(Long.valueOf(this.f458968e.Z0));
        this.R4.add(Long.valueOf(this.f458968e.Q0));
        if (this.f458997g5 == true) goto L13;
        return;
    L13:
        if (this.f458919a5 != null) goto L15;
        this.f458919a5 = new ArrayList();
        this.Z4 = new ArrayList();
    L15:
        this.f458919a5.add(Integer.valueOf(this.f458968e.f459320n1));
        this.Z4.add(Integer.valueOf(this.f458968e.f459315m1));
        return;
    L19:
        return;
    }

    public void calculateRenderFailType() {
        LogBundle r100 = this.f458968e;
        long r101 = r100.f459333q;
        if (r101 <= 0) goto L8;
        if (r100.f459328p <= 0) goto L8;
        this.f459110p3 = 0;
        return;
    L8:
        if (r101 <= 0) goto L13;
        if (r100.f459328p > 0) goto L13;
        this.f459110p3 = 1;
        return;
    L13:
        if (r101 <= 0) goto L15;
    L17:
        this.f459110p3 = 3;
        return;
    L15:
        if (r100.f459328p <= 0) goto L17;
        this.f459110p3 = 2;
    }

    public void calculateSessionRenderFailType() {
        long r100 = this.f459088n8;
        if (r100 <= 0) goto L8;
        if (this.f459064l8 <= 0) goto L8;
        this.f459229y8 = 0;
        return;
    L8:
        if (r100 <= 0) goto L13;
        if (this.f459064l8 > 0) goto L13;
        this.f459229y8 = 1;
        return;
    L13:
        if (r100 <= 0) goto L15;
    L17:
        this.f459229y8 = 3;
        return;
    L15:
        if (this.f459064l8 <= 0) goto L17;
        this.f459229y8 = 2;
    }

    public boolean canPlayingLogUpload() {
        VideoLiveManager r100 = this.f458980f;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.canPlayingLogUpload();
    }

    public JSONObject createCommonLog() {
        if (this.f459081md == 1) goto L5;
        this.f458980f.getVideoCodecType();
        this.f458980f.getIpFromPlayer();
        float r100 = this.f458980f.getVolume();
        float r101 = this.f458980f.getMaxVolume();
        if (r101 == 0.0f) goto L9;
        float r102 = r100 / r101;
    L10:
        boolean r103 = this.f459045k0;
        int r104 = 0;
        if ("bytevc2".equals(this.Z) == false) goto L243;
        r103 = false;
    L243:
        JSONObject r105 = new JSONObject().put("trans_tpl", this.f458980f.getCurrentTransmittedTemplateName()).put("report_version", "5").put(IPerformanceManager.Params.live_sdk_version, "1.10.260.2-aweme").put("product_line", "live").put("client_timestamp", System.currentTimeMillis());     // Catch: JSONException -> L240
        String r110 = this.f459181v;     // Catch: JSONException -> L240
        String r111 = "-1";
        if (r110 != null) goto L17;
        r110 = "-1";
    L17:
        JSONObject r106 = r105.put("player_sdk_version", r110);     // Catch: JSONException -> L240
        String r112 = this.f459121q;     // Catch: JSONException -> L240
        if (r112 != null) goto L20;
        r112 = "-1";
    L20:
        JSONObject r107 = r106.put("project_key", r112);     // Catch: JSONException -> L240
        String r113 = this.f459032j;     // Catch: JSONException -> L240
        if (r113 != null) goto L24;
        r113 = "none";
    L24:
        JSONObject r108 = r107.put("live_stream_enter_method", r113);     // Catch: JSONException -> L240
        String r114 = this.f459044k;     // Catch: JSONException -> L240
        if (r114 != null) goto L27;
        r114 = "none";
    L27:
        JSONObject r109 = r108.put("live_stream_enter_action", r114);     // Catch: JSONException -> L240
        String r115 = this.f459058l;     // Catch: JSONException -> L240
        if (r115 != null) goto L30;
        r115 = "none";
    L30:
        JSONObject r116 = r109.put("live_stream_enter_method_subtag", r115);     // Catch: JSONException -> L240
        String r117 = this.f459133r;     // Catch: JSONException -> L240
        if (r117 == null) goto L34;
        r111 = r117;
    L34:
        JSONObject r118 = r116.put("cdn_play_url", r111);     // Catch: JSONException -> L240
        String r119 = this.f459157t;     // Catch: JSONException -> L240
        if (r119 != null) goto L37;
        r119 = "none";
    L37:
        JSONObject r120 = r118.put(EventConstants.ExtraJson.KEY_CDN_IP, r119).put(BdpAppEventConstant.PARAMS_REQUEST_URL, this.X7);     // Catch: JSONException -> L240
        if (this.f459169u == false) goto L40;
        int r121 = 1;
    L41:
        JSONObject r122 = r120.put("ip_from_player_core", r121);     // Catch: JSONException -> L240
        if (this.f459195w == false) goto L44;
        int r123 = 1;
    L45:
        JSONObject r124 = r122.put(VrBgLogData.KEY_IS_PREVIEW, r123);     // Catch: JSONException -> L240
        if (this.R == false) goto L48;
        int r125 = 1;
    L49:
        JSONObject r126 = r124.put("open_dns_optimizer", r125);     // Catch: JSONException -> L240
        if (this.W == false) goto L52;
        int r127 = 1;
    L53:
        JSONObject r128 = r126.put("hit_node_optimize", r127).put("evaluator_symbol", this.S).put("lss_response_cost", this.T).put("lss_first_response_cost", this.U).put("lss_response_status_code", this.V);     // Catch: JSONException -> L240
        if (this.X == false) goto L56;
        int r129 = 1;
    L57:
        JSONObject r130 = r128.put("remote_sorted", r129).put("common_tag", this.f459070m).put(TTVideoEngineInterface.PLAY_API_KEY_CODEC, this.Z).put("codec_name", this.f459107p0);     // Catch: JSONException -> L240
        if (r103 == false) goto L60;
        int r131 = 1;
    L61:
        JSONObject r132 = r130.put("hardware_decode", r131);     // Catch: JSONException -> L240
        if (this.f458970e4 == false) goto L64;
        int r133 = 1;
    L65:
        JSONObject r134 = r132.put("sharp", r133).put("enable_skip_on_buffering_end", this.V0).put("enable_latency_network_adapt", this.L0);     // Catch: JSONException -> L240
        if (this.P0 == false) goto L68;
        int r135 = 1;
    L69:
        JSONObject r136 = r134.put("enable_hurry", r135).put("hurry_time", this.f458930b1).put("hurry_type", this.f458993g1).put("hurry_interval", this.f459007h1).put("hurry_once_max", this.f459046k1).put("hurry_cache_type", this.f459182v1).put("hurry_skip_start", this.f459108p1).put("hurry_stop_type", this.S1).put("min_buffer_stop_drop", this.T1).put("max_drop_frame_time_cost", this.V1).put("enable_fix_pts_shift", this.f458931b2).put("hurry_delay_inc_threshold", this.f458994g2).put("catch_speed", new DecimalFormat("0.00").format(this.M1)).put("slow_play_time", this.P1).put("slow_speed", new DecimalFormat("0.00").format(this.Q1));     // Catch: JSONException -> L240
        if (this.f459009h3 == false) goto L72;
        int r137 = 1;
    L73:
        JSONObject r138 = r136.put("first_screen", r137);     // Catch: JSONException -> L240
        if (this.f459023i5 == false) goto L76;
        int r139 = 1;
    L77:
        JSONObject r140 = r138.put("enable_httpDns", r139).put("enable_ntp", this.f459197w4).put("enable_media_codec_async", this.f459035j5).put("default_codec_id", this.f459049k5).put("url_ability", this.f459097o5).put("max_cache_seconds", this.f459124q5).put("enable_fast_open", this.f459160t5).put("enable_mdl", this.f459237z4).put("enable_p2p", this.A4).put("p2p_loader_type", this.D4).put("used_p2p", this.B4);     // Catch: JSONException -> L240
        String r141 = this.G4;     // Catch: JSONException -> L240
        if (r141 != null) goto L80;
        r141 = "none";
    L80:
        JSONObject r142 = r140.put("mdl_version", r141).put("enable_mdl_proto", this.H4).put("enable_low_latency_flv", this.f458936b7).put("open_strategy_sdk", this.f459165ta).put("enable_strategy_node_opt", this.f459177ua).put("enable_strategy_httpDNS", this.f459191va).put("enable_strategy_httpDNS_by_localDNS_timeout", this.f459203wa).put("enable_strategy_ipv6", this.f459217xa).put("hit_strategy_opt", this.Aa);     // Catch: JSONException -> L240
        String r143 = this.f458968e.f459365w1;     // Catch: JSONException -> L240
        if (r143 != null) goto L83;
        r143 = "none";
    L83:
        JSONObject r144 = r142.put("dns_ip", r143).put("in_main_looper", this.f459172u5).put("start_play_buffer_threshold", this.f459209x2).put("buffering_start_idl_time", this.P2).put("enable_change_start_play_buffer_advance", this.L2).put("fast_open_gop_cache", this.F2).put("used_predict_gop_cache", this.G2).put("buffering_end_ignore_video", this.H2).put("start_direct_after_prepared", this.I2).put("check_buffering_end_advance", this.J2).put("channel_id", this.f458968e.f459310l1).put("sei_delay", this.f458968e.f459280f1).put("sei_source", this.f458968e.f459300j1).put(BdpAppEventConstant.PARAMS_SUB_SCENE, this.f458968e.f459325o1).put("chip_board", this.U5).put("chip_hardware", this.V5).put("width", this.I4).put("height", this.J4).put("settings_info", this.W5).put("ttnet_nqe_info", this.X5);     // Catch: JSONException -> L240
        if (this.f459113p6 == false) goto L86;
        String r145 = "llash";
    L87:
        JSONObject r146 = r144.put("play_format", r145).put("play_protocol", this.F5).put("protocol_downgraded", this.I5).put("protocol_degrade_reason", this.J5).put("url_set_method", this.f458980f.getUrlSettingMethod());     // Catch: JSONException -> L240
        if (this.Z5 == false) goto L90;
        int r147 = 1;
    L91:
        JSONObject r148 = r146.put("enable_resolution_auto_degrade", r147).put("has_abr_info", this.f458935b6).put("quic_load_succ", this.H5).put("link_info", this.P);     // Catch: JSONException -> L240
        if (this.B5 == false) goto L94;
        int r149 = 1;
    L95:
        JSONObject r150 = r148.put("used_texturerender", r149).put("settings_res", this.f458948c6).put("start_up_res", this.f458972e6).put("is_too_large_av_diff", this.f458968e.D2).put("stall_retry_time_interval", this.f459010h4).put("is_too_large_av_diff", this.f458968e.D2).put("enable_rtc_play", getEnableRtsPlay()).put("enable_rts_quic", this.f459240z7).put("enable_mini_sdp", this.f459228y7).put("rtc_play_fallback", this.A7).put("fallback_type", this.L7).put("mute_audio", this.f458937b8).put("player_volume_setting", this.f458950c8).put("enable_liveio_play", this.C4).put("liveio_play", this.H9).put("liveio_p2p", this.I9).put("liveio_p2p_upload", this.E4).put("liveio_demuxer", this.J9).put("liveio_rtm_vmtp", this.K9).put("liveio_prepare_spent", this.F4).put("enable_pcdn_rts", this.P9).put("pcdn_rts_sdk_available", this.Q9).put("pcdn_rts_play", this.R9).put("timer_version", this.W6).put(LocationMonitorConst.IS_BACKGROUND, this.f459066la).put("duration_of_start_auto_speed", this.E2).put("redirect_ip", this.f459141ra).put("request_id", this.Z7).put("backup_to_origin", this.Ia).put("enable_strategy_performance_optimization", this.f459231ya).put("strategy_start_up_delay", this.f459243za).put("udp_probe_result", this.La).put("udp_probe_info", this.Ma).put("quic_fallback_tcp", this.Ja).put("enable_global_volume_balance", this.M2).put("volume_balance_type", this.N2).put("volume_balance_targetlufs", this.O2).put("enable_strategy_trans_params", this.Ca).put("enable_use_pty", this.Ga).put("enable_start_init_pty", this.Ha).put("external_res", this.f458960d6);     // Catch: JSONException -> L240
        if (this.f458998g6 == false) goto L98;
        int r151 = 1;
    L99:
        JSONObject r152 = r150.put("enable_lower_res", r151);     // Catch: JSONException -> L240
        if (this.f459012h6 == false) goto L102;
        int r153 = 1;
    L103:
        JSONObject r154 = r152.put("enable_low_res_startplay", r153).put("volume_setting", r102).put("cert_verify_failed", this.f458968e.P1).put("cert_verify_detail", this.f458968e.Q1).put(ITiktokService.ResponseConstants.REDIRECT_URL, this.f458968e.R1).put("enable_preplay_smooth_switch", this.f459142rb).put("live_stream_strategy_startup_bitrate_predict", this.f459178ub).put("live_stream_strategy_smooth_switch_probe_bitrate", this.f459192vb).put("liveplayer_hash_code", this.f458980f.getHashCode()).put("sei_ver", this.f458968e.f459305k1).put("fallback_from_hdr_to_sdr", this.Ob).put("cae_category", this.f458990fc);     // Catch: JSONException -> L240
        if (this.f458980f.getPreplayType() == 0) goto L107;
        r104 = 1;
    L107:
        JSONObject r155 = r154.put("is_preplay", r104).put("preplay_type", this.f458980f.getPreplayType()).put("transport_type", this.W2);     // Catch: JSONException -> L240
        if (TextUtils.isEmpty(this.U2) == false) goto L110;
        String r156 = "none";
    L111:
        JSONObject r157 = r155.put("biz_session_id", r156).put("scene_tags", this.f459094o).put("business_type", this.f459106p).put("pcdn_isolation_name", this.V9).put("multipath_network_type", this.X9).put("unstable_network_status", VideoLiveManager.sNetworkStatus).put("device_policy_ids", this.f459019hd);     // Catch: JSONException -> L240
        if (this.f459166tb != 1) goto L115;
        r157.put("dynamic_open_texturerender", 1);     // Catch: JSONException -> L240
    L115:
        if (this.f459024i6.equals("none") == true) goto L117;
        r157.put("abr_default_res", this.f459024i6);     // Catch: JSONException -> L240
    L117:
        ArrayList<Integer> r158 = this.f459102oa;     // Catch: JSONException -> L240
        if (r158 == null) goto L123;
        if (r158.isEmpty() == true) goto L123;
        r157.put("ab_group_id", new JSONArray(this.f459102oa));     // Catch: JSONException -> L240
    L123:
        if (this.C4 != 1) goto L126;
        r157.put("liveio_error_msg", this.L9);     // Catch: JSONException -> L240
        r157.put("liveio_version", this.O9);     // Catch: JSONException -> L240
    L126:
        if (isRtcPlayAvailable() == false) goto L128;
        r157.put("rtc_get_width", this.f458980f.getVideoWidth());     // Catch: JSONException -> L240
        r157.put("rtc_get_height", this.f458980f.getVideoHeight());     // Catch: JSONException -> L240
    L128:
        r157.put("live_stream_session_id", this.R2);     // Catch: JSONException -> L240
        r157.put("live_vv_session_id", this.T2);     // Catch: JSONException -> L240
        if (this.f458948c6.equals("auto") == false) goto L132;
        r157.put("auto_res", this.f459036j6);     // Catch: JSONException -> L240
    L132:
        if (this.f458980f.getEnableTexturerender() != 1) goto L136;
        r157.put("texturerender_error", this.f459226y5);     // Catch: JSONException -> L240
    L136:
        if (this.f458980f.getEnableSR() == 1) goto L138;
    L142:
        r157.put("sr_width", this.I4).put("sr_height", this.J4);     // Catch: JSONException -> L240
    L143:
        VideoLiveManager r159 = this.f458980f;     // Catch: JSONException -> L240
        if (r159.mEnableGaussicanBlur == 1) goto L146;
    L148:
        VideoLiveManager r160 = this.f458980f;     // Catch: JSONException -> L240
        if (r160.mEnableLutFilter != 1) goto L154;
        if (r160.isUsedEffect(2) == false) goto L154;
        r157.put("used_lut_filter", 1);     // Catch: JSONException -> L240
    L154:
        if (this.f458980f.getEnableSharpen() != 1) goto L161;
        if (this.f458980f.getEnableTexturerender() != 1) goto L161;
        if (this.f458980f.isUsedSharpen() == false) goto L161;
        this.A5 = true;     // Catch: JSONException -> L240
    L161:
        if (this.Z5 == false) goto L163;
    L164:
        r157.put("abr_strategy", this.f458920a6).put("default_res_bitrate", this.f459074m6).put("stall_count_rad", this.C6);     // Catch: JSONException -> L240
    L165:
        String r161 = this.V2;     // Catch: JSONException -> L240
        if (r161 == null) goto L173;
        if (TextUtils.equals(r161, "cmaf") == false) goto L173;
        r157.put("cmaf_audio_min_seq_no", this.f458968e.N).put("cmaf_video_min_seq_no", this.f458968e.M).put("cmaf_audio_max_seq_no", this.f458968e.P).put("cmaf_video_max_seq_no", this.f458968e.O).put("cmaf_audio_req_seq_no", this.f458968e.R).put("cmaf_video_req_seq_no", this.f458968e.Q).put("cmaf_audio_hit_push", this.f458968e.S).put("cmaf_video_hit_push", this.f458968e.T).put("cmaf_mpd_cached", this.f458968e.U);     // Catch: JSONException -> L240
    L173:
        if (TextUtils.equals(this.F5, "quic") == false) goto L175;
    L176:
        r157.put("quic_report_cctk_frame_data", this.f458968e.f459286g2);     // Catch: JSONException -> L240
    L179:
        if (TextUtils.equals(this.F5, "quic") == false) goto L181;
    L186:
        r157.put("quic_config_cached", this.f458968e.J1).put("quic_CHLO_count", this.f458968e.K1).put("quic_connection_id", this.f458968e.O1);     // Catch: JSONException -> L240
    L188:
        if (TextUtils.equals(this.F5, "h2") == false) goto L190;
    L193:
        r157.put("h2_context_start_cost", this.f458968e.T1);     // Catch: JSONException -> L240
        r157.put("h2_reused", this.f458968e.U1);     // Catch: JSONException -> L240
        r157.put("h2_race_result", this.f458968e.F1);     // Catch: JSONException -> L240
        r157.put("h2_negotiate_protocol", this.f458968e.D1);     // Catch: JSONException -> L240
        r157.put("h2_push_url_list", this.f458968e.E1);     // Catch: JSONException -> L240
        r157.put("h2_pushed_stream_count", this.f458968e.G1);     // Catch: JSONException -> L240
    L195:
        if (this.f458980f.mEnableRadioLiveDisableRender != 1) goto L197;
        r157.put("disable_video_render", this.f458922a8);     // Catch: JSONException -> L240
    L197:
        int r162 = this.f459136r5;     // Catch: JSONException -> L240
        if (r162 <= 0) goto L200;
        r157.put("tsl_timeshift", r162);     // Catch: JSONException -> L240
    L200:
        Map<String, String> r163 = this.Y7;     // Catch: JSONException -> L240
        if (r163 == null) goto L208;
        Iterator<Map.Entry<String, String>> r164 = r163.entrySet().iterator();     // Catch: JSONException -> L240
    L204:
        if (r164.hasNext() == false) goto L208;
        Map.Entry<String, String> r165 = r164.next();     // Catch: JSONException -> L240
        if (r165.getKey().equals("Host") == false) goto L204;
        r157.put("headers_host", r165.getValue().replace(" ", ""));     // Catch: JSONException -> L240
    L208:
        int r166 = this.f458974e8;     // Catch: JSONException -> L240
        if (r166 == (-1)) goto L211;
        r157.put("fcdn_res_type", r166);     // Catch: JSONException -> L240
    L211:
        int r167 = this.f458986f8;     // Catch: JSONException -> L240
        if (r167 == (-1)) goto L215;
        r157.put("fcdn_trans_strategy", r167);     // Catch: JSONException -> L240
    L215:
        if (TextUtils.isEmpty(this.F5) == true) goto L226;
        if (this.F5.equals("quic") == false) goto L219;
    L224:
        r157.put("ttquic_sdk_version", this.f458968e.A1);     // Catch: JSONException -> L240
        r157.put("quic_rej_count", this.f458968e.C1);     // Catch: JSONException -> L240
        r157.put("quic_rej_reasons", this.f458968e.B1);     // Catch: JSONException -> L240
        goto L226
    L219:
        if (this.F5.equals("quicu") == true) goto L224;
        if (this.F5.equals("h2q") == true) goto L224;
        if (this.F5.equals("h2qu") == true) goto L224;
    L226:
        if (TextUtils.equals(this.V2, "cmaf") == false) goto L230;
        reportCmafRequestLog(r157);     // Catch: JSONException -> L240
    L230:
        if (this.f459033j3 == 0) goto L232;
        r157.put("play_time_axis", System.currentTimeMillis() - this.f459033j3);     // Catch: JSONException -> L240
    L233:
        int r168 = this.Fc;     // Catch: JSONException -> L240
        if (r168 == (-1)) goto L237;
        r157.put("reporting_priority", r168);     // Catch: JSONException -> L240
    L237:
        if (this.f459043jd == 1) goto L239;
        r157.put("protocol_downgraded", this.I5).put("push_client_sdk_version", this.D).put("push_client_platform", this.E).put("push_client_os_version", this.F).put("push_client_model", this.G).put("push_client_start_time", this.H).put("push_client_is_hardware_encode", this.I).put("push_client_min_bitrate", this.f458915J).put("push_client_max_bitrate", this.K).put("push_client_default_bitrate", this.L).put("push_client_push_protocol", this.N).put("push_client_qid", this.O).put("push_client_hit_node_optimize", this.M);     // Catch: JSONException -> L240
    L239:
        return r157;
    L232:
        r157.put("play_time_axis", -1);     // Catch: JSONException -> L240
        goto L233
    L190:
        if (TextUtils.equals(this.F5, "h2q") == true) goto L193;
        if (TextUtils.equals(this.F5, "h2qu") == false) goto L195;
    L181:
        if (TextUtils.equals(this.F5, "quicu") == true) goto L186;
        if (TextUtils.equals(this.F5, "h2q") == true) goto L186;
        if (TextUtils.equals(this.F5, "h2qu") == false) goto L188;
    L175:
        if (TextUtils.equals(this.F5, "h2q") == false) goto L179;
    L163:
        if (this.f458935b6 == false) goto L165;
    L146:
        if (r159.isUsedEffect(10) == false) goto L148;
        r157.put("used_gaussican_blur", 1);     // Catch: JSONException -> L240
        r157.put("gaussican_blur_strength", this.f459153sa);     // Catch: JSONException -> L240
        goto L148
    L138:
        if (this.f458980f.getEnableTexturerender() != 1) goto L142;
        if (this.f458980f.getSRUsed() == false) goto L142;
        float r169 = this.f458980f.getSRScaleFloatType();     // Catch: JSONException -> L240
        r157.put("sr_width", (int) (this.I4 * r169));     // Catch: JSONException -> L240
        r157.put("sr_height", (int) (this.J4 * r169));     // Catch: JSONException -> L240
        this.f459238z5 = true;     // Catch: JSONException -> L240
        goto L143
    L110:
        r156 = this.U2;     // Catch: JSONException -> L240
        goto L111
    L102:
        r153 = 0;
        goto L103
    L98:
        r151 = 0;
        goto L99
    L94:
        r149 = 0;
        goto L95
    L90:
        r147 = 0;
        goto L91
    L86:
        r145 = this.V2;     // Catch: JSONException -> L240
        goto L87
    L76:
        r139 = 0;
        goto L77
    L72:
        r137 = 0;
        goto L73
    L68:
        r135 = 0;
        goto L69
    L64:
        r133 = 0;
        goto L65
    L60:
        r131 = 0;
        goto L61
    L56:
        r129 = 0;
        goto L57
    L52:
        r127 = 0;
        goto L53
    L48:
        r125 = 0;
        goto L49
    L44:
        r123 = 0;
        goto L45
    L40:
        r121 = 0;
    L240:
        e = move-exception;
        e.printStackTrace();
        return null;
    L9:
        r102 = -1.0f;
        goto L10
    L5:
        return createNecessaryCommonLog();
    }

    public JSONObject createNecessaryCommonLog() {
        this.f458980f.getVideoCodecType();
        this.f458980f.getIpFromPlayer();
        boolean r100 = this.f459045k0;
        if ("bytevc2".equals(this.Z) == false) goto L5;
        r100 = false;
    L5:
        float r101 = this.f458980f.getVolume();
        float r110 = this.f458980f.getMaxVolume();
        if (r110 == 0.0f) goto L8;
        float r102 = r101 / r110;
    L98:
        JSONObject r111 = new JSONObject().put("trans_tpl", this.f458980f.getCurrentTransmittedTemplateName()).put("report_version", "5").put(IPerformanceManager.Params.live_sdk_version, "1.10.260.2-aweme").put("product_line", "live").put("client_timestamp", System.currentTimeMillis());     // Catch: JSONException -> L95
        String r112 = this.f459181v;     // Catch: JSONException -> L95
        if (r112 != null) goto L13;
        r112 = "-1";
    L13:
        JSONObject r113 = r111.put("player_sdk_version", r112);     // Catch: JSONException -> L95
        String r114 = this.f459121q;     // Catch: JSONException -> L95
        if (r114 != null) goto L16;
        r114 = "-1";
    L16:
        JSONObject r115 = r113.put("project_key", r114);     // Catch: JSONException -> L95
        String r116 = this.f459133r;     // Catch: JSONException -> L95
        if (r116 != null) goto L19;
        r116 = "-1";
    L19:
        JSONObject r117 = r115.put("cdn_play_url", r116);     // Catch: JSONException -> L95
        String r118 = this.f459157t;     // Catch: JSONException -> L95
        if (r118 != null) goto L23;
        r118 = "none";
    L23:
        JSONObject r119 = r117.put(EventConstants.ExtraJson.KEY_CDN_IP, r118).put(BdpAppEventConstant.PARAMS_REQUEST_URL, this.X7);     // Catch: JSONException -> L95
        if (this.f459195w == false) goto L26;
        int r120 = 1;
    L27:
        JSONObject r121 = r119.put(VrBgLogData.KEY_IS_PREVIEW, r120).put(TTVideoEngineInterface.PLAY_API_KEY_CODEC, this.Z).put("codec_name", this.f459107p0);     // Catch: JSONException -> L95
        if (r100 == false) goto L30;
        int r103 = 1;
    L31:
        JSONObject r104 = r121.put("hardware_decode", r103).put("in_main_looper", this.f459172u5);     // Catch: JSONException -> L95
        if (this.f459113p6 == false) goto L34;
        String r122 = "llash";
    L35:
        JSONObject r105 = r104.put("play_format", r122).put("play_protocol", this.F5).put("width", this.I4).put("height", this.J4).put("ttnet_nqe_info", this.X5).put("has_abr_info", this.f458935b6);     // Catch: JSONException -> L95
        if (this.B5 == false) goto L38;
        int r123 = 1;
    L39:
        JSONObject r106 = r105.put("used_texturerender", r123).put("settings_res", this.f458948c6).put("start_up_res", this.f458972e6).put("is_too_large_av_diff", this.f458968e.D2).put("stall_retry_time_interval", this.f459010h4).put("enable_rtc_play", getEnableRtsPlay()).put("rtc_play_fallback", this.A7).put("fallback_type", this.L7).put("mute_audio", this.f458937b8).put("player_volume_setting", this.f458950c8).put("enable_liveio_play", this.C4).put("liveio_play", this.H9).put("liveio_p2p", this.I9).put("liveio_p2p_upload", this.E4).put("liveio_demuxer", this.J9).put("liveio_rtm_vmtp", this.K9).put("liveio_prepare_spent", this.F4).put("enable_pcdn_rts", this.P9).put("pcdn_rts_sdk_available", this.Q9).put("pcdn_rts_play", this.R9).put(LocationMonitorConst.IS_BACKGROUND, this.f459066la).put("duration_of_start_auto_speed", this.E2).put("redirect_ip", this.f459141ra).put("request_id", this.Z7).put("backup_to_origin", this.Ia).put("enable_strategy_performance_optimization", this.f459231ya).put("strategy_start_up_delay", this.f459243za).put("udp_probe_result", this.La).put("udp_probe_info", this.Ma).put("enable_global_volume_balance", this.M2).put("volume_balance_type", this.N2).put("volume_balance_targetlufs", this.O2).put("volume_setting", r102).put(ITiktokService.ResponseConstants.REDIRECT_URL, this.f458968e.R1).put("enable_preplay_smooth_switch", this.f459142rb).put("liveplayer_hash_code", this.f458980f.getHashCode()).put("cae_category", this.f458990fc);     // Catch: JSONException -> L95
        if (this.f458980f.getPreplayType() != 0) goto L42;
        int r124 = 0;
    L43:
        JSONObject r107 = r106.put("is_preplay", r124).put("preplay_type", this.f458980f.getPreplayType()).put("transport_type", this.W2).put("scene_tags", this.f459094o).put("business_type", this.f459106p).put("pcdn_isolation_name", this.V9).put("multipath_network_type", this.X9).put("unstable_network_status", VideoLiveManager.sNetworkStatus).put("device_policy_ids", this.f459019hd);     // Catch: JSONException -> L95
        String r125 = this.f458968e.f459365w1;     // Catch: JSONException -> L95
        if (r125 != null) goto L46;
        r125 = "none";
    L46:
        JSONObject r108 = r107.put("dns_ip", r125).put("report_version", "5").put(IPerformanceManager.Params.live_sdk_version, "1.10.260.2-aweme").put("product_line", "live");     // Catch: JSONException -> L95
        String r109 = this.f459181v;     // Catch: JSONException -> L95
        if (r109 != null) goto L49;
        String r126 = "-1";
    L50:
        JSONObject r127 = r108.put("player_sdk_version", r126).put("sei_delay", this.f458968e.f459280f1).put("fast_open_gop_cache", this.F2);     // Catch: JSONException -> L95
        if (this.f459166tb != 1) goto L54;
        r127.put("dynamic_open_texturerender", 1);     // Catch: JSONException -> L95
    L54:
        if (this.f459024i6.equals("none") == true) goto L56;
        r127.put("abr_default_res", this.f459024i6);     // Catch: JSONException -> L95
    L56:
        ArrayList<Integer> r128 = this.f459102oa;     // Catch: JSONException -> L95
        if (r128 == null) goto L62;
        if (r128.isEmpty() == true) goto L62;
        r127.put("ab_group_id", new JSONArray(this.f459102oa));     // Catch: JSONException -> L95
    L62:
        if (this.C4 != 1) goto L65;
        r127.put("liveio_error_msg", this.L9);     // Catch: JSONException -> L95
        r127.put("liveio_version", this.O9);     // Catch: JSONException -> L95
    L65:
        if (isRtcPlayAvailable() == false) goto L67;
        r127.put("rtc_get_width", this.f458980f.getVideoWidth());     // Catch: JSONException -> L95
        r127.put("rtc_get_height", this.f458980f.getVideoHeight());     // Catch: JSONException -> L95
    L67:
        r127.put("live_stream_session_id", this.R2);     // Catch: JSONException -> L95
        r127.put("live_vv_session_id", this.T2);     // Catch: JSONException -> L95
        if (this.f458948c6.equals("auto") == false) goto L71;
        r127.put("auto_res", this.f459036j6);     // Catch: JSONException -> L95
    L71:
        if (this.f458980f.getEnableTexturerender() != 1) goto L75;
        r127.put("texturerender_error", this.f459226y5);     // Catch: JSONException -> L95
    L75:
        if (this.f458980f.getEnableSR() == 1) goto L77;
    L81:
        r127.put("sr_width", this.I4).put("sr_height", this.J4);     // Catch: JSONException -> L95
    L83:
        if (this.f458980f.getEnableSharpen() != 1) goto L90;
        if (this.f458980f.getEnableTexturerender() != 1) goto L90;
        if (this.f458980f.isUsedSharpen() == false) goto L90;
        this.A5 = true;     // Catch: JSONException -> L95
    L90:
        if (this.Z5 == false) goto L92;
    L93:
        r127.put("abr_strategy", this.f458920a6).put("default_res_bitrate", this.f459074m6).put("stall_count_rad", this.C6);     // Catch: JSONException -> L95
    L94:
        return r127;
    L92:
        if (this.f458935b6 == false) goto L94;
    L77:
        if (this.f458980f.getEnableTexturerender() != 1) goto L81;
        if (this.f458980f.getSRUsed() == false) goto L81;
        float r129 = this.f458980f.getSRScaleFloatType();     // Catch: JSONException -> L95
        r127.put("sr_width", (int) (this.I4 * r129));     // Catch: JSONException -> L95
        r127.put("sr_height", (int) (this.J4 * r129));     // Catch: JSONException -> L95
        this.f459238z5 = true;     // Catch: JSONException -> L95
        goto L83
    L49:
        r126 = r109;
        goto L50
    L42:
        r124 = 1;
        goto L43
    L38:
        r123 = 0;
        goto L39
    L34:
        r122 = this.V2;     // Catch: JSONException -> L95
        goto L35
    L30:
        r103 = 0;
        goto L31
    L26:
        r120 = 0;
    L95:
        e = move-exception;
        e.printStackTrace();
        return null;
    L8:
        r102 = -1.0f;
        goto L98
    }

    public JSONObject createUnimportantCommonLog() {
        JSONObject r100 = new JSONObject().put("sei_ver", this.f458968e.f459305k1).put("fallback_from_hdr_to_sdr", this.Ob);     // Catch: JSONException -> L85
        String r101 = "none";
        if (TextUtils.isEmpty(this.U2) == false) goto L6;
        String r102 = "none";
    L7:
        JSONObject r103 = r100.put("biz_session_id", r102).put("live_stream_strategy_startup_bitrate_predict", this.f459178ub).put("live_stream_strategy_smooth_switch_probe_bitrate", this.f459192vb).put("external_res", this.f458960d6).put("enable_rts_quic", this.f459240z7).put("cert_verify_failed", this.f458968e.P1).put("cert_verify_detail", this.f458968e.Q1);     // Catch: JSONException -> L85
        int r104 = 0;
        if (this.f459012h6 == false) goto L10;
        int r105 = 1;
    L11:
        JSONObject r106 = r103.put("enable_low_res_startplay", r105);     // Catch: JSONException -> L85
        String r107 = this.f459032j;     // Catch: JSONException -> L85
        if (r107 != null) goto L14;
        r107 = "none";
    L14:
        JSONObject r108 = r106.put("live_stream_enter_method", r107);     // Catch: JSONException -> L85
        String r109 = this.f459044k;     // Catch: JSONException -> L85
        if (r109 != null) goto L17;
        r109 = "none";
    L17:
        JSONObject r110 = r108.put("live_stream_enter_action", r109);     // Catch: JSONException -> L85
        String r111 = this.f459058l;     // Catch: JSONException -> L85
        if (r111 == null) goto L21;
        r101 = r111;
    L21:
        JSONObject r112 = r110.put("live_stream_enter_method_subtag", r101).put("start_play_buffer_threshold", this.f459209x2).put("buffering_start_idl_time", this.P2).put("enable_change_start_play_buffer_advance", this.L2).put("used_predict_gop_cache", this.G2).put("buffering_end_ignore_video", this.H2).put("start_direct_after_prepared", this.I2).put("check_buffering_end_advance", this.J2).put("channel_id", this.f458968e.f459310l1).put("sei_source", this.f458968e.f459300j1).put(BdpAppEventConstant.PARAMS_SUB_SCENE, this.f458968e.f459325o1).put("chip_board", this.U5).put("chip_hardware", this.V5).put("url_set_method", this.f458980f.getUrlSettingMethod());     // Catch: JSONException -> L85
        if (this.Z5 == false) goto L24;
        r104 = 1;
    L24:
        JSONObject r113 = r112.put("enable_resolution_auto_degrade", r104).put("quic_load_succ", this.H5).put("link_info", this.P).put("common_tag", this.f459070m);     // Catch: JSONException -> L85
        int r114 = this.Fc;     // Catch: JSONException -> L85
        if (r114 == (-1)) goto L29;
        r113.put("reporting_priority", r114);     // Catch: JSONException -> L85
    L29:
        if (TextUtils.equals(this.F5, "h2") == false) goto L31;
    L34:
        r113.put("h2_context_start_cost", this.f458968e.T1);     // Catch: JSONException -> L85
        r113.put("h2_reused", this.f458968e.U1);     // Catch: JSONException -> L85
        r113.put("h2_race_result", this.f458968e.F1);     // Catch: JSONException -> L85
        r113.put("h2_negotiate_protocol", this.f458968e.D1);     // Catch: JSONException -> L85
        r113.put("h2_push_url_list", this.f458968e.E1);     // Catch: JSONException -> L85
        r113.put("h2_pushed_stream_count", this.f458968e.G1);     // Catch: JSONException -> L85
    L36:
        if (this.f458980f.mEnableRadioLiveDisableRender != 1) goto L38;
        r113.put("disable_video_render", this.f458922a8);     // Catch: JSONException -> L85
    L38:
        int r115 = this.f459136r5;     // Catch: JSONException -> L85
        if (r115 <= 0) goto L41;
        r113.put("tsl_timeshift", r115);     // Catch: JSONException -> L85
    L41:
        Map<String, String> r116 = this.Y7;     // Catch: JSONException -> L85
        if (r116 == null) goto L49;
        Iterator<Map.Entry<String, String>> r117 = r116.entrySet().iterator();     // Catch: JSONException -> L85
    L45:
        if (r117.hasNext() == false) goto L49;
        Map.Entry<String, String> r118 = r117.next();     // Catch: JSONException -> L85
        if (r118.getKey().equals("Host") == false) goto L45;
        r113.put("headers_host", r118.getValue().replace(" ", ""));     // Catch: JSONException -> L85
    L49:
        int r119 = this.f458974e8;     // Catch: JSONException -> L85
        if (r119 == (-1)) goto L52;
        r113.put("fcdn_res_type", r119);     // Catch: JSONException -> L85
    L52:
        int r120 = this.f458986f8;     // Catch: JSONException -> L85
        if (r120 == (-1)) goto L56;
        r113.put("fcdn_trans_strategy", r120);     // Catch: JSONException -> L85
    L56:
        if (TextUtils.isEmpty(this.F5) == true) goto L67;
        if (this.F5.equals("quic") == false) goto L60;
    L65:
        r113.put("ttquic_sdk_version", this.f458968e.A1);     // Catch: JSONException -> L85
        r113.put("quic_rej_count", this.f458968e.C1);     // Catch: JSONException -> L85
        r113.put("quic_rej_reasons", this.f458968e.B1);     // Catch: JSONException -> L85
        goto L67
    L60:
        if (this.F5.equals("quicu") == true) goto L65;
        if (this.F5.equals("h2q") == true) goto L65;
        if (this.F5.equals("h2qu") == true) goto L65;
    L67:
        if (TextUtils.equals(this.V2, "cmaf") == false) goto L71;
        reportCmafRequestLog(r113);     // Catch: JSONException -> L85
    L71:
        if (this.f459033j3 == 0) goto L73;
        r113.put("play_time_axis", System.currentTimeMillis() - this.f459033j3);     // Catch: JSONException -> L85
    L74:
        VideoLiveManager r121 = this.f458980f;     // Catch: JSONException -> L85
        if (r121.mEnableGaussicanBlur == 1) goto L77;
    L79:
        VideoLiveManager r122 = this.f458980f;     // Catch: JSONException -> L85
        if (r122.mEnableLutFilter == 1) goto L82;
    L84:
        return r113;
    L82:
        if (r122.isUsedEffect(2) == false) goto L84;
        r113.put("used_lut_filter", 1);     // Catch: JSONException -> L85
        goto L84
    L77:
        if (r121.isUsedEffect(10) == false) goto L79;
        r113.put("used_gaussican_blur", 1);     // Catch: JSONException -> L85
        r113.put("gaussican_blur_strength", this.f459153sa);     // Catch: JSONException -> L85
        goto L79
    L73:
        r113.put("play_time_axis", -1);     // Catch: JSONException -> L85
        goto L74
    L31:
        if (TextUtils.equals(this.F5, "h2q") == true) goto L34;
        if (TextUtils.equals(this.F5, "h2qu") == false) goto L36;
    L10:
        r105 = 0;
        goto L11
    L6:
        r102 = this.U2;     // Catch: JSONException -> L85
    L85:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public boolean enableRtmLastPlayingStat() {
        VideoLiveManager r100 = this.f458980f;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.enableRtmLastPlayingStat();
    }

    public void getABRStreamInfo() {
        VideoLiveManager r100 = this.f458980f;
        if (r100 == null) goto L9;
        LogBundle r101 = this.f458968e;
        if (r101 == null) goto L10;
        r100.getLogInfo(r101, 8);
        return;
    L10:
        return;
    }

    public void getAVPHStreamInfo() {
        VideoLiveManager r100 = this.f458980f;
        if (r100 == null) goto L9;
        LogBundle r101 = this.f458968e;
        if (r101 == null) goto L10;
        r100.getLogInfo(r101, 9);
        return;
    L10:
        return;
    }

    public long getCurrentDelay() {
        return this.f458968e.f459280f1;
    }

    public long getCurrentStallTime() {
        long r100 = this.f459170u3;
        if (isStalling() == true) goto L5;
        return r100;
    L5:
        return r100 + (System.currentTimeMillis() - this.f459122q3);
    }

    public String getCurrentStreamFormat() {
        if (this.f459113p6 == false) goto L6;
        return "llash";
    L6:
        return this.V2;
    }

    public long getFirstFrameDownloadSpeed() {
        return this.f458968e.f459255a1;
    }

    public JSONObject getLiveInfoItems() {
        Long r100 = 0L;
        ArrayList<Long> r101 = this.R4;
        if (r101 != null) goto L5;
    L22:
        JSONObject r102 = new JSONObject();     // Catch: JSONException -> L19
        String r103 = this.f459133r;     // Catch: JSONException -> L19
        if (r103 != null) goto L14;
        r103 = "-1";
    L14:
        JSONObject r104 = r102.put("cdn_play_url", r103);     // Catch: JSONException -> L19
        String r105 = this.f459157t;     // Catch: JSONException -> L19
        if (r105 != null) goto L17;
        r105 = "none";
    L17:
        return r104.put(EventConstants.ExtraJson.KEY_CDN_IP, r105).put("pull_stream_bitrate", r100);
    L19:
        e = move-exception;
        e.printStackTrace();
        return null;
    L5:
        if (r101.isEmpty() == true) goto L22;
        Iterator<Long> r106 = this.R4.iterator();
    L8:
        if (r106.hasNext() == false) goto L10;
        Long r107 = r106.next();
        r100 = Long.valueOf(r100.longValue() + r107.longValue());
        goto L8
    L10:
        r100 = Long.valueOf(r100.longValue() / ((long) this.R4.size()));
        goto L22
    }

    public JSONObject getPlayStopInfo() throws JSONException {
        JSONObject r100 = new JSONObject();
        r100.put("PLAY-SessionID", this.T2);
        r100.put("stallTotalCount", getStallTotalCount());
        r100.put("retryTotalCount", getRetryTotalCount());
        r100.put("firstFrameDownloadSpeed", getFirstFrameDownloadSpeed());
        r100.put("nqeInfo", this.Y5);
        r100.put("domain", this.Oa);
        r100.put("playTime", getPlayTime());
        r100.put("cdnIp", this.f459157t);
        r100.put("errorCode", this.f459095o3);
        r100.put("hasFirstFrame", this.f459009h3);
        r100.put("ipFromPlayerCore", this.f459169u);
        r100.put("downloadSpeed", this.f458968e.Q0);
        if (this.f458980f.getEnableRecordPullStreamQuality() != 1) goto L21;
        r100.put("PullFailRate", !this.f459009h3 ? 1 : 0);
        long r101 = this.M9;
        if (r101 > 0) goto L7;
    L9:
        int r102 = 1;
    L10:
        r100.put("NonInstantStartRate", r102);
        if (getPlayTime() <= 0) goto L13;
        float r103 = (this.f459170u3 * 1.0f) / getPlayTime();
        float r104 = (this.I3 * 1.0f) / getPlayTime();
        float r105 = (this.C8 * 1.0f) / getPlayTime();
    L14:
        float r106 = Math.min(r103, 1.0f);
        float r107 = Math.min(r104, 1.0f);
        float r108 = Math.min(r105, 1.0f);
        r100.put("StallRate", r106);
        r100.put("VideoRenderStallRate", r107);
        r100.put("VideoDecodeStallRate", r108);
        r100.put("Resolution", this.f458980f.mCurrentActualRes);
        r100.put("StreamId", this.f458980f.getStreamId());
        r100.put("ClientTimestamp", System.currentTimeMillis());
        if (this.W3 <= 0) goto L17;
    L20:
        r100.put("PullRenderStall", 1);
        goto L21
    L17:
        if (this.X3 > 0) goto L20;
        if (this.Y3 <= 0) goto L21;
    L13:
        r103 = 0.0f;
        r104 = 0.0f;
        r105 = 0.0f;
        goto L14
    L7:
        if (r101 >= 1000) goto L9;
        r102 = 0;
    L21:
        return r100;
    }

    public long getPlayingDownloadSize() {
        return this.f458968e.f459349t0;
    }

    public String getRedirectUrl() {
        return this.f458968e.R1;
    }

    public int getStallTotalCount() {
        return (int) this.f459158t3;
    }

    public JSONObject getStaticLog() {
        LogBundle r100 = new LogBundle();
        int r101 = 1;
        this.f458980f.getLogInfo(r100, 1);
        String r102 = "none";
        if (this.f458980f.getSRUsed() == true) goto L5;
        String r103 = "0";
    L13:
        String r104 = this.f458980f.getPlayerInternalState();
        JSONObject r105 = this.f458980f.getPushStreamInfo();
        if (r105 == null) goto L16;
        String r106 = r105.optString("push_client_resolution");
        String r107 = r105.optString("push_client_codec_type");
    L76:
        JSONObject r108 = new JSONObject().put("playing_time:", System.currentTimeMillis() - this.f459033j3).put("live_sdk_version:", "1.10.260.2-aweme");     // Catch: JSONException -> L73
        String r109 = this.f459181v;     // Catch: JSONException -> L73
        String r110 = "-1";
        if (r109 != null) goto L21;
        r109 = "-1";
    L21:
        JSONObject r111 = r108.put("player_sdk_version:", r109);     // Catch: JSONException -> L73
        String r112 = this.f459157t;     // Catch: JSONException -> L73
        if (r112 == null) goto L25;
        r110 = r112;
    L25:
        JSONObject r113 = r111.put("cdn_ip:", r110).put("push_client_sdk_version:", this.D).put("push_client_platform:", this.E).put("push_client_model:", this.G).put("push_client_os_version:", this.F).put("push_client_is_hardware_encode:", this.I).put("push_client_push_protocol:", this.N).put("push_client_qid:", this.O).put("push_client_bitrate:", this.f458968e.f459315m1).put("push_client_fps:", this.f458968e.f459320n1);     // Catch: JSONException -> L73
        int r114 = 0;
        if (this.W == false) goto L28;
        int r115 = 1;
    L29:
        JSONObject r116 = r113.put("Hit_Node_Optimizer:", r115).put("Evaluator_Symbol:", this.S);     // Catch: JSONException -> L73
        if (this.X == false) goto L32;
        int r117 = 1;
    L33:
        JSONObject r118 = r116.put("Is_Remote_Sorted:", r117).put("Stall_Total_Count:", this.f459158t3).put("Stall_Total_Time:", this.f459170u3);     // Catch: JSONException -> L73
        long r119 = this.f459146s3;     // Catch: JSONException -> L73
        if (r119 != (-1)) goto L37;
        String r120 = "no stall";
    L40:
        JSONObject r121 = r118.put("Stall_Reason:", r120).put("audio_Render_Stall_Total_Count：", this.J3).put("audio_Render_Stall_Total_Time：", this.K3).put("video_Render_Stall_Total_Count：", this.H3).put("video_Render_Stall_Total_Time：", this.I3);     // Catch: JSONException -> L73
        LogBundle r122 = this.f458968e;     // Catch: JSONException -> L73
        JSONObject r123 = r121.put("first_frame_time:", r122.f459328p - r122.f459253a);     // Catch: JSONException -> L73
        LogBundle r124 = this.f458968e;     // Catch: JSONException -> L73
        JSONObject r125 = r123.put("first_live_frame_time: ", r124.M2 - r124.f459253a).put("video_Buffer_Time:", r100.Y0).put("audio_Buffer_Time:", r100.Z0).put("delay:", this.f458968e.f459280f1).put("render_fps:", r100.P0).put("sei_source:", this.f458968e.f459300j1).put("download_Speed:", r100.Q0).put("Error_Code:", this.f459095o3).put("HardDecode:", this.f459045k0).put("domain:", this.Oa).put("sr_type:", r103).put("push_client_resolution:", r106).put("push_client_codec_type:", r107).put("Codec_Type:", this.Z).put("Codec_Name:", this.f459107p0);     // Catch: JSONException -> L73
        if (this.B4 != 1) goto L44;
        r102 = "PCDN";
    L46:
        JSONObject r126 = r125.put("MDL_Vendor:", r102).put("audio_Buffer_Time_On_First_Frame:", this.f458968e.f459265c1).put("waiting_Time_After_First_Frame:", this.f458968e.f459270d1).put("dns_ip:", this.f458968e.f459365w1);     // Catch: JSONException -> L73
        if (TextUtils.isEmpty(this.f459145s) == false) goto L49;
        String r127 = this.f459133r;     // Catch: JSONException -> L73
    L50:
        JSONObject r128 = r126.put("url:", r127).put("width:", this.I4).put("height:", this.J4).put("resolution:", r100.f459370x1).put("play_format:", this.V2).put("play_protocol:", this.F5).put("settings_res:", this.f458948c6);     // Catch: JSONException -> L73
        if (this.Z5 == true) goto L54;
        r101 = 0;
    L54:
        JSONObject r129 = r128.put("enable_resolution_auto_degrade:", r101);     // Catch: JSONException -> L73
        VideoLiveManager r130 = this.f458980f;     // Catch: JSONException -> L73
        if (r130 != null) goto L57;
        boolean r131 = false;
    L58:
        JSONObject r132 = r129.put("is_use_sr", r131);     // Catch: JSONException -> L73
        VideoLiveManager r133 = this.f458980f;     // Catch: JSONException -> L73
        if (r133 != null) goto L61;
        boolean r134 = false;
    L62:
        JSONObject r135 = r132.put("is_use_sharpen", r134).put("enable_volume_balance", this.M2).put("volume_balance_type", this.N2);     // Catch: JSONException -> L73
        VideoLiveManager r136 = this.f458980f;     // Catch: JSONException -> L73
        if (r136 == null) goto L65;
        int r137 = r136.getIntValueInner(MediaPlayer.MEDIA_PLAYER_OPTION_SAMPLE_RATE, 0);     // Catch: JSONException -> L73
    L66:
        JSONObject r138 = r135.put("samplerate", r137);     // Catch: JSONException -> L73
        VideoLiveManager r139 = this.f458980f;     // Catch: JSONException -> L73
        if (r139 == null) goto L69;
        r114 = r139.getIntValueInner(MediaPlayer.MEDIA_PLAYER_OPTION_CHANNELS, 0);     // Catch: JSONException -> L73
    L69:
        JSONObject r140 = r138.put("channels", r114).put("sei_bitrate", this.f458968e.f459315m1).put("player_state:", r104).put("enable_fast_first_frame", this.T5).put("rtc_play_fallback", this.A7).put("fallback_type", this.L7).put("liveio_play", this.H9).put("request_cdn_cached", this.f458968e.f459324o0).put("used_drm", this.f459078ma);     // Catch: JSONException -> L73
        if (TextUtils.equals(this.G5, "quicu") == false) goto L72;
        r140.put("audio_quicu_frame_drop_time:", this.W8).put("video_quicu_frame_drop_time:", this.Y8).put("audio_quicu_frame_drop_count:", this.V8).put("video_quicu_frame_drop_count:", this.X8);     // Catch: JSONException -> L73
    L72:
        return r140;
    L65:
        r137 = 0;
        goto L66
    L61:
        r134 = r133.getSharpenState();     // Catch: JSONException -> L73
        goto L62
    L57:
        r131 = r130.getSRState();     // Catch: JSONException -> L73
        goto L58
    L49:
        r127 = this.f459145s;     // Catch: JSONException -> L73
        goto L50
    L44:
        if (this.f459237z4 != 1) goto L46;
        r102 = "Http-CDN";
        goto L46
    L37:
        if (r119 != 0) goto L39;
        r120 = "network stall";
        goto L40
    L39:
        r120 = "decode stall";
        goto L40
    L32:
        r117 = 0;
        goto L33
    L28:
        r115 = 0;
    L73:
        e = move-exception;
        e.printStackTrace();
        return null;
    L16:
        r107 = "none";
        r106 = r107;
        goto L76
    L5:
        if (this.f458980f.getSRAlType() != 0) goto L8;
        r103 = "2x";
    L11:
        this.f459238z5 = true;
        goto L13
    L8:
        if (this.f458980f.getSRAlType() != 4) goto L10;
        r103 = "1.5x";
        goto L11
    L10:
        r103 = "none";
        goto L11
    }

    public String getStreamType() {
        int r100 = this.f458968e.A2;
        if (r100 != (-1)) goto L5;
        return "no stream";
    L5:
        if (r100 != 0) goto L8;
        return "video stream";
    L8:
        if (r100 != 1) goto L11;
        return "audio stream";
    L11:
        if (r100 != 2) goto L13;
        return "both stream";
    L13:
        return "none";
    }

    public int getTotalCost() {
        LogBundle r100 = this.f458968e;
        return (int) (r100.f459328p - r100.f459253a);
    }

    public boolean isRtcPlayAvailable() {
        VideoLiveManager r100 = this.f458980f;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.isRtcPlayAvailable();
    }

    public boolean isRtmSessionStopEnable() {
        VideoLiveManager r100 = this.f458980f;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.isRtmSessionStopEnable();
    }

    public boolean isRtmv3() {
        VideoLiveManager r100 = this.f458980f;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.isRtmv3();
    }

    public void onAbrSwitchEnd() {
        if (this.f459131qc.compareAndSet(true, false) == false) goto L6;
        this.f459104oc = 0;
        this.f459119pc = 0;
        return;
    }

    public void onAbrSwitchStart() {
        if (this.f459131qc.compareAndSet(false, true) == false) goto L6;
        this.f459104oc = 0;
        this.f459119pc = System.currentTimeMillis();
        return;
    }

    public void onCallPreload() {
        LogBundle r100 = this.f458968e;
        if (r100 == null) goto L6;
        r100.f459366w2 = System.currentTimeMillis();
        return;
    }

    public void onCallPrepare() {
        if (this.f459009h3 == false) goto L5;
        return;
    L5:
        LogBundle r100 = this.f458968e;
        r100.f459263c = System.currentTimeMillis();
        LogBundle r101 = this.f459026i8;
        if (r101 == null) goto L9;
        r101.f459263c = System.currentTimeMillis();
        return;
    }

    public void onFirstLiveFrame() {
        VideoLiveManager r100 = this.f458980f;
        if (r100 == null) goto L30;
        LogBundle r101 = this.f458968e;
        if (r101 == null) goto L33;
        int r102 = 1;
        this.Za = 1;
        r100.getLogInfo(r101, 10);
        JSONObject r103 = createCommonLog();
        if (r103 == null) goto L31;
        JSONObject r104 = r103.put(LiveCommonConstants.LOG_PARAM_EVENT_KEY, "first_frame_live");     // Catch: Exception -> L25
        if (this.f459009h3 == false) goto L12;
        int r105 = 1;
    L13:
        JSONObject r106 = r104.put("is_stream_received", r105).put("is_stream_received_live", this.Za).put("audio_live_open", this.f458968e.G2).put("video_live_open", this.f458968e.H2).put("audio_live_connect_end", this.f458968e.I2).put("video_live_connect_end", this.f458968e.J2).put("first_live_audio_packet_end", this.f458968e.K2).put("first_live_video_packet_end", this.f458968e.L2);     // Catch: Exception -> L25
        this.f458968e.getClass();     // Catch: Exception -> L25
        JSONObject r107 = r106.put("first_live_audio_frame_render_end", 0).put("first_live_video_frame_render_end", this.f458968e.M2).put("enable_preload", this.Ta);     // Catch: Exception -> L25
        if (this.Va != 1) goto L16;
        int r108 = 1;
    L17:
        JSONObject r109 = r107.put("audioHttpxRequestCached", r108);     // Catch: Exception -> L25
        if (this.Wa == 1) goto L21;
        r102 = 0;
    L21:
        JSONObject r110 = r109.put("videoHttpxRequestCached", r102).put("audioCachedNum", this.f458968e.N2).put("videoCachedNum", this.f458968e.O2).put("preload_init_error", this.Ua).put("preload_result", this.Xa).put("preload_resolution", this.f458953cb).put("play_use_preload_resolution", this.f458965db).put("preload_visit_timedelta", this.Ya).put("start", this.f458968e.f459253a).put("sdk_dns_analysis_end", this.f458968e.f459258b).put("http_req_finish_time", this.f458968e.f459309l0).put("http_res_finish_time", this.f458968e.f459314m0).put("first_video_package_end", this.f458968e.f459308l).put("first_audio_package_end", this.f458968e.f459313m).put("first_video_frame_decode_end", this.f458968e.f459318n).put("first_audio_frame_decode_end", this.f458968e.f459323o).put("first_frame_from_player_core", this.f458968e.f459338r).put("first_frame_render_end", this.f458968e.f459328p).put("video_param_send_outlet_time", this.f458968e.f459330p1).put("first_video_frame_send_outlet_time", this.f458968e.f459335q1).put("video_first_pkt_pts", this.f458968e.f459284g0).put("audio_first_pkt_pts", this.f458968e.f459294i0).put("video_buffer_time", this.f458968e.Y0).put("audio_buffer_time", this.f458968e.Z0).put("download_speed", this.f458968e.Q0).put("suggest_format", this.E5).put("suggest_protocol", this.G5);     // Catch: Exception -> L25
        LogBundle r111 = this.f458968e;     // Catch: Exception -> L25
        JSONObject r112 = r110.put("first_live_frame_time", r111.M2 - r111.f459253a).put("cache_hit", this.f458925ab).put("preload_task_state", this.f458940bb).put("cache_open_start_time", this.f458968e.V2).put("cache_open_end_time", this.f458968e.W2).put("cache_read_eof_time", this.f458968e.X2).put("live_open_start_time", this.f458968e.Y2).put("live_open_end_time", this.f458968e.Z2).put("live_read_first_pkt_time", this.f458968e.f459257a3);     // Catch: Exception -> L25
        LogBundle r113 = this.f458968e;     // Catch: Exception -> L25
        JSONObject r114 = r112.put("cache_open_cost", r113.W2 - r113.V2);     // Catch: Exception -> L25
        LogBundle r115 = this.f458968e;     // Catch: Exception -> L25
        JSONObject r116 = r114.put("cache_consume_cost", r115.X2 - r115.V2);     // Catch: Exception -> L25
        LogBundle r117 = this.f458968e;     // Catch: Exception -> L25
        JSONObject r118 = r116.put("live_open_cost", r117.Z2 - r117.Y2);     // Catch: Exception -> L25
        LogBundle r119 = this.f458968e;     // Catch: Exception -> L25
        JSONObject r120 = r118.put("cache_live_hole", r119.Z2 - r119.X2);     // Catch: Exception -> L25
        LogBundle r121 = this.f458968e;     // Catch: Exception -> L25
        JSONObject r122 = r120.put("cache_live_read_diff", r121.f459257a3 - r121.X2);     // Catch: Exception -> L25
        LogBundle r123 = this.f458968e;     // Catch: Exception -> L25
        r122.put("cache_live_render_diff", r123.M2 - r123.f459328p).put("buffer_stall_time", this.f459170u3).put("buffer_stall_count", this.f459158t3).put("video_decode_stall_time", this.C8).put("video_decode_stall_count", this.B8).put("audio_decode_stall_time", this.E8).put("audio_decode_stall_count", this.D8).put("video_render_stall_time", this.I3).put("video_render_stall_count", this.H3).put("audio_render_stall_time", this.K3).put("audio_render_stall_count", this.J3);     // Catch: Exception -> L25
        onEventLog(r103, "live_client_monitor_log");     // Catch: Exception -> L25
        long r124 = this.f459083n3;     // Catch: Exception -> L25
        if (r124 <= 0) goto L32;
        this.f459083n3 = r124 + 1;     // Catch: Exception -> L25
        return;
    L32:
        return;
    L16:
        r108 = 0;
        goto L17
    L12:
        r105 = 0;
    L25:
        e = move-exception;
        e.printStackTrace();
        return;
    L31:
        return;
    L33:
        return;
    }

    public void onPrepareEnd() {
        LogBundle r100 = this.f459026i8;
        if (r100 == null) goto L6;
        r100.f459343s = System.currentTimeMillis();
    L6:
        if (this.f459009h3 == false) goto L8;
        return;
    L8:
        LogBundle r101 = this.f458968e;
        r101.f459343s = System.currentTimeMillis();
    }

    public void onPullStart() {
        if (this.f458980f != null) goto L15;
        return;
    L15:
        JSONObject r100 = createCommonLog();     // Catch: JSONException -> L12
        if (r100 != null) goto L8;
        return;
    L8:
        r100.put(LiveCommonConstants.LOG_PARAM_EVENT_KEY, "pull_restart").put(MiniAppConstants.KEY_MINI_APP_STREAM_DATA, this.f459212x5).put("cmd", this.Gc).put("mode", this.Hc);     // Catch: JSONException -> L12
        onEventLog(r100, "live_client_monitor_log");     // Catch: JSONException -> L12
        long r101 = this.f459083n3;     // Catch: JSONException -> L12
        if (r101 <= 0) goto L17;
        this.f459083n3 = r101 + 1;     // Catch: JSONException -> L12
        return;
    L17:
        return;
    L12:
        e = move-exception;
        e.printStackTrace();
    }

    public void onSessionFirstFrame() {
        LogBundle r100 = this.f459026i8;
        if (r100 == null) goto L6;
        r100.f459290h1 = this.f458968e.f459280f1;
        return;
    }

    public void onSessionStop() {
        if (this.f459014h8 != 0) goto L5;
        return;
    L5:
        if (this.f459026i8 != null) goto L8;
        return;
    L8:
        if (this.f459081md != 1) goto L10;
        this.f458944c.removeMessages(101);
    L10:
        this.f458980f.getSessionlogInfo(this.f459026i8);
        if (this.f459081md == 1) goto L13;
        JSONObject r100 = createCommonLog();
    L14:
        JSONObject r101 = r100;
        if (this.f459009h3 == true) goto L17;
    L19:
        boolean r102 = false;
    L21:
        if (this.f459038j8 == true) goto L24;
        reportSessionFirstFrame(r101, 0, 0);
    L24:
        if (this.f459038j8 == false) goto L26;
        long r103 = System.currentTimeMillis() - this.f459064l8;
        computeDisplayTime();
        this.Pd += r103;
        long r110 = r103;
        long r104 = 0;
    L28:
        if (this.f459038j8 == true) goto L30;
        long r111 = 0;
    L34:
        this.f459115p8++;
        long r105 = this.f459201w8;
        if (r105 <= 0) goto L37;
        long r106 = r105 - this.f459064l8;
        long r107 = this.f459215x8 - r105;
    L39:
        if (isStalling() == false) goto L44;
        this.f459127q8++;
        long r210 = r111;
        if (this.f459122q3 < this.f459052k8) goto L43;
        this.f459139r8 += System.currentTimeMillis() - this.f459122q3;
    L45:
        calculateSessionRenderFailType();
        if (this.W2.equals(OnekeyLoginConstants.NETWORK_TYPE_MOBILE_STR) == false) goto L50;
        if (this.f458968e.f459282f3 != (-1)) goto L50;
    L51:
        this.f458917a3 += this.f459026i8.f459349t0;
        this.f458932b3 += r110;
    L52:
        LogBundle r108 = this.f459026i8;
        long r109 = r108.f459349t0;
        long r112 = r108.f459354u0;
        long r211 = r109;
        if (this.f459206wd != 1) goto L60;
        long r113 = this.G6;
        if (r113 == 0) goto L57;
        r211 = r113;
    L57:
        long r114 = this.H6;
        if (r114 == 0) goto L60;
        r112 = r114;
    L60:
        long r115 = r211;
        if (r101 != 0) goto L190;
    L186:
        resetSessionInfo();
        return;
    L190:
        long r212 = r112;
        JSONObject r116 = r101.put(LiveCommonConstants.LOG_PARAM_EVENT_KEY, "session_stop").put("index", this.f459115p8).put("socket_err_code", this.f458968e.I1).put("socket_err_type", this.f458968e.H1).put(ILoadStallMonitor.STOP_TIME, System.currentTimeMillis()).put(HistoryTableOperate.HISTORY_PLAY_TIME, r110);     // Catch: JSONException -> L184
        if (this.f459038j8 == false) goto L65;
        int r117 = 1;
    L66:
        JSONObject r118 = r116.put("is_stream_received", r117).put("render_fail_type", this.f459229y8).put("code", this.f459241z8).put("stall_count", this.f459127q8).put("stall_time", this.f459139r8).put("audio_render_stall_count", this.f459175u8).put("audio_render_stall_time", this.f459189v8).put("video_render_stall_count", this.f459151s8).put("video_render_stall_time", this.f459163t8).put("start", this.f459052k8).put("sdk_dns_analysis_end", this.f459026i8.f459258b).put("player_dns_analysis_end", this.f458968e.f459268d).put("http_req_finish_time", this.f459026i8.f459309l0).put("http_res_finish_time", this.f459026i8.f459314m0).put("tcp_first_package_end", this.f458968e.f459303k).put("first_video_package_end", this.f459026i8.f459308l).put("first_audio_package_end", this.f459026i8.f459313m).put("first_video_frame_decode_end", this.f459026i8.f459318n).put("first_audio_frame_decode_end", this.f459026i8.f459323o).put("video_device_open_start", this.f459026i8.f459348t).put("video_device_open_end", this.f459026i8.f459353u).put("audio_device_open_start", this.f459026i8.f459358v).put("audio_device_open_end", this.f459026i8.f459363w).put("video_device_wait_start", this.f459026i8.f459355u1).put("video_device_wait_end", this.f459026i8.f459360v1).put("find_stream_info_start", this.f459026i8.f459345s1).put("find_stream_info_end", this.f459026i8.f459350t1).put("video_param_send_outlet_time", this.f459026i8.f459330p1).put("first_video_frame_send_outlet_time", this.f459026i8.f459335q1).put("first_frame_render_end", this.f459064l8).put("first_audio_frame_end", this.f459088n8).put("prepare_end", this.f459026i8.f459343s).put("prepare_block_end", this.f459026i8.f459263c).put("video_first_pkt_pos", this.f459026i8.f459279f0).put("video_first_pkt_pts", this.f459026i8.f459284g0).put("audio_first_pkt_pos", this.f459026i8.f459289h0).put("audio_first_pkt_pts", this.f459026i8.f459294i0).put("video_render_type", this.f459026i8.f459340r1).put("download_speed", this.f459026i8.f459255a1).put("video_buffer_time", this.f459026i8.f459260b1).put("audio_buffer_time", this.f459026i8.f459265c1);     // Catch: JSONException -> L184
        if (this.f459026i8.f459270d1 <= 0) goto L69;
        long r119 = this.f458968e.f459270d1;     // Catch: JSONException -> L184
    L70:
        JSONObject r120 = r118.put("wait_time", r119);     // Catch: JSONException -> L184
        if (this.f459026i8.f459270d1 < 0) goto L73;
        int r121 = 0;
    L74:
        JSONObject r122 = r120.put("is_waiting", r121).put("first_stall_time", r106).put("first_stall_duration", r107).put("play_time_on_no_frame", r104).put("total_download_size", r115).put("drop_audio_pts_diff", this.f459026i8.f459299j0).put("drop_audio_cost", this.f459026i8.f459304k0);     // Catch: JSONException -> L184
        if (this.f458980f.isSrDirectDrawUsed() == false) goto L77;
        int r123 = 1;
    L78:
        JSONObject r124 = r122.put("sr_direct_draw_used", r123);     // Catch: JSONException -> L184
        if (this.f458980f.isSharpenDirectDrawUsed() == false) goto L81;
        int r125 = 1;
    L82:
        JSONObject r126 = r124.put("sharpen_direct_draw_used", r125).put(IVideoEventLogger.FEATURE_KEY_NETWORK_TIMEOUT, this.S6).put("suggest_format", this.E5).put("suggest_protocol", this.G5).put("suggest_access_code", this.L5).put("first_sei_delay", this.f459026i8.f459290h1).put("room_play_time_ms", r210).put("error_msg", this.A8).put("play_size", r212);     // Catch: JSONException -> L184
        if (this.H9 <= 0) goto L85;
        long r127 = this.f459026i8.f459359v0;     // Catch: JSONException -> L184
    L86:
        JSONObject r128 = r126.put("http_flow_size", r127);     // Catch: JSONException -> L184
        if (this.H9 <= 0) goto L89;
        long r129 = this.f459026i8.f459364w0;     // Catch: JSONException -> L184
    L90:
        JSONObject r130 = r128.put("p2p_flow_size", r129);     // Catch: JSONException -> L184
        if (this.H9 <= 0) goto L93;
        long r131 = this.f459026i8.f459374y0;     // Catch: JSONException -> L184
    L94:
        JSONObject r132 = r130.put("p2p_mobile_flow_size", r131).put("httpio_play_time", this.f459026i8.f459379z0).put("p2pio_play_time", this.f459026i8.A0).put("multipath_cellular_flow_size", this.f459026i8.E0).put("multipath_running_status", this.f459026i8.D0).put("switch_cellular_reason", this.f459026i8.f459277e3).put("switch_cellular_detail", this.f459026i8.f459287g3).put("switch_cellular_result", this.f459026i8.f459297i3).put("switch_default_reason", this.f459026i8.f459282f3).put("switch_default_detail", this.f459026i8.f459292h3).put("switch_default_result", this.f459026i8.f459302j3).put("cellular_total_download_size", this.f458917a3).put("cellular_play_time", this.f458932b3).put("event_key_index", f458911he.incrementAndGet());     // Catch: JSONException -> L184
        if (r102 == false) goto L97;
        int r133 = 1;
    L98:
        JSONObject r134 = r132.put("is_first_play", r133).put("p2p_flv_detail", this.Oc).put("svc_play", this.Ic);     // Catch: JSONException -> L184
        if (this.H9 <= 0) goto L101;
        long r135 = this.f459026i8.F0;     // Catch: JSONException -> L184
    L102:
        JSONObject r136 = r134.put("http_patch_dts_size", r135);     // Catch: JSONException -> L184
        if (this.H9 <= 0) goto L105;
        long r137 = this.f459026i8.G0;     // Catch: JSONException -> L184
    L106:
        r136.put("http_substream_size", r137);     // Catch: JSONException -> L184
        addViewResolutionInfo(r101);     // Catch: JSONException -> L184
        addBmfSrInfo(r101);     // Catch: JSONException -> L184
        addBmfSharpenInfo(r101);     // Catch: JSONException -> L184
        addAesBoostInfo(r101);     // Catch: JSONException -> L184
        addSDR2HDRInfo(r101);     // Catch: JSONException -> L184
        addDisplayModelInfo(r101);     // Catch: JSONException -> L184
        if (this.Bd != 1) goto L114;
        if (((ArrayList) this.f459234yd).size() >= 20) goto L111;
        addSegementRequest(r101);     // Catch: JSONException -> L184
    L111:
        r101.put("segement_count", ((ArrayList) this.f459234yd).size());     // Catch: JSONException -> L184
    L114:
        if (this.f459133r != null) goto L117;
        r101.put("tcp_connect_end", this.f459026i8.f459278f);     // Catch: JSONException -> L184
    L121:
        addStreamVersion(r101);     // Catch: JSONException -> L184
        if (isRtcPlayAvailable() == false) goto L125;
        fixRtmSessionStopInfo(r101);     // Catch: JSONException -> L184
    L125:
        if (this.f459043jd != 1) goto L144;
        if (this.f459169u == false) goto L129;
        int r138 = 1;
    L130:
        JSONObject r139 = r101.put("ip_from_player_core", r138);     // Catch: JSONException -> L184
        if (this.R == false) goto L133;
        int r140 = 1;
    L134:
        JSONObject r141 = r139.put("open_dns_optimizer", r140);     // Catch: JSONException -> L184
        if (this.W == false) goto L137;
        int r142 = 1;
    L138:
        JSONObject r143 = r141.put("hit_node_optimize", r142).put("evaluator_symbol", this.S).put("lss_response_cost", this.T).put("lss_first_response_cost", this.U).put("lss_response_status_code", this.V);     // Catch: JSONException -> L184
        if (this.X == false) goto L141;
        int r144 = 1;
    L142:
        r143.put("remote_sorted", r144);     // Catch: JSONException -> L184
        goto L144
    L141:
        r144 = 0;
        goto L142
    L137:
        r142 = 0;
        goto L138
    L133:
        r140 = 0;
        goto L134
    L129:
        r138 = 0;
    L144:
        if (this.f459120pd == 1) goto L149;
        Object r145 = this.A;     // Catch: JSONException -> L184
        if (r145 != null) goto L148;
        r145 = "none";
    L148:
        r101.put(OrderParamsKey.KEY_SDK_PARAM, r145);     // Catch: JSONException -> L184
    L149:
        String r146 = this.f458968e.S1;     // Catch: JSONException -> L184
        if (TextUtils.isEmpty(r146) == true) goto L160;
        r101.put("liveio_metrics", r146);     // Catch: JSONException -> L184
        JSONObject r147 = new JSONObject(r146);     // Catch: JSONException -> L157
        Iterator<String> r148 = r147.keys();     // Catch: JSONException -> L157
    L154:
        if (r148.hasNext() == false) goto L160;
        String r149 = r148.next();     // Catch: JSONException -> L157
        r101.put(r149, r147.get(r149));     // Catch: JSONException -> L157
    L157:
        e = move-exception;
        e.printStackTrace();     // Catch: JSONException -> L184
    L160:
        if (TextUtils.isEmpty(this.X7) == false) goto L162;
    L174:
        this.f459083n3++;     // Catch: JSONException -> L184
        onEventLog(r101, "live_client_monitor_log");     // Catch: JSONException -> L184
        this.f459193vc++;     // Catch: JSONException -> L184
        if (this.f459167tc <= 0) goto L186;
        if (this.f459143rc.size() >= this.f459155sc) goto L179;
    L180:
        JSONObject r150 = getSessionStopStr(r101);     // Catch: JSONException -> L184
        if (r150 == null) goto L186;
        this.f459143rc.add(r150);     // Catch: JSONException -> L184
        goto L186
    L179:
        if (this.f459179uc == false) goto L186;
    L162:
        if (this.X7.startsWith("webrtc") == false) goto L164;
    L169:
        boolean r151 = true;
    L170:
        if (r151 == false) goto L174;
        if (TextUtils.equals(this.V2, "lls") == true) goto L174;
        r101.put("play_format", "lls");     // Catch: JSONException -> L184
        goto L174
    L164:
        if (this.X7.startsWith("http") == true) goto L166;
    L168:
        r151 = false;
        goto L170
    L166:
        if (this.X7.contains(".sdp") == false) goto L168;
    L117:
        if ("kcp".equals(this.F5) == false) goto L119;
        long r152 = this.f459026i8.f459268d;     // Catch: JSONException -> L184
    L120:
        r101.put("tcp_connect_end", r152);     // Catch: JSONException -> L184
        goto L121
    L119:
        r152 = this.f459026i8.f459278f;     // Catch: JSONException -> L184
        goto L120
    L105:
        r137 = 0;
        goto L106
    L101:
        r135 = 0;
        goto L102
    L97:
        r133 = 0;
        goto L98
    L93:
        r131 = 0;
        goto L94
    L89:
        r129 = 0;
        goto L90
    L85:
        r127 = 0;
        goto L86
    L81:
        r125 = 0;
        goto L82
    L77:
        r123 = 0;
        goto L78
    L73:
        r121 = 1;
        goto L74
    L69:
        r119 = -this.f458968e.f459270d1;
        goto L70
    L65:
        r117 = 0;
    L184:
        e = move-exception;
        e.printStackTrace();
    L50:
        if (this.f458968e.f459277e3 == (-1)) goto L52;
    L43:
        this.f459139r8 += System.currentTimeMillis() - this.f459052k8;
        goto L45
    L44:
        r210 = r111;
        goto L45
    L37:
        r106 = 0;
        r107 = 0;
        goto L39
    L30:
        if (this.f458954cc == false) goto L32;
        r111 = this.f458978ec + (System.currentTimeMillis() - this.f458941bc);
        goto L34
    L32:
        r111 = this.f458978ec;
        goto L34
    L26:
        r104 = System.currentTimeMillis() - this.f459052k8;
        r110 = 0;
        goto L28
    L17:
        if (this.f459021i3 == true) goto L19;
        String r153 = this.R2;
        this.S2 = r153;
        this.f459059l3 = r153;
        this.f459021i3 = true;
        r102 = true;
        goto L21
    L13:
        r100 = createCommonLog_v2();
        goto L14
    }

    public void onSilenceStart() {
        this.f458977eb++;
        if (this.f459003gb != null) goto L5;
        this.f459003gb = new JSONObject();
    L5:
        this.f458989fb = System.currentTimeMillis();
        c.d("LiveLoggerService", "silence start: " + this.f458989fb);
    }

    public void resetRtmSessionBundle() {
        this.f459200w7.reset();
        this.f459214x7 = 0;
    }

    public void resetStreamCheckParams() {
        LinkedBlockingQueue<Long> r100 = this.f458961d7;
        if (r100 == null) goto L5;
        r100.clear();
        this.f458961d7 = null;
    L5:
        int r101 = this.f459063l7;
        if (r101 == (-1)) goto L10;
        int r102 = this.f459075m7;
        if (r102 == (-1)) goto L10;
        this.f459013h7 += (r102 - r101) + 1;
        this.f459063l7 = -1;
        this.f459075m7 = -1;
    L10:
        this.f458973e7 = -1;
        this.f458985f7 = -1;
        this.f458999g7 = -1;
    }

    public void resetVideoProcessInfo() {
        LogBundle.VideoProcessConfigChannel r100 = LogBundle.VideoProcessConfigChannel.ChannelVPASS;
        logSrConfigType(r100, -1, -1, -1, null);
        logSharpenConfigType(r100, -1, -1, null);
        logAesBoostConfigType(r100, -1, null);
    }

    public void setSDKDNSCompleteTimeOnPreprepared() {
        LogBundle r100 = this.f458968e;
        r100.f459258b = System.currentTimeMillis();
        LogBundle r101 = this.f459026i8;
        if (r101 == null) goto L5;
        r101.f459258b = System.currentTimeMillis();
    L5:
        LogBundle r102 = this.f459200w7;
        r102.f459258b = System.currentTimeMillis();
    }

    public void start() {
        if (this.f459006h == false) goto L5;
        return;
    L5:
        long r100 = this.f458992g;
        if (this.f459081md != 1) goto L8;
    L10:
        this.f458944c.sendEmptyMessageDelayed(101, r100);
        if (this.f459112p5 == false) goto L14;
        this.f458944c.sendEmptyMessageDelayed(102, 5000);
    L14:
        if (this.f459211x4 == 1) goto L16;
    L20:
        this.f459006h = true;
        return;
    L16:
        if (this.f459171u4 == true) goto L20;
        a r101 = this.f459123q4;
        if (r101 == null) goto L20;
        r101.sendEmptyMessageDelayed(103, 0);
        this.f459171u4 = true;
        goto L20
    L8:
        if (isRtcPlayAvailable() == false) goto L10;
        r100 = this.f459040ja;
        goto L10
    }

    public void startPlayingReport() {
        long r100 = this.f458992g;
        if (this.f459081md != 1) goto L5;
    L7:
        this.f458944c.sendEmptyMessageDelayed(101, r100);
        return;
    L5:
        if (isRtcPlayAvailable() == false) goto L7;
        r100 = this.f459040ja;
        goto L7
    }

    private JSONObject _createSessionTimeSeries() {
        updateSessionSeries();
        JSONObject r100 = new JSONObject().put(ILoadStallMonitor.START_TIME, this.f458968e.f459253a).put("duration", System.currentTimeMillis() - this.f458968e.f459253a).put("render_fps_series", new JSONArray(this.Q4)).put("download_bitrate_series", new JSONArray(this.R4)).put("play_buffer_series", new JSONArray(this.S4)).put("speed_switch_series", this.f459183v2).put("video_stall_series", this.X4).put("audio_stall_series", this.W4);     // Catch: JSONException -> L28
        if (this.Z4 != null) goto L6;
        JSONArray r101 = new JSONArray();     // Catch: JSONException -> L28
    L7:
        JSONObject r102 = r100.put("push_bitrate_series", r101);     // Catch: JSONException -> L28
        if (this.f458919a5 != null) goto L10;
        JSONArray r103 = new JSONArray();     // Catch: JSONException -> L28
    L11:
        JSONObject r104 = r102.put("push_fps_series", r103);     // Catch: JSONException -> L28
        if (this.T4 != null) goto L14;
        JSONArray r105 = new JSONArray();     // Catch: JSONException -> L28
    L15:
        JSONObject r106 = r104.put("stall_series", r105);     // Catch: JSONException -> L28
        if (this.U4 != null) goto L18;
        JSONArray r107 = new JSONArray();     // Catch: JSONException -> L28
    L19:
        JSONObject r108 = r106.put("stall_buffer_series", r107);     // Catch: JSONException -> L28
        JSONObject r109 = this.Y4;     // Catch: JSONException -> L28
        if (r109 != null) goto L22;
        r109 = new JSONObject();     // Catch: JSONException -> L28
    L22:
        JSONObject r110 = r108.put("error_series", r109);     // Catch: JSONException -> L28
        if (this.f458934b5 != null) goto L25;
        JSONArray r111 = new JSONArray();     // Catch: JSONException -> L28
    L26:
        return r110.put("push_stall_series", r111).put("push_video_stall_series", this.f458959d5).put("push_audio_stall_series", this.f458947c5).put("quicu_audio_drop_series", this.f458971e5).put("quicu_video_drop_series", this.f458983f5);
    L25:
        r111 = new JSONArray(this.f458934b5);     // Catch: JSONException -> L28
        goto L26
    L18:
        r107 = new JSONArray(this.U4);     // Catch: JSONException -> L28
        goto L19
    L14:
        r105 = new JSONArray(this.T4);     // Catch: JSONException -> L28
        goto L15
    L10:
        r103 = new JSONArray(this.f458919a5);     // Catch: JSONException -> L28
        goto L11
    L6:
        r101 = new JSONArray(this.Z4);     // Catch: JSONException -> L28
    L28:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    private void reportUpdateSessionSeries() {
        updateSessionSeries();
        c.i("zdh", "update session series");
        if (this.f459006h == false) goto L6;
        this.f458944c.sendEmptyMessageDelayed(102, 5000);
        return;
    }

    public JSONObject createCommonLog_v2() {
        JSONObject r100 = createNecessaryCommonLog();
        JSONObject r101 = createUnimportantCommonLog();     // Catch: JSONException -> L8
        Iterator<String> r102 = r101.keys();     // Catch: JSONException -> L8
    L5:
        if (r102.hasNext() == false) goto L10;
        String r103 = r102.next();     // Catch: JSONException -> L8
        r100.put(r103, r101.opt(r103));     // Catch: JSONException -> L8
    L10:
        return r100;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    }

    public long getPlayTime() {
        return System.currentTimeMillis() - this.f459033j3;
    }

    public void getRtmPlayerStopInfo() {
        if (isRtcPlayAvailable() == true) goto L5;
        return;
    L5:
        if (isRtmv3() == false) goto L8;
        return;
    L8:
        if (this.F7 == true) goto L12;
        c.w("[RTM_PLAY]", "no need to getRtmPlayerStopInfo");
        return;
    L12:
        if (TextUtils.equals("none", this.P7) == false) goto L14;
    L15:
        String r100 = this.f458980f.getRtcStopInfo();
        if (TextUtils.isEmpty(r100) == true) goto L21;
        onRecvedRtcTraceInfo(r100);
        return;
    L21:
        return;
    L14:
        if (TextUtils.isEmpty(this.P7) == true) goto L15;
    }

    public void onMaybeRTMSessionFirstFrame() {
        if (isRtcPlayAvailable() == true) goto L5;
        return;
    L5:
        LogBundle r100 = this.f459200w7;
        if (r100.f459328p != 0) goto L9;
        r100.f459328p = System.currentTimeMillis();
        return;
    }

    public void onMaybeRTMSessionStart() {
        if (isRtcPlayAvailable() == true) goto L5;
        return;
    L5:
        LogBundle r100 = this.f459200w7;
        r100.f459291h2 = System.currentTimeMillis();
    }

    public void onProtocolDowngrade() {
        onProtocolDowngrade(EventConstant.Value.RETRY);
    }

    public void onStopWhenPrepared() {
        JSONObject r100 = createNecessaryCommonLog();
        if (r100 == null) goto L11;
        r100.put(LiveCommonConstants.LOG_PARAM_EVENT_KEY, "stop_when_prepared").put("liveio_prepare", this.f458980f.mForbidLiveIOPrepareWhenPreparing).put("httpio_prepare", this.f458980f.mForbidHttpIOPrepareWhenPreparing);     // Catch: JSONException -> L6
        onEventLog(r100, "live_client_monitor_log");     // Catch: JSONException -> L6
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public String getCdnPlayUrl() {
        return this.f459133r;
    }

    public boolean getHitNodeOptimizer() {
        return this.W;
    }

    public int getRetryTotalCount() {
        return this.f458933b4;
    }

    public boolean isInErrorRecovering() {
        return this.f459022i4;
    }

    public boolean isPreview() {
        return this.f459195w;
    }

    public boolean isStalling() {
        return this.L3;
    }

    public void onStop(String r410) {
        String r110 = "quicu";
        if (this.f459086n6 <= 0) goto L6;
        this.f459149s6 = this.f459036j6;
        this.f459161t6 = this.f459125q6;
        onAbrSessionStop(true);
    L6:
        if (this.f459009h3 == false) goto L21;
        VideoLiveManager r100 = this.f458980f;
        if (r100 == null) goto L11;
        r100.updateStopSize(this.f458968e);
    L11:
        if (isRtcPlayAvailable() == true) goto L13;
    L20:
        report(true, this.f459080mc, this.f459056kc, this.f459068lc, this.f459092nc, 0);
        boolean r101 = true;
    L22:
        this.f459179uc = r101;
        VideoLiveManager r102 = this.f458980f;
        if (r102 == null) goto L28;
        if (r102.needReportPlayStopEvent() == true) goto L28;
        return;
    L28:
        if (this.f459081md == r101) goto L30;
        JSONObject r103 = createCommonLog();
    L32:
        if (this.f459093nd == r101) goto L35;
        onSessionStop();
    L42:
        if (r103 == null) goto L495;
    L53:
        e = move-exception;
        e.printStackTrace();
        return;
    L44:
        if (this.f459009h3 == false) goto L56;
        long r104 = System.currentTimeMillis() - this.f459033j3;     // Catch: JSONException -> L53
        if (isPreview() == false) goto L48;
        long r105 = System.currentTimeMillis();     // Catch: JSONException -> L53
        long r111 = this.E9;     // Catch: JSONException -> L53
    L49:
        long r106 = r105 - r111;     // Catch: JSONException -> L53
        long r112 = this.Pd;     // Catch: JSONException -> L53
        if (r104 <= r112) goto L52;
        this.Md = r104 - r112;     // Catch: JSONException -> L53
    L52:
        long r210 = 0;
        long r113 = r106;
        long r107 = r104;
        long r108 = 0;
    L66:
        if (this.f459009h3 == true) goto L68;
        long r109 = 0;
    L72:
        long r114 = this.S3;     // Catch: JSONException -> L53
        if (r114 <= 0) goto L75;
        long r115 = r114 - this.f458968e.f459328p;     // Catch: JSONException -> L53
        long r116 = this.T3 - r114;     // Catch: JSONException -> L53
        long r117 = r115;
    L77:
        if (isStalling() == false) goto L82;
        long r211 = r109;
        this.f459158t3++;     // Catch: JSONException -> L53
        long r212 = r108;
        this.f459170u3 += System.currentTimeMillis() - this.f459122q3;     // Catch: JSONException -> L53
        if (isPreview() == false) goto L84;
        this.f459196w3++;     // Catch: JSONException -> L53
        this.f459184v3 += System.currentTimeMillis() - this.f459122q3;     // Catch: JSONException -> L53
    L84:
        if (isInErrorRecovering() == true) goto L86;
    L88:
        calculateRenderFailType();     // Catch: JSONException -> L53
        VideoLiveManager r118 = this.f458980f;     // Catch: JSONException -> L53
        if (r118.mEnableOpenStrategyEngine == 1) goto L92;
    L96:
        int r119 = -1;
    L97:
        String r120 = this.f458980f.getUnSyncInfo();     // Catch: JSONException -> L53
        this.Q7 = r120;     // Catch: JSONException -> L53
        String r121 = "";
        if (r120 != null) goto L101;
        String r310 = r110;
        String r122 = "";
        int r311 = 0;
    L111:
        int r123 = r311;
        int r124 = 0;
    L113:
        if (((ArrayList) this.Tb).isEmpty() == true) goto L118;
        int r125 = ((ArrayList) this.Tb).size();     // Catch: JSONException -> L53
        int r126 = 0;
        long r312 = 0;
    L115:
        if (r126 >= r125) goto L117;
        r312 = r312 + ((Long) ListProtector.get(this.Tb, r126)).longValue();     // Catch: JSONException -> L53
        r126 = r126 + 1;     // Catch: JSONException -> L53
        r121 = r121;
        goto L115
    L117:
        String r313 = r121;
        long r127 = (r312 / ((long) r125)) / 1000;     // Catch: JSONException -> L53
    L119:
        LogBundle r128 = this.f458968e;     // Catch: JSONException -> L53
        long r314 = r127;
        long r129 = r128.f459333q - r128.f459253a;     // Catch: JSONException -> L53
        if ("bytevc1".equals(this.Z) == true) goto L122;
    L124:
        int r130 = -1;
    L125:
        int r315 = r130;
        JSONObject r131 = r103;
        int r316 = r123;
        JSONObject r132 = r131.put(LiveCommonConstants.LOG_PARAM_EVENT_KEY, "play_stop").put("res_list", new JSONArray(this.f458984f6)).put("socket_err_code", this.f458968e.I1).put("socket_err_type", this.f458968e.H1).put("first_audio_frame_end", this.f458968e.f459333q);     // Catch: JSONException -> L53
        if (r129 > 0) goto L129;
        r129 = 0;
    L129:
        JSONObject r133 = r132.put("first_audio_frame_view", r129).put(HistoryTableOperate.HISTORY_PLAY_TIME, r107);     // Catch: JSONException -> L53
        if (this.f459009h3 == false) goto L132;
        int r134 = 1;
    L133:
        JSONObject r135 = r133.put("is_stream_received", r134).put("is_stream_received_live", this.Za).put("render_fail_type", this.f459110p3).put("code", this.f459095o3).put("stall_count", this.f459158t3).put("stall_time", this.f459170u3).put("request_cdn_cached", this.f458968e.f459324o0).put("request_time_to_source", this.f458968e.f459334q0).put("request_time_for_cdn", this.f458968e.f459344s0).put("audio_render_stall_count", this.J3).put("audio_render_stall_time", this.K3).put("video_render_stall_count", this.H3).put("video_render_stall_time", this.I3).put("video_decode_stall_count", this.B8).put("video_decode_stall_time", this.C8).put("audio_decode_stall_count", this.D8).put("audio_decode_stall_time", this.E8).put("video_demux_stall_count", this.F8).put("video_demux_stall_time", this.O8).put("audio_demux_stall_count", this.P8).put("audio_demux_stall_time", this.Q8).put("stall_count_preview", this.f459196w3).put("stall_time_preview", this.f459184v3).put("audio_render_stall_count_preview", this.f459236z3).put("audio_render_stall_time_preview", this.A3).put("video_render_stall_count_preview", this.f459210x3).put("video_render_stall_time_preview", this.f459224y3).put("video_decode_stall_count_preview", this.f458951c9).put("video_decode_stall_time_preview", this.f458963d9).put("audio_decode_stall_count_preview", this.f458975e9).put("audio_decode_stall_time_preview", this.f458987f9).put("video_demux_stall_count_preview", this.f459001g9).put("video_demux_stall_time_preview", this.f459015h9).put("audio_demux_stall_count_preview", this.f459027i9).put("audio_demux_stall_time_preview", this.f459039j9).put("play_time_preview", r113).put("play_time_on_no_frame_preview", r210).put("error_recover_count", this.f459048k4).put("error_recover_time", this.f459060l4).put("start", this.f458968e.f459253a).put("settings_info", this.W5).put("set_surface_time", this.f459198w5).put("set_surface_cost", this.f459186v5).put("video_render_type", this.f458968e.f459340r1).put("prepare_block_end", this.f458968e.f459263c).put("prepare_end", this.f458968e.f459343s).put("retry_count", this.f458933b4).put("socket_receive_buffer_size_on_first_frame", this.f458968e.f459275e1).put("socket_receive_buffer_size_on_stop", this.f458980f.getSocketRecBuffer()).put("first_stall_time", r117).put("first_stall_duration", r116).put("call_api_name", r410).put("play_time_on_no_frame", r212).put("abr_switch_count", this.f459086n6).put("abr_switch_count_info", this.f459098o6).put("first_frame_retry_count", this.N6).put("first_frame_retry_duration", this.O6).put("abr_check_enhance", this.f459138r7);     // Catch: JSONException -> L53
        if (this.f458980f.isSrDirectDrawUsed() == false) goto L136;
        int r136 = 1;
    L137:
        JSONObject r137 = r135.put("sr_direct_draw_used", r136);     // Catch: JSONException -> L53
        if (this.f458980f.isSharpenDirectDrawUsed() == false) goto L140;
        int r138 = 1;
    L141:
        JSONObject r139 = r137.put("sharpen_direct_draw_used", r138).put(IVideoEventLogger.FEATURE_KEY_NETWORK_TIMEOUT, this.S6).put("suggest_format", this.E5).put("suggest_protocol", this.G5).put("suggest_access_code", this.L5).put("is_change_network_type", this.M5).put("degrade_for_net_change", this.N5).put("session_num", this.f459115p8).put("use_live_threadpool", this.f459054ka).put("used_drm", this.f459078ma).put("push_audio_stall_time_0", this.U3).put("push_audio_stall_time_2", this.V3).put("push_video_stall_time_0", this.W3).put("push_video_stall_time_1", this.X3).put("push_video_stall_time_2", this.Y3).put("push_retry_stall", this.Z3).put("preconnect_result", this.Ka).put("hw_dec_err", this.H0).put("ipv6_probe_result", this.f458968e.F2).put("http_open_start", this.f458968e.f459283g).put("trans_open_start", this.f458968e.f459288h).put("socket_create_end", this.f458968e.f459293i).put("3xx_happen_time", this.f458968e.f459298j).put("sr_predict_result", r119).put("trans_strategy_params", this.Da).put("trans_params_bandwidth", this.Ea).put("trans_params_bandwidth_decision", this.Fa).put("node_optimize_info", this.Pa).put("cache_ajframe", this.Q6).put("is_crop_live", this.Qa).put("media_codec_async_output", this.f459061l5).put("dynamic_frame_drop", this.f459085n5).put("audio_live_open", this.f458968e.G2).put("video_live_open", this.f458968e.H2).put("audio_live_connect_end", this.f458968e.I2).put("video_live_connect_end", this.f458968e.J2).put("first_live_audio_packet_end", this.f458968e.K2).put("first_live_video_packet_end", this.f458968e.L2);     // Catch: JSONException -> L53
        this.f458968e.getClass();     // Catch: JSONException -> L53
        JSONObject r140 = r139.put("first_live_audio_frame_render_end", 0).put("first_live_video_frame_render_end", this.f458968e.M2).put("enable_preload", this.Ta).put("preload_init_error", this.Ua);     // Catch: JSONException -> L53
        if (this.Va != 1) goto L144;
        int r141 = 1;
    L145:
        JSONObject r142 = r140.put("audioHttpxRequestCached", r141);     // Catch: JSONException -> L53
        if (this.Wa != 1) goto L148;
        int r143 = 1;
    L149:
        JSONObject r144 = r142.put("videoHttpxRequestCached", r143).put("audioCachedNum", this.f458968e.N2).put("videoCachedNum", this.f458968e.O2).put("preload_resource_total", this.f458968e.P2).put("preloadTaskTotal", this.f458968e.Q2).put("preloadTaskSuccess", this.f458968e.R2).put("preloadTaskFail", this.f458968e.S2).put("preloadTaskNotExecute", this.f458968e.T2).put("bussiness_preload_resource_total", this.f458968e.U2).put("preload_result", this.Xa).put("preload_resolution", this.f458953cb).put("play_use_preload_resolution", this.f458965db).put("preload_visit_timedelta", this.Ya).put("cache_hit", this.f458925ab).put("preload_task_state", this.f458940bb).put("cache_open_start_time", this.f458968e.V2).put("cache_open_end_time", this.f458968e.W2).put("cache_read_eof_time", this.f458968e.X2).put("live_open_start_time", this.f458968e.Y2).put("live_open_end_time", this.f458968e.Z2).put("live_read_first_pkt_time", this.f458968e.f459257a3);     // Catch: JSONException -> L53
        LogBundle r145 = this.f458968e;     // Catch: JSONException -> L53
        JSONObject r146 = r144.put("cache_open_cost", r145.W2 - r145.V2);     // Catch: JSONException -> L53
        LogBundle r147 = this.f458968e;     // Catch: JSONException -> L53
        JSONObject r148 = r146.put("cache_consume_cost", r147.X2 - r147.V2);     // Catch: JSONException -> L53
        LogBundle r149 = this.f458968e;     // Catch: JSONException -> L53
        JSONObject r150 = r148.put("live_open_cost", r149.Z2 - r149.Y2);     // Catch: JSONException -> L53
        LogBundle r151 = this.f458968e;     // Catch: JSONException -> L53
        JSONObject r152 = r150.put("cache_live_hole", r151.Z2 - r151.X2);     // Catch: JSONException -> L53
        LogBundle r153 = this.f458968e;     // Catch: JSONException -> L53
        JSONObject r154 = r152.put("cache_live_read_diff", r153.f459257a3 - r153.X2);     // Catch: JSONException -> L53
        LogBundle r155 = this.f458968e;     // Catch: JSONException -> L53
        JSONObject r156 = r154.put("cache_live_render_diff", r155.M2 - r155.f459328p).put("av_unsync_info", this.Q7).put("av_out_sync_count_rts", r122).put("av_out_sync_duration_rts", r316).put("av_out_diff_average_rts", r124).put("silent_voice_event", this.f459003gb).put(IVideoEventLogger.LOG_CALLBACK_CONTAINER_FPS, this.C5).put("async_set_surface_cost", this.f459154sb).put("fallback_sw_dec", this.f459073m5).put("prepare_start_ts", this.f459204wb).put("play_start_ts", this.f459232yb).put("play_end_ts", this.f459244zb).put("prepare_error_code", this.f459218xb).put("pre_io_error_code", this.Bb).put("pre_back_error_code", this.Cb).put("prepare_end_ts", this.Ab).put("liveio_p2p_dn_used", this.Db).put("liveio_p2p_up_used", this.Eb).put("preconn_error_code", this.Pb).put("preconn_host", this.Qb).put("preconn_ip", this.Rb);     // Catch: JSONException -> L53
        if (this.Sb == false) goto L152;
        int r157 = 1;
    L153:
        JSONObject r158 = r156.put("preconn_is_get_ip_from_preconn", r157);     // Catch: JSONException -> L53
        if (this.H9 <= 0) goto L156;
        long r159 = this.Fb;     // Catch: JSONException -> L53
    L157:
        JSONObject r160 = r158.put("http_flow_size", r159);     // Catch: JSONException -> L53
        if (this.H9 <= 0) goto L160;
        long r161 = this.Gb;     // Catch: JSONException -> L53
    L161:
        JSONObject r162 = r160.put("p2p_flow_size", r161);     // Catch: JSONException -> L53
        if (this.H9 <= 0) goto L164;
        long r163 = this.Hb;     // Catch: JSONException -> L53
    L165:
        JSONObject r164 = r162.put("p2p_mobile_flow_size", r163);     // Catch: JSONException -> L53
        if (this.H9 <= 0) goto L168;
        long r165 = this.Ib;     // Catch: JSONException -> L53
    L169:
        JSONObject r166 = r164.put("rtm_flow_size", r165).put("httpio_play_time", this.Jb).put("p2pio_play_time", this.Kb).put("rtmio_play_time", this.Lb).put("multipath_cellular_flow_size", this.Nb).put("multipath_running_status", this.Mb).put("algorithmlist", getAlgoSeParams()).put("first_sei_delay", this.f458968e.f459290h1).put("average_bitrate", r314).put("room_play_time_ms", r211).put("has_open_audio_balance_by_sei", this.Vb).put("has_open_third_pub_audio_balance_by_sei", this.Wb).put("has_skip_audio_balance_bysei", this.Xb).put("first_frame_preplay_wait_cost", this.f459018hc).put("is_free_flow", this.Q).put("enable_p2p_and_lowlatency_adapt", this.S9).put("pcdn_h2p_cache", this.U9).put("pcdn_watch_threshold", this.T9).put("cellular_total_download_size", this.f458917a3).put("cellular_play_time", this.f458932b3).put("ipv6_race_result", this.f458968e.H0).put("ipv6_race_connect_cost", this.f458968e.I0).put("ipv6_race_result_ip", this.f458968e.J0).put("enable_drop_frame", this.f458969e3).put("drop_frame_min_fps", this.f458995g3).put("drop_frame_rate", this.f458981f3).put("network_quality_behavior", this.X2);     // Catch: JSONException -> L53
        if (this.Z2 <= 0) goto L172;
        int r167 = 1;
    L173:
        JSONObject r168 = r166.put("has_switched_network", r167).put("switch_network_try_times", this.Y2).put("switch_network_succeed_times", this.Z2).put("enable_fast_first_frame", this.T5).put("start_play_buffer_wait_time", this.f459223y2).put("volume_balance_target_lufs", this.Yb).put("preplay_enter_room_timestamp", this.f459004gc).put("preplay_play_time_ms", calculatePreplayTime()).put("vqscore_series", this.f458980f.getVQSCoreResult()).put("texturerender_error_msg", this.f459233yc).put("UseRedirectedIp", this.L4).put("RedirectedPort", this.M4).put("UsePreconnectIp", this.N4).put("source_stream_luft", this.f459245zc).put("source_stream_luft_peak", this.Ac).put("strategy_common_trace", LiveStrategyManager.inst().getStrategyCenterCommonTraceInfo()).put("neptune_common_trace", this.f459082n).put("strategy_ABInfo", LiveStrategyManager.inst().getStrategyCenterABTraceInfo()).put("OptMissedDomain", this.Ba).put("event_key_index", f458912ie.incrementAndGet()).put("major_anchor_level", this.f459221y).put("p2p_auto_start_reason", this.W9).put("pre_node_selection", this.Lc).put("is_code_start", this.Mc).put("data_space", this.f458916a).put("svc_play", this.Ic).put("svc_discard_offset", this.f458980f.getActualSvcDiscardOffset()).put("svc_discard_interval", this.f458980f.getActualSvcDiscardInterval()).put("svc_temporal_layers", r315).put("multipath_show_push_reason", this.Y9);     // Catch: JSONException -> L53
        Object r169 = "none";
        if (this.Nc.isEmpty() == false) goto L177;
        Object r170 = "none";
    L178:
        r168.put("p2p_flv_detail", r170).put("sync_set_surface_cost", this.f458979ed).put("illegal_call_start_count", this.f459057kd).put("illegal_call_stop_count", this.f459069ld).put("total_download_size", this.I6).put("play_size", this.J6).put("setup_texturerender_cost", this.f459194vd).put("no_frame_time", this.Md).put("dns_resolver_cost", this.Cd).put("sdk_dns_resolver_cost", this.Dd).put("real_time_flv_ip", this.Ra).put("volume_balance_strategy_type", this.Yd).put("real_time_rtm_ip", this.Sa).put("enable_early_voice", this.f458928ae).put("ttlive_audio_first", this.f458943be);     // Catch: JSONException -> L53
        Object r171 = this.Rd;     // Catch: JSONException -> L53
        if (r171 == null) goto L181;
        JSONObject r172 = r131;
        r172.put("perf_strategy_info", r171);     // Catch: JSONException -> L53
    L182:
        r172.put("perf_strategy_avg_cost", this.Vd);     // Catch: JSONException -> L53
        r172.put("perf_strategy_max_cost", this.Wd);     // Catch: JSONException -> L53
        if (TextUtils.isEmpty(this.O4) == true) goto L186;
        r172.put("pre_redirect_new_args", this.O4);     // Catch: JSONException -> L53
    L186:
        if (TextUtils.isEmpty(this.P4) == true) goto L188;
        r172.put("pre_redirect_ip", this.P4);     // Catch: JSONException -> L53
    L188:
        int r173 = this.f458980f.getAudioWaterMarkISEnable();     // Catch: JSONException -> L53
        if (r173 != 1) goto L191;
        int r174 = this.f458980f.getAudioWaterMarkIsInitOK();     // Catch: JSONException -> L53
        int r175 = this.f458980f.getAudioWaterMarkIsWorking();     // Catch: JSONException -> L53
        r172.put("audioWaterMarkWoking", r175).put("audioWaterMarkErrorCode", this.f458980f.getAudioWaterMarkErrorCode()).put("audioWaterMarkInitOK", r174).put("audioWaterMarkEnable", r173);     // Catch: JSONException -> L53
    L191:
        String r176 = this.f458968e.S1;     // Catch: JSONException -> L53
        if (TextUtils.isEmpty(r176) == true) goto L202;
        r172.put("liveio_metrics", r176);     // Catch: JSONException -> L53
        JSONObject r177 = new JSONObject(r176);     // Catch: JSONException -> L199
        Iterator<String> r178 = r177.keys();     // Catch: JSONException -> L199
    L196:
        if (r178.hasNext() == false) goto L202;
        String r179 = r178.next();     // Catch: JSONException -> L199
        r172.put(r179, r177.get(r179));     // Catch: JSONException -> L199
    L199:
        e = move-exception;
        e.printStackTrace();     // Catch: JSONException -> L53
    L202:
        JSONObject r180 = LiveStrategyManager.inst().executeCommand(0, 404, 0, null);     // Catch: JSONException -> L53
        c.d("multiPath", "multiPathMetrics" + r180);     // Catch: JSONException -> L53
        if (r180 != null) goto L475;
    L212:
        JSONObject r181 = this.f459180ud;     // Catch: JSONException -> L53
        if (r181 != null) goto L479;
    L222:
        Object r182 = this.S2;     // Catch: JSONException -> L53
        if (r182 == "none") goto L226;
        r172.put("live_stream_session_id", r182);     // Catch: JSONException -> L53
    L226:
        if (this.f459009h3 == true) goto L228;
    L229:
        String r183 = this.f458980f.getPlayerErrorInfo();     // Catch: JSONException -> L53
        if (TextUtils.isEmpty(r183) == true) goto L232;
        r172.put("error_msg", r183);     // Catch: JSONException -> L53
    L232:
        addViewResolutionInfo(r172);     // Catch: JSONException -> L53
        addBmfSrInfo(r172);     // Catch: JSONException -> L53
        addBmfSharpenInfo(r172);     // Catch: JSONException -> L53
        addAesBoostInfo(r172);     // Catch: JSONException -> L53
        addSDR2HDRInfo(r172);     // Catch: JSONException -> L53
        resetVideoProcessInfo();     // Catch: JSONException -> L53
        if (this.f458980f.getEffectEnable(16) != 1) goto L246;
        int r184 = this.Bc;     // Catch: JSONException -> L53
        if (r184 == 15) goto L242;
        if (r184 != 16) goto L238;
        int r185 = -102;
    L243:
        r172.put("vqscore_process_cost", this.f458980f.getEffectProcessCost(16));     // Catch: JSONException -> L53
        r172.put("vqsore_process_success_rate", this.f458980f.getEffectProcessSuccessRate(16));     // Catch: JSONException -> L53
        r172.put("vqscore_error", r185);     // Catch: JSONException -> L53
        if (this.f458980f.getEnableLogPrintOpt() == 1) goto L246;
        String r186 = "LiveLoggerService";
        c.i(r186, "vqscore_process_cost " + this.f458980f.getEffectProcessCost(16) + ",vqsore_process_success_rate: " + this.f458980f.getEffectProcessSuccessRate(16) + ", vqscore_series: " + this.f458980f.getVQSCoreResult() + ", vqscore_error: " + r185);     // Catch: JSONException -> L53
    L247:
        c.i(r186, "average bitrate: " + r314);     // Catch: JSONException -> L53
        wmc.a r187 = this.G9;     // Catch: JSONException -> L53
        if (r187 == null) goto L250;
        JSONObject r188 = r187.serialLiveIOLog(2, r172);     // Catch: JSONException -> L53
    L251:
        LogBundle r189 = this.f458968e;     // Catch: JSONException -> L53
        long r190 = r189.K0;     // Catch: JSONException -> L53
        if (r190 == (-1)) goto L255;
        r188.put("http_notfound_cost", r190 - r189.f459253a);     // Catch: JSONException -> L53
    L256:
        r188.put("liveio_dispatch_cost", this.f458968e.L0);     // Catch: JSONException -> L53
        if (this.Ta != 1) goto L259;
        c.i(TTUtils.LOG_TAG, "[play_stop] first_frame_view = " + this.M9 + "\ncache_hit = " + this.f458925ab + "\npreload_result = " + this.Xa + "\npreload_visit_timedelta = " + this.Ya + "\naudioHttpxRequestCached = " + this.Va + "\nvideoHttpxRequestCached = " + this.Wa + "\npreload_init_error = " + this.Ua + "\npreload_resource_total = " + this.f458968e.P2 + "\npreloadTaskTotal = " + this.f458968e.Q2 + "\npreloadTaskSuccess = " + this.f458968e.R2 + "\npreloadTaskFail = " + this.f458968e.S2 + "\nbussinessPreloadResTotal = " + this.f458968e.U2);     // Catch: JSONException -> L53
    L259:
        StringBuilder r191 = new StringBuilder();     // Catch: JSONException -> L53
        r191.append("use sr: ");     // Catch: JSONException -> L53
        r191.append(this.f459238z5);     // Catch: JSONException -> L53
        r191.append(", not use sr reason: ");     // Catch: JSONException -> L53
        if (this.f459238z5 == false) goto L262;
        int r192 = 0;
    L263:
        r191.append(r192);     // Catch: JSONException -> L53
        c.i(r186, r191.toString());     // Catch: JSONException -> L53
        StringBuilder r193 = new StringBuilder();     // Catch: JSONException -> L53
        r193.append("use sharpen: ");     // Catch: JSONException -> L53
        r193.append(this.A5);     // Catch: JSONException -> L53
        r193.append(", not use sharpen reason: ");     // Catch: JSONException -> L53
        if (this.A5 == false) goto L266;
        int r194 = 0;
    L267:
        r193.append(r194);     // Catch: JSONException -> L53
        c.i(r186, r193.toString());     // Catch: JSONException -> L53
        c.i(r186, "use aesboost: " + this.f458980f.isUsedEffect(28) + ", not use aesboost reason: " + this.f458980f.getAesBoostNotUseReason());     // Catch: JSONException -> L53
        Object r195 = this.f458980f.getAbrBitrateMap();     // Catch: JSONException -> L53
        if (this.f458980f.getEnableLogPrintOpt() == 1) goto L270;
        c.i(r186, "bitrateMap: " + r195);     // Catch: JSONException -> L53
    L270:
        if (r195 == null) goto L273;
        r188.put("abr_bitrate_map", r195);     // Catch: JSONException -> L53
    L273:
        if (this.f459017hb == null) goto L275;
        JSONObject r196 = new JSONObject();     // Catch: JSONException -> L53
        r196.put("abr_time_offset_set", this.f459017hb);     // Catch: JSONException -> L53
        r196.put("abr_cur_bitrate_set", this.f459029ib);     // Catch: JSONException -> L53
        r196.put("abr_predict_bitrate_set", this.f459041jb);     // Catch: JSONException -> L53
        r196.put("abr_cur_bandwidth_set", this.f459055kb);     // Catch: JSONException -> L53
        r196.put("abr_predict_bandwidth_set", this.f459067lb);     // Catch: JSONException -> L53
        r196.put("abr_player_buffer_set", this.f459079mb);     // Catch: JSONException -> L53
        r196.put("abr_stall_status_set", this.f459091nb);     // Catch: JSONException -> L53
        r188.put("abr_decision_info", r196);     // Catch: JSONException -> L53
    L275:
        Object r197 = this.Na;     // Catch: JSONException -> L53
        if (r197 == null) goto L278;
        r188.put("sdk_localdns_result", r197);     // Catch: JSONException -> L53
    L278:
        Object r198 = this.f458968e.B2;     // Catch: JSONException -> L53
        if (r198 == null) goto L281;
        r188.put("abr_stream_info", r198);     // Catch: JSONException -> L53
    L281:
        int r199 = this.K2;     // Catch: JSONException -> L53
        if (r199 == (-1)) goto L284;
        r188.put("audio_timescale_enable", r199);     // Catch: JSONException -> L53
    L284:
        Object r200 = this.f458968e.E2;     // Catch: JSONException -> L53
        if (r200 == null) goto L288;
        r188.put("avph_stream_info", r200);     // Catch: JSONException -> L53
    L288:
        if (this.f459113p6 == false) goto L291;
        r188.put("mpd_compose_cost", this.f458980f.getMpdUrlCost());     // Catch: JSONException -> L53
    L291:
        if (this.f458980f.getEnableTexturerender() != 1) goto L481;
        r188.put("render_start_timestamp", this.D5);     // Catch: JSONException -> L53
        r188.put("texturerender_renderstart_timestamp", this.f459000g8);     // Catch: JSONException -> L53
        r188.put("crop_texture_coord", this.f458980f.getStringOption(211, r313));     // Catch: JSONException -> L53
    L481:
    L298:
        th = move-exception;
        th.printStackTrace();     // Catch: JSONException -> L53
    L303:
        r188.put("av_out_sync_count", this.f458939ba);     // Catch: JSONException -> L53
        r188.put("av_out_sync_duration", this.f458964da);     // Catch: JSONException -> L53
        if (this.f458939ba <= 0) goto L306;
        r188.put("av_out_sync_info", this.f459016ha);     // Catch: JSONException -> L53
    L306:
        reportQuicOpenResult(r188);     // Catch: JSONException -> L53
        r188.put("call_preload_func_result", getCallPreloadFuncState());     // Catch: JSONException -> L53
        if (isRtcPlayAvailable() == false) goto L311;
        r188.put("player_dns_analysis_end", this.H7);     // Catch: JSONException -> L53
        r188.put("rtc_use_sdk_dns", this.G7);     // Catch: JSONException -> L53
        r188.put("tcp_connect_end", this.I7);     // Catch: JSONException -> L53
        r188.put("rtc_tls_handshake_end", this.J7);     // Catch: JSONException -> L53
        r188.put("tcp_first_package_end", this.K7);     // Catch: JSONException -> L53
        r188.put("rtc_inited_end", this.f458968e.f459296i2);     // Catch: JSONException -> L53
        r188.put("rtc_offer_send_end", this.f458968e.f459316m2);     // Catch: JSONException -> L53
        r188.put("rtc_answer_recv_end", this.f458968e.f459321n2);     // Catch: JSONException -> L53
        r188.put("rtc_ice_connected_time", this.f458968e.f459336q2);     // Catch: JSONException -> L53
        r188.put("rtc_start_end", this.f458968e.f459341r2);     // Catch: JSONException -> L53
        r188.put("rtc_preload_result", getRTCPreloadingState());     // Catch: JSONException -> L53
        r188.put("call_preload_func_time", this.f458968e.f459366w2);     // Catch: JSONException -> L53
        r188.put("rtc_playstop_info", this.P7);     // Catch: JSONException -> L53
    L321:
        String r201 = this.V2;     // Catch: JSONException -> L53
        if (r201 != null) goto L325;
    L333:
        String r202 = r310;
        if (TextUtils.equals(this.G5, r202) == false) goto L345;
        long r1100 = this.Z8;     // Catch: JSONException -> L53
        if (r1100 != 0) goto L342;
        String r411 = "tcp_first_package_end";
        String r1101 = "tcp_connect_end";
        if (this.f458923a9 != 0) goto L343;
        r188.put("quicu_client_per", -1);     // Catch: JSONException -> L53
    L344:
        r188.put("audio_quicu_frame_drop_time", this.W8).put("video_quicu_frame_drop_time", this.Y8).put("audio_quicu_frame_drop_count", this.V8).put("video_quicu_frame_drop_count", this.X8).put("audio_quicu_frame_drop_time_preview", this.f459065l9).put("video_quicu_frame_drop_time_preview", this.f459089n9).put("audio_quicu_frame_drop_count_preview", this.f459053k9).put("video_quicu_frame_drop_count_preview", this.f459077m9).put("audio_level1_frame_drop_time", this.A9).put("video_level1_frame_drop_time", this.f459216x9).put("audio_level2_frame_drop_time", this.B9).put("video_level2_frame_drop_time", this.f459230y9).put("audio_level3_frame_drop_time", this.C9).put("video_level3_frame_drop_time", this.f459242z9).put("audio_before_first_frame_drop_time", this.f459202w9).put("video_before_first_frame_drop_time", this.f459190v9).put("quicu_audio_timeout", this.X6).put("quicu_video_timeout", this.Y6).put("quicu_timeout_from", this.Z6).put("quicu_client_drop_max_cost", this.f458938b9);     // Catch: JSONException -> L53
    L347:
        if (this.f459112p5 == false) goto L352;
        r188.put("session_time_series", _createSessionTimeSeries());     // Catch: JSONException -> L53
        if (this.f458980f.getEnableLogPrintOpt() == 1) goto L352;
        c.i(r186, _createSessionTimeSeries().toString());     // Catch: JSONException -> L53
    L352:
        if (this.f458982f4 == false) goto L354;
        r188.put("abnormal_sei_series", this.f459099o7);     // Catch: JSONException -> L53
        r188.put("expected_sei_count", this.f459013h7);     // Catch: JSONException -> L53
        r188.put("received_sei_count", this.f459025i7);     // Catch: JSONException -> L53
        r188.put("expected_unique_sei_count", this.f459037j7);     // Catch: JSONException -> L53
        r188.put("received_unique_sei_count", this.f459051k7);     // Catch: JSONException -> L53
    L354:
        int r203 = this.R7;     // Catch: JSONException -> L53
        if (r203 == 0) goto L357;
        r188.put("bitrate_abnormal", r203);     // Catch: JSONException -> L53
    L357:
        int r204 = this.S7;     // Catch: JSONException -> L53
        if (r204 == 0) goto L361;
        r188.put("abr_codec_not_same", r204);     // Catch: JSONException -> L53
    L361:
        if (this.T7 != 0) goto L364;
        r188.put("abr_list_not_match", 1);     // Catch: JSONException -> L53
    L364:
        if (this.f459113p6 == false) goto L369;
        r188.put("abr_request_url", this.f458968e.f459267c3);     // Catch: JSONException -> L53
        r188.put("abr_switch_fail", 0);     // Catch: JSONException -> L53
    L369:
        if (TextUtils.equals(this.F5, "quic") == false) goto L371;
    L372:
        r188.put("quic_report_ccre_tag_in_chlo", this.f458968e.Z1).put("quic_report_jcco_tag_in_chlo", this.f458968e.f459256a2).put("quic_report_ssr_tag_in_chlo", this.f458968e.f459261b2).put("quic_report_irtt_tag_in_chlo", this.f458968e.f459266c2).put("quic_report_cctk_tag_in_chlo", this.f458968e.f459271d2).put("quic_report_ntyp_tag_in_chlo", this.f458968e.f459276e2).put("quic_report_ccfb_tag_in_shlo", this.f458968e.f459281f2);     // Catch: JSONException -> L53
    L374:
        if (TextUtils.equals(this.F5, "quic") == false) goto L376;
    L377:
        r188.put("scfg", this.T6).put("mtu", this.U6).put("pad_hello", this.V6).put("real_fifo_size", this.f458968e.M1);     // Catch: JSONException -> L53
        setExtParam(r188, this.P5);     // Catch: JSONException -> L53
        setExtParam(r188, this.f458968e.N1);     // Catch: JSONException -> L53
    L379:
        if (TextUtils.equals(this.F5, "h2") == false) goto L381;
    L384:
        setExtParam(r188, this.O5);     // Catch: JSONException -> L53
        r188.put("httpxRedirectIP", this.R5);     // Catch: JSONException -> L53
    L386:
        if (TextUtils.equals(this.V2, "avph") == false) goto L389;
        setExtParam(r188, this.Q5);     // Catch: JSONException -> L53
    L389:
        if (TextUtils.equals(this.V2, "cmaf") == false) goto L391;
        setExtParam(r188, this.S5);     // Catch: JSONException -> L53
        r188.put("cmaf_start_seq_no_diff", this.f458968e.L).put("audio_request_cdn_cached", this.f458968e.f459319n0).put("video_request_cdn_cached", this.f458968e.f459324o0).put("audio_request_time_to_source", this.f458968e.f459329p0).put("video_request_time_to_source", this.f458968e.f459334q0).put("audio_request_time_for_cdn", this.f458968e.f459339r0).put("video_request_time_for_cdn", this.f458968e.f459344s0);     // Catch: JSONException -> L53
    L391:
        boolean r205 = this.U7;     // Catch: JSONException -> L53
        if (r205 == false) goto L399;
        if (r205 == false) goto L396;
        int r206 = 1;
    L397:
        r188.put("cdn_abr_switch_performed", r206).put("cdn_abr_switch_code", this.V7);     // Catch: JSONException -> L53
        goto L399
    L396:
        r206 = 0;
    L399:
        if (this.f458993g1 != 1) goto L401;
        r188.put("skip_audio_time", this.f459222y1).put("skip_video_time", this.G1).put("skip_durtiaon", this.f459208x1).put("skip_count", this.H1);     // Catch: JSONException -> L53
    L401:
        long r207 = this.f459083n3 + 1;     // Catch: JSONException -> L53
        this.f459083n3 = r207;     // Catch: JSONException -> L53
        r188.put("log_total_count_when_playing", r207);     // Catch: JSONException -> L53
        if (isRtcPlayAvailable() == false) goto L408;
        LogBundle r208 = this.f459200w7;     // Catch: JSONException -> L53
        if (r208 == null) goto L408;
        r188.put(r1101, r208.f459321n2);     // Catch: JSONException -> L53
        r188.put(r411, this.f459200w7.f459308l);     // Catch: JSONException -> L53
        r188.put("first_video_package_end", this.f459200w7.f459346s2);     // Catch: JSONException -> L53
        resetRtmSessionBundle();     // Catch: JSONException -> L53
    L408:
        if (TextUtils.isEmpty(this.Jc) == true) goto L411;
        r188.put("server_expr_tag", this.Jc);     // Catch: JSONException -> L53
    L411:
        if (TextUtils.isEmpty(this.Kc) == true) goto L413;
        r188.put("server_expr_id", this.Kc);     // Catch: JSONException -> L53
    L413:
        int r209 = this.f459043jd;     // Catch: JSONException -> L53
        if (r209 != 1) goto L417;
        r188.put("reduce_report", r209).put("data_lost_series", this.f459114p7).put("data_repeat_series", this.f459126q7);     // Catch: JSONException -> L53
    L417:
        if (this.f459093nd == 1) goto L444;
        JSONObject r213 = r188.put("sdk_dns_analysis_end", this.f458968e.f459258b).put("http_req_finish_time", this.f458968e.f459309l0).put("http_res_finish_time", this.f458968e.f459314m0).put("first_video_package_end", this.f458968e.f459308l).put("first_audio_package_end", this.f458968e.f459313m).put("first_video_frame_decode_end", this.f458968e.f459318n).put("first_audio_frame_decode_end", this.f458968e.f459323o).put("first_frame_render_end", this.f458968e.f459328p).put("video_device_open_start", this.f458968e.f459348t).put("video_device_open_end", this.f458968e.f459353u).put("audio_device_open_start", this.f458968e.f459358v).put("audio_device_open_end", this.f458968e.f459363w).put("video_device_wait_start", this.f458968e.f459355u1).put("video_device_wait_end", this.f458968e.f459360v1).put("find_stream_info_start", this.f458968e.f459345s1).put("find_stream_info_end", this.f458968e.f459350t1).put("video_param_send_outlet_time", this.f458968e.f459330p1).put("first_video_frame_send_outlet_time", this.f458968e.f459335q1).put("video_first_pkt_pos", this.f458968e.f459279f0).put("video_first_pkt_pts", this.f458968e.f459284g0).put("audio_first_pkt_pos", this.f458968e.f459289h0).put("audio_first_pkt_pts", this.f458968e.f459294i0).put("download_speed", this.f458968e.f459255a1).put("video_buffer_time", this.f458968e.f459260b1).put("audio_buffer_time", this.f458968e.f459265c1);     // Catch: JSONException -> L53
        long r214 = this.f458968e.f459270d1;     // Catch: JSONException -> L53
        if (r214 > 0) goto L422;
        r214 = -r214;
    L422:
        JSONObject r215 = r213.put("wait_time", r214);     // Catch: JSONException -> L53
        if (this.f458968e.f459270d1 < 0) goto L425;
        int r216 = 0;
    L426:
        JSONObject r217 = r215.put("is_waiting", r216).put("drop_audio_pts_diff", this.f458968e.f459299j0).put("drop_audio_cost", this.f458968e.f459304k0).put(ILoadStallMonitor.STOP_TIME, System.currentTimeMillis());     // Catch: JSONException -> L53
        if (this.f459169u == false) goto L429;
        int r218 = 1;
    L430:
        JSONObject r219 = r217.put("ip_from_player_core", r218);     // Catch: JSONException -> L53
        if (this.R == false) goto L433;
        int r220 = 1;
    L434:
        JSONObject r221 = r219.put("open_dns_optimizer", r220);     // Catch: JSONException -> L53
        if (this.W == false) goto L437;
        int r222 = 1;
    L438:
        JSONObject r223 = r221.put("hit_node_optimize", r222).put("evaluator_symbol", this.S).put("lss_response_cost", this.T).put("lss_first_response_cost", this.U).put("lss_response_status_code", this.V);     // Catch: JSONException -> L53
        if (this.X == false) goto L441;
        int r224 = 1;
    L442:
        r223.put("remote_sorted", r224);     // Catch: JSONException -> L53
        goto L444
    L441:
        r224 = 0;
        goto L442
    L437:
        r222 = 0;
        goto L438
    L433:
        r220 = 0;
        goto L434
    L429:
        r218 = 0;
        goto L430
    L425:
        r216 = 1;
    L444:
        if (this.f459081md != 1) goto L462;
        if (this.f458970e4 == false) goto L448;
        int r225 = 1;
    L449:
        JSONObject r226 = r188.put("sharp", r225).put("enable_skip_on_buffering_end", this.V0).put("enable_latency_network_adapt", this.L0);     // Catch: JSONException -> L53
        if (this.P0 == false) goto L452;
        int r227 = 1;
    L453:
        JSONObject r228 = r226.put("enable_hurry", r227).put("hurry_time", this.f458930b1).put("hurry_type", this.f458993g1).put("hurry_interval", this.f459007h1).put("hurry_once_max", this.f459046k1).put("hurry_cache_type", this.f459182v1).put("hurry_skip_start", this.f459108p1).put("hurry_stop_type", this.S1).put("min_buffer_stop_drop", this.T1).put("max_drop_frame_time_cost", this.V1).put("enable_fix_pts_shift", this.f458931b2).put("hurry_delay_inc_threshold", this.f458994g2).put("catch_speed", new DecimalFormat("0.00").format(this.M1)).put("slow_play_time", this.P1).put("slow_speed", new DecimalFormat("0.00").format(this.Q1));     // Catch: JSONException -> L53
        if (this.f459023i5 == false) goto L456;
        int r229 = 1;
    L457:
        JSONObject r230 = r228.put("enable_httpDns", r229).put("enable_ntp", this.f459197w4).put("enable_media_codec_async", this.f459035j5).put("default_codec_id", this.f459049k5).put("url_ability", this.f459097o5).put("max_cache_seconds", this.f459124q5).put("enable_fast_open", this.f459160t5).put("enable_mdl", this.f459237z4).put("enable_p2p", this.A4).put("p2p_loader_type", this.D4).put("used_p2p", this.B4);     // Catch: JSONException -> L53
        Object r231 = this.G4;     // Catch: JSONException -> L53
        if (r231 != null) goto L460;
        r231 = "none";
    L460:
        r230.put("mdl_version", r231).put("enable_mdl_proto", this.H4).put("enable_low_latency_flv", this.f458936b7).put("open_strategy_sdk", this.f459165ta).put("enable_strategy_node_opt", this.f459177ua).put("enable_strategy_httpDNS", this.f459191va).put("enable_strategy_httpDNS_by_localDNS_timeout", this.f459203wa).put("enable_strategy_ipv6", this.f459217xa);     // Catch: JSONException -> L53
        goto L462
    L456:
        r229 = 0;
        goto L457
    L452:
        r227 = 0;
        goto L453
    L448:
        r225 = 0;
    L462:
        if (this.f459120pd == 1) goto L468;
        Object r232 = this.A;     // Catch: JSONException -> L53
        if (r232 == null) goto L467;
        r169 = r232;
    L467:
        r188.put(OrderParamsKey.KEY_SDK_PARAM, r169).put("sdk_params_length", this.B).put("common_sdk_params_length", this.C);     // Catch: JSONException -> L53
    L469:
        r188.put("did_set_sdkparams", this.f458980f.mDidSetSDKParams);     // Catch: JSONException -> L53
        r188.put("did_set_dolphin", this.f458980f.mDidSetDolphin);     // Catch: JSONException -> L53
        r188.put("did_set_live_stream", this.f458980f.mDidSetLiveStream);     // Catch: JSONException -> L53
        r188.put("stop_player_cost", this.Zd);     // Catch: JSONException -> L53
        onEventLog(r188, "live_client_monitor_log");     // Catch: JSONException -> L53
        this.f459083n3 = 0;     // Catch: JSONException -> L53
        return;
    L468:
        r188.put("reduce_report_applog", this.f459081md);     // Catch: JSONException -> L53
        goto L469
    L381:
        if (TextUtils.equals(this.F5, "h2q") == true) goto L384;
        if (TextUtils.equals(this.F5, "h2qu") == false) goto L386;
    L376:
        if (TextUtils.equals(this.F5, r202) == false) goto L379;
    L371:
        if (TextUtils.equals(this.F5, "h2q") == false) goto L374;
    L343:
        r188.put("quicu_client_per", Math.round((r1100 / (r1100 + this.f458923a9)) * 1000.0f));     // Catch: JSONException -> L53
        goto L344
    L342:
        r411 = "tcp_first_package_end";
        r1101 = "tcp_connect_end";
        goto L343
    L345:
        r411 = "tcp_first_package_end";
        r1101 = "tcp_connect_end";
        goto L347
    L325:
        if ("cmaf".equals(r201) == false) goto L327;
    L328:
        r188.put("video_dns_analysis_end", this.f458968e.X).put("audio_dns_analysis_end", this.f458968e.Y).put("video_tcp_connect_time", this.f458968e.V).put("audio_tcp_connect_time", this.f458968e.W).put("video_tcp_first_packet_time", this.f458968e.Z).put("audio_tcp_first_packet_time", this.f458968e.f459254a0).put("video_http_req_finish_time", this.f458968e.f459259b0).put("audio_http_req_finish_time", this.f458968e.f459264c0).put("video_http_res_finish_time", this.f458968e.f459269d0).put("audio_http_res_finish_time", this.f458968e.f459274e0);     // Catch: JSONException -> L53
        if ("cmaf".equals(this.V2) == false) goto L333;
        r188.put("cmaf_mpd_dns_analysis_end", this.f458968e.f459373y).put("cmaf_sdk_version", this.f458968e.G).put("cmaf_mpd_tcp_connect_time", this.f458968e.f459378z).put("cmaf_mpd_tcp_first_package_end", this.f458968e.B).put("cmaf_mpd_http_req_finish_time", this.f458968e.A).put("cmaf_mpd_http_res_finish_time", this.f458968e.C).put("cmaf_audio_firstseg_connect_time", this.f458968e.E).put("cmaf_video_firstseg_connect_time", this.f458968e.F).put("cmaf_mpd_connect_time", this.f458968e.D);     // Catch: JSONException -> L53
        int r233 = this.W7;     // Catch: JSONException -> L53
        if (r233 != 1) goto L333;
        r188.put("enable_async", r233);     // Catch: JSONException -> L53
        goto L333
    L327:
        if ("avph".equals(this.V2) == false) goto L333;
    L311:
        if (this.L7 == 0) goto L313;
        r188.put("fallback_begin_time", this.M7);     // Catch: JSONException -> L53
        r188.put("fallback_end_time", this.N7);     // Catch: JSONException -> L53
    L313:
        r188.put("tcp_first_package_end", this.f458968e.f459303k);     // Catch: JSONException -> L53
        r188.put("player_dns_analysis_end", this.f458968e.f459268d);     // Catch: JSONException -> L53
        if (this.f459133r != null) goto L317;
        r188.put("tcp_connect_end", this.f458968e.f459278f);     // Catch: JSONException -> L53
        goto L321
    L317:
        if ("kcp".equals(this.F5) == false) goto L319;
        long r234 = this.f458968e.f459268d;     // Catch: JSONException -> L53
    L320:
        r188.put("tcp_connect_end", r234);     // Catch: JSONException -> L53
        goto L321
    L319:
        r234 = this.f458968e.f459278f;     // Catch: JSONException -> L53
        goto L320
    L294:
        if (this.f459167tc > 0) goto L296;
    L300:
        this.f459193vc = 0;     // Catch: Throwable -> L298
        this.f459143rc.clear();     // Catch: Throwable -> L298
        this.f459179uc = false;     // Catch: Throwable -> L298
    L296:
        if (this.f459143rc.size() <= 0) goto L300;
        r188.put("session_params", new JSONArray(this.f459143rc));     // Catch: Throwable -> L298
        r188.put("session_count", this.f459193vc);     // Catch: Throwable -> L298
        r188.put("session_real_count", this.f459143rc.size());     // Catch: Throwable -> L298
        goto L300
    L266:
        r194 = this.f458980f.getSharpenNotUseReason();     // Catch: JSONException -> L53
        goto L267
    L262:
        r192 = this.f458980f.getSRNotUseReason();     // Catch: JSONException -> L53
        goto L263
    L255:
        r188.put("http_notfound_cost", -1);     // Catch: JSONException -> L53
        goto L256
    L250:
        r188 = r172;
        goto L251
    L238:
        if (r184 == 19) goto L240;
        r185 = 0;
        goto L243
    L240:
        r185 = -100;
        goto L243
    L242:
        r185 = -101;
    L246:
        r186 = "LiveLoggerService";
        goto L247
    L228:
        if (this.f458980f.getEnableReportErrorInfo() == false) goto L232;
    L479:
        Iterator<String> r235 = r181.keys();     // Catch: JSONException -> L219
    L216:
        if (r235.hasNext() == false) goto L222;
        String r236 = r235.next();     // Catch: JSONException -> L219
        r172.put(r236, this.f459180ud.get(r236));     // Catch: JSONException -> L219
    L219:
        e = move-exception;
        e.printStackTrace();     // Catch: JSONException -> L53
        goto L222
    L475:
        Iterator<String> r237 = r180.keys();     // Catch: JSONException -> L209
    L206:
        if (r237.hasNext() == false) goto L212;
        String r238 = r237.next();     // Catch: JSONException -> L209
        r172.put(r238, r180.get(r238));     // Catch: JSONException -> L209
    L209:
        e = move-exception;
        e.printStackTrace();     // Catch: JSONException -> L53
        goto L212
    L181:
        r172 = r131;
        goto L182
    L177:
        r170 = this.Nc.toString();     // Catch: JSONException -> L53
        goto L178
    L172:
        r167 = 0;
        goto L173
    L168:
        r165 = 0;
        goto L169
    L164:
        r163 = 0;
        goto L165
    L160:
        r161 = 0;
        goto L161
    L156:
        r159 = 0;
        goto L157
    L152:
        r157 = 0;
        goto L153
    L148:
        r143 = 0;
        goto L149
    L144:
        r141 = 0;
        goto L145
    L140:
        r138 = 0;
        goto L141
    L136:
        r136 = 0;
        goto L137
    L132:
        r134 = 0;
        goto L133
    L122:
        if (this.f459156sd.length() < 46) goto L124;
        int r1102 = HexCharToData(this.f459156sd.charAt(42));     // Catch: JSONException -> L53
        r130 = ((HexCharToData(this.f459156sd.charAt(43)) >> 3) & 1) | ((r1102 << 1) & 6);     // Catch: JSONException -> L53
        goto L125
    L118:
        r313 = "";
        r127 = 0;
        goto L119
    L101:
        int r239 = r120.indexOf(124);     // Catch: JSONException -> L53
        r122 = this.Q7.substring(1, r239);     // Catch: JSONException -> L53
        String r240 = this.Q7;     // Catch: JSONException -> L53
        String[] r241 = r240.substring(r239 + 1, r240.length() - 1).split(i.f25853b);     // Catch: JSONException -> L53
        int r242 = r241.length;     // Catch: JSONException -> L53
        int r243 = 0;
        r311 = 0;
        int r317 = 0;
    L102:
        if (r243 >= r242) goto L107;
        int r318 = r242;
        String[] r319 = r241;
        String[] r244 = r241[r243].split(",");     // Catch: JSONException -> L53
        String r320 = r110;
        if (r244.length != 3) goto L106;
        r311 = r311 + CastIntegerProtector.parseInt(r244[1]);     // Catch: JSONException -> L53
        r317 = r317 + CastIntegerProtector.parseInt(r244[2]);     // Catch: JSONException -> L53
    L106:
        r243 = r243 + 1;     // Catch: JSONException -> L53
        r242 = r318;
        r241 = r319;
        r110 = r320;
        goto L102
    L107:
        r310 = r110;
        if ("0".equals(r122) == true) goto L111;
        r124 = r317 / CastIntegerProtector.parseInt(r122);     // Catch: JSONException -> L53
        r123 = r311;
        goto L113
    L92:
        if (r118.mEnableDynamicSR != 1) goto L96;
        JSONObject r245 = (JSONObject) LiveStrategyManager.inst().getConfigAndStrategyByKeyInt(0, 19, null, null);     // Catch: JSONException -> L53
        c.i("LiveLoggerService", "get sr predict result " + r245);     // Catch: JSONException -> L53
        if (r245 == null) goto L96;
        r119 = r245.optInt("enable_sr");     // Catch: JSONException -> L53
        goto L97
    L86:
        if (this.f459034j4 == 0) goto L88;
        this.f459048k4++;     // Catch: JSONException -> L53
        this.f459060l4 += System.currentTimeMillis() - this.f459034j4;     // Catch: JSONException -> L53
        goto L88
    L82:
        r211 = r109;
        r212 = r108;
        goto L84
    L75:
        r116 = 0;
        r117 = 0;
        goto L77
    L68:
        if (this.f458954cc == false) goto L70;
        r109 = (this.f458966dc + System.currentTimeMillis()) - this.f458926ac;     // Catch: JSONException -> L53
        goto L72
    L70:
        r109 = this.f458966dc;     // Catch: JSONException -> L53
        goto L72
    L48:
        r105 = this.F9;     // Catch: JSONException -> L53
        r111 = this.E9;     // Catch: JSONException -> L53
        goto L49
    L56:
        if (this.f459095o3 == 0) goto L58;
    L64:
        r108 = 0;
        r107 = 0;
        r113 = 0;
        r210 = 0;
        goto L66
    L58:
        if (this.f458968e.f459253a == 0) goto L64;
        r108 = System.currentTimeMillis() - this.f458968e.f459253a;     // Catch: JSONException -> L53
        if (isPreview() == false) goto L62;
        long r246 = System.currentTimeMillis();     // Catch: JSONException -> L53
        long r1103 = this.D9;     // Catch: JSONException -> L53
    L63:
        long r247 = r246 - r1103;     // Catch: JSONException -> L53
        r113 = 0;
        r210 = r247;
        r107 = 0;
        goto L66
    L62:
        r246 = this.F9;     // Catch: JSONException -> L53
        r1103 = this.D9;     // Catch: JSONException -> L53
        goto L63
    L495:
        return;
    L35:
        if (this.f459105od != r101) goto L41;
        addSessionStopInfo_v2(r103);
        r103.put("playing_info", this.Xd);     // Catch: JSONException -> L39
        r103.put("playing_live_stream_session_id", this.R2);     // Catch: JSONException -> L39
        r103.put("session_stop_live_stream_session_id", this.R2);     // Catch: JSONException -> L39
    L39:
        e = move-exception;
        e.printStackTrace();
        goto L42
    L41:
        addSessionStopInfo(r103);
        goto L42
    L30:
        r103 = createCommonLog_v2();
        goto L32
    L13:
        if (isRtmv3() == true) goto L20;
        if (isRtcPlayAvailable() == true) goto L17;
    L19:
        r101 = true;
        goto L22
    L17:
        if (enableRtmLastPlayingStat() == false) goto L19;
    L21:
        this.f458980f.getLogInfo(this.f458968e, 2);
        this.N6 = this.f458933b4;
        this.O6 = this.P6;
        r101 = true;
        goto L22
    }

    public static /* synthetic */ int access$100(LiveLoggerService r100) {
        return r100.f459159t4;
    }

    public static /* synthetic */ boolean access$200(LiveLoggerService r100) {
        return r100.isNetWorkChanged();
    }

    public static /* synthetic */ InetAddress access$300(LiveLoggerService r100) {
        return r100.f459111p4;
    }

    public static /* synthetic */ void access$400(LiveLoggerService r100) {
        r100.ntp();
    }

    public static /* synthetic */ boolean access$500(LiveLoggerService r100) {
        return r100.f459171u4;
    }

    private void addAesBoostBasicInfo(JSONObject r100) throws JSONException {
        boolean r101 = this.f458980f.isUsedEffect(28);
        r100.put("aes_boost_used", r101 ? 1 : 0);
        if (r101 == false) goto L6;
        r100.put(TextureRenderKeys.KEY_IS_AES_BOOST_GROUP_ID, this.f458968e.f459362v3);
        return;
    }

    private void addAesBoostInfo(JSONObject r100) throws JSONException {
        addAesBoostBasicInfo(r100);
        r100.put("aes_boost_not_use_reason", this.f458980f.getAesBoostNotUseReason());
        r100.put("aes_boost_cfg_type", this.f458968e.f459357u3.ordinal());
        String r101 = this.f458968e.f459367w3;
        if (r101 == null) goto L6;
        r100.put("aes_boost_cfg_reason", r101);
        return;
    }

    private void addBmfSharpenBasicInfo(JSONObject r100) throws JSONException {
        r100.put("sharpen_used", this.A5 ? 1 : 0);
        addBmfSharpenLevelInfo(r100);
        if (this.A5 == false) goto L6;
        r100.put("sharpen_alg_type", this.f458968e.f459342r3);
        return;
    }

    private void addBmfSharpenInfo(JSONObject r100) throws JSONException {
        addBmfSharpenBasicInfo(r100);
        r100.put(IPerformanceManager.PlayerClient.sharpen_enabled, this.f458980f.getSharpenState() ? 1 : 0);
        if (this.A5 == false) goto L5;
        int r101 = 0;
    L6:
        r100.put("sharpen_not_use_reason", r101);
        r100.put("sharpen_cfg_type", this.f458968e.f459337q3.ordinal());
        String r102 = this.f458968e.f459352t3;
        if (r102 == null) goto L10;
        r100.put("sharpen_cfg_reason", r102);
    L10:
        if (this.A5 == false) goto L13;
        r100.put("sharpen_process_cost", this.f458980f.getEffectProcessCost(1));
        r100.put("sharpen_process_success_rate", this.f458980f.getEffectProcessSuccessRate(1));
        return;
    L13:
        return;
    L5:
        r101 = this.f458980f.getSharpenNotUseReason();
        goto L6
    }

    private void addBmfSharpenLevelInfo(JSONObject r100) throws JSONException {
        if (this.A5 == false) goto L6;
        r100.put("sharpen_level", this.f458968e.f459347s3);
        return;
    }

    private void addBmfSrInfo(JSONObject r100) throws JSONException {
        addBmfSrBasicInfo(r100, this.f459238z5);
        r100.put("nnsr_enabled", this.f458980f.getSRState() ? 1 : 0);
        if (this.f459238z5 == false) goto L5;
        int r101 = 0;
    L6:
        r100.put("sr_not_use_reason", r101);
        r100.put("sr_cfg_type", this.f458968e.f459307k3.ordinal());
        String r102 = this.f458968e.f459332p3;
        if (r102 == null) goto L10;
        r100.put("sr_cfg_reason", r102);
    L10:
        if (this.f459238z5 == false) goto L13;
        r100.put("sr_process_cost", this.f458980f.getEffectProcessCost(5));
        r100.put("sr_process_success_rate", this.f458980f.getEffectProcessSuccessRate(5));
        return;
    L13:
        return;
    L5:
        r101 = this.f458980f.getSRNotUseReason();
        goto L6
    }

    private void addDisplayModelInfo(JSONObject r100) throws JSONException {
        r100.put("preview_play_time", this.f459026i8.f459372x3).put("inner_play_time", this.f459026i8.f459377y3).put("small_window_play_time", this.f459026i8.C3).put("initial_play_time", this.f459026i8.D3).put("background_watching_time", this.f459026i8.B3).put("preview_preplay_play_time", this.f459026i8.f459382z3).put("inner_preplay_play_time", this.f459026i8.A3);
        HashMap<String, Long> r101 = this.Qd;
        if (r101 == null) goto L8;
        Iterator<Map.Entry<String, Long>> r102 = r101.entrySet().iterator();
    L6:
        if (r102.hasNext() == false) goto L10;
        Map.Entry<String, Long> r103 = r102.next();
        r100.put(r103.getKey() + "_time", r103.getValue());
        goto L6
    L10:
        return;
    }

    private void addSDR2HDRInfo(JSONObject r100) throws JSONException {
        boolean r101 = this.f458980f.getSDR2HDRUsed();
        r100.put("sdr2hdr_used", r101 ? 1 : 0);
        r100.put("enable_use_sdr2hdr", this.Sd);
        if (r101 == false) goto L5;
        int r102 = 0;
    L6:
        r100.put("sdr2hdr_not_use_reason", r102);
        return;
    L5:
        r102 = this.f458980f.getSDR2HDRNotUseReason();
        goto L6
    }

    private void addSegementRequest(JSONObject r100) {
    L10:
        e = move-exception;
        e.printStackTrace();
        return;
    L3:
        if (((ArrayList) this.f459234yd).size() <= 0) goto L8;
        int r101 = 0;
    L6:
        if (r101 >= ((ArrayList) this.f459234yd).size()) goto L8;
        d r102 = (d) ListProtector.get(this.f459234yd, r101);     // Catch: Exception -> L10
        JSONObject r103 = new JSONObject();     // Catch: Exception -> L10
        r103.put("request_id", String.valueOf(r102.f459432a) + "_" + r102.f459438g);     // Catch: Exception -> L10
        r103.put("request_size", r102.f459435d);     // Catch: Exception -> L10
        r103.put("play_duration", r102.f459434c);     // Catch: Exception -> L10
        r103.put("suffix", r102.f459438g);     // Catch: Exception -> L10
        r103.put(TTVideoEngineInterface.PLAY_API_KEY_CODEC, r102.f459439h);     // Catch: Exception -> L10
        r103.put("play_format", r102.f459440i);     // Catch: Exception -> L10
        r103.put(MonitorConstants.IS_PCDN, this.I9);     // Catch: Exception -> L10
        r103.put("svc_type", r102.f459436e);     // Catch: Exception -> L10
        r103.put("p2p_xcdn_detail", r102.f459437f);     // Catch: Exception -> L10
        this.f459246zd.add(r103.toString());     // Catch: Exception -> L10
        r101 = r101 + 1;     // Catch: Exception -> L10
    L8:
        r100.put("segement_request", this.f459246zd.toString());     // Catch: Exception -> L10
    }

    private void addSessionStopInfo(JSONObject r210) {
        if (this.f459014h8 == 0) goto L150;
        LogBundle r100 = this.f459026i8;
        if (r100 == null) goto L151;
        this.f458980f.getSessionlogInfo(r100);
        if (this.f459009h3 == true) goto L10;
    L12:
        boolean r101 = false;
    L14:
        if (this.f459038j8 == true) goto L17;
        reportSessionFirstFrame(r210, 0, 0);
    L17:
        if (this.f459038j8 == false) goto L19;
        long r102 = System.currentTimeMillis() - this.f459064l8;
        computeDisplayTime();
        this.Pd += r102;
        long r110 = 0;
    L21:
        if (this.f459038j8 == true) goto L23;
        long r103 = 0;
    L27:
        this.f459115p8++;
        long r111 = this.f459201w8;
        if (r111 <= 0) goto L30;
        long r112 = r111 - this.f459064l8;
        long r104 = this.f459215x8 - r111;
    L32:
        if (isStalling() == false) goto L37;
        this.f459127q8++;
        long r211 = r102;
        if (this.f459122q3 < this.f459052k8) goto L36;
        this.f459139r8 += System.currentTimeMillis() - this.f459122q3;
    L38:
        calculateSessionRenderFailType();
        if (this.W2.equals(OnekeyLoginConstants.NETWORK_TYPE_MOBILE_STR) == false) goto L43;
        if (this.f458968e.f459282f3 != (-1)) goto L43;
    L44:
        this.f458917a3 += this.f459026i8.f459349t0;
        this.f458932b3 += r211;
    L45:
        LogBundle r105 = this.f459026i8;
        long r106 = r105.f459349t0;
        long r113 = r105.f459354u0;
        if (this.f459206wd != 1) goto L53;
        long r114 = this.G6;
        if (r114 == 0) goto L50;
        r106 = r114;
    L50:
        long r115 = this.H6;
        if (r115 == 0) goto L53;
        long r116 = r115;
    L54:
        if (r210 != null) goto L148;
    L146:
        resetSessionInfo();
        return;
    L148:
        JSONObject r117 = r210.put("index", this.f459115p8);     // Catch: JSONException -> L144
        if (this.f459038j8 == false) goto L58;
        int r107 = 1;
    L59:
        long r212 = r116;
        JSONObject r108 = r117.put("session_stop_is_stream_received", r107).put("session_stop_render_fail_type", this.f459229y8).put("session_stop_code", this.f459241z8).put("session_stop_stall_count", this.f459127q8).put("session_stop_stall_time", this.f459139r8).put("session_stop_audio_render_stall_count", this.f459175u8).put("session_stop_audio_render_stall_time", this.f459189v8).put("session_stop_video_render_stall_count", this.f459151s8).put("session_stop_video_render_stall_time", this.f459163t8).put("session_stop_start", this.f459052k8).put("sdk_dns_analysis_end", this.f459026i8.f459258b).put("player_dns_analysis_end", this.f459026i8.f459268d).put("http_req_finish_time", this.f459026i8.f459309l0).put("http_res_finish_time", this.f459026i8.f459314m0).put("tcp_first_package_end", this.f458968e.f459303k).put("first_video_package_end", this.f459026i8.f459308l).put("first_audio_package_end", this.f459026i8.f459313m).put("first_video_frame_decode_end", this.f459026i8.f459318n).put("first_audio_frame_decode_end", this.f459026i8.f459323o).put("video_device_open_start", this.f459026i8.f459348t).put("video_device_open_end", this.f459026i8.f459353u).put("audio_device_open_start", this.f459026i8.f459358v).put("audio_device_open_end", this.f459026i8.f459363w).put("video_device_wait_start", this.f459026i8.f459355u1).put("video_device_wait_end", this.f459026i8.f459360v1).put("find_stream_info_start", this.f459026i8.f459345s1).put("find_stream_info_end", this.f459026i8.f459350t1).put("video_param_send_outlet_time", this.f459026i8.f459330p1).put("first_video_frame_send_outlet_time", this.f459026i8.f459335q1).put("first_frame_render_end", this.f459064l8).put("first_audio_frame_end", this.f459088n8).put("prepare_end", this.f459026i8.f459343s).put("prepare_block_end", this.f459026i8.f459263c).put("video_first_pkt_pos", this.f459026i8.f459279f0).put("video_first_pkt_pts", this.f459026i8.f459284g0).put("audio_first_pkt_pos", this.f459026i8.f459289h0).put("audio_first_pkt_pts", this.f459026i8.f459294i0).put("video_render_type", this.f459026i8.f459340r1).put("download_speed", this.f459026i8.f459255a1).put("video_buffer_time", this.f459026i8.f459260b1).put("audio_buffer_time", this.f459026i8.f459265c1);     // Catch: JSONException -> L144
        if (this.f459026i8.f459270d1 <= 0) goto L62;
        long r118 = this.f458968e.f459270d1;     // Catch: JSONException -> L144
    L63:
        JSONObject r109 = r108.put("wait_time", r118);     // Catch: JSONException -> L144
        if (this.f459026i8.f459270d1 < 0) goto L66;
        int r119 = 0;
    L67:
        JSONObject r120 = r109.put("is_waiting", r119).put("session_stop_first_stall_time", r112).put("session_stop_first_stall_duration", r104).put("session_stop_play_time_on_no_frame", r110).put("session_stop_total_download_size", r106).put("drop_audio_pts_diff", this.f459026i8.f459299j0).put("drop_audio_cost", this.f459026i8.f459304k0).put("session_stop_first_sei_delay", this.f459026i8.f459290h1).put("session_stop_room_play_time_ms", r103).put("session_stop_error_msg", this.A8).put("session_stop_play_size", r212);     // Catch: JSONException -> L144
        if (this.H9 <= 0) goto L70;
        long r121 = this.f459026i8.f459359v0;     // Catch: JSONException -> L144
    L71:
        JSONObject r122 = r120.put("session_stop_http_flow_size", r121);     // Catch: JSONException -> L144
        if (this.H9 <= 0) goto L74;
        long r123 = this.f459026i8.f459364w0;     // Catch: JSONException -> L144
    L75:
        JSONObject r124 = r122.put("session_stop_p2p_flow_size", r123);     // Catch: JSONException -> L144
        if (this.H9 <= 0) goto L78;
        long r125 = this.f459026i8.f459374y0;     // Catch: JSONException -> L144
    L79:
        JSONObject r126 = r124.put("session_stop_p2p_mobile_flow_size", r125).put("session_stop_httpio_play_time", this.f459026i8.f459379z0).put("session_stop_p2pio_play_time", this.f459026i8.A0).put("multipath_cellular_flow_size", this.f459026i8.E0).put("multipath_running_status", this.f459026i8.D0).put("switch_cellular_reason", this.f459026i8.f459277e3).put("switch_cellular_detail", this.f459026i8.f459287g3).put("switch_cellular_result", this.f459026i8.f459297i3).put("switch_default_reason", this.f459026i8.f459282f3).put("switch_default_detail", this.f459026i8.f459292h3).put("switch_default_result", this.f459026i8.f459302j3).put("session_stop_cellular_total_download_size", this.f458917a3).put("session_stop_cellular_play_time", this.f458932b3);     // Catch: JSONException -> L144
        if (r101 == false) goto L82;
        int r127 = 1;
    L83:
        JSONObject r128 = r126.put("session_stop_is_first_play", r127).put("session_stop_p2p_flv_detail", this.Oc);     // Catch: JSONException -> L144
        if (this.H9 <= 0) goto L86;
        long r129 = this.f459026i8.F0;     // Catch: JSONException -> L144
    L87:
        JSONObject r130 = r128.put("session_stop_http_patch_dts_size", r129);     // Catch: JSONException -> L144
        if (this.H9 <= 0) goto L90;
        long r131 = this.f459026i8.G0;     // Catch: JSONException -> L144
    L91:
        r130.put("session_stop_http_substream_size", r131).put("session_stop_live_stream_session_id", this.R2).put("session_stop_play_time", r211);     // Catch: JSONException -> L144
        if (this.f459133r != null) goto L96;
        r210.put("tcp_connect_end", this.f459026i8.f459278f);     // Catch: JSONException -> L144
    L100:
        addStreamVersion(r210);     // Catch: JSONException -> L144
        if (isRtcPlayAvailable() == false) goto L103;
        fixRtmSessionStopInfo(r210);     // Catch: JSONException -> L144
    L103:
        addDisplayModelInfo(r210);     // Catch: JSONException -> L144
        if (this.Bd != 1) goto L110;
        if (((ArrayList) this.f459234yd).size() >= 20) goto L108;
        addSegementRequest(r210);     // Catch: JSONException -> L144
    L108:
        r210.put("segement_count", ((ArrayList) this.f459234yd).size());     // Catch: JSONException -> L144
    L110:
        if (this.f459043jd != 1) goto L129;
        if (this.f459169u == false) goto L114;
        int r132 = 1;
    L115:
        JSONObject r133 = r210.put("ip_from_player_core", r132);     // Catch: JSONException -> L144
        if (this.R == false) goto L118;
        int r134 = 1;
    L119:
        JSONObject r135 = r133.put("open_dns_optimizer", r134);     // Catch: JSONException -> L144
        if (this.W == false) goto L122;
        int r136 = 1;
    L123:
        JSONObject r137 = r135.put("hit_node_optimize", r136).put("evaluator_symbol", this.S).put("lss_response_cost", this.T).put("lss_first_response_cost", this.U).put("lss_response_status_code", this.V);     // Catch: JSONException -> L144
        if (this.X == false) goto L126;
        int r138 = 1;
    L127:
        r137.put("remote_sorted", r138);     // Catch: JSONException -> L144
        goto L129
    L126:
        r138 = 0;
        goto L127
    L122:
        r136 = 0;
        goto L123
    L118:
        r134 = 0;
        goto L119
    L114:
        r132 = 0;
    L129:
        if (this.f459120pd == 1) goto L134;
        String r139 = this.A;     // Catch: JSONException -> L144
        if (r139 != null) goto L133;
        r139 = "none";
    L133:
        r210.put(OrderParamsKey.KEY_SDK_PARAM, r139);     // Catch: JSONException -> L144
    L134:
        this.f458980f.updateLiveIOMessage(r210);     // Catch: JSONException -> L144
        this.f459193vc++;     // Catch: JSONException -> L144
        if (this.f459167tc <= 0) goto L146;
        if (this.f459143rc.size() >= this.f459155sc) goto L139;
    L140:
        JSONObject r140 = getSessionStopStr(r210);     // Catch: JSONException -> L144
        if (r140 == null) goto L146;
        this.f459143rc.add(r140);     // Catch: JSONException -> L144
        goto L146
    L139:
        if (this.f459179uc == false) goto L146;
    L96:
        if ("kcp".equals(this.F5) == false) goto L98;
        long r141 = this.f459026i8.f459268d;     // Catch: JSONException -> L144
    L99:
        r210.put("tcp_connect_end", r141);     // Catch: JSONException -> L144
        goto L100
    L98:
        r141 = this.f459026i8.f459278f;     // Catch: JSONException -> L144
        goto L99
    L90:
        r131 = 0;
        goto L91
    L86:
        r129 = 0;
        goto L87
    L82:
        r127 = 0;
        goto L83
    L78:
        r125 = 0;
        goto L79
    L74:
        r123 = 0;
        goto L75
    L70:
        r121 = 0;
        goto L71
    L66:
        r119 = 1;
        goto L67
    L62:
        r118 = -this.f458968e.f459270d1;
        goto L63
    L58:
        r107 = 0;
    L144:
        e = move-exception;
        e.printStackTrace();
    L53:
        r116 = r113;
    L43:
        if (this.f458968e.f459277e3 == (-1)) goto L45;
    L36:
        this.f459139r8 += System.currentTimeMillis() - this.f459052k8;
        goto L38
    L37:
        r211 = r102;
        goto L38
    L30:
        r104 = 0;
        r112 = 0;
        goto L32
    L23:
        if (this.f458954cc == false) goto L25;
        r103 = this.f458978ec + (System.currentTimeMillis() - this.f458941bc);
        goto L27
    L25:
        r103 = this.f458978ec;
        goto L27
    L19:
        r110 = System.currentTimeMillis() - this.f459052k8;
        r102 = 0;
        goto L21
    L10:
        if (this.f459021i3 == true) goto L12;
        String r142 = this.R2;
        this.S2 = r142;
        this.f459021i3 = true;
        this.f459059l3 = r142;
        r101 = true;
        goto L14
    L151:
        return;
    }

    private void addSessionStopInfo_v2(JSONObject r210) {
        if (this.f459014h8 != 0) goto L5;
        return;
    L5:
        if (this.f459026i8 == null) goto L151;
        JSONObject r100 = new JSONObject();
        this.f458980f.getSessionlogInfo(this.f459026i8);     // Catch: JSONException -> L144
        if (this.f459009h3 == true) goto L11;
    L13:
        boolean r101 = false;
    L15:
        if (this.f459038j8 == true) goto L18;
        reportSessionFirstFrame(r210, 0, 0);     // Catch: JSONException -> L144
    L18:
        if (this.f459038j8 == false) goto L20;
        long r102 = System.currentTimeMillis() - this.f459064l8;     // Catch: JSONException -> L144
        computeDisplayTime();     // Catch: JSONException -> L144
        this.Pd += r102;     // Catch: JSONException -> L144
        long r110 = 0;
    L22:
        if (this.f459038j8 == true) goto L24;
        long r103 = 0;
    L28:
        this.f459115p8++;     // Catch: JSONException -> L144
        long r111 = this.f459201w8;     // Catch: JSONException -> L144
        if (r111 <= 0) goto L31;
        long r104 = r111 - this.f459064l8;     // Catch: JSONException -> L144
        long r105 = this.f459215x8 - r111;     // Catch: JSONException -> L144
    L33:
        if (isStalling() == false) goto L38;
        this.f459127q8++;     // Catch: JSONException -> L144
        long r211 = r110;
        if (this.f459122q3 < this.f459052k8) goto L37;
        this.f459139r8 += System.currentTimeMillis() - this.f459122q3;     // Catch: JSONException -> L144
    L39:
        calculateSessionRenderFailType();     // Catch: JSONException -> L144
        if (this.W2.equals(OnekeyLoginConstants.NETWORK_TYPE_MOBILE_STR) == false) goto L44;
        if (this.f458968e.f459282f3 != (-1)) goto L44;
    L45:
        this.f458917a3 += this.f459026i8.f459349t0;     // Catch: JSONException -> L144
        this.f458932b3 += r102;     // Catch: JSONException -> L144
    L46:
        LogBundle r106 = this.f459026i8;     // Catch: JSONException -> L144
        long r112 = r106.f459349t0;     // Catch: JSONException -> L144
        long r107 = r106.f459354u0;     // Catch: JSONException -> L144
        if (this.f459206wd != 1) goto L54;
        long r113 = this.G6;     // Catch: JSONException -> L144
        if (r113 == 0) goto L51;
        r112 = r113;
    L51:
        long r114 = this.H6;     // Catch: JSONException -> L144
        if (r114 == 0) goto L54;
        r107 = r114;
    L54:
        JSONObject r115 = r100.put("index", this.f459115p8);     // Catch: JSONException -> L144
        if (this.f459038j8 == false) goto L57;
        int r116 = 1;
    L58:
        JSONObject r117 = r115.put("is_stream_received", r116).put("render_fail_type", this.f459229y8).put("code", this.f459241z8).put("stall_count", this.f459127q8).put("stall_time", this.f459139r8).put("audio_render_stall_count", this.f459175u8).put("audio_render_stall_time", this.f459189v8).put("video_render_stall_count", this.f459151s8).put("video_render_stall_time", this.f459163t8).put("start", this.f459052k8).put("sdk_dns_analysis_end", this.f459026i8.f459258b).put("player_dns_analysis_end", this.f459026i8.f459268d).put("http_req_finish_time", this.f459026i8.f459309l0).put("http_res_finish_time", this.f459026i8.f459314m0).put("tcp_first_package_end", this.f458968e.f459303k).put("first_video_package_end", this.f459026i8.f459308l).put("first_audio_package_end", this.f459026i8.f459313m).put("first_video_frame_decode_end", this.f459026i8.f459318n).put("first_audio_frame_decode_end", this.f459026i8.f459323o).put("video_device_open_start", this.f459026i8.f459348t).put("video_device_open_end", this.f459026i8.f459353u).put("audio_device_open_start", this.f459026i8.f459358v).put("audio_device_open_end", this.f459026i8.f459363w).put("video_device_wait_start", this.f459026i8.f459355u1).put("video_device_wait_end", this.f459026i8.f459360v1).put("find_stream_info_start", this.f459026i8.f459345s1).put("find_stream_info_end", this.f459026i8.f459350t1).put("video_param_send_outlet_time", this.f459026i8.f459330p1).put("first_video_frame_send_outlet_time", this.f459026i8.f459335q1).put("first_frame_render_end", this.f459064l8).put("first_audio_frame_end", this.f459088n8).put("prepare_end", this.f459026i8.f459343s).put("prepare_block_end", this.f459026i8.f459263c).put("video_first_pkt_pos", this.f459026i8.f459279f0).put("video_first_pkt_pts", this.f459026i8.f459284g0).put("audio_first_pkt_pos", this.f459026i8.f459289h0).put("audio_first_pkt_pts", this.f459026i8.f459294i0).put("video_render_type", this.f459026i8.f459340r1).put("download_speed", this.f459026i8.f459255a1).put("video_buffer_time", this.f459026i8.f459260b1).put("audio_buffer_time", this.f459026i8.f459265c1);     // Catch: JSONException -> L144
        if (this.f459026i8.f459270d1 <= 0) goto L61;
        long r118 = this.f458968e.f459270d1;     // Catch: JSONException -> L144
    L62:
        JSONObject r119 = r117.put("wait_time", r118);     // Catch: JSONException -> L144
        if (this.f459026i8.f459270d1 < 0) goto L65;
        int r120 = 0;
    L66:
        JSONObject r108 = r119.put("is_waiting", r120).put("first_stall_time", r104).put("first_stall_duration", r105).put("play_time_on_no_frame", r211).put("total_download_size", r112).put("drop_audio_pts_diff", this.f459026i8.f459299j0).put("drop_audio_cost", this.f459026i8.f459304k0).put("first_sei_delay", this.f459026i8.f459290h1).put("room_play_time_ms", r103).put("error_msg", this.A8).put("play_size", r107);     // Catch: JSONException -> L144
        if (this.H9 <= 0) goto L69;
        long r109 = this.f459026i8.f459359v0;     // Catch: JSONException -> L144
    L70:
        JSONObject r121 = r108.put("http_flow_size", r109);     // Catch: JSONException -> L144
        if (this.H9 <= 0) goto L73;
        long r122 = this.f459026i8.f459364w0;     // Catch: JSONException -> L144
    L74:
        JSONObject r123 = r121.put("p2p_flow_size", r122);     // Catch: JSONException -> L144
        if (this.H9 <= 0) goto L77;
        long r124 = this.f459026i8.f459374y0;     // Catch: JSONException -> L144
    L78:
        JSONObject r125 = r123.put("p2p_mobile_flow_size", r124).put("httpio_play_time", this.f459026i8.f459379z0).put("p2pio_play_time", this.f459026i8.A0).put("multipath_cellular_flow_size", this.f459026i8.E0).put("multipath_running_status", this.f459026i8.D0).put("switch_cellular_reason", this.f459026i8.f459277e3).put("switch_cellular_detail", this.f459026i8.f459287g3).put("switch_cellular_result", this.f459026i8.f459297i3).put("switch_default_reason", this.f459026i8.f459282f3).put("switch_default_detail", this.f459026i8.f459292h3).put("switch_default_result", this.f459026i8.f459302j3).put("cellular_total_download_size", this.f458917a3).put("cellular_play_time", this.f458932b3);     // Catch: JSONException -> L144
        if (r101 == false) goto L81;
        int r126 = 1;
    L82:
        JSONObject r127 = r125.put("is_first_play", r126).put("p2p_flv_detail", this.Oc);     // Catch: JSONException -> L144
        if (this.H9 <= 0) goto L85;
        long r128 = this.f459026i8.F0;     // Catch: JSONException -> L144
    L86:
        JSONObject r129 = r127.put("http_patch_dts_size", r128);     // Catch: JSONException -> L144
        if (this.H9 <= 0) goto L89;
        long r130 = this.f459026i8.G0;     // Catch: JSONException -> L144
    L90:
        r129.put("http_substream_size", r130).put("live_stream_session_id", this.R2).put(HistoryTableOperate.HISTORY_PLAY_TIME, r102);     // Catch: JSONException -> L144
        if (this.f459133r != null) goto L95;
        r100.put("tcp_connect_end", this.f459026i8.f459278f);     // Catch: JSONException -> L144
    L99:
        addStreamVersion(r100);     // Catch: JSONException -> L144
        if (isRtcPlayAvailable() == false) goto L102;
        fixRtmSessionStopInfo(r100);     // Catch: JSONException -> L144
    L102:
        addDisplayModelInfo(r100);     // Catch: JSONException -> L144
        if (this.Bd != 1) goto L109;
        if (((ArrayList) this.f459234yd).size() >= 20) goto L107;
        addSegementRequest(r100);     // Catch: JSONException -> L144
    L107:
        r100.put("segement_count", ((ArrayList) this.f459234yd).size());     // Catch: JSONException -> L144
    L109:
        if (this.f459043jd != 1) goto L128;
        if (this.f459169u == false) goto L113;
        int r131 = 1;
    L114:
        JSONObject r132 = r100.put("ip_from_player_core", r131);     // Catch: JSONException -> L144
        if (this.R == false) goto L117;
        int r133 = 1;
    L118:
        JSONObject r134 = r132.put("open_dns_optimizer", r133);     // Catch: JSONException -> L144
        if (this.W == false) goto L121;
        int r135 = 1;
    L122:
        JSONObject r136 = r134.put("hit_node_optimize", r135).put("evaluator_symbol", this.S).put("lss_response_cost", this.T).put("lss_first_response_cost", this.U).put("lss_response_status_code", this.V);     // Catch: JSONException -> L144
        if (this.X == false) goto L125;
        int r137 = 1;
    L126:
        r136.put("remote_sorted", r137);     // Catch: JSONException -> L144
        goto L128
    L125:
        r137 = 0;
        goto L126
    L121:
        r135 = 0;
        goto L122
    L117:
        r133 = 0;
        goto L118
    L113:
        r131 = 0;
    L128:
        if (this.f459120pd == 1) goto L133;
        String r138 = this.A;     // Catch: JSONException -> L144
        if (r138 != null) goto L132;
        r138 = "none";
    L132:
        r100.put(OrderParamsKey.KEY_SDK_PARAM, r138);     // Catch: JSONException -> L144
    L133:
        this.f458980f.updateLiveIOMessage(r100);     // Catch: JSONException -> L144
        this.f459193vc++;     // Catch: JSONException -> L144
        if (this.f459167tc > 0) goto L136;
    L142:
        r210.put("session_stop_info", r100);     // Catch: JSONException -> L144
    L146:
        resetSessionInfo();
        return;
    L136:
        if (this.f459143rc.size() >= this.f459155sc) goto L138;
    L139:
        JSONObject r139 = getSessionStopStr(r100);     // Catch: JSONException -> L144
        if (r139 == null) goto L142;
        this.f459143rc.add(r139);     // Catch: JSONException -> L144
        goto L142
    L138:
        if (this.f459179uc == false) goto L142;
    L95:
        if ("kcp".equals(this.F5) == false) goto L97;
        long r140 = this.f459026i8.f459268d;     // Catch: JSONException -> L144
    L98:
        r100.put("tcp_connect_end", r140);     // Catch: JSONException -> L144
        goto L99
    L97:
        r140 = this.f459026i8.f459278f;     // Catch: JSONException -> L144
        goto L98
    L89:
        r130 = 0;
        goto L90
    L85:
        r128 = 0;
        goto L86
    L81:
        r126 = 0;
        goto L82
    L77:
        r124 = 0;
        goto L78
    L73:
        r122 = 0;
        goto L74
    L69:
        r109 = 0;
        goto L70
    L65:
        r120 = 1;
        goto L66
    L61:
        r118 = -this.f458968e.f459270d1;
        goto L62
    L57:
        r116 = 0;
    L44:
        if (this.f458968e.f459277e3 == (-1)) goto L46;
    L37:
        this.f459139r8 += System.currentTimeMillis() - this.f459052k8;     // Catch: JSONException -> L144
        goto L39
    L38:
        r211 = r110;
        goto L39
    L31:
        r104 = 0;
        r105 = 0;
        goto L33
    L24:
        if (this.f458954cc == false) goto L26;
        r103 = this.f458978ec + (System.currentTimeMillis() - this.f458941bc);     // Catch: JSONException -> L144
        goto L28
    L26:
        r103 = this.f458978ec;     // Catch: JSONException -> L144
        goto L28
    L20:
        r110 = System.currentTimeMillis() - this.f459052k8;     // Catch: JSONException -> L144
        r102 = 0;
        goto L22
    L11:
        if (this.f459021i3 == true) goto L13;
        String r141 = this.R2;     // Catch: JSONException -> L144
        this.S2 = r141;     // Catch: JSONException -> L144
        this.f459021i3 = true;     // Catch: JSONException -> L144
        this.f459059l3 = r141;     // Catch: JSONException -> L144
        r101 = true;
    L144:
        e = move-exception;
        e.printStackTrace();
        goto L146
    }

    private void addStreamVersion(JSONObject r100) throws JSONException {
        long r101 = this.f458980f.getStreamVersion();
        if (r101 < 0) goto L6;
        r100.put("stream_version", r101);
        return;
    }

    private void addUniqueIDToEvent(JSONObject r100) {
        if (r100 == null) goto L10;
        r100.put("app_session_uuid", VideoLiveManager.sAppSessionUUID).put("event_index", VideoLiveManager.sUploadLogEventIndex.incrementAndGet());     // Catch: JSONException -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    private void addViewResolutionInfo(JSONObject r100) throws JSONException {
        r100.put("view_width", this.f458980f.getVideoRenderViewWidth());
        r100.put("view_height", this.f458980f.getVideoRenderViewHeight());
    }

    private JSONObject configP2PInfo(JSONArray r510) {
        LiveLoggerService r100 = this;
        JSONObject r101 = new JSONObject();
        int r102 = 0;
        long r103 = 0;
        long r104 = 0;
        long r105 = 0;
        long r110 = 0;
        long r111 = 0;
        long r112 = 0;
        long r113 = 0;
    L42:
        long r210 = r112;
        JSONObject r114 = r101;
        long r211 = r111;
        long r212 = r110;
        long r213 = r105;
        long r214 = r104;
        long r310 = r103;
        if (r102 >= r510.length()) goto L23;
        String r311 = "first_time_h2p_buffer";
        JSONObject r106 = JSONArrayProtectorUtils.getJSONObject(r510, r102);     // Catch: JSONException -> L21
        int r107 = ((Integer) cnc.c.getParam(r106, Integer.valueOf(r100.f458942bd), "exception_code")).intValue();     // Catch: JSONException -> L21
        r100.f458942bd = r107;     // Catch: JSONException -> L21
        if (r107 == 1) goto L9;
        long r108 = ((Long) cnc.c.getParam(r106, 0L, "httpio_play_time")).longValue();     // Catch: JSONException -> L21
        long r312 = ((Long) cnc.c.getParam(r106, 0L, "p2pio_play_time")).longValue();     // Catch: JSONException -> L21
        long r109 = ((Long) cnc.c.getParam(r106, -1L, "group_id")).longValue();     // Catch: JSONException -> L21
        int r313 = r102;
        long r115 = ((Long) cnc.c.getParam(r106, -1L, "group_reason")).longValue();     // Catch: JSONException -> L19
        long r116 = ((Long) cnc.c.getParam(r106, -1L, "group_enter_reason")).longValue();     // Catch: JSONException -> L19
        long r117 = ((Long) cnc.c.getParam(r106, -1L, "p2p_onlines")).longValue();     // Catch: JSONException -> L19
        long r118 = ((Long) cnc.c.getParam(r106, 0L, "http_flow_size")).longValue();     // Catch: JSONException -> L19
        long r314 = ((Long) cnc.c.getParam(r106, 0L, "p2p_flow_size")).longValue();     // Catch: JSONException -> L19
        long r119 = ((Long) cnc.c.getParam(r106, 0L, "p2p_mobile_flow_size")).longValue();     // Catch: JSONException -> L19
        long r120 = ((Long) cnc.c.getParam(r106, 0L, "buffer_not_satify_p2p_times")).longValue();     // Catch: JSONException -> L19
        long r121 = ((Long) cnc.c.getParam(r106, 0L, "buffer_not_satify_p2p_value")).longValue();     // Catch: JSONException -> L19
        long r122 = ((Long) cnc.c.getParam(r106, 0L, r311)).longValue();     // Catch: JSONException -> L19
        long r410 = r108 + r312;
        r103 = r310 + r108;
        long r215 = r214 + r312;
        long r123 = r213 + r118;
        long r216 = r212 + r314;
        long r124 = r211 + r119;
        long r125 = r120 + r210;
        if (r410 <= r113) goto L17;
        LiveLoggerService r126 = this;
        r126.Rc = r109;     // Catch: JSONException -> L30
        r126.Sc = r115;     // Catch: JSONException -> L30
        r126.Tc = r116;     // Catch: JSONException -> L30
        r126.Uc = r117;     // Catch: JSONException -> L30
        r126.Zc = r121;     // Catch: JSONException -> L30
        r126.f458927ad = r122;     // Catch: JSONException -> L30
        r113 = r410;
    L18:
        r102 = r313 + 1;     // Catch: JSONException -> L30
        r100 = r126;
        r105 = r123;
        r111 = r124;
        r110 = r216;
        r104 = r215;
        r101 = r114;
        r112 = r125;
    L30:
        e = e;
    L31:
        JSONObject r127 = r114;
    L34:
        e.printStackTrace();
    L35:
        return r127;
    L17:
        r126 = this;
    L19:
        e = e;
        goto L31
    L9:
        String r128 = "p2p_mobile_flow_size";
    L24:
        r100.Pc = r310;     // Catch: JSONException -> L30
        r100.Qc = r214;     // Catch: JSONException -> L30
        r100.Vc = r213;     // Catch: JSONException -> L30
        r100.Wc = r212;     // Catch: JSONException -> L30
        r100.Xc = r211;     // Catch: JSONException -> L30
        r100.Yc = r210;     // Catch: JSONException -> L30
        calibratePlayTime();     // Catch: JSONException -> L30
        int r129 = r100.f458942bd;     // Catch: JSONException -> L30
        r127 = r114;
        r127.put("exception_code", r129);     // Catch: JSONException -> L28
        r127.put("httpio_play_time", r100.Pc);     // Catch: JSONException -> L28
        r127.put("p2pio_play_time", r100.Qc);     // Catch: JSONException -> L28
        r127.put("group_id", r100.Rc);     // Catch: JSONException -> L28
        r127.put("group_reason", r100.Sc);     // Catch: JSONException -> L28
        r127.put("group_enter_reason", r100.Tc);     // Catch: JSONException -> L28
        r127.put("p2p_onlines", r100.Uc);     // Catch: JSONException -> L28
        r127.put("http_flow_size", r100.Vc);     // Catch: JSONException -> L28
        r127.put("p2p_flow_size", r100.Wc);     // Catch: JSONException -> L28
        r127.put(r128, r100.Xc);     // Catch: JSONException -> L28
        r127.put("buffer_not_satify_p2p_times", r100.Yc);     // Catch: JSONException -> L28
        r127.put("buffer_not_satify_p2p_value", r100.Zc);     // Catch: JSONException -> L28
        String r130 = r311;
        r127.put(r130, r100.f458927ad);     // Catch: JSONException -> L28
        r127.put("http_patch_dts_size", r100.f458955cd);     // Catch: JSONException -> L28
        r127.put("http_substream_size", r100.f458967dd);     // Catch: JSONException -> L28
        r127.put("session_id", r100.R2);     // Catch: JSONException -> L28
    L28:
        e = e;
    L21:
        e = e;
        goto L31
    L23:
        r311 = "first_time_h2p_buffer";
        r128 = "p2p_mobile_flow_size";
    L32:
        e = e;
        r127 = r101;
        goto L34
    }

    private JSONObject configTrafficInfo(long r100) {
        JSONObject r101 = new JSONObject();
        if (this.f459038j8 == false) goto L5;
        long r102 = System.currentTimeMillis() - this.f459064l8;
    L16:
    L13:
        e = move-exception;
        e.printStackTrace();
    L15:
        return r101;
    L8:
        if (this.f458942bd != 1) goto L10;
        r101.put("exception_code", 1);     // Catch: JSONException -> L13
    L11:
        r101.put("httpio_play_time", r102);     // Catch: JSONException -> L13
        r101.put("p2pio_play_time", 0);     // Catch: JSONException -> L13
        r101.put("group_id", 0);     // Catch: JSONException -> L13
        r101.put("group_reason", 0);     // Catch: JSONException -> L13
        r101.put("group_enter_reason", 0);     // Catch: JSONException -> L13
        r101.put("p2p_onlines", 0);     // Catch: JSONException -> L13
        r101.put("http_flow_size", r100);     // Catch: JSONException -> L13
        r101.put("p2p_flow_size", 0);     // Catch: JSONException -> L13
        r101.put("p2p_mobile_flow_size", 0);     // Catch: JSONException -> L13
        r101.put("buffer_not_satify_p2p_times", 0);     // Catch: JSONException -> L13
        r101.put("buffer_not_satify_p2p_value", 0);     // Catch: JSONException -> L13
        r101.put("first_time_h2p_buffer", 0);     // Catch: JSONException -> L13
        r101.put("http_patch_dts_size", 0);     // Catch: JSONException -> L13
        r101.put("http_substream_size", 0);     // Catch: JSONException -> L13
        r101.put("session_id", this.R2);     // Catch: JSONException -> L13
        goto L15
    L10:
        r101.put("exception_code", 3);     // Catch: JSONException -> L13
        goto L11
    L5:
        r102 = 0;
        goto L16
    }

    private JSONObject createSessionFirstFrameLog(LogBundle r100) throws JSONException {
        JSONObject r101 = createCommonLog();
        if (r101 == null) goto L43;
        JSONObject r102 = r101.put(LiveCommonConstants.LOG_PARAM_EVENT_KEY, "session_first_frame").put("total_cost", r100.f459328p - r100.f459253a).put("start", this.f459026i8.f459253a).put("sdk_dns_analysis_end", r100.f459258b).put("prepare_block_end", r100.f459263c);
        long r103 = r100.f459368x;
        if (r103 > 0) goto L7;
        r103 = r100.f459268d;
    L7:
        JSONObject r104 = r102.put("tfo_fall_back_time", r103).put("pre_connect", this.K4).put("request_cdn_cached", r100.f459324o0).put("request_time_to_source", r100.f459334q0).put("request_time_for_cdn", r100.f459344s0).put("http_req_finish_time", r100.f459309l0).put("http_res_finish_time", r100.f459314m0).put("first_video_package_end", r100.f459308l).put("first_audio_package_end", r100.f459313m).put("first_video_frame_decode_end", r100.f459318n).put("first_audio_frame_decode_end", r100.f459323o).put("first_frame_from_player_core", r100.f459338r).put("first_frame_render_end", r100.f459328p).put("video_param_send_outlet_time", r100.f459330p1).put("first_video_frame_send_outlet_time", r100.f459335q1).put("set_surface_time", this.f459198w5).put("set_surface_cost", this.f459186v5).put("video_render_type", r100.f459340r1).put("video_device_open_start", r100.f459348t).put("video_device_open_end", r100.f459353u).put("audio_device_open_start", r100.f459358v).put("audio_device_open_end", r100.f459363w).put("video_device_wait_start", r100.f459355u1).put("video_device_wait_end", r100.f459360v1).put("find_stream_info_start", r100.f459345s1).put("find_stream_info_end", r100.f459350t1).put("video_first_pkt_pos", r100.f459279f0).put("video_first_pkt_pts", r100.f459284g0).put("audio_first_pkt_pos", r100.f459289h0).put("audio_first_pkt_pts", r100.f459294i0).put("video_buffer_time", r100.Y0).put("audio_buffer_time", r100.Z0).put("download_speed", r100.Q0).put("first_sei_delay", r100.f459280f1).put("response_header_X-Server-IP", r100.f459375y1).put("response_header_Via", r100.f459380z1).put("prepare_end", r100.f459343s).put("drop_audio_pts_diff", r100.f459299j0).put("drop_audio_cost", r100.f459304k0).put("enable_tcp_fast_open", this.f458921a7).put("tfo_success", r100.C2).put("abr_check_enhance", this.f459138r7);
        if (this.f458949c7 != null) goto L10;
        JSONArray r105 = new JSONArray();
    L11:
        r104.put("optimize_backup_ips", r105).put("suggest_format", this.E5).put("suggest_protocol", this.G5).put("suggest_access_code", this.L5).put(IVideoEventLogger.LOG_CALLBACK_CONTAINER_FPS, this.C5).put("used_drm", this.f459078ma).put("ipv6_probe_result", r100.F2).put("http_open_start", r100.f459283g).put("trans_open_start", r100.f459288h).put("socket_create_end", r100.f459293i).put("3xx_happen_time", r100.f459298j).put("trans_strategy_params", this.Da).put("trans_params_bandwidth", this.Ea).put("trans_params_bandwidth_decision", this.Fa).put("is_free_flow", this.Q).put("enable_fast_first_frame", this.T5).put("preplay_enter_room_timestamp", this.f459004gc).put("event_key_index", f458909fe.incrementAndGet()).put("UseRedirectedIp", this.L4).put("UsePreconnectIp", this.N4);
        long r106 = this.f459004gc;
        if (r106 == (-1)) goto L17;
        long r107 = r100.f459318n;
        if (r106 <= r107) goto L17;
        this.f459018hc = r106 - r107;
    L17:
        if (r106 == (-1)) goto L20;
        c.i("LiveLoggerService", "preplay enter room at: " + this.f459004gc + ", wait cost: " + this.f459018hc);
    L20:
        if (this.f459078ma != 1) goto L23;
        r101.put("drm_get_secret_key_end", this.f459090na);
    L23:
        if (isRtcPlayAvailable() == false) goto L25;
    L32:
        r101.put("player_dns_analysis_end", this.H7);
        r101.put("rtc_use_sdk_dns", this.G7);
        r101.put("tcp_connect_end", this.I7);
        r101.put("rtc_tls_handshake_end", this.J7);
        r101.put("tcp_first_package_end", this.K7);
        r101.put("rtc_inited_end", r100.f459296i2);
        r101.put("rtc_offer_send_end", r100.f459316m2);
        r101.put("rtc_answer_recv_end", r100.f459321n2);
        r101.put("rtc_ice_connected_time", r100.f459336q2);
        r101.put("rtc_start_end", r100.f459341r2);
        r101.put("rtc_preload_result", getRTCPreloadingState());
        r101.put("first_audio_frame_decode_start", r100.f459361v2);
        r101.put("first_video_frame_decode_start", r100.f459356u2);
        r101.put("first_audio_frame_end", r100.f459351t2);
        r101.put("first_video_frame_end", r100.f459346s2);
        if (isRtmv3() == false) goto L35;
        r101.put("player_open_input_start", r100.f459273e);
    L35:
        int r108 = this.K2;
        if (r108 == (-1)) goto L39;
        r101.put("audio_timescale_enable", r108);
    L39:
        if (this.f459113p6 == false) goto L41;
        r101.put("abr_startup_bitrate", r100.X0);
        r101.put("abr_request_url", r100.f459267c3);
    L41:
        addStreamVersion(r101);
        return r101;
    L25:
        if (isRtmv3() == true) goto L32;
        r101.put("player_dns_analysis_end", r100.f459268d);
        r101.put("player_open_input_start", r100.f459273e);
        if ("kcp".equals(this.F5) == false) goto L30;
        long r109 = r100.f459268d;
    L31:
        r101.put("tcp_connect_end", r109);
        r101.put("tcp_first_package_end", r100.f459303k);
        goto L35
    L30:
        r109 = r100.f459278f;
        goto L31
    L10:
        r105 = new JSONArray(this.f458949c7);
        goto L11
    L43:
        return null;
    }

    private boolean enableApplogReportEvent(JSONObject r100) {
        g r101 = this.f459011h5;
        if (r101 == null) goto L32;
        if (r100 == null) goto L32;
    L30:
        th = move-exception;
        c.e("LiveLoggerService", "report ex=" + th);
        goto L32
    L7:
        if (this.f459030ic == true) goto L12;
        boolean r102 = ((Boolean) r101.getSettingsValueForKey("live_setting_applog_key", Boolean.FALSE)).booleanValue();     // Catch: Throwable -> L30
        this.f459030ic = r102;     // Catch: Throwable -> L30
        if (r102 == true) goto L12;
        return false;
    L12:
        if (this.f459031id != 1) goto L15;
        return true;
    L15:
        if (this.f459042jc != 0) goto L18;
        this.f459042jc = ((Integer) r101.getSettingsValueForKey("live_setting_enable_applog_event_key", 0)).intValue();     // Catch: Throwable -> L30
    L18:
        if (this.f459042jc != 0) goto L20;
        return true;
    L20:
        Object r103 = r100.get(LiveCommonConstants.LOG_PARAM_EVENT_KEY);     // Catch: Throwable -> L30
        if (r103 == null) goto L32;
        if ((r103 instanceof String) == false) goto L32;
        Integer r104 = f458914ke.get(r103);     // Catch: Throwable -> L30
        if (r104 == null) goto L32;
        if ((r104.intValue() & this.f459042jc) <= 0) goto L32;
        return true;
    L32:
        return false;
    }

    private void fixRtmSessionStopInfo(JSONObject r100) {
        if (isRtmSessionStopEnable() == false) goto L21;
        if (r100 == null) goto L23;
        this.f458980f.getRTMSessionLogInfo(this.f459200w7);     // Catch: JSONException -> L16
        r100.put(ILoadStallMonitor.START_TIME, this.f458968e.f459253a).put("sdk_session_start", this.f459200w7.f459291h2).put("sdk_dns_end", this.f459200w7.f459258b).put("rtm_init_end", this.f459200w7.f459296i2).put("rtm_signal_offer_created", this.f459200w7.f459301j2).put("rtm_signal_dns_analysis_end", this.f459200w7.f459306k2).put("rtm_signal_transport_connected", this.f459200w7.f459311l2).put("rtm_signal_offer_sent", this.f459200w7.f459316m2).put("rtm_signal_answer_received", this.f459200w7.f459321n2).put("rtm_signal_answer_updated", this.f459200w7.f459326o2).put("rtc_start_end", this.f459200w7.f459341r2).put("rtm_data_ice_connect_start", this.f459200w7.f459331p2).put("rtm_data_ice_connected", this.f459200w7.f459336q2).put("rtm_data_first_video_packet", this.f459200w7.f459308l).put("rtm_data_first_audio_packet", this.f459200w7.f459313m).put("rtm_data_first_video_frame_end", this.f459200w7.f459346s2).put("rtm_data_first_audio_frame_end", this.f459200w7.f459351t2).put("rtm_data_first_video_frame_decode_start", this.f459200w7.f459356u2).put("rtm_data_first_audio_frame_decode_start", this.f459200w7.f459361v2).put("rtm_data_first_video_frame_decoded", this.f459200w7.f459318n).put("rtm_data_first_video_frame_rendered", this.f459200w7.f459328p).put("rtm_first_frame_time_info", this.f459200w7.f459376y2).put("rtm_start_play_stats", this.f459200w7.f459381z2).put("sdk_session_stop", System.currentTimeMillis()).put(EventConstant.Value.RETRY, this.f458933b4).put("error_code", this.f459214x7);     // Catch: JSONException -> L16
        if (TextUtils.isEmpty(this.Jc) == true) goto L10;
        r100.put("server_expr_tag", this.Jc);     // Catch: JSONException -> L16
    L10:
        if (TextUtils.isEmpty(this.Kc) == true) goto L12;
        r100.put("server_expr_id", this.Kc);     // Catch: JSONException -> L16
    L12:
        VideoLiveManager r101 = this.f458980f;     // Catch: JSONException -> L16
        if (r101 == null) goto L22;
        r101.onRTMLog(5, "report rtm_session_stop rtm_first_frame_time_info: " + this.f459200w7.f459376y2);     // Catch: JSONException -> L16
        return;
    L22:
        return;
    L16:
        e = move-exception;
        this.f458980f.onRTMLog(6, "fixRtmSessionStopInfo error msg: " + e.toString());
        return;
    L23:
        return;
    }

    private JSONObject getSessionStopStr(JSONObject r110) {
        JSONObject r100 = new JSONObject();     // Catch: Exception -> L29
        if (r110.has("total_download_size") == false) goto L7;
        r100.put("total_download_size", r110.get("total_download_size"));     // Catch: Exception -> L29
    L7:
        if (r110.has("play_size") == false) goto L10;
        r100.put("play_size", r110.get("play_size"));     // Catch: Exception -> L29
    L10:
        if (r110.has(HistoryTableOperate.HISTORY_PLAY_TIME) == false) goto L13;
        r100.put(HistoryTableOperate.HISTORY_PLAY_TIME, r110.get(HistoryTableOperate.HISTORY_PLAY_TIME));     // Catch: Exception -> L29
    L13:
        if (r110.has("http_flow_size") == false) goto L16;
        r100.put("http_flow_size", r110.get("http_flow_size"));     // Catch: Exception -> L29
    L16:
        if (r110.has("p2p_flow_size") == false) goto L19;
        r100.put("p2p_flow_size", r110.get("p2p_flow_size"));     // Catch: Exception -> L29
    L19:
        if (r110.has("p2p_mobile_flow_size") == false) goto L22;
        r100.put("p2p_mobile_flow_size", r110.get("p2p_mobile_flow_size"));     // Catch: Exception -> L29
    L22:
        if (r110.has("ab_group_id") == false) goto L25;
        r100.put("ab_group_id", r110.get("ab_group_id"));     // Catch: Exception -> L29
    L25:
        if (r110.has("live_stream_session_id") == false) goto L27;
        r100.put("session_id", r110.get("live_stream_session_id"));     // Catch: Exception -> L29
    L27:
        r100.put("client_timestamp", r110.get("client_timestamp"));     // Catch: Exception -> L29
        return r100;
    L29:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    private void initializeSegmentRequest(JSONObject r100) {
        d r101 = new d();
        int r102 = this.Ad;
        r101.f459432a = r102;
        this.Ad = r102 + 1;
        r101.f459439h = this.Z;
        r101.f459437f = r100;
        r101.f459438g = this.f458980f.mCurrentActualRes;
        if (this.f459113p6 == false) goto L5;
        String r103 = "llash";
    L6:
        r101.f459440i = r103;
        r101.f459433b = this.f459076m8;
        long r104 = System.currentTimeMillis();
        long r105 = r101.f459433b;
        if (r104 >= r105) goto L9;
    L11:
        LogBundle r106 = this.f459026i8;
        long r107 = r106.f459349t0;
        long r108 = r106.f459354u0;
        long r109 = this.f459100o8;
        if (r109 == 0) goto L14;
        r108 = r108 - r109;
    L14:
        r101.f459435d = r108;
        r101.f459436e = this.Ic;
        ((ArrayList) this.f459234yd).add(r101);
        return;
    L9:
        if (r105 <= 0) goto L11;
        r101.f459434c = r104 - r105;
        goto L11
    L5:
        r103 = this.V2;
        goto L6
    }

    private void onLink(boolean r100) {
        if (this.f459237z4 != 1) goto L10;
        xmc.c r101 = xmc.c.getDataLoader();
        if (r100 == false) goto L7;
        int r102 = 8013;
    L8:
        r101.setInt64ValueByStrKey(r102, this.R2, -1);
        goto L10
    L7:
        r102 = 8014;
    L10:
        if (this.C4 != 1) goto L16;
        com.ss.videoarch.live.b r103 = com.ss.videoarch.live.b.f.f458578a;
        if (r100 == false) goto L14;
        int r104 = 1008;
    L15:
        r103.g(r104, this.f458980f.getLiveIOSessionId(), -1);
        goto L16
    L14:
        r104 = 1009;
    L16:
        JSONObject r105 = createCommonLog();
        if (r105 == null) goto L31;
        JSONObject r106 = r105.put(LiveCommonConstants.LOG_PARAM_EVENT_KEY, "link");     // Catch: JSONException -> L26
        if (r100 == false) goto L21;
        String r107 = "start";
    L22:
        r106.put("info", r107);     // Catch: JSONException -> L26
        onEventLog(r105, "live_client_monitor_log");     // Catch: JSONException -> L26
        long r108 = this.f459083n3;     // Catch: JSONException -> L26
        if (r108 <= 0) goto L32;
        this.f459083n3 = r108 + 1;     // Catch: JSONException -> L26
        return;
    L32:
        return;
    L21:
        r107 = "end";
    L26:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    private void reportCmafRequestLog(JSONObject r100) throws JSONException {
        if (TextUtils.equals(this.V2, "cmaf") == false) goto L22;
        String r101 = "";
        if (TextUtils.isEmpty(this.f458968e.H) == false) goto L7;
        String r102 = "";
    L8:
        r100.put("cmaf_video_request_log", r102);
        if (TextUtils.isEmpty(this.f458968e.I) == false) goto L11;
        String r103 = "";
    L12:
        r100.put("cmaf_audio_request_log", r103);
        c.i("LiveLoggerService", "cmaf_video_request_log = " + this.f458968e.H + "\tcmaf_audio_request_log = " + this.f458968e.I);
        if (TextUtils.isEmpty(this.f458968e.f459252J) == false) goto L15;
        String r104 = "";
    L16:
        r100.put("cmaf_video_req_no_series", r104);
        if (TextUtils.isEmpty(this.f458968e.K) == true) goto L20;
        r101 = this.f458968e.K;
    L20:
        r100.put("cmaf_audio_req_no_series", r101);
        c.i("LiveLoggerService", "cmaf_video_req_no_series = " + this.f458968e.f459252J + "\tcmaf_audio_req_no_series = " + this.f458968e.K);
        return;
    L15:
        r104 = this.f458968e.f459252J;
        goto L16
    L11:
        r103 = this.f458968e.I;
        goto L12
    L7:
        r102 = this.f458968e.H;
        goto L8
    }

    private void reportQuicOpenResult(JSONObject r100) throws JSONException {
        if (TextUtils.equals(this.F5, "quic") == false) goto L5;
    L6:
        r100.put("quic_open_result", this.f458968e.L1);
        c.i("LiveLoggerService", "quic_open_result = " + this.f458968e.L1);
        return;
    L5:
        if (TextUtils.equals(this.F5, "quicu") == true) goto L6;
    }

    private void updateRequestTimeFieldInRtcPlay(JSONObject r100) {
        if (r100.has("event_message") == false) goto L35;
        String r101 = r100.optString("event_message");
        c.i("LiveLoggerService", "eventMessage:" + r101);
        if (TextUtils.isEmpty(r101) == false) goto L7;
        return;
    L7:
        if (r100.has("phase_timestamp") == true) goto L10;
        return;
    L10:
        if (TextUtils.equals("dns resolved", r101) == false) goto L19;
        if (r100.has("request_ip") == false) goto L17;
        String r102 = r100.optString("request_ip");
        if (r102.equals(this.E7) == true) goto L16;
        this.f459157t = r102;
        this.G7 = 0;
        goto L17
    L16:
        this.G7 = 1;
    L17:
        this.H7 = CastLongProtector.parseLong(r100.optString("phase_timestamp"));
        c.i("LiveLoggerService", "mRtcDnsTimeStamp:" + this.H7);
        return;
    L19:
        if (TextUtils.equals("tcp connected", r101) == false) goto L21;
    L33:
        this.I7 = CastLongProtector.parseLong(r100.optString("phase_timestamp"));
        c.i("LiveLoggerService", "mRtcTcpConnectTimeStamp:" + this.I7);
        return;
    L21:
        if (TextUtils.equals("quic connected", r101) == true) goto L33;
        if (TextUtils.equals("send request", r101) == true) goto L33;
        if (TextUtils.equals("tls handshaked", r101) == false) goto L29;
        this.J7 = CastLongProtector.parseLong(r100.optString("phase_timestamp"));
        c.i("LiveLoggerService", "mRtcTlsHandshakedTimeStamp:" + this.J7);
        return;
    L29:
        if (TextUtils.equals("response received", r101) == false) goto L31;
    L32:
        this.K7 = CastLongProtector.parseLong(r100.optString("phase_timestamp"));
        c.i("LiveLoggerService", "mRtcTcpFirstPackageTimeStamp:" + this.K7);
        return;
    L31:
        if (TextUtils.equals("remote answer got", r101) == true) goto L32;
        return;
    }

    public void AddSeiSource(String r100) {
        if (this.f459130qb != null) goto L5;
        this.f459130qb = new HashMap();
    L5:
        this.f459130qb.put(r100, 1);
    }

    public void addPureColorDetectResult(PureColorDetector.DetectResult r100) {
        ((LinkedBlockingQueue) this.f458991fd).offer(r100);
    }

    public long calSum(JSONArray r100) throws JSONException {
        int r101 = r100.length();
        long r102 = 0;
        int r103 = 0;
    L3:
        if (r103 >= r101) goto L5;
        r102 = r102 + ((long) JSONArrayProtectorUtils.getInt(r100, r103));
        r103 = r103 + 1;
        goto L3
    L5:
        return r102;
    }

    public void checkSeiIndex(int r100) {
        if (this.f458996g4 == true) goto L5;
        this.f459025i7++;
        this.f459013h7++;
        int r101 = this.f458999g7;
        if (r101 < 0) goto L51;
        if (r100 > r101) goto L46;
        onStreamAbnormalSEI(4, r100, r101);
        if (r100 != 1) goto L51;
        this.f459037j7++;
        this.f459051k7++;
        goto L51
    L46:
        this.f459037j7++;
        this.f459051k7++;
        if ((r100 - r101) <= 1) goto L51;
        if (this.f458980f.getIsRetrying() == true) goto L51;
        onStreamAbnormalSEI(3, r100, this.f458999g7);
        int r102 = this.f459013h7;
        int r103 = this.f458999g7;
        this.f459013h7 = r102 + ((r100 - r103) - 1);
        this.f459037j7 += (r100 - r103) - 1;
    L51:
        this.f458999g7 = r100;
        return;
    L5:
        if (this.f459087n7 != null) goto L8;
        this.f459087n7 = new LinkedBlockingQueue(32);
    L8:
        if (this.f459087n7.contains(Integer.valueOf(r100)) == false) goto L10;
        return;
    L10:
        this.f459025i7++;
        int r104 = this.f458999g7;
        if (r104 < r100) goto L20;
        if (Math.abs(r104 - r100) <= 32) goto L20;
        if (r100 >= 200) goto L20;
        this.f459013h7 += (this.f459075m7 - this.f459063l7) + 1;
        this.f459063l7 = 1;
        this.f459075m7 = -1;
    L18:
        if (this.f459087n7.poll() != null) goto L18;
    L20:
        if (this.f459087n7.remainingCapacity() != 0) goto L22;
        this.f459087n7.poll();
    L22:
        this.f459087n7.offer(Integer.valueOf(r100));
        int r105 = this.f459063l7;
        if (r105 != (-1)) goto L25;
        this.f459063l7 = r100;
    L27:
        int r106 = this.f459075m7;
        if (r106 != (-1)) goto L30;
        this.f459075m7 = r100;
    L33:
        if (Math.abs(this.f458999g7 - r100) <= 32) goto L51;
        if (this.f458999g7 == (-1)) goto L51;
        if (this.f459099o7.equals("none") == false) goto L39;
        this.f459099o7 = this.f458999g7 + ":" + r100;
        goto L51
    L39:
        this.f459099o7 += "," + this.f458999g7 + ":" + r100;
        goto L51
    L30:
        if (r100 <= r106) goto L33;
        this.f459075m7 = r100;
        goto L33
    L25:
        if (r105 <= r100) goto L27;
        this.f459063l7 = r100;
        goto L27
    }

    public void close(String r100) {
        if (this.f459006h == false) goto L8;
        this.f459006h = false;
        this.f458944c.removeCallbacksAndMessages(null);
        a r101 = this.f459123q4;
        if (r101 == null) goto L7;
        a.access$000(r101).removeCallbacksAndMessages(null);
    L7:
        this.f459171u4 = false;
    L8:
        resetStreamCheckParams();
        onStop(r100);
        reset(true);
        resetApplogParams();
    }

    public void enableHardDecode(boolean r100) {
        this.f459045k0 = r100;
    }

    public void feedVideoDTS(long r100) {
        if (this.f458961d7 != null) goto L6;
        this.f458961d7 = new LinkedBlockingQueue(600);
    L6:
        if (this.f458961d7.remainingCapacity() == 0) goto L8;
    L10:
        this.f458961d7.offer(Long.valueOf(r100));
        return;
    L8:
        if (this.f458961d7.size() <= 0) goto L10;
        this.f458961d7.poll();
        goto L10
    }

    public JSONObject getFirstFrameBlockInfo(JSONObject r100) {
        if (r100 != null) goto L8;
    L7:
        return r100;
    L8:
        r100.put("start_play_time", this.f458968e.f459253a).put("sdk_dns_analysis_end", this.f458968e.f459258b).put("first_frame_render_end", this.f458968e.f459328p).put("retry_count", this.f458933b4);     // Catch: JSONException -> L5
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public int getRtmRetryCount(int r100) {
        VideoLiveManager r101 = this.f458980f;
        if (r101 != null) goto L5;
        return -1;
    L5:
        return r101.getRtmRetryCount(r100);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message r110) {
        int r111 = r110.what;
        if (101 != r111) goto L6;
        report(false, 0, 0, 0, 0, 0);
    L6:
        if (102 != r111) goto L10;
        reportUpdateSessionSeries();
        return true;
    L10:
        return true;
    }

    public void logSDR2HDRInfo(int r100) {
        this.Sd = r100;
    }

    public void logSpeedChange(int r110) {
        this.f459008h2++;
        StringBuilder r100 = new StringBuilder();
        r100.append(this.f459109p2);
        r100.append(",");
        double r101 = ((double) r110) / 1000.0d;
        r100.append(r101);
        r100.append(":");
        r100.append(System.currentTimeMillis());
        this.f459109p2 = r100.toString();
        if (this.f459183v2.equals("none") == false) goto L5;
        this.f459183v2 = (System.currentTimeMillis() - getInt64Value(101, 0)) + ":" + r101;
        return;
    L5:
        this.f459183v2 += "," + (System.currentTimeMillis() - getInt64Value(101, 0)) + ":" + r101;
    }

    public void onAbrSessionStop(boolean r110) {
        if (this.f458980f != null) goto L5;
        return;
    L5:
        if (this.f458956d != null) goto L8;
        return;
    L8:
        if (this.f458968e.f459328p <= this.f459199w6) goto L10;
        long r100 = System.currentTimeMillis();
        long r101 = this.f458968e.f459328p;
    L11:
        long r102 = r100 - r101;
        if (this.A6 > 0) goto L14;
    L30:
        JSONObject r103 = createCommonLog();     // Catch: JSONException -> L26
        JSONObject r104 = r103.put(LiveCommonConstants.LOG_PARAM_EVENT_KEY, "abr_session").put("current_resolution", this.f459036j6).put("current_bitrate", this.f459125q6).put("previous_resolution", this.f459149s6).put("previous_bitrate", this.f459161t6).put("stall_count", this.f459173u6).put("stall_time", this.f459187v6).put("startup_type", this.f459137r6).put(HistoryTableOperate.HISTORY_PLAY_TIME, r102).put("switch_cost", this.A6).put("abr_switch_info", this.B6).put("is_last", r110);     // Catch: JSONException -> L26
        if (r110 == false) goto L21;
        int r111 = this.f459086n6 + 1;     // Catch: JSONException -> L26
    L22:
        r104.put("abr_switch_count", r111);     // Catch: JSONException -> L26
        onEventLog(r103, "live_client_monitor_log");     // Catch: JSONException -> L26
        long r105 = this.f459083n3;     // Catch: JSONException -> L26
        if (r105 <= 0) goto L28;
        this.f459083n3 = r105 + 1;     // Catch: JSONException -> L26
    L28:
        onAbrSwitchEnd();
        resetAbrSessionInfo();
        this.f459199w6 = System.currentTimeMillis();
        return;
    L21:
        r111 = this.f459086n6;     // Catch: JSONException -> L26
    L26:
        e = move-exception;
        e.printStackTrace();
        goto L28
    L14:
        if (this.f459125q6 <= this.f459161t6) goto L16;
        int r106 = 3;
    L17:
        this.f459137r6 = r106;
        goto L30
    L16:
        r106 = 4;
        goto L17
    L10:
        r100 = System.currentTimeMillis();
        r101 = this.f459199w6;
        goto L11
    }

    public void onAudioRenderStart(long r100) {
        this.f458968e.f459333q = r100;
        if (this.f459014h8 != 1) goto L6;
        this.f459088n8 = r100;
        return;
    }

    public void onCallNotInMainThread(String r100) {
        if (this.f458980f != null) goto L5;
        return;
    L5:
        JSONObject r101 = createCommonLog();
        if (r101 == null) goto L16;
        r101.put(LiveCommonConstants.LOG_PARAM_EVENT_KEY, "call_not_in_main_thread").put("api_name", r100);     // Catch: JSONException -> L11
        onEventLog(r101, "live_client_monitor_log");     // Catch: JSONException -> L11
        long r102 = this.f459083n3;     // Catch: JSONException -> L11
        if (r102 <= 0) goto L17;
        this.f459083n3 = r102 + 1;     // Catch: JSONException -> L11
        return;
    L17:
        return;
    L11:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public void onFirstFrameFail(int r100) {
        if (this.f459009h3 == true) goto L18;
        VideoLiveManager r101 = this.f458980f;
        if (r101 == null) goto L21;
        r101.getLogInfo(this.f458968e, 2);
        JSONObject r102 = createCommonLog();
        if (r102 == null) goto L19;
        r102.put(LiveCommonConstants.LOG_PARAM_EVENT_KEY, "first_frame_failed").put(ILoadStallMonitor.START_TIME, System.currentTimeMillis()).put("reason", r100);     // Catch: JSONException -> L13
        reportQuicOpenResult(r102);     // Catch: JSONException -> L13
        onEventLog(r102, "live_client_monitor_log");     // Catch: JSONException -> L13
        long r103 = this.f459083n3;     // Catch: JSONException -> L13
        if (r103 <= 0) goto L20;
        this.f459083n3 = r103 + 1;     // Catch: JSONException -> L13
        return;
    L20:
        return;
    L13:
        e = move-exception;
        e.printStackTrace();
        return;
    L19:
        return;
    L21:
        return;
    }

    public void onHurrySkipData(String r100) {
        if (r100 != null) goto L35;
        return;
    L35:
        JSONObject r101 = new JSONObject(r100);     // Catch: JSONException -> L32
        if (r101.has("skip_duraion") == false) goto L9;
        this.f459208x1 += r101.optInt("skip_duraion", 0);     // Catch: JSONException -> L32
    L9:
        if (r101.has("skip_audio_time") == false) goto L12;
        this.f459222y1 += r101.optInt("skip_audio_time", 0);     // Catch: JSONException -> L32
    L12:
        if (r101.has("skip_video_time") == false) goto L15;
        this.G1 += r101.optInt("skip_video_time", 0);     // Catch: JSONException -> L32
    L15:
        if (r101.has("av_skip_end_diff") == false) goto L18;
        r101.optInt("av_skip_end_diff", 0);     // Catch: JSONException -> L32
    L18:
        if (r101.has("av_skip_end_pts_diff") == false) goto L20;
        r101.optInt("av_skip_end_pts_diff", 0);     // Catch: JSONException -> L32
    L20:
        this.H1++;     // Catch: JSONException -> L32
        if (this.f458980f != null) goto L23;
        return;
    L23:
        if (this.L1 == 0) goto L37;
        JSONObject r102 = createCommonLog();     // Catch: JSONException -> L32
        if (r102 == null) goto L38;
        r102.put(LiveCommonConstants.LOG_PARAM_EVENT_KEY, "skip_data_info");     // Catch: JSONException -> L32
        setExtParam(r102, r101);     // Catch: JSONException -> L32
        onEventLog(r102, "live_client_monitor_log");     // Catch: JSONException -> L32
        long r103 = this.f459083n3;     // Catch: JSONException -> L32
        if (r103 <= 0) goto L39;
        this.f459083n3 = r103 + 1;     // Catch: JSONException -> L32
        return;
    L39:
        return;
    L38:
        return;
    L37:
        return;
    L32:
        e = move-exception;
        e.printStackTrace();
    }

    public void onIllegalAPICall(String r100) {
        VideoLiveManager r101 = this.f458980f;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.getLogInfo(this.f458968e, 2);
        JSONObject r102 = createCommonLog();
        if (r102 == null) goto L16;
        r102.put(LiveCommonConstants.LOG_PARAM_EVENT_KEY, "illegal_call").put("api_name", r100);     // Catch: JSONException -> L11
        reportQuicOpenResult(r102);     // Catch: JSONException -> L11
        onEventLog(r102, "live_client_monitor_log");     // Catch: JSONException -> L11
        long r103 = this.f459083n3;     // Catch: JSONException -> L11
        if (r103 <= 0) goto L17;
        this.f459083n3 = r103 + 1;     // Catch: JSONException -> L11
        return;
    L17:
        return;
    L11:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public void onPrepare(int r110) {
        VideoLiveManager r100 = this.f458980f;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.getLogInfo(this.f458968e, 7);
        JSONObject r101 = createCommonLog();
        String r102 = "none";
        if (this.f459014h8 != 1) goto L12;
        this.f459241z8 = r110;
        if (r110 == 0) goto L10;
        String r103 = this.f458980f.getPlayerErrorInfo();
    L11:
        this.A8 = r103;
        goto L12
    L10:
        r103 = "none";
    L12:
        if (r101 == null) goto L68;
        long r104 = this.L6;     // Catch: JSONException -> L63
        if (r104 <= 0) goto L20;
        long r105 = this.M6;     // Catch: JSONException -> L63
        if (r105 <= 0) goto L20;
        if (r104 >= r105) goto L20;
        boolean r106 = true;
    L21:
        JSONObject r107 = r101.put(LiveCommonConstants.LOG_PARAM_EVENT_KEY, "prepare_result").put("result", r110);     // Catch: JSONException -> L63
        if (r106 == false) goto L24;
        int r108 = 1;
    L25:
        JSONObject r109 = r107.put("first_audio_packet_dts_rollback", r108).put("first_audio_packet_dts", this.L6).put("previous_audio_packet_dts", this.M6).put("stream_type", this.f458968e.A2).put("suggest_format", this.E5).put("suggest_protocol", this.G5).put("suggest_access_code", this.L5);     // Catch: JSONException -> L63
        if (this.f458980f.getSRState() == false) goto L28;
        int r111 = 1;
    L29:
        JSONObject r112 = r109.put("nnsr_enabled", r111);     // Catch: JSONException -> L63
        if (this.f458980f.getSharpenState() == false) goto L32;
        int r113 = 1;
    L33:
        r112.put(IPerformanceManager.PlayerClient.sharpen_enabled, r113);     // Catch: JSONException -> L63
        if (this.f459078ma == 0) goto L38;
    L40:
        if (r110 == 0) goto L42;
        String r114 = this.f458980f.getPlayerErrorInfo();     // Catch: JSONException -> L63
    L43:
        r101.put("error_msg", r114);     // Catch: JSONException -> L63
    L45:
        if (this.f459120pd == 1) goto L53;
        String r115 = this.A;     // Catch: JSONException -> L63
        if (r115 == null) goto L50;
        r102 = r115;
    L50:
        r101.put(OrderParamsKey.KEY_SDK_PARAM, r102);     // Catch: JSONException -> L63
    L53:
        if (this.f459084n4 != 1) goto L58;
        if (r110 != 0) goto L56;
    L59:
        long r116 = this.f459083n3;     // Catch: JSONException -> L63
        if (r116 <= 0) goto L69;
        this.f459083n3 = r116 + 1;     // Catch: JSONException -> L63
        return;
    L69:
        return;
    L56:
        if (this.f459038j8 == true) goto L59;
        long r117 = System.currentTimeMillis() - this.f459026i8.f459253a;     // Catch: JSONException -> L63
        r101.put(LiveCommonConstants.LOG_PARAM_EVENT_KEY, "session_first_frame").put("reason", r110).put("session_play_time_on_no_frame", r117).put("is_stream_received", 0).put("event_key_index", f458909fe.incrementAndGet());     // Catch: JSONException -> L63
        onEventLog(r101, "live_client_monitor_log");     // Catch: JSONException -> L63
        goto L59
    L58:
        onEventLog(r101, "live_client_monitor_log");     // Catch: JSONException -> L63
        goto L59
    L42:
        r114 = "none";
        goto L43
    L38:
        if (TextUtils.isEmpty(null) == true) goto L40;
        r101.put("error_msg", null);     // Catch: JSONException -> L63
        goto L45
    L32:
        r113 = 0;
        goto L33
    L28:
        r111 = 0;
        goto L29
    L24:
        r108 = 0;
    L20:
        r106 = false;
    L63:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public void onProtocolDowngrade(String r100) {
        this.J5 = r100;
        this.I5 = 1;
    }

    public void onPullStartSuccess(int r110) {
        VideoLiveManager r100 = this.f458980f;
        if (r100 != null) goto L25;
        return;
    L25:
        r100.getLogInfo(this.f458968e, 0);     // Catch: JSONException -> L22
        JSONObject r101 = createFirstFrameLog(this.f458968e, 0, this.Y, r110);     // Catch: JSONException -> L22
        if (r101 != null) goto L9;
        return;
    L9:
        if (r110 == (-1)) goto L11;
    L17:
        r101.put(LiveCommonConstants.LOG_PARAM_EVENT_KEY, "pull_restart_success").put("stall_time", r110).put("start", this.f459052k8).put("cmd", this.Gc).put("mode", this.Hc);     // Catch: JSONException -> L22
        onEventLog(r101, "live_client_monitor_log");     // Catch: JSONException -> L22
        long r102 = this.f459083n3;     // Catch: JSONException -> L22
        if (r102 <= 0) goto L20;
        this.f459083n3 = r102 + 1;     // Catch: JSONException -> L22
    L20:
        this.Hc = "";     // Catch: JSONException -> L22
        return;
    L11:
        if (this.f459009h3 == true) goto L15;
        long r103 = System.currentTimeMillis();     // Catch: JSONException -> L22
        long r104 = this.f458968e.f459253a;     // Catch: JSONException -> L22
    L13:
        r110 = (int) (r103 - r104);     // Catch: JSONException -> L22
        goto L17
    L15:
        if (this.f459052k8 <= 0) goto L17;
        r103 = System.currentTimeMillis();     // Catch: JSONException -> L22
        r104 = this.f459052k8;     // Catch: JSONException -> L22
    L22:
        e = move-exception;
        e.printStackTrace();
    }

    public void onQuicuFrameDrop(String r210) {
        if (r210 == null) goto L130;
        double r100 = AudioStats.AUDIO_AMPLITUDE_NONE;
        JSONObject r110 = new JSONObject(r210);     // Catch: JSONException -> L40
        if (r110.has("streamid") == false) goto L9;
        int r101 = r110.optInt("streamid");     // Catch: JSONException -> L40
    L120:
    L38:
        e = e;
        int r102 = -1;
        int r103 = -1;
        int r104 = -1;
    L42:
        e.printStackTrace();
    L43:
        if (r101 == (-1)) goto L131;
        if (r104 == (-1)) goto L132;
        if (r103 == (-1)) goto L133;
        int r105 = r103 - r104;
        if (r105 >= 0) goto L50;
        return;
    L50:
        if (this.f459009h3 == false) goto L52;
        long r111 = System.currentTimeMillis() - this.f459033j3;
    L54:
        if (r102 != 0) goto L56;
        double r112 = r100;
        this.f458923a9++;
    L60:
        if (r101 != 9) goto L89;
        int r113 = r103;
        this.X8++;
        this.T8++;
        long r114 = r105;
        this.Y8 += r114;
        this.U8 += r114;
        if (isPreview() == false) goto L65;
        this.f459077m9++;
        this.f459128q9++;
        this.f459089n9 += r114;
        this.f459140r9 += r114;
    L65:
        if (this.f459009h3 == true) goto L70;
        this.f459190v9 += r114;
        if (this.f458983f5.equals("none") == false) goto L69;
        this.f458983f5 = "-1:" + r105;
        return;
    L69:
        this.f458983f5 += ",-1:" + r105;
        return;
    L70:
        int r106 = this.f459152s9;
        if (r106 != (-1)) goto L73;
    L75:
        int r107 = this.f459164t9;
        if (r107 != (-1)) goto L78;
    L80:
        int r108 = this.f459176u9;
        if (r108 != (-1)) goto L83;
    L85:
        System.currentTimeMillis();
        long r109 = this.f458968e.f459328p;
        if (this.f458983f5.equals("none") == false) goto L88;
        this.f458983f5 = r102 + ":" + (((long) r104) - this.f458968e.f459284g0) + ":" + (((long) r113) - this.f458968e.f459284g0) + ":" + r112;
        return;
    L88:
        this.f458983f5 += "," + r102 + ":" + (((long) r104) - this.f458968e.f459284g0) + ":" + (((long) r113) - this.f458968e.f459284g0) + ":" + r112;
        return;
    L83:
        if (r111 >= r108) goto L85;
        this.f459242z9 += r114;
        goto L85
    L78:
        if (r111 >= r107) goto L80;
        this.f459230y9 += r114;
        goto L80
    L73:
        if (r111 >= r106) goto L75;
        this.f459216x9 += r114;
        goto L75
    L89:
        double r115 = r112;
        if (r101 != 8) goto L138;
        int r116 = r103;
        this.V8++;
        this.R8++;
        long r117 = r105;
        this.W8 += r117;
        this.S8 += r117;
        if (isPreview() == false) goto L95;
        this.f459053k9++;
        this.f459101o9++;
        this.f459065l9 += r117;
        this.f459116p9 += r117;
    L95:
        if (this.f459009h3 == true) goto L100;
        this.f459202w9 += r117;
        if (this.f458971e5.equals("none") == false) goto L99;
        this.f458971e5 = "-1:" + r105;
        return;
    L99:
        this.f458971e5 += ",-1:" + r105;
        return;
    L100:
        int r118 = this.f459152s9;
        if (r118 != (-1)) goto L103;
    L105:
        int r119 = this.f459164t9;
        if (r119 != (-1)) goto L108;
    L110:
        int r120 = this.f459176u9;
        if (r120 != (-1)) goto L113;
    L115:
        System.currentTimeMillis();
        long r121 = this.f458968e.f459328p;
        if (this.f458971e5.equals("none") == false) goto L118;
        this.f458971e5 = r102 + ":" + (((long) r104) - this.f458968e.f459294i0) + ":" + (((long) r116) - this.f458968e.f459294i0) + ":" + r115;
        return;
    L118:
        this.f458971e5 += r102 + ":" + (((long) r104) - this.f458968e.f459294i0) + ":" + (((long) r116) - this.f458968e.f459294i0) + ":" + r115;
        return;
    L113:
        if (r111 >= r120) goto L115;
        this.C9 += r117;
        goto L115
    L108:
        if (r111 >= r119) goto L110;
        this.B9 += r117;
        goto L110
    L103:
        if (r111 >= r118) goto L105;
        this.A9 += r117;
        goto L105
    L138:
        return;
    L56:
        r112 = r100;
        if (r102 != 1) goto L60;
        this.Z8++;
        goto L60
    L52:
        r111 = 0;
        goto L54
    L133:
        return;
    L132:
        return;
    L131:
        return;
    L11:
        if (r110.has("start") == false) goto L14;
        r104 = r110.optInt("start");     // Catch: JSONException -> L38
    L128:
    L36:
        e = e;
        r102 = -1;
        r103 = -1;
        goto L42
    L16:
        if (r110.has("end") == false) goto L19;
        r103 = r110.optInt("end");     // Catch: JSONException -> L36
    L126:
    L34:
        e = e;
        r102 = -1;
        goto L42
    L21:
        if (r110.has("drop_per") == false) goto L24;
        r100 = r110.optDouble("drop_per", AudioStats.AUDIO_AMPLITUDE_NONE);     // Catch: JSONException -> L34
    L24:
        if (r110.has("type") == false) goto L27;
        r102 = r110.optInt("type", 0);     // Catch: JSONException -> L34
    L124:
    L32:
        e = e;
        goto L42
    L29:
        if (r110.has("c_drop_use_max_time") == false) goto L43;
        this.f458938b9 = r110.optInt("c_drop_use_max_time", 0);     // Catch: JSONException -> L32
        goto L43
    L27:
        r102 = -1;
        goto L124
    L19:
        r103 = -1;
        goto L126
    L14:
        r104 = -1;
        goto L128
    L9:
        r101 = -1;
    L40:
        e = e;
        r102 = -1;
        r103 = -1;
        r104 = -1;
        r101 = -1;
        goto L42
    }

    public void onRecvRtcEventNotify(String r100) {
        if (this.f458980f != null) goto L5;
        return;
    L5:
        if (r100 == null) goto L13;
        JSONObject r101 = new JSONObject(r100);     // Catch: Exception -> L8
        c.i("LiveLoggerService", "recv event notify: " + r101);     // Catch: Exception -> L8
        updateRequestTimeFieldInRtcPlay(r101);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        c.e("LiveLoggerService", "recv event notify error occurs error:" + e.toString());
        return;
    }

    public void onRecvedRtcTraceInfo(String r100) {
        if (this.f458980f != null) goto L17;
        return;
    L17:
        JSONObject r101 = new JSONObject();     // Catch: JSONException -> L14
        if (r100 == null) goto L12;
        r101.put("product_line", "rts");     // Catch: JSONException -> L14
        r101.put("rtc_trace_info", r100);     // Catch: JSONException -> L14
        if (r100.isEmpty() == true) goto L12;
        if (r100.contains("rts_play_stop") == false) goto L12;
        this.P7 = new JSONObject(r100).optString("event_message");     // Catch: JSONException -> L14
    L12:
        onEventLog(r101, "live_webrtc_monitor_log");     // Catch: JSONException -> L14
        return;
    L14:
        e = move-exception;
        e.printStackTrace();
    }

    public void onRecvedSPSPPS(String r100) {
        if (this.f458980f != null) goto L13;
        return;
    L13:
        JSONObject r101 = createCommonLog();     // Catch: JSONException -> L10
        r101.put(LiveCommonConstants.LOG_PARAM_EVENT_KEY, "recved_spspps").put("spspps", r100);     // Catch: JSONException -> L10
        onEventLog(r101, "live_client_monitor_log");     // Catch: JSONException -> L10
        long r102 = this.f459083n3;     // Catch: JSONException -> L10
        if (r102 <= 0) goto L8;
        this.f459083n3 = r102 + 1;     // Catch: JSONException -> L10
    L8:
        this.f459156sd = r100;     // Catch: JSONException -> L10
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
    }

    public void onRecvedSPSPPSBeforeFirstFrame(String r100) {
        if (this.f458980f != null) goto L5;
        return;
    L5:
        this.f459132qd++;
        this.f459144rd.add("spspps:" + r100 + "received_time:" + System.currentTimeMillis());
        this.f459156sd = r100;
    }

    public void onRetry(int r100) {
        this.f458918a4++;
        this.f458933b4++;
        this.f458980f.getLogInfo(this.f458968e, 2);
        JSONObject r101 = createCommonLog();
        calculateRenderFailType();
        if (r101 == null) goto L13;
        r101.put(LiveCommonConstants.LOG_PARAM_EVENT_KEY, EventConstant.Value.RETRY).put("reason", this.f459095o3).put("code", r100).put("socket_err_code", this.f458968e.I1).put("socket_err_type", this.f458968e.H1).put("render_fail_type", this.f459110p3);     // Catch: JSONException -> L8
        reportQuicOpenResult(r101);     // Catch: JSONException -> L8
        onEventLog(r101, "live_client_monitor_log");     // Catch: JSONException -> L8
        onAbrSwitchEnd();     // Catch: JSONException -> L8
        long r102 = this.f459083n3;     // Catch: JSONException -> L8
        if (r102 <= 0) goto L14;
        this.f459083n3 = r102 + 1;     // Catch: JSONException -> L8
        return;
    L14:
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public void onRoomStateChange(int r100) {
        if (r100 != 1) goto L11;
        if (this.f459009h3 == true) goto L7;
    L9:
        this.f458954cc = true;
        goto L11
    L7:
        if (this.f458954cc == true) goto L9;
        this.f458926ac = System.currentTimeMillis();
        this.f458941bc = System.currentTimeMillis();
    L11:
        if (r100 == 2) goto L13;
        return;
    L13:
        if (this.f459009h3 == true) goto L15;
    L21:
        this.f458954cc = false;
        return;
    L15:
        if (this.f458926ac <= 0) goto L21;
        if (this.f458941bc <= 0) goto L21;
        if (this.f458954cc == false) goto L21;
        this.f458966dc += System.currentTimeMillis() - this.f458926ac;
        this.f458978ec += System.currentTimeMillis() - this.f458941bc;
        goto L21
    }

    public void onSDKDNSError(LiveError r100) {
        this.f458980f.getLogInfo(this.f458968e, 2);
        JSONObject r101 = createCommonLog();
        if (r101 == null) goto L26;
        JSONObject r102 = r101.put(LiveCommonConstants.LOG_PARAM_EVENT_KEY, "prepare_result").put("error_msg", r100.getInfoJSON()).put("result", r100.code).put("stream_type", this.f458968e.A2).put("suggest_format", this.E5).put("suggest_protocol", this.G5).put("suggest_access_code", this.L5);     // Catch: JSONException -> L21
        int r103 = 0;
        if (this.f458980f.getSRState() == false) goto L7;
        int r104 = 1;
    L8:
        JSONObject r105 = r102.put("nnsr_enabled", r104);     // Catch: JSONException -> L21
        if (this.f458980f.getSharpenState() == false) goto L11;
        r103 = 1;
    L11:
        r105.put(IPerformanceManager.PlayerClient.sharpen_enabled, r103);     // Catch: JSONException -> L21
        if (this.f459120pd == 1) goto L17;
        String r106 = this.A;     // Catch: JSONException -> L21
        if (r106 != null) goto L16;
        r106 = "none";
    L16:
        r101.put(OrderParamsKey.KEY_SDK_PARAM, r106);     // Catch: JSONException -> L21
    L17:
        onEventLog(r101, "live_client_monitor_log");     // Catch: JSONException -> L21
        long r107 = this.f459083n3;     // Catch: JSONException -> L21
        if (r107 <= 0) goto L27;
        this.f459083n3 = r107 + 1;     // Catch: JSONException -> L21
        return;
    L27:
        return;
    L7:
        r104 = 0;
    L21:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public void onSessionFirstFrame(int r210) {
        if (this.f459026i8 != null) goto L5;
        return;
    L5:
        this.f459047k3 = System.currentTimeMillis();
        String r100 = this.f459059l3;
        String r101 = this.R2;
        if (r100 == r101) goto L98;
        this.f459059l3 = r101;
        if (this.f458980f != null) goto L10;
        return;
    L10:
        if (this.f458968e == null) goto L101;
        this.f459026i8.M0 = System.currentTimeMillis();     // Catch: JSONException -> L93
        if (isPreview() == false) goto L15;
        LogBundle r102 = this.f459026i8;     // Catch: JSONException -> L93
        r102.N0 = r102.M0;     // Catch: JSONException -> L93
    L15:
        this.f458980f.getLogInfo(this.f459026i8, 0);     // Catch: JSONException -> L93
        JSONObject r103 = createSessionFirstFrameLog(this.f459026i8);     // Catch: JSONException -> L93
        this.N9 = this.f459047k3 - this.f459026i8.f459253a;     // Catch: JSONException -> L93
        if (isRtcPlayAvailable() == false) goto L20;
        VideoLiveManager r104 = this.f458980f;     // Catch: JSONException -> L93
        if (r104 == null) goto L20;
        r104.onRTMLog(5, "rtc_play_url:" + this.f459133r);     // Catch: JSONException -> L93
        this.f458980f.onRTMLog(5, "mFirstFrameView:" + this.N9);     // Catch: JSONException -> L93
        this.f458980f.onRTMLog(5, "startPlayTime:" + this.f459026i8.f459253a + ",mFirstFrameTimestamp:" + this.f459033j3);     // Catch: JSONException -> L93
        VideoLiveManager r105 = this.f458980f;     // Catch: JSONException -> L93
        StringBuilder r106 = new StringBuilder("rtc_inited_end:");     // Catch: JSONException -> L93
        r106.append(this.f459026i8.f459296i2);     // Catch: JSONException -> L93
        r105.onRTMLog(5, r106.toString());     // Catch: JSONException -> L93
        VideoLiveManager r107 = this.f458980f;     // Catch: JSONException -> L93
        StringBuilder r108 = new StringBuilder("start_2_init_diff: ");     // Catch: JSONException -> L93
        LogBundle r109 = this.f459026i8;     // Catch: JSONException -> L93
        r108.append(r109.f459296i2 - r109.f459253a);     // Catch: JSONException -> L93
        r107.onRTMLog(5, r108.toString());     // Catch: JSONException -> L93
        this.f458980f.onRTMLog(5, "rtc_offer_send_end:" + this.f459026i8.f459316m2);     // Catch: JSONException -> L93
        this.f458980f.onRTMLog(5, "rtc_answer_recv_end:" + this.f459026i8.f459321n2);     // Catch: JSONException -> L93
        this.f458980f.onRTMLog(5, "rtc_ice_connected_time:" + this.f459026i8.f459336q2);     // Catch: JSONException -> L93
        this.f458980f.onRTMLog(5, "first_video_package_end:" + this.f459026i8.f459308l);     // Catch: JSONException -> L93
        this.f458980f.onRTMLog(5, "first_video_frame_end:" + this.f459026i8.f459346s2);     // Catch: JSONException -> L93
        this.f458980f.onRTMLog(5, "first_video_frame_decode_start:" + this.f459026i8.f459356u2);     // Catch: JSONException -> L93
        this.f458980f.onRTMLog(5, "first_video_frame_decode_end:" + this.f459026i8.f459318n);     // Catch: JSONException -> L93
        this.f458980f.onRTMLog(5, "first_frame_render_end:" + this.f459026i8.f459328p);     // Catch: JSONException -> L93
        this.f458980f.onRTMLog(5, "preload_result: " + getRTCPreloadingState());     // Catch: JSONException -> L93
    L20:
        this.f459109p2 = "1.0:" + this.f459033j3;     // Catch: JSONException -> L93
        LogBundle r110 = this.f459026i8;     // Catch: JSONException -> L93
        if (r110 == null) goto L23;
        r110.f459290h1 = this.f458968e.f459280f1;     // Catch: JSONException -> L93
        r110.f459295i1 = r110.f459280f1;     // Catch: JSONException -> L93
    L23:
        long r111 = System.currentTimeMillis() - this.f459026i8.f459253a;     // Catch: JSONException -> L93
        if (this.f459038j8 == false) goto L26;
        JSONObject r112 = r103;
        r112.put("session_succ_elapse", r111);     // Catch: JSONException -> L93
    L28:
        int r113 = 1;
        String r114 = "none";
        if (this.f459014h8 != 1) goto L36;
        int r115 = r210;
        this.f459241z8 = r115;     // Catch: JSONException -> L93
        if (r115 == 0) goto L34;
        String r116 = this.f458980f.getPlayerErrorInfo();     // Catch: JSONException -> L93
    L35:
        this.A8 = r116;     // Catch: JSONException -> L93
    L38:
        if (r112 == null) goto L69;
        long r117 = this.L6;     // Catch: JSONException -> L93
        if (r117 <= 0) goto L46;
        long r118 = this.M6;     // Catch: JSONException -> L93
        if (r118 <= 0) goto L46;
        if (r117 >= r118) goto L46;
        boolean r119 = true;
    L47:
        JSONObject r120 = r112.put("reason", r115);     // Catch: JSONException -> L93
        if (r119 == false) goto L50;
        int r121 = 1;
    L51:
        JSONObject r122 = r120.put("first_audio_packet_dts_rollback", r121).put("first_audio_packet_dts", this.L6).put("previous_audio_packet_dts", this.M6);     // Catch: JSONException -> L93
        if (this.f458980f.getSRState() == false) goto L54;
        int r123 = 1;
    L55:
        JSONObject r124 = r122.put("nnsr_enabled", r123);     // Catch: JSONException -> L93
        if (this.f458980f.getSharpenState() == false) goto L58;
        int r125 = 1;
    L59:
        r124.put(IPerformanceManager.PlayerClient.sharpen_enabled, r125);     // Catch: JSONException -> L93
        if (this.f459078ma == 0) goto L64;
    L66:
        if (r115 == 0) goto L68;
        r114 = this.f458980f.getPlayerErrorInfo();     // Catch: JSONException -> L93
    L68:
        r112.put("error_msg", r114);     // Catch: JSONException -> L93
        goto L69
    L64:
        if (TextUtils.isEmpty(null) == true) goto L66;
        r112.put("error_msg", null);     // Catch: JSONException -> L93
        goto L69
    L58:
        r125 = 0;
        goto L59
    L54:
        r123 = 0;
        goto L55
    L50:
        r121 = 0;
    L46:
        r119 = false;
    L69:
        long r126 = this.f459026i8.f459318n;     // Catch: JSONException -> L93
        if (r126 == 0) goto L80;
        boolean r127 = this.f459038j8;     // Catch: JSONException -> L93
        if (r127 == false) goto L76;
        long r128 = this.f459198w5;     // Catch: JSONException -> L93
        if (r128 <= r126) goto L76;
        long r129 = r128 - r126;     // Catch: JSONException -> L93
    L82:
        if (this.f459038j8 == false) goto L84;
        int r130 = 1;
    L85:
        JSONObject r131 = r112.put("is_stream_received", r130).put("wait_surface_elapse", r129);     // Catch: JSONException -> L93
        if (this.f459186v5 >= 0) goto L89;
        r113 = 0;
    L89:
        r131.put("set_surface", r113);     // Catch: JSONException -> L93
        onEventLog(r112, "live_client_monitor_log");     // Catch: JSONException -> L93
        long r132 = this.f459083n3;     // Catch: JSONException -> L93
        if (r132 <= 0) goto L100;
        this.f459083n3 = r132 + 1;     // Catch: JSONException -> L93
        return;
    L100:
        return;
    L84:
        r130 = 0;
    L76:
        if (r127 == true) goto L80;
        if (this.f459198w5 != 0) goto L80;
        r129 = System.currentTimeMillis() - this.f459026i8.f459318n;     // Catch: JSONException -> L93
    L80:
        r129 = 0;
        goto L82
    L34:
        r116 = "none";
        goto L35
    L36:
        r115 = r210;
        goto L38
    L26:
        r112 = r103;
        r112.put("session_play_time_on_no_frame", r111);     // Catch: JSONException -> L93
    L93:
        e = move-exception;
        e.printStackTrace();
        return;
    L101:
        return;
    }

    public void onSilenceEnd(int r100) {
        JSONObject r101 = new JSONObject();
        r101.put(ILoadStallMonitor.START_TIME, this.f458989fb);     // Catch: JSONException -> L7
        r101.put("duration", System.currentTimeMillis() - this.f458989fb);     // Catch: JSONException -> L7
        r101.put("average_db", r100);     // Catch: JSONException -> L7
        c.d("LiveLoggerService", "silence end: " + r101);     // Catch: JSONException -> L7
        JSONObject r102 = this.f459003gb;     // Catch: JSONException -> L7
        if (r102 == null) goto L12;
        r102.put(String.valueOf(this.f458977eb), r101);     // Catch: JSONException -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    public void onStallEnd(int r110) {
        if (this.f459095o3 != (-100015)) goto L6;
        this.f459095o3 = 0;
    L6:
        if (this.L3 == true) goto L9;
        return;
    L9:
        if (isRtcPlayAvailable() == false) goto L11;
        return;
    L11:
        this.L3 = false;
        this.f458980f.getLogInfo(this.f458968e, 6);
        JSONObject r100 = createCommonLog();
        if (this.T4 != null) goto L15;
        this.T4 = new ArrayList();
    L15:
        if (this.U4 != null) goto L17;
        this.U4 = new ArrayList();
    L17:
        this.T4.add(Long.valueOf(this.V4));
        this.T4.add(Long.valueOf(-(System.currentTimeMillis() - this.f458968e.f459253a)));
        this.U4.add(Integer.valueOf(this.Ec));
        if (this.T3 != 0) goto L21;
        this.T3 = System.currentTimeMillis();
    L21:
        if (this.f459014h8 == 1) goto L23;
    L25:
        if (r100 != null) goto L27;
        return;
    L27:
        if (this.f459122q3 == 0) goto L84;
    L78:
        e = move-exception;
        e.printStackTrace();
        return;
    L29:
        if (this.f459134r3 == 0) goto L33;
        this.M3++;     // Catch: JSONException -> L78
        this.N3 = (int) (((long) this.N3) + (System.currentTimeMillis() - this.f459134r3));     // Catch: JSONException -> L78
        if (isPreview() == false) goto L33;
        this.B3++;     // Catch: JSONException -> L78
        this.C3 = (int) (((long) this.C3) + (System.currentTimeMillis() - this.f459134r3));     // Catch: JSONException -> L78
    L33:
        this.f459158t3++;     // Catch: JSONException -> L78
        this.f459170u3 += System.currentTimeMillis() - this.f459122q3;     // Catch: JSONException -> L78
        this.f459117pa += System.currentTimeMillis() - this.f459122q3;     // Catch: JSONException -> L78
        if (this.f459158t3 < this.f458945c3) goto L48;
        if (this.f459033j3 == 0) goto L39;
        this.X2 += ",[play_time:" + (System.currentTimeMillis() - this.f459033j3) + ", behavior:-3]";     // Catch: JSONException -> L78
    L40:
        VideoLiveManager r101 = this.f458980f;     // Catch: JSONException -> L78
        g0 r102 = r101.mObserver;     // Catch: JSONException -> L78
        if (r102 == null) goto L43;
        r102.onNetworkQualityChanged(r101, -2, "to_much_stall");     // Catch: JSONException -> L78
    L46:
        this.f458945c3 += (long) VideoLiveManager.mNetworkBehaviorStallCountThreshlod;     // Catch: JSONException -> L78
        goto L48
    L43:
        com.ss.videoarch.liveplayer.e r103 = r101.mListener;     // Catch: JSONException -> L78
        if (r103 == null) goto L46;
        r103.onNetworkQualityChanged(-2, "to_much_stall");     // Catch: JSONException -> L78
        goto L46
    L39:
        this.X2 += ",[no_first_frame, behavior:-3]";     // Catch: JSONException -> L78
    L48:
        if (this.f459170u3 < this.f458957d3) goto L61;
        if (this.f459033j3 == 0) goto L52;
        this.X2 += ",[play_time:" + (System.currentTimeMillis() - this.f459033j3) + ", behavior:-3]";     // Catch: JSONException -> L78
    L53:
        VideoLiveManager r104 = this.f458980f;     // Catch: JSONException -> L78
        g0 r105 = r104.mObserver;     // Catch: JSONException -> L78
        if (r105 == null) goto L56;
        r105.onNetworkQualityChanged(r104, -2, "to_much_stall");     // Catch: JSONException -> L78
    L59:
        this.f458957d3 += (long) VideoLiveManager.mNetworkBehaviorStallTimeThreshlod;     // Catch: JSONException -> L78
        goto L61
    L56:
        com.ss.videoarch.liveplayer.e r106 = r104.mListener;     // Catch: JSONException -> L78
        if (r106 == null) goto L59;
        r106.onNetworkQualityChanged(-2, "to_much_stall");     // Catch: JSONException -> L78
        goto L59
    L52:
        this.X2 += ",[no_first_frame, behavior:-3]";     // Catch: JSONException -> L78
    L61:
        if (isPreview() == false) goto L64;
        this.f459196w3++;     // Catch: JSONException -> L78
        this.f459184v3 += System.currentTimeMillis() - this.f459122q3;     // Catch: JSONException -> L78
    L64:
        if (this.f459014h8 != 1) goto L66;
        this.f459127q8++;     // Catch: JSONException -> L78
        this.f459139r8 += System.currentTimeMillis() - this.f459122q3;     // Catch: JSONException -> L78
    L66:
        this.f459173u6++;     // Catch: JSONException -> L78
        this.f459187v6 += System.currentTimeMillis() - this.f459122q3;     // Catch: JSONException -> L78
        if (this.f459131qc.get() == false) goto L69;
        this.f459104oc += System.currentTimeMillis() - Math.max(this.f459122q3, this.f459119pc);     // Catch: JSONException -> L78
    L69:
        r100.put(LiveCommonConstants.LOG_PARAM_EVENT_KEY, "stall").put("stall_start", this.f459122q3).put("stall_end", System.currentTimeMillis()).put("video_buffer_time_stall_start", this.f458968e.V1).put("audio_buffer_time_stall_start", this.f458968e.W1).put("video_buffer_time_stall_end", this.f458968e.X1).put("audio_buffer_time_stall_end", this.f458968e.Y1).put("last_res", this.f459050k6).put("stall_start_sub_scene", this.f459205wc).put("stall_start_ver", this.f459219xc).put("reason", this.f459146s3).put("recover_reason", r110);     // Catch: JSONException -> L78
        onEventLog(r100, "live_client_monitor_log");     // Catch: JSONException -> L78
        long r107 = this.f459083n3;     // Catch: JSONException -> L78
        if (r107 <= 0) goto L72;
        this.f459083n3 = r107 + 1;     // Catch: JSONException -> L78
    L72:
        JSONObject r108 = new JSONObject();     // Catch: JSONException -> L78
        r108.put("PLAY-StallTime", r100.optLong("stall_end") - this.f459122q3).put(LiveCommonConstants.LOG_PARAM_EVENT_KEY, "stall");     // Catch: JSONException -> L78
        r108.put("PLAY-SessionID", this.T2);     // Catch: JSONException -> L78
        VideoLiveManager r109 = this.f458980f;     // Catch: JSONException -> L78
        if (r109 != null) goto L75;
        return;
    L75:
        if (r109.mEnableOpenStrategyEngine != 1) goto L86;
        LiveStrategyManager.inst().setEventInfo(62, r108);     // Catch: JSONException -> L78
        return;
    L86:
        return;
    L84:
        return;
    L23:
        if (this.f459215x8 != 0) goto L25;
        this.f459215x8 = System.currentTimeMillis();
        goto L25
    }

    public void onStrategyReportInfo(JSONObject r100) {
        if (r100 != null) goto L9;
        return;
    L9:
        onEventLog(createCommonLog().put(LiveCommonConstants.LOG_PARAM_EVENT_KEY, "strategy_report").put("report_info", r100), "live_client_monitor_log");     // Catch: JSONException -> L6
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
    }

    public void onSwitchURL(String r100) {
        this.f459145s = r100;
    }

    public void onUpdateMetaData(String r110) {
        if (r110 != null) goto L55;
        return;
    L55:
        JSONObject r100 = new JSONObject(r110);     // Catch: JSONException -> L52
        if (r100.has("sdk_version") == false) goto L10;
        this.D = JSONObjectProtectorUtils.getString(r100, "sdk_version");     // Catch: JSONException -> L52
    L10:
        if (r100.has("platform") == false) goto L13;
        this.E = JSONObjectProtectorUtils.getString(r100, "platform");     // Catch: JSONException -> L52
    L13:
        if (r100.has("os_version") == false) goto L16;
        this.F = JSONObjectProtectorUtils.getString(r100, "os_version");     // Catch: JSONException -> L52
    L16:
        if (r100.has(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL) == false) goto L19;
        this.G = JSONObjectProtectorUtils.getString(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);     // Catch: JSONException -> L52
    L19:
        if (r100.has(ILoadStallMonitor.START_TIME) == false) goto L22;
        this.H = JSONObjectProtectorUtils.getString(r100, ILoadStallMonitor.START_TIME);     // Catch: JSONException -> L52
    L22:
        if (r100.has("is_hardware_encode") == false) goto L25;
        this.I = JSONObjectProtectorUtils.getInt(r100, "is_hardware_encode");     // Catch: JSONException -> L52
    L25:
        if (r100.has("min_bitrate") == false) goto L28;
        this.f458915J = JSONObjectProtectorUtils.getInt(r100, "min_bitrate");     // Catch: JSONException -> L52
    L28:
        if (r100.has("max_bitrate") == false) goto L31;
        this.K = JSONObjectProtectorUtils.getInt(r100, "max_bitrate");     // Catch: JSONException -> L52
    L31:
        if (r100.has("default_bitrate") == false) goto L34;
        this.L = JSONObjectProtectorUtils.getInt(r100, "default_bitrate");     // Catch: JSONException -> L52
    L34:
        if (r100.has("hit_node_optimize") == false) goto L37;
        this.M = JSONObjectProtectorUtils.getInt(r100, "hit_node_optimize");     // Catch: JSONException -> L52
    L37:
        if (r100.has("push_protocol") == false) goto L40;
        this.N = JSONObjectProtectorUtils.getString(r100, "push_protocol");     // Catch: JSONException -> L52
    L40:
        if (r100.has("qId") == false) goto L43;
        this.O = JSONObjectProtectorUtils.getString(r100, "qId");     // Catch: JSONException -> L52
    L43:
        if (r100.has("link_info") == false) goto L46;
        this.P = JSONObjectProtectorUtils.getString(r100, "link_info");     // Catch: JSONException -> L52
    L46:
        if (r100.has("h_id") == false) goto L49;
        this.f458974e8 = JSONObjectProtectorUtils.getInt(r100, "h_id");     // Catch: JSONException -> L52
    L49:
        if (r100.has("s_id") == false) goto L57;
        this.f458986f8 = JSONObjectProtectorUtils.getInt(r100, "s_id");     // Catch: JSONException -> L52
        return;
    L57:
        return;
    L52:
        e = move-exception;
        e.printStackTrace();
    }

    public void onUpdateSeiDelay(JSONObject r110) {
        if (r110 != null) goto L70;
        return;
    L70:
    L67:
        e = move-exception;
        e.printStackTrace();
        return;
    L7:
        if (this.f459103ob != 1) goto L25;
        if (this.f459130qb.isEmpty() == false) goto L11;
        c.i("LiveLoggerService", "sei_delay parse roll back, we never config source Map");     // Catch: JSONException -> L67
        goto L25
    L11:
        if (r110.has("source") == true) goto L17;
        if (this.f459118pb == 1) goto L17;
        c.i("LiveLoggerService", "sei_delay parse roll back, json has not source obj");     // Catch: JSONException -> L67
    L17:
        if (this.f459130qb.containsKey(r110.optString("source", "")) == false) goto L19;
        c.i("LiveLoggerService", "sei_delay parse successfully ");     // Catch: JSONException -> L67
        this.f459118pb = 1;     // Catch: JSONException -> L67
        goto L25
    L19:
        if (this.f459118pb != 1) goto L21;
        return;
    L21:
        c.i("LiveLoggerService", "sei_delay parse roll back, we never get source in array");     // Catch: JSONException -> L67
    L25:
        if (r110.has("ts") == false) goto L72;
        long r100 = JSONObjectProtectorUtils.getLong(r110, "ts");     // Catch: JSONException -> L67
        long r101 = 0;
        if (this.f459211x4 != 1) goto L40;
        if (r110.has(GameSeiConstants.KEY_GAME_POD_MERGE_STREAM_TT_NTP) == false) goto L40;
        if (JSONObjectProtectorUtils.getInt(r110, GameSeiConstants.KEY_GAME_POD_MERGE_STREAM_TT_NTP) != 1) goto L40;
        if (this.f459171u4 == true) goto L38;
        a r102 = this.f459123q4;     // Catch: JSONException -> L67
        if (r102 == null) goto L38;
        r102.sendEmptyMessageDelayed(103, 0);     // Catch: JSONException -> L67
        this.f459171u4 = true;     // Catch: JSONException -> L67
    L38:
        r101 = this.f459225y4;     // Catch: JSONException -> L67
        this.f459135r4 = true;     // Catch: JSONException -> L67
    L49:
        if (r110.has("ntp_diff") == false) goto L52;
        this.f459147s4 = r110.optInt("ntp_diff", 0);     // Catch: JSONException -> L67
    L52:
        if (r110.has("stream_delay") == false) goto L54;
        long r103 = JSONObjectProtectorUtils.getLong(r110, "stream_delay");     // Catch: JSONException -> L67
    L56:
        if (this.f459197w4 == 1) goto L58;
    L65:
        this.f458968e.f459280f1 = (System.currentTimeMillis() - r100) + r101;     // Catch: JSONException -> L67
        this.f458968e.f459285g1 = r103;     // Catch: JSONException -> L67
        c.i("LiveLoggerService", "sei_delay: " + this.f458968e.f459280f1 + ", push delay: " + this.f458968e.f459285g1);     // Catch: JSONException -> L67
        return;
    L58:
        if (r110.has(GameSeiConstants.KEY_GAME_POD_MERGE_STREAM_TT_NTP) == false) goto L65;
        if (JSONObjectProtectorUtils.getInt(r110, GameSeiConstants.KEY_GAME_POD_MERGE_STREAM_TT_NTP) != 1) goto L65;
        VideoLiveManager r111 = this.f458980f;     // Catch: JSONException -> L67
        if (r111 == null) goto L64;
        this.f459225y4 = r111.getNtpTimeDiff();     // Catch: JSONException -> L67
        c.d("ntp", "ntp_time_diff:" + this.f459225y4);     // Catch: JSONException -> L67
    L64:
        r101 = this.f459225y4;     // Catch: JSONException -> L67
        this.f459135r4 = true;     // Catch: JSONException -> L67
        goto L65
    L54:
        r103 = -1;
    L40:
        if (this.f459171u4 == true) goto L42;
    L47:
        this.f459135r4 = false;     // Catch: JSONException -> L67
        goto L49
    L42:
        if (r110.has(GameSeiConstants.KEY_GAME_POD_MERGE_STREAM_TT_NTP) == true) goto L47;
        a r104 = this.f459123q4;     // Catch: JSONException -> L67
        if (r104 == null) goto L46;
        a.access$000(r104).removeCallbacksAndMessages(null);     // Catch: JSONException -> L67
    L46:
        this.f459171u4 = false;     // Catch: JSONException -> L67
        goto L47
    }

    public void onUpdateSeiInfo(String r210) {
        this.f459071m3 = System.currentTimeMillis();
        if (TextUtils.isEmpty(r210) == false) goto L5;
        return;
    L5:
        if (this.f458968e != null) goto L7;
        return;
    L7:
        if (this.f458980f == null) goto L182;
        JSONObject r110 = new JSONObject(r210);     // Catch: JSONException -> L174
        onUpdateSeiDelay(r110);     // Catch: JSONException -> L174
        String r111 = this.f458968e.f459300j1;     // Catch: JSONException -> L174
        if (r110.has("source") == false) goto L14;
        this.f458968e.f459300j1 = JSONObjectProtectorUtils.getString(r110, "source");     // Catch: JSONException -> L174
    L22:
        if (r111.equals("none") == true) goto L30;
        if (this.f458968e.f459300j1.equals(r111) == true) goto L30;
        if (r111.startsWith("TTLiveSDK") == false) goto L28;
        onLink(true);     // Catch: JSONException -> L174
        goto L30
    L28:
        onLink(false);     // Catch: JSONException -> L174
    L30:
        if (r110.has("app_data") == false) goto L37;
        JSONObject r112 = new JSONObject(r110.optString("app_data"));     // Catch: JSONException -> L174
        if (r112.has("channel_id") == false) goto L35;
        this.f458968e.f459310l1 = JSONObjectProtectorUtils.getString(r112, "channel_id");     // Catch: JSONException -> L174
    L35:
        if (r112.has(BdpAppEventConstant.PARAMS_SUB_SCENE) == false) goto L39;
        this.f458968e.f459325o1 = r112.optInt(BdpAppEventConstant.PARAMS_SUB_SCENE, -1);     // Catch: JSONException -> L174
    L39:
        if (r110.has("real_bitrate") == false) goto L42;
        this.f458968e.f459315m1 = JSONObjectProtectorUtils.getInt(r110, "real_bitrate");     // Catch: JSONException -> L174
        this.f458997g5 = true;     // Catch: JSONException -> L174
    L42:
        if (r110.has("real_video_framerate") == false) goto L46;
        this.f458968e.f459320n1 = JSONObjectProtectorUtils.getInt(r110, "real_video_framerate");     // Catch: JSONException -> L174
        this.f458997g5 = true;     // Catch: JSONException -> L174
    L46:
        if (r110.has("trans_info") == true) goto L50;
        if (r110.has("tans_info") == true) goto L50;
    L56:
        if (this.f459117pa > 0) goto L62;
        if (this.f459129qa == 1) goto L62;
        long r100 = 0;
        r110 = r110;
    L164:
        this.f459117pa = r100;     // Catch: JSONException -> L174
        this.f459129qa = r100;     // Catch: JSONException -> L174
        if (this.f458982f4 == false) goto L169;
        JSONObject r101 = r110;
        if (r101.has("sei_index") == false) goto L171;
        checkSeiIndex(JSONObjectProtectorUtils.getInt(r101, "sei_index"));     // Catch: JSONException -> L174
    L171:
        if (r101.has("cae_category") == false) goto L181;
        this.f458990fc = r101.optInt("cae_category", -1);     // Catch: JSONException -> L174
        return;
    L181:
        return;
    L169:
        r101 = r110;
    L62:
        if (r110.has("push_qos") == false) goto L163;
        JSONObject r102 = JSONObjectProtectorUtils.getJSONObject(r110, "push_qos");     // Catch: JSONException -> L174
        if (r102 == null) goto L163;
        String r113 = "0";
        if (r102.has("audio_stall") == false) goto L76;
        JSONObject r103 = JSONObjectProtectorUtils.getJSONObject(r102, "audio_stall");     // Catch: JSONException -> L174
        if (r103.has("0") == false) goto L71;
        long r114 = calSum(JSONObjectProtectorUtils.getJSONArray(r103, "0"));     // Catch: JSONException -> L174
        this.U3 += r114;     // Catch: JSONException -> L174
    L73:
        if (r103.has("2") == false) goto L75;
        long r104 = this.f459117pa;     // Catch: JSONException -> L174
        this.V3 += r104;     // Catch: JSONException -> L174
    L79:
        if (r102.has("video_stall") == false) goto L92;
        JSONObject r105 = JSONObjectProtectorUtils.getJSONObject(r102, "video_stall");     // Catch: JSONException -> L174
        if (r105.has("0") == false) goto L83;
        long r106 = calSum(JSONObjectProtectorUtils.getJSONArray(r105, "0"));     // Catch: JSONException -> L174
        this.W3 += r106;     // Catch: JSONException -> L174
    L85:
        if (r105.has("1") == false) goto L87;
        long r107 = calSum(JSONObjectProtectorUtils.getJSONArray(r105, "1"));     // Catch: JSONException -> L174
        this.X3 += r107;     // Catch: JSONException -> L174
    L89:
        if (r105.has("2") == false) goto L91;
        long r108 = this.f459117pa;     // Catch: JSONException -> L174
        this.Y3 += r108;     // Catch: JSONException -> L174
        long r109 = r106;
    L94:
        if (r102.has("push_retry_stall") == false) goto L96;
        JSONArray r115 = JSONObjectProtectorUtils.getJSONArray(r102, "push_retry_stall");     // Catch: JSONException -> L174
        this.Z3 = (int) (((long) this.Z3) + this.f459117pa);     // Catch: JSONException -> L174
    L97:
        JSONObject r116 = new JSONObject();     // Catch: JSONException -> L174
        r116.put("audio_stall_time_2", r104).put("video_stall_time_2", r108);     // Catch: JSONException -> L174
        if (this.f459117pa <= 0) goto L108;
        if (r104 == 0) goto L102;
    L103:
        onPushStall(r116, r115, "push_stall");     // Catch: JSONException -> L174
        if (this.f458934b5 != null) goto L106;
        this.f458934b5 = new ArrayList();     // Catch: JSONException -> L174
    L106:
        this.f458934b5.add(Long.valueOf(this.f459071m3 - this.f459033j3));     // Catch: JSONException -> L174
        goto L108
    L102:
        if (r108 != 0) goto L103;
    L108:
        long r117 = r107;
        r116.put("audio_stall_time_0", r114).put("video_stall_time_0", r109).put("video_stall_time_1", r117);     // Catch: JSONException -> L174
        if (this.f459129qa == 1) goto L111;
    L162:
        r100 = 0;
        goto L164
    L111:
        if (r114 == 0) goto L113;
    L120:
        onPushStall(r116, r115, "push_render_stall");     // Catch: JSONException -> L174
        if (r114 == 0) goto L124;
    L128:
        StringBuilder r118 = new StringBuilder();     // Catch: JSONException -> L174
        if (r114 != 0) goto L131;
        String r119 = "";
    L132:
        r118.append(r119);     // Catch: JSONException -> L174
        if (r104 != 0) goto L135;
        String r120 = "";
    L136:
        r118.append(r120);     // Catch: JSONException -> L174
        String r121 = r118.toString();     // Catch: JSONException -> L174
        Object r122 = r11;
        if (this.f458947c5.equals(r122) == false) goto L139;
        this.f458947c5 = (this.f459071m3 - this.f459033j3) + ":" + r121;     // Catch: JSONException -> L174
    L141:
        if (r109 == 0) goto L143;
    L146:
        StringBuilder r123 = new StringBuilder();     // Catch: JSONException -> L174
        if (r109 != 0) goto L149;
        String r124 = "";
    L150:
        r123.append(r124);     // Catch: JSONException -> L174
        if (r117 != 0) goto L153;
        String r125 = "";
    L154:
        r123.append(r125);     // Catch: JSONException -> L174
        if (r108 != 0) goto L157;
        String r126 = "";
    L158:
        r123.append(r126);     // Catch: JSONException -> L174
        String r127 = r123.toString();     // Catch: JSONException -> L174
        if (this.f458959d5.equals(r122) == false) goto L161;
        this.f458959d5 = (this.f459071m3 - this.f459033j3) + ":" + r127;     // Catch: JSONException -> L174
        goto L162
    L161:
        this.f458959d5 += "," + (this.f459071m3 - this.f459033j3) + ":" + r127;     // Catch: JSONException -> L174
        goto L162
    L157:
        r126 = "2";
        goto L158
    L153:
        r125 = "1";
        goto L154
    L149:
        r124 = r113;
        goto L150
    L143:
        if (r117 != 0) goto L146;
        if (r108 == 0) goto L162;
    L139:
        this.f458947c5 += "," + (this.f459071m3 - this.f459033j3) + ":" + r121;     // Catch: JSONException -> L174
        goto L141
    L135:
        r120 = r4;
        goto L136
    L131:
        r119 = r113;
        goto L132
    L124:
        if (r104 != 0) goto L128;
        r122 = "none";
        goto L141
    L113:
        if (r104 != 0) goto L120;
        if (r109 != 0) goto L120;
        if (r117 != 0) goto L120;
        if (r108 == 0) goto L162;
    L96:
        r115 = null;
        goto L97
    L91:
        r109 = r106;
        r108 = 0;
        goto L94
    L87:
        r107 = 0;
        goto L89
    L83:
        r106 = 0;
        goto L85
    L92:
        r113 = "0";
        r109 = 0;
        r108 = 0;
        r107 = 0;
        goto L94
    L75:
        r104 = 0;
        goto L79
    L71:
        r114 = 0;
        goto L73
    L76:
        r104 = 0;
        r114 = 0;
    L163:
        r110 = r110;
        r100 = 0;
    L50:
        if (r110.has("trans_info") == false) goto L52;
        JSONObject r128 = JSONObjectProtectorUtils.getJSONObject(r110, "trans_info");     // Catch: JSONException -> L174
    L53:
        if (r128 == null) goto L56;
        checkVideoFrame(JSONObjectProtectorUtils.getInt(r128, "index"), JSONObjectProtectorUtils.getInt(r128, "sent_frames"), JSONObjectProtectorUtils.getInt(r128, "checked_dts"));     // Catch: JSONException -> L174
        goto L56
    L52:
        r128 = JSONObjectProtectorUtils.getJSONObject(r110, "tans_info");     // Catch: JSONException -> L174
        goto L53
    L37:
        this.f458968e.f459310l1 = "none";     // Catch: JSONException -> L174
        goto L39
    L14:
        if (r110.has("app_data") == false) goto L22;
        JSONObject r129 = new JSONObject(r110.optString("app_data"));     // Catch: JSONException -> L174
        if (r129.has(Constants.OperatorKey.KEY_VENDOR) == false) goto L19;
        this.f458968e.f459300j1 = JSONObjectProtectorUtils.getString(r129, Constants.OperatorKey.KEY_VENDOR);     // Catch: JSONException -> L174
    L19:
        if (r129.has("ver") == false) goto L22;
        this.f458968e.f459305k1 = r129.optInt("ver");     // Catch: JSONException -> L174
    L174:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public void openNodeOptimizer(boolean r100) {
        this.R = r100;
    }

    public void reset(boolean r110) {
        if (this.f459220xd != 1) goto L5;
        resetSessionInfo();
    L5:
        this.f459133r = "none";
        this.f459145s = "none";
        this.f459157t = "none";
        this.f459169u = false;
        this.f459207x = 0;
        this.D = "none";
        this.E = "none";
        this.F = "none";
        this.G = "none";
        this.H = "none";
        this.I = -1;
        this.f458915J = -1;
        this.K = -1;
        this.L = -1;
        this.M = -1;
        this.N = "none";
        this.O = "none";
        this.S = "none";
        this.W = false;
        this.T = -1;
        this.V = -1;
        this.X = false;
        this.Y = false;
        this.D6 = false;
        this.K4 = -1;
        this.L0 = 1;
        this.P0 = false;
        this.V0 = 0;
        this.f458993g1 = -1;
        this.f458930b1 = -1;
        this.f459007h1 = -1;
        this.f459046k1 = -1;
        this.f459108p1 = -1;
        this.f459182v1 = 0;
        this.f459208x1 = 0;
        this.f459222y1 = 0;
        this.G1 = 0;
        this.H1 = 0;
        this.L1 = 0;
        this.M1 = -1.0f;
        this.P1 = -1;
        this.Q1 = -1.0f;
        this.f459008h2 = 0;
        this.f459109p2 = "none";
        this.f459209x2 = 0;
        this.P2 = -1;
        this.E2 = 0;
        this.f459223y2 = 2000;
        this.F2 = -1;
        this.G2 = 0;
        this.H2 = 0;
        this.I2 = 0;
        this.J2 = 0;
        this.L2 = 0;
        this.f459049k5 = -1;
        this.f459035j5 = 0;
        this.f459061l5 = 0;
        this.f459073m5 = 1;
        this.f459085n5 = 0;
        this.f459009h3 = false;
        this.f459033j3 = 0;
        this.f458926ac = 0;
        this.f458966dc = 0;
        this.f459095o3 = 0;
        this.f459122q3 = 0;
        this.f459146s3 = -1;
        this.f459158t3 = 0;
        this.f459170u3 = 0;
        this.I3 = 0;
        this.H3 = 0;
        this.K3 = 0;
        this.J3 = 0;
        this.f459048k4 = 0;
        this.f459060l4 = 0;
        this.f459022i4 = false;
        this.L3 = false;
        this.M3 = 0;
        this.N3 = 0;
        this.Q3 = 0;
        this.R3 = 0;
        this.O3 = 0;
        this.P3 = 0;
        this.f459134r3 = 0;
        this.S3 = 0;
        this.T3 = 0;
        this.U3 = 0;
        this.V3 = 0;
        this.W3 = 0;
        this.X3 = 0;
        this.Y3 = 0;
        this.Z3 = 0;
        this.f459020i = 0;
        this.f458918a4 = 0;
        this.f458933b4 = 0;
        this.I5 = 0;
        this.J5 = "none";
        this.f458958d4 = -1;
        this.f459135r4 = false;
        this.f459147s4 = 0;
        this.f459225y4 = 0;
        this.f459197w4 = 0;
        this.f459211x4 = 0;
        this.I4 = 0;
        this.J4 = 0;
        this.f459124q5 = -1;
        this.f459238z5 = false;
        this.f459226y5 = 0;
        this.B5 = false;
        this.C5 = -1.0f;
        this.D5 = 0;
        this.f459000g8 = 0;
        this.Q4 = null;
        this.R4 = null;
        this.S4 = null;
        this.Z4 = null;
        this.f458919a5 = null;
        this.Y4 = null;
        this.T4 = null;
        this.U4 = null;
        this.V4 = -1;
        this.f459183v2 = "none";
        this.W4 = "none";
        this.X4 = "none";
        this.f458959d5 = "none";
        this.f458947c5 = "none";
        this.f458934b5 = null;
        LogBundle r111 = this.f458968e;
        if (r111 == null) goto L8;
        r111.reset();
    L8:
        this.f459107p0 = "none";
        this.Z = "none";
        this.f459172u5 = 1;
        this.H0 = 0;
        this.Q2 = "none";
        this.R2 = "none";
        this.T2 = "none";
        this.W5 = "none";
        this.X5 = "none";
        this.Y5 = "none";
        this.Ka = "none";
        this.W2 = "none";
        this.X2 = "";
        this.Y2 = 0;
        this.Z2 = 0;
        this.f458917a3 = 0;
        this.f458932b3 = 0;
        this.f458945c3 = 2;
        this.f458957d3 = 3000;
        this.T5 = 0;
        this.A4 = 0;
        this.f459237z4 = 0;
        this.B4 = 0;
        this.D4 = -1;
        this.F6 = 0;
        this.E6 = 0;
        this.K6 = 0;
        this.Gb = 0;
        this.Fb = 0;
        this.Ib = 0;
        this.Jb = 0;
        this.Kb = 0;
        this.Lb = 0;
        this.Mb = 0;
        this.Nb = 0;
        this.Z5 = false;
        this.f458935b6 = false;
        this.f458920a6 = "rad";
        this.f458948c6 = PlayerResolution.SDKKEY.ORIGIN;
        this.f459036j6 = PlayerResolution.SDKKEY.ORIGIN;
        this.f459050k6 = "none";
        this.f459074m6 = -1;
        this.f459062l6 = -1;
        this.f459086n6 = 0;
        this.f459098o6 = "none";
        this.B6 = "none";
        this.f459213x6 = -1;
        this.f459227y6 = -1;
        this.f459239z6 = -1;
        this.A6 = -1;
        this.C6 = 4;
        this.f459113p6 = false;
        this.f459125q6 = -1;
        this.S6 = -1;
        this.U6 = -1;
        this.T6 = -1;
        this.V6 = -1;
        this.W6 = -1;
        this.X6 = -1;
        this.Y6 = -1;
        this.Z6 = -1;
        this.N6 = 0;
        this.O6 = 0;
        this.P6 = 0;
        this.Q6 = -1;
        this.f458921a7 = 0;
        this.f458936b7 = 0;
        this.f459165ta = 0;
        this.f459177ua = 0;
        this.f459191va = 0;
        this.f459217xa = 0;
        this.f459203wa = 0;
        this.f459231ya = 0;
        this.f459243za = 0;
        this.Ca = 0;
        this.Da = "none";
        this.Ea = 0;
        this.Fa = 0;
        this.Ga = 0;
        this.Ha = 0;
        this.M2 = 0;
        this.N2 = -1;
        this.O2 = -1.0f;
        this.Aa = 0;
        this.f458949c7 = null;
        this.f459138r7 = 0;
        this.I7 = 0;
        this.K7 = 0;
        this.J7 = 0;
        this.O7 = "none";
        this.P7 = "none";
        this.f458922a8 = 0;
        this.X7 = "none";
        this.Y7 = null;
        this.Z7 = "none";
        this.f458962d8 = 0;
        this.f458974e8 = -1;
        this.f458986f8 = -1;
        this.f459014h8 = 1;
        this.f459115p8 = 0;
        this.B8 = 0;
        this.C8 = 0;
        this.D8 = 0;
        this.E8 = 0;
        this.F8 = 0;
        this.O8 = 0;
        this.P8 = 0;
        this.Q8 = 0;
        this.f458939ba = 0;
        this.f458952ca = 0;
        this.f458964da = 0;
        this.f458976ea = 0;
        this.f459028ia = "";
        this.f459016ha = "";
        this.C4 = 0;
        this.H9 = 0;
        this.I9 = 0;
        this.J9 = 0;
        this.K9 = 0;
        this.L9 = "none";
        this.M9 = 0;
        this.O9 = "none";
        this.P9 = 0;
        this.Q9 = 0;
        this.R9 = 0;
        this.E4 = 0;
        this.T9 = 0;
        this.U9 = 0;
        this.S9 = 0;
        this.V9 = "none";
        this.W9 = "none";
        this.X9 = 0;
        this.Y9 = 0;
        this.F4 = 0;
        this.f459054ka = 0;
        this.f459066la = 0;
        this.f459078ma = -1;
        this.f459090na = 0;
        this.f459184v3 = 0;
        this.f459196w3 = 0;
        this.f459210x3 = 0;
        this.f459224y3 = 0;
        this.f459236z3 = 0;
        this.A3 = 0;
        this.C3 = 0;
        this.B3 = 0;
        this.E3 = 0;
        this.D3 = 0;
        this.F3 = 0;
        this.G3 = 0;
        this.f458951c9 = 0;
        this.f458963d9 = 0;
        this.f458975e9 = 0;
        this.f458987f9 = 0;
        this.f459001g9 = 0;
        this.f459015h9 = 0;
        this.f459027i9 = 0;
        this.f459039j9 = 0;
        this.D9 = 0;
        this.E9 = 0;
        this.F9 = 0;
        this.S8 = 0;
        this.U8 = 0;
        this.R8 = 0;
        this.T8 = 0;
        this.f459116p9 = 0;
        this.f459140r9 = 0;
        this.f459101o9 = 0;
        this.f459128q9 = 0;
        this.f459152s9 = -1;
        this.f459164t9 = -1;
        this.f459176u9 = -1;
        this.f459190v9 = 0;
        this.f459202w9 = 0;
        this.f459216x9 = 0;
        this.f459230y9 = 0;
        this.f459242z9 = 0;
        this.A9 = 0;
        this.B9 = 0;
        this.C9 = 0;
        this.f459053k9 = 0;
        this.f459077m9 = 0;
        this.f459065l9 = 0;
        this.f459089n9 = 0;
        this.Z8 = 0;
        this.f458923a9 = 0;
        this.f458938b9 = 0;
        this.f459141ra = "none";
        this.Ia = 0;
        this.Ja = 0;
        this.Na = null;
        this.Oa = "none";
        this.Pa = "none";
        this.Qa = false;
        this.R5 = -1;
        this.Ta = 0;
        this.Va = 0;
        this.Wa = 0;
        this.Za = 0;
        this.f458925ab = 0;
        this.f458940bb = 0;
        this.f459003gb = null;
        this.f459017hb = null;
        this.f459029ib = null;
        this.f459041jb = null;
        this.f459055kb = null;
        this.f459067lb = null;
        this.f459079mb = null;
        this.f459091nb = null;
        this.f459103ob = 0;
        this.f459130qb = null;
        this.f459118pb = -1;
        this.f459154sb = -1;
        this.f459013h7 = 0;
        this.f459025i7 = 0;
        this.f459037j7 = 0;
        this.f459051k7 = 0;
        this.f459166tb = 0;
        this.f459178ub = "none";
        this.f459192vb = "none";
        this.Eb = 0;
        this.Db = 0;
        this.Ob = 0;
        this.Ub = 0;
        this.Vb = 0;
        this.Wb = 0;
        this.Xb = 0;
        if (r110 == false) goto L11;
        this.L7 = 0;
        this.A7 = 0;
    L11:
        this.f458990fc = -1;
        this.f459004gc = -1;
        this.f459018hc = -1;
        this.A5 = false;
        this.Yb = -1.0f;
        this.f459233yc = "";
        this.Bc = -1;
        this.Cc = "";
        this.Dc = "";
        this.Zb = 0;
        this.f458916a = -1;
        this.f459063l7 = -1;
        this.f459075m7 = -1;
        LinkedBlockingQueue<Integer> r112 = this.f459087n7;
        if (r112 == null) goto L14;
        r112.clear();
        this.f459087n7 = null;
    L14:
        this.f459114p7 = new ArrayList();
        this.f459126q7 = new ArrayList();
        this.f459099o7 = "none";
        this.Ic = -99;
        this.G8 = 0;
        this.H8 = 0;
        this.I8 = 0;
        this.J8 = 0;
        this.f459150s7 = new ArrayList();
        this.f459162t7 = new ArrayList();
        this.K8 = 0;
        this.L8 = 0;
        this.M8 = 0;
        this.N8 = 0;
        this.f459174u7 = new ArrayList();
        this.f459188v7 = new ArrayList();
        this.f459132qd = 0;
        this.f459144rd = new ArrayList();
        this.H6 = 0;
        this.G6 = 0;
    }

    public void setApplog(b r100) {
        this.f459072m4 = r100;
    }

    public void setBusinessType(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L6;
        this.f459106p = r100;
        return;
    }

    public void setCheckSilenceInterval(int r100) {
        int r101 = 0;
        if (r100 <= 0) goto L5;
        boolean r102 = true;
    L6:
        this.f458946c4 = r102;
        if (r100 > 0) goto L10;
        r101 = -1;
    L10:
        this.f458958d4 = r101;
        return;
    L5:
        r102 = false;
        goto L6
    }

    public void setCodecType(String r100) {
        this.Z = r100;
    }

    public void setCommonFlag(String r100) {
        if (r100 == null) goto L5;
        this.f459070m = r100;
        return;
    }

    public void setCommonNeptuneTrace(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L6;
        this.f459082n = r100;
        return;
    }

    public void setDegradeForNetChange(boolean r100) {
        this.N5 = r100;
    }

    public void setEvaluatorSymbol(String r100) {
        if (r100 == null) goto L5;
        this.S = r100;
        return;
    }

    public void setFastFirstFrame(int r100) {
        this.T5 = r100;
    }

    public void setFreeFlowStatus(int r100) {
        this.Q = r100;
    }

    public void setHttpxParams(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L10;
        return;
    L10:
        this.O5 = new JSONObject(r100);     // Catch: JSONException -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    public void setIsChangeNetWorkType(boolean r100) {
        this.M5 = r100;
    }

    public void setLSSResponseCost(int r100) {
        this.T = r100;
    }

    public void setLSSResponseStatusCode(int r100) {
        this.V = r100;
    }

    public void setLiveIO(wmc.a r100) {
        this.G9 = r100;
    }

    public void setOriginUrl(String r100) {
        this.K5 = r100;
    }

    public void setPlayLogInterval(long r100) {
        if (r100 < 2000) goto L6;
        this.f458992g = r100;
        return;
    }

    public void setPlayerSdkVersion(String r100) {
        this.f459181v = r100;
    }

    public void setPreconnect(int r100) {
        this.K4 = r100;
    }

    public void setPreconnectMetrics(int r100) {
        this.N4 = r100;
    }

    public void setPreplayShow(int r100) {
        if (r100 == 1) goto L5;
        return;
    L5:
        if (this.f459020i != 0) goto L9;
        this.f459020i = System.currentTimeMillis();
        return;
    }

    public void setPreviewFlag(boolean r100) {
        this.f459195w = r100;
    }

    public void setProjectKey(String r100) {
        this.f459121q = r100;
    }

    public void setPureColorUploadAllInfo(boolean r100) {
        this.f459005gd = r100;
    }

    public void setQuicLibLoader(int r100) {
        this.H5 = r100;
    }

    public void setRemoteSorted(boolean r100) {
        this.X = r100;
    }

    public void setRtcPlayLogInterval(long r100) {
        if (r100 < 2000) goto L6;
        this.f459040ja = r100;
        return;
    }

    public void setSVCPlayType(int r100) {
        this.Ic = r100;
    }

    public void setSceneTags(JSONObject r100) {
        if (r100 == null) goto L5;
        this.f459094o = r100;
        return;
    }

    public void setSettingBundle(g r100) {
        this.f459011h5 = r100;
        if (r100 == null) goto L8;
        this.f459014h8 = ((Integer) r100.getSettingsValueForKey("live_sdk_should_report_session_stop", 0)).intValue();
        c.i("LiveLoggerService", "enable report sessionstop: " + this.f459014h8);
        if (this.f459014h8 != 1) goto L9;
        this.f459026i8 = new LogBundle();
        return;
    L9:
        return;
    }

    public void setStallBufferDataMs(int r100) {
        this.Ec = r100;
    }

    public void setStreamDisplayModel(String r100) {
        if (this.f459038j8 == false) goto L5;
        computeDisplayTime();
    L5:
        this.Ld = System.currentTimeMillis();
        if (TextUtils.equals(r100, this.Ed) == false) goto L9;
        this.Nd = DisplayModel.INITAL;
        return;
    L9:
        if (TextUtils.equals(r100, this.Fd) == false) goto L12;
        this.Nd = DisplayModel.PREVIEW;
        c.i("LiveLoggerService", "setStreamDisplayModel :preview");
        return;
    L12:
        if (TextUtils.equals(r100, this.Gd) == false) goto L15;
        this.Nd = DisplayModel.INNER;
        c.i("LiveLoggerService", "setStreamDisplayModel : inner");
        return;
    L15:
        if (TextUtils.equals(r100, this.Kd) == false) goto L18;
        this.Nd = DisplayModel.SMALL_WINDOW;
        return;
    L18:
        if (TextUtils.equals(r100, this.Jd) == false) goto L21;
        this.Nd = DisplayModel.BACKGROUND;
        return;
    L21:
        if (TextUtils.equals(r100, this.Hd) == false) goto L24;
        this.Nd = DisplayModel.PREVIEW_PREPLAY;
        return;
    L24:
        if (TextUtils.equals(r100, this.Id) == false) goto L26;
        this.Nd = DisplayModel.INNER_PREPLAY;
        return;
    L26:
        this.Nd = DisplayModel.OTHER;
        this.Od = r100;
    }

    public void setUsePullSuccessV2(int r100) {
        this.f459084n4 = r100;
    }

    public void setWaitTime(long r100) {
        LogBundle r101 = this.f458968e;
        if (r101 == null) goto L5;
        r101.f459270d1 = r100;
    L5:
        LogBundle r102 = this.f459026i8;
        if (r102 == null) goto L9;
        r102.f459270d1 = r100;
        return;
    }

    public boolean updateLogInfo(int r100) {
        VideoLiveManager r101 = this.f458980f;
        if (r101 != null) goto L5;
        return false;
    L5:
        if (this.f458956d == null) goto L16;
        LogBundle r102 = this.f458968e;
        if (r102 != null) goto L10;
        return false;
    L10:
        if (r100 != 1) goto L12;
        this.f459056kc = r102.f459354u0;
        this.f459068lc = r102.M0;
        this.f459080mc = r102.f459349t0;
        this.f459092nc = r102.O0;
        this.P6 = r102.N0;
    L12:
        r101.getLogInfo(r102, r100);
        return true;
    L16:
        return false;
    }

    public static /* synthetic */ InetAddress access$302(LiveLoggerService r100, InetAddress r101) {
        r100.f459111p4 = r101;
        return r101;
    }

    private void addBmfSrBasicInfo(JSONObject r100, boolean r101) throws JSONException {
        addBmfSrSharpInfo(r100, r101);
        if (r101 == false) goto L6;
        r100.put("sr_alg_type", this.f458980f.getSRAlgType());
        return;
    }

    private void addBmfSrSharpInfo(JSONObject r100, boolean r101) throws JSONException {
        r100.put("sr_used", r101 ? 1 : 0);
        if (r101 == false) goto L6;
        r100.put("sr_scale_type", this.f458980f.getSRScaleReportType());
        r100.put("sr_sharp_level", this.f458980f.getSRSharpLevel());
        return;
    }

    private void onEventLog(JSONObject r100, String r101) {
        r100 = (JSONObject) performVideoLiveManagerMethod("handleMonitorLog", new Object[]{r100});     // Catch: Exception -> L4
    L6:
        addUniqueIDToEvent(r100);
        if (enableApplogReportEvent(r100) == false) goto L11;
        b r102 = this.f459072m4;
        if (r102 == null) goto L22;
        r102.onMonitorLog(r100, r101);
        return;
    L22:
        return;
    L11:
        VideoLiveManager r103 = this.f458980f;
        if (r103 == null) goto L16;
        g0 r104 = r103.mObserver;
        if (r104 == null) goto L16;
        r104.onMonitorLog(r103, r100, r101);
        return;
    L16:
        com.ss.videoarch.liveplayer.e r105 = this.f458956d;
        if (r105 == null) goto L25;
        r105.onMonitorLog(r100, r101);
        return;
    L25:
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
        goto L6
    }

    private void reportABRFirstFrame(JSONObject r100, JSONObject r101) {
        int r102 = r100.optInt("result", 0);
        LogBundle r103 = this.f459026i8;
        if (r103 == null) goto L5;
        r103.f459253a = System.currentTimeMillis();
    L5:
        reportSessionFirstFrame(r101, r102, LiveError.ABR_SWITCH_FIRST_FRAME);
    }

    private void setExtParam(JSONObject r100, JSONObject r101) {
        if (r101 == null) goto L16;
        if (r100 == null) goto L17;
        Iterator<String> r102 = r101.keys();     // Catch: JSONException -> L9
    L6:
        if (r102.hasNext() == false) goto L18;
        String r103 = r102.next();     // Catch: JSONException -> L9
        r100.put(r103, r101.get(r103));     // Catch: JSONException -> L9
        goto L6
    L18:
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
        return;
    L17:
        return;
    }

    public long getInt64Value(String r100, long r101) {
        r100.getClass();
        byte r102 = -1;
        switch(r100.hashCode()) {
            case -159477514: goto L14;
            case 61193033: goto L10;
            case 1653721288: goto L6;
            default: goto L17;
        };
    L17:
        switch(r102) {
            case 0: goto L22;
            case 1: goto L24;
            case 2: goto L23;
            default: goto L25;
        };
    L25:
        return r101;
    L23:
        return this.f458968e.f459253a;
    L24:
        return this.f458968e.Q0;
    L22:
        return this.M9;
    L6:
        if (r100.equals("PLAY-StartTs") == false) goto L17;
        r102 = 2;
        goto L17
    L10:
        if (r100.equals("PLAY-FirstFrameDownloadSpeed") == false) goto L17;
        r102 = 1;
        goto L17
    L14:
        if (r100.equals("PLAY-FirstFrame") == false) goto L17;
        r102 = 0;
        goto L17
    }

    public void onAbrDecisionInfo(long r100, String r110) {
        if (this.f459017hb != null) goto L30;
        this.f459017hb = new ArrayList();
        this.f459029ib = new ArrayList();
        this.f459041jb = new ArrayList();
        this.f459055kb = new ArrayList();
        this.f459067lb = new ArrayList();
        this.f459079mb = new ArrayList();
        this.f459091nb = new ArrayList();
    L30:
        JSONObject r101 = new JSONObject(r110);     // Catch: JSONException -> L27
        this.f459017hb.add(Long.valueOf(r100));     // Catch: JSONException -> L27
        if (r101.has("current_download_speed") == false) goto L9;
        this.f459055kb.add(Long.valueOf(r101.optLong("current_download_speed")));     // Catch: JSONException -> L27
    L9:
        if (r101.has("current_bitrate") == false) goto L12;
        this.f459029ib.add(Long.valueOf(r101.optLong("current_bitrate")));     // Catch: JSONException -> L27
    L12:
        if (r101.has("predict_bitrate") == false) goto L15;
        this.f459041jb.add(Long.valueOf(r101.optLong("predict_bitrate")));     // Catch: JSONException -> L27
    L15:
        if (r101.has("probe_bandwidth") == false) goto L18;
        this.f459067lb.add(Long.valueOf(r101.optLong("probe_bandwidth")));     // Catch: JSONException -> L27
    L18:
        if (r101.has("is_buffering") == false) goto L24;
        if (r101.optInt("is_buffering") != 1) goto L22;
        this.f459091nb.add(1);     // Catch: JSONException -> L27
        goto L24
    L22:
        this.f459091nb.add(0);     // Catch: JSONException -> L27
    L24:
        if (r101.has("buffer_len") == false) goto L32;
        this.f459079mb.add(Double.valueOf(r101.optDouble("buffer_len")));     // Catch: JSONException -> L27
        return;
    L32:
        return;
    L27:
        e = move-exception;
        e.printStackTrace();
    }

    public void onAudioDTSRollback(long r100, long r101) {
        JSONObject r102 = createCommonLog();
        if (r102 == null) goto L13;
        r102.put(LiveCommonConstants.LOG_PARAM_EVENT_KEY, "timestamp_rollback").put("packet_type", "audio").put("timestamp_type", "dts").put("latest_ts", r101).put("previous_ts", r100);     // Catch: JSONException -> L8
        onEventLog(r102, "live_client_monitor_log");     // Catch: JSONException -> L8
        long r103 = this.f459083n3;     // Catch: JSONException -> L8
        if (r103 <= 0) goto L14;
        this.f459083n3 = r103 + 1;     // Catch: JSONException -> L8
        return;
    L14:
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public void onAudioDecodeStall(long r100, int r101) {
        if (r100 <= (System.currentTimeMillis() - this.f458968e.f459253a)) goto L5;
    L20:
        c.i("LiveLoggerService", "abnormal demux stall time" + r100);
        return;
    L5:
        if (r100 <= r101) goto L20;
        this.M8++;
        this.N8 += r100;
        this.D8++;
        this.E8 += r100;
        if (isPreview() == false) goto L10;
        this.f458975e9++;
        this.f458987f9 += r100;
    L10:
        this.f459188v7.add(System.currentTimeMillis() + ":" + r100);
        JSONObject r102 = new JSONObject();     // Catch: JSONException -> L17
        r102.put("PLAY-StallType", 0).put("PLAY-StallTime", r100).put(LiveCommonConstants.LOG_PARAM_EVENT_KEY, "decode_stall");     // Catch: JSONException -> L17
        r102.put("PLAY-SessionID", this.T2);     // Catch: JSONException -> L17
        VideoLiveManager r103 = this.f458980f;     // Catch: JSONException -> L17
        if (r103 != null) goto L14;
        return;
    L14:
        if (r103.mEnableOpenStrategyEngine != 1) goto L25;
        LiveStrategyManager.inst().setEventInfo(62, r102);     // Catch: JSONException -> L17
        return;
    L25:
        return;
    L17:
        e = move-exception;
        e.printStackTrace();
    }

    public void onAudioDemuxerStall(long r100, int r101) {
        if (r100 <= (System.currentTimeMillis() - this.f458968e.f459253a)) goto L5;
    L20:
        c.i("LiveLoggerService", "abnormal demux stall time" + r100);
        return;
    L5:
        if (r100 <= r101) goto L20;
        this.I8++;
        this.J8 += r100;
        this.P8++;
        this.Q8 += r100;
        if (isPreview() == false) goto L10;
        this.f459027i9++;
        this.f459039j9 += r100;
    L10:
        this.f459162t7.add(System.currentTimeMillis() + ":" + r100);
        JSONObject r102 = new JSONObject();     // Catch: JSONException -> L17
        r102.put("PLAY-StallType", 1).put("PLAY-StallTime", r100).put(LiveCommonConstants.LOG_PARAM_EVENT_KEY, "demux_stall");     // Catch: JSONException -> L17
        r102.put("PLAY-SessionID", this.T2);     // Catch: JSONException -> L17
        VideoLiveManager r103 = this.f458980f;     // Catch: JSONException -> L17
        if (r103 != null) goto L14;
        return;
    L14:
        if (r103.mEnableOpenStrategyEngine != 1) goto L25;
        LiveStrategyManager.inst().setEventInfo(62, r102);     // Catch: JSONException -> L17
        return;
    L25:
        return;
    L17:
        e = move-exception;
        e.printStackTrace();
    }

    public void onError(int r100, String r101) {
        if (this.Y4 != null) goto L23;
        this.Y4 = new JSONObject();
    L23:
        this.Y4.put(Long.toString(System.currentTimeMillis() - this.f458968e.f459253a), r100);     // Catch: JSONException -> L7
    L9:
        this.f458980f.getLogInfo(this.f458968e, 2);
        JSONObject r102 = createCommonLog();
        this.f458980f.getCurrentAccessCode();
        if (r102 == null) goto L25;
        r102.put(LiveCommonConstants.LOG_PARAM_EVENT_KEY, "play_error").put("code", r100).put("info", r101);     // Catch: JSONException -> L18
        reportQuicOpenResult(r102);     // Catch: JSONException -> L18
        onEventLog(r102, "live_client_monitor_log");     // Catch: JSONException -> L18
        long r103 = this.f459083n3;     // Catch: JSONException -> L18
        if (r103 <= 0) goto L14;
        this.f459083n3 = r103 + 1;     // Catch: JSONException -> L18
    L14:
        this.f459095o3 = r100;     // Catch: JSONException -> L18
        if (isRtcPlayAvailable() == false) goto L26;
        this.f459214x7 = r100;     // Catch: JSONException -> L18
        return;
    L26:
        return;
    L18:
        e = move-exception;
        e.printStackTrace();
        return;
    L25:
        return;
    L7:
        e = move-exception;
        this.Y4 = null;
        e.printStackTrace();
        goto L9
    }

    public void onFirstFrame(long r210, long r211) {
        this.f459009h3 = true;
        this.N6 = this.f458933b4;
        this.O6 = this.P6;
        this.f459033j3 = System.currentTimeMillis();
        this.f458926ac = System.currentTimeMillis();
        this.f458941bc = System.currentTimeMillis();
        this.f459038j8 = true;
        this.f459064l8 = System.currentTimeMillis();
        this.f459076m8 = System.currentTimeMillis();
        if (isPreview() == false) goto L6;
        this.E9 = this.f459033j3;
    L6:
        if (this.f458980f == null) goto L71;
        LogBundle r100 = this.f458968e;
        if (r100 != null) goto L69;
        return;
    L69:
        r100.M0 = System.currentTimeMillis();     // Catch: JSONException -> L66
        if (isPreview() == false) goto L14;
        LogBundle r101 = this.f458968e;     // Catch: JSONException -> L66
        r101.N0 = r101.M0;     // Catch: JSONException -> L66
    L14:
        this.f458980f.getLogInfo(this.f458968e, 0);     // Catch: JSONException -> L66
        JSONObject r102 = createFirstFrameLog(this.f458968e, r210, this.Y, r211);     // Catch: JSONException -> L66
        this.M9 = this.f459033j3 - this.f458968e.f459253a;     // Catch: JSONException -> L66
        if (isRtcPlayAvailable() == false) goto L19;
        VideoLiveManager r103 = this.f458980f;     // Catch: JSONException -> L66
        if (r103 == null) goto L19;
        r103.onRTMLog(5, "rtc_play_url:" + this.f459133r);     // Catch: JSONException -> L66
        this.f458980f.onRTMLog(5, "mFirstFrameView:" + this.M9);     // Catch: JSONException -> L66
        this.f458980f.onRTMLog(5, "startPlayTime:" + this.f458968e.f459253a + ",mFirstFrameTimestamp:" + this.f459033j3);     // Catch: JSONException -> L66
        VideoLiveManager r104 = this.f458980f;     // Catch: JSONException -> L66
        StringBuilder r105 = new StringBuilder("rtc_inited_end:");     // Catch: JSONException -> L66
        r105.append(this.f458968e.f459296i2);     // Catch: JSONException -> L66
        r104.onRTMLog(5, r105.toString());     // Catch: JSONException -> L66
        VideoLiveManager r106 = this.f458980f;     // Catch: JSONException -> L66
        StringBuilder r107 = new StringBuilder("start_2_init_diff: ");     // Catch: JSONException -> L66
        LogBundle r108 = this.f458968e;     // Catch: JSONException -> L66
        r107.append(r108.f459296i2 - r108.f459253a);     // Catch: JSONException -> L66
        r106.onRTMLog(5, r107.toString());     // Catch: JSONException -> L66
        this.f458980f.onRTMLog(5, "rtc_offer_send_end:" + this.f458968e.f459316m2);     // Catch: JSONException -> L66
        this.f458980f.onRTMLog(5, "rtc_answer_recv_end:" + this.f458968e.f459321n2);     // Catch: JSONException -> L66
        this.f458980f.onRTMLog(5, "rtc_ice_connected_time:" + this.f458968e.f459336q2);     // Catch: JSONException -> L66
        this.f458980f.onRTMLog(5, "first_video_package_end:" + this.f458968e.f459308l);     // Catch: JSONException -> L66
        this.f458980f.onRTMLog(5, "first_video_frame_end:" + this.f458968e.f459346s2);     // Catch: JSONException -> L66
        this.f458980f.onRTMLog(5, "first_video_frame_decode_start:" + this.f458968e.f459356u2);     // Catch: JSONException -> L66
        this.f458980f.onRTMLog(5, "first_video_frame_decode_end:" + this.f458968e.f459318n);     // Catch: JSONException -> L66
        this.f458980f.onRTMLog(5, "first_frame_render_end:" + this.f458968e.f459328p);     // Catch: JSONException -> L66
        this.f458980f.onRTMLog(5, "preload_result: " + getRTCPreloadingState());     // Catch: JSONException -> L66
    L19:
        String r109 = this.V2;     // Catch: JSONException -> L66
        if (r109 == null) goto L31;
        if ("cmaf".equals(r109) == false) goto L25;
    L26:
        r102.put("video_dns_analysis_end", this.f458968e.X).put("audio_dns_analysis_end", this.f458968e.Y).put("video_tcp_connect_time", this.f458968e.V).put("audio_tcp_connect_time", this.f458968e.W).put("video_tcp_first_packet_time", this.f458968e.Z).put("audio_tcp_first_packet_time", this.f458968e.f459254a0).put("video_http_req_finish_time", this.f458968e.f459259b0).put("audio_http_req_finish_time", this.f458968e.f459264c0).put("video_http_res_finish_time", this.f458968e.f459269d0).put("audio_http_res_finish_time", this.f458968e.f459274e0);     // Catch: JSONException -> L66
        if ("cmaf".equals(this.V2) == false) goto L29;
        r102.put("cmaf_mpd_dns_analysis_end", this.f458968e.f459373y).put("cmaf_sdk_version", this.f458968e.G).put("cmaf_mpd_tcp_connect_time", this.f458968e.f459378z).put("cmaf_mpd_tcp_first_package_end", this.f458968e.B).put("cmaf_mpd_http_req_finish_time", this.f458968e.A).put("cmaf_mpd_http_res_finish_time", this.f458968e.C).put("cmaf_audio_firstseg_connect_time", this.f458968e.E).put("cmaf_video_firstseg_connect_time", this.f458968e.F).put("cmaf_mpd_connect_time", this.f458968e.D);     // Catch: JSONException -> L66
    L29:
        reportQuicOpenResult(r102);     // Catch: JSONException -> L66
        goto L31
    L25:
        if ("avph".equals(this.V2) == true) goto L26;
    L31:
        if (TextUtils.equals("cmaf", this.V2) == false) goto L33;
    L36:
        JSONObject r110 = r102.put("enable_preload", this.Ta).put("preload_init_error", this.Ua).put("preload_result", this.Xa).put("preload_resolution", this.f458953cb).put("play_use_preload_resolution", this.f458965db).put("preload_visit_timedelta", this.Ya);     // Catch: JSONException -> L66
        if (this.Va != 1) goto L39;
        int r111 = 1;
    L40:
        JSONObject r112 = r110.put("audioHttpxRequestCached", r111);     // Catch: JSONException -> L66
        if (this.Wa != 1) goto L43;
        int r113 = 1;
    L44:
        JSONObject r114 = r112.put("videoHttpxRequestCached", r113).put("cache_hit", this.f458925ab).put("cache_open_start_time", this.f458968e.V2).put("cache_open_end_time", this.f458968e.W2);     // Catch: JSONException -> L66
        LogBundle r115 = this.f458968e;     // Catch: JSONException -> L66
        r114.put("cache_open_cost", r115.W2 - r115.V2).put("preload_task_state", this.f458940bb);     // Catch: JSONException -> L66
        if (this.Ta == 1) goto L47;
    L54:
        long r116 = this.f459083n3;     // Catch: JSONException -> L66
        if (r116 <= 0) goto L57;
        this.f459083n3 = r116 + 1;     // Catch: JSONException -> L66
    L57:
        this.f459109p2 = "1.0:" + this.f459033j3;     // Catch: JSONException -> L66
        LogBundle r117 = this.f458968e;     // Catch: JSONException -> L66
        long r118 = r117.f459280f1;     // Catch: JSONException -> L66
        r117.f459290h1 = r118;     // Catch: JSONException -> L66
        r117.f459295i1 = r118;     // Catch: JSONException -> L66
        LogBundle r119 = this.f459026i8;     // Catch: JSONException -> L66
        if (r119 == null) goto L61;
        r119.f459290h1 = r118;     // Catch: JSONException -> L66
    L61:
        if (this.f459038j8 == false) goto L63;
        int r120 = 0;
        int r121 = 1;
    L64:
        reportSessionFirstFrame(r102, r121, r120);     // Catch: JSONException -> L66
        onEventLog(r102, "live_client_monitor_log");     // Catch: JSONException -> L66
        return;
    L63:
        r120 = 0;
        r121 = 0;
        goto L64
    L47:
        if (this.f458925ab != 1) goto L53;
        long r122 = this.f458968e.f459258b;     // Catch: JSONException -> L66
        if (r210 == 0) goto L51;
        long r123 = r210;
    L52:
        r102.put("player_dns_analysis_end", r122);     // Catch: JSONException -> L66
        r102.put("tcp_connect_end", r123);     // Catch: JSONException -> L66
        r102.put("tcp_first_package_end", r123);     // Catch: JSONException -> L66
        goto L53
    L51:
        r123 = r122;
    L53:
        StringBuilder r124 = new StringBuilder("[first_frame] first_frame_view :");     // Catch: JSONException -> L66
        r124.append(this.M9);     // Catch: JSONException -> L66
        r124.append("\ncache_hit :");     // Catch: JSONException -> L66
        r124.append(this.f458925ab);     // Catch: JSONException -> L66
        r124.append("\npreload_result :");     // Catch: JSONException -> L66
        r124.append(this.Xa);     // Catch: JSONException -> L66
        r124.append("\npreload_visit_timedelta :");     // Catch: JSONException -> L66
        r124.append(this.Ya);     // Catch: JSONException -> L66
        r124.append("\npreload_task_state : ");     // Catch: JSONException -> L66
        r124.append(this.f458940bb);     // Catch: JSONException -> L66
        r124.append("\nfirst_video_pkg_cost : ");     // Catch: JSONException -> L66
        LogBundle r125 = this.f458968e;     // Catch: JSONException -> L66
        r124.append(r125.f459308l - r125.f459253a);     // Catch: JSONException -> L66
        r124.append("\nfirst_video_frame_decode_cost : ");     // Catch: JSONException -> L66
        LogBundle r126 = this.f458968e;     // Catch: JSONException -> L66
        r124.append(r126.f459318n - r126.f459253a);     // Catch: JSONException -> L66
        r124.append("\nfirst_video_frame_render_cost : ");     // Catch: JSONException -> L66
        LogBundle r127 = this.f458968e;     // Catch: JSONException -> L66
        r124.append(r127.f459328p - r127.f459253a);     // Catch: JSONException -> L66
        c.i(TTUtils.LOG_TAG, r124.toString());     // Catch: JSONException -> L66
        goto L54
    L43:
        r113 = 0;
        goto L44
    L39:
        r111 = 0;
        goto L40
    L33:
        if (TextUtils.equals("flv", this.V2) == false) goto L54;
    L66:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public void onLLASHSwitch(String r110, boolean r111) {
        if (this.f458980f != null) goto L37;
        return;
    L37:
        JSONObject r100 = createCommonLog();     // Catch: JSONException -> L34
        JSONObject r101 = new JSONObject(r110);     // Catch: JSONException -> L34
        LogBundle r112 = new LogBundle();     // Catch: JSONException -> L34
        this.f458980f.getLogInfo(r112, 11);     // Catch: JSONException -> L34
        if (this.f458968e.f459328p <= 0) goto L8;
        long r102 = System.currentTimeMillis() - this.f458968e.f459328p;     // Catch: JSONException -> L34
    L9:
        int r103 = this.f459095o3;     // Catch: JSONException -> L34
        if (r103 != 0) goto L13;
        int r104 = 2;
    L16:
        Iterator<String> r113 = r101.keys();     // Catch: JSONException -> L34
    L18:
        if (r113.hasNext() == false) goto L20;
        String r114 = r113.next();     // Catch: JSONException -> L34
        r100.put(r114, r101.get(r114));     // Catch: JSONException -> L34
        goto L18
    L20:
        r100.put(LiveCommonConstants.LOG_PARAM_EVENT_KEY, "abr_switch").put("load_state", r104).put("is_auto_switch", 1).put(HistoryTableOperate.HISTORY_PLAY_TIME, r102).put("abr_switch_info", "abr_" + JSONObjectProtectorUtils.getString(r101, "source_resolution") + "_to_" + JSONObjectProtectorUtils.getString(r101, "target_resolution")).put("predict_bitrate", r101.optInt("target_bitrate", -1)).put("tcp_connect_cost", r101.optInt("tran_connect_cost", -1)).put("tcp_first_package_cost", r101.optInt("tran_first_packet_cost", -1)).put("abr_switch_count", r101.optInt("switch_count", -1)).put("stall_count", this.f459158t3).put("abr_switch_stall_time", this.f459104oc).put(BdpAppEventConstant.PARAMS_REQUEST_URL, r112.f459267c3).put("external_smooth_switch", this.Ub).put("use_expect_bitrate", this.f458962d8);     // Catch: JSONException -> L34
        onAbrSwitchEnd();     // Catch: JSONException -> L34
        this.f458962d8 = 0;     // Catch: JSONException -> L34
        this.Ub = 0;     // Catch: JSONException -> L34
        if (this.f459084n4 != 1) goto L23;
        reportABRFirstFrame(r101, r100);     // Catch: JSONException -> L34
    L23:
        if (r111 == false) goto L40;
        c.t("LiveLoggerService", "llash switch log: " + r100);     // Catch: JSONException -> L34
        onEventLog(r100, "live_client_monitor_log");     // Catch: JSONException -> L34
        long r115 = this.f459083n3;     // Catch: JSONException -> L34
        if (r115 <= 0) goto L27;
        this.f459083n3 = r115 + 1;     // Catch: JSONException -> L34
    L27:
        int r116 = r101.optInt("result", -1);     // Catch: JSONException -> L34
        if (JSONObjectProtectorUtils.getString(r101, "source_resolution").equals(JSONObjectProtectorUtils.getString(r101, "target_resolution")) == true) goto L41;
        if (r116 == 0) goto L31;
        return;
    L31:
        if (this.Bd != 1) goto L43;
        this.f458980f.updateSegementTrafficInfo();     // Catch: JSONException -> L34
        return;
    L43:
        return;
    L41:
        return;
    L40:
        return;
    L13:
        if (r103 != (-100015)) goto L15;
        r104 = 1;
        goto L16
    L15:
        r104 = 3;
        goto L16
    L8:
        r102 = 0;
    L34:
        e = move-exception;
        e.printStackTrace();
    }

    public void onLoaderError(int r100, String r101) {
        JSONObject r102 = createCommonLog();
        if (r102 == null) goto L13;
        r102.put(LiveCommonConstants.LOG_PARAM_EVENT_KEY, "p2p_error").put("error_msg", r101).put("code", r100);     // Catch: JSONException -> L8
        onEventLog(r102, "live_client_monitor_log");     // Catch: JSONException -> L8
        long r103 = this.f459083n3;     // Catch: JSONException -> L8
        if (r103 <= 0) goto L14;
        this.f459083n3 = r103 + 1;     // Catch: JSONException -> L8
        return;
    L14:
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public void onLoaderSwitch(int r100, String r101) {
        JSONObject r102 = createCommonLog();
        if (r102 == null) goto L16;
    L11:
        e = move-exception;
        e.printStackTrace();
        return;
    L5:
        if (r101.equals("cdn_to_p2p") == false) goto L7;
        this.B4 = 1;     // Catch: JSONException -> L11
    L7:
        r102.put(LiveCommonConstants.LOG_PARAM_EVENT_KEY, "p2p_switch").put("switch_info", r101).put("p2p_vendor", "none").put("reason", r100);     // Catch: JSONException -> L11
        onEventLog(r102, "live_client_monitor_log");     // Catch: JSONException -> L11
        long r103 = this.f459083n3;     // Catch: JSONException -> L11
        if (r103 <= 0) goto L17;
        this.f459083n3 = r103 + 1;     // Catch: JSONException -> L11
        return;
    L17:
        return;
    }

    public void onMuteStateChanged(String r100, boolean r101) {
        if (this.f458980f != null) goto L5;
        return;
    L5:
        if (r101 == true) goto L15;
        long r102 = this.f459168td;
        long r103 = this.f458968e.f459253a;
        if (r102 != r103) goto L9;
        return;
    L9:
        this.f459168td = r103;
    L15:
        JSONObject r104 = createCommonLog();     // Catch: JSONException -> L12
        r104.put(LiveCommonConstants.LOG_PARAM_EVENT_KEY, "on_mute_state_changed").put("mute_monitoring_msg", r100);     // Catch: JSONException -> L12
        onEventLog(r104, "live_client_monitor_log");     // Catch: JSONException -> L12
        return;
    L12:
        e = move-exception;
        e.printStackTrace();
    }

    public void onPlay(String r100, String r101) {
        if (this.f459026i8 == null) goto L5;
        this.f459052k8 = System.currentTimeMillis();
    L5:
        this.f459199w6 = System.currentTimeMillis();
        this.f458968e.f459253a = System.currentTimeMillis();
        if (isPreview() == false) goto L8;
        this.D9 = this.f458968e.f459253a;
    L8:
        this.f458968e.f459365w1 = r101;
        this.f459133r = r100;
        this.f459145s = r100;
        JSONObject r102 = createCommonLog();
        this.f459083n3 = 0;
        if (r102 == null) goto L37;
        r102.put(LiveCommonConstants.LOG_PARAM_EVENT_KEY, "start_play").put("rule_ids", this.Q2).put("set_surface_cost", this.f459186v5).put("start_play_time", this.f458968e.f459253a).put("suggest_format", this.E5).put("play_format", this.V2).put("suggest_protocol", this.G5).put("suggest_access_code", this.L5).put("log_total_count_when_playing", this.f459083n3).put("event_key_index", f458906ce.incrementAndGet()).put("trigger_type", this.f459235z).put(MiniAppConstants.KEY_MINI_APP_STREAM_DATA, this.f459212x5).put("live_suggest_fastopenduration", this.R6);     // Catch: JSONException -> L32
        if (TextUtils.equals(this.F5, "h2") == false) goto L13;
    L16:
        r102.remove("h2_context_start_cost");     // Catch: JSONException -> L32
    L18:
        if (this.f459120pd == 1) goto L20;
        r102.put("origin_url", this.K5);     // Catch: JSONException -> L32
    L20:
        onEventLog(r102, "live_client_monitor_log");     // Catch: JSONException -> L32
        this.f459083n3++;     // Catch: JSONException -> L32
        JSONObject r103 = new JSONObject();     // Catch: JSONException -> L32
        r103.put("PLAY-SessionID", this.T2);     // Catch: JSONException -> L32
        if (r102.has("live_suggest_fastopenduration") == false) goto L23;
        r103.put("PLAY-SuggestFastOpenDuration", r102.optInt("live_suggest_fastopenduration", -1));     // Catch: JSONException -> L32
    L23:
        VideoLiveManager r104 = this.f458980f;     // Catch: JSONException -> L32
        if (r104 == null) goto L29;
        if (r104.mEnableOpenStrategyEngine != 1) goto L29;
        LiveStrategyManager.inst().setEventInfo(60, r103);     // Catch: JSONException -> L32
    L29:
        if (this.f458980f.mEnableUseNativeLiveStrategyFeatureCenter != 1) goto L38;
        LiveStrategyManager.inst().executeCommand(0, 407, 0, r103);     // Catch: JSONException -> L32
        return;
    L38:
        return;
    L13:
        if (TextUtils.equals(this.F5, "h2q") == true) goto L16;
        if (TextUtils.equals(this.F5, "h2qu") == false) goto L18;
    L32:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public void onPreload(int r210, Bundle r211) {
        if (this.f458980f != null) goto L5;
        return;
    L5:
        JSONObject r100 = createCommonLog();
        if (r100 == null) goto L23;
        r100.put(LiveCommonConstants.LOG_PARAM_EVENT_KEY, "live_preload").put("preload_event", r210).put("preload_url", r211.getString("preload_url", "")).put("preload_code", r211.getInt("preload_code", 0)).put("preload_sub_code", r211.getInt("preload_sub_code", 0)).put("preload_error", r211.getString("preload_error", "")).put("preload_num", r211.getInt("preload_num", 0)).put("video_cached_num", r211.getInt("video_cached_num", 0)).put("audio_cached_num", r211.getInt("audio_cached_num", 0)).put("video_init_section_cached", r211.getInt("video_init_section_cached", 0)).put("audio_init_section_cached", r211.getInt("audio_init_section_cached", 0)).put("io_read_Bytes", r211.getLong("io_read_Bytes", 0)).put("cache_write_bytes", r211.getLong("cache_write_bytes", 0)).put("cache_waste_bytes", r211.getLong("cache_waste_bytes", 0)).put("cache_mode", r211.getInt("cache_mode", 0)).put("cache_frame_count", r211.getInt("cache_frame_count", 0)).put("cache_duration", r211.getLong("cache_duration", 0)).put("cancel_cost_time", r211.getLong("cancel_cost_time", 0)).put("pull_data", r211.getString("pull_data", "")).put("enable_probe_startup_bitrate", r211.getInt("enable_probe_startup_bitrate", 0)).put("probe_startup_bitrate", r211.getInt("probe_startup_bitrate", 0));     // Catch: JSONException -> L15
        onEventLog(r100, "live_client_monitor_log");     // Catch: JSONException -> L13
        long r101 = this.f459083n3;     // Catch: JSONException -> L13
        if (r101 <= 0) goto L24;
        this.f459083n3 = r101 + 1;     // Catch: JSONException -> L13
        return;
    L24:
        return;
    L13:
        e = e;
    L17:
        e.printStackTrace();
        return;
    L15:
        e = e;
        goto L17
    }

    public void onPtsBack(long r100, boolean r101) {
        JSONObject r102 = createCommonLog();
        if (r102 == null) goto L15;
        JSONObject r103 = r102.put(LiveCommonConstants.LOG_PARAM_EVENT_KEY, "pts_back");     // Catch: JSONException -> L10
        if (r101 == false) goto L7;
        String r104 = "video";
    L8:
        r103.put("type", r104).put("pts_back_diff", r100);     // Catch: JSONException -> L10
        onEventLog(r102, "live_client_monitor_log");     // Catch: JSONException -> L10
        return;
    L7:
        r104 = "audio";
    L10:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public void onPullRestartRecmd(String r100, String r101) {
        if (this.f458980f != null) goto L15;
        return;
    L15:
        JSONObject r102 = createCommonLog();     // Catch: JSONException -> L12
        if (r102 != null) goto L8;
        return;
    L8:
        r102.put(LiveCommonConstants.LOG_PARAM_EVENT_KEY, "pull_restart_recmd").put("cmd", r100).put("mode", r101);     // Catch: JSONException -> L12
        this.Gc = r100;     // Catch: JSONException -> L12
        this.Hc = r101;     // Catch: JSONException -> L12
        onEventLog(r102, "live_client_monitor_log");     // Catch: JSONException -> L12
        long r103 = this.f459083n3;     // Catch: JSONException -> L12
        if (r103 <= 0) goto L17;
        this.f459083n3 = r103 + 1;     // Catch: JSONException -> L12
        return;
    L17:
        return;
    L12:
        e = move-exception;
        e.printStackTrace();
    }

    public void onPullStartSkip(int r100, String r101) {
        if (this.f458980f != null) goto L15;
        return;
    L15:
        JSONObject r102 = createCommonLog();     // Catch: JSONException -> L12
        if (r102 != null) goto L8;
        return;
    L8:
        r102.put(LiveCommonConstants.LOG_PARAM_EVENT_KEY, "pull_restart").put("cmd", this.Gc).put("mode", this.Hc).put("code", r100).put("reason", r101);     // Catch: JSONException -> L12
        onEventLog(r102, "live_client_monitor_log");     // Catch: JSONException -> L12
        long r103 = this.f459083n3;     // Catch: JSONException -> L12
        if (r103 <= 0) goto L17;
        this.f459083n3 = r103 + 1;     // Catch: JSONException -> L12
        return;
    L17:
        return;
    L12:
        e = move-exception;
        e.printStackTrace();
    }

    public void onRtcDecoderStall(long r100, boolean r110) {
        if (r100 <= (System.currentTimeMillis() - this.f458968e.f459253a)) goto L6;
        c.i("LiveLoggerService", "abnormal rtc decode stall time" + r100);
        return;
    L6:
        JSONObject r101 = createCommonLog();
        if (r101 == null) goto L30;
        JSONObject r102 = r101.put(LiveCommonConstants.LOG_PARAM_EVENT_KEY, "rtc_decode_stall");     // Catch: JSONException -> L25
        if (r110 == false) goto L11;
        String r103 = "video";
    L12:
        r102.put("type", r103).put("decode_stall_time", r100);     // Catch: JSONException -> L25
        onEventLog(r101, "live_client_monitor_log");     // Catch: JSONException -> L25
        long r104 = this.f459083n3;     // Catch: JSONException -> L25
        if (r104 <= 0) goto L15;
        this.f459083n3 = r104 + 1;     // Catch: JSONException -> L25
    L15:
        JSONObject r105 = new JSONObject();     // Catch: JSONException -> L25
        if (r110 == false) goto L18;
        int r111 = 0;
    L19:
        r105.put("PLAY-StallType", r111).put("PLAY-StallTime", r100).put(LiveCommonConstants.LOG_PARAM_EVENT_KEY, "rtc_decode_stall");     // Catch: JSONException -> L25
        r105.put("PLAY-SessionID", this.T2);     // Catch: JSONException -> L25
        VideoLiveManager r106 = this.f458980f;     // Catch: JSONException -> L25
        if (r106 != null) goto L22;
        return;
    L22:
        if (r106.mEnableOpenStrategyEngine != 1) goto L32;
        LiveStrategyManager.inst().setEventInfo(62, r105);     // Catch: JSONException -> L25
        return;
    L32:
        return;
    L18:
        r111 = 1;
        goto L19
    L11:
        r103 = "audio";
    L25:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public void onSDKDNSComplete(boolean r100, boolean r101) {
        LogBundle r102 = this.f458968e;
        r102.f459258b = System.currentTimeMillis();
        LogBundle r103 = this.f459026i8;
        if (r103 == null) goto L5;
        r103.f459258b = System.currentTimeMillis();
    L5:
        LogBundle r104 = this.f459200w7;
        r104.f459258b = System.currentTimeMillis();
        this.W = r101;
        this.Y = r100;
    }

    public void onSessionStart(String r100, int r101) {
        if (this.f459026i8 != null) goto L5;
        return;
    L5:
        this.f459052k8 = System.currentTimeMillis();
        this.f459026i8.f459253a = System.currentTimeMillis();
        this.f459199w6 = System.currentTimeMillis();
        this.f459133r = r100;
        JSONObject r102 = createCommonLog();
        this.f459083n3 = 0;
        if (r102 == null) goto L21;
        r102.put(LiveCommonConstants.LOG_PARAM_EVENT_KEY, "session_start").put("reason", r101).put("rule_ids", this.Q2).put("set_surface_cost", this.f459186v5).put("start_play_time", this.f459026i8.f459253a).put(MiniAppConstants.KEY_MINI_APP_STREAM_DATA, this.f459212x5).put("suggest_format", this.E5).put("play_format", this.V2).put("suggest_protocol", this.G5).put("suggest_access_code", this.L5).put("origin_url", this.K5).put("log_total_count_when_playing", this.f459083n3).put("event_key_index", f458908ee.incrementAndGet());     // Catch: JSONException -> L16
        if (TextUtils.equals(this.F5, "h2") == false) goto L10;
    L13:
        r102.remove("h2_context_start_cost");     // Catch: JSONException -> L16
    L14:
        addStreamVersion(r102);     // Catch: JSONException -> L16
        onEventLog(r102, "live_client_monitor_log");     // Catch: JSONException -> L16
        this.f459083n3++;     // Catch: JSONException -> L16
        return;
    L10:
        if (TextUtils.equals(this.F5, "h2q") == true) goto L13;
        if (TextUtils.equals(this.F5, "h2qu") == false) goto L14;
    L16:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public void onStallStart(int r100, boolean r110) {
        this.f459095o3 = LiveError.PLAYER_STALL;
        if (r110 == true) goto L6;
        return;
    L6:
        if (isRtcPlayAvailable() == false) goto L8;
        return;
    L8:
        this.f458980f.getLogInfo(this.f458968e, 5);
        long r101 = System.currentTimeMillis();
        this.f459122q3 = r101;
        if (this.S3 != 0) goto L12;
        this.S3 = r101;
    L12:
        if (this.f459014h8 == 1) goto L14;
    L17:
        this.f459134r3 = r101;
        this.f459146s3 = r100;
        this.L3 = true;
        if (this.T4 != null) goto L21;
        this.T4 = new ArrayList();
    L21:
        if (this.U4 != null) goto L23;
        this.U4 = new ArrayList();
    L23:
        long r102 = this.f459122q3;
        LogBundle r103 = this.f458968e;
        this.V4 = r102 - r103.f459253a;
        this.f459205wc = r103.f459325o1;
        this.f459219xc = r103.f459305k1;
        return;
    L14:
        if (this.f459201w8 != 0) goto L16;
        this.f459201w8 = r101;
    L16:
        this.f459241z8 = this.f459095o3;
        goto L17
    }

    public void onVideoDecodeStall(long r100, int r101) {
        if (r100 <= (System.currentTimeMillis() - this.f458968e.f459253a)) goto L5;
    L20:
        c.i("LiveLoggerService", "abnormal demux stall time" + r100);
        return;
    L5:
        if (r100 <= r101) goto L20;
        this.K8++;
        this.L8 += r100;
        this.B8++;
        this.C8 += r100;
        if (isPreview() == false) goto L10;
        this.f458951c9++;
        this.f458963d9 += r100;
    L10:
        this.f459174u7.add(System.currentTimeMillis() + ":" + r100);
        JSONObject r102 = new JSONObject();     // Catch: JSONException -> L17
        r102.put("PLAY-StallType", 0).put("PLAY-StallTime", r100).put(LiveCommonConstants.LOG_PARAM_EVENT_KEY, "decode_stall");     // Catch: JSONException -> L17
        r102.put("PLAY-SessionID", this.T2);     // Catch: JSONException -> L17
        VideoLiveManager r103 = this.f458980f;     // Catch: JSONException -> L17
        if (r103 != null) goto L14;
        return;
    L14:
        if (r103.mEnableOpenStrategyEngine != 1) goto L25;
        LiveStrategyManager.inst().setEventInfo(62, r102);     // Catch: JSONException -> L17
        return;
    L25:
        return;
    L17:
        e = move-exception;
        e.printStackTrace();
    }

    public void onVideoDemuxerStall(long r100, int r101) {
        if (r100 <= (System.currentTimeMillis() - this.f458968e.f459253a)) goto L5;
    L20:
        c.i("LiveLoggerService", "abnormal demux stall time" + r100);
        return;
    L5:
        if (r100 <= r101) goto L20;
        this.G8++;
        this.H8 += r100;
        this.F8++;
        this.O8 += r100;
        if (isPreview() == false) goto L10;
        this.f459001g9++;
        this.f459015h9 += r100;
    L10:
        this.f459150s7.add(System.currentTimeMillis() + ":" + r100);
        JSONObject r102 = new JSONObject();     // Catch: JSONException -> L17
        r102.put("PLAY-StallType", 0).put("PLAY-StallTime", r100).put(LiveCommonConstants.LOG_PARAM_EVENT_KEY, "demux_stall");     // Catch: JSONException -> L17
        r102.put("PLAY-SessionID", this.T2);     // Catch: JSONException -> L17
        VideoLiveManager r103 = this.f458980f;     // Catch: JSONException -> L17
        if (r103 != null) goto L14;
        return;
    L14:
        if (r103.mEnableOpenStrategyEngine != 1) goto L25;
        LiveStrategyManager.inst().setEventInfo(62, r102);     // Catch: JSONException -> L17
        return;
    L25:
        return;
    L17:
        e = move-exception;
        e.printStackTrace();
    }

    public void onVideoSizeChanged(int r100, int r101) {
        this.I4 = r100;
        this.J4 = r101;
    }

    public void setCdnIp(String r100, boolean r101) {
        this.f459157t = r100;
        this.f459169u = r101;
    }

    public void setFormatInfo(String r100, String r101) {
        this.E5 = r100;
        this.V2 = r101;
    }

    public void updateAudioMetricInfo(String r210, int r310) {
        String r100 = "background_noise_left";
        String r110 = "rel_left";
        if (TextUtils.isEmpty(r210) == false) goto L148;
        return;
    L148:
        JSONObject r101 = new JSONObject(r210);     // Catch: JSONException -> L141
        JSONObject r111 = new JSONObject();     // Catch: JSONException -> L141
        if (r101.has("anomaly_info") == false) goto L13;
        JSONObject r112 = r101.optJSONObject("anomaly_info");     // Catch: JSONException -> L141
        if (r112 == null) goto L13;
        if (r112.has(com.bytedance.android.ec.core.event.a.KEY_SCORE) == false) goto L13;
        r111.put(com.bytedance.android.ec.core.event.a.KEY_SCORE, r112.optString(com.bytedance.android.ec.core.event.a.KEY_SCORE));     // Catch: JSONException -> L141
    L13:
        JSONObject r102 = new JSONObject();     // Catch: JSONException -> L141
        if (r101.has("loudness") == false) goto L27;
        JSONObject r113 = r101.optJSONObject("loudness");     // Catch: JSONException -> L141
        if (r113 == null) goto L27;
        String r211 = "cutoff_frequency";
        if (r113.has("integrated_loudness") == false) goto L22;
        r102.put("integrated_loudness", r113.optDouble("integrated_loudness"));     // Catch: JSONException -> L141
    L22:
        if (r113.has("max_mom_loud") == false) goto L25;
        r102.put("max_mom_loud", r113.optDouble("max_mom_loud"));     // Catch: JSONException -> L141
    L25:
        if (r113.has("max_short_term_loud") == false) goto L29;
        r102.put("max_short_term_loud", r113.optDouble("max_short_term_loud"));     // Catch: JSONException -> L141
    L29:
        if (r101.has("clipping") == false) goto L32;
        r111.put("clipping", r101.optString("clipping"));     // Catch: JSONException -> L141
    L32:
        if (r101.has("rms_stats") == false) goto L84;
        JSONObject r103 = r101.optJSONObject("rms_stats");     // Catch: JSONException -> L141
        if (r103 == null) goto L84;
        JSONObject r104 = new JSONObject();     // Catch: JSONException -> L141
        JSONObject r105 = new JSONObject();     // Catch: JSONException -> L141
        JSONObject r106 = new JSONObject();     // Catch: JSONException -> L141
        if (r103.has("left_right_diff") == false) goto L40;
        r102.put("left_right_rms_diff", r103.optDouble("left_right_diff"));     // Catch: JSONException -> L141
    L40:
        if (r103.has("dynamic_range_left") == false) goto L43;
        r104.put("dynamic_range_left", r103.optDouble("dynamic_range_left"));     // Catch: JSONException -> L141
    L43:
        if (r103.has("dynamic_range_right") == false) goto L46;
        r104.put("dynamic_range_right", r103.optDouble("dynamic_range_right"));     // Catch: JSONException -> L141
    L46:
        if (r103.has("estimated_snr_left") == false) goto L49;
        r105.put("estimated_snr_left", r103.optDouble("estimated_snr_left"));     // Catch: JSONException -> L141
    L49:
        if (r103.has("estimated_snr_right") == false) goto L51;
        r105.put("estimated_snr_right", r103.optDouble("estimated_snr_right"));     // Catch: JSONException -> L141
    L51:
        String r107 = r100;
        if (r103.has(r107) == false) goto L55;
        r106.put(r107, r103.optDouble(r107));     // Catch: JSONException -> L141
    L55:
        if (r103.has("background_noise_right") == false) goto L58;
        r106.put("background_noise_right", r103.optDouble("background_noise_right"));     // Catch: JSONException -> L141
    L58:
        if (r103.has("left_total") == false) goto L61;
        r102.put("left_total", r103.optDouble("left_total"));     // Catch: JSONException -> L141
    L61:
        if (r103.has("right_total") == false) goto L64;
        r102.put("right_total", r103.optDouble("right_total"));     // Catch: JSONException -> L141
    L64:
        if (r103.has("peak") == false) goto L67;
        r102.put("peak", r103.optDouble("peak"));     // Catch: JSONException -> L141
    L67:
        if (r103.has("minimum") == false) goto L70;
        r102.put("minimum", r103.optDouble("minimum"));     // Catch: JSONException -> L141
    L70:
        if (r103.has("std_left") == false) goto L73;
        r102.put("std_left", r103.optDouble("std_left"));     // Catch: JSONException -> L141
    L73:
        if (r103.has("std_right") == false) goto L76;
        r102.put("std_right", r103.optDouble("std_right"));     // Catch: JSONException -> L141
    L76:
        if (r104.length() <= 0) goto L79;
        r111.put("dynamicrange", r104.toString());     // Catch: JSONException -> L141
    L79:
        if (r105.length() <= 0) goto L82;
        r111.put("snr", r105.toString());     // Catch: JSONException -> L141
    L82:
        if (r106.length() <= 0) goto L86;
        r111.put("backgroundnoise", r106.toString());     // Catch: JSONException -> L141
    L86:
        if (r102.length() <= 0) goto L88;
        r111.put("loudness", r102.toString());     // Catch: JSONException -> L141
    L88:
        JSONObject r108 = new JSONObject();     // Catch: JSONException -> L141
        String r109 = r211;
        if (r101.has(r109) == false) goto L111;
        JSONObject r114 = r101.optJSONObject(r109);     // Catch: JSONException -> L141
        if (r114 == null) goto L111;
        String r115 = r110;
        if (r114.has(r115) == false) goto L96;
        r108.put(r115, r114.optDouble(r115));     // Catch: JSONException -> L141
    L96:
        if (r114.has("rel_left_conf") == false) goto L99;
        r108.put("rel_left_conf", r114.optDouble("rel_left_conf"));     // Catch: JSONException -> L141
    L99:
        if (r114.has("band_std_left") == false) goto L102;
        r108.put("band_std_left", r114.optDouble("band_std_left"));     // Catch: JSONException -> L141
    L102:
        if (r114.has("rel_right") == false) goto L105;
        r108.put("rel_right", r114.optDouble("rel_right"));     // Catch: JSONException -> L141
    L105:
        if (r114.has("rel_right_conf") == false) goto L108;
        r108.put("rel_right_conf", r114.optDouble("rel_right_conf"));     // Catch: JSONException -> L141
    L108:
        if (r114.has("band_std_right") == false) goto L111;
        r108.put("band_std_right", r114.optDouble("band_std_right"));     // Catch: JSONException -> L141
    L111:
        if (r108.length() <= 0) goto L113;
        r111.put(r109, r108.toString());     // Catch: JSONException -> L141
    L113:
        JSONObject r116 = new JSONObject();     // Catch: JSONException -> L141
        if (r101.has("phase_check") == false) goto L127;
        JSONObject r117 = r101.optJSONObject("phase_check");     // Catch: JSONException -> L141
        if (r117 == null) goto L127;
        if (r117.has("rms_before_downmix") == false) goto L121;
        r116.put("rms_before_downmix", r117.optDouble("rms_before_downmix"));     // Catch: JSONException -> L141
    L121:
        if (r117.has("rms_after_downmix") == false) goto L124;
        r116.put("rms_after_downmix", r117.optDouble("rms_after_downmix"));     // Catch: JSONException -> L141
    L124:
        if (r117.has("rms_downmix_diff") == false) goto L127;
        r116.put("rms_downmix_diff", r117.optDouble("rms_downmix_diff"));     // Catch: JSONException -> L141
    L127:
        if (r116.length() <= 0) goto L130;
        r111.put("phase_check", r116.toString());     // Catch: JSONException -> L141
    L130:
        if (r101.has("timestamp") == false) goto L146;
        r111.put("detecting_timestamp", r101.optLong("timestamp"));     // Catch: JSONException -> L141
    L146:
        if (r310 != 1) goto L137;
        this.Dc = r111.toString();     // Catch: JSONException -> L139
    L145:
        return;
    L137:
        this.Cc = r111.toString();     // Catch: JSONException -> L139
    L139:
        e = e;
    L143:
        e.printStackTrace();
        return;
    L84:
        r110 = "rel_left";
    L27:
        r211 = "cutoff_frequency";
        r100 = "background_noise_left";
    L141:
        e = e;
        goto L143
    }

    public void updateP2PInfo(String r100, boolean r101) {
        if (r100 != null) goto L19;
        c.d("LiveLoggerService", "no p2pinfo, sessionid:" + this.R2);
        return;
    L19:
        JSONObject r102 = configP2PInfo(new JSONArray(r100));     // Catch: JSONException -> L16
        if (r102 != null) goto L8;
        return;
    L8:
        if (this.f458942bd == 1) goto L21;
        this.Oc = r102.toString();     // Catch: JSONException -> L16
        if (r101 == false) goto L13;
        this.Nc.add(new JSONObject(this.Oc));     // Catch: JSONException -> L16
    L13:
        initializeSegmentRequest(r102);     // Catch: JSONException -> L16
        return;
    L21:
        return;
    L16:
        e = move-exception;
        e.printStackTrace();
    }

    public void updateTrafficInfo(long r100, boolean r101) {
        JSONObject r102 = configTrafficInfo(r100);
        if (r101 == false) goto L5;
        this.Oc = r102.toString();
        this.Nc.add(r102);
    L5:
        initializeSegmentRequest(r102);
    }

    private void setExtParam(JSONObject r100, String r101) {
        if (r100 == null) goto L11;
        if (r101 == null) goto L12;
        setExtParam(r100, new JSONObject(r101));     // Catch: JSONException -> L6
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        return;
    L12:
        return;
    }

    public long getInt64Value(int r100, long r101) {
        if (r100 != 0) goto L4;
        int r102 = this.K;
        if (r102 != (-1)) goto L19;
        VideoLiveManager r103 = this.f458980f;
        if (r103 == null) goto L19;
        return r103.getIntOption(r100, r101);
    L19:
        return r102;
    L4:
        if (r100 == 100) goto L11;
        if (r100 == 101) goto L9;
        return r101;
    L9:
        return this.f458968e.f459328p;
    L11:
        return this.f458968e.f459280f1;
    }

    private void checkVideoFrame(int r110, int r111, long r112) {
        if (r110 < 0) goto L72;
        if (r111 > 0) goto L5;
        return;
    L5:
        if (r112 < 0) goto L74;
        LinkedBlockingQueue<Long> r100 = this.f458961d7;
        if (r100 != null) goto L10;
        return;
    L10:
        int r101 = this.f458973e7;
        if (r101 != (-1)) goto L15;
        this.f458973e7 = r110;
        this.f458985f7 = r112;
        return;
    L15:
        if (this.f459043jd == 1) goto L19;
        if (r110 != r101) goto L19;
        return;
    L19:
        if (r100.size() <= 0) goto L21;
        long r102 = this.f458961d7.peek().longValue();
    L22:
        int r103 = 0;
        if (r102 > 0) goto L25;
    L52:
        int r104 = this.f458973e7;
        if ((r110 - r104) == 1) goto L64;
        if (r110 > r104) goto L58;
        r103 = 1;
    L58:
        if (this.f459043jd == 1) goto L60;
        onStreamAbnormalSEI(r103, r110, r104);
        goto L64
    L60:
        if (r103 != 0) goto L62;
        this.f459114p7.add("type" + r103 + "sent_frames" + r111 + "last_index" + this.f458973e7);
        goto L64
    L62:
        this.f459126q7.add("type" + r103 + "sent_frames" + r111 + "last_index" + this.f458973e7);
    L64:
        this.f458973e7 = r110;
        this.f458985f7 = r112;
        return;
    L25:
        if (r102 > this.f458985f7) goto L52;
        boolean r105 = false;
        int r106 = 0;
    L28:
        if (this.f458961d7.size() <= 0) goto L42;
        long r107 = this.f458961d7.peek().longValue();
        long r108 = this.f458985f7;
        if (r107 != r108) goto L32;
        r105 = true;
    L32:
        if (r105 == false) goto L40;
        if (r107 <= r108) goto L40;
        if (r107 > r112) goto L40;
        r106 = r106 + 1;
        if (r107 == r112) goto L42;
    L40:
        this.f458961d7.poll().longValue();
    L42:
        if ((r110 - this.f458973e7) != 1) goto L52;
        if (r106 <= 0) goto L52;
        if (r106 == r111) goto L52;
        if (r106 >= r111) goto L47;
        int r109 = 0;
    L49:
        if (this.f459043jd != 1) goto L51;
        this.f459114p7.add("type" + r109 + "sent_frames" + r111 + "received_frames" + r106);
        goto L52
    L51:
        onStreamAbnormalFrame(r109, r111, r106);
        goto L52
    L47:
        r109 = 1;
        goto L49
    L21:
        r102 = -1;
        goto L22
    L74:
        return;
    }

    private void onStreamAbnormalFrame(int r100, int r101, int r102) {
        if (this.f458980f != null) goto L5;
        return;
    L5:
        JSONObject r103 = createCommonLog();
        if (r103 == null) goto L16;
        r103.put(LiveCommonConstants.LOG_PARAM_EVENT_KEY, "stream_abnormal").put("stream_type", "video").put("type", r100).put("sent_frames", r101).put("received_frames", r102);     // Catch: JSONException -> L11
        onEventLog(r103, "live_client_monitor_log");     // Catch: JSONException -> L11
        long r104 = this.f459083n3;     // Catch: JSONException -> L11
        if (r104 <= 0) goto L17;
        this.f459083n3 = r104 + 1;     // Catch: JSONException -> L11
        return;
    L17:
        return;
    L11:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    private void onStreamAbnormalSEI(int r100, int r101, int r102) {
        if (this.f458980f != null) goto L5;
        return;
    L5:
        JSONObject r103 = createCommonLog();
        if (r103 == null) goto L16;
        r103.put(LiveCommonConstants.LOG_PARAM_EVENT_KEY, "stream_abnormal").put("stream_type", "video").put("type", r100).put("cur_index", r101).put("last_index", r102);     // Catch: JSONException -> L11
        onEventLog(r103, "live_client_monitor_log");     // Catch: JSONException -> L11
        long r104 = this.f459083n3;     // Catch: JSONException -> L11
        if (r104 <= 0) goto L17;
        this.f459083n3 = r104 + 1;     // Catch: JSONException -> L11
        return;
    L17:
        return;
    L11:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    private void reportSessionFirstFrame(JSONObject r110, int r111, int r112) {
        if (this.f459026i8 != null) goto L6;
        return;
    L6:
        if (this.f459084n4 != 1) goto L31;
        String r100 = this.f459059l3;     // Catch: JSONException -> L25
        String r101 = this.R2;     // Catch: JSONException -> L25
        if (r100 == r101) goto L10;
        this.f459059l3 = r101;     // Catch: JSONException -> L25
    L10:
        JSONObject r102 = new JSONObject();     // Catch: JSONException -> L25
        Iterator<String> r103 = r110.keys();     // Catch: JSONException -> L25
    L12:
        if (r103.hasNext() == false) goto L14;
        String r104 = r103.next();     // Catch: JSONException -> L25
        r102.put(r104, r110.get(r104));     // Catch: JSONException -> L25
        goto L12
    L14:
        int r105 = 0;
        JSONObject r113 = r102.put(LiveCommonConstants.LOG_PARAM_EVENT_KEY, "session_first_frame").put("is_stream_received", r111).put("wait_surface_elapse", 0);     // Catch: JSONException -> L25
        if (this.f459186v5 <= 0) goto L17;
        r105 = 1;
    L17:
        r113.put("set_surface", r105).put("event_key_index", f458909fe.incrementAndGet());     // Catch: JSONException -> L25
        long r106 = System.currentTimeMillis() - this.f459026i8.f459253a;     // Catch: JSONException -> L25
        if (r111 != 1) goto L20;
        r102.put("session_succ_elapse", r106);     // Catch: JSONException -> L25
    L21:
        onEventLog(r102, "live_client_monitor_log");     // Catch: JSONException -> L25
        long r114 = this.f459083n3;     // Catch: JSONException -> L25
        if (r114 <= 0) goto L32;
        this.f459083n3 = r114 + 1;     // Catch: JSONException -> L25
        return;
    L32:
        return;
    L20:
        r102.put("session_play_time_on_no_frame", r106);     // Catch: JSONException -> L25
        r102.put("reason", r112);     // Catch: JSONException -> L25
    L25:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public void logAesBoostConfigType(LogBundle.VideoProcessConfigChannel r100, int r101, String r102) {
        LogBundle r103 = this.f458968e;
        if (r103 != null) goto L5;
        return;
    L5:
        r103.f459357u3 = r100;
        r103.f459362v3 = r101;
        r103.f459367w3 = r102;
    }

    public void onDecoderStall(long r100, int r110, boolean r111) {
        if (r100 <= (System.currentTimeMillis() - this.f458968e.f459253a)) goto L5;
    L37:
        c.i("LiveLoggerService", "abnormal decode stall time" + r100);
        return;
    L5:
        if (r100 <= r110) goto L37;
        if (r111 == false) goto L12;
        this.B8++;
        this.C8 += r100;
        if (isPreview() == false) goto L15;
        this.f458951c9++;
        this.f458963d9 += r100;
    L15:
        JSONObject r112 = createCommonLog();
        if (r112 == null) goto L41;
        JSONObject r101 = r112.put(LiveCommonConstants.LOG_PARAM_EVENT_KEY, "decode_stall");     // Catch: JSONException -> L34
        if (r111 == false) goto L20;
        String r102 = "video";
    L21:
        r101.put("type", r102).put("stall_time", r100);     // Catch: JSONException -> L34
        onEventLog(r112, "live_client_monitor_log");     // Catch: JSONException -> L34
        long r103 = this.f459083n3;     // Catch: JSONException -> L34
        if (r103 <= 0) goto L24;
        this.f459083n3 = r103 + 1;     // Catch: JSONException -> L34
    L24:
        JSONObject r113 = new JSONObject();     // Catch: JSONException -> L34
        if (r111 == false) goto L27;
        int r114 = 0;
    L28:
        r113.put("PLAY-StallType", r114).put("PLAY-StallTime", r100).put(LiveCommonConstants.LOG_PARAM_EVENT_KEY, "decode_stall");     // Catch: JSONException -> L34
        r113.put("PLAY-SessionID", this.T2);     // Catch: JSONException -> L34
        VideoLiveManager r104 = this.f458980f;     // Catch: JSONException -> L34
        if (r104 != null) goto L31;
        return;
    L31:
        if (r104.mEnableOpenStrategyEngine != 1) goto L43;
        LiveStrategyManager.inst().setEventInfo(62, r113);     // Catch: JSONException -> L34
        return;
    L43:
        return;
    L27:
        r114 = 1;
        goto L28
    L20:
        r102 = "audio";
    L34:
        e = move-exception;
        e.printStackTrace();
        return;
    L41:
        return;
    L12:
        this.D8++;
        this.E8 += r100;
        if (isPreview() == false) goto L15;
        this.f458975e9++;
        this.f458987f9 += r100;
        goto L15
    }

    public void onDemuxerStall(long r100, int r110, boolean r111) {
        if (r100 <= (System.currentTimeMillis() - this.f458968e.f459253a)) goto L5;
    L37:
        c.i("LiveLoggerService", "abnormal demux stall time" + r100);
        return;
    L5:
        if (r100 <= r110) goto L37;
        if (r111 == false) goto L12;
        this.F8++;
        this.O8 += r100;
        if (isPreview() == false) goto L15;
        this.f459001g9++;
        this.f459015h9 += r100;
    L15:
        JSONObject r112 = createCommonLog();
        if (r112 == null) goto L41;
        JSONObject r101 = r112.put(LiveCommonConstants.LOG_PARAM_EVENT_KEY, "demux_stall");     // Catch: JSONException -> L34
        if (r111 == false) goto L20;
        String r102 = "video";
    L21:
        r101.put("type", r102).put("stall_time", r100);     // Catch: JSONException -> L34
        onEventLog(r112, "live_client_monitor_log");     // Catch: JSONException -> L34
        long r103 = this.f459083n3;     // Catch: JSONException -> L34
        if (r103 <= 0) goto L24;
        this.f459083n3 = r103 + 1;     // Catch: JSONException -> L34
    L24:
        JSONObject r113 = new JSONObject();     // Catch: JSONException -> L34
        if (r111 == false) goto L27;
        int r114 = 0;
    L28:
        r113.put("PLAY-StallType", r114).put("PLAY-StallTime", r100).put(LiveCommonConstants.LOG_PARAM_EVENT_KEY, "demux_stall");     // Catch: JSONException -> L34
        r113.put("PLAY-SessionID", this.T2);     // Catch: JSONException -> L34
        VideoLiveManager r104 = this.f458980f;     // Catch: JSONException -> L34
        if (r104 != null) goto L31;
        return;
    L31:
        if (r104.mEnableOpenStrategyEngine != 1) goto L43;
        LiveStrategyManager.inst().setEventInfo(62, r113);     // Catch: JSONException -> L34
        return;
    L43:
        return;
    L27:
        r114 = 1;
        goto L28
    L20:
        r102 = "audio";
    L34:
        e = move-exception;
        e.printStackTrace();
        return;
    L41:
        return;
    L12:
        this.P8++;
        this.Q8 += r100;
        if (isPreview() == false) goto L15;
        this.f459027i9++;
        this.f459039j9 += r100;
        goto L15
    }

    public void onPushStall(JSONObject r100, JSONArray r101, String r102) throws JSONException {
        JSONObject r103 = createCommonLog();
        Iterator<String> r104 = r100.keys();
    L4:
        if (r104.hasNext() == false) goto L6;
        String r105 = r104.next();
        r103.put(r105, JSONObjectProtectorUtils.getLong(r100, r105));
        goto L4
    L6:
        if (r103 == null) goto L17;
        r103.put(LiveCommonConstants.LOG_PARAM_EVENT_KEY, r102).put("push_retry_stall", r101).put("sei_source", this.f458968e.f459300j1);     // Catch: JSONException -> L11
        onEventLog(r103, "live_client_monitor_log");     // Catch: JSONException -> L11
        long r106 = this.f459083n3;     // Catch: JSONException -> L11
        if (r106 <= 0) goto L18;
        this.f459083n3 = r106 + 1;     // Catch: JSONException -> L11
        return;
    L18:
        return;
    L11:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public void setProtocolInfo(String r100, String r101, String r102) {
        this.G5 = r100;
        this.F5 = r101;
        this.L5 = r102;
    }

    public void setSdkParams(String r100, int r101, int r102) {
        this.A = r100;
        this.B = r101;
        this.C = r102;
    }

    private JSONObject createFirstFrameLog(LogBundle r110, long r111, boolean r210, long r211) throws JSONException {
        if (this.f459081md == 1) goto L5;
        JSONObject r100 = createCommonLog();
    L6:
        if (r100 == null) goto L108;
        long r101 = r110.f459328p - r110.f459253a;
        JSONObject r102 = r100.put(LiveCommonConstants.LOG_PARAM_EVENT_KEY, PortraitEngine.LABEL_FIRST_FRAME).put("total_cost", r101).put("last_retry_end", r111).put(com.bytedance.android.ec.core.event.a.KEY_HIT_CACHE, r210 ? 1 : 0).put("start", r110.f459253a).put("sdk_dns_analysis_end", r110.f459258b).put("prepare_block_end", r110.f459263c);
        long r103 = r110.f459368x;
        if (r103 > 0) goto L10;
        r103 = r110.f459268d;
    L10:
        JSONObject r104 = r102.put("tfo_fall_back_time", r103).put("pre_connect", this.K4).put("request_cdn_cached", this.f458968e.f459324o0).put("request_time_to_source", this.f458968e.f459334q0).put("request_time_for_cdn", this.f458968e.f459344s0).put("http_req_finish_time", r110.f459309l0).put("http_res_finish_time", r110.f459314m0).put("first_video_package_end", r110.f459308l).put("first_audio_package_end", r110.f459313m).put("first_video_frame_decode_end", r110.f459318n).put("first_audio_frame_decode_end", r110.f459323o).put("first_frame_from_player_core", r110.f459338r).put("first_frame_render_end", r110.f459328p).put("video_param_send_outlet_time", r110.f459330p1).put("first_video_frame_send_outlet_time", r110.f459335q1).put("set_surface_time", this.f459198w5).put("set_surface_cost", this.f459186v5).put("video_render_type", r110.f459340r1).put("video_device_open_start", r110.f459348t).put("video_device_open_end", r110.f459353u).put("audio_device_open_start", r110.f459358v).put("audio_device_open_end", r110.f459363w).put("video_device_wait_start", r110.f459355u1).put("video_device_wait_end", r110.f459360v1).put("find_stream_info_start", r110.f459345s1).put("find_stream_info_end", r110.f459350t1).put("video_first_pkt_pos", r110.f459279f0).put("video_first_pkt_pts", r110.f459284g0).put("audio_first_pkt_pos", r110.f459289h0).put("audio_first_pkt_pts", r110.f459294i0).put("video_buffer_time", this.f458968e.Y0).put("audio_buffer_time", this.f458968e.Z0).put("download_speed", this.f458968e.Q0).put("stall_time", r211).put("first_sei_delay", this.f458968e.f459280f1).put("response_header_X-Server-IP", this.f458968e.f459375y1).put("response_header_Via", this.f458968e.f459380z1).put("prepare_end", r110.f459343s).put("drop_audio_pts_diff", r110.f459299j0).put("drop_audio_cost", r110.f459304k0).put("enable_tcp_fast_open", this.f458921a7).put("tfo_success", r110.C2).put("abr_check_enhance", this.f459138r7);
        if (this.f458949c7 != null) goto L13;
        JSONArray r105 = new JSONArray();
    L14:
        r104.put("optimize_backup_ips", r105).put("suggest_format", this.E5).put("suggest_protocol", this.G5).put("suggest_access_code", this.L5).put(IVideoEventLogger.LOG_CALLBACK_CONTAINER_FPS, this.C5).put("used_drm", this.f459078ma).put("ipv6_probe_result", r110.F2).put("http_open_start", r110.f459283g).put("trans_open_start", r110.f459288h).put("socket_create_end", r110.f459293i).put("3xx_happen_time", r110.f459298j).put("trans_strategy_params", this.Da).put("trans_params_bandwidth", this.Ea).put("trans_params_bandwidth_decision", this.Fa).put("is_free_flow", this.Q).put("enable_fast_first_frame", this.T5).put("preplay_enter_room_timestamp", this.f459004gc).put("event_key_index", f458907de.incrementAndGet()).put("UseRedirectedIp", this.L4).put("UsePreconnectIp", this.N4);
        long r106 = this.f459004gc;
        if (r106 == (-1)) goto L20;
        long r112 = r110.f459318n;
        if (r106 <= r112) goto L20;
        this.f459018hc = r106 - r112;
    L20:
        if (r106 == (-1)) goto L23;
        c.i("LiveLoggerService", "preplay enter room at: " + this.f459004gc + ", wait cost: " + this.f459018hc);
    L23:
        if (this.f459078ma != 1) goto L26;
        r100.put("drm_get_secret_key_end", this.f459090na);
    L26:
        if (this.f459043jd != 1) goto L29;
        r100.put("ip_from_player_core", this.f459169u ? 1 : 0).put("open_dns_optimizer", this.R ? 1 : 0).put("hit_node_optimize", this.W ? 1 : 0).put("evaluator_symbol", this.S);
    L29:
        if (TextUtils.isEmpty(this.O4) == true) goto L32;
        r100.put("pre_redirect_new_args", this.O4);
    L32:
        if (TextUtils.isEmpty(this.P4) == true) goto L35;
        r100.put("pre_redirect_ip", this.P4);
    L35:
        if (isRtcPlayAvailable() == false) goto L37;
    L47:
        r100.put("player_dns_analysis_end", this.H7);
        r100.put("rtc_use_sdk_dns", this.G7);
        r100.put("tcp_connect_end", this.I7);
        r100.put("rtc_tls_handshake_end", this.J7);
        r100.put("tcp_first_package_end", this.K7);
        r100.put("rtc_inited_end", r110.f459296i2);
        r100.put("rtc_offer_send_end", r110.f459316m2);
        r100.put("rtc_answer_recv_end", r110.f459321n2);
        r100.put("rtc_ice_connected_time", r110.f459336q2);
        r100.put("rtc_start_end", r110.f459341r2);
        r100.put("rtc_preload_result", getRTCPreloadingState());
        r100.put("first_audio_frame_decode_start", r110.f459361v2);
        r100.put("first_video_frame_decode_start", r110.f459356u2);
        r100.put("first_audio_frame_end", r110.f459351t2);
        r100.put("first_video_frame_end", r110.f459346s2);
        if (isRtmv3() == false) goto L50;
        r100.put("player_open_input_start", r110.f459273e);
    L50:
        int r107 = this.K2;
        if (r107 == (-1)) goto L54;
        r100.put("audio_timescale_enable", r107);
    L54:
        if (this.f459113p6 == false) goto L57;
        r100.put("abr_startup_bitrate", r110.X0);
        r100.put("abr_request_url", r110.f459267c3);
    L57:
        if (TextUtils.equals(this.F5, "quic") == false) goto L59;
    L60:
        r100.put("quic_report_ccre_tag_in_chlo", this.f458968e.Z1).put("quic_report_jcco_tag_in_chlo", this.f458968e.f459256a2).put("quic_report_ssr_tag_in_chlo", this.f458968e.f459261b2).put("quic_report_irtt_tag_in_chlo", this.f458968e.f459266c2).put("quic_report_cctk_tag_in_chlo", this.f458968e.f459271d2).put("quic_report_ntyp_tag_in_chlo", this.f458968e.f459276e2).put("quic_report_ccfb_tag_in_shlo", this.f458968e.f459281f2);
    L61:
        r100.put("perf_strategy_avg_cost", this.Vd);
        if (TextUtils.equals(this.F5, "quic") == false) goto L64;
    L65:
        setExtParam(r100, this.P5);
    L67:
        if (TextUtils.equals(this.F5, "h2") == false) goto L69;
    L72:
        setExtParam(r100, this.O5);
    L74:
        if (TextUtils.equals(this.V2, "avph") == false) goto L77;
        setExtParam(r100, this.Q5);
    L77:
        if (TextUtils.equals(this.V2, "cmaf") == false) goto L79;
        setExtParam(r100, this.S5);
        r100.put("cmaf_start_seq_no_diff", this.f458968e.L).put("audio_request_cdn_cached", this.f458968e.f459319n0).put("video_request_cdn_cached", this.f458968e.f459324o0).put("audio_request_time_to_source", this.f458968e.f459329p0).put("video_request_time_to_source", this.f458968e.f459334q0).put("audio_request_time_for_cdn", this.f458968e.f459339r0).put("video_request_time_for_cdn", this.f458968e.f459344s0);
    L79:
        addStreamVersion(r100);
        JSONObject r108 = new JSONObject();
        JSONObject r109 = r108.put("PLAY-FirstFrameAudioBuffer", this.f458968e.Z0).put("PLAY-FirstFrameVideoBuffer", this.f458968e.Y0).put("PLAY-FirstFrameDownloadSpeed", this.f458968e.Q0);
        String r113 = this.f459032j;
        String r114 = "none";
        if (r113 != null) goto L82;
        r113 = "none";
    L82:
        JSONObject r115 = r109.put("PLAY-EnterMethod", r113);
        String r116 = this.f459044k;
        if (r116 != null) goto L85;
        r116 = "none";
    L85:
        JSONObject r117 = r115.put("PLAY-EnterAction", r116);
        String r118 = this.f459058l;
        if (r118 == null) goto L89;
        r114 = r118;
    L89:
        JSONObject r119 = r117.put("PLAY-EnterMethodSubtag", r114).put("PLAY-IsPreview", this.f459195w ? 1 : 0).put("PLAY-Protocol", this.F5).put("PLAY-FirstFrame", r101).put("PLAY-Success", 1);
        if (this.f458968e.f459298j <= 0) goto L92;
        boolean r120 = true;
    L93:
        r119.put("PLAY-302", r120).put("PLAY-BufferDataSeconds", this.f458980f.mBufferDataSeconds);
        r108.put("PLAY-ConnectCost", r100.optLong("tcp_connect_end") - r100.optLong("player_dns_analysis_end"));
        r108.put("PLAY-SessionID", this.T2);
        r100.put("first_play_time", -1);
        VideoLiveManager r121 = this.f458980f;
        if (r121 == null) goto L103;
        if (r121.mEnableOpenStrategyEngine != 1) goto L103;
        r108.put("PLAY-StreamSuffix", r121.getStreamSuffix());
        r108.put("PLAY-NeptuneName", this.f458980f.getNeptuneName());
        r108.put("PLAY-FPS", this.f458980f.getFPS());
        if (LiveStrategyManager.inst().mFirstStart == false) goto L100;
        long r122 = r110.f459253a - LiveStrategyManager.mLoadLibraryTime;
    L101:
        r100.put("first_play_time", r122);
        LiveStrategyManager.inst().setEventInfo(61, r108);
        goto L103
    L100:
        r122 = -1;
    L103:
        if (this.f459043jd != 1) goto L107;
        int r123 = this.f459132qd;
        if (r123 <= 0) goto L107;
        r100.put("receive_sps_pps_count", r123);
        r100.put("receive_sps_pps_list", this.f459144rd);
    L107:
        return r100;
    L92:
        r120 = false;
        goto L93
    L69:
        if (TextUtils.equals(this.F5, "h2q") == true) goto L72;
        if (TextUtils.equals(this.F5, "h2qu") == false) goto L74;
    L64:
        if (TextUtils.equals(this.F5, "quicu") == false) goto L67;
    L59:
        if (TextUtils.equals(this.F5, "h2q") == false) goto L61;
    L37:
        if (isRtmv3() == true) goto L47;
        if (r110.f459258b != 0) goto L42;
        r100.put("sdk_dns_analysis_end", this.f459026i8.f459258b);
    L42:
        r100.put("player_dns_analysis_end", r110.f459268d);
        r100.put("player_open_input_start", r110.f459273e);
        if ("kcp".equals(this.F5) == false) goto L45;
        long r124 = r110.f459268d;
    L46:
        r100.put("tcp_connect_end", r124);
        r100.put("tcp_first_package_end", r110.f459303k);
        goto L50
    L45:
        r124 = r110.f459278f;
        goto L46
    L13:
        r105 = new JSONArray(this.f458949c7);
        goto L14
    L108:
        return null;
    L5:
        r100 = createCommonLog_v2();
        goto L6
    }

    public void logSharpenConfigType(LogBundle.VideoProcessConfigChannel r100, int r101, int r102, String r103) {
        LogBundle r104 = this.f458968e;
        if (r104 != null) goto L5;
        return;
    L5:
        r104.f459337q3 = r100;
        r104.f459342r3 = r101;
        r104.f459347s3 = r102;
        r104.f459352t3 = r103;
    }

    public void onAbrSwitch(long r110, String r111, boolean r210, boolean r211) {
        if (this.f458980f != null) goto L24;
        return;
    L24:
        JSONObject r100 = createCommonLog();     // Catch: JSONException -> L21
        LogBundle r101 = new LogBundle();     // Catch: JSONException -> L21
        this.f458980f.getLogInfo(r101, 11);     // Catch: JSONException -> L21
        long r102 = r101.f459278f;     // Catch: JSONException -> L21
        long r103 = r102 - r101.f459268d;     // Catch: JSONException -> L21
        long r104 = r101.f459303k - r102;     // Catch: JSONException -> L21
        if (this.f458968e.f459328p <= 0) goto L8;
        long r105 = System.currentTimeMillis() - this.f458968e.f459328p;     // Catch: JSONException -> L21
    L9:
        JSONObject r112 = r100.put(LiveCommonConstants.LOG_PARAM_EVENT_KEY, "abr_switch");     // Catch: JSONException -> L21
        if (r210 == false) goto L12;
        int r113 = 1;
    L13:
        r112.put("auto_switch", r113).put("target_resoultion", r111).put("predict_bitrate", r110).put("abr_switch_info", this.B6).put("cur_download_speed", this.f459213x6).put("cur_audio_buffer_time", this.f459227y6).put("cur_video_buffer_time", this.f459239z6).put("stall_count", this.f459158t3).put("switch_cost", this.A6).put("use_expect_bitrate", this.f458962d8).put("tcp_connect_cost", r103).put("tcp_first_package_cost", r104).put("find_stream_info_cost", r101.f459262b3).put(BdpAppEventConstant.PARAMS_REQUEST_URL, r101.f459267c3).put("prev_video_buffer_time", r101.Y0).put("prev_audio_buffer_time", r101.Z0).put("external_smooth_switch", this.Ub).put("abr_switch_count", this.f459086n6).put("request_cdn_cached", r101.f459324o0).put("request_time_to_source", r101.f459334q0).put("request_time_for_cdn", r101.f459344s0).put("close_io_cost", r101.f459272d3).put(HistoryTableOperate.HISTORY_PLAY_TIME, r105).put("abr_switch_stall_time", this.f459104oc);     // Catch: JSONException -> L21
        onAbrSwitchEnd();     // Catch: JSONException -> L21
        this.f458962d8 = 0;     // Catch: JSONException -> L21
        this.Ub = 0;     // Catch: JSONException -> L21
        if (this.f459084n4 != 1) goto L16;
        reportSessionFirstFrame(r100, 1, LiveError.ABR_SWITCH_FIRST_FRAME);     // Catch: JSONException -> L21
    L16:
        if (r211 == false) goto L26;
        c.t("LiveLoggerService", "abr switch log: " + r100);     // Catch: JSONException -> L21
        onEventLog(r100, "live_client_monitor_log");     // Catch: JSONException -> L21
        long r106 = this.f459083n3;     // Catch: JSONException -> L21
        if (r106 <= 0) goto L27;
        this.f459083n3 = r106 + 1;     // Catch: JSONException -> L21
        return;
    L27:
        return;
    L26:
        return;
    L12:
        r113 = 0;
        goto L13
    L8:
        r105 = 0;
    L21:
        e = move-exception;
        e.printStackTrace();
    }

    public void onRenderStall(long r110, int r111, boolean r210, boolean r211) {
        this.f459129qa = 1;
        if (r110 <= (System.currentTimeMillis() - this.f458968e.f459253a)) goto L5;
    L52:
        c.i("LiveLoggerService", "abnormal render stall time" + r110);
        return;
    L5:
        if (r110 <= r111) goto L52;
        if (r210 == false) goto L19;
        c.i("LiveLoggerService", "video render stall time " + r110);
        this.O3 = this.O3 + 1;
        this.H3 = this.H3 + 1;
        this.P3 = (int) (((long) this.P3) + r110);
        this.I3 += r110;
        if (this.f459014h8 != 1) goto L12;
        this.f459151s8++;
        this.f459163t8 += r110;
    L12:
        long r112 = System.currentTimeMillis() - this.f458968e.f459328p;
        if (this.X4.equals("none") == false) goto L15;
        this.X4 = r112 + ":" + r110;
    L17:
        if (isPreview() == false) goto L29;
        this.f459210x3++;
        this.f459224y3 += r110;
        this.D3++;
        this.E3 = (int) (((long) this.E3) + r110);
    L29:
        if (r211 == false) goto L56;
        this.f458980f.getLogInfo(this.f458968e, 4);
        JSONObject r100 = createCommonLog();
        if (r100 == null) goto L57;
        JSONObject r101 = r100.put(LiveCommonConstants.LOG_PARAM_EVENT_KEY, "render_stall");     // Catch: JSONException -> L49
        if (r210 == false) goto L35;
        String r113 = "video";
    L36:
        r101.put("type", r113).put("stall_time", r110).put("video_buffer_time", this.f458968e.Y0).put("audio_buffer_time", this.f458968e.Z0).put("event_key_index", f458913je.incrementAndGet());     // Catch: JSONException -> L49
        onEventLog(r100, "live_client_monitor_log");     // Catch: JSONException -> L49
        long r102 = this.f459083n3;     // Catch: JSONException -> L49
        if (r102 <= 0) goto L39;
        this.f459083n3 = r102 + 1;     // Catch: JSONException -> L49
    L39:
        JSONObject r103 = new JSONObject();     // Catch: JSONException -> L49
        if (r210 == false) goto L42;
        int r104 = 0;
    L43:
        r103.put("PLAY-StallType", r104).put("PLAY-StallTime", r110).put(LiveCommonConstants.LOG_PARAM_EVENT_KEY, "render_stall");     // Catch: JSONException -> L49
        r103.put("PLAY-SessionID", this.T2);     // Catch: JSONException -> L49
        VideoLiveManager r105 = this.f458980f;     // Catch: JSONException -> L49
        if (r105 != null) goto L46;
        return;
    L46:
        if (r105.mEnableOpenStrategyEngine != 1) goto L59;
        LiveStrategyManager.inst().setEventInfo(62, r103);     // Catch: JSONException -> L49
        return;
    L59:
        return;
    L42:
        r104 = 1;
        goto L43
    L35:
        r113 = "audio";
    L49:
        e = move-exception;
        e.printStackTrace();
        return;
    L57:
        return;
    L56:
        return;
    L15:
        this.X4 += "," + r112 + ":" + r110;
        goto L17
    L19:
        c.i("LiveLoggerService", "audio render stall time " + r110);
        this.Q3 = this.Q3 + 1;
        this.J3 = this.J3 + 1;
        this.R3 = (int) (((long) this.R3) + r110);
        this.K3 += r110;
        if (this.f459014h8 != 1) goto L22;
        this.f459175u8++;
        this.f459189v8 += r110;
    L22:
        long r114 = System.currentTimeMillis() - this.f458968e.f459328p;
        if (this.W4.equals("none") == false) goto L25;
        this.W4 = r114 + ":" + r110;
    L27:
        if (isPreview() == false) goto L29;
        this.f459236z3++;
        this.A3 += r110;
        this.F3++;
        this.G3 = (int) (((long) this.G3) + r110);
        goto L29
    L25:
        this.W4 += "," + r114 + ":" + r110;
        goto L27
    }

    public void onReportVQScore(int r100, float r101, float r102, int r110) {
        if (this.f458980f != null) goto L5;
        return;
    L5:
        JSONObject r103 = createCommonLog();
        this.f458980f.getLogInfo(this.f458968e, 12);
        if (r103 == null) goto L26;
        JSONObject r104 = r103.put("index", r100).put(LiveCommonConstants.LOG_PARAM_EVENT_KEY, "vqscore_report").put("sr_scale_type_float", this.f458968e.f459322n3).put("sr_alg_type", this.f458968e.f459312l3);     // Catch: JSONException -> L21
        if (this.f458968e.f459342r3 < 0) goto L10;
        int r105 = 1;
    L11:
        r104.put("sharpen_used", r105).put("sharpen_alg_type", this.f458968e.f459342r3).put("is_hdr", this.f458968e.f459327o3).put("width", this.I4).put("height", this.J4).put("sr_sharp_level", this.f458968e.f459317m3).put("download_speed", this.f458968e.Q0).put("vqscore_algorithm_type", r110).put("vqscore_result", r101).put("vqscore_result_after_effect", r102);     // Catch: JSONException -> L21
        addViewResolutionInfo(r103);     // Catch: JSONException -> L21
        if (this.f458980f.getEnableSR() != 1) goto L15;
        addBmfSrSharpInfo(r103, this.f458980f.getSRUsed());     // Catch: JSONException -> L21
    L15:
        if (this.f458980f.getEnableSharpen() != 1) goto L17;
        addBmfSharpenLevelInfo(r103);     // Catch: JSONException -> L21
    L17:
        onEventLog(r103, "live_client_monitor_log");     // Catch: JSONException -> L21
        long r106 = this.f459083n3;     // Catch: JSONException -> L21
        if (r106 <= 0) goto L27;
        this.f459083n3 = r106 + 1;     // Catch: JSONException -> L21
        return;
    L27:
        return;
    L10:
        r105 = 0;
    L21:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public void onSwitch(String r100, String r101, String r102, int r103) {
        if (this.f458980f != null) goto L29;
        return;
    L29:
        JSONObject r104 = createCommonLog();     // Catch: JSONException -> L26
        JSONObject r105 = r104.put(LiveCommonConstants.LOG_PARAM_EVENT_KEY, "switch_url");     // Catch: JSONException -> L26
        if (r100 != null) goto L9;
        r100 = "null";
    L9:
        JSONObject r106 = r105.put("last_cdn_play_url", r100);     // Catch: JSONException -> L26
        if (r101 != null) goto L12;
        r101 = "null";
    L12:
        r106.put("next_cdn_play_url", r101).put("res_bitrate", this.f459062l6).put("last_res", this.f459050k6).put("code", r103).put("reason", r102);     // Catch: JSONException -> L26
        String r107 = this.f458968e.S1;     // Catch: JSONException -> L26
        if (TextUtils.isEmpty(r107) == true) goto L22;
        r104.put("liveio_metrics", r107);     // Catch: JSONException -> L26
        JSONObject r108 = new JSONObject(r107);     // Catch: JSONException -> L20
        Iterator<String> r109 = r108.keys();     // Catch: JSONException -> L20
    L17:
        if (r109.hasNext() == false) goto L22;
        String r110 = r109.next();     // Catch: JSONException -> L20
        r104.put(r110, r108.get(r110));     // Catch: JSONException -> L20
    L20:
        e = move-exception;
        e.printStackTrace();     // Catch: JSONException -> L26
    L22:
        onEventLog(r104, "live_client_monitor_log");     // Catch: JSONException -> L26
        long r111 = this.f459083n3;     // Catch: JSONException -> L26
        if (r111 <= 0) goto L35;
        this.f459083n3 = r111 + 1;     // Catch: JSONException -> L26
        return;
    L35:
        return;
    L26:
        e = move-exception;
        e.printStackTrace();
    }

    public void setPreRedirectedMetrics(int r100, String r101, String r102, String r103) {
        this.L4 = r100;
        this.M4 = r101;
        this.O4 = r102;
        this.P4 = r103;
    }

    public void logSrConfigType(LogBundle.VideoProcessConfigChannel r100, int r101, int r102, int r103, String r104) {
        LogBundle r105 = this.f458968e;
        if (r105 != null) goto L5;
        return;
    L5:
        r105.f459307k3 = r100;
        r105.f459312l3 = r101;
        r105.getClass();
        LogBundle r106 = this.f458968e;
        r106.f459317m3 = r103;
        r106.f459332p3 = r104;
    }

    public LiveLoggerService(VideoLiveManager r110, com.ss.videoarch.liveplayer.e r111, long r112, long r113, Context r210, int r211) {
        super(r110);
        this.f458916a = -1;
        this.f459006h = false;
        this.f459020i = 0;
        this.f459032j = "none";
        this.f459044k = "none";
        this.f459058l = "none";
        this.f459070m = "none";
        this.f459082n = "none";
        this.f459094o = null;
        this.f459106p = "none";
        this.f459121q = "none";
        this.f459133r = "none";
        this.f459145s = "none";
        this.f459157t = "none";
        this.f459169u = false;
        this.f459181v = "none";
        this.f459195w = false;
        this.f459207x = 0;
        this.f459221y = "none";
        this.f459235z = -1;
        this.A = "none";
        this.B = 0;
        this.C = 0;
        this.D = "none";
        this.E = "none";
        this.F = "none";
        this.G = "none";
        this.H = "none";
        this.I = -1;
        this.f458915J = -1;
        this.K = -1;
        this.L = -1;
        this.M = -1;
        this.N = "none";
        this.O = "none";
        this.P = "";
        this.Q = 0;
        this.R = false;
        this.S = "none";
        this.T = -1;
        this.U = -1;
        this.V = -1;
        this.W = false;
        this.X = false;
        this.Y = false;
        this.Z = "none";
        this.f459045k0 = false;
        this.f459107p0 = "none";
        this.H0 = 0;
        this.L0 = 1;
        this.P0 = false;
        this.V0 = 0;
        this.f458930b1 = -1;
        this.f458993g1 = -1;
        this.f459007h1 = -1;
        this.f459046k1 = -1;
        this.f459108p1 = -1;
        this.f459182v1 = 0;
        this.f459208x1 = 0;
        this.f459222y1 = 0;
        this.G1 = 0;
        this.H1 = 0;
        this.L1 = 0;
        this.M1 = -1.0f;
        this.P1 = -1;
        this.Q1 = -1.0f;
        this.S1 = 0.0f;
        this.T1 = 0;
        this.V1 = 0;
        this.f458931b2 = 0;
        this.f458994g2 = 0;
        this.f459008h2 = 0;
        this.f459109p2 = "none";
        this.f459183v2 = "none";
        this.f459209x2 = 0;
        this.f459223y2 = 2000;
        this.E2 = 0;
        this.F2 = -1;
        this.G2 = 0;
        this.H2 = 0;
        this.I2 = 0;
        this.J2 = 0;
        this.K2 = -1;
        this.L2 = 0;
        this.M2 = 0;
        this.N2 = -1;
        this.O2 = -1.0f;
        this.P2 = -1;
        this.Q2 = "none";
        this.R2 = "none";
        this.S2 = "none";
        this.T2 = "none";
        this.U2 = "none";
        this.V2 = "flv";
        this.W2 = "none";
        this.X2 = "";
        this.Y2 = 0;
        this.Z2 = 0;
        this.f458917a3 = 0;
        this.f458932b3 = 0;
        this.f458945c3 = 2;
        this.f458957d3 = 3000;
        this.f458969e3 = 0;
        this.f458981f3 = -1;
        this.f458995g3 = 0;
        this.f459009h3 = false;
        this.f459021i3 = false;
        this.f459033j3 = 0;
        this.f459047k3 = 0;
        this.f459059l3 = "";
        this.f459071m3 = 0;
        this.f459083n3 = 0;
        this.f459095o3 = 0;
        this.f459110p3 = 0;
        this.f459122q3 = 0;
        this.f459134r3 = 0;
        this.f459146s3 = -1;
        this.f459158t3 = 0;
        this.f459170u3 = 0;
        this.f459184v3 = 0;
        this.f459196w3 = 0;
        this.f459210x3 = 0;
        this.f459224y3 = 0;
        this.f459236z3 = 0;
        this.A3 = 0;
        this.B3 = 0;
        this.C3 = 0;
        this.D3 = 0;
        this.E3 = 0;
        this.F3 = 0;
        this.G3 = 0;
        this.H3 = 0;
        this.I3 = 0;
        this.J3 = 0;
        this.K3 = 0;
        this.L3 = false;
        this.M3 = 0;
        this.N3 = 0;
        this.O3 = 0;
        this.P3 = 0;
        this.Q3 = 0;
        this.R3 = 0;
        this.S3 = 0;
        this.T3 = 0;
        this.U3 = 0;
        this.V3 = 0;
        this.W3 = 0;
        this.X3 = 0;
        this.Y3 = 0;
        this.Z3 = 0;
        this.f458918a4 = 0;
        this.f458933b4 = 0;
        this.f458946c4 = false;
        this.f458958d4 = -1;
        this.f458970e4 = false;
        this.f458982f4 = false;
        this.f458996g4 = false;
        this.f459010h4 = 10000;
        this.f459022i4 = false;
        this.f459034j4 = 0;
        this.f459048k4 = 0;
        this.f459060l4 = 0;
        this.f459084n4 = 0;
        this.f459147s4 = 0;
        this.f459159t4 = -1;
        this.f459171u4 = false;
        this.f459197w4 = 0;
        this.f459211x4 = 0;
        this.f459225y4 = 0;
        this.f459237z4 = 0;
        this.A4 = 0;
        this.B4 = 0;
        this.C4 = 0;
        this.D4 = -1;
        this.E4 = 0;
        this.F4 = 0;
        this.G4 = null;
        this.H4 = 0;
        this.I4 = 0;
        this.J4 = 0;
        this.K4 = -1;
        this.L4 = -1;
        this.M4 = "none";
        this.N4 = -1;
        this.O4 = "";
        this.P4 = "";
        this.Q4 = null;
        this.R4 = null;
        this.S4 = null;
        this.T4 = null;
        this.U4 = null;
        this.V4 = -1;
        this.W4 = "none";
        this.X4 = "none";
        this.Y4 = null;
        this.Z4 = null;
        this.f458919a5 = null;
        this.f458934b5 = null;
        this.f458947c5 = "none";
        this.f458959d5 = "none";
        this.f458971e5 = "none";
        this.f458983f5 = "none";
        this.f458997g5 = false;
        this.f459011h5 = null;
        this.f459023i5 = false;
        this.f459035j5 = 0;
        this.f459049k5 = -1;
        this.f459061l5 = 0;
        this.f459073m5 = 1;
        this.f459085n5 = 0;
        this.f459097o5 = "none";
        this.f459112p5 = false;
        this.f459124q5 = -1;
        this.f459136r5 = -1;
        this.f459148s5 = false;
        this.f459160t5 = 0;
        this.f459172u5 = 1;
        this.f459186v5 = -1;
        this.f459198w5 = 0;
        this.f459212x5 = "none";
        this.f459226y5 = 0;
        this.f459238z5 = false;
        this.A5 = false;
        this.B5 = false;
        this.C5 = -1.0f;
        this.D5 = 0;
        this.E5 = "none";
        this.F5 = "tcp";
        this.G5 = "none";
        this.H5 = -1;
        this.I5 = 0;
        this.J5 = "none";
        this.K5 = "none";
        this.L5 = "none";
        this.M5 = false;
        this.N5 = false;
        this.O5 = null;
        this.P5 = null;
        this.Q5 = null;
        this.R5 = -1;
        this.S5 = null;
        this.T5 = 0;
        this.U5 = Build.BOARD;
        this.V5 = Build.HARDWARE;
        this.W5 = "none";
        this.X5 = "none";
        this.Y5 = "none";
        this.Z5 = false;
        this.f458920a6 = "rad";
        this.f458935b6 = false;
        this.f458948c6 = PlayerResolution.SDKKEY.ORIGIN;
        this.f458960d6 = "none";
        this.f458972e6 = "none";
        this.f458984f6 = new ArrayList();
        this.f458998g6 = false;
        this.f459012h6 = false;
        this.f459024i6 = "none";
        this.f459036j6 = PlayerResolution.SDKKEY.ORIGIN;
        this.f459050k6 = "none";
        this.f459062l6 = -1;
        this.f459074m6 = -1;
        this.f459086n6 = 0;
        this.f459098o6 = "none";
        this.f459113p6 = false;
        this.f459125q6 = -1;
        this.f459137r6 = 0;
        this.f459149s6 = "none";
        this.f459161t6 = -1;
        this.f459173u6 = 0;
        this.f459187v6 = 0;
        this.f459199w6 = 0;
        this.f459213x6 = -1;
        this.f459227y6 = -1;
        this.f459239z6 = -1;
        this.A6 = -1;
        this.B6 = "none";
        this.C6 = 4;
        this.D6 = false;
        this.E6 = 0;
        this.F6 = 0;
        this.G6 = 0;
        this.H6 = 0;
        this.I6 = 0;
        this.J6 = 0;
        this.K6 = 0;
        this.L6 = -1;
        this.M6 = -1;
        this.N6 = 0;
        this.O6 = 0;
        this.P6 = 0;
        this.Q6 = -1;
        this.R6 = -1;
        this.S6 = -1;
        this.T6 = -1;
        this.U6 = -1;
        this.V6 = -1;
        this.W6 = -1;
        this.X6 = -1;
        this.Y6 = -1;
        this.Z6 = -1;
        this.f458921a7 = 0;
        this.f458936b7 = 0;
        this.f458949c7 = null;
        this.f458961d7 = null;
        this.f458973e7 = -1;
        this.f458985f7 = -1;
        this.f458999g7 = -1;
        this.f459013h7 = 0;
        this.f459025i7 = 0;
        this.f459037j7 = 0;
        this.f459051k7 = 0;
        this.f459063l7 = -1;
        this.f459075m7 = -1;
        this.f459087n7 = new LinkedBlockingQueue(32);
        this.f459099o7 = "none";
        this.f459114p7 = new ArrayList();
        this.f459126q7 = new ArrayList();
        this.f459138r7 = 0;
        this.f459150s7 = new ArrayList();
        this.f459162t7 = new ArrayList();
        this.f459174u7 = new ArrayList();
        this.f459188v7 = new ArrayList();
        this.f459200w7 = null;
        this.f459214x7 = 0;
        this.f459228y7 = 0;
        this.f459240z7 = 0;
        this.A7 = 0;
        this.B7 = -1;
        this.C7 = 5000;
        this.D7 = 500;
        this.E7 = "none";
        this.F7 = false;
        this.G7 = -1;
        this.H7 = 0;
        this.I7 = 0;
        this.J7 = 0;
        this.K7 = 0;
        this.L7 = 0;
        this.M7 = 0;
        this.N7 = 0;
        this.O7 = "none";
        this.P7 = "none";
        this.Q7 = "none";
        this.R7 = 0;
        this.S7 = 0;
        this.T7 = 1;
        this.U7 = false;
        this.V7 = -1;
        this.W7 = 0;
        this.X7 = "none";
        this.Y7 = null;
        this.Z7 = "none";
        this.f458922a8 = 0;
        this.f458937b8 = -1;
        this.f458950c8 = -1.0f;
        this.f458962d8 = 0;
        this.f458974e8 = -1;
        this.f458986f8 = -1;
        this.f459000g8 = 0;
        this.f459014h8 = 1;
        this.f459038j8 = false;
        this.f459052k8 = 0;
        this.f459064l8 = 0;
        this.f459076m8 = 0;
        this.f459088n8 = 0;
        this.f459100o8 = 0;
        this.f459115p8 = 0;
        this.f459127q8 = 0;
        this.f459139r8 = 0;
        this.f459151s8 = 0;
        this.f459163t8 = 0;
        this.f459175u8 = 0;
        this.f459189v8 = 0;
        this.f459201w8 = 0;
        this.f459215x8 = 0;
        this.f459229y8 = -1;
        this.f459241z8 = 0;
        this.A8 = "none";
        this.B8 = 0;
        this.C8 = 0;
        this.D8 = 0;
        this.E8 = 0;
        this.F8 = 0;
        this.G8 = 0;
        this.H8 = 0;
        this.I8 = 0;
        this.J8 = 0;
        this.K8 = 0;
        this.L8 = 0;
        this.M8 = 0;
        this.N8 = 0;
        this.O8 = 0;
        this.P8 = 0;
        this.Q8 = 0;
        this.R8 = 0;
        this.S8 = 0;
        this.T8 = 0;
        this.U8 = 0;
        this.V8 = 0;
        this.W8 = 0;
        this.X8 = 0;
        this.Y8 = 0;
        this.Z8 = 0;
        this.f458923a9 = 0;
        this.f458938b9 = 0;
        this.f458951c9 = 0;
        this.f458963d9 = 0;
        this.f458975e9 = 0;
        this.f458987f9 = 0;
        this.f459001g9 = 0;
        this.f459015h9 = 0;
        this.f459027i9 = 0;
        this.f459039j9 = 0;
        this.f459053k9 = 0;
        this.f459065l9 = 0;
        this.f459077m9 = 0;
        this.f459089n9 = 0;
        this.f459101o9 = 0;
        this.f459116p9 = 0;
        this.f459128q9 = 0;
        this.f459140r9 = 0;
        this.f459152s9 = -1;
        this.f459164t9 = -1;
        this.f459176u9 = -1;
        this.f459190v9 = 0;
        this.f459202w9 = 0;
        this.f459216x9 = 0;
        this.f459230y9 = 0;
        this.f459242z9 = 0;
        this.A9 = 0;
        this.B9 = 0;
        this.C9 = 0;
        this.D9 = 0;
        this.E9 = 0;
        this.F9 = 0;
        this.H9 = 0;
        this.I9 = 0;
        this.J9 = 0;
        this.K9 = 0;
        this.L9 = "none";
        this.M9 = 0;
        this.N9 = 0;
        this.O9 = "none";
        this.P9 = 0;
        this.Q9 = 0;
        this.R9 = 0;
        this.S9 = 0;
        this.T9 = 0;
        this.U9 = 0;
        this.V9 = "none";
        this.W9 = "none";
        this.X9 = 0;
        this.Y9 = 0;
        this.Z9 = 0;
        this.f458924aa = 0;
        this.f458939ba = 0;
        this.f458952ca = 0;
        this.f458964da = 0;
        this.f458976ea = 0;
        this.f458988fa = 4096;
        this.f459002ga = 512;
        this.f459016ha = "";
        this.f459028ia = "";
        this.f459040ja = 5000;
        this.f459054ka = 0;
        this.f459066la = 0;
        this.f459078ma = -1;
        this.f459090na = 0;
        this.f459102oa = new ArrayList();
        this.f459117pa = 0;
        this.f459129qa = 0;
        this.f459141ra = "none";
        this.f459153sa = -1.0f;
        this.f459165ta = 0;
        this.f459177ua = 0;
        this.f459191va = 0;
        this.f459203wa = 0;
        this.f459217xa = 0;
        this.f459231ya = 0;
        this.f459243za = 0;
        this.Aa = 0;
        this.Ba = "none";
        this.Ca = 0;
        this.Da = "none";
        this.Ea = 0;
        this.Fa = 0;
        this.Ga = 0;
        this.Ha = 0;
        this.Ia = 0;
        this.Ja = 0;
        this.Ka = "none";
        this.La = -1;
        this.Ma = "none";
        this.Na = null;
        this.Oa = "none";
        this.Pa = "none";
        this.Qa = false;
        this.Ra = "none";
        this.Sa = "none";
        this.Ta = 0;
        this.Ua = 0;
        this.Va = 0;
        this.Wa = 0;
        this.Xa = -998;
        this.Ya = 0;
        this.Za = 0;
        this.f458925ab = 0;
        this.f458940bb = 0;
        this.f458953cb = "";
        this.f458965db = 0;
        this.f458977eb = 0;
        this.f458989fb = -1;
        this.f459003gb = null;
        this.f459017hb = null;
        this.f459029ib = null;
        this.f459041jb = null;
        this.f459055kb = null;
        this.f459067lb = null;
        this.f459079mb = null;
        this.f459091nb = null;
        this.f459103ob = 0;
        this.f459118pb = -1;
        this.f459130qb = null;
        this.f459142rb = false;
        this.f459154sb = -1;
        this.f459166tb = 0;
        this.f459178ub = "none";
        this.f459192vb = "none";
        this.f459204wb = 0;
        this.f459218xb = -1;
        this.f459232yb = 0;
        this.f459244zb = 0;
        this.Ab = 0;
        this.Bb = -1;
        this.Cb = -1;
        this.Db = 0;
        this.Eb = 0;
        this.Fb = 0;
        this.Gb = 0;
        this.Hb = 0;
        this.Ib = 0;
        this.Jb = 0;
        this.Kb = 0;
        this.Lb = 0;
        this.Mb = 0;
        this.Nb = 0;
        this.Ob = 0;
        this.Pb = -1;
        this.Qb = "none";
        this.Rb = "none";
        this.Sb = false;
        this.Tb = new ArrayList();
        this.Ub = 0;
        this.Vb = 0;
        this.Wb = 0;
        this.Xb = 0;
        this.Yb = -1.0f;
        this.Zb = 0;
        this.f458926ac = 0;
        this.f458941bc = 0;
        this.f458954cc = false;
        this.f458966dc = 0;
        this.f458978ec = 0;
        this.f458990fc = -1;
        this.f459004gc = -1;
        this.f459018hc = -1;
        this.f459030ic = false;
        this.f459042jc = 0;
        this.f459056kc = 0;
        this.f459068lc = 0;
        this.f459080mc = 0;
        this.f459092nc = 0;
        this.f459104oc = 0;
        this.f459119pc = 0;
        this.f459131qc = new AtomicBoolean(false);
        this.f459143rc = new ArrayList();
        this.f459155sc = 10;
        this.f459167tc = 0;
        this.f459179uc = false;
        this.f459193vc = 0;
        this.f459205wc = -1;
        this.f459219xc = 0;
        this.f459233yc = "";
        this.f459245zc = -1.0f;
        this.Ac = -1.0f;
        this.Bc = -1;
        this.Cc = "";
        this.Dc = "";
        this.Ec = -1;
        this.Fc = -1;
        this.Gc = "";
        this.Hc = "";
        this.Ic = -99;
        this.Jc = "";
        this.Kc = "";
        this.Lc = "";
        this.Mc = -1;
        this.Nc = new ArrayList();
        this.Oc = "none";
        this.Pc = 0;
        this.Qc = 0;
        this.Rc = -1;
        this.Sc = -1;
        this.Tc = -1;
        this.Uc = -1;
        this.Vc = 0;
        this.Wc = 0;
        this.Xc = 0;
        this.Yc = 0;
        this.Zc = 0;
        this.f458927ad = 0;
        this.f458942bd = -1;
        this.f458955cd = 0;
        this.f458967dd = 0;
        this.f458979ed = 0;
        this.f458991fd = new LinkedBlockingQueue(7200);
        this.f459005gd = false;
        this.f459019hd = "";
        this.f459031id = 0;
        this.f459043jd = 0;
        this.f459057kd = 0;
        this.f459069ld = 0;
        this.f459081md = 0;
        this.f459093nd = 0;
        this.f459105od = 0;
        this.f459120pd = 0;
        this.f459132qd = 0;
        this.f459144rd = new ArrayList();
        this.f459156sd = "";
        this.f459180ud = null;
        this.f459194vd = 0;
        this.f459206wd = 1;
        this.f459220xd = 1;
        this.f459234yd = new ArrayList();
        this.f459246zd = new ArrayList();
        this.Ad = 0;
        this.Bd = 0;
        this.Cd = 99999;
        this.Dd = 99999;
        this.Ed = "display_model_inital";
        this.Fd = "display_model_preview";
        this.Gd = "display_model_inner";
        this.Hd = "display_model_preview_preplay";
        this.Id = "display_model_inner_preplay";
        this.Jd = "display_model_background_watching";
        this.Kd = "display_model_small_window";
        this.Ld = 0;
        this.Md = 0;
        this.Nd = DisplayModel.INITAL;
        this.Od = "none";
        this.Pd = 0;
        this.Qd = new HashMap();
        this.Rd = null;
        this.Sd = -1;
        this.Td = 0;
        this.Ud = 0;
        this.Vd = -1;
        this.Wd = -1;
        this.Xd = new JSONObject();
        this.Yd = 0;
        this.Zd = 0;
        this.f458928ae = -1;
        this.f458943be = -1;
        this.f458929b = r210;
        this.f458944c = new Handler(this);
        if (r112 > 0) goto L5;
        long r100 = 60000;
    L6:
        this.f458992g = r100;
        this.f458956d = r111;
        this.f458980f = r110;
        this.f458968e = new LogBundle();
        NTPUDPClient r101 = new NTPUDPClient();
        this.f459096o4 = r101;
        r101.setDefaultTimeout(10000);
        this.f459010h4 = r113;
        c.i("LiveLoggerService", "enable report sessionstop: " + r211);
        this.f459026i8 = new LogBundle();
        this.f459200w7 = new LogBundle();
        new d();
        initReportKey();
        return;
    L5:
        r100 = r112;
        goto L6
    }

    private void report(boolean r210, long r310, long r311, long r312, long r313, long r314) {
        VideoLiveManager r100 = this.f458980f;
        if (r100 == null) goto L60;
        LogBundle r101 = this.f458968e;
        if (r101 != null) goto L8;
        return;
    L8:
        if (r310 == 0) goto L59;
        long r110 = r310;
    L12:
        if (r311 == 0) goto L14;
        long r211 = r311;
    L16:
        if (r312 == 0) goto L18;
        long r212 = r312;
    L20:
        if (r313 == 0) goto L22;
        long r213 = r313;
    L24:
        if (r314 == 0) goto L26;
        long r214 = r314;
    L27:
        if (r210 == true) goto L29;
        r100.getLogInfo(r101, 1);     // Catch: JSONException -> L48
    L31:
        if (canPlayingLogUpload() == false) goto L50;
        JSONObject r102 = createPlayingLog(this.f458968e, r110, r211, r212, r213, r210, r214);     // Catch: JSONException -> L48
        if (r210 == true) goto L36;
    L44:
        onEventLog(r102, "live_client_monitor_log");     // Catch: JSONException -> L48
        long r103 = this.f459083n3;     // Catch: JSONException -> L48
        if (r103 <= 0) goto L50;
        this.f459083n3 = r103 + 1;     // Catch: JSONException -> L48
        goto L50
    L36:
        if (this.f459105od != 1) goto L44;
        if (enableApplogReportEvent(r102) == false) goto L42;
        b r104 = this.f459072m4;     // Catch: JSONException -> L48
        if (r104 == null) goto L42;
        r104.onMonitorLog(r102, "live_client_monitor_log");     // Catch: JSONException -> L48
    L42:
        this.Xd = createPlayingInfo_v2(this.f458968e, r110, r211, r212, r213, r210, r214);     // Catch: JSONException -> L48
        return;
    L50:
        long r105 = this.f458992g;
        if (this.f459081md == 1) goto L56;
        if (isRtcPlayAvailable() == false) goto L56;
        r105 = this.f459040ja;
    L56:
        if (this.f459006h == false) goto L61;
        this.f458944c.sendEmptyMessageDelayed(101, r105);
        return;
    L61:
        return;
    L29:
        r101.M0 = System.currentTimeMillis();     // Catch: JSONException -> L48
        goto L31
    L26:
        r214 = r101.N0;     // Catch: JSONException -> L48
        goto L27
    L22:
        r213 = r101.O0;     // Catch: JSONException -> L48
        goto L24
    L18:
        r212 = r101.M0;     // Catch: JSONException -> L48
        goto L20
    L14:
        r211 = r101.f459354u0;     // Catch: JSONException -> L48
        goto L16
    L59:
        r110 = r101.f459349t0;     // Catch: JSONException -> L48
    L48:
        e = move-exception;
        e.printStackTrace();
        goto L50
    }

    private JSONObject createPlayingInfo_v2(LogBundle r210, long r211, long r212, long r213, long r214, boolean r310, long r311) throws JSONException {
        JSONObject r100 = new JSONObject();
        long r101 = r210.M0 - r213;
        if (isPreview() == false) goto L6;
        long r102 = r210.M0;
        r210.N0 = r102;
    L5:
        long r103 = r102 - r311;
    L10:
        long r110 = r210.O0 - r214;
        long r111 = r210.f459354u0 - r212;
        if (r110 > 0) goto L13;
    L15:
        long r112 = 0;
    L16:
        this.f459207x++;
        int r104 = this.M3;
        int r113 = this.N3;
        int r114 = this.B3;
        int r115 = this.C3;
        if (this.L3 == false) goto L26;
        if (this.f459134r3 == 0) goto L26;
        r104 = r104 + 1;
        int r116 = (int) (((long) r113) + (System.currentTimeMillis() - this.f459134r3));
        if (isPreview() == false) goto L24;
        r115 = (int) (((long) r115) + (System.currentTimeMillis() - this.f459134r3));
        r114 = r114 + 1;
    L24:
        this.f459134r3 = System.currentTimeMillis();
        r113 = r116;
    L26:
        long r105 = r210.f459349t0;
        long r106 = this.F6 + r105;
        int r117 = r114;
        if (this.D6 == true) goto L29;
        long r107 = r105 - r211;
    L30:
        int r118 = 0;
        this.D6 = false;
        if (r310 == false) goto L33;
        this.f458980f.updateAudioMetricBeforeStop();
    L33:
        this.f458980f.updateTTNqeInfo();
        r100.put("download_size_delta", r107).put(TTDelegateActivity.DOWNLOAD_SIZE, r106).put("video_play_size", r210.f459354u0).put("render_fps", r210.P0).put("video_rate", r112).put("download_speed", this.f458968e.Q0).put(HistoryTableOperate.HISTORY_PLAY_TIME, r101).put("play_time_preview", r103).put("retry_count", this.f458918a4).put("stall_count", r104).put("stall_time", r113).put("audio_render_stall_count", this.Q3).put("audio_render_stall_time", this.R3).put("video_render_stall_count", this.O3).put("video_render_stall_time", this.P3).put("silence_detected_count", this.f458958d4).put("stall_time_preview", r115).put("stall_count_preview", r117).put("audio_render_stall_count_preview", this.F3).put("audio_render_stall_time_preview", this.G3).put("video_render_stall_count_preview", this.D3).put("video_render_stall_time_preview", this.E3).put("is_last", r310 ? 1 : 0).put("index", this.f459207x).put("speed_switch_count", this.f459008h2).put("speed_switch_info", this.f459109p2).put("video_buffer_time", this.f458968e.Y0).put("audio_buffer_time", this.f458968e.Z0).put("enable_sei_check", this.f459148s5 ? 1 : 0).put("ntp_sync", this.f459135r4 ? 1 : 0).put("ntp_push_diff", this.f459147s4).put("rtc_stat_info", this.f458968e.f459371x2).put("suggest_format", this.E5).put("suggest_protocol", this.G5).put("suggest_access_code", this.L5).put("used_drm", this.f459078ma).put("first_sei_delay", this.f458968e.f459295i1).put("hit_check_sei_source", this.f459118pb).put("flvtag_based_speed", this.f458968e.R0).put("av_jitterbuffer_ms", this.f458968e.S0).put("enable_drop_frame", this.f458969e3).put("drop_frame_min_fps", this.f458995g3).put("drop_frame_rate", this.f458981f3).put("is_free_flow", this.Q).put("texturerender_error_msg", this.f459233yc).put("event_key_index", f458910ge.incrementAndGet()).put("audiometric_info_before", this.Cc).put("audiometric_info_after", this.Dc).put("volume_balance_target_lufs", this.Yb).put("volume_balance_effect_type", this.Zb).put("push_stream_delay", this.f458968e.f459285g1).put("liveio_p2p_dn_using", this.f458968e.C0).put("ttnet_nqe_info", this.X5).put("video_demux_stall_count", this.G8).put("video_demux_stall_time", this.H8).put("video_demux_stall_series", this.f459150s7).put("audio_demux_stall_count", this.I8).put("audio_demux_stall_time", this.J8).put("audio_demux_stall_series", this.f459162t7).put("video_decode_stall_count", this.K8).put("video_decode_stall_time", this.L8).put("video_decode_stall_series", this.f459174u7).put("audio_decode_stall_count", this.M8).put("audio_decode_stall_time", this.N8).put("audio_decode_stall_series", this.f459188v7).put("live_stream_session_id", this.R2).put("aed_scene", this.f458980f.logAudioAedSceneListString()).put("source_stream_luft", this.f459245zc);
        if (this.f458980f.isAudioRMSMonitorEnable() == false) goto L45;
        int r108 = this.f458980f.getAudioOutletRMS();
        int r109 = this.f458980f.getAudioDecoderRMS();
        r100.put("audio_outlet_db", r108).put("audio_decoder_db", r109);
        String r119 = this.f458980f.getAudioOutletRMSList();
        String r120 = this.f458980f.getAudioDecoderRMSList();
        Object r121 = new JSONArray();
        if (r119 == null) goto L38;
        r121 = new JSONArray(r119);
    L38:
        Object r122 = new JSONArray();
        if (r120 == null) goto L41;
        r122 = new JSONArray(r120);
    L41:
        r100.put("audio_outlet_db_full", r121).put("audio_decoder_db_full", r122);
        v r123 = new v();
        r123.f459656a = r108;
        r123.f459657b = r109;
        VideoLiveManager r124 = this.f458980f;
        g0 r125 = r124.mObserver;
        if (r125 == null) goto L45;
        r125.onAudioVolume(r124, r123);
    L45:
        if (this.f458980f.isAudioOutputDeviceTypeMonitorEnabled() == false) goto L47;
        r100.put("audio_output_device_type", this.f458980f.getAudioOutputDeviceType());
    L47:
        addViewResolutionInfo(r100);
        if (this.f458980f.getEnableSR() != 1) goto L51;
        addBmfSrBasicInfo(r100, this.f458980f.getSRUsed());
    L51:
        if (this.f458980f.getEnableSharpen() != 1) goto L53;
        addBmfSharpenBasicInfo(r100);
    L53:
        addAesBoostBasicInfo(r100);
        int r126 = this.f458952ca;
        if (r126 <= 0) goto L57;
        r100.put("av_out_sync_count", r126).put("av_out_sync_duration", this.f458976ea).put("av_out_sync_info", this.f459028ia);
    L57:
        if (this.f458980f.getEnableCalculateFLVTagBaseSpeed() != 2) goto L60;
        r100.put("estimated_bandwidth", this.f458968e.T0);
        r100.put("sd_samples", this.f458968e.U0);
        r100.put("avg_estimated", this.f458968e.V0);
        r100.put("sd_estimated", this.f458968e.W0);
    L60:
        if (this.f458991fd.isEmpty() == true) goto L72;
        JSONArray r127 = new JSONArray();
        int r128 = 0;
    L62:
        PureColorDetector.DetectResult r129 = (PureColorDetector.DetectResult) ((LinkedBlockingQueue) this.f458991fd).poll();
        if (r129 == null) goto L64;
        r118 = r118 + 1;
        if (r129.isPureColor == false) goto L62;
        r128 = r128 + 1;
        if (r128 <= 1) goto L71;
        if (this.f459005gd == false) goto L62;
    L71:
        r127.put(r129.pts);
        goto L62
    L64:
        JSONObject r130 = new JSONObject();
        r130.put("detect_count", r118);
        r130.put("count", r128);
        r130.put("ts", r127);
        JSONObject r131 = new JSONObject();
        r131.put("pure_color", r130);
        r100.put("frame_detect_abnormal", r131);
    L72:
        resetPlayingInfo();
        return r100;
    L29:
        r107 = r105 + this.E6;
        this.E6 = 0;
        goto L30
    L13:
        if (r111 <= 0) goto L15;
        r112 = (r111 * 8) / r110;
        goto L16
    L6:
        r102 = this.F9;
        if (r102 > r213) goto L5;
        r103 = 0;
        goto L10
    }

    private JSONObject createPlayingLog(LogBundle r210, long r211, long r212, long r213, long r214, boolean r310, long r311) throws JSONException {
        if (this.f459081md == 1) goto L5;
        JSONObject r100 = createCommonLog();
    L6:
        if (r100 == null) goto L83;
        long r101 = r210.M0 - r213;
        if (isPreview() == false) goto L11;
        long r110 = r210.M0;
        r210.N0 = r110;
    L10:
        long r111 = r110 - r311;
    L15:
        long r112 = r210.O0 - r214;
        long r113 = r210.f459354u0 - r212;
        if (r112 > 0) goto L18;
    L20:
        long r114 = 0;
    L21:
        this.f459207x++;
        int r102 = this.M3;
        int r115 = this.N3;
        int r116 = this.B3;
        int r103 = this.C3;
        if (this.L3 == false) goto L31;
        if (this.f459134r3 == 0) goto L31;
        r102 = r102 + 1;
        int r117 = (int) (((long) r115) + (System.currentTimeMillis() - this.f459134r3));
        if (isPreview() == false) goto L29;
        r103 = (int) (((long) r103) + (System.currentTimeMillis() - this.f459134r3));
        r116 = r116 + 1;
    L29:
        this.f459134r3 = System.currentTimeMillis();
        r115 = r117;
    L31:
        long r104 = r210.f459349t0;
        long r118 = this.F6 + r104;
        int r119 = r103;
        if (this.D6 == true) goto L34;
        long r105 = r104 - r211;
    L35:
        this.D6 = false;
        if (r310 == false) goto L38;
        this.f458980f.updateAudioMetricBeforeStop();
    L38:
        this.f458980f.updateTTNqeInfo();
        r100.put(LiveCommonConstants.LOG_PARAM_EVENT_KEY, "playing").put("download_size_delta", r105).put(TTDelegateActivity.DOWNLOAD_SIZE, r118).put("video_play_size", r210.f459354u0).put("render_fps", r210.P0).put("video_rate", r114).put("download_speed", this.f458968e.Q0).put(HistoryTableOperate.HISTORY_PLAY_TIME, r101).put("play_time_preview", r111).put("retry_count", this.f458918a4).put("stall_count", r102).put("stall_time", r115).put("audio_render_stall_count", this.Q3).put("audio_render_stall_time", this.R3).put("video_render_stall_count", this.O3).put("video_render_stall_time", this.P3).put("silence_detected_count", this.f458958d4).put("stall_time_preview", r116).put("stall_count_preview", r119).put("audio_render_stall_count_preview", this.F3).put("audio_render_stall_time_preview", this.G3).put("video_render_stall_count_preview", this.D3).put("video_render_stall_time_preview", this.E3).put("is_last", r310 ? 1 : 0).put("index", this.f459207x).put("speed_switch_count", this.f459008h2).put("speed_switch_info", this.f459109p2).put("video_buffer_time", this.f458968e.Y0).put("audio_buffer_time", this.f458968e.Z0).put("enable_sei_check", this.f459148s5 ? 1 : 0).put("ntp_sync", this.f459135r4 ? 1 : 0).put("ntp_push_diff", this.f459147s4).put("rtc_stat_info", this.f458968e.f459371x2).put("suggest_format", this.E5).put("suggest_protocol", this.G5).put("suggest_access_code", this.L5).put("used_drm", this.f459078ma).put("first_sei_delay", this.f458968e.f459295i1).put("hit_check_sei_source", this.f459118pb).put("flvtag_based_speed", this.f458968e.R0).put("av_jitterbuffer_ms", this.f458968e.S0).put("enable_drop_frame", this.f458969e3).put("drop_frame_min_fps", this.f458995g3).put("drop_frame_rate", this.f458981f3).put("is_free_flow", this.Q).put("texturerender_error_msg", this.f459233yc).put("event_key_index", f458910ge.incrementAndGet()).put("audiometric_info_before", this.Cc).put("audiometric_info_after", this.Dc).put("volume_balance_target_lufs", this.Yb).put("volume_balance_effect_type", this.Zb).put("push_stream_delay", this.f458968e.f459285g1).put("liveio_p2p_dn_using", this.f458968e.C0).put("ttnet_nqe_info", this.X5).put("video_demux_stall_count", this.G8).put("video_demux_stall_time", this.H8).put("video_demux_stall_series", this.f459150s7).put("audio_demux_stall_count", this.I8).put("audio_demux_stall_time", this.J8).put("audio_demux_stall_series", this.f459162t7).put("video_decode_stall_count", this.K8).put("video_decode_stall_time", this.L8).put("video_decode_stall_series", this.f459174u7).put("audio_decode_stall_count", this.M8).put("audio_decode_stall_time", this.N8).put("audio_decode_stall_series", this.f459188v7).put("aed_scene", this.f458980f.logAudioAedSceneListString()).put("source_stream_luft", this.f459245zc);
        if (this.f458980f.isAudioRMSMonitorEnable() == false) goto L50;
        int r106 = this.f458980f.getAudioOutletRMS();
        int r107 = this.f458980f.getAudioDecoderRMS();
        r100.put("audio_outlet_db", r106).put("audio_decoder_db", r107);
        String r108 = this.f458980f.getAudioOutletRMSList();
        String r109 = this.f458980f.getAudioDecoderRMSList();
        Object r120 = new JSONArray();
        if (r108 == null) goto L43;
        r120 = new JSONArray(r108);
    L43:
        Object r121 = new JSONArray();
        if (r109 == null) goto L46;
        r121 = new JSONArray(r109);
    L46:
        r100.put("audio_outlet_db_full", r120).put("audio_decoder_db_full", r121);
        v r122 = new v();
        r122.f459656a = r106;
        r122.f459657b = r107;
        VideoLiveManager r123 = this.f458980f;
        g0 r124 = r123.mObserver;
        if (r124 == null) goto L50;
        r124.onAudioVolume(r123, r122);
    L50:
        if (this.f458980f.isAudioOutputDeviceTypeMonitorEnabled() == false) goto L52;
        r100.put("audio_output_device_type", this.f458980f.getAudioOutputDeviceType());
    L52:
        addViewResolutionInfo(r100);
        if (this.f458980f.getEnableSR() != 1) goto L56;
        addBmfSrBasicInfo(r100, this.f458980f.getSRUsed());
    L56:
        if (this.f458980f.getEnableSharpen() != 1) goto L58;
        addBmfSharpenBasicInfo(r100);
    L58:
        addAesBoostBasicInfo(r100);
        r100.put("av_out_sync_count", this.f458952ca);
        r100.put("av_out_sync_duration", this.f458976ea);
        if (this.f458952ca <= 0) goto L62;
        r100.put("av_out_sync_info", this.f459028ia);
    L62:
        if (TextUtils.equals(this.G5, "quicu") == false) goto L65;
        r100.put("audio_quicu_frame_drop_time", this.S8).put("video_quicu_frame_drop_time", this.U8).put("audio_quicu_frame_drop_count", this.R8).put("video_quicu_frame_drop_count", this.T8).put("audio_quicu_frame_drop_time_preview", this.f459116p9).put("video_quicu_frame_drop_time_preview", this.f459140r9).put("audio_quicu_frame_drop_count_preview", this.f459101o9).put("video_quicu_frame_drop_count_preview", this.f459128q9);
    L65:
        if (this.f458980f.getEnableCalculateFLVTagBaseSpeed() != 2) goto L68;
        r100.put("estimated_bandwidth", this.f458968e.T0);
        r100.put("sd_samples", this.f458968e.U0);
        r100.put("avg_estimated", this.f458968e.V0);
        r100.put("sd_estimated", this.f458968e.W0);
    L68:
        if (this.f458991fd.isEmpty() == true) goto L81;
        JSONArray r125 = new JSONArray();
        int r126 = 0;
        int r127 = 0;
    L70:
        PureColorDetector.DetectResult r128 = (PureColorDetector.DetectResult) ((LinkedBlockingQueue) this.f458991fd).poll();
        if (r128 == null) goto L72;
        r127 = r127 + 1;
        if (r128.isPureColor == false) goto L70;
        r126 = r126 + 1;
        if (r126 <= 1) goto L79;
        if (this.f459005gd == false) goto L70;
    L79:
        r125.put(r128.pts);
        goto L70
    L72:
        JSONObject r129 = new JSONObject();
        r129.put("detect_count", r127);
        r129.put("count", r126);
        r129.put("ts", r125);
        JSONObject r130 = new JSONObject();
        r130.put("pure_color", r129);
        r100.put("frame_detect_abnormal", r130);
    L81:
        resetPlayingInfo();
        return r100;
    L34:
        r105 = r104 + this.E6;
        this.E6 = 0;
        goto L35
    L18:
        if (r113 <= 0) goto L20;
        r114 = (r113 * 8) / r112;
        goto L21
    L11:
        r110 = this.F9;
        if (r110 > r213) goto L10;
        r111 = 0;
        goto L15
    L83:
        return null;
    L5:
        r100 = createCommonLog_v2();
        goto L6
    }

    public void onVideoStallCounter(long r100, long r110, long r111, long r112, long r113, long r114, long r210) {
        JSONObject r101 = createCommonLog();
        if (r101 == null) goto L13;
        r101.put(LiveCommonConstants.LOG_PARAM_EVENT_KEY, "stall_counter").put("type", "video").put("render_stall_200_duration", r100 / 1000).put("render_stall_200_count", r100 % 1000).put("render_stall_300_duration", r110 / 1000).put("render_stall_300_count", r110 % 1000).put("render_stall_400_duration", r111 / 1000).put("render_stall_400_count", r111 % 1000).put("render_stall_500_duration", r112 / 1000).put("render_stall_500_count", r112 % 1000).put("demuxer_stall_500_duration", r113 / 1000).put("demuxer_stall_500_count", r113 % 1000).put("decode_pre_stall_500_duration", r114 / 1000).put("decode_pre_stall_500_count", r114 % 1000).put("decode_post_stall_500_duration", r210 / 1000).put("decode_post_stall_500_count", r210 % 1000);     // Catch: JSONException -> L8
        onEventLog(r101, "live_client_monitor_log");     // Catch: JSONException -> L8
        long r102 = this.f459083n3;     // Catch: JSONException -> L8
        if (r102 <= 0) goto L14;
        this.f459083n3 = r102 + 1;     // Catch: JSONException -> L8
        return;
    L14:
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    }
}
