package com.ss.android.lark.image.impl.preload;

import com.bytedance.ee.bear.middleground.comment.aibot.model.AiBotPollingAuthResult;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/image/impl/preload/ResultState;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "NEEDLESS", "PENDING", "PRELOADING", "PRELOADED", "FAILED", "CONSUMED", "lark-image_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ResultState extends Enum<ResultState> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ResultState[] $VALUES = null;
    public static final ResultState CONSUMED = null;
    public static final ResultState FAILED = null;
    public static final ResultState NEEDLESS = null;
    public static final ResultState PENDING = null;
    public static final ResultState PRELOADED = null;
    public static final ResultState PRELOADING = null;
    private final String value;

    private static final /* synthetic */ ResultState[] $values() {
        return new ResultState[]{NEEDLESS, PENDING, PRELOADING, PRELOADED, FAILED, CONSUMED};
    }

    public static EnumEntries<ResultState> getEntries() {
        return $ENTRIES;
    }

    static {
        NEEDLESS = new ResultState("NEEDLESS", 0, "needless");
        PENDING = new ResultState("PENDING", 1, AiBotPollingAuthResult.STATUS_PENDING);
        PRELOADING = new ResultState("PRELOADING", 2, "preloading");
        PRELOADED = new ResultState("PRELOADED", 3, "preloaded");
        FAILED = new ResultState("FAILED", 4, "failed");
        CONSUMED = new ResultState("CONSUMED", 5, "consumed");
        ResultState[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static ResultState[] values() {
        return (ResultState[]) $VALUES.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static ResultState valueOf(String r100) {
        return (ResultState) a.a(ResultState.class, r100);
    }

    private ResultState(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
