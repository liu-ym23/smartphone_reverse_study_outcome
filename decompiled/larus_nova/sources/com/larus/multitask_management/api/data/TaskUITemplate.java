package com.larus.multitask_management.api.data;

import kl9.g0;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlinx.serialization.Serializable;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0087\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/larus/multitask_management/api/data/TaskUITemplate;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "DEFAULT", "SINGLE_ICON", "OMNI_WAITING", "Companion", "multitask_management_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable(with = g0.class)
public final enum TaskUITemplate extends Enum<TaskUITemplate> {
    public static final a Companion = null;
    public static final TaskUITemplate DEFAULT = null;
    public static final TaskUITemplate OMNI_WAITING = null;
    public static final TaskUITemplate SINGLE_ICON = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TaskUITemplate[] f359385a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f359386b = null;
    private final int value;

    public static EnumEntries<TaskUITemplate> getEntries() {
        return f359386b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.multitask_management.api.data.TaskUITemplate$a] */
    static {
        TaskUITemplate r100 = new TaskUITemplate("DEFAULT", 0, 0);
        DEFAULT = r100;
        TaskUITemplate r101 = new TaskUITemplate("SINGLE_ICON", 1, 1);
        SINGLE_ICON = r101;
        TaskUITemplate r102 = new TaskUITemplate("OMNI_WAITING", 2, 2);
        OMNI_WAITING = r102;
        TaskUITemplate[] r103 = {r100, r101, r102};
        f359385a = r103;
        f359386b = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
    }

    public static TaskUITemplate[] values() {
        return (TaskUITemplate[]) f359385a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static TaskUITemplate valueOf(String r100) {
        return (TaskUITemplate) r27.a.a(TaskUITemplate.class, r100);
    }

    public TaskUITemplate(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
