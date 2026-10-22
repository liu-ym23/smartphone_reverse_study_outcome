package com.bytedance.applog.priority.original;

import com.android.ttcjpaysdk.outer.pay.view.OuterPayLoginWrapper;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.common.applog.EventVerify;
import com.ss.android.message.log.PushLog;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0001\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000eR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fj\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u0017"}, d2 = {"com/bytedance/applog/priority/original/Model$EventType", "", "Lcom/bytedance/applog/priority/original/Model$EventType;", "", "type", "I", "getType", "()I", "", "alias", "Ljava/lang/String;", "getAlias", "()Ljava/lang/String;", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "V3", OuterPayLoginWrapper.LOGIN_STYLE_V1, "LogData", "Launch", "Terminate", "Impression", "ForwardV3", "Unknown", "priority_release"}, k = 1, mv = {1, 6, 0})
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

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Model$EventType[] f192688a = null;
    private final String alias;
    private final int type;

    public static final class a {
        public a() {
        }

        public static Model$EventType a(int r100) {
            Model$EventType[] r101 = Model$EventType.values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L11;
            Model$EventType r104 = r101[r103];
            if (r104.getType() != r100) goto L7;
            boolean r105 = true;
        L8:
            if (r105 == true) goto L12;
            r103 = r103 + 1;
        L12:
            if (r104 == null) goto L14;
            return r104;
        L14:
            return Model$EventType.Unknown;
        L7:
            r105 = false;
            goto L8
        L11:
            r104 = null;
            goto L12
        }

        public static Model$EventType b(String r100) {
            Intrinsics.checkNotNullParameter(r100, "alias");
            Model$EventType[] r101 = Model$EventType.values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L8;
            Model$EventType r104 = r101[r103];
            if (Intrinsics.areEqual(r104.getAlias(), r100.toLowerCase(Locale.ROOT)) == true) goto L9;
            r103 = r103 + 1;
        L9:
            if (r104 == null) goto L11;
            return r104;
        L11:
            return Model$EventType.Unknown;
        L8:
            r104 = null;
            goto L9
        }
    }

    public static Model$EventType valueOf(String r100) {
        return (Model$EventType) r27.a.a(Model$EventType.class, r100);
    }

    public static Model$EventType[] values() {
        return (Model$EventType[]) f192688a.clone();
    }

    static {
        Model$EventType r100 = new Model$EventType("V3", 0, 0, "event_v3");
        V3 = r100;
        Model$EventType r101 = new Model$EventType(OuterPayLoginWrapper.LOGIN_STYLE_V1, 1, 1, PushLog.CATEGORY);
        V1 = r101;
        Model$EventType r102 = new Model$EventType("LogData", 2, 2, "log_data");
        LogData = r102;
        Model$EventType r103 = new Model$EventType("Launch", 3, 3, EventVerify.TYPE_LAUNCH);
        Launch = r103;
        Model$EventType r104 = new Model$EventType("Terminate", 4, 4, EventVerify.TYPE_TERMINATE);
        Terminate = r104;
        Model$EventType r105 = new Model$EventType("Impression", 5, 5, EventVerify.TYPE_ITEM_IMPRESSION);
        Impression = r105;
        Model$EventType r110 = new Model$EventType("ForwardV3", 6, 6, "forward_v3");
        ForwardV3 = r110;
        Model$EventType r111 = new Model$EventType("Unknown", 7, 99, "unknown");
        Unknown = r111;
        f192688a = new Model$EventType[]{r100, r101, r102, r103, r104, r105, r110, r111};
        Companion = new a();
    }

    public final String getAlias() {
        return this.alias;
    }

    public final int getType() {
        return this.type;
    }

    public Model$EventType(String r100, int r101, int r102, String r103) {
        super(r100, r101);
        this.type = r102;
        this.alias = r103;
    }
}
