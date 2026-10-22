package com.obric.aiagent.assistant.common.ui.icon;

import com.bytedance.android.live.network.annotation.PbRequest;
import com.larus.nova.R;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b@\b\u0086\u0081\u0002\u0018\u0000 D2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001DB\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00058GX\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5j\u0002\b6j\u0002\b7j\u0002\b8j\u0002\b9j\u0002\b:j\u0002\b;j\u0002\b<j\u0002\b=j\u0002\b>j\u0002\b?j\u0002\b@j\u0002\bAj\u0002\bBj\u0002\bC¨\u0006E"}, d2 = {"Lcom/obric/aiagent/assistant/common/ui/icon/TaskResolvedIcon;", "", "key", "", "drawableRes", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;I)V", "getKey", "()Ljava/lang/String;", "getDrawableRes", "()I", "GENERAL_1", "GENERAL_2", "GENERAL_3", "GENERAL_4", "GENERAL_5", "EMOTION_SMILE", "EMOTION_SAD", "EMOTION_ANGRY", "EMOTION_SURPRISED", "EMOTION_LAUGH", "MEDIA_MOVIE", "MEDIA_GAME_1", "MEDIA_GAME_2", "MEDIA_MUSIC", "MEDIA_PHOTO", "MEDIA_VIDEO", "RELATIONSHIP_RUNNING_1", "RELATIONSHIP_RUNNING_2", "RELATIONSHIP_FITNESS_1", "RELATIONSHIP_FITNESS_2", "RELATIONSHIP_FITNESS_3", "RELATIONSHIP_FITNESS_4", "RELATIONSHIP_EXERCISE_1", "RELATIONSHIP_FIGURE", "RELATIONSHIP_PARTY_1", "RELATIONSHIP_PARTY_2", "RELATIONSHIP_PARTY_3", "RELATIONSHIP_PARTY_4", "RELATIONSHIP_SUPPORT", "RELATIONSHIP_PROFILE", "RELATIONSHIP_PRIVATE", "CALENDAR_1", "CALENDAR_2", "CALENDAR_3", "MATERIALS_1", "MATERIALS_2", "MATERIALS_3", "MATERIALS_4", "HEALTH_1", "HEALTH_2", "STUDY_1", "FINANCE_1", "FINANCE_2", "FOOD", "SHOPPING", "TRAVEL_FLY", "BEER", "TRAVEL_TRAIN", "TRAVEL_CAR", "DRINK", "VACATION", "CAKE", "CLOTHES", "BAG", "MILESTONE", "GIFT", "Companion", "assistant-common-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TaskResolvedIcon extends Enum<TaskResolvedIcon> {
    public static final TaskResolvedIcon BAG = null;
    public static final TaskResolvedIcon BEER = null;
    public static final TaskResolvedIcon CAKE = null;
    public static final TaskResolvedIcon CALENDAR_1 = null;
    public static final TaskResolvedIcon CALENDAR_2 = null;
    public static final TaskResolvedIcon CALENDAR_3 = null;
    public static final TaskResolvedIcon CLOTHES = null;
    public static final a Companion = null;
    public static final TaskResolvedIcon DRINK = null;
    public static final TaskResolvedIcon EMOTION_ANGRY = null;
    public static final TaskResolvedIcon EMOTION_LAUGH = null;
    public static final TaskResolvedIcon EMOTION_SAD = null;
    public static final TaskResolvedIcon EMOTION_SMILE = null;
    public static final TaskResolvedIcon EMOTION_SURPRISED = null;
    public static final TaskResolvedIcon FINANCE_1 = null;
    public static final TaskResolvedIcon FINANCE_2 = null;
    public static final TaskResolvedIcon FOOD = null;
    public static final TaskResolvedIcon GENERAL_1 = null;
    public static final TaskResolvedIcon GENERAL_2 = null;
    public static final TaskResolvedIcon GENERAL_3 = null;
    public static final TaskResolvedIcon GENERAL_4 = null;
    public static final TaskResolvedIcon GENERAL_5 = null;
    public static final TaskResolvedIcon GIFT = null;
    public static final TaskResolvedIcon HEALTH_1 = null;
    public static final TaskResolvedIcon HEALTH_2 = null;
    public static final TaskResolvedIcon MATERIALS_1 = null;
    public static final TaskResolvedIcon MATERIALS_2 = null;
    public static final TaskResolvedIcon MATERIALS_3 = null;
    public static final TaskResolvedIcon MATERIALS_4 = null;
    public static final TaskResolvedIcon MEDIA_GAME_1 = null;
    public static final TaskResolvedIcon MEDIA_GAME_2 = null;
    public static final TaskResolvedIcon MEDIA_MOVIE = null;
    public static final TaskResolvedIcon MEDIA_MUSIC = null;
    public static final TaskResolvedIcon MEDIA_PHOTO = null;
    public static final TaskResolvedIcon MEDIA_VIDEO = null;
    public static final TaskResolvedIcon MILESTONE = null;
    public static final TaskResolvedIcon RELATIONSHIP_EXERCISE_1 = null;
    public static final TaskResolvedIcon RELATIONSHIP_FIGURE = null;
    public static final TaskResolvedIcon RELATIONSHIP_FITNESS_1 = null;
    public static final TaskResolvedIcon RELATIONSHIP_FITNESS_2 = null;
    public static final TaskResolvedIcon RELATIONSHIP_FITNESS_3 = null;
    public static final TaskResolvedIcon RELATIONSHIP_FITNESS_4 = null;
    public static final TaskResolvedIcon RELATIONSHIP_PARTY_1 = null;
    public static final TaskResolvedIcon RELATIONSHIP_PARTY_2 = null;
    public static final TaskResolvedIcon RELATIONSHIP_PARTY_3 = null;
    public static final TaskResolvedIcon RELATIONSHIP_PARTY_4 = null;
    public static final TaskResolvedIcon RELATIONSHIP_PRIVATE = null;
    public static final TaskResolvedIcon RELATIONSHIP_PROFILE = null;
    public static final TaskResolvedIcon RELATIONSHIP_RUNNING_1 = null;
    public static final TaskResolvedIcon RELATIONSHIP_RUNNING_2 = null;
    public static final TaskResolvedIcon RELATIONSHIP_SUPPORT = null;
    public static final TaskResolvedIcon SHOPPING = null;
    public static final TaskResolvedIcon STUDY_1 = null;
    public static final TaskResolvedIcon TRAVEL_CAR = null;
    public static final TaskResolvedIcon TRAVEL_FLY = null;
    public static final TaskResolvedIcon TRAVEL_TRAIN = null;
    public static final TaskResolvedIcon VACATION = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, TaskResolvedIcon> f384426a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ TaskResolvedIcon[] f384427b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f384428c = null;
    private final int drawableRes;
    private final String key;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static TaskResolvedIcon a(String r100) {
            String r101 = b(r100);
            if (r101 != null) goto L7;
            return null;
        L7:
            return (TaskResolvedIcon) TaskResolvedIcon.access$getICONS_BY_KEY$cp().get(r101);
        }

        @JvmStatic
        public static String b(String r100) {
            if (r100 == null) goto L6;
            String r101 = StringsKt.trim(r100).toString();
            if (r101 == null) goto L6;
            return r101.toLowerCase(Locale.ROOT);
        L6:
            return null;
        }
    }

    @JvmStatic
    public static final TaskResolvedIcon fromKey(String r100) {
        Companion.getClass();
        return a.a(r100);
    }

    public static EnumEntries<TaskResolvedIcon> getEntries() {
        return f384428c;
    }

    @JvmStatic
    public static final String normalize(String r100) {
        Companion.getClass();
        return a.b(r100);
    }

    static {
        TaskResolvedIcon r100 = new TaskResolvedIcon("GENERAL_1", 0, "general_1", R.drawable.ic_task_icon_general_1);
        GENERAL_1 = r100;
        TaskResolvedIcon r101 = new TaskResolvedIcon("GENERAL_2", 1, "general_2", R.drawable.ic_task_icon_general_2);
        GENERAL_2 = r101;
        TaskResolvedIcon r102 = new TaskResolvedIcon("GENERAL_3", 2, "general_3", R.drawable.ic_task_icon_general_3);
        GENERAL_3 = r102;
        TaskResolvedIcon r103 = new TaskResolvedIcon("GENERAL_4", 3, "general_4", R.drawable.ic_task_icon_general_4);
        GENERAL_4 = r103;
        TaskResolvedIcon r104 = new TaskResolvedIcon("GENERAL_5", 4, "general_5", R.drawable.ic_task_icon_general_5);
        GENERAL_5 = r104;
        TaskResolvedIcon r105 = new TaskResolvedIcon("EMOTION_SMILE", 5, "emotion_smile", R.drawable.ic_task_icon_emotion_smile);
        EMOTION_SMILE = r105;
        TaskResolvedIcon r110 = new TaskResolvedIcon("EMOTION_SAD", 6, "emotion_sad", R.drawable.ic_task_icon_emotion_sad);
        EMOTION_SAD = r110;
        TaskResolvedIcon r111 = new TaskResolvedIcon("EMOTION_ANGRY", 7, "emotion_angry", R.drawable.ic_task_icon_emotion_angry);
        EMOTION_ANGRY = r111;
        TaskResolvedIcon r112 = new TaskResolvedIcon("EMOTION_SURPRISED", 8, "emotion_surprised", R.drawable.ic_task_icon_emotion_surprised);
        EMOTION_SURPRISED = r112;
        TaskResolvedIcon r106 = new TaskResolvedIcon("EMOTION_LAUGH", 9, "emotion_laugh", R.drawable.ic_task_icon_emotion_laugh);
        EMOTION_LAUGH = r106;
        TaskResolvedIcon r107 = new TaskResolvedIcon("MEDIA_MOVIE", 10, "media_movie", R.drawable.ic_task_icon_media_movie);
        MEDIA_MOVIE = r107;
        TaskResolvedIcon r108 = new TaskResolvedIcon("MEDIA_GAME_1", 11, "media_game_1", R.drawable.ic_task_icon_media_game_1);
        MEDIA_GAME_1 = r108;
        TaskResolvedIcon r109 = new TaskResolvedIcon("MEDIA_GAME_2", 12, "media_game_2", R.drawable.ic_task_icon_media_game_2);
        MEDIA_GAME_2 = r109;
        TaskResolvedIcon r113 = new TaskResolvedIcon("MEDIA_MUSIC", 13, "media_music", R.drawable.ic_task_icon_media_music);
        MEDIA_MUSIC = r113;
        TaskResolvedIcon r114 = new TaskResolvedIcon("MEDIA_PHOTO", 14, "media_photo", R.drawable.ic_task_icon_media_photo);
        MEDIA_PHOTO = r114;
        TaskResolvedIcon r115 = new TaskResolvedIcon("MEDIA_VIDEO", 15, "media_video", R.drawable.ic_task_icon_media_video);
        MEDIA_VIDEO = r115;
        TaskResolvedIcon r116 = new TaskResolvedIcon("RELATIONSHIP_RUNNING_1", 16, "relationship_running_1", R.drawable.ic_task_icon_relationship_running_1);
        RELATIONSHIP_RUNNING_1 = r116;
        TaskResolvedIcon r117 = new TaskResolvedIcon("RELATIONSHIP_RUNNING_2", 17, "relationship_running_2", R.drawable.ic_task_icon_relationship_running_2);
        RELATIONSHIP_RUNNING_2 = r117;
        TaskResolvedIcon r118 = new TaskResolvedIcon("RELATIONSHIP_FITNESS_1", 18, "relationship_fitness_1", R.drawable.ic_task_icon_relationship_fitness_1);
        RELATIONSHIP_FITNESS_1 = r118;
        TaskResolvedIcon r119 = new TaskResolvedIcon("RELATIONSHIP_FITNESS_2", 19, "relationship_fitness_2", R.drawable.ic_task_icon_relationship_fitness_2);
        RELATIONSHIP_FITNESS_2 = r119;
        TaskResolvedIcon r120 = new TaskResolvedIcon("RELATIONSHIP_FITNESS_3", 20, "relationship_fitness_3", R.drawable.ic_task_icon_relationship_fitness_3);
        RELATIONSHIP_FITNESS_3 = r120;
        TaskResolvedIcon r121 = new TaskResolvedIcon("RELATIONSHIP_FITNESS_4", 21, "relationship_fitness_4", R.drawable.ic_task_icon_relationship_fitness_4);
        RELATIONSHIP_FITNESS_4 = r121;
        TaskResolvedIcon r122 = new TaskResolvedIcon("RELATIONSHIP_EXERCISE_1", 22, "relationship_exercise_1", R.drawable.ic_task_icon_relationship_exercise_1);
        RELATIONSHIP_EXERCISE_1 = r122;
        TaskResolvedIcon r123 = new TaskResolvedIcon("RELATIONSHIP_FIGURE", 23, "relationship_exercise_2", R.drawable.ic_task_icon_relationship_exercise_2);
        RELATIONSHIP_FIGURE = r123;
        TaskResolvedIcon r124 = new TaskResolvedIcon("RELATIONSHIP_PARTY_1", 24, "relationship_party_1", R.drawable.ic_task_icon_relationship_party_1);
        RELATIONSHIP_PARTY_1 = r124;
        TaskResolvedIcon r125 = new TaskResolvedIcon("RELATIONSHIP_PARTY_2", 25, "relationship_party_2", R.drawable.ic_task_icon_relationship_party_2);
        RELATIONSHIP_PARTY_2 = r125;
        TaskResolvedIcon r126 = new TaskResolvedIcon("RELATIONSHIP_PARTY_3", 26, "relationship_party_3", R.drawable.ic_task_icon_relationship_party_3);
        RELATIONSHIP_PARTY_3 = r126;
        TaskResolvedIcon r127 = new TaskResolvedIcon("RELATIONSHIP_PARTY_4", 27, "relationship_party_4", R.drawable.ic_task_icon_relationship_party_4);
        RELATIONSHIP_PARTY_4 = r127;
        TaskResolvedIcon r128 = new TaskResolvedIcon("RELATIONSHIP_SUPPORT", 28, "relationship_support", R.drawable.ic_task_icon_relationship_support);
        RELATIONSHIP_SUPPORT = r128;
        TaskResolvedIcon r129 = new TaskResolvedIcon("RELATIONSHIP_PROFILE", 29, "relationship_profile", R.drawable.ic_task_icon_relationship_profile);
        RELATIONSHIP_PROFILE = r129;
        TaskResolvedIcon r130 = new TaskResolvedIcon("RELATIONSHIP_PRIVATE", 30, "relationship_private", R.drawable.ic_task_icon_relationship_private);
        RELATIONSHIP_PRIVATE = r130;
        TaskResolvedIcon r131 = new TaskResolvedIcon("CALENDAR_1", 31, "calendar_1", R.drawable.ic_task_icon_calendar_1);
        CALENDAR_1 = r131;
        TaskResolvedIcon r132 = new TaskResolvedIcon("CALENDAR_2", 32, "calendar_2", R.drawable.ic_task_icon_calendar_2);
        CALENDAR_2 = r132;
        TaskResolvedIcon r133 = new TaskResolvedIcon("CALENDAR_3", 33, "calendar_3", R.drawable.ic_task_icon_calendar_3);
        CALENDAR_3 = r133;
        TaskResolvedIcon r134 = new TaskResolvedIcon("MATERIALS_1", 34, "materials_1", R.drawable.ic_task_icon_materials_1);
        MATERIALS_1 = r134;
        TaskResolvedIcon r135 = new TaskResolvedIcon("MATERIALS_2", 35, "materials_2", R.drawable.ic_task_icon_materials_2);
        MATERIALS_2 = r135;
        TaskResolvedIcon r136 = new TaskResolvedIcon("MATERIALS_3", 36, "materials_3", R.drawable.ic_task_icon_materials_3);
        MATERIALS_3 = r136;
        TaskResolvedIcon r137 = new TaskResolvedIcon("MATERIALS_4", 37, "materials_4", R.drawable.ic_task_icon_materials_4);
        MATERIALS_4 = r137;
        TaskResolvedIcon r138 = new TaskResolvedIcon("HEALTH_1", 38, "health_1", R.drawable.ic_task_icon_health_1);
        HEALTH_1 = r138;
        TaskResolvedIcon r139 = new TaskResolvedIcon("HEALTH_2", 39, "health_2", R.drawable.ic_task_icon_health_2);
        HEALTH_2 = r139;
        TaskResolvedIcon r140 = new TaskResolvedIcon("STUDY_1", 40, "study_1", R.drawable.ic_task_icon_study_1);
        STUDY_1 = r140;
        TaskResolvedIcon r141 = new TaskResolvedIcon("FINANCE_1", 41, "finance_1", R.drawable.ic_task_icon_finance_1);
        FINANCE_1 = r141;
        TaskResolvedIcon r142 = new TaskResolvedIcon("FINANCE_2", 42, "finance_2", R.drawable.ic_task_icon_finance_2);
        FINANCE_2 = r142;
        TaskResolvedIcon r143 = new TaskResolvedIcon("FOOD", 43, "food", R.drawable.ic_task_icon_life_food);
        FOOD = r143;
        TaskResolvedIcon r144 = new TaskResolvedIcon("SHOPPING", 44, "shopping", R.drawable.ic_task_icon_life_shopping);
        SHOPPING = r144;
        TaskResolvedIcon r145 = new TaskResolvedIcon("TRAVEL_FLY", 45, "travel_fly", R.drawable.ic_task_icon_life_travel_fly);
        TRAVEL_FLY = r145;
        TaskResolvedIcon r146 = new TaskResolvedIcon("BEER", 46, "beer", R.drawable.ic_task_icon_life_beer);
        BEER = r146;
        TaskResolvedIcon r147 = new TaskResolvedIcon("TRAVEL_TRAIN", 47, "travel_train", R.drawable.ic_task_icon_life_train);
        TRAVEL_TRAIN = r147;
        TaskResolvedIcon r148 = new TaskResolvedIcon("TRAVEL_CAR", 48, "travel_car", R.drawable.ic_task_icon_life_car);
        TRAVEL_CAR = r148;
        TaskResolvedIcon r149 = new TaskResolvedIcon("DRINK", 49, "drink", R.drawable.ic_task_icon_life_drink);
        DRINK = r149;
        TaskResolvedIcon r150 = new TaskResolvedIcon("VACATION", 50, "vacation", R.drawable.ic_task_icon_life_vacation);
        VACATION = r150;
        TaskResolvedIcon r151 = new TaskResolvedIcon("CAKE", 51, "cake", R.drawable.ic_task_icon_life_cake);
        CAKE = r151;
        TaskResolvedIcon r152 = new TaskResolvedIcon("CLOTHES", 52, "clothes", R.drawable.ic_task_icon_life_clothes);
        CLOTHES = r152;
        TaskResolvedIcon r153 = new TaskResolvedIcon("BAG", 53, "bag", R.drawable.ic_task_icon_life_bag);
        BAG = r153;
        TaskResolvedIcon r154 = new TaskResolvedIcon("MILESTONE", 54, "milestone", R.drawable.ic_task_icon_life_milestone);
        MILESTONE = r154;
        TaskResolvedIcon r155 = new TaskResolvedIcon("GIFT", 55, PbRequest.SwitchType.GIFT, R.drawable.ic_task_icon_life_gift);
        GIFT = r155;
        int r156 = 0;
        TaskResolvedIcon[] r157 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r106, r107, r108, r109, r113, r114, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135, r136, r137, r138, r139, r140, r141, r142, r143, r144, r145, r146, r147, r148, r149, r150, r151, r152, r153, r154, r155};
        f384427b = r157;
        f384428c = EnumEntriesKt.enumEntries(r157);
        Companion = new a();
        TaskResolvedIcon[] r158 = values();
        LinkedHashMap r159 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(r158.length), 16));
        int r160 = r158.length;
    L3:
        if (r156 >= r160) goto L5;
        TaskResolvedIcon r161 = r158[r156];
        r159.put(r161.key, r161);
        r156 = r156 + 1;
        goto L3
    L5:
        f384426a = r159;
    }

    public static TaskResolvedIcon[] values() {
        return (TaskResolvedIcon[]) f384427b.clone();
    }

    public static final /* synthetic */ Map access$getICONS_BY_KEY$cp() {
        return f384426a;
    }

    public final int getDrawableRes() {
        return this.drawableRes;
    }

    public final String getKey() {
        return this.key;
    }

    public static TaskResolvedIcon valueOf(String r100) {
        return (TaskResolvedIcon) r27.a.a(TaskResolvedIcon.class, r100);
    }

    public TaskResolvedIcon(String r100, int r101, String r102, int r103) {
        super(r100, r101);
        this.key = r102;
        this.drawableRes = r103;
    }
}
