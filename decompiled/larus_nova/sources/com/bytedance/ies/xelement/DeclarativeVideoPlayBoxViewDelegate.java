package com.bytedance.ies.xelement;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0014\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b'\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010M\u001a\u00020L\u0012\n\b\u0002\u0010O\u001a\u0004\u0018\u00010N\u0012\b\b\u0002\u0010P\u001a\u00020\t¢\u0006\u0004\bQ\u0010RJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH&J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0006H&J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0006H&J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0002H&J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0006H\u0016J\u0016\u0010\u0017\u001a\u00020\u00042\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0016J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0006H\u0016J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\tH&J\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0002H&J\u0010\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0006H&J\u0010\u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u0006H&J\u0010\u0010#\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u0006H&J\u0010\u0010&\u001a\u00020\u00042\u0006\u0010%\u001a\u00020$H&J\b\u0010'\u001a\u00020\u0004H&J\u001a\u0010*\u001a\u00020\u00042\u0010\b\u0002\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010(H&J\b\u0010+\u001a\u00020\u0004H&J\u0018\u0010.\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\t2\u0006\u0010-\u001a\u00020\u0006H&J\b\u0010/\u001a\u00020\u0004H&J\b\u00100\u001a\u00020\u0004H&J\u0010\u00102\u001a\u00020\u00042\u0006\u00101\u001a\u00020\tH\u0016J\u0010\u00104\u001a\u00020\u00042\u0006\u00103\u001a\u00020\tH\u0016Jc\u0010>\u001a\u00020\u00042Y\u0010=\u001aU\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(8\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020:09¢\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(;\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u0004\u0018\u000105H\u0016J,\u0010B\u001a\u00020\u00042\"\u0010A\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020:0?j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020:`@H\u0016J\u0012\u0010D\u001a\u00020\u00042\b\u0010C\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010F\u001a\u00020\u00042\u0006\u0010E\u001a\u00020\u0002H\u0017J\u0012\u0010I\u001a\u00020\u00042\b\u0010H\u001a\u0004\u0018\u00010GH\u0016J\b\u0010J\u001a\u00020\tH\u0016J\b\u0010K\u001a\u00020\u0004H\u0016¨\u0006S"}, d2 = {"Lcom/bytedance/ies/xelement/DeclarativeVideoPlayBoxViewDelegate;", "Landroid/widget/RelativeLayout;", "", "src", "", "setSrc", "", "muted", "setMuted", "", "initTime", "setInitTime", "autoPlay", "setAutoPlay", "loop", "setLoop", "poster", "setPoster", "autoLifecycle", "setAutoLifecycle", "Lf76/a;", "Lf76/c;", "loader", "setResourceLoader", "enablePlayListener", "setEnablePlayListener", "rate", "setRate", "objectFit", "setObjectFit", "singlePlayer", "setSinglePlayer", "deviceChangeAware", "setDeviceChangeAware", "preload", "setPreload", "", ITTVideoEngineEventSource.KEY_VOLUME, "setVolume", "onPropsUpdateOnce", "Lkotlin/Function0;", "playCB", "playReal", "pause", "optInt", "optBoolean", "seek", "performZoom", "performZoomOut", "videoWidth", "setVideoWidth", "videoHeight", "setVideoHeight", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "state", "", "", "data", "viewBox", "reporter", "setStateChangeReporter", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "logExtra", "setLogExtra", "tag", "setVideoTag", "performanceLog", "setPerformanceLog", "", "borderRadius", "setBorderRadius", "getDuration", MapMonitorConst.EVENT_DESTROY, "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "x-element-api_release"}, k = 1, mv = {1, 6, 0})
public abstract class DeclarativeVideoPlayBoxViewDelegate extends RelativeLayout {
    public Map<Integer, View> _$_findViewCache;

    public DeclarativeVideoPlayBoxViewDelegate(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, 6, null);
    }

    public DeclarativeVideoPlayBoxViewDelegate(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 4, null);
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int r100) {
        Map<Integer, View> r101 = this._$_findViewCache;
        View r102 = r101.get(Integer.valueOf(r100));
        if (r102 != null) goto L9;
        View r103 = findViewById(r100);
        if (r103 == null) goto L7;
        r101.put(Integer.valueOf(r100), r103);
        return r103;
    L7:
        return null;
    L9:
        return r102;
    }

    public void destroy() {
    }

    public int getDuration() {
        return 0;
    }

    public abstract void onPropsUpdateOnce();

    public abstract void pause();

    public abstract void performZoom();

    public abstract void performZoomOut();

    public abstract void playReal(Function0<Unit> r100);

    public abstract void seek(int r100, boolean r101);

    public void setAutoLifecycle(boolean r100) {
    }

    public abstract void setAutoPlay(boolean r100);

    public void setBorderRadius(float[] r100) {
    }

    public abstract void setDeviceChangeAware(boolean r100);

    public void setEnablePlayListener(boolean r100) {
    }

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

    public void setResourceLoader(f76.a<f76.c> r100) {
        Intrinsics.checkNotNullParameter(r100, "loader");
    }

    public abstract void setSinglePlayer(boolean r100);

    public abstract void setSrc(String r100);

    public void setStateChangeReporter(Function3<? super String, ? super Map<String, ? extends Object>, ? super DeclarativeVideoPlayBoxViewDelegate, Unit> r100) {
    }

    public void setVideoHeight(int r100) {
    }

    public void setVideoTag(String r100) {
    }

    public void setVideoWidth(int r100) {
    }

    public abstract void setVolume(float r100);

    public DeclarativeVideoPlayBoxViewDelegate(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this._$_findViewCache = new LinkedHashMap();
        super(r100, r101, r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void playReal$default(DeclarativeVideoPlayBoxViewDelegate r100, Function0 r101, int r102, Object r103) {
        if (r103 != null) goto L9;
        if ((r102 & 1) == 0) goto L6;
        r101 = null;
    L6:
        r100.playReal(r101);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: playReal");
    }

    public /* synthetic */ DeclarativeVideoPlayBoxViewDelegate(Context r100, AttributeSet r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        this(r100, r101, r102);
    }
}
