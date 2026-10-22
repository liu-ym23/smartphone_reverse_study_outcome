package com.ss.bytedance.ies.videoclip.api.timeline;

import android.view.Surface;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.ss.bytedance.ies.videoclip.api.player.IPlayer;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import njc.b;
import qjc.a;
import rjc.c;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH&J\"\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0002H&J\"\u0010\u0015\u001a\u00020\u00042\u0018\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00040\u0012H&J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0016H&J\u001a\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH&J\u001a\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH&J\u0010\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018H&J\u0010\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018H&J\u0018\u0010\"\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010!\u001a\u00020 H&J \u0010'\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010$\u001a\u00020#2\u0006\u0010&\u001a\u00020%H&J\b\u0010(\u001a\u00020\u0004H&J\u0010\u0010*\u001a\u00020\u00042\u0006\u0010)\u001a\u00020%H&J\u0010\u0010-\u001a\u00020\u00042\u0006\u0010,\u001a\u00020+H&¨\u0006."}, d2 = {"Lcom/ss/bytedance/ies/videoclip/api/timeline/ITimeLine;", "", "", "color", "", "setBackgroundColor", "Lrjc/b;", "size", "setRenderSize", "Lcom/ss/bytedance/ies/videoclip/api/timeline/RenderLayoutModeProxy;", "mode", "setRenderLayoutMode", "Landroid/view/Surface;", "surface", "width", "height", "Lcom/ss/bytedance/ies/videoclip/api/player/IPlayer;", "getPlayer", "Lkotlin/Function2;", "", "callback", "notifyUpdate", "Lnjc/b;", "getExporter", "", "id", "Lqjc/a;", GXTemplateKey.GAIAX_TRACK, "addVideoTrack", "addAudioTrack", "removeVideoTrack", "removeAudioTrack", "", ITTVideoEngineEventSource.KEY_VOLUME, "updateTrackVolume", "", "offset", "Lrjc/c;", "time", "updateTrackAlign", "release", "duration", "setFrameDuration", "Lsjc/a;", "globalIGLCanvasDrawable", "setGlobalCanvasDrawable", "videoclip-api-0.0.0.2-alpha.93@aar_release"}, k = 1, mv = {1, 4, 0})
public interface ITimeLine {
    void addAudioTrack(String r100, a r101);

    void addVideoTrack(String r100, a r101);

    b getExporter();

    IPlayer getPlayer(Surface r100, int r101, int r102);

    void notifyUpdate(Function2<? super IPlayer, ? super Boolean, Unit> r100);

    void release();

    void removeAudioTrack(String r100);

    void removeVideoTrack(String r100);

    void setBackgroundColor(int r100);

    void setFrameDuration(c r100);

    void setGlobalCanvasDrawable(sjc.a r100);

    void setRenderLayoutMode(RenderLayoutModeProxy r100);

    void setRenderSize(rjc.b r100);

    void updateTrackAlign(String r100, long r101, c r102);

    void updateTrackVolume(String r100, float r101);
}
