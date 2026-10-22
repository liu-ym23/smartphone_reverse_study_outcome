package com.bytedance.applog.priority.original;

import com.bytedance.awemeopen.apps.framework.comment.api.constants.CommentPublishScene;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0001\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000eR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fj\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u0017"}, d2 = {"com/bytedance/applog/priority/original/Model$EventType", "", "Lcom/bytedance/applog/priority/original/Model$EventType;", "", "type", "I", "getType", "()I", "", "alias", "Ljava/lang/String;", "getAlias", "()Ljava/lang/String;", "Companion", "a", "V3", "V1", "LogData", "Launch", "Terminate", "Impression", "ForwardV3", "Unknown", "priority_release"}, k = 1, mv = {1, 6, 0})
public final enum Model$EventType extends Enum<Model$EventType> {
    public static final a Companion = null;
    public static final Model$EventType ForwardV3 = null;
    public static final Model$EventType Impression = null;
    public static final Model$EventType Launch = null;
    public static final Model$EventType LogData = null;
    public static final Model$EventType Terminate = null;
    public static final Model$EventType Unknown = null;
    public static final Model$EventType V1 = null;
    public static final Model$EventType V3 = null;
    public static final /* synthetic */ Model$EventType[] a = null;
    private final String alias;
    private final int type;

    public static final class a {
        public a() {
        }

        public static Model$EventType a(int r6) {
            Model$EventType[] r0 = Model$EventType.values();
            int r1 = r0.length;
            int r3 = 0;
        L3:
            if (r3 >= r1) goto L11;
            Model$EventType r4 = r0[r3];
            if (r4.getType() != r6) goto L7;
            boolean r5 = true;
        L8:
            if (r5 == true) goto L12;
            r3 = r3 + 1;
        L12:
            if (r4 == null) goto L14;
            return r4;
        L14:
            return Model$EventType.Unknown;
        L7:
            r5 = false;
            goto L8
        L11:
            r4 = null;
            goto L12
        }

        public static Model$EventType b(String r6) {
            Intrinsics.checkNotNullParameter(r6, "alias");
            Model$EventType[] r0 = Model$EventType.values();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L8;
            Model$EventType r3 = r0[r2];
            if (Intrinsics.areEqual(r3.getAlias(), r6.toLowerCase(Locale.ROOT)) == true) goto L9;
            r2 = r2 + 1;
        L9:
            if (r3 == null) goto L11;
            return r3;
        L11:
            return Model$EventType.Unknown;
        L8:
            r3 = null;
            goto L9
        }
    }

    public static Model$EventType valueOf(String r1) {
        return (Model$EventType) r27.a.a(Model$EventType.class, r1);
    }

    public static Model$EventType[] values() {
        return (Model$EventType[]) a.clone();
    }

    static {
        Model$EventType r0 = new Model$EventType("V3", 0, 0, "event_v3");
        V3 = r0;
        Model$EventType r1 = new Model$EventType("V1", 1, 1, "event_v1");
        V1 = r1;
        Model$EventType r3 = new Model$EventType("LogData", 2, 2, "log_data");
        LogData = r3;
        Model$EventType r5 = new Model$EventType("Launch", 3, 3, "launch");
        Launch = r5;
        Model$EventType r7 = new Model$EventType("Terminate", 4, 4, "terminate");
        Terminate = r7;
        Model$EventType r9 = new Model$EventType("Impression", 5, 5, "item_impression");
        Impression = r9;
        Model$EventType r11 = new Model$EventType("ForwardV3", 6, 6, "forward_v3");
        ForwardV3 = r11;
        Model$EventType r13 = new Model$EventType("Unknown", 7, 99, CommentPublishScene.UNKNOWN);
        Unknown = r13;
        a = new Model$EventType[]{r0, r1, r3, r5, r7, r9, r11, r13};
        Companion = new a();
    }

    public final String getAlias() {
        return this.alias;
    }

    public final int getType() {
        return this.type;
    }

    public Model$EventType(String r1, int r2, int r3, String r4) {
        super(r1, r2);
        this.type = r3;
        this.alias = r4;
    }
}
