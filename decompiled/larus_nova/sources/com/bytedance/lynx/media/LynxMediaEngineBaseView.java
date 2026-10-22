package com.bytedance.lynx.media;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Build;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.lynx.media.playable.IVideoEnginePlayable;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.render.PlatformRendererContext;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.DataSource;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import com.ss.ttvideoengine.VideoEngineCallback;
import com.ss.ttvideoengine.VideoEngineInfoListener;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import x6a.i;

/* JADX INFO: loaded from: classes21.dex */
public abstract class LynxMediaEngineBaseView extends FrameLayout implements x6a.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IVideoEnginePlayable f264819a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public i f264820b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f264821c;

    public static final class a {
    }

    static {
    }

    @Override // x6a.e
    public final /* synthetic */ void applyRendererClipBounds(boolean r100, Rect r101) {
        x6a.d.a(this, r100, r101);
    }

    @Override // x6a.e
    public final /* synthetic */ void applyRendererOpacity(float r100) {
        x6a.d.b(this, r100);
    }

    @Override // x6a.e
    public final /* synthetic */ void applyRendererTransform(float[] r100) {
        x6a.d.c(this, r100);
    }

    public abstract void c(b r100);

    @Override // x6a.e
    public final /* synthetic */ PointF convertPointInRendererHostToScreen(PointF r100) {
        return x6a.d.d(this, r100);
    }

    public abstract boolean d();

    public abstract void f();

    @Override // x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostHeight() {
        return x6a.d.e(this);
    }

    @Override // x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostScrollX() {
        return x6a.d.f(this);
    }

    @Override // x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostScrollY() {
        return x6a.d.g(this);
    }

    @Override // x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostWidth() {
        return x6a.d.h(this);
    }

    @Override // x6a.e
    public View getView() {
        return this;
    }

    @Override // x6a.e
    public final /* synthetic */ void invalidateForRenderer() {
        x6a.d.i(this);
    }

    @Override // x6a.e
    public final /* synthetic */ boolean invokeUIMethod(String r100, ReadableMap r101, Callback r102) {
        return false;
    }

    @Override // x6a.e
    public final /* synthetic */ void requestLayoutForRenderer() {
        x6a.d.j(this);
    }

    @Override // x6a.e
    public /* bridge */ /* synthetic */ void setClipChildrenForRenderer(boolean r100) {
        x6a.d.k(this, r100);
    }

    public abstract void setPlayParams(Map<String, ? extends Object> r100);

    @Override // x6a.e
    public /* bridge */ /* synthetic */ void setWillNotDrawForRenderer(boolean r100) {
        x6a.d.l(this, r100);
    }

    private final h07.a getMAudioFocusManager() {
        return (h07.a) this.f264821c.getValue();
    }

    public final IVideoEnginePlayable getMediaView() {
        return this.f264819a;
    }

    @Override // x6a.e
    public i getRenderer() {
        return this.f264820b;
    }

    public LynxMediaEngineBaseView(final Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        new LinkedHashMap();
        super(r100);
        this.f264821c = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new LynxMediaEngineBaseView$mAudioFocusManager$2(r100));
    }

    public final void a(com.bytedance.lynx.media.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        LLog.i("LynxMediaEngineBaseView", "invoke abandonAudioFocus");
        if (this.f264819a == null) goto L11;
        h07.a r101 = getMAudioFocusManager();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "listener");
        if (Build.VERSION.SDK_INT < 26) goto L9;
        AudioFocusRequest r102 = r101.f483446b;
        if (r102 == null) goto L12;
        r101.f483445a.abandonAudioFocusRequest(r102);
        return;
    L12:
        return;
    L9:
        r101.f483445a.abandonAudioFocus(r100);
        return;
    }

    public final void b(b r100) {
        IVideoEnginePlayable r101 = this.f264819a;
        if (r101 == null) goto L6;
        LLog.i("LynxMediaEngineBaseView", "invoke pause");
        r101.k(r100);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.dispatchDraw(r100);
        i r101 = this.f264820b;
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }

    public final void e(com.bytedance.lynx.media.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        LLog.i("LynxMediaEngineBaseView", "invoke requestAudioFocus");
        if (this.f264819a == null) goto L9;
        h07.a r101 = getMAudioFocusManager();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "listener");
        if (Build.VERSION.SDK_INT < 26) goto L7;
        AudioAttributes r102 = new AudioAttributes.Builder().setUsage(1).setContentType(2).build();
        AudioFocusRequest r103 = new AudioFocusRequest.Builder(1).setAudioAttributes(r102).setAcceptsDelayedFocusGain(true).setOnAudioFocusChangeListener(r100).build();
        r101.f483446b = r103;
        AudioManager r104 = r101.f483445a;
        Intrinsics.checkNotNull(r103);
        r104.requestAudioFocus(r103);
        return;
    L7:
        r101.f483445a.requestAudioFocus(r100, 3, 1);
        return;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        i r101 = this.f264820b;
        if (r101 == null) goto L6;
        r101.g(r100);
        return;
    L6:
        super.onDraw(r100);
    }

    public final void setCacheSize(int r100) {
        IVideoEnginePlayable r101 = this.f264819a;
        if (r101 == null) goto L6;
        LLog.i("LynxMediaEngineBaseView", "invoke setCacheSize " + r100);
        r101.o(MapsKt.mapOf(TuplesKt.to("cache-size", Integer.valueOf(r100))));
        return;
    }

    public final void setDataSource(DataSource r100) {
        if (r100 == null) goto L7;
        IVideoEnginePlayable r101 = this.f264819a;
        if (r101 == null) goto L8;
        LLog.i("LynxMediaEngineBaseView", "trigger setDataSource");
        r101.setDataSource(r100);
        return;
    L8:
        return;
    }

    public final void setLoop(boolean r100) {
        IVideoEnginePlayable r101 = this.f264819a;
        if (r101 == null) goto L6;
        LLog.i("LynxMediaEngineBaseView", "invoke setLoop " + r100);
        r101.o(MapsKt.mapOf(TuplesKt.to("loop", Boolean.valueOf(r100))));
        return;
    }

    public final void setMediaVideoEngineCallback(i07.a r100) {
        if (r100 == null) goto L7;
        IVideoEnginePlayable r101 = this.f264819a;
        if (r101 == null) goto L8;
        LLog.i("LynxMediaEngineBaseView", "trigger setVideoEngineInfoListener");
        r101.e(r100);
        return;
    L8:
        return;
    }

    public final void setMediaView(IVideoEnginePlayable r100) {
        this.f264819a = r100;
    }

    public final void setMuted(boolean r100) {
        IVideoEnginePlayable r101 = this.f264819a;
        if (r101 == null) goto L6;
        LLog.i("LynxMediaEngineBaseView", "invoke setMuted " + r100);
        r101.o(MapsKt.mapOf(TuplesKt.to("muted", Boolean.valueOf(r100))));
        return;
    }

    public final void setPlayOptions(Map<Integer, ? extends Pair<? extends Object, ? extends IVideoEnginePlayable.IVideoEnginePlayablePlayOptionType>> r100) {
        Intrinsics.checkNotNullParameter(r100, "options");
        IVideoEnginePlayable r101 = this.f264819a;
        if (r101 == null) goto L6;
        LLog.i("LynxMediaEngineBaseView", "trigger setPlayOptions");
        r101.h(r100);
        return;
    }

    public final void setProgressUpdateInterval(int r100) {
        IVideoEnginePlayable r101 = this.f264819a;
        if (r101 == null) goto L6;
        LLog.i("LynxMediaEngineBaseView", "invoke setProgressUpdateInterval " + r100);
        r101.o(MapsKt.mapOf(TuplesKt.to("progress_update_interval", Integer.valueOf(r100))));
        return;
    }

    @Override // x6a.e
    public void setRenderer(i r100) {
        Intrinsics.checkNotNullParameter(r100, "renderer");
        this.f264820b = r100;
    }

    public final void setResolution(String r100) {
        Intrinsics.checkNotNullParameter(r100, "resolution");
        IVideoEnginePlayable r101 = this.f264819a;
        if (r101 == null) goto L6;
        LLog.i("LynxMediaEngineBaseView", "invoke setResolution " + r100);
        r101.o(MapsKt.mapOf(TuplesKt.to("resolution", r100)));
        return;
    }

    public final void setSpeed(float r100) {
        IVideoEnginePlayable r101 = this.f264819a;
        if (r101 == null) goto L6;
        LLog.i("LynxMediaEngineBaseView", "invoke setSpeed " + r100);
        r101.o(MapsKt.mapOf(TuplesKt.to("speed", Float.valueOf(r100))));
        return;
    }

    public final void setSubTag(String r100) {
        Intrinsics.checkNotNullParameter(r100, "subTag");
        IVideoEnginePlayable r101 = this.f264819a;
        if (r101 == null) goto L6;
        LLog.i("LynxMediaEngineBaseView", "invoke setSubTag " + r100);
        r101.o(MapsKt.mapOf(TuplesKt.to("sub_tag", r100)));
        return;
    }

    public final void setTag(String r100) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        IVideoEnginePlayable r101 = this.f264819a;
        if (r101 == null) goto L6;
        LLog.i("LynxMediaEngineBaseView", "invoke setTag " + r100);
        r101.o(MapsKt.mapOf(TuplesKt.to("tag", r100)));
        return;
    }

    public final void setVideoEngineCallback(VideoEngineCallback r100) {
        if (r100 == null) goto L7;
        IVideoEnginePlayable r101 = this.f264819a;
        if (r101 == null) goto L8;
        LLog.i("LynxMediaEngineBaseView", "trigger setVideoEngineCallback");
        r101.setVideoEngineCallback(r100);
        return;
    L8:
        return;
    }

    public final void setVideoEngineInfoListener(VideoEngineInfoListener r100) {
        if (r100 == null) goto L7;
        IVideoEnginePlayable r101 = this.f264819a;
        if (r101 == null) goto L8;
        LLog.i("LynxMediaEngineBaseView", "trigger setVideoEngineInfoListener");
        r101.setVideoEngineInfoListener(r100);
        return;
    L8:
        return;
    }

    public final void setVolume(float r100) {
        IVideoEnginePlayable r101 = this.f264819a;
        if (r101 == null) goto L6;
        LLog.i("LynxMediaEngineBaseView", "invoke setVolume " + r100);
        r101.o(MapsKt.mapOf(TuplesKt.to(ITTVideoEngineEventSource.KEY_VOLUME, Float.valueOf(r100))));
        return;
    }

    @Override // x6a.e
    public final i createRenderer(PlatformRendererContext r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "platformRendererContext");
        return new i(r100, r101);
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas r100, View r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        i r103 = this.f264820b;
        if (r103 == null) goto L5;
        r103.b(r100, r101);
    L5:
        boolean r104 = super.drawChild(r100, r101, r102);
        if (this.f264820b == null) goto L8;
        r100.restore();
    L8:
        return r104;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        i r105 = this.f264820b;
        if (r105 == null) goto L7;
        LynxBaseUI r106 = r105.f562747h;
        if (r106 == null) goto L7;
        r106.measure();
    L7:
        super.onLayout(r100, r101, r102, r103, r104);
    }
}
