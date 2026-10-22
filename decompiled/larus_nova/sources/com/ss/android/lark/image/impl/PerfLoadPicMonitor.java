package com.ss.android.lark.image.impl;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.SystemClock;
import android.text.TextUtils;
import com.android.ttcjpaysdk.verify.constants.DyVerifyEventConstants;
import com.bumptech.glide.load.engine.GlideException;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.lark.pb.basic.v1.Trace;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.CollectionUtils;
import com.larksuite.framework.utils.DevEnvUtil;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.lark.appcontext.applifecycle.a0;
import com.ss.android.lark.appreciablelib.AppreciableKit;
import com.ss.android.lark.appreciablelib.Event;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.image.a;
import com.ss.android.lark.image.api.DataSource;
import com.ss.android.lark.image.api.Target;
import com.ss.android.lark.image.entity.AvatarImage;
import com.ss.android.lark.image.entity.EncryptImage;
import com.ss.android.lark.image.entity.ListenerParams;
import com.ss.android.lark.image.entity.PassThroughImage;
import com.ss.android.lark.image.entity.ReactionImage;
import com.ss.android.lark.image.entity.VideoImage;
import com.ss.android.lark.image.impl.preload.ImagePreloadManager;
import com.ss.android.lark.image.impl.preload.PreloadResult;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.monitor.perf.BasePerfMonitor;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.ImageUtils;
import com.ss.android.lark.utils.LarkContext;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;
import rkb.g;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0003\u001b\u001c\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ.\u0010\f\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0018\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u001c\u0010\u0015\u001a\u00020\u00162\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002J\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002J\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/ss/android/lark/image/impl/PerfLoadPicMonitor;", "Lcom/ss/android/lark/monitor/perf/BasePerfMonitor;", "<init>", "()V", "mShowImageCostData", "Lcom/ss/android/lark/image/impl/PerfLoadPicMonitor$ShowImageCostData;", "start", "", "params", "Lcom/ss/android/lark/image/entity/ListenerParams;", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "", "end", "trace", "Lcom/bytedance/lark/pb/basic/v1/Trace;", "resource", "dataSource", "Lcom/ss/android/lark/image/api/DataSource;", "onException", "errorResult", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "getLoadType", "Lcom/ss/android/lark/image/entity/ListenerParams$LoadType;", "getResourceSize", "", "getImageType", "", "ShowImageCostData", "Companion", "MonitorRequestListener", "lark-image_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PerfLoadPicMonitor extends BasePerfMonitor {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private ShowImageCostData mShowImageCostData;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\b\u001a\u00020\t2\u000e\u0010\n\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/image/impl/PerfLoadPicMonitor$Companion;", "", "<init>", "()V", "TAG", "", "DEFAULT_UNKNOWN_ERROR_CODE", "", "getErrorResult", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "getTrace", "Lcom/bytedance/lark/pb/basic/v1/Trace;", "lark-image_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final Trace getTrace(Object r100) {
            if ((r100 instanceof EncryptImage) == false) goto L6;
            return ((EncryptImage) r100).getTrace();
        L6:
            if ((r100 instanceof PassThroughImage) == true) goto L11;
            return null;
        L11:
            return ((PassThroughImage) r100).getTrace();
        }

        public final ErrorResult getErrorResult(Exception r100, Object r101) {
            if ((r101 instanceof EncryptImage) == false) goto L6;
            ErrorResult r102 = ((EncryptImage) r101).getErrorResult();
        L12:
            if (r102 != null) goto L19;
            r102 = new ErrorResult(r100);
            if (r100 != null) goto L16;
        L18:
            r102.setErrorCode(GlideException.ERROR_CODE_DECODE_JOB_CANCELLED);
            Log.e("PerfLoadPicMonitor", "getErrorResult, exception is:" + r100);
            goto L19
        L16:
            if ((r100 instanceof GlideException) == false) goto L18;
            r102.setErrorCode(((GlideException) r100).getErrorCode());
        L19:
            return r102;
        L6:
            if ((r101 instanceof PassThroughImage) == false) goto L9;
            r102 = ((PassThroughImage) r101).getErrorResult();
            goto L12
        L9:
            if ((r101 instanceof AvatarImage) == false) goto L11;
            r102 = ((AvatarImage) r101).getErrorResult();
            goto L12
        L11:
            r102 = null;
            goto L12
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J<\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0018\u00010\fj\u0004\u0018\u0001`\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0010\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\nH\u0016J>\u0010\u0012\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0010\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u00102\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\nH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/image/impl/PerfLoadPicMonitor$MonitorRequestListener;", "Lcom/ss/android/lark/image/api/RequestListener;", "", "listenerParams", "Lcom/ss/android/lark/image/entity/ListenerParams;", "<init>", "(Lcom/ss/android/lark/image/entity/ListenerParams;)V", "monitor", "Lcom/ss/android/lark/image/impl/PerfLoadPicMonitor;", "onLoadFailed", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, PickerReporterConstants.KEY.TARGET, "Lcom/ss/android/lark/image/api/Target;", "isFirstResource", "onResourceReady", "resource", "dataSource", "Lcom/ss/android/lark/image/api/DataSource;", "lark-image_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class MonitorRequestListener implements g<Object, Object> {
        private final ListenerParams listenerParams;
        private final PerfLoadPicMonitor monitor;

        public MonitorRequestListener(ListenerParams r100) {
            this.listenerParams = r100;
            PerfLoadPicMonitor r101 = new PerfLoadPicMonitor();
            this.monitor = r101;
            if (r100 == null) goto L6;
            r101.start(r100, null);
            return;
        }

        @Override // rkb.g
        public boolean onLoadFailed(Exception r100, Object r101, Target<Object> r102, boolean r103) {
            this.monitor.onException(PerfLoadPicMonitor.Companion.getErrorResult(r100, r101), r101);
            ListenerParams r104 = this.listenerParams;
            if (r104 == null) goto L9;
            ListenerParams.b r105 = r104.f426293h;
            if (r105 == null) goto L10;
            r105.a(r100);
            return false;
        L10:
            return false;
        L9:
            return false;
        }

        @Override // rkb.g
        public boolean onResourceReady(Object r100, Object r101, Target<Object> r102, DataSource r103, boolean r104) {
            Intrinsics.checkNotNullParameter(r103, "dataSource");
            this.monitor.end(PerfLoadPicMonitor.Companion.getTrace(r101), r100, r103, r101);
            ListenerParams r105 = this.listenerParams;
            if (r105 == null) goto L9;
            ListenerParams.b r106 = r105.f426293h;
            if (r106 == null) goto L10;
            r106.b(r100, r101, r103, r104);
            return false;
        L10:
            return false;
        L9:
            return false;
        }
    }

    @Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0006\b\u0001\u0018\u0000 E2\u00020\u0001:\u0001EB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00072\b\u0010(\u001a\u0004\u0018\u00010)J\u001a\u0010*\u001a\u00020&2\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010(\u001a\u0004\u0018\u00010)J\u0010\u0010-\u001a\u00020&2\u0006\u0010.\u001a\u00020/H\u0002J\u0010\u00100\u001a\u0002012\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u00102\u001a\u00020\u00052\u0006\u00103\u001a\u000204H\u0016J \u00105\u001a\u00020&2\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u0002072\u0006\u00109\u001a\u000207H\u0016J\u0010\u0010:\u001a\u0002012\u0006\u00103\u001a\u000204H\u0016J\u001e\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020)0<2\b\u0010(\u001a\u0004\u0018\u00010)H\u0002J\u001e\u0010=\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020)0<2\b\u0010(\u001a\u0004\u0018\u00010)H\u0002J\u0014\u0010>\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020)0<H\u0002J&\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020)0@2\b\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010A\u001a\u00020\u0005H\u0002J\u001c\u0010B\u001a\u00020\u00052\b\u0010'\u001a\u0004\u0018\u00010\u00072\b\u0010(\u001a\u0004\u0018\u00010)H\u0002J\u0012\u0010C\u001a\u00020\u00052\b\u0010(\u001a\u0004\u0018\u00010)H\u0002J\u0014\u0010D\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020)0<H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006F"}, d2 = {"Lcom/ss/android/lark/image/impl/PerfLoadPicMonitor$ShowImageCostData;", "Lcom/ss/android/lark/monitor/perf/BasePerfMonitor$TimePerfData;", "<init>", "()V", "appreciableKey", "", "listenerParams", "Lcom/ss/android/lark/image/entity/ListenerParams;", "preloadResult", "Lcom/ss/android/lark/image/impl/preload/PreloadResult;", "resourceSize", "", "getResourceSize", "()J", "setResourceSize", "(J)V", "colorSpace", "colorType", "timeAfterAppStart", "timeAfterForeground", "loadType", "Lcom/ss/android/lark/image/entity/ListenerParams$LoadType;", "getLoadType", "()Lcom/ss/android/lark/image/entity/ListenerParams$LoadType;", "setLoadType", "(Lcom/ss/android/lark/image/entity/ListenerParams$LoadType;)V", "imageType", "getImageType", "()Ljava/lang/String;", "setImageType", "(Ljava/lang/String;)V", "trace", "Lcom/bytedance/lark/pb/basic/v1/Trace;", "getTrace", "()Lcom/bytedance/lark/pb/basic/v1/Trace;", "setTrace", "(Lcom/bytedance/lark/pb/basic/v1/Trace;)V", "start", "", "params", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "", "end", "errorResult", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "executeReportTask", "reportTask", "Ljava/lang/Runnable;", "isMuteReport", "", "getEventName", Keys.API_PARAM_KEY_PLATFORM_TYPE, "", "generateData", "metrics", "Lorg/json/JSONObject;", "category", "extra", "needReport", "getLatencyDetail", "", "getClientLatency", "getExtraCategory", "getExtraMetric", "", "imageKey", "getImageKey", "getImageKeyByModel", "getSpanCost", "Companion", "lark-image_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ShowImageCostData extends BasePerfMonitor.b {
        public static final int $stable = 0;
        public static final Companion Companion = null;
        private String appreciableKey;
        private String colorSpace;
        private String colorType;
        private String imageType;
        private ListenerParams listenerParams;
        private ListenerParams.LoadType loadType;
        private PreloadResult preloadResult;
        private long resourceSize;
        private long timeAfterAppStart;
        private long timeAfterForeground;
        private Trace trace;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0017\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/image/impl/PerfLoadPicMonitor$ShowImageCostData$Companion;", "", "<init>", "()V", "EVENT_NAME_IMAGE_EMPTY_COST", "", "METRIC_KEY_LATENCY", "CATEGORY_KEY_SCENE", "CATEGORY_KEY_BIZ_SCENE", "EXTRA_KEY_TO_STARTUP", "EXTRA_KEY_TO_FOREGROUND", "EXTRA_METRIC_RESOURCE_CONTENT_LENGTH", "EXTRA_CATEGORY_FROM_TYPE", "EXTRA_CATEGORY_IMAGE_TYPE", "EXTRA_CATEGORY_CHAT_TYPE", "EXTRA_CATEGORY_LOAD_TYPE", "EXTRA_CATEGORY_COLOR_SPACE", "EXTRA_CATEGORY_COLOR_TYPE", "EXTRA_METRIC_RESOURCE_WIDTH", "EXTRA_METRIC_RESOURCE_HEIGHT", "EXTRA_METRIC_RESOURCE_FRAMES", "EXTRA_METRIC_LOAD_WIDTH", "EXTRA_METRIC_LOAD_HEIGHT", "EXTRA_METRIC_MESSAGE_ID", "EXTRA_METRIC_IMAGE_KEY", "EXTRA_METRIC_MEDIA_IS_ORIGIN_TYPE", "EXTRA_METRIC_RESOURCE_HASH", "EXTRA_METRIC_FORMAT_HEADER", "lark-image_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r100) {
                this();
            }
        }

        static {
            Companion = new Companion(null);
            $stable = 8;
        }

        @Override // com.ss.android.lark.monitor.perf.BasePerfMonitor.a
        public String getEventName(int r100) {
            return "user_image_empty_cost";
        }

        @Override // com.ss.android.lark.monitor.perf.BasePerfMonitor.b, com.ss.android.lark.monitor.perf.BasePerfMonitor.a
        public boolean needReport(int r100) {
            return false;
        }

        private final Map<String, Object> getExtraCategory() {
            HashMap r100 = new HashMap();
            ListenerParams r101 = this.listenerParams;
            if (r101 == null) goto L5;
            r100.put("from_type", Integer.valueOf(r101.f426296k.getValue()));
            r100.put("chat_type", Integer.valueOf(r101.f426297l.getValue()));
            r100.put(ChameleonOpenTracker.ParamKey.LOAD_TYPE, Integer.valueOf(this.loadType.getValue()));
            r100.put("image_type", this.imageType);
            r100.put("color_type", this.colorType);
            r100.put("color_space", this.colorSpace);
        L5:
            PreloadResult r102 = this.preloadResult;
            if (r102 == null) goto L8;
            r100.put("preload_result", r102.getState().getValue());
            r100.put("preloading_duration", Integer.valueOf(r102.getPreloadingDuration()));
            r100.put("preload_scene", r102.getScene());
        L8:
            return r100;
        }

        private final Map<String, Object> getSpanCost() {
            HashMap r100 = new HashMap();
            Trace r101 = this.trace;
            if (r101 == null) goto L15;
            Iterator<Trace.Span> r102 = r101.spans.iterator();
        L6:
            if (r102.hasNext() == false) goto L15;
            Trace.Span r103 = r102.next();
            if (TextUtils.isEmpty(r103.name) == true) goto L6;
            Long r104 = r103.duration_millis;
            if (r104 == null) goto L6;
            r100.put(r103.name, r104);
            if (CollectionUtils.isEmpty(r103.attributes) == true) goto L6;
            r100.putAll(r103.attributes);
        L15:
            return r100;
        }

        public ShowImageCostData() {
            this.colorSpace = ListenerParams.ColorSpace.UNKNOWN.getValue();
            this.colorType = ListenerParams.ColorType.UNKNOWN.getValue();
            this.loadType = ListenerParams.LoadType.UNKNOWN;
            this.imageType = ImageUtils.ImageType.TYPE_UNKNOWN.getValue();
        }

        public final long getResourceSize() {
            return this.resourceSize;
        }

        public static final /* synthetic */ String access$getAppreciableKey$p(ShowImageCostData r100) {
            return r100.appreciableKey;
        }

        public static final /* synthetic */ Map access$getExtraCategory(ShowImageCostData r100) {
            return r100.getExtraCategory();
        }

        public static final /* synthetic */ ListenerParams access$getListenerParams$p(ShowImageCostData r100) {
            return r100.listenerParams;
        }

        private final void executeReportTask(Runnable r100) {
            ListenerParams r101 = this.listenerParams;
            if (r101 == null) goto L5;
            ListenerParams.FromType r102 = r101.f426296k;
        L7:
            if (r102 == ListenerParams.FromType.AVATAR) goto L9;
        L11:
            CoreThreadPool.getDefault().getCachedThreadPool().execute(r100);
            return;
        L9:
            if (AvatarMonitorExecutor.INSTANCE.tryExecute(r100) == false) goto L11;
            return;
        L5:
            r102 = null;
            goto L7
        }

        private final Map<String, Object> getClientLatency(Object r100) {
            HashMap r101 = new HashMap();
            if ((r100 instanceof EncryptImage) == false) goto L9;
            EncryptImage r102 = (EncryptImage) r100;
            r101.put("send_req_waiting_cost", Long.valueOf(r102.getWaitTime()));
            if (r102.getDecodeStartTime() <= 0) goto L7;
            r101.put("decode_cost", Long.valueOf(System.currentTimeMillis() - r102.getDecodeStartTime()));
        L7:
            r101.put("decrypt_cost", Long.valueOf(r102.getDecryptTime()));
        L13:
            return r101;
        L9:
            if ((r100 instanceof AvatarImage) == false) goto L13;
            AvatarImage r103 = (AvatarImage) r100;
            r101.put("send_req_waiting_cost", Long.valueOf(r103.getWaitTime()));
            if (r103.getDecodeStartTime() <= 0) goto L13;
            r101.put("decode_cost", Long.valueOf(System.currentTimeMillis() - r103.getDecodeStartTime()));
            goto L13
        }

        private final String getImageKeyByModel(Object r100) {
            if ((r100 instanceof EncryptImage) == false) goto L6;
            return "image:" + ((EncryptImage) r100).getEncryptKey();
        L6:
            if ((r100 instanceof AvatarImage) == false) goto L9;
            return "avatar:" + ((AvatarImage) r100).getKey();
        L9:
            if ((r100 instanceof ReactionImage) == false) goto L12;
            return "reaction:" + ((ReactionImage) r100).getReactionKey();
        L12:
            if ((r100 instanceof PassThroughImage) == false) goto L15;
            return "passthrough:" + ((PassThroughImage) r100).getImageKey();
        L15:
            if ((r100 instanceof VideoImage) == false) goto L21;
            StringBuilder r101 = new StringBuilder("video:");
            VideoImage r102 = (VideoImage) r100;
            String r103 = r102.getPath();
            if (r103 == null) goto L19;
            String r104 = r103.substring(0, StringsKt.lastIndexOf$default(r102.getPath(), HTTP.URL_DEFAULT, 0, false, 6, null));
        L20:
            r101.append(r104);
            return r101.toString();
        L19:
            r104 = null;
            goto L20
        L21:
            return "other scene";
        }

        private final Map<String, Object> getLatencyDetail(Object r100) {
            HashMap r101 = new HashMap();
            r101.putAll(getSpanCost());
            r101.putAll(getClientLatency(r100));
            return r101;
        }

        private final boolean isMuteReport(ListenerParams.LoadType r100) {
            boolean r101 = !DevEnvUtil.isDebugMode(LarkContext.getApplication());
            a r102 = (a) ApiUtils.getApi(a.class);
            ListenerParams r103 = this.listenerParams;
            if (r103 == null) goto L7;
            ListenerParams.FromType r104 = r103.f426296k;
            if (r104 == null) goto L7;
            int r105 = r104.getValue();
        L8:
            boolean r106 = !r102.isReportImageLoad(r105, r100.getValue());
            if (r101 == false) goto L12;
            if (r106 == false) goto L12;
            return true;
        L12:
            return false;
        L7:
            r105 = 1;
            goto L8
        }

        public final void setImageType(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.imageType = r100;
        }

        public final void setLoadType(ListenerParams.LoadType r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.loadType = r100;
        }

        public final void setResourceSize(long r100) {
            this.resourceSize = r100;
        }

        public final void setTrace(Trace r100) {
            this.trace = r100;
        }

        public static final /* synthetic */ Map access$getLatencyDetail(ShowImageCostData r100, Object r101) {
            return r100.getLatencyDetail(r101);
        }

        private final Map<String, Object> getExtraMetric(Object r100, String r101) {
            HashMap r102 = new HashMap();
            r102.put("resource_content_length", Long.valueOf(this.resourceSize));
            ListenerParams r103 = this.listenerParams;
            if (r103 == null) goto L18;
            r102.put("resource_width", Integer.valueOf(r103.f426290e));
            r102.put("resource_height", Integer.valueOf(r103.f426291f));
            r102.put("resource_frames", Integer.valueOf(r103.f426292g));
            r102.put("load_width", Integer.valueOf(r103.f426288c));
            r102.put("load_height", Integer.valueOf(r103.f426289d));
            if ((r100 instanceof EncryptImage) == false) goto L14;
            EncryptImage r104 = (EncryptImage) r100;
            String r105 = r104.getResourceHash();
            String r106 = "";
            if (r105 != null) goto L9;
            r105 = "";
        L9:
            r102.put("resource_hash", r105);
            String r107 = r104.getFormatHeader();
            if (r107 == null) goto L13;
            r106 = r107;
        L13:
            r102.put("format_header", r106);
        L14:
            String r108 = r103.f426299n;
            if (r108 == null) goto L17;
            r102.put(MusicAppletPage.KEY_MESSAGE_ID, r108);
        L17:
            r102.put("media_is_origin_type", Boolean.valueOf(r103.f426301p));
        L18:
            r102.put("image_key", r101);
            return r102;
        }

        private final String getImageKey(ListenerParams r100, Object r101) {
            if (r100 == null) goto L4;
            String r102 = r100.f426300o;
        L5:
            if (r102 != null) goto L7;
        L10:
            boolean r103 = true;
        L11:
            if (r103 == true) goto L13;
            return r102;
        L13:
            return getImageKeyByModel(r101);
        L7:
            if (r102.length() == 0) goto L10;
            r103 = false;
            goto L11
        L4:
            r102 = null;
            goto L5
        }

        public final void end(final ErrorResult r100, final Object r101) {
            super.end();
            if (r100 == null) goto L5;
        L7:
            executeReportTask(new PerfLoadPicMonitor$ShowImageCostData$end$reportTask$1(this, r101, r100));
            return;
        L5:
            if (isMuteReport(this.loadType) == false) goto L7;
        }

        public final void start(ListenerParams r100, Object r101) {
            Intrinsics.checkNotNullParameter(r100, "params");
            super.start();
            this.listenerParams = r100;
            String r102 = getImageKey(r100, r101);
            ListenerParams r103 = this.listenerParams;
            if (r103 == null) goto L5;
            ListenerParams.FromType r104 = r103.f426296k;
        L7:
            if (r104 == ListenerParams.FromType.AVATAR) goto L9;
            this.preloadResult = ImagePreloadManager.getResult(r102);
        L9:
            long r105 = SystemClock.elapsedRealtime();
            int r106 = a0.f408823b;
            this.timeAfterAppStart = r105 - (SystemClock.elapsedRealtime() - 0);
            this.timeAfterForeground = SystemClock.elapsedRealtime() - (SystemClock.elapsedRealtime() - a0.f408822a);
            this.appreciableKey = AppreciableKit.Companion.getInstance().start(r100.f426294i, r100.f426295j, Event.image_load, r100.f426298m, true);
            return;
        L5:
            r104 = null;
            goto L7
        }

        public static final /* synthetic */ Map access$getExtraMetric(ShowImageCostData r100, Object r101, String r102) {
            return r100.getExtraMetric(r101, r102);
        }

        public static final /* synthetic */ String access$getImageKey(ShowImageCostData r100, ListenerParams r101, Object r102) {
            return r100.getImageKey(r101, r102);
        }

        @Override // com.ss.android.lark.monitor.perf.BasePerfMonitor.b, com.ss.android.lark.monitor.perf.BasePerfMonitor.a
        public void generateData(JSONObject r100, JSONObject r101, JSONObject r102) {
            Intrinsics.checkNotNullParameter(r100, "metrics");
            Intrinsics.checkNotNullParameter(r101, "category");
            Intrinsics.checkNotNullParameter(r102, "extra");
            r100.put("latency", this.costInMillis);     // Catch: JSONException -> L7
            r102.put("since_startup", this.timeAfterAppStart);     // Catch: JSONException -> L7
            r102.put("since_latest_enter_foreground", this.timeAfterForeground);     // Catch: JSONException -> L7
            ListenerParams r103 = this.listenerParams;     // Catch: JSONException -> L7
            if (r103 == null) goto L12;
            r101.put("scene", r103.f426295j.getValue());     // Catch: JSONException -> L7
            r101.put(DyVerifyEventConstants.EventParam.BIZ_SCENE, r103.f426295j.getValue());     // Catch: JSONException -> L7
            return;
        L12:
            return;
        L7:
            e = move-exception;
            e.printStackTrace();
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[DataSource.values().length];
            r100[DataSource.LOCAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r100[DataSource.REMOTE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r100[DataSource.DATA_DISK_CACHE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r100[DataSource.RESOURCE_DISK_CACHE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r100[DataSource.MEMORY_CACHE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            $EnumSwitchMapping$0 = r100;
        }
    }

    static {
        Companion = new Companion(null);
        $stable = 8;
    }

    public PerfLoadPicMonitor() {
    }

    private final String getImageType(Object r100) {
        if ((r100 instanceof EncryptImage) == false) goto L6;
        String r101 = ((EncryptImage) r100).getImageType();
    L12:
        if (r101 == null) goto L14;
        return r101;
    L14:
        return ImageUtils.ImageType.TYPE_UNKNOWN.getValue();
    L6:
        if ((r100 instanceof AvatarImage) == false) goto L9;
        r101 = ((AvatarImage) r100).getImageType();
        goto L12
    L9:
        if ((r100 instanceof PassThroughImage) == false) goto L11;
        r101 = ((PassThroughImage) r100).getImageType();
        goto L12
    L11:
        r101 = ImageUtils.ImageType.TYPE_UNKNOWN.getValue();
        goto L12
    }

    private final long getResourceSize(Object r100) {
        if ((r100 instanceof EncryptImage) == false) goto L6;
        return ((EncryptImage) r100).getResourceSize();
    L6:
        if ((r100 instanceof AvatarImage) == false) goto L9;
        return ((AvatarImage) r100).getResourceSize();
    L9:
        if ((r100 instanceof PassThroughImage) == true) goto L15;
        return 0;
    L15:
        return ((PassThroughImage) r100).getResourceSize();
    }

    private final ListenerParams.LoadType getLoadType(DataSource r100, Object r101) {
        if (r100 != null) goto L5;
        int r102 = -1;
    L6:
        if (r102 == (-1)) goto L27;
        if (r102 == 1) goto L23;
        if (r102 == 2) goto L30;
        if (r102 == 3) goto L29;
        if (r102 == 4) goto L29;
        if (r102 != 5) goto L19;
        return ListenerParams.LoadType.MEMORY_CACHE;
    L19:
        throw new NoWhenBranchMatchedException();
    L29:
        return ListenerParams.LoadType.DISK_CACHE;
    L30:
        return ListenerParams.LoadType.NET;
    L23:
        if ((r101 instanceof AvatarImage) == false) goto L32;
        return ListenerParams.LoadType.NET;
    L32:
        return ListenerParams.LoadType.DISK_CACHE;
    L27:
        return ListenerParams.LoadType.UNKNOWN;
    L5:
        r102 = WhenMappings.$EnumSwitchMapping$0[r100.ordinal()];
        goto L6
    }

    public final void onException(ErrorResult r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "errorResult");
        ShowImageCostData r102 = this.mShowImageCostData;
        if (r102 != null) goto L5;
        return;
    L5:
        this.mShowImageCostData = null;
        r102.setImageType(getImageType(r101));
        r102.end(r100, r101);
    }

    public final void start(ListenerParams r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        if (this.mShowImageCostData != null) goto L5;
        this.mShowImageCostData = new ShowImageCostData();
    L5:
        ShowImageCostData r102 = this.mShowImageCostData;
        if (r102 == null) goto L9;
        r102.start(r100, r101);
        return;
    }

    public final void end(Trace r100, Object r101, DataSource r102, Object r110) {
        ShowImageCostData r103 = this.mShowImageCostData;
        if (r103 == null) goto L19;
        r103.setTrace(r100);
        r103.setLoadType(getLoadType(r102, r110));
        r103.setImageType(getImageType(r110));
        r103.setResourceSize(getResourceSize(r110));
        if (r103.getResourceSize() == 0) goto L7;
    L11:
        r103.end(null, r110);
        if (r103.isValid() == false) goto L19;
        if (r103.needReport(2) == false) goto L17;
        BasePerfMonitor.reportToTea(r103);
    L17:
        if (r103.needReport(1) == false) goto L19;
        BasePerfMonitor.reportToSlardar(r103);
        goto L19
    L7:
        if ((r101 instanceof BitmapDrawable) == false) goto L11;
        Bitmap r104 = ((BitmapDrawable) r101).getBitmap();
        if (r104 == null) goto L11;
        r103.setResourceSize(r104.getWidth() * r104.getHeight());
    L19:
        this.mShowImageCostData = null;
    }
}
