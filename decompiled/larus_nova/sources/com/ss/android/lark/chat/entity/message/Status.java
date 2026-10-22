package com.ss.android.lark.chat.entity.message;

import com.alibaba.gaiax.model.GXAnimation;
import com.bytedance.lark.pb.basic.v1.AIReply;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/Status;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN_STATUS", GXAnimation.STATE_START, "TRANSMIT", "OVER", "FAILED", "NO_RECOMENDATION", "NO_ANSWER", "Companion", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum Status extends Enum<Status> {
    public static final a Companion = null;
    public static final Status FAILED = null;
    public static final Status NO_ANSWER = null;
    public static final Status NO_RECOMENDATION = null;
    public static final Status OVER = null;
    public static final Status START = null;
    public static final Status TRANSMIT = null;
    public static final Status UNKNOWN_STATUS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Status[] f415312a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f415313b = null;
    private final int value;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static Status a(AIReply.Status r100) {
            Intrinsics.checkNotNullParameter(r100, "status");
            int r101 = r100.getValue();
            Status r102 = Status.UNKNOWN_STATUS;
            if (r101 == r102.getValue()) goto L25;
            Status r103 = Status.START;
            if (r101 == r103.getValue()) goto L26;
            Status r104 = Status.TRANSMIT;
            if (r101 == r104.getValue()) goto L27;
            Status r105 = Status.OVER;
            if (r101 == r105.getValue()) goto L28;
            Status r106 = Status.FAILED;
            if (r101 == r106.getValue()) goto L29;
            Status r107 = Status.NO_RECOMENDATION;
            if (r101 == r107.getValue()) goto L30;
            Status r108 = Status.NO_ANSWER;
            if (r101 == r108.getValue()) goto L23;
            return r107;
        L23:
            return r108;
        L30:
            return r107;
        L29:
            return r106;
        L28:
            return r105;
        L27:
            return r104;
        L26:
            return r103;
        L25:
            return r102;
        }
    }

    public static EnumEntries<Status> getEntries() {
        return f415313b;
    }

    @JvmStatic
    public static final Status parse(AIReply.Status r100) {
        Companion.getClass();
        return a.a(r100);
    }

    static {
        Status r100 = new Status("UNKNOWN_STATUS", 0, 0);
        UNKNOWN_STATUS = r100;
        Status r101 = new Status(GXAnimation.STATE_START, 1, 1);
        START = r101;
        Status r102 = new Status("TRANSMIT", 2, 2);
        TRANSMIT = r102;
        Status r103 = new Status("OVER", 3, 3);
        OVER = r103;
        Status r104 = new Status("FAILED", 4, 4);
        FAILED = r104;
        Status r105 = new Status("NO_RECOMENDATION", 5, 5);
        NO_RECOMENDATION = r105;
        Status r110 = new Status("NO_ANSWER", 6, 6);
        NO_ANSWER = r110;
        Status[] r111 = {r100, r101, r102, r103, r104, r105, r110};
        f415312a = r111;
        f415313b = EnumEntriesKt.enumEntries(r111);
        Companion = new a();
    }

    public static Status[] values() {
        return (Status[]) f415312a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static Status valueOf(String r100) {
        return (Status) r27.a.a(Status.class, r100);
    }

    public Status(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
