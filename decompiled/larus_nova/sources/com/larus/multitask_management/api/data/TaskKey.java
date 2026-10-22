package com.larus.multitask_management.api.data;

import androidx.core.app.NotificationCompat;
import com.larus.audio.constant.GlobalAudioSceneEnum;
import com.larus.media.MediaScene;
import kl9.z;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlinx.serialization.Serializable;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0087\u0081\u0002\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0010B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0011"}, d2 = {"Lcom/larus/multitask_management/api/data/TaskKey;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "UNDEFINED", "MUSIC", "PODCAST", "STREAMING_PODCAST", "RECORD", "AI_SIMULT_TRANS", MediaScene.NAVIGATION, "DEBUG", "Companion", "multitask_management_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable(with = z.class)
public final enum TaskKey extends Enum<TaskKey> {
    public static final TaskKey AI_SIMULT_TRANS = null;
    public static final a Companion = null;
    public static final TaskKey DEBUG = null;
    public static final TaskKey MUSIC = null;
    public static final TaskKey NAVIGATION = null;
    public static final TaskKey PODCAST = null;
    public static final TaskKey RECORD = null;
    public static final TaskKey STREAMING_PODCAST = null;
    public static final TaskKey UNDEFINED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TaskKey[] f359375a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f359376b = null;
    private final String value;

    public static EnumEntries<TaskKey> getEntries() {
        return f359376b;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.larus.multitask_management.api.data.TaskKey$a] */
    static {
        TaskKey r100 = new TaskKey("UNDEFINED", 0, "");
        UNDEFINED = r100;
        TaskKey r101 = new TaskKey("MUSIC", 1, "music");
        MUSIC = r101;
        TaskKey r102 = new TaskKey("PODCAST", 2, GlobalAudioSceneEnum.PODCAST);
        PODCAST = r102;
        TaskKey r103 = new TaskKey("STREAMING_PODCAST", 3, "streaming_podcast");
        STREAMING_PODCAST = r103;
        TaskKey r104 = new TaskKey("RECORD", 4, "record");
        RECORD = r104;
        TaskKey r105 = new TaskKey("AI_SIMULT_TRANS", 5, "ai_simult_trans");
        AI_SIMULT_TRANS = r105;
        TaskKey r110 = new TaskKey(MediaScene.NAVIGATION, 6, NotificationCompat.CATEGORY_NAVIGATION);
        NAVIGATION = r110;
        TaskKey r111 = new TaskKey("DEBUG", 7, "test_audio");
        DEBUG = r111;
        TaskKey[] r112 = {r100, r101, r102, r103, r104, r105, r110, r111};
        f359375a = r112;
        f359376b = EnumEntriesKt.enumEntries(r112);
        Companion = new a();
    }

    public static TaskKey[] values() {
        return (TaskKey[]) f359375a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static TaskKey valueOf(String r100) {
        return (TaskKey) r27.a.a(TaskKey.class, r100);
    }

    public TaskKey(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
