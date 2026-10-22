package com.bytedance.ies.xelement;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010<\u001a\u00020;\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010=\u0012\b\b\u0002\u0010?\u001a\u00020\t¢\u0006\u0004\b@\u0010AJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH&J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0006H&J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0006H&J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0002H&J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0006H&J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\tH&J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0002H&J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0006H&J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0006H&J\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0006H&J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001eH&J\u0010\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\tH\u0016J\u0010\u0010$\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\tH\u0016Jc\u0010.\u001a\u00020\u00042Y\u0010-\u001aU\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020*0)¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b(+\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020\u0004\u0018\u00010%H&J,\u00102\u001a\u00020\u00042\"\u00101\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020*0/j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020*`0H\u0016J\u0010\u00104\u001a\u00020\u00042\u0006\u00103\u001a\u00020\u0002H\u0017J\u0012\u00107\u001a\u00020\u00042\b\u00106\u001a\u0004\u0018\u000105H\u0016J\b\u00108\u001a\u00020\tH\u0016J\u0010\u0010:\u001a\u00020\u00042\u0006\u00109\u001a\u00020\u0002H\u0016¨\u0006B"}, d2 = {"Lcom/bytedance/ies/xelement/DeclarativeVideoPlayBoxView;", "Landroid/widget/RelativeLayout;", "", "src", "", "setSrc", "", "muted", "setMuted", "", "initTime", "setInitTime", "autoPlay", "setAutoPlay", "loop", "setLoop", "poster", "setPoster", "autoLifecycle", "setAutoLifecycle", "rate", "setRate", "objectFit", "setObjectFit", "singlePlayer", "setSinglePlayer", "deviceChangeAware", "setDeviceChangeAware", "preload", "setPreload", "", ITTVideoEngineEventSource.KEY_VOLUME, "setVolume", "videoWidth", "setVideoWidth", "videoHeight", "setVideoHeight", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "state", "", "", "data", "viewBox", "reporter", "setStateChangeReporter", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "logExtra", "setLogExtra", "performanceLog", "setPerformanceLog", "", "borderRadius", "setBorderRadius", "getDuration", "singleScene", "setSinglePlayerScene", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "x-element-video_release"}, k = 1, mv = {1, 6, 0})
public abstract class DeclarativeVideoPlayBoxView extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f249600a = 0;

    public DeclarativeVideoPlayBoxView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public DeclarativeVideoPlayBoxView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public abstract void a();

    public abstract void b();

    public abstract void c();

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public int getDuration() {
        return 0;
    }

    public abstract void setAutoLifecycle(boolean r100);

    public abstract void setAutoPlay(boolean r100);

    public void setBorderRadius(float[] r100) {
    }

    public abstract void setDeviceChangeAware(boolean r100);

    public abstract void setInitTime(int r100);

    public void setLogExtra(HashMap<String, Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "logExtra");
    }

    public abstract void setLoop(boolean r100);

    public abstract void setMuted(boolean r100);

    public abstract void setObjectFit(String r100);

    @Deprecated(message = "use setLogExtra")
    public void setPerformanceLog(String r100) {
        Intrinsics.checkNotNullParameter(r100, "performanceLog");
    }

    public abstract void setPoster(String r100);

    public abstract void setPreload(boolean r100);

    public abstract void setRate(int r100);

    public abstract void setSinglePlayer(boolean r100);

    public void setSinglePlayerScene(String r100) {
        Intrinsics.checkNotNullParameter(r100, "singleScene");
    }

    public abstract void setSrc(String r100);

    public abstract void setStateChangeReporter(Function3<? super String, ? super Map<String, ? extends Object>, ? super DeclarativeVideoPlayBoxView, Unit> r100);

    public void setVideoHeight(int r100) {
    }

    public void setVideoWidth(int r100) {
    }

    public abstract void setVolume(float r100);

    public DeclarativeVideoPlayBoxView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        new LinkedHashMap();
        super(r100, r101, r102);
    }

    public /* synthetic */ DeclarativeVideoPlayBoxView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
