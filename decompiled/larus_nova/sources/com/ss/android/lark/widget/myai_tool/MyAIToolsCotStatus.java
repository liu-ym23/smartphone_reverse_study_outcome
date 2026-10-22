package com.ss.android.lark.widget.myai_tool;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\r\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0002\u001a\u00020\u0003J\u0006\u0010\u000e\u001a\u00020\u0003R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/widget/myai_tool/MyAIToolsCotStatus;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "setValue", "(I)V", "RUNNING", "SUCCESS", "FAILED", "valueOf", "getNumber", "Companion", "linked-emoji_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MyAIToolsCotStatus extends Enum<MyAIToolsCotStatus> {
    public static final a Companion = null;
    public static final MyAIToolsCotStatus FAILED = null;
    public static final MyAIToolsCotStatus RUNNING = null;
    public static final MyAIToolsCotStatus SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MyAIToolsCotStatus[] f446489a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f446490b = null;
    private int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<MyAIToolsCotStatus> getEntries() {
        return f446490b;
    }

    static {
        MyAIToolsCotStatus r100 = new MyAIToolsCotStatus("RUNNING", 0, 0);
        RUNNING = r100;
        MyAIToolsCotStatus r101 = new MyAIToolsCotStatus("SUCCESS", 1, 1);
        SUCCESS = r101;
        MyAIToolsCotStatus r102 = new MyAIToolsCotStatus("FAILED", 2, 2);
        FAILED = r102;
        MyAIToolsCotStatus[] r103 = {r100, r101, r102};
        f446489a = r103;
        f446490b = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
    }

    public static MyAIToolsCotStatus[] values() {
        return (MyAIToolsCotStatus[]) f446489a.clone();
    }

    public final int getNumber() {
        return this.value;
    }

    public final int getValue() {
        return this.value;
    }

    public final void setValue(int r100) {
        this.value = r100;
    }

    public final MyAIToolsCotStatus valueOf(int r100) {
        Companion.getClass();
        if (r100 == 0) goto L12;
        if (r100 == 1) goto L15;
        if (r100 == 2) goto L14;
        return null;
    L14:
        return FAILED;
    L15:
        return SUCCESS;
    L12:
        return RUNNING;
    }

    public static MyAIToolsCotStatus valueOf(String r100) {
        return (MyAIToolsCotStatus) r27.a.a(MyAIToolsCotStatus.class, r100);
    }

    public MyAIToolsCotStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
