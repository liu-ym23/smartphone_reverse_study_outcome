package com.bytedance.lynx.media;

import android.content.Context;
import com.bytedance.lynx.media.playable.IVideoEnginePlayable;
import com.lynx.tasm.base.LLog;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class f extends LynxMediaEngineBaseView {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f264830d;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.lynx.media.LynxMediaEngineBaseView
    public final void f() {
        this.f264830d = false;
    }

    @Override // com.bytedance.lynx.media.LynxMediaEngineBaseView, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostHeight() {
        return x6a.d.e(this);
    }

    @Override // com.bytedance.lynx.media.LynxMediaEngineBaseView, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostScrollX() {
        return x6a.d.f(this);
    }

    @Override // com.bytedance.lynx.media.LynxMediaEngineBaseView, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostScrollY() {
        return x6a.d.g(this);
    }

    @Override // com.bytedance.lynx.media.LynxMediaEngineBaseView, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostWidth() {
        return x6a.d.h(this);
    }

    @Override // com.bytedance.lynx.media.LynxMediaEngineBaseView, x6a.e
    public /* bridge */ /* synthetic */ void setClipChildrenForRenderer(boolean r100) {
        x6a.d.k(this, r100);
    }

    @Override // com.bytedance.lynx.media.LynxMediaEngineBaseView, x6a.e
    public /* bridge */ /* synthetic */ void setWillNotDrawForRenderer(boolean r100) {
        x6a.d.l(this, r100);
    }

    @Override // com.bytedance.lynx.media.LynxMediaEngineBaseView
    public final boolean d() {
        return this.f264830d;
    }

    public f(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        new LinkedHashMap();
        super(r100);
    }

    @Override // com.bytedance.lynx.media.LynxMediaEngineBaseView
    public final void c(b r100) {
        IVideoEnginePlayable r101 = getMediaView();
        if (r101 == null) goto L6;
        LLog.i("LynxAudioEngineLayout", "invoke prepare");
        r101.g(r100);
        this.f264830d = true;
        return;
    }

    @Override // com.bytedance.lynx.media.LynxMediaEngineBaseView
    public void setPlayParams(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        IVideoEnginePlayable r101 = getMediaView();
        j07.a r102 = new j07.a(getContext());
        r102.initialize();
        LLog.i("LynxAudioEngineLayout", "mediaView trigger initialize");
        r102.o(r100);
        setMediaView(r102);
        Object r103 = r100.get("auto_prepare");
        if ((r103 instanceof Boolean) == false) goto L5;
        Boolean r104 = (Boolean) r103;
    L6:
        if (r104 == null) goto L8;
        boolean r105 = r104.booleanValue();
    L9:
        if (r105 == false) goto L14;
        IVideoEnginePlayable r106 = getMediaView();
        if (r106 == null) goto L13;
        r106.g(null);
    L13:
        this.f264830d = true;
        LLog.i("LynxAudioEngineLayout", "Trigger prepare for mediaView " + getMediaView());
    L14:
        if (r101 == null) goto L17;
        r101.destroy();
        return;
    L17:
        return;
    L8:
        r105 = false;
        goto L9
    L5:
        r104 = null;
        goto L6
    }
}
