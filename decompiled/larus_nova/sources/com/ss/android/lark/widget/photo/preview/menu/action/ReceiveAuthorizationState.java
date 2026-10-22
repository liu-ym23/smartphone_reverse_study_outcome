package com.ss.android.lark.widget.photo.preview.menu.action;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/widget/photo/preview/menu/action/ReceiveAuthorizationState;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "MIDDLE_AUTHORIZATION_STATE", "FINAL_AUTHORIZATION_STATE_PASS", "FINAL_AUTHORIZATION_STATE_DENY", "NORMAL_STATE", "Companion", "photo-picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ReceiveAuthorizationState extends Enum<ReceiveAuthorizationState> {
    public static final a Companion = null;
    public static final ReceiveAuthorizationState FINAL_AUTHORIZATION_STATE_DENY = null;
    public static final ReceiveAuthorizationState FINAL_AUTHORIZATION_STATE_PASS = null;
    public static final ReceiveAuthorizationState MIDDLE_AUTHORIZATION_STATE = null;
    public static final ReceiveAuthorizationState NORMAL_STATE = null;
    public static final ReceiveAuthorizationState UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ReceiveAuthorizationState[] f446822a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f446823b = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<ReceiveAuthorizationState> getEntries() {
        return f446823b;
    }

    static {
        ReceiveAuthorizationState r100 = new ReceiveAuthorizationState("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        ReceiveAuthorizationState r101 = new ReceiveAuthorizationState("MIDDLE_AUTHORIZATION_STATE", 1, 1);
        MIDDLE_AUTHORIZATION_STATE = r101;
        ReceiveAuthorizationState r102 = new ReceiveAuthorizationState("FINAL_AUTHORIZATION_STATE_PASS", 2, 2);
        FINAL_AUTHORIZATION_STATE_PASS = r102;
        ReceiveAuthorizationState r103 = new ReceiveAuthorizationState("FINAL_AUTHORIZATION_STATE_DENY", 3, 3);
        FINAL_AUTHORIZATION_STATE_DENY = r103;
        ReceiveAuthorizationState r104 = new ReceiveAuthorizationState("NORMAL_STATE", 4, 4);
        NORMAL_STATE = r104;
        ReceiveAuthorizationState[] r105 = {r100, r101, r102, r103, r104};
        f446822a = r105;
        f446823b = EnumEntriesKt.enumEntries(r105);
        Companion = new a();
    }

    public static ReceiveAuthorizationState[] values() {
        return (ReceiveAuthorizationState[]) f446822a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    @JvmStatic
    public static final ReceiveAuthorizationState fromValue(int r100) {
        Companion.getClass();
        if (r100 == 0) goto L18;
        if (r100 == 1) goto L23;
        if (r100 == 2) goto L22;
        if (r100 == 3) goto L21;
        if (r100 == 4) goto L20;
        return UNKNOWN;
    L20:
        return NORMAL_STATE;
    L21:
        return FINAL_AUTHORIZATION_STATE_DENY;
    L22:
        return FINAL_AUTHORIZATION_STATE_PASS;
    L23:
        return MIDDLE_AUTHORIZATION_STATE;
    L18:
        return UNKNOWN;
    }

    public static ReceiveAuthorizationState valueOf(String r100) {
        return (ReceiveAuthorizationState) r27.a.a(ReceiveAuthorizationState.class, r100);
    }

    public ReceiveAuthorizationState(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
