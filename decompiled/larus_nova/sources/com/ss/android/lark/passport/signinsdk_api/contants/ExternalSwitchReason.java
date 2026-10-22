package com.ss.android.lark.passport.signinsdk_api.contants;

import com.tencent.open.SocialConstants;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u000b2\u00020\u0001:\u0004\b\t\n\u000bB\u0019\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007\u0082\u0001\u0003\f\r\u000e¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/passport/signinsdk_api/contants/ExternalSwitchReason;", "Lcom/ss/android/lark/passport/signinsdk_api/contants/SwitchReason;", "value", "", SocialConstants.PARAM_APP_DESC, "", "<init>", "(ILjava/lang/String;)V", "Sidebar", "Notify", "Placeholder", "Companion", "Lcom/ss/android/lark/passport/signinsdk_api/contants/ExternalSwitchReason$Notify;", "Lcom/ss/android/lark/passport/signinsdk_api/contants/ExternalSwitchReason$Placeholder;", "Lcom/ss/android/lark/passport/signinsdk_api/contants/ExternalSwitchReason$Sidebar;", "passport-base-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class ExternalSwitchReason extends SwitchReason {
    public static final a Companion = null;
    public static final int NOTIFY = 10;
    public static final int PASSPORT_EXTERNAL = 4;
    public static final int SIDEBAR = 11;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<Integer> f438063b = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/passport/signinsdk_api/contants/ExternalSwitchReason$Notify;", "Lcom/ss/android/lark/passport/signinsdk_api/contants/ExternalSwitchReason;", "<init>", "()V", "passport-base-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Notify extends ExternalSwitchReason {
        public static final Notify INSTANCE = null;

        static {
            INSTANCE = new Notify();
        }

        private Notify() {
            super(10, "notify", null);
        }
    }

    @Deprecated(message = "")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/passport/signinsdk_api/contants/ExternalSwitchReason$Placeholder;", "Lcom/ss/android/lark/passport/signinsdk_api/contants/ExternalSwitchReason;", "<init>", "()V", "passport-base-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Placeholder extends ExternalSwitchReason {
        public static final Placeholder INSTANCE = null;

        static {
            INSTANCE = new Placeholder();
        }

        private Placeholder() {
            super(4, "external", null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/passport/signinsdk_api/contants/ExternalSwitchReason$Sidebar;", "Lcom/ss/android/lark/passport/signinsdk_api/contants/ExternalSwitchReason;", "<init>", "()V", "passport-base-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Sidebar extends ExternalSwitchReason {
        public static final Sidebar INSTANCE = null;

        static {
            INSTANCE = new Sidebar();
        }

        private Sidebar() {
            super(11, "sidebar", null);
        }
    }

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
        f438063b = SetsKt.setOf(new Integer[]{4, 10, 11});
    }

    public static final /* synthetic */ Set access$getExternalReasons$cp() {
        return f438063b;
    }

    public ExternalSwitchReason(int r100, String r101, DefaultConstructorMarker r102) {
        super(r100, r101, null);
    }
}
