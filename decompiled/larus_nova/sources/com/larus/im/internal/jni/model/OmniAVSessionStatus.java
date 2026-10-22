package com.larus.im.internal.jni.model;

import com.android.ttcjpaysdk.base.h5.cjjsb.constant.ErrorCode;
import com.byted.cast.common.bean.State;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import r27.a;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/larus/im/internal/jni/model/OmniAVSessionStatus;", "", "status", "", "<init>", "(Ljava/lang/String;II)V", "getStatus", "()I", ErrorCode.INIT, "CONNECTING", "CONNECTED", State.DISCONNECTED, "RECONNECTING", "Companion", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OmniAVSessionStatus extends Enum<OmniAVSessionStatus> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ OmniAVSessionStatus[] $VALUES = null;
    public static final OmniAVSessionStatus CONNECTED = null;
    public static final OmniAVSessionStatus CONNECTING = null;
    public static final Companion Companion = null;
    public static final OmniAVSessionStatus DISCONNECTED = null;
    public static final OmniAVSessionStatus INIT = null;
    public static final OmniAVSessionStatus RECONNECTING = null;
    private final int status;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/larus/im/internal/jni/model/OmniAVSessionStatus$Companion;", "", "<init>", "()V", "fromValue", "Lcom/larus/im/internal/jni/model/OmniAVSessionStatus;", "status", "", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final OmniAVSessionStatus fromValue(int r100) {
            OmniAVSessionStatus[] r101 = OmniAVSessionStatus.values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L11;
            OmniAVSessionStatus r104 = r101[r103];
            if (r104.getStatus() != r100) goto L7;
            boolean r105 = true;
        L8:
            if (r105 == true) goto L12;
            r103 = r103 + 1;
        L12:
            if (r104 == null) goto L14;
            return r104;
        L14:
            return OmniAVSessionStatus.INIT;
        L7:
            r105 = false;
            goto L8
        L11:
            r104 = null;
            goto L12
        }
    }

    private static final /* synthetic */ OmniAVSessionStatus[] $values() {
        return new OmniAVSessionStatus[]{INIT, CONNECTING, CONNECTED, DISCONNECTED, RECONNECTING};
    }

    public static EnumEntries<OmniAVSessionStatus> getEntries() {
        return $ENTRIES;
    }

    static {
        INIT = new OmniAVSessionStatus(ErrorCode.INIT, 0, 0);
        CONNECTING = new OmniAVSessionStatus("CONNECTING", 1, 1);
        CONNECTED = new OmniAVSessionStatus("CONNECTED", 2, 2);
        DISCONNECTED = new OmniAVSessionStatus(State.DISCONNECTED, 3, 3);
        RECONNECTING = new OmniAVSessionStatus("RECONNECTING", 4, 4);
        OmniAVSessionStatus[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
        Companion = new Companion(null);
    }

    public static OmniAVSessionStatus[] values() {
        return (OmniAVSessionStatus[]) $VALUES.clone();
    }

    public final int getStatus() {
        return this.status;
    }

    public static OmniAVSessionStatus valueOf(String r100) {
        return (OmniAVSessionStatus) a.a(OmniAVSessionStatus.class, r100);
    }

    private OmniAVSessionStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.status = r102;
    }
}
