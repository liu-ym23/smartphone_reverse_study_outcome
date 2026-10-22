package com.ss.android.videoshop.log;

import ajc.c;
import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.model.VideoInfo;
import fjc.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import nic.p;

/* JADX INFO: loaded from: classes40.dex */
public final enum VideoTracer extends Enum<VideoTracer> {
    public static final VideoTracer INS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VideoTracer[] f455981a = null;
    private boolean enable;
    private final int maxPrepareTraceNum;
    private final int maxTraceNum;
    private Queue<tic.a> playQueue;
    private Queue<tic.a> prepareQueue;
    private Map<tic.a, c> prepareTraceItemMap;
    private Map<tic.a, c> traceItemMap;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f455982a = null;

        static {
            int[] r100 = new int[VideoTraceState.values().length];
            f455982a = r100;
            r100[VideoTraceState.CONTROLLER_PLAY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            f455982a[VideoTraceState.CONTROLLER_ON_RENDER_START.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public synchronized List<c> getTraceInfoList() {
        monitor-enter(this);
        ArrayList r100 = new ArrayList();     // Catch: Throwable -> L10
    L5:
        if (this.playQueue.isEmpty() == true) goto L8;
        r100.add(this.traceItemMap.remove(this.playQueue.poll()));     // Catch: Throwable -> L10
        goto L5
    L8:
        monitor-exit(this);
        return r100;
    L10:
        th = move-exception;
        throw th;
    }

    static {
        VideoTracer r100 = new VideoTracer();
        INS = r100;
        f455981a = new VideoTracer[]{r100};
    }

    public VideoTracer() {
        super("INS", 0);
        this.enable = true;
        this.maxTraceNum = 3;
        this.maxPrepareTraceNum = 5;
        this.traceItemMap = new HashMap();
        this.prepareTraceItemMap = new HashMap();
        this.playQueue = new LinkedList();
        this.prepareQueue = new LinkedList();
    }

    public static VideoTracer[] values() {
        return (VideoTracer[]) f455981a.clone();
    }

    public boolean isEnable() {
        return this.enable;
    }

    public static VideoTracer valueOf(String r100) {
        return (VideoTracer) r27.a.a(VideoTracer.class, r100);
    }

    public final c b(tic.a r100) {
        if (this.traceItemMap.containsKey(r100) == false) goto L7;
        return this.traceItemMap.get(r100);
    L7:
        if (this.prepareTraceItemMap.containsKey(r100) == true) goto L9;
        return null;
    L9:
        return this.prepareTraceItemMap.get(r100);
    }

    public void setEnable(boolean r100) {
        this.enable = r100;
    }

    public final boolean c(tic.a r100, VideoTraceState r101) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (this.enable == true) goto L10;
        this.traceItemMap.clear();
        this.playQueue.clear();
        this.prepareQueue.clear();
        this.prepareTraceItemMap.clear();
        return false;
    L10:
        if (this.playQueue.contains(r100) == true) goto L26;
        if (this.prepareQueue.contains(r100) == true) goto L18;
        if (this.prepareQueue.size() < 5) goto L16;
        tic.a r102 = this.prepareQueue.poll();
        this.prepareTraceItemMap.remove(r102);
    L16:
        this.prepareQueue.offer(r100);
        this.prepareTraceItemMap.put(r100, new c());
    L18:
        if (r101 != VideoTraceState.LAYER_HOST_PLAY) goto L26;
        tic.a r103 = this.prepareQueue.poll();
        if (r103 == null) goto L26;
        if (this.playQueue.size() < 3) goto L24;
        this.traceItemMap.remove(this.playQueue.poll());
    L24:
        this.playQueue.offer(r103);
        this.traceItemMap.put(r103, this.prepareTraceItemMap.remove(r103));
    L26:
        if (this.traceItemMap.containsKey(r100) == false) goto L28;
    L29:
        return true;
    L28:
        if (this.prepareTraceItemMap.containsKey(r100) == true) goto L29;
        return false;
    }

    public synchronized void updateVolume(tic.a r100, float r101, float r102) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (c(r100, null) == true) goto L8;
        monitor-exit(this);
        return;
    L8:
        b(r100);     // Catch: Throwable -> L11
        monitor-exit(this);
    }

    public static void a(c r100, tic.a r101, VideoTraceState r102, p r103) {
        if (r101 == null) goto L28;
        int r104 = a.f455982a[r102.ordinal()];
        if (r104 == 1) goto L15;
        if (r104 != 2) goto L29;
        if (r103 == null) goto L26;
        VideoInfo r105 = r103.b();
        if (r105 == null) goto L13;
        r105.getValueStr(7);
        r105.getValueStr(8);
        r105.getValueStr(6);
    L13:
        r103.getResolution();
        Resolution r106 = Resolution.Undefine;
        return;
    L26:
        return;
    L29:
        return;
    L15:
        if (r101.f546366d == null) goto L18;
        Pair r107 = new Pair("video_model", r101.f546363a);
    L24:
        String r108 = (String) r107.first;
        String r109 = (String) r107.second;
        return;
    L18:
        if (TextUtils.isEmpty(r101.f546368f) == true) goto L21;
        r107 = new Pair("local_url", r101.f546368f);
        goto L24
    L21:
        if (TextUtils.isEmpty(r101.f546367e) == true) goto L23;
        r107 = new Pair("video_url", r101.f546367e);
        goto L24
    L23:
        r107 = new Pair("vid", r101.f546363a);
        goto L24
    }

    public synchronized void trace(tic.a r100, VideoTraceState r101, String r102, Object r103, p r104) {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L4:
        if (c(r100, r101) == true) goto L7;
        monitor-exit(this);
        return;
    L7:
        c r105 = b(r100);     // Catch: Throwable -> L15
        if (r105 == null) goto L13;
        List r106 = r105.f3972a;     // Catch: Throwable -> L15
        a(r105, r100, r101, r104);     // Catch: Throwable -> L15
        if (r106 != null) goto L12;
        r106 = new ArrayList();     // Catch: Throwable -> L15
        r105.f3972a = r106;     // Catch: Throwable -> L15
    L12:
        r106.add(new ajc.a(r101, r102, r103));     // Catch: Throwable -> L15
    L13:
        monitor-exit(this);
    }

    public synchronized void updateTextureSize(tic.a r100, int r101, int r102, int r103, int r110, float r111, Context r112) {
        monitor-enter(this);
        VideoTraceState r104 = VideoTraceState.TEXTURE_SIZE;     // Catch: Throwable -> L29
        if (c(r100, r104) == true) goto L8;
        monitor-exit(this);
        return;
    L8:
        c r105 = b(r100);     // Catch: Throwable -> L29
        if (r105 == null) goto L27;
        List r106 = r105.f3972a;     // Catch: Throwable -> L29
        if (r106 != null) goto L13;
        r106 = new ArrayList();     // Catch: Throwable -> L29
        r105.f3972a = r106;     // Catch: Throwable -> L29
    L13:
        int r107 = g.d(r112);     // Catch: Throwable -> L29
        int r108 = g.c(r112);     // Catch: Throwable -> L29
        int r113 = g.b(r112);     // Catch: Throwable -> L29
        if (r101 > r103) goto L26;
        if (r102 > r110) goto L26;
        if (r113 == 1) goto L26;
        if (r113 == 9) goto L26;
        if (r113 == 0) goto L26;
        if (r113 == 8) goto L26;
        Math.max(r103, r110);     // Catch: Throwable -> L29
    L26:
        r106.add(new ajc.a(r104, "texture:[" + r101 + "," + r102 + "];parent:[" + r103 + "," + r110 + "];screen:[" + r107 + "," + r108 + "];scale:" + r111, null));     // Catch: Throwable -> L29
    L27:
        monitor-exit(this);
        return;
    L29:
        th = move-exception;
        throw th;
    }
}
