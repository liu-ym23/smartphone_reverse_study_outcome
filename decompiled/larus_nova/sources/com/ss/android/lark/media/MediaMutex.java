package com.ss.android.lark.media;

import android.text.TextUtils;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes36.dex */
public final class MediaMutex {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final MediaMutex f431631r = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, WeakReference<com.ss.android.lark.media.a>> f431632a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Scene> f431633b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f431634c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f431635d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ArrayList<String> f431636e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Scene f431637f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Scene f431638g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ArrayList<Scene> f431639h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Map<String, String> f431640i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Map<String, String> f431641j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Map<String, ArrayList<String>> f431642k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Map<Scene, Scene> f431643l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Map<Scene, Scene> f431644m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Map<Scene, ArrayList<Scene>> f431645n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Map<String, Priority> f431646o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Map<String, Priority> f431647p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final HashMap<Scene, SceneMediaConfig> f431648q;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/media/MediaMutex$LockError;", "Ljava/lang/Error;", "Lkotlin/Error;", "occupiedScene", "Lcom/ss/android/lark/media/Scene;", "errorMessage", "", "<init>", "(Lcom/ss/android/lark/media/Scene;Ljava/lang/String;)V", "getOccupiedScene", "()Lcom/ss/android/lark/media/Scene;", "getErrorMessage", "()Ljava/lang/String;", "lark-media_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class LockError extends Error {
        private final String errorMessage;
        private final Scene occupiedScene;

        public final String getErrorMessage() {
            return this.errorMessage;
        }

        public final Scene getOccupiedScene() {
            return this.occupiedScene;
        }

