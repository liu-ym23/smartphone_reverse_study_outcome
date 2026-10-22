package com.bytedance.applet.jsb;

import com.ivy.ivykit.api.bridge.core.model.IvyBridgePlatformType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class AppletSendOutputMethod extends bx7.c {

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/applet/jsb/AppletSendOutputMethod$SupportedOutputType;", "", "typeName", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getTypeName", "()Ljava/lang/String;", "Tips", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum SupportedOutputType extends Enum<SupportedOutputType> {
        public static final SupportedOutputType Tips = null;
        public static final /* synthetic */ SupportedOutputType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final String typeName;

        public static EnumEntries<SupportedOutputType> getEntries() {
            return b;
        }

        static {
            SupportedOutputType r0 = new SupportedOutputType();
            Tips = r0;
            SupportedOutputType[] r1 = {r0};
            a = r1;
            b = EnumEntriesKt.enumEntries(r1);
        }

        public SupportedOutputType() {
            super("Tips", 0);
            this.typeName = "tips";
        }

        public static SupportedOutputType[] values() {
            return (SupportedOutputType[]) a.clone();
        }

        public final String getTypeName() {
            return this.typeName;
        }

        public static SupportedOutputType valueOf(String r1) {
            return (SupportedOutputType) r27.a.a(SupportedOutputType.class, r1);
        }
    }

    public final String getName() {
        return "applet.sendOutput";
    }

    public AppletSendOutputMethod() {
    }

    public final void a(dx7.b r2, ux7.d.d r3, IvyBridgePlatformType r4) {
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r3, "callback");
        Intrinsics.checkNotNullParameter(r4, "type");
        com.bytedance.applet.impl.b.a(this, r2);
    }
}
