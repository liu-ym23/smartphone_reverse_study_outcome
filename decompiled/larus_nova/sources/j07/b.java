package j07;

import android.content.Context;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.lynx.media.AbsMediaEngineView;
import com.bytedance.lynx.media.playable.IVideoEnginePlayable;
import com.bytedance.lynx.media.view.BaseMediaView;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.DataSource;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.VideoEngineCallback;
import com.ss.ttvideoengine.VideoEngineInfoListener;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public abstract class b implements IVideoEnginePlayable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f496816a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BaseMediaView f496817b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public g07.b f496818c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public WeakReference<TTVideoEngine> f496819d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Map<Integer, ? extends Pair<? extends Object, ? extends IVideoEnginePlayable.IVideoEnginePlayablePlayOptionType>> f496820e;

    public static final class a {
    }

    /* JADX INFO: renamed from: j07.b$b, reason: collision with other inner class name */
    public /* synthetic */ class C6379b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f496821a = null;

        static {
            int[] r100 = new int[IVideoEnginePlayable.IVideoEnginePlayablePlayOptionType.values().length];
            r100[IVideoEnginePlayable.IVideoEnginePlayablePlayOptionType.TYPE_STRING.ordinal()] = 1;
            r100[IVideoEnginePlayable.IVideoEnginePlayablePlayOptionType.TYPE_INT.ordinal()] = 2;
            r100[IVideoEnginePlayable.IVideoEnginePlayablePlayOptionType.TYPE_LONG.ordinal()] = 3;
            r100[IVideoEnginePlayable.IVideoEnginePlayablePlayOptionType.TYPE_FLOAT.ordinal()] = 4;
            f496821a = r100;
        }
    }

    static {
    }

    @Override // com.bytedance.lynx.media.playable.IVideoEnginePlayable
    public final void destroy() {
        BaseMediaView r100 = this.f496817b;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.d() == false) goto L16;
        f07.c r101 = r100.f264837b;
        if (r101.f474984a == null) goto L17;
        WeakHandler r102 = r101.f475003t;
        if (r102 == null) goto L13;
        r102.removeMessages(201);
    L13:
        r101.f474996m = false;
        r101.f474998o = false;
        r101.f474984a.releaseAsync();
        r101.f474984a = null;
        return;
    L17:
        return;
    }

    public final Context getContext() {
        return this.f496816a;
    }

    public b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f496816a = r100;
    }

    @Override // com.bytedance.lynx.media.playable.IVideoEnginePlayable
    public final void a(com.bytedance.lynx.media.b r100) {
        BaseMediaView r101 = this.f496817b;
        if (r101 != null) goto L5;
    L10:
        if (r100 == null) goto L13;
        r100.a(0, null, 0, null);
        return;
    L13:
        return;
    L5:
        if (r101.d() == false) goto L10;
        f07.c r102 = r101.f264837b;
        if (r102.f474984a == null) goto L10;
        r102.f474984a.stop();
        goto L10
    }

    @Override // com.bytedance.lynx.media.playable.IVideoEnginePlayable
    public final void e(i07.a r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        BaseMediaView r101 = this.f496817b;
        if (r101 == null) goto L6;
        r101.setMediaVideoEngineCallback(r100);
        return;
    }

    @Override // com.bytedance.lynx.media.playable.IVideoEnginePlayable
    public final void h(Map<Integer, ? extends Pair<? extends Object, ? extends IVideoEnginePlayable.IVideoEnginePlayablePlayOptionType>> r100) {
        Intrinsics.checkNotNullParameter(r100, "options");
        WeakReference<TTVideoEngine> r101 = this.f496819d;
        if (r101 == null) goto L5;
        TTVideoEngine r102 = r101.get();
    L6:
        if (r102 != null) goto L9;
        this.f496820e = r100;
        return;
    L9:
        p(r100);
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.lynx.media.playable.IVideoEnginePlayable
    public final int j(AbsMediaEngineView.a r100) {
        BaseMediaView r101 = this.f496817b;
        if (r101 != null) goto L5;
    L7:
        boolean r102 = false;
    L9:
        if (r102 == false) goto L13;
        if (r100 == null) goto L12;
        r100.a(7, null, -1, "player is not prepared");
    L12:
        return -1;
    L13:
        if (r100 == null) goto L15;
        r100.a(0, new c(this), 0, null);
    L15:
        BaseMediaView r103 = this.f496817b;
        if (r103 != null) goto L18;
        return -1;
    L18:
        return r103.getDuration();
    L5:
        if (r101.e() == true) goto L7;
        r102 = true;
        goto L9
    }

    @Override // com.bytedance.lynx.media.playable.IVideoEnginePlayable
    public final void k(com.bytedance.lynx.media.b r100) {
        BaseMediaView r101 = this.f496817b;
        if (r101 == null) goto L5;
        r101.f();
    L5:
        if (r100 == null) goto L8;
        r100.a(0, null, 0, null);
        return;
    }

    public final void p(Map<Integer, ? extends Pair<? extends Object, ? extends IVideoEnginePlayable.IVideoEnginePlayablePlayOptionType>> r100) {
        Intrinsics.checkNotNullParameter(r100, "options");
        WeakReference<TTVideoEngine> r101 = this.f496819d;
        if (r101 == null) goto L22;
        TTVideoEngine r102 = r101.get();
        if (r102 == null) goto L37;
        Iterator<T> r103 = r100.entrySet().iterator();
    L8:
        if (r103.hasNext() == false) goto L38;
        Map.Entry r104 = (Map.Entry) r103.next();
        IVideoEnginePlayable.IVideoEnginePlayablePlayOptionType r105 = (IVideoEnginePlayable.IVideoEnginePlayablePlayOptionType) ((Pair) r104.getValue()).getSecond();
        int r106 = C6379b.f496821a[r105.ordinal()];
        if (r106 != 1) goto L12;
        r102.setStringOption(((Number) r104.getKey()).intValue(), (String) ((Pair) r104.getValue()).getFirst());
        goto L8
    L12:
        if (r106 != 2) goto L14;
        r102.setIntOption(((Number) r104.getKey()).intValue(), ((Integer) ((Pair) r104.getValue()).getFirst()).intValue());
        goto L8
    L14:
        if (r106 != 3) goto L16;
        r102.setLongOption(((Number) r104.getKey()).intValue(), ((Long) ((Pair) r104.getValue()).getFirst()).longValue());
        goto L8
    L16:
        if (r106 != 4) goto L8;
        r102.setFloatOption(((Number) r104.getKey()).intValue(), ((Float) ((Pair) r104.getValue()).getFirst()).floatValue());
        goto L8
    L38:
        return;
    L37:
        return;
    }

    public boolean q(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        if (r100.containsKey("muted") == false) goto L5;
    L20:
        return true;
    L5:
        if (r100.containsKey("loop") == true) goto L20;
        if (r100.containsKey("speed") == true) goto L20;
        if (r100.containsKey(ITTVideoEngineEventSource.KEY_VOLUME) == true) goto L20;
        if (r100.containsKey("tag") == true) goto L20;
        if (r100.containsKey("sub_tag") == true) goto L20;
        if (r100.containsKey("cache-size") == true) goto L20;
        if (r100.containsKey("progress_update_interval") == true) goto L20;
        return false;
    }

    @Override // com.bytedance.lynx.media.playable.IVideoEnginePlayable
    public final void setDataSource(DataSource r100) {
        Intrinsics.checkNotNullParameter(r100, "dataSource");
        BaseMediaView r101 = this.f496817b;
        if (r101 == null) goto L6;
        r101.setDataSource(r100);
        return;
    }

    @Override // com.bytedance.lynx.media.playable.IVideoEnginePlayable
    public final void setVideoEngineCallback(VideoEngineCallback r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        BaseMediaView r101 = this.f496817b;
        if (r101 == null) goto L6;
        r101.setVideoEngineCallback(r100);
        return;
    }

    @Override // com.bytedance.lynx.media.playable.IVideoEnginePlayable
    public final void setVideoEngineInfoListener(VideoEngineInfoListener r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        BaseMediaView r101 = this.f496817b;
        if (r101 == null) goto L6;
        r101.setVideoEngineInfoListener(r100);
        return;
    }
}
