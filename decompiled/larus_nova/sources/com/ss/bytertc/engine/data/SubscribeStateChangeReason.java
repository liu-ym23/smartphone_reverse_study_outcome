package com.ss.bytertc.engine.data;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum SubscribeStateChangeReason extends Enum<SubscribeStateChangeReason> {
    private static final /* synthetic */ SubscribeStateChangeReason[] $VALUES = null;
    public static final SubscribeStateChangeReason NO_SUBSCRIBE_PERMISSION = null;
    public static final SubscribeStateChangeReason OVER_STREAM_SUBSCRIBE_LIMIT = null;
    public static final SubscribeStateChangeReason REMOTE_PUBLISH = null;
    public static final SubscribeStateChangeReason REMOTE_UNPUBLISH = null;
    public static final SubscribeStateChangeReason STREAM_FAILED_404 = null;
    public static final SubscribeStateChangeReason STREAM_FAILED_5XX = null;
    public static final SubscribeStateChangeReason SUBSCRIBE = null;
    public static final SubscribeStateChangeReason UNSUBSCRIBE = null;
    private int value;

    /* JADX INFO: renamed from: com.ss.bytertc.engine.data.SubscribeStateChangeReason$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$data$SubscribeStateChangeReason = null;

        static {
            int[] r100 = new int[SubscribeStateChangeReason.values().length];
            $SwitchMap$com$ss$bytertc$engine$data$SubscribeStateChangeReason = r100;
            r100[SubscribeStateChangeReason.SUBSCRIBE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L20:
            $SwitchMap$com$ss$bytertc$engine$data$SubscribeStateChangeReason[SubscribeStateChangeReason.UNSUBSCRIBE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L24:
            $SwitchMap$com$ss$bytertc$engine$data$SubscribeStateChangeReason[SubscribeStateChangeReason.REMOTE_PUBLISH.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L34:
            $SwitchMap$com$ss$bytertc$engine$data$SubscribeStateChangeReason[SubscribeStateChangeReason.REMOTE_UNPUBLISH.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L22:
            $SwitchMap$com$ss$bytertc$engine$data$SubscribeStateChangeReason[SubscribeStateChangeReason.STREAM_FAILED_5XX.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L26:
            $SwitchMap$com$ss$bytertc$engine$data$SubscribeStateChangeReason[SubscribeStateChangeReason.STREAM_FAILED_404.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L28:
            $SwitchMap$com$ss$bytertc$engine$data$SubscribeStateChangeReason[SubscribeStateChangeReason.OVER_STREAM_SUBSCRIBE_LIMIT.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L30:
            $SwitchMap$com$ss$bytertc$engine$data$SubscribeStateChangeReason[SubscribeStateChangeReason.NO_SUBSCRIBE_PERMISSION.ordinal()] = 8;     // Catch: NoSuchFieldError -> L19
            return;
        }
    }

    static {
        SubscribeStateChangeReason r100 = new SubscribeStateChangeReason("SUBSCRIBE", 0, 0);
        SUBSCRIBE = r100;
        SubscribeStateChangeReason r101 = new SubscribeStateChangeReason("UNSUBSCRIBE", 1, 1);
        UNSUBSCRIBE = r101;
        SubscribeStateChangeReason r102 = new SubscribeStateChangeReason("REMOTE_PUBLISH", 2, 2);
        REMOTE_PUBLISH = r102;
        SubscribeStateChangeReason r103 = new SubscribeStateChangeReason("REMOTE_UNPUBLISH", 3, 3);
        REMOTE_UNPUBLISH = r103;
        SubscribeStateChangeReason r104 = new SubscribeStateChangeReason("STREAM_FAILED_5XX", 4, 4);
        STREAM_FAILED_5XX = r104;
        SubscribeStateChangeReason r105 = new SubscribeStateChangeReason("STREAM_FAILED_404", 5, 5);
        STREAM_FAILED_404 = r105;
        SubscribeStateChangeReason r110 = new SubscribeStateChangeReason("OVER_STREAM_SUBSCRIBE_LIMIT", 6, 6);
        OVER_STREAM_SUBSCRIBE_LIMIT = r110;
        SubscribeStateChangeReason r111 = new SubscribeStateChangeReason("NO_SUBSCRIBE_PERMISSION", 7, 7);
        NO_SUBSCRIBE_PERMISSION = r111;
        $VALUES = new SubscribeStateChangeReason[]{r100, r101, r102, r103, r104, r105, r110, r111};
    }

    public static SubscribeStateChangeReason[] values() {
        return (SubscribeStateChangeReason[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        switch(AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$data$SubscribeStateChangeReason[ordinal()]) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            case 8: goto L5;
            default: goto L4;
        };
    L4:
        return "";
    L5:
        return "kSubscribeStateChangeReasonNoSubscribePermission";
    L6:
        return "kSubscribeStateChangeReasonOverStreamSubscribeLimit";
    L7:
        return "kSubscribeStateChangeReasonStreamFailed404";
    L8:
        return "kSubscribeStateChangeReasonStreamFailed5xx";
    L9:
        return "kSubscribeStateChangeReasonRemoteUnpublish";
    L10:
        return "kSubscribeStateChangeReasonRemotePublish";
    L11:
        return "kSubscribeStateChangeReasonUnsubscribe";
    L12:
        return "kSubscribeStateChangeReasonSubscribe";
    }

    public int value() {
        return this.value;
    }

    public static SubscribeStateChangeReason fromId(int r100) {
        SubscribeStateChangeReason[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        SubscribeStateChangeReason r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static SubscribeStateChangeReason valueOf(String r100) {
        return (SubscribeStateChangeReason) a.a(SubscribeStateChangeReason.class, r100);
    }

    private SubscribeStateChangeReason(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
