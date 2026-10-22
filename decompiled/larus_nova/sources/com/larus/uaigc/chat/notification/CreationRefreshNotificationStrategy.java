package com.larus.uaigc.chat.notification;

import android.content.Intent;
import android.os.SystemClock;
import androidx.fragment.app.Fragment;
import com.bytedance.keva.Keva;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.bmhome.creative.loading.CreationQueuingTaskUIState;
import com.larus.bmhome.creative.loading.MessageLoadingUIState;
import com.larus.bmhome.creative.loading.ProgressLoadingUIState;
import com.larus.bmhome.creative.messagecard.bean.CreationInfo;
import com.larus.bmhome.creative.messagecard.bean.CreationMsgContentData;
import com.larus.bmhome.creative.messagecard.bean.CreationTask;
import com.larus.bmhome.creative.messagecard.bean.LoadingInfo;
import com.larus.bmhome.social.userchat.model.b0;
import com.larus.common.apphost.AppHost;
import com.larus.home.impl.sdk.ChatServiceImpl;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import com.larus.nova.R;
import com.larus.platform.IFlowSdkDepend;
import com.larus.uaigc.api.x;
import com.larus.uaigc.utils.DataConverterKt;
import com.larus.utils.logger.FLogger;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import hq9.u0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: classes4.dex */
public final class CreationRefreshNotificationStrategy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CreationRefreshNotificationStrategy f371308a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f371309b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap<String, a> f371310c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f371311d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Set<String> f371312e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f371313f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Lazy f371314g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Lazy f371315h = null;

    /* JADX INFO: loaded from: classes31.dex */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Message f371316a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Job f371317b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final HashMap<String, b> f371318c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f371319d;

        public a() {
            throw null;
        }

        public a(Message r100, Job r101) {
            HashMap<String, b> r102 = new HashMap();
            Intrinsics.checkNotNullParameter(r100, "message");
            Intrinsics.checkNotNullParameter(r101, "regularlyRefreshNotificationJob");
            Intrinsics.checkNotNullParameter(r102, "curUnfinishedTaskIdMap");
            this.f371316a = r100;
            this.f371317b = r101;
            this.f371318c = r102;
            this.f371319d = 2000;
        }
    }

    /* JADX INFO: loaded from: classes31.dex */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f371320a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f371321b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final com.larus.uaigc.chat.notification.a f371322c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f371323d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Long f371324e;

        public b(int r100, String r101, com.larus.uaigc.chat.notification.a r102, long r103) {
            Intrinsics.checkNotNullParameter(r101, DBDefinition.TASK_ID);
            Intrinsics.checkNotNullParameter(r102, "progressMocker");
            this.f371320a = r100;
            this.f371321b = r101;
            this.f371322c = r102;
            this.f371323d = r103;
            this.f371324e = null;
        }
    }

    public CreationRefreshNotificationStrategy() {
    }

    static {
        f371308a = new CreationRefreshNotificationStrategy();
        f371310c = new ConcurrentHashMap();
        f371311d = LazyKt.lazy(new g());
        f371312e = new LinkedHashSet();
        f371314g = LazyKt.lazy(new h());
        f371315h = LazyKt.lazy(new i());
    }

    public static u0 d() {
        return (u0) f371314g.getValue();
    }

    public static void f() {
        u0 r100 = d();
        if (r100 == null) goto L5;
        boolean r101 = Intrinsics.areEqual(r100.showNotification, Boolean.TRUE);
    L6:
        if (r101 == true) goto L8;
        return;
    L8:
        if (f371309b == true) goto L13;
        f371309b = true;
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new CreationRefreshNotificationStrategy$init$1(null), 2, null);
        return;
    L13:
        return;
    L5:
        r101 = false;
        goto L6
    }

    public static void g(List r100) {
        Intrinsics.checkNotNullParameter(r100, "lastMsgList");
        if (f371309b == true) goto L6;
        return;
    L6:
        if (f371313f == false) goto L8;
        return;
    L8:
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new CreationRefreshNotificationStrategy$onMessageListChanged$1(r100, null), 2, null);
    }

    public static double e(CreationTask r100, b r101) {
        LoadingInfo r102 = r100.loadingInfo;
        long r103 = 0;
        if (r102 == null) goto L7;
        Long r104 = r102.loadingBeginTimeSec;
        if (r104 == null) goto L7;
        long r105 = r104.longValue();
    L9:
        if (r105 <= 0) goto L17;
        double r106 = System.currentTimeMillis() / 1000.0d;
        LoadingInfo r107 = r100.loadingInfo;
        if (r107 == null) goto L18;
        Long r108 = r107.loadingBeginTimeSec;
        if (r108 == null) goto L18;
        r103 = r108.longValue();
    L18:
        return r106 - r103;
    L17:
        return (SystemClock.elapsedRealtime() - r101.f371323d) / 1000.0d;
    L7:
        r105 = 0;
        goto L9
    }

    public static final Object a(CreationRefreshNotificationStrategy r110, Message r111, Continuation r112) {
        r110.getClass();
        if ((r112 instanceof CreationRefreshNotificationStrategy$handleCreationMessageNotification$1) == false) goto L7;
        CreationRefreshNotificationStrategy$handleCreationMessageNotification$1 r100 = (CreationRefreshNotificationStrategy$handleCreationMessageNotification$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r113 = r100.result;
        Object r114 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = r100.label;
        boolean r103 = true;
        int r104 = 0;
        String r105 = "";
        if (r102 == 0) goto L16;
        if (r102 == 1) goto L15;
        if (r102 != 2) goto L14;
        r111 = (Message) r100.L$2;
        String r115 = (String) r100.L$1;
        Map r106 = (Map) r100.L$0;
        ResultKt.throwOnFailure(r113);
    L146:
        r106.put(r115, new a(r111, (Job) r113));
        Keva r116 = c.f371331a;
        c.a(CollectionsKt.toList(f371310c.keySet()));
    L181:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r111 = (Message) r100.L$0;
        ResultKt.throwOnFailure(r113);
    L121:
        Message r117 = (Message) r113;
        if (r117 == null) goto L124;
        String r118 = com.larus.bmhome.chat.bean.d.r(r117);
    L125:
        if (r118 != null) goto L128;
        r118 = "";
    L128:
        if (r118.length() == 0) goto L131;
        r103 = false;
    L131:
        if (r103 == false) goto L133;
        r118 = "";
    L133:
        ConcurrentHashMap<String, a> r107 = f371310c;
        if (r107.containsKey(r111.getMessageId()) == true) goto L181;
        String r108 = r111.getMessageId();
        if (r108 != null) goto L138;
        r108 = "";
    L138:
        String r109 = r111.getMessageId();
        if (r109 == null) goto L142;
        r105 = r109;
    L142:
        r100.L$0 = r107;
        r100.L$1 = r108;
        r100.L$2 = r111;
        r100.label = 2;
        r113 = BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new CreationRefreshNotificationStrategy$regularlyRefreshNotification$2(r105, r118, null), 2, null);
        if (r113 == r114) goto L192;
        r106 = r107;
        r115 = r108;
        goto L146
    L192:
        return r114;
    L124:
        r118 = null;
        goto L125
    L16:
        ResultKt.throwOnFailure(r113);
        CreationMsgContentData r119 = dp8.e.c(r111);
        if (f371313f == false) goto L19;
    L147:
        ConcurrentHashMap<String, a> r120 = f371310c;
        if (r120.containsKey(r111.getMessageId()) == false) goto L181;
        FLogger.f375446a.d("CreationRefreshNotificationStrategy", "dismissForegroundNotification msgId: " + r111.getMessageId() + ", , creationMsgNotificationStatusMap.size: " + r120.size());
        a r121 = r120.get(r111.getMessageId());
        if (r121 == null) goto L154;
        Job r122 = r121.f371317b;
        if (r122 == null) goto L154;
        Job.DefaultImpls.cancel$default(r122, null, 1, null);
    L154:
        a r123 = (a) TypeIntrinsics.asMutableMap(r120).remove(r111.getMessageId());
        if (r123 == null) goto L162;
        HashMap<String, b> r124 = r123.f371318c;
        if (r124 == null) goto L162;
        Iterator<Map.Entry<String, b>> r125 = r124.entrySet().iterator();
    L160:
        if (r125.hasNext() == false) goto L162;
        Map.Entry<String, b> r126 = r125.next();
        CreationService r127 = f.f371333a;
        f.b(r126.getValue().f371320a);
    L162:
        ConcurrentHashMap<String, a> r128 = f371310c;
        if (r128.size() != 1) goto L177;
        a r129 = (a) CollectionsKt.firstOrNull(r128.values());
        if (r129 == null) goto L169;
        HashMap<String, b> r130 = r129.f371318c;
        if (r130 == null) goto L169;
        int r131 = r130.size();
    L170:
        if (r131 > 1) goto L177;
        a r132 = (a) CollectionsKt.firstOrNull(r128.values());
        if (r132 == null) goto L177;
        CreationService r133 = f.f371333a;
        b r134 = (b) CollectionsKt.firstOrNull(r132.f371318c.values());
        if (r134 == null) goto L176;
        r104 = r134.f371320a;
    L176:
        f.b(r104);
    L169:
        r131 = 0;
    L177:
        Keva r135 = c.f371331a;
        c.a(CollectionsKt.toList(r128.keySet()));
        if (r128.isEmpty() == false) goto L181;
        f.d();
        goto L181
    L19:
        if (com.larus.bmhome.chat.bean.d.i0(r111) == false) goto L24;
        if (com.larus.bmhome.chat.bean.d.w(r111) == true) goto L24;
    L43:
        boolean r136 = false;
    L44:
        if (r136 == false) goto L147;
        if (r111.getMessageStatusLocal() == 23) goto L147;
        if (r111.getMessageStatusLocal() == 22) goto L147;
        if (r119 == null) goto L95;
        CreationInfo r137 = r119.creationInfo;
        if (r137 == null) goto L95;
        Map<String, CreationTask> r138 = r137.taskInfo;
        if (r138 == null) goto L95;
        Collection<CreationTask> r139 = r138.values();
        if (r139 == null) goto L95;
        Collection<CreationTask> r140 = r139;
        if (r140.isEmpty() == true) goto L92;
        Iterator<T> r141 = r140.iterator();
    L61:
        if (r141.hasNext() == false) goto L92;
        CreationTask r142 = (CreationTask) r141.next();
        if (r142 == null) goto L70;
        Integer r143 = r142.loadingAssetType;
        if (r143 == null) goto L70;
        if (r143.intValue() != 7) goto L70;
        boolean r144 = true;
    L71:
        if (r144 == true) goto L73;
    L89:
        boolean r145 = false;
    L90:
        if (r145 == false) goto L61;
        boolean r146 = true;
    L93:
        if (r146 != true) goto L95;
        boolean r147 = true;
    L96:
        if (r147 == false) goto L147;
        ConcurrentHashMap<String, a> r148 = f371310c;
        if (r148.containsKey(r111.getMessageId()) == false) goto L104;
        a r149 = r148.get(r111.getMessageId());
        if (r149 == null) goto L190;
        r149.f371316a = r111;
    L190:
        return Unit.INSTANCE;
    L104:
        if (r148.isEmpty() == true) goto L106;
    L115:
        FLogger.f375446a.d("CreationRefreshNotificationStrategy", "regularlyRefreshNotification msgId: " + r111.getMessageId() + ", creationMsgNotificationStatusMap.size: " + f371310c.size());
        IChatRepoService r150 = RepoDispatcherDelegate.f307737b.e();
        String r151 = r111.getReplyId();
        if (r151 != null) goto L118;
        r151 = "";
    L118:
        r100.L$0 = r111;
        r100.label = 1;
        r113 = r150.E1(r151, r100);
        if (r113 != r114) goto L121;
        return r114;
    L106:
        if (f.f371333a != null) goto L115;
        Result.Companion r152 = Result.Companion;     // Catch: Throwable -> L109
        e r153 = new e();     // Catch: Throwable -> L109
        AppHost.Companion r154 = AppHost.f326268a;     // Catch: Throwable -> L109
        r154.getApplication().bindService(new Intent(r154.getApplication(), CreationService.class), r153, 1);     // Catch: Throwable -> L109
        Object r155 = Result.m9449constructorimpl(r153);     // Catch: Throwable -> L109
    L112:
        if (Result.m9452exceptionOrNullimpl(r155) == null) goto L114;
        FLogger.f375446a.e("CreationNotificationManager", "bindForegroundService failed");
    L114:
        Result.m9448boximpl(r155);
    L109:
        th = move-exception;
        Result.Companion r156 = Result.Companion;
        r155 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L112
    L73:
        if (CollectionsKt.contains(CollectionsKt.listOf(new Integer[]{Boxing.boxInt(3), Boxing.boxInt(1)}), r142.status) == false) goto L89;
        long r157 = System.currentTimeMillis() / ((long) 1000);
        LoadingInfo r158 = r142.loadingInfo;
        if (r158 == null) goto L79;
        Long r159 = r158.loadingBeginTimeSec;
        if (r159 == null) goto L79;
        long r160 = r159.longValue();
    L80:
        long r161 = r157 - r160;
        u0 r162 = d();
        if (r162 == null) goto L85;
        Long r163 = r162.expireTime;
        if (r163 == null) goto L85;
        long r164 = r163.longValue();
    L87:
        if (r161 >= r164) goto L89;
        r145 = true;
    L85:
        r164 = 21600;
    L79:
        r160 = 0;
    L70:
        r144 = false;
    L92:
        r146 = false;
    L95:
        r147 = false;
    L24:
        if (com.larus.bmhome.chat.bean.d.T(r111) == true) goto L43;
        if (com.larus.bmhome.chat.bean.d.p0(r111) == true) goto L43;
        if (com.larus.bmhome.chat.bean.d.C0(r111) == true) goto L31;
    L33:
        MessageStatus r165 = r111.getMessageStatus();
        if (r165 != null) goto L36;
    L38:
        boolean r166 = false;
    L39:
        if (r166 == false) goto L41;
    L42:
        r136 = true;
        goto L44
    L41:
        if (b0.f(r111) == false) goto L43;
    L36:
        if (r165.isVisible() != true) goto L38;
        r166 = true;
        goto L39
    L31:
        if (r111.getRegenVisible() == true) goto L33;
    L7:
        r100 = new CreationRefreshNotificationStrategy$handleCreationMessageNotification$1(r110, r112);
        goto L8
    }

    public static String c(String r100, int r101, int r102) {
        if (r102 != 1) goto L7;
        return AppHost.f326268a.getApplication().getString(R.string.larus_pushVideo_title_generating_summary) + ((String) f371311d.getValue()) + r100;
    L7:
        return AppHost.f326268a.getApplication().getString(R.string.larus_pushVideo_title_generating_summary) + ' ' + (r101 + 1) + '/' + r102 + ((String) f371311d.getValue()) + r100;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:310:0x051a -> B:311:0x0523). Please report as a decompilation issue!!! */
    public static final Object b(CreationRefreshNotificationStrategy r210, a r211, String r310, Continuation r311) {
        a r100 = r211;
        r210.getClass();
        if ((r311 instanceof CreationRefreshNotificationStrategy$handleRefreshInner$1) == false) goto L7;
        CreationRefreshNotificationStrategy$handleRefreshInner$1 r101 = (CreationRefreshNotificationStrategy$handleRefreshInner$1) r311;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        int r106 = 3;
        int r107 = 2;
        String r110 = "";
        if (r105 == 0) goto L16;
        if (r105 == 1) goto L15;
        if (r105 != 2) goto L14;
        int r108 = r101.I$0;
        Iterator r109 = (Iterator) r101.L$4;
        List r111 = (List) r101.L$3;
        Message r112 = (Message) r101.L$2;
        String r113 = (String) r101.L$1;
        a r114 = (a) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L311:
        CreationRefreshNotificationStrategy$handleRefreshInner$1 r115 = r101;
        a r116 = r114;
        Message r117 = r112;
        Object r118 = r104;
        List r119 = r111;
        String r120 = r110;
    L265:
        Iterator r121 = r109;
        int r122 = r108;
        String r123 = r113;
        r100 = r116;
    L181:
        if (r121.hasNext() == false) goto L315;
        Object r124 = r121.next();
        int r125 = r122 + 1;
        if (r122 >= 0) goto L185;
        CollectionsKt.throwIndexOverflow();
    L185:
        CreationTask r126 = (CreationTask) r124;
        HashMap<String, b> r127 = r100.f371318c;
        if (r126 == null) goto L188;
        String r128 = r126.f310760id;
    L189:
        if (r128 != null) goto L191;
        r128 = r120;
    L191:
        b r129 = r127.get(r128);
        if (r129 != null) goto L194;
        Message r130 = r117;
        Object r131 = r118;
        Iterator r132 = r121;
        int r133 = r125;
    L314:
        r117 = r130;
        r122 = r133;
        r121 = r132;
        r118 = r131;
        goto L181
    L194:
        if (r126 == null) goto L196;
        Integer r134 = r126.status;
    L197:
        if (r134 != null) goto L200;
    L266:
        r130 = r117;
        Object r135 = r118;
        int r136 = r125;
        if (r134 != null) goto L270;
    L313:
        r131 = r135;
        Iterator r212 = r121;
        r133 = r136;
        r132 = r212;
        goto L314
    L270:
        if (r134.intValue() != 1) goto L313;
        if (r129.f371324e != null) goto L321;
        r129.f371324e = Boxing.boxLong(SystemClock.elapsedRealtime());
    L321:
        Result.Companion r137 = Result.Companion;     // Catch: Throwable -> L295
        IFlowSdkDepend r138 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);     // Catch: Throwable -> L295
        if (r138 == null) goto L294;
        r138.P();     // Catch: Throwable -> L295
        Fragment r139 = ChatServiceImpl.f346124a.f();     // Catch: Throwable -> L295
        if (r139 == null) goto L294;
        t1a.b r140 = s1a.a.g(r139);     // Catch: Throwable -> L295
        if (r140 == null) goto L294;
        zd8.b r141 = (zd8.b) r140.getAbility(zd8.b.class);     // Catch: Throwable -> L295
        if (r141 == null) goto L294;
        i1<MessageLoadingUIState> r142 = r141.H4();     // Catch: Throwable -> L295
        if (r142 == null) goto L294;
        MessageLoadingUIState r143 = r142.getValue();     // Catch: Throwable -> L295
        if (r143 == null) goto L294;
        Map<String, ProgressLoadingUIState> r144 = r143.getMessageLoadingMap();     // Catch: Throwable -> L295
        if (r144 == null) goto L294;
        ProgressLoadingUIState r145 = r144.get(DataConverterKt.a(r130.getLocalMessageId(), r126.f310760id));     // Catch: Throwable -> L295
        if (r145 == null) goto L294;
        Integer r146 = r145.getProgress();     // Catch: Throwable -> L295
    L300:
        if (r146 == null) goto L302;
        int r147 = r146.intValue();
        r136 = r136;
        r121 = r121;
    L307:
        String r148 = c(r123, r122, r119.size());
        StringBuilder r149 = new StringBuilder();
        StringCompanionObject r150 = StringCompanionObject.INSTANCE;
        r149.append(String.format(AppHost.f326268a.getApplication().getString(R.string.larus_pushVideo_title_generating), Arrays.copyOf(new Object[]{String.valueOf(r147)}, 1)));
        r149.append('%');
        String r151 = r149.toString();
        int r152 = r129.f371322c.a(e(r126, r129));
        r115.L$0 = r100;
        r115.L$1 = r123;
        r115.L$2 = r130;
        r115.L$3 = r119;
        Iterator r153 = r121;
        r115.L$4 = r153;
        int r154 = r136;
        r115.I$0 = r154;
        r115.label = 2;
        Object r155 = r135;
        if (h(r130, r129, r148, r151, r152, r115) == r155) goto L349;
        r109 = r153;
        r104 = r155;
        r114 = r100;
        r113 = r123;
        r101 = r115;
        r108 = r154;
        r110 = r120;
        r111 = r119;
        r112 = r130;
    L349:
        return r155;
    L302:
        long r156 = SystemClock.elapsedRealtime();
        Long r157 = r129.f371324e;
        if (r157 == null) goto L305;
        long r158 = r157.longValue();
    L306:
        r147 = (int) Math.floor(Math.pow(1.0d - (1.0d / ((RangesKt.coerceAtLeast(1.0d, (r156 - r158) / 1000.0d) * 0.2d) + 1.0d)), 2.0d) * 99.0d);
        goto L307
    L305:
        r158 = r129.f371323d;
    L294:
        r146 = null;
    L295:
        th = move-exception;
        Result.Companion r159 = Result.Companion;
        Object r160 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r160) == false) goto L299;
        r160 = null;
    L299:
        r146 = (Integer) r160;
        goto L300
    L200:
        if (r134.intValue() != 3) goto L266;
        String r161 = r117.getLocalMessageId();
        String r162 = r126.f310760id;
        if (r162 != null) goto L204;
        r162 = r120;
    L204:
        String r163 = DataConverterKt.a(r161, r162);
        Result.Companion r164 = Result.Companion;     // Catch: Throwable -> L226
        IFlowSdkDepend r165 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);     // Catch: Throwable -> L226
        if (r165 == null) goto L225;
        r165.P();     // Catch: Throwable -> L226
        Fragment r166 = ChatServiceImpl.f346124a.f();     // Catch: Throwable -> L226
        if (r166 == null) goto L225;
        t1a.b r167 = s1a.a.g(r166);     // Catch: Throwable -> L226
        if (r167 == null) goto L225;
        zd8.b r168 = (zd8.b) r167.getAbility(zd8.b.class);     // Catch: Throwable -> L226
        if (r168 == null) goto L225;
        i1<CreationQueuingTaskUIState> r169 = r168.Um();     // Catch: Throwable -> L226
        if (r169 == null) goto L225;
        CreationQueuingTaskUIState r170 = r169.getValue();     // Catch: Throwable -> L226
        if (r170 == null) goto L225;
        Map<String, cp8.a> r171 = r170.taskQueuingUIStateMap;     // Catch: Throwable -> L226
        if (r171 == null) goto L225;
        cp8.a r172 = r171.get(r163);     // Catch: Throwable -> L226
        if (r172 == null) goto L225;
        String r173 = r172.f464725a;     // Catch: Throwable -> L226
    L231:
        if (r173 != null) goto L234;
        r173 = r120;
    L234:
        if (r173.length() != 0) goto L236;
        boolean r174 = true;
    L237:
        if (r174 == false) goto L259;
        Map<String, String> r175 = r117.getBusinessExt();
        if (r175 == null) goto L241;
        String r176 = r175.get("creation_msg_queuing_status");
    L242:
        x r177 = DataConverterKt.f(r176).get(r163);
        if (r177 == null) goto L245;
        r173 = r177.loadingText;
    L246:
        if (r173 != null) goto L249;
        r173 = r120;
    L249:
        if (r173.length() != 0) goto L251;
        boolean r178 = true;
    L252:
        if (r178 == false) goto L259;
        LoadingInfo r179 = r126.loadingInfo;
        if (r179 == null) goto L256;
        r173 = r179.loadingText;
    L257:
        if (r173 != null) goto L259;
        String r180 = r120;
    L260:
        String r181 = c(r123, r122, r119.size());
        Object r213 = r118;
        int r182 = r129.f371322c.a(e(r126, r129));
        r115.L$0 = r100;
        r115.L$1 = r123;
        r115.L$2 = r117;
        r115.L$3 = r119;
        r115.L$4 = r121;
        r115.I$0 = r125;
        r115.label = 1;
        Message r183 = r117;
        if (h(r117, r129, r181, r180, r182, r115) != r213) goto L263;
        r155 = r213;
        goto L349
    L263:
        r116 = r100;
        r108 = r125;
        r109 = r121;
        r115 = r115;
        r117 = r183;
        r113 = r123;
        r119 = r119;
        r120 = r120;
        r118 = r213;
        goto L265
    L256:
        r173 = null;
        goto L257
    L251:
        r178 = false;
        goto L252
    L245:
        r173 = null;
        goto L246
    L241:
        r176 = null;
    L259:
        r180 = r173;
        goto L260
    L236:
        r174 = false;
    L225:
        r173 = null;
    L226:
        th = move-exception;
        Result.Companion r184 = Result.Companion;
        Object r185 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r185) == false) goto L230;
        r185 = null;
    L230:
        r173 = (String) r185;
        goto L231
    L196:
        r134 = null;
        goto L197
    L188:
        r128 = null;
        goto L189
    L315:
        Unit r186 = Unit.INSTANCE;
    L350:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r108 = r101.I$0;
        r109 = (Iterator) r101.L$4;
        List r187 = (List) r101.L$3;
        Message r188 = (Message) r101.L$2;
        String r189 = (String) r101.L$1;
        a r190 = (a) r101.L$0;
        ResultKt.throwOnFailure(r103);
        r116 = r190;
        r115 = r101;
        r117 = r188;
        r113 = r189;
        r119 = r187;
        r120 = "";
        r118 = r104;
        goto L265
    L16:
        ResultKt.throwOnFailure(r103);
        if (r100 == null) goto L318;
        Message r191 = r100.f371316a;
        if (r191 == null) goto L318;
        CreationMsgContentData r192 = dp8.e.c(r191);
        if (r192 == null) goto L43;
        CreationInfo r193 = r192.creationInfo;
        if (r193 == null) goto L43;
        Map<String, CreationTask> r194 = r193.taskInfo;
        if (r194 == null) goto L43;
        Collection<CreationTask> r195 = r194.values();
        if (r195 == null) goto L43;
        ArrayList r196 = new ArrayList();
        Iterator<T> r197 = r195.iterator();
    L31:
        if (r197.hasNext() == false) goto L44;
        Object r198 = r197.next();
        CreationTask r199 = (CreationTask) r198;
        if (r199 == null) goto L40;
        Integer r1100 = r199.loadingAssetType;
        if (r1100 == null) goto L40;
        if (r1100.intValue() != 7) goto L40;
        boolean r1101 = true;
    L41:
        if (r1101 == false) goto L31;
        r196.add(r198);
    L40:
        r1101 = false;
    L44:
        if (r196 != null) goto L46;
    L65:
        boolean r200 = false;
    L67:
        if (r200 == false) goto L75;
        u0 r201 = d();
        if (r201 == null) goto L73;
        Long r202 = r201.refreshGeneratingIntervalSec;
        if (r202 == null) goto L73;
        long r1102 = r202.longValue();
    L74:
        r100.f371319d = RangesKt.coerceAtLeast(1000, ((long) 1000) * r1102);
    L82:
        if (r196 == null) goto L170;
        Iterator r203 = r196.iterator();
    L85:
        if (r203.hasNext() == false) goto L168;
        CreationTask r204 = (CreationTask) r203.next();
        Integer[] r205 = new Integer[r107];
        r205[0] = Boxing.boxInt(r106);
        r205[1] = Boxing.boxInt(1);
        List r206 = CollectionsKt.listOf(r205);
        if (r204 == null) goto L89;
        Integer r207 = r204.status;
    L91:
        if (CollectionsKt.contains(r206, r207) == false) goto L150;
        if (r204 == null) goto L94;
        String r208 = r204.f310760id;
    L95:
        if (r208 != null) goto L97;
    L100:
        boolean r209 = true;
    L101:
        if (r209 == true) goto L167;
        HashMap<String, b> r214 = r100.f371318c;
        if (r204 == null) goto L105;
        String r215 = r204.f310760id;
    L106:
        if (r215 != null) goto L109;
        r215 = "";
    L109:
        if (r214.containsKey(r215) == true) goto L167;
        HashMap<String, b> r216 = r100.f371318c;
        if (r204 == null) goto L113;
        String r217 = r204.f310760id;
    L114:
        if (r217 != null) goto L116;
        r217 = "";
    L116:
        int r1103 = ((int) r191.getLocalIndex()) * 10;
        if (r204 == null) goto L121;
        Integer r1104 = r204.index;
        if (r1104 == null) goto L121;
        int r1105 = r1104.intValue();
    L122:
        int r218 = r1103 + r1105;
        if (r204 == null) goto L125;
        String r1106 = r204.f310760id;
    L126:
        if (r1106 != null) goto L128;
        String r219 = "";
    L129:
        Double r1107 = (Double) f371315h.getValue();
        if (r1107 == null) goto L132;
        double r1108 = r1107.doubleValue();
    L323:
        Result.Companion r1109 = Result.Companion;     // Catch: Throwable -> L143
        if (r204 == null) goto L140;
        LoadingInfo r220 = r204.loadingInfo;     // Catch: Throwable -> L143
        if (r220 == null) goto L140;
        Long r221 = r220.waitTimeSec;     // Catch: Throwable -> L143
        if (r221 == null) goto L140;
        long r222 = r221.longValue();     // Catch: Throwable -> L143
    L141:
        Object r223 = Result.m9449constructorimpl(Boxing.boxDouble(60.0d / r222));     // Catch: Throwable -> L143
    L146:
        if (Result.m9452exceptionOrNullimpl(r223) == null) goto L149;
        r223 = Boxing.boxDouble(1.0d);
    L149:
        r216.put(r217, new b(r218, r219, new com.larus.uaigc.chat.notification.a(r1108 * ((Number) r223).doubleValue(), 5), SystemClock.elapsedRealtime()));
    L140:
        r222 = 60;
    L143:
        th = move-exception;
        Result.Companion r224 = Result.Companion;
        r223 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L146
    L132:
        r1108 = 0.05d;
        goto L323
    L128:
        r219 = r1106;
        goto L129
    L125:
        r1106 = null;
    L121:
        r1105 = 0;
        goto L122
    L113:
        r217 = null;
        goto L114
    L105:
        r215 = null;
    L167:
        r106 = 3;
        r107 = 2;
        goto L85
    L97:
        if (StringsKt.isBlank(r208) == true) goto L100;
        r209 = false;
        goto L101
    L94:
        r208 = null;
        goto L95
    L150:
        HashMap<String, b> r225 = r100.f371318c;
        if (r204 == null) goto L153;
        String r226 = r204.f310760id;
    L154:
        if (r226 != null) goto L157;
        r226 = "";
    L157:
        if (r225.containsKey(r226) == false) goto L167;
        HashMap<String, b> r227 = r100.f371318c;
        if (r204 == null) goto L161;
        String r228 = r204.f310760id;
    L162:
        if (r228 != null) goto L164;
        r228 = "";
    L164:
        b r229 = r227.remove(r228);
        if (r229 == null) goto L167;
        CreationService r230 = f.f371333a;
        f.b(r229.f371320a);
        Unit r231 = Unit.INSTANCE;
        goto L167
    L161:
        r228 = null;
        goto L162
    L153:
        r226 = null;
        goto L154
    L89:
        r207 = null;
        goto L91
    L168:
        Unit r232 = Unit.INSTANCE;
    L170:
        if (f.f371336d.size() > 1) goto L172;
    L178:
        if (r196 == null) goto L350;
        r115 = r101;
        r117 = r191;
        r119 = r196;
        r120 = "";
        r123 = r310;
        r121 = r196.iterator();
        r118 = r104;
        r122 = 0;
        goto L181
    L172:
        if (r100.f371318c.size() > 1) goto L178;
        if (f371310c.size() > 1) goto L178;
        b r233 = (b) CollectionsKt.firstOrNull(r100.f371318c.values());
        if (r233 == null) goto L178;
        f.b(r233.f371320a);
        Unit r234 = Unit.INSTANCE;
    L73:
        r1102 = 1;
        goto L74
    L75:
        u0 r235 = d();
        if (r235 == null) goto L80;
        Long r236 = r235.refreshQueuingIntervalSec;
        if (r236 == null) goto L80;
        long r237 = r236.longValue();
    L81:
        r100.f371319d = RangesKt.coerceAtLeast(1000, ((long) 1000) * r237);
    L80:
        r237 = 5;
        goto L81
    L46:
        if (r196.isEmpty() == true) goto L62;
        Iterator r238 = r196.iterator();
    L50:
        if (r238.hasNext() == false) goto L62;
        CreationTask r1110 = (CreationTask) r238.next();
        if (r1110 == null) goto L59;
        Integer r1111 = r1110.status;
        if (r1111 == null) goto L59;
        if (r1111.intValue() != 1) goto L59;
        boolean r1112 = true;
    L60:
        if (r1112 == false) goto L50;
        boolean r239 = true;
    L63:
        if (r239 != true) goto L65;
        r200 = true;
    L59:
        r1112 = false;
    L62:
        r239 = false;
    L43:
        r196 = null;
    L318:
        return Unit.INSTANCE;
    L7:
        r101 = new CreationRefreshNotificationStrategy$handleRefreshInner$1(r210, r311);
        goto L8
    }

    public static Object h(Message r100, b r110, String r111, String r112, int r113, Continuation r114) {
        Object r101 = BuildersKt.withContext(Dispatchers.getMain(), new CreationRefreshNotificationStrategy$showNotification$2(r110, r111, r112, r113, r100, null), r114);
        if (r101 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r101;
    L6:
        return Unit.INSTANCE;
    }
}
