package com.ss.android.lark.media;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u001d\b\u0086\u0081\u0002\u0018\u0000 \u001f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001e¨\u0006 "}, d2 = {"Lcom/ss/android/lark/media/Scene;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "VC_MEETING", "VC_RINGING", "VOIP_MEETING", "VOIP_RINGING", "Minutes_Record", "Minutes_Play", "IM_Video_Record", "IM_Audio_Record", "IM_Audio_Play", "IM_Video_Play", "IM_Camera", "Little_App_Audio_Play", "Little_App_Scan", "Little_App_Audio_Record", "Little_App_Video_Record", "CCM_Audio_Record", "CCM_Video_Record", "CCM_Photo", "CCM_Audio_Play", "VC_RING_TONE", "NOTIFICATION_PLAY", "VC_VOICE_PRINT_RECORD", "DOUBAO_RECORD", "Companion", "lark-media_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum Scene extends Enum<Scene> {
    public static final Scene CCM_Audio_Play = null;
    public static final Scene CCM_Audio_Record = null;
    public static final Scene CCM_Photo = null;
    public static final Scene CCM_Video_Record = null;
    public static final a Companion = null;
    public static final Scene DOUBAO_RECORD = null;
    public static final Scene IM_Audio_Play = null;
    public static final Scene IM_Audio_Record = null;
    public static final Scene IM_Camera = null;
    public static final Scene IM_Video_Play = null;
    public static final Scene IM_Video_Record = null;
    public static final Scene Little_App_Audio_Play = null;
    public static final Scene Little_App_Audio_Record = null;
    public static final Scene Little_App_Scan = null;
    public static final Scene Little_App_Video_Record = null;
    public static final Scene Minutes_Play = null;
    public static final Scene Minutes_Record = null;
    public static final Scene NOTIFICATION_PLAY = null;
    public static final Scene VC_MEETING = null;
    public static final Scene VC_RINGING = null;
    public static final Scene VC_RING_TONE = null;
    public static final Scene VC_VOICE_PRINT_RECORD = null;
    public static final Scene VOIP_MEETING = null;
    public static final Scene VOIP_RINGING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Scene[] f431654a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f431655b = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<Scene> getEntries() {
        return f431655b;
    }

    static {
        Scene r100 = new Scene("VC_MEETING", 0, 0);
        VC_MEETING = r100;
        Scene r101 = new Scene("VC_RINGING", 1, 1);
        VC_RINGING = r101;
        Scene r102 = new Scene("VOIP_MEETING", 2, 2);
        VOIP_MEETING = r102;
        Scene r103 = new Scene("VOIP_RINGING", 3, 3);
        VOIP_RINGING = r103;
        Scene r104 = new Scene("Minutes_Record", 4, 4);
        Minutes_Record = r104;
        Scene r105 = new Scene("Minutes_Play", 5, 5);
        Minutes_Play = r105;
        Scene r110 = new Scene("IM_Video_Record", 6, 6);
        IM_Video_Record = r110;
        Scene r111 = new Scene("IM_Audio_Record", 7, 7);
        IM_Audio_Record = r111;
        Scene r112 = new Scene("IM_Audio_Play", 8, 8);
        IM_Audio_Play = r112;
        Scene r113 = new Scene("IM_Video_Play", 9, 9);
        IM_Video_Play = r113;
        Scene r114 = new Scene("IM_Camera", 10, 10);
        IM_Camera = r114;
        Scene r115 = new Scene("Little_App_Audio_Play", 11, 11);
        Little_App_Audio_Play = r115;
        Scene r106 = new Scene("Little_App_Scan", 12, 12);
        Little_App_Scan = r106;
        Scene r107 = new Scene("Little_App_Audio_Record", 13, 13);
        Little_App_Audio_Record = r107;
        Scene r108 = new Scene("Little_App_Video_Record", 14, 14);
        Little_App_Video_Record = r108;
        Scene r109 = new Scene("CCM_Audio_Record", 15, 15);
        CCM_Audio_Record = r109;
        Scene r116 = new Scene("CCM_Video_Record", 16, 16);
        CCM_Video_Record = r116;
        Scene r117 = new Scene("CCM_Photo", 17, 17);
        CCM_Photo = r117;
        Scene r118 = new Scene("CCM_Audio_Play", 18, 18);
        CCM_Audio_Play = r118;
        Scene r119 = new Scene("VC_RING_TONE", 19, 19);
        VC_RING_TONE = r119;
        Scene r120 = new Scene("NOTIFICATION_PLAY", 20, 20);
        NOTIFICATION_PLAY = r120;
        Scene r121 = new Scene("VC_VOICE_PRINT_RECORD", 21, 21);
        VC_VOICE_PRINT_RECORD = r121;
        Scene r122 = new Scene("DOUBAO_RECORD", 22, 22);
        DOUBAO_RECORD = r122;
        Scene[] r123 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119, r120, r121, r122};
        f431654a = r123;
        f431655b = EnumEntriesKt.enumEntries(r123);
        Companion = new a();
    }

    public static Scene[] values() {
        return (Scene[]) f431654a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static Scene valueOf(String r100) {
        return (Scene) r27.a.a(Scene.class, r100);
    }

    public Scene(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
