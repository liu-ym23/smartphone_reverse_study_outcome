package kotlin.reflect.jvm.internal.impl.descriptors;

import com.bytedance.android.live.soloktv.SoloKtvContext;
import com.bytedance.sdk.bridge.annotation.BridgePrivilege;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class Visibilities {
    private static final Public DEFAULT_VISIBILITY = null;
    public static final Visibilities INSTANCE = null;
    private static final Map<Visibility, Integer> ORDERED_VISIBILITIES = null;

    public static final class Inherited extends Visibility {
        public static final Inherited INSTANCE = null;

        static {
            INSTANCE = new Inherited();
        }

        private Inherited() {
            super("inherited", false);
        }
    }

    public static final class Internal extends Visibility {
        public static final Internal INSTANCE = null;

        static {
            INSTANCE = new Internal();
        }

        private Internal() {
            super("internal", false);
        }
    }

    public static final class InvisibleFake extends Visibility {
        public static final InvisibleFake INSTANCE = null;

        static {
            INSTANCE = new InvisibleFake();
        }

        private InvisibleFake() {
            super("invisible_fake", false);
        }
    }

    public static final class Local extends Visibility {
        public static final Local INSTANCE = null;

        static {
            INSTANCE = new Local();
        }

        private Local() {
            super("local", false);
        }
    }

    public static final class Private extends Visibility {
        public static final Private INSTANCE = null;

        static {
            INSTANCE = new Private();
        }

        private Private() {
            super(BridgePrivilege.PRIVATE, false);
        }
    }

    public static final class PrivateToThis extends Visibility {
        public static final PrivateToThis INSTANCE = null;

        static {
            INSTANCE = new PrivateToThis();
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.Visibility
        public String getInternalDisplayName() {
            return "private/*private to this*/";
        }

        private PrivateToThis() {
            super("private_to_this", false);
        }
    }

    public static final class Protected extends Visibility {
        public static final Protected INSTANCE = null;

        static {
            INSTANCE = new Protected();
        }

        private Protected() {
            super("protected", true);
        }
    }

    public static final class Public extends Visibility {
        public static final Public INSTANCE = null;

        static {
            INSTANCE = new Public();
        }

        private Public() {
            super("public", true);
        }
    }

    public static final class Unknown extends Visibility {
        public static final Unknown INSTANCE = null;

        static {
            INSTANCE = new Unknown();
        }

        private Unknown() {
            super("unknown", false);
        }
    }

    private Visibilities() {
    }

    static {
        INSTANCE = new Visibilities();
        Map r100 = MapsKt.createMapBuilder();
        r100.put(PrivateToThis.INSTANCE, 0);
        r100.put(Private.INSTANCE, 0);
        r100.put(Internal.INSTANCE, 1);
        r100.put(Protected.INSTANCE, 1);
        Public r101 = Public.INSTANCE;
        r100.put(r101, 2);
        ORDERED_VISIBILITIES = MapsKt.build(r100);
        DEFAULT_VISIBILITY = r101;
    }

    public final boolean isPrivate(Visibility r100) {
        Intrinsics.checkNotNullParameter(r100, RemoteMessageConst.Notification.VISIBILITY);
        if (r100 != Private.INSTANCE) goto L5;
    L8:
        return true;
    L5:
        if (r100 == PrivateToThis.INSTANCE) goto L8;
        return false;
    }

    public final Integer compareLocal$compiler_common(Visibility r100, Visibility r101) {
        Intrinsics.checkNotNullParameter(r100, SoloKtvContext.SOLO_PAGE_FIRST);
        Intrinsics.checkNotNullParameter(r101, "second");
        if (r100 == r101) goto L5;
        Map<Visibility, Integer> r102 = ORDERED_VISIBILITIES;
        Integer r103 = r102.get(r100);
        Integer r104 = r102.get(r101);
        if (r103 == null) goto L13;
        if (r104 == null) goto L13;
        if (Intrinsics.areEqual(r103, r104) == true) goto L13;
        return Integer.valueOf(r103.intValue() - r104.intValue());
    L13:
        return null;
    L5:
        return 0;
    }
}
