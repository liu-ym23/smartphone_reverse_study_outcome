package com.larus.avlink.plugins;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/avlink/plugins/SVResult;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", UserProfileEvent.POSITION_NONE, "TRUE", "FALSE", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SVResult extends Enum<SVResult> {
    public static final SVResult FALSE = null;
    public static final SVResult NONE = null;
    public static final SVResult TRUE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SVResult[] f293784a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f293785b = null;
    private final String value;

    public static EnumEntries<SVResult> getEntries() {
        return f293785b;
    }

    static {
        SVResult r100 = new SVResult(UserProfileEvent.POSITION_NONE, 0, "none");
        NONE = r100;
        SVResult r101 = new SVResult("TRUE", 1, "true");
        TRUE = r101;
        SVResult r102 = new SVResult("FALSE", 2, "false");
        FALSE = r102;
        SVResult[] r103 = {r100, r101, r102};
        f293784a = r103;
        f293785b = EnumEntriesKt.enumEntries(r103);
    }

    public static SVResult[] values() {
        return (SVResult[]) f293784a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static SVResult valueOf(String r100) {
        return (SVResult) r27.a.a(SVResult.class, r100);
    }

    public SVResult(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