        public LockError(Scene r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "occupiedScene");
            Intrinsics.checkNotNullParameter(r101, "errorMessage");
            super(r100.name());
            this.occupiedScene = r100;
            this.errorMessage = r101;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/media/MediaMutex$MediaConfig;", "Ljava/io/Serializable;", "type", "Lcom/ss/android/lark/media/MediaType;", "priority", "Lcom/ss/android/lark/media/Priority;", "<init>", "(Lcom/ss/android/lark/media/MediaType;Lcom/ss/android/lark/media/Priority;)V", "getType", "()Lcom/ss/android/lark/media/MediaType;", "getPriority", "()Lcom/ss/android/lark/media/Priority;", "lark-media_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class MediaConfig implements Serializable {
        private final Priority priority;
        private final MediaType type;

        public final Priority getPriority() {
            return this.priority;
        }

        public final MediaType getType() {
            return this.type;
        }

        public MediaConfig(MediaType r100, Priority r101) {
            Intrinsics.checkNotNullParameter(r100, "type");
            Intrinsics.checkNotNullParameter(r101, "priority");
            this.type = r100;
            this.priority = r101;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/media/MediaMutex$SceneMediaConfig;", "Ljava/io/Serializable;", "scene", "Lcom/ss/android/lark/media/Scene;", "mediaConfig", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/media/MediaMutex$MediaConfig;", "mixWithOthers", "", "sceneDescription", "", "<init>", "(Lcom/ss/android/lark/media/Scene;Ljava/util/ArrayList;ZLjava/lang/String;)V", "getScene", "()Lcom/ss/android/lark/media/Scene;", "getMediaConfig", "()Ljava/util/ArrayList;", "getMixWithOthers", "()Z", "setMixWithOthers", "(Z)V", "getSceneDescription", "()Ljava/lang/String;", "lark-media_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class SceneMediaConfig implements Serializable {
        private final ArrayList<MediaConfig> mediaConfig;
        private boolean mixWithOthers;
        private final Scene scene;
        private final String sceneDescription;

        public final ArrayList<MediaConfig> getMediaConfig() {
            return this.mediaConfig;
        }

        public final boolean getMixWithOthers() {
            return this.mixWithOthers;
        }

        public final Scene getScene() {
            return this.scene;
        }

        public final String getSceneDescription() {
            return this.sceneDescription;
        }

        public final void setMixWithOthers(boolean r100) {
            this.mixWithOthers = r100;
        }

        public SceneMediaConfig(Scene r100, ArrayList<MediaConfig> r101, boolean r102, String r103) {
            Intrinsics.checkNotNullParameter(r100, "scene");
            Intrinsics.checkNotNullParameter(r101, "mediaConfig");
            this.scene = r100;
            this.mediaConfig = r101;
            this.mixWithOthers = r102;
            this.sceneDescription = r103;
        }
    }

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f431649a = null;

        static {
            int[] r100 = new int[MediaType.values().length];
            r100[MediaType.Camera.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[MediaType.Audio_Record.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[MediaType.Audio_Play.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f431649a = r100;
        }
    }

    static {
        f431631r = new MediaMutex();
    }

    public MediaMutex() {
        this.f431632a = new HashMap();
        this.f431633b = new HashMap();
        this.f431636e = new ArrayList();
        this.f431639h = new ArrayList();
        this.f431640i = new HashMap();
        this.f431641j = new HashMap();
        this.f431642k = new HashMap();
        this.f431643l = new EnumMap(Scene.class);
        this.f431644m = new EnumMap(Scene.class);
        this.f431645n = new EnumMap(Scene.class);
        this.f431646o = new HashMap();
        this.f431647p = new HashMap();
        Scene r100 = Scene.VC_MEETING;
        MediaType r101 = MediaType.Camera;
        Priority r102 = Priority.High;
        MediaType r110 = MediaType.Audio_Record;
        MediaType r111 = MediaType.Audio_Play;
        MediaConfig[] r103 = {new MediaConfig(r101, r102), new MediaConfig(r110, r102), new MediaConfig(r111, r102)};
        Scene r104 = Scene.VC_RINGING;
        MediaConfig[] r105 = {new MediaConfig(r111, r102)};
        Scene r106 = Scene.VOIP_MEETING;
        MediaConfig[] r107 = {new MediaConfig(r110, r102), new MediaConfig(r111, r102)};
        Scene r108 = Scene.VOIP_RINGING;
        MediaConfig[] r109 = {new MediaConfig(r111, r102)};
        Scene r112 = Scene.Minutes_Record;
        Priority r113 = Priority.Medium;
        MediaConfig[] r114 = {new MediaConfig(r110, r113)};
        Scene r115 = Scene.Minutes_Play;
        Priority r116 = Priority.Default;
        MediaConfig[] r117 = {new MediaConfig(r111, r116)};
        Scene r118 = Scene.IM_Video_Record;
        MediaConfig[] r119 = {new MediaConfig(r101, r116), new MediaConfig(r110, r116)};
        Scene r120 = Scene.IM_Video_Play;
        MediaConfig[] r121 = {new MediaConfig(r111, r113)};
        Scene r122 = Scene.IM_Audio_Record;
        MediaConfig[] r123 = {new MediaConfig(r110, r116)};
        Scene r124 = Scene.IM_Audio_Play;
        MediaConfig[] r125 = {new MediaConfig(r111, r113)};
        Scene r126 = Scene.IM_Camera;
        MediaConfig[] r127 = {new MediaConfig(r101, r116)};
        Scene r128 = Scene.Little_App_Audio_Play;
        Priority r129 = Priority.Low;
        MediaConfig[] r130 = {new MediaConfig(r110, r129), new MediaConfig(r111, r116)};
        Scene r131 = Scene.Little_App_Scan;
        MediaConfig[] r132 = {new MediaConfig(r101, r116)};
        Scene r133 = Scene.Little_App_Audio_Record;
        MediaConfig[] r134 = {new MediaConfig(r110, r116)};
        Scene r135 = Scene.Little_App_Video_Record;
        MediaConfig[] r136 = {new MediaConfig(r101, r116), new MediaConfig(r110, r116)};
        Scene r137 = Scene.CCM_Audio_Record;
        MediaConfig[] r138 = {new MediaConfig(r110, r116)};
        Scene r139 = Scene.CCM_Video_Record;
        MediaConfig[] r140 = {new MediaConfig(r101, r116), new MediaConfig(r110, r116)};
        Scene r141 = Scene.CCM_Photo;
        MediaConfig[] r142 = {new MediaConfig(r101, r116)};
        Scene r143 = Scene.CCM_Audio_Play;
        MediaConfig[] r144 = {new MediaConfig(r111, r116)};
        Scene r145 = Scene.VC_RING_TONE;
        MediaConfig[] r146 = {new MediaConfig(r111, r116)};
        Scene r147 = Scene.NOTIFICATION_PLAY;
        MediaConfig[] r148 = {new MediaConfig(r111, r113)};
        Scene r149 = Scene.VC_VOICE_PRINT_RECORD;
        MediaConfig[] r150 = {new MediaConfig(r110, r129)};
        Scene r151 = Scene.DOUBAO_RECORD;
        this.f431648q = MapsKt.hashMapOf(new Pair[]{TuplesKt.to(r100, new SceneMediaConfig(r100, CollectionsKt.arrayListOf(r103), true, "View_G_Meeting_Fill")), TuplesKt.to(r104, new SceneMediaConfig(r104, CollectionsKt.arrayListOf(r105), false, "View_G_Meeting_Fill")), TuplesKt.to(r106, new SceneMediaConfig(r106, CollectionsKt.arrayListOf(r107), true, "View_G_Meeting_Fill")), TuplesKt.to(r108, new SceneMediaConfig(r108, CollectionsKt.arrayListOf(r109), false, "View_G_Meeting_Fill")), TuplesKt.to(r112, new SceneMediaConfig(r112, CollectionsKt.arrayListOf(r114), false, "View_G_FeishuMinutes")), TuplesKt.to(r115, new SceneMediaConfig(r115, CollectionsKt.arrayListOf(r117), false, "View_G_FeishuMinutes")), TuplesKt.to(r118, new SceneMediaConfig(r118, CollectionsKt.arrayListOf(r119), false, "View_G_Video_Fill")), TuplesKt.to(r120, new SceneMediaConfig(r120, CollectionsKt.arrayListOf(r121), false, "View_G_Video_Fill")), TuplesKt.to(r122, new SceneMediaConfig(r122, CollectionsKt.arrayListOf(r123), false, "View_G_Voice_Fill")), TuplesKt.to(r124, new SceneMediaConfig(r124, CollectionsKt.arrayListOf(r125), true, "View_G_Voice_Fill")), TuplesKt.to(r126, new SceneMediaConfig(r126, CollectionsKt.arrayListOf(r127), false, "View_G_Camera_Fill")), TuplesKt.to(r128, new SceneMediaConfig(r128, CollectionsKt.arrayListOf(r130), false, "View_G_App_Fill")), TuplesKt.to(r131, new SceneMediaConfig(r131, CollectionsKt.arrayListOf(r132), false, "View_G_App_Fill")), TuplesKt.to(r133, new SceneMediaConfig(r133, CollectionsKt.arrayListOf(r134), false, "View_G_App_Fill")), TuplesKt.to(r135, new SceneMediaConfig(r135, CollectionsKt.arrayListOf(r136), false, "View_G_App_Fill")), TuplesKt.to(r137, new SceneMediaConfig(r137, CollectionsKt.arrayListOf(r138), false, "View_G_Docs_Fill")), TuplesKt.to(r139, new SceneMediaConfig(r139, CollectionsKt.arrayListOf(r140), false, "View_G_Docs_Fill")), TuplesKt.to(r141, new SceneMediaConfig(r141, CollectionsKt.arrayListOf(r142), false, "View_G_Docs_Fill")), TuplesKt.to(r143, new SceneMediaConfig(r143, CollectionsKt.arrayListOf(r144), false, "View_G_Docs_Fill")), TuplesKt.to(r145, new SceneMediaConfig(r145, CollectionsKt.arrayListOf(r146), false, "View_G_Meeting_Fill")), TuplesKt.to(r147, new SceneMediaConfig(r147, CollectionsKt.arrayListOf(r148), false, "View_G_Voice_Fill")), TuplesKt.to(r149, new SceneMediaConfig(r149, CollectionsKt.arrayListOf(r150), false, "View_G_Recording_Fill")), TuplesKt.to(r151, new SceneMediaConfig(r151, CollectionsKt.arrayListOf(new MediaConfig[]{new MediaConfig(r110, r116)}), false, "View_G_FeishuMinutes"))});
    }

    public final List<Scene> a() {
        ArrayList r100 = new ArrayList();
        Scene r101 = this.f431638g;
        if (r101 == null) goto L5;
        r100.add(r101);
    L5:
        Iterator r102 = ((EnumMap) this.f431644m).values().iterator();
    L7:
        if (r102.hasNext() == false) goto L14;
        Scene r103 = (Scene) r102.next();
        if (r103 == null) goto L7;
        if (r100.contains(r103) == true) goto L7;
        r100.add(r103);
        goto L7
    L14:
        if (r100.isEmpty() == false) goto L24;
        return null;
    L24:
        return r100;
    }

    public final String c(Scene r100) {
        Iterator r101 = ((HashMap) this.f431633b).entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        Map.Entry r102 = (Map.Entry) r101.next();
        if (r100 != r102.getValue()) goto L4;
        return (String) r102.getKey();
    L9:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final ArrayList<String> d(Scene r100) {
        ArrayList<String> r101 = new ArrayList();
        Iterator r102 = ((HashMap) this.f431633b).entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        Map.Entry r103 = (Map.Entry) r102.next();
        if (r100 != r103.getValue()) goto L4;
        r101.add(r103.getKey());
        goto L4
    L8:
        return r101;
    }

    public final Priority b(Scene r100, MediaType r101) {
        if (r100 != null) goto L5;
        return null;
    L5:
        SceneMediaConfig r102 = this.f431648q.get(r100);
        if (r102 == null) goto L16;
        ArrayList<MediaConfig> r103 = r102.getMediaConfig();
        if (r103 == null) goto L16;
        Iterator<MediaConfig> r104 = r103.iterator();
    L11:
        if (r104.hasNext() == false) goto L16;
        MediaConfig r105 = r104.next();
        if (r105.getType() != r101) goto L11;
        return r105.getPriority();
    L16:
        return null;
    }

    public final boolean e(Scene r100, MediaType r101) {
        SceneMediaConfig r102 = this.f431648q.get(r100);
        if (r102 == null) goto L13;
        ArrayList<MediaConfig> r103 = r102.getMediaConfig();
        if (r103 == null) goto L18;
        Iterator<MediaConfig> r104 = r103.iterator();
    L8:
        if (r104.hasNext() == false) goto L19;
        if (r104.next().getType() != r101) goto L8;
        return true;
    L19:
        return false;
    L18:
        return false;
    L13:
        return false;
    }

    public final void g(Scene r100, String r101) {
        ArrayList<String> r102 = (ArrayList) ((HashMap) this.f431642k).get(r101);
        boolean r103 = false;
        if (r102 == null) goto L18;
        Iterator r104 = ((HashMap) this.f431632a).entrySet().iterator();
    L6:
        if (r104.hasNext() == false) goto L18;
        Map.Entry r105 = (Map.Entry) r104.next();
        String r106 = (String) r105.getKey();
        WeakReference r107 = (WeakReference) r105.getValue();
        if (r102.contains(r106) == false) goto L6;
        Scene r108 = (Scene) ((HashMap) this.f431633b).get(r101);
        MediaType r109 = MediaType.Audio_Play;
        if (e(r108, r109) == false) goto L6;
        com.ss.android.lark.media.a r110 = (com.ss.android.lark.media.a) r107.get();
        if (r110 == null) goto L14;
        r110.c(r100, r109);
    L14:
        this.f431636e = r102;
        ArrayList<Scene> r111 = (ArrayList) ((EnumMap) this.f431645n).get(r100);
        if (r111 == null) goto L17;
        this.f431639h = r111;
    L17:
        r103 = true;
    L18:
        if (r103 == true) goto L28;
        this.f431636e.remove(r101);
        this.f431639h.remove(r100);
        return;
    }

    public final void h(Scene r100, com.ss.android.lark.media.a r101) {
        StringBuilder r102 = new StringBuilder();
        r102.append(r100);
        r102.append(r101.hashCode());
        String r103 = r102.toString();
        String r104 = this.f431635d;
        if (r104 == null) goto L9;
        ((HashMap) this.f431641j).put(r103, r104);
        Map<Scene, Scene> r105 = this.f431644m;
        EnumMap r106 = (EnumMap) r105;
        r106.put(r100, this.f431638g);
        MediaType r107 = MediaType.Audio_Record;
        WeakReference r108 = (WeakReference) ((HashMap) this.f431632a).get(r104);
        if (r108 == null) goto L9;
        com.ss.android.lark.media.a r109 = (com.ss.android.lark.media.a) r108.get();
        if (r109 == null) goto L9;
        r109.b(r100, r107);
    L9:
        this.f431635d = r103;
        this.f431638g = r100;
    }

    public final void i(Scene r100, String r101) {
        String r102 = (String) ((HashMap) this.f431641j).get(r101);
        boolean r103 = false;
        if (r102 == null) goto L15;
        Iterator r104 = ((HashMap) this.f431632a).entrySet().iterator();
    L6:
        if (r104.hasNext() == false) goto L15;
        Map.Entry r105 = (Map.Entry) r104.next();
        String r106 = (String) r105.getKey();
        WeakReference r107 = (WeakReference) r105.getValue();
        if (Intrinsics.areEqual(r106, r102) == false) goto L6;
        Scene r108 = (Scene) ((HashMap) this.f431633b).get(r101);
        MediaType r109 = MediaType.Audio_Record;
        if (e(r108, r109) == false) goto L6;
        com.ss.android.lark.media.a r110 = (com.ss.android.lark.media.a) r107.get();
        if (r110 == null) goto L14;
        r110.c(r100, r109);
    L14:
        this.f431635d = r102;
        this.f431638g = (Scene) ((EnumMap) this.f431644m).get(r100);
        r103 = true;
    L15:
        if (r103 == true) goto L25;
        this.f431635d = null;
        this.f431638g = null;
        return;
    }

    public final void j(Scene r100, com.ss.android.lark.media.a r101) {
        StringBuilder r102 = new StringBuilder();
        r102.append(r100);
        r102.append(r101.hashCode());
        String r103 = r102.toString();
        String r104 = this.f431634c;
        if (r104 == null) goto L9;
        ((HashMap) this.f431640i).put(r103, r104);
        Map<Scene, Scene> r105 = this.f431643l;
        EnumMap r106 = (EnumMap) r105;
        r106.put(r100, this.f431637f);
        MediaType r107 = MediaType.Camera;
        WeakReference r108 = (WeakReference) ((HashMap) this.f431632a).get(r104);
        if (r108 == null) goto L9;
        com.ss.android.lark.media.a r109 = (com.ss.android.lark.media.a) r108.get();
        if (r109 == null) goto L9;
        r109.b(r100, r107);
    L9:
        this.f431634c = r103;
        this.f431637f = r100;
    }

    public final void k(Scene r100, String r101) {
        String r102 = (String) ((HashMap) this.f431640i).get(r101);
        boolean r103 = false;
        if (r102 == null) goto L15;
        Iterator r104 = ((HashMap) this.f431632a).entrySet().iterator();
    L6:
        if (r104.hasNext() == false) goto L15;
        Map.Entry r105 = (Map.Entry) r104.next();
        String r106 = (String) r105.getKey();
        WeakReference r107 = (WeakReference) r105.getValue();
        if (Intrinsics.areEqual(r106, r102) == false) goto L6;
        Scene r108 = (Scene) ((HashMap) this.f431633b).get(r101);
        MediaType r109 = MediaType.Camera;
        if (e(r108, r109) == false) goto L6;
        com.ss.android.lark.media.a r110 = (com.ss.android.lark.media.a) r107.get();
        if (r110 == null) goto L14;
        r110.c(r100, r109);
    L14:
        this.f431634c = r102;
        this.f431637f = (Scene) ((EnumMap) this.f431643l).get(r100);
        r103 = true;
    L15:
        if (r103 == true) goto L25;
        this.f431634c = null;
        this.f431637f = null;
        return;
    }

    public final boolean m(MediaConfig r100, com.ss.android.lark.media.a r101) {
        Priority r102 = b(this.f431637f, MediaType.Camera);
        Iterator r103 = ((HashMap) this.f431646o).keySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L10;
        String r104 = (String) r103.next();
        Scene r105 = this.f431637f;
        if (r105 == null) goto L4;
        if (StringsKt.startsWith$default(r104, String.valueOf(r105), false, 2, null) == false) goto L4;
        r102 = (Priority) ((HashMap) this.f431646o).get(r104);
        goto L4
    L10:
        if (r102 != null) goto L12;
    L17:
        boolean r106 = true;
    L18:
        if (r106 == true) goto L23;
        Scene r107 = this.f431637f;
        if (r107 == null) goto L23;
        MediaType.a r108 = MediaType.Companion;
        r101.a(new LockError(r107, ""));
        return false;
    L23:
        return r106;
    L12:
        if (r102.compareTo(r100.getPriority()) <= 0) goto L14;
    L16:
        r106 = false;
        goto L18
    L14:
        if (r102 == Priority.High) goto L16;
        goto L16
    }

    public final void n(Scene r100, com.ss.android.lark.media.a r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        monitor-enter(this);
        o(r100, r101);     // Catch: Throwable -> L72
        SceneMediaConfig r102 = this.f431648q.get(r100);     // Catch: Throwable -> L72
        if (r102 == null) goto L49;
        ArrayList<MediaConfig> r103 = r102.getMediaConfig();     // Catch: Throwable -> L72
        if (r103 == null) goto L49;
        Iterator<MediaConfig> r104 = r103.iterator();     // Catch: Throwable -> L72
    L10:
        if (r104.hasNext() == false) goto L49;
        MediaType r105 = r104.next().getType();     // Catch: Throwable -> L72
        int r106 = b.f431649a[r105.ordinal()];     // Catch: Throwable -> L72
        if (r106 != 1) goto L13;
        if (r101 == null) goto L41;
    L45:
        if (r101 == null) goto L10;
        StringBuilder r107 = new StringBuilder();     // Catch: Throwable -> L72
        r107.append(r100);     // Catch: Throwable -> L72
        r107.append(r101.hashCode());     // Catch: Throwable -> L72
        String r108 = r107.toString();     // Catch: Throwable -> L72
        if (TextUtils.equals(this.f431634c, r108) == false) goto L10;
        k(r100, r108);     // Catch: Throwable -> L72
        ((HashMap) this.f431646o).remove(r108);     // Catch: Throwable -> L72
        goto L10
    L41:
        if (this.f431637f != r100) goto L45;
        String r109 = c(r100);     // Catch: Throwable -> L72
        if (r109 == null) goto L45;
        k(r100, r109);     // Catch: Throwable -> L72
        Priority r110 = (Priority) ((HashMap) this.f431646o).remove(r109);     // Catch: Throwable -> L72
        goto L45
    L13:
        if (r106 != 2) goto L15;
        if (r101 == null) goto L31;
    L35:
        if (r101 == null) goto L10;
        StringBuilder r111 = new StringBuilder();     // Catch: Throwable -> L72
        r111.append(r100);     // Catch: Throwable -> L72
        r111.append(r101.hashCode());     // Catch: Throwable -> L72
        String r112 = r111.toString();     // Catch: Throwable -> L72
        if (TextUtils.equals(this.f431635d, r112) == false) goto L10;
        i(r100, r112);     // Catch: Throwable -> L72
        goto L10
    L31:
        if (this.f431638g != r100) goto L35;
        String r113 = c(r100);     // Catch: Throwable -> L72
        if (r113 == null) goto L35;
        i(r100, r113);     // Catch: Throwable -> L72
        goto L35
    L15:
        if (r106 != 3) goto L28;
        if (r101 == null) goto L18;
    L23:
        if (r101 == null) goto L10;
        StringBuilder r114 = new StringBuilder();     // Catch: Throwable -> L72
        r114.append(r100);     // Catch: Throwable -> L72
        r114.append(r101.hashCode());     // Catch: Throwable -> L72
        String r115 = r114.toString();     // Catch: Throwable -> L72
        if (this.f431636e.contains(r115) == false) goto L10;
        g(r100, r115);     // Catch: Throwable -> L72
        goto L10
    L18:
        if (this.f431639h.contains(r100) == false) goto L23;
        Iterator<String> r116 = d(r100).iterator();     // Catch: Throwable -> L72
    L21:
        if (r116.hasNext() == false) goto L23;
        g(r100, r116.next());     // Catch: Throwable -> L72
        goto L21
    L28:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L72
    L49:
        Iterator r117 = ((HashMap) this.f431646o).keySet().iterator();     // Catch: Throwable -> L72
    L51:
        if (r117.hasNext() == false) goto L61;
        String r118 = (String) r117.next();     // Catch: Throwable -> L72
        if (r100 == null) goto L51;
        if (StringsKt.startsWith$default(r118, r100.toString(), false, 2, null) == false) goto L51;
        if (((Priority) ((HashMap) this.f431646o).get(r118)) == null) goto L51;
        String r119 = c(r100);     // Catch: Throwable -> L72
        if (r119 == null) goto L51;
        k(r100, r119);     // Catch: Throwable -> L72
        goto L51
    L61:
        if (r101 != null) goto L69;
        ArrayList<String> r120 = d(r100);     // Catch: Throwable -> L72
        HashMap r121 = new HashMap();     // Catch: Throwable -> L72
        r121.putAll(this.f431633b);     // Catch: Throwable -> L72
        ((HashMap) this.f431633b).clear();     // Catch: Throwable -> L72
        Iterator r122 = r121.entrySet().iterator();     // Catch: Throwable -> L72
    L64:
        if (r122.hasNext() == false) goto L68;
        Map.Entry r123 = (Map.Entry) r122.next();     // Catch: Throwable -> L72
        if (r120.contains(r123.getKey()) == true) goto L64;
        Map<String, Scene> r124 = this.f431633b;     // Catch: Throwable -> L72
        HashMap r125 = (HashMap) r124;     // Catch: Throwable -> L72
        r125.put(r123.getKey(), r123.getValue());     // Catch: Throwable -> L72
        goto L64
    L68:
        Unit r126 = Unit.INSTANCE;     // Catch: Throwable -> L72
    L70:
        monitor-exit(this);
        return;
    L69:
        StringBuilder r127 = new StringBuilder();     // Catch: Throwable -> L72
        r127.append(r100);     // Catch: Throwable -> L72
        r127.append(r101.hashCode());     // Catch: Throwable -> L72
        String r128 = r127.toString();     // Catch: Throwable -> L72
        ((HashMap) this.f431633b).remove(r128);     // Catch: Throwable -> L72
    L72:
        th = move-exception;
        throw th;
    }

    public final void o(Scene r100, com.ss.android.lark.media.a r101) {
        StringBuilder r102 = new StringBuilder();
        r102.append(r100);
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        r102.append(r103);
        String r104 = r102.toString();
        ((HashMap) this.f431632a).remove(r104);
        return;
    L5:
        r103 = 0;
        goto L6
    }

    public final void f(Scene r100, boolean r101, com.ss.android.lark.media.a r102) {
        StringBuilder r103 = new StringBuilder();
        r103.append(r100);
        r103.append(r102.hashCode());
        String r104 = r103.toString();
        if (r101 == true) goto L17;
        ArrayList<String> r105 = this.f431636e;
        if (r105 == null) goto L14;
        ArrayList r106 = new ArrayList();
        r106.addAll(r105);
        ((HashMap) this.f431642k).put(r104, r106);
        ArrayList r107 = new ArrayList();
        r107.addAll(this.f431639h);
        ((EnumMap) this.f431645n).put(r100, r107);
        MediaType.a r108 = MediaType.Companion;
        Iterator<String> r109 = r105.iterator();
    L8:
        if (r109.hasNext() == false) goto L14;
        String r110 = r109.next();
        WeakReference r111 = (WeakReference) ((HashMap) this.f431632a).get(r110);
        if (r111 == null) goto L8;
        com.ss.android.lark.media.a r112 = (com.ss.android.lark.media.a) r111.get();
        if (r112 == null) goto L8;
        r112.b(r100, MediaType.Audio_Play);
    L14:
        this.f431636e.clear();
        ArrayList<Scene> r113 = this.f431639h;
        if (r113 == null) goto L17;
        r113.clear();
    L17:
        this.f431636e.add(r104);
        ArrayList<Scene> r114 = this.f431639h;
        if (r114 == null) goto L28;
        r114.add(r100);
        return;
    }

    public final void l(Scene r110, boolean r111, com.ss.android.lark.media.a r210, boolean r211) {
        Intrinsics.checkNotNullParameter(r110, "scene");
        Intrinsics.checkNotNullParameter(r210, "listener");
        monitor-enter(this);
        StringBuilder r100 = new StringBuilder();     // Catch: Throwable -> L139
        r100.append(r110);     // Catch: Throwable -> L139
        r100.append(r210.hashCode());     // Catch: Throwable -> L139
        String r101 = r100.toString();     // Catch: Throwable -> L139
        Map<String, WeakReference<com.ss.android.lark.media.a>> r102 = this.f431632a;     // Catch: Throwable -> L139
        HashMap r103 = (HashMap) r102;     // Catch: Throwable -> L139
        r103.put(r101, new WeakReference(r210));     // Catch: Throwable -> L139
        SceneMediaConfig r104 = this.f431648q.get(r110);     // Catch: Throwable -> L139
        Ref.BooleanRef r105 = new Ref.BooleanRef();     // Catch: Throwable -> L139
        r105.element = true;     // Catch: Throwable -> L139
        StringBuilder r106 = new StringBuilder();     // Catch: Throwable -> L139
        r106.append(r110);     // Catch: Throwable -> L139
        r106.append(r210.hashCode());     // Catch: Throwable -> L139
        String r107 = r106.toString();     // Catch: Throwable -> L139
        ((HashMap) this.f431633b).put(r107, r110);     // Catch: Throwable -> L139
        int r108 = 3;
        if (r104 == null) goto L40;
        ArrayList<MediaConfig> r112 = r104.getMediaConfig();     // Catch: Throwable -> L139
        if (r112 == null) goto L40;
        Iterator<MediaConfig> r113 = r112.iterator();     // Catch: Throwable -> L139
    L10:
        if (r113.hasNext() == false) goto L40;
        MediaType r114 = r113.next().getType();     // Catch: Throwable -> L139
        int r115 = b.f431649a[r114.ordinal()];     // Catch: Throwable -> L139
        if (r115 != 1) goto L13;
        if (r211 == false) goto L10;
        if (r105.element == true) goto L35;
    L37:
        boolean r116 = false;
    L38:
        r105.element = r116;     // Catch: Throwable -> L139
        goto L10
    L35:
        if (TextUtils.equals(r107, this.f431634c) == false) goto L37;
        r116 = true;
        goto L38
    L13:
        if (r115 != 2) goto L14;
        if (r105.element == true) goto L27;
    L29:
        boolean r117 = false;
    L30:
        r105.element = r117;     // Catch: Throwable -> L139
        goto L10
    L27:
        if (TextUtils.equals(r107, this.f431635d) == false) goto L29;
        r117 = true;
        goto L30
    L14:
        if (r115 != 3) goto L23;
        if (r105.element == true) goto L18;
    L20:
        boolean r118 = false;
    L21:
        r105.element = r118;     // Catch: Throwable -> L139
        goto L10
    L18:
        if (this.f431636e.contains(r107) == false) goto L20;
        r118 = true;
        goto L21
    L23:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L139
    L40:
        if (r105.element == false) goto L44;
        r210.onSuccess();     // Catch: Throwable -> L139
        monitor-exit(this);
        return;
    L44:
        if (r104 == null) goto L137;
        ArrayList<MediaConfig> r109 = r104.getMediaConfig();     // Catch: Throwable -> L139
        if (r109 == null) goto L137;
        Iterator<MediaConfig> r119 = r109.iterator();     // Catch: Throwable -> L139
        boolean r120 = r111;
        boolean r121 = false;
        boolean r122 = false;
        boolean r123 = false;
    L49:
        if (r119.hasNext() == false) goto L130;
        MediaConfig r124 = r119.next();     // Catch: Throwable -> L139
        MediaType r125 = r124.getType();     // Catch: Throwable -> L139
        int r126 = b.f431649a[r125.ordinal()];     // Catch: Throwable -> L139
        if (r126 == 1) goto L120;
        if (r126 == 2) goto L100;
        if (r126 != r108) goto L98;
        if (this.f431636e.contains(r107) == true) goto L129;
        Iterator<Scene> r127 = this.f431639h.iterator();     // Catch: Throwable -> L139
    L59:
        if (r127.hasNext() == false) goto L93;
        Scene r128 = r127.next();     // Catch: Throwable -> L139
        if (r120 == false) goto L70;
        SceneMediaConfig r129 = this.f431648q.get(r128);     // Catch: Throwable -> L139
        if (r129 != null) goto L65;
    L67:
        boolean r130 = false;
    L68:
        if (r130 == false) goto L70;
        r120 = true;
    L71:
        Priority r131 = b(r128, MediaType.Audio_Play);     // Catch: Throwable -> L139
        if (r131 != null) goto L74;
    L87:
        boolean r132 = true;
    L88:
        if (r132 == true) goto L59;
        r210.a(new LockError(r128, ""));     // Catch: Throwable -> L139
        o(r110, r210);     // Catch: Throwable -> L139
        monitor-exit(this);
        return;
    L74:
        if (r131.compareTo(r124.getPriority()) <= 0) goto L76;
    L77:
        if (r111 == false) goto L86;
        SceneMediaConfig r133 = this.f431648q.get(r128);     // Catch: Throwable -> L139
        if (r133 != null) goto L81;
    L83:
        boolean r134 = false;
    L84:
        if (r134 == false) goto L86;
    L81:
        if (r133.getMixWithOthers() != true) goto L83;
        r134 = true;
    L86:
        r132 = false;
        goto L88
    L76:
        if (r131 != Priority.High) goto L87;
    L65:
        if (r129.getMixWithOthers() != true) goto L67;
        r130 = true;
    L70:
        r120 = false;
        goto L71
    L93:
        SceneMediaConfig r135 = this.f431648q.get(r110);     // Catch: Throwable -> L139
        if (r135 == null) goto L96;
        r135.setMixWithOthers(r111);     // Catch: Throwable -> L139
    L96:
        r108 = 3;
        r123 = true;
    L129:
        r108 = 3;
        goto L49
    L98:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L139
    L100:
        if (TextUtils.equals(r107, this.f431635d) == true) goto L129;
        Scene.a r136 = Scene.Companion;     // Catch: Throwable -> L139
        Priority r137 = b(this.f431638g, MediaType.Audio_Record);     // Catch: Throwable -> L139
        if (r137 != null) goto L105;
    L110:
        boolean r138 = true;
    L111:
        if (r138 == true) goto L115;
        Scene r139 = this.f431638g;     // Catch: Throwable -> L139
        if (r139 == null) goto L115;
        r210.a(new LockError(r139, ""));     // Catch: Throwable -> L139
        r122 = false;
    L116:
        if (r122 == true) goto L129;
        o(r110, r210);     // Catch: Throwable -> L139
        monitor-exit(this);
        return;
    L115:
        r122 = r138;
        goto L116
    L105:
        if (r137.compareTo(r124.getPriority()) <= 0) goto L107;
    L109:
        r138 = false;
        goto L111
    L107:
        if (r137 == Priority.High) goto L109;
    L120:
        if (r211 == false) goto L129;
        if (TextUtils.equals(r107, this.f431634c) == true) goto L129;
        r121 = m(r124, r210);     // Catch: Throwable -> L139
        if (r121 == true) goto L129;
        o(r110, r210);     // Catch: Throwable -> L139
        monitor-exit(this);
        return;
    L130:
        if (r121 == false) goto L132;
        j(r110, r210);     // Catch: Throwable -> L139
    L132:
        if (r122 == false) goto L134;
        h(r110, r210);     // Catch: Throwable -> L139
    L134:
        if (r123 == false) goto L136;
        f(r110, r120, r210);     // Catch: Throwable -> L139
    L136:
        r210.onSuccess();     // Catch: Throwable -> L139
        Unit r140 = Unit.INSTANCE;     // Catch: Throwable -> L139
    L137:
        monitor-exit(this);
        return;
    L139:
        th = move-exception;
        throw th;
    }
}
