package com.bytedance.android.livesdk.link.model;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\f\bf\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002:\u0002\r\u000eR\u001a\u0010\b\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R\u001a\u0010\u000b\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0007\u001a\u0004\b\t\u0010\u0005¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/ILinkerCloseContent;", "Lvh7/e;", "Lcom/bytedance/android/livesdk/message/linker/e;", "", "getSource", "()I", "getSource$annotations", "()V", "source", "getReason", "getReason$annotations", "reason", "Companion", "CloseReason", "a", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface ILinkerCloseContent extends vh7.e<com.bytedance.android.livesdk.message.linker.e>, com.bytedance.android.livesdk.message.linker.e {
    public static final int COMPATIBLE_OCHANNEL = 2;
    public static final a Companion = null;
    public static final int SWITCH_SCENE = 1;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/ILinkerCloseContent$CloseReason;", "", "", LocationMonitorConst.TYPE, "I", "getType", "()I", "Default", "ByInviter2v2ToLink", "ByInvitee2v2ToLink", "By2v1ToLink", "ByLinkToPK", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum CloseReason extends Enum<CloseReason> {
        public static final CloseReason By2v1ToLink = null;
        public static final CloseReason ByInvitee2v2ToLink = null;
        public static final CloseReason ByInviter2v2ToLink = null;
        public static final CloseReason ByLinkToPK = null;
        public static final CloseReason Default = null;
        public static final /* synthetic */ CloseReason[] a = null;
        private final int type;

        static {
            CloseReason r1 = new CloseReason("Default", 0, 0);
            Default = r1;
            CloseReason r2 = new CloseReason("ByInviter2v2ToLink", 1, 1);
            ByInviter2v2ToLink = r2;
            CloseReason r3 = new CloseReason("ByInvitee2v2ToLink", 2, 2);
            ByInvitee2v2ToLink = r3;
            CloseReason r4 = new CloseReason("By2v1ToLink", 3, 3);
            By2v1ToLink = r4;
            CloseReason r5 = new CloseReason("ByLinkToPK", 4, 4);
            ByLinkToPK = r5;
            a = new CloseReason[]{r1, r2, r3, r4, r5};
        }

        public static CloseReason valueOf(String r1) {
            return (CloseReason) r27.a.a(CloseReason.class, r1);
        }

        public static CloseReason[] values() {
            return (CloseReason[]) a.clone();
        }

        public final int getType() {
            return this.type;
        }

        public CloseReason(String r1, int r2, int r3) {
            super(r1, r2);
            this.type = r3;
        }
    }

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class b {
    }

    static {
        Companion = a.a;
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    /* synthetic */ Object getFlexInstance();

    @FieldName(name = "reason")
    int getReason();

    @FieldName(name = "source")
    int getSource();
}
