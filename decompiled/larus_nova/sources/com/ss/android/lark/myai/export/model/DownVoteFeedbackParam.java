package com.ss.android.lark.myai.export.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import osb.f;

/* JADX INFO: loaded from: classes36.dex */
public final class DownVoteFeedbackParam {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final nsb.a f432892a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f432893b;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/myai/export/model/DownVoteFeedbackParam$WorkMode;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "CHAT", "INLINE", "IM_REPLY", "UNREAD_RECOMMEND", "myai-export-officesdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum WorkMode extends Enum<WorkMode> {
        public static final WorkMode CHAT = null;
        public static final WorkMode IM_REPLY = null;
        public static final WorkMode INLINE = null;
        public static final WorkMode UNREAD_RECOMMEND = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ WorkMode[] f432894a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f432895b = null;
        private final int value;

        public static EnumEntries<WorkMode> getEntries() {
            return f432895b;
        }

        static {
            WorkMode r100 = new WorkMode("CHAT", 0, 1);
            CHAT = r100;
            WorkMode r101 = new WorkMode("INLINE", 1, 2);
            INLINE = r101;
            WorkMode r102 = new WorkMode("IM_REPLY", 2, 4);
            IM_REPLY = r102;
            WorkMode r103 = new WorkMode("UNREAD_RECOMMEND", 3, 6);
            UNREAD_RECOMMEND = r103;
            WorkMode[] r104 = {r100, r101, r102, r103};
            f432894a = r104;
            f432895b = EnumEntriesKt.enumEntries(r104);
        }

        public static WorkMode[] values() {
            return (WorkMode[]) f432894a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static WorkMode valueOf(String r100) {
            return (WorkMode) r27.a.a(WorkMode.class, r100);
        }

        public WorkMode(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f432896a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public nsb.a f432897b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public f f432898c;

        public a() {
            WorkMode r100 = WorkMode.CHAT;
        }
    }

    public DownVoteFeedbackParam(a r100) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        if (r100.f432896a != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("aiMessageId");
    L6:
        this.f432892a = r100.f432897b;
        this.f432893b = r100.f432898c;
    }
}
