package com.obric.assistant.chat.impl;

import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import com.larus.platform.service.o;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public final class MessageApiTrace {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f386911a = 0;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/obric/assistant/chat/impl/MessageApiTrace$GetExtResultState;", "", "state", "", "<init>", "(Ljava/lang/String;II)V", "getState", "()I", "Default", "Timeout", "Error", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum GetExtResultState extends Enum<GetExtResultState> {
        public static final GetExtResultState Default = null;
        public static final GetExtResultState Error = null;
        public static final GetExtResultState Timeout = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ GetExtResultState[] f386912a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f386913b = null;
        private final int state;

        public static EnumEntries<GetExtResultState> getEntries() {
            return f386913b;
        }

        static {
            GetExtResultState r100 = new GetExtResultState("Default", 0, 0);
            Default = r100;
            GetExtResultState r101 = new GetExtResultState("Timeout", 1, 1);
            Timeout = r101;
            GetExtResultState r102 = new GetExtResultState("Error", 2, 2);
            Error = r102;
            GetExtResultState[] r103 = {r100, r101, r102};
            f386912a = r103;
            f386913b = EnumEntriesKt.enumEntries(r103);
        }

        public static GetExtResultState[] values() {
            return (GetExtResultState[]) f386912a.clone();
        }

        public final int getState() {
            return this.state;
        }

        public static GetExtResultState valueOf(String r100) {
            return (GetExtResultState) r27.a.a(GetExtResultState.class, r100);
        }

        public GetExtResultState(String r100, int r101, int r102) {
            super(r100, r101);
            this.state = r102;
        }
    }

    static {
    }

    public static void a(String r100, long r101, GetExtResultState r102) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r102, "resultState");
        JSONObject r103 = new JSONObject();
        r103.put("scene", r100);
        r103.put(WiseOpenHianalyticsData.UNION_COSTTIME, r101);
        r103.put("result", r102.getState());
        o.f365780a.reportEvent("o_get_message_ext", r103);
    }
}
