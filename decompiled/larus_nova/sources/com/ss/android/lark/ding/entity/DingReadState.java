package com.ss.android.lark.ding.entity;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\t\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/ding/entity/DingReadState;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", UserProfileEvent.POSITION_NONE, "READ", "UN_READ", "getValue", "Companion", "ding-entity_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DingReadState extends Enum<DingReadState> {
    public static final a Companion = null;
    public static final DingReadState NONE = null;
    public static final DingReadState READ = null;
    public static final DingReadState UN_READ = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DingReadState[] f420401a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f420402b = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<DingReadState> getEntries() {
        return f420402b;
    }

    static {
        DingReadState r100 = new DingReadState(UserProfileEvent.POSITION_NONE, 0, 0);
        NONE = r100;
        DingReadState r101 = new DingReadState("READ", 1, 1);
        READ = r101;
        DingReadState r102 = new DingReadState("UN_READ", 2, 2);
        UN_READ = r102;
        DingReadState[] r103 = {r100, r101, r102};
        f420401a = r103;
        f420402b = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
    }

    public static DingReadState[] values() {
        return (DingReadState[]) f420401a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static DingReadState valueOf(String r100) {
        return (DingReadState) r27.a.a(DingReadState.class, r100);
    }

    public DingReadState(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
