package com.obric.trace;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u001c\b\u0086\u0081\u0002\u0018\u0000  2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001 B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001f¨\u0006!"}, d2 = {"Lcom/obric/trace/ObricActionBarTrackType;", "", "stringValue", "", "intValue", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;I)V", "getStringValue", "()Ljava/lang/String;", "getIntValue", "()I", "NA", "COCO_INSTRUCTION", "OBRIC_WEB_PERCEPTION", "OBRIC_VIDEO_PERCEPTION", "OBRIC_DOCUMENT_PERCEPTION", "OBRIC_SCREEN_QA", "OBRIC_PHOTO_PERCEPTION", "OBRIC_IM_PERCEPTION", "OBRIC_OAUTO", "OBRIC_COMPLEX_TASK", "OBRIC_QUICK_INSTRUCTION", "OBRIC_OMNI_ALL_SKILLS", "OBRIC_PICTURE_DYNAMIC", "OBRIC_TEXT_TRANSLATION", "OBRIC_EXTRACT_TEXT", "OBRIC_WHATS_THIS", "OBRIC_ADJUST_COPYWRITING", "OBRIC_PICTURE_QA", "OBRIC_IM_SCREEN_QA", "OBRIC_AI_BEAUTIFY", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ObricActionBarTrackType extends Enum<ObricActionBarTrackType> {
    public static final ObricActionBarTrackType COCO_INSTRUCTION = null;
    public static final a Companion = null;
    public static final String EVENT_SEND_MESSAGE_STATUS = "send_message_status";
    public static final String KEY_ACTION_BAR_KEY = "action_bar_key";
    public static final String KEY_ACTION_BAR_TEMPLATE_ID = "action_bar_template_id";
    public static final String KEY_BOARD = "keyboard";
    public static final String KEY_IS_FROM_OBRIC_ACTION_BAR = "is_from_obric_action_bar";
    public static final String KEY_SCENE = "scene";
    public static final String KEY_SHOW_POSITION = "show_position";
    public static final ObricActionBarTrackType NA = null;
    public static final ObricActionBarTrackType OBRIC_ADJUST_COPYWRITING = null;
    public static final ObricActionBarTrackType OBRIC_AI_BEAUTIFY = null;
    public static final String OBRIC_CLICK_SPEAK = "obric_click_speak";
    public static final ObricActionBarTrackType OBRIC_COMPLEX_TASK = null;
    public static final ObricActionBarTrackType OBRIC_DOCUMENT_PERCEPTION = null;
    public static final ObricActionBarTrackType OBRIC_EXTRACT_TEXT = null;
    public static final ObricActionBarTrackType OBRIC_IM_PERCEPTION = null;
    public static final ObricActionBarTrackType OBRIC_IM_SCREEN_QA = null;
    public static final ObricActionBarTrackType OBRIC_OAUTO = null;
    public static final ObricActionBarTrackType OBRIC_OMNI_ALL_SKILLS = null;
    public static final ObricActionBarTrackType OBRIC_PHOTO_PERCEPTION = null;
    public static final ObricActionBarTrackType OBRIC_PICTURE_DYNAMIC = null;
    public static final ObricActionBarTrackType OBRIC_PICTURE_QA = null;
    public static final ObricActionBarTrackType OBRIC_QUICK_INSTRUCTION = null;
    public static final ObricActionBarTrackType OBRIC_SCREEN_QA = null;
    public static final ObricActionBarTrackType OBRIC_TEXT_TRANSLATION = null;
    public static final ObricActionBarTrackType OBRIC_VIDEO_PERCEPTION = null;
    public static final ObricActionBarTrackType OBRIC_WEB_PERCEPTION = null;
    public static final ObricActionBarTrackType OBRIC_WHATS_THIS = null;
    public static final String SPEAK = "speak";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy<Set<String>> f404030a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f404031b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ ObricActionBarTrackType[] f404032c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f404033d = null;
    private final int intValue;
    private final String stringValue;

    public static final class a {
        public static Set b() {
            return (Set) ObricActionBarTrackType.access$getObricActionBarTrackTypeSet$delegate$cp().getValue();
        }

        public a() {
        }

        public static Integer a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "actionBarKey");
            ObricActionBarTrackType[] r101 = ObricActionBarTrackType.values();
            int r102 = r101.length;
            int r103 = 0;
        L4:
            if (r103 >= r102) goto L9;
            ObricActionBarTrackType r104 = r101[r103];
            if (Intrinsics.areEqual(r104.getStringValue(), r100) == true) goto L10;
            r103 = r103 + 1;
        L10:
            if (r104 != null) goto L12;
            return null;
        L12:
            return Integer.valueOf(r104.getIntValue());
        L9:
            r104 = null;
            goto L10
        }
    }

    public static EnumEntries<ObricActionBarTrackType> getEntries() {
        return f404033d;
    }

    static {
        ObricActionBarTrackType r100 = new ObricActionBarTrackType("NA", 0, "obric_na", -1);
        NA = r100;
        ObricActionBarTrackType r101 = new ObricActionBarTrackType("COCO_INSTRUCTION", 1, "coco_instruction", -2);
        COCO_INSTRUCTION = r101;
        ObricActionBarTrackType r102 = new ObricActionBarTrackType("OBRIC_WEB_PERCEPTION", 2, "obric_web_perception", 10000);
        OBRIC_WEB_PERCEPTION = r102;
        ObricActionBarTrackType r103 = new ObricActionBarTrackType("OBRIC_VIDEO_PERCEPTION", 3, "obric_video_perception", 10014);
        OBRIC_VIDEO_PERCEPTION = r103;
        ObricActionBarTrackType r104 = new ObricActionBarTrackType("OBRIC_DOCUMENT_PERCEPTION", 4, "obric_document_perception", 10001);
        OBRIC_DOCUMENT_PERCEPTION = r104;
        ObricActionBarTrackType r105 = new ObricActionBarTrackType("OBRIC_SCREEN_QA", 5, "obric_screen_qa", 10002);
        OBRIC_SCREEN_QA = r105;
        ObricActionBarTrackType r110 = new ObricActionBarTrackType("OBRIC_PHOTO_PERCEPTION", 6, "obric_photo_perception", 4);
        OBRIC_PHOTO_PERCEPTION = r110;
        ObricActionBarTrackType r111 = new ObricActionBarTrackType("OBRIC_IM_PERCEPTION", 7, "obric_im_perception", 10009);
        OBRIC_IM_PERCEPTION = r111;
        ObricActionBarTrackType r106 = new ObricActionBarTrackType("OBRIC_OAUTO", 8, "obric_oauto", 10011);
        OBRIC_OAUTO = r106;
        ObricActionBarTrackType r107 = new ObricActionBarTrackType("OBRIC_COMPLEX_TASK", 9, "obric_omni", 10013);
        OBRIC_COMPLEX_TASK = r107;
        ObricActionBarTrackType r108 = new ObricActionBarTrackType("OBRIC_QUICK_INSTRUCTION", 10, "obric_quick_instruction", 10015);
        OBRIC_QUICK_INSTRUCTION = r108;
        ObricActionBarTrackType r109 = new ObricActionBarTrackType("OBRIC_OMNI_ALL_SKILLS", 11, "obric_omni_all_skills", 10017);
        OBRIC_OMNI_ALL_SKILLS = r109;
        ObricActionBarTrackType r112 = new ObricActionBarTrackType("OBRIC_PICTURE_DYNAMIC", 12, "obric_picture_dynamic", 18);
        OBRIC_PICTURE_DYNAMIC = r112;
        ObricActionBarTrackType r113 = new ObricActionBarTrackType("OBRIC_TEXT_TRANSLATION", 13, "obric_text_translation", 10005);
        OBRIC_TEXT_TRANSLATION = r113;
        ObricActionBarTrackType r114 = new ObricActionBarTrackType("OBRIC_EXTRACT_TEXT", 14, "obric_extract_text", 10006);
        OBRIC_EXTRACT_TEXT = r114;
        ObricActionBarTrackType r115 = new ObricActionBarTrackType("OBRIC_WHATS_THIS", 15, "obric_whats_this", 10007);
        OBRIC_WHATS_THIS = r115;
        ObricActionBarTrackType r116 = new ObricActionBarTrackType("OBRIC_ADJUST_COPYWRITING", 16, "obric_adjust_copywriting", 10008);
        OBRIC_ADJUST_COPYWRITING = r116;
        ObricActionBarTrackType r117 = new ObricActionBarTrackType("OBRIC_PICTURE_QA", 17, "obric_picture_qa", 10010);
        OBRIC_PICTURE_QA = r117;
        ObricActionBarTrackType r118 = new ObricActionBarTrackType("OBRIC_IM_SCREEN_QA", 18, "obric_im_screen_qa", 10002);
        OBRIC_IM_SCREEN_QA = r118;
        ObricActionBarTrackType r119 = new ObricActionBarTrackType("OBRIC_AI_BEAUTIFY", 19, "obric_ai_beautify", 4);
        OBRIC_AI_BEAUTIFY = r119;
        ObricActionBarTrackType[] r120 = {r100, r101, r102, r103, r104, r105, r110, r111, r106, r107, r108, r109, r112, r113, r114, r115, r116, r117, r118, r119};
        f404032c = r120;
        f404033d = EnumEntriesKt.enumEntries(r120);
        Companion = new a();
        f404030a = LazyKt.lazy(new boa.a());
    }

    public static ObricActionBarTrackType[] values() {
        return (ObricActionBarTrackType[]) f404032c.clone();
    }

    public static Set a() {
        ObricActionBarTrackType[] r100 = values();
        ArrayList r101 = new ArrayList();
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L14;
        ObricActionBarTrackType r104 = r100[r103];
        if (r104 != NA) goto L7;
    L10:
        boolean r105 = true;
    L11:
        if (r105 == true) goto L13;
        r101.add(r104);
    L13:
        r103 = r103 + 1;
        goto L3
    L7:
        if (r104 == COCO_INSTRUCTION) goto L10;
        r105 = false;
        goto L11
    L14:
        ArrayList r106 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator r107 = r101.iterator();
    L16:
        if (r107.hasNext() == false) goto L19;
        r106.add(((ObricActionBarTrackType) r107.next()).stringValue);
        goto L16
    L19:
        return CollectionsKt.toSet(r106);
    }

    public static final /* synthetic */ String access$getActionBarStatus$cp() {
        return f404031b;
    }

    public static final /* synthetic */ Lazy access$getObricActionBarTrackTypeSet$delegate$cp() {
        return f404030a;
    }

    public final int getIntValue() {
        return this.intValue;
    }

    public final String getStringValue() {
        return this.stringValue;
    }

    public static final /* synthetic */ void access$setActionBarStatus$cp(String r100) {
        f404031b = r100;
    }

    public static ObricActionBarTrackType valueOf(String r100) {
        return (ObricActionBarTrackType) r27.a.a(ObricActionBarTrackType.class, r100);
    }

    public ObricActionBarTrackType(String r100, int r101, String r102, int r103) {
        super(r100, r101);
        this.stringValue = r102;
        this.intValue = r103;
    }
}
