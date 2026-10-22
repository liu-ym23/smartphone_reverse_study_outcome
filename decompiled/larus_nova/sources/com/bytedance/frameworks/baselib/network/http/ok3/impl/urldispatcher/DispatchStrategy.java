package com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher;

import android.net.Uri;
import com.bytedance.common.utility.Logger;
import org.json.JSONObject;
import r27.a;

/* JADX INFO: loaded from: classes3.dex */
public abstract class DispatchStrategy {
    private static final String TAG = null;
    private DispatchStrategyType mDispatchStrategyType;

    /* JADX INFO: renamed from: com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.DispatchStrategy$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$frameworks$baselib$network$http$ok3$impl$urldispatcher$DispatchStrategy$DispatchStrategyType = null;

        static {
            int[] r100 = new int[DispatchStrategyType.values().length];
            $SwitchMap$com$bytedance$frameworks$baselib$network$http$ok3$impl$urldispatcher$DispatchStrategy$DispatchStrategyType = r100;
            r100[DispatchStrategyType.STATIC_DISPATCH_STRATEGY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$com$bytedance$frameworks$baselib$network$http$ok3$impl$urldispatcher$DispatchStrategy$DispatchStrategyType[DispatchStrategyType.REQUEST_HEADER_DISPATCH_STRATEGY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public static final enum DispatchStrategyType extends Enum<DispatchStrategyType> {
        private static final /* synthetic */ DispatchStrategyType[] $VALUES = null;
        public static final DispatchStrategyType CONSERVATIVE_DISPATCH_STRATEGY = null;
        public static final DispatchStrategyType DISPATCH_STRATEGY_SUPPORTED_LAST = null;
        public static final DispatchStrategyType OPTIMIZED_DISPATCH_STRATEGY = null;
        public static final DispatchStrategyType REQUEST_HEADER_DISPATCH_STRATEGY = null;
        public static final DispatchStrategyType ROUTE_SELECTION_DISPATCH_STRATEGY = null;
        public static final DispatchStrategyType STATIC_DISPATCH_STRATEGY = null;
        public static final DispatchStrategyType UNKNOWN_DISPATCH_STRATEGY = null;
        public static final DispatchStrategyType WRR_DISPATCH_STRATEGY = null;

        static {
            DispatchStrategyType r100 = new DispatchStrategyType("UNKNOWN_DISPATCH_STRATEGY", 0);
            UNKNOWN_DISPATCH_STRATEGY = r100;
            DispatchStrategyType r101 = new DispatchStrategyType("STATIC_DISPATCH_STRATEGY", 1);
            STATIC_DISPATCH_STRATEGY = r101;
            DispatchStrategyType r102 = new DispatchStrategyType("WRR_DISPATCH_STRATEGY", 2);
            WRR_DISPATCH_STRATEGY = r102;
            DispatchStrategyType r103 = new DispatchStrategyType("CONSERVATIVE_DISPATCH_STRATEGY", 3);
            CONSERVATIVE_DISPATCH_STRATEGY = r103;
            DispatchStrategyType r104 = new DispatchStrategyType("OPTIMIZED_DISPATCH_STRATEGY", 4);
            OPTIMIZED_DISPATCH_STRATEGY = r104;
            DispatchStrategyType r105 = new DispatchStrategyType("ROUTE_SELECTION_DISPATCH_STRATEGY", 5);
            ROUTE_SELECTION_DISPATCH_STRATEGY = r105;
            DispatchStrategyType r110 = new DispatchStrategyType("REQUEST_HEADER_DISPATCH_STRATEGY", 6);
            REQUEST_HEADER_DISPATCH_STRATEGY = r110;
            DispatchStrategyType r111 = new DispatchStrategyType("DISPATCH_STRATEGY_SUPPORTED_LAST", 7);
            DISPATCH_STRATEGY_SUPPORTED_LAST = r111;
            $VALUES = new DispatchStrategyType[]{r100, r101, r102, r103, r104, r105, r110, r111};
        }

        public static DispatchStrategyType[] values() {
            return (DispatchStrategyType[]) $VALUES.clone();
        }

        public static DispatchStrategyType valueOf(String r100) {
            return (DispatchStrategyType) a.a(DispatchStrategyType.class, r100);
        }

        private DispatchStrategyType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public abstract void dispatchRequestHeaders(URLRequest r100);

    public abstract String getTargetUrl(Uri r100);

    public abstract boolean needRequestResultFeedback();

    public abstract void notifyRequestResult(String r100, boolean r101, int r102);

    static {
        TAG = "DispatchStrategy";
    }

    public DispatchStrategyType getDispatchStrategyType() {
        return this.mDispatchStrategyType;
    }

    public DispatchStrategy(DispatchStrategyType r100) {
        this.mDispatchStrategyType = r100;
    }

    public static DispatchStrategy factory(DispatchStrategyType r100, JSONObject r101, String r102, long r103, int r104) {
        int r105 = AnonymousClass1.$SwitchMap$com$bytedance$frameworks$baselib$network$http$ok3$impl$urldispatcher$DispatchStrategy$DispatchStrategyType[r100.ordinal()];
        if (r105 == 1) goto L14;
        if (r105 == 2) goto L12;
        if (Logger.debug() == false) goto L10;
        Logger.d(TAG, "dispatch strategy " + r100 + " is not supported, fallback to default strategy");
    L10:
        return new DefaultDispatchStrategy();
    L12:
        return new RequestHeaderDispatchStrategy(r101);
    L14:
        return new StaticDispatchStrategy(r101);
    }
}
